package com.bytedance.ee.bear.drive.view.preview.ttreader;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c95.b;
import c95.c;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.bear.drive.view.preview.wrapper.m;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class TTReaderBaseView extends FrameLayout implements m, b, c95.a, m85.a {
    public ITTReaderViewWrapper a;
    public RequestPasswordView b;
    public c c;
    public c95.a.InterfaceC0013a d;
    public a e;
    public z f;
    public PreviewViewModel g;
    public DriveComponentRenderVM h;
    public ViewOwner i;
    public a95.a j;

    @Override // c95.b
    public final void a(PointValue r1) {
    }

    @Override // c95.b
    public final void b(int r1) {
    }

    @Override // c95.b
    public final void c(String r1) {
    }

    public abstract void e(String r1);

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public String getCommentQuote() {
        return null;
    }

    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "TTReaderBaseView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final CommentRectF hideCreateComment() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onAreaClick() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelClose(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelClose() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    @Override // c95.b
    public void setEncryptData(EncryptData r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r1) {
    }

    public final void g() {
        if (this.b != null) goto L10;
        RequestPasswordView r0 = ((ii5.b) org.koin.java.a.a(ii5.b.class)).b(getContext());     // Catch: Throwable -> L6
    L8:
        this.b = r0;
        r0.setVisibility(0);
        this.b.setOnInputPasswordListener(new aa5.a(this));
        this.b.setTag("REQUEST_PASSWORD_VIEW_TAG");
        ViewOwner r1 = this.i;
        RequestPasswordView r3 = this.b;
        new DriveBlockViewSwitchManager(r1).a(new aa5.b(r3));
    L6:
        th = move-exception;
        tt5.a.e("TTReaderBaseView", "create request password view failed", th, false);
        ii5.a r2 = ii5.a.a;
        r0 = new RequestPasswordView(getContext());
    L10:
        if (findViewWithTag("REQUEST_PASSWORD_VIEW_TAG") != null) goto L12;
        ViewGroup.LayoutParams r4 = new ViewGroup.LayoutParams(-1, -1);
        addView(this.b, r4);
        return;
    L12:
        RequestPasswordView r5 = this.b;
        Toast.showFailureText(r5.getContext(), r5.getResources().getString(2131888104), 0);
        r5.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        PreviewViewModel r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        if (this.h.needBindReleaseListener() == true) goto L11;
        onRelease();
        return;
    L11:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    @Override // m85.a
    public final void onRelease() {
        PreviewViewModel r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        ITTReaderViewWrapper r1 = this.a;
        if (r1 == null) goto L11;
        r1.closeBook();
        return;
    L11:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        c r0 = this.c;
        if (r0 == null) goto L5;
        r0.onShowStart();
    L5:
        j65.a.b(this.g, "TTReaderBaseView");
        e(null);
    }

    public TTReaderBaseView(Context r2) {
        super(r2);
        new PointValue(false, 0);
        this.e = new a();
    }

    public final void d(String r2) {
        if (findViewWithTag("REQUEST_PASSWORD_VIEW_TAG") == null) goto L7;
        RequestPasswordView r0 = this.b;
        if (r0 == null) goto L7;
        r0.clearFocus();
        removeView(this.b);
    L7:
        c r1 = this.c;
        if (r1 == null) goto L10;
        r1.b(r2);
    L10:
        j65.a.c(this.g, "TTReaderBaseView");
    }

    public final void i(String r4) {
        tt5.a.h("TTReaderBaseView", "trackOpenDowngradeSuccess, openType: ".concat(r4));
        if (this.g == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("open_type", r4);
        r0.put("source_type", String.valueOf(3));
        this.g.liveInnerReportMsg().a(new a0(22, r0));
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        this.e.a(r2);
        return super.onInterceptTouchEvent(r2);
    }

    @Override // c95.a
    public void setClickLinkCallback(c95.a.InterfaceC0013a r1) {
        this.d = r1;
    }

    public void setFullScreenManager(a.c r2) {
        this.e.d = r2;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r1) {
        this.j = r1;
    }

    public TTReaderBaseView(Context r1, AttributeSet r2) {
        super(r1, r2);
        new PointValue(false, 0);
        this.e = new a();
    }

    public final void f(String r3, JSONObject r4) {
        tt5.a.b("TTReaderBaseView", "reportEvent: " + r3 + "  jsonObject: " + r4);
        ((d) org.koin.java.a.a(d.class)).a(r3, r4);
    }

    public final void h(String r3, Throwable r4) {
        tt5.a.l("TTReaderBaseView", "trackOpenDowngradeFail, openType: ".concat(r3), r4);
        if (this.g == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("open_type", r3);
        r0.put("source_type", String.valueOf(3));
        r0.put("error_message", t85.b.a(r4));
        this.g.liveInnerReportMsg().a(new a0(21, r0));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onSetup(ViewOwner r2, ViewOwner r3) {
        this.i = r3;
        this.g = (PreviewViewModel) r3.viewModel(PreviewViewModel.class);
        DriveComponentRenderVM r4 = (DriveComponentRenderVM) r2.viewModel(DriveComponentRenderVM.class);
        this.h = r4;
        r4.bindReleaseListener(this);
    }

    public TTReaderBaseView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        new PointValue(false, 0);
        this.e = new a();
    }
}

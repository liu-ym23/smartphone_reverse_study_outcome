package com.bytedance.ee.bear.drive.view.preview.document;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c95.c;
import c95.d;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.capture.DriveCaptureVM;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.m;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.drive.view.widget.DriveWebView;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseWebPreviewView extends FrameLayout implements m, d, c95.b, m85.a {
    public static final /* synthetic */ int g = 0;
    public DriveWebView a;
    public Disposable b;
    public c c;
    public PreviewViewModel d;
    public DriveComponentRenderVM e;
    public a95.a f;

    public interface a {
        String a(String r1, boolean r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public String getCommentQuote() {
        return null;
    }

    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "BaseWebPreviewView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public CommentRectF hideCreateComment() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onAreaClick() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentInputPanelClose(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentInputPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentListPanelClose() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showSelectedComment(String r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showThumbnailPreview() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void updateComment(ArrayList<CommentRectF> r1) {
    }

    public final void d() {
        tt5.a.h("BaseWebPreviewView", "init");
        LayoutInflater.from(getContext()).inflate(2131560224, this);
        this.a = (DriveWebView) findViewById(2131370258);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        PreviewViewModel r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        tt5.a.h("BaseWebPreviewView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        if (this.e.needBindReleaseListener() == true) goto L11;
        onRelease();
        return;
    L11:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    @Override // m85.a
    public void onRelease() {
        PreviewViewModel r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        Disposable r1 = this.b;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        DriveWebView r2 = this.a;
        if (r2 == null) goto L17;
        r2.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        this.a.clearHistory();
        ViewGroup r3 = (ViewGroup) this.a.getParent();
        if (r3 == null) goto L15;
        r3.removeView(this.a);
    L15:
        this.a.destroy();
        this.a = null;
        return;
    L17:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    public DriveWebView getWebView() {
        return this.a;
    }

    public BaseWebPreviewView(Context r1) {
        super(r1);
        d();
    }

    @Override // c95.b
    public final void a(PointValue r2) {
        if (getWebView() == null) goto L6;
        getWebView().setCopyPermission(r2);
        return;
    }

    @Override // c95.b
    public final void b(int r2) {
        if (getWebView() == null) goto L6;
        getWebView().setCopyErrorCode(r2);
        return;
    }

    @Override // c95.b
    public final void c(String r2) {
        if (getWebView() == null) goto L6;
        getWebView().setTenantId(r2);
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 != 0) goto L8;
        DriveWebView r2 = this.a;
        if (r2 == null) goto L9;
        r2.resumeTimers();
        return;
    L9:
        return;
    }

    @Override // c95.b
    public void setEncryptData(EncryptData r2) {
        if (getWebView() == null) goto L6;
        getWebView().setEncryptData(r2);
        return;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r1) {
        this.f = r1;
    }

    public BaseWebPreviewView(Context r1, AttributeSet r2) {
        super(r1, r2);
        d();
    }

    public final Flowable e(DriveFilePath r2, a r3) {
        if (isAttachedToWindow() == false) goto L7;
        return Flowable.create(new com.bytedance.ee.bear.drive.view.preview.document.a(this, r2, r3), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b()).observeOn(fo5.d.d());
    L7:
        return Flowable.error(new Throwable("setDataToWebViewInChunks, not attached to window. "));
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onSetup(ViewOwner r3, ViewOwner r4) {
        this.a.g(r3, r4);
        this.d = (PreviewViewModel) r4.viewModel(PreviewViewModel.class);
        DriveComponentRenderVM r5 = (DriveComponentRenderVM) r3.viewModel(DriveComponentRenderVM.class);
        this.e = r5;
        r5.bindReleaseListener(this);
        ((DriveBlockPreviewVM) r4.viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().observe(r4.lifecycleOwner(), new i95.a(this));
        DriveCaptureVM r6 = (DriveCaptureVM) r4.viewModel(DriveCaptureVM.class);
        r6.getInCapture().observe(r4.lifecycleOwner(), new i95.b(this));
        if (r6.getInCapture().getValue() != null) goto L5;
    L6:
        this.a.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131100545)));
        return;
    L5:
        if (((Boolean) r6.getInCapture().getValue()).booleanValue() == false) goto L6;
    }

    public BaseWebPreviewView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        d();
    }
}

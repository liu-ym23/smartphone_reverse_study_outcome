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
import com.byted.cast.linkcommon.cybergarage.xml.XML;
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
import com.larus.nova.R;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseWebPreviewView extends FrameLayout implements m, d, c95.b, m85.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f224799g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DriveWebView f224800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f224801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f224802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PreviewViewModel f224803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DriveComponentRenderVM f224804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a95.a f224805f;

    public interface a {
        String a(String r100, boolean r101);
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
    public void onCommentInputPanelClose(boolean r100) {
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
    public final /* synthetic */ void onNewConfiguration(Configuration r100) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showSelectedComment(String r100) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showThumbnailPreview() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void updateComment(ArrayList<CommentRectF> r100) {
    }

    public final void d() {
        tt5.a.h("BaseWebPreviewView", "init");
        LayoutInflater.from(getContext()).inflate(R.layout.drive_preview_webview_wrapper, this);
        this.f224800a = (DriveWebView) findViewById(R.id.drive_document_webview);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        PreviewViewModel r100 = this.f224803d;
        if (r100 != null) goto L5;
    L7:
        tt5.a.h("BaseWebPreviewView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        if (this.f224804e.needBindReleaseListener() == true) goto L11;
        onRelease();
        return;
    L11:
        return;
    L5:
        if (r100.isBlockViewChanging() == false) goto L7;
    }

    @Override // m85.a
    public void onRelease() {
        PreviewViewModel r100 = this.f224803d;
        if (r100 != null) goto L5;
    L7:
        Disposable r101 = this.f224801b;
        if (r101 == null) goto L10;
        r101.dispose();
    L10:
        DriveWebView r102 = this.f224800a;
        if (r102 == null) goto L17;
        r102.loadDataWithBaseURL(null, "", "text/html", XML.CHARSET_UTF8, null);
        this.f224800a.clearHistory();
        ViewGroup r103 = (ViewGroup) this.f224800a.getParent();
        if (r103 == null) goto L15;
        r103.removeView(this.f224800a);
    L15:
        this.f224800a.destroy();
        this.f224800a = null;
        return;
    L17:
        return;
    L5:
        if (r100.isBlockViewChanging() == false) goto L7;
    }

    public DriveWebView getWebView() {
        return this.f224800a;
    }

    public BaseWebPreviewView(Context r100) {
        super(r100);
        d();
    }

    @Override // c95.b
    public final void a(PointValue r100) {
        if (getWebView() == null) goto L6;
        getWebView().setCopyPermission(r100);
        return;
    }

    @Override // c95.b
    public final void b(int r100) {
        if (getWebView() == null) goto L6;
        getWebView().setCopyErrorCode(r100);
        return;
    }

    @Override // c95.b
    public final void c(String r100) {
        if (getWebView() == null) goto L6;
        getWebView().setTenantId(r100);
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (r100 != 0) goto L8;
        DriveWebView r101 = this.f224800a;
        if (r101 == null) goto L9;
        r101.resumeTimers();
        return;
    L9:
        return;
    }

    @Override // c95.b
    public void setEncryptData(EncryptData r100) {
        if (getWebView() == null) goto L6;
        getWebView().setEncryptData(r100);
        return;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c r100) {
        this.f224802c = r100;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r100) {
        this.f224805f = r100;
    }

    public BaseWebPreviewView(Context r100, AttributeSet r101) {
        super(r100, r101);
        d();
    }

    public final Flowable e(DriveFilePath r100, a r101) {
        if (isAttachedToWindow() == false) goto L7;
        return Flowable.create(new com.bytedance.ee.bear.drive.view.preview.document.a(this, r100, r101), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b()).observeOn(fo5.d.d());
    L7:
        return Flowable.error(new Throwable("setDataToWebViewInChunks, not attached to window. "));
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onSetup(ViewOwner r100, ViewOwner r101) {
        this.f224800a.g(r100, r101);
        this.f224803d = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        DriveComponentRenderVM r102 = (DriveComponentRenderVM) r100.viewModel(DriveComponentRenderVM.class);
        this.f224804e = r102;
        r102.bindReleaseListener(this);
        ((DriveBlockPreviewVM) r101.viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().observe(r101.lifecycleOwner(), new i95.a(this));
        DriveCaptureVM r103 = (DriveCaptureVM) r101.viewModel(DriveCaptureVM.class);
        r103.getInCapture().observe(r101.lifecycleOwner(), new i95.b(this));
        if (r103.getInCapture().getValue() != null) goto L5;
    L6:
        this.f224800a.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_base)));
        return;
    L5:
        if (r103.getInCapture().getValue().booleanValue() == false) goto L6;
    }

    public BaseWebPreviewView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        d();
    }
}

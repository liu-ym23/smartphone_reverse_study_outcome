package com.bytedance.ee.bear.imageviewer;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageCommentData;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerPlugin;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImageViewerDialogFragment extends BaseAntiScreenshotsDialogFragment implements IImageViewer {
    public static final /* synthetic */ int i = 0;
    public final c3 h;

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Wh() {
        this.h.Wh();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final ImageData.Image c7() {
        return this.h.c7();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void close() {
        this.h.close();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final ViewGroup getContainerView() {
        return this.h.getContainerView();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final View iF() {
        return this.h.iF();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final String mC() {
        return this.h.mC();
    }

    public ImageViewerDialogFragment() {
        this.h = new c3();
    }

    public Context getContext() {
        if (super/*androidx.fragment.app.Fragment*/.getContext() != null) goto L7;
        return eu5.b.a;
    L7:
        return super/*androidx.fragment.app.Fragment*/.getContext();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final boolean isShowing() {
        return isAdded();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        this.h.P();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.b("ImageViewerFragment", "onDestroyView");
        this.h.Q();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        setStyle(2131953794, 0);
        Dialog r0 = getDialog();
        boolean r2 = getArguments().getBoolean("extra_flag_back_press", false);
        if (r0.getWindow() == null) goto L9;
        Window r1 = r0.getWindow();
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.width = -1;
        r3.height = -1;
        if (r2 == true) goto L7;
        r3.flags |= 8;
    L7:
        r1.setAttributes(r3);
        r1.setWindowAnimations(2131952400);
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        return;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void JB(ImageCommentData r2) {
        this.h.JB(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void LN(com.bytedance.ee.bear.document.imageviewer.areacomment.c.f r2) {
        this.h.H0 = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Ob(ImageViewerPlugin.f r2) {
        this.h.O = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void RX(tw4.b r2) {
        this.h.P = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Ws(com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a.c r2) {
        this.h.G1 = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void aQ(r15.c r2) {
        this.h.M = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void c80(ImageViewerPlugin.e r2) {
        this.h.N = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void f00(boolean r2) {
        this.h.f00(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void hl(IImageViewer.ImageCommentMode r2) {
        this.h.hl(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void mG(uw4.b r2) {
        this.h.L = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void oZ(boolean r2) {
        this.h.f.a = r2;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        c3 r0 = this.h;
        r0.getClass();
        int r3 = r2.orientation;
        r0.Y();
        c3.j r4 = r0.s;
        if (r4 == null) goto L6;
        r4.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        tt5.a.b("ImageViewerFragment", "onCreate");
        this.h.O(getActivity(), this, this, getArguments());
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void qK(uw4.f r2) {
        this.h.K = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void wn(ImageData r2) {
        this.h.wn(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void xJ(uw4.c r2) {
        this.h.J = r2;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        tt5.a.b("ImageViewerFragment", "onViewCreated");
        ImageData r4 = (ImageData) getArguments().getSerializable("extra_image");
        this.h.R(r2, r4);
        if (getArguments().getBoolean("extra_flag_back_press", false) == false) goto L9;
        setCancelable(false);
        Dialog r5 = getDialog();
        if (r5 != null) goto L7;
        return;
    L7:
        r5.setCanceledOnTouchOutside(false);
        r5.setOnKeyListener(new q3(this));
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        tt5.a.b("ImageViewerFragment", "onCreateView");
        if (getActivity() == null) goto L5;
        c3 r5 = this.h;
        getActivity().getRequestedOrientation();
        r5.getClass();
    L5:
        this.h.getClass();
        return r2.inflate(2131561537, r3, false);
    }
}

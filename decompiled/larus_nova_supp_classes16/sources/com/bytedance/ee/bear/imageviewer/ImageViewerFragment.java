package com.bytedance.ee.bear.imageviewer;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageCommentData;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerPlugin;
import com.bytedance.ee.bear.facade.common.BaseFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImageViewerFragment extends BaseFragment implements IImageViewer, com.bytedance.ee.bear.l {
    public final c3 e;

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Wh() {
        this.e.Wh();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final ImageData.Image c7() {
        return this.e.c7();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void close() {
        this.e.close();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final ViewGroup getContainerView() {
        return this.e.getContainerView();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final View iF() {
        return this.e.iF();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final String mC() {
        return this.e.mC();
    }

    public ImageViewerFragment() {
        this.e = new c3();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public Context getContext() {
        if (super.getContext() != null) goto L7;
        return eu5.b.a;
    L7:
        return super.getContext();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final boolean isShowing() {
        return isAdded();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        this.e.P();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.b("ImageViewerFragment", "onDestroyView");
        this.e.Q();
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void JB(ImageCommentData r2) {
        this.e.JB(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void LN(com.bytedance.ee.bear.document.imageviewer.areacomment.c.f r2) {
        this.e.H0 = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Ob(ImageViewerPlugin.f r2) {
        this.e.O = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void RX(tw4.b r2) {
        this.e.P = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void Ws(com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a.c r2) {
        this.e.G1 = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void aQ(r15.c r2) {
        this.e.M = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void c80(ImageViewerPlugin.e r2) {
        this.e.N = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void f00(boolean r2) {
        this.e.f00(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void hl(IImageViewer.ImageCommentMode r2) {
        this.e.hl(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void mG(uw4.b r2) {
        this.e.L = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void oZ(boolean r2) {
        this.e.f.a = r2;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        c3 r0 = this.e;
        r0.getClass();
        int r3 = r2.orientation;
        r0.Y();
        c3.j r4 = r0.s;
        if (r4 == null) goto L6;
        r4.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        tt5.a.b("ImageViewerFragment", "onCreate");
        this.e.O(getActivity(), this, this, getArguments());
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void qK(uw4.f r2) {
        this.e.K = r2;
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void wn(ImageData r2) {
        this.e.wn(r2);
    }

    @Override // com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer
    public final void xJ(uw4.c r2) {
        this.e.J = r2;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        ImageData r4 = (ImageData) getArguments().getSerializable("extra_image");
        this.e.R(r2, r4);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        tt5.a.b("ImageViewerFragment", "onCreateView");
        if (getActivity() == null) goto L5;
        c3 r5 = this.e;
        int r0 = getActivity().getResources().getConfiguration().orientation;
        r5.getClass();
    L5:
        this.e.getClass();
        return r2.inflate(2131561537, r3, false);
    }
}

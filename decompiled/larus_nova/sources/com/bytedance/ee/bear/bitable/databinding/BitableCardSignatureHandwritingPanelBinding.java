package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.celleditor.editor.signature.SignatureCanvasView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardSignatureHandwritingPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SignatureCanvasView f210691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f210692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f210693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f210694e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210690a;
    }

    public BitableCardSignatureHandwritingPanelBinding(FrameLayout r100, TextView r101, SignatureCanvasView r102, ImageView r103, TextView r104, TextView r105) {
        this.f210690a = r100;
        this.f210691b = r102;
        this.f210692c = r103;
        this.f210693d = r104;
        this.f210694e = r105;
    }
}

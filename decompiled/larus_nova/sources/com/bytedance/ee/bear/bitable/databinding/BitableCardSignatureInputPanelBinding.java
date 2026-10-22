package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.celleditor.editor.signature.SignatureEditText;
import com.bytedance.ee.bear.bitable.celleditor.editor.signature.SignatureTextPreviewView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardSignatureInputPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f210696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SignatureEditText f210697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f210698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SignatureTextPreviewView f210699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f210700f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210695a;
    }

    public BitableCardSignatureInputPanelBinding(FrameLayout r100, TextView r101, ImageView r102, SignatureEditText r103, LinearLayout r104, TextView r105, SignatureTextPreviewView r106, TextView r107) {
        this.f210695a = r100;
        this.f210696b = r102;
        this.f210697c = r103;
        this.f210698d = r105;
        this.f210699e = r106;
        this.f210700f = r107;
    }
}

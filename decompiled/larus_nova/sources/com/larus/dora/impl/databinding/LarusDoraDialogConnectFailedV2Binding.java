package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDialogConnectFailedV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f332463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MarkdownTextView f332464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraTextView f332465d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332462a;
    }

    public static LarusDoraDialogConnectFailedV2Binding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_dialog_connect_failed_v2, r101, false);
        int r103 = R.id.dora_dialog_connect_failed_close_btn;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r102, R.id.dora_dialog_connect_failed_close_btn);
        if (r104 == null) goto L13;
        r103 = R.id.dora_dialog_connect_failed_msg;
        MarkdownTextView r105 = (MarkdownTextView) ViewBindings.findChildViewById(r102, R.id.dora_dialog_connect_failed_msg);
        if (r105 == null) goto L13;
        r103 = R.id.dora_dialog_connect_failed_retry_btn;
        DoraTextView r106 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_dialog_connect_failed_retry_btn);
        if (r106 == null) goto L13;
        r103 = R.id.dora_dialog_connect_failed_title;
        if (((DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_dialog_connect_failed_title)) == null) goto L13;
        return new LarusDoraDialogConnectFailedV2Binding((FrameLayout) r102, r104, r105, r106);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusDoraDialogConnectFailedV2Binding(FrameLayout r100, ImageView r101, MarkdownTextView r102, DoraTextView r103) {
        this.f332462a = r100;
        this.f332463b = r101;
        this.f332464c = r102;
        this.f332465d = r103;
    }
}

package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraHowConversationLinkFragmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraTextView f332325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f332326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraTextView f332327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332328e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332324a;
    }

    public DoraHowConversationLinkFragmentBinding(ConstraintLayout r100, DoraTextView r101, NovaTitleBarEx r102, DoraTextView r103, DoraTextView r104) {
        this.f332324a = r100;
        this.f332325b = r101;
        this.f332326c = r102;
        this.f332327d = r103;
        this.f332328e = r104;
    }
}

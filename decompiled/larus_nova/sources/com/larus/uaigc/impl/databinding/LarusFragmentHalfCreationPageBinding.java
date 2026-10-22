package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusFragmentHalfCreationPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatConstraintLayout f373122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f373123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f373124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f373125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewStub f373126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ChatConstraintLayout f373127f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373122a;
    }

    public static LarusFragmentHalfCreationPageBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_fragment_half_creation_page, r101, false);
        int r103 = R.id.chat_input;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r102, R.id.chat_input);
        if (r104 == null) goto L13;
        r103 = R.id.creation_input_container;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r102, R.id.creation_input_container);
        if (r105 == null) goto L13;
        r103 = R.id.half_creation_background;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r102, R.id.half_creation_background);
        if (r106 == null) goto L13;
        r103 = R.id.input_delegate;
        ViewStub r107 = (ViewStub) ViewBindings.findChildViewById(r102, R.id.input_delegate);
        if (r107 == null) goto L13;
        ChatConstraintLayout r108 = (ChatConstraintLayout) r102;
        return new LarusFragmentHalfCreationPageBinding(r108, r104, r105, r106, r107, r108);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusFragmentHalfCreationPageBinding(ChatConstraintLayout r100, FrameLayout r101, ConstraintLayout r102, FrameLayout r103, ViewStub r104, ChatConstraintLayout r105) {
        this.f373122a = r100;
        this.f373123b = r101;
        this.f373124c = r102;
        this.f373125d = r103;
        this.f373126e = r104;
        this.f373127f = r105;
    }
}

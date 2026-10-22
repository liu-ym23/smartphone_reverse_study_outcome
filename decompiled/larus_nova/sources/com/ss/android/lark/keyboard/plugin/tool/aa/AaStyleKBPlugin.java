package com.ss.android.lark.keyboard.plugin.tool.aa;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.d;
import com.ss.android.lark.keyboard.keyboard2.h;
import com.ss.android.lark.keyboard.keyboard2.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class AaStyleKBPlugin extends nob.a implements lob.a, TextWatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f429573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f429574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f429575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f429576f;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return R.drawable.ud_icon_text_aa_outlined;
    }

    @Override // lob.a, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void y(boolean r100) {
    }

    public static void C() {
        AaStyleKBPlugin$clearAllSubPlugin$1 r100 = AaStyleKBPlugin$clearAllSubPlugin$1.INSTANCE;
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void u() {
        this.f429573c = n().l().getContext();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void v() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r100) {
        if (r100 == true) goto L9;
        d r101 = n().H();
        boolean r102 = r101 instanceof h;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.IOverlayKeyboardMenu");
        ((h) r101).a(null);
        View r103 = this.f429574d;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r103 = null;
    L7:
        r103.setSelected(false);
        throw null;
    L9:
        d r104 = n().H();
        boolean r105 = r104 instanceof h;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.IOverlayKeyboardMenu");
        h r106 = (h) r104;
        throw null;
    }

    public final void G(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FunctionEditText) == false) goto L5;
        String r101 = ((com.ss.android.lark.keyboard.edittext2.compat.a) ((FunctionEditText) r100).q(com.ss.android.lark.keyboard.edittext2.compat.a.f428962c)).f428964b;
    L7:
        if (Intrinsics.areEqual(r101, "") == false) goto L10;
        return;
    L10:
        if (r100.hashCode() != this.f429575e) goto L14;
        this.f429575e = r100.hashCode();
        return;
    L14:
        throw null;
    L5:
        r101 = "";
        goto L7
    }

    @Override // lob.a, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        throw null;
    }

    @Override // lob.a
    public final void j(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        G(r100);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(final boolean r100) {
        this.f429576f = r100;
        View r101 = this.f429574d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r101 = null;
    L5:
        r101.setEnabled(this.f429576f);
        new AaStyleKBPlugin$onEnableChange$1(r100);
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r100) {
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        this.f429574d = r100.f429551a;
    }

    @Override // lob.a
    public final boolean z(int r100, KeyEvent r101) {
        n().z().y();
        return false;
    }

    @Override // lob.a
    public final void r(Editable r100, int r101, int r102) {
        throw null;
    }

    @Override // lob.a, android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        throw null;
    }
}

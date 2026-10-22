package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.i;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.statistics.PostInputPluginHitPoint;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f430413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f430414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f430415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f430416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f430417g;

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return R.drawable.ud_icon_at_outlined;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void s() {
        if (this.f430416f == true) goto L5;
        return;
    L5:
        if (this.f430417g == false) goto L25;
        com.ss.android.lark.keyboard.keyboard2.b r100 = n().L();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.input.base.ISendKeyboardEditor");
        if (((mob.a) r100).getInputType() != InputSupportType.Post) goto L10;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        new PostInputPluginHitPoint("mention").c();
    L15:
        int r102 = this.f430413c.getSelectionStart();
        Editable r103 = this.f430413c.getEditableText();
        if (r102 >= 0) goto L18;
    L21:
        r103.append("@");
        return;
    L18:
        if (r102 >= r103.length()) goto L21;
        r103.insert(r102, "@");
        return;
    L14:
        new TextInputPluginHitPoint("mention").c();
        goto L15
    L10:
        r101 = false;
        goto L12
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return Integer.valueOf(R.string.test_kb_plugin_at);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return KeyboardMenuItemKey.At;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r100) {
        this.f430416f = r100;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r100) {
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        r100.f429551a.setActivated(this.f430414d);
        this.f430415e = r100.f429551a;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void y(boolean r100) {
        this.f430417g = r100;
    }

    public a(KeyboardFunctionEditText r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "targetEditText");
        this.f430413c = r100;
        this.f430414d = r101;
    }
}

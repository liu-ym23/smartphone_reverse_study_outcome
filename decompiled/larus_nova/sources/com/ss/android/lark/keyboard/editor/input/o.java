package com.ss.android.lark.keyboard.editor.input;

import android.widget.EditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f428905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence[] f428906b;

    public static final class a {
    }

    static {
    }

    public final void b() {
        CharSequence[] r100 = this.f428906b;
        int r101 = r100.length - 1;
        if (r101 < 0) goto L13;
    L4:
        int r102 = r101 - 1;
        CharSequence r103 = r100[r101];
        if (r103.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L14;
        if (r102 < 0) goto L13;
        r101 = r102;
    L14:
        if (r103 != null) goto L16;
        r103 = "";
    L16:
        this.f428905a.setHint(r103);
        return;
    L7:
        r104 = false;
    L13:
        r103 = null;
        goto L14
    }

    public o(KeyboardFunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        this.f428905a = r100;
        CharSequence[] r101 = new CharSequence[10];
        int r102 = 0;
    L3:
        if (r102 >= 10) goto L5;
        r101[r102] = "";
        r102 = r102 + 1;
        goto L3
    L5:
        this.f428906b = r101;
    }

    public final void a(int r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r101, "hint");
        if (r100 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        this.f428906b[r100] = r101;
        b();
        return;
    L5:
        if (r100 >= 10) goto L7;
        r102 = true;
        goto L8
    }
}

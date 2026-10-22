package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceKeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public int a;
    public Object b;
    public String c;
    public boolean d;
    public boolean e;

    public g() {
    }

    public final boolean a(CharSequence r2) {
        String r0 = this.c;
        if (r0 != null) goto L6;
        return false;
    L6:
        String r3 = r2.toString();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        return !Intrinsics.areEqual(r0, r3);
    }

    public final boolean b(int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r3, "editor");
        if (this.a == r2) goto L5;
    L7:
        return false;
    L5:
        if (this.b != r3) goto L7;
        return true;
    }

    public final boolean c(int r2, VoiceKeyboardFunctionEditText r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r3, "editor");
        if (this.d == true) goto L5;
    L9:
        return false;
    L5:
        if (b(r2, r3) == false) goto L9;
        if (a(r4) == true) goto L9;
        return true;
    }
}

package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceKeyboardFunctionEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f230489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f230490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f230491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f230492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f230493e;

    public g() {
    }

    public final boolean a(CharSequence r100) {
        String r101 = this.f230491c;
        if (r101 != null) goto L6;
        return false;
    L6:
        String r102 = r100.toString();
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        return !Intrinsics.areEqual(r101, r102);
    }

    public final boolean b(int r100, Object r101) {
        Intrinsics.checkNotNullParameter(r101, "editor");
        if (this.f230489a == r100) goto L5;
    L7:
        return false;
    L5:
        if (this.f230490b != r101) goto L7;
        return true;
    }

    public final boolean c(int r100, VoiceKeyboardFunctionEditText r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r101, "editor");
        if (this.f230492d == true) goto L5;
    L9:
        return false;
    L5:
        if (b(r100, r101) == false) goto L9;
        if (a(r102) == true) goto L9;
        return true;
    }
}

package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f414139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c f414140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MessageFullScreenLaunchData f414141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Integer> f414142d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f414139a == r101.f414139a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f414140b, r101.f414140b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f414141c, r101.f414141c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f414142d, r101.f414142d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f414139a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r102 = this.f414140b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (((r101 + r104) * 31) + this.f414141c.hashCode()) * 31;
        Function0<Integer> r106 = this.f414142d;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ProcessConfigV2(isTranslate=" + this.f414139a + ", clickContext=" + this.f414140b + ", launchData=" + this.f414141c + ", widthProvider=" + this.f414142d + ')';
    }

    public s(boolean r100, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r101, MessageFullScreenLaunchData r102, Function0<Integer> r103) {
        Intrinsics.checkNotNullParameter(r102, "launchData");
        this.f414139a = r100;
        this.f414140b = r101;
        this.f414141c = r102;
        this.f414142d = r103;
    }
}

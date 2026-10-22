package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f412120d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f412121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f412122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f412123c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a$a, reason: collision with other inner class name */
    public static final class C4795a {
        @JvmStatic
        public static boolean a(HashMap r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Iterator r101 = r100.entrySet().iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L6;
            r102 = r102 | ((a) ((Map.Entry) r101.next()).getValue()).f412122b;
            goto L4
        L6:
            return r102;
        }

        @JvmStatic
        public static boolean b(HashMap r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Iterator r101 = r100.entrySet().iterator();
            boolean r102 = false;
        L4:
            if (r101.hasNext() == false) goto L6;
            r102 = r102 | ((a) ((Map.Entry) r101.next()).getValue()).f412123c;
            goto L4
        L6:
            return r102;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f412121a, r101.f412121a) == true) goto L12;
        return false;
    L12:
        if (this.f412122b == r101.f412122b) goto L15;
        return false;
    L15:
        if (this.f412123c == r101.f412123c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f412121a.hashCode() * 31;
        int r101 = 1231;
        if (this.f412122b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f412123c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "BannedKeyboardReason(reason=" + this.f412121a + ", banKeyboard=" + this.f412122b + ", banKeyboardTop=" + this.f412123c + ')';
    }

    public a() {
        Intrinsics.checkNotNullParameter("banned_select", "reason");
        this.f412121a = "banned_select";
        this.f412122b = true;
        this.f412123c = true;
    }
}

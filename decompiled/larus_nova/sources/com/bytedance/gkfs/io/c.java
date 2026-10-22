package com.bytedance.gkfs.io;

import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f245191b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f245192a;

    public static final class a {
    }

    static {
        f245191b = new c(StringsKt.repeat("f", 40));
    }

    public final int hashCode() {
        return this.f245192a.hashCode();
    }

    public final String toString() {
        return "ChunkIdentifier(" + this.f245192a + ')';
    }

    public final String a() {
        return this.f245192a;
    }

    public c(String r100) {
        this.f245192a = r100;
        if (r100.length() != 40) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Invalid identifier:" + r100 + ", except size is 40 but receive " + r100.length());
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if ((!Intrinsics.areEqual(this.f245192a, ((c) r100).f245192a)) == false) goto L11;
        return false;
    L11:
        return true;
    }

    public c(byte[] r100, int r101) {
        MessageDigest r102 = MessageDigest.getInstance("SHA-1");
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r102.update(r100[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        byte[] r105 = r102.digest();
        char[] r106 = com.bytedance.gkfs.cdc.d.f245157a;
        if (r105 == null) goto L18;
        if (r105.length != 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L18;
        StringBuffer r108 = new StringBuffer(r105.length * 2);
        int r109 = r105.length;
    L13:
        if (r103 >= r109) goto L15;
        byte r110 = r105[r103];
        int r111 = (r110 & 240) >> 4;
        char[] r112 = com.bytedance.gkfs.cdc.d.f245157a;
        r108.append(r112[r111]);
        r108.append(r112[r110 & 15]);
        r103 = r103 + 1;
        goto L13
    L15:
        this(r108.toString());
        return;
    L10:
        r107 = false;
    L18:
        throw new NullPointerException("bytes array MUST not be NULL!");
    }
}

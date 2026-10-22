package com.bytedance.awemeopen.apps.framework.card.video;

import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public int a;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.card.video.a$a, reason: collision with other inner class name */
    public static final class C0068a {
    }

    static {
    }

    public a() {
    }

    public final boolean a() {
        if (this.a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void b() {
        this.a++;
    }

    public final String toString() {
        int r0 = this.a;
        if (r0 != 0) goto L5;
        String r1 = "idle";
    L13:
        return Integer.toString(hashCode(), CharsKt.checkRadix(16)) + '#' + r1;
    L5:
        if (r0 != 1) goto L7;
        r1 = "bind";
        goto L13
    L7:
        if (r0 == 2) goto L9;
        r1 = String.valueOf(r0);
        goto L13
    L9:
        r1 = "select";
        goto L13
    }
}

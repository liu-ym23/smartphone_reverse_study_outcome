package com.larus.chat.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f324180d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f324181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PreviewSendFailureReason f324182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f324183c;

    public static final class a {
        public static v a(PreviewSendFailureReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            return new v(false, r100, 4);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f324181a == r101.f324181a) goto L12;
        return false;
    L12:
        if (this.f324182b == r101.f324182b) goto L15;
        return false;
    L15:
        if (this.f324183c == r101.f324183c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f324181a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        PreviewSendFailureReason r103 = this.f324182b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f324183c == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewSendResult(success=" + this.f324181a + ", reason=" + this.f324182b + ", closePreview=" + this.f324183c + ')';
    }

    public v(boolean r100, PreviewSendFailureReason r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        boolean r103 = r100;
    L9:
        this.f324181a = r100;
        this.f324182b = r101;
        this.f324183c = r103;
        return;
    L8:
        r103 = false;
        goto L9
    }
}

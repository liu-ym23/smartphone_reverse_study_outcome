package com.larus.platform.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f365253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f365254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f365260h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r4) == true) goto L8;
        return false;
    L8:
        r4 r101 = (r4) r100;
        if (Intrinsics.areEqual(this.f365253a, r101.f365253a) == true) goto L12;
        return false;
    L12:
        if (this.f365254b == r101.f365254b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365255c, r101.f365255c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365256d, r101.f365256d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365257e, r101.f365257e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365258f, r101.f365258f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365259g, r101.f365259g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f365260h, r101.f365260h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f365253a.hashCode() * 31) + this.f365254b) * 31) + this.f365255c.hashCode()) * 31;
        String r101 = this.f365256d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f365257e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f365258f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f365259g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f365260h;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeUrlPreviewHostOpenRequest(context=" + this.f365253a + ", previewTypeValue=" + this.f365254b + ", token=" + this.f365255c + ", enterMethod=" + this.f365256d + ", page=" + this.f365257e + ", messageId=" + this.f365258f + ", conversationId=" + this.f365259g + ", sourceUrl=" + this.f365260h + ')';
    }

    public final Context getContext() {
        return this.f365253a;
    }

    public r4(Context r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        this.f365253a = r100;
        this.f365254b = 14;
        this.f365255c = r101;
        this.f365256d = r102;
        this.f365257e = "chat";
        this.f365258f = r103;
        this.f365259g = r104;
        this.f365260h = r105;
    }
}

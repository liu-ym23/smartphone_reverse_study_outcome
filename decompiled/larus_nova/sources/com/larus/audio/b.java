package com.larus.audio;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f288710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f288711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f288712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f288713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f288714g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f288708a, r101.f288708a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f288709b, r101.f288709b) == true) goto L15;
        return false;
    L15:
        if (this.f288710c == r101.f288710c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f288711d, r101.f288711d) == true) goto L21;
        return false;
    L21:
        if (this.f288712e == r101.f288712e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f288713f, r101.f288713f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f288714g, r101.f288714g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f288708a.hashCode() * 31) + this.f288709b.hashCode()) * 31;
        long r101 = this.f288710c;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f288711d.hashCode()) * 31;
        if (this.f288712e == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f288713f;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        c r109 = this.f288714g;
        if (r109 == null) goto L15;
        r106 = r109.hashCode();
    L15:
        return r108 + r106;
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "AsrSuccessResult(taskId=" + this.f288708a + ", messageContent=" + this.f288709b + ", audioDuration=" + this.f288710c + ", vid=" + this.f288711d + ", alterToVoiceSend=" + this.f288712e + ", path=" + this.f288713f + ", extra=" + this.f288714g + ')';
    }

    public static b a(b r100, boolean r110) {
        String r101 = r100.f288708a;
        String r102 = r100.f288709b;
        long r103 = r100.f288710c;
        String r104 = r100.f288711d;
        String r105 = r100.f288713f;
        c r106 = r100.f288714g;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "messageContent");
        Intrinsics.checkNotNullParameter(r104, "vid");
        return new b(r101, r102, r103, r104, r110, r105, r106);
    }

    public b(String r100, String r101, long r102, String r103, boolean r104, String r105, c r106) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "messageContent");
        Intrinsics.checkNotNullParameter(r103, "vid");
        this.f288708a = r100;
        this.f288709b = r101;
        this.f288710c = r102;
        this.f288711d = r103;
        this.f288712e = r104;
        this.f288713f = r105;
        this.f288714g = r106;
    }

    public /* synthetic */ b(String r110, String r111, long r112, String r113, String r114, c r115, int r116) {
        if ((r116 & 64) == 0) goto L5;
        c r100 = null;
    L6:
        this(r110, r111, r112, r113, false, r114, r100);
        return;
    L5:
        r100 = r115;
        goto L6
    }
}

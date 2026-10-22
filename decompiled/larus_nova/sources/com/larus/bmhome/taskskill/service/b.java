package com.larus.bmhome.taskskill.service;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wc9.e f314433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f314434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f314436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f314437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f314438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f314439g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f314433a, r101.f314433a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314434b, r101.f314434b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314435c, r101.f314435c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f314436d, r101.f314436d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f314437e, r101.f314437e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f314438f, r101.f314438f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f314439g, r101.f314439g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        wc9.e r100 = this.f314433a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        FragmentActivity r104 = this.f314434b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f314435c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f314436d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f314437e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f314438f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f314439g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalPcDispatchFallbackDialogRequest(conversation=" + this.f314433a + ", fragmentActivity=" + this.f314434b + ", blockId=" + this.f314435c + ", interactionType=" + this.f314436d + ", displayType=" + this.f314437e + ", agentType=" + this.f314438f + ", pcGuideRequestKey=" + this.f314439g + ')';
    }

    public b(wc9.e r100, FragmentActivity r101, String r102, String r103, String r104) {
        this.f314433a = r100;
        this.f314434b = r101;
        this.f314435c = r102;
        this.f314436d = null;
        this.f314437e = r103;
        this.f314438f = r104;
        this.f314439g = null;
    }
}

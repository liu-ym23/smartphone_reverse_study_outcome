package com.larus.bmhome.taskskill.network;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314391c;

    public q() {
        String r100 = null;
        this(r100, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f314389a, r101.f314389a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314390b, r101.f314390b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314391c, r101.f314391c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f314389a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f314390b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f314391c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskSkillRequestParam(conversationId=" + this.f314389a + ", pcDeviceId=" + this.f314390b + ", folderWorkspace=" + this.f314391c + ')';
    }

    public final String a() {
        String r100 = this.f314389a;
        String r101 = "";
        if (r100 == null) goto L23;
        String r102 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L23;
        String r103 = this.f314390b;
        if (r103 == null) goto L23;
        if ((!StringsKt.isBlank(r103)) == false) goto L15;
        r102 = r103;
    L15:
        if (r102 == null) goto L23;
        String[] r104 = new String[3];
        r104[0] = r100;
        r104[1] = r102;
        String r105 = this.f314391c;
        if (r105 == null) goto L21;
        r101 = r105;
    L21:
        r104[2] = r101;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r104), "#", null, null, 0, null, null, 62, null);
    L23:
        return "";
    }

    public final boolean b() {
        String r100 = this.f314390b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }

    public /* synthetic */ q(String r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this(null, r100, r101);
    }

    public q(String r100, String r101, String r102) {
        this.f314389a = r100;
        this.f314390b = r101;
        this.f314391c = r102;
    }
}

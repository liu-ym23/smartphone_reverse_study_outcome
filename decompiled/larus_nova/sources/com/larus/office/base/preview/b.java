package com.larus.office.base.preview;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f361016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f361017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f361018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f361019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f361020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<DocMeta> f361021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f361022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f361023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f361024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Bundle f361025j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f361016a, r101.f361016a) == true) goto L12;
        return false;
    L12:
        if (this.f361017b == r101.f361017b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f361018c, r101.f361018c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f361019d, r101.f361019d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f361020e, r101.f361020e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f361021f, r101.f361021f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f361022g, r101.f361022g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f361023h, r101.f361023h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f361024i, r101.f361024i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f361025j, r101.f361025j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f361016a.hashCode() * 31) + this.f361017b) * 31) + this.f361018c.hashCode()) * 31;
        String r101 = this.f361019d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f361020e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f361021f.hashCode()) * 31;
        String r108 = this.f361022g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f361023h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f361024i;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return ((r113 + r102) * 31) + this.f361025j.hashCode();
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
        return "OfficePreviewOpenRequest(context=" + this.f361016a + ", previewTypeValue=" + this.f361017b + ", token=" + this.f361018c + ", enterMethod=" + this.f361019d + ", page=" + this.f361020e + ", restDocs=" + this.f361021f + ", applyPermissionMessageId=" + this.f361022g + ", applyPermissionConversationId=" + this.f361023h + ", sourceUrlForParams=" + this.f361024i + ", extras=" + this.f361025j + ')';
    }

    public final Context getContext() {
        return this.f361016a;
    }

    public b(Context r100, int r101, String r102, String r103, String r104, ArrayList<DocMeta> r105, String r106, String r107, String r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r105, "restDocs");
        Intrinsics.checkNotNullParameter(r111, "extras");
        this.f361016a = r100;
        this.f361017b = r101;
        this.f361018c = r102;
        this.f361019d = r103;
        this.f361020e = r104;
        this.f361021f = r105;
        this.f361022g = r106;
        this.f361023h = r107;
        this.f361024i = r110;
        this.f361025j = r111;
    }

    public /* synthetic */ b(Context r110, int r111, String r112, String r113, String r114, ArrayList r210, String r211, String r212, String r213, Bundle r214, int r215) {
        if ((r215 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 32) == 0) goto L13;
        ArrayList r102 = new ArrayList();
    L15:
        if ((r215 & 64) == 0) goto L17;
        String r115 = null;
    L19:
        if ((r215 & 128) == 0) goto L21;
        String r116 = null;
    L23:
        if ((r215 & 256) == 0) goto L25;
        String r117 = null;
    L27:
        if ((r215 & 512) == 0) goto L29;
        Bundle r118 = new Bundle();
    L30:
        this(r110, r111, r112, r100, r101, r102, r115, r116, r117, r118);
        return;
    L29:
        r118 = r214;
        goto L30
    L25:
        r117 = r213;
        goto L27
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}

package com.obric.assistant.cocreationreview.modules.searchqa;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c0 extends com.obric.assistant.cocreationreview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleKey f387535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f387536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f387537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f387538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f387539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f387540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f387541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f387542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<s> f387543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f387544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a5 f387545l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f387546m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f387534a, r101.f387534a) == true) goto L12;
        return false;
    L12:
        if (this.f387535b == r101.f387535b) goto L15;
        return false;
    L15:
        if (this.f387536c == r101.f387536c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387537d, r101.f387537d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387538e, r101.f387538e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387539f, r101.f387539f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387540g, r101.f387540g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387541h, r101.f387541h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387542i, r101.f387542i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387543j, r101.f387543j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f387544k, r101.f387544k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f387545l, r101.f387545l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f387546m, r101.f387546m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f387534a.hashCode() * 31) + this.f387535b.hashCode()) * 31;
        long r101 = this.f387536c;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f387537d.hashCode()) * 31) + this.f387538e.hashCode()) * 31;
        String r103 = this.f387539f;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (((((((((r102 + r105) * 31) + this.f387540g.hashCode()) * 31) + this.f387541h.hashCode()) * 31) + this.f387542i.hashCode()) * 31) + this.f387543j.hashCode()) * 31;
        String r107 = this.f387544k;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        a5 r110 = this.f387545l;
        if (r110 == null) goto L15;
        r104 = r110.hashCode();
    L15:
        return ((r109 + r104) * 31) + this.f387546m.hashCode();
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchQaUsageRecord(id=" + this.f387534a + ", module=" + this.f387535b + ", createdAt=" + this.f387536c + ", answeredAt=" + this.f387537d + ", searchDomain=" + this.f387538e + ", searchTopic=" + this.f387539f + ", userQuestion=" + this.f387540g + ", answerSummary=" + this.f387541h + ", answerText=" + this.f387542i + ", localReferences=" + this.f387543j + ", logId=" + this.f387544k + ", feedback=" + this.f387545l + ", payload=" + this.f387546m + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.f387534a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.f387535b;
    }

    public /* synthetic */ c0(String r110, ModuleKey r111, long r112, String r210, String r211, String r212, String r213, List r214, String r215, String r216, int r217) {
        if ((r217 & 1024) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r217 & 4096) == 0) goto L9;
        String r114 = r110;
    L10:
        this(r110, r111, r112, r210, "全搜问答", null, r211, r212, r213, r214, r113, null, r114);
        return;
    L9:
        r114 = r216;
        goto L10
    L5:
        r113 = r215;
        goto L7
    }

    public c0(String r100, ModuleKey r101, long r102, String r103, String r104, String r105, String r106, String r110, String r111, List<s> r112, String r113, a5 r114, String r115) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r103, "answeredAt");
        Intrinsics.checkNotNullParameter(r104, "searchDomain");
        Intrinsics.checkNotNullParameter(r106, "userQuestion");
        Intrinsics.checkNotNullParameter(r110, "answerSummary");
        Intrinsics.checkNotNullParameter(r111, "answerText");
        Intrinsics.checkNotNullParameter(r112, "localReferences");
        Intrinsics.checkNotNullParameter(r115, WsConstants.KEY_PAYLOAD);
        this.f387534a = r100;
        this.f387535b = r101;
        this.f387536c = r102;
        this.f387537d = r103;
        this.f387538e = r104;
        this.f387539f = r105;
        this.f387540g = r106;
        this.f387541h = r110;
        this.f387542i = r111;
        this.f387543j = r112;
        this.f387544k = r113;
        this.f387545l = r114;
        this.f387546m = r115;
    }
}

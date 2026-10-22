package com.obric.assistant.cocreationreview.modules.memory.personalmemory;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.ss.android.cert.manager.constants.EventConstant;
import hda.e1;
import hda.f1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class g extends com.obric.assistant.cocreationreview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleKey f387445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f387447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f387448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f387449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f387450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f387451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f387452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e1 f387453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f387454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f387455l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f387444a, r101.f387444a) == true) goto L12;
        return false;
    L12:
        if (this.f387445b == r101.f387445b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387446c, r101.f387446c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387447d, r101.f387447d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387448e, r101.f387448e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387449f, r101.f387449f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387450g, r101.f387450g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387451h, r101.f387451h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387452i, r101.f387452i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387453j, r101.f387453j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f387454k, r101.f387454k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f387455l, r101.f387455l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f387444a.hashCode() * 31) + this.f387445b.hashCode()) * 31;
        String r101 = this.f387446c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f387447d.hashCode()) * 31) + this.f387448e.hashCode()) * 31;
        String r105 = this.f387449f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f387450g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((((((r107 + r109) * 31) + this.f387451h.hashCode()) * 31) + this.f387452i.hashCode()) * 31) + this.f387453j.hashCode()) * 31) + this.f387454k.hashCode()) * 31;
        String r111 = this.f387455l;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "PersonalMemoryUsageRecord(id=" + this.f387444a + ", module=" + this.f387445b + ", visualGroupKey=" + this.f387446c + ", profileChangedAt=" + this.f387447d + ", profileDomain=" + this.f387448e + ", profilePrimaryCategory=" + this.f387449f + ", profileSecondaryCategory=" + this.f387450g + ", profileTitle=" + this.f387451h + ", profileSummary=" + this.f387452i + ", uiModel=" + this.f387453j + ", payload=" + this.f387454k + ", traceJson=" + this.f387455l + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.f387444a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.f387445b;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String c() {
        return this.f387446c;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final com.obric.assistant.cocreationreview.a d(List<? extends com.obric.assistant.cocreationreview.a> r210) {
        Intrinsics.checkNotNullParameter(r210, "records");
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r210.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((r102 instanceof g) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        g r105 = (g) r104.next();
        CollectionsKt.addAll(r103, CollectionsKt.plus(CollectionsKt.listOf(r105.f387453j), r105.f387453j.f484672r));
        goto L10
    L12:
        HashSet r106 = new HashSet();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r103.iterator();
    L14:
        if (r108.hasNext() == false) goto L18;
        Object r109 = r108.next();
        if (r106.add(((e1) r109).f484655a) == false) goto L14;
        r107.add(r109);
        goto L14
    L18:
        List<e1> r110 = f1.d(r107);
        if (r110.size() > 1) goto L21;
        return this;
    L21:
        e1 r111 = e1.a(this.f387453j, null, null, null, r110, 917503);
        String r112 = this.f387444a;
        ModuleKey r113 = this.f387445b;
        String r114 = this.f387446c;
        String r115 = this.f387447d;
        String r116 = this.f387448e;
        String r117 = this.f387449f;
        String r118 = this.f387450g;
        String r119 = this.f387451h;
        String r120 = this.f387452i;
        String r121 = this.f387454k;
        String r122 = this.f387455l;
        Intrinsics.checkNotNullParameter(r112, "id");
        Intrinsics.checkNotNullParameter(r113, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r115, "profileChangedAt");
        Intrinsics.checkNotNullParameter(r116, "profileDomain");
        Intrinsics.checkNotNullParameter(r119, "profileTitle");
        Intrinsics.checkNotNullParameter(r120, "profileSummary");
        Intrinsics.checkNotNullParameter(r111, "uiModel");
        Intrinsics.checkNotNullParameter(r121, WsConstants.KEY_PAYLOAD);
        return new g(r112, r113, r114, r115, r116, r117, r118, r119, r120, r111, r121, r122);
    }

    public g(String r100, ModuleKey r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, e1 r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r103, "profileChangedAt");
        Intrinsics.checkNotNullParameter(r104, "profileDomain");
        Intrinsics.checkNotNullParameter(r107, "profileTitle");
        Intrinsics.checkNotNullParameter(r110, "profileSummary");
        Intrinsics.checkNotNullParameter(r111, "uiModel");
        Intrinsics.checkNotNullParameter(r112, WsConstants.KEY_PAYLOAD);
        this.f387444a = r100;
        this.f387445b = r101;
        this.f387446c = r102;
        this.f387447d = r103;
        this.f387448e = r104;
        this.f387449f = r105;
        this.f387450g = r106;
        this.f387451h = r107;
        this.f387452i = r110;
        this.f387453j = r111;
        this.f387454k = r112;
        this.f387455l = r113;
    }
}

package com.obric.assistant.cocreationreview.modules.memory.automemorypro;

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
public final class i extends com.obric.assistant.cocreationreview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleKey f387415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f387417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f387418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f387419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f387420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f387421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f387422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e1 f387423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f387424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f387425l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f387414a, r101.f387414a) == true) goto L12;
        return false;
    L12:
        if (this.f387415b == r101.f387415b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387416c, r101.f387416c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387417d, r101.f387417d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387418e, r101.f387418e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f387419f, r101.f387419f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f387420g, r101.f387420g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f387421h, r101.f387421h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f387422i, r101.f387422i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387423j, r101.f387423j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f387424k, r101.f387424k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f387425l, r101.f387425l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f387414a.hashCode() * 31) + this.f387415b.hashCode()) * 31;
        String r101 = this.f387416c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f387417d.hashCode()) * 31) + this.f387418e.hashCode()) * 31;
        String r105 = this.f387419f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f387420g.hashCode()) * 31;
        String r108 = this.f387421h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((((r107 + r109) * 31) + this.f387422i.hashCode()) * 31) + this.f387423j.hashCode()) * 31) + this.f387424k.hashCode()) * 31;
        String r111 = this.f387425l;
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
        return "AutoMemoryProUsageRecord(id=" + this.f387414a + ", module=" + this.f387415b + ", visualGroupKey=" + this.f387416c + ", detectedAt=" + this.f387417d + ", taskDomain=" + this.f387418e + ", taskRule=" + this.f387419f + ", taskTitle=" + this.f387420g + ", taskSubtitle=" + this.f387421h + ", taskSummary=" + this.f387422i + ", uiModel=" + this.f387423j + ", payload=" + this.f387424k + ", traceJson=" + this.f387425l + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.f387414a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.f387415b;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String c() {
        return this.f387416c;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final com.obric.assistant.cocreationreview.a d(List<? extends com.obric.assistant.cocreationreview.a> r210) {
        Intrinsics.checkNotNullParameter(r210, "records");
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r210.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((r102 instanceof i) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        i r105 = (i) r104.next();
        CollectionsKt.addAll(r103, CollectionsKt.plus(CollectionsKt.listOf(r105.f387423j), r105.f387423j.f484672r));
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
        e1 r111 = e1.a(this.f387423j, null, null, null, r110, 917503);
        String r112 = this.f387414a;
        ModuleKey r113 = this.f387415b;
        String r114 = this.f387416c;
        String r115 = this.f387417d;
        String r116 = this.f387418e;
        String r117 = this.f387419f;
        String r118 = this.f387420g;
        String r119 = this.f387421h;
        String r120 = this.f387422i;
        String r121 = this.f387424k;
        String r122 = this.f387425l;
        Intrinsics.checkNotNullParameter(r112, "id");
        Intrinsics.checkNotNullParameter(r113, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r115, "detectedAt");
        Intrinsics.checkNotNullParameter(r116, "taskDomain");
        Intrinsics.checkNotNullParameter(r118, "taskTitle");
        Intrinsics.checkNotNullParameter(r120, "taskSummary");
        Intrinsics.checkNotNullParameter(r111, "uiModel");
        Intrinsics.checkNotNullParameter(r121, WsConstants.KEY_PAYLOAD);
        return new i(r112, r113, r114, r115, r116, r117, r118, r119, r120, r111, r121, r122);
    }

    public i(String r100, ModuleKey r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, e1 r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r103, "detectedAt");
        Intrinsics.checkNotNullParameter(r104, "taskDomain");
        Intrinsics.checkNotNullParameter(r106, "taskTitle");
        Intrinsics.checkNotNullParameter(r110, "taskSummary");
        Intrinsics.checkNotNullParameter(r111, "uiModel");
        Intrinsics.checkNotNullParameter(r112, WsConstants.KEY_PAYLOAD);
        this.f387414a = r100;
        this.f387415b = r101;
        this.f387416c = r102;
        this.f387417d = r103;
        this.f387418e = r104;
        this.f387419f = r105;
        this.f387420g = r106;
        this.f387421h = r107;
        this.f387422i = r110;
        this.f387423j = r111;
        this.f387424k = r112;
        this.f387425l = r113;
    }
}

package com.larus.im.bean.message.feedback;

import java.util.List;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.b2;

/* JADX INFO: loaded from: classes29.dex */
@Serializable
public final class FeedbackItem {
    public static final a Companion = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f347111i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f347112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f347113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f347114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f347115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f347116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f347117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f347118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f347119h;

    public static final class a {
        public a() {
        }

        public final d<FeedbackItem> serializer() {
            return FeedbackItem$$serializer.f347120a;
        }
    }

    public FeedbackItem() {
        this(0, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedbackItem) == true) goto L8;
        return false;
    L8:
        FeedbackItem r101 = (FeedbackItem) r100;
        if (this.f347112a == r101.f347112a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f347113b, r101.f347113b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f347114c, r101.f347114c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f347115d, r101.f347115d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f347116e, r101.f347116e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f347117f, r101.f347117f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f347118g, r101.f347118g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f347119h, r101.f347119h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f347112a * 31;
        Integer r101 = this.f347113b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<Integer> r105 = this.f347114c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f347115d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f347116e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f347117f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f347118g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f347119h;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "FeedbackItem(feedbackType=" + this.f347112a + ", feedbackDetailType=" + this.f347113b + ", feedbackDetailTypes=" + this.f347114c + ", feedbackDetailContent=" + this.f347115d + ", scene=" + this.f347116e + ", entityId=" + this.f347117f + ", entityType=" + this.f347118g + ", extra=" + this.f347119h + ')';
    }

    static {
        Companion = new a();
        f347111i = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new bd9.a()), null, null, null, null, null};
    }

    public FeedbackItem(int r100, Integer r101, List<Integer> r102, String r103, String r104, String r105, String r106, String r107) {
        this.f347112a = r100;
        this.f347113b = r101;
        this.f347114c = r102;
        this.f347115d = r103;
        this.f347116e = r104;
        this.f347117f = r105;
        this.f347118g = r106;
        this.f347119h = r107;
    }

    public FeedbackItem(int r100, int r101, Integer r102, List r103, String r104, String r105, String r110, String r111, String r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, FeedbackItem$$serializer.f347121b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f347112a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f347113b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f347114c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f347115d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f347116e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f347117f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f347118g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f347119h = null;
        return;
    L35:
        this.f347119h = r112;
        return;
    L31:
        this.f347118g = r111;
        goto L33
    L27:
        this.f347117f = r110;
        goto L29
    L23:
        this.f347116e = r105;
        goto L25
    L19:
        this.f347115d = r104;
        goto L21
    L15:
        this.f347114c = r103;
        goto L17
    L11:
        this.f347113b = r102;
        goto L13
    L7:
        this.f347112a = r101;
        goto L9
    }
}

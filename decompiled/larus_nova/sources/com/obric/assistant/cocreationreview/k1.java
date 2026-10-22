package com.obric.assistant.cocreationreview;

import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class k1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CocreationReviewActivity f387339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f387340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Vote f387341c;

    public /* synthetic */ k1(CocreationReviewActivity r100, a r101, Vote r102) {
        this.f387339a = r100;
        this.f387340b = r101;
        this.f387341c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final CocreationReviewActivity r100 = this.f387339a;
        a r101 = this.f387340b;
        final Vote r102 = this.f387341c;
        Set<String> r103 = CocreationReviewActivity.P1;
        r100.getClass();
        if (r100.i2(r101.a()) == false) goto L5;
        int r104 = s3.f387719a;
        s3.b("feedback.detail", "showAfterVote blocked recordId=" + r101.a() + ", module=" + r101.b().getRaw() + ", vote=" + r102.getRaw() + ", reason=feedback_completed");
    L65:
        return Unit.INSTANCE;
    L5:
        l0 r105 = (l0) ((Map) r100.f387040b.getValue()).get(r101.b());
        if (r105 != null) goto L8;
        r100.D2(r101, r102);
        goto L65
    L8:
        FrameLayout r110 = null;
        r100.D = null;
        a5 r106 = r100.f387050i.get(r101.a());
        if (r106 != null) goto L13;
        r106 = (a5) ((LinkedHashMap) r100.L1()).get(r101.a());
        if (r106 != null) goto L13;
        r106 = new a5(r101.a(), null, null, null, false, 0, null, 254);
    L13:
        a5 r107 = r106;
        j5 r108 = new j5(r100);
        boolean r111 = true;
        if (r100.B != ReviewMode.HISTORY) goto L16;
        boolean r109 = true;
    L18:
        if (r107.f387187e == false) goto L20;
        b r112 = b.c.f387193a;
    L21:
        z4 r113 = r105.c(r108, r101, r107, r109, r112).f387780j;
        if ((r113 instanceof z4.a) == false) goto L24;
        z4.a r114 = (z4.a) r113;
    L26:
        if (r114 != null) goto L28;
        int r115 = s3.f387719a;
        s3.c("feedback.detail", "fallback recordId=" + r101.a() + ", module=" + r101.b().getRaw() + ", reason=detail_missing");
        r100.D2(r101, r102);
        goto L65
    L28:
        String r116 = r101.a();
        Iterator r117 = CocreationReviewActivity.N1(r114).iterator();
        int r118 = 0;
    L30:
        if (r117.hasNext() == false) goto L35;
        if (Intrinsics.areEqual(CocreationReviewActivity.O1((x4) r117.next(), r114), r116) == true) goto L36;
        r118 = r118 + 1;
    L36:
        Integer r119 = Integer.valueOf(r118);
        if (r119.intValue() >= 0) goto L40;
        r111 = false;
    L40:
        if (r111 == true) goto L43;
        r119 = null;
    L43:
        if (r119 == null) goto L45;
        int r120 = r119.intValue();
    L46:
        String r121 = CocreationReviewActivity.z1(r114, r120);
        Iterator r122 = ((ArrayList) r100.c2()).iterator();
    L48:
        if (r122.hasNext() == false) goto L52;
        Object r123 = r122.next();
        if (Intrinsics.areEqual(((a) r123).a(), r121) == false) goto L48;
    L53:
        final a r124 = (a) r123;
        if (r124 != null) goto L57;
        int r125 = s3.f387719a;
        s3.c("feedback.detail", "fallback recordId=" + r101.a() + ", module=" + r101.b().getRaw() + ", targetRecordId=" + r121 + ", reason=target_missing");
        r100.D2(r101, r102);
        goto L65
    L57:
        if (r100.i2(r124.a()) == false) goto L59;
        int r126 = s3.f387719a;
        s3.b("feedback.detail", "showAfterVote blocked recordId=" + r124.a() + ", module=" + r124.b().getRaw() + ", vote=" + r102.getRaw() + ", reason=target_completed");
        goto L65
    L59:
        a5 r127 = r100.A1(r124, r102);
        int r128 = s3.f387719a;
        s3.b("feedback.detail", "showAfterVote recordId=" + r101.a() + ", targetRecordId=" + r124.a() + ", module=" + r124.b().getRaw() + ", vote=" + r102.getRaw() + ", pageIndex=" + r120 + ", pages=" + r114.f387825f.size() + ", reasonCount=" + r127.f387185c.size());
        r100.D = r124.a();
        r124.b();
        r100.E2(r114, r120);
        FrameLayout r129 = r100.O;
        if (r129 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("rootHost");
    L63:
        r110.post(new q1(r100, r124, r102));
        goto L65
    L62:
        r110 = r129;
        goto L63
    L52:
        r123 = null;
        goto L53
    L45:
        r120 = 0;
        goto L46
    L35:
        r118 = -1;
        goto L36
    L24:
        r114 = null;
        goto L26
    L20:
        r112 = b.C4599b.f387192a;
        goto L21
    L16:
        r109 = false;
        goto L18
    }
}

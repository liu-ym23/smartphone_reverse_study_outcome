package com.larus.dora.impl.ota.g2;

import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.ota.check.DoraOTACheckRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraG2LatestSource implements p {
    public static final DoraG2LatestSource INSTANCE = null;

    static {
        INSTANCE = new DoraG2LatestSource();
    }

    public DoraG2LatestSource() {
    }

    @Override // com.larus.dora.impl.ota.g2.p
    public final Object a(q.b r310, Continuation<? super x4> r311) {
        if ((r311 instanceof DoraG2LatestSource$check$1) == false) goto L7;
        DoraG2LatestSource$check$1 r100 = (DoraG2LatestSource$check$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraG2LatestSource$check$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        q.b r105 = (q.b) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = ((Result) r102).m9458unboximpl();
        q.b r107 = r105;
    L26:
        if (Result.m9452exceptionOrNullimpl(r106) != null) goto L151;
        e49.a r108 = (e49.a) r106;
        DoraG2LatestSource r109 = INSTANCE;
        e r111 = r107.a();
        r109.getClass();
        if (r108 == null) goto L159;
        OTAUpdatePackage r112 = e49.b.a(r108);
        if (r112 == null) goto L160;
        Integer r113 = r112.getId();
        e5 r114 = null;
        String r115 = null;
        r114 = null;
        r114 = null;
        r114 = null;
        r114 = null;
        r114 = null;
        r114 = null;
        r114 = null;
        r114 = null;
        r114 = null;
        if (r113 == null) goto L147;
        long r116 = r113.intValue();
        Integer r117 = r112.getSize();
        if (r117 == null) goto L147;
        long r118 = r117.intValue();
        String r119 = r112.getVersion();
        if (r119 != null) goto L40;
        String r120 = "";
    L41:
        String r121 = r112.getMd5();
        if (r121 != null) goto L44;
        r121 = "";
    L44:
        String r122 = r121.toLowerCase(Locale.ROOT);
        String r123 = r112.getName();
        if (r123 != null) goto L47;
        String r124 = "";
    L48:
        String r125 = r112.getUrl();
        if (r125 != null) goto L51;
        String r210 = "";
    L53:
        if (r116 <= 0) goto L147;
        if (r118 <= 0) goto L147;
        if (StringsKt.isBlank(r120) == true) goto L147;
        int r126 = r112.getType();
        boolean r127 = false;
        if (1 <= r126) goto L61;
    L63:
        boolean r128 = false;
    L64:
        if (r128 == false) goto L147;
        if (r122.length() != 32) goto L147;
        int r129 = 0;
    L69:
        if (r129 >= r122.length()) goto L89;
        char r130 = r122.charAt(r129);
        if ('0' <= r130) goto L73;
    L75:
        boolean r131 = false;
    L76:
        if (r131 == false) goto L78;
    L85:
        boolean r132 = false;
    L86:
        if (r132 == true) goto L87;
        r129 = r129 + 1;
        goto L69
    L87:
        r127 = true;
        goto L89
    L78:
        if ('a' <= r130) goto L80;
    L82:
        boolean r133 = false;
    L83:
        if (r133 == true) goto L85;
        r132 = true;
        goto L86
    L80:
        if (r130 >= 'g') goto L82;
        r133 = true;
        goto L83
    L73:
        if (r130 >= ':') goto L75;
        r131 = true;
    L89:
        if (r127 == true) goto L147;
        if (StringsKt.isBlank(r124) == true) goto L147;
        if (StringsKt.isBlank(r210) == true) goto L147;
        List<String> r134 = r112.getBakUrls();
        if (r134 != null) goto L98;
        r134 = CollectionsKt.emptyList();
    L98:
        List r135 = CollectionsKt.filterNotNull(r134);
        ArrayList r136 = new ArrayList();
        Iterator r137 = r135.iterator();
    L100:
        if (r137.hasNext() == false) goto L104;
        Object r138 = r137.next();
        if ((!StringsKt.isBlank((String) r138)) == false) goto L100;
        r136.add(r138);
        goto L100
    L104:
        z39.a r139 = r108.f471022a;
        if (r139 == null) goto L107;
        OTAUpdateMeta r140 = r139.a();
    L108:
        d5 r211 = new d5(r111, r116, r120, r112.getType(), r118, r122, r124);
        String r141 = (String) CollectionsKt.firstOrNull(r136);
        if (r141 != null) goto L111;
        r141 = "";
    L111:
        z39.a r142 = r108.f471022a;
        if (r142 == null) goto L114;
        String r143 = r142.d();
    L115:
        if (r143 != null) goto L117;
        String r212 = "";
    L118:
        z39.a r144 = r108.f471022a;
        if (r144 == null) goto L121;
        String r145 = r144.c();
    L122:
        if (r145 != null) goto L124;
        String r213 = "";
    L125:
        Long r146 = r112.getBuildTime();
        if (r146 == null) goto L128;
        long r214 = r146.longValue();
    L129:
        if (r140 == null) goto L131;
        String r147 = r140.getDescText();
    L132:
        if (r147 != null) goto L134;
        String r215 = "";
    L135:
        if (r140 == null) goto L137;
        String r148 = r140.getDescType();
    L138:
        if (r148 != null) goto L140;
        String r216 = "";
    L141:
        if (r140 == null) goto L143;
        r115 = r140.getDescDetail();
    L143:
        if (r115 != null) goto L145;
        String r217 = "";
    L146:
        r114 = new e5(r211, r124, r210, r141, r212, r213, r136, r214, r215, r216, r217, r108.f471023b);
        goto L147
    L145:
        r217 = r115;
        goto L146
    L140:
        r216 = r148;
        goto L141
    L137:
        r148 = null;
        goto L138
    L134:
        r215 = r147;
        goto L135
    L131:
        r147 = null;
        goto L132
    L128:
        r214 = 0;
        goto L129
    L124:
        r213 = r145;
        goto L125
    L121:
        r145 = null;
        goto L122
    L117:
        r212 = r143;
        goto L118
    L114:
        r143 = null;
        goto L115
    L107:
        r140 = null;
        goto L108
    L61:
        if (r126 >= 3) goto L63;
        r128 = true;
        goto L64
    L51:
        r210 = r125;
        goto L53
    L47:
        r124 = r123;
        goto L48
    L40:
        r120 = r119;
    L147:
        if (r114 != null) goto L162;
        return new x4.b(FailureReason.VERSION_CHECK_FAILED);
    L162:
        return new x4.a(r114);
    L160:
        return x4.c.INSTANCE;
    L159:
        return x4.c.INSTANCE;
    L151:
        return new x4.b(FailureReason.VERSION_CHECK_FAILED);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        g r149 = r310.c();
        if (r149.l() == false) goto L17;
        DoraOTACheckRepository r150 = DoraOTACheckRepository.f337428a;
        String r151 = r149.i();
        String r152 = r149.f();
        String r153 = r310.a().b();
        String r154 = r149.g();
        String r155 = r149.j();
        String r156 = r149.c();
        if (r149.h() != 1) goto L21;
        String r157 = "1";
    L22:
        String r158 = r149.d();
        boolean r159 = r149.e();
        r107 = r310;
        r110.L$0 = r107;
        r110.label = 1;
        r106 = r150.a(r151, r152, r153, r154, r155, r156, r157, r158, r159, false, r110);
        if (r106 != r103) goto L26;
        return r103;
    L21:
        r157 = "0";
        goto L22
    L17:
        return new x4.b(FailureReason.VERSION_CHECK_FAILED);
    L7:
        r100 = new DoraG2LatestSource$check$1(this, r311);
        goto L8
    }
}

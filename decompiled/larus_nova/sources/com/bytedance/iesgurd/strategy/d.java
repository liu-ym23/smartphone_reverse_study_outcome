package com.bytedance.iesgurd.strategy;

import android.content.Context;
import com.alipay.sdk.m.u.i;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import ez5.g;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends dz5.a<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f250859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f250860c;

    @Override // dz5.a
    public final int b() {
        return 7;
    }

    @Override // dz5.a
    public final void a() {
        Iterator r100 = StringsKt.split$default(this.f250859b, new String[]{i.f25853b}, false, 0, 6, null).iterator();
    L4:
        if (r100.hasNext() == false) goto L72;
        String r101 = (String) r100.next();
        String r110 = null;
        if (StringsKt.startsWith$default(r101, "10001", false, 2, null) == false) goto L4;
        int r102 = StringsKt.indexOf$default(r101, "@", 0, false, 6, null);
        if (r102 != (-1)) goto L10;
        e.b("split_error_0", r101, null);
        return;
    L10:
        int r103 = r102 + 1;
        if (r101 == null) goto L60;
        final String r104 = r101.substring(r103);
        String r105 = e.f250861a;
        if (Intrinsics.areEqual(e.f250861a, r104) == false) goto L15;
        return;
    L15:
        e.b("receive_probe_change", r104, e.f250861a);
        String r106 = e.f250861a;
        if (r106 == null) goto L40;
        int r111 = StringsKt.indexOf$default(r106, "@", 0, false, 6, null);
        int r107 = StringsKt.indexOf$default(r104, "@", 0, false, 6, null);
        if (r111 == (-1)) goto L38;
        if (r107 == (-1)) goto L38;
        String r108 = r106.substring(0, r111);     // Catch: NumberFormatException -> L34
        if (r104 == null) goto L31;
        String r109 = r104.substring(0, r107);     // Catch: NumberFormatException -> L32
    L28:
        e = e;
        r110 = r109;
    L33:
        String r112 = r110;
        r110 = r108;
    L36:
        String r113 = e.f250861a;
        e.b("catch_error", r104, e.getMessage());
        GeckoLogger.d("[gecko probe] number format exception,old probe timestamp:" + r110 + ",new probe timestamp:" + r112 + ",url:" + this.f250860c);
        return;
    L25:
        if (CastLongProtector.parseLong(r108) <= CastLongProtector.parseLong(r109)) goto L40;
        e.b("timestamp_error", r104, r108 + '-' + r109);     // Catch: NumberFormatException -> L28
        return;
    L31:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: NumberFormatException -> L32
    L32:
        e = e;
    L34:
        e = e;
        r112 = null;
    L38:
        e.b("split_error", r104, e.f250861a);
        return;
    L40:
        GeckoLogger.d("[gecko probe] old probe:" + e.f250861a + ",new probe:" + r104 + ",url:" + this.f250860c);
        boolean r114 = false;
        if (StringsKt.indexOf$default(r104, "@", 0, false, 6, null) != (-1)) goto L43;
        e.b("split_error_1", r104, null);
    L54:
        if (r114 == false) goto L70;
        e.f250861a = r104;
        g r115 = g.a.f474886a;
        Context r116 = e.f250862b;
        if (r116 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L58:
        r115.c(r116, "tlb_probe", r104);
        return;
    L70:
        return;
    L43:
        String r117 = (String) ListProtector.get(StringsKt.split$default(r104, new String[]{"@"}, false, 0, 6, null), 1);
        int r118 = r117.hashCode();
        if (r118 == 49) goto L52;
        if (r118 != 50) goto L54;
        if (r117.equals("2") == false) goto L54;
        r114 = e.a(r104, new ProbeManager$executeProbeTask$2(r104));
        goto L54
    L52:
        if (r117.equals("1") == false) goto L54;
        r114 = e.a(r104, new ProbeManager$executeProbeTask$1(r104));
        goto L54
    L60:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public d(String r100, String r101) {
        this.f250859b = r100;
        this.f250860c = r101;
    }
}

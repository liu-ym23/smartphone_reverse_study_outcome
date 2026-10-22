package com.larus.dora.impl.core.settingsconfig;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.news.common.settings.SettingsManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.j;
import com.larus.dora.impl.settings.r;
import com.larus.settings.value.e10;
import com.larus.utils.l0;
import g49.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import mj4.f;
import nu9.a0;
import nu9.b0;
import nu9.o;
import nu9.q;
import ouc.w;
import pk4.n;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraSettingsConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraSettingsConfigManager f332259a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f332260b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f332261c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f332262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f332263e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DoraSettingsConfigManager$doraLinkCallback$1 f332264f = null;

    public DoraSettingsConfigManager() {
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.dora.impl.core.settingsconfig.b] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.dora.impl.core.settingsconfig.DoraSettingsConfigManager$doraLinkCallback$1] */
    static {
        f332259a = new DoraSettingsConfigManager();
        f332260b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f332261c = LazyKt.lazy(new a());
        f332263e = new b();
        f332264f = new DoraSettingsConfigManager$doraLinkCallback$1();
    }

    public static void b() {
        kj4.a.g().registerDoraLinkCallback(f332264f);
        CoroutineScope r100 = f332260b;
        f332262d = BuildersKt.launch$default(r100, null, null, new DoraSettingsConfigManager$init$1(null), 3, null);
        e10 r101 = e10.f368561a;
        e(e10.Q(), "init");
        boolean r102 = true;
        SettingsManager.registerListener(f332263e, true);
        BuildersKt.launch$default(r100, null, null, new DoraSettingsConfigManager$initDoraSettingsConfigAsync$1(null), 3, null);
        DoraSetting.f338023a.getClass();
        String r103 = (String) l0.a("", new j());
        if (StringsKt.isBlank(r103) == false) goto L5;
        d.d("DoraSettingsConfigManager", "updateKmpConfigIfNeed: skip empty config");
        return;
    L5:
        List<DoraDevice> r104 = kj4.a.g().getDoraBindList();
        if (r104 != null) goto L8;
    L40:
        d.d("DoraSettingsConfigManager", "updateKmpConfigIfNeed: config updated = " + r103);
        return;
    L8:
        if (r104.isEmpty() == true) goto L40;
        el4.a r105 = com.bytedance.dorax.kmp.c.f204762a;
        Intrinsics.checkNotNullParameter(r103, "jsonString");
        fl4.a.C5923a r106 = fl4.a.f477732a;
        kl4.c r107 = new kl4.c();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "registry");
        if (fl4.a.C5923a.f477735c == null) goto L14;
        int r108 = ll4.a.f509676a;
        Intrinsics.checkNotNullParameter("DoraKMPAdapter", "tag");
        Intrinsics.checkNotNullParameter("init called repeatedly, ignore duplicate initialization", "message");
        kl4.j r109 = ll4.a.a();
        if (r109 == null) goto L25;
        r109.w("init called repeatedly, ignore duplicate initialization");
    L25:
        ll4.a.b("DoraNativeInterop", "initDoraKMPAdapter finished");
        ll4.a.b("DoraNativeInterop", "updateKmpConfig called with: " + r103);
        com.bytedance.dorax.kmp.c.f204762a = (el4.a) w.a(new com.bytedance.dorax.kmp.a()).c(el4.a.Companion.serializer(), r103);     // Catch: Exception -> L34
        ll4.a.b("DoraNativeInterop", "KMP Config updated: " + com.bytedance.dorax.kmp.c.f204762a);     // Catch: Exception -> L34
        if (com.bytedance.dorax.kmp.c.f204762a.f473010a == 1) goto L30;
        r102 = false;
    L30:
        if (r102 == false) goto L32;
        ll4.a.b("DoraNativeInterop", "KMP is enabled");     // Catch: Exception -> L34
    L44:
        goto L40
    L32:
        ll4.a.b("DoraNativeInterop", "KMP is disabled");     // Catch: Exception -> L34
    L34:
        e = move-exception;
        int r110 = ll4.a.f509676a;
        String r111 = "Parse KMP config error: " + e.getMessage();
        Intrinsics.checkNotNullParameter("DoraNativeInterop", "tag");
        Intrinsics.checkNotNullParameter(r111, "message");
        kl4.j r112 = ll4.a.a();
        if (r112 == null) goto L40;
        r112.e(r111, e);
        goto L40
    L14:
        jl4.a r113 = fl4.a.C5923a.f477736d;
        r113.f499528a.lock();
    L21:
        th = move-exception;
        r113.f499528a.unlock();
        throw th;
    L16:
        if (fl4.a.C5923a.f477735c != null) goto L18;
        fl4.a.C5923a.f477734b = r107;     // Catch: Throwable -> L21
        fl4.a.C5923a.f477735c = new gl4.a();     // Catch: Throwable -> L21
        int r114 = ll4.a.f509676a;     // Catch: Throwable -> L21
        ll4.a.b("DoraKMPAdapter", "instance initialized: " + fl4.a.C5923a.f477735c);     // Catch: Throwable -> L21
    L23:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r113.f499528a.unlock();
        goto L25
    L18:
        int r116 = ll4.a.f509676a;     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter("DoraKMPAdapter", "tag");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter("init called repeatedly after lock, ignore duplicate initialization", "message");     // Catch: Throwable -> L21
        kl4.j r117 = ll4.a.a();     // Catch: Throwable -> L21
        if (r117 == null) goto L23;
        r117.w("init called repeatedly after lock, ignore duplicate initialization");     // Catch: Throwable -> L21
        goto L23
    }

    public static kk4.b a(o r100) {
        nu9.a r101 = r100.a();
        kk4.b.e r102 = null;
        if (r101 == null) goto L5;
        nu9.b r103 = r101.a();
        if (r103 == null) goto L15;
        a0 r104 = r103.a();
        if (r104 == null) goto L15;
        Boolean r105 = r104.a();
        List<String> r106 = r104.b();
        if (r106 == null) goto L13;
        List r107 = CollectionsKt.filterNotNull(r106);
    L14:
        kk4.b.d r108 = new kk4.b.d(r105, r107);
    L16:
        q r109 = r101.b();
        if (r109 == null) goto L22;
        b0 r110 = r109.b();
        if (r110 == null) goto L22;
        r102 = new kk4.b.e(r110.c(), r110.d(), r110.e(), r110.b(), r110.a());
    L22:
        return new kk4.b(new kk4.b.a(new kk4.b.C6566b(r108), new kk4.b.c(r102)));
    L13:
        r107 = null;
    L15:
        r108 = null;
        goto L16
    L5:
        return new kk4.b(null);
    }

    public static void c(DoraDevice r100) {
        if (r100 != null) goto L6;
        r100 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        d.c("DoraSettingsConfigManager", "syncDmsAudioPreprocessIfNeed: exception", th);
        return;
    L6:
        if (r100 != null) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L20;
        if (r100 != null) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == true) goto L20;
        boolean r103 = false;
    L21:
        if (r103 == true) goto L23;
        return;
    L23:
        DoraSetting.f338023a.getClass();     // Catch: Throwable -> L29
        int r104 = l0.f375430a;     // Catch: Throwable -> L29
        boolean r105 = ((Boolean) l0.a(Boolean.FALSE, new r())).booleanValue();     // Catch: Throwable -> L29
        ak4.a r106 = kj4.a.g().f503708c.f514229d;     // Catch: Throwable -> L29
        byte[] r107 = new byte[3];     // Catch: Throwable -> L29
        r107[0] = 36;     // Catch: Throwable -> L29
        r107[1] = 1;     // Catch: Throwable -> L29
        if (r105 == false) goto L26;
        int r108 = 2;
    L27:
        r107[2] = (byte) r108;     // Catch: Throwable -> L29
        r106.i(1, 4, r107);     // Catch: Throwable -> L29
        d.d("DoraSettingsConfigManager", "syncDmsAudioPreprocessIfNeed: enabled = " + r105);     // Catch: Throwable -> L29
        return;
    L26:
        r108 = 1;
        goto L27
    L14:
        if (r100.productId != 0) goto L16;
        r102 = true;
    L20:
        r103 = true;
        goto L21
    L8:
        if (r100.productId != ProductNameType.DORA_LITE.f204375id) goto L10;
        r101 = true;
        goto L11
    }

    public static void e(o r110, String r111) {
        nu9.a r100 = r110.a();
        if (r100 != null) goto L5;
        String r101 = "android=absent";
    L65:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L56
        kj4.a r103 = kj4.a.g();     // Catch: Throwable -> L56
        kk4.b r112 = a(r110);     // Catch: Throwable -> L56
        r103.getClass();     // Catch: Throwable -> L56
        kj4.a.F(r112);     // Catch: Throwable -> L56
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L59:
        if (Result.m9456isSuccessimpl(r113) == false) goto L61;
        Unit r104 = (Unit) r113;
        d.d("DoraSettingsConfigManager", "updateDoraXLinkCommonConfig dispatched: source=" + r111 + ", hostConfig=[" + r101 + ']');
    L61:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L67;
        d.c("DoraSettingsConfigManager", "updateDoraXLinkCommonConfig: source=" + r111 + ", hostConfig=[" + r101 + ']', r114);
        return;
    L67:
        return;
    L56:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L59
    L5:
        nu9.b r106 = r100.a();
        b0 r107 = null;
        if (r106 == null) goto L8;
        a0 r108 = r106.a();
    L9:
        q r109 = r100.b();
        if (r109 == null) goto L12;
        r107 = r109.b();
    L12:
        String r115 = "absent";
        if (r108 == null) goto L21;
        List<String> r116 = r108.b();
        if (r116 == null) goto L21;
        List r117 = CollectionsKt.filterNotNull(r116);
        if (r117 == null) goto L21;
        String r118 = CollectionsKt.joinToString$default(r117, null, "[", "]", 0, null, null, 57, null);
        if (r118 == null) goto L21;
    L22:
        StringBuilder r119 = new StringBuilder("rtcEnabled=");
        if (r108 == null) goto L26;
        Object r120 = r108.a();
        if (r120 == null) goto L26;
    L27:
        r119.append(r120);
        r119.append(", supportLinks=");
        r119.append(r118);
        r119.append(", videoStreamingEnabled=");
        if (r107 == null) goto L31;
        Object r121 = r107.c();
        if (r121 == null) goto L31;
    L32:
        r119.append(r121);
        r119.append(", showEntrance=");
        if (r107 == null) goto L36;
        Object r122 = r107.d();
        if (r122 == null) goto L36;
    L37:
        r119.append(r122);
        r119.append(", transport=");
        if (r107 == null) goto L41;
        String r123 = r107.e();
        if (r123 == null) goto L41;
    L42:
        r119.append(r123);
        r119.append(", controlMode=");
        if (r107 == null) goto L46;
        String r124 = r107.b();
        if (r124 == null) goto L46;
    L47:
        r119.append(r124);
        r119.append(", activeLink=");
        if (r107 == null) goto L53;
        String r125 = r107.a();
        if (r125 == null) goto L53;
        r115 = r125;
    L53:
        r119.append(r115);
        r101 = r119.toString();
    L46:
        r124 = "absent";
    L41:
        r123 = "absent";
    L36:
        r122 = "absent";
    L31:
        r121 = "absent";
    L26:
        r120 = "absent";
    L21:
        r118 = "absent";
        goto L22
    L8:
        r108 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, byte] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0096 -> B:32:0x0099). Please report as a decompilation issue!!! */
    public final Object d(DoraDevice r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof DoraSettingsConfigManager$syncVolumeSettingsConfigIfNeed$1) == false) goto L7;
        DoraSettingsConfigManager$syncVolumeSettingsConfigIfNeed$1 r100 = (DoraSettingsConfigManager$syncVolumeSettingsConfigIfNeed$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 3;
        boolean r106 = false;
        int r107 = 0;
        Byte r108 = null;
        boolean r109 = true;
        ?? r110 = 1;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        int r111 = r100.I$0;
        DoraVolumeAdaptationConfig r112 = (DoraVolumeAdaptationConfig) r100.L$1;
        ArrayList r113 = (ArrayList) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L54
    L32:
        kj4.a r114 = kj4.a.g();     // Catch: Throwable -> L54
        Float r115 = r112.getMaxGain();     // Catch: Throwable -> L54
        Integer r116 = r112.getMaxVolumeLevelRange();     // Catch: Throwable -> L54
        if (r116 == null) goto L35;
        Byte r117 = Boxing.boxByte((byte) r116.intValue());     // Catch: Throwable -> L54
    L36:
        Float r118 = r112.getMaxIncDb();     // Catch: Throwable -> L54
        Float r119 = r112.getMaxDecDb();     // Catch: Throwable -> L54
        Boolean r120 = r112.getDefaultState();     // Catch: Throwable -> L54
        if (Intrinsics.areEqual(r120, Boxing.boxBoolean(r110)) == false) goto L40;
        Byte r121 = Boxing.boxByte(r110);     // Catch: Throwable -> L54
    L43:
        f r122 = r114.f503708c;     // Catch: Throwable -> L54
        r122.getClass();     // Catch: Throwable -> L54
        byte[] r123 = new byte[r107];     // Catch: Throwable -> L54
        if (r115 == null) goto L46;
        r123 = n.u(r123, n.u(new byte[]{2, 4}, n.j(r115.floatValue())));     // Catch: Throwable -> L54
    L46:
        if (r117 == null) goto L48;
        r123 = n.u(r123, new byte[]{3, 1, r117.byteValue()});     // Catch: Throwable -> L54
    L48:
        if (r118 == null) goto L50;
        r123 = n.u(r123, n.u(new byte[]{4, 4}, n.j(r118.floatValue())));     // Catch: Throwable -> L54
    L50:
        if (r119 == null) goto L52;
        r123 = n.u(r123, n.u(new byte[]{5, 4}, n.j(r119.floatValue())));     // Catch: Throwable -> L54
    L52:
        if (r121 == null) goto L57;
        r123 = n.u(r123, new byte[]{6, 1, r121.byteValue()});     // Catch: Throwable -> L54
    L57:
        int r124 = r122.f514229d.i(1, 5, r123);     // Catch: Throwable -> L54
        r113.add(Boxing.boxInt(r124));     // Catch: Throwable -> L54
        if (r124 == 0) goto L61;
        r111 = r111 + 1;     // Catch: Throwable -> L54
        r105 = 3;
        r106 = false;
        r108 = null;
        r109 = true;
    L28:
        if (r111 >= r105) goto L61;
        r100.L$0 = r113;     // Catch: Throwable -> L54
        r100.L$1 = r112;     // Catch: Throwable -> L54
        r100.I$0 = r111;     // Catch: Throwable -> L54
        r100.label = r109 ? 1 : 0;     // Catch: Throwable -> L54
        r107 = r106;
        r110 = r109;
        if (DelayKt.delay(1000, r100) != r103) goto L32;
        return r103;
    L61:
        DoraVolumeAdaptationConfig r125 = r112;
        ArrayList r126 = r113;
    L62:
        d.d("DoraSettingsConfigManager", "syncVolumeSettingsConfigIfNeed: " + r125 + " ret=[" + CollectionsKt.joinToString$default(r126, null, null, null, 0, null, null, 63, null) + ']');     // Catch: Throwable -> L54
    L66:
        return Unit.INSTANCE;
    L40:
        if (Intrinsics.areEqual(r120, Boxing.boxBoolean(r107)) == false) goto L42;
        r121 = Boxing.boxByte(r107);     // Catch: Throwable -> L54
        goto L43
    L42:
        r121 = null;
        goto L43
    L35:
        r117 = r108;
        goto L36
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
        if (r210 != null) goto L19;
        DoraDevice r127 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L54
    L20:
        if (r127 == null) goto L66;
        if (((Boolean) f332261c.getValue()).booleanValue() == false) goto L66;
        if (o59.a.w(r127) == false) goto L66;
        r126 = new ArrayList();     // Catch: Throwable -> L54
        DoraSetting.f338023a.getClass();     // Catch: Throwable -> L54
        r125 = (DoraVolumeAdaptationConfig) l0.a(null, new com.larus.dora.impl.settings.n());     // Catch: Throwable -> L54
        if (r125 == null) goto L62;
        r113 = r126;
        r112 = r125;
        r111 = 0;
        goto L28
    L19:
        r127 = r210;
    L54:
        th = move-exception;
        d.c("DoraSettingsConfigManager", "syncVolumeSettingsConfigIfNeed: exception", th);
    L7:
        r100 = new DoraSettingsConfigManager$syncVolumeSettingsConfigIfNeed$1(this, r211);
        goto L8
    }
}

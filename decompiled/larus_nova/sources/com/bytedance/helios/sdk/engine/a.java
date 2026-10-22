package com.bytedance.helios.sdk.engine;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import gz5.y;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements jz5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f245563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<lz5.a> f245564b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<jz5.b>> f245565c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f245566d = null;

    public a() {
    }

    @Override // jz5.b
    public final String type() {
        return "both_engine";
    }

    static {
        f245566d = new a();
        f245564b = CollectionsKt.mutableListOf(new lz5.a[]{c06.a.f21944b, c06.b.f21946b, c06.c.f21948b});
        ConcurrentHashMap<String, List<jz5.b>> r100 = new ConcurrentHashMap();
        f245565c = r100;
        i r101 = i.f245571a;
        r100.put("rule_engine", ArraysKt.asList(new jz5.b[]{r101}));
        LegacyEngineManager r102 = LegacyEngineManager.f245562d;
        r100.put("legacy_engine", ArraysKt.asList(new jz5.b[]{r102}));
        r100.put("both_engine", ArraysKt.asList(new jz5.b[]{r102, r101}));
    }

    @Override // gz5.a.InterfaceC6085a
    public final void onNewSettings(y r100) {
        String r101 = HeliosEnvImpl.get().f245470m.o();
        List<jz5.b> r102 = f245565c.get(r101);
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((jz5.b) r103.next()).onNewSettings(r100);
        f245563a = true;
        goto L6
    L10:
        return;
    }

    @Override // jz5.b
    public final boolean a(PrivacyEvent r110, boolean r111) {
        if (f245563a == true) goto L5;
        return false;
    L5:
        String r100 = HeliosEnvImpl.get().f245470m.o();
        List<jz5.b> r101 = f245565c.get(r100);
        if (r101 == null) goto L30;
        Iterator<T> r102 = r101.iterator();
        boolean r103 = false;
    L9:
        if (r102.hasNext() == false) goto L26;
        jz5.b r104 = (jz5.b) r102.next();
        long r105 = System.currentTimeMillis();
        if (r104.a(r110, r111) == true) goto L15;
        if (r103 == true) goto L15;
        r103 = false;
    L16:
        StringBuilder r106 = new StringBuilder();
        if (Intrinsics.areEqual(r104.type(), "rule_engine") == false) goto L19;
        String r107 = com.heytap.mcssdk.constant.b.f276366p;
    L20:
        r106.append(r107);
        if (r111 == false) goto L23;
        String r108 = FaceService.girlLabel;
    L24:
        r106.append(r108);
        r106.append("EngineExecute");
        rz5.a.a(r106.toString(), r105, true);
        goto L9
    L23:
        r108 = "G";
        goto L24
    L19:
        r107 = "legacy";
    L15:
        r103 = true;
        goto L16
    L26:
        return r103;
    L30:
        return false;
    }
}

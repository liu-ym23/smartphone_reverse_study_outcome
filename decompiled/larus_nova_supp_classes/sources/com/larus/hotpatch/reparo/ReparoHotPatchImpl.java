package com.larus.hotpatch.reparo;

import android.util.EventsUtils;
import c97.h;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.reparo.core.o;
import com.bytedance.reparo.g;
import com.larus.apm.api.IApmTrace;
import com.larus.common.apphost.AppHost;
import com.larus.hotpatch.IHotPatch;
import com.larus.settings.value.e10;
import com.larus.settings.value.o00;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import qt9.t3;
import rc9.a;
import rc9.b;
import rc9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/hotpatch/reparo/ReparoHotPatchImpl;", "Lcom/larus/hotpatch/IHotPatch;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "KEY_HOTFIX_REALTIME_FETCH", "VALUE_TRUE", "VALUE_FALSE", "hotPatchConfig", "Lcom/larus/hotpatch/reparo/HotPatchConfig;", "settingListenerRegistered", XmlPullParser.NO_NAMESPACE, "init", XmlPullParser.NO_NAMESPACE, "initFlipped", "config", "Lcom/larus/hotpatch/IHotPatchConfig;", "loadRemotePatch", "autoLoadRemotePatchBySettingIfNeeded", "shouldTryToLoadRemotePatch", "autoLoadRemotePatchBySettingIfNeededInner", "listenSettingUpdate", "reparo-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ReparoHotPatchImpl implements IHotPatch {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final a e;
    public boolean f;

    @Override // com.larus.hotpatch.IHotPatch
    public final void b() {
        t0.b(new b(this), 10000);
    }

    public final void d() {
    L8:
        e = move-exception;
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L6
        r4.e(this.a, "autoLoadRemotePatchBySettingIfNeeded error", e);     // Catch: Throwable -> L6
        IApmTrace.Companion r3 = IApmTrace.a;     // Catch: Throwable -> L6
        String r5 = this.b;     // Catch: Throwable -> L6
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L6
        r6.put("result", this.d);     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r3.f(r5, r6, null, null);     // Catch: Throwable -> L6
        g r1 = g.a();
        this.e.getClass();
        long r2 = a.c();
        r1.getClass();
        g.k = r2;
        r4.i(this.a, "autoLoadRemotePatchBySettingIfNeededInner finish");
        return;
    L4:
        if (e() == false) goto L10;
        FLogger r7 = FLogger.a;     // Catch: Throwable -> L6 Exception -> L8
        r7.i(this.a, "autoLoadRemotePatchBySettingIfNeededInner start");     // Catch: Throwable -> L6 Exception -> L8
        g.a().getClass();     // Catch: Throwable -> L6 Exception -> L8
        g.k = 0;     // Catch: Throwable -> L6 Exception -> L8
        g.a().e();     // Catch: Throwable -> L6 Exception -> L8
        IApmTrace.Companion r8 = IApmTrace.a;     // Catch: Throwable -> L6 Exception -> L8
        String r9 = this.b;     // Catch: Throwable -> L6 Exception -> L8
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L6 Exception -> L8
        r10.put("result", this.c);     // Catch: Throwable -> L6 Exception -> L8
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L6 Exception -> L8
        r8.f(r9, r10, null, null);     // Catch: Throwable -> L6 Exception -> L8
        r7.i(this.a, "REPARO HOTFIX trigger loadRemotePatch by Setting!");     // Catch: Throwable -> L6 Exception -> L8
        r7.i(this.a, "autoLoadRemotePatchBySettingIfNeededInner loadRemotePatch by Setting executed!");     // Catch: Throwable -> L6 Exception -> L8
    L11:
        g r12 = g.a();
        this.e.getClass();
        long r13 = a.c();
        r12.getClass();
        g.k = r13;
        FLogger.a.i(this.a, "autoLoadRemotePatchBySettingIfNeededInner finish");
        return;
    L10:
        FLogger.a.i(this.a, "autoLoadRemotePatchBySettingIfNeededInner UNNECESSARY!");     // Catch: Throwable -> L6 Exception -> L8
    L6:
        th = move-exception;
        g r14 = g.a();
        this.e.getClass();
        long r15 = a.c();
        r14.getClass();
        g.k = r15;
        FLogger.a.i(this.a, "autoLoadRemotePatchBySettingIfNeededInner finish");
        throw th;
    }

    public final boolean e() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        List r2 = null;
        t3 r3 = (t3) l0.a(new t3(null), new o00());
        AppHost.Companion r4 = AppHost.a;
        long r5 = r4.getUpdateVersionCode();
        Long r6 = r3.b();
        if (r6 != null) goto L6;
    L7:
        FLogger.a.w(this.a, "shouldTryToLoadRemotePatch updateVersionCode NOT MATCH!!! AppHost.updateVersionCode = " + r4.getUpdateVersionCode() + ",  proactiveFetchPatchConfig.updateVersionCode = " + r3.b());
        return false;
    L6:
        if (r5 != r6.longValue()) goto L7;
        List r7 = r3.a();
        if (r7 == null) goto L12;
        r2 = CollectionsKt.filterNotNull(r7);
    L12:
        if (r2 != null) goto L14;
    L32:
        FLogger.a.w(this.a, "shouldTryToLoadRemotePatch patchIdList is empty!!! proactiveFetchPatchConfig.patchIdList = " + r3.a());
        return false;
    L14:
        if (r2.isEmpty() == true) goto L32;
        FLogger r8 = FLogger.a;
        r8.i(this.a, "shouldTryToLoadRemotePatch patchIdList = " + r2);
        Set r9 = ((ConcurrentHashMap) o.c().e()).keySet();
        r8.i(this.a, "shouldTryToLoadRemotePatch localPatchesMapKeys = " + r9);
        Iterator r10 = r2.iterator();
    L18:
        if (r10.hasNext() == false) goto L31;
        String r11 = (String) r10.next();
        Iterator r12 = r9.iterator();
    L21:
        if (r12.hasNext() == false) goto L27;
        h r13 = (h) r12.next();
        if (r13 == null) goto L21;
        if (Intrinsics.areEqual(r13.j, r11) == false) goto L21;
        boolean r14 = true;
    L28:
        if (r14 == true) goto L18;
        FLogger.a.i(this.a, "shouldTryToLoadRemotePatch patchShouldUpdate = " + r11 + " NOT FOUND IN localPatchesMap");
        return true;
    L27:
        r14 = false;
        goto L28
    L31:
        return false;
    }

    @Override // com.larus.hotpatch.IHotPatch
    public final void init() {
        a r0 = this.e;
        Intrinsics.checkNotNullParameter(r0, "config");
        g.a().b(new d(r0));
        FLogger.a.i(this.a, "REPARO HOTFIX INITED!");
    }

    public ReparoHotPatchImpl() {
        this.a = "ReparoHotPatch";
        this.b = "hotfix_realtime_fetch";
        this.c = "1";
        this.d = MiraMonitor.VALUE_DEFAULT;
        this.e = new a(AppHost.a.getApplication());
    }

    @Override // com.larus.hotpatch.IHotPatch
    public final void a() {
        g r0 = g.a();
        this.e.getClass();
        long r1 = a.c();
        r0.getClass();
        g.k = r1;
        g.a().e();
        this.e.a.registerActivityLifecycleCallbacks(new a());
        FLogger.a.i(this.a, "REPARO HOTFIX trigger loadRemotePatch!");
    }

    @Override // com.larus.hotpatch.IHotPatch
    public final void c() {
        Flipped.invokeHiddenApiRestrictions();
    }
}

package com.ss.ugc.clientai.core.api;

import alc.c;
import alc.d;
import com.alipay.sdk.m.p.e;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 22\u00020\u0001:\u000234B\u000f\u0012\u0006\u0010,\u001a\u00020\r¢\u0006\u0004\b0\u00101J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001b0!j\b\u0012\u0004\u0012\u00020\u001b`\"8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartService;", "", "Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;", "config", "", "configService", "", "enable", "isEnvReady", "preloadEnv", "ensureReady", "Lcom/ss/ugc/clientai/core/api/SmartOutputData;", "lastResult", "", e.f25671s, "Lalc/d;", "params", "callExtMethod", "Lcom/ss/ugc/clientai/core/api/SmartInputData;", "extInputs", "runSync", "", "delayMs", "Lcom/ss/ugc/clientai/core/api/SmartService$a;", "callback", "runAsyncDelay", "runAsync", "Lalc/c;", "listener", "addResultChangedListener", "removeResultChangedListener", OnekeyLoginConstants.CU_KEY_RESULT_DATA, "notifyResultChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listeners", "Ljava/util/ArrayList;", "getListeners", "()Ljava/util/ArrayList;", "Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;", "getConfig", "()Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;", "setConfig", "(Lcom/ss/ugc/clientai/core/api/SmartServiceConfig;)V", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "core-api_release"}, k = 1, mv = {1, 4, 1})
public abstract class SmartService {
    public static final b Companion = null;
    private SmartServiceConfig config;
    private final ArrayList<c> listeners;
    private final String name;

    public interface a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public d callExtMethod(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        return null;
    }

    public abstract boolean enable();

    public boolean isEnvReady() {
        return true;
    }

    public abstract SmartOutputData lastResult();

    public void preloadEnv() {
    }

    public void runAsyncDelay(long r100, SmartInputData r101, a r102) {
    }

    public SmartOutputData runSync(SmartInputData r100) {
        return null;
    }

    public boolean ensureReady() {
        if (isEnvReady() == false) goto L6;
        return true;
    L6:
        preloadEnv();
        return isEnvReady();
    }

    public final SmartServiceConfig getConfig() {
        return this.config;
    }

    public final ArrayList<c> getListeners() {
        return this.listeners;
    }

    public final String getName() {
        return this.name;
    }

    public SmartService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
        this.listeners = new ArrayList();
    }

    public void addResultChangedListener(c r100) {
        if (r100 == null) goto L14;
        ArrayList<c> r101 = this.listeners;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (this.listeners.contains(r100) == true) goto L8;
        this.listeners.add(r100);     // Catch: Throwable -> L11
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    }

    public void configService(SmartServiceConfig r100) {
        this.config = r100;
    }

    public void notifyResultChanged(SmartOutputData r100) {
        if ((!this.listeners.isEmpty()) == false) goto L15;
        ArrayList<c> r101 = this.listeners;
        monitor-enter(r101);
        ArrayList r102 = new ArrayList(this.listeners);     // Catch: Throwable -> L12
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        Iterator r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L19;
        ((c) r104.next()).a();
        goto L10
    L19:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void removeResultChangedListener(c r100) {
        if (r100 == null) goto L11;
        ArrayList<c> r101 = this.listeners;
        monitor-enter(r101);
        this.listeners.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void setConfig(SmartServiceConfig r100) {
        this.config = r100;
    }

    public final void runAsync(SmartInputData r100, a r101) {
        runAsyncDelay(0, r100, r101);
    }

    public static /* synthetic */ d callExtMethod$default(SmartService r100, String r101, d r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = null;
    L7:
        return r100.callExtMethod(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callExtMethod");
    }
}

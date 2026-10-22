package com.obric.assistant.wakeup.statistics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.session.lifecycle.f;
import com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0019\u001a\u00020\u00182\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\bH\u0016J$\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\bH\u0002R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/impl/WakeupStatisticsImpl;", "Lcom/obric/assistant/wakeup/statistics/api/IWakeupStatisticsAPI;", "<init>", "()V", "mWakeupDuration", "", "Landroid/util/Pair;", "", "", "mStartTime", "getMStartTime", "()J", "setMStartTime", "(J)V", "mEndTime", "getMEndTime", "setMEndTime", "mBundle", "Landroid/os/Bundle;", "sWorkHandler", "Landroid/os/Handler;", "mUploader", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "init", "uploader", MapMonitorConst.EVENT_DESTROY, "setBundle", "bundle", "onEvent", "event", "end", "", "time", "clear", "setStartTime", "insertTimeTrace", "name", SVGRenderEngine.SAVE, "transferToCloud", "getLastTraceTime", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupStatisticsImpl implements IWakeupStatisticsAPI {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f394487g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<String, Long>> f394488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f394489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f394490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f394491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f394492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function2<? super String, ? super JSONObject, Unit> f394493f;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void destroy() {
        this.f394493f = null;
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void clear() {
        ((ArrayList) this.f394488a).clear();
    }

    public WakeupStatisticsImpl() {
        this.f394488a = new ArrayList();
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "uploader");
        FLogger.f375446a.i("WakeupDuration/S3", "init with uploader " + r100);
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("WakeupDuration/S3");
        ThreadMethodProxy.start(r101);
        this.f394492e = new Handler(r101.getLooper());
        this.f394493f = r100;
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void setBundle(Bundle r100) {
        this.f394491d = r100;
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void setStartTime(long r100) {
        this.f394489b = r100;
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI
    public final void b(final String r100, final boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 == false) goto L8;
        if (((ArrayList) this.f394488a).isEmpty() == false) goto L8;
        return;
    L8:
        if (r102 != 0) goto L11;
        r102 = System.currentTimeMillis();
    L11:
        final long r103 = r102;
        Handler r104 = this.f394492e;
        if (r104 == null) goto L15;
        r104.post(new com.obric.assistant.wakeup.statistics.impl.a(r101, this, r100, r103));
        return;
    }
}

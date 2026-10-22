package com.ss.android.lark.officesdk.feed.impl;

import android.app.Application;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.PushLatestDoubaoIMFeatureOpened;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import e0c.k;
import f0c.h;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class a extends c0c.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f433213k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f433214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f433215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f433216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f433217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f433218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f433219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f433220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FlowFeedApiProxy f433221j;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.feed.impl.a$a, reason: collision with other inner class name */
    public static final class C5152a {
    }

    static {
    }

    @Override // c0c.c
    public final void d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Object r101 = this.f433216e;
        monitor-enter(r101);
        this.f433217f.incrementAndGet();     // Catch: Throwable -> L11
        this.f433219h = null;     // Catch: Throwable -> L11
        Disposable r102 = this.f433220i;     // Catch: Throwable -> L11
        if (r102 == null) goto L7;
        r102.dispose();     // Catch: Throwable -> L11
    L7:
        this.f433220i = null;     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        CoroutineScopeKt.cancel$default(this.f433218g, null, 1, null);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // c0c.c
    public final void i(h r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        Intrinsics.checkNotNullParameter(r110, "state");
        stb.a r100 = (stb.a) k.a(this.f433215d, stb.a.class);     // Catch: Throwable -> L5
    L7:
        if (r100 == null) goto L11;
        String r101 = r100.a();
        if (r101 == null) goto L11;
        final String r102 = StringsKt.trim(r101).toString();
    L12:
        if (r102 != null) goto L15;
        r102 = "";
    L15:
        if (r102.length() != 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
        Log.w("DoubaoIMFeatureSyncer", "start sync skipped: user id is empty");
        return;
    L20:
        this.f433221j.K(r102);
        Log.i("DoubaoIMFeatureSyncer", "start sync");
        Ref.LongRef r104 = new Ref.LongRef();
        Object r105 = this.f433216e;
        monitor-enter(r105);
    L36:
        th = move-exception;
        throw th;
    L23:
        if (Intrinsics.areEqual(this.f433219h, r102) == true) goto L25;
    L29:
        Disposable r106 = this.f433220i;     // Catch: Throwable -> L36
        if (r106 == null) goto L32;
        r106.dispose();     // Catch: Throwable -> L36
    L32:
        this.f433219h = r102;     // Catch: Throwable -> L36
        final long r107 = this.f433217f.incrementAndGet();     // Catch: Throwable -> L36
        r104.element = r107;     // Catch: Throwable -> L36
        this.f433220i = t.g(this.f433214c.i(Command.PUSH_DOUBAO_IM_FEATURE_OPENED, PushLatestDoubaoIMFeatureOpened.ADAPTER), new DoubaoIMFeatureOpenedSyncer$subscribePush$1(this, r102, r107), DoubaoIMFeatureOpenedSyncer$subscribePush$2.INSTANCE);     // Catch: Throwable -> L36
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r105);
        BuildersKt.launch$default(this.f433218g, null, null, new DoubaoIMFeatureOpenedSyncer$startSync$2(this, r102, r104, null), 3, null);
        return;
    L25:
        if (this.f433220i == null) goto L29;
        Log.i("DoubaoIMFeatureSyncer", "startSync push return");     // Catch: Throwable -> L36
        monitor-exit(r105);
        return;
    L17:
        r103 = false;
    L11:
        r102 = null;
    L5:
        th = move-exception;
        Log.e("DoubaoIMFeatureSyncer", "resolve IOfficeSDKUserApi failed", th);
        r100 = null;
        goto L7
    }

    @Inject
    public a(l r100, Application r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        Intrinsics.checkNotNullParameter(r101, "application");
        Intrinsics.checkNotNullParameter(r102, "passport");
        super(r102);
        this.f433214c = r100;
        this.f433215d = r101;
        this.f433216e = new Object();
        this.f433217f = new AtomicLong(0);
        this.f433218g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f433221j = new FlowFeedApiProxy();
    }

    public final void m(String r100, long r101, Boolean r102, Long r103, String r110) {
        if (r102 == null) goto L21;
        if (r103 == null) goto L21;
        Log.i("DoubaoIMFeatureSyncer", "persist IM feature update open=" + r102 + ", currentGeneration=" + r101 + ", updateTimestampMs=" + r103 + ", source=" + r110);
        Object r104 = this.f433216e;
        monitor-enter(r104);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (Intrinsics.areEqual(this.f433219h, r100) == true) goto L10;
    L15:
        Log.w("DoubaoIMFeatureSyncer", "data not match, not updated");     // Catch: Throwable -> L18
        monitor-exit(r104);
        return;
    L10:
        if (this.f433217f.get() != r101) goto L15;
        Log.i("DoubaoIMFeatureSyncer", r110 + " host update accepted=" + this.f433221j.X1(r100, r102.booleanValue(), r103.longValue()));     // Catch: Throwable -> L18
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r104);
        return;
    L21:
        Log.w("DoubaoIMFeatureSyncer", "ignore " + r110 + " without value or timestamp");
    }
}

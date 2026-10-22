package com.bytedance.sdk.xbridge.cn.platform.lynx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class LynxBDXBridge extends BDXBridge<ReadableMap, Object> implements ue7.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f269959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f269960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f269961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f269962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f269963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashSet<String> f269964p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<com.bytedance.sdk.xbridge.cn.optimize.c> f269965q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f269966r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile List<Function0<Unit>> f269967s;

    public static final class a implements com.bytedance.sdk.xbridge.cn.protocol.e<ReadableMap, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxBDXBridge f269968a;

        public a(LynxBDXBridge r100) {
            this.f269968a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.protocol.e
        public final void a(le7.a r100, me7.d r101) {
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r101, "bridgeContext");
            boolean r102 = this.f269968a.f269963o;
            r100.getClass();
            id7.c.f489344d.getClass();
        }
    }

    public final void C() {
        monitor-enter(this);
        List<Function0<Unit>> r100 = this.f269967s;     // Catch: Throwable -> L12
        if (r100 == null) goto L10;
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L12
    L7:
        if (r101.hasNext() == false) goto L9;
        ((Function0) r101.next()).invoke();     // Catch: Throwable -> L12
        goto L7
    L9:
        r100.clear();     // Catch: Throwable -> L12
        this.f269967s = null;     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final b D() {
        b r100 = this.f269961m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeContext");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final com.bytedance.sdk.xbridge.cn.protocol.e<ReadableMap, Object> i() {
        return new a(this);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final com.bytedance.sdk.xbridge.cn.protocol.c<ReadableMap, Object> j() {
        return (i) this.f269962n.getValue();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final boolean q() {
        if (this.f269967s == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final void u() {
        if (this.f269961m == null) goto L5;
        D().b();
    L5:
        List<Function0<Unit>> r100 = this.f269967s;
        if (r100 == null) goto L8;
        r100.clear();
    L8:
        this.f269967s = null;
    }

    public final void E(LynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        b r101 = new b(this.f269959k, r100, this, this.f269960l);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f269961m = r101;
        r(D());
    }

    public final void G(LynxViewBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxViewBuilder");
        r100.registerModule("bridge", XBridgeLynxModule.class, this);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final IDLXBridgeMethod.XBridgeThreadType n(le7.a<ReadableMap> r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        if (Intrinsics.areEqual(this.f269966r, Boolean.FALSE) == false) goto L5;
        return null;
    L5:
        if (this.f269965q == null) goto L14;
        s26.d r101 = s26.d.f540305c;
        m0 r102 = (m0) s26.d.f540305c.c(m0.class);
        if (r102 == null) goto L11;
        r102.a0();
    L11:
        return OptimizeConfigKt.a(this.f269965q, r100);
    L14:
        return null;
    }

    public LynxBDXBridge(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerID");
        super(r100, r101);
        this.f269959k = r101;
        this.f269960l = "";
        this.f269962n = LazyKt.lazy(LynxBDXBridge$bridgeHandler$2.INSTANCE);
        this.f269964p = new HashSet();
        this.f269966r = Boolean.FALSE;
    }

    public final void F(boolean r100, List<com.bytedance.sdk.xbridge.cn.optimize.c> r101) {
        this.f269966r = Boolean.valueOf(r100);
        this.f269965q = r101;
    }

    @Override // ue7.d
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        JSONObject r102 = new JSONObject();
        if (r101 == null) goto L5;
        JSONObject r103 = new JSONObject(r101);
    L6:
        r102.put("data", r103);
        JavaOnlyArray r104 = new JavaOnlyArray();
        d.f269973a.getClass();
        r104.pushMap(d.m(r102));
        b r105 = D();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r104, "params");
        r105.f269969e.sendGlobalEvent(r100, r104);
        return;
    L5:
        r103 = new JSONObject();
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final boolean g(le7.a<ReadableMap> r100, com.bytedance.sdk.xbridge.cn.protocol.d<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "callback");
        i r102 = (i) this.f269962n.getValue();
        String r103 = r100.f508946d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "namespace");
        r102.f269994c = r103;
        if (this.f269964p.contains(r100.f508946d) == false) goto L6;
        r101.c(((i) this.f269962n.getValue()).a(r100, -4, "Namespace " + this.f269960l + " unknown."));
        return true;
    L6:
        return false;
    }

    public LynxBDXBridge(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerID");
        Intrinsics.checkNotNullParameter(r102, "namespace");
        this(r100, r101);
        this.f269960l = r102;
    }
}

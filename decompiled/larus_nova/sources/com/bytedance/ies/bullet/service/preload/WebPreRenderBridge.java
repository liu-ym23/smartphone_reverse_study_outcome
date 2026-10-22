package com.bytedance.ies.bullet.service.preload;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.y;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(biz = "bullet", name = "__prerender")
public final class WebPreRenderBridge extends com.bytedance.ies.bullet.core.kit.bridge.c implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f248072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBridgeMethod.Access f248073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f248074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f248075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f248076g;

    public static final class a {
    }

    public static final class b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebPreRenderBridge f248077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBridgeMethod.a f248078b;

        @Override // com.bytedance.ies.bullet.service.base.y
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            JSONObject r101 = this.f248077a.c(true, 0, "succeed");
            this.f248078b.onComplete(r101);
        }

        public b(WebPreRenderBridge r100, IBridgeMethod.a r101) {
            this.f248077a = r100;
            this.f248078b = r101;
        }

        @Override // com.bytedance.ies.bullet.service.base.y
        public final void a(PoolResult r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            JSONObject r102 = this.f248077a.c(false, -2, "load failed");
            this.f248078b.onComplete(r102);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.i0
    public final void release() {
    }

    private final BulletContext getContext() {
        h16.e r100 = (h16.e) this.f248072c.c(h16.e.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBulletContext();
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f248073d;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f248074e;
    }

    public WebPreRenderBridge(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f248072c = r100;
        this.f248073d = IBridgeMethod.Access.PRIVATE;
        this.f248074e = "__prerender";
        this.f248075f = LazyKt.lazy(new WebPreRenderBridge$poolService$2(this));
        this.f248076g = 10000;
    }

    public static final /* synthetic */ BulletContext b(WebPreRenderBridge r100) {
        return r100.getContext();
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r100, IBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = r100.optString("schema");
        BulletContext r103 = getContext();
        if (r103 == null) goto L5;
        Context r104 = r103.getContext();
    L6:
        Context r105 = r104;
        if (r105 != null) goto L10;
        r101.onComplete(c(false, -1, "context is null"));
        return;
    L10:
        Uri r106 = UriProtector.parse(r102);
        a0 r107 = (a0) this.f248075f.getValue();
        if (r107 == null) goto L14;
        r107.e(r106, r105, this.f248076g, new b(this, r101));
    L14:
        if (((a0) this.f248075f.getValue()) != null) goto L17;
        r101.onComplete(c(false, -3, "poolService is null"));
        return;
    L17:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final JSONObject c(boolean r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("code", r101);
        JSONObject r104 = new JSONObject();
        r104.put("__status_message__", r102);
        r104.put(KtvSubElement.CONTAINER, "BulletX");
        r104.put("result", r100);
        Unit r105 = Unit.INSTANCE;
        r103.put("data", r104);
        return r103;
    }
}

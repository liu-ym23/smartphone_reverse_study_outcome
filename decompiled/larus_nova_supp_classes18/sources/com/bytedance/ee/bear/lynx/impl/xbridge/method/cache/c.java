package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends XCoreBridgeMethod {
    public final String a;
    public final XBridgeMethod.Access b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public b(c r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            c r0 = this.a;
            XBridgeMethod.Callback r1 = this.b;
            LinkedHashMap r2 = new LinkedHashMap();
            Unit r9 = Unit.INSTANCE;
            XCoreBridgeMethod.onSuccess$default(r0, r1, r2, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.c$c, reason: collision with other inner class name */
    public static final class C0044c<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public C0044c(c r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            c r0 = this.a;
            XBridgeMethod.Callback r1 = this.b;
            String r9 = ((Throwable) r8).getLocalizedMessage();
            if (r9 != null) goto L5;
            r9 = "";
        L5:
            XCoreBridgeMethod.onFailure$default(r0, r1, -1000, r9, null, 8, null);
        }
    }

    static {
    }

    public c() {
        this.a = "ccm.setCacheItem";
        this.b = XBridgeMethod.Access.PROTECT;
    }

    public final XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r12, XBridgeMethod.Callback r13, XBridgePlatformType r14) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_TYPE);
        String r15 = s.f(r12, "key", "");
        String r1 = s.f(r12, "business", "");
        String r16 = s.f(r12, WikiFolderPushPlugin.DATA, "");
        boolean r2 = false;
        if (r15.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        XCoreBridgeMethod.onFailure$default(this, r13, -3, "key is empty", null, 8, null);
        return;
    L10:
        if (r1.length() != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L17;
        XCoreBridgeMethod.onFailure$default(this, r13, -3, "business is null", null, 8, null);
        return;
    L17:
        if (r16.length() != 0) goto L19;
        r2 = true;
    L19:
        if (r2 == false) goto L23;
        XCoreBridgeMethod.onFailure$default(this, r13, -3, "data is null", null, 8, null);
        return;
    L23:
        if (r16.length() <= 1500000) goto L26;
        XCoreBridgeMethod.onFailure$default(this, r13, -3, "data can't be more than 1.5MB", null, 8, null);
        return;
    L26:
        CCMLynxCacheManager r4 = (CCMLynxCacheManager) CCMLynxCacheManager.a.getValue();
        i r5 = new i(r1, r15, r16);
        r4.getClass();
        Flowable.just(r5).observeOn(fo5.d.b()).map(new com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.b(r4)).subscribe(new b(this, r13), new C0044c(this, r13));
        return;
    L12:
        r3 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}

package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends XCoreBridgeMethod {
    public final String a;
    public final XBridgeMethod.Access b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.a$a, reason: collision with other inner class name */
    public static final class C0043a<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public C0043a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            CCMLynxCacheManager r5 = (CCMLynxCacheManager) CCMLynxCacheManager.a.getValue();
            String r0 = this.a;
            String r1 = this.b;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r0, "business");
            Intrinsics.checkNotNullParameter(r1, "key");
            String r6 = null;
            LynxCacheDatabase r2 = CCMLynxCacheManager.a();     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r2);     // Catch: Exception -> L5
            i r3 = ((h) r2.c()).c(r0, r1);     // Catch: Exception -> L5
        L7:
            if (r3 == null) goto L9;
            r6 = r3.c;
        L9:
            LinkedHashMap r7 = new LinkedHashMap();
            if (r6 == null) goto L12;
            r7.put(WikiFolderPushPlugin.DATA, r6);
        L12:
            return r7;
        L5:
            e = move-exception;
            iu5.d.c(e);
            r3 = null;
            goto L7
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public b(a r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Map r2 = (Map) r7;
            a r0 = this.a;
            XBridgeMethod.Callback r1 = this.b;
            Intrinsics.checkNotNull(r2);
            XCoreBridgeMethod.onSuccess$default(r0, r1, r2, null, 4, null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public c(a r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            a r0 = this.a;
            XBridgeMethod.Callback r1 = this.b;
            String r9 = ((Throwable) r8).getLocalizedMessage();
            if (r9 != null) goto L5;
            r9 = "";
        L5:
            XCoreBridgeMethod.onFailure$default(r0, r1, -1000, r9, null, 8, null);
        }
    }

    public a() {
        this.a = "ccm.getCacheItem";
        this.b = XBridgeMethod.Access.PROTECT;
    }

    public final XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r11, XBridgeMethod.Callback r12, XBridgePlatformType r13) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TYPE);
        String r14 = s.f(r11, "key", "");
        String r15 = s.f(r11, "business", "");
        boolean r1 = false;
        if (r14.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        XCoreBridgeMethod.onFailure$default(this, r12, -3, "key is empty", null, 8, null);
        return;
    L10:
        if (r15.length() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        XCoreBridgeMethod.onFailure$default(this, r12, -3, "business is null", null, 8, null);
        return;
    L15:
        Single.just(r14).subscribeOn(fo5.d.b()).map(new C0043a(r15, r14)).subscribe(new b(this, r12), new c(this, r12));
        return;
    L5:
        r0 = false;
        goto L6
    }
}

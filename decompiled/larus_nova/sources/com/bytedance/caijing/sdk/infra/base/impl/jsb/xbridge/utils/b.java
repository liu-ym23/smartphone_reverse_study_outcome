package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import cd4.k;
import cd4.m;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f202696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IDLXBridgeMethod f202697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f202698c;

    public static final class a implements IBDXBridgeContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2937a f202699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f202700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebView f202701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f202702d;

        /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.b$a$a, reason: collision with other inner class name */
        public static final class C2937a extends le7.a<String> {
            public final String M;
            public final PlatformType N;
            public final String O;

            @Override // le7.a
            public final String b() {
                return this.M;
            }

            @Override // le7.a
            public final PlatformType c() {
                return this.N;
            }

            @Override // le7.a
            public final String d() {
                return this.O;
            }

            public C2937a(String r100) {
                super(r100);
                this.M = "fakeBridgeCall";
                this.N = PlatformType.WEB;
                this.O = "fakeBridgeCall";
            }
        }

        /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.b$a$b, reason: collision with other inner class name */
        public static final class C2938b implements ue7.d {
            public C2938b() {
            }

            @Override // ue7.d
            public final void a(String r100, Map<String, ? extends Object> r101) {
                Intrinsics.checkNotNullParameter(r100, "eventName");
            }
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final String getContainerID() {
            return "";
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final String getNamespace() {
            return "";
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final <T> T getService(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            return null;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final ue7.d getJsEventDelegate() {
            return new C2938b();
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final Activity getOwnerActivity() {
            Context r100 = this.f202702d;
            if (r100 != null) goto L7;
            return null;
        L7:
            return CJPayBasicExtensionKt.toActivity(r100);
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
        public final le7.a<?> getBridgeCall() {
            return this.f202699a;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
        public final String getCallId() {
            return this.f202700b;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final View getEngineView() {
            return this.f202701c;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final PlatformType getPlatformType() {
            return PlatformType.WEB;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
        public final void setCallId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f202700b = r100;
        }

        public a(IDLXBridgeMethod r100, WebView r101, Context r102) {
            this.f202701c = r101;
            this.f202702d = r102;
            this.f202699a = new C2937a(r100.getName());
            this.f202700b = "bridgeCall.id";
        }
    }

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.b$b, reason: collision with other inner class name */
    public static final class C2939b implements IDLXBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f202703a;

        public C2939b(k r100) {
            this.f202703a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.a
        public final void invoke(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Object r101 = r100.get("code");
            String r102 = null;
            if ((r101 instanceof Integer) == false) goto L5;
            Integer r103 = (Integer) r101;
        L6:
            Object r104 = r100.get("msg");
            if ((r104 instanceof String) == false) goto L10;
            r102 = (String) r104;
        L10:
            if (r102 != null) goto L12;
            r102 = "";
        L12:
            if (r103 != null) goto L15;
        L19:
            if (r103 != null) goto L22;
        L26:
            k r105 = this.f202703a;
            if (r105 == null) goto L34;
            r105.onFailed("", KtSafeMethodExtensionKt.safeToJson(r100));
            return;
        L34:
            return;
        L22:
            if (r103.intValue() != 0) goto L26;
            k r106 = this.f202703a;
            if (r106 == null) goto L32;
            r106.onFailed(r102, KtSafeMethodExtensionKt.safeToJson(r100));
            return;
        L32:
            return;
        L15:
            if (r103.intValue() != 1) goto L19;
            k r107 = this.f202703a;
            if (r107 == null) goto L30;
            r107.onSuccess(KtSafeMethodExtensionKt.safeToJson(r100));
            return;
        L30:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    @Override // cd4.m
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // cd4.m
    public final <T> void putDependency(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    }

    @Override // cd4.m
    public final void release() {
    }

    @Override // cd4.m
    public final String getName() {
        return this.f202696a;
    }

    public b(IDLXBridgeMethod r100, WebView r101) {
        this.f202697b = r100;
        this.f202698c = r101;
        this.f202696a = r100.getName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cd4.m
    public final void handle(Context r100, JSONObject r101, k r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        IDLXBridgeMethod r103 = this.f202697b;
        WebView r104 = this.f202698c;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L10
        a r106 = new a(r103, r104, r100);     // Catch: Throwable -> L10
        Map<String, Object> r107 = c.f202706c.l(r101, r103.getClass());     // Catch: Throwable -> L10
        if (r107 != null) goto L8;
        Intrinsics.checkNotNullParameter(r101, "params");     // Catch: Throwable -> L10
        r107 = ConvertUtils.INSTANCE.jsonToMap(r101);     // Catch: Throwable -> L10
        if (r107 != null) goto L8;
        r107 = MapsKt.emptyMap();     // Catch: Throwable -> L10
    L8:
        r103.realHandle(r106, r107, new C2939b(r102));     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}

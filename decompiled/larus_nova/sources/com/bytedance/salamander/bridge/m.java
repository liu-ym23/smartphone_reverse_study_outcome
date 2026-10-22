package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.a4;
import com.bytedance.salamander.anniex.b4;
import com.bytedance.sdk.xbridge.cn.network.XRequestMethod;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class m {

    public static final class a implements com.bytedance.sdk.xbridge.cn.network.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f268563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f268564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f268565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, ? extends Object> f268566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Boolean f268567e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Number f268568f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f268569g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, Object> f268570h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Number f268571i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f268572j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f268573k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Boolean f268574l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Boolean f268575m;

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Map<String, Object> getExtraInfo() {
            return null;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final Map<String, Object> convert() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final JSONObject toJSON() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final boolean getAddCommonParams() {
            return this.f268563a;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Object getBody() {
            return this.f268564b;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final String getBodyType() {
            return this.f268565c;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Map<String, Object> getHeader() {
            return this.f268566d;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Number getMaxLength() {
            return this.f268568f;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final String getMethod() {
            return this.f268569g;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Map<String, Object> getParams() {
            return this.f268570h;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Number getStreamLoadType() {
            return this.f268571i;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final String getStreamSessionId() {
            return this.f268572j;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final String getUrl() {
            return this.f268573k;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Boolean getUsePrefetch() {
            return this.f268574l;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Boolean getUseUIThread() {
            return this.f268575m;
        }

        @Override // com.bytedance.sdk.xbridge.cn.network.a.b
        public final Boolean isCustomizedCookie() {
            return this.f268567e;
        }

        public a(a4 r100) {
            Boolean r101 = r100.f267947g;
            if (r101 == null) goto L5;
            boolean r102 = r101.booleanValue();
        L6:
            this.f268563a = r102;
            this.f268564b = r100.f267943c;
            this.f268565c = "";
            Object r103 = r100.f267945e;
            Map<String, Object> r104 = null;
            if ((r103 instanceof Map) == false) goto L9;
            Map<String, ? extends Object> r105 = (Map) r103;
        L10:
            this.f268566d = r105;
            this.f268567e = r100.f267949i;
            this.f268568f = r100.f267952l;
            this.f268569g = r100.f267942b;
            Object r106 = r100.f267944d;
            if ((r106 instanceof Map) == false) goto L13;
            r104 = (Map) r106;
        L13:
            this.f268570h = r104;
            this.f268571i = r100.f267950j;
            this.f268572j = r100.f267951k;
            this.f268573k = r100.f267941a;
            this.f268574l = r100.f267948h;
            this.f268575m = r100.f267946f;
            return;
        L9:
            r105 = null;
            goto L10
        L5:
            r102 = true;
            goto L6
        }
    }

    public static final void a(a4 r100, Function1<? super b4, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.salamander.bridge.common.a r102 = com.bytedance.salamander.bridge.common.b.a(null);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r101, "callback");     // Catch: Exception -> L5
        l r103 = new l(r101);     // Catch: Exception -> L5
        a r104 = new a(r100);     // Catch: Exception -> L5
        new XRequestMethod().c(r102, r104, r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r105 = e.getMessage();
        if (r105 == null) goto L12;
        Intrinsics.checkNotNullParameter(r105, "msg");
        return;
    }
}

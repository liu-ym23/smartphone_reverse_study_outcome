package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.y3;
import com.bytedance.salamander.anniex.z3;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class k {

    public static final class a implements wd7.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f268560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f268561b;

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final Map<String, Object> convert() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final JSONObject toJSON() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // wd7.c.b
        public final String getEventName() {
            return this.f268560a;
        }

        @Override // wd7.c.b
        public final Map<String, Object> getParams() {
            return this.f268561b;
        }

        public a(y3 r100) {
            this.f268560a = r100.f268521a;
            this.f268561b = r100.f268522b;
        }
    }

    public static final void a(y3 r100, Function1<? super z3, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.salamander.bridge.common.a r102 = com.bytedance.salamander.bridge.common.b.a(null);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r101, "callback");     // Catch: Exception -> L5
        j r103 = new j(r101);     // Catch: Exception -> L5
        a r104 = new a(r100);     // Catch: Exception -> L5
        new wd7.h();     // Catch: Exception -> L5
        wd7.h.a(r102, r104, r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r105 = e.getMessage();
        if (r105 == null) goto L12;
        Unit r106 = r101.invoke(new z3(r105, 0));
        return;
    }
}

package com.bytedance.salamander.bridge;

import android.content.Context;
import com.bytedance.salamander.anniex.w3;
import com.bytedance.salamander.anniex.x3;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class i {

    public static final class a implements oe7.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w3 f268558a;

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final Map<String, Object> convert() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // oe7.a.b
        public final Map<String, Object> getExtra() {
            return this.f268558a.f268484f;
        }

        @Override // oe7.a.b
        public final boolean getFirstClose() {
            return this.f268558a.f268481c;
        }

        @Override // oe7.a.b
        public final boolean getReplace() {
            return this.f268558a.f268480b;
        }

        @Override // oe7.a.b
        public final String getReplaceType() {
            return this.f268558a.f268483e;
        }

        @Override // oe7.a.b
        public final String getSchema() {
            return this.f268558a.f268479a;
        }

        @Override // oe7.a.b
        public final boolean getUseSysBrowser() {
            return this.f268558a.f268482d;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final JSONObject toJSON() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        public a(w3 r100) {
            this.f268558a = r100;
        }
    }

    public static final void a(w3 r100, Function1<? super x3, Unit> r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.salamander.bridge.common.a r103 = com.bytedance.salamander.bridge.common.b.a(r102);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r101, "callback");     // Catch: Exception -> L5
        h r104 = new h(r101);     // Catch: Exception -> L5
        a r105 = new a(r100);     // Catch: Exception -> L5
        new oe7.c().b(r103, r105, r104);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r106 = e.getMessage();
        if (r106 == null) goto L12;
        Unit r107 = r101.invoke(new x3(r106, 0));
        return;
    }
}

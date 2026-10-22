package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.g4;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class o implements ve7.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g4 f268577a;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ve7.d.b
    public final String getBiz() {
        return this.f268577a.f268082c;
    }

    @Override // ve7.d.b
    public final Object getData() {
        Object r100 = this.f268577a.f268081b;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return Unit.INSTANCE;
    L7:
        return r100;
    }

    @Override // ve7.d.b
    public final String getKey() {
        return this.f268577a.f268080a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public o(g4 r100) {
        this.f268577a = r100;
    }
}

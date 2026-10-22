package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.n3;
import java.util.Map;
import kotlin.NotImplementedError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements ve7.b.InterfaceC7993b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f268552b;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ve7.b.InterfaceC7993b
    public final String getBiz() {
        return this.f268552b;
    }

    @Override // ve7.b.InterfaceC7993b
    public final String getKey() {
        return this.f268551a;
    }

    public c(n3 r100) {
        this.f268551a = r100.f268253a;
        this.f268552b = r100.f268254b;
    }
}

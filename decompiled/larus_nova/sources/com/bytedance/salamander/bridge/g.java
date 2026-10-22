package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.t3;
import java.util.Map;
import kotlin.NotImplementedError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class g implements jd7.b.InterfaceC6419b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t3 f268556a;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // jd7.b.InterfaceC6419b
    public Map<String, Object> getContext() {
        return this.f268556a.getContext();
    }

    @Override // jd7.b.InterfaceC6419b
    public final boolean getKeepOpen() {
        return this.f268556a.f268385b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public g(t3 r100) {
        this.f268556a = r100;
    }
}

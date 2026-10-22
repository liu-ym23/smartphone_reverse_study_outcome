package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.i4;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import java.util.Map;
import kotlin.NotImplementedError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class q implements af7.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i4 f268579a;

    @Override // af7.g.b
    @XBridgeParamField(isGetter = true, keyPath = "ext", required = false)
    public abstract /* synthetic */ Map<String, Object> getExt();

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // af7.g.b
    public final String getCustomIcon() {
        return this.f268579a.f268118e;
    }

    @Override // af7.g.b
    public final Number getDuration() {
        return this.f268579a.f268116c;
    }

    @Override // af7.g.b
    public final String getIcon() {
        return this.f268579a.f268117d;
    }

    @Override // af7.g.b
    public final String getMessage() {
        return this.f268579a.f268114a;
    }

    @Override // af7.g.b
    public String getType() {
        return this.f268579a.getType();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public q(i4 r100) {
        this.f268579a = r100;
    }
}

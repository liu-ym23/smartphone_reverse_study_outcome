package kd7;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Number f502853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f502854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f502855c;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        LinkedHashMap r100 = new LinkedHashMap();
        Number r101 = this.f502853a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Any");
        r100.put("is_install", r101);
        String r102 = this.f502854b;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Any");
        r100.put("version_code", r102);
        String r103 = this.f502855c;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Any");
        r100.put("version_name", r103);
        return r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        r100.put("is_install", this.f502853a);
        r100.put("version_code", this.f502854b);
        r100.put("version_name", this.f502855c);
        return r100;
    }

    public b() {
        this.f502853a = 0;
        this.f502854b = "";
        this.f502855c = "";
    }

    @Override // kd7.a.b
    public final String getVersion_code() {
        return this.f502854b;
    }

    @Override // kd7.a.b
    public final String getVersion_name() {
        return this.f502855c;
    }

    @Override // kd7.a.b
    public final Number is_install() {
        return this.f502853a;
    }

    @Override // kd7.a.b
    public final void setVersion_code(String r100) {
        this.f502854b = r100;
    }

    @Override // kd7.a.b
    public final void setVersion_name(String r100) {
        this.f502855c = r100;
    }

    @Override // kd7.a.b
    public final void set_install(Number r100) {
        this.f502853a = r100;
    }
}

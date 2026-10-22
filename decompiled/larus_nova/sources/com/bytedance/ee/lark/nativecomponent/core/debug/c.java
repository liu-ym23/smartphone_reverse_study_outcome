package com.bytedance.ee.lark.nativecomponent.core.debug;

import com.bytedance.ee.lark.nativecomponent.service.NativeRenderType;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/lark/nativecomponent/core/debug/ExtraPlatformViewStateModel;", "", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "renderType", "Lcom/bytedance/ee/lark/nativecomponent/service/NativeRenderType;", "getRenderType", "()Lcom/bytedance/ee/lark/nativecomponent/service/NativeRenderType;", "setRenderType", "(Lcom/bytedance/ee/lark/nativecomponent/service/NativeRenderType;)V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/ee/lark/nativecomponent/core/model/NativeComponentModel;", "getModel", "()Lcom/bytedance/ee/lark/nativecomponent/core/model/NativeComponentModel;", "setModel", "(Lcom/bytedance/ee/lark/nativecomponent/core/model/NativeComponentModel;)V", "native-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private os5.a model;

    @SerializedName("render_type")
    private NativeRenderType renderType;

    @SerializedName("tag")
    private String tag;

    @SerializedName("type")
    private String type;

    public c() {
    }

    public final String getType() {
        return this.type;
    }

    public final void a(os5.a r100) {
        this.model = r100;
    }

    public final void b(NativeRenderType r100) {
        this.renderType = r100;
    }

    public final void c(String r100) {
        this.tag = r100;
    }

    public final void d(String r100) {
        this.type = r100;
    }
}

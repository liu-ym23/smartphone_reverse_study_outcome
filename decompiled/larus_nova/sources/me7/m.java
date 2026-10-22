package me7;

import com.bytedance.sdk.xbridge.cn.registry.core.RevenueSendStreamXEventParamModelSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@JsonAdapter(RevenueSendStreamXEventParamModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lme7/m;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m extends vh7.j<m> {

    @JsonAdapter(RevenueSendStreamXEventParamModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "rtcKey")
    String G();

    @FieldName(name = "layoutKey")
    String c();

    @FieldName(name = "event")
    Integer getEvent();

    @FieldName(name = "extra")
    JsonObject getExtra();
}

package com.bytedance.sdk.xbridge.cn.registry.core.model.idl;

import com.bytedance.sdk.xbridge.cn.registry.core.exception.XBridgeException;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004H'¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "", "Lorg/json/JSONObject;", "toJSON", "", "", "convert", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface XBaseModel {

    public static final class a implements XBaseModel {
        public a() {
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final JSONObject toJSON() {
            return new JSONObject();
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final Map<String, Object> convert() {
            return MapsKt.emptyMap();
        }
    }

    Map<String, Object> convert() throws XBridgeException;

    JSONObject toJSON();
}

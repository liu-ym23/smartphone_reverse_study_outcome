package com.bytedance.kmp.gamecp.base.settings;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import ta6.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/gamecp/base/settings/FilterConfigSerializableObjectImpl;", "Lta6/a;", "Lcom/google/gson/JsonArray;", "rules", "Lcom/google/gson/JsonArray;", "getRules", "()Lcom/google/gson/JsonArray;", "Lcom/google/gson/JsonElement;", FilterData.FilterSheetItem.Id.FILTER_VALUE, "Lcom/google/gson/JsonElement;", "getFilterValue", "()Lcom/google/gson/JsonElement;", "<init>", "()V", "Adapter", "kmp-gamecp-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FilterConfigSerializableObjectImpl implements a {

    @SerializedName("filter_value")
    private final JsonElement filterValue;

    @SerializedName("rules")
    private final JsonArray rules;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/gamecp/base/settings/FilterConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "kmp-gamecp-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(FilterConfigSerializableObjectImpl.class);
        }
    }

    public FilterConfigSerializableObjectImpl() {
    }
}

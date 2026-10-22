package com.bytedance.kmp.gamecp.base.settings;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import ta6.a;
import ta6.b;
import ta6.c;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/gamecp/base/settings/GameCPSettingFilterConfigSerializableObjectImpl;", "Lta6/c;", "", "", "Lta6/b;", "filterRulesMap", "Ljava/util/Map;", "getFilterRulesMap", "()Ljava/util/Map;", "Lta6/a;", "filterConfigMap", "getFilterConfigMap", "<init>", "()V", "Adapter", "kmp-gamecp-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GameCPSettingFilterConfigSerializableObjectImpl implements c {

    @SerializedName("filter_config")
    private final Map<String, a> filterConfigMap;

    @SerializedName("filter_rules")
    private final Map<String, b> filterRulesMap;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/gamecp/base/settings/GameCPSettingFilterConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "kmp-gamecp-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GameCPSettingFilterConfigSerializableObjectImpl.class);
        }
    }

    public GameCPSettingFilterConfigSerializableObjectImpl() {
    }
}

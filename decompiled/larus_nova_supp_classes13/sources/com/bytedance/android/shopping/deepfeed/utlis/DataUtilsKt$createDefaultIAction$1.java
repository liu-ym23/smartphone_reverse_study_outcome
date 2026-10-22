package com.bytedance.android.shopping.deepfeed.utlis;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"com/bytedance/android/shopping/deepfeed/utlis/DataUtilsKt$createDefaultIAction$1", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "disable", "Z", "getDisable", "()Z", "", "exposureThreshold", "F", "getExposureThreshold", "()F", "", "scrollCallbackThreshold", "J", "getScrollCallbackThreshold", "()J", "", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DataUtilsKt$createDefaultIAction$1 implements IAction {
    final /* synthetic */ String $actionName;
    final /* synthetic */ Map $params;
    private final List<IAction> actions;
    private final boolean disable;
    private final float exposureThreshold;
    private final Map<String, Object> params;
    private final long scrollCallbackThreshold;
    private final String type;

    public List<IAction> getActions() {
        return this.actions;
    }

    public boolean getDisable() {
        return this.disable;
    }

    public float getExposureThreshold() {
        return this.exposureThreshold;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public long getScrollCallbackThreshold() {
        return this.scrollCallbackThreshold;
    }

    public String getType() {
        return this.type;
    }

    public DataUtilsKt$createDefaultIAction$1(String r1, Map r2) {
        this.$actionName = r1;
        this.$params = r2;
        this.type = r1;
        this.params = r2;
    }
}

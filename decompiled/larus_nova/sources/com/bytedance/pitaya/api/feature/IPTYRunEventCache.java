package com.bytedance.pitaya.api.feature;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/pitaya/api/feature/IPTYRunEventCache;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", BasicTestActionHandler.TEST_ACTION_RESET, "", "aid", "", "business", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IPTYRunEventCache extends ReflectionCall {
    void reset(String r100, String r101);
}

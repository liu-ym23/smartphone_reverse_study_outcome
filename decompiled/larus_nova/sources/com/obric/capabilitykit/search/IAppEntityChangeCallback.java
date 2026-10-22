package com.obric.capabilitykit.search;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/search/IAppEntityChangeCallback;", "", "onChange", "", "result", "Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", LynxVideoManagerLite.EVENT_ON_ERROR, "errorCode", "", "errorMsg", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IAppEntityChangeCallback {
    void onChange(EntityChangeResult r100);

    void onError(int r100, String r101);
}

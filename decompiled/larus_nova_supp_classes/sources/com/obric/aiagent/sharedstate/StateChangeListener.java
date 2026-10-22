package com.obric.aiagent.sharedstate;

import android.util.EventsUtils;
import com.obric.aiagent.sharedstate.model.SharedValue;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/aiagent/sharedstate/StateChangeListener;", XmlPullParser.NO_NAMESPACE, "onStateChanged", XmlPullParser.NO_NAMESPACE, "key", XmlPullParser.NO_NAMESPACE, "value", "Lcom/obric/aiagent/sharedstate/model/SharedValue;", "shared-state-sdk_release"}, k = 1, mv = {1, 7, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface StateChangeListener {
    void onStateChanged(String r1, SharedValue r2);
}

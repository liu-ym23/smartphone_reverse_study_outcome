package com.obric.assistant.common.spi;

import android.util.EventsUtils;
import java.util.Map;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/assistant/common/spi/IObricConfigService;", XmlPullParser.NO_NAMESPACE, "getCommonParams", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "obric_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricConfigService {
    Map<String, String> getCommonParams();
}

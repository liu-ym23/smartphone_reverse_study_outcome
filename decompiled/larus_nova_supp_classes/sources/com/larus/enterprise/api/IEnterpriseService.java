package com.larus.enterprise.api;

import android.util.EventsUtils;
import com.larus.enterprise.impl.EnterpriseRouterInterceptor;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/larus/enterprise/api/IEnterpriseService;", XmlPullParser.NO_NAMESPACE, "isInEnterpriseMode", XmlPullParser.NO_NAMESPACE, "requestThemeConfig", XmlPullParser.NO_NAMESPACE, "scene", XmlPullParser.NO_NAMESPACE, "createChatEnterpriseRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IEnterpriseService {
    EnterpriseRouterInterceptor a();

    boolean b();

    void c(String r1);
}

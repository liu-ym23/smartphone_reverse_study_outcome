package com.obric.assistant.common.spi;

import android.util.EventsUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0096\u0001¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/common/spi/ObricConfigServiceDelegate;", "Lcom/obric/assistant/common/spi/IObricConfigService;", "<init>", "()V", "getCommonParams", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "obric_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricConfigServiceDelegate implements IObricConfigService {
    public static final ObricConfigServiceDelegate b = null;
    public final /* synthetic */ IObricConfigService a;

    static {
        b = new ObricConfigServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.IObricConfigService
    public final Map<String, String> getCommonParams() {
        return this.a.getCommonParams();
    }

    private ObricConfigServiceDelegate() {
        DefaultObricConfigService r0 = (IObricConfigService) ServiceManager.get().getService(IObricConfigService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricConfigService();
    L5:
        this.a = r0;
    }
}

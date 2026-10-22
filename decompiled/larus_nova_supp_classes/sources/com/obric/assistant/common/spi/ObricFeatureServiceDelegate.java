package com.obric.assistant.common.spi;

import android.util.EventsUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\bH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/assistant/common/spi/ObricFeatureServiceDelegate;", "Lcom/obric/assistant/common/spi/IObricFeatureService;", "<init>", "()V", "getObricKeepAliveLevel", XmlPullParser.NO_NAMESPACE, "getObricProductName", "isEmulatorOs", XmlPullParser.NO_NAMESPACE, "isFeatureEnable", "isObricFeatureEnable", "isObricOs", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricFeatureServiceDelegate implements IObricFeatureService {
    public static final ObricFeatureServiceDelegate b = null;
    public final /* synthetic */ IObricFeatureService a;

    static {
        b = new ObricFeatureServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean b() {
        return this.a.b();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean c() {
        return this.a.c();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final String d() {
        return this.a.d();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean e() {
        return this.a.e();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final String f() {
        return this.a.f();
    }

    private ObricFeatureServiceDelegate() {
        DefaultFeatureServiceImpl r0 = (IObricFeatureService) ServiceManager.get().getService(IObricFeatureService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultFeatureServiceImpl();
    L5:
        this.a = r0;
    }
}

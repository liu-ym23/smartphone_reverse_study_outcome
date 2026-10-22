package com.larus.bmhome.chat.api;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin$initAppletPayloadChangeListener$1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/api/AppletPayloadProviderDelegate;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "impl", "", "kotlin.jvm.PlatformType", "", "getAppletPayload", "", "", "conversationId", "botId", RemoteMessageConst.MSGID, "addOnAppletPayloadChangedListener", "", "listener", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "removeOnAppletPayloadChangedListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPayloadProviderDelegate implements IAppletPayloadProviderService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppletPayloadProviderDelegate f297130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<IAppletPayloadProviderService> f297131b = null;

    private AppletPayloadProviderDelegate() {
    }

    static {
        f297130a = new AppletPayloadProviderDelegate();
        f297131b = ServiceManager.get().getServices(IAppletPayloadProviderService.class, true);
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final void a(t0 r100) {
        Iterator<T> r101 = f297131b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IAppletPayloadProviderService) r101.next()).a(r100);
        goto L4
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final void c(CommonAppletPlugin$initAppletPayloadChangeListener$1 r100) {
        Iterator<T> r101 = f297131b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IAppletPayloadProviderService) r101.next()).c(r100);
        goto L4
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final Map<String, String> b(String r100, String r101, String r102) {
        Set<IAppletPayloadProviderService> r103 = f297131b;
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L9;
        Map<String, String> r106 = ((IAppletPayloadProviderService) r105.next()).b(r100, r101, r102);
        if (r106 != null) goto L8;
        r106 = MapsKt.emptyMap();
    L8:
        r104.putAll(r106);
        goto L4
    L9:
        return r104;
    }
}

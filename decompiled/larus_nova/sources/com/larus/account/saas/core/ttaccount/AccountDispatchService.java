package com.larus.account.saas.core.ttaccount;

import android.net.Uri;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.account.saas.coreapi.IAccountDeeplinkHandler;
import com.larus.account.saas.coreapi.IAccountDispatchService;
import com.larus.account.saas.coreapi.IAccountFrontierMessageHandler;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountDispatchService;", "Lcom/larus/account/saas/coreapi/IAccountDispatchService;", "<init>", "()V", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountDispatchService implements IAccountDispatchService {

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((IAccountFrontierMessageHandler) r101).priority().getValue()), Integer.valueOf(((IAccountFrontierMessageHandler) r100).priority().getValue()));
        }
    }

    public AccountDispatchService() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountDispatchService
    public final boolean e(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Iterator r101 = ServiceManager.get().getServices(IAccountDeeplinkHandler.class).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((IAccountDeeplinkHandler) r101.next()).a(r100) == false) goto L4;
        SaasTracking r102 = SaasTracking.f286464a;
        JSONObject r103 = new JSONObject();
        r103.put("path", r100.toString());
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("doubao_account_remote_notification_dispatch", r103);
        return true;
    L9:
        return false;
    }

    @Override // com.larus.account.saas.coreapi.IAccountDispatchService
    public final boolean c(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        Iterator r103 = CollectionsKt.sortedWith(ServiceManager.get().getServices(IAccountFrontierMessageHandler.class), new a()).iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        if (((IAccountFrontierMessageHandler) r103.next()).a(r101, r102) == false) goto L4;
        SaasTracking r104 = SaasTracking.f286464a;
        JSONObject r105 = new JSONObject();
        r105.put("service", String.valueOf(r100));
        r105.put(com.alipay.sdk.m.p.e.f25671s, String.valueOf(r101));
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("doubao_account_frontier_msg_dispatch", r105);
        return true;
    L9:
        return false;
    }
}

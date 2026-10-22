package com.larus.commercemembership.api;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.alipay.sdk.m.x.d;
import com.larus.commercemembership.impl.CommerceMembershipRouterInterceptor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.b1;
import tc9.e;
import uz8.c;
import uz8.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u0000 I2\u00020\u0001:\u0001IJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eH&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0012\u001a\u00020\u0003H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u001a\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001b\u001a\u00020\u0003H&J&\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030 H&J\u008c\u0001\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005H&J&\u0010!\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\b\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005H&J&\u0010.\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\b\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005H&J&\u00102\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u0005H&J&\u00104\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u0005H&J\u001c\u00105\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u00010\u0005H&J\u001c\u00107\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u00010\u0005H&J:\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u00052\b\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&JZ\u0010=\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u00052\b\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010?\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010D\u001a\u0004\u0018\u00010\u00052\b\u0010C\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u0005H&¨\u0006J"}, d2 = {"Lcom/larus/commercemembership/api/ICommerceMembershipService;", "", "requestSubscriptionEntryConfig", "", "from", "", "requestUserEntitlement", "scene", "requestPcGuidePushBanner", "campaignSource", "markPendingPcGuideReachPull", "getSubscriptionEntryConfig", "Lcom/larus/commercemembership/api/model/SubscriptionEntryConfig;", "getSubscriptionEntryConfigFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getMobSubscriptionEntryConfig", "Lcom/larus/commercemembership/api/model/MobSubscriptionEntryConfig;", "url", "updateSubscriptionEventCommonParams", "getMembershipRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "goToMembershipPageFromZlink", "text", "triggerInnerNotification", "inAppBannerNotify", "Lcom/larus/im/bean/InAppBannerNotify;", "triggerPcGuideInnerNotification", "tryShowPendingPcGuideInnerNotification", "observeSubscriptionEntryConfigChange", "scope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "listener", "Lkotlin/Function1;", "mobShowSubsGuidance", "enterMethod", "currentPage", "messageId", "triggerScene", "featureKey", "subsPurchaseId", "menuId", "featureDetail", "comQuotaCostReqId", "comQuotaCostFkId", "comWindowGapReqId", "comWindowGapIntentId", "mobClickSubsGuidance", "decodedUrl", "trackingExtra", "Lcom/larus/commercemembership/api/model/CreationSubscriptionTrackingExtra;", "mobShowSubsQuotaManagement", "entryPosition", "mobClickSubsQuotaManagement", "mobPcGuideLinkShow", "position", "mobPcGuideLinkClick", "mobMemberCashierPay", "orderId", "subscriptionId", "payService", d.D, "mobMemberCashierPayResult", "code", "message", "detailCode", "isContainMembershipRouter", "", "content", "getChatMessageMembershipTargetUrl", "getMembershipTargetUrl", "schema", "refreshMembershipConfigAfterSubscriptionChanged", "source", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICommerceMembershipService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f325827a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f325828a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<ICommerceMembershipService> f325829b = null;

        public a() {
        }

        static {
            f325828a = new a();
            f325829b = LazyKt.lazy(new tz8.a());
        }

        public static ICommerceMembershipService a() {
            return f325829b.getValue();
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b {
        public static /* synthetic */ void a(ICommerceMembershipService r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116) {
            r100.n(r110, r111, r112, r113, r114, r115, r116, null);
        }

        public static /* synthetic */ void b(ICommerceMembershipService r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, int r219) {
            if ((r219 & 64) == 0) goto L5;
            String r114 = null;
        L7:
            if ((r219 & 128) == 0) goto L9;
            String r115 = null;
        L11:
            if ((r219 & 256) == 0) goto L13;
            String r116 = null;
        L15:
            if ((r219 & 512) == 0) goto L17;
            String r117 = null;
        L19:
            if ((r219 & 1024) == 0) goto L21;
            String r118 = null;
        L23:
            if ((r219 & 2048) == 0) goto L25;
            String r119 = null;
        L26:
            r110.m(r111, r112, r113, r210, r211, r212, r114, r115, r116, r117, r118, r119);
            return;
        L25:
            r119 = r218;
            goto L26
        L21:
            r118 = r217;
            goto L23
        L17:
            r117 = r216;
            goto L19
        L13:
            r116 = r215;
            goto L15
        L9:
            r115 = r214;
            goto L11
        L5:
            r114 = r213;
            goto L7
        }
    }

    static {
        f325827a = a.f325828a;
    }

    String A(String r100);

    void B(String r100, String r101, String r102, String r103, String r104);

    void a(String r100);

    void b(e r100);

    void c(LifecycleCoroutineScope r100, Function1<? super f, Unit> r101);

    void d(String r100);

    b1 e();

    void f(String r100, String r101);

    void g(String r100);

    void h();

    void i();

    void j(e r100);

    void k();

    boolean l(String r100);

    void m(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112);

    void n(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107);

    void o();

    CommerceMembershipRouterInterceptor p();

    void q();

    void r();

    void s(uz8.b r100, String r101);

    String t(String r100);

    void u(String r100);

    void v(uz8.b r100, String r101);

    void w(String r100, String r101);

    void x();

    f y();

    c z(String r100);
}

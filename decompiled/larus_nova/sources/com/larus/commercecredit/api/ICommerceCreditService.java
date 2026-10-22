package com.larus.commercecredit.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import nz8.b;
import tc9.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 52\u00020\u0001:\u00015J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&JZ\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012H¦@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J \u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H&J\u001a\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010$\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H&J&\u0010(\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0014\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020\t0*H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u000202H&J\u0010\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0003H&¨\u00066"}, d2 = {"Lcom/larus/commercecredit/api/ICommerceCreditService;", "", "isCommerceCreditExperimentEnabled", "", "isCommerceCreditEnabled", "scene", "", "isDisableTouristCreation", "openCommerceCreditInfoPage", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "traceConfig", "Lcom/larus/commercecredit/api/TraceConfig;", "getAtomCreditInfo", "Lcom/larus/commercecredit/api/CreditInfoScene;", "needTasks", "callback", "Lkotlin/Function2;", "Lcom/larus/commercecredit/api/entity/AtomCreditInfo;", "Lkotlin/ParameterName;", "name", "atomCreditInfo", "isFromLocal", "(Lcom/larus/commercecredit/api/CreditInfoScene;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCommerceCreditGuideShowed", "openCommerceCreditGuidePage", "source", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "scope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "triggerInnerNotification", "inAppBannerNotify", "Lcom/larus/im/bean/InAppBannerNotify;", "triggerJoinGroup", "zlinkText", "triggerUserActivity", "updateTotalCreditNum", "totalCreditNum", "", "observeTotalCreditNumChange", "listener", "Lkotlin/Function1;", "isEnableToTriggerZlinkClipboardCheck", "triggerZlinkClipboardCheck", "onPageResumed", "f", "Landroidx/fragment/app/Fragment;", "mobCommerceCreditReceiveStream", "message", "Lcom/larus/im/bean/message/Message;", "debugCommerceCreditGuidePage", "isShowed", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICommerceCreditService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f325667a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f325668a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<ICommerceCreditService> f325669b = null;

        public a() {
        }

        static {
            f325668a = new a();
            f325669b = LazyKt.lazy(new nz8.a());
        }

        public static ICommerceCreditService a() {
            return f325669b.getValue();
        }
    }

    static {
        f325667a = a.f325668a;
    }

    void b(e r100);

    void c(Fragment r100);

    void d(long r100);

    void e(String r100);

    void f(String r100, String r101);

    void g(Message r100);

    void h(String r100, DowngradeSource r101);

    void i(LifecycleCoroutineScope r100, Function1<? super Long, Unit> r101);

    void j(Context r100, DowngradeSource r101, LifecycleCoroutineScope r102);

    boolean k();

    boolean l();

    Object m(CreditInfoScene r100, boolean r101, Function2<? super oz8.a, ? super Boolean, Unit> r102, Continuation<? super Unit> r103);

    boolean n(String r100);

    boolean o(String r100);

    void p(Context r100, b r101);
}

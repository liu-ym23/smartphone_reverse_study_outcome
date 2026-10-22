package com.ss.android.cert.manager.utils.net;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class CertRequestUtils {
    private static final Handler mainHandler = null;

    /* JADX INFO: renamed from: com.ss.android.cert.manager.utils.net.CertRequestUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends BCThread {
        final /* synthetic */ CertRequestCallback val$callback;
        final /* synthetic */ Map val$params;

        public static /* synthetic */ void a(CertRequestCallback r100, CertResponse r101) {
            lambda$run$0(r100, r101);
        }

        @Override // com.ss.android.cert.manager.utils.thread.BCThread, java.lang.Runnable
        public void run() {
            com_ss_android_cert_manager_utils_net_CertRequestUtils$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_android_cert_manager_utils_net_CertRequestUtils$1__run$___twin___() {
            String r100 = UrlConstant.getGreyStrategyPath();
            final CertResponse r101 = new BCNetworkUtils(null).fetchGet(r100, null, this.val$params, null);
            Handler r102 = CertRequestUtils.access$000();
            final CertRequestCallback r103 = this.val$callback;
            r102.post(new a(r103, r101));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_android_cert_manager_utils_net_CertRequestUtils$1_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass1 r100) {
            r100.com_ss_android_cert_manager_utils_net_CertRequestUtils$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AnonymousClass1(Map r100, CertRequestCallback r101) {
            this.val$params = r100;
            this.val$callback = r101;
        }

        private static /* synthetic */ void lambda$run$0(CertRequestCallback r100, CertResponse r101) {
            r100.onRequestFinish(r101);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.cert.manager.utils.net.CertRequestUtils$2, reason: invalid class name */
    public static class AnonymousClass2 extends BCThread {
        final /* synthetic */ CertRequestCallback val$callback;
        final /* synthetic */ Map val$params;

        public static /* synthetic */ void a(CertRequestCallback r100, CertResponse r101) {
            lambda$run$0(r100, r101);
        }

        @Override // com.ss.android.cert.manager.utils.thread.BCThread, java.lang.Runnable
        public void run() {
            com_ss_android_cert_manager_utils_net_CertRequestUtils$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_android_cert_manager_utils_net_CertRequestUtils$2__run$___twin___() {
            String r100 = UrlConstant.getAuthDecisionPath();
            final CertResponse r101 = new BCNetworkUtils(null).fetchGet(r100, null, this.val$params, null);
            Handler r102 = CertRequestUtils.access$000();
            final CertRequestCallback r103 = this.val$callback;
            r102.post(new b(r103, r101));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_android_cert_manager_utils_net_CertRequestUtils$2_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass2 r100) {
            r100.com_ss_android_cert_manager_utils_net_CertRequestUtils$2__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AnonymousClass2(Map r100, CertRequestCallback r101) {
            this.val$params = r100;
            this.val$callback = r101;
        }

        private static /* synthetic */ void lambda$run$0(CertRequestCallback r100, CertResponse r101) {
            r100.onRequestFinish(r101);
        }
    }

    public CertRequestUtils() {
    }

    static {
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ Handler access$000() {
        return mainHandler;
    }

    public static void authDecision(Map<String, String> r100, CertRequestCallback r101) {
        new AnonymousClass2(r100, r101).start();
    }

    public static void getGreyStrategy(Map<String, String> r100, CertRequestCallback r101) {
        new AnonymousClass1(r100, r101).start();
    }
}

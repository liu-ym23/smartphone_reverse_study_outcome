package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface c {

    public static final class a {
        public static void b(StoreTabConfig r1, Map r2) {
            Intrinsics.checkNotNullParameter(r1, "tabConfig");
            Intrinsics.checkNotNullParameter(r2, "metaInfo");
        }

        public static void c(ECStoreParam r1, com.bytedance.android.shopping.store.home.entity.n r2, CommerceBaseResponse r3) {
            Intrinsics.checkNotNullParameter(r1, "storeParam");
            Intrinsics.checkNotNullParameter(r2, "infoData");
            Intrinsics.checkNotNullParameter(r3, "response");
        }

        public static void e(ECStoreViewModel r1, ECStoreParam r2) {
            Intrinsics.checkNotNullParameter(r1, "viewModel");
            Intrinsics.checkNotNullParameter(r2, "storeParam");
        }

        public static void f(ECStoreParam r1, PageType r2) {
            Intrinsics.checkNotNullParameter(r1, "storeParam");
            Intrinsics.checkNotNullParameter(r2, "pageType");
        }

        public static void g(ECStoreViewModel r1, ECStoreParam r2) {
            Intrinsics.checkNotNullParameter(r1, "viewModel");
            Intrinsics.checkNotNullParameter(r2, "storeParam");
        }

        public static void i(Context r1, ECStoreParam r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "storeParam");
        }

        public static void j(ECStoreParam r1, ECStoreTabAreaVO r2, ECStoreHomeTabResponseTabkit r3) {
            Intrinsics.checkNotNullParameter(r1, "storeParam");
            Intrinsics.checkNotNullParameter(r2, "tabData");
            Intrinsics.checkNotNullParameter(r3, "response");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(m r2, String r3, Map r4, JSONObject r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = null;
        L8:
            r2.P(r3, r4, r5);
        }

        public static /* synthetic */ void h(m r9, ECStoreViewModel r10, StoreTabConfig r11, ECStoreParam r12, JSONObject r13, JSONObject r14, int r15) {
            if ((r15 & 8) == 0) goto L5;
            JSONObject r6 = null;
        L7:
            if ((r15 & 16) == 0) goto L9;
            JSONObject r7 = null;
        L10:
            r9.E(r10, r11, r12, r6, r7, false);
            return;
        L9:
            r7 = r14;
            goto L10
        L5:
            r6 = r13;
            goto L7
        }

        public static /* synthetic */ void d(m r12, StoreTabConfig r13, int r14, int r15, Integer r16, Integer r17, String r18, String r19, String r20, int r21) {
            if ((r21 & 8) == 0) goto L5;
            Integer r7 = null;
        L7:
            if ((r21 & 16) == 0) goto L9;
            Integer r8 = null;
        L11:
            if ((r21 & 32) == 0) goto L13;
            String r9 = null;
        L15:
            if ((r21 & 64) == 0) goto L17;
            String r10 = null;
        L19:
            if ((r21 & 128) == 0) goto L21;
            String r11 = null;
        L22:
            r12.D(r13, r14, r15, r7, r8, r9, r10, r11);
            return;
        L21:
            r11 = r20;
            goto L22
        L17:
            r10 = r19;
            goto L19
        L13:
            r9 = r18;
            goto L15
        L9:
            r8 = r17;
            goto L11
        L5:
            r7 = r16;
            goto L7
        }
    }

    void A(ECStoreParam r1);

    void B(Context r1, ECStoreParam r2, JSONObject r3, PageType r4);

    void C();

    void D(StoreTabConfig r1, int r2, int r3, Integer r4, Integer r5, String r6, String r7, String r8);

    void E(ECStoreViewModel r1, StoreTabConfig r2, ECStoreParam r3, JSONObject r4, JSONObject r5, boolean r6);

    void F(uj3.j r1, long r2);

    void G(ECStoreParam r1, ECStoreTabAreaVO r2, ECStoreHomeTabResponseTabkit r3);

    void H();

    void I(StoreTabConfig r1, Map<String, Object> r2);

    void J(ECStoreViewModel r1, ECStoreParam r2, int r3);

    void K();

    void L(f r1);

    void M(int r1, int r2);

    void N(StoreTabConfig r1);

    void O();

    void P(String r1, Map<String, ? extends Object> r2, JSONObject r3);

    void Q(ECStoreParam r1);

    void R(StoreTabConfig r1);

    void S(int r1, ECHybridListAdapter r2);

    void T();

    void a();

    void b();

    void c(StoreTabConfig r1);

    void d(Throwable r1, CommerceBaseResponse r2);

    void e(StoreTabConfig r1);

    void f();

    void g();

    void h(ECStorePreloadInfoResponse r1);

    void i(StoreTabConfig r1);

    void j();

    void k(StoreTabConfig r1);

    void l();

    void m(Context r1);

    void n();

    void o(ECShopHeadInfoBlock r1);

    void onPause();

    void onResume(Context r1);

    void p(StoreTabConfig r1, JSONObject r2, String r3);

    void q(Context r1, ECStoreParam r2);

    void r(int r1, int r2);

    void s(StoreTabConfig r1);

    void t();

    void u(ECStoreParam r1, com.bytedance.android.shopping.store.home.entity.n r2, CommerceBaseResponse r3);

    void v();

    void w();

    void x(StoreTabConfig r1);

    void y();

    void z(ECStorePreloadInfoResponse r1);
}

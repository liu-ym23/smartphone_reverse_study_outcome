package com.bytedance.android.window.shop.widget;

import com.bytedance.android.ec.window.base.shop.PrefetchScene;
import com.bytedance.android.window.shop.home.ECWindowJobKeys;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.prefetch.WindowComponentPrefetchJobKey;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.WindowComponentRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowComponentResponseDTO;
import com.bytedance.android.window.shop.repository.vo.ShopComponentResponseVO;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ECWindowViewModel a;

        public a(ECWindowViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            WindowComponentResponseDTO r3 = (WindowComponentResponseDTO) r2;
            if (r3.getStatusCode() != 0) goto L7;
            ShopComponentResponseVO r0 = new ShopComponentResponseVO();
            uq3.h.a(r0, r3);
            this.a.getComponentResponse().c(r0);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.widget.b$b, reason: collision with other inner class name */
    public static final class C0042b<T> implements Consumer {
        public static final C0042b a = null;

        static {
            a = new C0042b();
        }

        public C0042b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public static Disposable a(ECWindowViewModel r5, lq3.b r6) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        ECWindowParam r0 = r5.getShopParam();
        ShopRepository r1 = ShopRepository.a;
        WindowComponentRequestParam r2 = new WindowComponentRequestParam();
        r2.setSecAuthorId(r0.getSecAuthorId());
        r2.setSourceType(r0.getSourceType());
        r2.setPassThroughApi(String.valueOf(r0.getPassThroughParams().get("pass_through_api")));
        r2.setExtraSchema(r0.getExtraSchema());
        r2.setSceneParams(r6);
        Unit r7 = Unit.INSTANCE;
        ECWindowJobKeys r8 = r0.getWindowJobKeys();
        if (r8 == null) goto L5;
        WindowComponentPrefetchJobKey r9 = r8.getComponentJobKey();
    L6:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        ConcurrentHashMap r3 = com.bytedance.android.ec.window.base.shop.l.a;
        ReplaySubject r10 = com.bytedance.android.ec.window.base.shop.l.b(PrefetchScene.WINDOW, r9);
        if (r10 != null) goto L10;
        r10 = ShopRepository.a(r2);
    L10:
        return r10.subscribeOn(Schedulers.io()).subscribe(new a(r5), C0042b.a);
    L5:
        r9 = null;
        goto L6
    }
}

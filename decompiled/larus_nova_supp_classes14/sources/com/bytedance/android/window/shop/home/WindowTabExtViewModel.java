package com.bytedance.android.window.shop.home;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.dto.WindowProductExtDataDTO;
import com.bytedance.android.window.shop.repository.dto.y0;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J,\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0011j\u0002`\u0012J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0004R<\u0010\u0019\u001a*\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0011j\u0002`\u00120\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/window/shop/home/WindowTabExtViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Lcom/bytedance/android/window/shop/repository/dto/WindowProductExtDataDTO;", "dto", "", "dispatchRefreshInfo", "", "promotionId", "Lcom/bytedance/android/window/shop/repository/dto/y0;", "refreshInfo", "secAuthorId", "passThroughApi", "", "Lcom/bytedance/android/ec/window/base/repository/vo/WindowV2ProductItemVO;", "products", "loadProductExtData", "getExtData", "Lkotlin/Function2;", "Lcom/bytedance/android/window/shop/home/ExtDataObserver;", "observer", "subscribeOnce", "unsubscribe", "dropAll", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "registry", "Ljava/util/concurrent/ConcurrentHashMap;", "knownData", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabExtViewModel extends BaseViewModel {
    private final ConcurrentHashMap<String, y0> knownData;
    private final ConcurrentHashMap<String, WeakReference<Function2<String, y0, Unit>>> registry;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ WindowTabExtViewModel a;

        public a(WindowTabExtViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            WindowTabExtViewModel r0 = this.a;
            WindowTabExtViewModel.access$dispatchRefreshInfo(r0, (WindowProductExtDataDTO) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    public WindowTabExtViewModel() {
        super(null, null, 3, null);
        this.registry = new ConcurrentHashMap();
        this.knownData = new ConcurrentHashMap();
    }

    public final void dropAll() {
        this.registry.clear();
        this.knownData.clear();
    }

    private final void dispatchRefreshInfo(WindowProductExtDataDTO r3) {
        if (r3 == null) goto L10;
        Map<String, y0> r4 = r3.getAllRefreshInfo();
        if (r4 == null) goto L12;
        Iterator<Map.Entry<String, y0>> r5 = r4.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, y0> r0 = r5.next();
        dispatchRefreshInfo(r0.getKey(), r0.getValue());
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final y0 getExtData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        return this.knownData.get(r2);
    }

    public final void unsubscribe(String r2) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        this.registry.remove(r2);
    }

    public static final /* synthetic */ void access$dispatchRefreshInfo(WindowTabExtViewModel r0, WindowProductExtDataDTO r1) {
        r0.dispatchRefreshInfo(r1);
    }

    private final void dispatchRefreshInfo(String r2, y0 r3) {
        this.knownData.put(r2, r3);
        WeakReference<Function2<String, y0, Unit>> r0 = this.registry.get(r2);
        if (r0 == null) goto L8;
        Function2<String, y0, Unit> r1 = r0.get();
        if (r1 == null) goto L9;
        Unit r4 = (Unit) r1.invoke(r2, r3);
        return;
    L9:
        return;
    }

    public final void subscribeOnce(String r3, Function2<? super String, ? super y0, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionId");
        Intrinsics.checkNotNullParameter(r4, "observer");
        this.registry.put(r3, new WeakReference(r4));
    }

    public final void loadProductExtData(String r11, String r12, List<? extends WindowV2ProductItemVO> r13) {
        Intrinsics.checkNotNullParameter(r11, "secAuthorId");
        Intrinsics.checkNotNullParameter(r12, "passThroughApi");
        Intrinsics.checkNotNullParameter(r13, "products");
        ArrayList r1 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        String r2 = a2.c(((WindowV2ProductItemVO) r14.next()).H);
        if (r2 == null) goto L4;
        r1.add(r2);
        goto L4
    L9:
        if (r1.isEmpty() == false) goto L11;
        return;
    L11:
        int r15 = kq3.a.a;
        Intrinsics.checkNotNullParameter(r11, "secAuthorId");
        Intrinsics.checkNotNullParameter(r1, "params");
        ECWindowApi.a.getClass();
        ECWindowApi r16 = ECWindowApi.a.b;
        if (r16 == null) goto L15;
        Observable<WindowProductExtDataDTO> r17 = r16.getCardExtData(r11, r12, CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null));
        if (r17 == null) goto L15;
    L16:
        add(bg4.b.b(r17).subscribe(new a(this), b.a));
        return;
    L15:
        r17 = Observable.error(new Throwable("ECNetworkService not init"));
        goto L16
    }
}

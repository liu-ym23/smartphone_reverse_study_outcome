package com.bytedance.android.shopping.store.tabkit.monitor;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.ECStoreJsbErrorCode;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabKitAppMonitor {
    public static final Observable<Boolean> a = null;
    public static final ConcurrentHashMap<String, a> b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/monitor/TabKitAppMonitor$AppState;", "", "UNKNOWN", "FOREGROUND", "BACKGROUND", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AppState extends Enum<AppState> {
        public static final AppState BACKGROUND = null;
        public static final AppState FOREGROUND = null;
        public static final AppState UNKNOWN = null;
        public static final /* synthetic */ AppState[] a = null;

        static {
            AppState r1 = new AppState("UNKNOWN", 0);
            UNKNOWN = r1;
            AppState r2 = new AppState("FOREGROUND", 1);
            FOREGROUND = r2;
            AppState r3 = new AppState("BACKGROUND", 2);
            BACKGROUND = r3;
            a = new AppState[]{r1, r2, r3};
        }

        public static AppState valueOf(String r1) {
            return (AppState) r27.a.a(AppState.class, r1);
        }

        public static AppState[] values() {
            return (AppState[]) a.clone();
        }

        public AppState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public boolean a;

        public a() {
            Observable<Boolean> r0 = TabKitAppMonitor.a;
            int r1 = ECSdk.a;
            IEShoppingService r2 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
            if (r2 == null) goto L8;
            n83.a r3 = r2.getAppLifecycleObserver();
            if (r3 == null) goto L8;
            r3.isAppInBackground();
        L8:
            if (AppState.FOREGROUND != AppState.BACKGROUND) goto L10;
            boolean r4 = true;
        L11:
            this.a = r4;
            return;
        L10:
            r4 = false;
            goto L11
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r5) {
            Observable<Boolean> r0 = TabKitAppMonitor.a;
            boolean r6 = ((Boolean) r5).booleanValue();
            Iterator<Map.Entry<String, a>> r1 = TabKitAppMonitor.b.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            a r2 = r1.next().getValue();
            if (r6 == true) goto L7;
            AppState r3 = AppState.FOREGROUND;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            goto L4
        L7:
            AppState r4 = AppState.BACKGROUND;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r2.a = true;
            goto L4
        }
    }

    static {
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 == null) goto L5;
        Observable<Boolean> r1 = r0.getAppBackgroundStateObservable();
    L6:
        a = r1;
        if (r1 == null) goto L9;
        r1.subscribe(b.a);
    L9:
        b = new ConcurrentHashMap();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static String a(Long r1, Integer r2) {
        if (r1 == null) goto L9;
        r1.longValue();
        if (r2 == null) goto L6;
        int r3 = r2.intValue();
    L7:
        StringBuilder r0 = new StringBuilder();
        r0.append(r1);
        r0.append('_');
        r0.append(r3);
        return r0.toString();
    L6:
        r3 = ECStoreJsbErrorCode.JSON_ERROR;
        goto L7
    L9:
        return null;
    }

    public static void c(Long r1, Integer r2) {
        if (a != null) goto L5;
        return;
    L5:
        String r3 = a(r1, r2);
        if (r3 == null) goto L9;
        a r4 = b.putIfAbsent(r3, new a());
        return;
    }

    public static Boolean b(Long r1, Integer r2, Integer r3) {
        if (r1 == null) goto L18;
        r1.longValue();
        if (r2 == null) goto L19;
        r2.intValue();
        if (r3 != null) goto L9;
    L11:
        String r4 = a(r1, r2);
    L12:
        if (r4 != null) goto L14;
        return null;
    L14:
        a r5 = b.get(r4);
        if (r5 != null) goto L17;
        return null;
    L17:
        return Boolean.valueOf(r5.a);
    L9:
        if (Intrinsics.areEqual(r2, r3) == false) goto L11;
        r4 = a(r1, null);
        goto L12
    L19:
        return null;
    L18:
        return null;
    }
}

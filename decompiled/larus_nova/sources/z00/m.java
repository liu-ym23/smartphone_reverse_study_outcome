package z00;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.LocationApiForSaas;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569602a = 0;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f569603a;

        public a(Function1 r100) {
            this.f569603a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            u00.d r101 = ((u00.f) ((Response) r100).data).a();
            if (r101 == null) goto L8;
            u00.e r102 = r101.a();
            if (r102 == null) goto L8;
            String r103 = r102.a();
            if (r103 == null) goto L8;
        L9:
            this.f569603a.invoke(r103);
            return;
        L8:
            r103 = "";
            goto L9
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f569604a = null;

        static {
            f569604a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = m.f569602a;
            ALogger.stacktrace(6, "PreviewLocationWidgetForSaas", ((Throwable) r100).getStackTrace());
        }
    }

    static {
    }

    public static void a(LocationManager r110, String r111, l r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, 3000L, Float.valueOf(3000.0f), r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100001);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(100001, "android/location/LocationManager", "requestLocationUpdates", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.requestLocationUpdates(r111, 3000, 3000.0f, r210);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void b(Context r100, Location r101, Function1 r102) {
        Observable<R> r103 = ((LocationApiForSaas) com.bytedance.android.live.network.c.b().e(LocationApiForSaas.class)).getLocationDesc(r101.getLongitude(), r101.getLatitude()).compose(RxUtil.rxSchedulerHelper());
        if (r103 != 0) goto L5;
        return;
    L5:
        if ((r100 instanceof FragmentActivity) == true) goto L7;
        r100 = null;
    L7:
        ObservableSubscribeProxy r104 = (ObservableSubscribeProxy) r103.as(AutoDispose.bind((FragmentActivity) r100));
        if (r104 == null) goto L12;
        r104.subscribe(new a(r102), b.f569604a);
        return;
    }
}

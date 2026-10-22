package x10;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class b<T> implements ObservableTransformer<T, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PluginContext f562104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562106c;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f562107a;

        public a(b r100) {
            this.f562107a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) {
            b.b(this.f562107a, 0, null, 6);
        }
    }

    /* JADX INFO: renamed from: x10.b$b, reason: collision with other inner class name */
    public static final class C8181b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f562108a;

        public C8181b(b r100) {
            this.f562108a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            boolean r100 = false;
            String r101 = "";
            if ((r111 instanceof CustomApiServerException) == false) goto L9;
            JSONObject r102 = new JSONObject(((CustomApiServerException) r111).getExtra());     // Catch: Exception -> L7
            this.f562108a.a(100000, String.valueOf(r102.optInt("errcode", 0)), r102.optString(BdpAppEventConstant.PARAMS_REQUEST_URL, ""));     // Catch: Exception -> L7
            return;
        L7:
            b.b(this.f562108a, 100000, "custom api error", 4);
            return;
        L9:
            if ((r111 instanceof NetworkErrorException) == false) goto L30;
            this.f562108a.getClass();     // Catch: Exception -> L22
            String r103 = ((NetworkErrorException) r111).getMessage();     // Catch: Exception -> L22
            if (r103 == null) goto L23;
            int r104 = r103.length();     // Catch: Exception -> L22
            int r105 = StringsKt.indexOf$default(r103, "net::", 0, false, 6, null);     // Catch: Exception -> L22
            if (r105 == (-1)) goto L23;
            int r106 = r105 + 5;     // Catch: Exception -> L22
            if (r106 >= r104) goto L23;
            int r107 = StringsKt.indexOf$default(r103, ",", r106, false, 4, null);     // Catch: Exception -> L22
            if (r107 == (-1)) goto L23;
            if (r106 > r107) goto L23;
            if (r107 >= r104) goto L23;
            r101 = r103.substring(r106, r107);     // Catch: Exception -> L22
        L23:
            b r108 = this.f562108a;
            if (r101.length() != 0) goto L26;
            r100 = true;
        L26:
            if (r100 == false) goto L28;
            r101 = r111.getMessage();
        L28:
            b.b(r108, 100001, r101, 4);
            return;
        L30:
            if ((r111 instanceof SocketTimeoutException) == false) goto L32;
        L35:
            b.b(this.f562108a, 100002, r111.getClass().getName(), 4);
            return;
        L32:
            if ((r111 instanceof IOException) == true) goto L35;
            b.b(this.f562108a, 99999, r111.getClass().getName(), 4);
        }
    }

    public final String getType() {
        return this.f562106c;
    }

    @Override // io.reactivex.ObservableTransformer
    public final ObservableSource<T> apply(Observable<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "upstream");
        return r100.doOnNext(new a(this)).doOnError(new C8181b(this));
    }

    public b(PluginContext r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f562104a = r100;
        this.f562105b = r101;
        this.f562106c = r102;
    }

    public final void a(int r100, String r101, String r102) {
        if (r102 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        String r104 = UriProtector.parse(r102).getPath();
    L11:
        String r105 = this.f562106c;
        int r106 = e.f562109a;
        e.a(this.f562104a, r100, r101, r104, r105);
        return;
    L10:
        r104 = this.f562105b;
        goto L11
    L4:
        if (r102.length() == 0) goto L7;
        r103 = false;
        goto L8
    }

    public static /* synthetic */ void b(b r100, int r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = "";
    L5:
        r100.a(r101, r102, null);
    }
}

package yj2;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.livecommerce.room.api.c;
import com.bytedance.android.livesdk.livecommerce.utils.p0;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<c> f568070a;

    static {
    }

    @JvmStatic
    public static final void a(Context r100, ge.b r101, p0 r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "observer");
        if (r100 != null) goto L6;
        new Throwable("no context");
        return;
    L6:
        WeakReference<c> r103 = f568070a;
        if (r103 == null) goto L16;
        c r104 = r103.get();
        if (r104 == null) goto L17;
        int r105 = ge.b.f480992h;
        ge.b.a r106 = new ge.b.a();
        String r107 = r101.f480996d;
        Intrinsics.checkNotNullParameter(r107, "source");
        r106.f481003d = r107;
        String r108 = r101.f480998f;
        Intrinsics.checkNotNullParameter(r108, ReportConstant.COMMON_ACTION_TYPE);
        r106.f481005f = r108;
        String r109 = r101.f480997e;
        Intrinsics.checkNotNullParameter(r109, "enterFrom");
        r106.f481004e = r109;
        r106.f481002c = r101.f480995c;
        String r110 = r101.f480994b;
        Intrinsics.checkNotNullParameter(r110, "imageUrl");
        r106.f481001b = r110;
        String r111 = r101.f480993a;
        Intrinsics.checkNotNullParameter(r111, "msg");
        r106.f481000a = r111;
        Bundle r112 = r101.f480999g;
        Intrinsics.checkNotNullParameter(r112, "bundle");
        r106.f481006g = r112;
        Observable<ge.a> r113 = r104.g(r100, new ge.b(r106));
        if (r113 == null) goto L18;
        ObservableSource r114 = r113.map(a.f568069a);
        if (r114 == null) goto L19;
        r114.subscribe(r102);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }
}

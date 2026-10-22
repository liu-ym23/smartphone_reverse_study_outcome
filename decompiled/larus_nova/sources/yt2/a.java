package yt2;

import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.core.app.BundleCompat;
import com.bytedance.android.livesdk.config.ti;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.io.Serializable;
import jc1.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f569043a = null;

    static {
        f569043a = ti.f121301a.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        return f569043a.booleanValue();
    }

    @JvmStatic
    public static final Serializable c(Bundle r100) {
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.EXTRA_PULL_ORIGIN_STREAM_URL, "key");
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r102 = r100.get(ILiveRoomPlayFragmentConstant.EXTRA_PULL_ORIGIN_STREAM_URL);
        if (r102 == null) goto L12;
        if ((r102 instanceof Serializable) == false) goto L12;
        return (Serializable) r102;
    L12:
        if (a() == false) goto L24;
        IBinder r103 = BundleCompat.getBinder(r100, ILiveRoomPlayFragmentConstant.EXTRA_PULL_ORIGIN_STREAM_URL);
        if ((r103 instanceof g) == true) goto L16;
        r103 = null;
    L16:
        g r104 = (g) r103;
        if (r104 == null) goto L25;
        Object r105 = r104.f498078a;
        if ((r105 instanceof Serializable) == false) goto L23;
        r101 = r105;
    L23:
        return (Serializable) r101;
    L25:
        return null;
    L24:
        return null;
    }

    @JvmStatic
    public static final SparseArray d(Bundle r100) {
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.EXTRA_MORE_BUNDLE, "key");
        Object r101 = r100.get(ILiveRoomPlayFragmentConstant.EXTRA_MORE_BUNDLE);
        if (r101 != null) goto L5;
    L8:
        Object r102 = null;
        if (a() == false) goto L21;
        IBinder r103 = BundleCompat.getBinder(r100, ILiveRoomPlayFragmentConstant.EXTRA_MORE_BUNDLE);
        if ((r103 instanceof g) == true) goto L13;
        r103 = null;
    L13:
        g r104 = (g) r103;
        if (r104 == null) goto L22;
        Object r105 = r104.f498078a;
        if ((r105 instanceof SparseArray) == false) goto L20;
        r102 = r105;
    L20:
        return (SparseArray) r102;
    L22:
        return null;
    L21:
        return null;
    L5:
        if ((r101 instanceof SparseArray) == false) goto L8;
        return (SparseArray) r101;
    }

    @JvmStatic
    public static final Bundle b(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r103 = r100.get(r101);
        if (r103 == null) goto L12;
        if ((r103 instanceof Bundle) == false) goto L12;
        return (Bundle) r103;
    L12:
        if (a() == false) goto L24;
        IBinder r104 = BundleCompat.getBinder(r100, r101);
        if ((r104 instanceof g) == true) goto L16;
        r104 = null;
    L16:
        g r105 = (g) r104;
        if (r105 == null) goto L25;
        Object r106 = r105.f498078a;
        if ((r106 instanceof Bundle) == false) goto L23;
        r102 = r106;
    L23:
        return (Bundle) r102;
    L25:
        return null;
    L24:
        return null;
    }

    @JvmStatic
    public static final String e(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r103 = r100.get(r101);
        if (r103 == null) goto L12;
        if ((r103 instanceof String) == false) goto L12;
        return (String) r103;
    L12:
        if (a() == false) goto L24;
        IBinder r104 = BundleCompat.getBinder(r100, r101);
        if ((r104 instanceof g) == true) goto L16;
        r104 = null;
    L16:
        g r105 = (g) r104;
        if (r105 == null) goto L25;
        Object r106 = r105.f498078a;
        if ((r106 instanceof String) == false) goto L23;
        r102 = r106;
    L23:
        return (String) r102;
    L25:
        return null;
    L24:
        return null;
    }

    @JvmStatic
    public static final void f(Bundle r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.EXTRA_PULL_ORIGIN_STREAM_URL, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r100 != null) goto L6;
        return;
    L6:
        if (a() == false) goto L8;
        BundleCompat.putBinder(r100, ILiveRoomPlayFragmentConstant.EXTRA_PULL_ORIGIN_STREAM_URL, new g(r101));
        return;
    L8:
        r100.putSerializable(ILiveRoomPlayFragmentConstant.EXTRA_PULL_ORIGIN_STREAM_URL, r101);
    }

    @JvmStatic
    public static final void g(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (r100 != null) goto L6;
        return;
    L6:
        if (a() == false) goto L8;
        BundleCompat.putBinder(r100, r101, new g(r102));
        return;
    L8:
        r100.putString(r101, r102);
    }
}

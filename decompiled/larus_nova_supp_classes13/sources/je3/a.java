package je3;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p83.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements c {
    public static final List<Function2<String, Float, Unit>> a = null;
    public static final List<Function1<String, Unit>> b = null;
    public static final List<Function1<String, Unit>> c = null;
    public static final List<WeakReference<b>> d = null;
    public static final a e = null;

    public a() {
    }

    static {
        e = new a();
        a = new ArrayList();
        b = new ArrayList();
        c = new ArrayList();
        new Handler(Looper.getMainLooper());
        d = new ArrayList();
    }
}

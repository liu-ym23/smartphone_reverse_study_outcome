package kg1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f503349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f503350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f503351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IRoomCart f503352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f503353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f503354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f503355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static WeakReference<DataCenter> f503356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Disposable f503357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f503358j;

    static {
    }

    public static void a(boolean r100, boolean r101) {
        a r102 = new a(r101, r100);
        WeakReference<DataCenter> r103 = f503356h;
        if (r103 == null) goto L8;
        DataCenter r104 = r103.get();
        if (r104 == null) goto L9;
        r104.put("CMD_DOUYIN_LITE_COMMERCE_READY", r102);
        return;
    L9:
        return;
    }
}

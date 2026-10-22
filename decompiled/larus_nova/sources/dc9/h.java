package dc9;

import android.app.Activity;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f467895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f467896b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f467897c = null;

    static {
        f467895a = LazyKt.lazy(new e());
        f467896b = SetsKt.setOf("com.larus.sheet.impl.SheetActivity");
        f467897c = LazyKt.lazy(new f());
    }

    public static boolean a(Activity r100) {
        String r101 = r100.getClass().getName();
        int r102 = r100.getRequestedOrientation();
        if (r102 == 3) goto L6;
    L9:
        boolean r103 = false;
    L11:
        FLogger.f375446a.i("PadController", "check, page:" + r101 + ",oldOrientation:" + r102 + ",result:" + r103);
        return r103;
    L6:
        if (Build.VERSION.SDK_INT == 26) goto L8;
    L10:
        r103 = true;
        goto L11
    L8:
        if (((List) f467897c.getValue()).contains(r101) == false) goto L10;
        goto L9
    }
}

package ia8;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.nova.R;
import com.larus.platform.service.i2;
import com.larus.utils.j0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f488929a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f488930b = null;

    static {
        if (Build.VERSION.SDK_INT > 29) goto L5;
        String r100 = "android.permission.WRITE_EXTERNAL_STORAGE";
    L6:
        f488929a = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        int r102 = j0.f375426a;
        r101.put("android.permission.WRITE_EXTERNAL_STORAGE", j0.d(R.string.larus_dora_album_permission_title));
        f488930b = r101;
        return;
    L5:
        r100 = null;
        goto L6
    }

    public static boolean a(Context r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r102 = f488929a;
        if (r102 != null) goto L8;
        return true;
    L8:
        if (ContextCompat.checkSelfPermission(r100, r102) != 0) goto L11;
        r101 = true;
    L11:
        return r101;
    }

    public static void b(Fragment r100, final Function1 r101) {
        String r102 = f488929a;
        if (r102 == null) goto L5;
        i2.f365748b.b(r100, CollectionsKt.listOf(r102), new a(r101), f488930b);
        return;
    L5:
        r101.invoke(Boolean.TRUE);
    }
}

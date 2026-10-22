package h18;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483538a = 0;

    static {
    }

    @JvmStatic
    public static final String a(Context r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        String r104 = r100.getResources().getString(r101);
        HashMap r105 = new HashMap(1);
        r105.put(r102, r103);
        String r106 = com.samskivert.mustache.e.a().b().a(r104).b(r105);     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L6
        return r106;
    L9:
        return r104;
    }
}

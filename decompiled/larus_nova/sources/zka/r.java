package zka;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f572736a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f572737a = null;

        static {
            f572737a = new a();
        }

        public a() {
        }

        public static boolean a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_CALENDAR") == 0) goto L5;
        L7:
            return false;
        L5:
            if (ContextCompat.checkSelfPermission(r100, "android.permission.WRITE_CALENDAR") != 0) goto L7;
            return true;
        }
    }

    static {
        f572736a = a.f572737a;
    }
}

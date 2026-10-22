package iqb;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.location.service.SearchResultErrorCode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f495412a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f495413a = null;

        static {
            int[] r100 = new int[SearchResultErrorCode.values().length];
            r100[SearchResultErrorCode.OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SearchResultErrorCode.NETWORK_FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f495413a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(Context r100, com.ss.android.lark.location.service.k r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "error");
        SearchResultErrorCode r102 = r101.f431208b;
        int r103 = a.f495413a[r102.ordinal()];
        if (r103 != 1) goto L5;
        int r104 = R.string.Lark_Core_MapServicesErrorMessage_NoLocationsFound;
    L9:
        UDToast.show(r100, r104, R.drawable.ud_icon_warning_outlined);
        return;
    L5:
        if (r103 == 2) goto L7;
        r104 = R.string.Lark_Core_MapServicesErrorMessage_UnableToSearchRetry;
        goto L9
    L7:
        r104 = R.string.Lark_Core_MapServicesErrorMessage_NetworkErrorRetry;
        goto L9
    }
}

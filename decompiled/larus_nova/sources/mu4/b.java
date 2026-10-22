package mu4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.BitableShareParams;
import com.bytedance.ee.bear.share.EShareType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f515746a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f515747a = null;

        static {
            int[] r100 = new int[EShareType.values().length];
            r100[EShareType.DASHBOARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[EShareType.DASHBOARD_REDIRECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[EShareType.FORM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[EShareType.Record.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[EShareType.BASE_ADD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[EShareType.BASE_ADD_SUBMIT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f515747a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(Context r100, EShareType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "shareType");
        if (a.f515747a[r101.ordinal()] != 3) goto L6;
        return r100.getString(R.string.Bitable_Form_AddCollaborator);
    L6:
        return r100.getString(R.string.Bitable_Share_AddViewers_Title);
    }

    @JvmStatic
    public static final String c(Context r100, EShareType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "shareType");
        switch(a.f515747a[r101.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L4;
        };
    L4:
        return "";
    L12:
        return r100.getString(R.string.Bitable_QuickAdd_ShareThisPage_Button);
    L13:
        return r100.getString(R.string.Bitable_QuickAdd_ShareThisPage_Button);
    L14:
        return r100.getString(R.string.Bitable_Share_ShareThisRecord_Title);
    L15:
        return r100.getString(R.string.Bitable_Form_ShareForm);
    L10:
        return r100.getString(R.string.Bitable_Share_ShareThisDashboard_Title);
    }

    @JvmStatic
    public static final String b(Context r100, EShareType r101, BitableShareParams r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "shareType");
        Intrinsics.checkNotNullParameter(r102, "params");
        int r103 = a.f515747a[r101.ordinal()];
        if (r103 == 1) goto L12;
        if (r103 == 3) goto L15;
        if (r103 == 4) goto L14;
        return "";
    L14:
        return xo5.a.c(r100, R.string.Bitable_Share_ExternalSharePopUp_Description, "title", r102.getDocName()) + ' ' + r102.getUrl();
    L15:
        return xo5.a.c(r100, R.string.Bitable_Form_ShareViaWechat, "formName", r102.getDocName()) + ' ' + r102.getUrl();
    L12:
        return xo5.a.c(r100, R.string.Bitable_Dashboard_ComeToViewSharedDashboard_Description, "dashboardName", r102.getDocName()) + ' ' + r102.getUrl();
    }
}

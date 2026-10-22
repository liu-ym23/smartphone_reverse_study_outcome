package u2b;

import android.content.Context;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f548512a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f548513b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f548514c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f548515d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f548516e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f548517f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f548518g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f548519h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f548520i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f548521j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f548522k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f548523l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f548524m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f548525n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f548526o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f548527p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f548528q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f548529r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f548530s = 0;

    static {
        f548512a = UIHelper.dp2px(56.0f);
        f548513b = 20;
        f548514c = UIHelper.dp2px(5.0f);
        f548515d = UIHelper.dp2px(16.0f);
        UIHelper.dp2px(6.0f);
        f548516e = UIHelper.dp2px(12.0f);
        f548517f = UIHelper.dp2px(15.0f);
        f548518g = UIHelper.dp2px(16.0f);
        f548519h = UIHelper.dp2px(16.0f);
        f548520i = UIHelper.dp2px(48.0f);
        f548521j = UIHelper.dp2px(36.0f);
        f548522k = UIHelper.dp2px(6.0f);
        f548523l = UIHelper.dp2px(16.0f);
        f548524m = UIHelper.dp2px(12.0f);
        f548525n = UIHelper.dp2px(16.0f);
        f548526o = UIHelper.dp2px(36.0f);
        f548527p = UIHelper.dp2px(24.0f);
        f548528q = UIHelper.dp2px(24.0f);
        f548529r = UIHelper.dp2px(21.0f);
        f548530s = UIHelper.dp2px(2.0f);
    }

    @JvmStatic
    public static final int a(Context r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = zz7.b.g(r100, 32);
        int r103 = UIHelper.dp2px(32.0f);
        int r104 = f548512a + (r102 - r103);
        return (((n(r100, r101) - r104) - f548515d) - zz7.b.g(r100, f548513b)) - f548514c;
    }

    @JvmStatic
    public static final int b(Context r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (n(r100, r101) - (f548518g * 2)) - f548530s;
    }

    @JvmStatic
    public static final int d(Context r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (a(r100, r101) - (f548516e * 2)) - f548530s;
    }

    @JvmStatic
    public static final int f(Context r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return n(r100, r101) - (f548523l * 2);
    }

    @JvmStatic
    public static final int k(Context r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ((n(r100, r101) - (f548518g * 2)) - f548519h) - f548530s;
    }

    @JvmStatic
    public static final int l(Context r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ((n(r100, r101) - (f548519h * 2)) - f548520i) - f548530s;
    }

    public static int n(Context r100, Integer r101) {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.fold.support") == false) goto L5;
        if (r101 == null) goto L13;
        if (r101.intValue() <= 0) goto L13;
        return r101.intValue();
    L13:
        return DeviceUtils.getScreenWidth(r100);
    L5:
        return DeviceUtils.getScreenWidth(r100);
    }

    public static int c(Context r100, Integer r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = zz7.b.g(r100, 32);
        int r104 = UIHelper.dp2px(32.0f);
        int r105 = f548512a + (r103 - r104);
        int r106 = ((n(r100, r101) - r105) - f548515d) - (f548516e * 2);
        if (r102 == false) goto L5;
        int r107 = f548517f * 2;
    L7:
        return ((r106 - r107) - zz7.b.g(r100, f548513b)) - f548514c;
    L5:
        r107 = 0;
        goto L7
    }

    public static int g(Context r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = f548521j + f548522k;
        int r104 = n(r100, r102) - (f548518g * 2);
        if (r101 == false) goto L5;
        int r105 = f548527p;
    L6:
        int r106 = (r104 - r105) - r103;
        int r107 = r100.getResources().getDimensionPixelSize(R.dimen.im_message_cell_max_width);
        if (r107 <= 0) goto L11;
        r106 = Math.min(r107, r106);
    L11:
        return r106 - (f548524m * 2);
    L5:
        r105 = 0;
        goto L6
    }

    public static int h(Context r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = n(r100, r102) - (f548518g * 2);
        if (r101 == false) goto L5;
        int r104 = f548527p;
    L6:
        int r105 = r103 - r104;
        int r106 = r100.getResources().getDimensionPixelSize(R.dimen.im_message_cell_max_width);
        if (r106 <= 0) goto L11;
        r105 = Math.min(r106, r105);
    L11:
        return r105 - (f548524m * 2);
    L5:
        r104 = 0;
        goto L6
    }

    @JvmStatic
    public static final int m(Context r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == false) goto L5;
        int r103 = n(r100, r102) - (f548518g * 2);
        int r104 = f548519h;
    L7:
        return r103 - r104;
    L5:
        r103 = n(r100, r102);
        r104 = f548518g * 2;
        goto L7
    }

    @JvmStatic
    public static final int e(Context r100, Integer r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r104 = ((n(r100, r101) - (f548518g * 2)) - (f548517f * 2)) - f548530s;
        int r105 = 0;
        if (r102 == true) goto L5;
    L7:
        int r106 = 0;
    L8:
        int r107 = r104 - r106;
        if (r103 == false) goto L12;
        r105 = f548528q;
    L12:
        return r107 - r105;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.thread.read_receipt") == false) goto L7;
        r106 = f548529r;
        goto L8
    }

    @JvmStatic
    public static final int i(Context r100, boolean r101, Integer r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r104 = (n(r100, r102) - (f548518g * 2)) - f548530s;
        if (r101 == false) goto L5;
        int r105 = f548527p;
    L6:
        int r106 = (r104 - r105) - UIHelper.dp2px(20.0f);
        if (r103 == true) goto L9;
    L11:
        int r107 = 0;
    L13:
        return r106 - r107;
    L9:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.thread.read_receipt") == false) goto L11;
        r107 = f548529r;
        goto L13
    L5:
        r105 = f548519h;
        goto L6
    }

    @JvmStatic
    public static final int j(Context r100, boolean r101, Integer r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r104 = (((n(r100, r102) - (f548518g * 2)) - f548521j) - f548522k) - f548530s;
        if (r101 == false) goto L5;
        int r105 = f548527p;
    L6:
        int r106 = r104 - r105;
        if (r103 == true) goto L9;
    L11:
        int r107 = 0;
    L13:
        return r106 - r107;
    L9:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.thread.read_receipt") == false) goto L11;
        r107 = f548529r;
        goto L13
    L5:
        r105 = f548519h;
        goto L6
    }
}

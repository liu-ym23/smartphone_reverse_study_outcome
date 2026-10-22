package n3b;

import android.content.Context;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements o3b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f517009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f517010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f517011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f517012d;

    /* JADX INFO: renamed from: n3b.a$a, reason: collision with other inner class name */
    public static final class C6887a {
    }

    static {
    }

    @Override // o3b.a
    public final int a() {
        return 36;
    }

    @Override // o3b.a
    public final int c() {
        return 54;
    }

    public a() {
        this.f517009a = 12;
        this.f517010b = 54;
        this.f517011c = 0;
        this.f517012d = 0;
    }

    public final int e(Context r100, Integer r101) {
        int r102 = UIUtils.dp2px(r100, 54) + (zz7.b.g(r100, 36) - UIUtils.dp2px(r100, 36));
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.fold.support") == true) goto L5;
        int r103 = DeviceUtils.getScreenWidth(r100);
    L12:
        return (((r103 - r102) - UIUtils.dp2px(r100, this.f517010b)) - zz7.b.g(r100, this.f517011c)) - UIUtils.dp2px(r100, this.f517012d);
    L5:
        if (r101 != null) goto L7;
    L10:
        r103 = DeviceUtils.getScreenWidth(r100);
        goto L12
    L7:
        if (r101.intValue() <= 0) goto L10;
        r103 = r101.intValue();
        goto L12
    }

    @Override // o3b.a
    public final int b(Context r100, Integer r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (e(r100, r101) - (UIUtils.dp2px(r100, this.f517009a) * 2)) - UIUtils.dp2px(r100, 2.0f);
    }

    @Override // o3b.a
    public final int d(Context r100, Integer r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return e(r100, r101);
    }
}

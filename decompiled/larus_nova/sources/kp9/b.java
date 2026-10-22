package kp9;

import android.content.Context;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements lp9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f505530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<Boolean> f505531b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableSharedFlow f505532c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f505533d = null;

    public b() {
    }

    static {
        f505530a = new b();
        MutableSharedFlow<Boolean> r100 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        f505531b = r100;
        f505532c = r100;
        f505533d = LazyKt.lazy(new a());
    }

    @Override // lp9.a
    public final void a() {
        FLogger.f375446a.i("BottomPhotoPickerFragment", "recordAddImage");
        f505531b.tryEmit(Boolean.TRUE);
    }

    @Override // lp9.a
    public final MutableSharedFlow b() {
        return f505532c;
    }

    @Override // lp9.a
    public final boolean c(Context r100, boolean r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (((Boolean) f505533d.getValue()).booleanValue() == false) goto L27;
        int r102 = pp9.d.f530228a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT >= 34) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L23;
        boolean r104 = pp9.d.a("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
        boolean r105 = pp9.d.a(BaseConstants.PERMISSION_READ_MEDIA_IMAGES);
        boolean r106 = pp9.d.a(BaseConstants.PERMISSION_READ_MEDIA_VIDEO);
        if (r101 == false) goto L20;
        if (r106 == false) goto L19;
        if (r105 == false) goto L19;
        r105 = true;
    L19:
        r105 = false;
    L20:
        if (r105 == true) goto L23;
        if (r104 == false) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L28;
        return true;
    L28:
        return false;
    L23:
        r107 = false;
        goto L24
    L10:
        if (r100.getApplicationInfo().targetSdkVersion < 34) goto L12;
        r103 = true;
        goto L13
    L27:
        return false;
    }
}

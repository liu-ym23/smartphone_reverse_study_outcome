package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class CollectionFailSnackBarManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Function0<Unit>> f196684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static wx3.a f196685b;

    static {
        f196684a = new ArrayList();
        com.bytedance.awemeopen.apps.framework.utils.a.a(new k());
    }

    public static void a(Activity r100, int r101, View r102, Function0 r103, final Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorView");
        Intrinsics.checkNotNullParameter(r103, "clickCallback");
        Intrinsics.checkNotNullParameter(r110, "showCallback");
        wx3.a r104 = f196685b;
        if (r104 != null) goto L6;
    L11:
        wx3.a.C8171a r105 = new wx3.a.C8171a(r100);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r106 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r107 = new DisplayMetrics();
        if ((r106 instanceof WindowManager) == false) goto L14;
        ((WindowManager) r106).getDefaultDisplay().getRealMetrics(r107);
    L14:
        Pair r108 = TuplesKt.to(Integer.valueOf(r107.widthPixels), Integer.valueOf(r107.heightPixels));
        r105.f561808n = Math.min(((Number) r108.component1()).intValue(), ((Number) r108.component2()).intValue());
        r105.f561810p = false;
        r105.f561811q = true;
        Drawable r109 = ContextCompat.getDrawable(r105.f561795a, R.drawable.aos_ic_snackbar_un_collection);
        if (r109 == null) goto L17;
        r105.f561796b = r109;
    L17:
        r105.f561797c = r105.f561795a.getString(R.string.aos_common_feed_un_collection);
        CollectionFailSnackBarManager$realTryShow$1 r111 = CollectionFailSnackBarManager$realTryShow$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r111, "attrs");
        r105.f561798d = r111;
        ContextCompat.getDrawable(r105.f561795a, R.drawable.aos_picture_collect_bg);
        r105.f561809o = (int) n0.a(r100, 48.0f);
        r105.f561802h = r102;
        r105.f561804j = 0;
        r105.f561805k = r101;
        wx3.a.b r112 = new CollectionFailSnackBarManager$realTryShow$2();
        Intrinsics.checkNotNullParameter(r112, "callback");
        r105.f561807m = r112;
        f196685b = new wx3.a(r105);
        AoPool.g(new CollectionFailSnackBarManager$runOnUi$1(new CollectionFailSnackBarManager$realTryShow$3(r110)));
        return;
    L6:
        if (r104.f561793b.isShowing() != true) goto L8;
        boolean r113 = true;
    L9:
        if (r113 == false) goto L11;
        AoPool.g(new CollectionFailSnackBarManager$runOnUi$1(CollectionFailSnackBarManager$tryDismiss$1.INSTANCE));
        goto L11
    L8:
        r113 = false;
        goto L9
    }
}

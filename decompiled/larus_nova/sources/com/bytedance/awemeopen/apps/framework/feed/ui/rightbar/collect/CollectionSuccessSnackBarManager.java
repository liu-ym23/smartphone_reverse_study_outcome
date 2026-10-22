package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.collect.serviceapi.AoCollectService;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class CollectionSuccessSnackBarManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Function0<Unit>> f196686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static wx3.a f196687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f196688c = null;

    static {
        f196686a = new ArrayList();
        com.bytedance.awemeopen.apps.framework.utils.a.a(new l());
        f196688c = LazyKt.lazy(CollectionSuccessSnackBarManager$bdpCollectService$2.INSTANCE);
    }

    public static void b() {
        wx3.a r100 = f196687b;
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = true;
        if (r100.f561793b.isShowing() == true) goto L9;
        r101 = false;
    L9:
        if (r101 == false) goto L12;
        AoPool.g(new CollectionSuccessSnackBarManager$runOnUi$1(CollectionSuccessSnackBarManager$tryDismiss$1.INSTANCE));
        return;
    }

    public static void a(final Activity r110, final FeedPageConfig r111, int r112, View r113, final String r114, final Function0 r115, final Function0 r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "clickCallback");
        Intrinsics.checkNotNullParameter(r116, "showCallback");
        if (r111 == null) goto L5;
        boolean r100 = r111.isTeenagerModel();
    L7:
        if (r100 == true) goto L15;
        AoCollectService r101 = (AoCollectService) f196688c.getValue();
        if (r101 == null) goto L11;
        boolean r102 = r101.u();
    L13:
        if ((!r102) == false) goto L15;
        boolean r103 = true;
    L16:
        b();
        wx3.a.C8171a r104 = new wx3.a.C8171a(r110);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r105 = r110.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r106 = new DisplayMetrics();
        if ((r105 instanceof WindowManager) == false) goto L19;
        ((WindowManager) r105).getDefaultDisplay().getRealMetrics(r106);
    L19:
        Pair r107 = TuplesKt.to(Integer.valueOf(r106.widthPixels), Integer.valueOf(r106.heightPixels));
        r104.f561808n = Math.min(((Number) r107.component1()).intValue(), ((Number) r107.component2()).intValue());
        r104.f561810p = false;
        r104.f561811q = true;
        Drawable r108 = ContextCompat.getDrawable(r104.f561795a, R.drawable.aos_ic_snackbar_success_bl_social_familiar);
        if (r108 == null) goto L22;
        r104.f561796b = r108;
    L22:
        r104.f561797c = r104.f561795a.getString(R.string.aos_common_feed_add_collection_success);
        if (r103 == false) goto L25;
        int r109 = R.string.aos_tob_common_feed_add_collection_success_go;
    L26:
        r104.f561800f = r104.f561795a.getString(r109);
        CollectionSuccessSnackBarManager$realTryShow$1 r117 = CollectionSuccessSnackBarManager$realTryShow$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r117, "attrs");
        r104.f561798d = r117;
        CollectionSuccessSnackBarManager$realTryShow$2 r118 = CollectionSuccessSnackBarManager$realTryShow$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r118, "attrs");
        r104.f561801g = r118;
        Drawable r119 = ContextCompat.getDrawable(r104.f561795a, R.drawable.aos_collect_ic_snackbar);
        if (r119 == null) goto L29;
        r104.f561799e = r119;
    L29:
        ContextCompat.getDrawable(r104.f561795a, R.drawable.aos_picture_collect_bg);
        r104.f561809o = (int) n0.a(r110, 48.0f);
        r104.f561802h = r113;
        r104.f561804j = 0;
        r104.f561805k = r112;
        wx3.a.b r120 = new CollectionSuccessSnackBarManager$realTryShow$3();
        Intrinsics.checkNotNullParameter(r120, "callback");
        r104.f561807m = r120;
        wx3.a r121 = new wx3.a(r104);
        f196687b = r121;
        View r122 = r121.f561794c;
        if (r122 == null) goto L32;
        final boolean r123 = r103;
        r122.setOnClickListener(new j(r115, r123, r110, r111, r114));
    L32:
        AoPool.g(new CollectionSuccessSnackBarManager$runOnUi$1(new CollectionSuccessSnackBarManager$realTryShow$5(r116)));
        return;
    L25:
        r109 = R.string.aos_common_feed_add_collection_success_go;
        goto L26
    L11:
        r102 = false;
    L15:
        r103 = false;
        goto L16
    L5:
        r100 = false;
        goto L7
    }
}

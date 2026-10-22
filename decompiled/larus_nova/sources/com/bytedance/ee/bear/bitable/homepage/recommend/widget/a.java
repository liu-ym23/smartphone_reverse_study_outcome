package com.bytedance.ee.bear.bitable.homepage.recommend.widget;

import android.content.Context;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f213085a = 0;

    static {
    }

    public static CircularProgressDrawable a(Context r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CircularProgressDrawable r104 = new CircularProgressDrawable(r100);
        r104.setStyle(1);
        r104.setColorSchemeColors(new int[]{r101});
        r104.setCenterRadius(r102);
        r104.setStrokeWidth(r103);
        int r105 = ((int) (r104.getCenterRadius() + r104.getStrokeWidth())) * 2;
        r104.setBounds(0, 0, r105, r105);
        return r104;
    }
}

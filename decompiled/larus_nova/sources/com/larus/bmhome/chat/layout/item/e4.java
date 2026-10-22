package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e4 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f304333a;

    public e4(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setOrientation(1);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.larus_item_search_single_row_video, null);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r102 = (LinearLayout) r101;
        this.f304333a = r102;
        Resources r103 = AppHost.f326268a.getApplication().getResources();
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels, -2);
        if (r102 == null) goto L5;
        r102.setLayoutParams(r104);
    L5:
        addView(r102);
    }

    public final void setRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        r100.setTag("search_video_single_row");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L8;
        r102.removeView(r100);
    L8:
        LinearLayout r103 = this.f304333a;
        if (r103 == null) goto L12;
        r103.addView(r100);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setSearchHeaderText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        TextView r101 = (TextView) findViewById(R.id.search_header_txt);
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }
}

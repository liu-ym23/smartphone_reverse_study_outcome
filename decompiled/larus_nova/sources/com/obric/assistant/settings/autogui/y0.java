package com.obric.assistant.settings.autogui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.obric.oui.lisitem.OCardListItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class y0 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f391983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f391984b;

    public y0(Context r100, OCardListItem r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cardItem");
        super(r100);
        this.f391983a = r101;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.item_obric_auto_execute_auth_hint, this, false);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.TextView");
        TextView r103 = (TextView) r102;
        this.f391984b = r103;
        setOrientation(1);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(r101);
        addView(r103);
    }
}

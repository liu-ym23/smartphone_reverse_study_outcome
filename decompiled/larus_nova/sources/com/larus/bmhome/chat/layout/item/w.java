package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.databinding.LarusItemEduContinueShotBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class w extends xc8.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LarusItemEduContinueShotBinding f304681p;

    public w(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.larus_item_edu_continue_shot, this, false);
        addView(r101);
        if (r101 == null) goto L7;
        TextView r102 = (TextView) r101;
        this.f304681p = new LarusItemEduContinueShotBinding(r102, r102);
        return;
    L7:
        throw new NullPointerException("rootView");
    }
}

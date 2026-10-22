package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends FeedCardComponent<Object, TextView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f420953c;

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        TextView r100 = new TextView(getContext());
        r100.setTextSize(0, this.f420953c);
        r100.setSingleLine();
        r100.setEllipsize(TextUtils.TruncateAt.END);
        r100.setGravity(16);
        return r100;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
        r100.gravity = 16;
        return r100;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f420953c = zz7.b.h(r100, 14);
    }
}

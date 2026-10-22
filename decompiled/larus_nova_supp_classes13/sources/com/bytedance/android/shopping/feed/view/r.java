package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.resourcecard.model.SearchItem;
import com.bytedance.android.ui.base.widget.round.RoundTextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends ei.a<SearchItem> {
    public final /* synthetic */ SearchCardHashTagView c;
    public final /* synthetic */ rd3.a d;
    public final /* synthetic */ List e;

    public final View a(Object r6) {
        SearchItem r7 = (SearchItem) r6;
        Intrinsics.checkNotNullParameter(r7, "t");
        RoundTextView r0 = new RoundTextView(this.c.getContext());
        r0.setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
        r0.setText(r7.getKeyword());
        r0.setMaxLines(1);
        r0.setMaxWidth(com.bytedance.android.shopping.extensions.b.b(178));
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setTextSize(14.0f);
        r0.setTextColor(ColorProtector.parseColor("#161823"));
        r0.setGravity(16);
        ViewExtensionsKt.g(r0, 6.0f, 6.0f, 6.0f, 6.0f);
        r0.setBackgroundColor(ColorProtector.parseColor("#08161823"));
        FeedProductEventTracker r1 = FeedProductEventTracker.a;
        Context r2 = this.c.getContext();
        rd3.a r3 = this.d;
        r1.getClass();
        FeedProductEventTracker.y(r2, r3, r7);
        return r0;
    }

    public r(SearchCardHashTagView r1, rd3.a r2, List r3, List r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        super(r4);
    }
}

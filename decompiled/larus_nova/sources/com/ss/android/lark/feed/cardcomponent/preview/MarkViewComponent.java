package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MarkViewComponent extends FeedCardComponent<Object, AppCompatImageView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f420903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f420904d;

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        AppCompatImageView r100 = new AppCompatImageView(getContext());
        r100.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return r100;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        int r100 = this.f420904d;
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(r100, r100);
        r101.gravity = 16;
        r101.rightMargin = UIHelper.dp2px(4.0f);
        return r101;
    }

    public MarkViewComponent(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f420903c = LazyKt.lazy(new MarkViewComponent$rotateAnimation$2(r100));
        this.f420904d = zz7.b.g(r100, 16);
    }
}

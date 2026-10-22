package com.ss.android.lark.feed.cardcomponent.title.specialfocus;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class SpecialFocusComponent extends FeedCardComponent<Object, AppCompatImageView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f420988c;

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new AppCompatImageView(getContext());
    }

    public SpecialFocusComponent(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f420988c = LazyKt.lazy(new SpecialFocusComponent$specialFocusDrawable$2(r100));
    }
}

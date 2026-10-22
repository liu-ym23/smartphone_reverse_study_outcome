package com.ss.android.lark.feed.app.tablayout;

import android.view.View;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes35.dex */
public class FeedSelectorConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f420759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f420760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function3<? super View, ? super Integer, ? super Boolean, Unit> f420761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function4<? super View, ? super List<? extends View>, ? super Boolean, ? super Boolean, Unit> f420762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function4<? super Integer, ? super List<Integer>, ? super Boolean, ? super Boolean, Unit> f420763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function4<? super View, ? super Integer, ? super Boolean, ? super Boolean, Boolean> f420764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2<? super View, ? super Integer, Boolean> f420765g;

    public FeedSelectorConfig() {
        this.f420759a = 1;
        this.f420760b = Integer.MAX_VALUE;
        this.f420761c = FeedSelectorConfig$onStyleItemView$1.INSTANCE;
        this.f420762d = FeedSelectorConfig$onSelectViewChange$1.INSTANCE;
        this.f420763e = FeedSelectorConfig$onSelectIndexChange$1.INSTANCE;
        this.f420764f = FeedSelectorConfig$onSelectItemView$1.INSTANCE;
        this.f420765g = FeedSelectorConfig$onItemViewLongClick$1.INSTANCE;
    }
}

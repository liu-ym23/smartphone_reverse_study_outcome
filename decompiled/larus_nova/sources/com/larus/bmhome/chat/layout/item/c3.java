package com.larus.bmhome.chat.layout.item;

import android.view.View;
import android.view.animation.PathInterpolator;
import com.larus.bmhome.chat.bean.PromptContent;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c3 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PathInterpolator f304277g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f304278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<PromptContent> f304279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f304280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f304281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f304282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends View> f304283f;

    public static final class a {
    }

    static {
        f304277g = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
    }

    public c3(View r100, q2 r101, r2 r102) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "contentProvider");
        Intrinsics.checkNotNullParameter(r102, "childCountProvider");
        this.f304278a = r100;
        this.f304279b = r101;
        this.f304280c = r102;
        this.f304283f = CollectionsKt.emptyList();
    }
}

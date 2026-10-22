package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDTabLayout f436338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f436339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f436340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f436341d;

    public g(UDTabLayout r100, ImageView r101) {
        Intrinsics.checkNotNullParameter(r100, "tabLayout");
        Intrinsics.checkNotNullParameter(r101, "hintIcon");
        this.f436338a = r100;
        this.f436339b = r101;
    }
}

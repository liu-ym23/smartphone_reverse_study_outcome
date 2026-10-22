package com.bytedance.ee.bear.middleground.comment.widget;

import android.view.View;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f232324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BotAtHintView f232325b;

    public c(int r100, BotAtHintView r101) {
        this.f232324a = r100;
        this.f232325b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r110, int r111) {
        r100.removeOnLayoutChangeListener(this);
        int r107 = this.f232324a;
        BotAtHintView r108 = this.f232325b;
        if (r107 != r108.f232271m) goto L43;
        b r109 = r108.f232270l;
        if (r109 == null) goto L44;
        r108.f232270l = null;
        a r112 = r108.f232260b;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r109, "hintInfo");
        Iterator<j0> r113 = r112.y2().iterator();
        boolean r114 = false;
        int r115 = 0;
    L10:
        if (r113.hasNext() == false) goto L29;
        j0 r116 = r113.next();
        BotAtHintActionType r117 = r109.f232320c;
        int r118 = a.C3321a.f232317a[r117.ordinal()];
        if (r118 == 1) goto L21;
        if (r118 != 2) goto L19;
        if (r116.f232338a.f232318a == r109.f232318a) goto L24;
    L25:
        boolean r119 = false;
    L26:
        if (r119 == true) goto L30;
        r115 = r115 + 1;
    L30:
        int r120 = this.f232325b.f232260b.getItemCount();
        if (this.f232325b.f232259a.isAttachedToWindow() == false) goto L42;
        if (r115 < 0) goto L35;
        if (r115 >= r120) goto L35;
        r114 = true;
    L35:
        if (r114 == false) goto L45;
        this.f232325b.f232259a.smoothScrollToPosition(r115);
        return;
    L45:
        return;
    L42:
        return;
    L24:
        r119 = true;
        goto L26
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        if (r116.f232338a.f232320c != BotAtHintActionType.LEARN_MORE) goto L25;
        if (r116.f232339b.contains(r109.f232319b) == false) goto L25;
    L29:
        r115 = -1;
        goto L30
    L44:
        return;
    }
}

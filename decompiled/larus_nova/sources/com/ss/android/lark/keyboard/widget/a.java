package com.ss.android.lark.keyboard.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.android.lark.keyboard.keyboard2.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f431037b;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.widget.a$a, reason: collision with other inner class name */
    public static final class C5118a {
    }

    static {
    }

    public a() {
        this.f431037b = UIHelper.getDimens(R.dimen.keyboard_icon_horizontal_padding);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.f
    public final void a(KBMenuContainerView r100, List<? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "visibleChildViews");
        int r102 = r101.size();
        Context r103 = r100.getContext();
        int r104 = r100.getMeasuredWidth();
        Resources r105 = r103.getResources();
        int r106 = MathKt.roundToInt(r104 / WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density);
        List<? extends View> r107 = r101;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L4:
        if (r109.hasNext() == false) goto L6;
        r108.add(Integer.valueOf(((View) r109.next()).getMeasuredWidth()));
        goto L4
    L6:
        int r110 = r104 - CollectionsKt.sumOfInt(r108);
        if (r106 >= 304) goto L13;
        int r111 = r110 / r102;
        Iterator<T> r112 = r107.iterator();
    L10:
        if (r112.hasNext() == false) goto L28;
        m.a((View) r112.next(), r111);
        goto L10
    L28:
        return;
    L13:
        if (r106 >= 424) goto L19;
        int r113 = (r110 - (this.f431037b * 3)) / (r102 + 1);
        Iterator<T> r114 = r107.iterator();
    L16:
        if (r114.hasNext() == false) goto L18;
        m.a((View) r114.next(), r113);
        goto L16
    L18:
        m.a((View) CollectionsKt.last(r101), r113 * 2);
        return;
    L19:
        int r115 = y9c.d.a(14);
        Iterator<T> r116 = r107.iterator();
    L21:
        if (r116.hasNext() == false) goto L29;
        m.a((View) r116.next(), r115);
        goto L21
    }
}

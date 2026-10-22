package com.skydoves.balloon;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/view/View;Landroid/view/MotionEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class Balloon$passTouchEventToAnchor$1 extends Lambda implements Function2<View, MotionEvent, Boolean> {
    final /* synthetic */ View $anchor;

    public Balloon$passTouchEventToAnchor$1(View r100) {
        this.$anchor = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        r100.performClick();
        Rect r102 = new Rect();
        this.$anchor.getGlobalVisibleRect(r102);
        if (r102.contains((int) r101.getRawX(), (int) r101.getRawY()) == false) goto L5;
        this.$anchor.getRootView().dispatchTouchEvent(r101);
        boolean r103 = true;
    L7:
        return Boolean.valueOf(r103);
    L5:
        r103 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(View r100, MotionEvent r101) {
        return invoke2(r100, r101);
    }
}

package com.obric.oui.badge;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ OBadgeDrawable $badge;
    final /* synthetic */ View $host;

    public OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1(OBadgeDrawable r100, View r101, View r102) {
        this.$badge = r100;
        this.$anchor = r101;
        this.$host = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$badge.f(this.$anchor, this.$host);
        Rect r100 = this.$badge.getBounds();
        int r101 = this.$host.getHeight();
        int r102 = Math.max(RangesKt.coerceAtLeast(-r100.top, 0), RangesKt.coerceAtLeast(r100.bottom - r101, 0));
        if (r102 <= 0) goto L10;
        OBadgeDrawable r103 = this.$badge;
        int r104 = r103.B;
        int r105 = r102 + r104;
        if (r104 == r105) goto L8;
        r103.B = r105;
        r103.a();
    L8:
        this.$badge.f(this.$anchor, this.$host);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

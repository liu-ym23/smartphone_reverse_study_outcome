package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAnchorLyricsDisplayView;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAudienceLyricsDisplayView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ub0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvRoomLyricView;", "Landroid/widget/FrameLayout;", "Lub0/b;", "value", "a", "Lub0/b;", "getCustomOtherConfig", "()Lub0/b;", "setCustomOtherConfig", "(Lub0/b;)V", "customOtherConfig", "b", "getCustomSingerConfig", "setCustomSingerConfig", "customSingerConfig", "", "c", "J", "getLastPlayTime", "()J", "setLastPlayTime", "(J)V", "lastPlayTime", "", "f", "Z", "getSmallWindow", "()Z", "setSmallWindow", "(Z)V", "smallWindow", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", "g", "Lkotlin/Lazy;", "getSingerLyricsView", "()Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", "singerLyricsView", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvComponentCountDownView;", "h", "getKtvCountDownView", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvComponentCountDownView;", "ktvCountDownView", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "i", "getOtherLyricsView", "()Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "otherLyricsView", "", "j", "F", "getLast", "()F", "setLast", "(F)V", "last", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomLyricView extends FrameLayout {
    public b a;
    public b b;
    public long c;
    public final Paint.Align d;
    public final Paint.Align e;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public float j;

    public static final class a {
    }

    static {
    }

    public KtvRoomLyricView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvRoomLyricView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final KtvComponentCountDownView getKtvCountDownView() {
        return (KtvComponentCountDownView) this.h.getValue();
    }

    private final KtvAudienceLyricsDisplayView getOtherLyricsView() {
        return (KtvAudienceLyricsDisplayView) this.i.getValue();
    }

    private final KtvAnchorLyricsDisplayView getSingerLyricsView() {
        return (KtvAnchorLyricsDisplayView) this.g.getValue();
    }

    public final b getCustomOtherConfig() {
        return this.a;
    }

    public final b getCustomSingerConfig() {
        return this.b;
    }

    public final float getLast() {
        return this.j;
    }

    public final long getLastPlayTime() {
        return this.c;
    }

    public final boolean getSmallWindow() {
        return this.f;
    }

    public final void setCustomOtherConfig(final b r3) {
        this.a = r3;
        if (r3 == null) goto L6;
        getOtherLyricsView().c(new KtvRoomLyricView$customOtherConfig$$inlined$let$lambda$1(r3, this));
        return;
    }

    public final void setCustomSingerConfig(final b r3) {
        this.b = r3;
        if (r3 == null) goto L6;
        getSingerLyricsView().c(new KtvRoomLyricView$customSingerConfig$$inlined$let$lambda$1(r3, this));
        return;
    }

    public final void setLast(float r1) {
        this.j = r1;
    }

    public final void setLastPlayTime(long r1) {
        this.c = r1;
    }

    public final void setSmallWindow(final boolean r3) {
        getSingerLyricsView().c(new KtvRoomLyricView$smallWindow$1(r3));
        getOtherLyricsView().c(new KtvRoomLyricView$smallWindow$2(r3));
        this.f = r3;
    }

    public KtvRoomLyricView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint.Align r5 = Paint.Align.CENTER;
        this.d = r5;
        this.e = r5;
        this.g = LazyKt.lazy(new KtvRoomLyricView$singerLyricsView$2(this, r2));
        this.h = LazyKt.lazy(new KtvRoomLyricView$ktvCountDownView$2(r2));
        this.i = LazyKt.lazy(new KtvRoomLyricView$otherLyricsView$2(this, r2));
        TypedArray r6 = r2.obtainStyledAttributes(r3, new int[]{2130970190, 2130974093});
        int r7 = r6.getInt(1, 1);
        if (r7 == 0) goto L7;
        if (r7 == 2) goto L6;
        Paint.Align r8 = Paint.Align.CENTER;
    L8:
        this.d = r8;
        r6.recycle();
        removeAllViews();
        addView(getOtherLyricsView());
        return;
    L6:
        r8 = Paint.Align.RIGHT;
        goto L8
    L7:
        r8 = Paint.Align.LEFT;
        goto L8
    }

    public static final void a(KtvRoomLyricView r1, b r2, b r3) {
        r1.getClass();
        r2.a = r3.a;
        r2.b = r3.b;
        r2.c = r3.c;
        r2.e = r3.e;
        Paint.Align r4 = r3.f;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.f = r4;
        r2.g = r3.g;
        r2.d = r3.d;
        r2.h = r3.h;
        r2.i = r3.i;
        r2.j = r3.j;
        r2.k = r3.k;
        r2.l = r3.l;
        r2.m = r3.m;
        r2.n = r3.n;
        r2.o = r3.o;
        r2.p = r3.p;
    }

    public /* synthetic */ KtvRoomLyricView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

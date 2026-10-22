package com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.livesmallwindowview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.room.smallwindow.enums.LabelType;
import com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.carouseview.CarouselView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yi2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R#\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/livesmallwindowview/LiveSmallWindowView;", "Landroid/widget/FrameLayout;", "", "", "", "a", "Lkotlin/Lazy;", "getHasSeeId", "()Ljava/util/Set;", "hasSeeId", "Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/viewmodel/a;", "c", "getViewModel", "()Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/viewmodel/a;", "viewModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSmallWindowView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public final Lazy a;
    public final List<b> b;
    public final Lazy c;
    public final CarouselView d;
    public final View e;

    public static final class a {
    }

    static {
    }

    public LiveSmallWindowView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveSmallWindowView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Set<Long> getHasSeeId() {
        return (Set) this.a.getValue();
    }

    private final com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel.a getViewModel() {
        return (com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel.a) this.c.getValue();
    }

    public static boolean b(List r4) {
        if (r4.size() != 1) goto L20;
        b r0 = (b) CollectionsKt.firstOrNull(r4);
        if (r0 == null) goto L7;
        Integer r1 = r0.b();
    L8:
        int r3 = LabelType.EXPLAIN.getType();
        if (r1 != null) goto L12;
        return false;
    L12:
        if (r1.intValue() != r3) goto L22;
        b r5 = (b) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L16;
        Long r6 = r5.a();
    L18:
        if (Intrinsics.areEqual(null, r6) == false) goto L23;
        return true;
    L23:
        return false;
    L16:
        r6 = null;
        goto L18
    L22:
        return false;
    L7:
        r1 = null;
        goto L8
    L20:
        return false;
    }

    public static final void a(LiveSmallWindowView r2, List r3) {
        ((ArrayList) r2.b).clear();
        ((ArrayList) r2.b).addAll(r3);
        int r4 = ((ArrayList) r2.b).size();
    L3:
        r4 = r4 - 1;
        if (r4 < 0) goto L12;
        b r0 = (b) CollectionsKt.getOrNull(r2.b, r4);
        if (r0 == null) goto L3;
        if (r2.getHasSeeId().contains(r0.a()) == false) goto L3;
        ListProtector.remove(r2.b, r4);
        goto L3
    L12:
        if (b(r2.b) == false) goto L22;
        ((ArrayList) r2.b).clear();
        return;
    }

    public LiveSmallWindowView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(LiveSmallWindowView$hasSeeId$2.INSTANCE);
        this.b = new ArrayList();
        this.c = LazyKt.lazy(new LiveSmallWindowView$viewModel$2(this));
        th.a.c(r2, 2131560781, this, true);
        this.e = findViewById(2131378253);
        this.d = (CarouselView) findViewById(2131378254);
    }

    public /* synthetic */ LiveSmallWindowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

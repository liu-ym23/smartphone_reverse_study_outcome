package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/PinchSpeedView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "getDrawableResourceId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class PinchSpeedView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Float> f195781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f195782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f195783c;

    public PinchSpeedView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinchSpeedView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getDrawableResourceId() {
        int r100 = this.f195783c;
        if (r100 >= 0) goto L5;
        return R.drawable.common_feed_speed_100p_small_new;
    L5:
        if (r100 < this.f195782b.size()) goto L8;
        return R.drawable.common_feed_speed_100p_small_new;
    L8:
        return ((Number) ListProtector.get(this.f195782b, this.f195783c)).intValue();
    }

    public PinchSpeedView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f195781a = CollectionsKt.listOf(new Float[]{Float.valueOf(0.5f), Float.valueOf(1.0f), Float.valueOf(1.5f), Float.valueOf(2.0f)});
        this.f195782b = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.drawable.common_feed_speed_50p_small_new), Integer.valueOf(R.drawable.common_feed_speed_100p_small_new), Integer.valueOf(R.drawable.common_feed_speed_150p_small_new), Integer.valueOf(R.drawable.common_feed_speed_200p_small_new)});
        this.f195783c = 1;
        setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c());
    }

    public static void j(boolean r100, PinchSpeedView r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r101, "this$0");
        Intrinsics.checkNotNullParameter(r102, "$setter");
        if (r100 == false) goto L5;
        r101.performHapticFeedback(0, 1);
    L5:
        int r103 = r101.f195783c + 1;
        r101.f195783c = r103;
        if (r103 < r101.f195781a.size()) goto L8;
        r101.f195783c = 0;
    L8:
        r101.setImageResource(r101.getDrawableResourceId());
        r102.invoke(Float.valueOf(((Number) ListProtector.get(r101.f195781a, r101.f195783c)).floatValue()));
    }

    public /* synthetic */ PinchSpeedView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void l(float r100, r14.c r101, String r102, final Function1 r103) {
        Intrinsics.checkNotNullParameter(r103, "setter");
        int r104 = this.f195781a.indexOf(Float.valueOf(r100));
        if (c04.g.a(r101) == false) goto L9;
        if (r104 < 0) goto L9;
        if (r104 >= this.f195781a.size()) goto L9;
        this.f195783c = r104;
        setClickable(true);
        setAlpha(1.0f);
        setImageResource(getDrawableResourceId());
        setOnClickListener(new b(this, r103));
        return;
    L9:
        setAlpha(0.5f);
        setClickable(false);
        setImageResource(R.drawable.common_feed_speed_100p_small_new);
    }
}

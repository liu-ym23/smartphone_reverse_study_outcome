package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/PinchSpeedView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "getDrawableResourceId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class PinchSpeedView extends AppCompatImageView {
    public final List<Float> a;
    public final List<Integer> b;
    public int c;

    public PinchSpeedView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinchSpeedView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getDrawableResourceId() {
        int r0 = this.c;
        if (r0 >= 0) goto L5;
        return 2131233598;
    L5:
        if (r0 < this.b.size()) goto L8;
        return 2131233598;
    L8:
        return ((Number) ListProtector.get(this.b, this.c)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PinchSpeedView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5, r6, r7);
        this.a = CollectionsKt.listOf(new Float[]{Float.valueOf(0.5f), Float.valueOf(1.0f), Float.valueOf(1.5f), Float.valueOf(2.0f)});
        this.b = CollectionsKt.listOf(new Integer[]{2131233601, 2131233598, 2131233599, 2131233600});
        this.c = 1;
        setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(boolean r2, PinchSpeedView r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$setter");
        if (r2 == false) goto L5;
        r3.performHapticFeedback(0, 1);
    L5:
        int r5 = r3.c + 1;
        r3.c = r5;
        if (r5 < r3.a.size()) goto L8;
        r3.c = 0;
    L8:
        r3.setImageResource(r3.getDrawableResourceId());
        r4.invoke(Float.valueOf(((Number) ListProtector.get(r3.a, r3.c)).floatValue()));
    }

    public /* synthetic */ PinchSpeedView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(float r1, r14.c r2, String r3, final Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "setter");
        int r5 = this.a.indexOf(Float.valueOf(r1));
        if (c04.g.a(r2) == false) goto L9;
        if (r5 < 0) goto L9;
        if (r5 >= this.a.size()) goto L9;
        this.c = r5;
        setClickable(true);
        setAlpha(1.0f);
        setImageResource(getDrawableResourceId());
        setOnClickListener(new b(this, r4));
        return;
    L9:
        setAlpha(0.5f);
        setClickable(false);
        setImageResource(2131233598);
    }
}

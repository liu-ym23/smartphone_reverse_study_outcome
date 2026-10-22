package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/ECShopETAView;", "Landroid/widget/LinearLayout;", "Lkotlin/Pair;", "", "getETARealShowInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopETAView extends LinearLayout {
    public List<Integer> a;

    public static final class a {
    }

    static {
    }

    public ECShopETAView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECShopETAView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final Pair<Boolean, Boolean> getETARealShowInfo() {
        List<Integer> r1 = this.a;
        boolean r2 = false;
        if (r1 == null) goto L5;
        boolean r3 = r1.contains(1);
    L6:
        Boolean r4 = Boolean.valueOf(r3);
        List<Integer> r5 = this.a;
        if (r5 == null) goto L10;
        r2 = r5.contains(2);
    L10:
        return new Pair(r4, Boolean.valueOf(r2));
    L5:
        r3 = false;
        goto L6
    }

    public ECShopETAView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(16)));
        setOrientation(0);
        setGravity(16);
    }

    public /* synthetic */ ECShopETAView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ECFlagShipReputationView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ECNewReputationLayout;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ECShopETAView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/IronListHeaderTagLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronListHeaderTagLayout extends LinearLayout {
    public final ECNewReputationLayout a;
    public final ECFlagShipReputationView b;
    public final ListHeaderTagWidget c;
    public final ListHeaderTagWidget d;
    public final ECShopETAView e;

    public IronListHeaderTagLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IronListHeaderTagLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public IronListHeaderTagLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560774, this, true);
        this.a = (ECNewReputationLayout) findViewById(2131384381);
        this.b = (ECFlagShipReputationView) findViewById(2131384379);
        this.c = (ListHeaderTagWidget) findViewById(2131388162);
        this.d = (ListHeaderTagWidget) findViewById(2131373321);
        this.e = (ECShopETAView) findViewById(2131371820);
    }

    public /* synthetic */ IronListHeaderTagLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

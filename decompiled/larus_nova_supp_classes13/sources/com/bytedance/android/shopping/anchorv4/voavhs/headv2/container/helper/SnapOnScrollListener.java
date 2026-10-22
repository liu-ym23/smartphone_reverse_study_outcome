package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.AnchorV4HeadV2View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/helper/SnapOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Behavior", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SnapOnScrollListener extends RecyclerView.OnScrollListener {
    public int a;
    public final SnapHelper b;
    public final s c;
    public final Behavior d;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.a e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/helper/SnapOnScrollListener$Behavior;", "", "NOTIFY_ON_SCROLL", "NOTIFY_ON_SCROLL_STATE_IDLE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Behavior extends Enum<Behavior> {
        public static final Behavior NOTIFY_ON_SCROLL = null;
        public static final Behavior NOTIFY_ON_SCROLL_STATE_IDLE = null;
        public static final /* synthetic */ Behavior[] a = null;

        static {
            Behavior r1 = new Behavior("NOTIFY_ON_SCROLL", 0);
            NOTIFY_ON_SCROLL = r1;
            Behavior r2 = new Behavior("NOTIFY_ON_SCROLL_STATE_IDLE", 1);
            NOTIFY_ON_SCROLL_STATE_IDLE = r2;
            a = new Behavior[]{r1, r2};
        }

        public static Behavior valueOf(String r1) {
            return (Behavior) r27.a.a(Behavior.class, r1);
        }

        public static Behavior[] values() {
            return (Behavior[]) a.clone();
        }

        public Behavior(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void j(RecyclerView r15) {
        RecyclerView.LayoutManager r0 = r15.getLayoutManager();
        if (r0 == null) goto L7;
        View r2 = this.b.findSnapView(r0);
        if (r2 == null) goto L7;
        int r1 = r0.getPosition(r2);
    L9:
        boolean r3 = true;
        if (ECSettingKeys.A0().e() == false) goto L51;
        RecyclerView.LayoutManager r16 = r15.getLayoutManager();
        if (r16 == null) goto L51;
        int r4 = this.c.W4();
        if (r1 == (-1)) goto L51;
        if (this.c.s() == false) goto L51;
        if (this.c.isExpanded() == true) goto L51;
        if (r1 < 0) goto L51;
        if (r4 <= r1) goto L51;
        OrientationHelper r5 = OrientationHelper.createHorizontalHelper(r16);
        int r6 = r5.getStartAfterPadding() + ((int) (r5.getTotalSpace() * 0.6f));
        int r7 = r16.getChildCount();
        int r8 = Integer.MIN_VALUE;
        int r9 = 0;
        int r10 = -1;
    L25:
        if (r9 >= r7) goto L41;
        View r11 = r16.getChildAt(r9);
        if (r11 == null) goto L40;
        int r12 = r16.getPosition(r11);
        if (r12 < 0) goto L40;
        if (r4 <= r12) goto L40;
        if (r11.getWidth() <= 0) goto L40;
        int r13 = r5.getDecoratedStart(r11);
        if (r13 > r6) goto L40;
        if (r13 <= r8) goto L40;
        r8 = r13;
        r10 = r12;
    L40:
        r9 = r9 + 1;
        goto L25
    L41:
        Integer r17 = Integer.valueOf(r10);
        if (r17.intValue() == (-1)) goto L44;
        boolean r14 = true;
    L45:
        if (r14 == true) goto L48;
        r17 = null;
    L48:
        if (r17 == null) goto L51;
        r1 = r17.intValue();
        goto L51
    L44:
        r14 = false;
    L51:
        if (this.a != r1) goto L54;
        r3 = false;
    L54:
        if (r3 == false) goto L68;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.a r18 = this.e;
        if (r18 == null) goto L58;
        r18.a(r1);
    L58:
        this.a = r1;
        return;
    L68:
        return;
    L7:
        r1 = -1;
        goto L9
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        if (this.d != Behavior.NOTIFY_ON_SCROLL_STATE_IDLE) goto L7;
        if (r4 != 0) goto L8;
        j(r3);
        return;
    L8:
        return;
    }

    public SnapOnScrollListener(HeadPagerSnapHelper r3, s r4, AnchorV4HeadV2View.b r5) {
        Behavior r0 = Behavior.NOTIFY_ON_SCROLL_STATE_IDLE;
        Intrinsics.checkNotNullParameter(r3, "snapHelper");
        Intrinsics.checkNotNullParameter(r4, "headAbility");
        Intrinsics.checkNotNullParameter(r0, "behavior");
        this.b = r3;
        this.c = r4;
        this.d = r0;
        this.e = r5;
        this.a = -1;
    }

    public final void onScrolled(RecyclerView r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Behavior r0 = this.d;
        if (r0 != Behavior.NOTIFY_ON_SCROLL) goto L6;
        j(r3);
        return;
    L6:
        if (r0 != Behavior.NOTIFY_ON_SCROLL_STATE_IDLE) goto L12;
        if (r4 != 0) goto L13;
        if (r5 != 0) goto L14;
        j(r3);
        return;
    L14:
        return;
    L13:
        return;
    }
}

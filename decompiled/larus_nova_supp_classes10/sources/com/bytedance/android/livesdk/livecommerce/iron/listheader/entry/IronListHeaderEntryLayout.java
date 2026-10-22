package com.bytedance.android.livesdk.livecommerce.iron.listheader.entry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.e;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.f;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.i;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/entry/IronListHeaderEntryLayout;", "Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/ECCacheItemLinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/entry/IronListHeaderEntryView;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECLottieAnimationView;", "getCartEntryView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronListHeaderEntryLayout extends ECCacheItemLinearLayout<IronListHeaderEntryView> {
    public static final /* synthetic */ int d = 0;
    public final b a;
    public ECLottieAnimationView b;
    public i c;

    public static final class a {
    }

    public final class b implements ECCacheItemLinearLayout.a<IronListHeaderEntryView> {
        public List<ECPromotionEntry> a;
        public Map<String, String> b;
        public Integer c;
        public final /* synthetic */ IronListHeaderEntryLayout d;

        @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout.a
        public final View b() {
            return new IronListHeaderEntryView(this.d.getContext());
        }

        public b(IronListHeaderEntryLayout r1) {
            this.d = r1;
            this.c = 0;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout.a
        public final void a(View r10, int r11) {
            final IronListHeaderEntryView r12 = (IronListHeaderEntryView) r10;
            if (r12 == null) goto L50;
            LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
            gi2.a r6 = null;
            if (r11 <= 0) goto L19;
            Integer r1 = this.c;
            if (r1 != null) goto L9;
        L17:
            r1 = 8;
        L18:
            r0.leftMargin = UtilityKotlinExtentionsKt.d(r1);
            goto L19
        L9:
            if (r1.intValue() <= 0) goto L11;
            boolean r2 = true;
        L12:
            if (r2 == true) goto L15;
            r1 = null;
        L15:
            if (r1 == null) goto L17;
        L11:
            r2 = false;
        L19:
            r12.setLayoutParams(r0);
            final IronListHeaderEntryLayout r7 = this.d;
            List<ECPromotionEntry> r3 = this.a;
            if (r3 == null) goto L22;
            ECPromotionEntry r13 = (ECPromotionEntry) ListProtector.get(r3, r11);
        L23:
            final Map<String, String> r5 = this.b;
            r12.a(r13, r7.c, r5);
            if (r13 != null) goto L26;
        L31:
            if (r13 == null) goto L35;
            final List<ECPromotionEntry> r4 = r13.getSubEntries();
            if (r4 == null) goto L35;
            final ECPromotionEntry r8 = r13;
            r12.setPopupWindow(new IronListHeaderEntryLayout$bindEntryItemData$$inlined$let$lambda$2(r4, r12, r7, r8, r5));
        L35:
            if (r13 == null) goto L37;
            int r14 = r13.getType();
        L38:
            if (r13 == null) goto L41;
            String r9 = r13.getTrackName();
            if (r9 == null) goto L41;
        L42:
            if (r13 == null) goto L44;
            Map<String, String> r15 = r13.getTrackParams();
        L45:
            i r16 = r7.c;
            if (r16 == null) goto L48;
            r6 = r16.g;
        L48:
            int r17 = f.a;
            Intrinsics.checkNotNullParameter(r9, "trackName");
            oh.a.c("list_entry_show_event", new e(r14, r9, r6, r15));
            return;
        L44:
            r15 = null;
        L41:
            r9 = "";
            goto L42
        L37:
            r14 = -1;
            goto L38
        L26:
            if (r13.getType() != 3) goto L31;
            i r18 = r7.c;
            if (r18 == null) goto L30;
            com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.b r19 = new com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.b(r7, r5);
            Intrinsics.checkNotNullParameter(r19, "listHeaderHelper");
            r18.c = r19;
        L30:
            r7.b = r12.getLottieImageView();
            goto L31
        L22:
            r13 = null;
            goto L23
        }
    }

    static {
    }

    public IronListHeaderEntryLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IronListHeaderEntryLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ECLottieAnimationView getCartEntryView() {
        return this.b;
    }

    public IronListHeaderEntryLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new b(this);
    }

    public /* synthetic */ IronListHeaderEntryLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

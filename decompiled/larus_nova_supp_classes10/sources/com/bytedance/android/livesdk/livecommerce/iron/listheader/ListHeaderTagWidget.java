package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/ListHeaderTagWidget;", "Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/ECCacheItemLinearLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListHeaderTagWidget extends ECCacheItemLinearLayout<ECDraweeView> {
    public final b a;

    public static final class a {
    }

    public final class b implements ECCacheItemLinearLayout.a<ECDraweeView> {
        public List<ECRitTag> a;
        public gi2.a b;
        public final /* synthetic */ ListHeaderTagWidget c;

        @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout.a
        public final View b() {
            ECDraweeView r6 = new ECDraweeView(this.c.getContext(), null, 0, 6, null);
            r6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            return r6;
        }

        public b(ListHeaderTagWidget r1) {
            this.c = r1;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.iron.listheader.ECCacheItemLinearLayout.a
        public final void a(View r10, final int r11) {
            final ECDraweeView r12 = (ECDraweeView) r10;
            if (r12 == null) goto L26;
            List<ECRitTag> r0 = this.a;
            if (r0 == null) goto L27;
            final ECRitTag r1 = (ECRitTag) ListProtector.get(r0, r11);
            if (r1 == null) goto L28;
            if (r11 == 0) goto L10;
            o0.e(r12, UtilityKotlinExtentionsKt.d(4));
        L10:
            ECUrlModel r2 = r1.getTextIcon();
            if (r2 == null) goto L13;
            String r3 = r2.getFirstUrl();
        L14:
            y.g(r12, r3, UtilityKotlinExtentionsKt.d(Integer.valueOf(r1.getIconWidth())), UtilityKotlinExtentionsKt.d(Integer.valueOf(r1.getIconHeight())));
            String r4 = r1.getTrackTag();
            Map r5 = r1.getEventParam();
            gi2.a r6 = this.b;
            int r7 = f.a;
            if (r4 != null) goto L17;
        L20:
            boolean r8 = true;
        L21:
            if (r8 == true) goto L24;
            oh.a.c("list_tag_event", new g(false, r4, r6, r5));
        L24:
            com.bytedance.android.ec.core.widget.f.c(r12, null, "bind_key_live_promotion_list", new ListHeaderTagWidget$TagItemViewHelper$bindItemViewData$$inlined$let$lambda$1(r1, r12, this, r11, r12), 1);
            return;
        L17:
            if (StringsKt.isBlank(r4) == true) goto L20;
            r8 = false;
            goto L21
        L13:
            r3 = null;
            goto L14
        L28:
            return;
        L27:
            return;
        }
    }

    static {
    }

    public ListHeaderTagWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ListHeaderTagWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public ListHeaderTagWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new b(this);
    }

    public final int b(List<ECRitTag> r18, int r19, gi2.a r20) {
        measure(-2, -2);
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r18.iterator();
        long r5 = 0;
        int r7 = 0;
    L4:
        if (r3.hasNext() == false) goto L21;
        Object r8 = r3.next();
        int r10 = r7 + 1;
        if (r7 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ECRitTag r9 = (ECRitTag) r8;
        ECUrlModel r11 = r9.getTextIcon();
        if (r11 == null) goto L11;
        int r12 = r11.getWidth();
    L12:
        int r13 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r12));
        if (r7 <= 0) goto L15;
        int r14 = UtilityKotlinExtentionsKt.d(4);
    L16:
        long r15 = r5;
        if (((((long) r13) + r5) + ((long) r14)) > r19) goto L19;
        r2.add(r9);
        r5 = r15 + ((long) (r13 + r14));
    L20:
        r7 = r10;
        goto L4
    L19:
        r5 = r15;
        goto L20
    L15:
        r14 = 0;
        goto L16
    L11:
        r12 = 0;
        goto L12
    L21:
        oh.a.c("reportShowTags", new h(r2, r20, BtmSDK.INSTANCE.getPageId(PageFinder.via(this))));
        b r4 = this.a;
        r4.a = r2;
        r4.b = r20;
        a(r2.size(), this.a);
        Iterator r1 = r2.iterator();
        int r6 = 0;
        int r16 = 0;
    L23:
        if (r1.hasNext() == false) goto L36;
        Object r17 = r1.next();
        int r21 = r16 + 1;
        if (r16 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        ECUrlModel r22 = ((ECRitTag) r17).getTextIcon();
        if (r22 == null) goto L30;
        int r23 = r22.getWidth();
    L31:
        int r24 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r23));
        if (r16 <= 0) goto L34;
        int r25 = UtilityKotlinExtentionsKt.d(4);
    L35:
        r6 = r6 + (r24 + r25);
        r16 = r21;
        goto L23
    L34:
        r25 = 0;
        goto L35
    L30:
        r23 = 0;
        goto L31
    L36:
        return r6;
    }

    public /* synthetic */ ListHeaderTagWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

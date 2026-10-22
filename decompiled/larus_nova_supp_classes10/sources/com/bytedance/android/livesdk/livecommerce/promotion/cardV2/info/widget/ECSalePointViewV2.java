package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.ECSalePointDataV2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.x;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECSalePointViewV2;", "Lcom/bytedance/android/livesdk/livecommerce/view/AutoHideLinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSalePointViewV2 extends AutoHideLinearLayout {
    public final List<TextView> b;
    public final List<Space> c;
    public final List<View> d;
    public final Map<TextView, x> e;
    public ECSalePointDataV2 f;
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.b g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public ECSalePointViewV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        setOrientation(0);
        setGravity(16);
    }

    public final <T extends View> T f(List<T> r2) {
        if ((!r2.isEmpty()) == false) goto L7;
        T r3 = (T) ListProtector.remove(r2, 0);
        if (r3.getParent() != null) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout
    public final void onViewRemoved(View r3) {
        super.onViewRemoved(r3);
        if ((r3 instanceof TextView) == false) goto L6;
        ((ArrayList) this.b).add(r3);
        return;
    L6:
        if ((r3 instanceof Space) == false) goto L9;
        ((ArrayList) this.c).add(r3);
        return;
    L9:
        if ((r3 instanceof View) == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r3.getTag(2131370825), "divider_line") == false) goto L17;
        ((ArrayList) this.d).add(r3);
        return;
    }

    public ECSalePointViewV2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        setOrientation(0);
        setGravity(16);
    }

    public ECSalePointViewV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        setOrientation(0);
        setGravity(16);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        super.onLayout(r18, r19, r20, r21, r22);
        if (this.h == true) goto L96;
        Set r1 = ((LinkedHashMap) this.e).entrySet();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L6:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L17;
        Object r5 = r3.next();
        TextView r6 = (TextView) ((Map.Entry) r5).getKey();
        if (r6.getVisibility() == 0) goto L11;
    L15:
        if (r4 == false) goto L6;
        r2.add(r5);
        goto L6
    L11:
        if (r6.getWidth() <= 0) goto L15;
        if (r6.getHeight() <= 0) goto L15;
        r4 = true;
        goto L15
    L17:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r8 = r2.iterator();
    L19:
        if (r8.hasNext() == false) goto L22;
        r7.add((x) ((Map.Entry) r8.next()).getValue());
        goto L19
    L22:
        if ((!r7.isEmpty()) == true) goto L25;
        r7 = null;
    L25:
        if (r7 == null) goto L68;
        this.h = true;
        LinkedHashMap r9 = new LinkedHashMap();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r7.iterator();
    L28:
        if (r11.hasNext() == false) goto L35;
        Map r12 = ((x) r11.next()).c();
        if (r12 == null) goto L32;
        String r13 = (String) r12.get("elastic_title_type");
    L33:
        if (r13 == null) goto L28;
        r10.add(r13);
        goto L28
    L32:
        r13 = null;
        goto L33
    L35:
        r9.put("elastic_title_types", CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null));
        ArrayList r14 = new ArrayList();
        Iterator r15 = r7.iterator();
    L37:
        if (r15.hasNext() == false) goto L44;
        Map r16 = ((x) r15.next()).c();
        if (r16 == null) goto L41;
        String r17 = (String) r16.get("sellpoint_bp");
    L42:
        if (r17 == null) goto L37;
        r14.add(r17);
        goto L37
    L41:
        r17 = null;
        goto L42
    L44:
        r9.put("sellpoint_bp", CollectionsKt.joinToString$default(r14, "@", null, null, 0, null, null, 62, null));
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.b r23 = this.g;
        if (r23 == null) goto L47;
        r23.a(r9);
    L47:
        ECSalePointDataV2 r24 = this.f;
        if (r24 == null) goto L94;
        List r25 = r24.c();
        if (r25 == null) goto L95;
        Iterator r26 = r25.iterator();
    L53:
        if (r26.hasNext() == false) goto L97;
        s1 r27 = (s1) r26.next();
        String r28 = r27.a();
        Map r29 = r27.b();
        if (r28 == null) goto L53;
        if (r28.length() <= 0) goto L59;
        boolean r30 = true;
    L60:
        if (r30 != true) goto L53;
        if (r29 == null) goto L64;
        Map<String, String> r31 = MapsKt.plus(r29, r9);
        if (r31 == null) goto L64;
    L65:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.b r32 = this.g;
        if (r32 == null) goto L53;
        r32.b(r28, r31, ECSalePointViewV2$reportShowEvent$4$1$1.INSTANCE);
    L64:
        r31 = r9;
        goto L65
    L59:
        r30 = false;
        goto L60
    L97:
        return;
    L95:
        return;
    L94:
        return;
    L68:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout
    public final boolean e(View r2, boolean r3, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "child");
        if ((r2 instanceof TextView) == false) goto L12;
        if (UtilityKotlinExtentionsKt.e((TextView) r2) == false) goto L12;
        if (indexOfChild(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    L12:
        return super.e(r2, r3, r4, r5, r6, r7);
    }
}

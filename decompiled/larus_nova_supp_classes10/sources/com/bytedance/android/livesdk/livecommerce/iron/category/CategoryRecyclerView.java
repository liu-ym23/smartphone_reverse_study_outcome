package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "getCurrentVisibleWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryRecyclerView extends RecyclerView {
    public CategoryListAdapter a;
    public int b;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long getCurrentVisibleWidth() {
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return 0;
    L4:
        if ((getLayoutManager() instanceof LinearLayoutManager) == false) goto L31;
        RecyclerView.LayoutManager r2 = getLayoutManager();     // Catch: Exception -> L25
        if ((r2 instanceof LinearLayoutManager) == true) goto L8;
        r2 = null;
    L8:
        LinearLayoutManager r3 = (LinearLayoutManager) r2;     // Catch: Exception -> L25
        int r4 = 0;
        if (r3 == null) goto L11;
        int r5 = r3.findLastVisibleItemPosition();     // Catch: Exception -> L25
    L12:
        if (r5 < 0) goto L32;
        long r6 = 0;
    L14:
        View r7 = getChildAt(r4);     // Catch: Exception -> L25
        if (r7 != null) goto L17;
    L21:
        if (r4 == r5) goto L24;
        r4 = r4 + 1;
        goto L14
    L24:
        return r6;
    L17:
        if (this.b == 2) goto L19;
        int r8 = r7.getWidth() + UtilityKotlinExtentionsKt.d(8);     // Catch: Exception -> L25
    L20:
        r6 = r6 + ((long) r8);
        goto L21
    L19:
        r8 = r7.getWidth();     // Catch: Exception -> L25
        goto L20
    L32:
        return 0;
    L11:
        r5 = 0;
        goto L12
    L31:
        return 0;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CategoryListAdapter r0 = this.a;
        if (r0 == null) goto L16;
        List r1 = CollectionsKt.toList(r0.f);
        if (r1 == null) goto L22;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L23;
        String r3 = (String) r2.next();
        int r4 = ci2.a.a;
        if (r3 == null) goto L8;
        q r5 = q.a;
        String r6 = r5.getString("ec_live_tab_enhance_control_show", "");
        HashMap r7 = j.a;
        JSONObject r8 = j.i(r6);
        if (r8 != null) goto L15;
        r8 = new JSONObject();
    L15:
        r8.put(r3, 1);
        r5.putString("ec_live_tab_enhance_control_show", r8.toString());
        goto L8
    L23:
        return;
    L22:
        return;
    }

    public final void t() {
        if (getItemDecorationCount() <= 0) goto L14;
        int r0 = getItemDecorationCount() - 1;     // Catch: Exception -> L8
    L5:
        if (r0 < 0) goto L15;
        removeItemDecoration(getItemDecorationAt(r0));     // Catch: Exception -> L8
        r0 = r0 - 1;
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryRecyclerView(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12);
        addItemDecoration(new CategoryItemDecoration(UtilityKotlinExtentionsKt.d(8), 0, null, null, null, null, null, null, 252));
        setFocusableInTouchMode(false);
        setHasFixedSize(true);
        addOnScrollListener(new AnonymousClass1());
        CategoryLineaLayoutManager r0 = new CategoryLineaLayoutManager(getContext());
        r0.setOrientation(0);
        Unit r13 = Unit.INSTANCE;
        setLayoutManager(r0);
    }

    public final void r(Function1<? super PromotionCategory, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "tabChangedCallback");
        boolean r0 = false;
        scrollToPosition(0);
        CategoryListAdapter r1 = this.a;
        if (r1 == null) goto L31;
        PromotionCategory r2 = r1.z2();
        if (r2 == null) goto L31;
        PromotionCategory.a r3 = PromotionCategory.Companion;
        String r4 = r2.getUniqueIndex();
        r3.getClass();
        Integer r5 = null;
        if ((!PromotionCategory.a.b(r4)) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L31;
        CategoryListAdapter r6 = this.a;
        if (r6 == null) goto L31;
        PromotionCategory r7 = (PromotionCategory) CollectionsKt.getOrNull(r6.a, r6.c);
        if (r7 == null) goto L16;
        r7.setSelected(false);
    L16:
        r6.notifyItemChanged(r6.c);
        Iterator<PromotionCategory> r8 = r6.a.iterator();
        int r10 = 0;
    L18:
        if (r8.hasNext() == false) goto L23;
        PromotionCategory r11 = r8.next();
        PromotionCategory.a r12 = PromotionCategory.Companion;
        String r13 = r11.getUniqueIndex();
        r12.getClass();
        if (PromotionCategory.a.b(r13) == true) goto L24;
        r10 = r10 + 1;
    L24:
        Integer r14 = Integer.valueOf(r10);
        if (r14.intValue() < 0) goto L27;
        r0 = true;
    L27:
        if (r0 == false) goto L29;
        r5 = r14;
    L29:
        if (r5 == null) goto L31;
        int r15 = r5.intValue();
        ((PromotionCategory) ListProtector.get(r6.a, r15)).setSelected(true);
        r6.notifyItemChanged(r15);
        goto L31
    L23:
        r10 = -1;
    L31:
        CategoryListAdapter r16 = this.a;
        if (r16 == null) goto L39;
        PromotionCategory r17 = r16.z2();
        if (r17 == null) goto L40;
        r9.invoke(r17);
        return;
    L40:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryRecyclerView(Context r12, AttributeSet r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13);
        addItemDecoration(new CategoryItemDecoration(UtilityKotlinExtentionsKt.d(8), 0, null, null, null, null, null, null, 252));
        setFocusableInTouchMode(false);
        setHasFixedSize(true);
        addOnScrollListener(new AnonymousClass1());
        CategoryLineaLayoutManager r14 = new CategoryLineaLayoutManager(getContext());
        r14.setOrientation(0);
        Unit r15 = Unit.INSTANCE;
        setLayoutManager(r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryRecyclerView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        addItemDecoration(new CategoryItemDecoration(UtilityKotlinExtentionsKt.d(8), 0, null, null, null, null, null, null, 252));
        setFocusableInTouchMode(false);
        setHasFixedSize(true);
        addOnScrollListener(new AnonymousClass1());
        CategoryLineaLayoutManager r15 = new CategoryLineaLayoutManager(getContext());
        r15.setOrientation(0);
        Unit r16 = Unit.INSTANCE;
        setLayoutManager(r15);
    }
}

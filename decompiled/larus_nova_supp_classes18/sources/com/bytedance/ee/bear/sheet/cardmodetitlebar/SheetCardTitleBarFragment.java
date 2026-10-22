package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "viewModel", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarViewModel;", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "clearNavBarItems", "addNavBarItem", "item", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/NavBarItem;", "close", "onDestroyView", "onBackPressed", "", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetCardTitleBarFragment extends BaseFragment {
    public static final Map<String, Integer> h = null;
    public BaseTitleBar e;
    public SheetCardTitleBarViewModel f;
    public xu5.b.a g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SheetCardTitleBarFragment a;

        public b(SheetCardTitleBarFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Map<String, Integer> r4 = SheetCardTitleBarFragment.h;
            tt5.a.b("SheetCardTitleBarFragment", "back view clicked...");
            HashMap r5 = new HashMap();
            r5.put("click", "close");
            r5.put("target", "none");
            qm5.b.b("ccm_space_docs_topbar_click", r5);
            this.a.close();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ SheetCardTitleBarFragment a;

        public c(SheetCardTitleBarFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            CardNavBarData r11 = (CardNavBarData) r10;
            if (r11 == null) goto L62;
            SheetCardTitleBarFragment r0 = this.a;
            if (r11.getBgColor() == null) goto L63;
            String r1 = r11.getBgColor();
            Intrinsics.checkNotNull(r1);
            int r2 = ColorUtils.h(r1);
            BaseTitleBar r3 = r0.e;
            BaseTitleBar r4 = null;
            if (r3 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r3 = null;
        L10:
            r3.setBackgroundColor(r2);
            xu5.b.a r5 = r0.g;
            if (r5 == null) goto L13;
            r5.b(r2, true);
        L13:
            String r6 = r11.getTitle();
            if (r6 == null) goto L19;
            BaseTitleBar r7 = r0.e;
            if (r7 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r7 = null;
        L18:
            r7.setTitle(r6);
        L19:
            CardNavBarItem r8 = r11.getItems();
            if (r8 == null) goto L24;
            NavBarItem[] r9 = r8.getLeft();
            if (r9 == null) goto L24;
            NavBarItem r12 = (NavBarItem) ArraysKt.firstOrNull(r9);
        L25:
            if (r12 == null) goto L27;
            String r13 = r12.getId();
        L29:
            if (Intrinsics.areEqual(r13, "back") == true) goto L31;
            Map<String, Integer> r14 = SheetCardTitleBarFragment.h;
            tt5.a.d("SheetCardTitleBarFragment", "setCardNavBar leftItem's id is not 'back'!!");
        L31:
            BaseTitleBar r15 = r0.e;
            if (r15 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r15 = null;
        L34:
            r15.f();
            BaseTitleBar r16 = r0.e;
            if (r16 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r16 = null;
        L37:
            r16.g();
            CardNavBarItem r17 = r11.getItems();
            if (r17 == null) goto L53;
            NavBarItem[] r18 = r17.getRight();
            if (r18 == null) goto L53;
            int r19 = r18.length;
            int r20 = 0;
        L42:
            if (r20 >= r19) goto L53;
            NavBarItem r21 = r18[r20];
            Integer r22 = SheetCardTitleBarFragment.h.get(r21.getId());
            if (r22 == null) goto L52;
            com.bytedance.ee.bear.sheet.cardmodetitlebar.a r23 = new com.bytedance.ee.bear.sheet.cardmodetitlebar.a(r22.intValue(), r0, r21);
            BaseTitleBar r24 = r0.e;
            if (r24 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            r24 = null;
        L48:
            View r25 = r24.a(r23, true);
            String r26 = r21.getId();
            if (r26 != null) goto L51;
            r26 = "";
        L51:
            r25.setTag(r26);
        L52:
            r20 = r20 + 1;
        L53:
            BaseTitleBar r110 = r0.e;
            if (r110 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        L57:
            r4.setActionIconTint(2131102418);
            return;
        L56:
            r4 = r110;
            goto L57
        L27:
            r13 = null;
        L24:
            r12 = null;
            goto L25
        L63:
            return;
        }
    }

    static {
        h = MapsKt.mapOf(new Pair[]{TuplesKt.to("card", 2131255668), TuplesKt.to("list", 2131254229), TuplesKt.to("more", 2131255147)});
    }

    public final void close() {
        SheetCardTitleBarViewModel r0 = this.f;
        SheetCardTitleBarViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.getActive().setValue(Boolean.FALSE);
        SheetCardTitleBarViewModel r2 = this.f;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        SheetCardTitleBarViewModel.a r3 = r1.getDelegate();
        if (r3 == null) goto L13;
        r3.a("back");
        return;
    L13:
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final boolean onBackPressed() {
        close();
        return true;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        xu5.b.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.resetState();
        return;
    }

    public SheetCardTitleBarFragment() {
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.f = (SheetCardTitleBarViewModel) q.a(this, SheetCardTitleBarViewModel.class);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        int r5 = n.a;
        BaseTitleBar r6 = (BaseTitleBar) r3.findViewById(2131365219);
        this.e = r6;
        SheetCardTitleBarViewModel r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r6 = null;
    L5:
        r6.setLeftImageResource(2131254124);
        BaseTitleBar r7 = this.e;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r7 = null;
    L8:
        r7.setLeftClickListener(new b(this));
        qm5.b.b("ccm_space_docs_topbar_view", new HashMap());
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L11;
        this.g = xu5.b.b(r8, null);
    L11:
        xu5.b.a r9 = this.g;
        if (r9 == null) goto L14;
        r9.saveState();
    L14:
        SheetCardTitleBarViewModel r10 = this.f;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r0.getNavBar().observe(this, new c(this));
        return;
    L17:
        r0 = r10;
        goto L18
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564529, r3, false);
    }
}

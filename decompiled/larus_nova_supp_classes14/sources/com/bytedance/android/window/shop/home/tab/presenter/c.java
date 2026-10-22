package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.window.shop.holder.WindowHybridToolBarHolder;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.android.window.shop.widget.ECWindowTabLayout;
import com.bytedance.android.window.shop.widget.SubCategoryView;
import com.bytedance.android.window.shop.widget.ToolBarView;
import com.bytedance.android.window.shop.widget.childcategory.HorizontalWeightedGroupView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ ECWindowHybridTabPresenter a;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ WindowHybridToolBarHolder b;

        public a(c r1, WindowHybridToolBarHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            this.a.a.k0().setPadding(this.a.a.k0().getPaddingLeft(), ((RecyclerView.ViewHolder) this.b).itemView.getHeight(), this.a.a.k0().getPaddingRight(), this.a.a.k0().getPaddingBottom());
            ToolBarView r0 = this.b.u4();
            if (r0 != null) goto L5;
            return;
        L5:
            bg4.b.b(Observable.just(r0)).subscribe(this.a.a.t);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(ECWindowHybridTabPresenter r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.view.ViewGroup, com.bytedance.android.window.shop.widget.childcategory.HorizontalWeightedGroupView] */
    public final void a() {
        BaseViewHolder r1 = this.a.e0().e("tool_bar", "3002");
        WindowChildCategoryVO.ChildCategoryVO r3 = null;
        Object r4 = null;
        r3 = null;
        if ((r1 instanceof WindowHybridToolBarHolder) == true) goto L5;
        r1 = null;
    L5:
        WindowHybridToolBarHolder r2 = (WindowHybridToolBarHolder) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        this.a.p = r2.u4();
        ((RecyclerView.ViewHolder) r2).itemView.post(new a(this, r2));
        final ECWindowHybridTabPresenter r5 = this.a;
        final ToolBarView r6 = r2.u4();
        if (r6 == null) goto L12;
        r5.getClass();
        r6.getSortBarView().a("resort", new ECWindowHybridTabPresenter$renderToolBar$1(r5, r6));
        r6.setLayoutChangeCallback(new ECWindowHybridTabPresenter$renderToolBar$2(r5));
        r6.setLifecycleOwner(((QFragmentPresenter) r5).e);
        r6.setFilterTypeChangeCB(new ECWindowHybridTabPresenter$renderToolBar$3(r5));
        r6.setDoEventAction(new ECWindowHybridTabPresenter$renderToolBar$4(r5));
    L12:
        ECWindowHybridTabPresenter r7 = this.a;
        SubCategoryView r8 = (SubCategoryView) r2.s.getValue();
        if (r8.getVisibility() != 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L19;
        r8 = null;
    L19:
        if (r8 == null) goto L25;
        r7.getClass();
        f r10 = new f(r7);
        Intrinsics.checkNotNullParameter(r10, "listener");
        ECWindowTabLayout r11 = r8.a;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L24:
        r11.addOnTabSelectedListener(r10);
        r8.b(r7.l0().getLastSubCategoryId());
    L25:
        ECWindowHybridTabPresenter r12 = this.a;
        HorizontalWeightedGroupView r13 = (HorizontalWeightedGroupView) r2.r.getValue();
        if (r13.getVisibility() != 0) goto L28;
        boolean r14 = true;
    L29:
        if (r14 == true) goto L32;
        r13 = 0;
    L32:
        if (r13 == 0) goto L97;
        r12.getClass();
        r13.setOnSelectionChangedListener(new d(r12));
        com.bytedance.android.window.shop.repository.tab.entity.q r15 = (com.bytedance.android.window.shop.repository.tab.entity.q) r2.o;
        if (r15 == null) goto L96;
        WindowHybridTabViewModel r16 = r12.l0();
        WindowChildCategoryVO r17 = r15.m;
        if (r17 == null) goto L53;
        List<WindowChildCategoryVO.ChildCategoryVO> r18 = r17.a;
        if (r18 == null) goto L53;
        Iterator<T> r19 = r18.iterator();
    L42:
        if (r19.hasNext() == false) goto L49;
        Object r20 = r19.next();
        if (((WindowChildCategoryVO.ChildCategoryVO) r20).getSelected() != true) goto L46;
        boolean r21 = true;
    L47:
        if (r21 == false) goto L42;
    L50:
        WindowChildCategoryVO.ChildCategoryVO r22 = (WindowChildCategoryVO.ChildCategoryVO) r20;
        if (r22 == null) goto L53;
        String r23 = r22.getId();
    L54:
        r16.setLastChildCategory(r23);
        WindowHybridTabViewModel r24 = r12.l0();
        fo.a<Set<String>> r25 = wn.a.p;
        WindowChildCategoryVO r26 = r15.m;
        if (r26 == null) goto L59;
        List<WindowChildCategoryVO.ChildCategoryVO> r27 = r26.a;
        if (r27 == null) goto L59;
        String r28 = CollectionsKt.joinToString$default(r27, null, null, null, 0, null, ECWindowHybridTabPresenter$onChildCategoryInitialized$2$2.INSTANCE, 31, null);
    L60:
        if (r28 != null) goto L63;
        r28 = "";
    L63:
        if (r24.isIdFirstShowing(r25, r28) == false) goto L72;
        WindowChildCategoryVO r29 = r15.m;
        if (r29 == null) goto L72;
        List<WindowChildCategoryVO.ChildCategoryVO> r30 = r29.a;
        if (r30 == null) goto L72;
        Iterator<T> r31 = r30.iterator();
    L70:
        if (r31.hasNext() == false) goto L72;
        r12.l0().doAnyEventActionWithBtm("c68164.d520689", PageFinder.via(((QFragmentPresenter) r12).e), "moments_card_show", MapsKt.mapOf(TuplesKt.to("tab_name_second", ((WindowChildCategoryVO.ChildCategoryVO) r31.next()).getId())), new Pair[0]);
    L72:
        WindowChildCategoryVO r32 = r15.m;
        if (r32 == null) goto L83;
        List<WindowChildCategoryVO.ChildCategoryVO> r33 = r32.a;
        if (r33 == null) goto L83;
        Iterator<T> r34 = r33.iterator();
    L78:
        if (r34.hasNext() == false) goto L82;
        Object r35 = r34.next();
        if (((WindowChildCategoryVO.ChildCategoryVO) r35).getSelected() == false) goto L78;
        r4 = r35;
    L82:
        r3 = (WindowChildCategoryVO.ChildCategoryVO) r4;
    L83:
        if (r3 == null) goto L98;
        r12.l0().appendEventParams(new Pair[]{TuplesKt.to("tab_name_second", r3.getId())});
        return;
    L98:
        return;
    L59:
        r28 = null;
        goto L60
    L46:
        r21 = false;
        goto L47
    L49:
        r20 = null;
    L53:
        r23 = null;
        goto L54
    L96:
        return;
    L97:
        return;
    L28:
        r14 = false;
        goto L29
    L15:
        r9 = false;
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

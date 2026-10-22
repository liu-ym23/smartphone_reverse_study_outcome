package com.bytedance.ee.bear.search.picker.filter.type;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.ee.bear.search.picker.SpaceSearchViewModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u0014H\u0016J\u0012\u00105\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u0002072\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010>\u001a\u00020\u0014H\u0002J\b\u0010?\u001a\u00020\u0014H\u0002J\u0010\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020BH\u0002J\u0012\u0010C\u001a\u00020\u00142\b\u0010D\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bH\u0002J\u0010\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020BH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/type/SearchSelectTypeFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "docTypeRecycleFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getDocTypeRecycleFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setDocTypeRecycleFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "folderTypeRecycleFromXml", "getFolderTypeRecycleFromXml", "setFolderTypeRecycleFromXml", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "onDestroyView", "docTypeRecyle", "folderTypeRecyle", "docTypeList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/search/picker/filter/type/SelectTypeItem;", "Lkotlin/collections/ArrayList;", "folderTypeList", "docTypeAdapter", "Lcom/bytedance/ee/bear/search/picker/filter/type/SearchSelectAdapter;", "folderTypeAdapter", "titleBar", "multiSelectEnableView", "Landroid/widget/TextView;", "isMultiSelectEnabled", "", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "getBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "mViewModel", "Lcom/bytedance/ee/bear/search/picker/SpaceSearchViewModel;", "selectedTypes", "", "isFilterFolder", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "initTypeList", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initTitleBar", "switchMultiEnableStatus", "updateMultiSelectEnableView", "selectSize", "", "refreshSelectStatus", "selectItem", "getSelectedTypes", "enableType", ResourceData.KEY_TYPE, "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchSelectTypeFragment extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int A = 0;
    public RecyclerView k;
    public RecyclerView l;
    public BaseTitleBar m;
    public RecyclerView n;
    public RecyclerView o;
    public final ArrayList<e> p;
    public final ArrayList<e> q;
    public SearchSelectAdapter r;
    public SearchSelectAdapter s;
    public BaseTitleBar t;
    public TextView u;
    public boolean v;
    public BottomSheetBehavior<FrameLayout> w;
    public SpaceSearchViewModel x;
    public int[] y;
    public boolean z;

    public static final class a {
    }

    static {
    }

    public final ArrayList<e> ga0() {
        ArrayList<e> r0 = new ArrayList();
        SearchSelectAdapter r1 = this.r;
        SearchSelectAdapter r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeAdapter");
        r1 = null;
    L5:
        ArrayList<e> r3 = r1.a;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Object r6 = r5.next();
        if (((e) r6).c == false) goto L7;
        r4.add(r6);
        goto L7
    L11:
        r0.addAll(r4);
        SearchSelectAdapter r7 = this.s;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeAdapter");
    L15:
        ArrayList<e> r8 = r2.a;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L17:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        if (((e) r11).c == false) goto L17;
        r9.add(r11);
        goto L17
    L21:
        r0.addAll(r9);
        return r0;
    L14:
        r2 = r7;
        goto L15
    }

    public final void ha0() {
        SearchSelectAdapter r0 = this.r;
        SearchSelectAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeAdapter");
        r0 = null;
    L5:
        r0.c = this.v;
        r0.notifyDataSetChanged();
        SearchSelectAdapter r2 = this.s;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeAdapter");
    L9:
        r1.c = this.v;
        r1.notifyDataSetChanged();
        int[] r3 = this.y;
        if (r3 == null) goto L12;
        int r4 = r3.length;
    L13:
        ia0(r4);
        return;
    L12:
        r4 = 0;
        goto L13
    L8:
        r1 = r2;
        goto L9
    }

    public SearchSelectTypeFragment() {
        this.p = new ArrayList();
        this.q = new ArrayList();
    }

    public final void ea0() {
        super.onStart();
        BottomSheetDialog r0 = getDialog();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetDialog r1 = r0;
        FrameLayout r2 = (FrameLayout) r1.getDelegate().findViewById(2131368870);
        if (r2 == null) goto L5;
        CoordinatorLayout.LayoutParams r3 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) r3).height = -1;
        this.w = BottomSheetBehavior.from(r2);
    L5:
        BottomSheetBehavior<FrameLayout> r4 = this.w;
        if (r4 == null) goto L8;
        r4.setDraggable(false);
    L8:
        BottomSheetBehavior<FrameLayout> r5 = this.w;
        if (r5 == null) goto L11;
        r5.setState(3);
    L11:
        Window r6 = r1.getWindow();
        if (r6 == null) goto L19;
        zo5.b r7 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        View r8 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r9 = ThreadMethodProxy.currentThread();
        if (r9 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r9, "getDecorView");
    L18:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout");
        r7.p((FrameLayout) r8);
    L19:
        ca0(2131100548);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.k = null;
        this.l = null;
        this.m = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        ea0();
    }

    public static boolean fa0(int r5) {
        boolean r0 = ((k) org.koin.java.a.c(k.class, null, null, 6)).d();
        if (r5 != 8) goto L8;
        if (r0 == false) goto L8;
        return com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.bitable.enable", true);
    L8:
        if (r5 == 11) goto L10;
        return true;
    L10:
        return ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).x();
    }

    public final void ia0(int r9) {
        if (this.v == false) goto L22;
        if (r9 <= 0) goto L6;
        boolean r0 = true;
    L7:
        Context r1 = getContext();
        if (r1 == null) goto L23;
        TextView r2 = this.u;
        TextView r3 = null;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r2 = null;
    L12:
        StringBuilder r5 = new StringBuilder();
        r5.append(r1.getResources().getString(2131887800));
        if (r0 == false) goto L15;
        String r10 = "(" + r9 + ')';
    L16:
        r5.append(r10);
        r2.setText(r5.toString());
        TextView r11 = this.u;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
    L20:
        r3.setTextColor(r1.getResources().getColor(2131105568));
        return;
    L19:
        r3 = r11;
        goto L20
    L15:
        r10 = "";
        goto L16
    L23:
        return;
    L6:
        r0 = false;
        goto L7
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        SpaceSearchViewModel r0 = null;
        if (r8 == null) goto L5;
        int[] r9 = r8.getIntArray("selected_types");
    L6:
        this.y = r9;
        Bundle r10 = getArguments();
        boolean r1 = false;
        if (r10 == null) goto L9;
        boolean r11 = r10.getBoolean("isFilterFolder");
    L10:
        this.z = r11;
        int[] r12 = this.y;
        ArrayList<e> r2 = this.p;
        e r3 = new e(2131887745, 22);
        r3.a(r12);
        r2.add(r3);
        ArrayList<e> r4 = this.p;
        e r5 = new e(2131887733, 3);
        r5.a(r12);
        r4.add(r5);
        if (fa0(11) == false) goto L14;
        ArrayList<e> r6 = this.p;
        e r13 = new e(2131887774, 11);
        r13.a(r12);
        r6.add(r13);
    L14:
        if (fa0(8) == false) goto L17;
        ArrayList<e> r14 = this.p;
        e r15 = new e(2131887715, 8);
        r15.a(r12);
        r14.add(r15);
    L17:
        if (fa0(12) == false) goto L20;
        ArrayList<e> r16 = this.p;
        e r17 = new e(2131889109, 12);
        r17.a(r12);
        r16.add(r17);
    L20:
        if (((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().c().a == false) goto L23;
        ArrayList<e> r18 = this.q;
        e r19 = new e(2131887757, 0);
        r19.a(r12);
        r18.add(r19);
    L23:
        if (r12 != null) goto L25;
    L27:
        this.v = !r1;
        this.r = new SearchSelectAdapter(this.p, new AnonymousClass1(this));
        this.s = new SearchSelectAdapter(this.q, new AnonymousClass2(this));
        FragmentActivity r20 = getActivity();
        if (r20 == null) goto L30;
        r0 = (SpaceSearchViewModel) ViewModelProviders.of(r20).get(SpaceSearchViewModel.class);
    L30:
        this.x = r0;
        return;
    L25:
        if (r12.length != 0) goto L27;
        r1 = true;
        goto L27
    L9:
        r11 = false;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public static final void da0(SearchSelectTypeFragment r3, e r4) {
        if (r4 == null) goto L14;
        SpaceSearchViewModel r0 = r3.x;
        if (r0 == null) goto L18;
        MutableLiveData<ArrayList<e>> r1 = r0.getDocTypeSelectItem();
        if (r1 == null) goto L18;
        r1.postValue(CollectionsKt.arrayListOf(new e[]{r4}));
    L18:
        r3.dismiss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L20;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L14:
        ArrayList<e> r6 = r3.ga0();
        if (r3.getContext() == null) goto L22;
        r3.ia0(r6.size());
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r6, r7);
        View r8 = this.m;
        ViewGroup r9 = null;
        if (r8 != null) goto L9;
        View r10 = getView();
        if (r10 == null) goto L7;
        r8 = r10.findViewById(2131388807);
    L8:
        this.m = (BaseTitleBar) r8;
        goto L9
    L7:
        r8 = null;
    L9:
        BaseTitleBar r11 = (BaseTitleBar) r8;
        this.t = r11;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r11 = null;
    L12:
        r11.setLeftImageResource(2131254123);
        BaseTitleBar r12 = this.t;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r12 = null;
    L15:
        r12.setLeftClickListener(new c(this));
        BaseTitleBar r13 = this.t;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r13 = null;
    L18:
        r13.setTitle(2131888196);
        BaseTitleBar r14 = this.t;
        if (r14 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r14 = null;
    L21:
        r14.setMainTitleSize(17.0f);
        BaseTitleBar r15 = this.t;
        if (r15 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r15 = null;
    L24:
        r15.setDividerVisible(false);
        TextView r16 = new TextView(getContext());
        this.u = r16;
        r16.setTextSize(16.0f);
        TextView r17 = this.u;
        if (r17 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r17 = null;
    L27:
        r17.setGravity(16);
        TextView r18 = this.u;
        if (r18 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r18 = null;
    L30:
        r18.setText(2131891909);
        TextView r19 = this.u;
        if (r19 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r19 = null;
    L33:
        r19.setTextColor(getResources().getColor(2131106622));
        TextView r20 = this.u;
        if (r20 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r20 = null;
    L36:
        r20.setOnClickListener(new d(this));
        ha0();
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-2, -1);
        r21.rightMargin = n.d(17);
        BaseTitleBar r3 = this.t;
        if (r3 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r3 = null;
    L39:
        TextView r0 = this.u;
        if (r0 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r0 = null;
    L42:
        r3.f.removeAllViews();
        r3.f.setPadding(0, 0, 0, 0);
        r3.f.addView(r0, r21);
        View r22 = this.k;
        if (r22 != null) goto L49;
        View r23 = getView();
        if (r23 == null) goto L47;
        r22 = r23.findViewById(2131369381);
    L48:
        this.k = (RecyclerView) r22;
        goto L49
    L47:
        r22 = null;
    L49:
        this.n = (RecyclerView) r22;
        View r24 = this.l;
        if (r24 != null) goto L56;
        View r25 = getView();
        if (r25 == null) goto L54;
        r24 = r25.findViewById(2131373078);
    L55:
        this.l = (RecyclerView) r24;
        goto L56
    L54:
        r24 = null;
    L56:
        this.o = (RecyclerView) r24;
        RecyclerView r26 = this.n;
        if (r26 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeRecyle");
        r26 = null;
    L59:
        SearchSelectAdapter r1 = this.r;
        if (r1 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeAdapter");
        r1 = null;
    L62:
        r26.setAdapter(r1);
        RecyclerView r27 = this.n;
        if (r27 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeRecyle");
        r27 = null;
    L65:
        r27.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView r28 = this.o;
        if (r28 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeRecyle");
        r28 = null;
    L68:
        SearchSelectAdapter r2 = this.s;
        if (r2 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeAdapter");
        r2 = null;
    L71:
        r28.setAdapter(r2);
        RecyclerView r29 = this.o;
        if (r29 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeRecyle");
        r29 = null;
    L74:
        r29.setLayoutManager(new LinearLayoutManager(getContext()));
        SearchSelectAdapter r30 = this.r;
        if (r30 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeAdapter");
        r30 = null;
    L77:
        r30.notifyDataSetChanged();
        SearchSelectAdapter r31 = this.s;
        if (r31 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeAdapter");
        r31 = null;
    L80:
        r31.notifyDataSetChanged();
        if (this.z == false) goto L88;
        ViewGroup r32 = this.o;
        if (r32 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeRecyle");
    L86:
        r9.setVisibility(8);
        return;
    L85:
        r9 = r32;
        goto L86
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561245, r3, false);
    }
}

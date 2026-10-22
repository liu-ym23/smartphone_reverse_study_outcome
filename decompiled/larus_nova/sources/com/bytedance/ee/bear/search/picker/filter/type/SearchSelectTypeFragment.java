package com.bytedance.ee.bear.search.picker.filter.type;

import android.app.Dialog;
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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.ee.bear.search.picker.SpaceSearchViewModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u0014H\u0016J\u0012\u00105\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u0002072\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010>\u001a\u00020\u0014H\u0002J\b\u0010?\u001a\u00020\u0014H\u0002J\u0010\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020BH\u0002J\u0012\u0010C\u001a\u00020\u00142\b\u0010D\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bH\u0002J\u0010\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020BH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/type/SearchSelectTypeFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "docTypeRecycleFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getDocTypeRecycleFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setDocTypeRecycleFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "folderTypeRecycleFromXml", "getFolderTypeRecycleFromXml", "setFolderTypeRecycleFromXml", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "onDestroyView", "docTypeRecyle", "folderTypeRecyle", "docTypeList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/search/picker/filter/type/SelectTypeItem;", "Lkotlin/collections/ArrayList;", "folderTypeList", "docTypeAdapter", "Lcom/bytedance/ee/bear/search/picker/filter/type/SearchSelectAdapter;", "folderTypeAdapter", "titleBar", "multiSelectEnableView", "Landroid/widget/TextView;", "isMultiSelectEnabled", "", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "getBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "mViewModel", "Lcom/bytedance/ee/bear/search/picker/SpaceSearchViewModel;", "selectedTypes", "", "isFilterFolder", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "initTypeList", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initTitleBar", "switchMultiEnableStatus", "updateMultiSelectEnableView", "selectSize", "", "refreshSelectStatus", "selectItem", "getSelectedTypes", "enableType", "type", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchSelectTypeFragment extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f236898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f236899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BaseTitleBar f236900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f236901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f236902o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<e> f236903p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<e> f236904q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SearchSelectAdapter f236905r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SearchSelectAdapter f236906s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public BaseTitleBar f236907t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f236908u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f236909v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f236910w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SpaceSearchViewModel f236911x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f236912y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f236913z;

    public static final class a {
    }

    static {
    }

    public final ArrayList<e> ga0() {
        ArrayList<e> r100 = new ArrayList();
        SearchSelectAdapter r101 = this.f236905r;
        SearchSelectAdapter r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeAdapter");
        r101 = null;
    L5:
        ArrayList<e> r103 = r101.f236895a;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if (((e) r106).f236927c == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        r100.addAll(r104);
        SearchSelectAdapter r107 = this.f236906s;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeAdapter");
    L15:
        ArrayList<e> r108 = r102.f236895a;
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L17:
        if (r110.hasNext() == false) goto L21;
        Object r111 = r110.next();
        if (((e) r111).f236927c == false) goto L17;
        r109.add(r111);
        goto L17
    L21:
        r100.addAll(r109);
        return r100;
    L14:
        r102 = r107;
        goto L15
    }

    public final void ha0() {
        SearchSelectAdapter r100 = this.f236905r;
        SearchSelectAdapter r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeAdapter");
        r100 = null;
    L5:
        r100.f236897c = this.f236909v;
        r100.notifyDataSetChanged();
        SearchSelectAdapter r102 = this.f236906s;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeAdapter");
    L9:
        r101.f236897c = this.f236909v;
        r101.notifyDataSetChanged();
        int[] r103 = this.f236912y;
        if (r103 == null) goto L12;
        int r104 = r103.length;
    L13:
        ia0(r104);
        return;
    L12:
        r104 = 0;
        goto L13
    L8:
        r101 = r102;
        goto L9
    }

    public SearchSelectTypeFragment() {
        this.f236903p = new ArrayList();
        this.f236904q = new ArrayList();
    }

    public final void ea0() {
        super.onStart();
        Dialog r100 = getDialog();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetDialog r101 = (BottomSheetDialog) r100;
        FrameLayout r102 = (FrameLayout) r101.getDelegate().findViewById(R.id.design_bottom_sheet);
        if (r102 == null) goto L5;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r103)).height = -1;
        this.f236910w = BottomSheetBehavior.from(r102);
    L5:
        BottomSheetBehavior<FrameLayout> r104 = this.f236910w;
        if (r104 == null) goto L8;
        r104.setDraggable(false);
    L8:
        BottomSheetBehavior<FrameLayout> r105 = this.f236910w;
        if (r105 == null) goto L11;
        r105.setState(3);
    L11:
        Window r106 = r101.getWindow();
        if (r106 == null) goto L19;
        zo5.b r107 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        View r108 = r106.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r109 = ThreadMethodProxy.currentThread();
        if (r109 == com.larus.home.impl.utils.c.f346341a) goto L18;
        com.larus.home.impl.utils.c.a(r109, "getDecorView");
    L18:
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.widget.FrameLayout");
        r107.p((FrameLayout) r108);
    L19:
        ca0(R.color.bg_body);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f236898k = null;
        this.f236899l = null;
        this.f236900m = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        ea0();
    }

    public static boolean fa0(int r100) {
        boolean r101 = ((k) org.koin.java.a.c(k.class, null, null, 6)).d();
        if (r100 != 8) goto L8;
        if (r101 == false) goto L8;
        return com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.spacekit.bitable.enable", true);
    L8:
        if (r100 == 11) goto L10;
        return true;
    L10:
        return ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).x();
    }

    public final void ia0(int r100) {
        if (this.f236909v == false) goto L22;
        if (r100 <= 0) goto L6;
        boolean r101 = true;
    L7:
        Context r102 = getContext();
        if (r102 == null) goto L23;
        TextView r103 = this.f236908u;
        TextView r104 = null;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r103 = null;
    L12:
        StringBuilder r105 = new StringBuilder();
        r105.append(r102.getResources().getString(R.string.Doc_Facade_Ok));
        if (r101 == false) goto L15;
        String r106 = "(" + r100 + ')';
    L16:
        r105.append(r106);
        r103.setText(r105.toString());
        TextView r107 = this.f236908u;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
    L20:
        r104.setTextColor(r102.getResources().getColor(R.color.primary_pri_500));
        return;
    L19:
        r104 = r107;
        goto L20
    L15:
        r106 = "";
        goto L16
    L23:
        return;
    L6:
        r101 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        SpaceSearchViewModel r102 = null;
        if (r101 == null) goto L5;
        int[] r103 = r101.getIntArray("selected_types");
    L6:
        this.f236912y = r103;
        Bundle r104 = getArguments();
        boolean r105 = false;
        if (r104 == null) goto L9;
        boolean r106 = r104.getBoolean("isFilterFolder");
    L10:
        this.f236913z = r106;
        int[] r107 = this.f236912y;
        ArrayList<e> r108 = this.f236903p;
        e r109 = new e(R.string.Doc_Facade_Document, 22);
        r109.a(r107);
        r108.add(r109);
        ArrayList<e> r110 = this.f236903p;
        e r111 = new e(R.string.Doc_Facade_CreateSheet, 3);
        r111.a(r107);
        r110.add(r111);
        if (fa0(11) == false) goto L14;
        ArrayList<e> r112 = this.f236903p;
        e r113 = new e(R.string.Doc_Facade_MindNote, 11);
        r113.a(r107);
        r112.add(r113);
    L14:
        if (fa0(8) == false) goto L17;
        ArrayList<e> r114 = this.f236903p;
        e r115 = new e(R.string.Doc_Facade_Bitable, 8);
        r115.a(r107);
        r114.add(r115);
    L17:
        if (fa0(12) == false) goto L20;
        ArrayList<e> r116 = this.f236903p;
        e r117 = new e(R.string.LarkCCM_Docs_LocalFile_Menu_Mob, 12);
        r117.a(r107);
        r116.add(r117);
    L20:
        if (((ww4.a) org.koin.java.a.c(ww4.a.class, null, null, 6)).a().c().f217118a == false) goto L23;
        ArrayList<e> r118 = this.f236904q;
        e r119 = new e(R.string.Doc_Facade_Folder, 0);
        r119.a(r107);
        r118.add(r119);
    L23:
        if (r107 != null) goto L25;
    L27:
        this.f236909v = !r105;
        this.f236905r = new SearchSelectAdapter(this.f236903p, new AnonymousClass1(this));
        this.f236906s = new SearchSelectAdapter(this.f236904q, new AnonymousClass2(this));
        FragmentActivity r120 = getActivity();
        if (r120 == null) goto L30;
        r102 = (SpaceSearchViewModel) ViewModelProviders.of(r120).get(SpaceSearchViewModel.class);
    L30:
        this.f236911x = r102;
        return;
    L25:
        if (r107.length != 0) goto L27;
        r105 = true;
        goto L27
    L9:
        r106 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static final void da0(SearchSelectTypeFragment r100, e r101) {
        if (r101 == null) goto L14;
        SpaceSearchViewModel r102 = r100.f236911x;
        if (r102 == null) goto L18;
        MutableLiveData<ArrayList<e>> r103 = r102.getDocTypeSelectItem();
        if (r103 == null) goto L18;
        r103.postValue(CollectionsKt.arrayListOf(new e[]{r101}));
    L18:
        r100.dismiss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L20;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L14:
        ArrayList<e> r105 = r100.ga0();
        if (r100.getContext() == null) goto L22;
        r100.ia0(r105.size());
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f236900m;
        RecyclerView r103 = null;
        if (r102 != null) goto L9;
        View r104 = getView();
        if (r104 == null) goto L7;
        r102 = r104.findViewById(R.id.title_bar);
    L8:
        this.f236900m = (BaseTitleBar) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        BaseTitleBar r105 = (BaseTitleBar) r102;
        this.f236907t = r105;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r105 = null;
    L12:
        r105.setLeftImageResource(R.drawable.ud_icon_close_outlined);
        BaseTitleBar r106 = this.f236907t;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r106 = null;
    L15:
        r106.setLeftClickListener(new c(this));
        BaseTitleBar r107 = this.f236907t;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r107 = null;
    L18:
        r107.setTitle(R.string.Doc_Search_Type);
        BaseTitleBar r108 = this.f236907t;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r108 = null;
    L21:
        r108.setMainTitleSize(17.0f);
        BaseTitleBar r109 = this.f236907t;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r109 = null;
    L24:
        r109.setDividerVisible(false);
        TextView r110 = new TextView(getContext());
        this.f236908u = r110;
        r110.setTextSize(16.0f);
        TextView r111 = this.f236908u;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r111 = null;
    L27:
        r111.setGravity(16);
        TextView r112 = this.f236908u;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r112 = null;
    L30:
        r112.setText(R.string.Lark_Legacy_MenuMultiSelect);
        TextView r113 = this.f236908u;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r113 = null;
    L33:
        r113.setTextColor(getResources().getColor(R.color.text_title));
        TextView r114 = this.f236908u;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r114 = null;
    L36:
        r114.setOnClickListener(new d(this));
        ha0();
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-2, -1);
        r115.rightMargin = n.d(17);
        BaseTitleBar r116 = this.f236907t;
        if (r116 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r116 = null;
    L39:
        TextView r117 = this.f236908u;
        if (r117 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("multiSelectEnableView");
        r117 = null;
    L42:
        r116.f240031f.removeAllViews();
        r116.f240031f.setPadding(0, 0, 0, 0);
        r116.f240031f.addView(r117, r115);
        View r118 = this.f236898k;
        if (r118 != null) goto L49;
        View r119 = getView();
        if (r119 == null) goto L47;
        r118 = r119.findViewById(R.id.doc_type_recycle);
    L48:
        this.f236898k = (RecyclerView) r118;
        goto L49
    L47:
        r118 = null;
    L49:
        this.f236901n = (RecyclerView) r118;
        View r120 = this.f236899l;
        if (r120 != null) goto L56;
        View r121 = getView();
        if (r121 == null) goto L54;
        r120 = r121.findViewById(R.id.folder_type_recycle);
    L55:
        this.f236899l = (RecyclerView) r120;
        goto L56
    L54:
        r120 = null;
    L56:
        this.f236902o = (RecyclerView) r120;
        RecyclerView r122 = this.f236901n;
        if (r122 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeRecyle");
        r122 = null;
    L59:
        SearchSelectAdapter r123 = this.f236905r;
        if (r123 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeAdapter");
        r123 = null;
    L62:
        r122.setAdapter(r123);
        RecyclerView r124 = this.f236901n;
        if (r124 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeRecyle");
        r124 = null;
    L65:
        r124.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView r125 = this.f236902o;
        if (r125 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeRecyle");
        r125 = null;
    L68:
        SearchSelectAdapter r126 = this.f236906s;
        if (r126 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeAdapter");
        r126 = null;
    L71:
        r125.setAdapter(r126);
        RecyclerView r127 = this.f236902o;
        if (r127 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeRecyle");
        r127 = null;
    L74:
        r127.setLayoutManager(new LinearLayoutManager(getContext()));
        SearchSelectAdapter r128 = this.f236905r;
        if (r128 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("docTypeAdapter");
        r128 = null;
    L77:
        r128.notifyDataSetChanged();
        SearchSelectAdapter r129 = this.f236906s;
        if (r129 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeAdapter");
        r129 = null;
    L80:
        r129.notifyDataSetChanged();
        if (this.f236913z == false) goto L88;
        RecyclerView r130 = this.f236902o;
        if (r130 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("folderTypeRecyle");
    L86:
        r103.setVisibility(8);
        return;
    L85:
        r103 = r130;
        goto L86
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_search_type, r101, false);
    }
}

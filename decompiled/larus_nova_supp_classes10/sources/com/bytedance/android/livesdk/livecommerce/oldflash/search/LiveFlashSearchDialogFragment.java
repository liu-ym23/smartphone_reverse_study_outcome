package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.ui.ec.widget.searchbar.ECSearchBar;
import com.bytedance.android.ui.ec.widget.titlebar.ECTitleBar;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/LiveFlashSearchDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/LiveFlashSearchViewModel;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashSearchDialogFragment extends ECBaseDialogFragment<LiveFlashSearchViewModel> {
    public static final /* synthetic */ int o = 0;
    public Map<Integer, View> i;
    public com.bytedance.android.livesdk.livecommerce.oldflash.search.a j;
    public Function1<? super String, Unit> k;
    public String l;
    public String m;
    public SearchListAdapter n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return 2131560721;
    }

    public LiveFlashSearchDialogFragment() {
        this.i = new LinkedHashMap();
        this.l = "";
        this.m = "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r1.gravity = 80;
        return r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.i).clear();
    }

    public static final void ja0(LiveFlashSearchDialogFragment r1) {
        ECSearchBar r0 = r1.ia0(2131385326);
        if (r0 == null) goto L10;
        String r2 = r0.getText();
        if (r2 == null) goto L11;
        LiveFlashSearchViewModel r3 = r1.g;
        if (r3 == null) goto L12;
        r3.startSearch(StringsKt.trim(r2).toString());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final View ia0(int r3) {
        if (this.i != null) goto L5;
        this.i = new LinkedHashMap();
    L5:
        View r0 = this.i.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.i.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Bundle r4 = getArguments();
        String r0 = "";
        if (r4 == null) goto L6;
        String r5 = r4.getString("title_bar_title");
        if (r5 == null) goto L6;
    L7:
        this.l = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L13;
        String r7 = r6.getString("search_hint");
        if (r7 == null) goto L13;
        r0 = r7;
    L13:
        this.m = r0;
        this.n = new SearchListAdapter(new AnonymousClass1(this));
        RecyclerView r8 = ia0(2131384973);
        if (r8 == null) goto L16;
        r8.setAdapter(this.n);
        r8.setLayoutManager(new LinearLayoutManager(getContext()));
        r8.addOnScrollListener(new LiveFlashSearchDialogFragment$onActivityCreated$$inlined$also$lambda$1(this));
    L16:
        ECTitleBar r1 = ia0(2131388807);
        if (r1 == null) goto L19;
        r1.setTitleText(this.l);
    L19:
        ECTitleBar r9 = ia0(2131388807);
        if (r9 == null) goto L22;
        r9.setLeftIconClickListener(new e(this));
    L22:
        ECSearchBar r10 = ia0(2131385326);
        if (r10 == null) goto L25;
        r10.setOnEditorActionListener(new b(r10, this));
        r10.hideTextAction();
        r10.setHint(this.m);
        r10.addTextChangedListener(new c(r10, this));
        r10.setTextActionClickListener(new d(r10));
    L25:
        LiveFlashSearchViewModel r11 = this.g;
        if (r11 == null) goto L28;
        r11.setSearchRepository(this.j);
    L28:
        LiveFlashSearchViewModel r12 = this.g;
        if (r12 == null) goto L31;
        r12.initOriginData();
    L31:
        LiveFlashSearchViewModel r13 = this.g;
        if (r13 == null) goto L36;
        LiveData<List<k>> r14 = r13.getDataListLiveData();
        if (r14 == null) goto L36;
        r14.observe(getViewLifecycleOwner(), new f(this));
    L36:
        LiveFlashSearchViewModel r15 = this.g;
        if (r15 == null) goto L41;
        LiveData<Boolean> r16 = r15.getShowSearchBarLiveData();
        if (r16 == null) goto L41;
        r16.observe(getViewLifecycleOwner(), new g(this));
    L41:
        LiveFlashSearchViewModel r17 = this.g;
        if (r17 == null) goto L47;
        LiveData<Boolean> r18 = r17.getDismissLiveData();
        if (r18 == null) goto L48;
        r18.observe(getViewLifecycleOwner(), new h(this));
        return;
    L48:
        return;
    L47:
        return;
    L6:
        r5 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L14
        super.onDismiss(r2);     // Catch: Throwable -> L14
        Function1<? super String, Unit> r3 = this.k;     // Catch: Throwable -> L14
        if (r3 == null) goto L12;
        LiveFlashSearchViewModel r0 = this.g;     // Catch: Throwable -> L14
        if (r0 == null) goto L10;
        LiveData<String> r1 = r0.getCurrentStringLiveData();     // Catch: Throwable -> L14
        if (r1 == null) goto L10;
        String r4 = (String) r1.getValue();     // Catch: Throwable -> L14
        if (r4 == null) goto L10;
    L11:
        Unit r5 = (Unit) r3.invoke(r4);     // Catch: Throwable -> L14
    L10:
        r4 = "";
    L12:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L14:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }
}

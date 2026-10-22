package com.bytedance.android.livesdk.livecommerce.oldflash.select;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashMultiSelectDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashMultiSelectViewModel;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashMultiSelectDialogFragment extends ECBaseDialogFragment<LiveFlashMultiSelectViewModel> {
    public static final /* synthetic */ int n = 0;
    public Map<Integer, View> i;
    public com.bytedance.android.livesdk.livecommerce.oldflash.select.a j;
    public Function1<? super List<String>, Unit> k;
    public String l;
    public LiveFlashMultiSelectListAdapter m;

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
        return 2131560719;
    }

    public LiveFlashMultiSelectDialogFragment() {
        this.i = new LinkedHashMap();
        this.l = "";
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
        if (r4 == null) goto L6;
        String r5 = r4.getString("title_bar_title");
        if (r5 == null) goto L6;
    L7:
        this.l = r5;
        this.m = new LiveFlashMultiSelectListAdapter(new AnonymousClass1(this));
        RecyclerView r6 = ia0(2131384973);
        if (r6 == null) goto L10;
        r6.setAdapter(this.m);
        r6.setLayoutManager(new LinearLayoutManager(getContext()));
    L10:
        ECTitleBar r0 = ia0(2131388807);
        if (r0 == null) goto L13;
        r0.setTitleText(this.l);
    L13:
        ECTitleBar r7 = ia0(2131388807);
        if (r7 == null) goto L16;
        r7.setLeftIconClickListener(new e(this));
    L16:
        LiveFlashMultiSelectViewModel r8 = (LiveFlashMultiSelectViewModel) this.g;
        if (r8 == null) goto L19;
        r8.setSelectRepository(this.j);
        r8.initOriginData();
    L19:
        LiveFlashMultiSelectViewModel r9 = (LiveFlashMultiSelectViewModel) this.g;
        if (r9 == null) goto L24;
        LiveData<List<k>> r10 = r9.getDataListLiveData();
        if (r10 == null) goto L24;
        r10.observe(getViewLifecycleOwner(), new f(this));
    L24:
        LiveFlashMultiSelectViewModel r11 = (LiveFlashMultiSelectViewModel) this.g;
        if (r11 == null) goto L29;
        LiveData<Boolean> r12 = r11.getDismissLiveData();
        if (r12 == null) goto L29;
        r12.observe(getViewLifecycleOwner(), new g(this));
    L29:
        LiveFlashMultiSelectViewModel r13 = (LiveFlashMultiSelectViewModel) this.g;
        if (r13 == null) goto L35;
        LiveData<List<k>> r14 = r13.getCurrentStringListLiveData();
        if (r14 == null) goto L36;
        r14.observe(getViewLifecycleOwner(), new i(this));
        return;
    L36:
        return;
    L35:
        return;
    L6:
        r5 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }
}

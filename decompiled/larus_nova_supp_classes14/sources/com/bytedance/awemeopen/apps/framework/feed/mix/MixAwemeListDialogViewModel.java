package com.bytedance.awemeopen.apps.framework.feed.mix;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetViewModel;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.a0;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.bizmodels.feed.mix.MixStruct;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b'\u0010(J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR)\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\b8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\b8\u0006¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b%\u0010\rR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\b8\u0006¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b&\u0010\r¨\u0006+"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListDialogViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/AosBottomSheetViewModel;", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/a0;", "callback", "Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListDialogFragment;", "show", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/awemeopen/bizmodels/feed/mix/MixStruct;", "mixInfoLiveData", "Landroidx/lifecycle/MutableLiveData;", "getMixInfoLiveData", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState;", "", "Ljz3/a;", "dataList", "getDataList", "", "selectedIndex", "getSelectedIndex", "", "loading", "getLoading", "Lr14/c;", "itemClick", "getItemClick", "canShowLoadMore", "Z", "getCanShowLoadMore", "()Z", "setCanShowLoadMore", "(Z)V", "canShowLoadForward", "getCanShowLoadForward", "setCanShowLoadForward", "isLoadingMore", "isLoadingForward", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeListDialogViewModel extends AosBottomSheetViewModel {
    public static final a Companion = null;
    private static final String TAG = "MixAwemeListDialogViewModel";
    private boolean canShowLoadForward;
    private boolean canShowLoadMore;
    private final MutableLiveData<ListState<List<jz3.a>>> dataList;
    private final MutableLiveData<Boolean> isLoadingForward;
    private final MutableLiveData<Boolean> isLoadingMore;
    private final MutableLiveData<r14.c> itemClick;
    private final MutableLiveData<Boolean> loading;
    private final MutableLiveData<MixStruct> mixInfoLiveData;
    private final MutableLiveData<Integer> selectedIndex;

    public static final class a {
        public a() {
        }

        public static MixAwemeListDialogViewModel a(FragmentActivity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
            r1.getClass();
            return (MixAwemeListDialogViewModel) new ViewModelProvider(r2, r1).get(MixAwemeListDialogViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    public MixAwemeListDialogViewModel() {
        this.mixInfoLiveData = new MutableLiveData();
        this.dataList = new MutableLiveData();
        this.selectedIndex = new MutableLiveData();
        MutableLiveData<Boolean> r0 = new MutableLiveData();
        r0.setValue(Boolean.TRUE);
        this.loading = r0;
        this.itemClick = new MutableLiveData();
        this.canShowLoadMore = true;
        this.canShowLoadForward = true;
        MutableLiveData<Boolean> r1 = new MutableLiveData();
        Boolean r2 = Boolean.FALSE;
        r1.setValue(r2);
        this.isLoadingMore = r1;
        MutableLiveData<Boolean> r3 = new MutableLiveData();
        r3.setValue(r2);
        this.isLoadingForward = r3;
    }

    public final boolean getCanShowLoadForward() {
        return this.canShowLoadForward;
    }

    public final boolean getCanShowLoadMore() {
        return this.canShowLoadMore;
    }

    public final MutableLiveData<ListState<List<jz3.a>>> getDataList() {
        return this.dataList;
    }

    public final MutableLiveData<r14.c> getItemClick() {
        return this.itemClick;
    }

    public final MutableLiveData<Boolean> getLoading() {
        return this.loading;
    }

    public final MutableLiveData<MixStruct> getMixInfoLiveData() {
        return this.mixInfoLiveData;
    }

    public final MutableLiveData<Integer> getSelectedIndex() {
        return this.selectedIndex;
    }

    public final MutableLiveData<Boolean> isLoadingForward() {
        return this.isLoadingForward;
    }

    public final MutableLiveData<Boolean> isLoadingMore() {
        return this.isLoadingMore;
    }

    public final void setCanShowLoadForward(boolean r1) {
        this.canShowLoadForward = r1;
    }

    public final void setCanShowLoadMore(boolean r1) {
        this.canShowLoadMore = r1;
    }

    public final MixAwemeListDialogFragment show(FragmentActivity r5, a0 r6) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (r5.isFinishing() == false) goto L14;
        return null;
    L14:
        MixAwemeListDialogFragment r0 = (MixAwemeListDialogFragment) r5.getSupportFragmentManager().findFragmentByTag("MixAwemeListDialogFragment");     // Catch: Exception -> L11
        if (r0 != null) goto L9;
        r0 = new MixAwemeListDialogFragment();     // Catch: Exception -> L11
    L9:
        com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.n r3 = r0.g;     // Catch: Exception -> L11
        r3.e = false;     // Catch: Exception -> L11
        r3.f = r6;     // Catch: Exception -> L11
        r0.ea0(r5);     // Catch: Exception -> L11
        return r0;
    L11:
        e = move-exception;
        AoLogger.h(TAG, new Object[]{e});
        return null;
    }

    public static /* synthetic */ MixAwemeListDialogFragment show$default(MixAwemeListDialogViewModel r0, FragmentActivity r1, a0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.show(r1, r2);
    }
}

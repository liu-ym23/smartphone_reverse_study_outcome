package com.ss.android.lark.api.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.eventbus.EventBus;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0013\b\u0016\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020#J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010(\u001a\u00020#J\u0006\u0010*\u001a\u00020\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0004J\b\u0010.\u001a\u00020\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R!\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b$\u0010%¨\u00061"}, d2 = {"Lcom/ss/android/lark/api/ui/ForsetiPlaceHolderFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "forsetiUXOptimization", "", "getForsetiUXOptimization", "()Z", "forsetiUXOptimization$delegate", "Lkotlin/Lazy;", "forsetiPlaceholderExitEnabled", "getForsetiPlaceholderExitEnabled", "forsetiPlaceholderExitEnabled$delegate", "fragmentController", "Lcom/ss/android/lark/api/api/IForsetiFragmentDisplayController;", "chainManager", "Lcom/ss/android/lark/api/api/IForsetiActivityChainManager;", "isFullScreen", "fullscreenChangeListener", "com/ss/android/lark/api/ui/ForsetiPlaceHolderFragment$fullscreenChangeListener$1", "Lcom/ss/android/lark/api/ui/ForsetiPlaceHolderFragment$fullscreenChangeListener$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onDestroyView", "shouldRemovePlaceholderWhenCompact", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/api/ui/ForsetiPlaceHolderFragment$OnPlaceholderUpdatedListener;", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners$delegate", "addOnPlaceholderUpdatedListener", "listener", "removeOnPlaceholderUpdatedListener", "clear", "onPlaceholderUpdated", "navigationId", "", "onResume", "OnPlaceholderUpdatedListener", "Companion", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ForsetiPlaceHolderFragment extends Fragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f408687k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f408688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f408689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public tua.c f408690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public tua.b f408691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f408692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f408693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f408694j;

    public static final class a {
    }

    public interface b {
        void a(int r100);
    }

    public static final class c implements tua.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiPlaceHolderFragment f408695a;

        public c(ForsetiPlaceHolderFragment r100) {
            this.f408695a = r100;
        }

        @Override // tua.c.a
        public final void a(boolean r100) {
            Log.i("ForsetiPlaceHolderFragment", "isFullscreen: " + r100);
            this.f408695a.f408692h = r100;
        }
    }

    static {
    }

    public ForsetiPlaceHolderFragment() {
        this.f408688d = LazyKt.lazy(ForsetiPlaceHolderFragment$forsetiUXOptimization$2.INSTANCE);
        this.f408689e = LazyKt.lazy(ForsetiPlaceHolderFragment$forsetiPlaceholderExitEnabled$2.INSTANCE);
        this.f408693i = new c(this);
        this.f408694j = LazyKt.lazy(ForsetiPlaceHolderFragment$listeners$2.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((CopyOnWriteArrayList) this.f408694j.getValue()).clear();
        tua.c r100 = this.f408690f;
        if (r100 == null) goto L6;
        r100.a(this.f408693i);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.feed.feed_click_hint") == false) goto L6;
        EventBus.getDefault().trigger(new wua.a());
    L6:
        if (((Boolean) this.f408689e.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        if (this.f408692h == false) goto L14;
        Log.i("ForsetiPlaceHolderFragment", "placeholder is full, by its upper node triggered, make normal onResume.");
        tua.c r100 = this.f408690f;
        if (r100 == null) goto L15;
        r100.c(true);
        return;
    L15:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        tua.b r101 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(getActivity());
        this.f408691g = r101;
        if (r101 == null) goto L5;
        tua.c r102 = r101.g(this);
    L6:
        this.f408690f = r102;
        if (r102 == null) goto L10;
        r102.b(this.f408693i);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = requireContext();
        String r104 = UIUtils.getString(r103, R.string.Lark_IM_EmptyState_SendHeart);
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        if (((Boolean) this.f408688d.getValue()).booleanValue() == false) goto L9;
        AttributeSet r105 = null;
        ForsetiEmptyState r106 = new ForsetiEmptyState(r103, r105, 6, 0);
        r106.setImageResource(R.drawable.ud_icon_lark_logo_filled);
        r106.setDesc(r104);
        r106.setDescColor(UIUtils.getColor(r103, R.color.text_placeholder));
        r106.setBackgroundResource(R.color.bg_body);
        return r106;
    L9:
        UDEmptyState r107 = new UDEmptyState(r103);
        r107.setImageRes(Integer.valueOf(R.drawable.illustration_empty_positive_common_default));
        r107.setDesc(r104);
        r107.setBackgroundResource(R.color.bg_body);
        return r107;
    }
}

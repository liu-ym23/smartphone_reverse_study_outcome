package com.bytedance.android.shopping.store.tabkit.container;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitBottomSheetFragment;", "Lcom/bytedance/android/shopping/store/tabkit/container/ABSTabkitBottomSheetFragment;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitBottomSheetFragment extends ABSTabkitBottomSheetFragment {
    public static final /* synthetic */ int p = 0;
    public ViewGroup k;
    public TabKitFragment l;
    public TabKitRouterParams m;
    public final Lazy n;
    public final TabKitBottomSheetFragment$fragmentLifeCallBack$1 o;

    public static final class a {
        public static TabKitBottomSheetFragment a(Class r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r3, "tabKitFragmentClass");
            TabKitBottomSheetFragment r0 = new TabKitBottomSheetFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("tabkit_fragment_clazz", r3);
            r1.putBundle("biz_arguments", r4);
            Unit r5 = Unit.INSTANCE;
            r0.setArguments(r1);
            return r0;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.tabkit.container.ABSTabkitBottomSheetFragment
    public final int S90() {
        return 2131560976;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.container.ABSTabkitBottomSheetFragment
    public final int getLayoutId() {
        return 2131560844;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.container.ABSTabkitBottomSheetFragment
    public final int T90() {
        TabKitRouterParams r0 = this.m;
        if (r0 == null) goto L7;
        Integer r1 = r0.getHeightPercent();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L9:
        if (1 > r2) goto L18;
        if (100 < r2) goto L18;
        if (((Number) this.n.getValue()).intValue() <= 0) goto L18;
        return (int) (((Number) this.n.getValue()).intValue() * (r2 / 100.0f));
    L18:
        return super.T90();
    L7:
        r2 = -1;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetFragment$fragmentLifeCallBack$1] */
    public TabKitBottomSheetFragment() {
        this.n = LazyKt.lazy(new TabKitBottomSheetFragment$screenHeight$2(this));
        this.o = new TabKitBottomSheetFragment$fragmentLifeCallBack$1(this);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.container.ABSTabkitBottomSheetFragment
    public final void U90(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        TabKitFragment r4 = this.l;
        if (r4 == null) goto L6;
        r4.Mc().W(4);
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.container.ABSTabkitBottomSheetFragment
    public final void V90(boolean r2) {
        TabKitFragment r0 = this.l;
        if (r0 == null) goto L10;
        TabKitViewModel r1 = r0.d;
        if (r1 == null) goto L11;
        MutableLiveData<Integer> r3 = r1.getScreenState();
        if (r3 == null) goto L12;
        r3.setValue(Integer.valueOf(!r2 ? 1 : 0));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.container.ABSTabkitBottomSheetFragment
    public final void W90(float r7) {
        TabKitFragment r0 = this.l;
        if (r0 == null) goto L9;
        TabKitViewModel r1 = r0.d;
        if (r1 == null) goto L9;
        MutableLiveData<Float> r2 = r1.getScreenOffsetFactor();
        if (r2 == null) goto L9;
        r2.setValue(Float.valueOf(r7));
    L9:
        ViewGroup r3 = this.k;
        if (r3 == null) goto L12;
        Integer r4 = Integer.valueOf(r3.getHeight());
    L13:
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.intValue() <= T90()) goto L30;
        int r5 = r4.intValue() - T90();
        TabKitFragment r6 = this.l;
        if (r6 == null) goto L31;
        float r8 = r5;
        float r9 = r7 * r8;
        TabKitViewModel r10 = r6.d;
        if (r10 == null) goto L23;
        com.bytedance.android.shopping.store.tabkit.bridge.c r11 = r10.getJsEventStub();
        if (r11 == null) goto L23;
        JSONObject r12 = new JSONObject();
        r12.put("offset", Float.valueOf(r9));
        r12.put("max_offset", Float.valueOf(r8));
        Unit r13 = Unit.INSTANCE;
        r11.a("ecTabKit.splitModalDidScroll", r12);
    L23:
        TabKitViewModel r14 = r6.d;
        if (r14 == null) goto L32;
        MutableLiveData<Pair<Float, Float>> r15 = r14.getScreenOffset();
        if (r15 == null) goto L33;
        r15.setValue(new Pair(Float.valueOf(r9), Float.valueOf(r8)));
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L12:
        r4 = null;
        goto L13
    }

    @Override // com.bytedance.android.shopping.store.tabkit.container.ABSTabkitBottomSheetFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        Object r0 = null;
        if (r4 == null) goto L7;
        Bundle r5 = r4.getBundle("biz_arguments");
        if (r5 == null) goto L7;
        Object r6 = r5.get(TabKitRouterParams.KEY_ROUTER_PARAMS);
    L9:
        if ((r6 instanceof TabKitRouterParams) == false) goto L12;
        r0 = r6;
    L12:
        TabKitRouterParams r1 = (TabKitRouterParams) r0;
        this.m = r1;
        if (r1 == null) goto L17;
        Integer r7 = r1.getInitScreenStatus();
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
    L18:
        X90(r8);
        return;
    L17:
        r8 = 1;
    L7:
        r6 = null;
        goto L9
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        Dialog r9 = getDialog();
        Window r0 = null;
        if (r9 == null) goto L5;
        ViewGroup r10 = (ViewGroup) r9.findViewById(2131371215);
    L6:
        this.k = r10;
        Fragment r11 = getChildFragmentManager().findFragmentByTag("tabkit_fragment");
        if ((r11 instanceof TabKitFragment) == true) goto L9;
        r11 = null;
    L9:
        TabKitFragment r12 = (TabKitFragment) r11;
        this.l = r12;
        if (r12 != null) goto L32;
        Bundle r13 = getArguments();
        if (r13 == null) goto L14;
        Serializable r14 = r13.getSerializable("tabkit_fragment_clazz");
    L15:
        if (r14 == null) goto L31;
        TabKitFragment r15 = (TabKitFragment) ((Class) r14).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        this.l = r15;
        if (r15 == null) goto L23;
        Bundle r3 = new Bundle();
        Bundle r4 = getArguments();
        if (r4 == null) goto L21;
        Bundle r5 = r4.getBundle("biz_arguments");
    L22:
        r3.putAll(r5);
        Unit r6 = Unit.INSTANCE;
        r15.setArguments(r3);
        goto L23
    L21:
        r5 = null;
    L23:
        FragmentTransaction r16 = getChildFragmentManager().beginTransaction();
        TabKitFragment r17 = this.l;
        if (r17 == null) goto L32;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r17, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "tabkit_fragment", 2131371215) == true) goto L29;
        r16.add(2131371215, r17, "tabkit_fragment");
    L29:
        r16.commit();
        goto L32
    L31:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.bytedance.android.shopping.store.tabkit.TabKitFragment>");
    L14:
        r14 = null;
    L32:
        TabKitFragment r18 = this.l;
        if (r18 == null) goto L38;
        Dialog r19 = getDialog();
        if (r19 == null) goto L37;
        r0 = r19.getWindow();
    L37:
        r18.e = r0;
    L38:
        getChildFragmentManager().registerFragmentLifecycleCallbacks(this.o, false);
        this.f = new TabKitBottomSheetFragment$initContentFragment$3(this);
        return;
    L5:
        r10 = null;
        goto L6
    }
}

package com.bytedance.android.shopping.store.tabkit.container;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import b46.m;
import com.bytedance.android.ec.host.api.split.ECFoldStatus;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitFoldFragment;", "Landroidx/fragment/app/Fragment;", "", "Lnj/c;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitFoldFragment extends Fragment implements nj.c {
    public static final /* synthetic */ int f = 0;
    public TabKitFragment d;
    public Bundle e;

    public static final class a {
        public static Pair a(Activity r2) {
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
            if (r2 == null) goto L13;
            nj.d r3 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();     // Catch: Throwable -> L16
            if (r3 == null) goto L8;
            r3.getSpiltWidth();     // Catch: Throwable -> L16
        L8:
            b46.i r4 = m.a(r2);     // Catch: Throwable -> L16
            if (r4 == null) goto L12;
            int r5 = r4.b;     // Catch: Throwable -> L16
        L12:
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L16
        L14:
            Result.constructor-impl(r6);     // Catch: Throwable -> L16
        L18:
            return null;
        L13:
            r6 = null;
        L16:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L18
        }
    }

    static {
        new AtomicInteger();
    }

    public TabKitFoldFragment() {
        ECFoldStatus r0 = ECFoldStatus.UNKNOWN;
    }

    public final void onDestroy() {
        super.onDestroy();
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        d.a(r2);
        nj.d r3 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r3 == null) goto L5;
        r3.getFoldStatus();
    L5:
        ECFoldStatus r4 = ECFoldStatus.UNKNOWN;
    }

    public final void onCreate(Bundle r5) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Bundle r1 = r0.getBundle("biz_arguments");
    L6:
        this.e = r1;
        if (r1 == null) goto L9;
        Serializable r2 = r1.getSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS);
    L11:
        if ((r2 instanceof TabKitRouterParams) == true) goto L13;
        r2 = null;
    L13:
        TabKitRouterParams r3 = (TabKitRouterParams) r2;
        Bundle r4 = this.e;
        if (r4 == null) goto L18;
        long r6 = r4.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
        Map<Long, TabkitFirstFramePref> r7 = ok3.a.e;
        TabkitFirstFramePref r8 = ok3.a.C0149a.a(r6);
        if (r8 == null) goto L18;
        TabkitFramePref.recordTime$default(r8, "t_on_create_fragment", null, 2, null);
    L18:
        super.onCreate(r5);
        nj.d r9 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r9 == null) goto L22;
        r9.b();
        return;
    L22:
        return;
    L9:
        r2 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Bundle r0 = this.e;
        TabKitFragment r1 = null;
        if (r0 == null) goto L7;
        long r2 = r0.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
        Map<Long, TabkitFirstFramePref> r3 = ok3.a.e;
        TabkitFirstFramePref r4 = ok3.a.C0149a.a(r2);
        if (r4 == null) goto L7;
        TabkitFramePref.recordTime$default(r4, "t_on_view_created_fragment", null, 2, null);
    L7:
        super.onViewCreated(r5, r6);
        Fragment r7 = getChildFragmentManager().findFragmentByTag("tabkit_fragment");
        if ((r7 instanceof TabKitFragment) == true) goto L10;
        r7 = null;
    L10:
        TabKitFragment r8 = (TabKitFragment) r7;
        this.d = r8;
        if (r8 != null) goto L38;
        Bundle r9 = getArguments();
        if (r9 == null) goto L15;
        Serializable r10 = r9.getSerializable("tabkit_fragment_clazz");
    L17:
        if ((r10 instanceof Class) == true) goto L19;
        r10 = null;
    L19:
        Class r11 = (Class) r10;
        if (r11 == null) goto L24;
        Constructor r12 = r11.getDeclaredConstructor(new Class[0]);
        if (r12 == null) goto L24;
        r1 = (TabKitFragment) r12.newInstance(new Object[0]);
    L24:
        this.d = r1;
        if (r1 == null) goto L30;
        Bundle r13 = new Bundle();
        Bundle r14 = this.e;
        if (r14 == null) goto L29;
        r13.putAll(r14);
    L29:
        Unit r15 = Unit.INSTANCE;
        r1.setArguments(r13);
    L30:
        TabKitFragment r16 = this.d;
        if (r16 == null) goto L39;
        FragmentTransaction r17 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "tabkit_fragment", 2131388067) == true) goto L36;
        r17.add(2131388067, r16, "tabkit_fragment");
    L36:
        r17.commitNowAllowingStateLoss();
        return;
    L39:
        return;
    L15:
        r10 = null;
        goto L17
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Context r5 = getContext();
        if (r5 != null) goto L7;
        return null;
    L7:
        return th.a.c(r5, 2131560978, r3, false);
    }
}

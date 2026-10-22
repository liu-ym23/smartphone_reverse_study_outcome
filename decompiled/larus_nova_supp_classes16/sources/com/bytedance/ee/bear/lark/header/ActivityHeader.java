package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bitable.homepage.activity.BitableMessageFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.lark.DocTabFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ActivityHeader implements i {
    public zc5.a a;
    public LinearLayout b;
    public boolean c;
    public DocTabFragment d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("ActivityHeader", "destroy");
        this.a = null;
        this.b = null;
        this.d = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r3) {
        tt5.a.h("ActivityHeader", "onNetworkStateChanged " + r3);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        tt5.a.h("ActivityHeader", "initData");
        this.c = true;
        zc5.a r2 = this.a;
        if (r2 == null) goto L5;
        r2.setLeftTitle(r9.getString(2131886902));
    L5:
        zc5.a r3 = this.a;
        if (r3 == null) goto L8;
        r3.setRightTitle(r9.getString(2131886929));
    L8:
        DocTabFragment r4 = this.d;
        if (r4 == null) goto L11;
        FragmentManager r5 = r4.getChildFragmentManager();
    L12:
        if (r5 != null) goto L14;
    L29:
        tt5.a.h("ActivityHeader", "has init ");
        return;
    L14:
        if (r5.findFragmentByTag("BitableMessageFragment") != null) goto L29;
        int r6 = BitableMessageFragment.t;
        boolean r7 = this.e;
        DocTabFragment r8 = this.d;
        if (r8 == null) goto L19;
        String r10 = r8.ba0();
        if (r10 == null) goto L19;
    L20:
        Intrinsics.checkNotNullParameter(r10, "hpFrom");
        Bundle r11 = new Bundle();
        r11.putBoolean("is_tab", true);
        r11.putBoolean("is_from_workbench", r7);
        r11.putString("base_hp_from", r10);
        Fragment r12 = r5.getFragmentFactory().instantiate(r9.getClassLoader(), BitableMessageFragment.class.getName());
        r12.setArguments(r11);
        FragmentTransaction r1 = r5.beginTransaction();     // Catch: Exception -> L27
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "BitableMessageFragment", 2131378059) == true) goto L25;
        r1 = r1.replace(2131378059, r12, "BitableMessageFragment");     // Catch: Exception -> L27
    L25:
        r1.commitAllowingStateLoss();     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        tt5.a.f("ActivityHeader", e, false);
        Unit r13 = Unit.INSTANCE;
        return;
    L19:
        r10 = "";
        goto L20
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        tt5.a.h("ActivityHeader", "createView");
        LinearLayout r0 = new LinearLayout(r5);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r0.setOrientation(1);
        this.b = r0;
        zc5.a r1 = new zc5.a(r5, new AnonymousClass2(this));
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.a = r1;
        LinearLayout r2 = this.b;
        if (r2 == null) goto L5;
        r2.addView(r1);
    L5:
        FrameLayout r3 = new FrameLayout(r5);
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r3.setId(2131378059);
        LinearLayout r6 = this.b;
        if (r6 == null) goto L9;
        r6.addView(r3);
    L9:
        return this.b;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r3) {
        tt5.a.h("ActivityHeader", "setUserVisibleHint " + r3);
    }

    public ActivityHeader(DocTabFragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.d = r2;
        this.e = r3;
    }
}

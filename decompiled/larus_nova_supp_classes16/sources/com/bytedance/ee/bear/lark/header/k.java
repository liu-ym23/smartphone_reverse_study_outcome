package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationAdapter;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements i {
    public FrameLayout a;
    public NavigationFragment b;
    public FragmentManager c;
    public boolean d;

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r1) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("NavigationHeader", "destroy()...");
        this.a = null;
        this.c = null;
        this.b = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.d;
    }

    public k(FragmentManager r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r5) {
        tt5.a.h("NavigationHeader", "initData()...");
        this.d = true;
        this.b = this.c.getFragmentFactory().instantiate(r5.getClassLoader(), NavigationFragment.class.getName());
        FragmentTransaction r6 = this.c.beginTransaction();
        NavigationFragment r0 = this.b;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131374280) == true) goto L6;
        r6 = r6.replace(2131374280, r0);
    L6:
        r6.commitNowAllowingStateLoss();
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r6) {
        tt5.a.h("NavigationHeader", "createView()...");
        FrameLayout r0 = new FrameLayout(r6);
        this.a = r0;
        r0.setId(2131374280);
        this.a.setPadding(0, y9c.d.a(4), 0, y9c.d.a(8));
        ViewGroup.MarginLayoutParams r7 = new ViewGroup.MarginLayoutParams(-1, -2);
        r7.topMargin = y9c.d.a(4);
        r7.bottomMargin = y9c.d.a(8);
        this.a.setLayoutParams(r7);
        return this.a;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r6) {
        if (r6 == false) goto L32;
        NavigationFragment r7 = this.b;
        if (r7 == null) goto L33;
        NavigationAdapter r0 = r7.f;
        if (r0 != null) goto L8;
    L27:
        tt5.a.h("NavigationFragment", "reportIconShow()...mAdapter or mAdapter.getData() is null");
        return;
    L8:
        if (hu5.a.d(r0.getData()) == true) goto L27;
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        List r8 = r7.f.getData();
        if (r8 != null) goto L13;
        String r9 = "";
    L22:
        lc5.f.a r2 = lc5.f.a;
        Intrinsics.checkNotNullParameter(r1, "analyticService");
        Intrinsics.checkNotNullParameter(r9, "type");
        JSONObject r3 = new JSONObject();
        r3.put("function_type", r9);
        if (qc5.a.h() == false) goto L25;
        String r10 = "new_format";
    L26:
        r3.put("space_version", r10);
        r1.a("icon_show", r3);
        return;
    L25:
        r10 = "original";
        goto L26
    L13:
        StringBuilder r4 = new StringBuilder();
        int r5 = 0;
    L15:
        if (r5 >= r8.size()) goto L21;
        String r11 = NavigationFragment.U90(((com.bytedance.ee.bear.list.homepage.navigation.c) ListProtector.get(r8, r5)).a);
        if (r5 != (r8.size() - 1)) goto L19;
        r4.append(r11);
    L20:
        r5 = r5 + 1;
        goto L15
    L19:
        r4.append(r11);
        r4.append(",");
        goto L20
    L21:
        r9 = r4.toString();
        goto L22
    L33:
        return;
    }
}

package com.bytedance.ee.bear.list.homepage.navigation;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher;
import com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher$closeChatMode$1$1;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NavigationFragment extends BaseFragment {
    public static final /* synthetic */ int l = 0;
    public BaseRecyclerView e;
    public NavigationAdapter f;
    public boolean g;
    public final a h;
    public boolean i;
    public sc5.c j;
    public SpaceHomePageAiLauncher k;

    public class a implements Runnable {
        public final /* synthetic */ NavigationFragment a;

        public final void a() {
            NavigationFragment r0 = this.a;
            int r1 = NavigationFragment.l;
            r0.getClass();
            if (qc5.a.c() == true) goto L5;
            return;
        L5:
            if (r0.i == false) goto L9;
            r0.j = new sc5.c(new ce5.a(), r0.getActivity());
            tt5.a.h("NavigationFragment", "showHomeDriveOnBoardingPage");
            r0.j.f(r0.f.b);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(NavigationFragment r1) {
            this.a = r1;
        }
    }

    public class b extends GridLayoutManager {
        public final /* synthetic */ NavigationFragment a;

        public final void onLayoutCompleted(RecyclerView.State r3) {
            super.onLayoutCompleted(r3);
            tt5.a.h("NavigationFragment", "onLayoutCompleted()...");
            j.d(this.a.h, 1300);
        }

        public b(NavigationFragment r2, Context r3, int r4) {
            this.a = r2;
            super(r3, r4, 1, false);
        }
    }

    public final List<c> V90() {
        ArrayList r0 = new ArrayList();
        if (qc5.a.c() == false) goto L8;
        r0.add(new c(NavigationEnum.MY_LIBRARY.id, 2131255197, 2131888790));
        if (this.g == true) goto L7;
        r0.add(new c(NavigationEnum.WIKI.id, 2131256223, 2131887849));
    L7:
        r0.add(new c(NavigationEnum.MY_DRIVE.id, 2131254274, 2131888777));
    L14:
        int r1 = qc5.b.a;
        qc5.b.a(new ce5.a());
        r0.add(new c(NavigationEnum.FAVORITE.id, 2131254344, 2131887927));
        r0.add(new c(NavigationEnum.MANUAL_OFFLINE.id, 2131255243, 2131887949));
        BenefitStore r2 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1();
        boolean r3 = r2.hasBenefit("ccm_create_doc");
        boolean r4 = r2.hasBenefit("ccm_create_base");
        if (r3 == true) goto L17;
        if (r4 == true) goto L17;
    L18:
        return r0;
    L17:
        r0.add(new c(NavigationEnum.TEMPLATE.id, 2131255980, 2131887346));
        goto L18
    L8:
        r0.add(new c(NavigationEnum.MY_SPACE.id, kac.a.b(2131254455), 2131887935));
        c r5 = new c(NavigationEnum.SHARED_SPACE.id, 2131255660, 2131887981);
        qc5.a.j();
        if (qc5.a.d() == true) goto L11;
        r5.c = 2131887300;
    L11:
        r0.add(r5);
        if (this.g == true) goto L14;
        r0.add(new c(NavigationEnum.WIKI.id, 2131256223, 2131887849));
        goto L14
    }

    public final void W90() {
        tt5.a.h("NavigationFragment", "showNavigation()...");
        if (this.f != null) goto L5;
        NavigationAdapter r1 = new NavigationAdapter();
        this.f = r1;
        r1.a = new com.bytedance.ee.bear.list.homepage.navigation.b(this);
        this.e.setAdapter(r1);
    L5:
        List<c> r2 = V90();
        BaseRecyclerView r3 = this.e;
        Context r4 = getContext();
        int r5 = ((ArrayList) r2).size();
        WindowManager r6 = (WindowManager) getContext().getSystemService("window");
        DisplayMetrics r7 = new DisplayMetrics();
        r6.getDefaultDisplay().getMetrics(r7);
        int r8 = r7.widthPixels;
        int r9 = r7.heightPixels;
        int r10 = y9c.d.a(80);
        int r11 = y9c.d.a(8);
        tt5.a.h("NavigationFragment", "calculateLineCount()...screenWidth = " + r8 + ", screenHeight = " + r9 + ", total = " + r5);
        if (r5 <= 0) goto L10;
        if (r5 > 4) goto L10;
    L18:
        r5 = 4;
    L20:
        r3.setLayoutManager(new b(this, r4, r5));
        this.f.setNewData(r2);
        return;
    L10:
        if (r5 == 5) goto L19;
        boolean r12 = com.ss.android.lark.base.embedded.b.g();
        tt5.a.h("NavigationFragment", "isXiaomiFoldDisplay is " + r12);
        if (((r10 * r5) + (r11 * 2)) >= r8) goto L17;
        if (r12 == true) goto L20;
    L17:
        if (r5 >= 6) goto L18;
    L19:
        r5 = 5;
        goto L20
    }

    public NavigationFragment() {
        this.h = new a(this);
    }

    public final String m6() {
        if ((getParentFragment() instanceof wc5.c) == true) goto L5;
        return "";
    L5:
        return getParentFragment().m6();
    }

    public final void onDestroy() {
        super.onDestroy();
        j.e(this.h);
        SpaceHomePageAiLauncher r0 = this.k;
        if (r0 == null) goto L8;
        tt5.a.h("SpaceHomePageAiLauncher", "onDestroy close chat mode ");
        String r1 = r0.b;
        if (r1 == null) goto L9;
        r0.a().f(r1, new SpaceHomePageAiLauncher$closeChatMode$1$1());
        return;
    L9:
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        tt5.a.h("NavigationFragment", "onPause()...");
        this.i = false;
        sc5.c r0 = this.j;
        if (r0 == null) goto L25;
        Dialog r1 = r0.d;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isShowing() == false) goto L30;
        tt5.a.h("NavigationFragment", "switch tab dismiss onboarding");
        Dialog r2 = this.j.d;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r2);
        return;
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r4 == null) goto L22;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r3.getLooper()) goto L13;
        r3.post(DialogLancet.createDismissRunnable(r2));
        return;
    L30:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        tt5.a.h("NavigationFragment", "onResume()...");
        this.i = true;
    }

    static {
    }

    public static String U90(int r1) {
        if (r1 != NavigationEnum.WIKI.id) goto L6;
        return DocumentType.WIKI_NAME;
    L6:
        if (r1 != NavigationEnum.MY_SPACE.id) goto L9;
    L22:
        return WikiSpaceType.PERSONAL;
    L9:
        if (r1 != NavigationEnum.SHARED_SPACE.id) goto L12;
        return "sharetome";
    L12:
        if (r1 != NavigationEnum.FAVORITE.id) goto L15;
        return "favorites";
    L15:
        if (r1 != NavigationEnum.MANUAL_OFFLINE.id) goto L18;
        return OperationName.OPERATION_OFFLINE_AVAILABLE;
    L18:
        if (r1 != NavigationEnum.TEMPLATE.id) goto L21;
        return "templates";
    L21:
        if (r1 == NavigationEnum.MY_DRIVE.id) goto L22;
        if (r1 != NavigationEnum.MY_LIBRARY.id) goto L27;
        return "my_docs";
    L27:
        if (r1 != NavigationEnum.AI_NOTE.id) goto L29;
        return "ai_notes";
    L29:
        return "";
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        tt5.a.h("NavigationFragment", "initView()...");
        this.g = ud5.a.a(this);
        int r4 = qc5.b.a;
        qc5.b.a(new ce5.a());
        W90();
        int r5 = SpaceHomePageAiLauncher.g;
        SpaceHomePageAiLauncher.Companion.a(getContext(), new ce5.a(), new com.bytedance.ee.bear.list.homepage.navigation.a(this));
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.ViewGroup, com.bytedance.ee.bear.widgets.BaseRecyclerView] */
    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        tt5.a.h("NavigationFragment", "onCreateView()...");
        if (this.e != null) goto L6;
        ?? r4 = new BaseRecyclerView(getContext());
        this.e = r4;
        r4.setOverScrollMode(2);
        ViewGroup.LayoutParams r5 = new ViewGroup.LayoutParams(-1, -2);
        this.e.setLayoutParams(r5);
    L6:
        return this.e;
    }
}

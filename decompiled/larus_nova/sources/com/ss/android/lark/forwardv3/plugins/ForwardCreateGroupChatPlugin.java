package com.ss.android.lark.forwardv3.plugins;

import android.R;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larksuite.framework.utils.KeyboardUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.component_container.ResponsiveBaseFragment;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: classes36.dex */
public final class ForwardCreateGroupChatPlugin implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ForwardTemplateNew f425473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f425474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f425475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ForwardCreateGroupChatFragment f425476d;

    public interface a {
        void a(String r100);

        void onBack();
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForwardCreateGroupChatPlugin f425477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f425478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f425479c;

        public static final class a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FragmentActivity f425480a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ForwardCreateGroupChatPlugin f425481b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Fragment f425482c;

            @Override // com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin.a
            public final void onBack() {
                KeyboardUtils.hideKeyboard(this.f425480a);
                ForwardCreateGroupChatPlugin.f(this.f425481b, this.f425480a, this.f425482c);
                this.f425481b.f425474b.onBack();
            }

            @Override // com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin.a
            public final void a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "chatId");
                KeyboardUtils.hideKeyboard(this.f425480a);
                ForwardCreateGroupChatPlugin.f(this.f425481b, this.f425480a, this.f425482c);
                this.f425481b.f425474b.a(r100);
            }

            public a(FragmentActivity r100, ForwardCreateGroupChatPlugin r101, Fragment r102) {
                this.f425480a = r100;
                this.f425481b = r101;
                this.f425482c = r102;
            }
        }

        public b(ForwardCreateGroupChatPlugin r100, FragmentActivity r101, Fragment r102) {
            this.f425477a = r100;
            this.f425478b = r101;
            this.f425479c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            if (((com.ss.android.lark.forwardv3.utils.e) this.f425477a.f425475c.getValue()).a() == false) goto L80;
            ForwardCreateGroupChatPlugin r111 = this.f425477a;
            ForwardCreateGroupChatPlugin r100 = this.f425477a;
            r111.f425476d = new ForwardCreateGroupChatFragment(r100.f425473a, new a(this.f425478b, r100, this.f425479c));
            ForwardCreateGroupChatPlugin r112 = this.f425477a;
            FragmentActivity r101 = this.f425478b;
            Fragment r102 = this.f425479c;
            if (r101 == null) goto L78;
            ForwardCreateGroupChatFragment r103 = r112.f425476d;
            boolean r104 = true;
            if (r103 != null) goto L9;
        L11:
            boolean r105 = false;
        L12:
            if (r105 == true) goto L81;
            if (r102 == null) goto L87;
            Log.i("NewForward", "start create group chat");
            s5c.a r106 = r.f570334m;
            s5c.a r107 = p3.f570285f;
            int r108 = zib.e.f572329a;
            r106.getClass();
            zib.e.a.c(s5c.d.b.b(r106, r107));
            boolean r109 = ForsetiFGHelpers.d();
            int r113 = R.id.content;
            if (r109 == true) goto L18;
        L57:
            ForwardCreateGroupChatFragment r114 = r112.f425476d;
            if (r114 == null) goto L85;
            sua.a r115 = (sua.a) ApiUtils.getApi(sua.a.class);
            if (r115 == null) goto L64;
            FragmentManager r116 = r115.getFragmentManagerInForseti(r101, r114);
            if (r116 == null) goto L64;
        L65:
            FragmentTransaction r117 = r116.beginTransaction();
            r117.setCustomAnimations(com.larus.nova.R.anim.slide_right_in, com.larus.nova.R.anim.slide_right_out);
            if (ForsetiConfig.a(r101) == false) goto L73;
            sua.a r118 = (sua.a) ApiUtils.getApi(sua.a.class);
            if (r118 == null) goto L72;
            Integer r119 = r118.getResumedChainRootFragmentContainerId(r101);
            if (r119 == null) goto L72;
            r113 = r119.intValue();
        L72:
            r113 = com.larus.nova.R.id.forseti_fragment_container;
        L73:
            String r120 = ForwardCreateGroupChatFragment.class.getName();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r117, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r120, r113) == true) goto L77;
            r117.add(r113, r114, r120);
        L77:
            r117.commitAllowingStateLoss();
            return;
        L64:
            r116 = r101.getSupportFragmentManager();
            goto L65
        L85:
            return;
        L18:
            if (ForsetiConfig.a(r101) == true) goto L57;
            if (ForwardCreateGroupChatPlugin.g(r102) == false) goto L57;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            Fragment r121 = r101.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
            if (r121 == null) goto L24;
            FragmentManager r122 = r121.getChildFragmentManager();
        L25:
            if (r122 == null) goto L27;
            FragmentTransaction r123 = r122.beginTransaction();
        L28:
            ForwardCreateGroupChatFragment r124 = r112.f425476d;
            if (r124 == null) goto L82;
            if (r123 == null) goto L51;
            FragmentTransaction r125 = r123.setCustomAnimations(com.larus.nova.R.anim.slide_right_in, com.larus.nova.R.anim.lark_base_hold);
            if (r125 == null) goto L51;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            Fragment r126 = r101.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
            if ((r126 instanceof ResponsiveBaseFragment) == false) goto L36;
            ResponsiveBaseFragment r127 = (ResponsiveBaseFragment) r126;
        L37:
            StringBuilder r128 = new StringBuilder("getContainerId containerFragment is null: ");
            if (r127 == null) goto L41;
            r104 = false;
        L41:
            r128.append(r104);
            Log.i("ResponsiveBaseFragment", r128.toString());
            if (r127 == null) goto L48;
            FrameLayout r129 = r127.f444579f;
            if (r129 != null) goto L46;
            Intrinsics.throwUninitializedPropertyAccessException("shadowContainerChild");
            r129 = null;
        L46:
            r113 = r129.getId();
        L48:
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r125, r124, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r113) == true) goto L51;
            r125.add(r113, r124);
            goto L51
        L36:
            r127 = null;
        L51:
            boolean r130 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_hide_source", false);
            Log.i("FGUtils", "FG key: core.forward.create_group_hide_source: " + r130);
            if (r130 == true) goto L55;
            if (r123 == null) goto L55;
            r123.hide(r102);
        L55:
            if (r123 == null) goto L83;
            r123.commitAllowingStateLoss();
            return;
        L83:
            return;
        L82:
            return;
        L27:
            r123 = null;
            goto L28
        L24:
            r122 = null;
            goto L25
        L87:
            return;
        L81:
            return;
        L9:
            if (r103.isAdded() != true) goto L11;
            r105 = true;
            goto L12
        L78:
            r112.getClass();
            return;
        }
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void a(Intent r100) {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void c() {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void d() {
        this.f425476d = null;
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void e(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    public static boolean g(Fragment r100) {
        boolean r101 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_container_judge", false);
        Log.i("FGUtils", "FG key: core.forward.create_group_container_judge: " + r101);
        if (r101 == false) goto L7;
        return true;
    L7:
        return r100.getParentFragment() instanceof ResponsiveBaseFragment;
    }

    public ForwardCreateGroupChatPlugin(ForwardTemplateNew r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "forwardTemplate");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f425473a = r100;
        this.f425474b = r101;
        this.f425475c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ForwardCreateGroupChatPlugin$clickThrottle$2.INSTANCE);
    }

    public static final void f(ForwardCreateGroupChatPlugin r100, FragmentActivity r101, Fragment r102) {
        if (r101 == null) goto L39;
        ForwardCreateGroupChatFragment r103 = r100.f425476d;
        if (r103 == null) goto L8;
        boolean r104 = true;
        if (r103.isAdded() != true) goto L8;
    L9:
        if (r104 == false) goto L41;
        if (r102 != null) goto L13;
        return;
    L13:
        if (ForsetiFGHelpers.d() == true) goto L15;
    L36:
        ForwardCreateGroupChatFragment r105 = r100.f425476d;
        if (r105 == null) goto L46;
        FragmentTransaction r106 = ((sua.a) ApiUtils.getApi(sua.a.class)).getFragmentManagerInForseti(r101, r105).beginTransaction();
        r106.setCustomAnimations(com.larus.nova.R.anim.slide_right_in, com.larus.nova.R.anim.slide_right_out);
        r106.remove(r105).commitAllowingStateLoss();
        return;
    L46:
        return;
    L15:
        if (ForsetiConfig.a(r101) == true) goto L36;
        if (g(r102) == false) goto L36;
        ForwardCreateGroupChatFragment r107 = r100.f425476d;
        if (r107 == null) goto L42;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Fragment r108 = r101.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
        FragmentTransaction r109 = null;
        if (r108 == null) goto L23;
        FragmentManager r110 = r108.getChildFragmentManager();
    L24:
        if (r110 == null) goto L26;
        r109 = r110.beginTransaction();
    L26:
        if (r109 == null) goto L28;
        r109.setCustomAnimations(com.larus.nova.R.anim.lark_base_hold, com.larus.nova.R.anim.slide_right_out);
    L28:
        boolean r111 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_hide_source", false);
        Log.i("FGUtils", "FG key: core.forward.create_group_hide_source: " + r111);
        if (r111 == true) goto L32;
        if (r109 == null) goto L32;
        r109.show(r102);
    L32:
        if (r109 == null) goto L43;
        FragmentTransaction r112 = r109.remove(r107);
        if (r112 == null) goto L44;
        r112.commitAllowingStateLoss();
        return;
    L44:
        return;
    L43:
        return;
    L23:
        r110 = null;
        goto L24
    L42:
        return;
    L41:
        return;
    L8:
        r104 = false;
        goto L9
    L39:
        r100.getClass();
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final i b(FragmentActivity r100, Fragment r101, View r102) {
        Intrinsics.checkNotNullParameter(r102, "pluginTarget");
        r102.setOnClickListener(new b(this, r100, r101));
        return this;
    }
}

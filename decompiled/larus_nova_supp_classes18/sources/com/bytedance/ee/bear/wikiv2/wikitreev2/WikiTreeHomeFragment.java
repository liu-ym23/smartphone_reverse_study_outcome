package com.bytedance.ee.bear.wikiv2.wikitreev2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.WikiTreeFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.makecopy.WikiMakeCopyFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.shortcut.WikiShortcutToFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002J\u0017\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\"\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\"\u0010!\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeHomeFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "contractName", "", "kotlin.jvm.PlatformType", "contract", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "init", "setupContent", "extra", "provideTypeFragment", "Landroidx/fragment/app/Fragment;", "mode", "", "(Ljava/lang/Integer;)Landroidx/fragment/app/Fragment;", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "fragmentActivityResult", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WikiTreeHomeFragment extends BaseFragment {
    public final String e;
    public WikiTreeActivityContract f;

    public static final class a {
    }

    static {
    }

    public WikiTreeHomeFragment() {
        this.e = WikiTreeActivityContract.class.getName();
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        Bundle r9 = getArguments();
        WikiTreeActivityContract r10 = null;
        if (r9 == null) goto L5;
        WikiTreeActivityContract r11 = (WikiTreeActivityContract) r9.getParcelable(this.e);
    L7:
        if (r11 != null) goto L11;
        tt5.a.k("Wiki_WikiTreeHomeFragment", "init. invalid contract! return. ");
        com.suite.lark.component.navroute.forseti.g r12 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r12 == null) goto L63;
        r12.g(null);
        return;
    L63:
        return;
    L11:
        this.f = r11;
        Long r13 = gq5.b.a;
        gq5.b.a = Long.valueOf(System.currentTimeMillis());
        Bundle r14 = getArguments();
        WikiTreeActivityContract r1 = this.f;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("contract");
        r1 = null;
    L14:
        Integer r2 = Integer.valueOf(r1.getPageMode());
        if (r2 != null) goto L18;
    L20:
        if (r2 != null) goto L23;
    L25:
        if (r2 != null) goto L28;
    L30:
        if (r2 != null) goto L33;
    L35:
        Fragment r3 = new WikiTreeFragment();
    L36:
        Bundle r4 = new Bundle();
        String r5 = this.e;
        WikiTreeActivityContract r6 = this.f;
        if (r6 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("contract");
        r6 = null;
    L39:
        r4.putParcelable(r5, r6);
        if (r14 == null) goto L42;
        r4.putAll(r14);
    L42:
        r3.setArguments(r4);
        FragmentTransaction r15 = getChildFragmentManager().beginTransaction();
        String r16 = r3.getClass().getSimpleName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r15, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r16, 2131393266) == true) goto L46;
        r15 = r15.replace(2131393266, r3, r16);
    L46:
        r15.commitAllowingStateLoss();
        Bundle r17 = getArguments();
        if (r17 == null) goto L49;
        Serializable r18 = r17.getSerializable("KEY_DEST_STYLE");
    L50:
        StringBuilder r19 = new StringBuilder("init. mode: ");
        WikiTreeActivityContract r20 = this.f;
        if (r20 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("contract");
    L54:
        r19.append(r10.getPageMode());
        r19.append(" destStyle:");
        r19.append(r18);
        tt5.a.h("Wiki_WikiTreeHomeFragment", r19.toString());
        if (r18 != RouteBean.DestStyle.FLOAT) goto L59;
        View r21 = getView();
        if (r21 == null) goto L65;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.h.a(r21);
        return;
    L65:
        return;
    L59:
        View r22 = getView();
        if (r22 == null) goto L67;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        ViewCompat.setOnApplyWindowInsetsListener(r22, new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.i(r22));
        return;
    L67:
        return;
    L53:
        r10 = r20;
        goto L54
    L49:
        r18 = null;
        goto L50
    L33:
        if (r2.intValue() != 4) goto L35;
        r3 = new WikiMakeCopyFragment();
        goto L36
    L28:
        if (r2.intValue() != 3) goto L30;
        r3 = new WikiShortcutToFragment();
        goto L36
    L23:
        if (r2.intValue() != 2) goto L25;
        r3 = new WikiMovToFragment();
        goto L36
    L18:
        if (r2.intValue() != 1) goto L20;
        r3 = new WikiCreateToFragment();
        goto L36
    L5:
        r11 = null;
        goto L7
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        Iterator r0 = getChildFragmentManager().getFragments().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Fragment) r0.next()).onActivityResult(r3, r4, r5);
        goto L4
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568265, r3, false);
    }
}

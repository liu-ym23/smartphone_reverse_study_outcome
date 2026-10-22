package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0003J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020,H\u0016J\"\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020,H\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "searchBarFromXml", "Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar;", "getSearchBarFromXml", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar;", "setSearchBarFromXml", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar;)V", "viewPagerFromXml", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewPager;", "getViewPagerFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewPager;", "setViewPagerFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewPager;)V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewModel;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "args", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListArgs;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "bindView", "bindListener", "onBackPressed", "", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "titleBarHeight", "setTitleBarVisible", "visible", "commitFragment", "fragment", "Landroidx/fragment/app/Fragment;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceTabFragment extends BaseFragment {
    public static final /* synthetic */ int j = 0;
    public WikiSearchbar e;
    public WikiSpaceTabViewPager f;
    public BaseTitleBar g;
    public WikiSpaceTabViewModel h;
    public int i;

    public static final class a {
    }

    static {
    }

    public final WikiSearchbar U90() {
        View r0 = this.e;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131385326);
    L8:
        this.e = (WikiSearchbar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiSearchbar) r0;
    }

    public final BaseTitleBar V90() {
        View r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131388807);
    L8:
        this.g = (BaseTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (BaseTitleBar) r0;
    }

    public final boolean onBackPressed() {
        WikiSearchbar r0 = U90();
        if (r0.d == false) goto L5;
        r0.a();
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return true;
    L8:
        if (super.onBackPressed() == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public WikiSpaceTabFragment() {
    }

    public final void onCreate(Bundle r21) {
        super.onCreate(r21);
        Bundle r0 = getArguments();
        if (r0 == null) goto L56;
        String r3 = WikiSpaceListArgs.class.getName();
        Bundle r4 = getArguments();
        if (r4 == null) goto L7;
        int r6 = r4.getInt("EXTRA_PAGE_MODE", 0);
    L8:
        Bundle r5 = getArguments();
        if (r5 == null) goto L11;
        int r7 = r5.getInt("createDocumentType", sbb.e.g.b);
    L12:
        int r8 = r7;
        Bundle r9 = getArguments();
        if (r9 == null) goto L15;
        String r10 = r9.getString("src_token");
    L16:
        Bundle r11 = getArguments();
        if (r11 == null) goto L19;
        int r12 = r11.getInt("src_obj_type", -1);
    L20:
        Bundle r13 = getArguments();
        if (r13 == null) goto L23;
        String r14 = r13.getString("src_parent_token");
    L24:
        Bundle r15 = getArguments();
        if (r15 == null) goto L27;
        int r16 = r15.getInt("srcIsLock", -1);
    L28:
        Bundle r17 = getArguments();
        if (r17 == null) goto L31;
        String r18 = r17.getString("src_space_id");
    L32:
        Bundle r19 = getArguments();
        if (r19 == null) goto L35;
        String r110 = r19.getString("title");
    L36:
        Bundle r20 = getArguments();
        if (r20 == null) goto L39;
        String r111 = r20.getString("trigger_location");
    L40:
        Bundle r22 = getArguments();
        if (r22 == null) goto L43;
        boolean r112 = r22.getBoolean("src_is_shortcut", false);
    L44:
        Bundle r23 = getArguments();
        if (r23 == null) goto L47;
        String r113 = r23.getString("src_origin_token");
    L48:
        Bundle r24 = getArguments();
        if (r24 == null) goto L51;
        String r114 = r24.getString("src_origin_space_id");
    L52:
        Bundle r25 = getArguments();
        long r1 = 0;
        if (r25 == null) goto L55;
        r1 = r25.getLong("src_file_size", 0);
    L55:
        r0.putParcelable(r3, new WikiSpaceListArgs(r6, r8, r10, r12, r14, r16, r18, r110, r111, r112, r113, r114, r1));
        goto L56
    L51:
        r114 = null;
        goto L52
    L47:
        r113 = null;
        goto L48
    L43:
        r112 = false;
        goto L44
    L39:
        r111 = null;
        goto L40
    L35:
        r110 = null;
        goto L36
    L31:
        r18 = null;
        goto L32
    L27:
        r16 = -1;
        goto L28
    L23:
        r14 = null;
        goto L24
    L19:
        r12 = -1;
        goto L20
    L15:
        r10 = null;
        goto L16
    L11:
        r7 = sbb.e.g.b;
        goto L12
    L7:
        r6 = 0;
    L56:
        WikiSpaceTabViewModel.Companion.getClass();
        WikiSpaceTabViewModel r2 = WikiSpaceTabViewModel.a.a(this);
        this.h = r2;
        if (r2 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L59:
        WikiSpaceListArgs r26 = r2.getArgs();
        if (r26 != null) goto L62;
    L64:
        boolean r27 = false;
    L65:
        if (r27 == false) goto L68;
        gq5.d.g(null);
        return;
    L68:
        return;
    L62:
        if (r26.getPageMode() != 0) goto L64;
        r27 = true;
        goto L65
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        WikiSearchbar r10 = U90();
        FragmentActivity r11 = ContextsKt.findActivity(r10.getContext());
        WikiSpaceTabViewModel r1 = null;
        if ((r11 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r12 = r11;
    L6:
        if (r12 == null) goto L9;
        pcb.a r13 = pcb.a.a.b(r12);
        r10.g = r13;
        r10.h = new WikiSearchbar.b(r10);
        Intrinsics.checkNotNull(r13);
        r13.c(r10.h);
    L9:
        r10.getClearFromXml().setOnClickListener(new hq5.a(r10));
        r10.getCancelFromXml().setOnClickListener(new hq5.b(r10));
        r10.getInputFromXml().setOnEditorActionListener(new hq5.c(r10));
        r10.getInputFromXml().setOnFocusChangeListener(new hq5.d(r10));
        U90().setInputHint(2131888341);
        if (yp5.c.c() == false) goto L19;
        View r14 = this.f;
        if (r14 != null) goto L18;
        View r15 = getView();
        if (r15 == null) goto L16;
        r14 = r15.findViewById(2131392567);
    L17:
        this.f = (WikiSpaceTabViewPager) r14;
        goto L18
    L16:
        r14 = null;
    L18:
        FragmentManager r16 = getChildFragmentManager();
        Bundle r2 = getArguments();
        TabEnum r5 = TabEnum.ALL;
        r5.getSpaceType();
        int r6 = WikiSpaceListFragment.m;
        TabEnum r4 = TabEnum.TEAM;
        r4.getSpaceType();
        TabEnum r7 = TabEnum.PERSONAL;
        r7.getSpaceType();
        ((WikiSpaceTabViewPager) r14).a(r16, CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a[]{new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a(2131887461, WikiSpaceListFragment.a.a(r5.getSpaceType(), r2)), new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a(2131887534, WikiSpaceListFragment.a.a(r4.getSpaceType(), r2)), new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a(2131887522, WikiSpaceListFragment.a.a(r7.getSpaceType(), r2))}));
    L27:
        V90().setLeftClickListener(new n(this));
        View r17 = getView();
        if (r17 == null) goto L30;
        r17.setOnClickListener(o.a);
    L30:
        WikiSpaceTabViewModel r18 = this.h;
        if (r18 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        r1.getTitle().observe(getViewLifecycleOwner(), new m(this));
        U90().setViewDelegate(new l(this));
        return;
    L33:
        r1 = r18;
        goto L34
    L19:
        View r19 = this.f;
        if (r19 != null) goto L26;
        View r20 = getView();
        if (r20 == null) goto L24;
        r19 = r20.findViewById(2131392567);
    L25:
        this.f = (WikiSpaceTabViewPager) r19;
        goto L26
    L24:
        r19 = null;
    L26:
        WikiSpaceTabViewPager r21 = (WikiSpaceTabViewPager) r19;
        FragmentManager r22 = getChildFragmentManager();
        Bundle r3 = getArguments();
        TabEnum r23 = TabEnum.ALL;
        r23.getSpaceType();
        int r24 = WikiSpaceListFragment.m;
        com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a r25 = new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a(2131887461, WikiSpaceListFragment.a.a(r23.getSpaceType(), r3));
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "fm");
        Intrinsics.checkNotNullParameter(r25, "tab");
        r21.a(r22, CollectionsKt.listOf(r25));
        r21.getTabLayoutFromXml().setVisibility(8);
        r21.getTabDividerFromXml().setVisibility(8);
        goto L27
    L5:
        r12 = null;
        goto L6
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        if (r2 != (-1)) goto L5;
    L7:
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L11;
        r4.setResult(r2, r3);
        r4.finish();
        return;
    L11:
        return;
    L5:
        if (r2 == 100) goto L7;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568262, r3, false);
    }
}

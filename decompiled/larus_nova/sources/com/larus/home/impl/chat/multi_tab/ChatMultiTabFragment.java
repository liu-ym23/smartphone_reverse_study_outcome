package com.larus.home.impl.chat.multi_tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import ci8.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.m4;
import com.larus.bmhome.view.ChatTitleAlignLeftStyle;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.databinding.LarusPageMainBotMultiTabBinding;
import com.larus.nova.R;
import com.larus.platform.api.g0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mb9.b;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020\bH\u0016J\u001e\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0014J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\bH\u0002J\u0018\u00101\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0002J\b\u00103\u001a\u00020/H\u0002R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/home/impl/chat/multi_tab/ChatMultiTabFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/chat/multi_tab/IChatMultiTabFragment;", "Lcom/larus/bmhome/chat/ITraceFragment;", "<init>", "()V", "tabs", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "defaultTab", "titleStyle", "binding", "Lcom/larus/home/impl/databinding/LarusPageMainBotMultiTabBinding;", "tabFactory", "Lcom/larus/home/impl/chat/multi_tab/ChatMultiTabFactory;", "slideMode", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "initTitle", "Lcom/larus/bmhome/view/ChatTitleAlignLeftStyle;", "initDefaultTab", "getFragmentByTab", "tab", "onResult", "requestCode", "resultCode", "bundle", "getTitle", "Lcom/larus/platform/api/IChatTitle;", "switchTab", "enableSwitchTab", "enable", "", "scene", "", "reportChatTabSwitch", "reportEnterPage", "lastTab", "getSwitchTabEnterMethod", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatMultiTabFragment extends Fragment implements d, m4 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<Integer> f344203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f344204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f344205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusPageMainBotMultiTabBinding f344206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mb9.a f344207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f344208i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.m4
    public final String scene() {
        return "CHAT_MULTI_TAB";
    }

    @Override // ci8.d
    public final g0 getTitle() {
        LarusPageMainBotMultiTabBinding r100 = this.f344206g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f344374b;
    }

    public ChatMultiTabFragment() {
        this.f344204e = PageType.Chat.getType();
    }

    public final Fragment S90(int r100) {
        if (isDetached() == false) goto L5;
        return null;
    L5:
        if (isAdded() == true) goto L8;
        return null;
    L8:
        return getChildFragmentManager().findFragmentByTag("f" + r100);
    }

    @Override // ci8.d
    public final void f0(int r100) {
        ArrayList<Integer> r101 = this.f344203d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabs");
        r101 = null;
    L5:
        Iterator<Integer> r102 = r101.iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L15;
        if (r102.next().intValue() != r100) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L16;
        r103 = r103 + 1;
    L16:
        FLogger.f375446a.i("ChatMultiTabFragment", "switchTab, tab = " + r100 + ", index = " + r103);
        this.f344208i = 2;
        LarusPageMainBotMultiTabBinding r105 = this.f344206g;
        if (r105 == null) goto L24;
        ViewPager2 r106 = r105.f344375c;
        if (r106 == null) goto L25;
        r106.setCurrentItem(r103);
        return;
    L25:
        return;
    L24:
        return;
    L11:
        r104 = false;
        goto L12
    L15:
        r103 = -1;
        goto L16
    }

    @Override // ci8.d
    public final void hp(boolean r100) {
        LarusPageMainBotMultiTabBinding r101 = this.f344206g;
        if (r101 == null) goto L7;
        ChatMultiTabConstraintLayout r102 = r101.f344373a;
        if (r102 == null) goto L7;
        r102.setPagerEnabled(r100);
    L7:
        LarusPageMainBotMultiTabBinding r103 = this.f344206g;
        if (r103 == null) goto L13;
        ViewPager2 r104 = r103.f344375c;
        if (r104 == null) goto L14;
        r104.setUserInputEnabled(r100);
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        ArrayList<Integer> r102 = null;
        if (r101 == null) goto L5;
        ArrayList<Integer> r103 = r101.getIntegerArrayList("argument_multi_tab_list");
    L6:
        int r104 = 0;
        if (r103 != null) goto L9;
    L12:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        FLogger.f375446a.w("ChatMultiTabFragment", "page type list in arguments is empty, use default");
        r103 = CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(PageType.Chat.getType()), Integer.valueOf(PageType.IMAGE_TEMPLATE.getType())});
    L16:
        this.f344203d = r103;
        Bundle r106 = getArguments();
        if (r106 == null) goto L19;
        int r107 = r106.getInt("argument_multi_tab_default_tab", PageType.Chat.getType());
    L20:
        this.f344204e = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L23;
        r104 = r108.getInt("argument_multi_tab_title_style", 0);
    L23:
        this.f344205f = r104;
        FLogger r109 = FLogger.f375446a;
        StringBuilder r110 = new StringBuilder("init arguments, tabs: ");
        ArrayList<Integer> r111 = this.f344203d;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("tabs");
        r111 = null;
    L26:
        r110.append(r111);
        r110.append(", defaultTab: ");
        r110.append(this.f344204e);
        r110.append(", titleStyle: ");
        r110.append(this.f344205f);
        r109.i("ChatMultiTabFragment", r110.toString());
        Bundle r112 = getArguments();
        ArrayList<Integer> r113 = this.f344203d;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("tabs");
    L30:
        this.f344207h = new mb9.a(r112, r102, this.f344204e);
        return;
    L29:
        r102 = r113;
        goto L30
    L19:
        r107 = PageType.Chat.getType();
        goto L20
    L9:
        if (r103.isEmpty() == true) goto L12;
        r105 = false;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        LarusPageMainBotMultiTabBinding r112 = this.f344206g;
        boolean r113 = true;
        if (r112 == null) goto L7;
        ViewPager2 r114 = r112.f344375c;
        if (r114 == null) goto L7;
        final FragmentManager r100 = getChildFragmentManager();
        final Lifecycle r101 = getLifecycle();
        r114.setAdapter(new ChatMultiTabFragment$initViewPager$1$1(this, r100, r101));
        r114.registerOnPageChangeCallback(new ChatMultiTabFragment$initViewPager$1$2(this));
        r114.setOffscreenPageLimit(1);
    L7:
        LarusPageMainBotMultiTabBinding r115 = this.f344206g;
        Integer r102 = null;
        if (r115 == null) goto L49;
        ChatTitleAlignLeftStyle r116 = r115.f344374b;
        if (r116 == null) goto L49;
        b r103 = new b(this, r116);
        Intrinsics.checkNotNullParameter(r103, "listener");
        r116.f315493b.A.addOnTabSelectedListener(r103);
        ArrayList<Integer> r104 = this.f344203d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tabs");
        r104 = null;
    L14:
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L16:
        if (r106.hasNext() == false) goto L34;
        int r107 = ((Number) r106.next()).intValue();
        mb9.a r108 = this.f344207h;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("tabFactory");
        r108 = null;
    L20:
        r108.getClass();
        if (r107 != PageType.Chat.getType()) goto L24;
        String r109 = AppHost.f326268a.getApplication().getString(R.string.larus_db_feed_db_tab_name_cn);
        Intrinsics.checkNotNull(r109);
    L33:
        r105.add(r109);
        goto L16
    L24:
        if (r107 != PageType.VIDEO.getType()) goto L27;
        r109 = AppHost.f326268a.getApplication().getString(R.string.larus_db_feed_tab_name_cn);
        Intrinsics.checkNotNull(r109);
        goto L33
    L27:
        if (r107 != PageType.AWEME_FEED.getType()) goto L30;
        r109 = AppHost.f326268a.getApplication().getString(R.string.larus_db_feed_tab_name_cn);
        Intrinsics.checkNotNull(r109);
        goto L33
    L30:
        if (r107 != PageType.AI_GENERATE.getType()) goto L32;
        r109 = AppHost.f326268a.getApplication().getString(R.string.larus_image_bot_im_tab);
        Intrinsics.checkNotNull(r109);
        goto L33
    L32:
        FLogger.f375446a.e("ChatMultiTabFactory", "illegal page type: " + r107);
        r109 = "";
        goto L33
    L34:
        r116.setTabView(r105);
        if (this.f344205f != 0) goto L37;
        boolean r117 = true;
    L38:
        r116.setTabAlignment(r117);
        LarusPageMainBotMultiTabBinding r118 = this.f344206g;
        if (r118 == null) goto L41;
        ViewPager2 r119 = r118.f344375c;
    L42:
        r116.setupWithViewPager(r119);
        ViewGroup.LayoutParams r120 = r116.getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L45;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
    L46:
        if (r121 == null) goto L48;
        r121.topMargin = u.c(requireActivity());
    L48:
        e1.o(r116);
        goto L49
    L45:
        r121 = null;
        goto L46
    L41:
        r119 = null;
        goto L42
    L37:
        r117 = false;
    L49:
        ArrayList<Integer> r122 = this.f344203d;
        if (r122 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("tabs");
        r122 = null;
    L52:
        Integer r123 = Integer.valueOf(r122.indexOf(Integer.valueOf(this.f344204e)));
        if (r123.intValue() >= 0) goto L56;
        r113 = false;
    L56:
        if (r113 == false) goto L58;
        r102 = r123;
    L58:
        if (r102 == null) goto L60;
        int r124 = r102.intValue();
    L61:
        FLogger.f375446a.i("ChatMultiTabFragment", "landing to tab index " + r124);
        LarusPageMainBotMultiTabBinding r125 = this.f344206g;
        if (r125 == null) goto L73;
        ViewPager2 r126 = r125.f344375c;
        if (r126 == null) goto L74;
        r126.setCurrentItem(r124, false);
        return;
    L74:
        return;
    L73:
        return;
    L60:
        r124 = 0;
        goto L61
    }

    public final void T90(int r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r102, "bundle");
        FLogger.f375446a.i("ChatMultiTabFragment", "onResult, requestCode = " + r100 + ", resultCode = " + r101 + ", bundle = " + r102);
        if (isDetached() == false) goto L5;
        return;
    L5:
        if (isAdded() == false) goto L16;
        Fragment r103 = S90(PageType.Chat.getType());
        if ((r103 instanceof ChatFragment) == false) goto L10;
        ChatFragment r104 = (ChatFragment) r103;
    L11:
        if (r104 == null) goto L15;
        r104.Lc(r102, r100, r101);
        return;
    L15:
        return;
    L10:
        r104 = null;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_page_main_bot_multi_tab, r101, false);
        int r104 = R.id.title_bar;
        ChatTitleAlignLeftStyle r105 = (ChatTitleAlignLeftStyle) ViewBindings.findChildViewById(r103, R.id.title_bar);
        if (r105 == null) goto L9;
        r104 = R.id.view_pager;
        ViewPager2 r106 = (ViewPager2) ViewBindings.findChildViewById(r103, R.id.view_pager);
        if (r106 == null) goto L9;
        ChatMultiTabConstraintLayout r107 = (ChatMultiTabConstraintLayout) r103;
        this.f344206g = new LarusPageMainBotMultiTabBinding(r107, r105, r106);
        return r107;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}

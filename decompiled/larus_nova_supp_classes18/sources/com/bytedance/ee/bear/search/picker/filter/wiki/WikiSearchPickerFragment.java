package com.bytedance.ee.bear.search.picker.filter.wiki;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.search.SelectPickerConfig;
import com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment;
import com.bytedance.ee.bear.search.picker.SpaceSearchViewModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00102\u001a\u00020\u0011H\u0002J\b\u00103\u001a\u00020\u0011H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0011H\u0002J\u0016\u00108\u001a\u00020\u00112\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016J\u0012\u0010<\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u0011H\u0016J\"\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\b\u00109\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020\u0011H\u0016J\u001a\u0010H\u001a\u00020\u00112\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020FH\u0016J\u0006\u0010L\u001a\u00020\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/wiki/WikiSearchPickerFragment;", "Lcom/bytedance/ee/bear/search/picker/BaseSearchPickerFragment;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "pickerRootFromXml", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getPickerRootFromXml", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setPickerRootFromXml", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "pickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "filterView", "Lcom/bytedance/ee/bear/search/picker/filter/wiki/WikiSearchFilterView;", "picker", "Lcom/ss/android/lark/picker/Picker;", "getPicker", "()Lcom/ss/android/lark/picker/Picker;", "setPicker", "(Lcom/ss/android/lark/picker/Picker;)V", "docListener", "Lcom/bytedance/ee/bear/search/picker/DocPickerNotifyListener;", "mViewModel", "Lcom/bytedance/ee/bear/search/picker/SpaceSearchViewModel;", "wikiIRecommendPuller", "Lcom/bytedance/ee/bear/search/picker/filter/wiki/WikiSpaceRecommendPuller;", "selectPickerConfig", "Lcom/bytedance/ee/bear/search/SelectPickerConfig;", "trigger", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "backPress", "initViewModel", "getPickerConfig", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "initFilterView", "onSelectFolderClick", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/search/picker/filter/base/MultiSelectedFilterData;", "Lcom/ss/android/lark/search/dto/info/SearchSpaceInfo;", "doSearch", "searchReloader", "Lcom/bytedance/ee/bear/search/picker/filter/base/SearchReloader;", "changeConfig", "onActivityResult", "requestCode", "", "resultCode", "Landroid/content/Intent;", "isFilterFolderType", "", "onDestroy", "confirmResult", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isConfirm", "onBackClick", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSearchPickerFragment extends BaseSearchPickerFragment {
    public static final /* synthetic */ int n = 0;
    public BaseTitleBar e;
    public ConstraintLayout f;
    public PickerConfig g;
    public com.bytedance.ee.bear.search.picker.filter.wiki.b h;
    public Picker i;
    public com.bytedance.ee.bear.search.picker.a j;
    public g k;
    public SelectPickerConfig l;
    public com.bytedance.ee.bear.wikiv2.searchv2.a m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ WikiSearchPickerFragment a;

        public b(WikiSearchPickerFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            WikiSearchPickerFragment.W90(this.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class d implements sa5.d {
        public final /* synthetic */ WikiSearchPickerFragment a;

        public d(WikiSearchPickerFragment r1) {
            this.a = r1;
        }

        public final boolean onBackPressed() {
            WikiSearchPickerFragment.W90(this.a);
            return true;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment, com.bytedance.ee.bear.search.picker.filter.a
    public final void PF(em5.a<SearchSpaceInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment, com.bytedance.ee.bear.search.picker.filter.a
    public final void K30() {
        PickerConfig r0 = this.g;
        if (r0 == null) goto L23;
        final com.bytedance.ee.bear.search.picker.filter.wiki.b r2 = this.h;
        if (r2 == null) goto L23;
        final g r3 = this.k;
        Intrinsics.checkNotNullParameter(r0, "pickConfig");
        int r4 = r2.o;
        if (r4 == 0) goto L17;
        if (r4 != 1) goto L10;
        r2.d(r0);
        goto L23
    L10:
        if (r4 == 2) goto L12;
        r2.d(r0);
        goto L23
    L12:
        FilterViewV2 r5 = r2.getFilterView();
        if (r5 == null) goto L15;
        r5.setVisibility(8);
    L15:
        r0.searcher(WikiSearchFilterView$updateFolderConfig$1$1.INSTANCE);
        r0.extra(new WikiSearchFilterView$updateFolderConfig$1$2(r2));
        r0.recommendList(WikiSearchFilterView$updateFolderConfig$1$3.INSTANCE);
        goto L23
    L17:
        FilterViewV2 r6 = r2.getFilterView();
        if (r6 == null) goto L20;
        r6.setVisibility(8);
    L20:
        r0.searcher(WikiSearchFilterView$updateWikiConfig$1$1.INSTANCE);
        r0.extra(new WikiSearchFilterView$updateWikiConfig$1$2(r2));
        if (r3 == null) goto L23;
        r0.recommendList(new WikiSearchFilterView$updateWikiConfig$1$3$1(r2, r3));
    L23:
        Picker r1 = this.i;
        if (r1 == null) goto L27;
        r1.reload(true, true);
        return;
    }

    public final BaseTitleBar X90() {
        View r0 = this.e;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131388775);
    L8:
        this.e = (BaseTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (BaseTitleBar) r0;
    }

    public WikiSearchPickerFragment() {
        this.l = new SelectPickerConfig(null, false, false, false, null, null, null, 127, null);
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final View V90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L8;
        Picker r1 = new Picker(r0);
        r1.scene(this.l.getScene());
        Intrinsics.checkNotNullParameter(r0, "fragmentActivity");
        Context r2 = getContext();
        if (r2 == null) goto L7;
        com.bytedance.ee.bear.search.picker.filter.wiki.b r3 = new com.bytedance.ee.bear.search.picker.filter.wiki.b(r2, this.l);
        this.h = r3;
        r3.setListener(this);
    L7:
        final g r4 = new g();
        this.k = r4;
        this.j = new com.bytedance.ee.bear.search.picker.a(this, this.l.getUseDefaultClick());
        PickerConfig r5 = new PickerConfig(new Dependency(r0, r0.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r5.searcher(WikiSearchPickerFragment$getPickerConfig$config$1$1.INSTANCE);
        r5.extra(new WikiSearchPickerFragment$getPickerConfig$config$1$2(this));
        r5.recommendList(new WikiSearchPickerFragment$getPickerConfig$config$1$3(this, r4));
        this.g = r5;
        r1.init(r5);
        this.i = r1;
        return r1;
    L8:
        return null;
    }

    public final void onDestroy() {
        super.onDestroy();
        g r0 = this.k;
        if (r0 == null) goto L6;
        r0.a.clear();
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        this.f = null;
    }

    public static final void W90(WikiSearchPickerFragment r1) {
        r1.getClass();
        if (ForsetiHelper.s(r1) == false) goto L7;
        com.bytedance.ee.bear.wikiv2.searchv2.a r0 = r1.m;
        if (r0 == null) goto L10;
        r0.back();
    L10:
        rcb.c.c(r1.getActivity());
        return;
    L7:
        FragmentActivity r2 = r1.getActivity();
        if (r2 == null) goto L10;
        r2.onBackPressed();
        goto L10
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment, com.bytedance.ee.bear.search.picker.filter.a
    public final void M60(em5.e r3) {
        PickerConfig r0 = this.g;
        if (r0 == null) goto L6;
        if (r3 == null) goto L6;
        r3.c(r0);
    L6:
        tt5.a.h("WikiSearchPickerFragment", "change params, reload search, reloader : " + r3);
        Picker r4 = this.i;
        if (r4 == null) goto L10;
        r4.reload(true, true);
        return;
    }

    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        Bundle r12 = getArguments();     // Catch: Exception -> L24
        if (r12 == null) goto L14;
        Serializable r13 = r12.getSerializable("KEY_PICKER_CONFIG");     // Catch: Exception -> L24
        if ((r13 instanceof SelectPickerConfig) == false) goto L8;
        SelectPickerConfig r14 = (SelectPickerConfig) r13;     // Catch: Exception -> L24
    L9:
        if (r14 != null) goto L11;
        r14 = new SelectPickerConfig(null, false, false, false, null, null, null, 127, null);     // Catch: Exception -> L24
    L11:
        this.l = r14;     // Catch: Exception -> L24
        goto L14
    L8:
        r14 = null;
    L14:
        if ((getContext() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L17;
        Object r15 = getContext();     // Catch: Exception -> L24
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.searchv2.IOpenPageSelectTrigger");     // Catch: Exception -> L24
        this.m = (com.bytedance.ee.bear.wikiv2.searchv2.a) r15;     // Catch: Exception -> L24
    L17:
        if (ForsetiHelper.p() == true) goto L19;
        return;
    L19:
        if (this.m == null) goto L21;
        return;
    L21:
        if ((getParentFragment() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L31;
        com.bytedance.ee.bear.wikiv2.searchv2.a r16 = getParentFragment();     // Catch: Exception -> L24
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.searchv2.IOpenPageSelectTrigger");     // Catch: Exception -> L24
        this.m = r16;     // Catch: Exception -> L24
        return;
    L31:
        return;
    L24:
        e = move-exception;
        tt5.a.d("WikiSearchPickerFragment", "getSelectPickerConfig error" + e.getMessage());
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final void U90(SearchBaseInfo r9, boolean r10) {
        String r0 = "";
        if ((r9 instanceof SearchWikiInfo) == false) goto L17;
        SearchWikiInfo r11 = (SearchWikiInfo) r9;
        Long r12 = r11.getSpaceInfo().getSpaceId();
        if (r12 == null) goto L7;
        long r1 = r12.longValue();
    L8:
        String r13 = r11.getSpaceInfo().getSpaceName();
        if (r13 == null) goto L12;
        r0 = r13;
    L12:
        com.bytedance.ee.bear.wikiv2.searchv2.c r14 = new com.bytedance.ee.bear.wikiv2.searchv2.c(String.valueOf(r1), r0, r11.getToken());
        com.bytedance.ee.bear.wikiv2.searchv2.a r15 = this.m;
        if (r15 == null) goto L40;
        r15.Ct(r14);
        return;
    L40:
        return;
    L7:
        r1 = 0;
        goto L8
    L17:
        if ((r9 instanceof SearchWikiSpaceInfo) == false) goto L30;
        SearchWikiSpaceInfo r16 = (SearchWikiSpaceInfo) r9;
        String r2 = r16.getSpaceId();
        if (r2 != null) goto L21;
        r2 = "";
    L21:
        String r3 = r16.getSpaceName();
        if (r3 == null) goto L25;
        r0 = r3;
    L25:
        com.bytedance.ee.bear.wikiv2.searchv2.c r17 = new com.bytedance.ee.bear.wikiv2.searchv2.c(r2, r0, r16.getRootToken());
        com.bytedance.ee.bear.wikiv2.searchv2.a r18 = this.m;
        if (r18 == null) goto L41;
        r18.Ct(r17);
        return;
    L41:
        return;
    L30:
        if ((r9 instanceof SearchSpaceInfo) == false) goto L38;
        SearchSpaceInfo r19 = (SearchSpaceInfo) r9;
        if (r19.getDocType() != Doc.Type.FOLDER) goto L38;
        if ((getActivity() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L38;
        td5.e r110 = new td5.e(0, r19.getId(), r19.getTitle(), r19.getIsShareFolder().booleanValue(), 2, 5, r19.isCrossTenant());
        com.bytedance.ee.bear.wikiv2.searchv2.a r20 = this.m;
        if (r20 == null) goto L38;
        r20.j7(r110);
    L38:
        rcb.c.c(getContext());
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        FragmentActivity r7 = getActivity();
        View r0 = null;
        if (r7 == null) goto L5;
        SpaceSearchViewModel r8 = (SpaceSearchViewModel) ViewModelProviders.of(r7).get(SpaceSearchViewModel.class);
    L6:
        if (r8 == null) goto L10;
        MutableLiveData<ArrayList<com.bytedance.ee.bear.search.picker.filter.type.e>> r9 = r8.getDocTypeSelectItem();
        if (r9 == null) goto L10;
        r9.observe(getViewLifecycleOwner(), new f(this));
    L10:
        ViewGroup.LayoutParams r10 = new ConstraintLayout.LayoutParams(-1, 0);
        if (this.l.getSelectTitleConfig().getUseTitle() == false) goto L13;
        X90().setTitle(this.l.getSelectTitleConfig().getTitleName());
        ((ConstraintLayout.LayoutParams) r10).bottomToBottom = 2131382277;
        ((ConstraintLayout.LayoutParams) r10).topToBottom = 2131388775;
        X90().setLeftClickListener(new b(this));
    L14:
        View r1 = this.f;
        if (r1 != null) goto L20;
        View r2 = getView();
        if (r2 == null) goto L19;
        r0 = r2.findViewById(2131382277);
    L19:
        this.f = (ConstraintLayout) r0;
        r1 = r0;
    L20:
        ((ConstraintLayout) r1).addView(V90(), r10);
        r5.setOnClickListener(c.a);
        if (ForsetiHelper.s(this) == false) goto L24;
        FragmentBackPressedHelperKt.a(this, new d(this));
        return;
    L24:
        return;
    L13:
        X90().setVisibility(8);
        ((ConstraintLayout.LayoutParams) r10).bottomToBottom = 2131382277;
        ((ConstraintLayout.LayoutParams) r10).topToTop = 2131382277;
        goto L14
    L5:
        r8 = null;
        goto L6
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r1 != 4) goto L7;
        Serializable r4 = r3.getSerializableExtra("KEY_WIKI_SPACE_INFO");
        com.bytedance.ee.bear.search.picker.filter.wiki.b r5 = this.h;
        if (r5 == null) goto L26;
        r5.setWikiSpaceList(r4);
        return;
    L26:
        return;
    L7:
        if (r1 != 4097) goto L9;
        com.bytedance.ee.bear.search.picker.filter.wiki.b r6 = this.h;
        if (r6 == null) goto L24;
        r6.setOwnerList(r3.getSerializableExtra("EXTRA_OWNER_INFO"));
        return;
    L24:
        return;
    L9:
        if (r1 != 4098) goto L27;
        com.bytedance.ee.bear.search.picker.filter.wiki.b r7 = this.h;
        if (r7 == null) goto L22;
        r7.setChatList(r3.getSerializableExtra("EXTRA_CHAT_INFO"));
        return;
    L22:
        return;
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561256, r3, false);
    }
}

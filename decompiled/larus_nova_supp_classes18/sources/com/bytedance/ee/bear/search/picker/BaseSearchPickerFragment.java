package com.bytedance.ee.bear.search.picker;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.search.picker.filter.chat.ChatPickerActivity;
import com.bytedance.ee.bear.search.picker.filter.chatter.ChatterPickerActivity;
import com.bytedance.ee.bear.search.picker.filter.folder.SearchSelectFolderActivity;
import com.bytedance.ee.bear.search.picker.filter.type.SearchSelectTypeFragment;
import com.bytedance.ee.bear.search.picker.filter.wiki.SearchSelectWikiActivity;
import com.bytedance.ee.bear.search.picker.filter.wiki.WikiSearchPickerFragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import em5.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0016J\u0016\u0010\u001b\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017H\u0016J\u0016\u0010\u001d\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u0017H\u0016J\u0012\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\u001a\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/BaseSearchPickerFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/search/picker/filter/SearchFilterSelectListener;", "<init>", "()V", "isUsePickerV2", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getPickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getPicker", "onSelectTypeClick", "", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/search/picker/filter/base/MultiSelectedFilterData;", "", "onSelectOwnerClick", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "onSelectChatClick", "Lcom/ss/android/lark/search/dto/info/SearchChatInfo;", "onSelectFolderClick", "Lcom/ss/android/lark/search/dto/info/SearchSpaceInfo;", "onSelectWikiSpaceClick", "Lcom/ss/android/lark/search/dto/info/SearchWikiSpaceInfo;", "doSearch", "searchReloader", "Lcom/bytedance/ee/bear/search/picker/filter/base/SearchReloader;", "changeConfig", "isFilterFolderType", "confirmResult", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isConfirm", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseSearchPickerFragment extends BaseFragment implements com.bytedance.ee.bear.search.picker.filter.a {
    @Override // com.bytedance.ee.bear.search.picker.filter.a
    public void K30() {
    }

    @Override // com.bytedance.ee.bear.search.picker.filter.a
    public void M60(e r1) {
    }

    public void U90(SearchBaseInfo r1, boolean r2) {
    }

    public View V90() {
        return null;
    }

    public BaseSearchPickerFragment() {
    }

    @Override // com.bytedance.ee.bear.search.picker.filter.a
    public final void Hj(em5.a<Integer> r6) {
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.DATA);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L13;
        int r1 = SearchSelectTypeFragment.A;
        FragmentManager r2 = r0.getSupportFragmentManager();
        int[] r7 = CollectionsKt.toIntArray(r6.f);
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r7, "selectedTypes");
        SearchSelectTypeFragment r3 = new SearchSelectTypeFragment();
        Bundle r4 = new Bundle();
        r4.putIntArray("selected_types", r7);
        r4.putBoolean("isFilterFolder", this instanceof WikiSearchPickerFragment);
        r3.setArguments(r4);
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "SearchSelectTypeFragment", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r3, r8) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        r3.show(r2, "SearchSelectTypeFragment");
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.search.picker.filter.a
    public void PF(em5.a<SearchSpaceInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        Intent r1 = new Intent(r0, SearchSelectFolderActivity.class);
        r1.putExtra("EXTRA_SELECTED_FOLDER", r4.f);
        r0.startActivityForResult(r1, 5);
        r0.overridePendingTransition(2130772286, 0);
        return;
    }

    @Override // com.bytedance.ee.bear.search.picker.filter.a
    public final void WZ(em5.a<SearchWikiSpaceInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        Intent r1 = new Intent(r0, SearchSelectWikiActivity.class);
        r1.putExtra("EXTRA_SELECTED_WIKI", r4.f);
        r0.startActivityForResult(r1, 4);
        r0.overridePendingTransition(2130772286, 0);
        return;
    }

    @Override // com.bytedance.ee.bear.search.picker.filter.a
    public final void j20(em5.a<SearchChatterInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        Intent r1 = new Intent(r0, ChatterPickerActivity.class);
        r1.putExtra("EXTRA_SELECTED_CHATTER", r4.f);
        r0.startActivityForResult(r1, 4097);
        r0.overridePendingTransition(2130772286, 0);
        return;
    }

    @Override // com.bytedance.ee.bear.search.picker.filter.a
    public final void lZ(em5.a<SearchChatInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        Intent r1 = new Intent(r0, ChatPickerActivity.class);
        r1.putExtra("EXTRA_SELECTED_CHAT", r4.f);
        r0.startActivityForResult(r1, 4098);
        r0.overridePendingTransition(2130772286, 0);
        return;
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return V90();
    }
}

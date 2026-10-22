package com.bytedance.ee.bear.search.picker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.util.ui.n;
import com.google.gson.Gson;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.config.condition.DocTypes;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import em5.e;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\u0006\u0010)\u001a\u00020\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/SpaceSearchPickerFragment;", "Lcom/bytedance/ee/bear/search/picker/BaseSearchPickerFragment;", "<init>", "()V", "picker", "Lcom/ss/android/lark/picker/Picker;", "getPicker", "()Lcom/ss/android/lark/picker/Picker;", "setPicker", "(Lcom/ss/android/lark/picker/Picker;)V", "pickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "filterView", "Lcom/bytedance/ee/bear/search/picker/filter/SpaceSearchFilterView;", "mViewModel", "Lcom/bytedance/ee/bear/search/picker/SpaceSearchViewModel;", "pickerNotifyListener", "Lcom/bytedance/ee/bear/search/picker/DocPickerNotifyListener;", "folderInfo", "Lcom/bytedance/ee/bear/search/FolderInfo;", "Landroid/view/View;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "getPickerConfig", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "initFilterView", "initViewModel", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "doSearch", "searchReloader", "Lcom/bytedance/ee/bear/search/picker/filter/base/SearchReloader;", "changeConfig", "onBackClick", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SpaceSearchPickerFragment extends BaseSearchPickerFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f236828j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Picker f236829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PickerConfig f236830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.search.picker.filter.b f236831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.search.picker.a f236832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.search.a f236833i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment, com.bytedance.ee.bear.search.picker.filter.a
    public final void K30() {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final View V90() {
        FragmentActivity r100 = getActivity();
        String r101 = null;
        if (r100 == null) goto L17;
        Picker r102 = new Picker(r100);
        r102.scene(PickerStatistics.Scene.CcmSearchInSpace);
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Context r103 = getContext();
        if (r103 != null) goto L15;
    L13:
        this.f236832h = new com.bytedance.ee.bear.search.picker.a(this, true);
        final DocTypes r104 = b.a();
        tt5.a.h("SpaceSearchPickerFragment", "getPickerConfig, initial search, docTypes=" + r104.getTypes());
        PickerConfig r105 = new PickerConfig(new Dependency(r100, r100.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r105.searcher(new SpaceSearchPickerFragment$getPickerConfig$config$1$1(this, r104));
        r105.extra(new SpaceSearchPickerFragment$getPickerConfig$config$1$2(this));
        r105.recommendList(new SpaceSearchPickerFragment$getPickerConfig$config$1$3(this, r104));
        this.f236830f = r105;
        r102.init2(r105);
        this.f236829e = r102;
        return r102;
    L15:
        Gson r106 = new Gson();     // Catch: Exception -> L11
        Bundle r107 = getArguments();     // Catch: Exception -> L11
        if (r107 == null) goto L9;
        r101 = r107.getString("KEY_FOLDER_INFO");     // Catch: Exception -> L11
    L9:
        this.f236833i = (com.bytedance.ee.bear.search.a) r106.fromJson(r101, com.bytedance.ee.bear.search.a.class);     // Catch: Exception -> L11
    L12:
        com.bytedance.ee.bear.search.picker.filter.b r108 = new com.bytedance.ee.bear.search.picker.filter.b(this.f236833i, r103);
        this.f236831g = r108;
        r108.setListener(this);
    L11:
        tt5.a.d("SpaceSearchPickerFragment", "parse folder info err");
        goto L12
    L17:
        return null;
    }

    public SpaceSearchPickerFragment() {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment, com.bytedance.ee.bear.search.picker.filter.a
    public final void M60(e r100) {
        PickerConfig r101 = this.f236830f;
        if (r101 == null) goto L6;
        if (r100 == null) goto L6;
        r100.c(r101);
    L6:
        tt5.a.h("SpaceSearchPickerFragment", "change params, reload search, reloader : " + r100);
        Picker r102 = this.f236829e;
        if (r102 == null) goto L10;
        r102.reload(true, true);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L5;
        SpaceSearchViewModel r103 = (SpaceSearchViewModel) ViewModelProviders.of(r102).get(SpaceSearchViewModel.class);
    L6:
        if (r103 == null) goto L10;
        MutableLiveData<ArrayList<com.bytedance.ee.bear.search.picker.filter.type.e>> r104 = r103.getDocTypeSelectItem();
        if (r104 == null) goto L10;
        r104.observe(getViewLifecycleOwner(), new c(this));
    L10:
        com.bytedance.ee.bear.search.picker.filter.b r105 = this.f236831g;
        if (r105 == null) goto L16;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L17;
        r106.width = -1;
        r106.height = n.d(44);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 != 4) goto L7;
        ArrayList<String> r103 = r102.getStringArrayListExtra("KEY_WIKI_SPACE_INFO");
        com.bytedance.ee.bear.search.picker.filter.b r104 = this.f236831g;
        if (r104 == null) goto L33;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        r104.setWikiSpaceList(r103);
        return;
    L33:
        return;
    L7:
        if (r100 != 5) goto L9;
        Serializable r105 = r102.getSerializableExtra("KEY_FOLDER_INFOS");
        com.bytedance.ee.bear.search.picker.filter.b r106 = this.f236831g;
        if (r106 == null) goto L31;
        r106.setFolderList(r105);
        return;
    L31:
        return;
    L9:
        if (r100 != 4097) goto L11;
        com.bytedance.ee.bear.search.picker.filter.b r107 = this.f236831g;
        if (r107 == null) goto L29;
        r107.setOwnerList(r102.getSerializableExtra("EXTRA_OWNER_INFO"));
        return;
    L29:
        return;
    L11:
        if (r100 != 4098) goto L34;
        com.bytedance.ee.bear.search.picker.filter.b r108 = this.f236831g;
        if (r108 == null) goto L27;
        r108.setChatList(r102.getSerializableExtra("EXTRA_CHAT_INFO"));
        return;
    L27:
        return;
    }
}

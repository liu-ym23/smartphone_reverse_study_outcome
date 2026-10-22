package com.bytedance.ee.bear.search.picker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\u0006\u0010)\u001a\u00020\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/SpaceSearchPickerFragment;", "Lcom/bytedance/ee/bear/search/picker/BaseSearchPickerFragment;", "<init>", "()V", "picker", "Lcom/ss/android/lark/picker/Picker;", "getPicker", "()Lcom/ss/android/lark/picker/Picker;", "setPicker", "(Lcom/ss/android/lark/picker/Picker;)V", "pickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "filterView", "Lcom/bytedance/ee/bear/search/picker/filter/SpaceSearchFilterView;", "mViewModel", "Lcom/bytedance/ee/bear/search/picker/SpaceSearchViewModel;", "pickerNotifyListener", "Lcom/bytedance/ee/bear/search/picker/DocPickerNotifyListener;", "folderInfo", "Lcom/bytedance/ee/bear/search/FolderInfo;", "Landroid/view/View;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "getPickerConfig", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "initFilterView", "initViewModel", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "doSearch", "searchReloader", "Lcom/bytedance/ee/bear/search/picker/filter/base/SearchReloader;", "changeConfig", "onBackClick", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SpaceSearchPickerFragment extends BaseSearchPickerFragment {
    public static final /* synthetic */ int j = 0;
    public Picker e;
    public PickerConfig f;
    public com.bytedance.ee.bear.search.picker.filter.b g;
    public com.bytedance.ee.bear.search.picker.a h;
    public com.bytedance.ee.bear.search.a i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment, com.bytedance.ee.bear.search.picker.filter.a
    public final void K30() {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final View V90() {
        FragmentActivity r0 = getActivity();
        String r1 = null;
        if (r0 == null) goto L17;
        Picker r2 = new Picker(r0);
        r2.scene(PickerStatistics.Scene.CcmSearchInSpace);
        Intrinsics.checkNotNullParameter(r0, "fragmentActivity");
        Context r3 = getContext();
        if (r3 != null) goto L15;
    L13:
        this.h = new com.bytedance.ee.bear.search.picker.a(this, true);
        final DocTypes r4 = b.a();
        tt5.a.h("SpaceSearchPickerFragment", "getPickerConfig, initial search, docTypes=" + r4.getTypes());
        PickerConfig r5 = new PickerConfig(new Dependency(r0, r0.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r5.searcher(new SpaceSearchPickerFragment$getPickerConfig$config$1$1(this, r4));
        r5.extra(new SpaceSearchPickerFragment$getPickerConfig$config$1$2(this));
        r5.recommendList(new SpaceSearchPickerFragment$getPickerConfig$config$1$3(this, r4));
        this.f = r5;
        r2.init(r5);
        this.e = r2;
        return r2;
    L15:
        Gson r6 = new Gson();     // Catch: Exception -> L11
        Bundle r7 = getArguments();     // Catch: Exception -> L11
        if (r7 == null) goto L9;
        r1 = r7.getString("KEY_FOLDER_INFO");     // Catch: Exception -> L11
    L9:
        this.i = (com.bytedance.ee.bear.search.a) r6.fromJson(r1, com.bytedance.ee.bear.search.a.class);     // Catch: Exception -> L11
    L12:
        com.bytedance.ee.bear.search.picker.filter.b r8 = new com.bytedance.ee.bear.search.picker.filter.b(this.i, r3);
        this.g = r8;
        r8.setListener(this);
    L11:
        tt5.a.d("SpaceSearchPickerFragment", "parse folder info err");
        goto L12
    L17:
        return null;
    }

    public SpaceSearchPickerFragment() {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment, com.bytedance.ee.bear.search.picker.filter.a
    public final void M60(e r3) {
        PickerConfig r0 = this.f;
        if (r0 == null) goto L6;
        if (r3 == null) goto L6;
        r3.c(r0);
    L6:
        tt5.a.h("SpaceSearchPickerFragment", "change params, reload search, reloader : " + r3);
        Picker r4 = this.e;
        if (r4 == null) goto L10;
        r4.reload(true, true);
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L5;
        SpaceSearchViewModel r5 = (SpaceSearchViewModel) ViewModelProviders.of(r4).get(SpaceSearchViewModel.class);
    L6:
        if (r5 == null) goto L10;
        MutableLiveData<ArrayList<com.bytedance.ee.bear.search.picker.filter.type.e>> r6 = r5.getDocTypeSelectItem();
        if (r6 == null) goto L10;
        r6.observe(getViewLifecycleOwner(), new c(this));
    L10:
        com.bytedance.ee.bear.search.picker.filter.b r7 = this.g;
        if (r7 == null) goto L16;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L17;
        r8.width = -1;
        r8.height = n.d(44);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r1 != 4) goto L7;
        ArrayList<String> r4 = r3.getStringArrayListExtra("KEY_WIKI_SPACE_INFO");
        com.bytedance.ee.bear.search.picker.filter.b r5 = this.g;
        if (r5 == null) goto L33;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        r5.setWikiSpaceList(r4);
        return;
    L33:
        return;
    L7:
        if (r1 != 5) goto L9;
        Serializable r6 = r3.getSerializableExtra("KEY_FOLDER_INFOS");
        com.bytedance.ee.bear.search.picker.filter.b r7 = this.g;
        if (r7 == null) goto L31;
        r7.setFolderList(r6);
        return;
    L31:
        return;
    L9:
        if (r1 != 4097) goto L11;
        com.bytedance.ee.bear.search.picker.filter.b r8 = this.g;
        if (r8 == null) goto L29;
        r8.setOwnerList(r3.getSerializableExtra("EXTRA_OWNER_INFO"));
        return;
    L29:
        return;
    L11:
        if (r1 != 4098) goto L34;
        com.bytedance.ee.bear.search.picker.filter.b r9 = this.g;
        if (r9 == null) goto L27;
        r9.setChatList(r3.getSerializableExtra("EXTRA_CHAT_INFO"));
        return;
    L27:
        return;
    }
}

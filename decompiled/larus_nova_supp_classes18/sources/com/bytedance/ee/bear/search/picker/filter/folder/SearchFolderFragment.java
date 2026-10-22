package com.bytedance.ee.bear.search.picker.filter.folder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.search.SelectFolderConfig;
import com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.config.ConfigKt;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/folder/SearchFolderFragment;", "Lcom/bytedance/ee/bear/search/picker/BaseSearchPickerFragment;", "<init>", "()V", "pickerNotifyListener", "Lcom/bytedance/ee/bear/search/picker/filter/folder/FolderPickerNotifyListener;", "picker", "Lcom/ss/android/lark/picker/NavPicker;", "selectedFolderList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchSpaceInfo;", "Lkotlin/collections/ArrayList;", "getSelectedFolderList", "()Ljava/util/ArrayList;", "setSelectedFolderList", "(Ljava/util/ArrayList;)V", "multipleSelect", "", "getMultipleSelect", "()Z", "setMultipleSelect", "(Z)V", "selectFolderPickerConfig", "Lcom/bytedance/ee/bear/search/SelectFolderConfig;", "trigger", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "getPicker", "Landroid/view/View;", "getPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "itemClick", "", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "confirmResult", "isConfirm", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchFolderFragment extends BaseSearchPickerFragment {
    public static final /* synthetic */ int j = 0;
    public com.bytedance.ee.bear.search.picker.filter.folder.a e;
    public ArrayList<SearchSpaceInfo> f;
    public boolean g;
    public SelectFolderConfig h;
    public com.bytedance.ee.bear.wikiv2.searchv2.a i;

    public static final class a {
        public static SearchFolderFragment a(Context r2, Serializable r3, SelectFolderConfig r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "selectedFolders");
            Intrinsics.checkNotNullParameter(r4, "selectFolderConfig");
            Bundle r0 = new Bundle();
            r0.putSerializable("EXTRA_SELECTED_FOLDER", r3);
            r0.putSerializable("EXTRA_FOLDER_PICKER_CONFIG", r4);
            SearchFolderFragment r5 = Fragment.instantiate(r2, SearchFolderFragment.class.getName(), r0);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.search.picker.filter.folder.SearchFolderFragment");
            return r5;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Doc.Type.values().length];
            r0[Doc.Type.FOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final View V90() {
    L24:
        tt5.a.d("SearchFolderFragment", "parse selected folder error");
    L26:
        if (hu5.a.d(this.f) == false) goto L28;
    L30:
        boolean r1 = false;
    L31:
        this.g = r1;
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L37;
        NavPicker r3 = new NavPicker(r2, null, 2, null);
        r3.scene(this.h.getScene());
        Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
        this.e = new com.bytedance.ee.bear.search.picker.filter.folder.a(this, this.h.getUseDefaultClick());
        r3.init(ConfigKt.navPickerConfig(new Dependency(r2, r2.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()), new SearchFolderFragment$getPickerConfig$pickerConfig$1(this)));
        return r3;
    L37:
        return null;
    L28:
        if (this.h.isMultipleSelect() == false) goto L30;
        r1 = true;
        goto L31
    L5:
        if ((getContext() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L8;
        Object r4 = getContext();     // Catch: Exception -> L24
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.searchv2.IOpenPageSelectTrigger");     // Catch: Exception -> L24
        this.i = (com.bytedance.ee.bear.wikiv2.searchv2.a) r4;     // Catch: Exception -> L24
    L8:
        if (ForsetiHelper.p() == true) goto L10;
    L14:
        Bundle r5 = getArguments();     // Catch: Exception -> L24
        if (r5 == null) goto L17;
        Serializable r6 = r5.getSerializable("EXTRA_FOLDER_PICKER_CONFIG");     // Catch: Exception -> L24
    L18:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.search.SelectFolderConfig");     // Catch: Exception -> L24
        this.h = (SelectFolderConfig) r6;     // Catch: Exception -> L24
        Bundle r7 = getArguments();     // Catch: Exception -> L24
        if (r7 == null) goto L21;
        Serializable r8 = r7.getSerializable("EXTRA_SELECTED_FOLDER");     // Catch: Exception -> L24
    L22:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type java.util.ArrayList<com.ss.android.lark.search.dto.info.SearchSpaceInfo>");     // Catch: Exception -> L24
        this.f = (ArrayList) r8;     // Catch: Exception -> L24
        goto L26
    L21:
        r8 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L10:
        if (this.i != null) goto L14;
        if ((getParentFragment() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L14;
        com.bytedance.ee.bear.wikiv2.searchv2.a r9 = getParentFragment();     // Catch: Exception -> L24
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.searchv2.IOpenPageSelectTrigger");     // Catch: Exception -> L24
        this.i = r9;     // Catch: Exception -> L24
        goto L14
    }

    public SearchFolderFragment() {
        this.f = new ArrayList();
        this.h = new SelectFolderConfig(null, false, null, false, false, 31, null);
    }

    public final void W90(boolean r3) {
        if (r3 == false) goto L4;
    L6:
        Intent r4 = new Intent();
        r4.putExtra("KEY_FOLDER_INFOS", this.f);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        r0.setResult(5, r4);
    L9:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L13;
        r5.finish();
        return;
    L13:
        return;
    L4:
        if (this.g == false) goto L6;
    }
}

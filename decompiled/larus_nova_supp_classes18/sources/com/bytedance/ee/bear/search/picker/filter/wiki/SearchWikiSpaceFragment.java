package com.bytedance.ee.bear.search.picker.filter.wiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.config.ConfigKt;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0011J\b\u0010!\u001a\u00020\u001fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/wiki/SearchWikiSpaceFragment;", "Lcom/bytedance/ee/bear/search/picker/BaseSearchPickerFragment;", "<init>", "()V", "pickerNotifyListener", "Lcom/bytedance/ee/bear/search/picker/filter/wiki/WikiPickerNotifyListener;", "picker", "Lcom/ss/android/lark/picker/NavPicker;", "selectedWikiSpaceList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchWikiSpaceInfo;", "Lkotlin/collections/ArrayList;", "getSelectedWikiSpaceList", "()Ljava/util/ArrayList;", "setSelectedWikiSpaceList", "(Ljava/util/ArrayList;)V", "multipleSelect", "", "getMultipleSelect", "()Z", "setMultipleSelect", "(Z)V", "wikiIRecommendPuller", "Lcom/bytedance/ee/bear/search/picker/filter/wiki/WikiSpaceRecommendPuller;", "getPicker", "Landroid/view/View;", "getPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "activity", "Landroidx/fragment/app/FragmentActivity;", "confirmResult", "", "isConfirm", "onDestroy", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchWikiSpaceFragment extends BaseSearchPickerFragment {
    public static final /* synthetic */ int i = 0;
    public com.bytedance.ee.bear.search.picker.filter.wiki.a e;
    public ArrayList<SearchWikiSpaceInfo> f;
    public boolean g;
    public g h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final View V90() {
        Bundle r1 = getArguments();     // Catch: Exception -> L9
        if (r1 == null) goto L6;
        Serializable r2 = r1.getSerializable("EXTRA_SELECTED_WIKI");     // Catch: Exception -> L9
    L7:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.util.ArrayList<com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo>");     // Catch: Exception -> L9
        this.f = (ArrayList) r2;     // Catch: Exception -> L9
    L10:
        this.g = !hu5.a.d(this.f);
        final FragmentActivity r3 = getActivity();
        if (r3 == null) goto L16;
        NavPicker r4 = new NavPicker(r3, null, 2, null);
        r4.scene(PickerStatistics.Scene.CcmFilterByWikiSpace);
        Intrinsics.checkNotNullParameter(r3, "activity");
        this.e = new com.bytedance.ee.bear.search.picker.filter.wiki.a(this);
        final g r0 = new g();
        this.h = r0;
        r4.init(ConfigKt.navPickerConfig(new Dependency(r3, r3.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()), new SearchWikiSpaceFragment$getPickerConfig$pickerConfig$1(this, r0, r3)));
        return r4;
    L16:
        return null;
    L6:
        r2 = null;
    L9:
        tt5.a.d("SearchWikiFragment", "parse selected wikispace error");
        goto L10
    }

    public SearchWikiSpaceFragment() {
        this.f = new ArrayList();
    }

    public final void onDestroy() {
        super.onDestroy();
        g r0 = this.h;
        if (r0 == null) goto L6;
        r0.a.clear();
        return;
    }

    public final void W90(boolean r3) {
        if (r3 == false) goto L4;
    L6:
        Intent r4 = new Intent();
        r4.putExtra("KEY_WIKI_SPACE_INFO", this.f);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        r0.setResult(4, r4);
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

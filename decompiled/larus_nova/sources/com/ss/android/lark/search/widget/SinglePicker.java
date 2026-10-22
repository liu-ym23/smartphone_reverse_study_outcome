package com.ss.android.lark.search.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.recommend.DefaultRecommendView;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.params.BasePickerParams;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.service.SearchContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\rJ\b\u0010!\u001a\u00020\u0015H\u0016J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0018J \u0010$\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0015H\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/search/widget/SinglePicker;", "Lcom/ss/android/lark/picker/base/widget/BasePicker;", "Lcom/ss/android/lark/search/widget/params/OpenSearchPickerParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRecommendView", "Lcom/ss/android/lark/picker/base/view/recommend/DefaultRecommendView;", "mDataPuller", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "mOnSinglePickNotify", "Lcom/ss/android/lark/search/widget/SinglePicker$IOnSinglePickNotify;", "transformByPickerParams", "Lcom/ss/android/lark/search/dto/service/SearchContext;", "searchContext", "pickerParams", "onSearchSuccess", "", "infoList", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onBackPressed", "", "attachComplete", "initDefaultView", "attachOnSinglePickerNotify", "singlePickNotify", "attachDataPuller", "dataPuller", "refreshDefault", "onSingleChoiceClick", "data", "doItemClick", "isSelected", "position", "", "onResume", "IOnSinglePickNotify", "search-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SinglePicker extends BasePicker<k4c.c, SinglePicker> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f440365b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultRecommendView f440366a;

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public final void refreshDefault() {
        DefaultRecommendView.refreshSelected$default(this.f440366a, getSelectedList(), false, 2, null);
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public final void attachComplete() {
        super.attachComplete();
        DefaultRecommendView r100 = this.f440366a;
        if (r100.getParent() != null) goto L5;
        r100.erasePadding();
        getMDefaultViewContainer().addView(r100);
        r100.setDataPuller(null);
        r100.setProfileClickListener(new g(this));
        r100.setClickHandler(new h(this));
        r100.setScene(getScene());
        r100.setDisableRightViewHolder(getDisableRightViewHolder());
        r100.updateErrorView(R.drawable.illustration_placeholder_common_default, R.string.Lark_Search_UseKeyWordToSearch);
        r100.showDivider(true);
        r100.setSingleChoiceMode(true);
        DefaultRecommendView.refresh$default(r100, false, true, true, false, false, 25, null);
    L5:
        SearchResultView r101 = getMSearchResultView();
        r101.setDisableRightViewHolder(getDisableRightViewHolder());
        r101.showDivider(true);
        r101.setSingleChoiceMode(true);
        defaultMode(getMSoftInputInitPopup());
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        boolean r100 = !getSelectedList().isEmpty();
        super.onResume();
        if (r100 == false) goto L6;
        getSelectedList().isEmpty();
        return;
    }

    public SinglePicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public final void onSearchSuccess(List<SearchBaseInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "infoList");
        SearchBaseInfo r101 = (SearchBaseInfo) CollectionsKt.firstOrNull(getSelectedList());
        if (r101 == null) goto L18;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((SearchBaseInfo) r103).getId(), r101.getId()) == false) goto L6;
    L11:
        SearchBaseInfo r104 = (SearchBaseInfo) r103;
        if (r104 == null) goto L19;
        r104.setSingleChoice(true);
        return;
    L19:
        return;
    L10:
        r103 = null;
        goto L11
    }

    public SinglePicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        DefaultRecommendView r102 = new DefaultRecommendView(getContext());
        r102.grayTitleColor();
        this.f440366a = r102;
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public final SearchContext transformByPickerParams(SearchContext r100, BasePickerParams r101) {
        k4c.c r102 = (k4c.c) r101;
        Intrinsics.checkNotNullParameter(r100, "searchContext");
        r100.a(Scene.Type.SEARCH_PLATFORM_FILTER_SCENE);
        return r100;
    }

    @Override // com.ss.android.lark.picker.base.widget.BasePicker
    public final void doItemClick(SearchBaseInfo r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
    }
}

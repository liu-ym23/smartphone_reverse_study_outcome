package com.bytedance.ee.bear.bitable.filtersortviewsetting;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0005J\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\nJ\b\u0010\u0016\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/FilterSortViewSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mCurrTab", "Landroidx/lifecycle/MutableLiveData;", "", "mAllTabs", "", "mDelegate", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/IFilterSortViewSettingDelegate;", "mTopBarButton", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;", "getCurrentTab", "getAllTabs", "getTopBarButton", "getTabInfoList", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/FilterSortViewSettingViewModel$TabInfo;", "allTabs", "setDelegate", "", "delegate", "getDelegate", "Companion", "TabInfo", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterSortViewSettingViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "FilterSortViewSettingViewModel";
    private final MutableLiveData<List<String>> mAllTabs;
    private final MutableLiveData<String> mCurrTab;
    private f mDelegate;
    private final MutableLiveData<PanelData.TopBarButton> mTopBarButton;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f212130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f212131b;

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f212130a = r100;
            this.f212131b = r101;
        }
    }

    static {
        Companion = new a();
    }

    public FilterSortViewSettingViewModel() {
        this.mCurrTab = new MutableLiveData("");
        this.mAllTabs = new MutableLiveData(CollectionsKt.emptyList());
        this.mTopBarButton = new MutableLiveData(new PanelData.TopBarButton("", PanelData.TopBarButtonStatus.STATUS_HIDE.getStatus(), ""));
    }

    public final MutableLiveData<List<String>> getAllTabs() {
        return this.mAllTabs;
    }

    public final MutableLiveData<String> getCurrentTab() {
        return this.mCurrTab;
    }

    public final f getDelegate() {
        return this.mDelegate;
    }

    public final MutableLiveData<PanelData.TopBarButton> getTopBarButton() {
        return this.mTopBarButton;
    }

    public final List<b> getTabInfoList(List<String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L29;
        String r103 = (String) r102.next();
        int r104 = r103.hashCode();
        if (r104 == (-1274492040)) goto L24;
        if (r104 == (-311985482)) goto L20;
        if (r104 == 3536286) goto L16;
    L25:
        tt5.a.h(TAG, "unknown tab item=".concat(r103));
        b r105 = null;
    L27:
        if (r105 == null) goto L7;
        r101.add(r105);
        goto L7
    L16:
        if (r103.equals("sort") == false) goto L25;
        r105 = new b("sort", UIHelper.getString(R.string.Doc_List_SortBy));
        goto L27
    L20:
        if (r103.equals(PanelData.TAB_VIEW_SETTING) == false) goto L25;
        r105 = new b(PanelData.TAB_VIEW_SETTING, UIHelper.getString(R.string.Bitable_Mobile_CardMode_Layout_Button));
        goto L27
    L24:
        if (r103.equals("filter") == false) goto L25;
        r105 = new b("filter", UIHelper.getString(R.string.LarkCCM_NewCM_Filter_Button));
        goto L27
    L29:
        return r101;
    }

    public final void setDelegate(f r100) {
        this.mDelegate = r100;
    }
}

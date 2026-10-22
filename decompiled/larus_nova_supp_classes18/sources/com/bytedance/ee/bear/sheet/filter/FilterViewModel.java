package com.bytedance.ee.bear.sheet.filter;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0003,-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001c\u001a\u00020\u0019J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J=\u0010#\u001a\u00020\u0019\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u001e2\u0006\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u0002H$2\b\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010+R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel;", "Lcom/bytedance/ee/bear/edit/component/document/BaseEditPanelViewModel;", "<init>", "()V", "filterData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/sheet/filter/FilterData;", "getFilterData", "()Landroidx/lifecycle/MutableLiveData;", "delegate", "Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel$Delegate;)V", "filterPageData", "Lcom/bytedance/ee/bear/sheet/filter/FilterPageData;", "getFilterPageData", "filterValueDelegate", "Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel$FilterValueDelegate;", "getFilterValueDelegate", "()Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel$FilterValueDelegate;", "setFilterValueDelegate", "(Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel$FilterValueDelegate;)V", "updateFilterData", "", "clearFilterData", "updateFilterPageData", "clearFilterPageData", "getPanelName", "", "getPanelHeight", "", "context", "Landroid/content/Context;", "callback", "T", ResourceData.KEY_ID, "sheetId", "currentCol", "value", "isSearch", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/Boolean;)V", "Delegate", "FilterValueDelegate", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterViewModel extends BaseEditPanelViewModel {
    public static final a Companion = null;
    private static final String PANEL_NAME = "filter";
    private b delegate;
    private final MutableLiveData<FilterData> filterData;
    private final MutableLiveData<FilterPageData> filterPageData;
    private c filterValueDelegate;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        <T> void a(String r1, String r2, int r3, T r4, Boolean r5);
    }

    public interface c {
        void a(int r1, String r2, int r3);
    }

    static {
        Companion = new a();
    }

    public String getPanelName() {
        return PANEL_NAME;
    }

    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
    }

    public final void clearFilterData() {
        this.filterData.setValue(null);
    }

    public final void clearFilterPageData() {
        this.filterPageData.setValue(null);
    }

    public FilterViewModel() {
        this.filterData = new MutableLiveData();
        this.filterPageData = new MutableLiveData();
    }

    public final b getDelegate() {
        return this.delegate;
    }

    public final MutableLiveData<FilterData> getFilterData() {
        return this.filterData;
    }

    public final MutableLiveData<FilterPageData> getFilterPageData() {
        return this.filterPageData;
    }

    public final c getFilterValueDelegate() {
        return this.filterValueDelegate;
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public int getPanelHeight(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r2.getResources().getDimensionPixelSize(2131168161);
    }

    public final void setDelegate(b r1) {
        this.delegate = r1;
    }

    public final void setFilterValueDelegate(c r1) {
        this.filterValueDelegate = r1;
    }

    public final void updateFilterData(FilterData r2) {
        Intrinsics.checkNotNullParameter(r2, "filterData");
        this.filterData.setValue(r2);
    }

    public final void updateFilterPageData(FilterPageData r2) {
        this.filterPageData.setValue(r2);
    }

    public final <T> void callback(String r8, String r9, int r10, T r11, Boolean r12) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_ID);
        b r1 = this.delegate;
        if (r1 == null) goto L6;
        r1.a(r8, r9, r10, r11, r12);
        return;
    }
}

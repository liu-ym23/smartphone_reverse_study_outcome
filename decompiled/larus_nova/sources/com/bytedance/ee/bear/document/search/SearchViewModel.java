package com.bytedance.ee.bear.document.search;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.larus.nova.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes16.dex */
public class SearchViewModel extends BaseEditPanelViewModel {
    public static final int CLOSE_SEARCH = -1;
    private static final String JS_PANEL_NAME = "search";
    private static final String TAG = "SearchViewModel";
    private Set<a> closeKeyboardOnDestroyInterceptorSet;
    private MutableLiveData<Integer> currentIndex;
    private b delegate;
    private MutableLiveData<Integer> total;

    public interface a {
        boolean intercept();
    }

    public interface b {
        boolean a();

        void b();

        void c(int r100);

        void d(String r100, boolean r101);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return "search";
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r100, g45.a r101) {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r100, g45.a r101) {
    }

    void clearSearchResult() {
        b r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public MutableLiveData<Integer> getCurrentIndex() {
        if (this.currentIndex != null) goto L6;
        this.currentIndex = new MutableLiveData();
    L6:
        return this.currentIndex;
    }

    public MutableLiveData<Integer> getTotal() {
        if (this.total != null) goto L6;
        this.total = new MutableLiveData();
    L6:
        return this.total;
    }

    public boolean isAtVc() {
        b r100 = this.delegate;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.a();
    }

    public boolean shouldCloseKeyboardOnDestroy() {
        Iterator<a> r100 = this.closeKeyboardOnDestroyInterceptorSet.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().intercept() == false) goto L4;
        return false;
    L9:
        return true;
    }

    public SearchViewModel() {
        this.closeKeyboardOnDestroyInterceptorSet = new HashSet();
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onDetachFromUI() {
        super.onDetachFromUI();
        this.delegate = null;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public void addCloseKeyboardOnDestroyInterceptor(a r100) {
        if (r100 == null) goto L5;
        this.closeKeyboardOnDestroyInterceptorSet.add(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r100) {
        return r100.getResources().getDimensionPixelSize(R.dimen.searchbar_height);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onKeyboardStateChanged(int r100) {
        super.onKeyboardStateChanged(r100);
        if (this.editPanelsManager != null) goto L5;
        return;
    L5:
        if (Boolean.TRUE.equals(getActive().getValue()) == false) goto L9;
        this.editPanelsManager.requestUpdateWebContentHeight();
        return;
    }

    public void removeCloseKeyboardOnDestroyInterceptor(a r100) {
        if (r100 == null) goto L5;
        this.closeKeyboardOnDestroyInterceptorSet.remove(r100);
        return;
    }

    public void setDelegate(b r100) {
        this.delegate = r100;
    }

    public void switchResult(int r100) {
        b r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    void search(String r100, boolean r101) {
        b r102 = this.delegate;
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    public void updateSearchResult(int r100, int r101) {
        setActive(true);
        getCurrentIndex().setValue(Integer.valueOf(r100));
        getTotal().setValue(Integer.valueOf(r101));
    }
}

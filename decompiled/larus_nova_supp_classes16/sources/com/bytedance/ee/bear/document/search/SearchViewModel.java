package com.bytedance.ee.bear.document.search;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        void c(int r1);

        void d(String r1, boolean r2);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return JS_PANEL_NAME;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
    }

    void clearSearchResult() {
        b r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.b();
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
        b r0 = this.delegate;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a();
    }

    public boolean shouldCloseKeyboardOnDestroy() {
        Iterator<a> r0 = this.closeKeyboardOnDestroyInterceptorSet.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().intercept() == false) goto L4;
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

    public void addCloseKeyboardOnDestroyInterceptor(a r2) {
        if (r2 == null) goto L5;
        this.closeKeyboardOnDestroyInterceptorSet.add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r2) {
        return r2.getResources().getDimensionPixelSize(2131168131);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel
    public void onKeyboardStateChanged(int r2) {
        super.onKeyboardStateChanged(r2);
        if (this.editPanelsManager != null) goto L5;
        return;
    L5:
        if (Boolean.TRUE.equals(getActive().getValue()) == false) goto L9;
        this.editPanelsManager.requestUpdateWebContentHeight();
        return;
    }

    public void removeCloseKeyboardOnDestroyInterceptor(a r2) {
        if (r2 == null) goto L5;
        this.closeKeyboardOnDestroyInterceptorSet.remove(r2);
        return;
    }

    public void setDelegate(b r1) {
        this.delegate = r1;
    }

    public void switchResult(int r2) {
        b r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    void search(String r2, boolean r3) {
        b r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }

    public void updateSearchResult(int r2, int r3) {
        setActive(true);
        getCurrentIndex().setValue(Integer.valueOf(r2));
        getTotal().setValue(Integer.valueOf(r3));
    }
}

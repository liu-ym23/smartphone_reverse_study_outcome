package com.bytedance.ee.bear.document.customheader;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "delegate", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/document/customheader/CustomHeaderViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/document/customheader/CustomHeaderViewModel$Delegate;)V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "headerData", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "getHeaderData", "isCustomHeaderVisible", "isStatusBarImmersive", "statusBarDiffHeight", "", "getStatusBarDiffHeight", "Delegate", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomHeaderViewModel extends ViewModel {
    private final MutableLiveData<Boolean> active;
    private a delegate;
    private final MutableLiveData<CustomHeaderConfig> headerData;
    private final MutableLiveData<Boolean> isCustomHeaderVisible;
    private final MutableLiveData<Boolean> isStatusBarImmersive;
    private final MutableLiveData<Integer> statusBarDiffHeight;

    public interface a {
        void a(String r100, String r101);
    }

    public CustomHeaderViewModel() {
        this.active = new MutableLiveData();
        this.headerData = new MutableLiveData();
        this.isCustomHeaderVisible = new MutableLiveData();
        this.isStatusBarImmersive = new MutableLiveData();
        this.statusBarDiffHeight = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final a getDelegate() {
        return this.delegate;
    }

    public final MutableLiveData<CustomHeaderConfig> getHeaderData() {
        return this.headerData;
    }

    public final MutableLiveData<Integer> getStatusBarDiffHeight() {
        return this.statusBarDiffHeight;
    }

    public final MutableLiveData<Boolean> isCustomHeaderVisible() {
        return this.isCustomHeaderVisible;
    }

    public final MutableLiveData<Boolean> isStatusBarImmersive() {
        return this.isStatusBarImmersive;
    }

    public final void setDelegate(a r100) {
        this.delegate = r100;
    }
}

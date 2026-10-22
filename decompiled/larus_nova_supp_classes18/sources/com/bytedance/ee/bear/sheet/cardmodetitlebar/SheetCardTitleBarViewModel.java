package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "navBar", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/CardNavBarData;", "getNavBar", "delegate", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarViewModel$Delegate;)V", "Delegate", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetCardTitleBarViewModel extends ViewModel {
    private final MutableLiveData<Boolean> active;
    private a delegate;
    private final MutableLiveData<CardNavBarData> navBar;

    public interface a {
        void a(String r1);
    }

    public SheetCardTitleBarViewModel() {
        this.active = new MutableLiveData();
        this.navBar = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final a getDelegate() {
        return this.delegate;
    }

    public final MutableLiveData<CardNavBarData> getNavBar() {
        return this.navBar;
    }

    public final void setDelegate(a r1) {
        this.delegate = r1;
    }
}

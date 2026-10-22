package com.bytedance.ee.bear.list.recent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\fJ\r\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/list/recent/OfficeRecentFilterViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "tabTypeLiveDataInternal", "Landroidx/lifecycle/MutableLiveData;", "", "tabTypeLiveData", "Landroidx/lifecycle/LiveData;", "getTabTypeLiveData", "()Landroidx/lifecycle/LiveData;", "updateTabType", "", "tabType", "clearTabType", "currentTabType", "()Ljava/lang/Integer;", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeRecentFilterViewModel extends ViewModel {
    private static final int ALL_TAB_TYPE = 0;
    public static final a Companion = null;
    private final LiveData<Integer> tabTypeLiveData;
    private final MutableLiveData<Integer> tabTypeLiveDataInternal;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static Integer a(Integer r100) {
            if (r100 != null) goto L4;
        L9:
            return null;
        L4:
            if (r100.intValue() <= 0) goto L6;
            boolean r101 = true;
        L7:
            if (r101 == false) goto L9;
            return r100;
        L6:
            r101 = false;
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final Integer normalizeServerTabType(Integer r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public final void clearTabType() {
        this.tabTypeLiveDataInternal.setValue(null);
    }

    public final Integer currentTabType() {
        return this.tabTypeLiveDataInternal.getValue();
    }

    public OfficeRecentFilterViewModel() {
        MutableLiveData<Integer> r100 = new MutableLiveData();
        this.tabTypeLiveDataInternal = r100;
        this.tabTypeLiveData = r100;
    }

    public final LiveData<Integer> getTabTypeLiveData() {
        return this.tabTypeLiveData;
    }

    public final void updateTabType(int r100) {
        MutableLiveData<Integer> r101 = this.tabTypeLiveDataInternal;
        a r102 = Companion;
        Integer r103 = Integer.valueOf(r100);
        r102.getClass();
        r101.setValue(a.a(r103));
    }
}

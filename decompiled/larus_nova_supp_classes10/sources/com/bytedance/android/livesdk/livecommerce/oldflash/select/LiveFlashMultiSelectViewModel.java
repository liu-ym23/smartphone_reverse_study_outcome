package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\nR \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00108\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00108\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashMultiSelectViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/a;", "selectRepository", "", "setSelectRepository", "initOriginData", "", "selectedItemData", "selectOrUnSelectItem", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/a;", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/k;", "_currentStringListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "currentStringListLiveData", "Landroidx/lifecycle/LiveData;", "getCurrentStringListLiveData", "()Landroidx/lifecycle/LiveData;", "_dataListLiveData", "dataListLiveData", "getDataListLiveData", "", "_dismissLiveData", "dismissLiveData", "getDismissLiveData", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashMultiSelectViewModel extends ECBaseViewModel {
    private final MutableLiveData<List<k>> _currentStringListLiveData;
    private final MutableLiveData<List<k>> _dataListLiveData;
    private final MutableLiveData<Boolean> _dismissLiveData;
    private final LiveData<List<k>> currentStringListLiveData;
    private final LiveData<List<k>> dataListLiveData;
    private final LiveData<Boolean> dismissLiveData;
    private a selectRepository;

    public final void initOriginData() {
        a r0 = this.selectRepository;
        if (r0 == null) goto L23;
        List<String> r1 = r0.b();
        if (r1 == null) goto L24;
        a r2 = this.selectRepository;
        if (r2 == null) goto L10;
        List<String> r3 = r2.a();
        if (r3 == null) goto L10;
    L11:
        ArrayList r4 = new ArrayList();
        MutableLiveData<List<k>> r5 = this._dataListLiveData;
        List<String> r6 = r1;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L18;
        String r9 = (String) r8.next();
        boolean r10 = r3.contains(r9);
        k r11 = new k(r9, r10);
        if (r10 == false) goto L17;
        r4.add(r11);
    L17:
        r7.add(r11);
        goto L13
    L18:
        r5.setValue(r7);
        this._currentStringListLiveData.setValue(r4);
        return;
    L10:
        r3 = CollectionsKt.emptyList();
        goto L11
    L24:
        return;
    }

    public LiveFlashMultiSelectViewModel() {
        MutableLiveData<List<k>> r0 = new MutableLiveData();
        this._currentStringListLiveData = r0;
        this.currentStringListLiveData = r0;
        MutableLiveData<List<k>> r1 = new MutableLiveData();
        this._dataListLiveData = r1;
        this.dataListLiveData = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData();
        this._dismissLiveData = r2;
        this.dismissLiveData = r2;
    }

    public final LiveData<List<k>> getCurrentStringListLiveData() {
        return this.currentStringListLiveData;
    }

    public final LiveData<List<k>> getDataListLiveData() {
        return this.dataListLiveData;
    }

    public final LiveData<Boolean> getDismissLiveData() {
        return this.dismissLiveData;
    }

    public final void selectOrUnSelectItem(String r5) {
        Intrinsics.checkNotNullParameter(r5, "selectedItemData");
        List r0 = (List) this._dataListLiveData.getValue();
        if (r0 == null) goto L10;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        k r2 = (k) r1.next();
        if (Intrinsics.areEqual(r2.a, r5) == false) goto L6;
        r2.b = !r2.b;
    L10:
        MutableLiveData<List<k>> r6 = this._dataListLiveData;
        r6.setValue(r6.getValue());
        MutableLiveData<List<k>> r7 = this._currentStringListLiveData;
        List r3 = (List) this._dataListLiveData.getValue();
        if (r3 == null) goto L18;
        ArrayList r4 = new ArrayList();
        Iterator r8 = r3.iterator();
    L14:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        if (((k) r9).b == false) goto L14;
        r4.add(r9);
    L19:
        r7.setValue(r4);
        return;
    L18:
        r4 = null;
        goto L19
    }

    public final void setSelectRepository(a r1) {
        this.selectRepository = r1;
    }
}

package com.bytedance.ee.bear.doc.structure.pad.viewmodel;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.doc.structure.pad.livedata.ActivityWidthChangeLiveData;
import com.ss.android.lark.base.embedded.e;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002J\u001c\u0010(\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002J\u001c\u0010)\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0.J\u0010\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\rJ\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060.J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\b0.J\f\u00103\u001a\b\u0012\u0004\u0012\u00020\b0.J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0.J\u0006\u00104\u001a\u00020%J\u0012\u00105\u001a\u00020%2\b\b\u0002\u00106\u001a\u00020\bH\u0007J\u0006\u00107\u001a\u00020%J\u0016\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020\bJ\b\u0010>\u001a\u00020%H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "catalogModeChangingLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogModeChanging;", "phoneToPadLiveData", "", "isOnEmbedLiveData", "isCatalogOpenLiveData", "kotlin.jvm.PlatformType", "activeCatalogItemLiveData", "", "activityWidthChangeLiveData", "Lcom/bytedance/ee/bear/doc/structure/pad/livedata/ActivityWidthChangeLiveData;", "kvStorage", "Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "getKvStorage", "()Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "setKvStorage", "(Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;)V", "repo", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "getRepo", "()Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "isFirstLoadKV", "<set-?>", "Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogMode;", "catalogMode", "getCatalogMode", "()Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogMode;", "setCatalogMode", "(Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogMode;)V", "catalogMode$delegate", "Lkotlin/properties/ReadWriteProperty;", "makeEmbedModeChangingLiveData", "", "old", "new", "makePadOrPhoneModeChangingLiveData", "makeCatalogModeChangingLiveData", "activityWidthChangeObserver", "Landroidx/lifecycle/Observer;", "", "getActiveCatalogItemLiveData", "Landroidx/lifecycle/LiveData;", "setActiveCatalogItem", "activeHash", "getCatalogModeLiveData", "isModeChangedToPadLiveData", "isEmbedModeChangedLiveData", "loadPreviousPreferenceOnce", "openOrCloseCatalogView", "enable", "closeCatalogOnInvalidPage", "observeWidthChange", "container", "Landroid/view/View;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isCatalogOpen", "onCleared", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogViewModel extends ViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    public static final String CATALOG_REPO = "DocCatalogRepo";
    private static final a Companion = null;
    public static final String KEY_PREVIOUS_CATALOG_OPEN = "KEY_PREVIOUS_CATALOG_OPEN";
    public static final String TAG = "CatalogViewModel";
    private final MutableLiveData<String> activeCatalogItemLiveData;
    private ActivityWidthChangeLiveData activityWidthChangeLiveData;
    private final Observer<Integer> activityWidthChangeObserver;
    private final ReadWriteProperty catalogMode$delegate;
    private final MutableLiveData<com.bytedance.ee.bear.doc.structure.pad.viewmodel.a> catalogModeChangingLiveData;
    private final MutableLiveData<Boolean> isCatalogOpenLiveData;
    private boolean isFirstLoadKV;
    private final MutableLiveData<Boolean> isOnEmbedLiveData;
    private by4.d kvStorage;
    private final MutableLiveData<Boolean> phoneToPadLiveData;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CatalogViewModel a;

        public b(CatalogViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            int r5 = ((Number) r4).intValue();
            int r0 = e.c;
            e r1 = e.a.b(com.larksuite.framework.utils.b.a, r5);
            CatalogViewModel r2 = this.a;
            if (r5 >= r1.a) goto L5;
        L10:
            CatalogMode r6 = CatalogMode.DIALOG;
        L11:
            CatalogViewModel.access$setCatalogMode(r2, r6);
            return;
        L5:
            if (r5 < r1.b) goto L10;
            if (r5 <= u0c.a.a(900)) goto L9;
            r6 = CatalogMode.EMBED;
            goto L11
        L9:
            r6 = CatalogMode.COVERAGE;
            goto L11
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CatalogViewModel a;

        public c(CatalogViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            CatalogMode r0 = this.a.getCatalogMode();
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (com.bytedance.ee.bear.doc.structure.pad.viewmodel.b.a(r0) != true) goto L7;
        L8:
            if (r1 == false) goto L12;
            CatalogViewModel.access$isOnEmbedLiveData$p(this.a).postValue(r4);
            return;
        L12:
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class d extends ObservableProperty<CatalogMode> {
        public final /* synthetic */ CatalogViewModel a;

        public d(CatalogViewModel r1) {
            this.a = r1;
            super(null);
        }

        public final void afterChange(KProperty<?> r2, CatalogMode r3, CatalogMode r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            CatalogMode r5 = r4;
            CatalogMode r6 = r3;
            if (r6 == r5) goto L7;
            CatalogViewModel.access$makeCatalogModeChangingLiveData(this.a, r6, r5);
            CatalogViewModel.access$makePadOrPhoneModeChangingLiveData(this.a, r6, r5);
            CatalogViewModel.access$makeEmbedModeChangingLiveData(this.a, r6, r5);
            tt5.a.h(CatalogViewModel.TAG, "catalogModeChanged, old: " + r6 + ", new: " + r5 + ", isPadMode=" + CatalogViewModel.access$getPhoneToPadLiveData$p(this.a).getValue());
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(CatalogViewModel.class, "catalogMode", "getCatalogMode()Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogMode;", 0))};
        Companion = new a();
    }

    public final void openOrCloseCatalogView() {
        openOrCloseCatalogView$default(this, false, 1, null);
    }

    private final KVRepo getRepo() {
        by4.d r0 = this.kvStorage;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(CATALOG_REPO);
    }

    public final void closeCatalogOnInvalidPage() {
        Boolean r0 = Boolean.FALSE;
        if (Intrinsics.areEqual(r0, this.isCatalogOpenLiveData.getValue()) == false) goto L5;
        return;
    L5:
        this.isCatalogOpenLiveData.postValue(r0);
    }

    public final CatalogMode getCatalogMode() {
        return (CatalogMode) this.catalogMode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean isCatalogOpen() {
        return Intrinsics.areEqual(this.isCatalogOpenLiveData.getValue(), Boolean.TRUE);
    }

    public final void loadPreviousPreferenceOnce() {
        if (this.isFirstLoadKV == true) goto L5;
        return;
    L5:
        boolean r0 = false;
        this.isFirstLoadKV = false;
        CatalogMode r1 = getCatalogMode();
        if (r1 == null) goto L10;
        boolean r2 = true;
        if (com.bytedance.ee.bear.doc.structure.pad.viewmodel.b.a(r1) != true) goto L10;
    L11:
        if (r2 == false) goto L17;
        KVRepo r3 = getRepo();
        if (r3 == null) goto L15;
        r0 = r3.getBoolean(KEY_PREVIOUS_CATALOG_OPEN, false);
    L15:
        tt5.a.h(TAG, "loadPreviousPreferenceOnce " + r0);
        openOrCloseCatalogView(r0);
        return;
    L17:
        return;
    L10:
        r2 = false;
        goto L11
    }

    public CatalogViewModel() {
        this.catalogModeChangingLiveData = new MutableLiveData();
        this.phoneToPadLiveData = new MutableLiveData();
        this.isOnEmbedLiveData = new MutableLiveData();
        this.isCatalogOpenLiveData = new MutableLiveData(Boolean.FALSE);
        this.activeCatalogItemLiveData = new MutableLiveData();
        this.isFirstLoadKV = true;
        Delegates r0 = Delegates.INSTANCE;
        this.catalogMode$delegate = new d(this);
        this.activityWidthChangeObserver = new b(this);
    }

    public void onCleared() {
        super.onCleared();
        ActivityWidthChangeLiveData r0 = this.activityWidthChangeLiveData;
        if (r0 == null) goto L5;
        r0.removeObserver(this.activityWidthChangeObserver);
    L5:
        this.activityWidthChangeLiveData = null;
    }

    public final LiveData<String> getActiveCatalogItemLiveData() {
        return this.activeCatalogItemLiveData;
    }

    public final LiveData<com.bytedance.ee.bear.doc.structure.pad.viewmodel.a> getCatalogModeLiveData() {
        return this.catalogModeChangingLiveData;
    }

    public final by4.d getKvStorage() {
        return this.kvStorage;
    }

    public final LiveData<Boolean> isCatalogOpenLiveData() {
        return this.isCatalogOpenLiveData;
    }

    public final LiveData<Boolean> isEmbedModeChangedLiveData() {
        return this.isOnEmbedLiveData;
    }

    public final LiveData<Boolean> isModeChangedToPadLiveData() {
        return this.phoneToPadLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$getPhoneToPadLiveData$p(CatalogViewModel r0) {
        return r0.phoneToPadLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$isOnEmbedLiveData$p(CatalogViewModel r0) {
        return r0.isOnEmbedLiveData;
    }

    private final void setCatalogMode(CatalogMode r4) {
        this.catalogMode$delegate.setValue(this, $$delegatedProperties[0], r4);
    }

    public final void openOrCloseCatalogView(boolean r3) {
        if (Intrinsics.areEqual(Boolean.valueOf(r3), this.isCatalogOpenLiveData.getValue()) == false) goto L5;
        return;
    L5:
        KVRepo r0 = getRepo();
        if (r0 == null) goto L8;
        r0.putBoolean(KEY_PREVIOUS_CATALOG_OPEN, r3);
    L8:
        this.isCatalogOpenLiveData.postValue(Boolean.valueOf(r3));
    }

    public final void setActiveCatalogItem(String r2) {
        this.activeCatalogItemLiveData.postValue(r2);
    }

    public final void setKvStorage(by4.d r1) {
        this.kvStorage = r1;
    }

    public static final /* synthetic */ void access$setCatalogMode(CatalogViewModel r0, CatalogMode r1) {
        r0.setCatalogMode(r1);
    }

    private final void makeCatalogModeChangingLiveData(CatalogMode r4, CatalogMode r5) {
        MutableLiveData<com.bytedance.ee.bear.doc.structure.pad.viewmodel.a> r0 = this.catalogModeChangingLiveData;
        com.bytedance.ee.bear.doc.structure.pad.viewmodel.a r1 = (com.bytedance.ee.bear.doc.structure.pad.viewmodel.a) r0.getValue();
        if (r1 != null) goto L5;
        r1 = new com.bytedance.ee.bear.doc.structure.pad.viewmodel.a(0);
    L5:
        r1.a = r4;
        r1.b = r5;
        r0.setValue(r1);
    }

    private final void makeEmbedModeChangingLiveData(CatalogMode r3, CatalogMode r4) {
        if (isCatalogOpen() == true) goto L5;
        return;
    L5:
        boolean r0 = true;
        if (r3 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r4 != null) goto L13;
    L15:
        r0 = false;
    L16:
        if (r5 == true) goto L19;
        if (r0 == true) goto L19;
        return;
    L19:
        this.isOnEmbedLiveData.postValue(Boolean.valueOf(r0));
        return;
    L13:
        if (com.bytedance.ee.bear.doc.structure.pad.viewmodel.b.a(r4) != true) goto L15;
    L8:
        if (com.bytedance.ee.bear.doc.structure.pad.viewmodel.b.a(r3) != true) goto L10;
        r5 = true;
        goto L11
    }

    private final void makePadOrPhoneModeChangingLiveData(CatalogMode r6, CatalogMode r7) {
        boolean r0 = false;
        Boolean r3 = null;
        if (r6 == null) goto L12;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r6 != CatalogMode.EMBED) goto L7;
    L10:
        boolean r8 = true;
    L11:
        Boolean r9 = Boolean.valueOf(r8);
    L13:
        if (r7 == null) goto L20;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7 != CatalogMode.EMBED) goto L17;
    L18:
        r0 = true;
    L19:
        r3 = Boolean.valueOf(r0);
        goto L20
    L17:
        if (r7 != CatalogMode.COVERAGE) goto L19;
    L20:
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r10) == false) goto L23;
    L25:
        Boolean r11 = Boolean.FALSE;
        if (Intrinsics.areEqual(r9, r11) == false) goto L28;
        return;
    L28:
        if (Intrinsics.areEqual(r3, r11) == false) goto L33;
        this.phoneToPadLiveData.postValue(r11);
        return;
    L33:
        return;
    L23:
        if (Intrinsics.areEqual(r3, r10) == false) goto L25;
        this.phoneToPadLiveData.postValue(r10);
        return;
    L7:
        if (r6 == CatalogMode.COVERAGE) goto L10;
        r8 = false;
        goto L11
    L12:
        r9 = null;
        goto L13
    }

    public final void observeWidthChange(View r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        ActivityWidthChangeLiveData r0 = this.activityWidthChangeLiveData;
        if (r0 != null) goto L5;
        r0 = new ActivityWidthChangeLiveData(new WeakReference(r3));
    L5:
        this.activityWidthChangeLiveData = r0;
        r0.observe(r4, this.activityWidthChangeObserver);
        this.isCatalogOpenLiveData.observe(r4, new c(this));
    }

    public static final /* synthetic */ void access$makeCatalogModeChangingLiveData(CatalogViewModel r0, CatalogMode r1, CatalogMode r2) {
        r0.makeCatalogModeChangingLiveData(r1, r2);
    }

    public static final /* synthetic */ void access$makeEmbedModeChangingLiveData(CatalogViewModel r0, CatalogMode r1, CatalogMode r2) {
        r0.makeEmbedModeChangingLiveData(r1, r2);
    }

    public static final /* synthetic */ void access$makePadOrPhoneModeChangingLiveData(CatalogViewModel r0, CatalogMode r1, CatalogMode r2) {
        r0.makePadOrPhoneModeChangingLiveData(r1, r2);
    }

    public static /* synthetic */ void openOrCloseCatalogView$default(CatalogViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L9;
        Boolean r4 = (Boolean) r0.isCatalogOpenLiveData.getValue();
        if (r4 == null) goto L7;
        boolean r5 = r4.booleanValue();
    L8:
        r1 = !r5;
        goto L9
    L7:
        r5 = false;
    L9:
        r0.openOrCloseCatalogView(r1);
    }
}

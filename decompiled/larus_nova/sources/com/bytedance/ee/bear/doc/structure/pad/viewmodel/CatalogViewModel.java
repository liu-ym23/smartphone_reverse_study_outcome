package com.bytedance.ee.bear.doc.structure.pad.viewmodel;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.doc.structure.pad.livedata.ActivityWidthChangeLiveData;
import com.facebook.keyframes.model.KFAnimation;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002J\u001c\u0010(\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002J\u001c\u0010)\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0.J\u0010\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\rJ\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060.J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\b0.J\f\u00103\u001a\b\u0012\u0004\u0012\u00020\b0.J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0.J\u0006\u00104\u001a\u00020%J\u0012\u00105\u001a\u00020%2\b\b\u0002\u00106\u001a\u00020\bH\u0007J\u0006\u00107\u001a\u00020%J\u0016\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020\bJ\b\u0010>\u001a\u00020%H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "catalogModeChangingLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogModeChanging;", "phoneToPadLiveData", "", "isOnEmbedLiveData", "isCatalogOpenLiveData", "kotlin.jvm.PlatformType", "activeCatalogItemLiveData", "", "activityWidthChangeLiveData", "Lcom/bytedance/ee/bear/doc/structure/pad/livedata/ActivityWidthChangeLiveData;", "kvStorage", "Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "getKvStorage", "()Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "setKvStorage", "(Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;)V", "repo", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "getRepo", "()Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "isFirstLoadKV", "<set-?>", "Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogMode;", "catalogMode", "getCatalogMode", "()Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogMode;", "setCatalogMode", "(Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogMode;)V", "catalogMode$delegate", "Lkotlin/properties/ReadWriteProperty;", "makeEmbedModeChangingLiveData", "", "old", "new", "makePadOrPhoneModeChangingLiveData", "makeCatalogModeChangingLiveData", "activityWidthChangeObserver", "Landroidx/lifecycle/Observer;", "", "getActiveCatalogItemLiveData", "Landroidx/lifecycle/LiveData;", "setActiveCatalogItem", "activeHash", "getCatalogModeLiveData", "isModeChangedToPadLiveData", "isEmbedModeChangedLiveData", "loadPreviousPreferenceOnce", "openOrCloseCatalogView", "enable", "closeCatalogOnInvalidPage", "observeWidthChange", KtvSubElement.CONTAINER, "Landroid/view/View;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isCatalogOpen", "onCleared", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CatalogViewModel f218259a;

        public b(CatalogViewModel r100) {
            this.f218259a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            int r101 = ((Number) r100).intValue();
            int r102 = e.f409753c;
            e r103 = e.a.b(com.larksuite.framework.utils.b.f285948a, r101);
            CatalogViewModel r104 = this.f218259a;
            if (r101 >= r103.f409754a) goto L5;
        L10:
            CatalogMode r105 = CatalogMode.DIALOG;
        L11:
            CatalogViewModel.access$setCatalogMode(r104, r105);
            return;
        L5:
            if (r101 < r103.f409755b) goto L10;
            if (r101 <= u0c.a.a(900)) goto L9;
            r105 = CatalogMode.EMBED;
            goto L11
        L9:
            r105 = CatalogMode.COVERAGE;
            goto L11
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CatalogViewModel f218260a;

        public c(CatalogViewModel r100) {
            this.f218260a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            CatalogMode r102 = this.f218260a.getCatalogMode();
            if (r102 == null) goto L7;
            boolean r103 = true;
            if (com.bytedance.ee.bear.doc.structure.pad.viewmodel.b.a(r102) != true) goto L7;
        L8:
            if (r103 == false) goto L12;
            CatalogViewModel.access$isOnEmbedLiveData$p(this.f218260a).postValue(r101);
            return;
        L12:
            return;
        L7:
            r103 = false;
            goto L8
        }
    }

    public static final class d extends ObservableProperty<CatalogMode> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CatalogViewModel f218261a;

        public d(CatalogViewModel r100) {
            this.f218261a = r100;
            super(null);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, CatalogMode r101, CatalogMode r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            CatalogMode r103 = r102;
            CatalogMode r104 = r101;
            if (r104 == r103) goto L7;
            CatalogViewModel.access$makeCatalogModeChangingLiveData(this.f218261a, r104, r103);
            CatalogViewModel.access$makePadOrPhoneModeChangingLiveData(this.f218261a, r104, r103);
            CatalogViewModel.access$makeEmbedModeChangingLiveData(this.f218261a, r104, r103);
            tt5.a.h(CatalogViewModel.TAG, "catalogModeChanged, old: " + r104 + ", new: " + r103 + ", isPadMode=" + CatalogViewModel.access$getPhoneToPadLiveData$p(this.f218261a).getValue());
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
        by4.d r100 = this.kvStorage;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b(CATALOG_REPO);
    }

    public final void closeCatalogOnInvalidPage() {
        Boolean r100 = Boolean.FALSE;
        if (Intrinsics.areEqual(r100, this.isCatalogOpenLiveData.getValue()) == false) goto L5;
        return;
    L5:
        this.isCatalogOpenLiveData.postValue(r100);
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
        boolean r100 = false;
        this.isFirstLoadKV = false;
        CatalogMode r101 = getCatalogMode();
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (com.bytedance.ee.bear.doc.structure.pad.viewmodel.b.a(r101) != true) goto L10;
    L11:
        if (r102 == false) goto L17;
        KVRepo r103 = getRepo();
        if (r103 == null) goto L15;
        r100 = r103.getBoolean(KEY_PREVIOUS_CATALOG_OPEN, false);
    L15:
        tt5.a.h(TAG, "loadPreviousPreferenceOnce " + r100);
        openOrCloseCatalogView(r100);
        return;
    L17:
        return;
    L10:
        r102 = false;
        goto L11
    }

    public CatalogViewModel() {
        this.catalogModeChangingLiveData = new MutableLiveData();
        this.phoneToPadLiveData = new MutableLiveData();
        this.isOnEmbedLiveData = new MutableLiveData();
        this.isCatalogOpenLiveData = new MutableLiveData(Boolean.FALSE);
        this.activeCatalogItemLiveData = new MutableLiveData();
        this.isFirstLoadKV = true;
        Delegates r100 = Delegates.INSTANCE;
        this.catalogMode$delegate = new d(this);
        this.activityWidthChangeObserver = new b(this);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        ActivityWidthChangeLiveData r100 = this.activityWidthChangeLiveData;
        if (r100 == null) goto L5;
        r100.removeObserver(this.activityWidthChangeObserver);
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

    public static final /* synthetic */ MutableLiveData access$getPhoneToPadLiveData$p(CatalogViewModel r100) {
        return r100.phoneToPadLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$isOnEmbedLiveData$p(CatalogViewModel r100) {
        return r100.isOnEmbedLiveData;
    }

    private final void setCatalogMode(CatalogMode r100) {
        this.catalogMode$delegate.setValue(this, $$delegatedProperties[0], r100);
    }

    public final void openOrCloseCatalogView(boolean r100) {
        if (Intrinsics.areEqual(Boolean.valueOf(r100), this.isCatalogOpenLiveData.getValue()) == false) goto L5;
        return;
    L5:
        KVRepo r101 = getRepo();
        if (r101 == null) goto L8;
        r101.putBoolean(KEY_PREVIOUS_CATALOG_OPEN, r100);
    L8:
        this.isCatalogOpenLiveData.postValue(Boolean.valueOf(r100));
    }

    public final void setActiveCatalogItem(String r100) {
        this.activeCatalogItemLiveData.postValue(r100);
    }

    public final void setKvStorage(by4.d r100) {
        this.kvStorage = r100;
    }

    public static final /* synthetic */ void access$setCatalogMode(CatalogViewModel r100, CatalogMode r101) {
        r100.setCatalogMode(r101);
    }

    private final void makeCatalogModeChangingLiveData(CatalogMode r100, CatalogMode r101) {
        MutableLiveData<com.bytedance.ee.bear.doc.structure.pad.viewmodel.a> r102 = this.catalogModeChangingLiveData;
        com.bytedance.ee.bear.doc.structure.pad.viewmodel.a r103 = r102.getValue();
        if (r103 != null) goto L5;
        r103 = new com.bytedance.ee.bear.doc.structure.pad.viewmodel.a(0);
    L5:
        r103.f218262a = r100;
        r103.f218263b = r101;
        r102.setValue(r103);
    }

    private final void makeEmbedModeChangingLiveData(CatalogMode r100, CatalogMode r101) {
        if (isCatalogOpen() == true) goto L5;
        return;
    L5:
        boolean r102 = true;
        if (r100 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r101 != null) goto L13;
    L15:
        r102 = false;
    L16:
        if (r103 == true) goto L19;
        if (r102 == true) goto L19;
        return;
    L19:
        this.isOnEmbedLiveData.postValue(Boolean.valueOf(r102));
        return;
    L13:
        if (com.bytedance.ee.bear.doc.structure.pad.viewmodel.b.a(r101) != true) goto L15;
    L8:
        if (com.bytedance.ee.bear.doc.structure.pad.viewmodel.b.a(r100) != true) goto L10;
        r103 = true;
        goto L11
    }

    private final void makePadOrPhoneModeChangingLiveData(CatalogMode r100, CatalogMode r101) {
        boolean r102 = false;
        Boolean r103 = null;
        if (r100 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != CatalogMode.EMBED) goto L7;
    L10:
        boolean r104 = true;
    L11:
        Boolean r105 = Boolean.valueOf(r104);
    L13:
        if (r101 == null) goto L20;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101 != CatalogMode.EMBED) goto L17;
    L18:
        r102 = true;
    L19:
        r103 = Boolean.valueOf(r102);
        goto L20
    L17:
        if (r101 != CatalogMode.COVERAGE) goto L19;
    L20:
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r106) == false) goto L23;
    L25:
        Boolean r107 = Boolean.FALSE;
        if (Intrinsics.areEqual(r105, r107) == false) goto L28;
        return;
    L28:
        if (Intrinsics.areEqual(r103, r107) == false) goto L33;
        this.phoneToPadLiveData.postValue(r107);
        return;
    L33:
        return;
    L23:
        if (Intrinsics.areEqual(r103, r106) == false) goto L25;
        this.phoneToPadLiveData.postValue(r106);
        return;
    L7:
        if (r100 == CatalogMode.COVERAGE) goto L10;
        r104 = false;
        goto L11
    L12:
        r105 = null;
        goto L13
    }

    public final void observeWidthChange(View r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        ActivityWidthChangeLiveData r102 = this.activityWidthChangeLiveData;
        if (r102 != null) goto L5;
        r102 = new ActivityWidthChangeLiveData(new WeakReference(r100));
    L5:
        this.activityWidthChangeLiveData = r102;
        r102.observe(r101, this.activityWidthChangeObserver);
        this.isCatalogOpenLiveData.observe(r101, new c(this));
    }

    public static final /* synthetic */ void access$makeCatalogModeChangingLiveData(CatalogViewModel r100, CatalogMode r101, CatalogMode r102) {
        r100.makeCatalogModeChangingLiveData(r101, r102);
    }

    public static final /* synthetic */ void access$makeEmbedModeChangingLiveData(CatalogViewModel r100, CatalogMode r101, CatalogMode r102) {
        r100.makeEmbedModeChangingLiveData(r101, r102);
    }

    public static final /* synthetic */ void access$makePadOrPhoneModeChangingLiveData(CatalogViewModel r100, CatalogMode r101, CatalogMode r102) {
        r100.makePadOrPhoneModeChangingLiveData(r101, r102);
    }

    public static /* synthetic */ void openOrCloseCatalogView$default(CatalogViewModel r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L9;
        Boolean r104 = r100.isCatalogOpenLiveData.getValue();
        if (r104 == null) goto L7;
        boolean r105 = r104.booleanValue();
    L8:
        r101 = !r105;
        goto L9
    L7:
        r105 = false;
    L9:
        r100.openOrCloseCatalogView(r101);
    }
}

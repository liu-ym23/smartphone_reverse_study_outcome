package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.room.quick.BaseViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J4\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042$\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00050\u00040\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003J\u001a\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001aR#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u001b8\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001b8\u0006¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001fR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001aR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\u001b8\u0006¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001fR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/LiveFlashSearchViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/room/quick/BaseViewModel;", "", "", "", "Lkotlin/Pair;", "map", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/k;", "convertMapToList", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/a;", "searchRepository", "", "setSearchRepository", "initOriginData", "showOriginData", "hideDate", "searchText", "startSearch", "selectedItemData", "selectItem", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/a;", "", "originDataList", "Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", "_currentStringLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "currentStringLiveData", "Landroidx/lifecycle/LiveData;", "getCurrentStringLiveData", "()Landroidx/lifecycle/LiveData;", "_dataListLiveData", "dataListLiveData", "getDataListLiveData", "", "_showSearchBarLiveData", "showSearchBarLiveData", "getShowSearchBarLiveData", "_dismissLiveData", "dismissLiveData", "getDismissLiveData", "Lkotlinx/coroutines/Job;", "searchJob", "Lkotlinx/coroutines/Job;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashSearchViewModel extends BaseViewModel {
    private final MutableLiveData<String> _currentStringLiveData;
    private final MutableLiveData<List<k>> _dataListLiveData;
    private final MutableLiveData<Boolean> _dismissLiveData;
    private final MutableLiveData<Boolean> _showSearchBarLiveData;
    private final LiveData<String> currentStringLiveData;
    private final LiveData<List<k>> dataListLiveData;
    private final LiveData<Boolean> dismissLiveData;
    private List<k> originDataList;
    private Job searchJob;
    private a searchRepository;
    private final LiveData<Boolean> showSearchBarLiveData;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.oldflash.search.LiveFlashSearchViewModel$startSearch$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.oldflash.search.LiveFlashSearchViewModel$startSearch$1", f = "LiveFlashSearchViewModel.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $searchText;
        int label;
        final /* synthetic */ LiveFlashSearchViewModel this$0;

        public AnonymousClass1(LiveFlashSearchViewModel r1, String r2, Continuation r3) {
            this.this$0 = r1;
            this.$searchText = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new AnonymousClass1(this.this$0, this.$searchText, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L13:
            List r9 = (List) r8;
        L15:
            if (r9 == null) goto L22;
            MutableLiveData r2 = LiveFlashSearchViewModel.access$get_dataListLiveData$p(this.this$0);
            List r10 = r9;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator r11 = r10.iterator();
        L18:
            if (r11.hasNext() == false) goto L20;
            Pair r4 = (Pair) r11.next();
            r3.add(new i((String) r4.getFirst(), (String) r4.getSecond(), Intrinsics.areEqual((String) LiveFlashSearchViewModel.access$get_currentStringLiveData$p(this.this$0).getValue(), (String) r4.getFirst())));
            goto L18
        L20:
            r2.setValue(r3);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            a r12 = LiveFlashSearchViewModel.access$getSearchRepository$p(this.this$0);
            if (r12 == null) goto L14;
            String r5 = this.$searchText;
            this.label = 1;
            r8 = r12.a(r5, this);
            if (r8 != r0) goto L13;
            return r0;
        L14:
            r9 = null;
            goto L15
        }
    }

    public LiveFlashSearchViewModel() {
        super(null, 1, null);
        this.originDataList = new ArrayList();
        MutableLiveData<String> r0 = new MutableLiveData();
        this._currentStringLiveData = r0;
        this.currentStringLiveData = r0;
        MutableLiveData<List<k>> r1 = new MutableLiveData();
        this._dataListLiveData = r1;
        this.dataListLiveData = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData();
        this._showSearchBarLiveData = r2;
        this.showSearchBarLiveData = r2;
        MutableLiveData<Boolean> r3 = new MutableLiveData();
        this._dismissLiveData = r3;
        this.dismissLiveData = r3;
    }

    public final void hideDate() {
        this._dataListLiveData.setValue(new ArrayList());
    }

    public final void initOriginData() {
        this.originDataList.clear();
        a r0 = this.searchRepository;
        boolean r1 = true;
        if (r0 == null) goto L13;
        Map<String, List<Pair<String, String>>> r2 = r0.e();
        if (r2 == null) goto L13;
        MutableLiveData<Boolean> r3 = this._showSearchBarLiveData;
        a r4 = this.searchRepository;
        if (r4 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        r3.setValue(Boolean.valueOf(r5));
        this.originDataList.addAll(convertMapToList(r2));
        goto L13
    L9:
        if (r4.d() != true) goto L11;
        r5 = true;
    L13:
        a r6 = this.searchRepository;
        k r7 = null;
        if (r6 == null) goto L34;
        String r8 = r6.b();
        if (r8 == null) goto L34;
        if (r8.length() <= 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == true) goto L24;
        r8 = null;
    L24:
        if (r8 == null) goto L34;
        this._currentStringLiveData.setValue(r8);
        List<k> r10 = this.originDataList;
        ListIterator<k> r11 = r10.listIterator(r10.size());
    L27:
        if (r11.hasPrevious() == false) goto L31;
        k r12 = r11.previous();
        if (Intrinsics.areEqual(r12.a, r8) == false) goto L27;
    L32:
        if (r12 != null) goto L34;
        ListProtector.add(this.originDataList, 0, new i(r8, "", Intrinsics.areEqual((String) this._currentStringLiveData.getValue(), r8)));
        goto L34
    L31:
        r12 = null;
        goto L32
    L20:
        r9 = false;
    L34:
        a r13 = this.searchRepository;
        if (r13 == null) goto L54;
        String r14 = r13.c();
        if (r14 == null) goto L54;
        if (r14.length() > 0) goto L42;
        r1 = false;
    L42:
        if (r1 == true) goto L45;
        r14 = null;
    L45:
        if (r14 == null) goto L54;
        List<k> r15 = this.originDataList;
        ListIterator<k> r16 = r15.listIterator(r15.size());
    L48:
        if (r16.hasPrevious() == false) goto L52;
        k r17 = r16.previous();
        if (Intrinsics.areEqual(r17.a, r14) == false) goto L48;
        r7 = r17;
    L52:
        if (r7 != null) goto L54;
        ListProtector.add(this.originDataList, 0, new i(r14, "", Intrinsics.areEqual((String) this._currentStringLiveData.getValue(), r14)));
    L54:
        showOriginData();
    }

    public final void showOriginData() {
        Job r0 = this.searchJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Iterator<T> r1 = this.originDataList.iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        k r2 = (k) r1.next();
        if ((r2 instanceof i) == true) goto L11;
        k r3 = null;
    L12:
        i r4 = (i) r3;
        if (r4 == null) goto L7;
        r4.c = Intrinsics.areEqual((String) this._currentStringLiveData.getValue(), r2.a);
        goto L7
    L11:
        r3 = r2;
        goto L12
    L15:
        this._dataListLiveData.setValue(this.originDataList);
    }

    public final LiveData<String> getCurrentStringLiveData() {
        return this.currentStringLiveData;
    }

    public final LiveData<List<k>> getDataListLiveData() {
        return this.dataListLiveData;
    }

    public final LiveData<Boolean> getDismissLiveData() {
        return this.dismissLiveData;
    }

    public final LiveData<Boolean> getShowSearchBarLiveData() {
        return this.showSearchBarLiveData;
    }

    public static final /* synthetic */ a access$getSearchRepository$p(LiveFlashSearchViewModel r0) {
        return r0.searchRepository;
    }

    public static final /* synthetic */ MutableLiveData access$get_currentStringLiveData$p(LiveFlashSearchViewModel r0) {
        return r0._currentStringLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_dataListLiveData$p(LiveFlashSearchViewModel r0) {
        return r0._dataListLiveData;
    }

    private final List<k> convertMapToList(Map<String, ? extends List<Pair<String, String>>> r9) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, ? extends List<Pair<String, String>>>> r10 = r9.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        Map.Entry<String, ? extends List<Pair<String, String>>> r1 = r10.next();
        if ((!r1.getValue().isEmpty()) == false) goto L8;
        r0.add(new j(r1.getKey()));
    L8:
        List<Pair<String, String>> r2 = r1.getValue();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        Pair r5 = (Pair) r4.next();
        r3.add(new i((String) r5.getFirst(), (String) r5.getSecond(), Intrinsics.areEqual((String) this._currentStringLiveData.getValue(), (String) r5.getFirst())));
        goto L10
    L12:
        r0.addAll(r3);
        goto L4
    L13:
        return r0;
    }

    public final void selectItem(Pair<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "selectedItemData");
        if (((CharSequence) r6.getSecond()).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        MutableLiveData<String> r1 = this._currentStringLiveData;
        a r2 = this.searchRepository;
        if (r2 == null) goto L28;
        String r3 = r2.c();
        if (r3 == null) goto L28;
    L29:
        r1.setValue(r3);
        List r4 = (List) this._dataListLiveData.getValue();
        if (r4 == null) goto L41;
        Iterator r5 = r4.iterator();
    L33:
        if (r5.hasNext() == false) goto L41;
        k r7 = (k) r5.next();
        if ((r7 instanceof i) == true) goto L37;
        k r8 = null;
    L38:
        i r9 = (i) r8;
        if (r9 == null) goto L33;
        ((i) r7).c = Intrinsics.areEqual(r9.a, (String) this._currentStringLiveData.getValue());
        goto L33
    L37:
        r8 = r7;
    L41:
        MutableLiveData<List<k>> r10 = this._dataListLiveData;
        r10.setValue(r10.getValue());
        com.bytedance.android.livesdk.livecommerce.utils.k.n(ECAppInfoService.e.getApplicationContext(), (String) r6.getSecond());
        this._dismissLiveData.setValue(Boolean.FALSE);
        return;
    L28:
        r3 = "";
        goto L29
    L9:
        if ((!Intrinsics.areEqual((String) this._currentStringLiveData.getValue(), (String) r6.getFirst())) == false) goto L23;
        this._currentStringLiveData.setValue(r6.getFirst());
        List r11 = (List) this._dataListLiveData.getValue();
        if (r11 == null) goto L22;
        Iterator r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L22;
        k r13 = (k) r12.next();
        if ((r13 instanceof i) == true) goto L18;
        k r14 = null;
    L19:
        i r15 = (i) r14;
        if (r15 == null) goto L14;
        ((i) r13).c = Intrinsics.areEqual(r15.a, (String) r6.getFirst());
        goto L14
    L18:
        r14 = r13;
    L22:
        MutableLiveData<List<k>> r16 = this._dataListLiveData;
        r16.setValue(r16.getValue());
    L23:
        this._dismissLiveData.setValue(Boolean.TRUE);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void setSearchRepository(a r1) {
        this.searchRepository = r1;
    }

    public final void startSearch(String r10) {
        Intrinsics.checkNotNullParameter(r10, "searchText");
        Job r0 = this.searchJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.searchJob = BuildersKt.launch$default(mg.b.a(this), Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, r10, null), 2, null);
        dm.a.a("LiveFlashSearchViewModel").i("search:" + r10);
    }

    public static final /* synthetic */ void access$setSearchRepository$p(LiveFlashSearchViewModel r0, a r1) {
        r0.searchRepository = r1;
    }
}

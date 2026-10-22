package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import android.app.Application;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.android.file.picker.lib.FilePickerParams;
import com.bytedance.ee.android.file.picker.lib.v2.data.FilePickerRepository;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.StringKey;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.j;
import com.larksuite.framework.utils.ICUUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0006\b\u0001\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\"\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020 0!0\u001fH\u0002J>\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00130\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00130\u001f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JJ\u0010$\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020 0!0\u001f2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020 0!0\u001f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u0002H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/FilePickerViewModel;", "Lcom/larksuite/arch/jack/JackViewModel;", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/FilePickerUiState;", "mCategoryConfigManager", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;", "mRepository", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/FilePickerRepository;", "mApplication", "Landroid/app/Application;", "mSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;Lcom/bytedance/ee/android/file/picker/lib/v2/data/FilePickerRepository;Landroid/app/Application;Landroidx/lifecycle/SavedStateHandle;)V", "mParams", "Lcom/bytedance/ee/android/file/picker/lib/FilePickerParams;", "params", "getParams", "()Lcom/bytedance/ee/android/file/picker/lib/FilePickerParams;", "mCurrentOrder", "", "loadData", "", "updateSelectedStatus", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/GroupEntity;", "select", "", "getBottomBarButtonText", "", "selectedKey", "", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "", "calcSelectedOrders", "selectedOrders", "calcSelectedGroups", "defaultState", "Companion", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilePickerViewModel extends JackViewModel<FilePickerUiState> {
    public static final a Companion = null;
    private static final String TAG = "FilePickerViewModel";
    private final Application mApplication;
    private final sm4.b mCategoryConfigManager;
    private long mCurrentOrder;
    private final FilePickerParams mParams;
    private final FilePickerRepository mRepository;
    private final SavedStateHandle mSavedStateHandle;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel$loadData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel$loadData$1", f = "FilePickerViewModel.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FilePickerViewModel this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel$loadData$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "", "", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/FileEntry;", "e", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel$loadData$1$2", f = "FilePickerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Map<String, ? extends List<? extends FileEntry>>>, Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass2(Continuation<? super AnonymousClass2> r100) {
                super(3, r100);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Map<String, ? extends List<? extends FileEntry>>> r100, Throwable r101, Continuation<? super Unit> r102) {
                return invoke2(r100, r101, r102);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super Map<String, ? extends List<FileEntry>>> r100, Throwable r101, Continuation<? super Unit> r102) {
                AnonymousClass2 r103 = new AnonymousClass2(r102);
                r103.L$0 = r101;
                return r103.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                Log.e(FilePickerViewModel.TAG, "load failed", (Throwable) this.L$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel$loadData$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Set<String> f206122a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FilePickerViewModel f206123b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Set<String> f206124c;

            public a(Set<String> r100, FilePickerViewModel r101, Set<String> r102) {
                this.f206122a = r100;
                this.f206123b = r101;
                this.f206124c = r102;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r210, Continuation r211) {
                Map r100 = (Map) r210;
                Set r101 = r100.keySet();
                if (r101.containsAll(this.f206122a) == true) goto L5;
                Log.i(FilePickerViewModel.TAG, "keys:" + CollectionsKt.joinToString$default(r101, null, null, null, 0, null, null, 63, null) + ",dataSourceTypes:" + CollectionsKt.joinToString$default(this.f206122a, null, null, null, 0, null, null, 63, null));
                return Unit.INSTANCE;
            L5:
                Log.i(FilePickerViewModel.TAG, "load file success");
                HashMap r102 = new HashMap();
                Set<String> r103 = this.f206124c;
                Iterator r104 = r100.entrySet().iterator();
            L7:
                if (r104.hasNext() == false) goto L32;
                Iterable r105 = (Iterable) ((Map.Entry) r104.next()).getValue();
                ArrayList r106 = new ArrayList();
                Iterator<T> r107 = r105.iterator();
            L10:
                if (r107.hasNext() == false) goto L25;
                T r108 = r107.next();
                String r109 = StringsKt.substringAfterLast(((FileEntry) r108).f206013a, '.', "");
                Set<String> r110 = r103;
                boolean r111 = true;
                if (r110 != null) goto L14;
            L17:
                boolean r112 = true;
            L18:
                if (r112 == false) goto L20;
            L23:
                if (r111 == false) goto L10;
                r106.add(r108);
                goto L10
            L20:
                if (r103.contains(r109) == true) goto L23;
                r111 = false;
                goto L23
            L14:
                if (r110.isEmpty() == true) goto L17;
                r112 = false;
                goto L18
            L25:
                Iterator r113 = r106.iterator();
            L27:
                if (r113.hasNext() == false) goto L7;
                FileEntry r114 = (FileEntry) r113.next();
                ArrayList r115 = (ArrayList) r102.get(r114.f206019g);
                if (r115 != null) goto L31;
                r115 = new ArrayList();
                r102.put(r114.f206019g, r115);
            L31:
                r115.add(r114);
                goto L27
            L32:
                ArrayList r116 = new ArrayList(r102.size());
                Iterator r117 = r102.entrySet().iterator();
            L34:
                if (r117.hasNext() == false) goto L52;
                Map.Entry r118 = (Map.Entry) r117.next();
                Iterable r119 = (Iterable) r118.getValue();
                HashSet r120 = new HashSet();
                ArrayList r121 = new ArrayList();
                Iterator<T> r122 = r119.iterator();
            L37:
                if (r122.hasNext() == false) goto L41;
                T r123 = r122.next();
                if (r120.add(((FileEntry) r123).f206020h) == false) goto L37;
                r121.add(r123);
                goto L37
            L41:
                HashSet r124 = new HashSet();
                ArrayList r125 = new ArrayList();
                Iterator r126 = r121.iterator();
            L43:
                if (r126.hasNext() == false) goto L51;
                Object r127 = r126.next();
                FileEntry r128 = (FileEntry) r127;
                if (StringsKt.isBlank(r128.f206015c) == false) goto L47;
                String r129 = UUID.randomUUID().toString();
            L49:
                if (r124.add(r129) == false) goto L43;
                r125.add(r127);
                goto L43
            L47:
                r129 = r128.f206015c;
                goto L49
            L51:
                String r130 = (String) r118.getKey();
                r116.add(new GroupEntity(r130, r125, new StringKey(r130)));
                goto L34
            L52:
                final List r131 = CollectionsKt.sortedWith(r116, new d(this.f206123b));
                FilePickerViewModel.access$setState(this.f206123b, new FilePickerViewModel$loadData$1$3$2(r131));
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(FilePickerViewModel r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            Set<String> r102 = FilePickerViewModel.access$getMParams$p(this.this$0).f205964i;
            Set<String> r103 = r102;
            if (r103 != null) goto L11;
        L14:
            boolean r104 = true;
        L16:
            if (r104 == false) goto L19;
            Log.w(FilePickerViewModel.TAG, "Invalid dataSourceSet");
            return Unit.INSTANCE;
        L19:
            Set<String> r105 = FilePickerViewModel.access$getMParams$p(this.this$0).f205965j;
            if (r105 == null) goto L22;
            Set r106 = CollectionsKt.toMutableSet(r105);
        L23:
            if (r106 == null) goto L25;
            Boxing.boxBoolean(CollectionsKt.removeAll(r106, C29661.INSTANCE));
        L25:
            StringBuilder r107 = new StringBuilder("start load files:");
            r107.append(CollectionsKt.joinToString$default(r102, null, null, null, 0, null, null, 63, null));
            r107.append(",supportedExtensions:");
            if (r106 == null) goto L28;
            String r108 = CollectionsKt.joinToString$default(r106, null, null, null, 0, null, null, 63, null);
        L29:
            r107.append(r108);
            Log.i(FilePickerViewModel.TAG, r107.toString());
            FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r109 = new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(kotlinx.coroutines.flow.e.w(FilePickerViewModel.access$getMRepository$p(this.this$0).a(r102), Dispatchers.getIO()), new AnonymousClass2(null));
            a r111 = new a(r102, this.this$0, r106);
            this.label = 1;
            if (r109.collect(r111, this) != r100) goto L33;
            return r100;
        L28:
            r108 = null;
            goto L29
        L22:
            r106 = null;
            goto L23
        L11:
            if (r103.isEmpty() == true) goto L14;
            r104 = false;
            goto L16
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public FilePickerUiState defaultState() {
        String r100 = this.mParams.f205961f;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        r100 = y9c.d.i(this.mApplication, R.string.Lark_Message_File_defTitle);
    L11:
        String r102 = r100;
        boolean r103 = this.mParams.f205963h;
        if (CarUtils.a() == true) goto L14;
    L16:
        boolean r104 = r103;
    L17:
        Intrinsics.checkNotNull(r102);
        List r105 = CollectionsKt.emptyList();
        String r106 = getBottomBarButtonText(MapsKt.emptyMap());
        return new FilePickerUiState(r102, r104, r105, MapsKt.emptyMap(), r106, true, MapsKt.emptyMap());
    L14:
        if (((v28.a) ClaymoreServiceLoader.loadFirst(v28.a.class)).enableSystemFilePicker() == true) goto L16;
        r104 = false;
        goto L17
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final void loadData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final FilePickerParams getParams() {
        return this.mParams;
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public /* bridge */ /* synthetic */ j defaultState() {
        return defaultState();
    }

    public static final /* synthetic */ sm4.b access$getMCategoryConfigManager$p(FilePickerViewModel r100) {
        return r100.mCategoryConfigManager;
    }

    public static final /* synthetic */ FilePickerParams access$getMParams$p(FilePickerViewModel r100) {
        return r100.mParams;
    }

    public static final /* synthetic */ FilePickerRepository access$getMRepository$p(FilePickerViewModel r100) {
        return r100.mRepository;
    }

    private final String getBottomBarButtonText(Map<Key, ? extends Set<? extends Key>> r100) {
        Iterator<T> r101 = r100.values().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 + ((Set) r101.next()).size();
        goto L4
    L6:
        if (r102 != 0) goto L13;
        String r103 = this.mParams.f205968m;
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        if (StringsKt.isBlank(r103) == false) goto L15;
        r103 = this.mParams.f205962g;
    L15:
        if (StringsKt.isBlank(r103) == false) goto L17;
        r103 = y9c.d.i(this.mApplication, R.string.Lark_Legacy_Send);
    L17:
        ICUUtils.FormatArgsBuilder r104 = new ICUUtils.FormatArgsBuilder();
        r104.a(Integer.valueOf(r102));
        return ICUUtils.icuFormat(r103, r104.f285892a);
    L13:
        r103 = this.mParams.f205962g;
        goto L15
    }

    public static final /* synthetic */ String access$getBottomBarButtonText(FilePickerViewModel r100, Map r101) {
        return r100.getBottomBarButtonText(r101);
    }

    public static final /* synthetic */ void access$setState(FilePickerViewModel r100, Function1 r101) {
        r100.setState(r101);
    }

    public final void updateSelectedStatus(final List<GroupEntity> r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED);
        setState(new C105061(this, r100, r101));
    }

    private final Map<Key, Set<Key>> calcSelectedGroups(Map<Key, ? extends Set<? extends Key>> r100, List<GroupEntity> r110, boolean r111) {
        ArrayMap r101 = new ArrayMap();
        Iterator<Map.Entry<Key, ? extends Set<? extends Key>>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<Key, ? extends Set<? extends Key>> r103 = r102.next();
        Key r104 = r103.getKey();
        Set<? extends Key> r105 = r103.getValue();
        ArraySet r106 = new ArraySet(0, 1, null);
        r106.addAll(r105);
        r101.put(r104, r106);
        goto L4
    L6:
        Iterator<T> r107 = r110.iterator();
    L8:
        if (r107.hasNext() == false) goto L27;
        GroupEntity r112 = (GroupEntity) r107.next();
        Key r108 = r112.f206023c;
        Object r109 = r101.get(r108);
        if (r109 != null) goto L12;
        r109 = new ArraySet(0, 1, null);
        r101.put(r108, r109);
    L12:
        ArraySet r113 = (ArraySet) r109;
        if (r111 == false) goto L19;
        List<FileEntry> r114 = r112.f206022b;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r116 = r114.iterator();
    L16:
        if (r116.hasNext() == false) goto L18;
        r115.add(((FileEntry) r116.next()).f206020h);
        goto L16
    L18:
        r113.addAll(r115);
    L25:
        if (r113.isEmpty() == false) goto L8;
        r101.remove(r112.f206023c);
        goto L8
    L19:
        List<FileEntry> r117 = r112.f206022b;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L21:
        if (r119.hasNext() == false) goto L23;
        r118.add(((FileEntry) r119.next()).f206020h);
        goto L21
    L23:
        r113.removeAll(CollectionsKt.toSet(r118));
        goto L25
    L27:
        return r101;
    }

    private final Map<Key, Long> calcSelectedOrders(Map<Key, Long> r100, List<GroupEntity> r101, boolean r102) {
        if (r102 == true) goto L4;
        return r100;
    L4:
        ArrayMap r103 = new ArrayMap();
        r103.putAll(r100);
        Iterator<T> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        Iterator<T> r105 = ((GroupEntity) r104.next()).f206022b.iterator();
    L9:
        if (r105.hasNext() == false) goto L6;
        Key r106 = ((FileEntry) r105.next()).f206020h;
        long r107 = this.mCurrentOrder;
        this.mCurrentOrder = 1 + r107;
        r103.put(r106, Long.valueOf(r107));
        goto L9
    L11:
        return r103;
    }

    @Inject
    public FilePickerViewModel(sm4.b r110, FilePickerRepository r111, Application r112, SavedStateHandle r210) {
        Intrinsics.checkNotNullParameter(r110, "mCategoryConfigManager");
        Intrinsics.checkNotNullParameter(r111, "mRepository");
        Intrinsics.checkNotNullParameter(r112, "mApplication");
        Intrinsics.checkNotNullParameter(r210, "mSavedStateHandle");
        this.mCategoryConfigManager = r110;
        this.mRepository = r111;
        this.mApplication = r112;
        this.mSavedStateHandle = r210;
        FilePickerParams r100 = (FilePickerParams) r210.get("file_picker_params");
        if (r100 != null) goto L5;
        Log.e(TAG, "No param");
        r100 = new FilePickerParams(0, 0, 0, null, null, null, null, false, null, 8191);
    L5:
        this.mParams = r100;
    }

    public static final /* synthetic */ Map access$calcSelectedGroups(FilePickerViewModel r100, Map r101, List r102, boolean r103) {
        return r100.calcSelectedGroups(r101, r102, r103);
    }

    public static final /* synthetic */ Map access$calcSelectedOrders(FilePickerViewModel r100, Map r101, List r102, boolean r103) {
        return r100.calcSelectedOrders(r101, r102, r103);
    }
}

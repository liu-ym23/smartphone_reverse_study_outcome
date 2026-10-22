package com.ss.android.lark.widget.photo.preview;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnLoadMoreListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0006J\u0016\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bJ\u0016\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000bJ\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u000fJ\u0006\u00100\u001a\u00020\u0015J\u000e\u00101\u001a\u00020&2\u0006\u0010-\u001a\u00020\u000fJ\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\u0006\u00104\u001a\u00020&R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR'\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u00120\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/PhotoPagerViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "initDataLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData;", "getInitDataLiveData", "()Landroidx/lifecycle/MutableLiveData;", "photoItemsLiveData", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "Lkotlin/collections/ArrayList;", "getPhotoItemsLiveData", "updateLiveData", "", "getUpdateLiveData", "updatePageLiveData", "Lkotlin/Pair;", "getUpdatePageLiveData", "mAfterCleanCache", "", "currentIndex", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "mLastPosition", "mHasMoreLeft", "mHasMoreRight", "mIsLoadingLeft", "mIsLoadingRight", "initData", "getInitData", "()Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData;", "setInitData", "(Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData;)V", "init", "", "bundle", "Landroid/os/Bundle;", "photoPagerInitData", "updateItem", "originItem", "updatePageData", "position", "removeItem", "index", "isEmpty", "onPageSelected", "loadLeftPage", "loadRightPage", "cleanCache", "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoPagerViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String LOG_TAG = "PhotoPagerViewModel";
    private int currentIndex;
    public PhotoPagerInitData initData;
    private final MutableLiveData<PhotoPagerInitData> initDataLiveData;
    private boolean mAfterCleanCache;
    private volatile boolean mHasMoreLeft;
    private volatile boolean mHasMoreRight;
    private volatile boolean mIsLoadingLeft;
    private volatile boolean mIsLoadingRight;
    private int mLastPosition;
    private final MutableLiveData<ArrayList<PhotoItem>> photoItemsLiveData;
    private final MutableLiveData<Integer> updateLiveData;
    private final MutableLiveData<Pair<Integer, PhotoItem>> updatePageLiveData;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel$cleanCache$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel$cleanCache$1", f = "PhotoPagerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PhotoPagerViewModel this$0;

        public AnonymousClass1(PhotoPagerViewModel r100, Continuation<? super AnonymousClass1> r101) {
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
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L28;
            ResultKt.throwOnFailure(r100);
            int r101 = this.this$0.getCurrentIndex();
            ArrayList<PhotoItem> r102 = this.this$0.getPhotoItemsLiveData().getValue();
            if (r102 == null) goto L7;
            if (r101 < 0) goto L26;
            if (r101 > (r102.size() - 1)) goto L26;
            if (r102.size() < 3) goto L26;
            if (((PhotoItem) ListProtector.get(r102, r101)).isVideo() == true) goto L26;
            PhotoPagerViewModel.access$setMAfterCleanCache$p(this.this$0, true);
            if (r101 != 0) goto L20;
            ArrayList<PhotoItem> r103 = new ArrayList(r102.subList(r101, r101 + 2));
        L23:
            this.this$0.getPhotoItemsLiveData().postValue(r103);
            return Unit.INSTANCE;
        L20:
            if (r101 != (r102.size() - 1)) goto L22;
            r103 = new ArrayList(r102.subList(r101 - 1, r101 + 1));
            goto L23
        L22:
            r103 = new ArrayList(r102.subList(r101 - 1, Math.min(r101 + 2, r102.size())));
        L26:
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel$loadLeftPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel$loadLeftPage$1", f = "PhotoPagerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C122741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ OnLoadMoreListener $listener;
        int label;
        final /* synthetic */ PhotoPagerViewModel this$0;

        public C122741(OnLoadMoreListener r100, String r101, PhotoPagerViewModel r102, Continuation<? super C122741> r103) {
            this.$listener = r100;
            this.$id = r101;
            this.this$0 = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C122741(this.$listener, this.$id, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C122741) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L24;
            ResultKt.throwOnFailure(r100);
            List<ImageSet> r101 = this.$listener.onLoadLeft(this.$id);
            if (CollectionUtils.isEmpty(r101) == false) goto L7;
            List r102 = null;
        L8:
            PhotoPagerViewModel.access$setMIsLoadingLeft$p(this.this$0, false);
            if (CollectionUtils.isEmpty(r102) == false) goto L12;
            PhotoPagerViewModel.access$setMHasMoreLeft$p(this.this$0, false);
            return Unit.INSTANCE;
        L12:
            ArrayList<PhotoItem> r103 = new ArrayList(r102);
            ArrayList<PhotoItem> r104 = this.this$0.getPhotoItemsLiveData().getValue();
            Ref.ObjectRef r105 = new Ref.ObjectRef();
            if (r104 == null) goto L18;
            PhotoPagerViewModel r106 = this.this$0;
            if ((!r104.isEmpty()) == false) goto L17;
            r106.setCurrentIndex(RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(r106.getCurrentIndex(), r104.size() - 1)));
            r105.element = ListProtector.get(r104, r106.getCurrentIndex());
        L17:
            Boxing.boxBoolean(r103.addAll(r104));
        L18:
            PhotoItem r107 = (PhotoItem) r105.element;
            if (r107 == null) goto L21;
            this.this$0.setCurrentIndex(r103.indexOf(r107));
        L21:
            this.this$0.getPhotoItemsLiveData().postValue(r103);
            return Unit.INSTANCE;
        L7:
            r102 = com.ss.android.lark.widget.photo.preview.utils.d.b(r101, "");
            goto L8
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel$loadRightPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel$loadRightPage$1", f = "PhotoPagerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C122751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        final /* synthetic */ OnLoadMoreListener $listener;
        int label;
        final /* synthetic */ PhotoPagerViewModel this$0;

        public C122751(OnLoadMoreListener r100, String r101, PhotoPagerViewModel r102, Continuation<? super C122751> r103) {
            this.$listener = r100;
            this.$id = r101;
            this.this$0 = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C122751(this.$listener, this.$id, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C122751) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L26;
            ResultKt.throwOnFailure(r100);
            List<ImageSet> r101 = this.$listener.onLoadRight(this.$id);
            if (CollectionUtils.isEmpty(r101) == false) goto L7;
            List r102 = null;
        L8:
            PhotoPagerViewModel.access$setMIsLoadingRight$p(this.this$0, false);
            if (CollectionUtils.isEmpty(r102) == false) goto L12;
            PhotoPagerViewModel.access$setMHasMoreRight$p(this.this$0, false);
            return Unit.INSTANCE;
        L12:
            ArrayList<PhotoItem> r103 = new ArrayList();
            ArrayList<PhotoItem> r104 = this.this$0.getPhotoItemsLiveData().getValue();
            Ref.ObjectRef r105 = new Ref.ObjectRef();
            if (r104 == null) goto L18;
            PhotoPagerViewModel r106 = this.this$0;
            if ((!r104.isEmpty()) == false) goto L17;
            r106.setCurrentIndex(RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(r106.getCurrentIndex(), r104.size() - 1)));
            r105.element = ListProtector.get(r104, r106.getCurrentIndex());
        L17:
            Boxing.boxBoolean(r103.addAll(r104));
        L18:
            if (r102 == null) goto L20;
            Boxing.boxBoolean(r103.addAll(r102));
        L20:
            PhotoItem r107 = (PhotoItem) r105.element;
            if (r107 == null) goto L23;
            this.this$0.setCurrentIndex(r103.indexOf(r107));
        L23:
            this.this$0.getPhotoItemsLiveData().postValue(r103);
            return Unit.INSTANCE;
        L7:
            r102 = com.ss.android.lark.widget.photo.preview.utils.d.b(r101, "");
            goto L8
        L26:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    private final void loadLeftPage() {
        PhotoPagerInitData r100 = this.initDataLiveData.getValue();
        if (r100 == null) goto L5;
        OnLoadMoreListener r101 = r100.getLoadMoreListener();
    L6:
        ArrayList<PhotoItem> r102 = this.photoItemsLiveData.getValue();
        if (this.mIsLoadingLeft == true) goto L18;
        if (r101 == null) goto L19;
        if (r102 == null) goto L20;
        this.mIsLoadingLeft = true;
        MessageIdentity r103 = ((PhotoItem) ListProtector.get(r102, 0)).getMessageIdentity();
        if (r103 == null) goto L15;
        String r104 = r103.getMessageId();
        if (r104 == null) goto L15;
    L16:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C122741(r101, r104, this, null), 3, null);
        return;
    L15:
        r104 = String.valueOf(this.currentIndex);
        goto L16
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final void loadRightPage() {
        PhotoPagerInitData r100 = this.initDataLiveData.getValue();
        if (r100 == null) goto L5;
        OnLoadMoreListener r101 = r100.getLoadMoreListener();
    L6:
        ArrayList<PhotoItem> r102 = this.photoItemsLiveData.getValue();
        if (this.mIsLoadingLeft == true) goto L21;
        if (r101 == null) goto L22;
        if (r102 != null) goto L12;
        return;
    L12:
        if (this.mIsLoadingRight == false) goto L14;
        return;
    L14:
        this.mIsLoadingRight = true;
        MessageIdentity r103 = ((PhotoItem) CollectionsKt.last(r102)).getMessageIdentity();
        if (r103 == null) goto L18;
        String r104 = r103.getMessageId();
        if (r104 == null) goto L18;
    L19:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C122751(r101, r104, this, null), 3, null);
        return;
    L18:
        r104 = String.valueOf(this.currentIndex);
        goto L19
    L22:
        return;
    L21:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void cleanCache() {
        Log.i(LOG_TAG, "cleanCache");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final PhotoPagerInitData getInitData() {
        PhotoPagerInitData r100 = this.initData;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("initData");
        return null;
    }

    public final boolean isEmpty() {
        ArrayList<PhotoItem> r100 = this.photoItemsLiveData.getValue();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isEmpty();
    }

    public PhotoPagerViewModel() {
        this.initDataLiveData = new MutableLiveData();
        this.photoItemsLiveData = new MutableLiveData();
        this.updateLiveData = new MutableLiveData();
        this.updatePageLiveData = new MutableLiveData();
        this.currentIndex = -1;
        this.mLastPosition = -1;
        this.mHasMoreLeft = true;
        this.mHasMoreRight = true;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final MutableLiveData<PhotoPagerInitData> getInitDataLiveData() {
        return this.initDataLiveData;
    }

    public final MutableLiveData<ArrayList<PhotoItem>> getPhotoItemsLiveData() {
        return this.photoItemsLiveData;
    }

    public final MutableLiveData<Integer> getUpdateLiveData() {
        return this.updateLiveData;
    }

    public final MutableLiveData<Pair<Integer, PhotoItem>> getUpdatePageLiveData() {
        return this.updatePageLiveData;
    }

    public final void onPageSelected(int r100) {
        if (this.mAfterCleanCache == false) goto L6;
        Log.i(LOG_TAG, "updateCurrentPage after cleanCache, skip update");
        this.mAfterCleanCache = false;
        return;
    L6:
        ArrayList<PhotoItem> r101 = this.photoItemsLiveData.getValue();
        if (r101 != null) goto L10;
        Log.e(LOG_TAG, "photoItem is empty");
        return;
    L10:
        if (r100 >= 0) goto L12;
    L37:
        Log.e(LOG_TAG, "index is invalid, position is:" + r100 + ", dataList size:" + r101.size());
        return;
    L12:
        if (r100 > r101.size()) goto L37;
        this.currentIndex = r100;
        int r102 = this.mLastPosition;
        if (r102 != (-1)) goto L23;
        this.mLastPosition = r100;
        if (r100 != 0) goto L20;
        loadLeftPage();
    L20:
        if (r100 != (r101.size() - 1)) goto L39;
        loadRightPage();
        return;
    L39:
        return;
    L23:
        if (r102 >= r100) goto L29;
        com.ss.android.lark.widget.photopicker.f.a().b();
        if ((r100 + 3) >= r101.size()) goto L27;
    L35:
        this.mLastPosition = r100;
        return;
    L27:
        if (this.mHasMoreRight == false) goto L35;
        loadRightPage();
        goto L35
    L29:
        if (r102 <= r100) goto L35;
        com.ss.android.lark.widget.photopicker.f.a().b();
        if ((r100 - 3) > 0) goto L35;
        if (this.mHasMoreLeft == false) goto L35;
        loadLeftPage();
        goto L35
    }

    public final void removeItem(int r100) {
        ArrayList<PhotoItem> r101 = this.photoItemsLiveData.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        Log.i(LOG_TAG, "removeItem:" + r100);
        int r102 = r101.size();
        if (r100 < 0) goto L11;
        if (r100 >= r102) goto L11;
        ArrayList<PhotoItem> r103 = new ArrayList(r101);
        ListProtector.remove(r103, r100);
        this.currentIndex = RangesKt.coerceAtMost(this.currentIndex, r103.size() - 1);
        this.photoItemsLiveData.postValue(r103);
        return;
    L11:
        Log.e(LOG_TAG, "remove item failed, item to remove:" + r100 + ", list size:{" + r101.size() + '}');
    }

    public final void setCurrentIndex(int r100) {
        this.currentIndex = r100;
    }

    public final void setInitData(PhotoPagerInitData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.initData = r100;
    }

    public static final /* synthetic */ void access$setMAfterCleanCache$p(PhotoPagerViewModel r100, boolean r101) {
        r100.mAfterCleanCache = r101;
    }

    public static final /* synthetic */ void access$setMHasMoreLeft$p(PhotoPagerViewModel r100, boolean r101) {
        r100.mHasMoreLeft = r101;
    }

    public static final /* synthetic */ void access$setMHasMoreRight$p(PhotoPagerViewModel r100, boolean r101) {
        r100.mHasMoreRight = r101;
    }

    public static final /* synthetic */ void access$setMIsLoadingLeft$p(PhotoPagerViewModel r100, boolean r101) {
        r100.mIsLoadingLeft = r101;
    }

    public static final /* synthetic */ void access$setMIsLoadingRight$p(PhotoPagerViewModel r100, boolean r101) {
        r100.mIsLoadingRight = r101;
    }

    public final void init(Bundle r100, PhotoPagerInitData r101) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        if (r101 != null) goto L5;
        PhotoPagerInitData.Companion.getClass();
        r101 = PhotoPagerInitData.b.a(r100);
    L5:
        setInitData(r101);
        this.currentIndex = getInitData().getCurrentItem();
        this.initDataLiveData.setValue(getInitData());
        this.photoItemsLiveData.setValue(getInitData().getPhotoItem());
    }

    public final void updateItem(PhotoItem r100, PhotoItem r101) {
        Intrinsics.checkNotNullParameter(r100, "originItem");
        Intrinsics.checkNotNullParameter(r101, "updateItem");
        ArrayList<PhotoItem> r102 = this.photoItemsLiveData.getValue();
        if (r102 != null) goto L5;
        return;
    L5:
        ArrayList r103 = new ArrayList(r102);
        Iterator<Integer> r104 = CollectionsKt.getIndices(r103).iterator();
        int r105 = -1;
    L7:
        if (r104.hasNext() == false) goto L11;
        int r106 = ((IntIterator) r104).nextInt();
        if (((PhotoItem) ListProtector.get(r103, r106)).equals(r100) == false) goto L7;
        r105 = r106;
        goto L7
    L11:
        if (r105 >= 0) goto L13;
        return;
    L13:
        if (r105 >= r103.size()) goto L22;
        ListProtector.set(r102, r105, r101);
        this.updateLiveData.postValue(Integer.valueOf(r105));
        return;
    }

    public final void updatePageData(int r100, PhotoItem r101) {
        Intrinsics.checkNotNullParameter(r101, "updateItem");
        this.updatePageLiveData.postValue(new Pair(Integer.valueOf(r100), r101));
    }
}

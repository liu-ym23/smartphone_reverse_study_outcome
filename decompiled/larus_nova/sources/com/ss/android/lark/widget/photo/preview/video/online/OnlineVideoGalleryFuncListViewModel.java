package com.ss.android.lark.widget.photo.preview.video.online;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002:\b./012345B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0012J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0012J\u0006\u0010,\u001a\u00020(J\b\u0010-\u001a\u00020(H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u001c¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001e¨\u00066"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/video/online/OnlineVideoGalleryFuncListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "photoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "operateListener", "Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;", "<init>", "(Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;)V", "getPhotoItem", "()Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "getOperateListener", "()Lcom/ss/android/lark/widget/photo/preview/callback/OperateListener;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "showSaveVideo", "", "showSaveToDriver", "showJumpToChat", "showForward", "showCopyVideo", "_funcListItems", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lcom/ss/android/lark/widget/photo/preview/video/online/OnlineVideoGalleryFuncListViewModel$FuncListItem;", "funcListItems", "Lkotlinx/coroutines/flow/SharedFlow;", "getFuncListItems", "()Lkotlinx/coroutines/flow/SharedFlow;", "_hasItems", "hasItems", "getHasItems", "saveVideo", "saveDriver", "jumpToChat", "forward", "copyVideo", "generateFuncListItems", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onlyCheck", MapMonitorConst.EVENT_DESTROY, "onCleared", "SaveVideoItemAction", "CopyMediaAction", "ShowSaveToDriveItemAction", "JumpToChatItemAction", "ForwardItemAction", "FuncListItem", "IFuncListItemCreator", "DialogAction", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnlineVideoGalleryFuncListViewModel extends ViewModel implements CoroutineScope {
    private final MutableSharedFlow<List<d>> _funcListItems;
    private final MutableSharedFlow<Boolean> _hasItems;
    private final CoroutineContext coroutineContext;
    private final d1<List<d>> funcListItems;
    private final d1<Boolean> hasItems;
    private final OperateListener operateListener;
    private final PhotoItem photoItem;
    private boolean showCopyVideo;
    private boolean showForward;
    private boolean showJumpToChat;
    private boolean showSaveToDriver;
    private boolean showSaveVideo;

    public final class a extends b implements e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OnlineVideoGalleryFuncListViewModel f447287c;

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.b
        public final String b() {
            return "COPY_IMAGE";
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final boolean enable() {
            return OnlineVideoGalleryFuncListViewModel.access$getShowCopyVideo$p(this.f447287c);
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final d a() {
            String r100 = UIUtils.getString(getContext(), R.string.Lark_Legacy_Copy);
            Intrinsics.checkNotNull(r100);
            return new d(new com.larksuite.component.ui.dialog.h(r100, 0), r100, this);
        }

        public a(Context r100, OperateListener r101, OnlineVideoGalleryFuncListViewModel r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateListener");
            Intrinsics.checkNotNullParameter(r102, "viewModel");
            super(r100, r101);
            this.f447287c = r102;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f447288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OperateListener f447289b;

        public abstract String b();

        public final Context getContext() {
            return this.f447288a;
        }

        public b(Context r100, OperateListener r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateListener");
            this.f447288a = r100;
            this.f447289b = r101;
        }
    }

    public final class c extends b implements e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OnlineVideoGalleryFuncListViewModel f447290c;

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.b
        public final String b() {
            return "FORWARD";
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final d a() {
            String r100 = UIUtils.getString(getContext(), R.string.Lark_Legacy_MenuForward);
            Intrinsics.checkNotNull(r100);
            return new d(new com.larksuite.component.ui.dialog.h(r100), r100, this);
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final boolean enable() {
            boolean r100 = com.ss.android.lark.widget.photopicker.f.a().t();
            if (OnlineVideoGalleryFuncListViewModel.access$getShowForward$p(this.f447290c) == false) goto L6;
            if (r100 == false) goto L6;
            return true;
        L6:
            return false;
        }

        public c(Context r100, OperateListener r101, OnlineVideoGalleryFuncListViewModel r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateListener");
            Intrinsics.checkNotNullParameter(r102, "viewModel");
            super(r100, r101);
            this.f447290c = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larksuite.component.ui.dialog.h f447291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f447292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f447293c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f447291a, r101.f447291a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f447292b, r101.f447292b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f447293c, r101.f447293c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f447291a.hashCode() * 31) + this.f447292b.hashCode()) * 31) + this.f447293c.hashCode();
        }

        public final String toString() {
            return "FuncListItem(menuItem=" + this.f447291a + ", desc=" + this.f447292b + ", action=" + this.f447293c + ')';
        }

        public d(com.larksuite.component.ui.dialog.h r100, String r101, b r102) {
            Intrinsics.checkNotNullParameter(r100, "menuItem");
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            Intrinsics.checkNotNullParameter(r102, "action");
            this.f447291a = r100;
            this.f447292b = r101;
            this.f447293c = r102;
        }
    }

    public interface e {
        d a();

        boolean enable();
    }

    public final class f extends b implements e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OnlineVideoGalleryFuncListViewModel f447294c;

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.b
        public final String b() {
            return "JUMP_TO_CHAT";
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final boolean enable() {
            MessageIdentity r100 = this.f447294c.getPhotoItem().getMessageIdentity();
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L9:
            if (OnlineVideoGalleryFuncListViewModel.access$getShowJumpToChat$p(this.f447294c) == false) goto L12;
            if (r101 == true) goto L12;
            return true;
        L12:
            return false;
        L5:
            if (r100.isHideJumpChat() == false) goto L7;
            r101 = true;
            goto L9
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final d a() {
            String r100 = UIUtils.getString(getContext(), R.string.Lark_Legacy_JumpToChat);
            Intrinsics.checkNotNull(r100);
            return new d(new com.larksuite.component.ui.dialog.h(r100), r100, this);
        }

        public f(Context r100, OperateListener r101, OnlineVideoGalleryFuncListViewModel r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateListener");
            Intrinsics.checkNotNullParameter(r102, "viewModel");
            super(r100, r101);
            this.f447294c = r102;
        }
    }

    public final class g extends b implements e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OnlineVideoGalleryFuncListViewModel f447295c;

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.b
        public final String b() {
            return "SAVE_VIDEO";
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final boolean enable() {
            return OnlineVideoGalleryFuncListViewModel.access$getShowSaveVideo$p(this.f447295c);
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final d a() {
            String r100 = UIUtils.getString(getContext(), R.string.Lark_Legacy_SaveVideoMenu);
            Intrinsics.checkNotNull(r100);
            return new d(new com.larksuite.component.ui.dialog.h(r100, 0), r100, this);
        }

        public g(Context r100, OperateListener r101, OnlineVideoGalleryFuncListViewModel r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateListener");
            Intrinsics.checkNotNullParameter(r102, "viewModel");
            super(r100, r101);
            this.f447295c = r102;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel$generateFuncListItems$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel$generateFuncListItems$1", f = "OnlineVideoGalleryFuncListViewModel.kt", i = {}, l = {64, 66}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WeakReference<Context> $contextRef;
        final /* synthetic */ boolean $onlyCheck;
        int label;
        final /* synthetic */ OnlineVideoGalleryFuncListViewModel this$0;

        public AnonymousClass1(WeakReference<Context> r100, boolean r101, OnlineVideoGalleryFuncListViewModel r102, Continuation<? super AnonymousClass1> r103) {
            this.$contextRef = r100;
            this.$onlyCheck = r101;
            this.this$0 = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$contextRef, this.$onlyCheck, this.this$0, r101);
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
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            boolean r103 = true;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L46:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r100);
            Context r104 = this.$contextRef.get();
            if (r104 == null) goto L13;
            ArrayList r105 = new ArrayList();
            OnlineVideoGalleryFuncListViewModel r106 = this.this$0;
            r105.add(new g(r104, r106.getOperateListener(), r106));
            if (OnlineVideoGalleryFuncListViewModel.access$getShowCopyVideo$p(r106) == false) goto L17;
            r105.add(new a(r104, r106.getOperateListener(), r106));
        L17:
            r105.add(new h(r104, r106.getOperateListener(), r106));
            r105.add(new f(r104, r106.getOperateListener(), r106));
            r105.add(new c(r104, r106.getOperateListener(), r106));
            if (this.$onlyCheck == true) goto L32;
            MutableSharedFlow r107 = OnlineVideoGalleryFuncListViewModel.access$get_funcListItems$p(this.this$0);
            ArrayList r108 = new ArrayList();
            Iterator r109 = r105.iterator();
        L21:
            if (r109.hasNext() == false) goto L25;
            Object r110 = r109.next();
            if (((e) r110).enable() == false) goto L21;
            r108.add(r110);
            goto L21
        L25:
            ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
            Iterator r112 = r108.iterator();
        L27:
            if (r112.hasNext() == false) goto L29;
            r111.add(((e) r112.next()).a());
            goto L27
        L29:
            List r113 = CollectionsKt.toMutableList(r111);
            this.label = 1;
            if (r107.emit(r113, this) != r101) goto L46;
            return r101;
        L32:
            MutableSharedFlow r114 = OnlineVideoGalleryFuncListViewModel.access$get_hasItems$p(this.this$0);
            if (r105.isEmpty() == true) goto L41;
            Iterator r115 = r105.iterator();
        L37:
            if (r115.hasNext() == false) goto L41;
            if (((e) r115.next()).enable() == false) goto L37;
        L42:
            Boolean r116 = Boxing.boxBoolean(r103);
            this.label = 2;
            if (r114.emit(r116, this) != r101) goto L46;
            return r101;
        L41:
            r103 = false;
            goto L42
        L13:
            return Unit.INSTANCE;
        }
    }

    public final class h extends b implements e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OnlineVideoGalleryFuncListViewModel f447296c;

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.b
        public final String b() {
            return "SAVE_TO_DRIVER";
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final d a() {
            String r100 = UIUtils.getString(getContext(), R.string.Lark_Legacy_SaveFileToDrive);
            Intrinsics.checkNotNull(r100);
            return new d(new com.larksuite.component.ui.dialog.h(r100), r100, this);
        }

        @Override // com.ss.android.lark.widget.photo.preview.video.online.OnlineVideoGalleryFuncListViewModel.e
        public final boolean enable() {
            boolean r100 = com.ss.android.lark.widget.photopicker.f.a().isPrimaryHost();
            MessageIdentity r101 = this.f447296c.getPhotoItem().getMessageIdentity();
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r100 == true) goto L10;
        L13:
            return false;
        L10:
            if (OnlineVideoGalleryFuncListViewModel.access$getShowSaveToDriver$p(this.f447296c) == false) goto L13;
            if (r102 == true) goto L13;
            return true;
        L5:
            if (r101.isHideSaveToDriver() == false) goto L7;
            r102 = true;
            goto L8
        }

        public h(Context r100, OperateListener r101, OnlineVideoGalleryFuncListViewModel r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateListener");
            Intrinsics.checkNotNullParameter(r102, "viewModel");
            super(r100, r101);
            this.f447296c = r102;
        }
    }

    public final void destroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CoroutineScopeKt.cancel$default(this, null, 1, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final d1<List<d>> getFuncListItems() {
        return this.funcListItems;
    }

    public final d1<Boolean> getHasItems() {
        return this.hasItems;
    }

    public final OperateListener getOperateListener() {
        return this.operateListener;
    }

    public final PhotoItem getPhotoItem() {
        return this.photoItem;
    }

    public static final /* synthetic */ boolean access$getShowCopyVideo$p(OnlineVideoGalleryFuncListViewModel r100) {
        return r100.showCopyVideo;
    }

    public static final /* synthetic */ boolean access$getShowForward$p(OnlineVideoGalleryFuncListViewModel r100) {
        return r100.showForward;
    }

    public static final /* synthetic */ boolean access$getShowJumpToChat$p(OnlineVideoGalleryFuncListViewModel r100) {
        return r100.showJumpToChat;
    }

    public static final /* synthetic */ boolean access$getShowSaveToDriver$p(OnlineVideoGalleryFuncListViewModel r100) {
        return r100.showSaveToDriver;
    }

    public static final /* synthetic */ boolean access$getShowSaveVideo$p(OnlineVideoGalleryFuncListViewModel r100) {
        return r100.showSaveVideo;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_funcListItems$p(OnlineVideoGalleryFuncListViewModel r100) {
        return r100._funcListItems;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_hasItems$p(OnlineVideoGalleryFuncListViewModel r100) {
        return r100._hasItems;
    }

    public final OnlineVideoGalleryFuncListViewModel showCopyVideo(boolean r100) {
        this.showCopyVideo = r100;
        return this;
    }

    public final OnlineVideoGalleryFuncListViewModel showForward(boolean r100) {
        this.showForward = r100;
        return this;
    }

    public final OnlineVideoGalleryFuncListViewModel showJumpToChat(boolean r100) {
        this.showJumpToChat = r100;
        return this;
    }

    public final OnlineVideoGalleryFuncListViewModel showSaveToDriver(boolean r100) {
        this.showSaveToDriver = r100;
        return this;
    }

    public final OnlineVideoGalleryFuncListViewModel showSaveVideo(boolean r100) {
        this.showSaveVideo = r100;
        return this;
    }

    public OnlineVideoGalleryFuncListViewModel(PhotoItem r100, OperateListener r101) {
        Intrinsics.checkNotNullParameter(r100, "photoItem");
        Intrinsics.checkNotNullParameter(r101, "operateListener");
        this.photoItem = r100;
        this.operateListener = r101;
        this.coroutineContext = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
        MutableSharedFlow<List<d>> r102 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._funcListItems = r102;
        this.funcListItems = kotlinx.coroutines.flow.e.a(r102);
        MutableSharedFlow<Boolean> r103 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._hasItems = r103;
        this.hasItems = kotlinx.coroutines.flow.e.a(r103);
    }

    public final void generateFuncListItems(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        WeakReference r102 = new WeakReference(r100);
        BuildersKt.launch$default(this, Dispatchers.getIO(), null, new AnonymousClass1(r102, r101, this, null), 2, null);
    }
}

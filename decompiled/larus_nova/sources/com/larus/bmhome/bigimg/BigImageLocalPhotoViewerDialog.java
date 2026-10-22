package com.larus.bmhome.bigimg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.common_ui.image.CustomPhotoTransitionPagerAdapter;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.bmhome.dora.IDoraEService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000208H\u0016J\u0018\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\tH\u0002J\u000f\u0010=\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000208H\u0002J \u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020$J\u0010\u0010G\u001a\u0002082\u0006\u0010H\u001a\u00020$H\u0002J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020$H\u0002J\u0010\u0010K\u001a\u0002082\u0006\u0010J\u001a\u00020$H\u0002J\b\u0010L\u001a\u000208H\u0002J\"\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020\t2\u0006\u0010;\u001a\u00020$2\b\b\u0002\u0010O\u001a\u00020\rH\u0002J\u0010\u0010P\u001a\u0002082\u0006\u0010F\u001a\u00020$H\u0002J\u0010\u0010Q\u001a\u0002082\u0006\u0010;\u001a\u00020$H\u0002J\u001e\u0010R\u001a\u0002082\f\u0010S\u001a\b\u0012\u0004\u0012\u0002080T2\u0006\u0010U\u001a\u00020\tH\u0016J\n\u0010V\u001a\u00020\t*\u00020\tJ(\u0010W\u001a\u0002082\u0006\u0010F\u001a\u00020$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\tJ\u0010\u0010\f\u001a\u0002082\u0006\u0010;\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020$0.j\b\u0012\u0004\u0012\u00020$`/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/larus/bmhome/bigimg/BigImageLocalPhotoViewerDialog;", "Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "Lcom/larus/bmhome/bigimg/IHandleMoreAction;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageUrls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "thumbImageUrls", "", "reportParams", "Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;", "showIndicator", "", "actionCallback", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;ZLcom/larus/bmhome/bigimg/IHandleMoreAction;)V", "getImageUrls", "()Ljava/util/List;", "setImageUrls", "(Ljava/util/List;)V", "getActionCallback", "()Lcom/larus/bmhome/bigimg/IHandleMoreAction;", "share", "Landroid/widget/ImageView;", "download", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "more", "Landroidx/appcompat/widget/AppCompatImageView;", "backIcon", "timeView", "Landroid/widget/TextView;", "poiView", "titleBar", "Landroid/view/ViewGroup;", "safeCurrentPos", "", "getSafeCurrentPos", "()I", "previousIndex", DyPayConstant.KEY_START_TIME, "", "loadedIndexList", "", "filteredIndexList", "enterPicDetailEventHistory", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "imageChangedByScrollListener", "Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;", "getImageChangedByScrollListener", "()Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;", "setImageChangedByScrollListener", "(Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;)V", "isTransition", "onAttachedToWindow", "", "onDetachedFromWindow", "reportEnterPicDetailEvent", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "enterMethod", "getExtraViewLayout", "()Ljava/lang/Integer;", "initIconListeners", "handleMediaReplaced", "mediaId", "newPath", "mediaItem", "Lcom/larus/bmhome/bigimg/MediaItem;", "refreshCurrentDisplayedMedia", "position", "performDirectDelete", "deletePos", "cleanupStatesAfterDelete", "deletedPos", "updateIndexesAfterDelete", "updateUIAfterDelete", "onDoShareAction", "source", "onlyShare", "updateIconStatus", "refreshMoreIcon", "handleDelete", "confirmCallback", "Lkotlin/Function0;", "path", "removeFileUriPrefix", "showAnimatedSafely", "view", "Landroid/view/View;", "enableRestoreTransition", "tag", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BigImageLocalPhotoViewerDialog extends CustomPhotoViewerDialog implements l1 {
    public static final /* synthetic */ int H = 0;
    public final ViewGroup A;
    public int B;
    public final long C;
    public final Set<Integer> D;
    public final Set<Integer> E;
    public final HashSet<Integer> F;
    public boolean G;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f295902q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<n1> f295903r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f295904s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final l1 f295905t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ImageView f295906u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CommonDownLoadLayout f295907v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AppCompatImageView f295908w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f295909x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TextView f295910y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f295911z;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog$8", f = "BigImageLocalPhotoViewerDialog.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BigImageLocalPhotoViewerDialog this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog$8$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog$8$2", f = "BigImageLocalPhotoViewerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BigImageLocalPhotoViewerDialog this$0;

            public AnonymousClass2(BigImageLocalPhotoViewerDialog r100, Continuation<? super AnonymousClass2> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass2(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L22;
                ResultKt.throwOnFailure(r100);
                final BigImageLocalPhotoViewerDialog r101 = this.this$0;
                int r102 = BigImageLocalPhotoViewerDialog.H;
                r101.getClass();
                AppHost.f326268a.isPlugin();
                ImageView r103 = r101.f295906u;
                if (r103 == null) goto L7;
                r103.setVisibility(8);
            L7:
                CommonDownLoadLayout r104 = r101.f295907v;
                if (r104 == null) goto L10;
                com.larus.utils.e1.o(r104);
            L10:
                ImageView r105 = r101.f295906u;
                if (r105 == null) goto L13;
                com.larus.utils.e1.d(r105, new m(r101));
            L13:
                AppCompatImageView r106 = r101.f295908w;
                if (r106 == null) goto L16;
                com.larus.utils.e1.d(r106, new p(r101));
            L16:
                ImageView r107 = r101.f295909x;
                if (r107 == null) goto L20;
                com.larus.utils.e1.d(r107, new q(r101));
            L20:
                return Unit.INSTANCE;
            L22:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass8(BigImageLocalPhotoViewerDialog r100, Continuation<? super AnonymousClass8> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass8(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass8) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            final BigImageLocalPhotoViewerDialog r103 = this.this$0;
            CustomPhotoTransitionPagerAdapter r104 = r103.f310674n;
            r104.f310664n = new a0(r103);
            MainCoroutineDispatcher r105 = Dispatchers.getMain();
            AnonymousClass2 r106 = new AnonymousClass2(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r105, r106, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/bigimg/BigImageLocalPhotoViewerDialog$Companion$ButtonStatus;", "", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface ButtonStatus {
            public static final int AddedPrivate = 2;
            public static final int AddedPublic = 3;
            public static final a Companion = null;
            public static final int Disable = 0;
            public static final int UnAdd = 1;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f295912a = null;

                static {
                    f295912a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f295912a;
            }
        }
    }

    static {
    }

    public final int l() {
        if (this.f327631f <= (this.f295903r.size() - 1)) goto L6;
        return this.f295903r.size() - 1;
    L6:
        return this.f327631f;
    }

    @Override // com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog
    public final Integer g() {
        return Integer.valueOf(R.layout.larus_layout_dora_ablum_big_image_extra);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean r100 = g.f295983a;
        g.f295983a = true;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boolean r100 = g.f295983a;
        g.f295983a = false;
    }

    public static void i(BigImageLocalPhotoViewerDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void j(int r100) {
        this.D.remove(Integer.valueOf(r100));
        this.E.remove(Integer.valueOf(r100));
        this.F.remove(Integer.valueOf(r100));
        Set<Integer> r101 = this.D;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L3:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L10;
        Object r105 = r103.next();
        if (((Number) r105).intValue() <= r100) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L3;
        r102.add(r105);
        goto L3
    L10:
        Iterator r106 = r102.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        int r107 = ((Number) r106.next()).intValue();
        this.D.remove(Integer.valueOf(r107));
        this.D.add(Integer.valueOf(r107 - 1));
        goto L12
    L14:
        Set<Integer> r108 = this.E;
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L16:
        if (r110.hasNext() == false) goto L23;
        Object r111 = r110.next();
        if (((Number) r111).intValue() <= r100) goto L20;
        boolean r112 = true;
    L21:
        if (r112 == false) goto L16;
        r109.add(r111);
        goto L16
    L20:
        r112 = false;
        goto L21
    L23:
        Iterator r113 = r109.iterator();
    L25:
        if (r113.hasNext() == false) goto L27;
        int r114 = ((Number) r113.next()).intValue();
        this.E.remove(Integer.valueOf(r114));
        this.E.add(Integer.valueOf(r114 - 1));
        goto L25
    L27:
        HashSet<Integer> r115 = this.F;
        ArrayList r116 = new ArrayList();
        Iterator<Integer> r117 = r115.iterator();
    L29:
        if (r117.hasNext() == false) goto L36;
        Integer r118 = r117.next();
        if (r118.intValue() <= r100) goto L33;
        boolean r119 = true;
    L34:
        if (r119 == false) goto L29;
        r116.add(r118);
        goto L29
    L33:
        r119 = false;
        goto L34
    L36:
        Iterator r120 = r116.iterator();
    L38:
        if (r120.hasNext() == false) goto L40;
        int r121 = ((Number) r120.next()).intValue();
        this.F.remove(Integer.valueOf(r121));
        this.F.add(Integer.valueOf(r121 - 1));
        goto L38
    }

    public final void o(int r100) {
        t1 r101 = ((n1) ListProtector.get(this.f295903r, r100)).f296031b;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L11;
        AppCompatImageView r103 = this.f295908w;
        if (r103 == null) goto L15;
        com.larus.utils.e1.o(r103);
        return;
    L15:
        return;
    L11:
        AppCompatImageView r104 = this.f295908w;
        if (r104 == null) goto L17;
        com.larus.utils.e1.x(r104);
        return;
    L17:
        return;
    L5:
        if (r101.d() != true) goto L7;
        r102 = true;
        goto L7
    }

    public final void q(int r110) {
        t1 r100 = ((n1) ListProtector.get(this.f295903r, r110)).f296031b;
        Long r101 = null;
        if (r100 == null) goto L7;
        GeoLocationInfo r102 = r100.a();
        if (r102 == null) goto L7;
        String r103 = r102.getPoi();
    L8:
        boolean r104 = true;
        if (r103 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L19;
        TextView r106 = this.f295911z;
        if (r106 == null) goto L25;
        com.larus.utils.e1.o(r106);
    L25:
        int r107 = com.larus.utils.j0.f375426a;
        String r108 = com.larus.utils.j0.d(R.string.larus_dora_album_year_cn);
        String r109 = com.larus.utils.j0.d(R.string.larus_dora_album_month_cn);
        String r111 = com.larus.utils.j0.d(R.string.larus_dora_album_day_cn);
        if (r103 == null) goto L32;
        if (r103.length() == 0) goto L32;
        r104 = false;
    L32:
        if (r104 == false) goto L34;
        String r112 = "yyyy" + r108 + "MM" + r109 + "dd" + r111 + "\nHH:mm:ss";
    L35:
        SimpleDateFormat r113 = new SimpleDateFormat(r112, Locale.CHINA);
        t1 r114 = ((n1) ListProtector.get(this.f295903r, r110)).f296031b;
        if (r114 == null) goto L38;
        r101 = Long.valueOf(r114.e());
    L38:
        if (r101 == null) goto L43;
        long r115 = r101.longValue();
        TextView r116 = this.f295910y;
        if (r116 == null) goto L44;
        r116.setText(r113.format(Long.valueOf(r115)));
        return;
    L44:
        return;
    L43:
        return;
    L34:
        r112 = "yyyy" + r108 + "MM" + r109 + "dd" + r111 + " HH:mm:ss";
        goto L35
    L19:
        TextView r117 = this.f295911z;
        if (r117 == null) goto L22;
        r117.setText(r103);
    L22:
        TextView r118 = this.f295911z;
        if (r118 == null) goto L25;
        com.larus.utils.e1.x(r118);
        goto L25
    L11:
        if (r103.length() == 0) goto L14;
        r105 = false;
    L7:
        r103 = null;
        goto L8
    }

    public final void r(int r100) {
        if (r100 == this.f327631f) goto L5;
        return;
    L5:
        ImageView r101 = this.f295906u;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.D.contains(Integer.valueOf(r100)) == true) goto L10;
    L12:
        boolean r102 = false;
    L13:
        r101.setEnabled(r102);
        return;
    L10:
        if (this.E.contains(Integer.valueOf(r100)) == true) goto L12;
        r102 = true;
        goto L13
    }

    @Override // com.larus.bmhome.bigimg.l1
    public final void a(final Function0<Unit> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "confirmCallback");
        Intrinsics.checkNotNullParameter(r101, "path");
        l1 r102 = this.f295905t;
        if (r102 == null) goto L6;
        r102.a(new o(r100), r101);
        return;
    }

    public final void p(int r100, String r101) {
        if (this.F.contains(Integer.valueOf(r100)) == true) goto L6;
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = h(r100);
        r103.put("enter_method", r101);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("enter_picture_detail", r103);
        this.F.add(Integer.valueOf(r100));
        return;
    }

    public final void m(String r100, String r101, t1 r102) {
        Intrinsics.checkNotNullParameter(r100, "mediaId");
        Intrinsics.checkNotNullParameter(r101, "newPath");
        FLogger.f375446a.i("BigImagePhotoViewer", "handleMediaReplaced: mediaId=" + r100 + ", newPath=" + r101);
        if (r102 != null) goto L5;
        return;
    L5:
        List<n1> r103 = CollectionsKt.toMutableList(this.f295903r);
        int r104 = r103.size();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L16;
        t1 r106 = ((n1) ListProtector.get(r103, r105)).f296031b;
        if (r106 == null) goto L11;
        String r107 = r106.g();
    L13:
        if (Intrinsics.areEqual(r107, r100) == true) goto L14;
        r105 = r105 + 1;
        goto L7
    L14:
        ListProtector.set(r103, r105, new n1(r101, r102));
    L17:
        if (r105 != (-1)) goto L20;
        FLogger.f375446a.w("BigImagePhotoViewer", "Media not found for replacement: " + r100);
        return;
    L20:
        this.f295903r = r103;
        o(l());
        this.f310674n.B2(r103);
        this.f310674n.notifyItemChanged(r105);
        return;
    L11:
        r107 = null;
        goto L13
    L16:
        r105 = -1;
        goto L17
    }

    public final void n(String r100, int r101, boolean r102) {
        ShareServiceDelegate r103 = ShareServiceDelegate.f313831b;
        JSONObject r104 = h(r101);
        r104.put("click_method", r100);
        r103.w(r104);
        if (this.D.contains(Integer.valueOf(r101)) == true) goto L5;
        return;
    L5:
        if (this.E.contains(Integer.valueOf(r101)) == true) goto L54;
        if (r101 < 0) goto L50;
        List<n1> r105 = this.f310674n.f310661k;
        if (r105 == null) goto L11;
        int r106 = r105.size();
    L12:
        if (r101 >= r106) goto L55;
        CustomPhotoTransitionPagerAdapter r107 = this.f310674n;
        int r108 = this.f327631f;
        List<n1> r109 = r107.f310661k;
        if (r109 == null) goto L32;
        n1 r110 = (n1) CollectionsKt.getOrNull(r109, r108);
        if (r110 == null) goto L32;
        String r111 = r110.f296032c;
        String r112 = null;
        if (r111 == null) goto L30;
        String r113 = StringsKt.substringBefore$default(r111, "?", null, 2, null);
        if (r113 == null) goto L30;
        String r114 = StringsKt.substringBefore$default(r113, "#", null, 2, null);
        if (r114 == null) goto L30;
        String r115 = StringsKt.substringAfterLast$default(r114, HTTP.URL_DEFAULT, null, 2, null);
        if (r115 == null) goto L30;
        String r116 = r115.toLowerCase(Locale.ROOT);
        if (r116 == null) goto L30;
        r112 = StringsKt.substringAfterLast$default(r116, ".", null, 2, null);
    L30:
        if (Intrinsics.areEqual(r112, "mp4") == false) goto L32;
        char r117 = 2;
    L33:
        if (r117 == 1) goto L42;
        if (r117 != 2) goto L56;
        String r118 = ((n1) ListProtector.get(this.f295903r, r101)).f296032c;
        if (r118 != null) goto L39;
        return;
    L39:
        IDoraEService r119 = (IDoraEService) ServiceManager.get().getService(IDoraEService.class);
        if (r119 == null) goto L51;
        r119.a(r118);
        return;
    L51:
        return;
    L56:
        return;
    L42:
        String r120 = ((n1) ListProtector.get(this.f295903r, r101)).f296032c;
        if (r120 != null) goto L45;
        return;
    L45:
        IDoraEService r121 = (IDoraEService) ServiceManager.get().getService(IDoraEService.class);
        if (r121 == null) goto L53;
        r121.d(CollectionsKt.listOf(r120), r102);
        return;
    L53:
        return;
    L32:
        r117 = 1;
        goto L33
    L55:
        return;
    L11:
        r106 = 0;
        goto L12
    L50:
        return;
    }

    public BigImageLocalPhotoViewerDialog(Context r100, List r101, uo8.k r102, boolean r110, l1 r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageUrls");
        Intrinsics.checkNotNullParameter(r102, "reportParams");
        super(r100, r101, null, r102);
        this.f295902q = r100;
        this.f295903r = r101;
        this.f295904s = r110;
        this.f295905t = r111;
        this.B = -1;
        this.D = new LinkedHashSet();
        this.E = new LinkedHashSet();
        this.F = new HashSet();
        this.C = System.currentTimeMillis();
        CustomPhotoTransitionPagerAdapter r103 = this.f310674n;
        Function1<? super Integer, Unit> r104 = new s(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f310663m = r104;
        CustomPhotoTransitionPagerAdapter r105 = this.f310674n;
        r105.f310665o = new t(this);
        y r106 = new y(this);
        Intrinsics.checkNotNullParameter(r106, "transitionListener");
        r105.f327750c.add(r106);
        this.f327629d = new z(this);
        setOnDismissListener(new u(this));
        setOnShowListener(new v(this));
        this.f295908w = (AppCompatImageView) this.f327628c.findViewById(R.id.more);
        this.f295906u = (ImageView) this.f327628c.findViewById(R.id.share);
        this.f295907v = (CommonDownLoadLayout) this.f327628c.findViewById(R.id.download_layout);
        this.f295909x = (ImageView) this.f327628c.findViewById(R.id.back);
        this.f295910y = (TextView) this.f327628c.findViewById(R.id.image_item_time);
        this.f295911z = (TextView) this.f327628c.findViewById(R.id.image_item_poi);
        ViewGroup r107 = (ViewGroup) this.f327628c.findViewById(R.id.titleBar);
        this.A = r107;
        if (r107 == null) goto L9;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L8;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        com.larus.utils.i0.f375410a.getClass();
        r109.topMargin = com.larus.utils.i0.g() + i5.r0();
        r107.setLayoutParams(r109);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass8(this, null), 3, null);
    }
}

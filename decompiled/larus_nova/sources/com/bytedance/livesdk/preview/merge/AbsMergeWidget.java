package com.bytedance.livesdk.preview.merge;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.WidgetCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.livesdk.preview.base.PreviewWidgetState;
import com.bytedance.livesdk.preview.event.VHDispatcher;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002mnB\u0007¢\u0006\u0004\bk\u0010lJ\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J>\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000f*\u00020\u000e2#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0010¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000f*\u00020\u000e2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0017J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH&J\b\u0010\"\u001a\u00020\u0005H\u0017J\b\u0010#\u001a\u00020\fH&J\f\u0010%\u001a\u00020\u0005*\u00020$H\u0005J \u0010)\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001cH\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\fH&J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016JD\u00105\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001c2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001c2\n\b\u0002\u00102\u001a\u0004\u0018\u00010/2\u0018\b\u0002\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u000103R$\u00106\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010\u0014\u001a\u00020\u00118\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010L\u001a\u00020K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0011\u0010i\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bi\u0010j¨\u0006o"}, d2 = {"Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "Lcom/bytedance/android/livesdk/utils/WidgetCompat;", "Ld70/a;", "Lh70/b;", "Lkotlin/Function0;", "", "action", "handleSubscribeEvent", "", "e", "postMergeError", "breakUpEvent", "", "subscribeDirect", "", "R", "Lkotlin/Function1;", "Lcom/bytedance/livesdk/preview/merge/MergeDataContext;", "Lkotlin/ParameterName;", "name", "mergeContext", "consumer", "runOnLivePreview", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "runOnLiveInner", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", "getMergeTag", "onMergeLoad", "Lcom/bytedance/livesdk/preview/event/b;", "event", "handleLifeEvent", "onMergeUnLoad", "isInnerPreviewNeedUnbind", "Lio/reactivex/disposables/Disposable;", "autoDispose", "status", "callWidgetTag", "changeWidgetTag", "otherWidgetVisibilityChange", LiveCommonConstants.REASON_ON_DEDTROY, "isPreviewWidget", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget$a;", "getSubService", "businesskey", "Landroid/os/Bundle;", "businessBundle", "clickMethod", "firstRoomLogParams", "", "commonLogParams", "mergeEnterRoomWithAction", "componentContext", "Lh70/b;", "getComponentContext", "()Lh70/b;", "setComponentContext", "(Lh70/b;)V", "Lj70/f;", "elementType", "Lj70/f;", "getElementType", "()Lj70/f;", "setElementType", "(Lj70/f;)V", "Lio/reactivex/disposables/CompositeDisposable;", "mergeCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/livesdk/preview/merge/MergeDataContext;", "getMergeContext", "()Lcom/bytedance/livesdk/preview/merge/MergeDataContext;", "setMergeContext", "(Lcom/bytedance/livesdk/preview/merge/MergeDataContext;)V", "Lcom/bytedance/livesdk/preview/base/PreviewWidgetState;", "mergeStatus", "Lcom/bytedance/livesdk/preview/base/PreviewWidgetState;", "getMergeStatus", "()Lcom/bytedance/livesdk/preview/base/PreviewWidgetState;", "setMergeStatus", "(Lcom/bytedance/livesdk/preview/base/PreviewWidgetState;)V", "Lcom/bytedance/livesdk/preview/merge/a;", "mergeWidgetManager", "Lcom/bytedance/livesdk/preview/merge/a;", "getMergeWidgetManager", "()Lcom/bytedance/livesdk/preview/merge/a;", "setMergeWidgetManager", "(Lcom/bytedance/livesdk/preview/merge/a;)V", "Lcom/bytedance/livesdk/preview/viewmodel/c;", "unRecyclableData", "Lcom/bytedance/livesdk/preview/viewmodel/c;", "getUnRecyclableData", "()Lcom/bytedance/livesdk/preview/viewmodel/c;", "setUnRecyclableData", "(Lcom/bytedance/livesdk/preview/viewmodel/c;)V", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget$MergeWidgetEnvironment;", "loadedEnvironment", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget$MergeWidgetEnvironment;", "getLoadedEnvironment", "()Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget$MergeWidgetEnvironment;", "setLoadedEnvironment", "(Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget$MergeWidgetEnvironment;)V", "eventConsumer", "Lkotlin/jvm/functions/Function1;", "isRunOnLivePreview", "()Z", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MergeWidgetEnvironment", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsMergeWidget extends WidgetCompat implements d70.a<h70.b> {
    private h70.b componentContext;
    private j70.f elementType;
    private Function1<? super com.bytedance.livesdk.preview.event.b, Unit> eventConsumer;
    private MergeWidgetEnvironment loadedEnvironment;
    private CompositeDisposable mergeCompositeDisposable;
    public MergeDataContext mergeContext;
    private PreviewWidgetState mergeStatus;
    private com.bytedance.livesdk.preview.merge.a mergeWidgetManager;
    private com.bytedance.livesdk.preview.viewmodel.c unRecyclableData;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget$MergeWidgetEnvironment;", "", "NULL", "PREVIEW", "LIVE", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MergeWidgetEnvironment extends Enum<MergeWidgetEnvironment> {
        public static final MergeWidgetEnvironment LIVE = null;
        public static final MergeWidgetEnvironment NULL = null;
        public static final MergeWidgetEnvironment PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MergeWidgetEnvironment[] f256434a = null;

        static {
            MergeWidgetEnvironment r100 = new MergeWidgetEnvironment("NULL", 0);
            NULL = r100;
            MergeWidgetEnvironment r101 = new MergeWidgetEnvironment("PREVIEW", 1);
            PREVIEW = r101;
            MergeWidgetEnvironment r102 = new MergeWidgetEnvironment("LIVE", 2);
            LIVE = r102;
            f256434a = new MergeWidgetEnvironment[]{r100, r101, r102};
        }

        public static MergeWidgetEnvironment valueOf(String r100) {
            return (MergeWidgetEnvironment) r27.a.a(MergeWidgetEnvironment.class, r100);
        }

        public static MergeWidgetEnvironment[] values() {
            return (MergeWidgetEnvironment[]) f256434a.clone();
        }

        public MergeWidgetEnvironment(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(Throwable r100);
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsMergeWidget f256435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f256436b;

        public b(AbsMergeWidget r100, Function0 r101) {
            this.f256435a = r100;
            this.f256436b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f256435a.getMergeStatus() == PreviewWidgetState.UNLOAD) goto L10;
            this.f256436b.invoke();     // Catch: Throwable -> L7
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsMergeWidget f256437a;

        public c(AbsMergeWidget r100) {
            this.f256437a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final com.bytedance.livesdk.preview.event.b r101 = (com.bytedance.livesdk.preview.event.b) r100;
            AbsMergeWidget.access$handleSubscribeEvent(this.f256437a, new AbsMergeWidget$onMergeLoad$1$1(this, r101));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            AbsMergeWidget.access$postMergeError(this.f256437a, e);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsMergeWidget f256438a;

        public d(AbsMergeWidget r100) {
            this.f256438a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            r101.getStackTrace();
            AbsMergeWidget.access$postMergeError(this.f256438a, r101);
            a r102 = this.f256438a.getSubService();
            if (r102 == null) goto L6;
            r102.a(r101);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsMergeWidget f256439a;

        public e(AbsMergeWidget r100) {
            this.f256439a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final com.bytedance.livesdk.preview.event.b r101 = (com.bytedance.livesdk.preview.event.b) r100;
            AbsMergeWidget.access$handleSubscribeEvent(this.f256439a, new AbsMergeWidget$onMergeLoad$3$1(this, r101));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            AbsMergeWidget.access$postMergeError(this.f256439a, e);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsMergeWidget f256440a;

        public f(AbsMergeWidget r100) {
            this.f256440a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            r101.getStackTrace();
            a r102 = this.f256440a.getSubService();
            if (r102 == null) goto L5;
            r102.a(r101);
        L5:
            AbsMergeWidget.access$postMergeError(this.f256440a, r101);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsMergeWidget f256441a;

        public g(AbsMergeWidget r100) {
            this.f256441a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AbsMergeWidget r101 = this.f256441a;
            ((com.bytedance.livesdk.preview.merge.b) r100).getClass();
            r101.otherWidgetVisibilityChange(false, null, null);
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f256442a;

        public h(Throwable r100) {
            this.f256442a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        L3:
            throw this.f256442a;     // Catch: Throwable -> L4
        }
    }

    /* JADX INFO: renamed from: com.bytedance.livesdk.preview.merge.AbsMergeWidget$runOnLivePreview$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(AbsMergeWidget r100) {
            super(r100, AbsMergeWidget.class, "mergeContext", "getMergeContext()Lcom/bytedance/livesdk/preview/merge/MergeDataContext;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((AbsMergeWidget) this.receiver).getMergeContext();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            ((AbsMergeWidget) this.receiver).setMergeContext((MergeDataContext) r100);
        }
    }

    public a getSubService() {
        return null;
    }

    public abstract void handleLifeEvent(com.bytedance.livesdk.preview.event.b r100);

    public abstract boolean isInnerPreviewNeedUnbind();

    public abstract boolean isPreviewWidget();

    public void otherWidgetVisibilityChange(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "callWidgetTag");
        Intrinsics.checkNotNullParameter(r102, "changeWidgetTag");
    }

    public boolean subscribeDirect() {
        return false;
    }

    public final MergeDataContext getMergeContext() {
        MergeDataContext r100 = this.mergeContext;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mergeContext");
    L5:
        return r100;
    }

    public final boolean isRunOnLivePreview() {
        if (this.loadedEnvironment != MergeWidgetEnvironment.PREVIEW) goto L5;
        return true;
    L5:
        return false;
    }

    public void onMergeLoad() {
        CompositeDisposable r100 = this.mergeCompositeDisposable;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.mergeCompositeDisposable = new CompositeDisposable();
        if (isPreviewWidget() == true) goto L8;
        MergeDataContext r101 = this.mergeContext;
        if (r101 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mergeContext");
    L22:
        Disposable r102 = r101.getMergeEvent().onEvent().subscribe(new e(this), new f(this));
        if (r102 == null) goto L25;
        autoDispose(r102);
    L25:
        MergeDataContext r103 = this.mergeContext;
        if (r103 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mergeContext");
    L28:
        Disposable r104 = r103.getOtherWidgetVisibilityChange().onEvent().subscribe(new g(this));
        if (r104 == null) goto L32;
        autoDispose(r104);
        return;
    L32:
        return;
    L8:
        if (subscribeDirect() == false) goto L13;
        MergeDataContext r105 = this.mergeContext;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mergeContext");
    L12:
        VHDispatcher r106 = r105.getVhDispatcher();
        Function1<? super com.bytedance.livesdk.preview.event.b, Unit> r107 = this.eventConsumer;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "consumer");
        ((List) r106.f256430a.getValue()).add(r107);
        autoDispose(new com.bytedance.livesdk.preview.event.a(r106, r107));
        goto L25
    L13:
        MergeDataContext r108 = this.mergeContext;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mergeContext");
    L16:
        Disposable r109 = r108.getVhEvent().onEvent().subscribe(new c(this), new d(this));
        if (r109 == null) goto L25;
        autoDispose(r109);
        goto L25
    }

    public AbsMergeWidget() {
        this.mergeStatus = PreviewWidgetState.UNLOAD;
        this.loadedEnvironment = MergeWidgetEnvironment.NULL;
        this.eventConsumer = new AbsMergeWidget$eventConsumer$1(this);
    }

    public String getMergeTag() {
        return getClass().getSimpleName();
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        super.onDestroy();
        if (this.loadedEnvironment == MergeWidgetEnvironment.PREVIEW) goto L6;
        this.mergeWidgetManager = null;
        return;
    }

    public void onMergeUnLoad() {
        if (isInnerPreviewNeedUnbind() == false) goto L5;
        handleLifeEvent(com.bytedance.livesdk.preview.event.b.g.f256433a);
    L5:
        CompositeDisposable r100 = this.mergeCompositeDisposable;
        if (r100 == null) goto L9;
        r100.dispose();
    L9:
        if (this.loadedEnvironment != MergeWidgetEnvironment.PREVIEW) goto L12;
        this.mergeWidgetManager = null;
        return;
    }

    @Override // d70.a
    public h70.b getComponentContext() {
        return this.componentContext;
    }

    @Override // d70.a
    public j70.f getElementType() {
        return this.elementType;
    }

    @Override // com.bytedance.android.livesdk.utils.WidgetCompat, com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return this.lifecycleRegistry;
    }

    public final MergeWidgetEnvironment getLoadedEnvironment() {
        return this.loadedEnvironment;
    }

    public final PreviewWidgetState getMergeStatus() {
        return this.mergeStatus;
    }

    public final com.bytedance.livesdk.preview.merge.a getMergeWidgetManager() {
        return this.mergeWidgetManager;
    }

    public final com.bytedance.livesdk.preview.viewmodel.c getUnRecyclableData() {
        return this.unRecyclableData;
    }

    private final void breakUpEvent(Function0<Unit> r100) {
        if (LiveInfraSettingKeys.LIVE_PREVIEW_PLAYER_POST_OPT.getValue().booleanValue() == true) goto L5;
        i0.c().postAtTime(new b(this, r100), 5);
        return;
    L5:
        if (this.mergeStatus != PreviewWidgetState.UNLOAD) goto L7;
        return;
    L7:
        r100.invoke();
    }

    private final void handleSubscribeEvent(Function0<Unit> r100) {
        if (this.mergeStatus != PreviewWidgetState.UNLOAD) goto L5;
        return;
    L5:
        r100.invoke();
    }

    private final void postMergeError(Throwable r100) {
        if (v.a() == false) goto L5;
    L6:
        i0.h(new h(r100));
        return;
    L5:
        if (LiveInfraSettingKeys.LIVE_PREVIEW_THROW_EXCEPTION.getValue().booleanValue() == true) goto L6;
    }

    @Deprecated(message = "该方法只会在widget销毁时(activity销毁)执行dispose，请自行处理dispose逻辑")
    public final void autoDispose(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        CompositeDisposable r101 = this.mergeCompositeDisposable;
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    public final <R> R runOnLiveInner(Function0<? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        if (this.loadedEnvironment == MergeWidgetEnvironment.LIVE) goto L5;
        return null;
    L5:
        return r100.invoke();
    }

    public final <R> R runOnLivePreview(Function1<? super MergeDataContext, ? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        if (isRunOnLivePreview() == false) goto L10;
        MergeDataContext r101 = this.mergeContext;
        if (r101 == null) goto L12;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mergeContext");
    L9:
        return r100.invoke(r101);
    L12:
        return null;
    L10:
        return null;
    }

    @Override // d70.a
    public void setComponentContext(h70.b r100) {
        this.componentContext = r100;
    }

    @Override // d70.a
    public void setElementType(j70.f r100) {
        this.elementType = r100;
    }

    public final void setLoadedEnvironment(MergeWidgetEnvironment r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadedEnvironment = r100;
    }

    public final void setMergeContext(MergeDataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mergeContext = r100;
    }

    public final void setMergeStatus(PreviewWidgetState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mergeStatus = r100;
    }

    public final void setMergeWidgetManager(com.bytedance.livesdk.preview.merge.a r100) {
        this.mergeWidgetManager = r100;
    }

    public final void setUnRecyclableData(com.bytedance.livesdk.preview.viewmodel.c r100) {
        this.unRecyclableData = r100;
    }

    public static final /* synthetic */ void access$breakUpEvent(AbsMergeWidget r100, Function0 r101) {
        r100.breakUpEvent(r101);
    }

    public static final /* synthetic */ void access$handleSubscribeEvent(AbsMergeWidget r100, Function0 r101) {
        r100.handleSubscribeEvent(r101);
    }

    public static final /* synthetic */ void access$postMergeError(AbsMergeWidget r100, Throwable r101) {
        r100.postMergeError(r101);
    }

    public final void mergeEnterRoomWithAction(String r100, Bundle r110, String r111, Bundle r112, Map<String, String> r113) {
        Intrinsics.checkNotNullParameter(r100, "businesskey");
        Intrinsics.checkNotNullParameter(r110, "businessBundle");
        Intrinsics.checkNotNullParameter(r111, "clickMethod");
        MergeDataContext r101 = this.mergeContext;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mergeContext");
    L5:
        Function5<String, Bundle, String, Bundle, Map<String, String>, Unit> r102 = r101.getMergeEnterAction();
        if (r102 == null) goto L9;
        Unit r103 = r102.invoke(r100, r110, r111, r112, r113);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void mergeEnterRoomWithAction$default(AbsMergeWidget r100, String r101, Bundle r102, String r103, Bundle r110, Map r111, int r112, Object r113) {
        if (r113 != null) goto L12;
        if ((r112 & 8) == 0) goto L6;
        r110 = null;
    L6:
        Bundle r104 = r110;
        if ((r112 & 16) == 0) goto L9;
        r111 = new HashMap();
    L9:
        r100.mergeEnterRoomWithAction(r101, r102, r103, r104, r111);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mergeEnterRoomWithAction");
    }
}

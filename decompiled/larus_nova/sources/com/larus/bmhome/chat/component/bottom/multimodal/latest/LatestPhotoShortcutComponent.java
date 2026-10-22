package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.g1;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.input.impl.databinding.LarusLayoutLatestPhotoShortcutViewBinding;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00012\b\u0016\u0018\u0000 N2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002NOB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000205H\u0016J\b\u00109\u001a\u000205H\u0016J\b\u0010:\u001a\u000205H\u0016J\u0010\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000205H\u0002J \u0010?\u001a\u000205*\u00020,2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u0002050AH\u0002J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u000205H\u0002J\b\u0010E\u001a\u000205H\u0002J\u0016\u0010F\u001a\u000205*\u00020.2\b\b\u0002\u0010G\u001a\u00020CH\u0002J\u001c\u0010H\u001a\u000205*\u00020.2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020CH\u0002J\u0018\u0010L\u001a\u0002052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020CH\u0003J\u0018\u0010M\u001a\u0002052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020CH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006P"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ILatestPhotoShortcutAbility;", "<init>", "()V", "viewModel", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "trace", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutTrace;", "getTrace", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutTrace;", "trace$delegate", "Lkotlin/Lazy;", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "shortcutShowGate", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutShowGate;", "getShortcutShowGate", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutShowGate;", "shortcutShowGate$delegate", "messageProcessor", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutMsgProcessor;", "getMessageProcessor", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutMsgProcessor;", "messageProcessor$delegate", "stub", "Landroid/view/ViewStub;", "shortcutViewBinding", "Lcom/larus/input/impl/databinding/LarusLayoutLatestPhotoShortcutViewBinding;", "lastShowTime", "", "onConversationChanged", "com/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutComponent$onConversationChanged$1", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutComponent$onConversationChanged$1;", "onViewCreated", "", "view", "Landroid/view/View;", "onAttach", "onResume", "onStop", "dismiss", "from", "", "triggerShow", "inflateStub", "onNext", "Lkotlin/Function1;", "latestPhotoShortcutEnabled", "", "recordDisplayDuration", "observeLatestPhotoViewState", "removeShortcutView", "skipAnimation", "showShortcutView", "uri", "Landroid/net/Uri;", "skipAttachment", "inflateAndShowShortcutView", "send", "Companion", "ActionOnGesture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LatestPhotoShortcutComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.bottom.multimodal.latest.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f299812x = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larus.ui.arch.vm.internal.l f299813m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f299814n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f299815o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f299816p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f299817q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f299818r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f299819s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewStub f299820t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LarusLayoutLatestPhotoShortcutViewBinding f299821u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f299822v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f299823w;

    public final class a implements LatestPhotoShortcutGestureLayout.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f299824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f299825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LatestPhotoShortcutComponent f299826c;

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void a() {
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onRightSwipe]");
            LatestPhotoShortcutComponent r100 = this.f299826c;
            int r101 = LatestPhotoShortcutComponent.f299812x;
            r100.Y2().handleEvent(LatestPhotoShortcutEvent.b.f299832a);
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void b() {
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onTouchDown]");
            LatestPhotoShortcutComponent r100 = this.f299826c;
            int r101 = LatestPhotoShortcutComponent.f299812x;
            r100.Y2().handleEvent(LatestPhotoShortcutEvent.c.f299833a);
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void c() {
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onWindowFocusLost]");
            this.f299826c.g0("LatestPhotoShortcutComponent#onWindowFocusLost");
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void d() {
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onTouchUp]");
            LatestPhotoShortcutComponent r100 = this.f299826c;
            int r101 = LatestPhotoShortcutComponent.f299812x;
            r100.Y2().handleEvent(LatestPhotoShortcutEvent.d.f299834a);
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void onClick() {
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onClick]");
            LatestPhotoShortcutComponent r100 = this.f299826c;
            int r101 = LatestPhotoShortcutComponent.f299812x;
            r100.Y2().handleEvent(LatestPhotoShortcutEvent.b.f299832a);
            g0 r102 = (g0) this.f299826c.f299814n.getValue();
            int r103 = g0.f299871e;
            TrackParams r104 = new TrackParams().merge(r102.a());
            by7.a r105 = new by7.a("new_picture_guide_click");
            r105.f21463a.merge(r104);
            r105.b();
            LatestPhotoShortcutComponent r106 = this.f299826c;
            Uri r107 = this.f299824a;
            boolean r108 = this.f299825b;
            com.larus.bmhome.chat.component.cvs.y r109 = (com.larus.bmhome.chat.component.cvs.y) r106.f299817q.getValue();
            if (r109 == null) goto L5;
            BotModel r110 = r109.j0();
        L6:
            if (r110 == null) goto L8;
            List<BotConfItem> r111 = r110.getBotConf();
        L10:
            if (r111 == null) goto L26;
            Iterator<T> r112 = r111.iterator();
        L13:
            if (r112.hasNext() == false) goto L22;
            Object r113 = r112.next();
            BotConfItem r114 = (BotConfItem) r113;
            if (Intrinsics.areEqual(r114.getConfGroupKey(), "disable_function") == true) goto L17;
        L19:
            boolean r115 = false;
        L20:
            if (r115 == false) goto L13;
        L23:
            BotConfItem r116 = (BotConfItem) r113;
            if (r116 == null) goto L26;
            String r117 = r116.getConfValue();
        L27:
            boolean r118 = Intrinsics.areEqual(r117, "1");
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[send] skipAttachment:" + r108 + ", attachmentPanelDisabledByBotConf:" + r118);
            LruCache<String, wc9.e> r119 = ko8.a.f504531a;
            com.larus.bmhome.chat.component.cvs.y r120 = (com.larus.bmhome.chat.component.cvs.y) r106.f299817q.getValue();
            if (r120 == null) goto L30;
            String r121 = r120.Y1();
        L31:
            ko8.a.k(r121, "new_picture_guide_click");
            if (r108 == true) goto L36;
            if (r118 == true) goto L36;
            boolean r122 = false;
        L37:
            ICoreInputAbility r123 = (ICoreInputAbility) r106.f299816p.getValue();
            if (r123 != null) goto L40;
        L42:
            boolean r124 = false;
        L43:
            boolean r125 = !r124;
            com.larus.bmhome.chat.component.bottom.multimodal.g r126 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r106.f299815o.getValue();
            if (r126 == null) goto L52;
            r126.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a(r107, null, 2)), new g1(!r122, MultimodalBizScene.ChatLatestPhoto, r125), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("upload_file_click_from", "new_picture_guide_click"), TuplesKt.to("enter_method_trace", "new_picture_guide_click"), TuplesKt.to("scene", "album")}), null, 20));
            return;
        L52:
            return;
        L40:
            if (r123.gj() != true) goto L42;
            r124 = true;
        L36:
            r122 = true;
            goto L37
        L30:
            r121 = null;
            goto L31
        L17:
            if (Intrinsics.areEqual(r114.getConfKey(), "disable_attachment_area") == false) goto L19;
            r115 = true;
            goto L20
        L22:
            r113 = null;
        L26:
            r117 = null;
            goto L27
        L8:
            r111 = null;
            goto L10
        L5:
            r110 = null;
            goto L6
        }

        public a(LatestPhotoShortcutComponent r100, Uri r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "uri");
            this.f299826c = r100;
            this.f299824a = r101;
            this.f299825b = r102;
        }
    }

    public static final class b {
    }

    public static final class c implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LatestPhotoShortcutComponent f299827a;

        public c(LatestPhotoShortcutComponent r100) {
            this.f299827a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(wc9.e r100) {
            Intrinsics.checkNotNullParameter(r100, "new");
            LatestPhotoShortcutComponent r101 = this.f299827a;
            int r102 = LatestPhotoShortcutComponent.f299812x;
            if (r101.h3() == false) goto L5;
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onConversationChanged] latest photo shortcut enabled");
            this.f299827a.Y2().handleEvent(new LatestPhotoShortcutEvent.a(this.f299827a.getContext()));
            return;
        L5:
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onConversationChanged] latest photo shortcut disabled");
        }
    }

    public static final class d implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f299828a;

        public d(ComponentFeature r100) {
            this.f299828a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f299828a;
        }
    }

    public static final class e implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f299829a;

        public e(ComponentFeature r100) {
            this.f299829a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return this.f299829a;
        }
    }

    public static final class f implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f299830a = null;

        static {
            f299830a = new f();
        }

        public f() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutComponent$onResume$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r100) {
            super(0, r100, LatestPhotoShortcutComponent.class, "triggerShow", "triggerShow()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LatestPhotoShortcutComponent r100 = (LatestPhotoShortcutComponent) this.receiver;
            int r101 = LatestPhotoShortcutComponent.f299812x;
            if (r100.h3() == false) goto L7;
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onResume] latest photo shortcut enabled");
            r100.Y2().handleEvent(new LatestPhotoShortcutEvent.a(r100.getContext()));
            com.larus.bmhome.chat.component.cvs.y r102 = (com.larus.bmhome.chat.component.cvs.y) r100.f299817q.getValue();
            if (r102 == null) goto L9;
            r102.lQ(r100.f299823w);
            return;
        L9:
            return;
        L7:
            FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onResume] latest photo shortcut disabled");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LatestPhotoShortcutViewModel Y2() {
        return (LatestPhotoShortcutViewModel) this.f299813m.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        AnonymousClass1 r101 = new AnonymousClass1(this);
        MainCoroutineDispatcher r102 = Dispatchers.getMain();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "dispatcher");
        View r103 = r100.getView();
        if (r103 == null) goto L6;
        SafeExtKt.a(r103, r101, 300, r102);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        FLogger.f375446a.i("LatestPhotoShortcutComponent", "[onStop]");
        LarusLayoutLatestPhotoShortcutViewBinding r100 = this.f299821u;
        if (r100 == null) goto L6;
        m3(r100, true);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.chat.component.bottom.multimodal.latest.a.class);
    }

    public LatestPhotoShortcutComponent() {
        this.f299813m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(LatestPhotoShortcutViewModel.class), Reflection.getOrCreateKotlinClass(LatestPhotoShortcutViewState.class), new d(this), new e(this), f.f299830a);
        this.f299814n = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.multimodal.latest.d(this));
        this.f299815o = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.multimodal.latest.e(this));
        this.f299816p = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.multimodal.latest.f(this));
        this.f299817q = LazyKt.lazy(new g(this));
        this.f299818r = LazyKt.lazy(new h(this));
        this.f299819s = LazyKt.lazy(new i(this));
        this.f299822v = -1;
        this.f299823w = new c(this);
    }

    public final boolean h3() {
        Context r100 = getContext();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 33) goto L8;
        if (ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == 0) goto L9;
    L10:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L15;
        FLogger.f375446a.i("LatestPhotoShortcutComponent", "[latestPhotoShortcutEnabled] disabled, permission denied");
        return false;
    L15:
        ICoreInputAbility r102 = (ICoreInputAbility) this.f299816p.getValue();
        if (r102 != null) goto L18;
    L20:
        boolean r103 = false;
    L21:
        if (r103 == true) goto L24;
        FLogger.f375446a.i("LatestPhotoShortcutComponent", "[latestPhotoShortcutEnabled] disabled, sendImageEnabled:false");
        return false;
    L24:
        com.larus.bmhome.chat.component.cvs.y r104 = (com.larus.bmhome.chat.component.cvs.y) this.f299817q.getValue();
        if (r104 == null) goto L37;
        wc9.e r105 = r104.h();
        if (r105 == null) goto L37;
        Intrinsics.checkNotNullParameter(r105, "conversation");
        boolean r106 = com.larus.bmhome.utils.i.f(r105);
        com.larus.platform.model.chat.z r107 = z2.f365865a.latestPhotoShortcutConfig();
        if (r106 == false) goto L32;
        boolean r108 = r107.f365606a;
    L33:
        if (r108 == true) goto L36;
        FLogger.f375446a.i("LatestPhotoShortcutComponent", "[latestPhotoShortcutEnabled] disabled, enabledByBotType:false");
        return false;
    L36:
        return true;
    L32:
        r108 = r107.f365607b;
    L37:
        FLogger.f375446a.e("LatestPhotoShortcutComponent", "[latestPhotoShortcutEnabled] disabled, conversation is null");
        com.larus.bmhome.chat.component.cvs.y r109 = (com.larus.bmhome.chat.component.cvs.y) this.f299817q.getValue();
        if (r109 == null) goto L40;
        r109.rh(new com.larus.bmhome.chat.component.bottom.multimodal.latest.b(), this.f299823w);
    L40:
        return false;
    L18:
        if (r102.Qd(false) != true) goto L20;
        r103 = true;
    L9:
        r101 = true;
        goto L12
    L8:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L10;
        goto L9
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.a
    public final void g0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        FLogger.f375446a.i("LatestPhotoShortcutComponent", "[dismiss] from:" + r100);
        Y2().handleEvent(LatestPhotoShortcutEvent.b.f299832a);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof ViewStub) == false) goto L5;
        this.f299820t = (ViewStub) r100;
        ComponentViewModel.onEach$default(Y2(), null, null, new LatestPhotoShortcutComponent$observeLatestPhotoViewState$1(this, null), 3, null);
        return;
    L5:
        FLogger.f375446a.e("LatestPhotoShortcutComponent", "[onViewCreated] view is expected to be a ViewStub");
    }

    public static void m3(final LarusLayoutLatestPhotoShortcutViewBinding r100, boolean r101) {
        if (r101 == false) goto L4;
        e1.o(r100.f351488a);
        return;
    L4:
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100.f351488a, View.ALPHA, new float[]{1.0f, 0.0f});
        r102.setDuration(200);
        r102.setInterpolator(new DecelerateInterpolator());
        Intrinsics.checkNotNull(r102);
        d2a.g.c(r102, new j(r100));
        r102.start();
    }
}

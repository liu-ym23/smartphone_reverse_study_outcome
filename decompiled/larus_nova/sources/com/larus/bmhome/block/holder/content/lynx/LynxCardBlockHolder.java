package com.larus.bmhome.block.holder.content.lynx;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LynxBlock;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e4;
import com.larus.platform.service.c1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CancellationException;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002WXB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0002H\u0016J\u0010\u00109\u001a\u00020:2\u0006\u00108\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u000207H\u0016J\u0018\u0010<\u001a\u0002072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0002H\u0002J\b\u0010=\u001a\u000207H\u0002J\u0012\u0010>\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010\u0013H\u0002J\f\u0010@\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010A\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010B\u001a\u00020C*\u00020CH\u0002J\b\u0010D\u001a\u000207H\u0002J \u0010E\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u000b2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070KH\u0002J\b\u0010L\u001a\u00020\u000bH\u0016J.\u0010M\u001a\u0002072\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020/2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010Q\u001a\u000207H\u0002J\u001e\u0010R\u001a\u0002072\b\b\u0002\u0010O\u001a\u00020/2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J3\u0010S\u001a\b\u0012\u0004\u0012\u0002070T2\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010O\u001a\u00020/2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\bU\u0010VR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/LynxCardBlockHolder;", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "Lcom/larus/bmhome/block/model/content/LynxCardBlockBizModel;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "isInit", "", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "TAG", "", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "lynxUrl", "loadingLynxUrl", "creatingLynxView", "initJob", "Lkotlinx/coroutines/Job;", "updateRunnable", "Ljava/lang/Runnable;", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "ivyPool", "Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "getIvyPool", "()Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "ivyPool$delegate", "isCreateLynxView", "bindGeneration", "", "cachedBindData", "errorView", "Landroid/view/View;", "maxWidth", "", DyPayConstant.KEY_START_TIME, DBDefinition.RETRY_COUNT, "lastRetryTimeMs", "onCreatedBlockView", "viewGroup", "Landroid/view/ViewGroup;", "onBindBlockView", "", "blockModel", "getMarginParams", "Lcom/larus/bmhome/chat/block/base/BlockMargin;", "onViewRecycled", "initLynxView", "cancelLynxInitialization", "detachFromParent", "view", "getProcessedData", "convertToActualUrl", "appendParamsToInnerUrl", "Landroid/net/Uri;", "ensureLifecycle", "createIvyPluginView", "data", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "releaseSignal", "Lkotlinx/coroutines/CompletableDeferred;", "getBlockHolderName", "reportPocketMessageCardShowed", "lynxViewLoadSuccess", "errorCode", "errorMsg", "delayReportPocketMessageCardShowTimeout", "reportPocketMessageCardError", "monitorLynxException", "Lkotlin/Result;", "monitorLynxException-0E7RQCE", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Object;", "LynxData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxCardBlockHolder extends jc8.b<fb8.g> implements LifecycleOwner {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f296170y = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f296171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LifecycleRegistry f296172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f296173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f296174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e4 f296175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f296176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f296177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e4 f296178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Job f296179l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Runnable f296180m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public kc8.b f296181n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f296182o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f296183p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f296184q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f296185r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public fb8.g f296186s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f296187t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f296188u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f296189v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f296190w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f296191x;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/LynxCardBlockHolder$LynxData;", "", "messageData", "", "sessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessageData", "()Ljava/lang/String;", "getSessionId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("message_data")
        private final String messageData;

        @SerializedName("session_id")
        private final String sessionId;

        public b() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.messageData, r101.messageData) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.messageData;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.sessionId;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "LynxData(messageData=" + this.messageData + ", sessionId=" + this.sessionId + ')';
        }

        public b(String r100, String r101) {
            this.messageData = r100;
            this.sessionId = r101;
        }
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "LynxCardBlockHolder";
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        LifecycleRegistry r100 = this.f296172e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        return null;
    L6:
        return r100;
    }

    public final void k() {
        this.f296185r++;
        Job r100 = this.f296179l;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f296179l = null;
        m(this.f296178k);
        this.f296178k = null;
        this.f296177j = null;
        this.f296184q = false;
    }

    public LynxCardBlockHolder() {
        this.f296171d = true;
        this.f296173f = "LynxCardBlockHolder-" + hashCode();
        this.f296182o = LazyKt.lazy(new c(this));
        this.f296183p = LazyKt.lazy(new d(this));
        this.f296190w = 3;
    }

    @Override // jc8.b
    public final void i() {
        k();
        e4 r100 = this.f296175h;
        if (r100 == null) goto L10;
        eh8.b r101 = (eh8.b) this.f296183p.getValue();
        if (r101 == null) goto L10;
        String r102 = this.f296176i;
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r101.a(r102, r100);
    L10:
        LifecycleRegistry r103 = null;
        this.f296175h = null;
        this.f296176i = null;
        this.f296180m = null;
        this.f296186s = null;
        LifecycleRegistry r104 = this.f296172e;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L14:
        r103.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.f296171d = true;
        this.f296190w = 3;
        return;
    L13:
        r103 = r104;
        goto L14
    }

    public static void r(LynxCardBlockHolder r100) {
        String r101 = r100.f296176i;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.p(r101, 301, null);
        FLogger.f375446a.e(r100.f296173f, "reportPocketMessageCardError: 301, errorMsg: null");
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r100) {
        Intrinsics.checkNotNullParameter((fb8.g) r100, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r210) {
        final fb8.g r110 = (fb8.g) r210;
        Intrinsics.checkNotNullParameter(r110, "blockModel");
        this.f296181n = (kc8.b) jc8.c.a(this, kc8.b.class);
        Integer r100 = null;
        if (this.f296171d == false) goto L8;
        this.f296171d = false;
        LifecycleRegistry r101 = new LifecycleRegistry(this);
        this.f296172e = r101;
        r101.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        LifecycleRegistry r102 = this.f296172e;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r102 = null;
    L7:
        r102.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L8:
        BlockContent r103 = r110.f498145a.getContent();
        if (r103 == null) goto L11;
        LynxBlock r111 = r103.getLynxBlock();
    L12:
        fb8.g r104 = this.f296186s;
        if (r104 == null) goto L15;
        Message r105 = r104.j();
    L16:
        boolean r112 = true;
        if (r105 != null) goto L19;
    L21:
        final boolean r106 = false;
    L22:
        if (r111 == null) goto L31;
        String r107 = r111.lynxUrl;
        if (r107 == null) goto L31;
        if (o0.d(r107) == true) goto L29;
        r107 = null;
    L29:
        if (r107 == null) goto L31;
        final String r108 = l(r107);
    L32:
        String r109 = this.f296176i;
        if (r109 != null) goto L35;
        r109 = this.f296177j;
    L35:
        final String r113 = r109;
        if (r113 != null) goto L38;
    L40:
        boolean r114 = false;
    L41:
        if (r106 == true) goto L45;
        if (r114 == true) goto L45;
        boolean r115 = false;
    L46:
        FLogger r116 = FLogger.f375446a;
        if (r116.isDebug() == false) goto L49;
        final LynxBlock r117 = r111;
        r116.g(this.f296173f, new f(r110, r117, r106, r113, r108, this));
    L49:
        FrameLayout r118 = this.f296174g;
        if (r118 == null) goto L130;
        kc8.b r119 = this.f296181n;
        if (r119 == null) goto L59;
        y r120 = r119.f502425a;
        if (r120 == null) goto L59;
        Function1<Boolean, Unit> r121 = r120.B;
        if (r121 == null) goto L59;
        r121.invoke(Boolean.FALSE);
    L59:
        final String r122 = "";
        if (r115 == false) goto L70;
        k();
        e4 r123 = this.f296175h;
        if (r123 == null) goto L69;
        eh8.b r124 = (eh8.b) this.f296183p.getValue();
        if (r124 == null) goto L69;
        String r125 = this.f296176i;
        if (r125 != null) goto L68;
        r125 = "";
    L68:
        r124.a(r125, r123);
    L69:
        this.f296175h = null;
        this.f296176i = null;
        this.f296180m = null;
    L70:
        this.f296186s = r110;
        if (r111 == null) goto L75;
        String r126 = r111.lynxData;
        if (r126 == null) goto L75;
        String r127 = o(r126);
    L76:
        if (r127 == null) goto L79;
        r122 = r127;
    L79:
        final e4 r128 = this.f296175h;
        if (r128 == null) goto L84;
        Runnable r129 = new g(r128, r122);
        this.f296180m = r129;
        if (this.f296184q == true) goto L124;
        r129.run();
        this.f296180m = null;
    L124:
        if (r116.isDebug() == false) goto L129;
        r116.g(this.f296173f, new i(r110));
        return;
    L129:
        return;
    L84:
        boolean r130 = this.f296184q;
        if (r130 == false) goto L87;
        this.f296180m = new h(this, r122);
        goto L124
    L87:
        if (r130 == false) goto L89;
        r116.e(this.f296173f, "initLynxView return, cause isCreateLynxView = true");
        goto L124
    L89:
        this.f296184q = true;
        long r131 = this.f296185r;
        Message r132 = r110.j();
        BlockContent r133 = r110.f498145a.getContent();
        if (r133 == null) goto L101;
        LynxBlock r134 = r133.getLynxBlock();
        if (r134 == null) goto L101;
        String r135 = r134.lynxUrl;
        if (r135 == null) goto L101;
        if (o0.d(r135) == true) goto L99;
        r135 = null;
    L99:
        if (r135 == null) goto L101;
        String r136 = l(r135);
    L102:
        this.f296177j = r136;
        this.f296189v = System.currentTimeMillis();
        w r137 = w.f305213a;
        Context r138 = r118.getContext();
        Message r139 = r110.j();
        kc8.b r140 = this.f296181n;
        if (r140 == null) goto L107;
        y r141 = r140.f502425a;
        if (r141 == null) goto L107;
        Integer r142 = r141.f502629j;
    L108:
        de8.c r143 = (de8.c) this.f296182o.getValue();
        if (r143 == null) goto L111;
        r100 = r143.m();
    L111:
        if (r100 != null) goto L114;
        r112 = false;
    L114:
        Boolean r144 = Boolean.valueOf(r112);
        kc8.b r145 = this.f296181n;
        if (r145 == null) goto L119;
        y r146 = r145.f502425a;
        if (r146 == null) goto L119;
        boolean r211 = Intrinsics.areEqual(r146.f502627h, Boolean.TRUE);
    L120:
        this.f296188u = w.c(r137, r138, r139, r142, r144, r211, true, null, this.f498155c, 64);
        ViewGroup.LayoutParams r147 = r118.getLayoutParams();
        if (r147 == null) goto L128;
        r147.width = this.f296188u;
        r147.height = -2;
        r118.setLayoutParams(r147);
        r118.removeAllViews();
        r118.addView(this.f296187t);
        this.f296179l = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LynxCardBlockHolder$initLynxView$2(r110, r136, this, r132, r131, r118, null), 3, null);
        goto L124
    L128:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L119:
        r211 = false;
    L107:
        r142 = null;
    L101:
        r136 = null;
    L75:
        r127 = null;
        goto L76
    L130:
        return;
    L45:
        r115 = true;
        goto L46
    L38:
        if (Intrinsics.areEqual(r113, r108) == true) goto L40;
        r114 = true;
    L31:
        r108 = null;
        goto L32
    L19:
        if (k.a(r105.getMessageId(), r105.getLocalMessageId(), r110.j().getMessageId(), r110.j().getLocalMessageId()) == true) goto L21;
        r106 = true;
        goto L22
    L15:
        r105 = null;
        goto L16
    L11:
        r111 = null;
        goto L12
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        FrameLayout r101 = new FrameLayout(r100.getContext());
        this.f296174g = r101;
        FrameLayout r102 = new FrameLayout(r101.getContext());
        r102.setBackgroundResource(R.drawable.larus_bg_base_2_overlay_radius_16);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r102.setVisibility(8);
        ImageView r103 = new ImageView(r102.getContext());
        r103.setImageResource(R.drawable.larus_ic_refresh);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(i5.Z(), i5.Z());
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        r102.addView(r103, r104);
        e1.d(r102, new e(this));
        this.f296187t = r102;
        return r101;
    }

    public final String l(String r100) {
        Uri r101 = y0.j(r100);
        if (r101 != null) goto L5;
        return r100;
    L5:
        Uri r102 = y0.l(y0.l(y0.l(r101, "loader_name", "forest"), "forest_newly_builtin", "1"), "enable_lynx_generic_fetcher", "1");
        if (AppHost.f326268a.isTestChannel() == false) goto L22;
        IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r103 == null) goto L14;
        FlowAppletServiceImpl r104 = r103.g0();
        if (r104 == null) goto L14;
        boolean r105 = true;
        if (r104.e() != true) goto L14;
    L15:
        if (r105 == false) goto L22;
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L22;
        FlowAppletServiceImpl r107 = r106.g0();
        if (r107 == null) goto L22;
        r102 = y0.a(r102, r107.f());
    L14:
        r105 = false;
    L22:
        return r102.toString();
    }

    public final void m(e4 r100) {
        if (r100 == null) goto L13;
        View r101 = r100.getView();
        if (r101 == null) goto L15;
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L9;
        ViewGroup r103 = (ViewGroup) r102;
    L10:
        if (r103 == null) goto L14;
        r103.removeView(r101);
        return;
    L14:
        return;
    L9:
        r103 = null;
        goto L10
    L15:
        return;
    }

    public final String o(String r100) {
        kc8.b r101 = this.f296181n;
        if (r101 == null) goto L9;
        y r102 = r101.f502425a;
        if (r102 == null) goto L9;
        Fragment r103 = r102.f502620a;
        if (r103 == null) goto L9;
        String r104 = Integer.valueOf(r103.hashCode()).toString();
    L10:
        zd9.h r105 = zd9.h.f571481a;
        b r106 = new b(r100, r104);
        r105.getClass();
        String r107 = zd9.h.c(r106);
        if (r107 != null) goto L14;
        return "";
    L14:
        return r107;
    L9:
        r104 = null;
        goto L10
    }

    public final void p(String r100, int r110, String r111) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L8
        r102.put(ImageNetworkRequestsMonitor.KEY_IMAGE_LOAD, System.currentTimeMillis() - this.f296189v);     // Catch: Throwable -> L8
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L8
        r103.put(ImageNetworkRequestsMonitor.KEY_IMAGE_LOAD, System.currentTimeMillis() - this.f296189v);     // Catch: Throwable -> L8
        r103.put(SendClosePdpEventParam.KEY_LYNX_URL, r100);     // Catch: Throwable -> L8
        r103.put("error_code", r110);     // Catch: Throwable -> L8
        r103.put("error_msg", r111);     // Catch: Throwable -> L8
        fb8.g r104 = this.f296186s;     // Catch: Throwable -> L8
        if (r104 == null) goto L6;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r104.j().getMessageId());     // Catch: Throwable -> L8
        r103.put("message_index", r104.j().getServerIndex());     // Catch: Throwable -> L8
    L6:
        com.larus.platform.service.o.f365780a.reportEvent("dev_lynx_card_load_failed", r103);     // Catch: Throwable -> L8
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("dev_lynx_card_load_failed", r103, r102, null);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final Object j(LynxCardBlockHolder r110, String r111, String r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof LynxCardBlockHolder$createIvyPluginView$1) == false) goto L7;
        LynxCardBlockHolder$createIvyPluginView$1 r100 = (LynxCardBlockHolder$createIvyPluginView$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        long r115 = r100.J$1;
        long r104 = r100.J$0;
        e4 r105 = (e4) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: CancellationException -> L14
    L28:
        boolean r116 = ((Boolean) r114).booleanValue();     // Catch: CancellationException -> L14
        long r106 = System.currentTimeMillis() - r104;     // Catch: CancellationException -> L14
        FLogger.f375446a.i(r110.f296173f, "createIvyPluginView, total=" + r106 + " ts1=" + (r115 - r104) + " ts2=" + (System.currentTimeMillis() - r115));     // Catch: CancellationException -> L14
        r110.f296178k = null;     // Catch: CancellationException -> L14
        if (r116 == true) goto L39;
        r110.m(r105);     // Catch: CancellationException -> L14
    L44:
        return null;
    L39:
        return r105;
    L14:
        e = move-exception;
        e = e;
        e4 r117 = r105;
    L35:
        r110.m(r117);
        if (r110.f296178k != r117) goto L38;
        r110.f296178k = null;
    L38:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r114);
        long r107 = System.currentTimeMillis();
        FrameLayout r118 = r110.f296174g;
        if (r118 == null) goto L44;
        Context r119 = r118.getContext();
        if (r119 == null) goto L44;
        CompletableDeferred r108 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r117 = c1.f365723a.g(r119, r111, r112, new j(r110, r108, r111));
        r110.f296178k = r117;
        long r120 = System.currentTimeMillis();
        r100.L$0 = r117;     // Catch: CancellationException -> L34
        r100.J$0 = r107;     // Catch: CancellationException -> L34
        r100.J$1 = r120;     // Catch: CancellationException -> L34
        r100.label = 1;     // Catch: CancellationException -> L34
        Object r109 = r108.await(r100);     // Catch: CancellationException -> L34
        if (r109 == r102) goto L45;
        r104 = r107;
        r105 = r117;
        r115 = r120;
        r114 = r109;
        goto L28
    L45:
        return r102;
    L34:
        e = e;
    L7:
        r100 = new LynxCardBlockHolder$createIvyPluginView$1(r110, r113);
        goto L8
    }

    public final void s(String r100, boolean r101, int r102, String r103) {
        if (r101 == true) goto L5;
        p(r100, r102, r103);
        FLogger.f375446a.e(this.f296173f, "reportPocketMessageCardShowed: lynxViewLoadSuccess=" + r101 + ", errorCode=" + r102 + ", errorMsg=" + r103);
        return;
    }
}

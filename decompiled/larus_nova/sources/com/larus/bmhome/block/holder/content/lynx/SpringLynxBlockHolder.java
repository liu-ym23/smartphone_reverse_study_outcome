package com.larus.bmhome.block.holder.content.lynx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SpringLynxBlock;
import com.larus.nova.R;
import com.larus.platform.api.e4;
import com.larus.platform.service.c1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002QRB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0002H\u0016J\u0018\u00107\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u0002H\u0002J\f\u00108\u001a\u00020\u0013*\u00020\u0013H\u0002J\u0014\u00109\u001a\u00020\u0013*\u00020\u00132\u0006\u0010:\u001a\u00020\u0013H\u0002J\f\u0010;\u001a\u00020<*\u00020<H\u0002J\b\u0010=\u001a\u000204H\u0002J \u0010>\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070DH\u0002J\u0012\u0010E\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J&\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\u00072\b\b\u0002\u0010J\u001a\u00020'2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010L\u001a\u00020M2\u0006\u00106\u001a\u00020\u0002H\u0016J\b\u0010N\u001a\u000204H\u0002J\b\u0010O\u001a\u00020\u0013H\u0016J\u001e\u0010P\u001a\u0002042\b\b\u0002\u0010J\u001a\u00020'2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/SpringLynxBlockHolder;", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "Lcom/larus/bmhome/block/model/content/SpringLynxBlockBizModel;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "isInit", "", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "lynxUrl", "", "updateRunnable", "Ljava/lang/Runnable;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "ivyPool", "Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "getIvyPool", "()Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "ivyPool$delegate", "isCreateLynxView", "cachedBindData", "loadingView", "Landroid/view/View;", "errorView", "maxWidth", "", DyPayConstant.KEY_START_TIME, "", "reportPocketMessageCardShowTimeoutJob", "Lkotlinx/coroutines/Job;", DBDefinition.RETRY_COUNT, "lastRetryTimeMs", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "onCreatedBlockView", "viewGroup", "Landroid/view/ViewGroup;", "onViewRecycled", "", "onBindBlockView", "blockModel", "initLynxView", "getProcessedData", "convertToActualUrl", RemoteMessageConst.MSGID, "appendParamsToInnerUrl", "Landroid/net/Uri;", "ensureLifecycle", "createIvyPluginView", "data", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "releaseSignal", "Lkotlinx/coroutines/CompletableDeferred;", "isLotteryMsg", "message", "Lcom/larus/im/bean/message/Message;", "reportPocketMessageCardShowed", "lynxViewLoadSuccess", "errorCode", "errorMsg", "getMarginParams", "Lcom/larus/bmhome/chat/block/base/BlockMargin;", "delayReportPocketMessageCardShowTimeout", "getBlockHolderName", "reportPocketMessageCardError", "LynxData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpringLynxBlockHolder extends jc8.b<fb8.k> implements LifecycleOwner {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f296192v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f296193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LifecycleRegistry f296194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f296195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e4 f296196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f296197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f296198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f296199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f296200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f296201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fb8.k f296202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f296203n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f296204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f296205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f296206q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Job f296207r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f296208s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f296209t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public kc8.b f296210u;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/SpringLynxBlockHolder$LynxData;", "", "messageData", "", "sessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessageData", "()Ljava/lang/String;", "getSessionId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Override // jc8.b
    public final String c() {
        return "SpringLynxBlockHolder";
    }

    static {
        new Gson();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        LifecycleRegistry r100 = this.f296194e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        return null;
    L6:
        return r100;
    }

    @Override // jc8.b
    public final void i() {
        e4 r100 = this.f296196g;
        if (r100 == null) goto L10;
        eh8.b r101 = (eh8.b) this.f296200k.getValue();
        if (r101 == null) goto L10;
        String r102 = this.f296197h;
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r101.a(r102, r100);
    L10:
        LifecycleRegistry r103 = null;
        this.f296196g = null;
        LifecycleRegistry r104 = this.f296194e;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L14:
        r103.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.f296193d = true;
        this.f296208s = 3;
        return;
    L13:
        r103 = r104;
        goto L14
    }

    public SpringLynxBlockHolder() {
        this.f296193d = true;
        this.f296199j = LazyKt.lazy(new l(this));
        this.f296200k = LazyKt.lazy(new m(this));
        this.f296208s = 3;
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r100) {
        Intrinsics.checkNotNullParameter((fb8.k) r100, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r210) {
        final fb8.k r100 = (fb8.k) r210;
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        this.f296210u = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (this.f296193d == false) goto L8;
        this.f296193d = false;
        LifecycleRegistry r101 = new LifecycleRegistry(this);
        this.f296194e = r101;
        r101.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        LifecycleRegistry r102 = this.f296194e;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r102 = null;
    L7:
        r102.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L8:
        String r103 = r100.j().getMessageId();
        fb8.k r104 = this.f296202m;
        if (r104 == null) goto L11;
        String r105 = r104.j().getMessageId();
    L12:
        boolean r106 = Intrinsics.areEqual(r103, r105);
        boolean r107 = true;
        boolean r108 = !r106;
        this.f296202m = r100;
        FrameLayout r109 = this.f296195f;
        if (r109 == null) goto L74;
        kc8.b r110 = this.f296210u;
        if (r110 == null) goto L22;
        y r111 = r110.f502425a;
        if (r111 == null) goto L22;
        Function1<Boolean, Unit> r112 = r111.B;
        if (r112 == null) goto L22;
        r112.invoke(Boolean.FALSE);
    L22:
        final e4 r113 = this.f296196g;
        if (r113 == null) goto L33;
        if ((!r108) == true) goto L28;
        r113 = null;
    L28:
        if (r113 == null) goto L33;
        Runnable r114 = new o(r100, r113, this);
        this.f296198i = r114;
        if (this.f296201l == true) goto L71;
        r114.run();
        this.f296198i = null;
        return;
    L71:
        return;
    L33:
        if (this.f296201l == false) goto L35;
        FLogger.f375446a.i("SpringLynxBlockHolder", "initLynxView return, cause isCreateLynxView = true");
        return;
    L35:
        this.f296201l = true;
        this.f296206q = System.currentTimeMillis();
        w r115 = w.f305213a;
        Context r116 = r109.getContext();
        Message r117 = r100.j();
        kc8.b r118 = this.f296210u;
        if (r118 == null) goto L40;
        y r119 = r118.f502425a;
        if (r119 == null) goto L40;
        Integer r120 = r119.f502629j;
    L41:
        de8.c r121 = (de8.c) this.f296199j.getValue();
        if (r121 == null) goto L44;
        Integer r122 = r121.m();
    L45:
        if (r122 != null) goto L48;
        r107 = false;
    L48:
        Boolean r123 = Boolean.valueOf(r107);
        kc8.b r124 = this.f296210u;
        if (r124 == null) goto L53;
        y r125 = r124.f502425a;
        if (r125 == null) goto L53;
        boolean r126 = Intrinsics.areEqual(r125.f502627h, Boolean.TRUE);
    L54:
        this.f296205p = Math.min(w.c(r115, r116, r117, r120, r123, r126, true, null, this.f498155c, 64), ((Number) i5.T1.getValue()).intValue());
        ViewGroup.LayoutParams r127 = r109.getLayoutParams();
        if (r127 == null) goto L70;
        int r128 = this.f296205p;
        r127.width = r128;
        double r129 = r128;
        BlockContent r130 = r100.f498145a.getContent();
        if (r130 == null) goto L63;
        SpringLynxBlock r131 = r130.getSpringLynxBlock();
        if (r131 == null) goto L63;
        Double r132 = r131.ratio;
        if (r132 == null) goto L63;
        double r133 = r132.doubleValue();
    L64:
        r127.height = (int) (r129 * r133);
        r109.setLayoutParams(r127);
        r109.removeAllViews();
        r109.addView(this.f296203n);
        r109.addView(this.f296204o);
        View r134 = this.f296203n;
        if (r134 == null) goto L67;
        r134.setVisibility(0);
    L67:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SpringLynxBlockHolder$initLynxView$2(this, r100, r109, null), 2, null);
        return;
    L63:
        r133 = 1.0d;
        goto L64
    L70:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L53:
        r126 = false;
        goto L54
    L44:
        r122 = null;
    L40:
        r120 = null;
        goto L41
    L74:
        return;
    L11:
        r105 = null;
        goto L12
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        FrameLayout r101 = new FrameLayout(r100.getContext());
        this.f296195f = r101;
        FrameLayout r102 = new FrameLayout(r101.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r102.setBackgroundResource(R.drawable.larus_bg_base_2_overlay_radius_16);
        r102.setVisibility(8);
        this.f296203n = r102;
        FrameLayout r103 = new FrameLayout(r101.getContext());
        r103.setBackgroundResource(R.drawable.larus_bg_base_2_overlay_radius_16);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.setVisibility(8);
        ImageView r104 = new ImageView(r103.getContext());
        r104.setImageResource(R.drawable.larus_ic_refresh);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(i5.Z(), i5.Z());
        r105.gravity = 17;
        Unit r106 = Unit.INSTANCE;
        r103.addView(r104, r105);
        e1.d(r103, new n(this));
        this.f296204o = r103;
        return r101;
    }

    public final String k(String r100) {
        kc8.b r101 = this.f296210u;
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

    public final void l(boolean r110, int r111, String r112) {
        Job r100 = this.f296207r;
        Message r101 = null;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        fb8.k r102 = this.f296202m;
        if (r102 == null) goto L8;
        r101 = r102.j();
    L8:
        if (r101 == null) goto L10;
        boolean r103 = com.larus.bmhome.chat.bean.d.t0(r101);
    L11:
        if (r103 == false) goto L14;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringLynxBlockHolder$reportPocketMessageCardShowed$1(this, r110, r111, r112, null), 3, null);
        return;
    L14:
        return;
    L10:
        r103 = false;
        goto L11
    }

    public static final Object j(SpringLynxBlockHolder r110, String r111, String r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof SpringLynxBlockHolder$createIvyPluginView$1) == false) goto L7;
        SpringLynxBlockHolder$createIvyPluginView$1 r100 = (SpringLynxBlockHolder$createIvyPluginView$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        e4 r115 = (e4) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L12:
        e4 r104 = r115;
        if (((Boolean) r114).booleanValue() == false) goto L42;
        return r104;
    L42:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r114);
        FLogger.f375446a.i("SpringLynxBlockHolder", "createIvyPluginView, lynxUrl: " + r111);
        c1 r116 = c1.f365723a;
        if (r116.d() == true) goto L18;
        r116.f();
    L18:
        FrameLayout r105 = r110.f296195f;
        if (r105 == null) goto L42;
        Context r106 = r105.getContext();
        if (r106 == null) goto L42;
        fb8.k r107 = r110.f296202m;
        if (r107 == null) goto L26;
        Message r108 = r107.j();
    L27:
        if (r108 == null) goto L29;
        boolean r109 = com.larus.bmhome.chat.bean.d.t0(r108);
    L30:
        if (r109 == false) goto L35;
        Job r117 = r110.f296207r;
        if (r117 == null) goto L34;
        Job.DefaultImpls.cancel$default(r117, null, 1, null);
    L34:
        r110.f296207r = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new SpringLynxBlockHolder$delayReportPocketMessageCardShowTimeout$1(r110, null), 3, null);
    L35:
        CompletableDeferred r118 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r115 = r116.g(r106, r111, r112, new p(r118, r110));
        r100.L$0 = r115;
        r100.label = 1;
        r114 = r118.await(r100);
        if (r114 != r102) goto L12;
        return r102;
    L29:
        r109 = false;
        goto L30
    L26:
        r108 = null;
    L7:
        r100 = new SpringLynxBlockHolder$createIvyPluginView$1(r110, r113);
        goto L8
    }
}

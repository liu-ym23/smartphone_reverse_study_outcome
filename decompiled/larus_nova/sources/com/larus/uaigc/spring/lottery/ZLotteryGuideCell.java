package com.larus.uaigc.spring.lottery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.e4;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0011H\u0002J\f\u0010)\u001a\u00020**\u00020*H\u0002J\f\u0010+\u001a\u00020,*\u00020,H\u0002J\u001e\u0010-\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b02H\u0002J&\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\r2\n\b\u0002\u00106\u001a\u0004\u0018\u00010*H\u0002J\b\u00107\u001a\u00020\"H\u0002J\u001e\u00108\u001a\u00020\"2\b\b\u0002\u00105\u001a\u00020\r2\n\b\u0002\u00106\u001a\u0004\u0018\u00010*H\u0002J\b\u00109\u001a\u00020\"H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/uaigc/spring/lottery/ZLotteryGuideCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/uaigc/spring/lottery/ZLotteryGuideCellState;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "isCreateLynxView", "", "maxWidth", "", "boxType", "Ljava/lang/Integer;", "curMessage", "Lcom/larus/im/bean/message/Message;", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "Lkotlin/Lazy;", DyPayConstant.KEY_START_TIME, "", "reportPocketMessageCardShowTimeoutJob", "Lkotlinx/coroutines/Job;", "onCreateBoxView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "onBindView", "", "view", "state", "position", "onViewRecycled", "createLynxView", "message", "convertToActualUrl", "", "appendParamsToInnerUrl", "Landroid/net/Uri;", "awaitCreateLynxView", "(Landroid/content/Context;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "releaseSignal", "Lkotlinx/coroutines/CompletableDeferred;", "reportPocketMessageCardShowed", "lynxViewLoadSuccess", "errorCode", "errorMsg", "delayReportPocketMessageCardShowTimeout", "reportPocketMessageCardError", "checkScrollLastest", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZLotteryGuideCell extends BaseMessageListCell<e> implements LifecycleOwner {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final StateFlowImpl f374116m = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f374117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e4 f374118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f374119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f374120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Message f374121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f374122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f374123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Job f374124l;

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
    }

    static {
        f374116m = j1.a(Boolean.FALSE);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onViewRecycled() {
        f374116m.setValue(Boolean.FALSE);
    }

    public ZLotteryGuideCell() {
        this.f374122j = LazyKt.lazy(new c(this));
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FrameLayout r103 = new FrameLayout(r100);
        this.f374117e = r103;
        int r104 = i5.h();
        int r105 = i5.h();
        int r106 = r103.getPaddingTop();
        int r107 = r103.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r103.getClass().getSimpleName() + ",source:,start:" + r104 + ",top:" + r106 + ",end:" + r105 + ",bottom:" + r107);
        r103.setPaddingRelative(r104, r106, r105, r107);
        return r103;
    }

    public final void o(boolean r110, int r111, String r112) {
        Job r100 = this.f374124l;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ZLotteryGuideCell$reportPocketMessageCardShowed$1(this, r110, r111, r112, null), 3, null);
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r110, int r111) {
        e r112 = (e) r110;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r112, "state");
        this.f374121i = r112.f563233a;
        f374116m.setValue(Boolean.TRUE);
        e4 r101 = this.f374118f;
        if (r101 != null) goto L16;
        Message r102 = r112.f563233a;
        if (this.f374119g == false) goto L7;
        FLogger.f375446a.i("ZLotteryGuideCell", "createLynxView return, isCreateLynxView = true");
    L13:
        FLogger.f375446a.i("ZLotteryGuideCell", "createLynxView");
        return;
    L7:
        FrameLayout r113 = this.f374117e;
        if (r113 == null) goto L13;
        this.f374119g = true;
        this.f374123k = System.currentTimeMillis();
        this.f374120h = Math.min(DeviceUtils.getScreenWidth(r113.getContext()), ((Number) i5.T1.getValue()).intValue() + i5.E());
        ViewGroup.LayoutParams r103 = r113.getLayoutParams();
        if (r103 == null) goto L15;
        r103.width = this.f374120h;
        r103.height = 0;
        r113.setLayoutParams(r103);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ZLotteryGuideCell$createLynxView$2(this, r113, r102, null), 2, null);
        goto L13
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L16:
        r101.updateData("");
        FLogger.f375446a.i("ZLotteryGuideCell", "updateData");
    }
}

package com.larus.uaigc.service;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 52\u00020\u0001:\u00015J\u0012\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH&J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\t\u001a\u00020\nH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\rH&J\b\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\nH&J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\u0006H&J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010!\u001a\u00020\u0006H&J\b\u0010\"\u001a\u00020\u0006H&J\b\u0010#\u001a\u00020\nH&J\b\u0010$\u001a\u00020\nH&J\b\u0010%\u001a\u00020\nH&JO\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\r2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010/J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H&J\u0010\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003H&¨\u00066"}, d2 = {"Lcom/larus/uaigc/service/IZLotteryService;", "", "guidePollingConfigFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/uaigc/bean/GuidePullingConfigData;", "onEnterZMainPage", "", "getCurHostReadState", "Lcom/larus/uaigc/bean/HostReadState;", "useCache", "", "isZLotteryGuideCardDisabled", "roundNum", "", "getRoundList", "", "Lcom/larus/uaigc/bean/LotteryRoundInfo;", "getCurRound", "getCurRoundWithFront", NewBroadcastMonitor.CAPTURE.FRONT, "isInLotteryRound", "isInNoPreheatingLotteryRound", "getCurRoundLotteryState", "getRoundLotteryState", "storeCurRoundLotteryState", "getNonLotteryShuffleTimes", "segmentId", "", "appendNonLotteryShuffleTimes", "getRoundBeginShuffleTimes", "appendBeginShuffleTimes", "getRoundShuffleTimes", "appendShuffleTimes", "storeShowLoadingButtonState", "storeSendNewYearAvatarMessageStatus", "getSendNewYearAvatarMessageStatus", "getShowLoadingButtonState", "disableOnboardingAndWcbNow", "reportPocketMessageCardShowed", "messageId", "lynxViewLoadSuccess", "createToLynxDuration", "", "cardType", "errorCode", "errorMsg", "isStream", "(Ljava/lang/String;ZJLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "createZLotteryGuideCellState", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "msg", "Lcom/larus/im/bean/message/Message;", "zLotteryGuideMsgShowFlow", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IZLotteryService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373948a = null;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0013\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010 \u001a\u00020\u0011H\u0096\u0001J\t\u0010!\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#H\u0096\u0001J\t\u0010%\u001a\u00020\u0011H\u0096\u0001J\t\u0010&\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010'\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010(\u001a\u00020\u0005H\u0096\u0001JJ\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\t2\b\u00101\u001a\u0004\u0018\u00010\u0011H\u0096\u0001¢\u0006\u0002\u00102J\t\u00103\u001a\u00020\u0005H\u0096\u0001J\t\u00104\u001a\u00020\u0005H\u0096\u0001J\t\u00105\u001a\u00020\u0005H\u0096\u0001J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010#H\u0096\u0001¨\u00067"}, d2 = {"Lcom/larus/uaigc/service/IZLotteryService$Companion;", "Lcom/larus/uaigc/service/IZLotteryService;", "<init>", "()V", "appendBeginShuffleTimes", "", "roundNum", "", "segmentId", "", "appendNonLotteryShuffleTimes", "appendShuffleTimes", "createZLotteryGuideCellState", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "msg", "Lcom/larus/im/bean/message/Message;", "disableOnboardingAndWcbNow", "", "getCurHostReadState", "Lcom/larus/uaigc/bean/HostReadState;", "useCache", "getCurRound", "Lcom/larus/uaigc/bean/LotteryRoundInfo;", "getCurRoundLotteryState", "getCurRoundWithFront", NewBroadcastMonitor.CAPTURE.FRONT, "getNonLotteryShuffleTimes", "getRoundBeginShuffleTimes", "getRoundList", "", "getRoundLotteryState", "getRoundShuffleTimes", "getSendNewYearAvatarMessageStatus", "getShowLoadingButtonState", "guidePollingConfigFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/uaigc/bean/GuidePullingConfigData;", "isInLotteryRound", "isInNoPreheatingLotteryRound", "isZLotteryGuideCardDisabled", "onEnterZMainPage", "reportPocketMessageCardShowed", "messageId", "lynxViewLoadSuccess", "createToLynxDuration", "", "cardType", "errorCode", "errorMsg", "isStream", "(Ljava/lang/String;ZJLjava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "storeCurRoundLotteryState", "storeSendNewYearAvatarMessageStatus", "storeShowLoadingButtonState", "zLotteryGuideMsgShowFlow", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IZLotteryService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373949c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IZLotteryService f373950b;

        static {
            f373949c = new Companion();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final i1<Boolean> E() {
            return this.f373950b.E();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void a() {
            this.f373950b.a();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void b() {
            this.f373950b.b();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final hy9.g c(int r100) {
            return this.f373950b.c(r100);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean d() {
            return this.f373950b.d();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final List e() {
            return this.f373950b.e();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean f() {
            return this.f373950b.f();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "segmentId");
            this.f373950b.g(r100);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final hy9.b h(boolean r100) {
            return this.f373950b.h(r100);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void i(String r110, boolean r111, long r112, String r113, int r114, String r115, Boolean r116) {
            Intrinsics.checkNotNullParameter(r110, "messageId");
            Intrinsics.checkNotNullParameter(r113, "cardType");
            this.f373950b.i(r110, r111, r112, r113, r114, r115, r116);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean j(int r100) {
            return this.f373950b.j(r100);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean k() {
            return this.f373950b.k();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void l(String r100) {
            Intrinsics.checkNotNullParameter(r100, "segmentId");
            this.f373950b.l(r100);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final int m(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "segmentId");
            return this.f373950b.m(r100, r101);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final hy9.g n() {
            return this.f373950b.n();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean o() {
            return this.f373950b.o();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void p(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "segmentId");
            this.f373950b.p(r100, r101);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void q() {
            this.f373950b.q();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final void r() {
            this.f373950b.r();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final xc8.b s(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return this.f373950b.s(r100);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean t() {
            return this.f373950b.t();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final int u(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "segmentId");
            return this.f373950b.u(r100, r101);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean v() {
            return this.f373950b.v();
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final boolean w(int r100) {
            return this.f373950b.w(r100);
        }

        @Override // com.larus.uaigc.service.IZLotteryService
        public final int x(String r100) {
            Intrinsics.checkNotNullParameter(r100, "segmentId");
            return this.f373950b.x(r100);
        }

        private Companion() {
            IZLotteryService r100 = (IZLotteryService) ServiceManager.get().getService(IZLotteryService.class);
            if (r100 != null) goto L5;
            r100 = new IZLotteryServiceNoop();
        L5:
            this.f373950b = r100;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(Companion r110, String r111, boolean r112, long r113, String r114, int r115, String r116, Boolean r117, int r118) {
            if ((r118 & 16) == 0) goto L5;
            int r100 = 0;
        L7:
            if ((r118 & 32) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r118 & 64) == 0) goto L13;
            Boolean r102 = Boolean.FALSE;
        L14:
            r110.i(r111, r112, r113, r114, r100, r101, r102);
            return;
        L13:
            r102 = r117;
            goto L14
        L9:
            r101 = r116;
            goto L11
        L5:
            r100 = r115;
            goto L7
        }
    }

    static {
        f373948a = Companion.f373949c;
    }

    i1<Boolean> E();

    void a();

    void b();

    hy9.g c(int r100);

    boolean d();

    List e();

    boolean f();

    void g(String r100);

    hy9.b h(boolean r100);

    void i(String r100, boolean r101, long r102, String r103, int r104, String r105, Boolean r106);

    boolean j(int r100);

    boolean k();

    void l(String r100);

    int m(int r100, String r101);

    hy9.g n();

    boolean o();

    void p(int r100, String r101);

    void q();

    void r();

    xc8.b s(Message r100);

    boolean t();

    int u(int r100, String r101);

    boolean v();

    boolean w(int r100);

    int x(String r100);
}

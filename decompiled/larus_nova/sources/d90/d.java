package d90;

import android.content.Context;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class d extends h70.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f467476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MiddlewareRoomContext f467477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f467478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IRoomContextService f467479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f467480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final IAbilityCenter f467481i;

    public static final class a {
        public static final j70.f A = null;
        public static final j70.f A0 = null;
        public static final j70.f A1 = null;
        public static final j70.f A2 = null;
        public static final j70.f A3 = null;
        public static final j70.f B = null;
        public static final j70.f B0 = null;
        public static final j70.f B1 = null;
        public static final j70.f B2 = null;
        public static final j70.f B3 = null;
        public static final j70.f C = null;
        public static final j70.f C0 = null;
        public static final j70.f C1 = null;
        public static final j70.f C2 = null;
        public static final j70.f C3 = null;
        public static final j70.f D = null;
        public static final j70.f D0 = null;
        public static final j70.f D1 = null;
        public static final j70.f D2 = null;
        public static final j70.f D3 = null;
        public static final j70.f E = null;
        public static final j70.f E0 = null;
        public static final j70.f E1 = null;
        public static final j70.f E2 = null;
        public static final j70.f E3 = null;
        public static final j70.f F = null;
        public static final j70.f F0 = null;
        public static final j70.f F1 = null;
        public static final j70.f F2 = null;
        public static final j70.f F3 = null;
        public static final j70.f G = null;
        public static final j70.f G0 = null;
        public static final j70.f G1 = null;
        public static final j70.f G2 = null;
        public static final j70.f G3 = null;
        public static final j70.f H = null;
        public static final j70.f H0 = null;
        public static final j70.f H1 = null;
        public static final j70.f H2 = null;
        public static final j70.f H3 = null;
        public static final j70.f I = null;
        public static final j70.f I0 = null;
        public static final j70.f I1 = null;
        public static final j70.f I2 = null;
        public static final j70.f I3 = null;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public static final j70.f f467482J = null;
        public static final j70.f J0 = null;
        public static final j70.f J1 = null;
        public static final j70.f J2 = null;
        public static final j70.f J3 = null;
        public static final j70.f K = null;
        public static final j70.f K0 = null;
        public static final j70.f K1 = null;
        public static final j70.f K2 = null;
        public static final a K3 = null;
        public static final j70.f L = null;
        public static final j70.f L0 = null;
        public static final j70.f L1 = null;
        public static final j70.f L2 = null;
        public static final j70.f M = null;
        public static final j70.f M0 = null;
        public static final j70.f M1 = null;
        public static final j70.f M2 = null;
        public static final j70.f N = null;
        public static final j70.f N0 = null;
        public static final j70.f N1 = null;
        public static final j70.f N2 = null;
        public static final j70.f O = null;
        public static final j70.f O0 = null;
        public static final j70.f O1 = null;
        public static final j70.f O2 = null;
        public static final j70.f P = null;
        public static final j70.f P0 = null;
        public static final j70.f P1 = null;
        public static final j70.f P2 = null;
        public static final j70.f Q = null;
        public static final j70.f Q0 = null;
        public static final j70.f Q1 = null;
        public static final j70.f Q2 = null;
        public static final j70.f R = null;
        public static final j70.f R0 = null;
        public static final j70.f R1 = null;
        public static final j70.f R2 = null;
        public static final j70.f S = null;
        public static final j70.f S0 = null;
        public static final j70.f S1 = null;
        public static final j70.f S2 = null;
        public static final j70.f T = null;
        public static final j70.f T0 = null;
        public static final j70.f T1 = null;
        public static final j70.f T2 = null;
        public static final j70.f U = null;
        public static final j70.f U0 = null;
        public static final j70.f U1 = null;
        public static final j70.f U2 = null;
        public static final j70.f V = null;
        public static final j70.f V0 = null;
        public static final j70.f V1 = null;
        public static final j70.f V2 = null;
        public static final j70.f W = null;
        public static final j70.f W0 = null;
        public static final j70.f W1 = null;
        public static final j70.f W2 = null;
        public static final j70.f X = null;
        public static final j70.f X0 = null;
        public static final j70.f X1 = null;
        public static final j70.f X2 = null;
        public static final j70.f Y = null;
        public static final j70.f Y0 = null;
        public static final j70.f Y1 = null;
        public static final j70.f Y2 = null;
        public static final j70.f Z = null;
        public static final j70.f Z0 = null;
        public static final j70.f Z1 = null;
        public static final j70.f Z2 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j70.f f467483a = null;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public static final j70.f f467484a0 = null;

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        public static final j70.f f467485a1 = null;

        /* JADX INFO: renamed from: a2, reason: collision with root package name */
        public static final j70.f f467486a2 = null;

        /* JADX INFO: renamed from: a3, reason: collision with root package name */
        public static final j70.f f467487a3 = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j70.f f467488b = null;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final j70.f f467489b0 = null;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        public static final j70.f f467490b1 = null;

        /* JADX INFO: renamed from: b2, reason: collision with root package name */
        public static final j70.f f467491b2 = null;

        /* JADX INFO: renamed from: b3, reason: collision with root package name */
        public static final j70.f f467492b3 = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j70.f f467493c = null;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final j70.f f467494c0 = null;

        /* JADX INFO: renamed from: c1, reason: collision with root package name */
        public static final j70.f f467495c1 = null;

        /* JADX INFO: renamed from: c2, reason: collision with root package name */
        public static final j70.f f467496c2 = null;

        /* JADX INFO: renamed from: c3, reason: collision with root package name */
        public static final j70.f f467497c3 = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final j70.f f467498d = null;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public static final j70.f f467499d0 = null;

        /* JADX INFO: renamed from: d1, reason: collision with root package name */
        public static final j70.f f467500d1 = null;

        /* JADX INFO: renamed from: d2, reason: collision with root package name */
        public static final j70.f f467501d2 = null;

        /* JADX INFO: renamed from: d3, reason: collision with root package name */
        public static final j70.f f467502d3 = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final j70.f f467503e = null;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public static final j70.f f467504e0 = null;

        /* JADX INFO: renamed from: e1, reason: collision with root package name */
        public static final j70.f f467505e1 = null;

        /* JADX INFO: renamed from: e2, reason: collision with root package name */
        public static final j70.f f467506e2 = null;

        /* JADX INFO: renamed from: e3, reason: collision with root package name */
        public static final j70.f f467507e3 = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final j70.f f467508f = null;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public static final j70.f f467509f0 = null;

        /* JADX INFO: renamed from: f1, reason: collision with root package name */
        public static final j70.g f467510f1 = null;

        /* JADX INFO: renamed from: f2, reason: collision with root package name */
        public static final j70.f f467511f2 = null;

        /* JADX INFO: renamed from: f3, reason: collision with root package name */
        public static final j70.f f467512f3 = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final j70.f f467513g = null;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public static final j70.f f467514g0 = null;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        public static final j70.g f467515g1 = null;

        /* JADX INFO: renamed from: g2, reason: collision with root package name */
        public static final j70.f f467516g2 = null;

        /* JADX INFO: renamed from: g3, reason: collision with root package name */
        public static final j70.f f467517g3 = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final j70.f f467518h = null;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public static final j70.f f467519h0 = null;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public static final j70.f f467520h1 = null;

        /* JADX INFO: renamed from: h2, reason: collision with root package name */
        public static final j70.f f467521h2 = null;

        /* JADX INFO: renamed from: h3, reason: collision with root package name */
        public static final j70.f f467522h3 = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final j70.f f467523i = null;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public static final j70.f f467524i0 = null;

        /* JADX INFO: renamed from: i1, reason: collision with root package name */
        public static final j70.f f467525i1 = null;

        /* JADX INFO: renamed from: i2, reason: collision with root package name */
        public static final j70.f f467526i2 = null;

        /* JADX INFO: renamed from: i3, reason: collision with root package name */
        public static final j70.f f467527i3 = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final j70.f f467528j = null;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public static final j70.f f467529j0 = null;

        /* JADX INFO: renamed from: j1, reason: collision with root package name */
        public static final j70.f f467530j1 = null;

        /* JADX INFO: renamed from: j2, reason: collision with root package name */
        public static final j70.f f467531j2 = null;

        /* JADX INFO: renamed from: j3, reason: collision with root package name */
        public static final j70.f f467532j3 = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final j70.f f467533k = null;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public static final j70.f f467534k0 = null;

        /* JADX INFO: renamed from: k1, reason: collision with root package name */
        public static final j70.f f467535k1 = null;

        /* JADX INFO: renamed from: k2, reason: collision with root package name */
        public static final j70.f f467536k2 = null;

        /* JADX INFO: renamed from: k3, reason: collision with root package name */
        public static final j70.f f467537k3 = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final j70.f f467538l = null;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public static final j70.f f467539l0 = null;

        /* JADX INFO: renamed from: l1, reason: collision with root package name */
        public static final j70.f f467540l1 = null;

        /* JADX INFO: renamed from: l2, reason: collision with root package name */
        public static final j70.f f467541l2 = null;

        /* JADX INFO: renamed from: l3, reason: collision with root package name */
        public static final j70.f f467542l3 = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final j70.f f467543m = null;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public static final j70.f f467544m0 = null;

        /* JADX INFO: renamed from: m1, reason: collision with root package name */
        public static final j70.f f467545m1 = null;

        /* JADX INFO: renamed from: m2, reason: collision with root package name */
        public static final j70.f f467546m2 = null;

        /* JADX INFO: renamed from: m3, reason: collision with root package name */
        public static final j70.f f467547m3 = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final j70.f f467548n = null;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public static final j70.f f467549n0 = null;

        /* JADX INFO: renamed from: n1, reason: collision with root package name */
        public static final j70.f f467550n1 = null;

        /* JADX INFO: renamed from: n2, reason: collision with root package name */
        public static final j70.f f467551n2 = null;

        /* JADX INFO: renamed from: n3, reason: collision with root package name */
        public static final j70.f f467552n3 = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final j70.f f467553o = null;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public static final j70.f f467554o0 = null;

        /* JADX INFO: renamed from: o1, reason: collision with root package name */
        public static final j70.f f467555o1 = null;

        /* JADX INFO: renamed from: o2, reason: collision with root package name */
        public static final j70.f f467556o2 = null;

        /* JADX INFO: renamed from: o3, reason: collision with root package name */
        public static final j70.f f467557o3 = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final j70.f f467558p = null;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public static final j70.f f467559p0 = null;

        /* JADX INFO: renamed from: p1, reason: collision with root package name */
        public static final j70.f f467560p1 = null;

        /* JADX INFO: renamed from: p2, reason: collision with root package name */
        public static final j70.f f467561p2 = null;

        /* JADX INFO: renamed from: p3, reason: collision with root package name */
        public static final j70.f f467562p3 = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final j70.f f467563q = null;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public static final j70.f f467564q0 = null;

        /* JADX INFO: renamed from: q1, reason: collision with root package name */
        public static final j70.f f467565q1 = null;

        /* JADX INFO: renamed from: q2, reason: collision with root package name */
        public static final j70.f f467566q2 = null;

        /* JADX INFO: renamed from: q3, reason: collision with root package name */
        public static final j70.f f467567q3 = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final j70.f f467568r = null;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static final j70.f f467569r0 = null;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        public static final j70.f f467570r1 = null;

        /* JADX INFO: renamed from: r2, reason: collision with root package name */
        public static final j70.f f467571r2 = null;

        /* JADX INFO: renamed from: r3, reason: collision with root package name */
        public static final j70.f f467572r3 = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final j70.f f467573s = null;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public static final j70.f f467574s0 = null;

        /* JADX INFO: renamed from: s1, reason: collision with root package name */
        public static final j70.f f467575s1 = null;

        /* JADX INFO: renamed from: s2, reason: collision with root package name */
        public static final j70.f f467576s2 = null;

        /* JADX INFO: renamed from: s3, reason: collision with root package name */
        public static final j70.f f467577s3 = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final j70.f f467578t = null;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public static final j70.f f467579t0 = null;

        /* JADX INFO: renamed from: t1, reason: collision with root package name */
        public static final j70.f f467580t1 = null;

        /* JADX INFO: renamed from: t2, reason: collision with root package name */
        public static final j70.f f467581t2 = null;

        /* JADX INFO: renamed from: t3, reason: collision with root package name */
        public static final j70.f f467582t3 = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final j70.f f467583u = null;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public static final j70.f f467584u0 = null;

        /* JADX INFO: renamed from: u1, reason: collision with root package name */
        public static final j70.f f467585u1 = null;

        /* JADX INFO: renamed from: u2, reason: collision with root package name */
        public static final j70.f f467586u2 = null;

        /* JADX INFO: renamed from: u3, reason: collision with root package name */
        public static final j70.f f467587u3 = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final j70.f f467588v = null;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public static final j70.f f467589v0 = null;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public static final j70.f f467590v1 = null;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public static final j70.f f467591v2 = null;

        /* JADX INFO: renamed from: v3, reason: collision with root package name */
        public static final j70.f f467592v3 = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final j70.f f467593w = null;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public static final j70.f f467594w0 = null;

        /* JADX INFO: renamed from: w1, reason: collision with root package name */
        public static final j70.f f467595w1 = null;

        /* JADX INFO: renamed from: w2, reason: collision with root package name */
        public static final j70.f f467596w2 = null;

        /* JADX INFO: renamed from: w3, reason: collision with root package name */
        public static final j70.f f467597w3 = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final j70.f f467598x = null;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public static final j70.f f467599x0 = null;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        public static final j70.f f467600x1 = null;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        public static final j70.f f467601x2 = null;

        /* JADX INFO: renamed from: x3, reason: collision with root package name */
        public static final j70.f f467602x3 = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final j70.f f467603y = null;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public static final j70.f f467604y0 = null;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        public static final j70.f f467605y1 = null;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        public static final j70.f f467606y2 = null;

        /* JADX INFO: renamed from: y3, reason: collision with root package name */
        public static final j70.f f467607y3 = null;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final j70.f f467608z = null;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public static final j70.f f467609z0 = null;

        /* JADX INFO: renamed from: z1, reason: collision with root package name */
        public static final j70.f f467610z1 = null;

        /* JADX INFO: renamed from: z2, reason: collision with root package name */
        public static final j70.f f467611z2 = null;

        /* JADX INFO: renamed from: z3, reason: collision with root package name */
        public static final j70.f f467612z3 = null;

        public a() {
        }

        static {
            K3 = new a();
            new j70.f("拍摄道具", "shootEffect");
            f467483a = new j70.f("节目首播播放事件提供", "episodePlayEventNotify");
            f467488b = new j70.f("节目首播消息通道切换服务", "episodeSeekMessageService");
            f467493c = new j70.f("横屏互动组件", "landscapeActivityInteraction");
            f467498d = new j70.f("高光容器（问答、评论上墙、预告）", "highlight");
            new j70.f("高光容器控制服务", "controlHighlightService");
            f467503e = new j70.f("观众连线实时字幕", "linkmicSubtitle");
            f467508f = new j70.f("回溯录制", "liveBacktrack");
            f467513g = new j70.f("录屏", "liveRecord");
            f467518h = new j70.f("高光录屏", "liveHighlightRecord");
            new j70.f("图片演示模式", "picturePresentation");
            new j70.f("云导播合流组件", "groupLiveStream");
            f467523i = new j70.f("普通直播间拖动进度条提示信息", "liveThumb");
            f467528j = new j70.f("主播公益服务", "welfareAnchorService");
            f467533k = new j70.f("主播电商服务", "commerceAnchorService");
            f467538l = new j70.f("火山打猴子", "monkeyGame");
            f467543m = new j70.f("礼物", PbRequest.SwitchType.GIFT);
            f467548n = new j70.f("礼物事件接收组件", "giftTouchReceive");
            f467553o = new j70.f("礼物特效信息展示组件", "giftEffectInfoLynx");
            f467558p = new j70.f("礼物业务第四行容器组件", "giftFourthLineLynx");
            f467563q = new j70.f("礼物Lynx特效", "giftFrontSeatLayerEffect");
            f467568r = new j70.f("赛事直播间边看边聊氛围", "chatChannelAtmosphere");
            f467573s = new j70.f("主播口播转评论", "anchorAsr");
            f467578t = new j70.f("图像识别", "iamgeRecognition");
            f467583u = new j70.f("手势礼物引导", "gestureGiftGuide");
            f467588v = new j70.f("PK礼物微托盘", "pkTray");
            f467593w = new j70.f("PK道具卡抽卡特效", "pkBattlePropEffect");
            f467598x = new j70.f("通用的 lottie 动画", "commonLottie");
            f467603y = new j70.f("主播任务完成动画", "taskFinishAnimation");
            f467608z = new j70.f("观众端Toolbar", NewBroadcastMonitor.STAGE.TOOLBAR);
            A = new j70.f("无障碍唤起交互层按钮", "a11yInteractionCtl");
            B = new j70.f("观众端媒体直播间Toolbar", "mediaToolbar");
            C = new j70.f("主播端 Toolbar", "broadcastToolbar");
            D = new j70.f("评论输入框", "comment");
            E = new j70.f("评论框左侧入口", "userAvatar");
            new j70.f("语音评论响应点击事件外层容器", "commentTetris");
            F = new j70.f("右侧外部卡片占位", "rightExternalCardPlaceHolder");
            G = new j70.f("底部外部卡片占位", "bottomExternalCardPlaceHolder");
            new j70.f("竖屏第四行右侧容器占位", "topRightFourthRowPlaceHolder");
            H = new j70.f("售票讲解卡", "paidLiveTicketCardPlaceHolder");
            I = new j70.f("付费播放器提示条服务", "paidPlayerTipServices");
            f467482J = new j70.f("付费Scope检查服务", "paidScopeCheckServices");
            K = new j70.f("主播放映短视频", "videoPlayControl");
            new j70.f("主播录屏监听", "screenRecordMonitor");
            L = new j70.f("主播互动特效音乐", "anchorKtvEffectMusic");
            M = new j70.f("通用的5.5层容器", "commonPopup");
            new j70.f("小程序游戏控制器", "wminiGameControl");
            N = new j70.f("录屏发布进度", "recordPublishProgress");
            O = new j70.f("debug测试信息", "debugTestInfo");
            new j70.f("triangle端通信服务", "debugSocketCommunicationSw");
            new j70.f("triangleDSL端预览服务", "debugDSLPreviewService");
            P = new j70.f("礼物特效预览", "giftPreviewDebug");
            new j70.f("Aio服务中枢对应widget", "aioDynamicCenterServiceDebug");
            Q = new j70.f("营收生命周期获取widget, 无实际逻辑", "revenueLifecycleWidget");
            R = new j70.f("水印", "sandboxWaterMark");
            S = new j70.f("竖屏第二行左侧发现区", "portraitRow2ndDiscovery");
            T = new j70.f("交互层元素显隐控制", "liveVisibilityControl");
            U = new j70.f("观众端更多直播入口", "drawerEntrance");
            V = new j70.f("主播侧状态中心面板的入口", "anchorStatusPanelEntrance");
            new j70.f("主播侧状态中心面板的mock入口", "mockPanelEntrance");
            new j70.f("主播侧状态中心面板的入口数据的mock", "anchorStatusPanelEntranceMock");
            W = new j70.f("主播端网络信号", "netSpeedMonitor");
            X = new j70.f("主播静音标识", "anchorSilenceStatus");
            Y = new j70.f("主播端竖屏第二行", "anchorPortraitRow2nd");
            Z = new j70.f("竖屏的公屏区", "portraitPublicScreen");
            f467484a0 = new j70.f("直播间水印", "liveWaterMask");
            f467489b0 = new j70.f("主播异常检测", "anchorAnomalyDetection");
            f467494c0 = new j70.f("主播连屏音频异常评论检测", "anchorAudioAbnormalDetection");
            f467499d0 = new j70.f("竖屏的频道服务", "portraitChatChannelService");
            f467504e0 = new j70.f("答题容器Widget", "answerQuestionService");
            f467509f0 = new j70.f("团播rts容器Widget", "groupLiveRtsService");
            f467514g0 = new j70.f("聊天频道IM互动表情动画播放器", "channelIMEmojiAnimPlayer");
            f467519h0 = new j70.f("互动资源服务", "interactivityResource");
            f467524i0 = new j70.f("多机位服务", "interactivityMultiCamera");
            f467529j0 = new j70.f("横屏的公屏服务组件", "landscapePublicScreenService");
            f467534k0 = new j70.f("IM服务", "industryIMServiceWidget");
            f467539l0 = new j70.f("横屏左上角返回", "landscapeNavigator");
            new j70.f("横屏第一行的直播标题", "live_title");
            new j70.f("竖屏第六行的直播标题", "live_title");
            f467544m0 = new j70.f("横屏下的头部和底部的背景遮罩", "landscapeMask");
            f467549n0 = new j70.f("横屏顶部设备信息栏", "landscapeTopPhoneInfo");
            f467554o0 = new j70.f("提词器", "promptDisplay");
            f467559p0 = new j70.f("竖屏右下banner", "portraitRightBottomBanner");
            new j70.f("横屏右下banner", "landscapeRightBottomBanner");
            f467564q0 = new j70.f("竖屏右下互动卡片容器", "portraitCommonCardArea");
            new j70.f("添加图片服务", "addPicService");
            f467569r0 = new j70.f("可见性范围变更通知", "visibilityRangeChangeServiceWidget");
            new j70.f("桌面组件引导", "appWidgetGuide");
            f467574s0 = new j70.f("进房引导动画", "roomEnterGuideAnim");
            f467579t0 = new j70.f("竖屏短触运营区", "portraitShortTermOperation");
            f467584u0 = new j70.f("竖屏距离顶部布局的特殊控件", "portraitTopExtraOperation");
            f467589v0 = new j70.f("横屏右上角活动Banner", "landscapeTopRightBanner");
            f467594w0 = new j70.f("竖屏第四行", "portraitRow4th");
            f467599x0 = new j70.f("XBridgeEventCenter前端通信", "xBridgeServiceWidget");
            new j70.f("抖音极速版任务", "rapidTaskWidget");
            f467604y0 = new j70.f("裸眼3D特效", "multiEffectWidget");
            new j70.f("火山TopRank", "topRankWidget");
            f467609z0 = new j70.f("观众端隐私信息", "privateDebugInfoWidget");
            A0 = new j70.f("你画我猜场景预览流小窗", "dragPlayerWidget");
            B0 = new j70.f("lynx测试", "lynxTestWidget");
            new j70.f("懂车帝卡片相关", "autoCar");
            C0 = new j70.f("主播开播状态合规提醒", "illegalLoading");
            D0 = new j70.f("全屏动画的Widget", "animationLayerWidget");
            E0 = new j70.f("主播游戏", "broadcastGameWidget");
            F0 = new j70.f("观众端游戏", "audienceGameWidget");
            G0 = new j70.f("主播贴纸容器", "anchorStickerContainer");
            H0 = new j70.f("观众端清屏之后的水印", "clearScreenWater");
            I0 = new j70.f("看播侧引导页层", "guidePage");
            J0 = new j70.f("活动盛典通知", "ceremonyPrizeNoticeWidget");
            new j70.f("活动盛典通知", "ceremonyBorderWidget");
            K0 = new j70.f("世界横幅通知", "roomNotify");
            new j70.f("主播评论ping", "anchorCommentPin");
            L0 = new j70.f("主播预告贴片服务", "anchorAnnouncementHighlightService");
            M0 = new j70.f("主播预告贴片", "anchorAnnouncementHighlight");
            N0 = new j70.f("主播调焦&曝光容器", "anchorFocusWidget");
            new j70.f("主播试播直播间服务", "anchorTrialWidget");
            O0 = new j70.f("横屏亮度和音量", "brightnessVolume");
            P0 = new j70.f("横屏小左下角的 banner", "landscapeBottomBanner");
            new j70.f("电商直播间横屏的小商品卡片", "landscapePromotionCard");
            Q0 = new j70.f("横屏右上角 Toolbar", "landscapeTopToolbar");
            R0 = new j70.f("横屏锁屏", "landscapeLock");
            S0 = new j70.f("快拍截屏动画蒙层", "quickShotLayer");
            T0 = new j70.f("快拍截屏自动监听动画蒙层", "quickShotAutoLayer");
            U0 = new j70.f("快拍录屏和截屏", "landscapeRecordAndShot");
            V0 = new j70.f("点赞", "digg");
            W0 = new j70.f("竖屏弹幕", "portraitBarrage");
            X0 = new j70.f("竖屏狂欢时刻弹幕", "portraitCarnivalBarrage");
            Y0 = new j70.f("商业化压屏条", "businessScreenBar");
            Z0 = new j70.f("拦截触摸事件", "fullInterceptTouch");
            f467485a1 = new j70.f("返回上一个直播间套娃", "backToPreRoom");
            f467490b1 = new j70.f("粉丝团人气榜单：观众端飘心动画、人气王彩蛋动画", "fansRankListAnimation");
            f467495c1 = new j70.f("直播间吸底消息", "roomPush");
            f467500d1 = new j70.f("入场动画", "enterAnim");
            f467505e1 = new j70.f("小游戏直播间的 SEI 消息", "seiMessage");
            f467510f1 = new j70.g("播放器的虚拟容器", "shadowPlayer");
            f467515g1 = new j70.g("播放器区域上下的阴影", "playerShadow");
            new j70.f("播放器水印", "watermark");
            f467520h1 = new j70.f("进度条区域", "progressBar");
            f467525i1 = new j70.f("全屏按钮", "fullVideoButton");
            f467530j1 = new j70.f("关注服务", "followStatusService");
            new j70.f("付费会员消息服务", "paidLiveInfoService");
            f467535k1 = new j70.f("投屏", "castScreen");
            f467540l1 = new j70.f("竖屏流投屏", "portraitCastScreenConnect");
            f467545m1 = new j70.f("竖屏播控层显影控制", "portraitVisibilityController");
            f467550n1 = new j70.f("竖屏播放器区域点击事件", "portraitPlayerGesture");
            f467555o1 = new j70.f("竖屏流投屏流蒙层", "castScreenPortraitStreamMask");
            f467560p1 = new j70.f("弹幕投屏监听组件", "castDanmakuService");
            new j70.f("投屏loading", "castScreenLoading");
            f467565q1 = new j70.f("投屏入口", "castScreenEntry");
            f467570r1 = new j70.f("续播入口", "multiDeviceEntry");
            new j70.f("视频ktv进度条", "ktvChallengeProgressBar");
            f467575s1 = new j70.f("歌房小卡片入口", "ktvRoomAccess");
            new j70.f("歌房推荐歌单卡片", "ktvPreviewSongsCard");
            f467580t1 = new j70.f("虚拟播放器下边缘到屏幕底部", "shadowLivePlayerBottom");
            f467585u1 = new j70.f("付费演出-试看门票", "paidLiveTicketForTempWatch");
            f467590v1 = new j70.f("付费试看转化组件通用", "paidLiveConversionContainer");
            f467595w1 = new j70.f("付费试看手势处理", "paidLiveGesture");
            f467600x1 = new j70.f("付费演出-金主助力票", "paidLiveShareTicket");
            new j70.f("付费播放tip服务", "paidPlayerTip");
            new j70.f("付费-试看组件容器", "paidConversionCard");
            f467605y1 = new j70.f("播放器副画面", "playerExtraRender");
            f467610z1 = new j70.f("播放器底部进度条区域", "playerProgressBarTetris");
            A1 = new j70.f("普通直播间进度条", "liveProgressBar");
            B1 = new j70.f("普通直播间播放暂停按钮", "livePlayerControl");
            C1 = new j70.f("视屏流左下方电商容器", "playerBottomLeftContainer");
            D1 = new j70.f("横屏左下角电商容器", "landscapeBottomLeftContainer");
            E1 = new j70.f("流底部面板打开服务", "bottomPanelService");
            F1 = new j70.f("TriangleDsl服务", "triangleService");
            G1 = new j70.f("流高度获取组件", "roomShadowPlayerBottom");
            new j70.f("充值", PbRequest.SwitchType.RECHARGE);
            H1 = new j70.f("直播间可见性范围历史拉取", "startLiveVisibilityTransform");
            I1 = new j70.f("官方巡查员主播侧右上角widget", "officialInspectorWidget");
            J1 = new j70.f("首播中的定时关闭widget", "scheduleClose");
            K1 = new j70.f("VS选集入口", "vsSelectEntry");
            L1 = new j70.f("长按面板处理推荐直播间给粉丝", "longPressPanelService");
            M1 = new j70.f("清屏服务", "clearMonitorServiceWidget");
            N1 = new j70.f("倒计时任务", "countdownTaskWidget");
            O1 = new j70.f("个人资料卡服务", "profileServiceWidget");
            P1 = new j70.f("用户服务", "userServiceWidget");
            Q1 = new j70.f("心愿单完成触发手势魔法", "wishFinishGesture");
            R1 = new j70.f("vr直播全景模式", "vrModeAudience");
            new j70.f("vr直播清屏模式下的手势操作", "vrClearGestureWidget");
            S1 = new j70.f("可拖拽组件临时方案", "tempDraggableWindow");
            T1 = new j70.f("信息窗卡片区容器", "msgWindowCard");
            U1 = new j70.f("左上角信息窗卡片区容器", "topLeftWindowCard");
            V1 = new j70.f("右上角信息窗卡片区容器", "topRightWindowCard");
            W1 = new j70.f("可拖拽组件", "draggableComponent");
            X1 = new j70.f("可拖拽组件服务", "draggableServiceWidget");
            new j70.f("体验优化房间性能框架服务组件", "expRoomLauncherWidget");
            Y1 = new j70.f("体验优化push服务组件", "expPushServiceWidget");
            new j70.f("主播经营面板", "anchorBizPanel");
            Z1 = new j70.f("主播状态中心面板", "anchorStatusPanel");
            f467486a2 = new j70.f("主播连线扩展记值组件", "profitInteractionDataWidget");
            f467491b2 = new j70.f("视频小窗、观众连线之类的能影响到右下角卡片展示的空壳儿卡片服务", "videoOrLinkCardShellService");
            f467496c2 = new j70.f("提供前端获取话题埋点参数的服务", "liveTopicGetParamsMethodWidget");
            f467501d2 = new j70.f("录屏监听引导发布", "liveScreenRecordGuidePublish");
            f467506e2 = new j70.f("放大画面场景下还原画面", "restoreView");
            f467511f2 = new j70.f("横屏直播间刷新按钮", "refreshView");
            f467516g2 = new j70.f("抖音极速版宝箱新入口", "newGoldTaskEntrance");
            f467521h2 = new j70.f("节目直播介绍", "vsLiveDetail");
            f467526i2 = new j70.f("直播介绍", "liveDetail");
            new j70.f("预览流卡片展现条件监测服务", "previewCardConditionMonitor");
            f467531j2 = new j70.f("节目留言板服务", "vsMsgBoardService");
            f467536k2 = new j70.f("横屏截屏监测", "landscapeQuickShotServiceWidget");
            f467541l2 = new j70.f("播放器tips", "landscapePlayerTipsTetris");
            new j70.f("特权MP4播放器", "profitMp4Player");
            f467546m2 = new j70.f("主播特效佩戴信息", "AnchorEffectStatusServiceWidget");
            f467551n2 = new j70.f("平台化黄点能力", "AnchorToolbarDotMessageWidget");
            new j70.f("主播互动工具信息上传", "InteractToolInfoUploadServiceWidget");
            new j70.f("主播互动工具性能调试组件", "InteractToolPerformanceWidget");
            f467556o2 = new j70.f("主播打开特效选择面板", "LiveStickerSelectServiceWidget");
            f467561p2 = new j70.f("主播渲染礼物菜单特效", "LiveGiftMenuStickerServiceWidget");
            f467566q2 = new j70.f("观众进房领取宠粉红包", "AudienceFansRedPacketWidget");
            f467571r2 = new j70.f("嘉宾佩戴特效", "AudienceStickerServiceWidget");
            f467576s2 = new j70.f("节目横屏更多节目/直播入口", "vsLandscapeDrawerEntrance");
            f467581t2 = new j70.f("节目横屏重置播放器画面", "vsLandscapeResetPlayerView");
            f467586u2 = new j70.f("节目横屏手势引导", "");
            f467591v2 = new j70.f("首播pop", "firstShowPop");
            f467596w2 = new j70.f("直播间宠物的容器", "live_pet_container");
            f467601x2 = new j70.f("直播中组件", "inLive");
            f467606y2 = new j70.f("关闭直播间X号", "closeRoom");
            f467611z2 = new j70.f("竖屏第一行", "portraitRoomTopNavigator");
            A2 = new j70.f("旧的竖屏媒体头部组件", "portraitMediaView");
            B2 = new j70.f("旧的横屏媒体头部组件", "landscapeMediaView");
            C2 = new j70.f("横屏评论屏蔽", "landscapeBlockComment");
            D2 = new j70.f("节目、赛事直播间多机位、锁链竖屏横流两种入口", "multiCameraLinkedRoomEntrance");
            E2 = new j70.f("旧的竖屏节目互动组件", "portraitEpisodeInteractive");
            F2 = new j70.f("旧的横屏节目互动组件", "landscapeEpisodeInteractive");
            G2 = new j70.f("横屏导航栏", "landscapeRoomTopNavigator");
            H2 = new j70.f("旧的赛事/VS直播间第二行在线人数", "matchLandscapeCount");
            I2 = new j70.f("VS主播信息", "vsAnchorInfo");
            J2 = new j70.f("旧的横屏第二行在线人", "landscapeUserRank");
            K2 = new j70.f("旧的横屏更多直播", "landscapeMoreLive");
            L2 = new j70.f("旧的横屏发现区", "landscapeDiscovery");
            M2 = new j70.f("旧的短触", "oldShortTouch");
            N2 = new j70.f("旧的长触", "oldLongTouch");
            O2 = new j70.f("旧的右上角banner", "oldBanner");
            P2 = new j70.f("新组件市场标题栏", "media_title");
            Q2 = new j70.f("新组件市场在线人数", "media_count");
            R2 = new j70.f("新组件市场主播信息区", "media_avator");
            S2 = new j70.f("节目、赛事直播间多机位、锁链竖屏横流两种入口", "multicam");
            T2 = new j70.f("融合互动组件", "interactive");
            U2 = new j70.f("通用dsl加载容器", "dynamic_dsl");
            V2 = new j70.f("公屏", "public_screen");
            W2 = new j70.f("主播头像", "anchor_avatar");
            X2 = new j70.f("电商主播头像", "anchor_avatar_ec");
            Y2 = new j70.f("点赞无障碍", "dig_accessibility");
            Z2 = new j70.f("麦序榜", "user_rank");
            f467487a3 = new j70.f("普通直播间在线人数", "user_count");
            f467492b3 = new j70.f("发现区", "discovery");
            f467497c3 = new j70.f("电商发现区", "discovery_ec");
            f467502d3 = new j70.f("电商蒙层", "ecShadow");
            f467507e3 = new j70.f("更多直播", "more_live");
            f467512f3 = new j70.f("短触", "short_touch");
            f467517g3 = new j70.f("长触", "long_touch");
            f467522h3 = new j70.f("banner", "banner");
            f467527i3 = new j70.f("全屏按钮", "full_screen");
            f467532j3 = new j70.f("进场消息", "enter_anim");
            f467537k3 = new j70.f("互动插件可拖拽组件", "interact_draggable_component");
            f467542l3 = new j70.f("互动工具服务组件", "interact_tools_service");
            new j70.f("生活服务多机位服务", "liveMultiCameraService");
            new j70.f("生活服务多机位服务视角状态", "liveMultiCameraStatus");
            new j70.f("伴侣抖音摄像头状态", "liveProDualDeviceStatus");
            new j70.f("外置相机开播组件", "liveExternalCamera");
            new j70.f("赛事直播间第一行", "portraitMatchRoomTopNavigator");
            new j70.f("赛事主播信息", "matchRoomAnchorInfo");
            f467547m3 = new j70.f("节目、赛事直播间多机位、锁链竖屏面板", "multiCameraLinkedRoomPanel");
            new j70.f("赛事直播间聊天频道选择小窗的透明蒙层", "chatChannelPopupTopMask");
            f467552n3 = new j70.f("赛事直播横屏播控层显隐控制", "matchLandVisibilityController");
            f467557o3 = new j70.f("赛事直播横屏手势", "matchLandGesture");
            f467562p3 = new j70.f("赛事直播横屏播放", "matchLandPlayControl");
            new j70.f("横屏弹幕", "landscapeBarrage");
            f467567q3 = new j70.f("高光时刻服务", "matchHighLight");
            f467572r3 = new j70.f("海报分享", "posterShare");
            f467577s3 = new j70.f("横屏多tab入口监测", "matchLandscapeTabsServiceWidget");
            f467582t3 = new j70.f("狂欢管理器", "carnivalManagerServiceWidget");
            f467587u3 = new j70.f("横屏弹幕狂欢", "landscapeCarnivalDanmaku");
            new j70.f("赛事无障碍点赞的入口", "matchDiggForA11y");
            f467592v3 = new j70.f("边看边聊语音连线浮窗", "ChannelLinkFloatWindow");
            new j70.f("横屏边看边聊入口的GuideLine", "matchChatGuideLine");
            f467597w3 = new j70.f("边看边聊邀请按钮", "channelInvite");
            f467602x3 = new j70.f("边看边聊评论框", "channelComment");
            f467607y3 = new j70.f("边看边聊频道展示区", "channelPageContainer");
            f467612z3 = new j70.f("边看边聊引导页面", "channelEmptyContainer");
            A3 = new j70.f("主播端小程序", "anchorMiniApp");
            B3 = new j70.f("观众端小程序", "audienceMiniApp");
            C3 = new j70.f("主播端小游戏", "anchorMiniGame");
            D3 = new j70.f("观众端小游戏", "audienceMiniGame");
            E3 = new j70.f("特权特效播放使用的Lynx AlphaPlayer", "alphaPlayerLynx");
            new j70.f("赛事直播间横屏第一行标题", "matchLandscapeTitle");
            new j70.f("世界杯直播间礼物托盘", "giftTray");
            new j70.f("横屏弹幕狂欢服务", "landscapeCarnivalDanmakuService");
            new j70.f("赛事直播间多解说视角竖屏面板打开上方透明蒙层", "matchRoomCameraTopMask");
            new j70.f("赛事直播间多解说视角", "matchRoomMultiCamera");
            F3 = new j70.f("直播独立任务弹窗服务", "liveIndependentTask");
            new j70.f("红包容器", "liveRoomTopContainer");
            new j70.f("RapidLiveTaskWidget", "rapidLiveTask");
            new j70.f("懂车帝提供的留资入口", "bottomRightRetainConsult");
            G3 = new j70.f("外部注入返回", "external_left_back");
            H3 = new j70.f("为注入组件提供uv信息的service", "injectUVServiceWidget");
            new j70.f("游戏直播贴纸组件", "gameSticker");
            I3 = new j70.f("节目合唱组件", "vsChorusConcert");
            J3 = new j70.f("新组件市场标题栏", "media_top_area");
        }
    }

    @Override // h70.b
    public IAbilityCenter a() {
        return this.f467481i;
    }

    public d(Context r100, DataCenter r101, AbilityCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "abilityCenter");
        super(r100);
        this.f467480h = r101;
        this.f467481i = r102;
        this.f467478f = a.K3;
    }
}

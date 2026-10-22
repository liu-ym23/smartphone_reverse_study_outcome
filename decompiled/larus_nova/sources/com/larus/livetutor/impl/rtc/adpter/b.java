package com.larus.livetutor.impl.rtc.adpter;

import com.larus.livetutor.api.idl.AnswerStartMsg;
import com.larus.livetutor.api.idl.ConnectedStatus;
import com.larus.livetutor.api.idl.ControlAction;
import com.larus.livetutor.api.idl.LiveTutorRoundEndMsg;
import com.larus.livetutor.api.idl.LiveTutorStartMsg;
import com.larus.livetutor.api.idl.LoadingStartMsg;
import com.larus.livetutor.api.idl.UserAsrEndMsg;
import com.larus.livetutor.api.idl.UserAsrStartMsg;
import com.larus.livetutor.impl.rtc.api.RTCAction;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements com.larus.livetutor.impl.rtc.api.a {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f356275a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f356276b = null;

        static {
            int[] r100 = new int[ConnectedStatus.values().length];
            r100[ConnectedStatus.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L4:
            f356275a = r100;
            int[] r101 = new int[ControlAction.values().length];
            r101[ControlAction.ConvenientContinueResponse.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L12:
            r101[ControlAction.BoardReactControl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L7:
            f356276b = r101;
        }
    }

    public b() {
    }

    @Override // com.larus.livetutor.impl.rtc.api.a
    public final ij9.a b(RTCAction.ConnectSuccess r100) {
        Intrinsics.checkNotNullParameter(r100, "successAction");
        ConnectedStatus r101 = r100.getStartStatus();
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        if (r102 == (-1)) goto L13;
        if (r102 == 1) goto L13;
        throw new NoWhenBranchMatchedException();
    L13:
        return LiveTutorConnectedStatus.Idle.INSTANCE;
    L5:
        r102 = a.f356275a[r101.ordinal()];
        goto L6
    }

    @Override // com.larus.livetutor.impl.rtc.api.a
    public final ij9.a a(ij9.a r110, RTCAction r111) {
        Intrinsics.checkNotNullParameter(r110, "current");
        Intrinsics.checkNotNullParameter(r111, "action");
        Long r100 = null;
        if ((r110 instanceof LiveTutorConnectedStatus.Idle) == false) goto L52;
        if ((r111 instanceof RTCAction.LoadingStart) == false) goto L27;
        RTCAction.LoadingStart r112 = (RTCAction.LoadingStart) r111;
        LoadingStartMsg r101 = r112.getMsg();
        if (r101 == null) goto L9;
        String r102 = r101.getStreamId();
    L10:
        LoadingStartMsg r103 = r112.getMsg();
        if (r103 == null) goto L13;
        Integer r104 = r103.getLoadingStep();
    L14:
        LoadingStartMsg r105 = r112.getMsg();
        if (r105 == null) goto L17;
        Long r106 = r105.getTutorId();
    L18:
        LoadingStartMsg r107 = r112.getMsg();
        if (r107 == null) goto L21;
        Long r108 = r107.getTutorRoundId();
    L22:
        LoadingStartMsg r113 = r112.getMsg();
        if (r113 == null) goto L355;
        r100 = r113.getTutorPartId();
    L355:
        return new LiveTutorConnectedStatus.Loading(r102, r104, new BaseConnectedMsg(r106, r108, r100), false, 8, null);
    L21:
        r108 = null;
        goto L22
    L17:
        r106 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r102 = null;
        goto L10
    L27:
        if ((r111 instanceof RTCAction.LiveTutorStart) == false) goto L41;
        RTCAction.LiveTutorStart r114 = (RTCAction.LiveTutorStart) r111;
        LiveTutorStartMsg r109 = r114.getMsg();
        if (r109 == null) goto L31;
        Long r115 = r109.getTutorId();
    L32:
        LiveTutorStartMsg r116 = r114.getMsg();
        if (r116 == null) goto L35;
        Long r117 = r116.getTutorRoundId();
    L36:
        LiveTutorStartMsg r118 = r114.getMsg();
        if (r118 == null) goto L356;
        r100 = r118.getTutorPartId();
    L356:
        return new LiveTutorConnectedStatus.Thinking(new BaseConnectedMsg(r115, r117, r100), false);
    L35:
        r117 = null;
        goto L36
    L31:
        r115 = null;
        goto L32
    L41:
        if ((r111 instanceof RTCAction.RoundEnd) == false) goto L357;
        RTCAction.RoundEnd r119 = (RTCAction.RoundEnd) r111;
        LiveTutorRoundEndMsg r120 = r119.getMsg();
        if (r120 == null) goto L45;
        Long r121 = r120.getTutorId();
    L46:
        LiveTutorRoundEndMsg r122 = r119.getMsg();
        if (r122 == null) goto L49;
        Long r123 = r122.getTutorRoundId();
    L358:
        return new LiveTutorConnectedStatus.RoundEnd(new BaseConnectedMsg(r121, r123, null));
    L49:
        r123 = null;
        goto L358
    L45:
        r121 = null;
        goto L46
    L357:
        return r110;
    L52:
        if ((r110 instanceof LiveTutorConnectedStatus.Loading) == false) goto L91;
        if ((r111 instanceof RTCAction.LiveTutorStart) == false) goto L68;
        RTCAction.LiveTutorStart r124 = (RTCAction.LiveTutorStart) r111;
        LiveTutorStartMsg r125 = r124.getMsg();
        if (r125 == null) goto L58;
        Long r126 = r125.getTutorId();
    L59:
        LiveTutorStartMsg r127 = r124.getMsg();
        if (r127 == null) goto L62;
        Long r128 = r127.getTutorRoundId();
    L63:
        LiveTutorStartMsg r129 = r124.getMsg();
        if (r129 == null) goto L359;
        r100 = r129.getTutorPartId();
    L359:
        return new LiveTutorConnectedStatus.Thinking(new BaseConnectedMsg(r126, r128, r100), false);
    L62:
        r128 = null;
        goto L63
    L58:
        r126 = null;
        goto L59
    L68:
        if ((r111 instanceof RTCAction.LoadingStart) == false) goto L361;
        RTCAction.LoadingStart r130 = (RTCAction.LoadingStart) r111;
        LoadingStartMsg r131 = r130.getMsg();
        if (r131 == null) goto L72;
        String r132 = r131.getStreamId();
    L73:
        LoadingStartMsg r133 = r130.getMsg();
        if (r133 == null) goto L76;
        Integer r134 = r133.getLoadingStep();
    L77:
        LoadingStartMsg r135 = r130.getMsg();
        if (r135 == null) goto L80;
        Long r136 = r135.getTutorId();
    L81:
        LoadingStartMsg r137 = r130.getMsg();
        if (r137 == null) goto L84;
        Long r138 = r137.getTutorRoundId();
    L85:
        LoadingStartMsg r139 = r130.getMsg();
        if (r139 == null) goto L360;
        r100 = r139.getTutorPartId();
    L360:
        return new LiveTutorConnectedStatus.Loading(r132, r134, new BaseConnectedMsg(r136, r138, r100), false, 8, null);
    L84:
        r138 = null;
        goto L85
    L80:
        r136 = null;
        goto L81
    L76:
        r134 = null;
        goto L77
    L72:
        r132 = null;
        goto L73
    L361:
        return (LiveTutorConnectedStatus) r110;
    L91:
        if ((r110 instanceof LiveTutorConnectedStatus.Listening) == false) goto L133;
        if ((r111 instanceof RTCAction.ReceiveUserAsrEnd) == false) goto L108;
        RTCAction.ReceiveUserAsrEnd r140 = (RTCAction.ReceiveUserAsrEnd) r111;
        UserAsrEndMsg r141 = r140.getMsg();
        if (r141 == null) goto L97;
        Long r142 = r141.getTutorId();
    L98:
        UserAsrEndMsg r143 = r140.getMsg();
        if (r143 == null) goto L101;
        Long r144 = r143.getTutorRoundId();
    L102:
        UserAsrEndMsg r145 = r140.getMsg();
        if (r145 == null) goto L105;
        Long r146 = r145.getTutorPartId();
    L362:
        return new LiveTutorConnectedStatus.Thinking(new BaseConnectedMsg(r142, r144, r146), false, 2, null);
    L105:
        r146 = null;
        goto L362
    L101:
        r144 = null;
        goto L102
    L97:
        r142 = null;
        goto L98
    L108:
        if ((r111 instanceof RTCAction.ReceiveAnswerStart) == false) goto L122;
        RTCAction.ReceiveAnswerStart r147 = (RTCAction.ReceiveAnswerStart) r111;
        AnswerStartMsg r148 = r147.getMsg();
        if (r148 == null) goto L112;
        Long r149 = r148.getTutorId();
    L113:
        AnswerStartMsg r150 = r147.getMsg();
        if (r150 == null) goto L116;
        Long r151 = r150.getTutorRoundId();
    L117:
        AnswerStartMsg r152 = r147.getMsg();
        if (r152 == null) goto L363;
        r100 = r152.getTutorPartId();
    L363:
        return new LiveTutorConnectedStatus.Speaking(new BaseConnectedMsg(r149, r151, r100));
    L116:
        r151 = null;
        goto L117
    L112:
        r149 = null;
        goto L113
    L122:
        if ((r111 instanceof RTCAction.CancelAsr) == false) goto L128;
        ij9.a r153 = ((RTCAction.CancelAsr) r111).getLastStatus();
        if (r153 != null) goto L364;
        return r110;
    L364:
        return r153;
    L128:
        if ((r111 instanceof RTCAction.SubmitAsr) == true) goto L366;
        if ((r111 instanceof RTCAction.Replay) == true) goto L366;
        return r110;
    L366:
        return new LiveTutorConnectedStatus.Thinking(null, false, 3, null);
    L133:
        if ((r110 instanceof LiveTutorConnectedStatus.Thinking) == false) goto L194;
        if ((r111 instanceof RTCAction.ReceiveAnswerStart) == false) goto L149;
        RTCAction.ReceiveAnswerStart r154 = (RTCAction.ReceiveAnswerStart) r111;
        AnswerStartMsg r155 = r154.getMsg();
        if (r155 == null) goto L139;
        Long r156 = r155.getTutorId();
    L140:
        AnswerStartMsg r157 = r154.getMsg();
        if (r157 == null) goto L143;
        Long r158 = r157.getTutorRoundId();
    L144:
        AnswerStartMsg r159 = r154.getMsg();
        if (r159 == null) goto L367;
        r100 = r159.getTutorPartId();
    L367:
        return new LiveTutorConnectedStatus.Speaking(new BaseConnectedMsg(r156, r158, r100));
    L143:
        r158 = null;
        goto L144
    L139:
        r156 = null;
        goto L140
    L149:
        if ((r111 instanceof RTCAction.UserAsrStart) == false) goto L163;
        RTCAction.UserAsrStart r160 = (RTCAction.UserAsrStart) r111;
        UserAsrStartMsg r161 = r160.getMsg();
        if (r161 == null) goto L153;
        Long r162 = r161.getTutorId();
    L154:
        UserAsrStartMsg r163 = r160.getMsg();
        if (r163 == null) goto L157;
        Long r164 = r163.getTutorRoundId();
    L158:
        UserAsrStartMsg r165 = r160.getMsg();
        if (r165 == null) goto L368;
        r100 = r165.getAsrTutorPartId();
    L368:
        return new LiveTutorConnectedStatus.Listening(new BaseConnectedMsg(r162, r164, r100));
    L157:
        r164 = null;
        goto L158
    L153:
        r162 = null;
        goto L154
    L163:
        if ((r111 instanceof RTCAction.AsrEmpty) == false) goto L168;
        r153 = ((RTCAction.AsrEmpty) r111).getLastStatus();
        if (r153 != null) goto L364;
        return r110;
    L168:
        if ((r111 instanceof RTCAction.UserInterrupt) == true) goto L373;
        if ((r111 instanceof RTCAction.PressAsr) == true) goto L373;
        if ((r111 instanceof RTCAction.RoundEnd) == false) goto L184;
        RTCAction.RoundEnd r166 = (RTCAction.RoundEnd) r111;
        LiveTutorRoundEndMsg r167 = r166.getMsg();
        if (r167 == null) goto L177;
        Long r168 = r167.getTutorId();
    L178:
        LiveTutorRoundEndMsg r169 = r166.getMsg();
        if (r169 == null) goto L181;
        Long r170 = r169.getTutorRoundId();
    L369:
        return new LiveTutorConnectedStatus.RoundEnd(new BaseConnectedMsg(r168, r170, null));
    L181:
        r170 = null;
        goto L369
    L177:
        r168 = null;
        goto L178
    L184:
        if ((r111 instanceof RTCAction.Replay) == true) goto L372;
        if ((r111 instanceof RTCAction.UploadData) == true) goto L372;
        if ((r111 instanceof RTCAction.WaitUserAnswer) == true) goto L371;
        return r110;
    L371:
        return new LiveTutorConnectedStatus.Waiting(((RTCAction.WaitUserAnswer) r111).getMsg());
    L372:
        return new LiveTutorConnectedStatus.Thinking(null, false, 3, null);
    L373:
        return new LiveTutorConnectedStatus.Listening(null, 1, null);
    L194:
        if ((r110 instanceof LiveTutorConnectedStatus.Speaking) == false) goto L251;
        if ((r111 instanceof RTCAction.UserAsrStart) == false) goto L210;
        RTCAction.UserAsrStart r171 = (RTCAction.UserAsrStart) r111;
        UserAsrStartMsg r172 = r171.getMsg();
        if (r172 == null) goto L200;
        Long r173 = r172.getTutorId();
    L201:
        UserAsrStartMsg r174 = r171.getMsg();
        if (r174 == null) goto L204;
        Long r175 = r174.getTutorRoundId();
    L205:
        UserAsrStartMsg r176 = r171.getMsg();
        if (r176 == null) goto L374;
        r100 = r176.getAsrTutorPartId();
    L374:
        return new LiveTutorConnectedStatus.Listening(new BaseConnectedMsg(r173, r175, r100));
    L204:
        r175 = null;
        goto L205
    L200:
        r173 = null;
        goto L201
    L210:
        if ((r111 instanceof RTCAction.UserInterrupt) == true) goto L380;
        if ((r111 instanceof RTCAction.PressAsr) == true) goto L380;
        if ((r111 instanceof RTCAction.WaitUserAnswer) == false) goto L218;
        return new LiveTutorConnectedStatus.Waiting(((RTCAction.WaitUserAnswer) r111).getMsg());
    L218:
        if ((r111 instanceof RTCAction.RoundEnd) == false) goto L229;
        RTCAction.RoundEnd r177 = (RTCAction.RoundEnd) r111;
        LiveTutorRoundEndMsg r178 = r177.getMsg();
        if (r178 == null) goto L222;
        Long r179 = r178.getTutorId();
    L223:
        LiveTutorRoundEndMsg r180 = r177.getMsg();
        if (r180 == null) goto L226;
        Long r181 = r180.getTutorRoundId();
    L376:
        return new LiveTutorConnectedStatus.RoundEnd(new BaseConnectedMsg(r179, r181, null));
    L226:
        r181 = null;
        goto L376
    L222:
        r179 = null;
        goto L223
    L229:
        if ((r111 instanceof RTCAction.ReceiveAnswerStart) == false) goto L243;
        RTCAction.ReceiveAnswerStart r182 = (RTCAction.ReceiveAnswerStart) r111;
        AnswerStartMsg r183 = r182.getMsg();
        if (r183 == null) goto L233;
        Long r184 = r183.getTutorId();
    L234:
        AnswerStartMsg r185 = r182.getMsg();
        if (r185 == null) goto L237;
        Long r186 = r185.getTutorRoundId();
    L238:
        AnswerStartMsg r187 = r182.getMsg();
        if (r187 == null) goto L377;
        r100 = r187.getTutorPartId();
    L377:
        return new LiveTutorConnectedStatus.Speaking(new BaseConnectedMsg(r184, r186, r100));
    L237:
        r186 = null;
        goto L238
    L233:
        r184 = null;
        goto L234
    L243:
        if ((r111 instanceof RTCAction.Replay) == true) goto L379;
        if ((r111 instanceof RTCAction.UploadData) == true) goto L379;
        return (LiveTutorConnectedStatus) r110;
    L379:
        return new LiveTutorConnectedStatus.Thinking(null, false, 3, null);
    L380:
        return new LiveTutorConnectedStatus.Listening(null, 1, null);
    L251:
        if ((r110 instanceof LiveTutorConnectedStatus.Waiting) == false) goto L315;
        if ((r111 instanceof RTCAction.ReceiveAnswerStart) == false) goto L267;
        RTCAction.ReceiveAnswerStart r188 = (RTCAction.ReceiveAnswerStart) r111;
        AnswerStartMsg r189 = r188.getMsg();
        if (r189 == null) goto L257;
        Long r190 = r189.getTutorId();
    L258:
        AnswerStartMsg r191 = r188.getMsg();
        if (r191 == null) goto L261;
        Long r192 = r191.getTutorRoundId();
    L262:
        AnswerStartMsg r193 = r188.getMsg();
        if (r193 == null) goto L381;
        r100 = r193.getTutorPartId();
    L381:
        return new LiveTutorConnectedStatus.Speaking(new BaseConnectedMsg(r190, r192, r100));
    L261:
        r192 = null;
        goto L262
    L257:
        r190 = null;
        goto L258
    L267:
        if ((r111 instanceof RTCAction.UserAsrStart) == false) goto L281;
        RTCAction.UserAsrStart r194 = (RTCAction.UserAsrStart) r111;
        UserAsrStartMsg r195 = r194.getMsg();
        if (r195 == null) goto L271;
        Long r196 = r195.getTutorId();
    L272:
        UserAsrStartMsg r197 = r194.getMsg();
        if (r197 == null) goto L275;
        Long r198 = r197.getTutorRoundId();
    L276:
        UserAsrStartMsg r199 = r194.getMsg();
        if (r199 == null) goto L382;
        r100 = r199.getAsrTutorPartId();
    L382:
        return new LiveTutorConnectedStatus.Listening(new BaseConnectedMsg(r196, r198, r100));
    L275:
        r198 = null;
        goto L276
    L271:
        r196 = null;
        goto L272
    L281:
        if ((r111 instanceof RTCAction.UserInterrupt) == true) goto L388;
        if ((r111 instanceof RTCAction.PressAsr) == true) goto L388;
        if ((r111 instanceof RTCAction.RoundEnd) == false) goto L297;
        RTCAction.RoundEnd r1100 = (RTCAction.RoundEnd) r111;
        LiveTutorRoundEndMsg r200 = r1100.getMsg();
        if (r200 == null) goto L290;
        Long r201 = r200.getTutorId();
    L291:
        LiveTutorRoundEndMsg r1101 = r1100.getMsg();
        if (r1101 == null) goto L294;
        Long r1102 = r1101.getTutorRoundId();
    L383:
        return new LiveTutorConnectedStatus.RoundEnd(new BaseConnectedMsg(r201, r1102, null));
    L294:
        r1102 = null;
        goto L383
    L290:
        r201 = null;
        goto L291
    L297:
        if ((r111 instanceof RTCAction.Replay) == true) goto L387;
        if ((r111 instanceof RTCAction.UploadData) == true) goto L387;
        if ((r111 instanceof RTCAction.ClientControl) == false) goto L386;
        ControlAction r1103 = ((RTCAction.ClientControl) r111).getControlMsg().getClientControl();
        if (r1103 != null) goto L306;
        int r1104 = -1;
    L307:
        if (r1104 == 1) goto L385;
        if (r1104 == 2) goto L385;
        return (LiveTutorConnectedStatus) r110;
    L385:
        return new LiveTutorConnectedStatus.Thinking(null, false, 3, null);
    L306:
        r1104 = a.f356276b[r1103.ordinal()];
        goto L307
    L386:
        return (LiveTutorConnectedStatus) r110;
    L387:
        return new LiveTutorConnectedStatus.Thinking(null, false, 3, null);
    L388:
        return new LiveTutorConnectedStatus.Listening(null, 1, null);
    L315:
        if ((r110 instanceof LiveTutorConnectedStatus.RoundEnd) == true) goto L317;
        return r110;
    L317:
        if ((r111 instanceof RTCAction.UserAsrStart) == false) goto L331;
        RTCAction.UserAsrStart r1105 = (RTCAction.UserAsrStart) r111;
        UserAsrStartMsg r202 = r1105.getMsg();
        if (r202 == null) goto L321;
        Long r203 = r202.getTutorId();
    L322:
        UserAsrStartMsg r204 = r1105.getMsg();
        if (r204 == null) goto L325;
        Long r205 = r204.getTutorRoundId();
    L326:
        UserAsrStartMsg r1106 = r1105.getMsg();
        if (r1106 == null) goto L390;
        r100 = r1106.getAsrTutorPartId();
    L390:
        return new LiveTutorConnectedStatus.Listening(new BaseConnectedMsg(r203, r205, r100));
    L325:
        r205 = null;
        goto L326
    L321:
        r203 = null;
        goto L322
    L331:
        if ((r111 instanceof RTCAction.PressAsr) == false) goto L334;
        return new LiveTutorConnectedStatus.Listening(null, 1, null);
    L334:
        if ((r111 instanceof RTCAction.ReceiveAnswerStart) == false) goto L348;
        RTCAction.ReceiveAnswerStart r1107 = (RTCAction.ReceiveAnswerStart) r111;
        AnswerStartMsg r206 = r1107.getMsg();
        if (r206 == null) goto L338;
        Long r207 = r206.getTutorId();
    L339:
        AnswerStartMsg r208 = r1107.getMsg();
        if (r208 == null) goto L342;
        Long r209 = r208.getTutorRoundId();
    L343:
        AnswerStartMsg r1108 = r1107.getMsg();
        if (r1108 == null) goto L392;
        r100 = r1108.getTutorPartId();
    L392:
        return new LiveTutorConnectedStatus.Speaking(new BaseConnectedMsg(r207, r209, r100));
    L342:
        r209 = null;
        goto L343
    L338:
        r207 = null;
        goto L339
    L348:
        if ((r111 instanceof RTCAction.Replay) == true) goto L354;
        if ((r111 instanceof RTCAction.UploadData) == true) goto L354;
        return (LiveTutorConnectedStatus) r110;
    L354:
        return new LiveTutorConnectedStatus.Thinking(null, false, 3, null);
    }
}

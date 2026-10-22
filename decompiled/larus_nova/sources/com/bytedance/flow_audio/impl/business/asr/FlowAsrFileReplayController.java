package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAsrFileReplayController {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f243781c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f243782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zw5.a f243783b;

    public static final class a {
    }

    static {
        f243781c = zw5.b.a("FlowAsrFileReplayController");
    }

    public FlowAsrFileReplayController(r r100, zw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "taskCoordinator");
        Intrinsics.checkNotNullParameter(r101, "logContext");
        this.f243782a = r100;
        this.f243783b = r101;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01ac -> B:57:0x01b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x01e0 -> B:59:0x01c2). Please report as a decompilation issue!!! */
    public final Object b(kw5.d r210, Continuation<? super hw5.a> r211) {
        FlowAsrFileReplayController r100 = this;
        if ((r211 instanceof FlowAsrFileReplayController$sendFileAudioData$2) == false) goto L7;
        FlowAsrFileReplayController$sendFileAudioData$2 r101 = (FlowAsrFileReplayController$sendFileAudioData$2) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        String r106 = "replay stream closed frames=";
        String r107 = "close replay stream failed ";
        String r110 = " bytes=";
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        int r108 = r101.I$0;
        long r111 = r101.J$1;
        long r112 = r101.J$0;
        Ref.IntRef r113 = (Ref.IntRef) r101.L$2;
        FlowAsrAudioFrameSender r109 = (FlowAsrAudioFrameSender) r101.L$1;
        kw5.d r114 = (kw5.d) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
    L57:
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        Object r116 = r104;
        FlowAsrFileReplayController$sendFileAudioData$2 r117 = r101;
        kw5.d r118 = r114;
        FlowAsrAudioFrameSender r119 = r109;
        FlowAsrFileReplayController r120 = r100;
        int r121 = r108;
    L59:
        long r122 = r112;
        String r123 = r110;
        String r124 = r107;
        String r125 = r106;
        FlowAsrAudioFrameSender r126 = r119;
        Throwable r127 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L83
        r113.element++;     // Catch: Throwable -> L83
        if (r127 == null) goto L82;
        FlowAsrErrorType r128 = FlowAsrErrorType.CLIENT_ERROR;     // Catch: Throwable -> L83
        if ((r127 instanceof FlowAsrAudioFrameSendException) == false) goto L72;
        FlowAsrAudioFrameSendException r129 = (FlowAsrAudioFrameSendException) r127;     // Catch: Throwable -> L83
    L73:
        if (r129 == null) goto L75;
        Integer r130 = Boxing.boxInt(r129.getNativeCode());     // Catch: Throwable -> L83
    L76:
        hw5.a r131 = i.b(r127, r128, r130, 4);     // Catch: Throwable -> L83
        IKMPLoggerService r132 = lp7.a.f510233a;     // Catch: Throwable -> L83
        String r133 = f243781c;     // Catch: Throwable -> L83
        zw5.a r134 = r120.f243783b;     // Catch: Throwable -> L83
        StringBuilder r135 = new StringBuilder();     // Catch: Throwable -> L83
        r135.append("send replay frame failed frameId=");     // Catch: Throwable -> L83
        r135.append(r113.element - 1);     // Catch: Throwable -> L83
        r135.append(" dataSize=");     // Catch: Throwable -> L83
        r135.append(r121);     // Catch: Throwable -> L83
        r135.append(' ');     // Catch: Throwable -> L83
        r135.append(zw5.b.b(r131));     // Catch: Throwable -> L83
        lp7.a.b(r133, r134.a(r135.toString()));     // Catch: Throwable -> L83
        r118.close();     // Catch: Throwable -> L79
        lp7.a.c(r133, r120.f243783b.a(r125 + r122 + r123 + r111));     // Catch: Throwable -> L79
        return r131;
    L79:
        th = move-exception;
        IKMPLoggerService r136 = lp7.a.f510233a;
        lp7.a.b(f243781c, r120.f243783b.a(r124 + zw5.b.c(th)));
        throw th;
    L75:
        r130 = null;
        goto L76
    L72:
        r129 = null;
        goto L73
    L82:
        long r137 = r122 + 1;
        r111 = r111 + ((long) r121);
        Object r138 = r116;
        FlowAsrFileReplayController r139 = r120;
        r109 = r126;
        r106 = r125;
        r107 = r124;
        r110 = r123;
        r112 = r137;
    L118:
        kw5.c r140 = r118.Y();     // Catch: Throwable -> L104
        if (Intrinsics.areEqual(r140, kw5.c.a.f506397a) == false) goto L31;
        IKMPLoggerService r141 = lp7.a.f510233a;     // Catch: Throwable -> L104
        String r142 = f243781c;     // Catch: Throwable -> L104
        lp7.a.c(r142, r139.f243783b.a("file replay reached eof frames=" + r112 + r110 + r111));     // Catch: Throwable -> L104
        r118.close();     // Catch: Throwable -> L27
        lp7.a.c(r142, r139.f243783b.a(r106 + r112 + r110 + r111));     // Catch: Throwable -> L27
        return null;
    L27:
        th = move-exception;
        IKMPLoggerService r143 = lp7.a.f510233a;
        lp7.a.b(f243781c, r139.f243783b.a(r107 + zw5.b.c(th)));
        throw th;
    L31:
        if ((r140 instanceof kw5.c.b) == false) goto L39;
        IKMPLoggerService r144 = lp7.a.f510233a;     // Catch: Throwable -> L104
        String r145 = f243781c;     // Catch: Throwable -> L104
        lp7.a.b(r145, r139.f243783b.a("read replay file failed frames=" + r112 + r110 + r111 + ' ' + zw5.b.b(((kw5.c.b) r140).f506398a)));     // Catch: Throwable -> L104
        hw5.a r146 = ((kw5.c.b) r140).f506398a;     // Catch: Throwable -> L104
        r118.close();     // Catch: Throwable -> L35
        lp7.a.c(r145, r139.f243783b.a(r106 + r112 + r110 + r111));     // Catch: Throwable -> L35
        return r146;
    L35:
        th = move-exception;
        IKMPLoggerService r147 = lp7.a.f510233a;
        lp7.a.b(f243781c, r139.f243783b.a(r107 + zw5.b.c(th)));
        throw th;
    L39:
        if ((r140 instanceof kw5.c.C6620c) == false) goto L107;
        kw5.a r148 = ((kw5.c.C6620c) r140).f506399a;     // Catch: Throwable -> L104
        int r149 = r148.f506394b;     // Catch: Throwable -> L104
        if (r149 > 0) goto L137;
        String r212 = r107;
    L116:
        String r150 = "dataSize=" + r149 + ",bufferSize=" + r148.f506393a.length + ",frameIndex=" + r112 + ",bytesSent=" + r111;     // Catch: Throwable -> L102
        hw5.a r151 = new hw5.a(FlowAsrErrorType.CLIENT_ERROR, "Invalid file audio data: " + r150, -1004, r150);     // Catch: Throwable -> L102
        IKMPLoggerService r152 = lp7.a.f510233a;     // Catch: Throwable -> L102
        String r153 = f243781c;     // Catch: Throwable -> L102
        zw5.a r154 = r139.f243783b;     // Catch: Throwable -> L102
        StringBuilder r155 = new StringBuilder();     // Catch: Throwable -> L102
        r155.append("invalid replay data dataSize=");     // Catch: Throwable -> L102
        r155.append(r149);     // Catch: Throwable -> L102
        r155.append(" bufferSize=");     // Catch: Throwable -> L102
        r155.append(r148.f506393a.length);     // Catch: Throwable -> L102
        r155.append(" frames=");     // Catch: Throwable -> L102
        r155.append(r112);     // Catch: Throwable -> L102
        r155.append(r110);     // Catch: Throwable -> L100
        r155.append(r111);     // Catch: Throwable -> L100
        lp7.a.b(r153, r154.a(r155.toString()));     // Catch: Throwable -> L100
        r118.close();     // Catch: Throwable -> L97
        lp7.a.c(r153, r139.f243783b.a(r106 + r112 + r110 + r111));     // Catch: Throwable -> L97
        return r151;
    L97:
        th = move-exception;
        IKMPLoggerService r156 = lp7.a.f510233a;
        lp7.a.b(f243781c, r139.f243783b.a(r212 + zw5.b.c(th)));
        throw th;
    L100:
        th = th;
    L89:
        r107 = r212;
        r106 = r106;
    L108:
        r122 = r112;
        r120 = r139;
    L139:
        r118.close();     // Catch: Throwable -> L113
        IKMPLoggerService r157 = lp7.a.f510233a;     // Catch: Throwable -> L113
        lp7.a.c(f243781c, r120.f243783b.a(r106 + r122 + r110 + r111));     // Catch: Throwable -> L113
        throw th;
    L113:
        th = move-exception;
        IKMPLoggerService r158 = lp7.a.f510233a;
        lp7.a.b(f243781c, r120.f243783b.a(r107 + zw5.b.c(th)));
        throw th;
    L102:
        th = th;
        goto L89
    L137:
        byte[] r159 = r148.f506393a;     // Catch: Throwable -> L90
        r212 = r107;
        if (r149 > r159.length) goto L116;
        Result.Companion r160 = Result.Companion;     // Catch: Throwable -> L62
        int r161 = r113.element;     // Catch: Throwable -> L62
        if (r149 == r159.length) goto L52;
        r159 = Arrays.copyOf(r159, r149);     // Catch: Throwable -> L62
    L52:
        String r162 = r106;
        rw5.d r163 = new rw5.d(String.valueOf(r161), r159, false);     // Catch: Throwable -> L60
        r117.L$0 = r118;     // Catch: Throwable -> L60
        r117.L$1 = r109;     // Catch: Throwable -> L60
        r117.L$2 = r113;     // Catch: Throwable -> L60
        r117.J$0 = r112;     // Catch: Throwable -> L60
        r117.J$1 = r111;     // Catch: Throwable -> L60
        r117.I$0 = r149;     // Catch: Throwable -> L60
        r117.label = 1;     // Catch: Throwable -> L60
        if (r109.b(r163, r117) != r138) goto L56;
        return r138;
    L56:
        r107 = r212;
        r100 = r139;
        r106 = r162;
        r114 = r118;
        r101 = r117;
        r104 = r138;
        r108 = r149;
    L60:
        th = th;
    L64:
        r107 = r212;
        kw5.d r164 = r118;
        r101 = r117;
        r104 = r138;
        r108 = r149;
        r106 = r162;
    L119:
        Result.Companion r165 = Result.Companion;     // Catch: Throwable -> L85
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L85
        r116 = r104;
        r117 = r101;
        r118 = r164;
        r121 = r108;
        r119 = r109;
        r120 = r139;
    L85:
        th = th;
        r118 = r164;
    L62:
        th = th;
        r162 = r106;
    L87:
        th = th;
        r106 = r106;
    L90:
        th = th;
        r106 = r106;
        r212 = r107;
        goto L89
    L107:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L104
    L104:
        th = th;
    L83:
        th = th;
        r106 = r125;
        r107 = r124;
        r110 = r123;
    L14:
        th = th;
        kw5.d r166 = r114;
        r139 = r100;
        r164 = r166;
        goto L119
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        FlowAsrAudioFrameSender r167 = new FlowAsrAudioFrameSender(new FlowAsrFileReplayController$sendFileAudioData$frameSender$1(r100.f243782a), r100.f243783b);
        r122 = 0;
        r111 = 0;
        r112 = 0;
        r113 = new Ref.IntRef();     // Catch: Throwable -> L109
        r109 = r167;
        r139 = r100;
        r138 = r104;
        r117 = r101;
        r118 = r210;
    L109:
        th = th;
        r120 = this;
        r118 = r210;
        r111 = 0;
    L7:
        r101 = new FlowAsrFileReplayController$sendFileAudioData$2(r100, r211);
        goto L8
    }

    public final Object a(String r100, FlowAsrFileAudioDataProvider r101, Continuation<? super hw5.a> r102) {
        if ((r102 instanceof FlowAsrFileReplayController$runReplay$1) == false) goto L7;
        FlowAsrFileReplayController$runReplay$1 r103 = (FlowAsrFileReplayController$runReplay$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L27:
        hw5.a r108 = (hw5.a) r105;
        if (r108 == null) goto L44;
        IKMPLoggerService r109 = lp7.a.f510233a;
        lp7.a.b(f243781c, this.f243783b.a("file replay send failed " + zw5.b.b(r108)));
        return r108;
    L44:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L33
        this.f243782a.c();     // Catch: Throwable -> L33
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        hw5.a r113 = null;
        if (r112 == null) goto L38;
        r113 = i.b(r112, FlowAsrErrorType.SOURCE_STOP_FAILED, null, 6);
    L38:
        if (r113 != null) goto L40;
        IKMPLoggerService r114 = lp7.a.f510233a;
        lp7.a.c(f243781c, this.f243783b.a("file replay end asr success"));
    L41:
        return r113;
    L40:
        IKMPLoggerService r115 = lp7.a.f510233a;
        lp7.a.b(f243781c, this.f243783b.a("file replay end asr failed " + zw5.b.b(r113)));
    L33:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        IKMPLoggerService r117 = lp7.a.f510233a;
        String r118 = f243781c;
        zw5.a r119 = this.f243783b;
        StringBuilder r120 = new StringBuilder("file replay begin hasFilePath=");
        if (r100.length() <= 0) goto L17;
        boolean r121 = true;
    L18:
        r120.append(r121);
        lp7.a.c(r118, r119.a(r120.toString()));
        r103.label = 1;
        kw5.b r122 = r101.D2(r100);
        if ((r122 instanceof kw5.b.a) == false) goto L23;
        zw5.a r123 = this.f243783b;
        StringBuilder r124 = new StringBuilder("open replay file failed ");
        kw5.b.a r125 = (kw5.b.a) r122;
        r124.append(zw5.b.b(r125.f506395a));
        lp7.a.b(r118, r123.a(r124.toString()));
        Object r126 = r125.f506395a;
    L21:
        r105 = r126;
        if (r105 != r106) goto L27;
        return r106;
    L23:
        if ((r122 instanceof kw5.b.C6619b) == false) goto L43;
        lp7.a.c(r118, this.f243783b.a("open replay file success"));
        r126 = b(((kw5.b.C6619b) r122).f506396a, r103);
        goto L21
    L43:
        throw new NoWhenBranchMatchedException();
    L17:
        r121 = false;
    L7:
        r103 = new FlowAsrFileReplayController$runReplay$1(this, r102);
        goto L8
    }
}

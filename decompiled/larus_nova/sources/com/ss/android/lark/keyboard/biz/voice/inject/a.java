package com.ss.android.lark.keyboard.biz.voice.inject;

import android.content.Context;
import android.widget.EditText;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.audio.opus.OpusEncoder;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.l;
import com.ss.android.lark.keyboard.plugin.tool.voice.processor.PartialUploadAudioData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f428608r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAudioService f428609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qob.a f428610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f428611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f428612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f428613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f428614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f428615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f428616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OpusEncoder f428617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PartialUploadAudioData f428618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile String f428619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile Long f428620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile Message f428621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f428622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f428623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f428624p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f428625q;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.biz.voice.inject.a$a, reason: collision with other inner class name */
    public static final class C5081a {
    }

    static {
    }

    public final void a() {
        if (this.f428612d.get() == false) goto L33;
        boolean r100 = true;
        this.f428613e.set(true);
        String r101 = this.f428619k;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        int r103 = VoiceUtils.f409442a;
        VoiceUtils.a(this.f428609a, r101);
    L13:
        Message r104 = this.f428621m;
        if (r104 == null) goto L34;
        String r105 = r104.getId();
        if (r105.length() != 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L21;
        r105 = r104.getcId();
    L21:
        Intrinsics.checkNotNull(r105);
        if (r105.length() > 0) goto L25;
        r100 = false;
    L25:
        if (r100 == false) goto L34;
        this.f428610b.m(r105);
        goto L34
    L18:
        r106 = false;
    L34:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L29
        this.f428617i.getClass();     // Catch: Throwable -> L29
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    L33:
        throw new IllegalStateException("ExternalPcmVoiceSession not started".toString());
    }

    public final void d() {
        boolean r100 = true;
        if (this.f428612d.compareAndSet(false, true) == false) goto L38;
        int r101 = this.f428617i.d(this.f428616h);
        if (r101 != 1) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L36;
        String r103 = this.f428610b.h();
        String r104 = this.f428610b.d();
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r105 = this.f428610b.f();
        String r106 = this.f428616h;
        String r107 = this.f428615g;
        PartialReplyInfo r110 = this.f428610b.c();
        Intrinsics.checkNotNullParameter(r103, "rootMsgId");
        Intrinsics.checkNotNullParameter(r104, "parentMsgId");
        Intrinsics.checkNotNullParameter(r106, "fileName");
        Intrinsics.checkNotNullParameter(r107, "cid");
        m5b.e r108 = new m5b.e(null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 536870911);
        r108.f512232j = r103;
        r108.f512233k = r104;
        r108.f512226d = this.f428620l;
        r108.f512224b = this.f428614f;
        r108.f512245w = r106;
        r108.f512243u = r107;
        r108.f512242t = r105;
        com.ss.android.lark.keyboard.b r109 = this.f428610b.n();
        if (r109 == null) goto L18;
        com.ss.android.lark.keyboard.keyboard2.b r111 = r109.L();
        if (r111 == null) goto L18;
        EditText r112 = r111.c();
        if (r112 == null) goto L18;
        RichText r113 = ExtensionEditTextCompatKt.e(r112, 0, r112.length());
        if (r113 == null) goto L18;
        m5b.d r114 = new m5b.d("", "", r113, r110, r108);
    L19:
        Message r115 = this.f428610b.a(r114);
        if (r115 == null) goto L34;
        AudioContent r116 = (AudioContent) r115.getContent();
        String r117 = this.f428609a.ec(r115.getChatId(), this.f428616h, com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.a());
        if (r117 != null) goto L25;
        r117 = "";
    L25:
        if (r117.length() == 0) goto L28;
        r100 = false;
    L28:
        if (r100 == true) goto L32;
        r116.setUploadId(r117);
        r116.setSequenceId(0);
        this.f428621m = r115;
        this.f428619k = r117;
        Log.i("ExternalPcmVoiceSession", "start ok, cid=" + this.f428615g + ", uploadId=" + r117 + ", filePath=" + this.f428616h);
        return;
    L32:
        throw new IllegalStateException("getAudioUploadId returns empty");
    L34:
        throw new IllegalStateException("startAudioRecord returns null");
    L18:
        r114 = null;
        goto L19
    L36:
        throw new IllegalStateException(("OpusEncoder.startEncoder failed: " + r101).toString());
    L7:
        r102 = false;
        goto L8
    L38:
        throw new IllegalStateException("ExternalPcmVoiceSession already started".toString());
    }

    public final void e(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f428612d.get() == false) goto L41;
        if (this.f428613e.compareAndSet(false, true) == true) goto L8;
        Log.e("ExternalPcmVoiceSession", "stopAndSend, session already stopped.");
        return;
    L8:
        Message r100 = this.f428621m;
        String r111 = this.f428619k;
        if (r100 == null) goto L38;
        if (r111 != null) goto L12;
    L15:
        boolean r101 = true;
    L16:
        if (r101 == true) goto L38;
        RangesKt.coerceAtLeast(this.f428624p - this.f428625q, 0);
        byte[] r102 = this.f428617i.a(true);
        if (r102.length != 0) goto L21;
        boolean r103 = true;
    L22:
        if (r103 == true) goto L24;
        int r104 = this.f428622n + 1;
        this.f428622n = r104;
        this.f428618j.a(new com.ss.android.lark.keyboard.plugin.tool.voice.processor.c(r100, r104, r111, ByteBuffer.wrap(r102), false, false), null);
    L24:
        final CountDownLatch r112 = new CountDownLatch(1);
        int r105 = this.f428622n + 1;
        this.f428622n = r105;
        this.f428618j.a(new com.ss.android.lark.keyboard.plugin.tool.voice.processor.c(r100, r105, r111, ByteBuffer.wrap(new byte[0]), true, false), new ExternalPcmVoiceSession$stopAndSend$2(r112, this));
        r112.await(1, TimeUnit.SECONDS);     // Catch: InterruptedException -> L27
    L28:
        int r106 = (int) (((this.f428623o / ((long) 2)) * 1000) / ((long) 16000));
        MonitorMessageSendCallback r107 = this.f428610b.l(this.f428616h, this.f428615g, r106);
        if (r106 >= 1000) goto L36;
        UICallbackExecutor.execute(new b(this, r110));
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L33
        this.f428617i.getClass();     // Catch: Throwable -> L33
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L36:
        this.f428611c.execute(new c(this, r100, r106, r107, r111));
        return;
    L27:
        Log.e("ExternalPcmVoiceSession", "stopAndSend, finish upload latch await interrupted.");
        goto L28
    L21:
        r103 = false;
        goto L22
    L12:
        if (r111.length() == 0) goto L15;
        r101 = false;
    L38:
        Log.e("ExternalPcmVoiceSession", "stopAndSend, message or uploadId is null.");
        return;
    L41:
        throw new IllegalStateException("ExternalPcmVoiceSession not started".toString());
    }

    public a(IAudioService r100, VoiceInnerEndPlugin.a r101) {
        ExecutorService r102 = CoreThreadPool.getDefault().newSerialIODensityThreadPool("external-pcm-voice");
        Intrinsics.checkNotNullParameter(r100, "audioService");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        Intrinsics.checkNotNullParameter(r102, "executor");
        this.f428609a = r100;
        this.f428610b = r101;
        this.f428611c = r102;
        this.f428612d = new AtomicBoolean(false);
        this.f428613e = new AtomicBoolean(false);
        boolean r103 = com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a;
        this.f428614f = com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a;
        this.f428615g = UUID.randomUUID().toString();
        PolarisFileWrapper r104 = new PolarisFileWrapper(com.ss.android.lark.a.f408535a.getContext().getCacheDir(), "lark_external_voice");
        r104.mkdirs();
        this.f428616h = new PolarisFileWrapper(r104, UUID.randomUUID() + ".ogg").getAbsolutePath();
        this.f428617i = new OpusEncoder();
        this.f428618j = new PartialUploadAudioData(r100);
        com.ss.android.lark.keyboard.b r105 = r101.n();
        if (r105 == null) goto L10;
        k r106 = r105.e();
        if (r106 == null) goto L11;
        l r107 = r106.of(this);
        if (r107 == null) goto L12;
        r107.c(com.ss.android.lark.keyboard.biz.mention.inject.a.class, new ExternalPcmVoiceSession$1(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void b(byte[] r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "pcm");
        if (this.f428612d.get() == false) goto L40;
        if ((!this.f428613e.get()) == false) goto L38;
        boolean r100 = false;
        if (r111 >= 0) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L36;
        Message r102 = this.f428621m;
        if (r102 != null) goto L17;
        Log.e("ExternalPcmVoiceSession", "push pcm, message is null.");
        return;
    L17:
        String r103 = this.f428619k;
        if (r103 != null) goto L22;
        Log.e("ExternalPcmVoiceSession", "push pcm, uploadId is null.");
        return;
    L22:
        if (r111 == r110.length) goto L25;
        r110 = ArraysKt.copyOfRange(r110, 0, 0 + r111);
    L25:
        ByteBuffer r112 = ByteBuffer.wrap(r110);
        OpusEncoder r104 = this.f428617i;
        Intrinsics.checkNotNull(r112);
        long r105 = r104.b(r112, r111);
        this.f428623o += (long) r111;
        this.f428624p = r105;
        if (RangesKt.coerceAtLeast(r105 - this.f428625q, 0) > 0) goto L28;
        return;
    L28:
        final byte[] r113 = this.f428617i.a(false);
        if (r113.length != 0) goto L31;
        r100 = true;
    L31:
        if (r100 == false) goto L33;
        return;
    L33:
        this.f428625q = r105;
        final int r114 = this.f428622n + 1;
        this.f428622n = r114;
        this.f428618j.a(new com.ss.android.lark.keyboard.plugin.tool.voice.processor.c(r102, r114, r103, ByteBuffer.wrap(r113), false, false), new ExternalPcmVoiceSession$pushPcm$4(this, r114, r113));
        return;
    L36:
        throw new IllegalArgumentException("invalid offset/length".toString());
    L9:
        if ((0 + r111) > r110.length) goto L11;
        r101 = true;
        goto L12
    L38:
        throw new IllegalStateException("ExternalPcmVoiceSession already stopped".toString());
    L40:
        throw new IllegalStateException("ExternalPcmVoiceSession not started".toString());
    }

    public final void c(Message r210, int r211, MonitorMessageSendCallback r212, PartialReplyInfo r213) {
        Intrinsics.checkNotNullParameter(r210, "message");
        m5b.e r100 = new m5b.e(null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 536870911);
        r100.f512241s = r210;
        r100.f512232j = this.f428610b.h();
        r100.f512233k = this.f428610b.d();
        r100.f512226d = this.f428620l;
        r100.f512224b = this.f428614f;
        r100.f512245w = this.f428616h;
        r100.f512244v = Integer.valueOf(r211);
        r100.f512243u = this.f428615g;
        r100.f512242t = this.f428610b.f();
        r100.f512246x = r212;
        com.ss.android.lark.keyboard.b r101 = this.f428610b.n();
        if (r101 == null) goto L11;
        com.ss.android.lark.keyboard.keyboard2.b r102 = r101.L();
        if (r102 == null) goto L11;
        EditText r103 = r102.c();
        if (r103 == null) goto L11;
        RichText r104 = ExtensionEditTextCompatKt.e(r103, 0, r103.length());
        if (r104 == null) goto L11;
        m5b.d r105 = new m5b.d("", "", r104, r213, r100);
    L12:
        this.f428610b.b(r105);
        return;
    L11:
        r105 = null;
        goto L12
    }
}

package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.l;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.y0;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class AudioRecordDataProcessor implements com.ss.android.lark.audio.voiceinput.processor.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f430724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IAudioService f430725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qob.a f430726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f430727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f430728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f430729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ExecutorService f430730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larksuite.framework.callback.c f430731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.processor.a f430732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final UploadAudioDataConsumer f430733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RecognizeWithUploadAudioDataConsumer f430734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f430735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.ss.android.lark.audio.voiceinput.e f430736m;

    public final class RecognizeWithUploadAudioDataConsumer extends com.ss.android.lark.keyboard.plugin.tool.voice.processor.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final UploadAudioDataConsumer f430737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final l f430738e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final IAudioService f430739f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f430740g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f430741h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final RecognizeAudioData f430742i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ AudioRecordDataProcessor f430743j;

        public static final class a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecognizeWithUploadAudioDataConsumer f430744a;

            public a(RecognizeWithUploadAudioDataConsumer r100) {
                this.f430744a = r100;
            }

            @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.f
            public final void a(com.ss.android.lark.audio.voiceinput.c r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                AudioRecordDataProcessor r101 = this.f430744a.f430743j;
                StringBuilder r102 = new StringBuilder("updateAudioText sourceId:");
                r102.append(r100.f409207a);
                r102.append(" sequenceId:");
                r102.append(r100.f409208b);
                r102.append("/ result length:");
                String r103 = r100.f409209c;
                if (r103 == null) goto L5;
                Integer r104 = Integer.valueOf(r103.length());
            L6:
                r102.append(r104);
                r102.append("/isFinish:");
                r102.append(r100.f409210d);
                Log.i("AudioRecordDataRecognize", r102.toString());
                r101.f430731h.a(new d(r101, r100));
                return;
            L5:
                r104 = null;
                goto L6
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f430745a;

            public b(Function0<Unit> r100) {
                this.f430745a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f430745a.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecognizeWithUploadAudioDataConsumer f430746a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f430747b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f430748c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ double f430749d;

            public c(RecognizeWithUploadAudioDataConsumer r100, ByteBuffer r101, int r102, double r103) {
                this.f430746a = r100;
                this.f430747b = r101;
                this.f430748c = r102;
                this.f430749d = r103;
            }

            public final void a() {
                RecognizeWithUploadAudioDataConsumer r100 = this.f430746a;
                if (r100.f430740g == true) goto L7;
                com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r101 = r100.f430792b;
                if (r101 == null) goto L7;
                r100.d(r101.f430796c, r101.f430797d, true);
            L7:
                final RecognizeWithUploadAudioDataConsumer r102 = this.f430746a;
                if ((!r102.f430743j.f430732i.f409350a.isEmpty()) == false) goto L11;
                final AudioRecordDataProcessor r103 = r102.f430743j;
                r103.f430732i.a(new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$handleCacheDataIfNeed$1(r102, r103));
            L11:
                RecognizeWithUploadAudioDataConsumer r104 = this.f430746a;
                ByteBuffer r110 = this.f430747b;
                int r111 = this.f430748c;
                double r112 = this.f430749d;
                r104.getClass();
                if (r110 != null) goto L14;
                Log.i("AudioRecordDataRecognize", "[handleAudioData]buffer is null");
                return;
            L14:
                IGetDataCallback<String> r113 = new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$handleOnUpdateAudio$callback$1();
                RecognizeAudioData r114 = r104.f430742i;
                com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r105 = r104.f430792b;
                if (r105 == null) goto L17;
                Message r106 = r105.f430794a;
            L18:
                r114.a(new com.ss.android.lark.keyboard.plugin.tool.voice.processor.c(r106, r104.a(), r104.f430793c, r110, false, r104.f430741h, r104.f430743j.f430728e), r113);
                if (r104.f430743j.f430728e == false) goto L25;
                UploadAudioDataConsumer r107 = r104.f430737d;
                if (r107 == null) goto L26;
                r107.i(r110, r111, r112);
                return;
            L26:
                return;
            L25:
                return;
            L17:
                r106 = null;
                goto L18
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final synchronized void e() {
            monitor-enter(this);
            super.e();     // Catch: Throwable -> L6
            this.f430740g = false;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final void f() {
            e();
            if (b() == false) goto L6;
            Log.e("AudioRecordDataRecognize", "[onPrepareRecord] invalid context");
            return;
        L6:
            String r100 = UUID.randomUUID().toString();
            this.f430793c = r100;
            RecognizeAudioData r101 = this.f430742i;
            r101.f430787h = r100;
            r101.f430788i = 0;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final boolean c(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "strFileName");
            Intrinsics.checkNotNullParameter(r101, "cid");
            if (super.c(r100, r101, r102) == true) goto L6;
            return false;
        L6:
            final int r103 = a();
            final String r104 = this.f430793c;
            final AudioRecordDataProcessor r105 = this.f430743j;
            AudioRecordDataProcessor.a(r105, new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onAudioRecorded$1(this, r103, r104, r105));
            if (this.f430743j.f430728e == false) goto L13;
            UploadAudioDataConsumer r106 = this.f430737d;
            if (r106 == null) goto L14;
            r106.g(AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onAudioRecorded$2.INSTANCE, AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onAudioRecorded$3.INSTANCE);
            return true;
        L14:
            return true;
        L13:
            return true;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final void d(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "strFileName");
            Intrinsics.checkNotNullParameter(r101, "cid");
            Log.d("AudioRecordDataRecognize", "[onStartRecord]:" + r100 + '/' + r101);
            final com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r103 = this.f430792b;
            if (r103 != null) goto L6;
            Log.e("AudioRecordDataRecognize", "mAudioMsgInfo is null");
            return;
        L6:
            String r104 = this.f430793c;
            if (r104 != null) goto L9;
        L12:
            boolean r105 = true;
        L13:
            if (r105 == true) goto L23;
            String r106 = fwa.a.f479017a;
            String r107 = this.f430793c;
            fwa.a.f479029m = r107;
            AudioContent r108 = r103.f430795b;
            if (r108 == null) goto L17;
            r108.setUploadId(r107);
            r108.setSequenceId(0);
        L17:
            final int r109 = a();
            final AudioRecordDataProcessor r110 = this.f430743j;
            Function0<Unit> r111 = new AudioRecordDataProcessor$RecognizeWithUploadAudioDataConsumer$onStartRecord$codeBlock$1(this, r103, r109, r110);
            if (r102 == false) goto L20;
            AudioRecordDataProcessor.a(this.f430743j, new b(r111));
        L21:
            this.f430740g = true;
            return;
        L20:
            r111.invoke();
            goto L21
        L23:
            return;
        L9:
            if (r104.length() == 0) goto L12;
            r105 = false;
            goto L13
        }

        public final boolean g(ByteBuffer r110, int r111, double r112) {
            if (b() == true) goto L10;
            if (r110 == null) goto L10;
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r100 = this.f430792b;
            if (r100 == null) goto L9;
            r100.f430798e = r111;
        L9:
            boolean r101 = true;
        L11:
            if (r101 == true) goto L13;
            return false;
        L13:
            if (r110 != null) goto L15;
            return false;
        L15:
            AudioRecordDataProcessor.a(this.f430743j, new c(this, r110, r111, r112));
            return true;
        L10:
            Log.e("AudioRecordDataProcessor", "[onUpdateAudio]mAudioMessage or buffer is null");
            r101 = false;
            goto L11
        }

        public RecognizeWithUploadAudioDataConsumer(AudioRecordDataProcessor r100, UploadAudioDataConsumer r101, l r102, IAudioService r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r102, "newAudio2TextPush");
            Intrinsics.checkNotNullParameter(r110, "audioService");
            Intrinsics.checkNotNullParameter(r111, "mChatId");
            Intrinsics.checkNotNullParameter(r112, "mDeviceLocale");
            Intrinsics.checkNotNullParameter(r113, "mUserLocale");
            this.f430743j = r100;
            this.f430737d = r101;
            this.f430738e = r102;
            this.f430739f = r110;
            this.f430741h = true;
            RecognizeAudioData r103 = new RecognizeAudioData(r102, r110, r111, r112, r113);
            a r104 = new a(this);
            Intrinsics.checkNotNullParameter(r104, "callback");
            r103.f430785f = r104;
            r103.f430780a.H2(r103.f430789j);
            this.f430742i = r103;
        }
    }

    public final class UploadAudioDataConsumer extends com.ss.android.lark.keyboard.plugin.tool.voice.processor.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final qob.a f430764d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PartialUploadAudioData f430765e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AudioRecordDataProcessor f430766f;

        public static final class a implements RxScheduledExecutor.Producer<Message> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f430767a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UploadAudioDataConsumer f430768b;

            @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
            public final Message produce() {
                this.f430767a.await(1, TimeUnit.SECONDS);     // Catch: InterruptedException -> L5
            L7:
                com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r100 = this.f430768b.f430792b;
                if (r100 != null) goto L10;
                Log.e("AudioRecordDataUpload", "mAudioMsgInfo is null");
                return null;
            L10:
                Message r101 = r100.f430794a;
                if (r101 != null) goto L14;
                Log.e("AudioRecordDataUpload", "audioMessage is null, mAudioMsgInfo: cid = " + r100.f430797d + ", fileName = " + r100.f430796c);
                return null;
            L14:
                return r101;
            L5:
                e = move-exception;
                Log.e("AudioRecordDataUpload", "[onAudioRecorded] await occurs timeout:" + e);
                goto L7
            }

            public a(CountDownLatch r100, UploadAudioDataConsumer r101) {
                this.f430767a = r100;
                this.f430768b = r101;
            }
        }

        public static final class b<T> implements RxScheduledExecutor.Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioRecordDataProcessor f430769a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f430770b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ UploadAudioDataConsumer f430771c;

            public b(AudioRecordDataProcessor r100, String r101, String r102, int r103, MonitorMessageSendCallback r104, UploadAudioDataConsumer r105) {
                this.f430769a = r100;
                this.f430770b = r101;
                this.f430771c = r105;
            }

            @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
            public final void consume(Object r100) {
                Message r101 = (Message) r100;
                if (r101 == null) goto L10;
                AudioRecordDataProcessor r102 = this.f430769a;
                String r103 = this.f430770b;
                UploadAudioDataConsumer r104 = this.f430771c;
                qob.a r105 = r102.f430726c;
                r105.f();
                r105.p(r101, r103);
                com.ss.android.lark.keyboard.b r106 = r102.i();
                if (r106 == null) goto L9;
                k r107 = r106.e();
                if (r107 == null) goto L9;
                r107.a(q.a.f429311a, r107.b());
            L9:
                r104.f430792b = null;
                return;
            L10:
                Log.e("AudioRecordDataProcessor", "[onAudioRecorded] audioMsg is null,then ignore send audio msg.");
            }
        }

        public final void f() {
            if (y0.d(this.f430793c) == true) goto L6;
            int r100 = VoiceUtils.f409442a;
            VoiceUtils.a(this.f430766f.f430725b, this.f430793c);
            return;
        }

        public final void h() {
            e();
            if (b() == false) goto L6;
            Log.e("AudioRecordDataUpload", "[onPrepareRecord] invalid context");
            return;
        L6:
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r100 = this.f430792b;
            if (r100 == null) goto L17;
            IAudioService r101 = this.f430766f.f430725b;
            Message r102 = r100.f430794a;
            if (r102 == null) goto L11;
            String r103 = r102.getChatId();
        L12:
            String r104 = r101.ec(r103, r100.f430796c, com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.a());
            if (r104 != null) goto L15;
            r104 = "";
        L15:
            this.f430793c = r104;
            Log.i("AudioRecordDataUpload", "[onPrepareRecord]strFileName:" + r100.f430796c + " cid:" + r100.f430797d + " mUploadId:" + this.f430793c);
            return;
        L11:
            r103 = null;
            goto L12
        }

        public UploadAudioDataConsumer(AudioRecordDataProcessor r100, qob.a r101) {
            Intrinsics.checkNotNullParameter(r101, "mAudioDataDependency");
            this.f430766f = r100;
            this.f430764d = r101;
            this.f430765e = new PartialUploadAudioData(r100.f430725b);
        }

        public final void g(final Function1<? super String, Unit> r110, final Function1<? super ErrorResult, Unit> r111) {
            Intrinsics.checkNotNullParameter(r110, "onSuccess");
            Intrinsics.checkNotNullParameter(r111, LynxVideoManagerLite.EVENT_ON_ERROR);
            final int r100 = a();
            final String r101 = this.f430793c;
            final AudioRecordDataProcessor r102 = this.f430766f;
            AudioRecordDataProcessor.a(r102, new AudioRecordDataProcessor$UploadAudioDataConsumer$finishAudioUpload$1(this, r100, r101, r102, r110, r111));
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final boolean c(String r110, String r111, int r112) {
            Intrinsics.checkNotNullParameter(r110, "strFileName");
            Intrinsics.checkNotNullParameter(r111, "cid");
            if (super.c(r110, r111, r112) == true) goto L6;
            return false;
        L6:
            MonitorMessageSendCallback r100 = this.f430764d.l(r110, r111, r112);
            if (r100 == null) goto L9;
            r100.v(null, null, Message.Type.AUDIO);
        L9:
            final CountDownLatch r101 = new CountDownLatch(1);
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r102 = this.f430792b;
            if (r102 == null) goto L16;
            Log.i("AudioRecordDataUpload", "[onAudioRecorded]strFileName:" + r102.f430796c + " cid:" + r102.f430797d + " mUploadId:" + this.f430793c + '}');
            Message r103 = r102.f430794a;
            if (r103 == null) goto L16;
            AudioContent r104 = (AudioContent) r103.getContent();
            if (r104 == null) goto L16;
            r104.setUploadId(this.f430793c);
        L16:
            g(new AudioRecordDataProcessor$UploadAudioDataConsumer$onAudioRecorded$2(r101), new AudioRecordDataProcessor$UploadAudioDataConsumer$onAudioRecorded$3(r101));
            RxScheduledExecutor.execInIO(new a(r101, this), new b(this.f430766f, r110, r111, r112, r100, this));
            return true;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final void d(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "strFileName");
            Intrinsics.checkNotNullParameter(r101, "cid");
            Log.d("AudioRecordDataUpload", "[onStartRecord]:" + r100 + '/' + r101);
            String r103 = fwa.a.f479017a;
            String r104 = this.f430793c;
            fwa.a.f479021e = r104;
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r105 = this.f430792b;
            if (r105 == null) goto L8;
            AudioContent r106 = r105.f430795b;
            if (r106 == null) goto L9;
            r106.setUploadId(r104);
            r106.setSequenceId(0);
            return;
        L9:
            return;
        }

        public final boolean i(ByteBuffer r100, int r110, double r111) {
            Log.d("AudioRecordDataUpload", "[onUpdateAudio duration]:" + r110 + " volume:" + r111);
            if (b() == true) goto L10;
            if (r100 == null) goto L10;
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r112 = this.f430792b;
            if (r112 == null) goto L9;
            r112.f430798e = r110;
        L9:
            boolean r113 = true;
        L11:
            if (r113 == true) goto L13;
            return false;
        L13:
            if (r100 != null) goto L15;
            return false;
        L15:
            boolean r114 = b();
            String r115 = this.f430793c;
            if (r115 != null) goto L18;
        L21:
            boolean r116 = true;
        L23:
            if ((r114 | r116) == false) goto L25;
            h();
        L25:
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r117 = this.f430792b;
            if (r117 != null) goto L29;
            Log.e("AudioRecordDataUpload", "mAudioMsgInfo is null");
            return false;
        L29:
            this.f430765e.a(new c(r117.f430794a, a(), this.f430793c, r100, false, this.f430766f.f430728e), new AudioRecordDataProcessor$UploadAudioDataConsumer$onUpdateAudio$1());
            return true;
        L18:
            if (r115.length() == 0) goto L21;
            r116 = false;
        L10:
            Log.e("AudioRecordDataProcessor", "[onUpdateAudio]mAudioMessage or buffer is null");
            r113 = false;
            goto L11
        }
    }

    public static final class a {
    }

    public final class b extends com.ss.android.lark.keyboard.plugin.tool.voice.processor.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AudioRecordDataProcessor f430778d;

        public b(AudioRecordDataProcessor r100, qob.a r101) {
            Intrinsics.checkNotNullParameter(r101, "mAudioDataDependency");
            this.f430778d = r100;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.processor.a
        public final boolean c(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "strFileName");
            Intrinsics.checkNotNullParameter(r101, "cid");
            if (super.c(r100, r101, r102) == true) goto L6;
            return false;
        L6:
            com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r103 = this.f430792b;
            if (r103 == null) goto L21;
            AudioRecordDataProcessor r104 = this.f430778d;
            Message r105 = r103.f430794a;
            if (r105 == null) goto L22;
            AudioContent r106 = r103.f430795b;
            if (r106 == null) goto L13;
            r106.setUploadId("");
        L13:
            r104.f430726c.p(r105, r100);
            com.ss.android.lark.keyboard.b r107 = r104.i();
            if (r107 == null) goto L18;
            k r108 = r107.e();
            if (r108 == null) goto L18;
            r108.a(q.a.f429311a, r108.b());
        L18:
            this.f430792b = null;
            return true;
        L22:
            return true;
        L21:
            return true;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void b() {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void e() {
        UploadAudioDataConsumer r100 = this.f430733j;
        if (r100 == null) goto L9;
        r100.f();
        com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r101 = r100.f430792b;
        if (r101 == null) goto L9;
        Message r102 = r101.f430794a;
        if (r102 == null) goto L9;
        r100.f430764d.m(r102.getId());
    L9:
        j();
    }

    public final com.ss.android.lark.keyboard.b i() {
        return (com.ss.android.lark.keyboard.b) this.f430729f.getValue();
    }

    public final void j() {
        this.f430731h.d();
        com.ss.android.lark.audio.voiceinput.processor.a r100 = this.f430732i;
        r100.f409350a.clear();
        r100.f409351b = 0;
        UploadAudioDataConsumer r101 = this.f430733j;
        if (r101 == null) goto L5;
        r101.e();
    L5:
        RecognizeWithUploadAudioDataConsumer r102 = this.f430734k;
        if (r102 == null) goto L9;
        r102.e();
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void onDestroy() {
        this.f430730g.shutdown();
        RecognizeWithUploadAudioDataConsumer r100 = this.f430734k;
        if (r100 == null) goto L6;
        RecognizeAudioData r101 = r100.f430742i;
        r101.f430780a.Ed(r101.f430789j);
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void d(com.ss.android.lark.audio.voiceinput.d.b r100) {
        this.f430736m = r100;
    }

    public static final void a(AudioRecordDataProcessor r100, Runnable r101) {
        if (r100.f430730g.isShutdown() == true) goto L6;
        r100.f430730g.execute(r101);
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "strFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        if (r102 == false) goto L8;
        RecognizeWithUploadAudioDataConsumer r103 = this.f430734k;
        if (r103 == null) goto L16;
        r103.d(r100, r101, true);
        return;
    L16:
        return;
    L8:
        if (this.f430727d == false) goto L12;
        UploadAudioDataConsumer r104 = this.f430733j;
        if (r104 == null) goto L18;
        r104.d(r100, r101, true);
        return;
    L18:
        return;
    L12:
        b r105 = this.f430735l;
        if (r105 == null) goto L20;
        r105.d(r100, r101, true);
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void g(String r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "strFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        if (r103 == false) goto L8;
        RecognizeWithUploadAudioDataConsumer r104 = this.f430734k;
        if (r104 == null) goto L15;
        r104.c(r100, r101, r102);
    L15:
        j();
        return;
    L8:
        if (this.f430727d == false) goto L12;
        UploadAudioDataConsumer r105 = this.f430733j;
        if (r105 == null) goto L15;
        r105.c(r100, r101, r102);
        goto L15
    L12:
        b r106 = this.f430735l;
        if (r106 == null) goto L15;
        r106.c(r100, r101, r102);
        goto L15
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void h(ByteBuffer r100, int r101, double r102, boolean r103) {
        if (r103 == false) goto L7;
        RecognizeWithUploadAudioDataConsumer r104 = this.f430734k;
        if (r104 == null) goto L17;
        r104.g(r100, r101, r102);
        return;
    L17:
        return;
    L7:
        if (this.f430727d == false) goto L19;
        com.ss.android.lark.audio.voiceinput.processor.a r105 = this.f430732i;
        r105.getClass();
        if (r100 != null) goto L11;
    L13:
        UploadAudioDataConsumer r106 = this.f430733j;
        if (r106 == null) goto L20;
        r106.i(r100, r101, r102);
        return;
    L20:
        return;
    L11:
        if (r100.hasArray() == false) goto L13;
        r105.f409350a.offer(r100);
        r105.f409351b += r100.array().length;
        goto L13
    }

    public AudioRecordDataProcessor(l r110, IAudioService r111, qob.a r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r111, "audioService");
        Intrinsics.checkNotNullParameter(r112, "processorDependency");
        this.f430724a = r110;
        this.f430725b = r111;
        this.f430726c = r112;
        this.f430727d = r113;
        this.f430728e = r114;
        this.f430729f = LazyKt.lazy(new AudioRecordDataProcessor$keyboard$2(this));
        this.f430730g = CoreThreadPool.getDefault().newSerialIODensityThreadPool("audio-send");
        this.f430731h = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
        this.f430732i = new com.ss.android.lark.audio.voiceinput.processor.a();
        String r115 = r112.getChatId();
        String r100 = r112.k();
        r112.i();
        UploadAudioDataConsumer r101 = new UploadAudioDataConsumer(this, r112);
        this.f430733j = r101;
        this.f430735l = new b(this, r112);
        this.f430734k = new RecognizeWithUploadAudioDataConsumer(this, r101, r110, r111, r115, r100, "");
        Log.i("AudioRecordDataProcessor", "init deviceLocale:" + r100 + " supportPartialUpload:" + r113 + " chatId:" + r115);
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.c
    public final void f(String r100, String r101, boolean r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "strFileName");
        Intrinsics.checkNotNullParameter(r101, "cid");
        String r102 = this.f430726c.h();
        String r103 = this.f430726c.d();
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r104 = this.f430726c.f();
        Message r105 = this.f430726c.e(r102, r103, r100, r101, r104);
        if (r105 == null) goto L5;
        AudioContent r106 = (AudioContent) r105.getContent();
    L6:
        com.ss.android.lark.keyboard.plugin.tool.voice.processor.b r107 = new com.ss.android.lark.keyboard.plugin.tool.voice.processor.b(r105, r106, r100, r101);
        StringBuilder r108 = new StringBuilder("[onPrepareForRecord] audioMessage is not null ");
        if (r105 == null) goto L9;
        boolean r109 = true;
    L10:
        r108.append(r109);
        r108.append(" cid:");
        r108.append(r101);
        r108.append(" needRecognized:");
        r108.append(r110);
        r108.append(" onlyText:");
        r108.append(r111);
        Log.i("AudioRecordDataProcessor", r108.toString());
        UploadAudioDataConsumer r113 = this.f430733j;
        if (r113 == null) goto L13;
        Intrinsics.checkNotNullParameter(r107, "audioMsgInfo");
        r113.f430792b = r107;
        r113.h();
    L13:
        RecognizeWithUploadAudioDataConsumer r114 = this.f430734k;
        if (r114 == null) goto L19;
        Intrinsics.checkNotNullParameter(r107, "audioMsgInfo");
        r114.f430792b = r107;
        r114.f();
        RecognizeAudioData r115 = r114.f430742i;
        r115.getClass();
        if (r112 != null) goto L18;
        r112 = "un_auto";
    L18:
        r115.f430784e = r112;
    L19:
        b r116 = this.f430735l;
        if (r116 == null) goto L23;
        Intrinsics.checkNotNullParameter(r107, "audioMsgInfo");
        r116.f430792b = r107;
        return;
    L23:
        return;
    L9:
        r109 = false;
        goto L10
    L5:
        r106 = null;
        goto L6
    }
}

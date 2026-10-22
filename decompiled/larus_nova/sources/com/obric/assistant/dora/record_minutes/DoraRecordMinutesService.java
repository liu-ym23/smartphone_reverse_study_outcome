package com.obric.assistant.dora.record_minutes;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.message.MessageStatus;
import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.SpeechSessionManager;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerTaskCreateParam;
import com.mammon.speechaudiosdk.session.task.SpeechRecorderAudioConsumerTask;
import com.obric.assistant.IObricAvailableManager;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class DoraRecordMinutesService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraRecordMinutesService f389125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f389126b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f389127c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f389128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Job f389129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile DoraConnectState f389130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile c f389131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, i> f389132h = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f389133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f389134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f389135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f389136d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f389133a == r101.f389133a) goto L12;
            return false;
        L12:
            if (this.f389134b == r101.f389134b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f389135c, r101.f389135c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f389136d, r101.f389136d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f389133a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f389134b == true) goto L10;
            r100 = 1237;
        L10:
            int r103 = (r102 + r100) * 31;
            String r104 = this.f389135c;
            int r105 = 0;
            if (r104 != null) goto L13;
            int r106 = 0;
        L14:
            int r107 = (r103 + r106) * 31;
            String r108 = this.f389136d;
            if (r108 == null) goto L19;
            r105 = r108.hashCode();
        L19:
            return r107 + r105;
        L13:
            r106 = r104.hashCode();
            goto L14
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "AudioRecordControlResult(success=" + this.f389133a + ", wasRecording=" + this.f389134b + ", recordingId=" + this.f389135c + ", errorMessage=" + this.f389136d + ')';
        }

        public a(boolean r100, boolean r101, String r102, String r103) {
            this.f389133a = r100;
            this.f389134b = r101;
            this.f389135c = r102;
            this.f389136d = r103;
        }

        public /* synthetic */ a(boolean r100, boolean r101, String r102, String r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = false;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r103 = null;
        L11:
            this(r100, r101, r102, r103);
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f389137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f389138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayBlockingQueue<byte[]> f389139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f389140d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f389141e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ParcelFileDescriptor f389142f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ExecutorService f389143g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile ParcelFileDescriptor.AutoCloseOutputStream f389144h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Function1<? super String, Unit> f389145i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AtomicBoolean f389146j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final g f389147k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public volatile boolean f389148l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final AtomicBoolean f389149m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final AtomicBoolean f389150n;

        public final void b() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L13
            ParcelFileDescriptor.AutoCloseOutputStream r101 = this.f389144h;     // Catch: Throwable -> L13
            if (r101 == null) goto L7;
            r101.close();     // Catch: Throwable -> L13
        L6:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L13
        L11:
            Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L13
        L15:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L18;
            FLogger.f375446a.w("DoraRecordMinutesService", "close recorder pcm output failed, sessionId=" + this.f389137a + ", error=" + r104.getMessage());
        L18:
            this.f389144h = null;
            this.f389142f = null;
            return;
        L7:
            ParcelFileDescriptor r105 = this.f389142f;     // Catch: Throwable -> L13
            if (r105 == null) goto L10;
            r105.close();     // Catch: Throwable -> L13
            goto L6
        L10:
            r102 = null;
        L13:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        }

        @Override // com.obric.assistant.dora.record_minutes.DoraRecordMinutesService.f
        public final void onStarted() {
            FLogger.f375446a.i("DoraRecordMinutesService", "recorder pcm capture started, sessionId=" + this.f389137a);
        }

        @Override // com.obric.assistant.dora.record_minutes.DoraRecordMinutesService.f
        public final void onStopped() {
            FLogger.f375446a.i("DoraRecordMinutesService", "recorder pcm capture stopped, sessionId=" + this.f389137a);
        }

        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            if (this.f389141e.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f389140d.set(false);
            this.f389139c.clear();
            b();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
            ExecutorService r102 = this.f389143g;     // Catch: Throwable -> L15
            if (r102 == null) goto L9;
            r102.shutdownNow();     // Catch: Throwable -> L15
        L9:
            ExecutorService r103 = this.f389143g;     // Catch: Throwable -> L15
            if (r103 == null) goto L12;
            Boolean r104 = Boolean.valueOf(r103.awaitTermination(300, TimeUnit.MILLISECONDS));     // Catch: Throwable -> L15
        L13:
            Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L15
        L17:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L20;
            FLogger.f375446a.w("DoraRecordMinutesService", "stop recorder pcm writer failed, sessionId=" + this.f389137a + ", error=" + r106.getMessage());
        L20:
            this.f389143g = null;
            this.f389148l = false;
            this.f389149m.set(false);
            this.f389145i = null;
            FLogger.f375446a.i("DoraRecordMinutesService", "recorder pcm forwarder stopped, sessionId=" + this.f389137a + ", reason=" + r100);
            return;
        L12:
            r104 = null;
        L15:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L17
        }

        public b(String r100, e r101) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
            this.f389137a = r100;
            this.f389138b = r101;
            this.f389139c = new ArrayBlockingQueue(100);
            this.f389140d = new AtomicBoolean(false);
            this.f389141e = new AtomicBoolean(false);
            this.f389146j = new AtomicBoolean(false);
            this.f389147k = new g(r100, r101);
            this.f389149m = new AtomicBoolean(false);
            this.f389150n = new AtomicBoolean(false);
        }

        @Override // com.obric.assistant.dora.record_minutes.DoraRecordMinutesService.f
        public final void a(byte[] r100, e r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
            if (this.f389140d.get() == true) goto L5;
            return;
        L5:
            if (this.f389141e.get() == false) goto L8;
            return;
        L8:
            if (this.f389149m.get() == false) goto L11;
            return;
        L11:
            if (this.f389148l == true) goto L14;
            return;
        L14:
            if (this.f389139c.offer(Arrays.copyOf(r100, r100.length)) == true) goto L22;
            FLogger.f375446a.e("DoraRecordMinutesService", "recorder pcm queue overflow, sessionId=" + this.f389137a);
            if (this.f389146j.compareAndSet(false, true) == false) goto L23;
            Function1<? super String, Unit> r102 = this.f389145i;
            if (r102 == null) goto L24;
            r102.invoke("recorder pcm queue overflow");
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f389151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f389152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f389153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f389154d;

        public c(int r100, String r101, String r102) {
            e r103 = new e(0);
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            Intrinsics.checkNotNullParameter(r103, SubInfo.KEY_FORMAT);
            this.f389151a = r101;
            this.f389152b = r102;
            b r104 = new b(r101, r103);
            this.f389153c = r104;
            this.f389154d = new d(r100, r103, r104);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f389155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f389156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f389157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SpeechRecorderAudioConsumerTask f389158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public SpeechSessionManager f389159e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f389160f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicBoolean f389161g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final com.obric.assistant.dora.record_minutes.f f389162h;

        public final void a() {
            if (this.f389161g.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f389160f.set(false);
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
            SpeechRecorderAudioConsumerTask r101 = this.f389158d;     // Catch: Throwable -> L12
            if (r101 == null) goto L9;
            Integer r102 = Integer.valueOf(r101.stop());     // Catch: Throwable -> L12
        L10:
            Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L12
        L14:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L17;
            FLogger.f375446a.w("DoraRecordMinutesService", "stop pcm capture failed, wakeId=" + this.f389155a + ", error=" + r104.getMessage());
        L17:
            SpeechRecorderAudioConsumerTask r105 = this.f389158d;
            if (r105 == null) goto L22;
            SpeechSessionManager r106 = this.f389159e;
            if (r106 == null) goto L22;
            r106.releaseRecorderAudioConsumerTask(r105);
        L22:
            this.f389158d = null;
            this.f389159e = null;
            this.f389157c.onStopped();
            FLogger.f375446a.i("DoraRecordMinutesService", "close pcm capture, wakeId=" + this.f389155a);
            return;
        L9:
            r102 = null;
        L12:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }

        public d(int r100, e r101, b r102) {
            Intrinsics.checkNotNullParameter(r101, "pcmFormat");
            Intrinsics.checkNotNullParameter(r102, "callback");
            this.f389155a = r100;
            this.f389156b = r101;
            this.f389157c = r102;
            this.f389160f = new AtomicBoolean(false);
            this.f389161g = new AtomicBoolean(false);
            this.f389162h = new com.obric.assistant.dora.record_minutes.f(this);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f389163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f389164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f389165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f389166d;

        public e() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f389163a, r101.f389163a) == true) goto L12;
            return false;
        L12:
            if (this.f389164b == r101.f389164b) goto L15;
            return false;
        L15:
            if (this.f389165c == r101.f389165c) goto L18;
            return false;
        L18:
            if (this.f389166d == r101.f389166d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f389163a.hashCode() * 31) + this.f389164b) * 31) + this.f389165c) * 31) + this.f389166d;
        }

        public final String toString() {
            return "PcmFormat(format=" + this.f389163a + ", sampleRate=" + this.f389164b + ", channel=" + this.f389165c + ", packetDurationMs=" + this.f389166d + ')';
        }

        public e(int r100) {
            Intrinsics.checkNotNullParameter("pcm", SubInfo.KEY_FORMAT);
            this.f389163a = "pcm";
            this.f389164b = 16000;
            this.f389165c = 1;
            this.f389166d = 20;
        }
    }

    public interface f {
        void a(byte[] r100, e r101);

        void onStarted();

        void onStopped();
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f389167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f389168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f389169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f389170d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f389171e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f389172f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f389173g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f389174h;

        public g(String r100, e r101) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
            this.f389167a = r100;
            this.f389168b = r101;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f389175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f389176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ParcelFileDescriptor f389177c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f389178d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f389179e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f389175a == r101.f389175a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f389176b, r101.f389176b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f389177c, r101.f389177c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f389178d, r101.f389178d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f389179e, r101.f389179e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            if (this.f389175a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f389176b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            ParcelFileDescriptor r106 = this.f389177c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (((r105 + r107) * 31) + this.f389178d.hashCode()) * 31;
            String r109 = this.f389179e;
            if (r109 == null) goto L19;
            r103 = r109.hashCode();
        L19:
            return r108 + r103;
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "PcmReadFdResult(success=" + this.f389175a + ", sessionId=" + this.f389176b + ", readFd=" + this.f389177c + ", format=" + this.f389178d + ", errorMessage=" + this.f389179e + ')';
        }

        public h(boolean r100, String r101, ParcelFileDescriptor r102, e r103, String r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r102 = null;
        L9:
            if ((r105 & 8) == 0) goto L12;
            r103 = new e(0);
        L12:
            if ((r105 & 16) == 0) goto L14;
            r104 = null;
        L14:
            Intrinsics.checkNotNullParameter(r103, SubInfo.KEY_FORMAT);
            this.f389175a = r100;
            this.f389176b = r101;
            this.f389177c = r102;
            this.f389178d = r103;
            this.f389179e = r104;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f389180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h f389181b;

        public i() {
            this.f389180a = new CountDownLatch(1);
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f389182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f389183b;

        public /* synthetic */ j() {
            this(true, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (this.f389182a == r101.f389182a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f389183b, r101.f389183b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f389182a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f389183b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "StartResult(success=" + this.f389182a + ", errorMessage=" + this.f389183b + ')';
        }

        public j(boolean r100, String r101) {
            this.f389182a = r100;
            this.f389183b = r101;
        }
    }

    public DoraRecordMinutesService() {
    }

    static {
        f389125a = new DoraRecordMinutesService();
        f389126b = UriProtector.parse("content://com.obric.recorder.dora.provider");
        f389127c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f389130f = DoraConnectState.NA;
        f389132h = new ConcurrentHashMap();
    }

    public static void b() {
        Job r100 = f389129e;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        FLogger.f375446a.i("DoraRecordMinutesService", "cancelDisconnectNotify");
    L10:
        Job r102 = f389129e;
        if (r102 == null) goto L13;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L13:
        f389129e = null;
        return;
    L5:
        if (r100.isActive() != true) goto L7;
        r101 = true;
        goto L8
    }

    public static h g() {
        c r100 = f389131g;
        if (r100 != null) goto L6;
        FLogger.f375446a.w("DoraRecordMinutesService", "startCapturePcm failed, no pcm session");
        return new h(false, null, null, null, "no pcm session", 14);
    L6:
        final b r101 = r100.f389153c;
        if (r101.f389140d.get() == true) goto L9;
    L63:
        FLogger.f375446a.w("DoraRecordMinutesService", "acquire recorder pcm read fd failed, sessionId=" + r101.f389137a + ", error=pcm forwarder not running");
        return new h(false, r101.f389137a, null, r101.f389138b, "pcm forwarder not running", 4);
    L9:
        if (r101.f389141e.get() == true) goto L63;
        if (r101.f389150n.compareAndSet(false, true) == true) goto L67;
        FLogger.f375446a.w("DoraRecordMinutesService", "acquire recorder pcm read fd failed, already requested, sessionId=" + r101.f389137a);
        return new h(false, r101.f389137a, null, r101.f389138b, "read fd already requested", 4);
    L67:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        Object r103 = Result.m9449constructorimpl(ParcelFileDescriptor.createPipe());     // Catch: Throwable -> L16
    L18:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L21;
        FLogger.f375446a.e("DoraRecordMinutesService", "create recorder pcm pipe failed, sessionId=" + r101.f389137a, r104);
    L21:
        Unit r105 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L24;
        r103 = null;
    L24:
        ParcelFileDescriptor[] r106 = (ParcelFileDescriptor[]) r103;
        if (r106 != null) goto L27;
        r101.f389150n.set(false);
        return new h(false, r101.f389137a, null, r101.f389138b, "create pipe failed", 4);
    L27:
        ParcelFileDescriptor r107 = r106[0];
        r101.f389142f = r106[1];
        Object r108 = Result.m9449constructorimpl(r107.dup());     // Catch: Throwable -> L30
    L32:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L36;
        FLogger.f375446a.e("DoraRecordMinutesService", "dup recorder pcm read fd failed, sessionId=" + r101.f389137a, r109);
    L36:
        if (Result.m9455isFailureimpl(r108) == false) goto L38;
        r108 = null;
    L38:
        ParcelFileDescriptor r110 = (ParcelFileDescriptor) r108;
        if (r110 != null) goto L48;
        if (r107 != null) goto L71;
    L44:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L42
    L47:
        r101.b();
        r101.f389150n.set(false);
        return new h(false, r101.f389137a, null, r101.f389138b, "dup read fd failed", 4);
    L42:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L71:
        r107.close();     // Catch: Throwable -> L42
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L42
        goto L44
    L48:
        if (r107 != null) goto L69;
    L52:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L50
    L55:
        ParcelFileDescriptor r112 = r101.f389142f;
        if (r112 == null) goto L58;
        r101.f389144h = new ParcelFileDescriptor.AutoCloseOutputStream(r112);
    L58:
        r101.f389148l = true;
        if (r101.f389143g != null) goto L62;
        ExecutorService r113 = PThreadExecutorsUtils.newSingleThreadExecutor(new com.obric.assistant.dora.record_minutes.c());
        r113.execute(new com.obric.assistant.dora.record_minutes.d(r101));
        r101.f389143g = r113;
    L62:
        FLogger.f375446a.i("DoraRecordMinutesService", "acquire recorder pcm read fd success, sessionId=" + r101.f389137a);
        return new h(true, r101.f389137a, r110, r101.f389138b, null, 16);
    L50:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    L69:
        r107.close();     // Catch: Throwable -> L50
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L50
    L30:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public static void j() {
        if (f389128d == null) goto L5;
        FLogger.f375446a.i("DoraRecordMinutesService", "stopObserveDoraConnectState");
    L5:
        Job r100 = f389128d;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        f389128d = null;
        b();
        f389130f = DoraConnectState.NA;
    }

    public static void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("activity");
        String r102 = null;
        if ((r101 instanceof ActivityManager) == false) goto L5;
        ActivityManager r103 = (ActivityManager) r101;
    L6:
        boolean r104 = false;
        if (r103 == null) goto L27;
        List<ActivityManager.RunningAppProcessInfo> r105 = r103.getRunningAppProcesses();
        if (r105 == null) goto L27;
        List<ActivityManager.RunningAppProcessInfo> r106 = r105;
        if ((r106 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r107 = r106.iterator();
    L17:
        if (r107.hasNext() == false) goto L27;
        ActivityManager.RunningAppProcessInfo r108 = (ActivityManager.RunningAppProcessInfo) r107.next();
        boolean r109 = true;
        if (Intrinsics.areEqual(r108.processName, "com.obric.recorder") == false) goto L21;
    L24:
        boolean r110 = true;
    L25:
        if (r110 == false) goto L17;
    L28:
        FLogger r111 = FLogger.f375446a;
        r111.i("DoraRecordMinutesService", "isRecorderAppRunning " + r109);
        if (r109 == true) goto L45;
        r111.i("DoraRecordMinutesService", "notifyDoraDisconnected skipped, recorder app not running");
        return;
    L45:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L39
        Bundle r113 = r100.getContentResolver().call(f389126b, "notify_dora_disconnected", null, null);     // Catch: Throwable -> L39
        if (r113 == null) goto L35;
        r104 = r113.getBoolean("accepted", false);     // Catch: Throwable -> L39
    L35:
        if (r113 == null) goto L37;
        r102 = r113.getString("reason");     // Catch: Throwable -> L39
    L37:
        r111.i("DoraRecordMinutesService", "notifyDoraDisconnected accepted=" + r104 + ", reason=" + r102);     // Catch: Throwable -> L39
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L52;
        FLogger.f375446a.e("DoraRecordMinutesService", "notifyDoraDisconnected failed", r115);
        return;
    L52:
        return;
    L39:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L21:
        if (StringsKt.startsWith$default(r108.processName, "com.obric.recorder:", false, 2, null) == true) goto L24;
        r110 = false;
        goto L25
    L13:
        if (r106.isEmpty() == false) goto L15;
    L27:
        r109 = false;
        goto L28
    L5:
        r103 = null;
        goto L6
    }

    public static void h(Context r110) {
        Job r100 = f389128d;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        FLogger.f375446a.i("DoraRecordMinutesService", "startObserveDoraConnectState skipped, already observing");
        return;
    L12:
        CoWakeupApi r103 = uha.a.a();
        if (r103 != null) goto L15;
    L17:
        if (r101 == false) goto L19;
        DoraConnectState r104 = DoraConnectState.CONNECTED;
    L20:
        f389130f = r104;
        FLogger.f375446a.i("DoraRecordMinutesService", "startObserveDoraConnectState lastConnectState=" + f389130f);
        f389128d = BuildersKt.launch$default(f389127c, null, null, new DoraRecordMinutesService$startObserveDoraConnectState$1(r110, null), 3, null);
        return;
    L19:
        r104 = DoraConnectState.NA;
        goto L20
    L15:
        if (r103.b() != true) goto L17;
        r101 = true;
        goto L17
    L5:
        if (r100.isActive() != true) goto L7;
        r102 = true;
        goto L9
    }

    public static final String a(DoraRecordMinutesService r100, double r101) {
        r100.getClass();
        if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return "-inf";
    L5:
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(Math.log10(r101 / 32768.0d) * 20.0d)}, 1));
    }

    public static boolean c(String r100, h r101) {
        i r102 = f389132h.remove(r100);
        if (r102 != null) goto L6;
        FLogger.f375446a.w("DoraRecordMinutesService", "completeRecorderAppStart skipped, no pending start, sessionId=".concat(r100));
        return false;
    L6:
        Intrinsics.checkNotNullParameter(r101, "result");
        r102.f389181b = r101;
        r102.f389180a.countDown();
        return true;
    }

    public static boolean i(String r100, boolean r101) {
        c r102 = f389131g;
        if (r102 != null) goto L8;
        if (r101 == false) goto L18;
        j();
        return false;
    L18:
        return false;
    L8:
        f389131g = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L12;
        r100 = null;
    L12:
        if (r100 != null) goto L14;
        r100 = "stop_dora_g_record_pcm";
    L14:
        FLogger.f375446a.i("DoraRecordMinutesService", "stopDoraGRecordPcm sessionId=" + r102.f389151a + ", reason=" + r100);
        Intrinsics.checkNotNullParameter(r100, "reason");
        r102.f389154d.a();
        r102.f389153c.c(r100);
        if (r101 == false) goto L17;
        j();
    L17:
        return true;
    }

    public final boolean d(int r110, int r111, int r112, int r210, String r211, String r212, String r213) {
        if (r212 != null) goto L5;
    L9:
        String r100 = UUID.randomUUID().toString();
    L10:
        boolean r101 = Intrinsics.areEqual(r213, "recorder_app");
        FLogger r102 = FLogger.f375446a;
        r102.i("DoraRecordMinutesService", "handleStartRecordMinutes start vuiId=" + r210 + ", sessionId=" + r100 + ", source=" + r213);
        if (r101 == true) goto L13;
    L16:
        r102.i("DoraRecordMinutesService", "startDoraGRecordPcm start vuiId=" + r210 + ", sessionId=" + r100 + ", source=" + r213);
        i("restart_dora_g_record_pcm", true);
        final c r103 = new c(r210, r100, r213);
        f389131g = r103;
        b r104 = r103.f389153c;
        Function1<? super String, Unit> r113 = new com.obric.assistant.dora.record_minutes.e(r103);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r113, "onBroken");
        r104.f389145i = r113;
        r104.f389140d.set(true);
        r104.f389141e.set(false);
        r104.f389146j.set(false);
        r102.i("DoraRecordMinutesService", "recorder pcm forwarder started, sessionId=" + r104.f389137a + ", sampleRate=" + r104.f389138b.f389164b + ", channel=" + r104.f389138b.f389165c);
        d r105 = r103.f389154d;
        if (r105.f389161g.get() == false) goto L20;
        j r106 = new j(false, "pcm capture session already closed");
    L38:
        if (r106.f389182a == true) goto L41;
        r103.f389154d.a();
        r103.f389153c.c("capture_start_failed");
    L41:
        if (r106.f389182a == true) goto L46;
        r102.e("DoraRecordMinutesService", "startDoraGRecordPcm failed, sessionId=" + r100 + ", error=" + r106.f389183b);
        if (f389131g != r103) goto L45;
        f389131g = null;
    L45:
        boolean r107 = false;
    L47:
        if (r107 == true) goto L51;
        if (r101 == false) goto L50;
        c(r100, new h(false, r100, null, null, "start pcm failed", 12));
    L50:
        return false;
    L51:
        if (r101 == false) goto L58;
        h(FlowRuntime.a().getApplication());
        h r108 = g();
        boolean r109 = c(r100, r108);
        if (r108.f389175a == true) goto L55;
        i("recorder_app_acquire_fd_failed", true);
    L55:
        r102.i("DoraRecordMinutesService", "handleStartRecordMinutes recorder app pcm ready=" + r108.f389175a + ", completed=" + r109 + ", sessionId=" + r100);
        return r108.f389175a;
    L58:
        if (r111 != 14) goto L60;
        boolean r114 = true;
    L61:
        boolean r115 = f("开始录音", "wakeUp", r110, r111, r112, r210, r211, r114);
        if (r115 == true) goto L64;
        i("start_record_minutes_query_failed", true);
    L65:
        return r115;
    L64:
        h(FlowRuntime.a().getApplication());
        goto L65
    L60:
        r114 = false;
        goto L61
    L46:
        r102.i("DoraRecordMinutesService", "startDoraGRecordPcm success, sessionId=".concat(r100));
        r107 = true;
        goto L47
    L20:
        if (r105.f389160f.compareAndSet(false, true) == true) goto L22;
        r106 = new j();
        goto L38
    L22:
        SpeechSessionManager r116 = new SpeechSessionManager();
        r105.f389159e = r116;
        SpeechRecorderAudioConsumerTaskCreateParam r117 = new SpeechRecorderAudioConsumerTaskCreateParam();
        r117.vuiId = String.valueOf(r105.f389155a);
        e r118 = r105.f389156b;
        r117.sampleRate = r118.f389164b;
        r117.channel = r118.f389165c;
        r117.format = "pcm";
        r117.packetDurationMs = r118.f389166d;
        r117.userCallback = r105.f389162h;
        SpeechRecorderAudioConsumerTask r119 = r116.createRecorderAudioConsumerTask(r117);
        if (r119 != null) goto L30;
        r102.e("DoraRecordMinutesService", "create pcm recorder audio consumer task failed, wakeId=" + r105.f389155a);
        SpeechRecorderAudioConsumerTask r120 = r105.f389158d;
        if (r120 == null) goto L29;
        SpeechSessionManager r121 = r105.f389159e;
        if (r121 == null) goto L29;
        r121.releaseRecorderAudioConsumerTask(r120);
    L29:
        r105.f389158d = null;
        r105.f389159e = null;
        r105.f389160f.set(false);
        r106 = new j(false, "create pcm recorder audio consumer task failed");
        goto L38
    L30:
        r105.f389158d = r119;
        int r122 = r119.init();
        if (r122 == 0) goto L33;
        String r123 = "init pcm recorder audio consumer task failed, code=" + r122;
        r102.e("DoraRecordMinutesService", r123 + ", wakeId=" + r105.f389155a);
        r105.a();
        r106 = new j(false, r123);
        goto L38
    L33:
        int r124 = r119.start();
        if (r124 == 0) goto L36;
        String r125 = "start pcm recorder audio consumer task failed, code=" + r124;
        r102.e("DoraRecordMinutesService", r125 + ", wakeId=" + r105.f389155a);
        r105.a();
        r106 = new j(false, r125);
        goto L38
    L36:
        r102.i("DoraRecordMinutesService", "start pcm capture, wakeId=" + r105.f389155a + ", sampleRate=" + r105.f389156b.f389164b + ", channel=" + r105.f389156b.f389165c);
        r105.f389157c.onStarted();
        r106 = new j();
        goto L38
    L13:
        if (f389132h.containsKey(r100) == true) goto L16;
        r102.w("DoraRecordMinutesService", "handleStartRecordMinutes skipped, recorder app start is not pending, sessionId=" + r100);
        return false;
    L5:
        if ((!StringsKt.isBlank(r212)) == false) goto L7;
        r100 = r212;
    L8:
        if (r100 != null) goto L10;
    L7:
        r100 = null;
        goto L8
    }

    public static boolean f(String r210, String r211, int r212, int r213, int r214, int r215, String r216, boolean r217) {
        IObricAvailableManager.f385118a.getClass();
        IObricAvailableManager r100 = IObricAvailableManager.a.a();
        if (r100 == null) goto L5;
        boolean r101 = r100.a();
    L6:
        IObricChatService.f386556a.getClass();
        IObricChatService r102 = IObricChatService.a.a();
        if (r102 == null) goto L11;
        wc9.e r103 = r102.h();
        if (r103 == null) goto L11;
        String r104 = r103.f559198a;
    L12:
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("sendDoraGRecordMinutesQuery action=");
        r106.append(r211);
        r106.append(", isDefaultAssistant=");
        r106.append(r101);
        r106.append(", hasConversation=");
        if (r104 == null) goto L15;
        boolean r107 = true;
    L16:
        r106.append(r107);
        r106.append(", state=");
        r106.append(r212);
        r106.append(", mode=");
        r106.append(r213);
        r106.append(", query=");
        r106.append(r214);
        r106.append(", vuiId=");
        r106.append(r215);
        r106.append(", kw=");
        r106.append(r216);
        r106.append(", hideMessage=");
        r106.append(r217);
        r105.i("DoraRecordMinutesService", r106.toString());
        if (r101 == false) goto L100;
        if (r104 == null) goto L104;
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("create_time_ms", String.valueOf(System.currentTimeMillis()));
        r108.put("record_status", "1");
        r108.put("wiki", "2");
        r108.put("search_engine_type", "4");
        r108.put("media_search_type", "1");
        r108.put("answer_with_suggest", "1");
        r108.put("system_language", "zh");
        IDoraService r109 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r109 == null) goto L23;
        DeviceService r110 = r109.device();
    L24:
        if (r110 == null) goto L28;
        String r111 = r110.n();
        if ((!StringsKt.isBlank(r111)) == false) goto L28;
    L29:
        Object r112 = AppHost.f326268a.getApplication().getSystemService("audio");
        if ((r112 instanceof AudioManager) == false) goto L32;
        AudioManager r113 = (AudioManager) r112;
    L33:
        if (r113 == null) goto L82;
        AudioDeviceInfo[] r114 = r113.getDevices(1);
        AudioDeviceInfo[] r115 = r113.getDevices(2);
        Intrinsics.checkNotNull(r114);
        int r116 = r114.length;
        int r117 = 0;
    L36:
        if (r117 >= r116) goto L70;
        AudioDeviceInfo r118 = r114[r117];
        DoraRecordMinutesService r119 = f389125a;
        Intrinsics.checkNotNull(r118);
        r119.getClass();
        IDoraService r120 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r120 == null) goto L44;
        DeviceService r121 = r120.device();
        if (r121 == null) goto L44;
        if (r121.M() != true) goto L44;
        boolean r122 = true;
    L45:
        IDoraService r123 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r123 == null) goto L52;
        DeviceService r124 = r123.device();
        if (r124 == null) goto L52;
        if (r124.K(r111) != true) goto L52;
        boolean r125 = true;
    L54:
        if (r118.getType() != 7) goto L56;
    L61:
        boolean r126 = true;
    L62:
        if (r126 == false) goto L66;
        if (r122 == false) goto L66;
        if (r125 == false) goto L66;
        boolean r127 = true;
    L67:
        if (r127 == true) goto L68;
        r117 = r117 + 1;
        goto L36
    L68:
        AudioDeviceInfo r128 = r118;
    L71:
        FLogger r129 = FLogger.f375446a;
        StringBuilder r130 = new StringBuilder("getDoraBluetoothId hasDoraMac=");
        if (r111 == null) goto L74;
        boolean r131 = true;
    L75:
        r130.append(r131);
        r130.append(", bluetoothId=");
        if (r128 == null) goto L78;
        Integer r132 = Integer.valueOf(r128.getId());
    L79:
        r130.append(r132);
        r130.append(", inputDevices=");
        r130.append(ArraysKt.joinToString$default(r114, null, "[", "]", 0, null, new com.obric.assistant.dora.record_minutes.b(), 25, null));
        r130.append(", outputDevices=");
        Intrinsics.checkNotNull(r115);
        r130.append(ArraysKt.joinToString$default(r115, null, "[", "]", 0, null, new com.obric.assistant.dora.record_minutes.b(), 25, null));
        r129.i("DoraRecordMinutesService", r130.toString());
        if (r128 == null) goto L82;
        Integer r133 = Integer.valueOf(r128.getId());
    L83:
        IDoraService r134 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r134 == null) goto L88;
        DeviceService r135 = r134.device();
        if (r135 == null) goto L88;
        Integer r136 = Integer.valueOf(r135.y());
    L89:
        FLogger.f375446a.i("DoraRecordMinutesService", "buildDoraRecordParams bluetoothId=" + r133 + ", productId=" + r136);
        JSONObject r137 = new JSONObject();
        r137.put("is_from_dora", true);
        if (r133 == null) goto L92;
        r137.put("dora_bluetooth_id", String.valueOf(r133.intValue()));
    L92:
        if (r136 == null) goto L94;
        r137.put("dora_product_id", String.valueOf(r136.intValue()));
    L94:
        r108.put("o_dora_params", r137.toString());
        u1 r138 = RepoDispatcherDelegate.f307737b.e().u1();
        String r139 = UUID.randomUUID().toString();
        MessageStatus r140 = MessageStatus.MessageStatus_INVISIBLE;
        if (r217 == false) goto L97;
        MessageStatus r141 = r140;
    L98:
        u1.a.f(r138, r210, r104, "doraGRecordMinutes", r108, null, r141, r139, false, null, String.valueOf(r213), null, null, null, false, 27432);
        return true;
    L97:
        r141 = null;
    L88:
        r136 = null;
        goto L89
    L78:
        r132 = null;
        goto L79
    L74:
        r131 = false;
    L66:
        r127 = false;
        goto L67
    L56:
        if (r118.getType() == 8) goto L61;
        if (r118.getType() == 26) goto L61;
        r126 = false;
    L52:
        r125 = false;
    L44:
        r122 = false;
        goto L45
    L70:
        r128 = null;
    L82:
        r133 = null;
        goto L83
    L32:
        r113 = null;
    L28:
        r111 = null;
        goto L29
    L23:
        r110 = null;
        goto L24
    L104:
        return false;
    L100:
        return false;
    L15:
        r107 = false;
    L11:
        r104 = null;
        goto L12
    L5:
        r101 = true;
        goto L6
    }
}

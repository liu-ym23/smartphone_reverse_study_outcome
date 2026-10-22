package com.bytedance.ee.bear.middleground.audio.asrsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import ay4.c;
import ay4.d;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.middleground.audio.e;
import com.bytedance.ee.bear.middleground.audio.i;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionRequest;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionResponse;
import com.ss.android.lark.audio.recorder.AudioRecordConfigBuilder;
import com.ss.android.lark.audio.recorder.LarkAudioRecorder;
import com.ss.android.lark.audio.recorder.k;
import com.ss.android.lark.sdk.SdkSender;
import eu5.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AsrSDK implements i {
    public static final AsrSDK a = null;
    public static int b;
    public static List<Integer> c;
    public static boolean d;
    public static boolean e;
    public static final String f = null;
    public static boolean g;
    public static final String h = null;
    public static long i;
    public static final Handler j = null;

    public static final class a<T> implements SdkSender.IParser {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object parse(byte[] r2) {
            return (SendSpeechRecognitionResponse) SendSpeechRecognitionResponse.ADAPTER.decode(r2);
        }
    }

    public AsrSDK() {
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void x() {
    }

    static {
        a = new AsrSDK();
        b = 1;
        new ArrayList();
        d = true;
        e = true;
        String r0 = "zh_cn";
        f = "zh_cn";
        StringBuilder r1 = new StringBuilder();
        int r2 = c.a;
        r1.append(c.a.f(Biz.DOCS, null, false, false, 14).getAbsolutePath());
        r1.append(File.separator);
        r1.append("comment_audio.m4a");
        h = r1.toString();
        i = -1;
        j = new Handler(Looper.getMainLooper());
        ((f) org.koin.java.a.c(f.class, null, null, 6)).d0().t();
        i0 r3 = (i0) org.koin.java.a.c(i0.class, null, null, 6);
        if (r3 == null) goto L8;
        String r4 = r3.a();
        if (r4 == null) goto L8;
        r0 = r4;
    L8:
        f = r0;
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void u() {
        e.a.f();
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void v() {
        e.a.f();
        FileUtils.m(d.a().z(h));
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void w() {
        if (g == true) goto L7;
        g = true;
        int r0 = com.bytedance.ee.bear.middleground.audio.a.a;
        Application r1 = b.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Context r2 = r1.getApplicationContext();
        int r3 = com.bytedance.ee.bear.middleground.audio.d.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        com.ss.android.lark.a.a = new com.bytedance.ee.bear.middleground.audio.c(r2);
        e.a.c(AudioRecordConfigBuilder.CCM.getAudioRecordConfig());
        i = System.currentTimeMillis();
        FileUtils.m(d.a().z(h));
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.audio.i
    public final void y(final String r3, final Function3<? super String, ? super Boolean, ? super int[], Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "speechLocale");
        Intrinsics.checkNotNullParameter(r4, "askCallCallBack");
        Intrinsics.checkNotNullParameter(r3, "speechLocale");
        Intrinsics.checkNotNullParameter(r4, "askCallCallBack");
        LarkAudioRecorder r0 = e.a;
        String r1 = h;
        k r2 = new AsrSDK$startRecord$1(r3, r4);
        Intrinsics.checkNotNullParameter(r1, "audioFilePath");
        Intrinsics.checkNotNullParameter(r2, "audioRecordListener");
        e.a.e(r1, r2);
    }

    public static boolean a(String r3, long r4, byte[] r6, final Function3 r7) {
        SendSpeechRecognitionRequest.Builder r0 = new SendSpeechRecognitionRequest.Builder();
        ByteString.a r1 = ByteString.Companion;
        byte[] r8 = Arrays.copyOf(r6, r6.length);
        r1.getClass();
        SendSpeechRecognitionRequest.Builder r9 = r0.audio_data(ByteString.a.c(r8)).audio_format("opus").audio_rate(16000).device_locale(f);
        int r2 = b;
        b = r2 + 1;
        SendSpeechRecognitionRequest.Builder r5 = r9.sequence_id(Integer.valueOf(r2)).should_diff_result(Boolean.TRUE).source_id(String.valueOf(r4)).speech_locale(r3);
        Integer r10 = r5.sequence_id;
        if (r10 == null) goto L9;
        if (r10.intValue() != 1) goto L9;
        r5.action(SendSpeechRecognitionRequest.Action.BEGIN);
    L11:
        SdkSender.asynSendRequestNonWrap(Command.SEND_SPEECH_RECOGNITION, r5, new AsrSDK$feedAudio$1(r7), a.a);
        return e;
    L9:
        if (d == false) goto L11;
        r5.action(SendSpeechRecognitionRequest.Action.END);
        goto L11
    }
}

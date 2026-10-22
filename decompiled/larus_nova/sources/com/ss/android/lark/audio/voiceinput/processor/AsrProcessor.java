package com.ss.android.lark.audio.voiceinput.processor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.lark.pb.im.v1.SpeechScene;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import com.ss.android.lark.audio.voiceinput.s;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.g0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes34.dex */
public final class AsrProcessor implements com.ss.android.lark.audio.voiceinput.processor.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f409320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f409321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f409322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f409323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f409324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f409325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.audio.voiceinput.e f409326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larksuite.framework.callback.c f409327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f409328i;

    public static final class a {
    }

    public static final class b implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsrProcessor f409329a;

        public b(AsrProcessor r100) {
            this.f409329a = r100;
        }

        @Override // com.ss.android.lark.audio.voiceinput.service.n
        public final void a(com.ss.android.lark.audio.voiceinput.service.a r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r110, "result");
            String r100 = this.f409329a.f409321b;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            return;
        L11:
            Log.i("VoiceInputService", "[AsrProcessor]recognize result:" + r110.a() + " fromPush:" + r111 + " sourceId:" + this.f409329a.f409321b + " curSequenceId:" + this.f409329a.f409323d);
            AsrProcessor r112 = this.f409329a;
            Integer r102 = r110.f409409b;
            if (r102 == null) goto L30;
            int r103 = r102.intValue();
            if (Intrinsics.areEqual(r110.f409408a, r112.f409321b) == true) goto L16;
            return;
        L16:
            if (r112.f409323d >= r103) goto L18;
        L19:
            String r104 = fwa.a.f479017a;
            fwa.a.c(r103, r110.f409411d, r110.f409410c);
            if (r112.f409323d >= r103) goto L22;
            r112.f409323d = r103;
        L22:
            com.ss.android.lark.audio.voiceinput.e r113 = r112.f409326g;
            if (r113 == null) goto L33;
            String r105 = r110.f409408a;
            String r106 = r110.f409410c;
            boolean r107 = r110.f409411d;
            List<Integer> r108 = r110.f409412e;
            if (r108 == null) goto L27;
            int[] r109 = com.ss.android.lark.audio.voiceinput.utils.c.a(r108);
        L28:
            r113.e(new com.ss.android.lark.audio.voiceinput.c(r105, r103, r106, r107, r109, r110.f409413f, r110.f409414g, g0.e(r110.f409415h, null), g0.e(r110.f409416i, null), r110.f409417j, r110.f409418k));
            return;
        L27:
            r109 = null;
            goto L28
        L33:
            return;
        L18:
            if (r110.f409411d == true) goto L19;
            return;
        L30:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsrProcessor f409330a;

        public c(AsrProcessor r100) {
            this.f409330a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.audio.voiceinput.e r100 = this.f409330a.f409326g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.f();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsrProcessor f409331a;

        public d(AsrProcessor r100) {
            this.f409331a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.audio.voiceinput.e r100 = this.f409331a.f409326g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void b() {
        this.f409321b = null;
        this.f409322c = 0;
        this.f409323d = 0;
        this.f409324e = "";
        this.f409325f = false;
        Log.i("VoiceInputService", "[AsrProcessor]resetIfNeed " + hashCode());
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void d() {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final String getUploadId() {
        return "";
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void onDestroy() {
        this.f409322c = 0;
        this.f409321b = "";
        this.f409324e = "";
        this.f409320a.f409362c.Ed(this.f409328i);
        Log.i("VoiceInputService", "[AsrProcessor]onDestroy hashCode" + hashCode());
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final String a() {
        String r100 = this.f409321b;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void e() {
        this.f409327h.a(new d(this));
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final boolean c() {
        return this.f409325f;
    }

    public AsrProcessor(h r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceInputContext");
        this.f409320a = r100;
        this.f409324e = "un_auto";
        this.f409327h = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
        this.f409328i = new b(this);
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void f(ProcessType r100) {
        Intrinsics.checkNotNullParameter(r100, "processType");
    }

    public final void k(IGetDataCallback<String> r100) {
        if (this.f409325f == false) goto L5;
        return;
    L5:
        g r101 = new g(0);
        r101.f409356a = ByteBuffer.wrap(new byte[0]);
        r101.f409359d = true;
        r101.f409357b = false;
        l(r101, r100);
        this.f409327h.a(new c(this));
        this.f409325f = true;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final boolean g(g r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
        String r102 = this.f409321b;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        this.f409321b = UUID.randomUUID().toString();
    L11:
        k(r101);
        l(r100, r101);
        return true;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void h(g r100, VoiceDataProcessDispatcher$onStartRecord$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
        boolean r102 = false;
        this.f409322c = 0;
        String r103 = this.f409321b;
        if (r103 != null) goto L5;
    L6:
        r102 = true;
    L7:
        if (r102 == false) goto L9;
        this.f409321b = UUID.randomUUID().toString();
    L9:
        k(r101);
        return;
    L5:
        if (r103.length() != 0) goto L7;
        goto L6
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void j(s r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r101, "languageKey");
        BuildersKt.launch$default(this.f409320a.f409360a, Dispatchers.getIO(), null, new AsrProcessor$changeAsrLanguage$1(this, r100, r101, null), 2, null);
    }

    public final void l(g r210, final IGetDataCallback<String> r211) {
        monitor-enter(this);
        this.f409322c++;     // Catch: Throwable -> L31
        final int r100 = this.f409322c;     // Catch: Throwable -> L31
        monitor-exit(this);
        boolean r101 = false;
        if (r100 != 1) goto L9;
        boolean r102 = true;
    L10:
        boolean r103 = r210.f409357b;
        if (r102 == false) goto L18;
        Log.i("VoiceInputService", "[AsrProcessor]send first request sequenceId:" + r100 + " sourceId:" + this.f409321b + ' ' + hashCode() + " asrLocale:" + this.f409324e);
        if (this.f409324e.length() != 0) goto L15;
        r101 = true;
    L15:
        if (r101 == false) goto L17;
        Log.e("VoiceInputService", "[AsrProcessor]asrLocale is null");
        this.f409324e = "un_auto";
    L17:
        int r110 = 1;
    L21:
        h r104 = this.f409320a;
        IAudioService r105 = r104.f409361b;
        String r106 = this.f409321b;
        String r107 = r104.f409365f;
        String r108 = this.f409324e;
        ByteBuffer r109 = r210.f409356a;
        if (r109 == null) goto L24;
        byte[] r111 = r109.array();
    L25:
        h r112 = this.f409320a;
        String r113 = r112.f409366g;
        boolean r114 = r210.f409358c;
        boolean r115 = r210.f409359d;
        boolean r116 = r112.f409370k;
        boolean r117 = r112.f409371l;
        VoiceInputSpeechScene r118 = r112.f409375p;
        if (r118 == null) goto L28;
        SpeechScene r119 = r118.f409197a;
    L29:
        r105.Jb(r106, r100, r107, r108, r111, r110, r113, r114, r115, r116, r117, r119, r112.f409376q, new AsrProcessor$processRequest$1(this, r211, r100));
        return;
    L28:
        r119 = null;
        goto L29
    L24:
        r111 = null;
        goto L25
    L18:
        if (r103 == false) goto L20;
        Log.i("VoiceInputService", "[AsrProcessor]send last request sequenceId:" + r100 + " sourceId:" + this.f409321b + ' ' + hashCode());
        r110 = 2;
        goto L21
    L20:
        r110 = 0;
        goto L21
    L9:
        r102 = false;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void i(g r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
        Intrinsics.checkNotNullParameter(r101, "audioFileName");
        this.f409321b = UUID.randomUUID().toString();
        if (r102 != null) goto L5;
        String r103 = "un_auto";
    L6:
        this.f409324e = r103;
        Log.i("VoiceInputService", "[AsrProcessor]onPrepareRecord sourceId:" + this.f409321b + " currentLocale:" + r102);
        return;
    L5:
        r103 = r102;
        goto L6
    }
}

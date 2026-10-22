package com.ss.android.lark.audio.voiceinput.processor;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.audio.voiceinput.s;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils;
import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class UploadProcessor implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f409336e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f409337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f409338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f409339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f409340d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final boolean c() {
        return false;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void e() {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void b() {
        this.f409338b = "";
        this.f409339c = "";
        this.f409340d = 0;
        Log.i("VoiceInputService", "[UploadProcessor]resetIfNeed " + hashCode());
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void d() {
        String r100 = this.f409338b;
        if (r100 == null) goto L6;
        int r101 = VoiceUtils.f409442a;
        VoiceUtils.a(this.f409337a.f409361b, r100);
        return;
    L6:
        Log.d("VoiceInputService", "[UploadProcessor]abortIfNeed:uploadId is null");
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final String getUploadId() {
        String r100 = this.f409338b;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void onDestroy() {
        this.f409338b = "";
        this.f409339c = "";
        this.f409340d = 0;
        Log.i("VoiceInputService", "[UploadProcessor]onDestroy " + hashCode());
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final String a() {
        return this.f409339c;
    }

    public UploadProcessor(h r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceInputContext");
        this.f409337a = r100;
        this.f409339c = "";
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void f(ProcessType r100) {
        Intrinsics.checkNotNullParameter(r100, "processType");
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final boolean g(final g r110, final IGetDataCallback<String> r111) {
        Intrinsics.checkNotNullParameter(r110, "voiceDataProcessEntity");
        String r100 = this.f409338b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        Log.e("VoiceInputService", "[UploadProcessor]onUpdateRecord uploadId is null");
        return false;
    L12:
        monitor-enter(this);
        this.f409340d++;     // Catch: Throwable -> L23
        final int r102 = this.f409340d;     // Catch: Throwable -> L23
        monitor-exit(this);
        Log.d("VoiceInputService", "[UploadProcessor]onUpdateRecord:uploadId:" + this.f409338b + " sequenceId:" + r102);
        IAudioService r103 = this.f409337a.f409361b;
        String r104 = this.f409338b;
        ByteBuffer r105 = r110.f409356a;
        if (r105 == null) goto L18;
        byte[] r106 = r105.array();
    L19:
        r103.jc(r104, r102, r106, r110.f409357b, new UploadProcessor$onUpdateRecord$1$1(r111, r110, this, r102));
        if (r102 != 1) goto L22;
        UICallbackExecutor.execute(new f(false, this));
    L22:
        return true;
    L18:
        r106 = null;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void h(g r100, VoiceDataProcessDispatcher$onStartRecord$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void j(s r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r101, "languageKey");
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void i(g r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
        Intrinsics.checkNotNullParameter(r101, "audioFileName");
        this.f409339c = UUID.randomUUID().toString();
        h r103 = this.f409337a;
        this.f409338b = r103.f409361b.ec(r103.f409366g, r101, r102);
        Log.i("VoiceInputService", "[UploadProcessor]onPrepareRecord:uploadId:" + this.f409338b + " chatId:" + this.f409337a.f409366g + ' ' + hashCode());
    }
}

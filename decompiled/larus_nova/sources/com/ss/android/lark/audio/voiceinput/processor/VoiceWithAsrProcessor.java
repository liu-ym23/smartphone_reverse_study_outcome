package com.ss.android.lark.audio.voiceinput.processor;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.s;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class VoiceWithAsrProcessor implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsrProcessor f409345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UploadProcessor f409346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProcessType f409347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.processor.a f409348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.utils.d f409349e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void e() {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final String a() {
        return this.f409345a.a();
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void b() {
        this.f409345a.b();
        this.f409346b.b();
        com.ss.android.lark.audio.voiceinput.processor.a r100 = this.f409348d;
        r100.f409350a.clear();
        r100.f409351b = 0;
        this.f409349e.f409446a = false;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final boolean c() {
        return this.f409345a.f409325f;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void d() {
        this.f409346b.d();
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final String getUploadId() {
        return this.f409346b.getUploadId();
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void onDestroy() {
        this.f409345a.onDestroy();
        this.f409346b.onDestroy();
        com.ss.android.lark.audio.voiceinput.processor.a r100 = this.f409348d;
        r100.f409350a.clear();
        r100.f409351b = 0;
        this.f409349e.f409446a = false;
    }

    public VoiceWithAsrProcessor(h r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceInputContext");
        this.f409345a = new AsrProcessor(r100);
        this.f409346b = new UploadProcessor(r100);
        this.f409347c = ProcessType.VoiceWithAsr;
        this.f409348d = new com.ss.android.lark.audio.voiceinput.processor.a();
        this.f409349e = new com.ss.android.lark.audio.voiceinput.utils.d();
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void f(ProcessType r100) {
        Intrinsics.checkNotNullParameter(r100, "processType");
        this.f409347c = r100;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final boolean g(g r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
        this.f409349e.a(new VoiceWithAsrProcessor$onUpdateRecord$1(this));
        if (this.f409347c != ProcessType.OnlyVoice) goto L11;
        com.ss.android.lark.audio.voiceinput.processor.a r102 = this.f409348d;
        ByteBuffer r103 = r100.f409356a;
        r102.getClass();
        if (r103 == null) goto L16;
        if (r103.hasArray() == false) goto L16;
        r102.f409350a.offer(r103);
        r102.f409351b += r103.array().length;
    L16:
        return this.f409346b.g(r100, r101);
    L11:
        if ((!this.f409348d.f409350a.isEmpty()) == false) goto L14;
        final g r104 = new g(0);
        r104.f409359d = true;
        this.f409348d.a(new VoiceWithAsrProcessor$handleCacheDataIfNeed$1(r104, this));
    L14:
        this.f409346b.g(r100, r101);
        this.f409345a.g(r100, r101);
        return true;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void h(g r100, VoiceDataProcessDispatcher$onStartRecord$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
        if (this.f409347c != ProcessType.VoiceWithAsr) goto L6;
        this.f409345a.h(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void j(s r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r101, "languageKey");
        this.f409345a.j(r100, r101);
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void i(g r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
        Intrinsics.checkNotNullParameter(r101, "audioFileName");
        this.f409346b.i(r100, r101, r102);
        this.f409345a.i(r100, r101, r102);
    }
}

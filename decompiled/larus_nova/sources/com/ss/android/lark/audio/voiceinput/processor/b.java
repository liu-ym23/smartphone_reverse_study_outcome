package com.ss.android.lark.audio.voiceinput.processor;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.s;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f409353a;

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final boolean c() {
        return false;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void d() {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void e() {
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final boolean g(g r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceDataProcessEntity");
        return true;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final String getUploadId() {
        return "";
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void b() {
        this.f409353a = "";
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void onDestroy() {
        this.f409353a = "";
    }

    public b() {
        this.f409353a = "";
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final String a() {
        return this.f409353a;
    }

    @Override // com.ss.android.lark.audio.voiceinput.processor.d
    public final void f(ProcessType r100) {
        Intrinsics.checkNotNullParameter(r100, "processType");
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
        this.f409353a = UUID.randomUUID().toString();
    }
}

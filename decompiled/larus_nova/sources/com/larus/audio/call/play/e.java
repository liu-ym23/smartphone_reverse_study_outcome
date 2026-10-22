package com.larus.audio.call.play;

import com.larus.audio.call.play.abs.TtsPlayEndType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class e implements u68.a.b {
    public e() {
    }

    @Override // u68.a.b
    public void a() {
    }

    @Override // u68.a.b
    public void b(Map<String, String> r100) {
    }

    @Override // u68.a.b
    public void c() {
    }

    @Override // u68.a.b
    public void d(h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // u68.a.b
    public void e(boolean r100) {
    }

    @Override // u68.a.b
    public void f(TtsPlayEndType r100) {
        Intrinsics.checkNotNullParameter(r100, "endType");
    }

    @Override // u68.a.b
    public void g(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audio");
    }

    @Override // u68.a.b
    public void i(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audio");
    }

    @Override // u68.a.b
    public void onPaused() {
    }

    @Override // u68.a.b
    public void onPlayComplete() {
    }

    @Override // u68.a.b
    public void onResume() {
    }

    public void h(String r100) {
        onPlayComplete();
    }
}

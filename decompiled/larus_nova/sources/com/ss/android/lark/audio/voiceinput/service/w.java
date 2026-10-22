package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.lark.pb.im.v1.PushSpeechRecognitionEvent;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class w implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f409435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f409436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f409437c;

    public interface a {
        void a(String r100, PushSpeechRecognitionEvent r101);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.audio.voiceinput.service.s] */
    @Inject
    public w(p r100) {
        this.f409435a = new CopyOnWriteArrayList();
        this.f409436b = new s();
        this.f409437c = r100;
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.o
    public final void M3(a r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f409435a).contains(r100) == false) goto L7;
        return;
    L7:
        com.ss.android.lark.sdk.f.a(this.f409435a, r100, new r(this));
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.o
    public final void x4(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<a> r101 = this.f409435a;
        final p r102 = this.f409437c;
        Objects.requireNonNull(r102);
        com.ss.android.lark.sdk.f.b(r101, r100, new t(r102));
    }
}

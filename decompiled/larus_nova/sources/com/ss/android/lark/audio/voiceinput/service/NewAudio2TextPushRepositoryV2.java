package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionResponse;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class NewAudio2TextPushRepositoryV2 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f409403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f409404c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.m
    public final void a() {
        Disposable r100 = this.f409404c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public NewAudio2TextPushRepositoryV2(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f409402a = r100;
        this.f409403b = r101;
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.m
    public final void b(final Function1<? super SendSpeechRecognitionResponse, Unit> r100, final Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f409404c = com.ss.android.lark.audio.voiceinput.utils.c.b("NewAudio2TextPushRepositoryV2", this.f409402a, new NewAudio2TextPushRepositoryV2$subscribeAudioRecognition$1(this, r100, r101));
    }
}

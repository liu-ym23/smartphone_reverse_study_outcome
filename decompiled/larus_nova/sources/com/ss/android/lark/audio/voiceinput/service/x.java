package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class x implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f409439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f409440c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.p
    public final void b() {
        Disposable r100 = this.f409440c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public x(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f409438a = r100;
        this.f409439b = r101;
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.p
    public final void a(final u r100, final s r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f409440c = com.ss.android.lark.audio.voiceinput.utils.c.b("SpeechRecognitionEventPushRepoV2", this.f409438a, new SpeechRecognitionEventPushRepoV2$subscribeSpeechRecognitionStatusPush$1(this, r100, r101));
    }
}

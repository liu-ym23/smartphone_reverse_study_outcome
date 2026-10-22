package com.ss.android.lark.audio.voiceinput.service;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class NewAudio2TextPush implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f409396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<n> f409398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Throwable, Unit> f409399d;

    public static final class a implements com.ss.android.lark.sdk.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewAudio2TextPush f409400a;

        public a(NewAudio2TextPush r100) {
            this.f409400a = r100;
        }

        @Override // com.ss.android.lark.sdk.f.a
        public final void a() {
            this.f409400a.f409396a.a();
        }
    }

    @Inject
    public NewAudio2TextPush(m r100) {
        Intrinsics.checkNotNullParameter(r100, "pushRepo");
        this.f409396a = r100;
        this.f409397b = "NewAudio2TextPush";
        this.f409398c = new CopyOnWriteArrayList();
        this.f409399d = new NewAudio2TextPush$onError$1(this);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.l
    public final void Ed(n r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.b(this.f409398c, r100, new a(this));
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.l
    public final void H2(n r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f409398c.contains(r100) == false) goto L7;
        return;
    L7:
        com.ss.android.lark.sdk.f.a(this.f409398c, r100, new NewAudio2TextPush$addListener$1(this));
    }
}

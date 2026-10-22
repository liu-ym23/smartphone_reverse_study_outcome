package com.larus.kmp.voice_setting.voice.bridge;

import com.larus.kmp.voice_setting.platform.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonVoiceDoubleTabPlatformDelegate f351856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f351857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f351858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f351859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f351860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f351861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f351862g;

    @Override // com.larus.kmp.voice_setting.platform.p0
    public final void onBegin() {
        this.f351856a.n(this.f351857b);
        this.f351858c.invoke();
    }

    @Override // com.larus.kmp.voice_setting.platform.p0
    public final void onEnd() {
        this.f351856a.n(this.f351859d);
        this.f351860e.invoke();
    }

    @Override // com.larus.kmp.voice_setting.platform.p0
    public final void onError() {
        this.f351856a.n(this.f351861f);
        this.f351862g.invoke();
    }

    public b(CommonVoiceDoubleTabPlatformDelegate r100, String r101, Function0<Unit> r102, String r103, Function0<Unit> r104, String r105, Function0<Unit> r106) {
        this.f351856a = r100;
        this.f351857b = r101;
        this.f351858c = r102;
        this.f351859d = r103;
        this.f351860e = r104;
        this.f351861f = r105;
        this.f351862g = r106;
    }
}

package com.larus.init.task;

import com.larus.audio.controller.GlobalAudioStateEnum;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 implements o78.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f351435a;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(Function1<? super Boolean, Unit> r100) {
        this.f351435a = r100;
    }

    @Override // o78.b
    public final void c(String r100, Map r101) {
        o78.b.a.a(r100);
    }

    @Override // o78.b
    public final void a(String r100, GlobalAudioStateEnum r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "playbackState");
        Function1<Boolean, Unit> r103 = this.f351435a;
        if (r101 != GlobalAudioStateEnum.PLAYING) goto L5;
        boolean r104 = true;
    L6:
        r103.invoke(Boolean.valueOf(r104));
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // o78.b
    public final void b(String r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f351435a.invoke(Boolean.FALSE);
    }

    @Override // o78.b
    public final void d(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "uniId");
        this.f351435a.invoke(Boolean.TRUE);
    }
}

package com.ss.android.lark.keyboard.plugin.tool.voice;

import android.content.Context;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements AudioRecordMutexController.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f430059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f430060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AudioRecordMutexController f430061c;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.AudioRecordMutexController.b
    public final void a(Scene r100, MediaType r101) {
        Intrinsics.checkNotNullParameter(r100, "byScene");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 == Scene.VC_MEETING) goto L5;
        return;
    L5:
        if (r101 != MediaType.Audio_Record) goto L9;
        UICallbackExecutor.execute(new a(this.f430059a, this.f430060b, this.f430061c, this));
        return;
    }

    public b(Function0<Unit> r100, Context r101, AudioRecordMutexController r102) {
        this.f430059a = r100;
        this.f430060b = r101;
        this.f430061c = r102;
    }
}

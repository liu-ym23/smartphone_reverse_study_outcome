package com.bytedance.salamander.adapter;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "", ExifInterface.GPS_DIRECTION_TRUE, "isCancelled", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncExec$workloadWrapper$1 extends Lambda implements Function1<Boolean, Object> {
    final /* synthetic */ Function1<Object, Unit> $callback;
    final /* synthetic */ boolean $isInMainThread;
    final /* synthetic */ Function0<Object> $workload;
    final /* synthetic */ o this$0;

    public SLKVStorage$asyncExec$workloadWrapper$1(o r100, Function0<Object> r101, boolean r102, Function1<Object, Unit> r103) {
        this.this$0 = r100;
        this.$workload = r101;
        this.$isInMainThread = r102;
        this.$callback = r103;
        super(1);
    }

    public final Object invoke(boolean r100) {
        if (r100 == false) goto L5;
        return null;
    L5:
        this.this$0.f267795b.a();
        final Object r101 = this.$workload.invoke();
        this.this$0.f267795b.b();
        if (this.$isInMainThread == false) goto L8;
        int r102 = r.f267796a;
        final Function1<Object, Unit> r103 = this.$callback;
        Function1<Boolean, Object> r104 = new AnonymousClass1(r103, r101);
        Intrinsics.checkNotNullParameter(r104, "workload");
        r.a.a(r104, i.f267784c, AudioStats.AUDIO_AMPLITUDE_NONE);
    L9:
        return null;
    L8:
        this.$callback.invoke(r101);
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100) {
        return invoke(r100.booleanValue());
    }
}

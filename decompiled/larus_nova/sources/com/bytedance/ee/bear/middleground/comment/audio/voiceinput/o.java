package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ViewGroup> f230498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<p> f230499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<p, Boolean> f230500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<p, CharSequence, Unit> f230501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Boolean, Unit> f230502e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f230498a, r101.f230498a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f230499b, r101.f230499b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f230500c, r101.f230500c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f230501d, r101.f230501d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f230502e, r101.f230502e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f230498a.hashCode() * 31) + this.f230499b.hashCode()) * 31) + this.f230500c.hashCode()) * 31) + this.f230501d.hashCode()) * 31;
        Function1<Boolean, Unit> r101 = this.f230502e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CommentVoiceSimpleInputContext(overlayContainerProvider=" + this.f230498a + ", targetSnapshotProvider=" + this.f230499b + ", targetValidator=" + this.f230500c + ", onFinalText=" + this.f230501d + ", onVoiceRecordingStateChanged=" + this.f230502e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function0<? extends ViewGroup> r100, Function0<p> r101, Function1<? super p, Boolean> r102, Function2<? super p, ? super CharSequence, Unit> r103, Function1<? super Boolean, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "overlayContainerProvider");
        Intrinsics.checkNotNullParameter(r101, "targetSnapshotProvider");
        Intrinsics.checkNotNullParameter(r102, "targetValidator");
        Intrinsics.checkNotNullParameter(r103, "onFinalText");
        this.f230498a = r100;
        this.f230499b = r101;
        this.f230500c = r102;
        this.f230501d = r103;
        this.f230502e = r104;
    }
}

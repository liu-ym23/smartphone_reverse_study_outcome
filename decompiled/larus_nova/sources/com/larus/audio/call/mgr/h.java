package com.larus.audio.call.mgr;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s68.n;
import s68.o;

/* JADX INFO: loaded from: classes24.dex */
public final class h<S> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f289261c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f289262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<n<S>, Unit> f289263b;

    public static final class a {
        public static h a(Object r100) {
            Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
            return new h(r100, new o());
        }
    }

    static {
    }

    public h() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Object r100, Function1 r101) {
        this.f289262a = r100;
        this.f289263b = r101;
    }
}

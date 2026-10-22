package dvb;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f470232a = null;

    static {
        f470232a = new b();
    }

    public b() {
    }

    @Override // dvb.a
    public final void a() {
    }

    @Override // dvb.a
    public final void b() {
    }

    @Override // dvb.a
    public final Object c() {
        Result.Companion r100 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new UnsupportedOperationException("hardware file sync is unsupported")));
    }
}

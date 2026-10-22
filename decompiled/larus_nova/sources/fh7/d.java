package fh7;

import com.bytedance.ruler.utils.h;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IStoreRepo f477065a;

    public final Map<String, ?> a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        return this.f477065a.getAll();
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public d(IStoreRepo r100) {
        this.f477065a = r100;
    }

    @Override // com.bytedance.ruler.utils.h
    public final String get(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        return this.f477065a.getString(r100, null);
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    @Override // com.bytedance.ruler.utils.h
    public final void remove(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        this.f477065a.remove(r100);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.ruler.utils.h
    public final void c(String r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        this.f477065a.putString(r100, r101);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}

package gx5;

import com.bytedance.forest.pollyfill.ttnet.ForestNetAPI;
import com.bytedance.retrofit2.Call;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends ForestNetAPI.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Call<?> f483118d;

    @Override // com.bytedance.forest.pollyfill.ttnet.ForestNetAPI.a
    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        Call<?> r101 = this.f483118d;     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        r101.cancel();     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
        return;
    L5:
        r102 = null;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public b(String r100, Map<String, String> r101) {
        super(r100, r101);
    }
}

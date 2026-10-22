package ex;

import android.content.Context;
import com.bytedance.android.annie.lynx.service.latch.LatchScriptContentLoader;
import com.bytedance.android.latch.LatchProcessOptions;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends ix.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super Context, ? super com.bytedance.ies.web.jsbridge2.b, ? super LatchProcessOptions, ? extends a> f474620f;

    public interface a {
        void release();
    }

    public b(LatchScriptContentLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "scriptContentLoader");
        super(r100);
        this.f474620f = fx.a.f479050b;
    }
}

package z36;

import android.content.Context;
import com.bytedance.ies.bullet.core.kit.bridge.c;
import kotlin.jvm.internal.Intrinsics;
import m16.b;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends c {
    public final Context getContext() {
        return (Context) this.f246545a.c(Context.class);
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
    }
}

package kx;

import android.content.Context;
import com.bytedance.android.annie.business.latch.AnnieBusinessLatchScriptContentLoader;
import com.bytedance.android.latch.LatchProcessOptions;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.Map;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends ix.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super Context, ? super String, ? super LatchProcessOptions, ? extends a> f506527f;

    public interface a {

        /* JADX INFO: renamed from: kx.b$a$a, reason: collision with other inner class name */
        public interface InterfaceC6625a {
            void onFail(String r100);

            void onSuccess(Map<String, ?> r100);
        }

        void a(String r100, JavaOnlyMap r101, InterfaceC6625a r102);

        void release();
    }

    public b(AnnieBusinessLatchScriptContentLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "scriptContentLoader");
        super(r100);
        this.f506527f = lx.b.f511104a;
    }
}

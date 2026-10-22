package u32;

import android.view.View;
import com.bytedance.android.livesdk.message.model.ii;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f548565a;

    public interface a {
        View a();

        View b();

        String c();

        List<Pair<String, String>> d();

        n e();

        View f();

        View g();

        void setContentDescription(String r100);
    }

    public abstract View d();

    public abstract void e();

    public abstract void f(ii r100);

    public abstract void g(long r100);

    public d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        this.f548565a = r100;
    }
}

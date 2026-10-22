package jh;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f499065a;

    public final void b() {
        int r100 = ECSdk.f48106a;
        cj.a r101 = (cj.a) ECSdk.a(cj.a.class);
        if (r101 == null) goto L6;
        String r102 = this.f499065a.f45192a;
        r101.start();
        return;
    }

    @Override // jh.a
    public final void stop() {
        int r100 = ECSdk.f48106a;
        cj.a r101 = (cj.a) ECSdk.a(cj.a.class);
        if (r101 == null) goto L6;
        String r102 = this.f499065a.f45192a;
        r101.stop();
        return;
    }

    public c(q r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorSceneWrapper");
        this.f499065a = r100;
    }

    public final void c(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        int r101 = ECSdk.f48106a;
        cj.a r102 = (cj.a) ECSdk.a(cj.a.class);
        if (r102 == null) goto L6;
        String r103 = this.f499065a.f45192a;
        r102.b();
        return;
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = ECSdk.f48106a;
        cj.a r103 = (cj.a) ECSdk.a(cj.a.class);
        if (r103 == null) goto L6;
        String r104 = this.f499065a.f45192a;
        r103.c();
        return;
    }
}

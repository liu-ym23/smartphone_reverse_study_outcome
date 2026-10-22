package ilb;

import android.graphics.Region;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Region f490349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f490350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f490351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f490352d;

    public a() {
        this(0);
    }

    public a(int r100) {
        Region r101 = new Region();
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_REGION);
        this.f490349a = r101;
        this.f490350b = false;
        this.f490351c = false;
        this.f490352d = false;
    }
}

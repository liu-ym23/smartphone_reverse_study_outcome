package dx7;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<String> f470433a;

    public final boolean a() {
        return this.f470433a.hasNext();
    }

    public final String b() {
        return this.f470433a.next();
    }

    public d(Iterator<String> r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f470433a = r100;
    }
}

package com.ss.android.ainote;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes34.dex */
public final class AINoteImageDownloadCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f406509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<String> f406510b;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public AINoteImageDownloadCoordinator() {
        this.f406509a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f406510b = new LinkedHashSet();
    }

    public final void a(final String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "imageId");
        if (r101 != null) goto L6;
        CollectionsKt.removeAll(this.f406510b, new AINoteImageDownloadCoordinator$cancel$1(r100));
        return;
    L6:
        LinkedHashSet<String> r102 = this.f406510b;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append(':');
        if (r101.booleanValue() == false) goto L9;
        String r104 = PlayerResolution.SDKKEY.ORIGIN;
    L10:
        r103.append(r104);
        r102.remove(r103.toString());
        return;
    L9:
        r104 = "thumb";
        goto L10
    }
}

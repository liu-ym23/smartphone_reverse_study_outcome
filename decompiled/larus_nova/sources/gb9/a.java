package gb9;

import android.content.Context;
import android.os.Bundle;
import com.larus.home.api.main.IAICreationSidebarLauncher;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f480735a = 0;

    static {
    }

    public static boolean a(Context r100, Bundle r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        IAICreationSidebarLauncher r103 = (IAICreationSidebarLauncher) ServiceManager.get().getService(IAICreationSidebarLauncher.class);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.a(r100, r101, r102);
    }
}

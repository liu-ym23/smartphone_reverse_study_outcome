package cpb;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.ss.android.lark.language.api.LocaleWatchScene;
import com.ss.android.lark.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f464732a;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public b(Application r100) {
        this.f464732a = r100;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        int r101 = d.f464734a;
        d.a.c(LocaleWatchScene.APPLICATION_CONFIGURE_CHANGE, this.f464732a).a(LogLevel.INFO);
    }
}

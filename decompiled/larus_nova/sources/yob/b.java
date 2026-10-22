package yob;

import android.app.Application;
import com.ss.android.lark.language.api.LocaleWatchScene;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements zob.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f568689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f568690b;

    public b(d r100, Application r101) {
        this.f568690b = r100;
        this.f568689a = r101;
    }

    @Override // zob.b
    public final void a(Locale r100, Locale r101) {
        int r102 = com.ss.android.lark.language.service.impl.a.f431092f;
        com.ss.android.lark.language.service.impl.a.b.f431098a.l(this.f568689a);
        this.f568690b.getClass();
        Application r103 = this.f568689a;
        Intrinsics.checkNotNullParameter(LocaleWatchScene.CHANGE_LOCALE_DONE, "localeScene");
        Intrinsics.checkNotNullParameter(r103, "application");
        int r104 = cpb.c.f464733a;
        cpb.c.a.a(LocaleWatchScene.CHANGE_LOCALE_DONE, r103, r101, r100);
    }
}

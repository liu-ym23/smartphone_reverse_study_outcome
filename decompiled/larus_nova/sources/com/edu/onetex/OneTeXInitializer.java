package com.edu.onetex;

import android.app.Activity;
import android.app.Application;
import android.provider.Settings;
import at7.b;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.larus.utils.logger.FLogger;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/edu/onetex/OneTeXInitializer;", "", "()V", "application", "Landroid/app/Application;", "getApplication$onetex_release", "()Landroid/app/Application;", "setApplication$onetex_release", "(Landroid/app/Application;)V", "init", "", "registerAppStatusListener", "updateTextContrastMode", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class OneTeXInitializer {
    public static final OneTeXInitializer INSTANCE = null;
    private static Application application;

    public static final class a implements at7.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f273697a;

        @Override // at7.a.b
        public final void onBackground() {
        }

        public a(Application r100) {
            this.f273697a = r100;
        }

        @Override // at7.a.b
        public final void onForeground(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            OneTeXInitializer.access$updateTextContrastMode(OneTeXInitializer.INSTANCE, this.f273697a);
        }
    }

    private OneTeXInitializer() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        INSTANCE = new OneTeXInitializer();
    }

    public final Application getApplication$onetex_release() {
        return application;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_edu_onetex_OneTeXInitializer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @JvmStatic
    public static final void init(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        application = r100;
        INVOKESTATIC_com_edu_onetex_OneTeXInitializer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("onetex");
        LaTeXEngine.INSTANCE.init();
        OneTeXInitializer r101 = INSTANCE;
        r101.registerAppStatusListener(r100);
        r101.updateTextContrastMode(r100);
    }

    private final void registerAppStatusListener(Application r100) {
        LinkedList<Activity> r101 = at7.a.f16265a;
        Intrinsics.checkNotNullParameter(r100, "application");
        r100.registerActivityLifecycleCallbacks(new at7.a.C0225a());
        a r102 = new a(r100);
        Intrinsics.checkNotNullParameter(r102, "statusListener");
        LinkedList<at7.a.b> r103 = at7.a.f16266b;
        if (r103.contains(r102) == true) goto L7;
        r103.add(r102);
        return;
    }

    private final void updateTextContrastMode(Application r100) {
        Graphics2D.Companion r101 = Graphics2D.Companion;
        int r102 = b.f16269a;
        boolean r103 = false;
        if (r100 != null) goto L12;
    L10:
        r101.setTextContrastMode(r103);
        return;
    L12:
        if (Settings.Secure.getInt(r100.getContentResolver(), "high_text_contrast_enabled", 0) != 1) goto L10;
        r103 = true;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public final void setApplication$onetex_release(Application r100) {
        application = r100;
    }

    public static final /* synthetic */ void access$updateTextContrastMode(OneTeXInitializer r100, Application r101) {
        r100.updateTextContrastMode(r101);
    }
}

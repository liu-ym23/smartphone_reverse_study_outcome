package com.larus.common_ui.dbx.theme;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.n0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f327085a;

    /* JADX INFO: renamed from: com.larus.common_ui.dbx.theme.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4184a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f327086a = null;

        static {
            int[] r100 = new int[DbxTheme.Variant.values().length];
            r100[DbxTheme.Variant.LIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DbxTheme.Variant.DARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f327086a = r100;
        }
    }

    public static final Context c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DbxTheme r101 = DbxTheme.f327081a;
        ContextThemeWrapper r102 = new ContextThemeWrapper(r100, R.style.Larus_DbxTheme_BaseAttr);
        Resources.Theme r103 = r102.getTheme();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.applyStyle(R.style.Larus_DbxTheme_Dark, true);
        a(r103, Boolean.TRUE);
        return r102;
    }

    public static final void a(Resources.Theme r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DbxTheme r102 = DbxTheme.f327081a;
        boolean r103 = false;
        if (DbxTheme.f327082b != null) goto L21;
    L6:
        if (r103 == true) goto L8;
        return;
    L8:
        if (r101 != null) goto L11;
        DbxTheme r104 = DbxTheme.f327081a;
        int r105 = R.style.Larus_DbxThemeOverlay_Business;
    L16:
        r100.applyStyle(r105, true);
        return;
    L11:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L14;
        DbxTheme r106 = DbxTheme.f327081a;
        r105 = R.style.Larus_DbxThemeOverlay_Business_Light;
        goto L16
    L14:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L19;
        DbxTheme r107 = DbxTheme.f327081a;
        r105 = R.style.Larus_DbxThemeOverlay_Business_Dark;
        goto L16
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        r103 = n0.f365775a.b();     // Catch: Exception -> L20
        goto L6
    }

    public static final int b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r102 = d(r100, r101);
        if (r102 != null) goto L5;
        Context r103 = f327085a;
        if (r103 != null) goto L17;
        DbxTheme r104 = DbxTheme.f327081a;
        monitor-enter(r104);
        Context r105 = f327085a;     // Catch: Throwable -> L22
        if (r105 != null) goto L15;
        Application r106 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r106, "<this>");     // Catch: Throwable -> L22
        ContextThemeWrapper r107 = new ContextThemeWrapper(r106, R.style.Larus_DbxTheme_BaseAttr);     // Catch: Throwable -> L22
        a(r107.getTheme(), null);     // Catch: Throwable -> L22
        f327085a = r107;     // Catch: Throwable -> L22
        r105 = r107;
    L15:
        monitor-exit(r104);
        r103 = r105;
    L22:
        th = move-exception;
        throw th;
    L17:
        Integer r108 = d(r103, r101);
        if (r108 != null) goto L27;
        return 0;
    L27:
        return r108.intValue();
    L5:
        return r102.intValue();
    }

    public static final Integer d(Context r100, int r101) {
        TypedValue r102 = new TypedValue();
        Resources.Theme r103 = r100.getTheme();     // Catch: Exception -> L25
        boolean r104 = false;
        if (r103 != null) goto L6;
    L8:
        if (r104 == true) goto L10;
        return null;
    L10:
        int r105 = r102.resourceId;     // Catch: Exception -> L25
        if (r105 == 0) goto L14;
        Integer r106 = Integer.valueOf(ContextCompat.getColor(r100, r105));     // Catch: Exception -> L25
    L24:
        return r106;
    L14:
        int r107 = r102.type;     // Catch: Exception -> L25
        if (r107 != 28) goto L17;
    L22:
        r106 = Integer.valueOf(r102.data);     // Catch: Exception -> L25
        goto L24
    L17:
        if (r107 == 29) goto L22;
        if (r107 == 30) goto L22;
        if (r107 == 31) goto L22;
        return null;
    L6:
        if (r103.resolveAttribute(r101, r102, true) != true) goto L8;
        r104 = true;
        goto L8
    L28:
        return null;
    }
}

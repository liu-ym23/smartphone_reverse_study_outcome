package com.larus.drive.sdk.impl.utils.file;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.drive.sdk.api.file.download.DriveDownloadStatus;
import com.larus.drive.sdk.impl.view.operation.download.DriveDownloadDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DriveDownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f342019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f342020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f342021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f342022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static WeakReference<FragmentActivity> f342023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static WeakReference<DriveDownloadDialog> f342024f;

    public DriveDownloadManager() {
    }

    static {
        f342019a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    public static final void a() {
        WeakReference<FragmentActivity> r100 = f342023e;
        DriveDownloadDialog r101 = null;
        if (r100 == null) goto L6;
        FragmentActivity r102 = r100.get();
        if (r102 == null) goto L6;
    L13:
        if (r102.getSupportFragmentManager().isStateSaved() == true) goto L33;
        Fragment r103 = r102.getSupportFragmentManager().findFragmentByTag("DriveDownloadManager");
        if ((r103 instanceof DriveDownloadDialog) == false) goto L18;
        r101 = (DriveDownloadDialog) r103;
    L18:
        if (r101 != null) goto L24;
        r101 = new DriveDownloadDialog();
        FragmentManager r104 = r102.getSupportFragmentManager();
        LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r101, "DriveDownloadManager", r105);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r101, r105) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L23:
        r101.show(r104, "DriveDownloadManager");
    L24:
        Intrinsics.checkNotNullParameter(r101, "dialog");
        f342024f = new WeakReference(r101);
        if (f342022d == false) goto L31;
        r101.T90(f342021c);
        return;
    L31:
        return;
    L33:
        return;
    L6:
        Activity r106 = AppHost.f326268a.a().getCurrentActivity();
        if ((r106 instanceof FragmentActivity) == false) goto L9;
        r102 = (FragmentActivity) r106;
    L10:
        if (r102 != null) goto L13;
        return;
    L9:
        r102 = null;
        goto L10
    }

    public static void b(FragmentActivity r100, String r101) {
        if (r100 == null) goto L5;
        f342023e = new WeakReference(r100);
    L5:
        BuildersKt.launch$default(f342019a, null, null, new DriveDownloadManager$onDownloadFailed$1(r101, null), 3, null);
    }

    public static void c(FragmentActivity r110, String r111, DriveDownloadStatus r112, long r113, long r114) {
        Intrinsics.checkNotNullParameter(r112, "status");
        if (r110 == null) goto L6;
        f342023e = new WeakReference(r110);
    L6:
        BuildersKt.launch$default(f342019a, null, null, new DriveDownloadManager$onDownloadProgress$1(r111, r112, r114, r113, null), 3, null);
    }
}

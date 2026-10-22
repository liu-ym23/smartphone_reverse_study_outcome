package com.bytedance.ee.bear.office.common.upload;

import android.webkit.MimeTypeMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.downloadlib.constants.MimeType;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f235406a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235407a = null;

        static {
            int[] r100 = new int[OfficeUploadActionType.values().length];
            r100[OfficeUploadActionType.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[OfficeUploadActionType.FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f235407a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f235408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FileSelectConfig f235409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f235410c;

        public c(o r100, FileSelectConfig r101, Function0<Unit> r102) {
            this.f235408a = r100;
            this.f235409b = r101;
            this.f235410c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f235408a.c(this.f235409b, this.f235410c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public o(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f235406a = r100;
    }

    public static String b(String r100) {
        String r101 = StringsKt.substringAfterLast(r100, '.', "").toLowerCase(Locale.ROOT);
        if (StringsKt.isBlank(r101) == false) goto L5;
        return null;
    L5:
        String r102 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r101);
        if (r102 != null) goto L26;
        int r103 = r101.hashCode();
        if (r103 == 108308) goto L22;
        if (r103 == 3198679) goto L18;
        if (r103 == 3198682) goto L15;
        return null;
    L15:
        if (r101.equals("heif") == true) goto L28;
        return null;
    L28:
        return "image/".concat(r101);
    L18:
        if (r101.equals("heic") == true) goto L28;
        return null;
    L22:
        if (r101.equals("mov") == false) goto L32;
        return MimeType.MOV;
    L32:
        return null;
    L26:
        return r102;
    }

    public static String d(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return "empty";
    L12:
        return "hash=" + r100.hashCode() + ", length=" + r100.length() + ", ext=" + StringsKt.substringAfterLast(r100, '.', "");
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public final void c(FileSelectConfig r100, Function0<Unit> r101) {
        FragmentManager r102 = this.f235406a.getSupportFragmentManager();
        Fragment r103 = r102.findFragmentByTag("OfficeUploadFileSelector");
        if (r103 != null) goto L5;
    L26:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        int r105 = com.bytedance.ee.bear.fileselector.d.f226786a;     // Catch: Throwable -> L10
        Object r106 = Result.m9449constructorimpl(com.bytedance.ee.bear.fileselector.d.a.b(this.f235406a, r100));     // Catch: Throwable -> L10
    L12:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L16;
        tt5.a.l("OfficeUploadFileSelector", "file selector fragment instantiate failed", r107);
        r106 = null;
    L16:
        Fragment r108 = (Fragment) r106;
        if (r108 != null) goto L20;
        tt5.a.k("OfficeUploadFileSelector", "file selector fragment invalid");
        r101.invoke();
        return;
    L20:
        FragmentTransaction r109 = r102.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r109, r108, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "OfficeUploadFileSelector", 0) == true) goto L24;
        r109 = r109.add(r108, "OfficeUploadFileSelector");
    L24:
        r109.commitAllowingStateLoss();
        tt5.a.h("OfficeUploadFileSelector", "file selector fragment committed");
        return;
    L10:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        if (r103.isAdded() == false) goto L26;
        tt5.a.h("OfficeUploadFileSelector", "dismiss existing file selector before reopen");
        int r111 = com.bytedance.ee.bear.fileselector.d.f226786a;
        com.bytedance.ee.bear.fileselector.d.a.a(r102, "OfficeUploadFileSelector");
        com.bytedance.ee.util.ui.j.c(new c(this, r100, r101));
    }

    public static final OfficeSpaceUploadSelection a(o r100, String r101, boolean r102, String r110) {
        r100.getClass();
        Long r103 = null;
        if (r102 == false) goto L10;
        String r104 = StringsKt.substringAfterLast$default(r101, '/', null, 2, null);
        if ((!StringsKt.isBlank(r104)) == true) goto L8;
        r104 = null;
    L8:
        if (r104 == null) goto L15;
    L16:
        String r105 = r104;
        if (r102 == true) goto L25;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101);
        if (r106.exists() == true) goto L23;
        r106 = null;
    L23:
        if (r106 == null) goto L25;
        r103 = Long.valueOf(r106.length());
    L25:
        Long r107 = r103;
        if (r110 != null) goto L28;
        r110 = b(r105);
    L28:
        String r108 = r110;
        tt5.a.h("OfficeUploadFileSelector", "build selection, pointer=" + d(r101) + ", isFileUseUri=" + r102 + ", nameLength=" + r105.length() + ", size=" + r107 + ", mime=" + r108);
        return new OfficeSpaceUploadSelection(r101, r102, r105, r108, r107);
    L15:
        r104 = "";
        goto L16
    L10:
        r104 = new PolarisFileWrapper(r101).getName();
        Intrinsics.checkNotNull(r104);
        if ((!StringsKt.isBlank(r104)) == true) goto L14;
        r104 = null;
    L14:
        if (r104 != null) goto L16;
        goto L15
    }
}

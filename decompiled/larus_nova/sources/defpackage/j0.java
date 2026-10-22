package defpackage;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.e;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.impl.g;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonLoadDialogFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v98.m;
import v98.r;

/* JADX INFO: loaded from: classes42.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f496744a = 0;

    public static final class a {
        public a() {
        }

        public static final List a(MediaMetadata r110) {
            int r100 = j0.f496744a;
            int r101 = j.f292609a;
            if (j.c(r110.getMediaType()) == false) goto L49;
            String r102 = r110.getDownloadFilePath();
            if (r102 != null) goto L8;
        L11:
            boolean r103 = true;
        L12:
            if (r103 == false) goto L14;
        L16:
            e.f292493a.getClass();
            List r104 = c(e.c());
            ArrayList r105 = new ArrayList();
            Iterator r106 = r104.iterator();
        L18:
            if (r106.hasNext() == false) goto L37;
            Object r107 = r106.next();
            File r108 = (File) r107;
            if (r108.isFile() == true) goto L22;
        L34:
            boolean r109 = false;
        L35:
            if (r109 == false) goto L18;
            r105.add(r107);
            goto L18
        L22:
            if (StringsKt.equals(FilesKt.getExtension(r108), "mp4", true) == false) goto L34;
            int r111 = j0.f496744a;
            String r112 = r108.getName();
            Intrinsics.checkNotNull(r112);
            if (StringsKt.contains$default(r112, String.valueOf(r110.getMediaId()), false, 2, null) == false) goto L26;
        L31:
            boolean r113 = true;
        L32:
            if (r113 == false) goto L34;
            r109 = true;
            goto L35
        L26:
            if (StringsKt.contains$default(r112, r110.getUniqId(), false, 2, null) == true) goto L31;
            if (StringsKt.contains$default(r112, String.valueOf(r110.getCreateTime()), false, 2, null) == true) goto L31;
            r113 = false;
            goto L32
        L37:
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r115 = r105.iterator();
        L39:
            if (r115.hasNext() == false) goto L42;
            File r116 = (File) r115.next();
            FLogger.f375446a.i("HardwareMediaDownloader", "Found fallback source video for mediaId " + r110.getMediaId() + ": " + r116.getAbsolutePath());
            r114.add(r116.getAbsolutePath());
            goto L39
        L42:
            return r114;
        L14:
            if (new PolarisFileWrapper(r102).exists() == false) goto L16;
            return CollectionsKt.emptyList();
        L8:
            if (StringsKt.isBlank(r102) == true) goto L11;
            r103 = false;
            goto L12
        L49:
            return CollectionsKt.emptyList();
        }

        public static List c(File r100) {
            if (r100.exists() == true) goto L7;
            return CollectionsKt.emptyList();
        L7:
            if (r100.isFile() == true) goto L9;
            File[] r101 = r100.listFiles();
            if (r101 == null) goto L20;
            ArrayList r102 = new ArrayList();
            int r103 = r101.length;
            int r104 = 0;
        L13:
            if (r104 >= r103) goto L24;
            File r105 = r101[r104];
            if (r105.isDirectory() == false) goto L17;
            List r106 = CollectionsKt.listOf(r105);
            int r107 = j0.f496744a;
            Intrinsics.checkNotNull(r105);
            List r108 = CollectionsKt.plus(r106, c(r105));
        L18:
            CollectionsKt.addAll(r102, r108);
            r104 = r104 + 1;
            goto L13
        L17:
            r108 = CollectionsKt.listOf(r105);
            goto L18
        L24:
            return r102;
        L20:
            return CollectionsKt.emptyList();
        L9:
            return CollectionsKt.listOf(r100);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [i0, kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r12v4, types: [T, kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r1v13, types: [y0] */
        public static final void b(Context r110, List r111, final Function1 r112) {
            int r100 = j0.f496744a;
            CoroutineScope r101 = c1.f21994a;
            String r102 = "media_dump_" + System.currentTimeMillis() + ".zip";
            final ?? r103 = new i0(r112);
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "filePaths");
            Intrinsics.checkNotNullParameter(r102, "zipFileName");
        L17:
            e = move-exception;
            FLogger.f375446a.e("ZipShareUtils", "Error creating and sharing ZIP: " + e.getMessage(), e);
            r103.invoke(Boolean.FALSE);
            return;
        L4:
            if (r111.isEmpty() == false) goto L6;
            Toast.makeText(AppHost.f326268a.getApplication(), "No dumped files to share", 0).show();     // Catch: Exception -> L17
            return;
        L6:
            final Ref.ObjectRef r113 = new Ref.ObjectRef();     // Catch: Exception -> L17
            if (m.a(r111) < 80.0d) goto L9;
            DialogFragment r104 = c1.a.c(r110, new y0(r113, r103));     // Catch: Exception -> L17
        L10:
            DialogFragment r105 = r104;
            FragmentManager r106 = ((FragmentActivity) r110).getSupportFragmentManager();     // Catch: Exception -> L17
            LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L17
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, null, r107);     // Catch: Exception -> L17
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r105, r107) == false) goto L21;
        L15:
            r113.element = BuildersKt.launch$default(c1.f21994a, null, null, new ZipShareUtils$Companion$createZipAndShareWithCallback$1(r111, r102, r105, r110, r103, null), 3, null);     // Catch: Exception -> L17
            return;
        L21:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L14:
            r105.show(r106, null);     // Catch: Exception -> L17
            goto L15
        L9:
            r104 = new CommonLoadDialogFragment();     // Catch: Exception -> L17
            goto L10
        }

        @Deprecated(message = "No longer needed, files are managed by MediaMetadata")
        public static void d(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "fileName");
            Intrinsics.checkNotNullParameter(r102, "mediaId");
            FLogger.f375446a.d("HardwareMediaDownloader", "dumpPackFile called but no longer needed for " + r102 + ": " + r101 + ", " + r100);
        }

        public static void e(Context r100, List r101, g r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "list");
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HardwareMediaDownloaderExtended$Companion$shareSelectGalleryFilesAsZipWithCallback$1(r101, r102, r100, null), 3, null);
        }
    }

    static {
        new a();
        r.f553837a.f();
    }
}

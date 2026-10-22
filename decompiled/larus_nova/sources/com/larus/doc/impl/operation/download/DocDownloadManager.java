package com.larus.doc.impl.operation.download;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.FileExportType;
import com.larus.doc.impl.DocumentApi;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
public final class DocDownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocDownloadManager f331343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f331344b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Job f331345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Boolean> f331346d = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331347a = null;

        static {
            int[] r100 = new int[FileExportType.values().length];
            r100[FileExportType.word.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FileExportType.pdf.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FileExportType.txt.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f331347a = r100;
        }
    }

    public DocDownloadManager() {
    }

    static {
        f331343a = new DocDownloadManager();
        f331344b = new j();
        f331346d = new LinkedHashMap();
    }

    public static String e() {
        return "document_" + new SimpleDateFormat("MMdd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static final String a(DocDownloadManager r100) {
        r100.getClass();
        File r101 = AppHost.f326268a.getApplication().getExternalFilesDir(null);
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        String r103 = File.separator;
        r102.append(r103);
        r102.append("export");
        r102.append(r103);
        return r102.toString();
    }

    public static String g(FileExportType r100) {
        int r101 = a.f331347a[r100.ordinal()];
        if (r101 != 1) goto L5;
    L11:
        return DocumentType.DOCX_NAME;
    L5:
        if (r101 != 2) goto L7;
        return ExportFileExtension.PDF;
    L7:
        if (r101 != 3) goto L11;
        return "txt";
    }

    public static String f(Context r100, Uri r101) {
        if (r101 != null) goto L5;
        return "";
    L5:
        String r102 = com.larus.office.base.utils.b.c(r100, r101);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return r101.toString();
    }

    public static final String b(DocDownloadManager r100, String r101, FileExportType r102) {
        r100.getClass();
        if (a.f331347a[r102.ordinal()] != 3) goto L6;
        r101 = new Regex("\\.md$").replace(r101, Global.SUFFIX_TXT_FILE);
    L6:
        if (r101.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return e();
    L12:
        return PatternProtector.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]").matcher(r101).replaceAll("_");
    L8:
        r103 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0132 -> B:47:0x0136). Please report as a decompilation issue!!! */
    public static final Object c(DocDownloadManager r110, m r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof DocDownloadManager$pollDownloadUrl$1) == false) goto L7;
        DocDownloadManager$pollDownloadUrl$1 r100 = (DocDownloadManager$pollDownloadUrl$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r105 = r100.I$4;
        int r106 = r100.I$3;
        int r107 = r100.I$2;
        int r113 = r100.I$1;
        int r114 = r100.I$0;
        Long r115 = (Long) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L47:
        int r116 = r113;
        int r117 = r107;
        int r108 = r116;
        dm9.a r109 = (dm9.a) r102;
        FLogger.f375446a.i("DocDownloadManager", "[pollDownloadUrl] response: " + r109);
        if ((r109 instanceof dm9.a.b) == false) goto L56;
        o r118 = (o) ((dm9.a.b) r109).f469231a.getData();
        if (r118 == null) goto L56;
        if (o0.d(r118.c()) == false) goto L56;
        if (Intrinsics.areEqual(r118.b(), r115) == false) goto L56;
        String r119 = h.f331375b;
        h.f331378e = System.currentTimeMillis();
        h.f331379f = r105;
        return r118;
    L56:
        r105 = r106 + 1;
        int r120 = r114;
        Long r121 = r115;
    L36:
        if (r105 >= r117) goto L57;
        if (r105 != 0) goto L39;
        int r122 = r120;
    L40:
        r100.L$0 = r121;
        r100.I$0 = r120;
        r100.I$1 = r108;
        r100.I$2 = r117;
        r100.I$3 = r105;
        r100.I$4 = r105;
        r100.label = 1;
        if (DelayKt.delay(((long) r122) * 1000, r100) == r103) goto L59;
        r115 = r121;
        r114 = r120;
        r106 = r105;
        int r123 = r117;
        r113 = r108;
        r107 = r123;
    L44:
        FLogger.f375446a.i("DocDownloadManager", "[pollDownloadUrl] attempt " + r105);
        n r124 = new n(r115);
        DocumentApi.a r125 = DocumentApi.f331050a;
        DocDownloadManager$pollDownloadUrl$2$response$1 r126 = new DocDownloadManager$pollDownloadUrl$2$response$1(r124, null);
        r100.L$0 = r115;
        r100.I$0 = r114;
        r100.I$1 = r113;
        r100.I$2 = r107;
        r100.I$3 = r106;
        r100.I$4 = r105;
        r100.label = 2;
        r125.getClass();
        r102 = DocumentApi.a.a(r126, r100);
        if (r102 != r103) goto L47;
    L59:
        return r103;
    L39:
        r122 = r108;
        goto L40
    L57:
        FLogger.f375446a.i("DocDownloadManager", "[pollDownloadUrl] maxAttempts reached");
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r105 = r100.I$4;
        r106 = r100.I$3;
        r107 = r100.I$2;
        r113 = r100.I$1;
        r114 = r100.I$0;
        r115 = (Long) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L44
    L16:
        ResultKt.throwOnFailure(r102);
        if (r111 == null) goto L19;
        r121 = r111.b();
    L20:
        if (r111 == null) goto L24;
        Integer r127 = r111.c();
        if (r127 == null) goto L24;
        int r128 = r127.intValue();
    L25:
        if (r111 == null) goto L29;
        Integer r129 = r111.a();
        if (r129 == null) goto L29;
        r120 = r129.intValue();
    L30:
        if (r111 == null) goto L34;
        Integer r130 = r111.d();
        if (r130 == null) goto L34;
        r108 = r130.intValue();
    L35:
        r117 = ((int) Math.ceil(((double) (r128 - r120)) / ((double) r108))) + 1;
        FLogger.f375446a.i("DocDownloadManager", "[pollDownloadUrl] begin jobId:" + r121 + " timeout:" + r128 + " times:" + r117 + " firstQuerySec:" + r120 + " querySec:" + r108);
        r105 = 0;
    L34:
        r108 = 2;
    L29:
        r120 = 1;
    L24:
        r128 = 300;
        goto L25
    L19:
        r121 = null;
    L7:
        r100 = new DocDownloadManager$pollDownloadUrl$1(r110, r112);
        goto L8
    }

    public static void d(FileExportType r110, String r111, String r112, String r113, Function4 r114) {
        IDocSdkServiceV2 r100 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r100 == null) goto L6;
        r100.startDocExport(AppHost.f326268a.getApplication().getApplicationContext(), r112 + '.' + g(r110), g(r110), DocumentType.DOCX.type, r111, "41", r113, r114);
        return;
    }

    public static void h(FileExportType r110, String r111, String r112, String r113, Function4 r114) {
        if (z2.f365865a.enableOfficeSdkInitOnEnterpriseOnline() == false) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DocDownloadManager$realDownload$1(r110, r111, r112, r113, r114, null), 3, null);
        return;
    L6:
        d(r110, r111, r112, r113, r114);
    }
}

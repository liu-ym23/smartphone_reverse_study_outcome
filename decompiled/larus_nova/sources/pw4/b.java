package pw4;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530833a = 0;

    static {
    }

    @JvmStatic
    public static final BizDomain a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        if (r100 == null) goto L51;
        switch(r100.hashCode()) {
            case -1928898497: goto L46;
            case -1630284708: goto L43;
            case -1440988460: goto L40;
            case -178324674: goto L35;
            case 3552645: goto L30;
            case 3649456: goto L27;
            case 96619420: goto L22;
            case 841198627: goto L19;
            case 1016525851: goto L16;
            case 1910060983: goto L11;
            default: goto L51;
        };
    L11:
        if (r100.equals(DocumentType.IM_FILE_NAME) == false) goto L51;
        return BizDomain.FileBizDomainIM;
    L16:
        if (r100.equals("docx_file") == false) goto L51;
    L49:
        return BizDomain.FileBizDomainCCM;
    L19:
        if (r100.equals("doc_file") == true) goto L49;
    L22:
        if (r100.equals("email") == false) goto L51;
        return BizDomain.FileBizDomainMAIL;
    L27:
        if (r100.equals("wiki") == true) goto L49;
    L30:
        if (r100.equals("task") == false) goto L51;
        return BizDomain.FileBizDomainTODO;
    L35:
        if (r100.equals("calendar") == false) goto L51;
        return BizDomain.FileBizDomainCALENDAR;
    L40:
        if (r100.equals("bitable_file") == true) goto L49;
    L43:
        if (r100.equals("sheet_file") == true) goto L49;
    L46:
        if (r100.equals(FileInfoPuller.CALLER_EXPLORER) == true) goto L49;
    L51:
        return BizDomain.FileBizDomainOPENPLATFORM;
    L5:
        return BizDomain.FileBizDomainOPENPLATFORM;
    }

    @JvmStatic
    public static final String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "CCM_CONTENT_COPY";
    L6:
        if (Intrinsics.areEqual(r100, DocumentType.IM_FILE_NAME) == false) goto L9;
        return "IM_MSG_FILE_COPY";
    L9:
        return "CCM_CONTENT_COPY";
    }

    @JvmStatic
    public static final String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "CCM_FILE_DOWNLOAD";
    L6:
        if (Intrinsics.areEqual(r100, DocumentType.IM_FILE_NAME) == false) goto L9;
        return "IM_MSG_FILE_DOWNLOAD";
    L9:
        return "CCM_FILE_DOWNLOAD";
    }

    @JvmStatic
    public static final FileBizDomain d(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        if (r100 == null) goto L41;
        switch(r100.hashCode()) {
            case -1928898497: goto L36;
            case -1630284708: goto L33;
            case -1440988460: goto L30;
            case -178324674: goto L25;
            case 3649456: goto L22;
            case 841198627: goto L19;
            case 1016525851: goto L16;
            case 1910060983: goto L11;
            default: goto L41;
        };
    L11:
        if (r100.equals(DocumentType.IM_FILE_NAME) == false) goto L41;
        return FileBizDomain.FileBizDomainIM;
    L16:
        if (r100.equals("docx_file") == false) goto L41;
    L39:
        return FileBizDomain.FileBizDomainCCM;
    L19:
        if (r100.equals("doc_file") == true) goto L39;
    L22:
        if (r100.equals("wiki") == true) goto L39;
    L25:
        if (r100.equals("calendar") == false) goto L41;
        return FileBizDomain.FileBizDomainCALENDAR;
    L30:
        if (r100.equals("bitable_file") == true) goto L39;
    L33:
        if (r100.equals("sheet_file") == true) goto L39;
    L36:
        if (r100.equals(FileInfoPuller.CALLER_EXPLORER) == true) goto L39;
    L41:
        return FileBizDomain.FileBizDomainUNKNOWN;
    L5:
        return FileBizDomain.FileBizDomainUNKNOWN;
    }

    @JvmStatic
    public static final sbb.e e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return sbb.e.f541301l;
    L7:
        if (Intrinsics.areEqual(r100, DocumentType.IM_FILE_NAME) == false) goto L11;
        return sbb.e.f541313x;
    L11:
        return sbb.e.f541301l;
    }

    @JvmStatic
    public static final int f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return sbb.e.f541301l.f541317b;
    L7:
        if (Intrinsics.areEqual(r100, DocumentType.IM_FILE_NAME) == false) goto L11;
        return 998;
    L11:
        return sbb.e.f541301l.f541317b;
    }
}

package yc9;

import android.webkit.MimeTypeMap;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class l1 {
    public static final String a(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UplinkEntityContent r101 = r100.getUplinkEntityContent();
        if (r101 == null) goto L7;
        UplinkFileInfo r102 = r101.getUplinkFileInfo();
        if (r102 == null) goto L7;
        return r102.getFileName();
    L7:
        return null;
    }

    public static final long b(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UplinkEntityContent r101 = r100.getUplinkEntityContent();
        if (r101 == null) goto L9;
        UplinkFileInfo r102 = r101.getUplinkFileInfo();
        if (r102 == null) goto L9;
        Long r103 = r102.getSize();
        if (r103 == null) goto L9;
        return r103.longValue();
    L9:
        return 0;
    }

    public static final Image c(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UplinkEntityContent r101 = r100.getUplinkEntityContent();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getUplinkImageInfo();
    }

    public static final String d(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UplinkEntityContent r101 = r100.getUplinkEntityContent();
        if (r101 == null) goto L21;
        Integer r102 = r100.getEntityType();
        int r103 = UplinkEntityType.EntityTypeImage.getValue();
        if (r102 != null) goto L8;
    L13:
        int r104 = UplinkEntityType.EntityTypeFile.getValue();
        if (r102 != null) goto L17;
        return null;
    L17:
        if (r102.intValue() != r104) goto L24;
        UplinkFileInfo r105 = r101.getUplinkFileInfo();
        if (r105 == null) goto L25;
        String r106 = r105.getLocalResPath();
    L23:
        return r106;
    L25:
        return null;
    L24:
        return null;
    L8:
        if (r102.intValue() != r103) goto L13;
        Image r107 = r101.getUplinkImageInfo();
        if (r107 == null) goto L22;
        r106 = r107.localResPath;
        goto L23
    L22:
        return null;
    L21:
        return null;
    }

    public static final String e(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UplinkEntityContent r101 = r100.getUplinkEntityContent();
        if (r101 == null) goto L21;
        Integer r102 = r100.getEntityType();
        int r103 = UplinkEntityType.EntityTypeImage.getValue();
        if (r102 != null) goto L8;
    L12:
        int r104 = UplinkEntityType.EntityTypeFile.getValue();
        if (r102 != null) goto L16;
        return null;
    L16:
        if (r102.intValue() != r104) goto L24;
        UplinkFileInfo r105 = r101.getUplinkFileInfo();
        if (r105 != null) goto L20;
        return null;
    L20:
        return r105.getMd5();
    L24:
        return null;
    L8:
        if (r102.intValue() != r103) goto L12;
        Image r106 = r101.getUplinkImageInfo();
        if (r106 != null) goto L23;
        return null;
    L23:
        return r106.f346641md5;
    L21:
        return null;
    }

    public static final String f(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UplinkEntityContent r101 = r100.getUplinkEntityContent();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.getUplinkImageInfo() == null) goto L8;
        return null;
    L8:
        if (r101.getUplinkFileInfo() == null) goto L29;
        UplinkFileInfo r102 = r101.getUplinkFileInfo();
        if (r102 == null) goto L15;
        String r103 = r102.getMimeType();
        if (r103 == null) goto L15;
        return r103;
    L15:
        UplinkFileInfo r104 = r101.getUplinkFileInfo();
        if (r104 == null) goto L20;
        String r105 = r104.getFileName();
        if (r105 == null) goto L20;
        String r106 = StringsKt.substringAfterLast$default(r105, '.', null, 2, null);
    L21:
        String r107 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r106);
        if (r107 != null) goto L27;
        Map<String, String> r108 = r100.getExtra();
        if (r108 != null) goto L32;
        return null;
    L32:
        return r108.get("originFileTypeString");
    L27:
        return r107;
    L20:
        r106 = null;
        goto L21
    L29:
        return null;
    }

    public static final String g(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeImage.getValue();
        if (r101 != null) goto L6;
    L12:
        int r103 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L16;
        return null;
    L16:
        if (r101.intValue() != r103) goto L26;
        UplinkEntityContent r104 = r100.getUplinkEntityContent();
        if (r104 == null) goto L27;
        UplinkFileInfo r105 = r104.getUplinkFileInfo();
        if (r105 != null) goto L22;
        return null;
    L22:
        return r105.getResourceId();
    L27:
        return null;
    L26:
        return null;
    L6:
        if (r101.intValue() != r102) goto L12;
        UplinkEntityContent r106 = r100.getUplinkEntityContent();
        if (r106 == null) goto L23;
        Image r107 = r106.getUplinkImageInfo();
        if (r107 != null) goto L25;
        return null;
    L25:
        return r107.resourceId;
    L23:
        return null;
    }

    public static final String h(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UplinkEntityContent r101 = r100.getUplinkEntityContent();
        if (r101 == null) goto L14;
        Image r102 = r101.getUplinkImageInfo();
        if (r102 == null) goto L10;
        String r103 = r102.key;
        if (r103 == null) goto L10;
        return r103;
    L10:
        UplinkFileInfo r104 = r101.getUplinkFileInfo();
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.getTosKey();
    L14:
        return null;
    }

    public static final boolean i(UplinkFileEntity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.intValue() != r102) goto L24;
        UplinkEntityContent r103 = r100.getUplinkEntityContent();
        if (r103 == null) goto L20;
        UplinkFileInfo r104 = r103.getUplinkFileInfo();
        if (r104 == null) goto L20;
        Integer r105 = r104.getFileType();
        int r106 = FileType.FileTypeAudio.getValue();
        if (r105 == null) goto L20;
        if (r105.intValue() != r106) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L25;
        return true;
    L25:
        return false;
    L20:
        r107 = false;
        goto L21
    L24:
        return false;
    }

    public static final boolean j(UplinkFileEntity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.intValue() != r102) goto L24;
        UplinkEntityContent r103 = r100.getUplinkEntityContent();
        if (r103 == null) goto L20;
        UplinkFileInfo r104 = r103.getUplinkFileInfo();
        if (r104 == null) goto L20;
        Integer r105 = r104.getFileType();
        int r106 = FileType.FileTypeFile.getValue();
        if (r105 == null) goto L20;
        if (r105.intValue() != r106) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L25;
        return true;
    L25:
        return false;
    L20:
        r107 = false;
        goto L21
    L24:
        return false;
    }

    public static final boolean k(String r100) {
        return CollectionsKt.contains(CollectionsKt.listOf(new String[]{"ai_doc", "ai_sheet", "ai_slides", DocumentType.BITABLE_NAME, DocumentType.MINDNOTE_NAME}), r100);
    }

    public static final boolean l(UplinkFileEntity r100) {
        if (r100 == null) goto L10;
        Integer r101 = r100.getUpLinkStatus();
        int r102 = UpLinkState.SUCCESS.getValue();
        if (r101 == null) goto L10;
        if (r101.intValue() != r102) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L24;
        if (r100 == null) goto L19;
        Integer r104 = r100.getUpLinkStatus();
        int r105 = UpLinkState.FAIL.getValue();
        if (r104 == null) goto L19;
        if (r104.intValue() != r105) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == true) goto L25;
        return false;
    L25:
        return true;
    L19:
        r106 = false;
        goto L20
    L24:
        return true;
    L10:
        r103 = false;
        goto L11
    }

    public static final boolean m(UplinkFileEntity r100) {
        if (r100 == null) goto L43;
        String r101 = r100.getFileIdentifier();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L52;
        UplinkEntityContent r103 = r100.getUplinkEntityContent();
        if (r103 == null) goto L44;
        Integer r104 = r100.getEntityType();
        int r105 = UplinkEntityType.EntityTypeImage.getValue();
        if (r104 != null) goto L19;
    L28:
        int r106 = UplinkEntityType.EntityTypeFile.getValue();
        if (r104 != null) goto L32;
        return false;
    L32:
        if (r104.intValue() != r106) goto L48;
        UplinkFileInfo r107 = r103.getUplinkFileInfo();
        if (r107 != null) goto L37;
        return false;
    L37:
        if (com.flow.kmp.common.util.f.a(r107.getFileName()) == true) goto L39;
        return false;
    L39:
        if (com.flow.kmp.common.util.f.a(r107.getMd5()) == true) goto L41;
        return false;
    L41:
        if (com.flow.kmp.common.util.f.a(r107.getLocalResPath()) == false) goto L51;
    L27:
        return true;
    L51:
        return false;
    L48:
        return false;
    L19:
        if (r104.intValue() != r105) goto L28;
        Image r108 = r103.getUplinkImageInfo();
        if (r108 != null) goto L24;
        return false;
    L24:
        if (com.flow.kmp.common.util.f.a(r108.f346641md5) == true) goto L26;
        return false;
    L26:
        if (com.flow.kmp.common.util.f.a(r108.localResPath) == true) goto L27;
        return false;
    L44:
        return false;
    L52:
        return false;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    L43:
        return false;
    }

    public static final boolean n(UplinkFileEntity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.intValue() != r102) goto L24;
        UplinkEntityContent r103 = r100.getUplinkEntityContent();
        if (r103 == null) goto L20;
        UplinkFileInfo r104 = r103.getUplinkFileInfo();
        if (r104 == null) goto L20;
        Integer r105 = r104.getFileType();
        int r106 = FileType.FileTypeVideo.getValue();
        if (r105 == null) goto L20;
        if (r105.intValue() != r106) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L25;
        return true;
    L25:
        return false;
    L20:
        r107 = false;
        goto L21
    L24:
        return false;
    }
}

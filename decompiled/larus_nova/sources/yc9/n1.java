package yc9;

import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class n1 {
    public static final boolean a(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.intValue() != r102) goto L21;
        UplinkEntityContent r103 = r100.getUplinkEntityContent();
        if (r103 == null) goto L17;
        UplinkFileInfo r104 = r103.getUplinkFileInfo();
        if (r104 == null) goto L17;
        Integer r105 = r104.getFileType();
        int r106 = FileType.FileTypeAudio.getValue();
        if (r105 == null) goto L17;
        if (r105.intValue() != r106) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L22;
        return true;
    L22:
        return false;
    L17:
        r107 = false;
        goto L18
    L21:
        return false;
    }

    public static final boolean b(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.intValue() != r102) goto L21;
        UplinkEntityContent r103 = r100.getUplinkEntityContent();
        if (r103 == null) goto L17;
        UplinkFileInfo r104 = r103.getUplinkFileInfo();
        if (r104 == null) goto L17;
        Integer r105 = r104.getFileType();
        int r106 = FileType.FileTypeFile.getValue();
        if (r105 == null) goto L17;
        if (r105.intValue() != r106) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L22;
        return true;
    L22:
        return false;
    L17:
        r107 = false;
        goto L18
    L21:
        return false;
    }

    public static final boolean c(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r101.intValue() != r102) goto L8;
        return true;
    }

    public static final boolean d(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeImage.getValue();
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r101.intValue() != r102) goto L8;
        return true;
    }

    public static final boolean e(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.intValue() != r102) goto L21;
        UplinkEntityContent r103 = r100.getUplinkEntityContent();
        if (r103 == null) goto L17;
        UplinkFileInfo r104 = r103.getUplinkFileInfo();
        if (r104 == null) goto L17;
        Integer r105 = r104.getFileType();
        int r106 = FileType.FileTypeVideo.getValue();
        if (r105 == null) goto L17;
        if (r105.intValue() != r106) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L22;
        return true;
    L22:
        return false;
    L17:
        r107 = false;
        goto L18
    L21:
        return false;
    }
}

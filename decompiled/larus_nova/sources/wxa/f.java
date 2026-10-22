package wxa;

import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.DoubaoFileInfo;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.FileType;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkEntityContent;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkEntityType;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class f {
    public static final boolean a(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DoubaoFileInfo r101 = r100.getDoubaoFileInfo();
        if (r101 == null) goto L9;
        String r102 = r101.getResourceUri();
        if (r102 == null) goto L9;
        if ((!StringsKt.isBlank(r102)) != true) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L18;
        DoubaoFileInfo r104 = r100.getDoubaoFileInfo();
        if (r104 == null) goto L14;
        Integer r105 = r104.getStorageType();
    L15:
        if (r105 == null) goto L19;
        return true;
    L19:
        return false;
    L14:
        r105 = null;
        goto L15
    L18:
        return false;
    L9:
        r103 = false;
        goto L10
    }

    public static final boolean b(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getUplinkFileDriveContent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean c(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.intValue() != r102) goto L33;
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
        if (r107 == true) goto L31;
        UplinkEntityContent r108 = r100.getUplinkEntityContent();
        if (r108 == null) goto L29;
        UplinkFileInfo r109 = r108.getUplinkFileInfo();
        if (r109 == null) goto L29;
        Integer r110 = r109.getFileType();
        int r111 = FileType.FileTypeAudio.getValue();
        if (r110 == null) goto L29;
        if (r110.intValue() != r111) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == true) goto L31;
        return false;
    L29:
        r112 = false;
    L31:
        return true;
    L17:
        r107 = false;
        goto L18
    L33:
        return false;
    }

    public static final boolean d(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (b(r100) == true) goto L10;
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeImage.getValue();
        if (r101 == null) goto L10;
        if (r101.intValue() != r102) goto L10;
        return true;
    L10:
        return false;
    }

    public static final boolean e(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (b(r100) == true) goto L23;
        Integer r101 = r100.getEntityType();
        int r102 = UplinkEntityType.EntityTypeFile.getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != r102) goto L24;
        UplinkEntityContent r103 = r100.getUplinkEntityContent();
        if (r103 == null) goto L19;
        UplinkFileInfo r104 = r103.getUplinkFileInfo();
        if (r104 == null) goto L19;
        Integer r105 = r104.getFileType();
        int r106 = FileType.FileTypeVideo.getValue();
        if (r105 == null) goto L19;
        if (r105.intValue() != r106) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L25;
        return true;
    L25:
        return false;
    L19:
        r107 = false;
        goto L20
    L24:
        return false;
    L23:
        return false;
    }
}

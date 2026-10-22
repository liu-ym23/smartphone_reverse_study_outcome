package com.larus.project;

import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectFolder;
import com.larus.im.internal.jni.bean.OmniProjectStatus;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class x {
    public static final i a(OmniProject r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = null;
        if (r110.status != OmniProjectStatus.OmniProjectStatus_DELETED) goto L5;
        return null;
    L5:
        String r101 = r110.projectId;
        if (r101 != null) goto L8;
    L33:
        return null;
    L8:
        if ((!StringsKt.isBlank(r101)) == false) goto L10;
        String r102 = r101;
    L11:
        if (r102 == null) goto L33;
        List<OmniProjectFolder> r103 = r110.folders;
        if (r103 != null) goto L16;
        r103 = CollectionsKt.emptyList();
    L16:
        OmniProjectFolder r104 = (OmniProjectFolder) CollectionsKt.firstOrNull(r103);
        String r111 = r110.name;
        if (r111 != null) goto L19;
        r111 = "";
    L19:
        String r105 = r111;
        boolean r106 = r103.isEmpty();
        if (r104 == null) goto L22;
        String r107 = r104.folderName;
    L23:
        if (r104 == null) goto L25;
        String r108 = r104.workspace;
    L26:
        if (r104 == null) goto L28;
        String r109 = r104.folderDeviceId;
    L29:
        if (r104 == null) goto L32;
        r100 = r104.folderDeviceName;
    L32:
        return new i(r102, r105, r106, r107, r108, r109, r100);
    L28:
        r109 = null;
        goto L29
    L25:
        r108 = null;
        goto L26
    L22:
        r107 = null;
        goto L23
    L10:
        r102 = null;
        goto L11
    }
}

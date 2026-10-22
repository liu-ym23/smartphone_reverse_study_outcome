package com.larus.bmhome.rc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {
    public static final String a(ResourceInstantUploadInfo r100, String r101) {
        if (r100 == null) goto L19;
        String r102 = r100.getRegisterUri();
        if (r102 == null) goto L20;
        boolean r103 = false;
        if (Intrinsics.areEqual(r100.getPreQueryHit(), Boolean.TRUE) == true) goto L8;
    L13:
        if (r103 == true) goto L16;
        r102 = null;
    L16:
        if (r102 != null) goto L18;
        return r101;
    L18:
        return r102;
    L8:
        if (r102.length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        r103 = true;
        goto L13
    L10:
        r104 = false;
        goto L11
    L20:
        return r101;
    L19:
        return r101;
    }

    public static final FlowResourceMeta b(FlowResourceMeta r210, ResourceInstantUploadInfo r211, Long r212) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        if (r211 != null) goto L5;
        return r210;
    L5:
        ResourceFingerprintMeta r100 = r211.getFingerprintMeta();
        if (r100 != null) goto L9;
        ResourceFingerprintMeta r101 = null;
    L18:
        if (Intrinsics.areEqual(r211.getPreQueryHit(), Boolean.TRUE) == false) goto L46;
        ResourceTargetMeta r102 = r211.getTargetMeta();
        if (r102 == null) goto L46;
        String r103 = r102.getTargetUri();
        if (r103 == null) goto L46;
        boolean r104 = true;
        if (r103.length() <= 0) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == true) goto L32;
        r103 = null;
    L32:
        if (r103 == null) goto L46;
        String r106 = r102.getTargetResourceId();
        if (r106 == null) goto L46;
        if (r106.length() > 0) goto L40;
        r104 = false;
    L40:
        if (r104 == true) goto L43;
        r106 = null;
    L43:
        if (r106 == null) goto L46;
        ResourceTargetMeta r107 = new ResourceTargetMeta(r103, r106);
    L48:
        return FlowResourceMeta.copy$default(r210, null, null, null, null, r101, r107, 15, null);
    L28:
        r105 = false;
    L46:
        r107 = null;
        goto L48
    L9:
        if (Intrinsics.areEqual(r211.getPreQueryHit(), Boolean.TRUE) == false) goto L11;
        Long r110 = null;
    L16:
        r101 = ResourceFingerprintMeta.copy$default(r100, null, null, null, null, null, null, r110, null, null, null, null, null, null, 8127, null);
        goto L18
    L11:
        if (r212 != null) goto L13;
    L15:
        r110 = r100.getFileSize();
        goto L16
    L13:
        if (r212.longValue() <= 0) goto L15;
        r110 = r212;
        goto L16
    }
}

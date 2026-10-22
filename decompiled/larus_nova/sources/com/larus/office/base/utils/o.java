package com.larus.office.base.utils;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.office.OfficeInputParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361178a = 0;

    static {
    }

    public static Integer a(OfficeInputParam r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getType();
    L7:
        if (Intrinsics.areEqual(r101, "drive") == false) goto L9;
        return null;
    L9:
        if (r100 == null) goto L37;
        int r102 = r100.getResourceType();
        if (r102 != 14) goto L13;
        String r103 = r100.getType();
        if (r103 == null) goto L36;
        switch(r103.hashCode()) {
            case -899647262: goto L32;
            case 3016401: goto L28;
            case 3088960: goto L24;
            case 109403487: goto L20;
            default: goto L36;
        };
    L20:
        if (r103.equals(DocumentType.SHEET_NAME) == false) goto L36;
        return 12;
    L24:
        if (r103.equals(DocumentType.DOCX_NAME) == false) goto L36;
        return 10;
    L28:
        if (r103.equals("base") == false) goto L36;
        return 15;
    L32:
        if (r103.equals("slides") == false) goto L36;
        return 9;
    L36:
        return Integer.valueOf(r102);
    L13:
        return Integer.valueOf(r102);
    L37:
        return null;
    L5:
        r101 = null;
        goto L7
    }

    public static Integer b(Integer r100, int r101) {
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r100.intValue() == 14) goto L7;
        return r100;
    L7:
        return Integer.valueOf(r101);
    }
}

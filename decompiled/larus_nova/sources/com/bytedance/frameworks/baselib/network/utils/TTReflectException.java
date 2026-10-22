package com.bytedance.frameworks.baselib.network.utils;

/* JADX INFO: loaded from: classes19.dex */
public class TTReflectException extends RuntimeException {
    private final String memberType;
    private final String targetClass;
    private final String targetMember;

    public String getMemberType() {
        return this.memberType;
    }

    public String getTargetClass() {
        return this.targetClass;
    }

    public String getTargetMember() {
        return this.targetMember;
    }

    public TTReflectException(String r100) {
        this(r100, null, new String[0]);
    }

    public TTReflectException(String r100, Throwable r101, String... r102) {
        StringBuilder r103 = new StringBuilder(r100);
        if (r102 != null) goto L5;
    L13:
        super(r103.toString(), r101);
        String r104 = "unknown";
        if (r102.length <= 0) goto L16;
        String r105 = r102[0];
    L17:
        this.targetClass = r105;
        if (r102.length <= 1) goto L20;
        String r106 = r102[1];
    L21:
        this.targetMember = r106;
        if (r102.length <= 2) goto L24;
        r104 = r102[2];
    L24:
        this.memberType = r104;
        return;
    L20:
        r106 = "unknown";
        goto L21
    L16:
        r105 = "unknown";
        goto L17
    L5:
        if (r102.length <= 0) goto L13;
        r103.append(" [TargetClass: ");
        r103.append(r102[0]);
        if (r102.length <= 1) goto L10;
        r103.append(", TargetMember: ");
        r103.append(r102[1]);
    L10:
        if (r102.length <= 2) goto L12;
        r103.append(", MemberType: ");
        r103.append(r102[2]);
    L12:
        r103.append("]");
        goto L13
    }
}

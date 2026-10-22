package com.google.thirdparty.publicsuffix;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum PublicSuffixType extends Enum<PublicSuffixType> {
    public static final PublicSuffixType PRIVATE = null;
    public static final PublicSuffixType REGISTRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicSuffixType[] f275929a = null;
    private final char innerNodeCode;
    private final char leafNodeCode;

    static {
        PublicSuffixType r100 = new PublicSuffixType("PRIVATE", 0, ':', ',');
        PRIVATE = r100;
        PublicSuffixType r101 = new PublicSuffixType("REGISTRY", 1, '!', '?');
        REGISTRY = r101;
        f275929a = new PublicSuffixType[]{r100, r101};
    }

    public static PublicSuffixType[] values() {
        return (PublicSuffixType[]) f275929a.clone();
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }

    public static PublicSuffixType fromCode(char r100) {
        PublicSuffixType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        PublicSuffixType r104 = r101[r103];
        if (r104.getInnerNodeCode() == r100) goto L10;
        if (r104.getLeafNodeCode() == r100) goto L10;
        r103 = r103 + 1;
    L10:
        return r104;
    L12:
        throw new IllegalArgumentException("No enum corresponding to given code: " + r100);
    }

    public static PublicSuffixType valueOf(String r100) {
        return (PublicSuffixType) a.a(PublicSuffixType.class, r100);
    }

    public PublicSuffixType(String r100, int r101, char r102, char r103) {
        super(r100, r101);
        this.innerNodeCode = r102;
        this.leafNodeCode = r103;
    }
}

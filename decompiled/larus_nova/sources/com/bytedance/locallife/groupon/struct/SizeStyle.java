package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/SizeStyle;", "", "", "originName", "Ljava/lang/String;", "getOriginName", "()Ljava/lang/String;", "SIZE_7", "SIZE_9", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum SizeStyle extends Enum<SizeStyle> {
    public static final SizeStyle SIZE_7 = null;
    public static final SizeStyle SIZE_9 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SizeStyle[] f258839a = null;
    private final String originName;

    public static SizeStyle valueOf(String r100) {
        return (SizeStyle) r27.a.a(SizeStyle.class, r100);
    }

    public static SizeStyle[] values() {
        return (SizeStyle[]) f258839a.clone();
    }

    static {
        SizeStyle r100 = new SizeStyle("SIZE_7", 0, "size_7");
        SIZE_7 = r100;
        SizeStyle r101 = new SizeStyle("SIZE_9", 1, "size_9");
        SIZE_9 = r101;
        f258839a = new SizeStyle[]{r100, r101};
    }

    public final String getOriginName() {
        return this.originName;
    }

    public SizeStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.originName = r102;
    }
}

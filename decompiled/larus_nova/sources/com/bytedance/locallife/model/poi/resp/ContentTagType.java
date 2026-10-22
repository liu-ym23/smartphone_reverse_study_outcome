package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/ContentTagType;", "", "", "value", "I", "getValue", "()I", "ATTITUDE", "CONSUMER_EXPERIENCE", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum ContentTagType extends Enum<ContentTagType> {
    public static final ContentTagType ATTITUDE = null;
    public static final ContentTagType CONSUMER_EXPERIENCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContentTagType[] f260853a = null;
    private final int value;

    public static ContentTagType valueOf(String r100) {
        return (ContentTagType) r27.a.a(ContentTagType.class, r100);
    }

    public static ContentTagType[] values() {
        return (ContentTagType[]) f260853a.clone();
    }

    static {
        ContentTagType r100 = new ContentTagType("ATTITUDE", 0, 1);
        ATTITUDE = r100;
        ContentTagType r101 = new ContentTagType("CONSUMER_EXPERIENCE", 1, 2);
        CONSUMER_EXPERIENCE = r101;
        f260853a = new ContentTagType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public ContentTagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

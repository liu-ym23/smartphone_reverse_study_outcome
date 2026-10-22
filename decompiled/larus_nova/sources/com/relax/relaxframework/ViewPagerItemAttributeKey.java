package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/relax/relaxframework/ViewPagerItemAttributeKey;", "", "", "value", "I", "getValue", "()I", "Tag", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ViewPagerItemAttributeKey extends Enum<ViewPagerItemAttributeKey> {
    public static final ViewPagerItemAttributeKey Tag = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewPagerItemAttributeKey[] f404991a = null;
    private final int value;

    public static ViewPagerItemAttributeKey valueOf(String r100) {
        return (ViewPagerItemAttributeKey) r27.a.a(ViewPagerItemAttributeKey.class, r100);
    }

    public static ViewPagerItemAttributeKey[] values() {
        return (ViewPagerItemAttributeKey[]) f404991a.clone();
    }

    static {
        ViewPagerItemAttributeKey r100 = new ViewPagerItemAttributeKey();
        Tag = r100;
        f404991a = new ViewPagerItemAttributeKey[]{r100};
    }

    public ViewPagerItemAttributeKey() {
        super("Tag", 0);
        this.value = 20211;
    }

    public final int getValue() {
        return this.value;
    }
}

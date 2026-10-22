package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/TextAttributeKey;", "", "", "value", "I", "getValue", "()I", "TextSelect", "TextMaxline", "TextMaxlength", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TextAttributeKey extends Enum<TextAttributeKey> {
    public static final TextAttributeKey TextMaxlength = null;
    public static final TextAttributeKey TextMaxline = null;
    public static final TextAttributeKey TextSelect = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextAttributeKey[] f404965a = null;
    private final int value;

    public static TextAttributeKey valueOf(String r100) {
        return (TextAttributeKey) r27.a.a(TextAttributeKey.class, r100);
    }

    public static TextAttributeKey[] values() {
        return (TextAttributeKey[]) f404965a.clone();
    }

    static {
        TextAttributeKey r100 = new TextAttributeKey("TextSelect", 0, 20029);
        TextSelect = r100;
        TextAttributeKey r101 = new TextAttributeKey("TextMaxline", 1, 20020);
        TextMaxline = r101;
        TextAttributeKey r102 = new TextAttributeKey("TextMaxlength", 2, 20022);
        TextMaxlength = r102;
        f404965a = new TextAttributeKey[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public TextAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

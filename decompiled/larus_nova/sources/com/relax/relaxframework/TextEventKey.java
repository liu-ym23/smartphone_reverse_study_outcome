package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/relax/relaxframework/TextEventKey;", "", "", "value", "I", "getValue", "()I", "Layout", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TextEventKey extends Enum<TextEventKey> {
    public static final TextEventKey Layout = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextEventKey[] f404967a = null;
    private final int value;

    public static TextEventKey valueOf(String r100) {
        return (TextEventKey) r27.a.a(TextEventKey.class, r100);
    }

    public static TextEventKey[] values() {
        return (TextEventKey[]) f404967a.clone();
    }

    static {
        TextEventKey r100 = new TextEventKey();
        Layout = r100;
        f404967a = new TextEventKey[]{r100};
    }

    public TextEventKey() {
        super("Layout", 0);
        this.value = 30076;
    }

    public final int getValue() {
        return this.value;
    }
}

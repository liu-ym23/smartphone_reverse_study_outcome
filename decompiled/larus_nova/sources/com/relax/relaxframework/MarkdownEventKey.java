package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/MarkdownEventKey;", "", "", "value", "I", "getValue", "()I", "MarkdownDrawStart", "MarkdownDrawEnd", "MarkdownAnimationStep", "MarkdownOverflow", "MarkdownLink", "MarkdownImageTap", "MarkdownParseEnd", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum MarkdownEventKey extends Enum<MarkdownEventKey> {
    public static final MarkdownEventKey MarkdownAnimationStep = null;
    public static final MarkdownEventKey MarkdownDrawEnd = null;
    public static final MarkdownEventKey MarkdownDrawStart = null;
    public static final MarkdownEventKey MarkdownImageTap = null;
    public static final MarkdownEventKey MarkdownLink = null;
    public static final MarkdownEventKey MarkdownOverflow = null;
    public static final MarkdownEventKey MarkdownParseEnd = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MarkdownEventKey[] f404785a = null;
    private final int value;

    public static MarkdownEventKey valueOf(String r100) {
        return (MarkdownEventKey) r27.a.a(MarkdownEventKey.class, r100);
    }

    public static MarkdownEventKey[] values() {
        return (MarkdownEventKey[]) f404785a.clone();
    }

    static {
        MarkdownEventKey r100 = new MarkdownEventKey("MarkdownDrawStart", 0, 30117);
        MarkdownDrawStart = r100;
        MarkdownEventKey r101 = new MarkdownEventKey("MarkdownDrawEnd", 1, 30118);
        MarkdownDrawEnd = r101;
        MarkdownEventKey r102 = new MarkdownEventKey("MarkdownAnimationStep", 2, 30119);
        MarkdownAnimationStep = r102;
        MarkdownEventKey r103 = new MarkdownEventKey("MarkdownOverflow", 3, 30120);
        MarkdownOverflow = r103;
        MarkdownEventKey r104 = new MarkdownEventKey("MarkdownLink", 4, 30121);
        MarkdownLink = r104;
        MarkdownEventKey r105 = new MarkdownEventKey("MarkdownImageTap", 5, 30127);
        MarkdownImageTap = r105;
        MarkdownEventKey r110 = new MarkdownEventKey("MarkdownParseEnd", 6, 30128);
        MarkdownParseEnd = r110;
        f404785a = new MarkdownEventKey[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public MarkdownEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

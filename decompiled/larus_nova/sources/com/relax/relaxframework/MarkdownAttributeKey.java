package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/MarkdownAttributeKey;", "", "", "value", "I", "getValue", "()I", "Content", "MarkdownStyle", "AnimationType", "AnimationVelocity", "TextMaxline", "InitialAnimationStep", "ContentComplete", "TypewriterDynamicHeight", "ContentRange", "MarkdownEffect", "ContentId", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum MarkdownAttributeKey extends Enum<MarkdownAttributeKey> {
    public static final MarkdownAttributeKey AnimationType = null;
    public static final MarkdownAttributeKey AnimationVelocity = null;
    public static final MarkdownAttributeKey Content = null;
    public static final MarkdownAttributeKey ContentComplete = null;
    public static final MarkdownAttributeKey ContentId = null;
    public static final MarkdownAttributeKey ContentRange = null;
    public static final MarkdownAttributeKey InitialAnimationStep = null;
    public static final MarkdownAttributeKey MarkdownEffect = null;
    public static final MarkdownAttributeKey MarkdownStyle = null;
    public static final MarkdownAttributeKey TextMaxline = null;
    public static final MarkdownAttributeKey TypewriterDynamicHeight = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MarkdownAttributeKey[] f404784a = null;
    private final int value;

    public static MarkdownAttributeKey valueOf(String r100) {
        return (MarkdownAttributeKey) r27.a.a(MarkdownAttributeKey.class, r100);
    }

    public static MarkdownAttributeKey[] values() {
        return (MarkdownAttributeKey[]) f404784a.clone();
    }

    static {
        MarkdownAttributeKey r100 = new MarkdownAttributeKey("Content", 0, 20107);
        Content = r100;
        MarkdownAttributeKey r101 = new MarkdownAttributeKey("MarkdownStyle", 1, 20277);
        MarkdownStyle = r101;
        MarkdownAttributeKey r102 = new MarkdownAttributeKey("AnimationType", 2, 20278);
        AnimationType = r102;
        MarkdownAttributeKey r103 = new MarkdownAttributeKey("AnimationVelocity", 3, 20279);
        AnimationVelocity = r103;
        MarkdownAttributeKey r104 = new MarkdownAttributeKey("TextMaxline", 4, 20020);
        TextMaxline = r104;
        MarkdownAttributeKey r105 = new MarkdownAttributeKey("InitialAnimationStep", 5, 20305);
        InitialAnimationStep = r105;
        MarkdownAttributeKey r110 = new MarkdownAttributeKey("ContentComplete", 6, 20306);
        ContentComplete = r110;
        MarkdownAttributeKey r111 = new MarkdownAttributeKey("TypewriterDynamicHeight", 7, 20307);
        TypewriterDynamicHeight = r111;
        MarkdownAttributeKey r112 = new MarkdownAttributeKey("ContentRange", 8, 20308);
        ContentRange = r112;
        MarkdownAttributeKey r113 = new MarkdownAttributeKey("MarkdownEffect", 9, 20309);
        MarkdownEffect = r113;
        MarkdownAttributeKey r114 = new MarkdownAttributeKey("ContentId", 10, 20310);
        ContentId = r114;
        f404784a = new MarkdownAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public MarkdownAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

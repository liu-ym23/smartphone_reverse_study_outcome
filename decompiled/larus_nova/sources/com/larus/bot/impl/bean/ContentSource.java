package com.larus.bot.impl.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larus/bot/impl/bean/ContentSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "MODEL_GENERATED", "GENERATION_FAILED", "USER_INPUT", "NOT_ENTERED", "POLISH", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContentSource extends Enum<ContentSource> {
    public static final a Companion = null;
    public static final ContentSource GENERATION_FAILED = null;
    public static final ContentSource MODEL_GENERATED = null;
    public static final ContentSource NOT_ENTERED = null;
    public static final ContentSource POLISH = null;
    public static final ContentSource UNKNOWN = null;
    public static final ContentSource USER_INPUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContentSource[] f317655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f317656b = null;
    private final String value;

    public static EnumEntries<ContentSource> getEntries() {
        return f317656b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bot.impl.bean.ContentSource$a] */
    static {
        ContentSource r100 = new ContentSource("UNKNOWN", 0, "");
        UNKNOWN = r100;
        ContentSource r101 = new ContentSource("MODEL_GENERATED", 1, "ModelGenerated");
        MODEL_GENERATED = r101;
        ContentSource r102 = new ContentSource("GENERATION_FAILED", 2, "GenerationFailed");
        GENERATION_FAILED = r102;
        ContentSource r103 = new ContentSource("USER_INPUT", 3, "UserInput");
        USER_INPUT = r103;
        ContentSource r104 = new ContentSource("NOT_ENTERED", 4, "NotEntered");
        NOT_ENTERED = r104;
        ContentSource r105 = new ContentSource("POLISH", 5, "Polish");
        POLISH = r105;
        ContentSource[] r110 = {r100, r101, r102, r103, r104, r105};
        f317655a = r110;
        f317656b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static ContentSource[] values() {
        return (ContentSource[]) f317655a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ContentSource valueOf(String r100) {
        return (ContentSource) r27.a.a(ContentSource.class, r100);
    }

    public ContentSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

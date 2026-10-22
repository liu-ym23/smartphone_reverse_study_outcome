package com.obric.aiagent.product.platform.api.vibratefeedback;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "WAKE_UP", "LONG_PRESS", "TICK", "WARNING", "CONFIRM", "RIGID", "SOFT", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackType extends Enum<FeedbackType> {
    public static final FeedbackType CONFIRM = null;
    public static final a Companion = null;
    public static final FeedbackType LONG_PRESS = null;
    public static final FeedbackType RIGID = null;
    public static final FeedbackType SOFT = null;
    public static final FeedbackType TICK = null;
    public static final FeedbackType WAKE_UP = null;
    public static final FeedbackType WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedbackType[] f385013a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385014b = null;
    private final String typeName;

    public static EnumEntries<FeedbackType> getEntries() {
        return f385014b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType$a] */
    static {
        FeedbackType r100 = new FeedbackType("WAKE_UP", 0, "EFFECT_WAKE_UP");
        WAKE_UP = r100;
        FeedbackType r101 = new FeedbackType("LONG_PRESS", 1, "EFFECT_LONG_PRESS");
        LONG_PRESS = r101;
        FeedbackType r102 = new FeedbackType("TICK", 2, "EFFECT_TICK");
        TICK = r102;
        FeedbackType r103 = new FeedbackType("WARNING", 3, "EFFECT_WARNING");
        WARNING = r103;
        FeedbackType r104 = new FeedbackType("CONFIRM", 4, "EFFECT_CONFIRM");
        CONFIRM = r104;
        FeedbackType r105 = new FeedbackType("RIGID", 5, "EFFECT_RIGID");
        RIGID = r105;
        FeedbackType r110 = new FeedbackType("SOFT", 6, "EFFECT_SOFT");
        SOFT = r110;
        FeedbackType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f385013a = r111;
        f385014b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static FeedbackType[] values() {
        return (FeedbackType[]) f385013a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static FeedbackType valueOf(String r100) {
        return (FeedbackType) r27.a.a(FeedbackType.class, r100);
    }

    public FeedbackType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}

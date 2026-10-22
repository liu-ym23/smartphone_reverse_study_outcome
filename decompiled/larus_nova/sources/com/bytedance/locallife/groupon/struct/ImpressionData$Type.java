package com.bytedance.locallife.groupon.struct;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/locallife/groupon/struct/ImpressionData$Type", "", "Lcom/bytedance/locallife/groupon/struct/ImpressionData$Type;", "<init>", "(Ljava/lang/String;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CLICK", "EXPOSE", "CLOSE", "AUTO_DISAPPEAR", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ImpressionData$Type extends Enum<ImpressionData$Type> {
    private static final /* synthetic */ ImpressionData$Type[] $VALUES = null;
    public static final ImpressionData$Type AUTO_DISAPPEAR = null;
    public static final ImpressionData$Type CLICK = null;
    public static final ImpressionData$Type CLOSE = null;
    public static final a Companion = null;
    public static final ImpressionData$Type EXPOSE = null;

    private static final /* synthetic */ ImpressionData$Type[] $values() {
        return new ImpressionData$Type[]{CLICK, EXPOSE, CLOSE, AUTO_DISAPPEAR};
    }

    public static ImpressionData$Type valueOf(String r100) {
        return (ImpressionData$Type) r27.a.a(ImpressionData$Type.class, r100);
    }

    public static ImpressionData$Type[] values() {
        return (ImpressionData$Type[]) $VALUES.clone();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.locallife.groupon.struct.ImpressionData$Type$a] */
    static {
        CLICK = new ImpressionData$Type("CLICK", 0);
        EXPOSE = new ImpressionData$Type("EXPOSE", 1);
        CLOSE = new ImpressionData$Type("CLOSE", 2);
        AUTO_DISAPPEAR = new ImpressionData$Type("AUTO_DISAPPEAR", 3);
        $VALUES = $values();
        Companion = new a();
    }

    private ImpressionData$Type(String r100, int r101) {
        super(r100, r101);
    }
}

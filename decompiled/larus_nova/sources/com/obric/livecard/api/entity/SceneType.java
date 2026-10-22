package com.obric.livecard.api.entity;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/livecard/api/entity/SceneType;", "", "(Ljava/lang/String;I)V", "AI_SUGGESTION", "AI_TASK", BannerBizName.NOTIFICATION, "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum SceneType extends Enum<SceneType> {
    private static final /* synthetic */ SceneType[] $VALUES = null;
    public static final SceneType AI_SUGGESTION = null;
    public static final SceneType AI_TASK = null;
    public static final SceneType NOTIFICATION = null;

    private static final /* synthetic */ SceneType[] $values() {
        return new SceneType[]{AI_SUGGESTION, AI_TASK, NOTIFICATION};
    }

    public static SceneType valueOf(String r100) {
        return (SceneType) a.a(SceneType.class, r100);
    }

    public static SceneType[] values() {
        return (SceneType[]) $VALUES.clone();
    }

    static {
        AI_SUGGESTION = new SceneType("AI_SUGGESTION", 0);
        AI_TASK = new SceneType("AI_TASK", 1);
        NOTIFICATION = new SceneType(BannerBizName.NOTIFICATION, 2);
        $VALUES = $values();
    }

    private SceneType(String r100, int r101) {
        super(r100, r101);
    }
}

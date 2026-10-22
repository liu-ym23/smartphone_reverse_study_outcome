package com.obric.assistant.state.api.v2.core.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "DEEP_THINK_SCENE", "REALTIME_CALL_SCENE", "COMPLEX_TASK_SCENE", "AIGC_GENERATION_SCENE", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricInteractionScene extends Enum<ObricInteractionScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObricInteractionScene[] $VALUES = null;
    public static final ObricInteractionScene AIGC_GENERATION_SCENE = null;
    public static final ObricInteractionScene COMPLEX_TASK_SCENE = null;
    public static final a Companion = null;
    public static final ObricInteractionScene DEEP_THINK_SCENE = null;
    public static final ObricInteractionScene DEFAULT = null;
    public static final ObricInteractionScene REALTIME_CALL_SCENE = null;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ ObricInteractionScene[] $values() {
        return new ObricInteractionScene[]{DEFAULT, DEEP_THINK_SCENE, REALTIME_CALL_SCENE, COMPLEX_TASK_SCENE, AIGC_GENERATION_SCENE};
    }

    public static EnumEntries<ObricInteractionScene> getEntries() {
        return $ENTRIES;
    }

    static {
        DEFAULT = new ObricInteractionScene("DEFAULT", 0);
        DEEP_THINK_SCENE = new ObricInteractionScene("DEEP_THINK_SCENE", 1);
        REALTIME_CALL_SCENE = new ObricInteractionScene("REALTIME_CALL_SCENE", 2);
        COMPLEX_TASK_SCENE = new ObricInteractionScene("COMPLEX_TASK_SCENE", 3);
        AIGC_GENERATION_SCENE = new ObricInteractionScene("AIGC_GENERATION_SCENE", 4);
        ObricInteractionScene[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static ObricInteractionScene[] values() {
        return (ObricInteractionScene[]) $VALUES.clone();
    }

    public static ObricInteractionScene valueOf(String r100) {
        return (ObricInteractionScene) r27.a.a(ObricInteractionScene.class, r100);
    }

    private ObricInteractionScene(String r100, int r101) {
        super(r100, r101);
    }
}

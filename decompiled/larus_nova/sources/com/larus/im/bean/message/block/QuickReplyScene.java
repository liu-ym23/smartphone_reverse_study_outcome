package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/im/bean/message/block/QuickReplyScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SCENE_DEFAULT", "SCENE_ANSWER_POST_OPTION", "SCENE_COMPUTER_USE_AGENT_ASK_HUMAN", "SCENE_SMART_REPLY_SUGGEST", "SCENE_ASWEER_INNER_OPTION", "SCENE_CROSS_END_DIFF_DISPLAY_OPTION", "SCENE_ABOVE_INPUT_BOX_OPTION", "SCENE_USE_LOCAL_APP", "SCENE_CONTROL_LOCAL_APP", "SCENE_INIT_LOCAL_APP", "SCENE_MOA_APPLET_GRANTING", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickReplyScene extends Enum<QuickReplyScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ QuickReplyScene[] $VALUES = null;
    public static final QuickReplyScene SCENE_ABOVE_INPUT_BOX_OPTION = null;
    public static final QuickReplyScene SCENE_ANSWER_POST_OPTION = null;
    public static final QuickReplyScene SCENE_ASWEER_INNER_OPTION = null;
    public static final QuickReplyScene SCENE_COMPUTER_USE_AGENT_ASK_HUMAN = null;
    public static final QuickReplyScene SCENE_CONTROL_LOCAL_APP = null;
    public static final QuickReplyScene SCENE_CROSS_END_DIFF_DISPLAY_OPTION = null;
    public static final QuickReplyScene SCENE_DEFAULT = null;
    public static final QuickReplyScene SCENE_INIT_LOCAL_APP = null;
    public static final QuickReplyScene SCENE_MOA_APPLET_GRANTING = null;
    public static final QuickReplyScene SCENE_SMART_REPLY_SUGGEST = null;
    public static final QuickReplyScene SCENE_USE_LOCAL_APP = null;
    private final int value;

    private static final /* synthetic */ QuickReplyScene[] $values() {
        return new QuickReplyScene[]{SCENE_DEFAULT, SCENE_ANSWER_POST_OPTION, SCENE_COMPUTER_USE_AGENT_ASK_HUMAN, SCENE_SMART_REPLY_SUGGEST, SCENE_ASWEER_INNER_OPTION, SCENE_CROSS_END_DIFF_DISPLAY_OPTION, SCENE_ABOVE_INPUT_BOX_OPTION, SCENE_USE_LOCAL_APP, SCENE_CONTROL_LOCAL_APP, SCENE_INIT_LOCAL_APP, SCENE_MOA_APPLET_GRANTING};
    }

    public static EnumEntries<QuickReplyScene> getEntries() {
        return $ENTRIES;
    }

    static {
        SCENE_DEFAULT = new QuickReplyScene("SCENE_DEFAULT", 0, 0);
        SCENE_ANSWER_POST_OPTION = new QuickReplyScene("SCENE_ANSWER_POST_OPTION", 1, 1);
        SCENE_COMPUTER_USE_AGENT_ASK_HUMAN = new QuickReplyScene("SCENE_COMPUTER_USE_AGENT_ASK_HUMAN", 2, 2);
        SCENE_SMART_REPLY_SUGGEST = new QuickReplyScene("SCENE_SMART_REPLY_SUGGEST", 3, 3);
        SCENE_ASWEER_INNER_OPTION = new QuickReplyScene("SCENE_ASWEER_INNER_OPTION", 4, 4);
        SCENE_CROSS_END_DIFF_DISPLAY_OPTION = new QuickReplyScene("SCENE_CROSS_END_DIFF_DISPLAY_OPTION", 5, 5);
        SCENE_ABOVE_INPUT_BOX_OPTION = new QuickReplyScene("SCENE_ABOVE_INPUT_BOX_OPTION", 6, 6);
        SCENE_USE_LOCAL_APP = new QuickReplyScene("SCENE_USE_LOCAL_APP", 7, 7);
        SCENE_CONTROL_LOCAL_APP = new QuickReplyScene("SCENE_CONTROL_LOCAL_APP", 8, 8);
        SCENE_INIT_LOCAL_APP = new QuickReplyScene("SCENE_INIT_LOCAL_APP", 9, 9);
        SCENE_MOA_APPLET_GRANTING = new QuickReplyScene("SCENE_MOA_APPLET_GRANTING", 10, 12);
        QuickReplyScene[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static QuickReplyScene[] values() {
        return (QuickReplyScene[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static QuickReplyScene valueOf(String r100) {
        return (QuickReplyScene) a.a(QuickReplyScene.class, r100);
    }

    private QuickReplyScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

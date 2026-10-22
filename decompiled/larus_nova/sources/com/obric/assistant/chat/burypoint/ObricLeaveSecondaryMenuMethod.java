package com.obric.assistant.chat.burypoint;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/chat/burypoint/ObricLeaveSecondaryMenuMethod;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LEAVE_METHOD_CLICK_MINI_ICON", "LEAVE_METHOD_CLICK_SKILL_IN_PANEL", "LEAVE_METHOD_CLICK_WHITE_AREA", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricLeaveSecondaryMenuMethod extends Enum<ObricLeaveSecondaryMenuMethod> {
    public static final ObricLeaveSecondaryMenuMethod LEAVE_METHOD_CLICK_MINI_ICON = null;
    public static final ObricLeaveSecondaryMenuMethod LEAVE_METHOD_CLICK_SKILL_IN_PANEL = null;
    public static final ObricLeaveSecondaryMenuMethod LEAVE_METHOD_CLICK_WHITE_AREA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricLeaveSecondaryMenuMethod[] f386643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f386644b = null;
    private final String value;

    public static EnumEntries<ObricLeaveSecondaryMenuMethod> getEntries() {
        return f386644b;
    }

    static {
        ObricLeaveSecondaryMenuMethod r100 = new ObricLeaveSecondaryMenuMethod("LEAVE_METHOD_CLICK_MINI_ICON", 0, "click_mini_icon");
        LEAVE_METHOD_CLICK_MINI_ICON = r100;
        ObricLeaveSecondaryMenuMethod r101 = new ObricLeaveSecondaryMenuMethod("LEAVE_METHOD_CLICK_SKILL_IN_PANEL", 1, "click_skill_in_panel");
        LEAVE_METHOD_CLICK_SKILL_IN_PANEL = r101;
        ObricLeaveSecondaryMenuMethod r102 = new ObricLeaveSecondaryMenuMethod("LEAVE_METHOD_CLICK_WHITE_AREA", 2, "click_white_area");
        LEAVE_METHOD_CLICK_WHITE_AREA = r102;
        ObricLeaveSecondaryMenuMethod[] r103 = {r100, r101, r102};
        f386643a = r103;
        f386644b = EnumEntriesKt.enumEntries(r103);
    }

    public static ObricLeaveSecondaryMenuMethod[] values() {
        return (ObricLeaveSecondaryMenuMethod[]) f386643a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ObricLeaveSecondaryMenuMethod valueOf(String r100) {
        return (ObricLeaveSecondaryMenuMethod) a.a(ObricLeaveSecondaryMenuMethod.class, r100);
    }

    public ObricLeaveSecondaryMenuMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

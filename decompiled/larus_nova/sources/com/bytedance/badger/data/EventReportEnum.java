package com.bytedance.badger.data;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/badger/data/EventReportEnum;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", GXAnimation.STATE_START, "PHONE_INPUT", "PHONE_INPUT_START", "PHONE_INPUT_END", "AGREEMENT_BUTTON", "VERIFY_AND_LOGIN_BUTTON", "VERIFY_CODE_INPUT", "VERIFY_CODE_INPUT_START", "VERIFY_CODE_INPUT_END", "LOGIN_BUTTON", "TOUCH", "badger-api_release"}, k = 1, mv = {1, 4, 0})
public final enum EventReportEnum extends Enum<EventReportEnum> {
    public static final EventReportEnum AGREEMENT_BUTTON = null;
    public static final EventReportEnum LOGIN_BUTTON = null;
    public static final EventReportEnum PHONE_INPUT = null;
    public static final EventReportEnum PHONE_INPUT_END = null;
    public static final EventReportEnum PHONE_INPUT_START = null;
    public static final EventReportEnum START = null;
    public static final EventReportEnum TOUCH = null;
    public static final EventReportEnum VERIFY_AND_LOGIN_BUTTON = null;
    public static final EventReportEnum VERIFY_CODE_INPUT = null;
    public static final EventReportEnum VERIFY_CODE_INPUT_END = null;
    public static final EventReportEnum VERIFY_CODE_INPUT_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventReportEnum[] f199028a = null;
    private final String value;

    public static EventReportEnum valueOf(String r100) {
        return (EventReportEnum) a.a(EventReportEnum.class, r100);
    }

    public static EventReportEnum[] values() {
        return (EventReportEnum[]) f199028a.clone();
    }

    static {
        EventReportEnum r100 = new EventReportEnum(GXAnimation.STATE_START, 0, "start");
        START = r100;
        EventReportEnum r101 = new EventReportEnum("PHONE_INPUT", 1, "phone_input");
        PHONE_INPUT = r101;
        EventReportEnum r102 = new EventReportEnum("PHONE_INPUT_START", 2, "phone_input_start");
        PHONE_INPUT_START = r102;
        EventReportEnum r103 = new EventReportEnum("PHONE_INPUT_END", 3, "phone_input_end");
        PHONE_INPUT_END = r103;
        EventReportEnum r104 = new EventReportEnum("AGREEMENT_BUTTON", 4, "agreement_button");
        AGREEMENT_BUTTON = r104;
        EventReportEnum r105 = new EventReportEnum("VERIFY_AND_LOGIN_BUTTON", 5, "verify_and_login_button");
        VERIFY_AND_LOGIN_BUTTON = r105;
        EventReportEnum r106 = new EventReportEnum("VERIFY_CODE_INPUT", 6, "verify_code_input");
        VERIFY_CODE_INPUT = r106;
        EventReportEnum r107 = new EventReportEnum("VERIFY_CODE_INPUT_START", 7, "verify_code_input_start");
        VERIFY_CODE_INPUT_START = r107;
        EventReportEnum r108 = new EventReportEnum("VERIFY_CODE_INPUT_END", 8, "verify_code_input_end");
        VERIFY_CODE_INPUT_END = r108;
        EventReportEnum r109 = new EventReportEnum("LOGIN_BUTTON", 9, "login_button");
        LOGIN_BUTTON = r109;
        EventReportEnum r110 = new EventReportEnum("TOUCH", 10, "touch");
        TOUCH = r110;
        f199028a = new EventReportEnum[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getValue() {
        return this.value;
    }

    public EventReportEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

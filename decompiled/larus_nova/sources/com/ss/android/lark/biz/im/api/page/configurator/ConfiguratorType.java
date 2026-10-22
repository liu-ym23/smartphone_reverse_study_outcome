package com.ss.android.lark.biz.im.api.page.configurator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVITY_RESULT", "ON_BACK_PRESSED", "BOTTOM_SHEET", "MESSAGE_LIST", "SECRET_MESSAGE_LIST", "KEYBOARD_TOP", "KEYBOARD_WRAPPER", "SECRET_KEYBOARD_WRAPPER", "FOOTER_HINT", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConfiguratorType extends Enum<ConfiguratorType> {
    public static final ConfiguratorType ACTIVITY_RESULT = null;
    public static final ConfiguratorType BOTTOM_SHEET = null;
    public static final ConfiguratorType FOOTER_HINT = null;
    public static final ConfiguratorType KEYBOARD_TOP = null;
    public static final ConfiguratorType KEYBOARD_WRAPPER = null;
    public static final ConfiguratorType MESSAGE_LIST = null;
    public static final ConfiguratorType ON_BACK_PRESSED = null;
    public static final ConfiguratorType SECRET_KEYBOARD_WRAPPER = null;
    public static final ConfiguratorType SECRET_MESSAGE_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConfiguratorType[] f410431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410432b = null;

    public static EnumEntries<ConfiguratorType> getEntries() {
        return f410432b;
    }

    static {
        ConfiguratorType r100 = new ConfiguratorType("ACTIVITY_RESULT", 0);
        ACTIVITY_RESULT = r100;
        ConfiguratorType r101 = new ConfiguratorType("ON_BACK_PRESSED", 1);
        ON_BACK_PRESSED = r101;
        ConfiguratorType r102 = new ConfiguratorType("BOTTOM_SHEET", 2);
        BOTTOM_SHEET = r102;
        ConfiguratorType r103 = new ConfiguratorType("MESSAGE_LIST", 3);
        MESSAGE_LIST = r103;
        ConfiguratorType r104 = new ConfiguratorType("SECRET_MESSAGE_LIST", 4);
        SECRET_MESSAGE_LIST = r104;
        ConfiguratorType r105 = new ConfiguratorType("KEYBOARD_TOP", 5);
        KEYBOARD_TOP = r105;
        ConfiguratorType r110 = new ConfiguratorType("KEYBOARD_WRAPPER", 6);
        KEYBOARD_WRAPPER = r110;
        ConfiguratorType r111 = new ConfiguratorType("SECRET_KEYBOARD_WRAPPER", 7);
        SECRET_KEYBOARD_WRAPPER = r111;
        ConfiguratorType r112 = new ConfiguratorType("FOOTER_HINT", 8);
        FOOTER_HINT = r112;
        ConfiguratorType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f410431a = r113;
        f410432b = EnumEntriesKt.enumEntries(r113);
    }

    public static ConfiguratorType[] values() {
        return (ConfiguratorType[]) f410431a.clone();
    }

    public static ConfiguratorType valueOf(String r100) {
        return (ConfiguratorType) a.a(ConfiguratorType.class, r100);
    }

    public ConfiguratorType(String r100, int r101) {
        super(r100, r101);
    }
}

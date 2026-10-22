package com.larus.im.bean.message;

import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/UserType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "USER_TYPE_UNKNOWN", "HUMAN", "AIBOT", MediaScene.SYSTEM, "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserType extends Enum<UserType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UserType[] $VALUES = null;

    @SerialName("2")
    public static final UserType AIBOT = null;
    public static final a Companion = null;

    @SerialName("1")
    public static final UserType HUMAN = null;

    @SerialName("3")
    public static final UserType SYSTEM = null;

    @SerialName("0")
    public static final UserType USER_TYPE_UNKNOWN = null;
    public final int value;

    private static final /* synthetic */ UserType[] $values() {
        return new UserType[]{USER_TYPE_UNKNOWN, HUMAN, AIBOT, SYSTEM};
    }

    public static EnumEntries<UserType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.im.bean.message.UserType$a] */
    static {
        USER_TYPE_UNKNOWN = new UserType("USER_TYPE_UNKNOWN", 0, 0);
        HUMAN = new UserType("HUMAN", 1, 1);
        AIBOT = new UserType("AIBOT", 2, 2);
        SYSTEM = new UserType(MediaScene.SYSTEM, 3, 3);
        UserType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static UserType[] values() {
        return (UserType[]) $VALUES.clone();
    }

    public static UserType valueOf(String r100) {
        return (UserType) r27.a.a(UserType.class, r100);
    }

    private UserType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

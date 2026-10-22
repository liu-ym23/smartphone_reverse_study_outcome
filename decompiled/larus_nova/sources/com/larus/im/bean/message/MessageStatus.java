package com.larus.im.bean.message;

import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0014"}, d2 = {"Lcom/larus/im/bean/message/MessageStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MessageStatus_AVAILABLE", "MessageStatus_INVISIBLE", "MessageStatus_NOT_EXIST", "MessageStatus_DELETED", "MessageStatus_BEFOREEDIT", "MessageStatus_EDITED", "MessageStatus_REGEN_ROOT", "MessageStatus_UNSELECTED", "MessageStatus_REGENATED", "MessageStatus_NOTCOMPLIANT", "isVisible", "", "()Z", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageStatus extends Enum<MessageStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MessageStatus[] $VALUES = null;
    public static final a Companion = null;

    @SerialName("0")
    public static final MessageStatus MessageStatus_AVAILABLE = null;

    @SerialName("7")
    public static final MessageStatus MessageStatus_BEFOREEDIT = null;

    @SerialName("5")
    public static final MessageStatus MessageStatus_DELETED = null;

    @SerialName("6")
    public static final MessageStatus MessageStatus_EDITED = null;

    @SerialName("1")
    public static final MessageStatus MessageStatus_INVISIBLE = null;

    @SerialName("11")
    public static final MessageStatus MessageStatus_NOTCOMPLIANT = null;

    @SerialName("3")
    public static final MessageStatus MessageStatus_NOT_EXIST = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final MessageStatus MessageStatus_REGENATED = null;

    @SerialName("8")
    public static final MessageStatus MessageStatus_REGEN_ROOT = null;

    @SerialName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final MessageStatus MessageStatus_UNSELECTED = null;
    public final int value;

    public static final class a {
        public a() {
        }

        public static MessageStatus a(int r100) {
            if (r100 == 0) goto L19;
            if (r100 == 1) goto L29;
            if (r100 == 3) goto L28;
            switch(r100) {
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                default: goto L8;
            };
        L8:
            return null;
        L21:
            return MessageStatus.MessageStatus_NOTCOMPLIANT;
        L22:
            return MessageStatus.MessageStatus_REGENATED;
        L23:
            return MessageStatus.MessageStatus_UNSELECTED;
        L24:
            return MessageStatus.MessageStatus_REGEN_ROOT;
        L25:
            return MessageStatus.MessageStatus_BEFOREEDIT;
        L26:
            return MessageStatus.MessageStatus_EDITED;
        L27:
            return MessageStatus.MessageStatus_DELETED;
        L28:
            return MessageStatus.MessageStatus_NOT_EXIST;
        L29:
            return MessageStatus.MessageStatus_INVISIBLE;
        L19:
            return MessageStatus.MessageStatus_AVAILABLE;
        }
    }

    private static final /* synthetic */ MessageStatus[] $values() {
        return new MessageStatus[]{MessageStatus_AVAILABLE, MessageStatus_INVISIBLE, MessageStatus_NOT_EXIST, MessageStatus_DELETED, MessageStatus_BEFOREEDIT, MessageStatus_EDITED, MessageStatus_REGEN_ROOT, MessageStatus_UNSELECTED, MessageStatus_REGENATED, MessageStatus_NOTCOMPLIANT};
    }

    public static EnumEntries<MessageStatus> getEntries() {
        return $ENTRIES;
    }

    public final boolean isVisible() {
        return !SetsKt.setOf(new MessageStatus[]{MessageStatus_INVISIBLE, MessageStatus_NOT_EXIST, MessageStatus_DELETED, MessageStatus_BEFOREEDIT}).contains(this);
    }

    static {
        MessageStatus_AVAILABLE = new MessageStatus("MessageStatus_AVAILABLE", 0, 0);
        MessageStatus_INVISIBLE = new MessageStatus("MessageStatus_INVISIBLE", 1, 1);
        MessageStatus_NOT_EXIST = new MessageStatus("MessageStatus_NOT_EXIST", 2, 3);
        MessageStatus_DELETED = new MessageStatus("MessageStatus_DELETED", 3, 5);
        MessageStatus_BEFOREEDIT = new MessageStatus("MessageStatus_BEFOREEDIT", 4, 7);
        MessageStatus_EDITED = new MessageStatus("MessageStatus_EDITED", 5, 6);
        MessageStatus_REGEN_ROOT = new MessageStatus("MessageStatus_REGEN_ROOT", 6, 8);
        MessageStatus_UNSELECTED = new MessageStatus("MessageStatus_UNSELECTED", 7, 9);
        MessageStatus_REGENATED = new MessageStatus("MessageStatus_REGENATED", 8, 10);
        MessageStatus_NOTCOMPLIANT = new MessageStatus("MessageStatus_NOTCOMPLIANT", 9, 11);
        MessageStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static MessageStatus[] values() {
        return (MessageStatus[]) $VALUES.clone();
    }

    public static MessageStatus valueOf(String r100) {
        return (MessageStatus) r27.a.a(MessageStatus.class, r100);
    }

    private MessageStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

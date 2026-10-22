package com.ss.android.lark.chat.preview.entity.component;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000 \u001f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/Tag;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "UNKNOWN_TAG", "OFFICIAL", "ONCALL", "BOT", "MEETING", "APPROVAL", "SECRET_CHAT", "WHOLE", "DEPARTMENT", "EXTERNAL", "PUBLIC", "GROUP_ADMIN", "SUPERVISOR", "STOPPED", "OFFLINE", "DELETED", "UNACTIVATED", "EDU", "FROZEN", "ONCALL_OFFLINE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Tag extends Enum<Tag> implements Serializable {
    public static final Tag APPROVAL = null;
    public static final Tag BOT = null;
    public static final a Companion = null;
    public static final Tag DELETED = null;
    public static final Tag DEPARTMENT = null;
    public static final Tag EDU = null;
    public static final Tag EXTERNAL = null;
    public static final Tag FROZEN = null;
    public static final Tag GROUP_ADMIN = null;
    public static final Tag MEETING = null;
    public static final Tag OFFICIAL = null;
    public static final Tag OFFLINE = null;
    public static final Tag ONCALL = null;
    public static final Tag ONCALL_OFFLINE = null;
    public static final Tag PUBLIC = null;
    public static final Tag SECRET_CHAT = null;
    public static final Tag STOPPED = null;
    public static final Tag SUPERVISOR = null;
    public static final Tag UNACTIVATED = null;
    public static final Tag UNKNOWN_TAG = null;
    public static final Tag WHOLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Tag[] f416247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f416248b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Tag a(int r100) {
            if (r100 == 100) goto L26;
            switch(r100) {
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L42;
                case 4: goto L41;
                case 5: goto L40;
                case 6: goto L39;
                case 7: goto L38;
                case 8: goto L37;
                case 9: goto L36;
                case 10: goto L35;
                case 11: goto L34;
                case 12: goto L33;
                case 13: goto L32;
                case 14: goto L31;
                case 15: goto L30;
                case 16: goto L29;
                case 17: goto L28;
                case 18: goto L27;
                default: goto L24;
            };
        L24:
            return null;
        L27:
            return Tag.FROZEN;
        L28:
            return Tag.EDU;
        L29:
            return Tag.UNACTIVATED;
        L30:
            return Tag.DELETED;
        L31:
            return Tag.OFFLINE;
        L32:
            return Tag.STOPPED;
        L33:
            return Tag.SUPERVISOR;
        L34:
            return Tag.GROUP_ADMIN;
        L35:
            return Tag.PUBLIC;
        L36:
            return Tag.EXTERNAL;
        L37:
            return Tag.DEPARTMENT;
        L38:
            return Tag.WHOLE;
        L39:
            return Tag.SECRET_CHAT;
        L40:
            return Tag.APPROVAL;
        L41:
            return Tag.MEETING;
        L42:
            return Tag.BOT;
        L43:
            return Tag.ONCALL;
        L44:
            return Tag.OFFICIAL;
        L26:
            return Tag.ONCALL_OFFLINE;
        }
    }

    public static EnumEntries<Tag> getEntries() {
        return f416248b;
    }

    static {
        Tag r100 = new Tag("UNKNOWN_TAG", 0, 0);
        UNKNOWN_TAG = r100;
        Tag r101 = new Tag("OFFICIAL", 1, 1);
        OFFICIAL = r101;
        Tag r102 = new Tag("ONCALL", 2, 2);
        ONCALL = r102;
        Tag r103 = new Tag("BOT", 3, 3);
        BOT = r103;
        Tag r104 = new Tag("MEETING", 4, 4);
        MEETING = r104;
        Tag r105 = new Tag("APPROVAL", 5, 5);
        APPROVAL = r105;
        Tag r110 = new Tag("SECRET_CHAT", 6, 6);
        SECRET_CHAT = r110;
        Tag r111 = new Tag("WHOLE", 7, 7);
        WHOLE = r111;
        Tag r112 = new Tag("DEPARTMENT", 8, 8);
        DEPARTMENT = r112;
        Tag r113 = new Tag("EXTERNAL", 9, 9);
        EXTERNAL = r113;
        Tag r114 = new Tag("PUBLIC", 10, 10);
        PUBLIC = r114;
        Tag r115 = new Tag("GROUP_ADMIN", 11, 11);
        GROUP_ADMIN = r115;
        Tag r106 = new Tag("SUPERVISOR", 12, 12);
        SUPERVISOR = r106;
        Tag r107 = new Tag("STOPPED", 13, 13);
        STOPPED = r107;
        Tag r108 = new Tag("OFFLINE", 14, 14);
        OFFLINE = r108;
        Tag r109 = new Tag("DELETED", 15, 15);
        DELETED = r109;
        Tag r116 = new Tag("UNACTIVATED", 16, 16);
        UNACTIVATED = r116;
        Tag r117 = new Tag("EDU", 17, 17);
        EDU = r117;
        Tag r118 = new Tag("FROZEN", 18, 18);
        FROZEN = r118;
        Tag r119 = new Tag("ONCALL_OFFLINE", 19, 100);
        ONCALL_OFFLINE = r119;
        Tag[] r120 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        f416247a = r120;
        f416248b = EnumEntriesKt.enumEntries(r120);
        Companion = new a();
    }

    public static Tag[] values() {
        return (Tag[]) f416247a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Tag valueOf(String r100) {
        return (Tag) r27.a.a(Tag.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public Tag(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

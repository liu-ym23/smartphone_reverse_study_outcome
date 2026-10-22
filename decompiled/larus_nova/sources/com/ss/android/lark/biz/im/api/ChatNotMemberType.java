package com.ss.android.lark.biz.im.api;

import com.bytedance.lark.pb.feed.v1.ChatData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/biz/im/api/ChatNotMemberType;", "", "notMemberType", "", "<init>", "(Ljava/lang/String;II)V", "getNotMemberType", "()I", "NOT_JOINED_OR_EXITED", "NORMAL_DISSOLVED", "TNS_DISSOLVED", "Companion", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatNotMemberType extends Enum<ChatNotMemberType> {
    public static final a Companion = null;
    public static final ChatNotMemberType NORMAL_DISSOLVED = null;
    public static final ChatNotMemberType NOT_JOINED_OR_EXITED = null;
    public static final ChatNotMemberType TNS_DISSOLVED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatNotMemberType[] f409799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409800b = null;
    private final int notMemberType;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.biz.im.api.ChatNotMemberType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4767a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f409801a = null;

            static {
                int[] r100 = new int[ChatData.NotMemberType.values().length];
                r100[ChatData.NotMemberType.NOT_JOINED_OR_EXITED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[ChatData.NotMemberType.NORMAL_DISSOLVED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[ChatData.NotMemberType.TNS_DISSOLVED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f409801a = r100;
            }
        }

        public a() {
        }

        public static ChatNotMemberType a(ChatData.NotMemberType r100) {
            if (r100 != null) goto L4;
            int r101 = -1;
        L6:
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L18;
            if (r101 == 3) goto L17;
            return null;
        L17:
            return ChatNotMemberType.TNS_DISSOLVED;
        L18:
            return ChatNotMemberType.NORMAL_DISSOLVED;
        L15:
            return ChatNotMemberType.NOT_JOINED_OR_EXITED;
        L4:
            r101 = C4767a.f409801a[r100.ordinal()];
            goto L6
        }
    }

    public static EnumEntries<ChatNotMemberType> getEntries() {
        return f409800b;
    }

    static {
        ChatNotMemberType r100 = new ChatNotMemberType("NOT_JOINED_OR_EXITED", 0, 0);
        NOT_JOINED_OR_EXITED = r100;
        ChatNotMemberType r101 = new ChatNotMemberType("NORMAL_DISSOLVED", 1, 1);
        NORMAL_DISSOLVED = r101;
        ChatNotMemberType r102 = new ChatNotMemberType("TNS_DISSOLVED", 2, 2);
        TNS_DISSOLVED = r102;
        ChatNotMemberType[] r103 = {r100, r101, r102};
        f409799a = r103;
        f409800b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ChatNotMemberType[] values() {
        return (ChatNotMemberType[]) f409799a.clone();
    }

    public final int getNotMemberType() {
        return this.notMemberType;
    }

    public static ChatNotMemberType valueOf(String r100) {
        return (ChatNotMemberType) r27.a.a(ChatNotMemberType.class, r100);
    }

    public ChatNotMemberType(String r100, int r101, int r102) {
        super(r100, r101);
        this.notMemberType = r102;
    }
}

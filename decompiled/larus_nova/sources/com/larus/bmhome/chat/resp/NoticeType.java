package com.larus.bmhome.chat.resp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/resp/NoticeType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Undefined", "FollowFriend", "FollowBot", "UserInfoReview", "BotReview", "GlobalActivity", "Activity", "ChatWithUgcBot", "LikeUgcBot", "ReportUser", "ReportConv", "LikeCreation", "CommentCreation", "ReplyCreationComment", "LikeCreationComment", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NoticeType extends Enum<NoticeType> {
    public static final NoticeType Activity = null;
    public static final NoticeType BotReview = null;
    public static final NoticeType ChatWithUgcBot = null;
    public static final NoticeType CommentCreation = null;
    public static final NoticeType FollowBot = null;
    public static final NoticeType FollowFriend = null;
    public static final NoticeType GlobalActivity = null;
    public static final NoticeType LikeCreation = null;
    public static final NoticeType LikeCreationComment = null;
    public static final NoticeType LikeUgcBot = null;
    public static final NoticeType ReplyCreationComment = null;
    public static final NoticeType ReportConv = null;
    public static final NoticeType ReportUser = null;
    public static final NoticeType Undefined = null;
    public static final NoticeType UserInfoReview = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NoticeType[] f308558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308559b = null;
    private final int type;

    public static EnumEntries<NoticeType> getEntries() {
        return f308559b;
    }

    static {
        NoticeType r100 = new NoticeType("Undefined", 0, 0);
        Undefined = r100;
        NoticeType r101 = new NoticeType("FollowFriend", 1, 1);
        FollowFriend = r101;
        NoticeType r102 = new NoticeType("FollowBot", 2, 2);
        FollowBot = r102;
        NoticeType r103 = new NoticeType("UserInfoReview", 3, 3);
        UserInfoReview = r103;
        NoticeType r104 = new NoticeType("BotReview", 4, 4);
        BotReview = r104;
        NoticeType r105 = new NoticeType("GlobalActivity", 5, 5);
        GlobalActivity = r105;
        NoticeType r110 = new NoticeType("Activity", 6, 6);
        Activity = r110;
        NoticeType r111 = new NoticeType("ChatWithUgcBot", 7, 7);
        ChatWithUgcBot = r111;
        NoticeType r112 = new NoticeType("LikeUgcBot", 8, 8);
        LikeUgcBot = r112;
        NoticeType r113 = new NoticeType("ReportUser", 9, 9);
        ReportUser = r113;
        NoticeType r114 = new NoticeType("ReportConv", 10, 10);
        ReportConv = r114;
        NoticeType r115 = new NoticeType("LikeCreation", 11, 104);
        LikeCreation = r115;
        NoticeType r106 = new NoticeType("CommentCreation", 12, 113);
        CommentCreation = r106;
        NoticeType r107 = new NoticeType("ReplyCreationComment", 13, 114);
        ReplyCreationComment = r107;
        NoticeType r108 = new NoticeType("LikeCreationComment", 14, 115);
        LikeCreationComment = r108;
        NoticeType[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        f308558a = r109;
        f308559b = EnumEntriesKt.enumEntries(r109);
    }

    public static NoticeType[] values() {
        return (NoticeType[]) f308558a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static NoticeType valueOf(String r100) {
        return (NoticeType) a.a(NoticeType.class, r100);
    }

    public NoticeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}

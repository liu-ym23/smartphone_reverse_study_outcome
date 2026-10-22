package com.larus.platform.model.comment.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/comment/api/CommentScrollToIndexType;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "CURRENT", UserProfileEvent.POSITION_NONE, "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommentScrollToIndexType extends Enum<CommentScrollToIndexType> {
    public static final CommentScrollToIndexType CURRENT = null;
    public static final CommentScrollToIndexType NONE = null;
    public static final CommentScrollToIndexType TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentScrollToIndexType[] f365623a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365624b = null;

    public static EnumEntries<CommentScrollToIndexType> getEntries() {
        return f365624b;
    }

    static {
        CommentScrollToIndexType r100 = new CommentScrollToIndexType("TOP", 0);
        TOP = r100;
        CommentScrollToIndexType r101 = new CommentScrollToIndexType("CURRENT", 1);
        CURRENT = r101;
        CommentScrollToIndexType r102 = new CommentScrollToIndexType(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        CommentScrollToIndexType[] r103 = {r100, r101, r102};
        f365623a = r103;
        f365624b = EnumEntriesKt.enumEntries(r103);
    }

    public static CommentScrollToIndexType[] values() {
        return (CommentScrollToIndexType[]) f365623a.clone();
    }

    public static CommentScrollToIndexType valueOf(String r100) {
        return (CommentScrollToIndexType) a.a(CommentScrollToIndexType.class, r100);
    }

    public CommentScrollToIndexType(String r100, int r101) {
        super(r100, r101);
    }
}

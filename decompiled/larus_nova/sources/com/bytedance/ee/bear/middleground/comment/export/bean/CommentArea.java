package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class CommentArea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f231353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f231354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Type f231355c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentArea$Type;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "WHOLE_PAGE", "AREA", "CONTENT", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type AREA = null;
        public static final Type CONTENT = null;
        public static final Type NONE = null;
        public static final Type WHOLE_PAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f231356a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f231357b = null;

        public static EnumEntries<Type> getEntries() {
            return f231357b;
        }

        static {
            Type r100 = new Type(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Type r101 = new Type("WHOLE_PAGE", 1);
            WHOLE_PAGE = r101;
            Type r102 = new Type("AREA", 2);
            AREA = r102;
            Type r103 = new Type("CONTENT", 3);
            CONTENT = r103;
            Type[] r104 = {r100, r101, r102, r103};
            f231356a = r104;
            f231357b = EnumEntriesKt.enumEntries(r104);
        }

        public static Type[] values() {
            return (Type[]) f231356a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CommentArea() {
        this.f231355c = Type.NONE;
    }

    public final Type getType() {
        return this.f231355c;
    }
}

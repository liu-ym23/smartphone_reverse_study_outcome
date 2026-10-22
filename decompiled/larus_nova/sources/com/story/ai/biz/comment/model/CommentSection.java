package com.story.ai.biz.comment.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/story/ai/biz/comment/model/CommentSection;", "Ljava/io/Serializable;", "getCommentItemType", "Lcom/story/ai/biz/comment/model/CommentSection$CommentItemType;", "isLoadingOrEmptyOrFail", "", "CommentItemType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CommentSection extends Serializable {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/story/ai/biz/comment/model/CommentSection$CommentItemType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "PARENT_COMMENT", "CHILD_COMMENT", "EXPAND_COLLAPSE_COMMENT", "FOOTER", "LOADING", "EMPTY", "FAIL", "CUSTOM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CommentItemType extends Enum<CommentItemType> {
        public static final CommentItemType CHILD_COMMENT = null;
        public static final CommentItemType CUSTOM = null;
        public static final CommentItemType EMPTY = null;
        public static final CommentItemType EXPAND_COLLAPSE_COMMENT = null;
        public static final CommentItemType FAIL = null;
        public static final CommentItemType FOOTER = null;
        public static final CommentItemType LOADING = null;
        public static final CommentItemType PARENT_COMMENT = null;
        public static final CommentItemType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CommentItemType[] f459897a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f459898b = null;
        private final int type;

        public static EnumEntries<CommentItemType> getEntries() {
            return f459898b;
        }

        static {
            CommentItemType r100 = new CommentItemType("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            CommentItemType r101 = new CommentItemType("PARENT_COMMENT", 1, 1);
            PARENT_COMMENT = r101;
            CommentItemType r102 = new CommentItemType("CHILD_COMMENT", 2, 2);
            CHILD_COMMENT = r102;
            CommentItemType r103 = new CommentItemType("EXPAND_COLLAPSE_COMMENT", 3, 3);
            EXPAND_COLLAPSE_COMMENT = r103;
            CommentItemType r104 = new CommentItemType("FOOTER", 4, 4);
            FOOTER = r104;
            CommentItemType r105 = new CommentItemType("LOADING", 5, 101);
            LOADING = r105;
            CommentItemType r110 = new CommentItemType("EMPTY", 6, 102);
            EMPTY = r110;
            CommentItemType r111 = new CommentItemType("FAIL", 7, 103);
            FAIL = r111;
            CommentItemType r112 = new CommentItemType("CUSTOM", 8, 9999);
            CUSTOM = r112;
            CommentItemType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
            f459897a = r113;
            f459898b = EnumEntriesKt.enumEntries(r113);
        }

        public static CommentItemType[] values() {
            return (CommentItemType[]) f459897a.clone();
        }

        public static CommentItemType valueOf(String r100) {
            return (CommentItemType) r27.a.a(CommentItemType.class, r100);
        }

        public CommentItemType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
        public static boolean a(CommentSection r100) {
            if (r100.getCommentItemType() != CommentItemType.LOADING) goto L5;
        L10:
            return true;
        L5:
            if (r100.getCommentItemType() == CommentItemType.EMPTY) goto L10;
            if (r100.getCommentItemType() == CommentItemType.FAIL) goto L10;
            return false;
        }
    }

    CommentItemType getCommentItemType();

    boolean isLoadingOrEmptyOrFail();
}

package com.bytedance.ee.bear.middleground.comment.export.reaction;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ReactionFlowCacheEntity {
    public final String a;
    public final String b;
    public final String c;
    public final STATUS d;
    public final String e;
    public final String f;
    public final String g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/reaction/ReactionFlowCacheEntity$STATUS;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "DELETE", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum STATUS extends Enum<STATUS> {
        public static final STATUS ADD = null;
        public static final STATUS DELETE = null;
        public static final /* synthetic */ STATUS[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<STATUS> getEntries() {
            return b;
        }

        static {
            STATUS r0 = new STATUS("ADD", 0);
            ADD = r0;
            STATUS r1 = new STATUS("DELETE", 1);
            DELETE = r1;
            STATUS[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static STATUS[] values() {
            return (STATUS[]) a.clone();
        }

        public static STATUS valueOf(String r1) {
            return (STATUS) a.a(STATUS.class, r1);
        }

        public STATUS(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, this.e, this.f});
    }

    public final String toString() {
        return "ReactionFlowCacheEntity(reactionKey=" + this.a + ", userId=" + this.b + ", userName=" + this.c + ", status=" + this.d + ", replyId=" + this.e + ", commentId=" + this.f + ", actionId=" + this.g + ')';
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(ReactionFlowCacheEntity.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.reaction.ReactionFlowCacheEntity");
        ReactionFlowCacheEntity r6 = (ReactionFlowCacheEntity) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public ReactionFlowCacheEntity(String r2, String r3, String r4, STATUS r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "reactionKey");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "userName");
        Intrinsics.checkNotNullParameter(r5, "status");
        Intrinsics.checkNotNullParameter(r6, "replyId");
        Intrinsics.checkNotNullParameter(r7, "commentId");
        Intrinsics.checkNotNullParameter(r8, "actionId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}

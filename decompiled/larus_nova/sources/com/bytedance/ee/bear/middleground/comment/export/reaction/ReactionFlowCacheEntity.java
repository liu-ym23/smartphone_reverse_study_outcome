package com.bytedance.ee.bear.middleground.comment.export.reaction;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final class ReactionFlowCacheEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f231389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f231390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f231391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final STATUS f231392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f231393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f231394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f231395g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/reaction/ReactionFlowCacheEntity$STATUS;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "DELETE", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum STATUS extends Enum<STATUS> {
        public static final STATUS ADD = null;
        public static final STATUS DELETE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ STATUS[] f231396a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f231397b = null;

        public static EnumEntries<STATUS> getEntries() {
            return f231397b;
        }

        static {
            STATUS r100 = new STATUS("ADD", 0);
            ADD = r100;
            STATUS r101 = new STATUS("DELETE", 1);
            DELETE = r101;
            STATUS[] r102 = {r100, r101};
            f231396a = r102;
            f231397b = EnumEntriesKt.enumEntries(r102);
        }

        public static STATUS[] values() {
            return (STATUS[]) f231396a.clone();
        }

        public static STATUS valueOf(String r100) {
            return (STATUS) a.a(STATUS.class, r100);
        }

        public STATUS(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f231389a, this.f231390b, this.f231393e, this.f231394f});
    }

    public final String toString() {
        return "ReactionFlowCacheEntity(reactionKey=" + this.f231389a + ", userId=" + this.f231390b + ", userName=" + this.f231391c + ", status=" + this.f231392d + ", replyId=" + this.f231393e + ", commentId=" + this.f231394f + ", actionId=" + this.f231395g + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ReactionFlowCacheEntity.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.reaction.ReactionFlowCacheEntity");
        ReactionFlowCacheEntity r102 = (ReactionFlowCacheEntity) r100;
        if (Intrinsics.areEqual(this.f231389a, r102.f231389a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f231390b, r102.f231390b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f231393e, r102.f231393e) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f231394f, r102.f231394f) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public ReactionFlowCacheEntity(String r100, String r101, String r102, STATUS r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "reactionKey");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "userName");
        Intrinsics.checkNotNullParameter(r103, "status");
        Intrinsics.checkNotNullParameter(r104, "replyId");
        Intrinsics.checkNotNullParameter(r105, "commentId");
        Intrinsics.checkNotNullParameter(r106, "actionId");
        this.f231389a = r100;
        this.f231390b = r101;
        this.f231391c = r102;
        this.f231392d = r103;
        this.f231393e = r104;
        this.f231394f = r105;
        this.f231395g = r106;
    }
}

package com.larus.im.internal.jni.media;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0005J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniReplyUniqueId;", "", "queryRound", "", "replyRound", "", DBDefinition.TASK_ID, "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getQueryRound", "()J", "getReplyRound", "()Ljava/lang/String;", "getTaskId", "dirty", "", "makeDirty", "", "isDirty", "uniqueId", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniReplyUniqueId {
    public static final Companion Companion = null;
    private boolean dirty;
    private final long queryRound;
    private final String replyRound;
    private final String taskId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniReplyUniqueId$Companion;", "", "<init>", "()V", "uniqueId", "", "queryRound", "", "replyRound", DBDefinition.TASK_ID, "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String uniqueId(long r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "replyRound");
            Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
            return r102 + '_' + r100 + '_' + r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ OmniReplyUniqueId copy$default(OmniReplyUniqueId r100, long r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.queryRound;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.replyRound;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.taskId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.queryRound;
    }

    public final String component2() {
        return this.replyRound;
    }

    public final String component3() {
        return this.taskId;
    }

    public final OmniReplyUniqueId copy(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "replyRound");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        return new OmniReplyUniqueId(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniReplyUniqueId) == true) goto L8;
        return false;
    L8:
        OmniReplyUniqueId r101 = (OmniReplyUniqueId) r100;
        if (this.queryRound == r101.queryRound) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyRound, r101.replyRound) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.queryRound;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.replyRound.hashCode()) * 31) + this.taskId.hashCode();
    }

    public final void makeDirty() {
        this.dirty = true;
    }

    public String toString() {
        return "OmniReplyUniqueId(queryRound=" + this.queryRound + ", replyRound=" + this.replyRound + ", taskId=" + this.taskId + ')';
    }

    public final String uniqueId() {
        return Companion.uniqueId(this.queryRound, this.replyRound, this.taskId);
    }

    public final long getQueryRound() {
        return this.queryRound;
    }

    public final String getReplyRound() {
        return this.replyRound;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final boolean isDirty() {
        return this.dirty;
    }

    public OmniReplyUniqueId(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "replyRound");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        this.queryRound = r100;
        this.replyRound = r101;
        this.taskId = r102;
    }
}

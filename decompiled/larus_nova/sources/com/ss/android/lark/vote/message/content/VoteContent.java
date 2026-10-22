package com.ss.android.lark.vote.message.content;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.lark.pb.vote.v1.VoteContainerType;
import com.bytedance.lark.pb.vote.v1.VoteScopeType;
import com.bytedance.lark.pb.vote.v1.VoteStatus;
import com.ss.android.lark.chat.export.entity.message.Content;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010I\u001a\u00020\t2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0016J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020\u000bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J·\u0001\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\tHÆ\u0001J\u0013\u0010\\\u001a\u00020\t2\b\u0010]\u001a\u0004\u0018\u00010^HÖ\u0003J\t\u0010_\u001a\u00020`HÖ\u0001J\t\u0010a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001fR\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010!\"\u0004\b?\u0010#R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\u0019\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010)\"\u0004\bH\u0010+¨\u0006b"}, d2 = {"Lcom/ss/android/lark/vote/message/content/VoteContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "voteId", "", "topic", "", "minPickNum", "maxPickNum", "realName", "", "status", "Lcom/bytedance/lark/pb/vote/v1/VoteStatus;", "ownerUserId", "initiator", "expectVoteNum", "actualVoteNum", "options", "", "Lcom/ss/android/lark/vote/message/content/VoteOption;", ST.UUID_DEVICE, "scopeId", "scopeType", "Lcom/bytedance/lark/pb/vote/v1/VoteScopeType;", "containerType", "Lcom/bytedance/lark/pb/vote/v1/VoteContainerType;", "isVoted", "<init>", "(JLjava/lang/String;JJZLcom/bytedance/lark/pb/vote/v1/VoteStatus;Ljava/lang/String;JJJLjava/util/List;JLjava/lang/String;Lcom/bytedance/lark/pb/vote/v1/VoteScopeType;Lcom/bytedance/lark/pb/vote/v1/VoteContainerType;Z)V", "getVoteId", "()J", "setVoteId", "(J)V", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "getMinPickNum", "setMinPickNum", "getMaxPickNum", "setMaxPickNum", "getRealName", "()Z", "setRealName", "(Z)V", "getStatus", "()Lcom/bytedance/lark/pb/vote/v1/VoteStatus;", "setStatus", "(Lcom/bytedance/lark/pb/vote/v1/VoteStatus;)V", "getOwnerUserId", "setOwnerUserId", "getInitiator", "setInitiator", "getExpectVoteNum", "setExpectVoteNum", "getActualVoteNum", "setActualVoteNum", "getOptions", "()Ljava/util/List;", "setOptions", "(Ljava/util/List;)V", "getUuid", "setUuid", "getScopeId", "setScopeId", "getScopeType", "()Lcom/bytedance/lark/pb/vote/v1/VoteScopeType;", "setScopeType", "(Lcom/bytedance/lark/pb/vote/v1/VoteScopeType;)V", "getContainerType", "()Lcom/bytedance/lark/pb/vote/v1/VoteContainerType;", "setContainerType", "(Lcom/bytedance/lark/pb/vote/v1/VoteContainerType;)V", "setVoted", "isContentSame", "diffable", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "", "toString", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoteContent extends Content {
    private long actualVoteNum;
    private VoteContainerType containerType;
    private long expectVoteNum;
    private long initiator;
    private boolean isVoted;
    private long maxPickNum;
    private long minPickNum;
    private List<VoteOption> options;
    private String ownerUserId;
    private boolean realName;
    private String scopeId;
    private VoteScopeType scopeType;
    private VoteStatus status;
    private String topic;
    private long uuid;
    private long voteId;

    public VoteContent() {
        this(0, null, 0, 0, false, null, null, 0, 0, 0, null, 0, null, null, null, false, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VoteContent copy$default(VoteContent r110, long r111, String r210, long r211, long r212, boolean r213, VoteStatus r214, String r215, long r216, long r310, long r311, List r312, long r313, String r314, VoteScopeType r315, VoteContainerType r316, boolean r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        long r100 = r110.voteId;
    L7:
        if ((r411 & 2) == 0) goto L9;
        String r101 = r110.topic;
    L11:
        if ((r411 & 4) == 0) goto L13;
        long r102 = r110.minPickNum;
    L15:
        if ((r411 & 8) == 0) goto L17;
        long r103 = r110.maxPickNum;
    L19:
        if ((r411 & 16) == 0) goto L21;
        boolean r104 = r110.realName;
    L23:
        if ((r411 & 32) == 0) goto L25;
        VoteStatus r112 = r110.status;
    L27:
        if ((r411 & 64) == 0) goto L29;
        String r113 = r110.ownerUserId;
    L31:
        if ((r411 & 128) == 0) goto L33;
        long r114 = r110.initiator;
    L35:
        if ((r411 & 256) == 0) goto L37;
        long r115 = r110.expectVoteNum;
    L38:
        long r317 = r115;
        if ((r411 & 512) == 0) goto L41;
        long r116 = r110.actualVoteNum;
    L42:
        long r318 = r116;
        if ((r411 & 1024) == 0) goto L45;
        List r117 = r110.options;
    L46:
        List r319 = r117;
        if ((r411 & 2048) == 0) goto L49;
        long r118 = r110.uuid;
    L50:
        long r320 = r118;
        if ((r411 & 4096) == 0) goto L53;
        String r119 = r110.scopeId;
    L55:
        if ((r411 & 8192) == 0) goto L57;
        VoteScopeType r120 = r110.scopeType;
    L58:
        VoteScopeType r321 = r120;
        if ((r411 & 16384) == 0) goto L61;
        VoteContainerType r121 = r110.containerType;
    L63:
        if ((r411 & 32768) == 0) goto L65;
        boolean r105 = r110.isVoted;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r112, r113, r114, r317, r318, r319, r320, r119, r321, r121, r105);
    L65:
        r105 = r410;
        goto L67
    L61:
        r121 = r316;
        goto L63
    L57:
        r120 = r315;
        goto L58
    L53:
        r119 = r314;
        goto L55
    L49:
        r118 = r313;
        goto L50
    L45:
        r117 = r312;
        goto L46
    L41:
        r116 = r311;
        goto L42
    L37:
        r115 = r310;
        goto L38
    L33:
        r114 = r216;
        goto L35
    L29:
        r113 = r215;
        goto L31
    L25:
        r112 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.voteId;
    }

    public final long component10() {
        return this.actualVoteNum;
    }

    public final List<VoteOption> component11() {
        return this.options;
    }

    public final long component12() {
        return this.uuid;
    }

    public final String component13() {
        return this.scopeId;
    }

    public final VoteScopeType component14() {
        return this.scopeType;
    }

    public final VoteContainerType component15() {
        return this.containerType;
    }

    public final boolean component16() {
        return this.isVoted;
    }

    public final String component2() {
        return this.topic;
    }

    public final long component3() {
        return this.minPickNum;
    }

    public final long component4() {
        return this.maxPickNum;
    }

    public final boolean component5() {
        return this.realName;
    }

    public final VoteStatus component6() {
        return this.status;
    }

    public final String component7() {
        return this.ownerUserId;
    }

    public final long component8() {
        return this.initiator;
    }

    public final long component9() {
        return this.expectVoteNum;
    }

    public final VoteContent copy(long r210, String r211, long r212, long r310, boolean r311, VoteStatus r312, String r313, long r314, long r315, long r410, List<VoteOption> r411, long r412, String r413, VoteScopeType r414, VoteContainerType r415, boolean r416) {
        Intrinsics.checkNotNullParameter(r312, "status");
        Intrinsics.checkNotNullParameter(r411, "options");
        Intrinsics.checkNotNullParameter(r413, "scopeId");
        return new VoteContent(r210, r211, r212, r310, r311, r312, r313, r314, r315, r410, r411, r412, r413, r414, r415, r416);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoteContent) == true) goto L8;
        return false;
    L8:
        VoteContent r101 = (VoteContent) r100;
        if (this.voteId == r101.voteId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topic, r101.topic) == true) goto L15;
        return false;
    L15:
        if (this.minPickNum == r101.minPickNum) goto L18;
        return false;
    L18:
        if (this.maxPickNum == r101.maxPickNum) goto L21;
        return false;
    L21:
        if (this.realName == r101.realName) goto L24;
        return false;
    L24:
        if (this.status == r101.status) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ownerUserId, r101.ownerUserId) == true) goto L30;
        return false;
    L30:
        if (this.initiator == r101.initiator) goto L33;
        return false;
    L33:
        if (this.expectVoteNum == r101.expectVoteNum) goto L36;
        return false;
    L36:
        if (this.actualVoteNum == r101.actualVoteNum) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.options, r101.options) == true) goto L42;
        return false;
    L42:
        if (this.uuid == r101.uuid) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.scopeId, r101.scopeId) == true) goto L48;
        return false;
    L48:
        if (this.scopeType == r101.scopeType) goto L51;
        return false;
    L51:
        if (this.containerType == r101.containerType) goto L54;
        return false;
    L54:
        if (this.isVoted == r101.isVoted) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        long r100 = this.voteId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.topic;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        long r105 = this.minPickNum;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.maxPickNum;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        int r109 = 1231;
        if (this.realName == false) goto L9;
        int r110 = 1231;
    L10:
        int r111 = (((r108 + r110) * 31) + this.status.hashCode()) * 31;
        String r112 = this.ownerUserId;
        if (r112 != null) goto L13;
        int r113 = 0;
    L14:
        long r114 = this.initiator;
        int r115 = (((r111 + r113) * 31) + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.expectVoteNum;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.actualVoteNum;
        int r119 = (((r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31) + this.options.hashCode()) * 31;
        long r120 = this.uuid;
        int r121 = (((r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31) + this.scopeId.hashCode()) * 31;
        VoteScopeType r122 = this.scopeType;
        if (r122 != null) goto L17;
        int r123 = 0;
    L18:
        int r124 = (r121 + r123) * 31;
        VoteContainerType r125 = this.containerType;
        if (r125 == null) goto L22;
        r103 = r125.hashCode();
    L22:
        int r126 = (r124 + r103) * 31;
        if (this.isVoted == true) goto L27;
        r109 = 1237;
    L27:
        return r126 + r109;
    L17:
        r123 = r122.hashCode();
        goto L18
    L13:
        r113 = r112.hashCode();
        goto L14
    L9:
        r110 = 1237;
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "VoteContent(voteId=" + this.voteId + ", topic=" + this.topic + ", minPickNum=" + this.minPickNum + ", maxPickNum=" + this.maxPickNum + ", realName=" + this.realName + ", status=" + this.status + ", ownerUserId=" + this.ownerUserId + ", initiator=" + this.initiator + ", expectVoteNum=" + this.expectVoteNum + ", actualVoteNum=" + this.actualVoteNum + ", options=" + this.options + ", uuid=" + this.uuid + ", scopeId=" + this.scopeId + ", scopeType=" + this.scopeType + ", containerType=" + this.containerType + ", isVoted=" + this.isVoted + ')';
    }

    public final long getActualVoteNum() {
        return this.actualVoteNum;
    }

    public final VoteContainerType getContainerType() {
        return this.containerType;
    }

    public final long getExpectVoteNum() {
        return this.expectVoteNum;
    }

    public final long getInitiator() {
        return this.initiator;
    }

    public final long getMaxPickNum() {
        return this.maxPickNum;
    }

    public final long getMinPickNum() {
        return this.minPickNum;
    }

    public final List<VoteOption> getOptions() {
        return this.options;
    }

    public final String getOwnerUserId() {
        return this.ownerUserId;
    }

    public final boolean getRealName() {
        return this.realName;
    }

    public final String getScopeId() {
        return this.scopeId;
    }

    public final VoteScopeType getScopeType() {
        return this.scopeType;
    }

    public final VoteStatus getStatus() {
        return this.status;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final long getUuid() {
        return this.uuid;
    }

    public final long getVoteId() {
        return this.voteId;
    }

    public final boolean isVoted() {
        return this.isVoted;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if ((r100 instanceof VoteContent) == true) goto L5;
        return false;
    L5:
        if (this != r100) goto L9;
        return true;
    L9:
        if (a.a(Long.valueOf(this.voteId), Long.valueOf(((VoteContent) r100).voteId)) == true) goto L12;
        return false;
    L12:
        return super.isContentSame(r100);
    }

    public final void setActualVoteNum(long r100) {
        this.actualVoteNum = r100;
    }

    public final void setContainerType(VoteContainerType r100) {
        this.containerType = r100;
    }

    public final void setExpectVoteNum(long r100) {
        this.expectVoteNum = r100;
    }

    public final void setInitiator(long r100) {
        this.initiator = r100;
    }

    public final void setMaxPickNum(long r100) {
        this.maxPickNum = r100;
    }

    public final void setMinPickNum(long r100) {
        this.minPickNum = r100;
    }

    public final void setOptions(List<VoteOption> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.options = r100;
    }

    public final void setOwnerUserId(String r100) {
        this.ownerUserId = r100;
    }

    public final void setRealName(boolean r100) {
        this.realName = r100;
    }

    public final void setScopeId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scopeId = r100;
    }

    public final void setScopeType(VoteScopeType r100) {
        this.scopeType = r100;
    }

    public final void setStatus(VoteStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.status = r100;
    }

    public final void setTopic(String r100) {
        this.topic = r100;
    }

    public final void setUuid(long r100) {
        this.uuid = r100;
    }

    public final void setVoteId(long r100) {
        this.voteId = r100;
    }

    public final void setVoted(boolean r100) {
        this.isVoted = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }

    public VoteContent(long r100, String r101, long r110, long r111, boolean r112, VoteStatus r113, String r114, long r115, long r116, long r210, List<VoteOption> r211, long r212, String r213, VoteScopeType r214, VoteContainerType r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r113, "status");
        Intrinsics.checkNotNullParameter(r211, "options");
        Intrinsics.checkNotNullParameter(r213, "scopeId");
        this.voteId = r100;
        this.topic = r101;
        this.minPickNum = r110;
        this.maxPickNum = r111;
        this.realName = r112;
        this.status = r113;
        this.ownerUserId = r114;
        this.initiator = r115;
        this.expectVoteNum = r116;
        this.actualVoteNum = r210;
        this.options = r211;
        this.uuid = r212;
        this.scopeId = r213;
        this.scopeType = r214;
        this.containerType = r215;
        this.isVoted = r216;
    }

    public /* synthetic */ VoteContent(long r210, String r211, long r212, long r213, boolean r310, VoteStatus r311, String r312, long r313, long r314, long r315, List r410, long r411, String r412, VoteScopeType r413, VoteContainerType r414, boolean r415, int r416, DefaultConstructorMarker r417) {
        if ((r416 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r416 & 2) == 0) goto L9;
        String r101 = null;
    L10:
        long r102 = 1;
        if ((r416 & 4) == 0) goto L13;
        long r110 = 1;
    L15:
        if ((r416 & 8) != 0) goto L19;
        r102 = r213;
    L19:
        if ((r416 & 16) == 0) goto L21;
        boolean r103 = false;
    L23:
        if ((r416 & 32) == 0) goto L25;
        VoteStatus r111 = VoteStatus.CLOSE;
    L27:
        if ((r416 & 64) == 0) goto L29;
        String r112 = null;
    L31:
        if ((r416 & 128) == 0) goto L33;
        long r113 = 0;
    L35:
        if ((r416 & 256) == 0) goto L37;
        long r104 = 0;
    L39:
        if ((r416 & 512) == 0) goto L41;
        long r114 = 0;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        List r105 = Collections.emptyList();
    L47:
        if ((r416 & 2048) == 0) goto L49;
        long r115 = -1;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        String r116 = "";
    L54:
        String r418 = r116;
        if ((r416 & 8192) == 0) goto L57;
        VoteScopeType r117 = null;
    L58:
        VoteScopeType r214 = r117;
        if ((r416 & 16384) == 0) goto L61;
        VoteContainerType r118 = null;
    L63:
        if ((r416 & 32768) == 0) goto L65;
        boolean r106 = false;
    L66:
        this(r100, r101, r110, r102, r103, r111, r112, r113, r104, r114, r105, r115, r418, r214, r118, r106);
        return;
    L65:
        r106 = r415;
        goto L66
    L61:
        r118 = r414;
        goto L63
    L57:
        r117 = r413;
        goto L58
    L53:
        r116 = r412;
        goto L54
    L49:
        r115 = r411;
        goto L51
    L45:
        r105 = r410;
        goto L47
    L41:
        r114 = r315;
        goto L43
    L37:
        r104 = r314;
        goto L39
    L33:
        r113 = r313;
        goto L35
    L29:
        r112 = r312;
        goto L31
    L25:
        r111 = r311;
        goto L27
    L21:
        r103 = r310;
        goto L23
    L13:
        r110 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L10
    L5:
        r100 = r210;
        goto L7
    }
}

package com.bytedance.android.livesdk.log;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0 {
    public static a a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/log/a0$a;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "", "position", "I", "getPosition", "()I", "", "watchDuration", "J", "getWatchDuration", "()J", "giftCount", "getGiftCount", "giftValue", "getGiftValue", "likeCount", "getLikeCount", "commentCount", "getCommentCount", "doFollow", "getDoFollow", "doUnFollow", "getDoUnFollow", "livelogger_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("comment_count")
        private final int commentCount;

        @SerializedName("is_follow")
        private final int doFollow;

        @SerializedName("is_unfollow")
        private final int doUnFollow;

        @SerializedName("gift_count")
        private final long giftCount;

        @SerializedName("gift_value")
        private final long giftValue;

        @SerializedName("like_count")
        private final int likeCount;

        @SerializedName("position")
        private final int position;

        @SerializedName("gid")
        private final String roomId;

        @SerializedName("duration")
        private final long watchDuration;

        public a() {
            this(0);
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L24;
            a r7 = (a) r6;
            if (Intrinsics.areEqual(this.roomId, r7.roomId) == true) goto L8;
            return false;
        L8:
            if (this.position == r7.position) goto L10;
            return false;
        L10:
            if (this.watchDuration == r7.watchDuration) goto L12;
            return false;
        L12:
            if (this.giftCount == r7.giftCount) goto L14;
            return false;
        L14:
            if (this.giftValue == r7.giftValue) goto L16;
            return false;
        L16:
            if (this.likeCount == r7.likeCount) goto L18;
            return false;
        L18:
            if (this.commentCount == r7.commentCount) goto L20;
            return false;
        L20:
            if (this.doFollow == r7.doFollow) goto L22;
            return false;
        L22:
            if (this.doUnFollow == r7.doUnFollow) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public final int hashCode() {
            String r0 = this.roomId;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = ((r1 * 31) + this.position) * 31;
            long r3 = this.watchDuration;
            int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r5 = this.giftCount;
            int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
            long r7 = this.giftValue;
            return ((((((((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.likeCount) * 31) + this.commentCount) * 31) + this.doFollow) * 31) + this.doUnFollow;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "LiveRoomDetailInfo(roomId=" + this.roomId + ", position=" + this.position + ", watchDuration=" + this.watchDuration + ", giftCount=" + this.giftCount + ", giftValue=" + this.giftValue + ", likeCount=" + this.likeCount + ", commentCount=" + this.commentCount + ", doFollow=" + this.doFollow + ", doUnFollow=" + this.doUnFollow + ")";
        }

        public /* synthetic */ a(int r14) {
            this("", 0, 0, 0, 0, 0, 0, 0, 0);
        }

        public a(String r1, int r2, long r3, long r5, long r7, int r9, int r10, int r11, int r12) {
            this.roomId = r1;
            this.position = r2;
            this.watchDuration = r3;
            this.giftCount = r5;
            this.giftValue = r7;
            this.likeCount = r9;
            this.commentCount = r10;
            this.doFollow = r11;
            this.doUnFollow = r12;
        }
    }

    static {
        a = new a(0);
    }

    public static String a() {
        String r0 = GsonProtectorUtils.toJson(new Gson(), a);
        if (r0.length() <= 600) goto L6;
        return "";
    L6:
        return r0;
    }
}

package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001a\u0010$\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000bR \u0010(\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010\u0013\u0012\u0004\b*\u0010\r\u001a\u0004\b)\u0010\u0015R \u0010+\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b+\u0010\u0013\u0012\u0004\b-\u0010\r\u001a\u0004\b,\u0010\u0015R\u001a\u0010/\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/h;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "avatarThumb", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "userId", "Ljava/lang/Long;", "getUserId", "()Ljava/lang/Long;", "getUserId$annotations", "()V", "secUid", "getSecUid", "nickName", "f", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "J", "getPercentage", "()J", "songTitle", "j", "", "score", "F", "g", "()F", "", "isHighScoreSong", "Z", "l", "()Z", "midiTips", "e", "hitMidiRecordABTest", "d", "songId", "i", "anchorId", "getAnchorId", "getAnchorId$annotations", "senderUserID", "getSenderUserID", "getSenderUserID$annotations", "", "highScoreSongThreshold", "D", "c", "()D", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {
    public String a;

    @SerializedName("anchor_id")
    private final long anchorId;

    @SerializedName("avatar_thumb")
    private final String avatarThumb;
    public String b;

    @SerializedName("threshold")
    private final double highScoreSongThreshold;

    @SerializedName("hit_record_ab")
    private final boolean hitMidiRecordABTest;

    @SerializedName("is_high_score")
    private final boolean isHighScoreSong;

    @SerializedName("midi_tips")
    private final String midiTips;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE)
    private final long percentage;

    @SerializedName("score")
    private final float score;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("sender_user_id")
    private final long senderUserID;

    @SerializedName("song_id")
    private final Long songId;

    @SerializedName("song_title")
    private final String songTitle;

    @SerializedName("user_id")
    private final Long userId;

    public static final class a {
    }

    static {
    }

    public h() {
        this(null, null, null, null, 0, null, 0.0f, false, null, false, null, 0, 0.0d, 16383);
    }

    public final String h() {
        if (TextUtils.isEmpty(this.a) == false) goto L6;
        this.a = t.k(this.senderUserID);
    L6:
        return this.a;
    }

    public final String k() {
        if (TextUtils.isEmpty(this.b) == false) goto L10;
        Long r0 = this.userId;
        if (r0 == null) goto L7;
        long r1 = r0.longValue();
    L8:
        this.b = t.k(r1);
        goto L10
    L7:
        r1 = 0;
    L10:
        return this.b;
    }

    public final String b() {
        return this.avatarThumb;
    }

    public final double c() {
        return this.highScoreSongThreshold;
    }

    public final boolean d() {
        return this.hitMidiRecordABTest;
    }

    public final String e() {
        return this.midiTips;
    }

    public final String f() {
        return this.nickName;
    }

    public final float g() {
        return this.score;
    }

    public final Long i() {
        return this.songId;
    }

    public final String j() {
        return this.songTitle;
    }

    public final boolean l() {
        return this.isHighScoreSong;
    }

    public h(String r23, Long r24, String r25, String r26, long r27, String r29, float r30, boolean r31, String r32, boolean r33, Long r34, long r35, double r37, int r39) {
        if ((r39 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r39 & 2) == 0) goto L9;
        Long r4 = null;
    L11:
        if ((r39 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r39 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r39 & 16) == 0) goto L21;
        long r10 = 0;
    L23:
        if ((r39 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r39 & 64) == 0) goto L29;
        float r13 = 0.0f;
    L31:
        if ((r39 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        boolean r14 = false;
    L35:
        if ((r39 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        String r3 = "";
    L39:
        if ((r39 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        boolean r15 = false;
    L43:
        if ((r39 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        Long r8 = null;
    L47:
        if ((r39 & 2048) == 0) goto L49;
        long r16 = 0;
    L51:
        if ((r39 & 8192) == 0) goto L53;
        double r20 = 0.0d;
    L54:
        this.avatarThumb = r2;
        this.userId = r4;
        this.secUid = r5;
        this.nickName = r6;
        this.percentage = r10;
        this.songTitle = r7;
        this.score = r13;
        this.isHighScoreSong = r14;
        this.midiTips = r3;
        this.hitMidiRecordABTest = r15;
        this.songId = r8;
        this.anchorId = r16;
        this.senderUserID = 0;
        this.highScoreSongThreshold = r20;
        this.a = "";
        this.b = "";
        return;
    L53:
        r20 = r37;
        goto L54
    L49:
        r16 = r35;
        goto L51
    L45:
        r8 = r34;
        goto L47
    L41:
        r15 = r33;
        goto L43
    L37:
        r3 = r32;
        goto L39
    L33:
        r14 = r31;
        goto L35
    L29:
        r13 = r30;
        goto L31
    L25:
        r7 = r29;
        goto L27
    L21:
        r10 = r27;
        goto L23
    L17:
        r6 = r26;
        goto L19
    L13:
        r5 = r25;
        goto L15
    L9:
        r4 = r24;
        goto L11
    L5:
        r2 = r23;
        goto L7
    }
}

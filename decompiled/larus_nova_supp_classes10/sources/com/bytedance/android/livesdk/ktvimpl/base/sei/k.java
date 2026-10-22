package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001sR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR0\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010\"\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001c\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\rR\u001a\u0010.\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R \u00106\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b6\u0010\u0004\u0012\u0004\b8\u0010\b\u001a\u0004\b7\u0010\u0006R\u001a\u00109\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\rR$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\rR\u001a\u0010D\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010\u001d\u001a\u0004\bE\u0010\u001fR\u001a\u0010F\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010\u000b\u001a\u0004\bG\u0010\rR$\u0010H\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010/\u001a\u0004\bI\u00101\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bM\u0010\rR\u001c\u0010O\u001a\u0004\u0018\u00010N8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bS\u0010\u000b\u001a\u0004\bT\u0010\rR\u001c\u0010U\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010/\u001a\u0004\bV\u00101R$\u0010W\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010/\u001a\u0004\bX\u00101\"\u0004\bY\u0010KR$\u0010Z\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010/\u001a\u0004\b[\u00101\"\u0004\b\\\u0010KR\u001c\u0010]\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R$\u0010a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010^\u001a\u0004\bb\u0010`\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\be\u00103\u001a\u0004\be\u00105R\u001a\u0010f\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\u001d\u001a\u0004\bg\u0010\u001fR\u001a\u0010h\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010/\u001a\u0004\bi\u00101R\u001c\u0010k\u001a\u0004\u0018\u00010j8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\"\u0010o\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\bo\u0010\u0015\u001a\u0004\bp\u0010\u0017R\"\u0010q\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\bq\u0010\u0015\u001a\u0004\br\u0010\u0017¨\u0006t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/k;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "anchorId", "J", "getAnchorId", "()J", "getAnchorId$annotations", "()V", "", "cmd", "I", "d", "()I", "scene", "z", "lyricsType", "n", "", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/v;", "lyricsInfo", "Ljava/util/List;", "l", "()Ljava/util/List;", "L", "(Ljava/util/List;)V", "getLyricsInfo$annotations", "", "playTime", "F", "y", "()F", "id", "j", "duration", "h", "lyricsOffset", "m", "", "showScore", "Ljava/lang/Boolean;", "getShowScore", "()Ljava/lang/Boolean;", "mode", "u", "", "coverUrl", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "forceHide", "Z", "i", "()Z", "senderUserID", "getSenderUserID", "getSenderUserID$annotations", BaseCoreViewModel.CORE_TAG_STATE, "C", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;", "orderInfo", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;", "w", "()Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;", "setOrderInfo", "(Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;)V", "playFlag", "x", "start", "B", "musicPlayStatus", "v", "lyricsUrl", "p", "M", "(Ljava/lang/String;)V", "songType", "getSongType", "Loe2/e;", "ktvRoomState", "Loe2/e;", "k", "()Loe2/e;", "sync_index", "getSync_index", "vId", "D", "midiUrl", "t", "N", "vocalUrl", "getVocalUrl", "setVocalUrl", "midiStatus", "Ljava/lang/Integer;", "s", "()Ljava/lang/Integer;", "midiCover", "q", "setMidiCover", "(Ljava/lang/Integer;)V", "isInChorus", "ballPos", "c", "midiDressId", "r", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/x;", "wantListenInfo", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/x;", "E", "()Lcom/bytedance/android/livesdk/ktvimpl/base/sei/x;", "copyrightedAppIds", "e", "copyrightedRegionIds", "f", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {
    public String a;

    @SerializedName("anchor_id")
    private final long anchorId;
    public String b;

    @SerializedName("grid_y")
    private final float ballPos;

    @SerializedName("cmd")
    private final int cmd;

    @SerializedName("copyrighted_app_ids")
    private final List<Integer> copyrightedAppIds;

    @SerializedName("copyrighted_region_ids")
    private final List<String> copyrightedRegionIds;

    @SerializedName("cover_url")
    private final String coverUrl;

    @SerializedName("duration")
    private final float duration;

    @SerializedName("force_hide")
    private final boolean forceHide;

    @SerializedName("id")
    private final long id;

    @SerializedName("is_in_chorus")
    private final boolean isInChorus;

    @SerializedName("roomState")
    private final oe2.e ktvRoomState;

    @SerializedName("lyrics_info")
    private List<v> lyricsInfo;

    @SerializedName("lyrics_offset")
    private final float lyricsOffset;

    @SerializedName("lyrics_type")
    private final int lyricsType;

    @SerializedName("lyric_url")
    private String lyricsUrl;

    @SerializedName("midi_cover")
    private Integer midiCover;

    @SerializedName("midi_dress_id")
    private final String midiDressId;

    @SerializedName("midi_status")
    private final Integer midiStatus;

    @SerializedName("midi_url")
    private String midiUrl;

    @SerializedName("mode")
    private final int mode;

    @SerializedName("music_play_status")
    private final int musicPlayStatus;

    @SerializedName("order_info")
    private q orderInfo;

    @SerializedName("play_flag")
    private final int playFlag;

    @SerializedName("playTime")
    private final float playTime;

    @SerializedName("scene")
    private final int scene;

    @SerializedName("sender_user_id")
    private final long senderUserID;

    @SerializedName("show_score")
    private final Boolean showScore;

    @SerializedName("song_type")
    private final int songType;

    @SerializedName("start")
    private final float start;

    @SerializedName(BaseCoreViewModel.CORE_TAG_STATE)
    private final int state;

    @SerializedName("sync_index")
    private final int sync_index;

    @SerializedName("vid")
    private final String vId;

    @SerializedName("vocal_url")
    private String vocalUrl;

    @SerializedName("want_listen_info")
    private final x wantListenInfo;

    public static final class a {
    }

    static {
    }

    public final void L() {
        this.lyricsInfo = null;
    }

    public final void M() {
        this.lyricsUrl = null;
    }

    public final void N() {
        this.midiUrl = null;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof k) == false) goto L74;
        k r7 = (k) r6;
        if (this.anchorId == r7.anchorId) goto L8;
        return false;
    L8:
        if (this.cmd == r7.cmd) goto L10;
        return false;
    L10:
        if (this.scene == r7.scene) goto L12;
        return false;
    L12:
        if (this.lyricsType == r7.lyricsType) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.lyricsInfo, r7.lyricsInfo) == true) goto L16;
        return false;
    L16:
        if (Float.compare(this.playTime, r7.playTime) == 0) goto L18;
        return false;
    L18:
        if (this.id == r7.id) goto L20;
        return false;
    L20:
        if (Float.compare(this.duration, r7.duration) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.lyricsOffset, r7.lyricsOffset) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showScore, r7.showScore) == true) goto L26;
        return false;
    L26:
        if (this.mode == r7.mode) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.coverUrl, r7.coverUrl) == true) goto L30;
        return false;
    L30:
        if (this.forceHide == r7.forceHide) goto L32;
        return false;
    L32:
        if (this.senderUserID == r7.senderUserID) goto L34;
        return false;
    L34:
        if (this.state == r7.state) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.orderInfo, r7.orderInfo) == true) goto L38;
        return false;
    L38:
        if (this.playFlag == r7.playFlag) goto L40;
        return false;
    L40:
        if (Float.compare(this.start, r7.start) == 0) goto L42;
        return false;
    L42:
        if (this.musicPlayStatus == r7.musicPlayStatus) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.lyricsUrl, r7.lyricsUrl) == true) goto L46;
        return false;
    L46:
        if (this.songType == r7.songType) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ktvRoomState, r7.ktvRoomState) == true) goto L50;
        return false;
    L50:
        if (this.sync_index == r7.sync_index) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.vId, r7.vId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.midiUrl, r7.midiUrl) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.vocalUrl, r7.vocalUrl) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.midiStatus, r7.midiStatus) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.midiCover, r7.midiCover) == true) goto L62;
        return false;
    L62:
        if (this.isInChorus == r7.isInChorus) goto L64;
        return false;
    L64:
        if (Float.compare(this.ballPos, r7.ballPos) == 0) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.midiDressId, r7.midiDressId) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.wantListenInfo, r7.wantListenInfo) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.copyrightedAppIds, r7.copyrightedAppIds) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.copyrightedRegionIds, r7.copyrightedRegionIds) == true) goto L112;
        return false;
    L112:
        return true;
    L74:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final int hashCode() {
        long r0 = this.anchorId;
        int r1 = ((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.cmd) * 31) + this.scene) * 31) + this.lyricsType) * 31;
        List<v> r2 = this.lyricsInfo;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (((r1 + r4) * 31) + Float.floatToIntBits(this.playTime)) * 31;
        long r6 = this.id;
        int r7 = (((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + Float.floatToIntBits(this.duration)) * 31) + Float.floatToIntBits(this.lyricsOffset)) * 31;
        Boolean r8 = this.showScore;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        int r10 = (((r7 + r9) * 31) + this.mode) * 31;
        String r11 = this.coverUrl;
        if (r11 == null) goto L13;
        int r12 = r11.hashCode();
    L14:
        int r13 = (r10 + r12) * 31;
        boolean r14 = this.forceHide;
        ?? r15 = 1;
        ?? r16 = r14;
        if (r14 == false) goto L17;
        r16 = 1;
    L17:
        long r17 = this.senderUserID;
        int r18 = (((((r13 + r16) * 31) + ((int) (r17 ^ (r17 >>> 32)))) * 31) + this.state) * 31;
        q r19 = this.orderInfo;
        if (r19 == null) goto L20;
        int r20 = r19.hashCode();
    L21:
        int r21 = (((((((r18 + r20) * 31) + this.playFlag) * 31) + Float.floatToIntBits(this.start)) * 31) + this.musicPlayStatus) * 31;
        String r22 = this.lyricsUrl;
        if (r22 == null) goto L24;
        int r23 = r22.hashCode();
    L25:
        int r24 = (((r21 + r23) * 31) + this.songType) * 31;
        oe2.e r25 = this.ktvRoomState;
        if (r25 == null) goto L28;
        int r26 = r25.hashCode();
    L29:
        int r27 = (((r24 + r26) * 31) + this.sync_index) * 31;
        String r28 = this.vId;
        if (r28 == null) goto L32;
        int r29 = r28.hashCode();
    L33:
        int r30 = (r27 + r29) * 31;
        String r31 = this.midiUrl;
        if (r31 == null) goto L36;
        int r32 = r31.hashCode();
    L37:
        int r33 = (r30 + r32) * 31;
        String r34 = this.vocalUrl;
        if (r34 == null) goto L40;
        int r35 = r34.hashCode();
    L41:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.midiStatus;
        if (r37 == null) goto L44;
        int r38 = r37.hashCode();
    L45:
        int r39 = (r36 + r38) * 31;
        Integer r40 = this.midiCover;
        if (r40 == null) goto L48;
        int r41 = r40.hashCode();
    L49:
        int r42 = (r39 + r41) * 31;
        boolean r43 = this.isInChorus;
        if (r43 == true) goto L53;
        r15 = r43;
    L53:
        int r44 = (((r42 + r15) * 31) + Float.floatToIntBits(this.ballPos)) * 31;
        String r45 = this.midiDressId;
        if (r45 == null) goto L56;
        int r46 = r45.hashCode();
    L57:
        int r47 = (r44 + r46) * 31;
        x r48 = this.wantListenInfo;
        if (r48 == null) goto L60;
        int r49 = r48.hashCode();
    L61:
        int r50 = (r47 + r49) * 31;
        List<Integer> r51 = this.copyrightedAppIds;
        if (r51 == null) goto L64;
        int r52 = r51.hashCode();
    L65:
        int r53 = (r50 + r52) * 31;
        List<String> r54 = this.copyrightedRegionIds;
        if (r54 == null) goto L69;
        r3 = r54.hashCode();
    L69:
        return r53 + r3;
    L64:
        r52 = 0;
        goto L65
    L60:
        r49 = 0;
        goto L61
    L56:
        r46 = 0;
        goto L57
    L48:
        r41 = 0;
        goto L49
    L44:
        r38 = 0;
        goto L45
    L40:
        r35 = 0;
        goto L41
    L36:
        r32 = 0;
        goto L37
    L32:
        r29 = 0;
        goto L33
    L28:
        r26 = 0;
        goto L29
    L24:
        r23 = 0;
        goto L25
    L20:
        r20 = 0;
        goto L21
    L13:
        r12 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvSeiModelCompat(anchorId=" + this.anchorId + ", cmd=" + this.cmd + ", scene=" + this.scene + ", lyricsType=" + this.lyricsType + ", lyricsInfo=" + this.lyricsInfo + ", playTime=" + this.playTime + ", id=" + this.id + ", duration=" + this.duration + ", lyricsOffset=" + this.lyricsOffset + ", showScore=" + this.showScore + ", mode=" + this.mode + ", coverUrl=" + this.coverUrl + ", forceHide=" + this.forceHide + ", senderUserID=" + this.senderUserID + ", state=" + this.state + ", orderInfo=" + this.orderInfo + ", playFlag=" + this.playFlag + ", start=" + this.start + ", musicPlayStatus=" + this.musicPlayStatus + ", lyricsUrl=" + this.lyricsUrl + ", songType=" + this.songType + ", ktvRoomState=" + this.ktvRoomState + ", sync_index=" + this.sync_index + ", vId=" + this.vId + ", midiUrl=" + this.midiUrl + ", vocalUrl=" + this.vocalUrl + ", midiStatus=" + this.midiStatus + ", midiCover=" + this.midiCover + ", isInChorus=" + this.isInChorus + ", ballPos=" + this.ballPos + ", midiDressId=" + this.midiDressId + ", wantListenInfo=" + this.wantListenInfo + ", copyrightedAppIds=" + this.copyrightedAppIds + ", copyrightedRegionIds=" + this.copyrightedRegionIds + ")";
    }

    public final String A() {
        if (TextUtils.isEmpty(this.b) == false) goto L6;
        this.b = t.k(this.senderUserID);
    L6:
        return this.b;
    }

    public final boolean F() {
        int r0 = this.scene;
        if (r0 == 3) goto L7;
        if (r0 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean G() {
        if (this.scene == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean H() {
        if (this.scene != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean I() {
        if (this.scene != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean J() {
        List<v> r0 = this.lyricsInfo;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        String r2 = this.lyricsUrl;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r2.length() == 0) goto L16;
        r3 = false;
        goto L17
    L20:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean K() {
        if (this.musicPlayStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.a) == false) goto L6;
        this.a = t.k(this.anchorId);
    L6:
        return this.a;
    }

    public final boolean o() {
        int r0 = this.lyricsType;
        if (r0 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 2) goto L8;
        return false;
    }

    public final float B() {
        return this.start;
    }

    public final int C() {
        return this.state;
    }

    public final String D() {
        return this.vId;
    }

    public final x E() {
        return this.wantListenInfo;
    }

    public final float c() {
        return this.ballPos;
    }

    public final int d() {
        return this.cmd;
    }

    public final List<Integer> e() {
        return this.copyrightedAppIds;
    }

    public final List<String> f() {
        return this.copyrightedRegionIds;
    }

    public final String g() {
        return this.coverUrl;
    }

    public final float h() {
        return this.duration;
    }

    public final boolean i() {
        return this.forceHide;
    }

    public final long j() {
        return this.id;
    }

    public final oe2.e k() {
        return this.ktvRoomState;
    }

    public final List<v> l() {
        return this.lyricsInfo;
    }

    public final float m() {
        return this.lyricsOffset;
    }

    public final int n() {
        return this.lyricsType;
    }

    public final String p() {
        return this.lyricsUrl;
    }

    public final Integer q() {
        return this.midiCover;
    }

    public final String r() {
        return this.midiDressId;
    }

    public final Integer s() {
        return this.midiStatus;
    }

    public final String t() {
        return this.midiUrl;
    }

    public final int u() {
        return this.mode;
    }

    public final int v() {
        return this.musicPlayStatus;
    }

    public final q w() {
        return this.orderInfo;
    }

    public final int x() {
        return this.playFlag;
    }

    public final float y() {
        return this.playTime;
    }

    public final int z() {
        return this.scene;
    }
}

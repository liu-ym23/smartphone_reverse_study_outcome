package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.livesdk.message.model.c7;
import com.bytedance.android.livesdk.message.model.d8;
import com.bytedance.android.livesdk.message.model.eb;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdk.message.model.xa;
import com.bytedance.android.livesdk.message.model.xb;
import com.bytedance.android.livesdk.message.model.y7;
import com.bytedance.android.livesdk.message.model.ya;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003+,-R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/ILinkMicGuideMessageBridge;", "Lvh7/c;", "", "getGuidelineType", "()J", "guidelineType", "", "getAudienceLimit", "()I", "audienceLimit", "Lcom/bytedance/android/livesdk/message/model/f6;", "getAnchorGuideInfo", "()Lcom/bytedance/android/livesdk/message/model/f6;", "anchorGuideInfo", "Lcom/bytedance/android/livesdk/message/model/ya;", "getNormalPaidLinkmicMigrateToPlayContent", "()Lcom/bytedance/android/livesdk/message/model/ya;", "normalPaidLinkmicMigrateToPlayContent", "Lcom/bytedance/android/livesdk/message/model/xa;", "getNormalPaidLinkmicExplainCardContent", "()Lcom/bytedance/android/livesdk/message/model/xa;", "normalPaidLinkmicExplainCardContent", "Lcom/bytedance/android/livesdk/message/model/eb;", "getPlayModeGuideBubbleContent", "()Lcom/bytedance/android/livesdk/message/model/eb;", "playModeGuideBubbleContent", "Lcom/bytedance/android/livesdk/message/model/xb;", "getTeamFightBubbleGuideContent", "()Lcom/bytedance/android/livesdk/message/model/xb;", "teamFightBubbleGuideContent", "Lcom/bytedance/android/livesdk/message/model/y7;", "getGuestBattleBubbleGuideContent", "()Lcom/bytedance/android/livesdk/message/model/y7;", "guestBattleBubbleGuideContent", "Lcom/bytedance/android/livesdk/message/model/c7;", "getCreateGroupChatGuideContent", "()Lcom/bytedance/android/livesdk/message/model/c7;", "createGroupChatGuideContent", "Lcom/bytedance/android/livesdk/message/model/d8;", "getJoinGroupChatGuideContent", "()Lcom/bytedance/android/livesdk/message/model/d8;", "joinGroupChatGuideContent", "Companion", "BubbleEnhanceType", "a", "GroupType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkMicGuideMessageBridge extends vh7.c<ILinkMicGuideMessageBridge> {
    public static final long AUDIO_CHATROMM_GUIDELINE = 0;
    public static final long CALL_TO_LINKMIC = 3;
    public static final long CREATE_GROUP_CHAT_GUIDE = 5;
    public static final long CROSS_LINK_GUIDE_AUDIO_BUBBLE_ANIMATION = 16;
    public static final long CROSS_LINK_GUIDE_BUBBLE = 15;
    public static final a Companion = null;
    public static final long FAST_MATCH_GUIDELINE = 2;
    public static final long GUEST_BATTLE_BUBBLE_GUIDE = 7;
    public static final long JOIN_GROUP_CHAT_GUIDE = 6;
    public static final long KTV_ADD_SONG_GUIDE = 4;
    public static final long LINKMIC_FOLLOW_EFFECT = 11;
    public static final long LINKMIC_ICON_WHEN_HIDDEN_GUIDELINE = 1;
    public static final long NORMAL_PAID_LINKMIC_EXPLAIN_CARD = 9;
    public static final long NORMAL_PAID_LINKMIC_MIGRATE_TO_PLAY = 10;
    public static final long PK_LINK_BUBBLE_CONTENT = 12;
    public static final long PLAY_MODE_GUIDE_BUBBLE = 13;
    public static final long ROOM_BATTLE_RANDOM_MATCH_BUBBLE = 14;
    public static final long TEAM_FIGHT_BUBBLE_GUIDE = 8;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/ILinkMicGuideMessageBridge$BubbleEnhanceType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "TEXT_AND_SCHEMA", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BubbleEnhanceType extends Enum<BubbleEnhanceType> {
        public static final BubbleEnhanceType TEXT_AND_SCHEMA = null;
        public static final BubbleEnhanceType UNKNOWN = null;
        public static final /* synthetic */ BubbleEnhanceType[] a = null;
        private final int value;

        static {
            BubbleEnhanceType r1 = new BubbleEnhanceType("UNKNOWN", 0, 0);
            UNKNOWN = r1;
            BubbleEnhanceType r2 = new BubbleEnhanceType("TEXT_AND_SCHEMA", 1, 1);
            TEXT_AND_SCHEMA = r2;
            a = new BubbleEnhanceType[]{r1, r2};
        }

        public static BubbleEnhanceType valueOf(String r1) {
            return (BubbleEnhanceType) r27.a.a(BubbleEnhanceType.class, r1);
        }

        public static BubbleEnhanceType[] values() {
            return (BubbleEnhanceType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public BubbleEnhanceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/ILinkMicGuideMessageBridge$GroupType;", "", "", "value", "I", "getValue", "()I", "DefaultGroupType", "LinkmicGroup", "KtvGroup", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum GroupType extends Enum<GroupType> {
        public static final GroupType DefaultGroupType = null;
        public static final GroupType KtvGroup = null;
        public static final GroupType LinkmicGroup = null;
        public static final /* synthetic */ GroupType[] a = null;
        private final int value;

        static {
            GroupType r1 = new GroupType("DefaultGroupType", 0, 0);
            DefaultGroupType = r1;
            GroupType r2 = new GroupType("LinkmicGroup", 1, 1);
            LinkmicGroup = r2;
            GroupType r3 = new GroupType("KtvGroup", 2, 2);
            KtvGroup = r3;
            a = new GroupType[]{r1, r2, r3};
        }

        public static GroupType valueOf(String r1) {
            return (GroupType) r27.a.a(GroupType.class, r1);
        }

        public static GroupType[] values() {
            return (GroupType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public GroupType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    f6 getAnchorGuideInfo();

    int getAudienceLimit();

    c7 getCreateGroupChatGuideContent();

    y7 getGuestBattleBubbleGuideContent();

    long getGuidelineType();

    d8 getJoinGroupChatGuideContent();

    xa getNormalPaidLinkmicExplainCardContent();

    ya getNormalPaidLinkmicMigrateToPlayContent();

    eb getPlayModeGuideBubbleContent();

    xb getTeamFightBubbleGuideContent();
}

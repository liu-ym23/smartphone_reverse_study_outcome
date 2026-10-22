package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u000fR\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/y4;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/model/u8;", "", "getEndReason", "()I", "getEndReason$annotations", "()V", "endReason", "Lcom/bytedance/android/livesdk/link/model/u1;", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/u1;", "getBattleSetting$annotations", "battleSetting", "Companion", "a", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y4 extends vh7.e<com.bytedance.android.livesdk.message.model.u8>, com.bytedance.android.livesdk.message.model.u8 {
    public static final a Companion = null;
    public static final int EndBattlePunishReason_Default = 0;
    public static final int EndBattlePunishReason_LinkmicReply = 2;
    public static final int EndBattlePunishReason_StartBattle = 1;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_settings")
    u1 getBattleSetting();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "end_battle_punish_reason")
    int getEndReason();

    /* synthetic */ Object getFlexInstance();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);
}

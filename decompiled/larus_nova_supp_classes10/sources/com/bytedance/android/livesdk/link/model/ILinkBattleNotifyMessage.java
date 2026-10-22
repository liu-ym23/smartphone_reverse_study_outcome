package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkBattleNotifyMessage;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/j0;", "", "getContent", "()Ljava/lang/String;", "getContent$annotations", "()V", "content", "", "getNotifyType", "()I", "getNotifyType$annotations", "notifyType", "", "getContinueSeconds", "()J", "getContinueSeconds$annotations", "continueSeconds", "BattleNotifyType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkBattleNotifyMessage extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.j0>, com.bytedance.android.livesdk.link.model.bridge.j0 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkBattleNotifyMessage$BattleNotifyType;", "", "TypeUndefined", "TypeStarActivity", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleNotifyType extends Enum<BattleNotifyType> {
        public static final BattleNotifyType TypeStarActivity = null;
        public static final BattleNotifyType TypeUndefined = null;
        public static final /* synthetic */ BattleNotifyType[] a = null;

        static {
            BattleNotifyType r1 = new BattleNotifyType("TypeUndefined", 0);
            TypeUndefined = r1;
            BattleNotifyType r2 = new BattleNotifyType("TypeStarActivity", 1);
            TypeStarActivity = r2;
            a = new BattleNotifyType[]{r1, r2};
        }

        public static BattleNotifyType valueOf(String r1) {
            return (BattleNotifyType) r27.a.a(BattleNotifyType.class, r1);
        }

        public static BattleNotifyType[] values() {
            return (BattleNotifyType[]) a.clone();
        }

        public BattleNotifyType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.j0
    /* synthetic */ vh7.e castTo(Class r1);

    @Override // com.bytedance.android.livesdk.link.model.bridge.j0
    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.livesdk.link.model.bridge.j0
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "continue_seconds")
    long getContinueSeconds();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "notify_type")
    int getNotifyType();

    @Override // com.bytedance.android.livesdk.link.model.bridge.j0
    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);
}

package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002%&R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u001d\u001a\u00060\u0012j\u0002`\u00198&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\"\u0010$\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/d0;", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "()V", "content", "", "getNotifyType", "()I", "setNotifyType", "(I)V", "getNotifyType$annotations", "notifyType", "", "getDuration", "()J", "setDuration", "(J)V", "getDuration$annotations", "duration", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/BattleId;", "getBattleId", "setBattleId", "getBattleId$annotations", "battleId", "Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b;", "getUiConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b;", "setUiConfig", "(Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b;)V", "getUiConfig$annotations", "uiConfig", "b", "NotifyType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBattleToastMessage extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d0>, com.bytedance.android.livesdk.link.model.bridge.d0 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$NotifyType;", "", "TypeUndefined", "TypeProp", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum NotifyType extends Enum<NotifyType> {
        public static final NotifyType TypeProp = null;
        public static final NotifyType TypeUndefined = null;
        public static final /* synthetic */ NotifyType[] a = null;

        static {
            NotifyType r1 = new NotifyType("TypeUndefined", 0);
            TypeUndefined = r1;
            NotifyType r2 = new NotifyType("TypeProp", 1);
            TypeProp = r2;
            a = new NotifyType[]{r1, r2};
        }

        public static NotifyType valueOf(String r1) {
            return (NotifyType) r27.a.a(NotifyType.class, r1);
        }

        public static NotifyType[] values() {
            return (NotifyType[]) a.clone();
        }

        public NotifyType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b$b;", "getText", "()Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b$b;", "getText$annotations", "()V", "text", "b", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.link.model.IBattleToastMessage$b$b, reason: collision with other inner class name */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleToastMessage$b$b;", "Lvh7/c;", "", "getContent", "()Ljava/lang/String;", "getContent$annotations", "()V", "content", "getColor", "getColor$annotations", "color", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
        public interface InterfaceC0052b extends vh7.c<InterfaceC0052b> {

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.link.model.IBattleToastMessage$b$b$a */
            @JsonAdapter(FlexModelJsonAdapter.class)
            @Metadata(k = 3, mv = {1, 5, 1})
            public static final class a {
            }

            /* synthetic */ vh7.e castTo(Class r1);

            /* synthetic */ vh7.e castToOrNull(Class r1);

            @FieldName(name = "color")
            String getColor();

            @FieldName(name = "content")
            String getContent();
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "content")
        InterfaceC0052b getText();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d0
    /* synthetic */ vh7.e castTo(Class r1);

    @Override // com.bytedance.android.livesdk.link.model.bridge.d0
    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_id")
    long getBattleId();

    @Override // com.bytedance.android.livesdk.link.model.bridge.d0
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "duration")
    long getDuration();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "notify_type")
    int getNotifyType();

    @FieldName(name = "ui_config")
    b getUiConfig();

    @FieldName(name = "battle_id#setter")
    void setBattleId(long r1);

    @Override // com.bytedance.android.livesdk.link.model.bridge.d0
    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);

    @FieldName(name = "content#setter")
    void setContent(String r1);

    @FieldName(name = "duration#setter")
    void setDuration(long r1);

    @FieldName(name = "notify_type#setter")
    void setNotifyType(int r1);

    @FieldName(name = "ui_config#setter")
    void setUiConfig(b r1);
}

package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0006\"#$%&'R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010!\u001a\u00020\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0007\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t0;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/o;", "Lcom/bytedance/android/livesdk/link/model/t0$d;", "getInviteContent", "()Lcom/bytedance/android/livesdk/link/model/t0$d;", "getInviteContent$annotations", "()V", "inviteContent", "Lcom/bytedance/android/livesdk/link/model/t0$f;", "getReplyContent", "()Lcom/bytedance/android/livesdk/link/model/t0$f;", "getReplyContent$annotations", "replyContent", "Lcom/bytedance/android/livesdk/link/model/t0$g;", "getSwitchContent", "()Lcom/bytedance/android/livesdk/link/model/t0$g;", "getSwitchContent$annotations", "switchContent", "Lcom/bytedance/android/livesdk/link/model/t0$b;", "getCloseContent", "()Lcom/bytedance/android/livesdk/link/model/t0$b;", "getCloseContent$annotations", "closeContent", "Lcom/bytedance/android/livesdk/link/model/t0$e;", "getRejectContent", "()Lcom/bytedance/android/livesdk/link/model/t0$e;", "getRejectContent$annotations", "rejectContent", "", "getType", "()I", "getType$annotations", LocationMonitorConst.TYPE, "a", "b", "d", "e", "f", "g", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t0 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.o>, com.bytedance.android.livesdk.link.model.bridge.o {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\r\u001a\u00060\bj\u0002`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0016\u001a\u00060\u000ej\u0002`\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t0$a;", "Lvh7/c;", "", "getAnchorScore", "()Ljava/lang/String;", "getAnchorScore$annotations", "()V", "anchorScore", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAuxiliaryImg", "()Lpy/k;", "getAuxiliaryImg$annotations", "auxiliaryImg", "", "getIndex", "()J", "getIndex$annotations", "index", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/GiftId;", "getGiftId", "getGiftId$annotations", "giftId", "getAuxiliaryType", "getAuxiliaryType$annotations", "auxiliaryType", "getAnchorScoreInt", "getAnchorScoreInt$annotations", "anchorScoreInt", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.c<a> {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.link.model.t0$a$a, reason: collision with other inner class name */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C0056a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "anchor_score")
        String getAnchorScore();

        @FieldName(name = "anchor_score_int")
        long getAnchorScoreInt();

        @FieldName(name = "auxiliary_img")
        py.k getAuxiliaryImg();

        @FieldName(name = "auxiliary_type")
        long getAuxiliaryType();

        @FieldName(name = "gift_id")
        long getGiftId();

        @FieldName(name = "index")
        long getIndex();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t0$b;", "Lvh7/c;", "", "getCloseContent", "()Ljava/lang/String;", "getCloseContent$annotations", "()V", "closeContent", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "close_content")
        String getCloseContent();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class c {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R>\u0010\u0010\u001a&\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bj\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t0$d;", "Lvh7/c;", "", "getInviteContent", "()Ljava/lang/String;", "getInviteContent$annotations", "()V", "inviteContent", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/UserId;", "Lcom/bytedance/android/livesdk/link/model/t0$a;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getAuxiliaryScoreInfo", "()Ljava/util/Map;", "getAuxiliaryScoreInfo$annotations", "auxiliaryScoreInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface d extends vh7.c<d> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "anchor_auxiliary_score_info")
        Map<Long, a> getAuxiliaryScoreInfo();

        @FieldName(name = "invite_string")
        String getInviteContent();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t0$e;", "Lvh7/c;", "", "getRejectContent", "()Ljava/lang/String;", "getRejectContent$annotations", "()V", "rejectContent", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface e extends vh7.c<e> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "reject_content")
        String getRejectContent();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R>\u0010\u0010\u001a&\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bj\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t0$f;", "Lvh7/c;", "", "getReplyContent", "()Ljava/lang/String;", "getReplyContent$annotations", "()V", "replyContent", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/UserId;", "Lcom/bytedance/android/livesdk/link/model/t0$a;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getAuxiliaryScoreInfo", "()Ljava/util/Map;", "getAuxiliaryScoreInfo$annotations", "auxiliaryScoreInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface f extends vh7.c<f> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "anchor_auxiliary_score_info")
        Map<Long, a> getAuxiliaryScoreInfo();

        @FieldName(name = "reply_string")
        String getReplyContent();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t0$g;", "Lvh7/c;", "", "getSwitchContent", "()Ljava/lang/String;", "getSwitchContent$annotations", "()V", "switchContent", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface g extends vh7.c<g> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "switch_string")
        String getSwitchContent();
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "close_content")
    b getCloseContent();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invite_content")
    d getInviteContent();

    @FieldName(name = "reject_content")
    e getRejectContent();

    @FieldName(name = "reply_content")
    f getReplyContent();

    @FieldName(name = "switch_content")
    g getSwitchContent();

    @FieldName(name = LocationMonitorConst.TYPE)
    int getType();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);
}

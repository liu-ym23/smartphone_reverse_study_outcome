package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R2\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR6\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/link/model/r4;", "Lvh7/c;", "Laf2/e;", "", "getRivalUserId", "()Ljava/lang/String;", "getRivalUserId$annotations", "()V", "rivalUserId", "", "Lcom/bytedance/android/livesdk/link/model/h0;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPreviewUserList", "()Ljava/util/List;", "setPreviewUserList", "(Ljava/util/List;)V", "getPreviewUserList$annotations", "previewUserList", "Lcom/bytedance/android/livesdk/link/model/r4$b;", "getRivals", "setRivals", "getRivals$annotations", "rivals", "", "getMatchStrategy", "()J", "getMatchStrategy$annotations", "matchStrategy", "", "getShowNewTips", "()Z", "getShowNewTips$annotations", "showNewTips", "b", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r4 extends vh7.c<r4>, af2.e {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/r4$b;", "Lvh7/c;", "", "", "getUserId", "()Ljava/lang/String;", "getUserId$annotations", "()V", "userId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom$annotations", "room", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "room")
        IRoom getRoom();

        @FieldName(name = "open_user_id")
        String getUserId();
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ String getBattleAttachedInfo();

    /* synthetic */ boolean getCanHighWay();

    /* synthetic */ py.k getDefaultAvatar();

    /* synthetic */ String getDefaultContent();

    /* synthetic */ long getExpectTime();

    @FieldName(name = "effect_match_path")
    long getMatchStrategy();

    /* synthetic */ long getMaxWaitTime();

    @FieldName(name = "preview_user_list")
    List<h0> getPreviewUserList();

    /* synthetic */ IRoom getRivalRoom();

    @FieldName(name = "rival_open_id")
    String getRivalUserId();

    @FieldName(name = "rivals")
    List<b> getRivals();

    @FieldName(name = "show_tips")
    boolean getShowNewTips();

    /* synthetic */ String getSignExtra();

    /* synthetic */ void setBattleAttachedInfo(String r1);

    @FieldName(name = "preview_user_list#setter")
    void setPreviewUserList(List<? extends h0> r1);

    @FieldName(name = "rivals#setter")
    void setRivals(List<? extends b> r1);

    /* synthetic */ void setSignExtra(String r1);
}

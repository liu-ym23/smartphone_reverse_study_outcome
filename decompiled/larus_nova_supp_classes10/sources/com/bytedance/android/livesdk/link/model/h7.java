package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/h7;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/h7$b;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getRankList", "()Ljava/util/List;", "setRankList", "(Ljava/util/List;)V", "getRankList$annotations", "()V", "rankList", "", "getAnchorId", "()Ljava/lang/String;", "getAnchorId$annotations", "anchorId", "b", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h7 extends vh7.c<h7> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R*\u0010\u001c\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/h7$b;", "Lvh7/c;", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getUserId$annotations", "()V", "userId", "", "getScore", "()J", "setScore", "(J)V", "getScore$annotations", "score", "getNickname", "setNickname", "getNickname$annotations", "nickname", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "getAvatar$annotations", "avatar", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "avatar_thumb")
        py.k getAvatar();

        @FieldName(name = "nickname")
        String getNickname();

        @FieldName(name = "score")
        long getScore();

        @FieldName(name = "open_id")
        String getUserId();

        @FieldName(name = "avatar_thumb#setter")
        void setAvatar(py.k r1);

        @FieldName(name = "nickname#setter")
        void setNickname(String r1);

        @FieldName(name = "score#setter")
        void setScore(long r1);

        @FieldName(name = "open_id#setter")
        void setUserId(String r1);
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "anchor_open_id")
    String getAnchorId();

    @FieldName(name = "rank_list")
    List<b> getRankList();

    @FieldName(name = "rank_list#setter")
    void setRankList(List<? extends b> r1);
}

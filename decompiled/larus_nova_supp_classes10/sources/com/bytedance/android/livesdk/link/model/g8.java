package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\r\u001a\u00060\bj\u0002`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001e\u0010\u0013\u001a\u00060\bj\u0002`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/g8;", "Lvh7/c;", "", "getRankDetail", "()Ljava/lang/String;", "getRankDetail$annotations", "()V", "rankDetail", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getRankBadge", "()Lpy/k;", "getRankBadge$annotations", "rankBadge", "getRankIndex", "getRankIndex$annotations", "rankIndex", "getRankTag", "getRankTag$annotations", "rankTag", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g8 extends vh7.c<g8> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "rank_badge")
    py.k getRankBadge();

    @FieldName(name = "cur_rank_detail")
    String getRankDetail();

    @FieldName(name = "rank_index")
    String getRankIndex();

    @FieldName(name = "rank_tag_img")
    py.k getRankTag();
}

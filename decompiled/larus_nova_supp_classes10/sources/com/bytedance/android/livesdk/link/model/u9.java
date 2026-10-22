package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.gift.model.IRichText;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u000f\u001a\u00060\nj\u0002`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/u9;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/gift/model/IRichText;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getDesc", "()Ljava/util/List;", "getDesc$annotations", "()V", "desc", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBgImg", "()Lpy/k;", "getBgImg$annotations", "bgImg", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u9 extends vh7.c<u9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "bg_img")
    py.k getBgImg();

    @FieldName(name = "desc")
    List<IRichText> getDesc();
}

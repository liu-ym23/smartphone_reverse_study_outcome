package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0004\"\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i9;", "Lvh7/c;", "", "getGiftName", "()Ljava/lang/String;", "setGiftName", "(Ljava/lang/String;)V", "getGiftName$annotations", "()V", "giftName", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImage", "()Lpy/k;", "getImage$annotations", "image", "getGiftDes", "setGiftDes", "getGiftDes$annotations", "giftDes", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i9 extends vh7.c<i9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "gift_des")
    String getGiftDes();

    @FieldName(name = "gift_name")
    String getGiftName();

    @FieldName(name = "image")
    py.k getImage();

    @FieldName(name = "gift_des#setter")
    void setGiftDes(String r1);

    @FieldName(name = "gift_name#setter")
    void setGiftName(String r1);
}

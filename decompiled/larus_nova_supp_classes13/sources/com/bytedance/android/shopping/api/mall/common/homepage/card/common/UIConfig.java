package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/UIConfig;", "Ljava/io/Serializable;", "content", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "iconLeft", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TagUIParams;", "iconRight", "componentStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TagUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TagUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;)V", "getComponentStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "getContent", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "getIconLeft", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TagUIParams;", "getIconRight", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class UIConfig implements Serializable {

    @SerializedName("style")
    private final ProductStyle componentStyle;

    @SerializedName("content")
    private final TextBaseUIParams content;

    @SerializedName("icon_left")
    private final TagUIParams iconLeft;

    @SerializedName("icon_right")
    private final TagUIParams iconRight;

    public UIConfig() {
        this(null, null, null, null, 15, null);
    }

    public final ProductStyle getComponentStyle() {
        return this.componentStyle;
    }

    public final TextBaseUIParams getContent() {
        return this.content;
    }

    public final TagUIParams getIconLeft() {
        return this.iconLeft;
    }

    public final TagUIParams getIconRight() {
        return this.iconRight;
    }

    public UIConfig(TextBaseUIParams r1, TagUIParams r2, TagUIParams r3, ProductStyle r4) {
        this.content = r1;
        this.iconLeft = r2;
        this.iconRight = r3;
        this.componentStyle = r4;
    }

    public /* synthetic */ UIConfig(TextBaseUIParams r2, TagUIParams r3, TagUIParams r4, ProductStyle r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}

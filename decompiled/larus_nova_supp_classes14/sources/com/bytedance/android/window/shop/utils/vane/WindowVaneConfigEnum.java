package com.bytedance.android.window.shop.utils.vane;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/utils/vane/WindowVaneConfigEnum;", "", "", "vaneType", "Ljava/lang/String;", "getVaneType", "()Ljava/lang/String;", "SEARCH_VANE", "RECOMMEND_VANE", "HOT_SALE_VANE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowVaneConfigEnum extends Enum<WindowVaneConfigEnum> {
    public static final WindowVaneConfigEnum HOT_SALE_VANE = null;
    public static final WindowVaneConfigEnum RECOMMEND_VANE = null;
    public static final WindowVaneConfigEnum SEARCH_VANE = null;
    public static final /* synthetic */ WindowVaneConfigEnum[] a = null;
    private final String vaneType;

    static {
        WindowVaneConfigEnum r1 = new WindowVaneConfigEnum("SEARCH_VANE", 0, "0");
        SEARCH_VANE = r1;
        WindowVaneConfigEnum r2 = new WindowVaneConfigEnum("RECOMMEND_VANE", 1, CommentScene.COMMENTSCENE_NO_AWEME);
        RECOMMEND_VANE = r2;
        WindowVaneConfigEnum r3 = new WindowVaneConfigEnum("HOT_SALE_VANE", 2, "2");
        HOT_SALE_VANE = r3;
        a = new WindowVaneConfigEnum[]{r1, r2, r3};
    }

    public static WindowVaneConfigEnum valueOf(String r1) {
        return (WindowVaneConfigEnum) a.a(WindowVaneConfigEnum.class, r1);
    }

    public static WindowVaneConfigEnum[] values() {
        return (WindowVaneConfigEnum[]) a.clone();
    }

    public final String getVaneType() {
        return this.vaneType;
    }

    public WindowVaneConfigEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.vaneType = r3;
    }
}

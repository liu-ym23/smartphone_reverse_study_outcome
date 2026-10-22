package com.bytedance.android.window.shop.repository.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/WindowSceneType;", "", "", "type", "I", "getType", "()I", "DEFAULT", "CROPPED_STYLE", "CROPPED_OPT_STYLE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowSceneType extends Enum<WindowSceneType> {
    public static final WindowSceneType CROPPED_OPT_STYLE = null;
    public static final WindowSceneType CROPPED_STYLE = null;
    public static final WindowSceneType DEFAULT = null;
    public static final /* synthetic */ WindowSceneType[] a = null;
    private final int type;

    static {
        WindowSceneType r1 = new WindowSceneType("DEFAULT", 0, 0);
        DEFAULT = r1;
        WindowSceneType r2 = new WindowSceneType("CROPPED_STYLE", 1, 1);
        CROPPED_STYLE = r2;
        WindowSceneType r3 = new WindowSceneType("CROPPED_OPT_STYLE", 2, 2);
        CROPPED_OPT_STYLE = r3;
        a = new WindowSceneType[]{r1, r2, r3};
    }

    public static WindowSceneType valueOf(String r1) {
        return (WindowSceneType) a.a(WindowSceneType.class, r1);
    }

    public static WindowSceneType[] values() {
        return (WindowSceneType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public WindowSceneType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}

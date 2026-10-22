package com.bytedance.android.shopping.yata.biz.popup.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/api/PopupHybridCardErrorType;", "", "FAILED", "TIMEOUT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PopupHybridCardErrorType extends Enum<PopupHybridCardErrorType> {
    public static final PopupHybridCardErrorType FAILED = null;
    public static final PopupHybridCardErrorType TIMEOUT = null;
    public static final /* synthetic */ PopupHybridCardErrorType[] a = null;

    static {
        PopupHybridCardErrorType r1 = new PopupHybridCardErrorType("FAILED", 0);
        FAILED = r1;
        PopupHybridCardErrorType r2 = new PopupHybridCardErrorType("TIMEOUT", 1);
        TIMEOUT = r2;
        a = new PopupHybridCardErrorType[]{r1, r2};
    }

    public static PopupHybridCardErrorType valueOf(String r1) {
        return (PopupHybridCardErrorType) a.a(PopupHybridCardErrorType.class, r1);
    }

    public static PopupHybridCardErrorType[] values() {
        return (PopupHybridCardErrorType[]) a.clone();
    }

    public PopupHybridCardErrorType(String r1, int r2) {
        super(r1, r2);
    }
}

package com.bytedance.android.shopping.collect.container;

import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/CollectYataQueryFrom;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "FIRST_ENTER", "LOAD_MORE", "REFRESH", "PAGE_BACK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectYataQueryFrom extends Enum<CollectYataQueryFrom> {
    public static final CollectYataQueryFrom FIRST_ENTER = null;
    public static final CollectYataQueryFrom LOAD_MORE = null;
    public static final CollectYataQueryFrom PAGE_BACK = null;
    public static final CollectYataQueryFrom REFRESH = null;
    public static final /* synthetic */ CollectYataQueryFrom[] a = null;
    private final String value;

    static {
        CollectYataQueryFrom r1 = new CollectYataQueryFrom("FIRST_ENTER", 0, "first_enter");
        FIRST_ENTER = r1;
        CollectYataQueryFrom r2 = new CollectYataQueryFrom("LOAD_MORE", 1, GYLFetchType.LOAD_MORE);
        LOAD_MORE = r2;
        CollectYataQueryFrom r3 = new CollectYataQueryFrom("REFRESH", 2, ErrorPageButtonAction.REFRESH);
        REFRESH = r3;
        CollectYataQueryFrom r4 = new CollectYataQueryFrom("PAGE_BACK", 3, "page_back");
        PAGE_BACK = r4;
        a = new CollectYataQueryFrom[]{r1, r2, r3, r4};
    }

    public static CollectYataQueryFrom valueOf(String r1) {
        return (CollectYataQueryFrom) r27.a.a(CollectYataQueryFrom.class, r1);
    }

    public static CollectYataQueryFrom[] values() {
        return (CollectYataQueryFrom[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public CollectYataQueryFrom(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

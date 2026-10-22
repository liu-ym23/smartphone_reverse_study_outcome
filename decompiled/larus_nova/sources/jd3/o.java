package jd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f498394b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("product_id", this.f498393a);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, this.f498394b);
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_COMMENT_CARD);
    }

    public o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
        this.f498393a = "";
        this.f498394b = "";
    }
}

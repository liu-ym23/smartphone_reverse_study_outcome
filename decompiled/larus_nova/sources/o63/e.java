package o63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f522184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f522185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f522186f;

    public static final class a {
    }

    static {
    }

    @Override // o63.b, com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, this.f522186f);
        appendParam("page_name", this.f522185e);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, null);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, this.f522184d);
        appendParam("btm_id", null);
        super.buildParams();
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
        this.f522185e = "matching_middle_list";
        this.f522186f = "blank";
    }
}

package jd3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f498389a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam(this.f498389a);
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_COMMENT_CARD);
    }

    public n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
        this.f498389a = new LinkedHashMap();
    }
}

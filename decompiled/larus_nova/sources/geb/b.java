package geb;

import com.bytedance.lark.molten_livequery_wrapper.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f481032a = null;

    static {
        f481032a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.d
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter("livequery_wrapper", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        c.d("FeedMolten_livequery_wrapper", r100);
    }
}

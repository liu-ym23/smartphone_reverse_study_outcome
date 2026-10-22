package hg3;

import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f485003a;

    /* JADX INFO: renamed from: hg3.a$a, reason: collision with other inner class name */
    public static final class C6142a {
    }

    static {
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        this.f485003a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "COMMON_LOG"), TuplesKt.to(SocialConstants.PARAM_APP_DESC, r100)});
    }
}

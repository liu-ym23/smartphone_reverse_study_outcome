package o6c;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f522234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Regex, String> f522235b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<String, String> f522236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedHashMap<Regex, String> f522237b;

        public a() {
            this.f522236a = new LinkedHashMap();
            this.f522237b = new LinkedHashMap();
        }

        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            this.f522236a.put(r100, r101);
        }
    }

    public e(Map r100, Map r101) {
        this.f522234a = r100;
        this.f522235b = r101;
    }
}

package e07;

import com.ss.ttvideoengine.DataSource;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470650b;

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "domain");
        this.f470649a = r100;
        this.f470650b = r101;
    }

    @Override // com.ss.ttvideoengine.DataSource
    public final String apiForFetcher(Map<String, String> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        StringBuilder r102 = new StringBuilder();
        r102.append("https://" + this.f470650b + "/?" + this.f470649a);
        return r102.toString();
    }
}

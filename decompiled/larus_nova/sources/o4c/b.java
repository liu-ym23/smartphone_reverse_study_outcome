package o4c;

import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileBizDomain f522020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f522022c;

    public b(FileBizDomain r100, a r101) {
        String r102 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r100, "scopeEntityDomain");
        Intrinsics.checkNotNullParameter("IM_MSG", "scopeEntityType");
        Intrinsics.checkNotNullParameter(r102, "contextId");
        this.f522020a = r100;
        this.f522021b = "IM_MSG";
        this.f522022c = r101;
    }
}

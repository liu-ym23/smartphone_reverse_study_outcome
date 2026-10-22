package nj9;

import com.larus.livetutor.impl.repository.viewmodel.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a extends l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f519466c;

    public a() {
        this(0);
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.l0
    public final int a() {
        return this.f519466c;
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.l0
    public final String b() {
        return this.f519465b;
    }

    public /* synthetic */ a(int r100) {
        this("rtc_other_error", -1);
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f519465b = r100;
        this.f519466c = r101;
    }
}

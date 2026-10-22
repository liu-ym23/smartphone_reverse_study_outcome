package w48;

import com.bytedance.bdinstall.f0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558262a;

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f558262a = r100;
    }

    @Override // com.bytedance.bdinstall.f0
    public final void d(String r100, Throwable r101) {
        if (r101 == null) goto L4;
        FLogger.f375446a.w(this.f558262a, r100, r101);
        return;
    L4:
        FLogger.f375446a.d(this.f558262a, r100);
    }

    @Override // com.bytedance.bdinstall.f0
    public final void e(String r100, Throwable r101) {
        FLogger.f375446a.e(this.f558262a, r100, r101);
    }

    @Override // com.bytedance.bdinstall.f0
    public final void i(String r100, Throwable r101) {
        if (r101 == null) goto L4;
        FLogger.f375446a.w(this.f558262a, r100, r101);
        return;
    L4:
        FLogger.f375446a.i(this.f558262a, r100);
    }

    @Override // com.bytedance.bdinstall.f0
    public final void v(String r100, Throwable r101) {
        if (r101 == null) goto L4;
        FLogger.f375446a.w(this.f558262a, r100, r101);
        return;
    L4:
        FLogger.f375446a.v(this.f558262a, r100);
    }

    @Override // com.bytedance.bdinstall.f0
    public final void w(String r100, Throwable r101) {
        FLogger.f375446a.w(this.f558262a, r100, r101);
    }
}

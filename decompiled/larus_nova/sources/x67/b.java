package x67;

import com.bytedance.push.log.ILogger;
import com.bytedance.push.utils.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ILogger {
    public b() {
    }

    @Override // com.bytedance.push.log.ILogger
    public final boolean debug() {
        return f.f267065a;
    }

    @Override // com.bytedance.push.log.ILogger
    public final void d(String r100) {
        f.a(r100);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void e(String r100) {
        f.d(r100);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void i(String r100) {
        f.g("", r100);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void d(String r100, String r101) {
        f.b(r100, r101);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void e(String r100, String r101) {
        f.e(r100, r101);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void i(String r100, String r101) {
        f.g(r100, r101);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void v(String r100, String r101) {
        f.h(r100, r101);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void w(String r100, String r101) {
        f.i(r100, r101);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void e(String r100, String r101, Throwable r102) {
        f.f(r100, r101, r102);
    }

    @Override // com.bytedance.push.log.ILogger
    public final void i(String r100, String r101, Throwable r102) {
        String r103 = f.f267068d;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        r104.append("\t>>>\t");
        r104.append(r101);
        r104.append("\t>>>\t");
        if (r102 != null) goto L5;
        String r105 = "null";
    L6:
        r104.append(r105);
        f.g(r103, r104.toString());
        return;
    L5:
        r105 = r102.getMessage();
        goto L6
    }
}

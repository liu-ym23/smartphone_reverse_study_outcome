package com.bytedance.mt.protector;

import com.bytedance.keva.Keva;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d implements a {
    public d() {
    }

    @Override // com.bytedance.mt.protector.a
    public final void a(Throwable r1) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void c(Throwable r1, Map r2) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void d(String r1) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void f(String r1) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void g(String r1) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void b(ProtectorType r3, Throwable r4) {
        r3.getName();
        if (r4 == null) goto L6;
        Keva r5 = Keva.getRepo("protector_throwable_repo", 1);
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r4.printStackTrace(new PrintStream(r0));
        r5.storeString("protector_throwable_key", r0.toString());
        return;
    }

    @Override // com.bytedance.mt.protector.a
    public final void e(ProtectorType r1, Throwable r2) {
        r1.getName();
    }
}

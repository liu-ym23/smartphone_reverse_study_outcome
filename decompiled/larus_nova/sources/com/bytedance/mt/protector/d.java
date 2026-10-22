package com.bytedance.mt.protector;

import com.bytedance.keva.Keva;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d implements a {
    public d() {
    }

    @Override // com.bytedance.mt.protector.a
    public final void a(Throwable r100) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void c(Throwable r100, Map r101) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void d(String r100) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void f(String r100) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void g(String r100) {
    }

    @Override // com.bytedance.mt.protector.a
    public final void b(ProtectorType r100, Throwable r101) {
        r100.getName();
        if (r101 == null) goto L6;
        Keva r102 = Keva.getRepo("protector_throwable_repo", 1);
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        r101.printStackTrace(new PrintStream(r103));
        r102.storeString("protector_throwable_key", r103.toString());
        return;
    }

    @Override // com.bytedance.mt.protector.a
    public final void e(ProtectorType r100, Throwable r101) {
        r100.getName();
    }
}

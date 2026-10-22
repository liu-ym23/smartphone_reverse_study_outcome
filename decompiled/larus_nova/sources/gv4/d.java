package gv4;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f482819a;

    public d() {
    }

    @Override // gv4.a
    public void a(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        m r101 = this.f482819a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final a update(m r100) {
        this.f482819a = r100;
        return this;
    }
}

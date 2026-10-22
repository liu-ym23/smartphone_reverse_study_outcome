package xgb;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import kotlin.jvm.internal.Intrinsics;
import r7b.b;
import r7b.e;

/* JADX INFO: loaded from: classes36.dex */
public class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r7b.a.InterfaceC7445a f563838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r7b.a.b f563839c;

    @Override // r7b.c
    public final boolean a() {
        return this.f563838b.a();
    }

    @Override // r7b.c
    public final int j() {
        return this.f563839c.b();
    }

    public a(b<ThreadTopic> r100, r7b.a.InterfaceC7445a r101, r7b.a.b r102) {
        Intrinsics.checkNotNullParameter(r100, "datasource");
        Intrinsics.checkNotNullParameter(r101, "backToBottomDependency");
        Intrinsics.checkNotNullParameter(r102, "fetcher");
        super(r100);
        this.f563838b = r101;
        this.f563839c = r102;
    }
}

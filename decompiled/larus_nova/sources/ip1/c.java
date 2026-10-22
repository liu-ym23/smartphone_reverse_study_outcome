package ip1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements lp1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f495259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f495260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b f495261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ElementType f495262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e f495263e;

    @Override // lp1.a
    public final void d() {
        this.f495260b = true;
    }

    @Override // lp1.a
    public final void f() {
        this.f495259a = false;
    }

    @Override // lp1.a
    public final boolean a() {
        return this.f495260b;
    }

    @Override // lp1.a
    public final boolean b() {
        return this.f495259a;
    }

    @Override // lp1.a
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b c() {
        return this.f495261c;
    }

    @Override // lp1.a
    public final ElementType e() {
        return this.f495262d;
    }

    @Override // lp1.a
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e getButton() {
        return this.f495263e;
    }

    public c(ElementType r100, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r101) {
        Intrinsics.checkNotNullParameter(r100, "ofElement");
        Intrinsics.checkNotNullParameter(r101, "button");
        this.f495262d = r100;
        this.f495263e = r101;
    }
}

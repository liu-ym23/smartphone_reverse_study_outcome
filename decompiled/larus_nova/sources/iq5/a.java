package iq5;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f495341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f495342b;

    @Override // iq5.p
    public final float b() {
        return 14.0f;
    }

    @Override // iq5.p
    public final int c() {
        return -1;
    }

    @Override // iq5.p
    public final /* synthetic */ int d() {
        return 0;
    }

    @Override // iq5.p
    public final int height() {
        return com.bytedance.ee.util.ui.n.d(44);
    }

    @Override // iq5.p
    public final String title() {
        return eu5.b.f474075a.getString(R.string.LarkCCM_CM_Drive_Header);
    }

    @Override // iq5.p
    public final boolean a(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        if (this.f495341a.a(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f495342b.a(r100) == true) goto L8;
        return false;
    }

    public a(q r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "myFolder");
        Intrinsics.checkNotNullParameter(r101, "shareFolder");
        this.f495341a = r100;
        this.f495342b = r101;
    }
}

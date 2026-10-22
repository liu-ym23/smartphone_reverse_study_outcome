package nc0;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import uf2.z;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements com.bytedance.android.live.revenuelink.rtc.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gy.d f518607a;

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void U3() {
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void W3() {
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void o() {
        this.f518607a.o();
    }

    public d(gy.d r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518607a = r100;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void L(String r100) {
        this.f518607a.L(r100);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void o0(long r100) {
        this.f518607a.o0(r100);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void onUserJoined(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        this.f518607a.onUserJoined(r100);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void A(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        this.f518607a.A(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void C1(vc0.a r100, vc0.a[] r101) {
        this.f518607a.C1(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void R(long r100, Exception r101) {
        this.f518607a.R(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void S3(String r100, ByteBuffer r101) {
        this.f518607a.S3(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void X0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f518607a.X0(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void e1(String r100, long r101) {
        this.f518607a.e1(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void f0(long r100, Exception r101) {
        this.f518607a.f0(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void f1(long r100, long r101) {
        this.f518607a.f1(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void g(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        this.f518607a.g(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void p1(int r100, int r101) {
        this.f518607a.p1(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void s(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f518607a.s(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void u1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f518607a.u1(r100, r101);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void J(String[] r100, boolean[] r101, int[] r102) {
        this.f518607a.J(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void S(String r100, int r101, int r102) {
        this.f518607a.S(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void L0(String r100, TextureView r101, int r102, int r103) {
        this.f518607a.L0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void S2(String r100, Object r101, int r102, int r103) {
        this.f518607a.S2(r100, r101, r102, r103);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void T3(String r100, vc0.a r101, int r102, int r103) {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r104 = ILiveWrappedLivePusher.a.b();
        z.a r105 = null;
        Object r106 = null;
        if (r104 == null) goto L7;
        if (r101 == null) goto L6;
        r106 = r101.f554079a;
    L6:
        r105 = r104.buildLayerControlLayer(r106);
    L7:
        this.f518607a.b4(r100, r105, r102, r103);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void V3(String r100, vc0.a r101, int r102, int r103) {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r104 = ILiveWrappedLivePusher.a.b();
        z.a r105 = null;
        Object r106 = null;
        if (r104 == null) goto L7;
        if (r101 == null) goto L6;
        r106 = r101.f554079a;
    L6:
        r105 = r104.buildLayerControlLayer(r106);
    L7:
        this.f518607a.V4(r100, r105);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void h1(String r100, SurfaceView r101, int r102, int r103) {
        this.f518607a.h1(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void j0(String r100, TextureView r101, int r102, int r103) {
        this.f518607a.j0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.g
    public final void y0(String r100, SurfaceView r101, int r102, int r103) {
        this.f518607a.y0(r100, r101, r102, r103);
    }
}

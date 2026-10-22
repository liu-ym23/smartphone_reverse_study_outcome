package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantNative;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class f implements b<HeaderPendantNative> {
    public static final /* synthetic */ int b = 0;
    public final HeaderPendantModel a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void a(boolean r1) {
    }

    public void b(HeaderPendantNative r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void c(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void d(boolean r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void f(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void h(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void o() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void onPageSelected(int r1) {
    }

    public f(HeaderPendantModel r2) {
        Intrinsics.checkNotNullParameter(r2, "pendantModel");
        this.a = r2;
        PendantType r3 = PendantType.TYPE_NATIVE;
    }

    public /* bridge */ /* synthetic */ void g(Object r1) {
        b((HeaderPendantNative) r1);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(Object r1, int r2, Integer r3) {
        HeaderPendantNative r4 = (HeaderPendantNative) r1;
    }
}

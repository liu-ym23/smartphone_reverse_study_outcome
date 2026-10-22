package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.graphics.Bitmap;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.facebook.common.references.CloseableReference;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface u {
    r P();

    int R();

    boolean S();

    void T(com.bytedance.android.shopping.anchorv4.vm.h r1);

    String U();

    x V();

    void W(com.bytedance.android.shopping.anchorv4.vm.c r1);

    int W4();

    void X(HeadRecyclerView r1);

    void Y(int r1);

    void Z(com.bytedance.android.ec.core.anchorv3.q r1, boolean r2);

    void a();

    void a0(Boolean r1);

    boolean b();

    boolean b0();

    AnchorV4Param c();

    void c0(boolean r1);

    boolean d();

    com.bytedance.android.shopping.anchorv4.perf.monitor.c d0();

    com.bytedance.android.shopping.anchorv4.video.f e();

    vg3.c e0();

    void f();

    void f0(int r1, Bitmap r2);

    void g0(String r1, Map<String, ? extends Object> r2, String r3, View r4, boolean r5, boolean r6, String r7);

    Map<String, Object> getEventParams();

    LifecycleOwner getLifecycleOwner();

    String getSessionId();

    LinkedTreeMap<String, Object> getTrackMeta();

    CloseableReference<Bitmap> h0();

    Boolean i0();

    boolean isExpanded();

    w j0();

    com.bytedance.android.shopping.anchorv4.containers.g k0();

    boolean l();

    void l0(Integer r1, int r2);

    AnchorV4HeadV2VO m0();

    boolean n();

    boolean n0();

    void o0(String r1, Map<String, Object> r2, boolean r3);

    boolean oa();

    void p0(z r1);

    void q0(int r1, Bitmap r2);

    CommonMeta r0();

    boolean r9();
}

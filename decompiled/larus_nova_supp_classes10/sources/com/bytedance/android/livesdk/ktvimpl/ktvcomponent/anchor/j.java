package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements vb6.f {
    public final /* synthetic */ KtvComponentAnchorLogicWidget.i a;

    public final void Am(ei6.a r1, int r2, long r3, Exception r5) {
    }

    public final void E2() {
    }

    public final void H1() {
    }

    public final void X1(int r1, int r2, Exception r3) {
    }

    public final void Y4() {
    }

    public final void k4() {
    }

    public final void q2(int r1, int r2, int r3) {
    }

    public final void ra() {
    }

    public final void s1() {
    }

    public final void t1() {
    }

    public final void M1() {
        ALogger.i("KtvComponentAnchorLogicWidget", "onEndSuccess");
        h80.a r0 = this.a.b.h;
        if (r0 == null) goto L6;
        r0.accept(Boolean.TRUE);
        return;
    }

    public j(KtvComponentAnchorLogicWidget.i r1) {
        this.a = r1;
    }

    public final void H4(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void M4(cc6.b r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final ec6.a O2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        Intrinsics.checkNotNullParameter(r2, "liveCoreSetting");
        return null;
    }

    public final void Ra(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void ag(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void fe(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void y1(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void z2(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void C2(long r1, ExtraResponse<? extends IJoinChannelResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void F2(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void Fk(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void I2(ei6.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "client");
        Intrinsics.checkNotNullParameter(r3, "source");
        vb6.f.a.b(r2, r3);
    }

    public final void U8(long r1, ExtraResponse<IApplyResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void W(long r1, OperateType r3) {
        Intrinsics.checkNotNullParameter(r3, "operationType");
        Intrinsics.checkNotNullParameter(r3, "operationType");
    }

    public final void Wb(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void Xf(long r1, ExtraResponse<? extends g1, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void Zk(long r1, ei6.a r3) {
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
    }

    public final void bp(long r1, ExtraResponse<LinkFinishResult, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void lf(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void o1(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void t5(ec6.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "client");
        Intrinsics.checkNotNullParameter(r3, "source");
        vb6.f.a.a(r2, r3);
    }

    public final void u4(long r1, ec6.a r3) {
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r3, "client");
    }

    public final void uf(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
    }

    public final void wn(long r1, ExtraResponse<com.bytedance.android.livesdk.chatroom.model.interact.m, Extra> r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    public final void yp(long r1, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        h80.a r2 = this.a.b.h;
        if (r2 == null) goto L6;
        r2.accept(Boolean.FALSE);
        return;
    }

    public final void c1(long r1, OperateType r3, BaseCheckException r4) {
        Intrinsics.checkNotNullParameter(r3, "operationType");
        Intrinsics.checkNotNullParameter(r4, "exception");
        Intrinsics.checkNotNullParameter(r3, "operationType");
        Intrinsics.checkNotNullParameter(r4, "exception");
    }

    public final void vc(ei6.a r1, int r2, long r3, Object... r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r5, "params");
    }
}

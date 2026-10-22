package com.bytedance.ee.bear.drive.biz.preview.vc.comment;

import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.drive.biz.preview.vc.connector.e;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import p65.b;
import py4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveDocCommentFollowConnector implements e {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Override // py4.g
    public final void b(FollowModuleState r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void e(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void f(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void g() {
    }

    @Override // py4.g
    public final String getModule() {
        return "DocComment";
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        tt5.a.h("DriveDocCommentFollowConnector", "onDetach.");
        Iterator r0 = ((Map) this.a.getValue()).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).onDetach();
        goto L4
    }

    public DriveDocCommentFollowConnector() {
        this.a = LazyKt.lazy(DriveDocCommentFollowConnector$vmMap$2.INSTANCE);
    }

    @Override // py4.g
    public final void a(h r3) {
        Iterator r0 = ((Map) this.a.getValue()).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).c(r3);
        goto L4
    }

    @Override // py4.g
    public final void c(FollowModuleState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        String r0 = r5.actionType;
        if (r0 == null) goto L9;
        b r1 = (b) ((Map) this.a.getValue()).get(r0);
        if (r1 == null) goto L9;
        tt5.a.h("DriveDocCommentFollowConnector", "setState, actionType: " + r5.actionType);
        r1.onReceive(r5.data);
        return;
    L9:
        tt5.a.d("DriveDocCommentFollowConnector", "setState, actionVM not found for actionType: " + r5.actionType);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void d(sy4.b r3) {
        Iterator r0 = ((Map) this.a.getValue()).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).a(r3);
        goto L4
    }
}

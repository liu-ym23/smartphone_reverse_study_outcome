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

/* JADX INFO: loaded from: classes16.dex */
public final class DriveDocCommentFollowConnector implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f223794a;

    public static final class a {
    }

    static {
    }

    @Override // py4.g
    public final void b(FollowModuleState r100) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void e(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void f(boolean r100) {
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
        Iterator r100 = ((Map) this.f223794a.getValue()).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).onDetach();
        goto L4
    }

    public DriveDocCommentFollowConnector() {
        this.f223794a = LazyKt.lazy(DriveDocCommentFollowConnector$vmMap$2.INSTANCE);
    }

    @Override // py4.g
    public final void a(h r100) {
        Iterator r101 = ((Map) this.f223794a.getValue()).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).c(r100);
        goto L4
    }

    @Override // py4.g
    public final void c(FollowModuleState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        String r101 = r100.actionType;
        if (r101 == null) goto L9;
        b r102 = (b) ((Map) this.f223794a.getValue()).get(r101);
        if (r102 == null) goto L9;
        tt5.a.h("DriveDocCommentFollowConnector", "setState, actionType: " + r100.actionType);
        r102.onReceive(r100.data);
        return;
    L9:
        tt5.a.d("DriveDocCommentFollowConnector", "setState, actionVM not found for actionType: " + r100.actionType);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void d(sy4.b r100) {
        Iterator r101 = ((Map) this.f223794a.getValue()).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).a(r100);
        goto L4
    }
}

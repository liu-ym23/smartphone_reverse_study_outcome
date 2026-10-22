package com.bytedance.ee.bear.drive.biz.preview.vc.connector;

import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.drive.biz.preview.vc.comment.DriveDocCommentFollowConnector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import l65.i;
import py4.h;

/* JADX INFO: loaded from: classes16.dex */
public abstract class AbsFollowableContentProvider implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends e>, Function0<e>> f223806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f223807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f223808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f223809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f223810e;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsFollowableContentProvider f223811a;

        public a(AbsFollowableContentProvider r100) {
            this.f223811a = r100;
        }

        @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.d
        public final void onChanged(boolean r100) {
            Iterator r101 = ((ArrayList) this.f223811a.f223807b).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            e r102 = (e) r101.next();
            tt5.a.h("CCMFollow_FollowableContentProvider", "notifyModuleAndActionType fileBlockState= " + r100);
            r102.e(r100);
            goto L4
        }
    }

    public static final class b {
    }

    static {
    }

    public abstract Class<? extends e>[] c();

    public e d() {
        return null;
    }

    public e e() {
        return null;
    }

    public e f() {
        return null;
    }

    public e g() {
        return null;
    }

    public e h() {
        return null;
    }

    public e i() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.f
    public final List<e> b() {
        return this.f223807b;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.f
    public final void a(h r100) {
        this.f223810e = r100;
        Iterator r101 = ((ArrayList) this.f223807b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        e r102 = (e) r101.next();
        r102.a(this.f223810e);
        r102.g();
        goto L4
    }

    public AbsFollowableContentProvider(l65.f r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "followableContentManager");
        this.f223806a = MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$1(this)), TuplesKt.to(DriveDocCommentFollowConnector.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$2(this)), TuplesKt.to(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$3(this)), TuplesKt.to(o65.b.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$4(this)), TuplesKt.to(m65.a.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$5(this)), TuplesKt.to(n65.a.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$6(this))});
        this.f223807b = new ArrayList();
        this.f223808c = r101;
        this.f223809d = r102;
        a r103 = new a(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED);
        i r104 = r100.f507708a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED);
        r104.f507727i.add(r103);
    }
}

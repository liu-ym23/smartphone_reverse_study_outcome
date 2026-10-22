package com.bytedance.ee.bear.drive.biz.preview.vc.connector;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsFollowableContentProvider implements f {
    public final Map<Class<? extends e>, Function0<e>> a;
    public final List<e> b;
    public final boolean c;
    public final String d;
    public h e;

    public static final class a implements d {
        public final /* synthetic */ AbsFollowableContentProvider a;

        public a(AbsFollowableContentProvider r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.d
        public final void onChanged(boolean r5) {
            Iterator r0 = ((ArrayList) this.a.b).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            e r1 = (e) r0.next();
            tt5.a.h("CCMFollow_FollowableContentProvider", "notifyModuleAndActionType fileBlockState= " + r5);
            r1.e(r5);
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
        return this.b;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.f
    public final void a(h r3) {
        this.e = r3;
        Iterator r4 = ((ArrayList) this.b).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        e r0 = (e) r4.next();
        r0.a(this.e);
        r0.g();
        goto L4
    }

    public AbsFollowableContentProvider(l65.f r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "followableContentManager");
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.ee.bear.drive.biz.preview.vc.comment.a.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$1(this)), TuplesKt.to(DriveDocCommentFollowConnector.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$2(this)), TuplesKt.to(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$3(this)), TuplesKt.to(o65.b.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$4(this)), TuplesKt.to(m65.a.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$5(this)), TuplesKt.to(n65.a.class, new AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$6(this))});
        this.b = new ArrayList();
        this.c = r5;
        this.d = r6;
        a r7 = new a(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "changed");
        i r8 = r4.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "changed");
        r8.i.add(r7);
    }
}

package com.bytedance.ee.bear.route;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.ee.bear.basesdk.services.route.UserRouteServiceImpl;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.middleground.like.LikeListActivity;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyActivity;
import com.bytedance.ee.bear.middleground.record.viewhistory.ViewHistoryActivity;
import com.bytedance.ee.bear.operation.view.OperationStrategyActivity;
import com.bytedance.ee.bear.wikiv2.selector.SelectorActivity;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivity;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@UserScope
public final class g extends UserRouteServiceImpl {
    public static final Set<String> h = null;

    public static final class a {
    }

    public static final class b implements PostCard {
        public final String a;
        public final IllegalStateException b;
        public boolean c;

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard a(ArrayList r1) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard b(CharSequence r1) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard c(String r1, Bundle r2) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard d(Context r1) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard f(String r1, long r2) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard g(int r1, int r2) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard h(Bundle r1) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard i(String r1, String r2) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard j(String r1, int r2) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard k(int r1) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard l(String r1, boolean r2) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard m(int r1) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard n(String r1, Serializable r2) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final PostCard o(String r1, Parcelable r2) {
            return this;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public final void e() {
            if (this.c == false) goto L5;
            return;
        L5:
            this.c = true;
            String r0 = du5.b.g(this.a);
            tt5.a.e("OfficeUserRouteServiceImpl", "navigation missing route, url = " + r0, this.b, false);
            if (g.h.add(r0) == false) goto L9;
            iu5.d.a("OfficeUserRouteServiceImpl", this.b);
            return;
        }

        @Override // com.bytedance.ee.bear.route.PostCard
        public PostCard.Type getType() {
            return PostCard.Type.NORMAL;
        }

        public b(String r2, IllegalStateException r3) {
            Intrinsics.checkNotNullParameter(r3, "exception");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        h = Collections.synchronizedSet(new LinkedHashSet());
    }

    @Inject
    public g(t45.c r6) {
        Intrinsics.checkNotNullParameter(r6, "spaceKitUrlHelper");
        Application r0 = LarkContext.getApplication();
        super(r6, MapsKt.mapOf(new Pair[]{TuplesKt.to("/doc/viewhistory/activity", new com.bytedance.ee.bear.basesdk.services.route.d(r0, ViewHistoryActivity.class)), TuplesKt.to("/doc/like/activity", new com.bytedance.ee.bear.basesdk.services.route.d(r0, LikeListActivity.class)), TuplesKt.to("/doc/privacy/activity", new com.bytedance.ee.bear.basesdk.services.route.d(r0, PrivacyActivity.class)), TuplesKt.to("/doc/operation/strategy/activity", new com.bytedance.ee.bear.basesdk.services.route.d(r0, OperationStrategyActivity.class)), TuplesKt.to("/selector/activity", new com.bytedance.ee.bear.basesdk.services.route.d(r0, SelectorActivity.class)), TuplesKt.to("/wikiv2/treehome/activity", new com.bytedance.ee.bear.basesdk.services.route.d(r0, WikiTreeActivity.class))}), MapsKt.mapOf(TuplesKt.to("/selector/activity", new com.bytedance.ee.bear.basesdk.config.directionprovider.d())));
    }

    public final com.bytedance.ee.bear.basesdk.services.route.c a(t45.c r6) {
        Intrinsics.checkNotNullParameter(r6, "spaceKitUrlHelper");
        if (CCMOfficeSDKAssembleFG.b() == true) goto L5;
        List r1 = CollectionsKt.listOf(new e());
    L7:
        return new f(r1, r6);
    L5:
        r1 = CollectionsKt.listOf(new d[]{((com.bytedance.ee.bear.lynx.api.d) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.d.class, null, null, 6)).a(), new e()});
        goto L7
    }

    public final PostCard yd(String r4, RouteBean r5) {
        PostCard r6 = super.yd(r4, r5);
        if (r6 == null) goto L5;
        return r6;
    L5:
        IllegalStateException r7 = new IllegalStateException("OfficeSDK route missing: " + du5.b.g(r4));
        if (eu5.c.d() == true) goto L9;
        tt5.a.e("OfficeUserRouteServiceImpl", "build missing route, return fallback post card", r7, false);
        return new b(r4, r7);
    L9:
        throw r7;
    }
}

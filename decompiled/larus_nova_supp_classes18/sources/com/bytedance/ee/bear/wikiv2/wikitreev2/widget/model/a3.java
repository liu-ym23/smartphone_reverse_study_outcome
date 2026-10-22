package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetSpaceInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a3 {
    public static final a3 a = null;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r6) {
            SpaceInfo r7 = (SpaceInfo) r6;
            Intrinsics.checkNotNullParameter(r7, "spaceInfo");
            yq5.a r0 = new yq5.a();
            r0.a = this.a;
            r0.b = r7.space_name;
            r0.c = r7.space_icon;
            r0.d = r7.tenant_id;
            r0.e = r7.description;
            r0.f = r7.is_star;
            r0.g = r7.space_type;
            r0.h = r7.wiki_scope;
            r0.i = r7.open_sharing;
            r0.j = r7.owner_perm_type;
            r0.k = r7.create_uid;
            SpaceInfo.SpaceCover r1 = r7.space_cover;
            if (r1 == null) goto L5;
            r0.l = r1.origin;
            r0.m = r1.thumbnail;
            r0.n = r1.key;
            r0.o = r1.is_graph_dark;
            r0.p = r1.color_value;
        L5:
            WikiHomePageV2 r2 = r7.homePageV2;
            if (yp5.c.i() == false) goto L33;
            String r3 = "";
            if (r2 == null) goto L11;
            String r4 = r2.objToken;
            if (r4 == null) goto L11;
        L12:
            r0.v = r4;
            if (r2 == null) goto L15;
            int r5 = r2.objType;
        L16:
            r0.w = r5;
            if (r2 == null) goto L20;
            String r8 = r2.wikiToken;
            if (r8 == null) goto L20;
        L21:
            r0.x = r8;
            if (r2 == null) goto L25;
            String r9 = r2.url;
            if (r9 == null) goto L25;
        L26:
            r0.y = r9;
            if (r2 == null) goto L32;
            String r10 = r2.title;
            if (r10 == null) goto L32;
            r3 = r10;
        L32:
            r0.z = r3;
        L25:
            r9 = "";
        L20:
            r8 = "";
            goto L21
        L15:
            r5 = 0;
        L11:
            r4 = "";
        L33:
            r0.u = false;
            r0.q = false;
            r0.r = false;
            r0.s = false;
            r0.t = false;
            WikiDatabase.c().d().k(r0);
            r7.space_id = this.a;
            return new up5.b(r7);
        }
    }

    static {
        a = new a3();
    }

    public a3() {
    }

    public static Flowable a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "spaceId");
        Flowable r2 = b(r1);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.map(up5.c.a).observeOn(fo5.d.d());
    }

    public static Flowable b(String r3) {
        return com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.c((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).a(new GetSpaceInfoPuller.Params(r3)).observeOn(fo5.d.c()).map(new a(r3));
    }
}

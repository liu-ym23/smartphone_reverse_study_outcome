package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetSpaceInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a3 f241764a = null;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f241765a;

        public a(String r100) {
            this.f241765a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            SpaceInfo r101 = (SpaceInfo) r100;
            Intrinsics.checkNotNullParameter(r101, "spaceInfo");
            yq5.a r102 = new yq5.a();
            r102.f568752a = this.f241765a;
            r102.f568753b = r101.space_name;
            r102.f568754c = r101.space_icon;
            r102.f568755d = r101.tenant_id;
            r102.f568756e = r101.description;
            r102.f568757f = r101.is_star;
            r102.f568758g = r101.space_type;
            r102.f568759h = r101.wiki_scope;
            r102.f568760i = r101.open_sharing;
            r102.f568761j = r101.owner_perm_type;
            r102.f568762k = r101.create_uid;
            SpaceInfo.SpaceCover r103 = r101.space_cover;
            if (r103 == null) goto L5;
            r102.f568763l = r103.origin;
            r102.f568764m = r103.thumbnail;
            r102.f568765n = r103.key;
            r102.f568766o = r103.is_graph_dark;
            r102.f568767p = r103.color_value;
        L5:
            WikiHomePageV2 r104 = r101.homePageV2;
            if (yp5.c.i() == false) goto L33;
            String r105 = "";
            if (r104 == null) goto L11;
            String r106 = r104.objToken;
            if (r106 == null) goto L11;
        L12:
            r102.f568773v = r106;
            if (r104 == null) goto L15;
            int r107 = r104.objType;
        L16:
            r102.f568774w = r107;
            if (r104 == null) goto L20;
            String r108 = r104.wikiToken;
            if (r108 == null) goto L20;
        L21:
            r102.f568775x = r108;
            if (r104 == null) goto L25;
            String r109 = r104.url;
            if (r109 == null) goto L25;
        L26:
            r102.f568776y = r109;
            if (r104 == null) goto L32;
            String r110 = r104.title;
            if (r110 == null) goto L32;
            r105 = r110;
        L32:
            r102.f568777z = r105;
        L25:
            r109 = "";
        L20:
            r108 = "";
            goto L21
        L15:
            r107 = 0;
        L11:
            r106 = "";
        L33:
            r102.f568772u = false;
            r102.f568768q = false;
            r102.f568769r = false;
            r102.f568770s = false;
            r102.f568771t = false;
            WikiDatabase.c().d().k(r102);
            r101.space_id = this.f241765a;
            return new up5.b(r101);
        }
    }

    static {
        f241764a = new a3();
    }

    public a3() {
    }

    public static Flowable a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Flowable r101 = b(r100);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.map(up5.c.f551049a).observeOn(fo5.d.d());
    }

    public static Flowable b(String r100) {
        return com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.c((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).a(new GetSpaceInfoPuller.Params(r100)).observeOn(fo5.d.c()).map(new a(r100));
    }
}

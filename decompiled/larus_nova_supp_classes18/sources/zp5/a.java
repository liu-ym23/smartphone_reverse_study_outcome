package zp5;

import com.bytedance.ee.bear.contract.route.parcelable.WikiDocument;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceCover;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final List<yq5.d> b(List<? extends SpaceBean> r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        List<? extends SpaceBean> r7 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L18;
        SpaceBean r2 = (SpaceBean) r8.next();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        yq5.d r3 = new yq5.d();
        r3.a = r2.space_id;
        r3.b = r2.space_name;
        r3.c = r2.description;
        r3.d = r2.space_icon;
        r3.e = r2.tenant_id;
        SpaceCover r4 = r2.space_cover;
        if (r4 == null) goto L8;
        r3.f = r4.origin;
        r3.g = r4.thumbnail;
        r3.h = r4.key;
        r3.i = r4.is_graph_dark;
        r3.j = r4.color_value;
    L8:
        r3.k = r2.root_token;
        r3.l = r2.space_type;
        r3.m = r2.wiki_scope;
        r3.n = r2.is_star;
        r3.o = r2.browse_time;
        r3.q = r2.open_sharing;
        DisplayTag r5 = r2.display_tag;
        if (r5 == null) goto L11;
        int r9 = r5.getTag_type();
    L12:
        r3.r = r9;
        DisplayTag r10 = r2.display_tag;
        if (r10 == null) goto L16;
        String r11 = r10.getTag_value();
        if (r11 == null) goto L16;
    L17:
        r3.s = r11;
        r3.t = r2.space_icon_info;
        r1.add(r3);
    L16:
        r11 = "";
        goto L17
    L11:
        r9 = 0;
        goto L12
    L18:
        return r1;
    }

    @Deprecated(message = "")
    public static final WikiDocument c(SpaceBean r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        WikiDocument r0 = new WikiDocument();
        r0.m = r3.space_id;
        r0.a = r3.space_name;
        r0.q = r3.space_icon;
        r0.P2 = r3.description;
        r0.z = r3.is_star;
        r0.l = r3.browse_time;
        r0.U2 = r3.wiki_scope;
        r0.V2 = r3.open_sharing;
        r0.W2 = r3.display_tag;
        SpaceCover r4 = r3.space_cover;
        if (r4 == null) goto L5;
        WikiDocument.SpaceCover r1 = new WikiDocument.SpaceCover();
        r1.a = r4.origin;
        r1.b = r4.thumbnail;
        r1.e = r4.color_value;
        r1.d = r4.is_graph_dark;
        r1.c = r4.key;
        r0.R2 = r1;
    L5:
        return r0;
    }

    public static final List<SpaceBean> d(List<? extends yq5.d> r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        yq5.d r2 = (yq5.d) r7.next();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        SpaceBean r3 = new SpaceBean();
        r3.space_id = r2.a;
        r3.space_name = r2.b;
        r3.description = r2.c;
        r3.space_icon = r2.d;
        r3.tenant_id = r2.e;
        SpaceCover r4 = new SpaceCover();
        r4.origin = r2.f;
        r4.thumbnail = r2.g;
        r4.key = r2.h;
        r4.is_graph_dark = r2.i;
        r4.color_value = r2.j;
        r3.space_cover = r4;
        r3.root_token = r2.k;
        r3.space_type = r2.l;
        r3.wiki_scope = r2.m;
        r3.is_star = r2.n;
        r3.browse_time = r2.o;
        r3.open_sharing = r2.q;
        DisplayTag r5 = new DisplayTag();
        r5.setTag_type(r2.r);
        r5.setTag_value(r2.s);
        r3.display_tag = r5;
        r3.space_icon_info = r2.t;
        r1.add(r3);
        goto L4
    L6:
        return r1;
    }

    public static final List<yq5.e> a(List<? extends yq5.d> r6, int r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r8, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r9, "spaceClassId");
        List<? extends yq5.d> r10 = r6;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        yq5.d r4 = (yq5.d) r11.next();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r8, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r9, "spaceClassId");
        yq5.e r5 = new yq5.e();
        r5.a = r4.a;
        r5.b = r7;
        r5.c = r8;
        r5.d = r9;
        r3.add(r5);
        goto L4
    L6:
        return r3;
    }
}

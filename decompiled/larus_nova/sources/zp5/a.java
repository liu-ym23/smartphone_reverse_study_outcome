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

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static final List<yq5.d> b(List<? extends SpaceBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<? extends SpaceBean> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L18;
        SpaceBean r104 = (SpaceBean) r103.next();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        yq5.d r105 = new yq5.d();
        r105.f568801a = r104.space_id;
        r105.f568802b = r104.space_name;
        r105.f568803c = r104.description;
        r105.f568804d = r104.space_icon;
        r105.f568805e = r104.tenant_id;
        SpaceCover r106 = r104.space_cover;
        if (r106 == null) goto L8;
        r105.f568806f = r106.origin;
        r105.f568807g = r106.thumbnail;
        r105.f568808h = r106.key;
        r105.f568809i = r106.is_graph_dark;
        r105.f568810j = r106.color_value;
    L8:
        r105.f568811k = r104.root_token;
        r105.f568812l = r104.space_type;
        r105.f568813m = r104.wiki_scope;
        r105.f568814n = r104.is_star;
        r105.f568815o = r104.browse_time;
        r105.f568817q = r104.open_sharing;
        DisplayTag r107 = r104.display_tag;
        if (r107 == null) goto L11;
        int r108 = r107.getTag_type();
    L12:
        r105.f568818r = r108;
        DisplayTag r109 = r104.display_tag;
        if (r109 == null) goto L16;
        String r110 = r109.getTag_value();
        if (r110 == null) goto L16;
    L17:
        r105.f568819s = r110;
        r105.f568820t = r104.space_icon_info;
        r102.add(r105);
    L16:
        r110 = "";
        goto L17
    L11:
        r108 = 0;
        goto L12
    L18:
        return r102;
    }

    @Deprecated(message = "")
    public static final WikiDocument c(SpaceBean r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WikiDocument r101 = new WikiDocument();
        r101.f227888m = r100.space_id;
        r101.f227868a = r100.space_name;
        r101.f227895q = r100.space_icon;
        r101.P2 = r100.description;
        r101.f227910z = r100.is_star;
        r101.f227887l = r100.browse_time;
        r101.U2 = r100.wiki_scope;
        r101.V2 = r100.open_sharing;
        r101.W2 = r100.display_tag;
        SpaceCover r102 = r100.space_cover;
        if (r102 == null) goto L5;
        WikiDocument.SpaceCover r103 = new WikiDocument.SpaceCover();
        r103.f217149a = r102.origin;
        r103.f217150b = r102.thumbnail;
        r103.f217153e = r102.color_value;
        r103.f217152d = r102.is_graph_dark;
        r103.f217151c = r102.key;
        r101.R2 = r103;
    L5:
        return r101;
    }

    public static final List<SpaceBean> d(List<? extends yq5.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        yq5.d r103 = (yq5.d) r102.next();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        SpaceBean r104 = new SpaceBean();
        r104.space_id = r103.f568801a;
        r104.space_name = r103.f568802b;
        r104.description = r103.f568803c;
        r104.space_icon = r103.f568804d;
        r104.tenant_id = r103.f568805e;
        SpaceCover r105 = new SpaceCover();
        r105.origin = r103.f568806f;
        r105.thumbnail = r103.f568807g;
        r105.key = r103.f568808h;
        r105.is_graph_dark = r103.f568809i;
        r105.color_value = r103.f568810j;
        r104.space_cover = r105;
        r104.root_token = r103.f568811k;
        r104.space_type = r103.f568812l;
        r104.wiki_scope = r103.f568813m;
        r104.is_star = r103.f568814n;
        r104.browse_time = r103.f568815o;
        r104.open_sharing = r103.f568817q;
        DisplayTag r106 = new DisplayTag();
        r106.setTag_type(r103.f568818r);
        r106.setTag_value(r103.f568819s);
        r104.display_tag = r106;
        r104.space_icon_info = r103.f568820t;
        r101.add(r104);
        goto L4
    L6:
        return r101;
    }

    public static final List<yq5.e> a(List<? extends yq5.d> r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r103, "spaceClassId");
        List<? extends yq5.d> r104 = r100;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        yq5.d r107 = (yq5.d) r106.next();
        Intrinsics.checkNotNullParameter(r107, "<this>");
        Intrinsics.checkNotNullParameter(r102, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r103, "spaceClassId");
        yq5.e r108 = new yq5.e();
        r108.f568821a = r107.f568801a;
        r108.f568822b = r101;
        r108.f568823c = r102;
        r108.f568824d = r103;
        r105.add(r108);
        goto L4
    L6:
        return r105;
    }
}

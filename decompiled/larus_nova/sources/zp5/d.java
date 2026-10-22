package zp5;

import com.bytedance.ee.bear.contract.route.parcelable.WikiDocument;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f573189a;

    public d(String r100) {
        this.f573189a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SpaceInfo r101 = (SpaceInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        WikiDocument r102 = new WikiDocument();
        r102.f227888m = this.f573189a;
        r102.f227868a = r101.getSpaceName();
        r102.f227895q = r101.space_icon;
        r102.f227910z = r101.is_star;
        r102.P2 = r101.description;
        r102.U2 = r101.wiki_scope;
        r102.V2 = r101.open_sharing;
        r102.W2 = r101.display_tag;
        if (r101.space_cover == null) goto L5;
        WikiDocument.SpaceCover r103 = new WikiDocument.SpaceCover();
        SpaceInfo.SpaceCover r104 = r101.space_cover;
        r103.f217151c = r104.key;
        r103.f217153e = r104.color_value;
        r103.f217152d = r104.is_graph_dark;
        r103.f217149a = r104.origin;
        r103.f217150b = r104.thumbnail;
        r102.R2 = r103;
    L5:
        return r102;
    }
}

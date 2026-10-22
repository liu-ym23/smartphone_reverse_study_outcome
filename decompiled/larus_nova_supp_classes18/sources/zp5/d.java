package zp5;

import com.bytedance.ee.bear.contract.route.parcelable.WikiDocument;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ String a;

    public d(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        SpaceInfo r5 = (SpaceInfo) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        WikiDocument r0 = new WikiDocument();
        r0.m = this.a;
        r0.a = r5.getSpaceName();
        r0.q = r5.space_icon;
        r0.z = r5.is_star;
        r0.P2 = r5.description;
        r0.U2 = r5.wiki_scope;
        r0.V2 = r5.open_sharing;
        r0.W2 = r5.display_tag;
        if (r5.space_cover == null) goto L5;
        WikiDocument.SpaceCover r1 = new WikiDocument.SpaceCover();
        SpaceInfo.SpaceCover r6 = r5.space_cover;
        r1.c = r6.key;
        r1.e = r6.color_value;
        r1.d = r6.is_graph_dark;
        r1.a = r6.origin;
        r1.b = r6.thumbnail;
        r0.R2 = r1;
    L5:
        return r0;
    }
}

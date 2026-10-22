package fg5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.reaction.ReactionContent;
import com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import gg5.o;
import gg5.p;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends BaseFeedItemAdapter<ReactionContent> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function5<String, String, String, Boolean, Notice<?>, Unit> f476853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<String, Unit> f476854e;

    @Override // ag5.a
    public final int b() {
        return 6;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter
    public final View f(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return r100.inflate(R.layout.reaction_feed_item_sub_content, r101, false);
    }

    public c(o r100, p r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "toMessage");
        Intrinsics.checkNotNullParameter(r101, "gotoProfile");
        super(r100, r101, r102);
        this.f476853d = r100;
        this.f476854e = r101;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter
    public final void e(View r100, FrameLayout r101, Notice<ReactionContent> r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "frameLayout");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        ContentWraper<Content> r104 = r102.getContent();
        if (r104 == 0) goto L26;
        ReactionContent r105 = (ReactionContent) r104.getData();
        if (r105 == null) goto L28;
        ImageView r106 = (ImageView) r101.findViewById(R.id.iv_emoji);
        ArrayList<ReactionContent.Reaction> r107 = r105.getReactions();
        if (r107 != null) goto L10;
    L13:
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
        r106.setVisibility(8);
        return;
    L16:
        r106.setVisibility(0);
        rsb.a r109 = qsb.b.a();
        ArrayList<ReactionContent.Reaction> r110 = r105.getReactions();
        if (r110 == null) goto L21;
        ReactionContent.Reaction r111 = (ReactionContent.Reaction) ListProtector.get(r110, 0);
        if (r111 == null) goto L21;
        String r112 = r111.getKey();
    L22:
        if (r112 != null) goto L24;
        r112 = "";
    L24:
        r106.setImageBitmap(r109.Hb(r112, false));
        return;
    L21:
        r112 = null;
        goto L22
    L10:
        if (r107.isEmpty() == true) goto L13;
        r108 = false;
        goto L14
    L28:
        return;
    }
}

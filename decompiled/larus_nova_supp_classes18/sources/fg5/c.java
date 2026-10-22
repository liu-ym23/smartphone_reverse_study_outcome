package fg5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.reaction.ReactionContent;
import com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import gg5.o;
import gg5.p;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends BaseFeedItemAdapter<ReactionContent> {
    public final Function5<String, String, String, Boolean, Notice<?>, Unit> d;
    public final Function1<String, Unit> e;

    @Override // ag5.a
    public final int b() {
        return 6;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter
    public final View f(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return r3.inflate(2131564262, r4, false);
    }

    public c(o r2, p r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "toMessage");
        Intrinsics.checkNotNullParameter(r3, "gotoProfile");
        super(r2, r3, r4);
        this.d = r2;
        this.e = r3;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter
    public final void e(View r1, FrameLayout r2, Notice<ReactionContent> r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "itemView");
        Intrinsics.checkNotNullParameter(r2, "frameLayout");
        Intrinsics.checkNotNullParameter(r3, "item");
        ContentWraper<Content> r5 = r3.getContent();
        if (r5 == 0) goto L26;
        ReactionContent r6 = (ReactionContent) r5.getData();
        if (r6 == null) goto L28;
        ImageView r7 = (ImageView) r2.findViewById(2131376206);
        ArrayList<ReactionContent.Reaction> r8 = r6.getReactions();
        if (r8 != null) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        r7.setVisibility(8);
        return;
    L16:
        r7.setVisibility(0);
        rsb.a r10 = qsb.b.a();
        ArrayList<ReactionContent.Reaction> r11 = r6.getReactions();
        if (r11 == null) goto L21;
        ReactionContent.Reaction r12 = (ReactionContent.Reaction) ListProtector.get(r11, 0);
        if (r12 == null) goto L21;
        String r13 = r12.getKey();
    L22:
        if (r13 != null) goto L24;
        r13 = "";
    L24:
        r7.setImageBitmap(r10.Hb(r13, false));
        return;
    L21:
        r13 = null;
        goto L22
    L10:
        if (r8.isEmpty() == true) goto L13;
        r9 = false;
        goto L14
    L28:
        return;
    }
}

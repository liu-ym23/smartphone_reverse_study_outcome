package vq5;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiHorizontalScrollView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;
import gq5.b;
import gq5.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnLayoutChangeListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a b;
    public final /* synthetic */ WikiTreeView c;

    public a(RecyclerView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a r2, WikiTreeView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        int r10 = this.a.getMeasuredWidth();
        WikiHorizontalScrollView r11 = this.b.b;
        if (r11 == null) goto L5;
        int r12 = r11.getMeasuredWidth();
    L6:
        if (r10 <= r12) goto L12;
        String r13 = this.c.getSpaceId();
        if (r13 != null) goto L10;
        r13 = "";
    L10:
        Long r14 = b.a;
        JSONObject r15 = new JSONObject();
        e.b(r15, "space_id", e.a(r13));
        e.c("ccm_wiki_trigger_slide_event_dev", r15);
        return;
    L12:
        return;
    L5:
        r12 = 0;
        goto L6
    }
}

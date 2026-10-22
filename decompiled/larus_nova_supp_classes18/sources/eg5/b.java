package eg5;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedTipsModel;
import com.bytedance.ee.bear.middleground.feed.view.adapter.ViewHolder;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.n;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ag5.a<ViewHolder, FeedTipsModel> {
    @Override // ag5.a
    public final int b() {
        return 7;
    }

    public b() {
    }

    @Override // ag5.a
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "adapter");
        Intrinsics.checkNotNullParameter(r5, "parent");
        TextView r6 = new TextView(r5.getContext());
        r6.setTextSize(14.0f);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), 2131106620));
        r6.setPadding(n.d(16), n.d(16), 0, n.d(8));
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new ViewHolder(r6);
    }

    @Override // ag5.a
    public final void d(RecyclerView.Adapter r7, RecyclerView.ViewHolder r8, int r9, MultiBean r10, boolean r11) {
        ViewHolder r12 = (ViewHolder) r8;
        FeedTipsModel r13 = (FeedTipsModel) r10;
        Intrinsics.checkNotNullParameter(r7, "adapter");
        Intrinsics.checkNotNullParameter(r12, "holder");
        Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.DATA);
        String r14 = StringsKt.replace$default(r12.a.getContext().getString(2131886407), 'D', 'd', false, 4, null);     // Catch: Exception -> L5
        TextView r15 = r12.a;     // Catch: Exception -> L5
        r15.setText(xo5.a.c(r15.getContext(), 2131886436, "date", new SimpleDateFormat(r14).format(Long.valueOf(r13.getTs()))));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("FeedTipsAdapter", "getTime error " + e);
    }
}

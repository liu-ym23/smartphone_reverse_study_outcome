package eg5;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedTipsModel;
import com.bytedance.ee.bear.middleground.feed.view.adapter.ViewHolder;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements ag5.a<ViewHolder, FeedTipsModel> {
    @Override // ag5.a
    public final int b() {
        return 7;
    }

    public b() {
    }

    @Override // ag5.a
    public final RecyclerView.ViewHolder c(RecyclerView.Adapter r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "parent");
        TextView r102 = new TextView(r101.getContext());
        r102.setTextSize(14.0f);
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), R.color.text_placeholder));
        r102.setPadding(n.d(16), n.d(16), 0, n.d(8));
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new ViewHolder(r102);
    }

    @Override // ag5.a
    public final void d(RecyclerView.Adapter r100, RecyclerView.ViewHolder r101, int r102, MultiBean r110, boolean r111) {
        ViewHolder r103 = (ViewHolder) r101;
        FeedTipsModel r112 = (FeedTipsModel) r110;
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r112, "data");
        String r104 = StringsKt.replace$default(r103.f232661a.getContext().getString(R.string.Bitable_DateFormat_LongDate_Placeholder), 'D', Directory.UNIX_ID, false, 4, null);     // Catch: Exception -> L5
        TextView r105 = r103.f232661a;     // Catch: Exception -> L5
        r105.setText(xo5.a.c(r105.getContext(), R.string.Bitable_FeedCenter_Onboarding_OnlyDisplayNotificationsBeforeDate_Desc, "date", new SimpleDateFormat(r104).format(Long.valueOf(r112.getTs()))));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("FeedTipsAdapter", "getTime error " + e);
    }
}

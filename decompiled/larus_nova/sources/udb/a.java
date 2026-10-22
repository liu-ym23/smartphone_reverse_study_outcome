package udb;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends FeedCardComponent<Object, AppCompatImageView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f549755c;

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        AppCompatImageView r100 = new AppCompatImageView(getContext());
        r100.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return r100;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public Context getContext() {
        return this.f549755c;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f549755c = r100;
    }
}

package vdb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends FeedCardComponent<b, AppCompatImageView> {

    /* JADX INFO: renamed from: vdb.a$a, reason: collision with other inner class name */
    public static final class C7986a {
    }

    public static final class b {
        public b(Drawable r100) {
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        AppCompatImageView r100 = new AppCompatImageView(getContext());
        r100.setScaleType(ImageView.ScaleType.FIT_XY);
        r100.setPadding(0, 0, UIHelper.dp2px(4.0f), 0);
        return r100;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}

package wdb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends FeedCardComponent<Object, TextView> {

    /* JADX INFO: renamed from: wdb.a$a, reason: collision with other inner class name */
    public static final class C8098a {
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        TextView r100 = new TextView(getContext());
        r100.setTextColor(UDColorUtils.getColor(r100.getContext(), R.color.text_title));
        r100.setTextSize(0, b.h(r100.getContext(), 16));
        r100.setEllipsize(TextUtils.TruncateAt.END);
        r100.setSingleLine(true);
        return r100;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}

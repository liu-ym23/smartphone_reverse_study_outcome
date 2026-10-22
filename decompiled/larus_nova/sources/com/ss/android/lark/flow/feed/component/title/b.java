package com.ss.android.lark.flow.feed.component.title;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends FeedCardComponent<C4999b, TextView> {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.title.b$b, reason: collision with other inner class name */
    public static final class C4999b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f423359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f423360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f423361c;

        public C4999b(String r100, boolean r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "titleText");
            this.f423359a = r100;
            this.f423360b = r101;
            this.f423361c = r102;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        TextView r100 = new TextView(getContext());
        r100.setTextColor(UDColorUtils.getColor(r100.getContext(), R.color.text_title));
        r100.setTextSize(0, zz7.b.h(r100.getContext(), 17));
        r100.setEllipsize(TextUtils.TruncateAt.END);
        r100.setSingleLine(true);
        return r100;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}

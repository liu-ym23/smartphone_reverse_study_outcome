package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends FeedCardComponent<b, FeedDigestTextView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f420938c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f420939d = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.cardcomponent.preview.a$a, reason: collision with other inner class name */
    public static final class C4962a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<DigestElement> f420940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f420941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f420942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f420943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f420944e;

        public b(List r100, int r101) {
            this.f420940a = r100;
            this.f420941b = null;
            this.f420942c = null;
            this.f420943d = r101;
            this.f420944e = 16;
        }
    }

    static {
        UIHelper.dp2px(16.0f);
        f420938c = UIHelper.dp2px(20.0f);
        f420939d = UIHelper.dp2px(16.0f);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        FeedDigestTextView r100 = new FeedDigestTextView(getContext());
        r100.setLineHeight(f420938c);
        r100.setSingleLine(true);
        r100.setGravity(16);
        r100.setMinHeight(f420939d);
        r100.setEllipsize(TextUtils.TruncateAt.END);
        r100.setIncludeFontPadding(true);
        r100.setTextColor(UDColorUtils.getColor(r100.getContext(), R.color.text_placeholder));
        r100.setTextSize(0, zz7.b.h(r100.getContext(), 14));
        return r100;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        return super.b();
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}

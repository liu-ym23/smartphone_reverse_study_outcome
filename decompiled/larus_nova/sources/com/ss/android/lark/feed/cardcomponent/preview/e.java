package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends FeedCardComponent<b, ImageView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f420954c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f420955d = 0;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f420956a;

        public b(boolean r100) {
            this.f420956a = r100;
        }
    }

    static {
        f420954c = UIHelper.dp2px(14.0f);
        f420955d = UIHelper.dp2px(16.0f);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        int r100 = f420954c;
        ViewGroup.MarginLayoutParams r101 = new ViewGroup.MarginLayoutParams(r100, r100);
        r101.leftMargin = f420955d;
        return r101;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        Drawable r100 = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_alerts_off_outlined, getContext().getResources().getColor(R.color.icon_n3));
        ImageView r101 = new ImageView(getContext());
        r101.setBackground(r100);
        return r101;
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ImageView r101 = c();
        if (r100.f420956a == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }
}

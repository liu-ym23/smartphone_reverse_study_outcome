package com.ss.android.lark.feed.cardcomponent.teams;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends FeedCardComponent<C4963b, FeedTeamView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f420982c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.cardcomponent.teams.b$b, reason: collision with other inner class name */
    public static final class C4963b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<FeedTeamInfo> f420983a;

        public C4963b(List<FeedTeamInfo> r100) {
            this.f420983a = r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        AttributeSet r100 = null;
        return new FeedTeamView(getContext(), r100, 6, 0);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        return new ConstraintLayout.LayoutParams(0, this.f420982c);
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f420982c = zz7.b.g(r100, 20);
    }
}

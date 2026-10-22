package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class SwipeActionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f414173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jdb.g f414174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<y6b.c<?>> f414175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c<y6b.c<?>> f414176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.a f414177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b.a f414178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CapturedItemInfo f414179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f414180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f414181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f414182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f414183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f414184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f414185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f414186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SwipeActionHandler$onItemTouchListener$1 f414187o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SwipeActionItemDecoration f414188p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SwipeActionHandler$childAttachStateChangeListener$1 f414189q;

    public static final class CapturedItemInfo {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int f414190i = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f414191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerView.ViewHolder f414192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f414193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f414194d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewTreeObserver.OnGlobalLayoutListener f414195e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f414196f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int[] f414197g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Lazy f414198h;

        public static final class a {
        }

        static {
        }

        public final float a() {
            this.f414193c.getLocationInWindow(this.f414196f);
            this.f414192b.itemView.getLocationInWindow(this.f414197g);
            return (this.f414196f[1] - this.f414197g[1]) + (this.f414193c.getHeight() / 2);
        }

        public CapturedItemInfo(RecyclerView r100, RecyclerView.ViewHolder r101, View r102, b r103) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "viewHolder");
            Intrinsics.checkNotNullParameter(r102, "anchorView");
            Intrinsics.checkNotNullParameter(r103, "action");
            this.f414191a = r100;
            this.f414192b = r101;
            this.f414193c = r102;
            this.f414194d = r103;
            this.f414196f = new int[2];
            this.f414197g = new int[2];
            this.f414198h = LazyKt.lazy(new SwipeActionHandler$CapturedItemInfo$iconDrawable$2(this));
        }
    }

    public static final class a {
    }

    static {
    }

    public static final void a(SwipeActionHandler r100) {
        SwipeActionItemDecoration r101 = r100.f414188p;
        if (r101 == null) goto L5;
        r101.f414207d = null;
    L5:
        CapturedItemInfo r102 = r100.f414179g;
        if (r102 == null) goto L8;
        r102.f414192b.itemView.getViewTreeObserver().removeOnGlobalLayoutListener(r102.f414195e);
    L8:
        r100.f414179g = null;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.SwipeActionHandler$onItemTouchListener$1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.SwipeActionHandler$childAttachStateChangeListener$1] */
    public SwipeActionHandler(m2b.a r100, jdb.g r101, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.c r102, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.e r103, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.f r104, f r105) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r102, "handlerDependency");
        Intrinsics.checkNotNullParameter(r103, "messageItemProvider");
        Intrinsics.checkNotNullParameter(r104, "messageListModeProvider");
        Intrinsics.checkNotNullParameter(r105, "actionProvider");
        this.f414173a = r100;
        this.f414174b = r101;
        this.f414175c = r102;
        this.f414176d = r103;
        this.f414177e = r104;
        this.f414178f = r105;
        this.f414181i = new g(this);
        this.f414184l = UIHelper.dp2px(60.0f);
        this.f414185m = UIHelper.dp2px(60.0f);
        this.f414186n = UIHelper.dp2px(46.0f);
        this.f414187o = new SwipeActionHandler$onItemTouchListener$1(this);
        this.f414189q = new SwipeActionHandler$childAttachStateChangeListener$1(this);
    }
}

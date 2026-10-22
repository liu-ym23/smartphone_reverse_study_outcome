package com.bytedance.ies.xelement;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class RecyclerItemStatusHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f249690e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f249691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f249692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f249693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerItemStatusHelper$recyclerScrollListener$1 f249694d;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f249695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerItemStatusHelper f249696b;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            int r100 = RecyclerItemStatusHelper.f249690e;
            RecyclerView r101 = this.f249695a;
            if (r101 != null) goto L5;
        L8:
            boolean r102 = false;
        L9:
            if (r102 == true) goto L11;
            return;
        L11:
            RecyclerView.LayoutManager r103 = this.f249695a.getLayoutManager();
            if ((r103 instanceof LinearLayoutManager) == false) goto L14;
            LinearLayoutManager r104 = (LinearLayoutManager) r103;
        L15:
            if (r104 == null) goto L22;
            int r105 = r104.findFirstVisibleItemPosition();
            int r106 = r104.findLastVisibleItemPosition();
            if (r105 != (-1)) goto L19;
            return;
        L19:
            if ((r106 - r105) < 0) goto L24;
            RecyclerItemStatusHelper.a(this.f249696b, r105, r106);
            return;
        L24:
            return;
        L22:
            return;
        L14:
            r104 = null;
            goto L15
        L5:
            if (r101.getVisibility() != 0) goto L8;
            r102 = r101.getGlobalVisibleRect(new Rect());
            goto L9
        }

        public b(RecyclerView r100, RecyclerItemStatusHelper r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "helper");
            this.f249695a = r100;
            this.f249696b = r101;
        }
    }

    static {
        new a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ies.xelement.RecyclerItemStatusHelper$recyclerScrollListener$1] */
    public RecyclerItemStatusHelper() {
        this.f249691a = -1;
        this.f249694d = new RecyclerItemStatusHelper$recyclerScrollListener$1(this);
    }

    public static final void a(RecyclerItemStatusHelper r100, int r101, int r102) {
        if ((r102 - r101) < 0) goto L26;
        int r103 = r100.f249691a;
        if (r103 != (-1)) goto L9;
        r100.f249691a = r101;
        r100.f249692b = r102;
    L7:
        if (r101 >= (r102 + 1)) goto L35;
        r101 = r101 + 1;
        goto L7
    L35:
        return;
    L9:
        if (r101 == r103) goto L17;
        if (r101 <= r103) goto L13;
    L11:
        if (r103 >= r101) goto L16;
        r103 = r103 + 1;
    L16:
        r100.f249691a = r101;
        goto L17
    L13:
        int r104 = r101;
    L14:
        if (r104 >= r103) goto L16;
        r104 = r104 + 1;
    L17:
        int r105 = r100.f249692b;
        if (r102 == r105) goto L33;
        if (r102 <= r105) goto L22;
    L20:
        if (r105 >= r102) goto L25;
        r105 = r105 + 1;
    L25:
        r100.f249692b = r102;
        return;
    L22:
        int r106 = r102;
    L23:
        if (r106 >= r105) goto L25;
        r106 = r106 + 1;
        goto L23
    L33:
        return;
    L26:
        r100.getClass();
    }
}

package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f194248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o14.a f194249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f194250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<View> f194251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DuxTextView f194252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f194253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f194254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CommentColorMode f194255h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f194256a = null;

        static {
            int[] r100 = new int[CommentColorMode.values().length];
            r100[CommentColorMode.MODE_LIGHT_OR_DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CommentColorMode.MODE_DARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f194256a = r100;
        }
    }

    public final void b() {
        View r100 = this.f194248a;
        if ((r100 instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r101 = (ConstraintLayout) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        ConstraintSet r102 = new ConstraintSet();
        r102.clone(r101);
        if (this.f194254g == true) goto L11;
    L13:
        r102.connect(R.id.digg_bury_container, 3, R.id.time, 3);
        r102.connect(R.id.digg_bury_container, 4, R.id.time, 4);
    L14:
        r102.applyTo(r101);
        return;
    L11:
        if (this.f194249b.p() == false) goto L13;
        r102.connect(R.id.digg_bury_container, 3, R.id.comment_fold_tips, 3);
        r102.connect(R.id.digg_bury_container, 4, R.id.comment_fold_tips, 4);
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public final void a(View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.f194251d).contains(r100) == true) goto L8;
        ((ArrayList) this.f194251d).add(r100);
        return;
    }

    public final void c(DuxTextView r100) {
        CommentColorMode r101 = this.f194255h;
        int r102 = a.f194256a[r101.ordinal()];
        if (r102 != 1) goto L5;
        r100.setTextColor(ContextCompat.getColor(y54.a.a(), R.color.TextQuaternary));
        return;
    L5:
        if (r102 == 2) goto L7;
        r100.setTextColor(ContextCompat.getColor(y54.a.a(), R.color.TextReverse4));
        return;
    L7:
        r100.setTextColor(ContextCompat.getColor(y54.a.a(), R.color.ConstTextInverse5));
    }

    public h(View r100, o14.a r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "comment");
        this.f194248a = r100;
        this.f194249b = r101;
        this.f194250c = r102;
        this.f194251d = new ArrayList();
        this.f194252e = (DuxTextView) r100.findViewById(R.id.comment_fold_tips);
        int r103 = AppCompatDelegate.getDefaultNightMode();
        if (r103 != 1) goto L5;
        CommentColorMode r104 = CommentColorMode.MODE_LIGHT;
    L9:
        this.f194255h = r104;
        return;
    L5:
        if (r103 == 2) goto L7;
        r104 = CommentColorMode.MODE_LIGHT_OR_DARK;
        goto L9
    L7:
        r104 = CommentColorMode.MODE_DARK;
        goto L9
    }
}

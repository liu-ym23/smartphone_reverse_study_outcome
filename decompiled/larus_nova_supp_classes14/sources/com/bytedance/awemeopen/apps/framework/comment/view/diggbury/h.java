package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public final View a;
    public final o14.a b;
    public final d c;
    public final List<View> d;
    public final DuxTextView e;
    public boolean f;
    public boolean g;
    public final CommentColorMode h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CommentColorMode.values().length];
            r0[CommentColorMode.MODE_LIGHT_OR_DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CommentColorMode.MODE_DARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final void b() {
        ConstraintLayout r0 = this.a;
        if ((r0 instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        ConstraintSet r2 = new ConstraintSet();
        r2.clone(r1);
        if (this.g == true) goto L11;
    L13:
        r2.connect(2131369091, 3, 2131388654, 3);
        r2.connect(2131369091, 4, 2131388654, 4);
    L14:
        r2.applyTo(r1);
        return;
    L11:
        if (this.b.p() == false) goto L13;
        r2.connect(2131369091, 3, 2131367342, 3);
        r2.connect(2131369091, 4, 2131367342, 4);
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final void a(View r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.d).contains(r2) == true) goto L8;
        ((ArrayList) this.d).add(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(DuxTextView r3) {
        CommentColorMode r0 = this.h;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        r3.setTextColor(ContextCompat.getColor(y54.a.a(), 2131100041));
        return;
    L5:
        if (r1 == 2) goto L7;
        r3.setTextColor(ContextCompat.getColor(y54.a.a(), 2131100049));
        return;
    L7:
        r3.setTextColor(ContextCompat.getColor(y54.a.a(), 2131099800));
    }

    public h(View r2, o14.a r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "comment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new ArrayList();
        this.e = (DuxTextView) r2.findViewById(2131367342);
        int r5 = AppCompatDelegate.getDefaultNightMode();
        if (r5 != 1) goto L5;
        CommentColorMode r6 = CommentColorMode.MODE_LIGHT;
    L9:
        this.h = r6;
        return;
    L5:
        if (r5 == 2) goto L7;
        r6 = CommentColorMode.MODE_LIGHT_OR_DARK;
        goto L9
    L7:
        r6 = CommentColorMode.MODE_DARK;
        goto L9
    }
}

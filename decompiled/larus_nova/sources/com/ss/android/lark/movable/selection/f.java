package com.ss.android.lark.movable.selection;

import android.os.Build;
import android.view.View;
import android.widget.Magnifier;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.movable.MovableView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f432794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f432795b;

    public static final class a implements c {
        public a() {
        }

        @Override // com.ss.android.lark.movable.selection.f.c
        public final void a(float r100, float r101) {
        }

        @Override // com.ss.android.lark.movable.selection.f.c
        public final void dismiss() {
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Magnifier f432796a;

        @Override // com.ss.android.lark.movable.selection.f.c
        public final void dismiss() {
            this.f432796a.dismiss();
        }

        public b(MovableView r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            this.f432796a = new Magnifier.Builder(r100).setCornerRadius(100.0f).build();
        }

        @Override // com.ss.android.lark.movable.selection.f.c
        public final void a(float r100, float r101) {
            this.f432796a.show(r100, r101);
        }
    }

    public interface c {
        void a(float r100, float r101);

        void dismiss();
    }

    public f(MovableView r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f432794a = r100;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        c r101 = new b(r100);
    L6:
        this.f432795b = r101;
        return;
    L5:
        r101 = new a();
        goto L6
    }
}

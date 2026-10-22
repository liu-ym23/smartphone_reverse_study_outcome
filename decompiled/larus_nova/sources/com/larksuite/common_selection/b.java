package com.larksuite.common_selection;

import android.os.Build;
import android.widget.Magnifier;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f282865a;

    public static final class a implements c {
        public a() {
        }

        @Override // com.larksuite.common_selection.b.c
        public final void a(float r100, float r101) {
        }

        @Override // com.larksuite.common_selection.b.c
        public final void dismiss() {
        }
    }

    /* JADX INFO: renamed from: com.larksuite.common_selection.b$b, reason: collision with other inner class name */
    public static final class C3885b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Magnifier f282866a;

        @Override // com.larksuite.common_selection.b.c
        public final void dismiss() {
            this.f282866a.dismiss();
        }

        public C3885b(SelectionContainer r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            this.f282866a = new Magnifier.Builder(r100).setCornerRadius(100.0f).build();
        }

        @Override // com.larksuite.common_selection.b.c
        public final void a(float r100, float r101) {
            this.f282866a.show(r100, r101);
        }
    }

    public interface c {
        void a(float r100, float r101);

        void dismiss();
    }

    public b(SelectionContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (Build.VERSION.SDK_INT < 29) goto L5;
        c r101 = new C3885b(r100);
    L6:
        this.f282865a = r101;
        return;
    L5:
        r101 = new a();
        goto L6
    }
}

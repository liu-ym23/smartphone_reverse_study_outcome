package com.ss.android.lark.widget.light.viewstub;

import android.view.View;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.light.layout.TextLayoutViewHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f446339a = null;

    public static final class a implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f446340b = null;

        static {
            f446340b = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.widget.light.viewstub.f
        public final View a(h r100) {
            Intrinsics.checkNotNullParameter(r100, "stubSpan");
            return r100.b(LarkContext.getApplication());
        }

        @Override // com.ss.android.lark.widget.light.viewstub.f
        public final void b(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            TextLayoutViewHelperKt.a(r100, r101);
        }
    }

    static {
        f446339a = a.f446340b;
    }

    View a(h r100);

    void b(View r100, int r101);
}

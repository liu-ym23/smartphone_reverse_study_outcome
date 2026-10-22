package com.bytedance.ee.bear.middleground.comment.adapter.aside;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelBottomSheetDialog;
import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView;
import com.bytedance.ee.bear.middleground.comment.audio.RecordViewModel;
import com.bytedance.ee.bear.middleground.comment.input.AsideInputComment;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Runnable {
    public final /* synthetic */ AsideCommentCardAdapter.AsideContentViewHolder a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ AsideCommentCardAdapter.AsideContentViewHolder a;

        public a(AsideCommentCardAdapter.AsideContentViewHolder r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            AsideInputComment r3 = this.a.x;
            if (r3 == null) goto L10;
            RecordPanelBottomSheetDialog r4 = r3.k0;
            if (r4 == null) goto L11;
            RecordPanelView r5 = r4.k;
            if (r5 == null) goto L12;
            r5.f();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public b(AsideCommentCardAdapter.AsideContentViewHolder r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsideCommentCardAdapter.AsideContentViewHolder r0 = this.a;     // Catch: Throwable -> L12
        AsideInputComment r1 = r0.x;     // Catch: Throwable -> L12
        if (r1 == null) goto L15;
        RecordViewModel r2 = r1.Q;     // Catch: Throwable -> L12
        if (r2 == null) goto L19;
        p r3 = r1.a;     // Catch: Throwable -> L12
        if (r3 == null) goto L20;
        FragmentActivity r4 = r3.getActivity();     // Catch: Throwable -> L12
        if (r4 == null) goto L21;
        r2.g.removeObservers(r4);     // Catch: Throwable -> L12
        r2.g.observe(r4, new a(r0));     // Catch: Throwable -> L12
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}

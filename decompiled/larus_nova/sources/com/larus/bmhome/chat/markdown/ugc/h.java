package com.larus.bmhome.chat.markdown.ugc;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import com.larus.platform.service.z2;
import com.larus.utils.t0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h implements ip8.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f307287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MarkdownUgcWidget f307288b;

    @Override // ip8.e
    public final void b(View r100, Content r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ip8.e
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public h(RecyclerView r100, MarkdownUgcWidget r101) {
        this.f307287a = r100;
        this.f307288b = r101;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.bmhome.chat.markdown.ugc.d] */
    @Override // ip8.e
    public final void c(View r100, final Content r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f307287a.getContext() == null) goto L22;
        if (r110 == null) goto L24;
        final MarkdownUgcWidget r101 = this.f307288b;
        final String r102 = MarkdownUgcWidget.j(r101);
        final int r103 = r100.getWidth();
        final int r104 = r100.getHeight();
        List<Content> r105 = this.f307288b.f307263p;
        if (r105 == null) goto L9;
        final int r106 = r105.indexOf(r110);
    L10:
        final ?? r107 = new d(r110, r101, r103, r104, r106, r102);
        if (z2.f365865a.enableTrackerOptimize() == false) goto L13;
        t0.a(new e(r107));
    L14:
        Integer r108 = r110.getItemType();
        int r109 = ItemType.ARTICLE.getValue();
        if (r108 != null) goto L18;
    L20:
        MarkdownUgcWidget.l(this.f307288b, r100, r110);
        return;
    L18:
        if (r108.intValue() != r109) goto L20;
        MarkdownUgcWidget.k(this.f307288b, r100, r110);
        return;
    L13:
        r107.invoke();
        goto L14
    L9:
        r106 = 0;
        goto L10
    L24:
        return;
    }
}

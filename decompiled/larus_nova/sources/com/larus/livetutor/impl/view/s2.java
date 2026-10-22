package com.larus.livetutor.impl.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class s2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TutorStarListWithTitleView f356904a;

    public /* synthetic */ s2(TutorStarListWithTitleView r100) {
        this.f356904a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TutorStarListWithTitleView r100 = this.f356904a;
        int r101 = TutorStarListWithTitleView.f356802c;
        TutorStarListView r102 = (TutorStarListView) r100.findViewById(R.id.star_list);
        if (r102 == null) goto L5;
        int r103 = r102.getWidth() / 2;
    L6:
        Iterator r104 = ((ArrayList) r100.f356803a).iterator();
        int r105 = 0;
    L8:
        if (r104.hasNext() == false) goto L24;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        TutorStarTitleView r108 = (TutorStarTitleView) r106;
        if (r102 == null) goto L19;
        Rect r109 = new Rect();
        RecyclerView.LayoutManager r110 = r102.getLayoutManager();
        if (r110 == null) goto L20;
        View r111 = r110.findViewByPosition(r105);
        if (r111 == null) goto L20;
        r109.left = r111.getLeft();
        r109.top = r111.getTop();
        r109.right = r111.getRight();
        r109.bottom = r111.getBottom();
    L20:
        if (r109 == null) goto L22;
        int r112 = r109.centerX();
    L23:
        r108.setTranslationX(r112 - r103);
        r105 = r107;
        goto L8
    L22:
        r112 = 0;
        goto L23
    L19:
        r109 = null;
        goto L20
    L24:
        return;
    L5:
        r103 = 0;
        goto L6
    }
}

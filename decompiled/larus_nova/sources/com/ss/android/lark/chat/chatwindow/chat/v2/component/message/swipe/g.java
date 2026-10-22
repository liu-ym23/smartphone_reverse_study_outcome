package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeActionHandler f414240a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        SwipeActionHandler r100 = this.f414240a;
        SwipeActionHandler.CapturedItemInfo r101 = r100.f414179g;
        if (r101 == null) goto L17;
        RecyclerView.ViewHolder r102 = r101.f414192b;
        if (r102 == null) goto L19;
        View r103 = r102.itemView;
        RecyclerView r104 = r100.f414182j;
        if (r104 != null) goto L11;
        return;
    L11:
        if (r103.getTranslationX() != this.f414240a.f414180h) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L18;
        Log.d("SwipeActionHandler", "force update translationX, xx: " + r103.getTranslationX() + ", pre: " + this.f414240a.f414180h);
        r104.invalidateItemDecorations();
        r103.setTranslationX(this.f414240a.f414180h);
        return;
    L18:
        return;
    L13:
        r105 = false;
        goto L14
    L19:
        return;
    }

    public g(SwipeActionHandler r100) {
        this.f414240a = r100;
    }
}

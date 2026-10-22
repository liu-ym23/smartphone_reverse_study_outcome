package com.ss.android.lark.newemoji.emojioptions;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OptionsSelectPopupMenu<Object> f433011a;

    public d(OptionsSelectPopupMenu<Object> r100) {
        this.f433011a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        Log.i("OptionsPopupMenu", String.valueOf(this.f433011a.f432974k));
        OptionsSelectPopupMenu<Object> r109 = this.f433011a;
        if (r109.f432972i == true) goto L5;
    L7:
        OptionsSelectPopupMenu<Object> r110 = this.f433011a;
        r110.f432974k = r110.f432986w.getDefaultDisplay().getOrientation();
        return;
    L5:
        if (r109.f432974k == r109.f432986w.getDefaultDisplay().getOrientation()) goto L7;
        this.f433011a.d(false);
        goto L7
    }
}

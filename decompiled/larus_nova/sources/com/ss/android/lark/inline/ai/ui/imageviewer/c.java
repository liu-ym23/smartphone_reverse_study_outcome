package com.ss.android.lark.inline.ai.ui.imageviewer;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageViewerFragment<Object> f427557a;

    public c(ImageViewerFragment<Object> r100) {
        this.f427557a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ImageViewerFragment<Object> r101 = this.f427557a;
        int r102 = r101.f427547o;
        if (r102 >= 0) goto L5;
    L29:
        Log.e("ImageViewerFragment", "mSelected click but mCurrentIndex is invalid! mCurrentIndex = " + this.f427557a.f427547o + ", urls.size = " + this.f427557a.f427545m.size());
        return;
    L5:
        if (r102 >= r101.f427545m.size()) goto L29;
        ImageViewerFragment<Object> r103 = this.f427557a;
        Object r104 = ListProtector.get(r103.f427545m, r103.f427547o);
        if (this.f427557a.f427546n.indexOf(r104) < 0) goto L18;
        this.f427557a.f427546n.remove(r104);
        AppCompatCheckBox r105 = this.f427557a.f427541i;
        if (r105 == null) goto L12;
        r105.setChecked(false);
    L12:
        AppCompatCheckBox r106 = this.f427557a.f427541i;
        if (r106 == null) goto L15;
        r106.setText(null);
    L15:
        ylb.a<Object> r107 = this.f427557a.f427548p;
        if (r107 == null) goto L27;
        r107.a(r104, false);
    L27:
        this.f427557a.T90();
        return;
    L18:
        this.f427557a.f427546n.add(r104);
        AppCompatCheckBox r108 = this.f427557a.f427541i;
        if (r108 == null) goto L21;
        r108.setChecked(true);
    L21:
        ImageViewerFragment<Object> r109 = this.f427557a;
        AppCompatCheckBox r110 = r109.f427541i;
        if (r110 == null) goto L24;
        r110.setText(String.valueOf(r109.f427546n.size()));
    L24:
        ylb.a<Object> r111 = this.f427557a.f427548p;
        if (r111 == null) goto L27;
        r111.a(r104, true);
        goto L27
    }
}

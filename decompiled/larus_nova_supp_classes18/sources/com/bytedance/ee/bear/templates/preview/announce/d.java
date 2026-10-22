package com.bytedance.ee.bear.templates.preview.announce;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.util.ui.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public FrameLayout a;
    public FrameLayout b;
    public ImageView c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public AnnounceTemplateViewModel g;

    public d() {
    }

    public final void a(int r5) {
        AnnounceTemplateViewModel r0 = this.g;
        if (r0 == null) goto L34;
        MutableLiveData<ArrayList<AnnounceTemplate>> r1 = r0.getTemplates();
        if (r1 == null) goto L35;
        ArrayList r2 = (ArrayList) r1.getValue();
        if (r2 == null) goto L36;
        int r3 = r2.size();
        boolean r4 = false;
        if (r5 < 0) goto L12;
        if (r5 >= r3) goto L12;
        r4 = true;
    L12:
        if (r4 == false) goto L27;
        TextView r6 = this.e;
        if (r6 == null) goto L27;
        AnnounceTemplateViewModel r7 = this.g;
        if (r7 == null) goto L24;
        MutableLiveData<ArrayList<AnnounceTemplate>> r8 = r7.getTemplates();
        if (r8 == null) goto L24;
        ArrayList r9 = (ArrayList) r8.getValue();
        if (r9 == null) goto L24;
        AnnounceTemplate r10 = (AnnounceTemplate) ListProtector.get(r9, r5);
        if (r10 == null) goto L24;
        String r11 = r10.getName();
    L25:
        r6.setText(r11);
    L24:
        r11 = null;
    L27:
        if (r5 < (r3 - 1)) goto L29;
        l.c(this.d, 2131102416);
    L30:
        if (r5 > 0) goto L32;
        l.c(this.c, 2131102416);
        return;
    L32:
        l.c(this.c, 2131102418);
        return;
    L29:
        l.c(this.d, 2131102418);
        goto L30
    L36:
        return;
    L35:
        return;
    }
}

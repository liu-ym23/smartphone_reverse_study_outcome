package com.bytedance.ee.bear.templates.preview.announce;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.util.ui.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f239172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f239173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f239174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f239175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f239176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f239177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnnounceTemplateViewModel f239178g;

    public d() {
    }

    public final void a(int r100) {
        AnnounceTemplateViewModel r101 = this.f239178g;
        if (r101 == null) goto L34;
        MutableLiveData<ArrayList<AnnounceTemplate>> r102 = r101.getTemplates();
        if (r102 == null) goto L35;
        ArrayList<AnnounceTemplate> r103 = r102.getValue();
        if (r103 == null) goto L36;
        int r104 = r103.size();
        boolean r105 = false;
        if (r100 < 0) goto L12;
        if (r100 >= r104) goto L12;
        r105 = true;
    L12:
        if (r105 == false) goto L27;
        TextView r106 = this.f239176e;
        if (r106 == null) goto L27;
        AnnounceTemplateViewModel r107 = this.f239178g;
        if (r107 == null) goto L24;
        MutableLiveData<ArrayList<AnnounceTemplate>> r108 = r107.getTemplates();
        if (r108 == null) goto L24;
        ArrayList<AnnounceTemplate> r109 = r108.getValue();
        if (r109 == null) goto L24;
        AnnounceTemplate r110 = (AnnounceTemplate) ListProtector.get(r109, r100);
        if (r110 == null) goto L24;
        String r111 = r110.getName();
    L25:
        r106.setText(r111);
    L24:
        r111 = null;
    L27:
        if (r100 < (r104 - 1)) goto L29;
        l.c(this.f239175d, R.color.icon_disable);
    L30:
        if (r100 > 0) goto L32;
        l.c(this.f239174c, R.color.icon_disable);
        return;
    L32:
        l.c(this.f239174c, R.color.icon_n1);
        return;
    L29:
        l.c(this.f239175d, R.color.icon_n1);
        goto L30
    L36:
        return;
    L35:
        return;
    }
}

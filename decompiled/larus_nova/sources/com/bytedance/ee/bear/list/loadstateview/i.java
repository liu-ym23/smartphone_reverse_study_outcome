package com.bytedance.ee.bear.list.loadstateview;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f228652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f228653b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f228654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f228655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f228656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f228657d;

        public a(int r100, int r101, int r102, int r103) {
            this.f228654a = r100;
            this.f228655b = r101;
            this.f228656c = r102;
            this.f228657d = r103;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.ee.bear.list.loadstateview.LoadStateView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static i a(LoadStateView r100) {
    L3:
        if (r100 == 0) goto L12;
        Object r101 = r100.getTag(R.id.list_office_load_state_style_config);
        if ((r101 instanceof i) == true) goto L7;
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == true) goto L10;
        r100 = 0;
        goto L3
    L10:
        r100 = (View) r102;
        goto L3
    L7:
        return (i) r101;
    L12:
        return null;
    }

    public i(a r100, a r101) {
        this.f228652a = r100;
        this.f228653b = r101;
    }
}

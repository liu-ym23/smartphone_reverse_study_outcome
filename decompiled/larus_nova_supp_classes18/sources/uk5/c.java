package uk5;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends a {
    public final String b;
    public String c;
    public final int d;
    public final int e;
    public final View f;
    public final RectF g;
    public final boolean h;
    public FlowStyleHollowShape i;
    public int j;
    public d k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public boolean p;

    public final String toString() {
        return "FlowData{title='" + this.b + "', body='" + this.c + "', index=" + this.d + ", count=" + this.e + ", targetView=" + this.f + ", targetRect=" + this.g + ", isLast='" + this.h + "', hollowShape=" + this.i + ", customHighlightRectRadius=" + this.j + '}';
    }

    public c(String r1, RectF r2) {
        this.b = r1;
        this.d = 2;
        this.e = 2;
        this.g = r2;
    }

    public c(String r1, View r2) {
        this.b = r1;
        this.h = true;
        this.f = r2;
    }

    public c(String r1, View r2, int r3) {
        this.b = r1;
        this.d = 1;
        this.e = 2;
        this.f = r2;
    }

    public c(String r1, boolean r2, RectF r3) {
        this.b = r1;
        this.h = r2;
        this.g = r3;
    }
}

package uk5;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.ee.bear.onboarding.export.Direction;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends a {
    public final String b;
    public String c;
    public final View d;
    public final int[] e;
    public final RectF f;
    public Direction g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    public final String toString() {
        return "TextData{title='" + this.b + "', body='" + this.c + "', targetView=" + this.d + ", timerDuration=" + this.h + ", autoDismissDelayTime=" + this.i + ", targetPos=" + Arrays.toString(this.e) + '}';
    }

    public e(String r2, RectF r3) {
        this.i = -1;
        this.k = false;
        this.l = false;
        this.b = r2;
        this.f = r3;
    }

    public e(String r2, View r3) {
        this.i = -1;
        this.k = false;
        this.l = false;
        this.b = r2;
        this.d = r3;
    }

    public e(String r2, int[] r3) {
        this.i = -1;
        this.k = false;
        this.l = false;
        this.b = r2;
        this.e = r3;
    }
}

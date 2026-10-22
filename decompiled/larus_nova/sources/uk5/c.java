package uk5;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f550502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f550503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f550504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f550505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f550506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f550507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FlowStyleHollowShape f550508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f550509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f550510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f550511l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f550512m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f550513n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f550514o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f550515p;

    public final String toString() {
        return "FlowData{title='" + this.f550501b + "', body='" + this.f550502c + "', index=" + this.f550503d + ", count=" + this.f550504e + ", targetView=" + this.f550505f + ", targetRect=" + this.f550506g + ", isLast='" + this.f550507h + "', hollowShape=" + this.f550508i + ", customHighlightRectRadius=" + this.f550509j + '}';
    }

    public c(String r100, RectF r101) {
        this.f550501b = r100;
        this.f550503d = 2;
        this.f550504e = 2;
        this.f550506g = r101;
    }

    public c(String r100, View r101) {
        this.f550501b = r100;
        this.f550507h = true;
        this.f550505f = r101;
    }

    public c(String r100, View r101, int r102) {
        this.f550501b = r100;
        this.f550503d = 1;
        this.f550504e = 2;
        this.f550505f = r101;
    }

    public c(String r100, boolean r101, RectF r102) {
        this.f550501b = r100;
        this.f550507h = r101;
        this.f550506g = r102;
    }
}

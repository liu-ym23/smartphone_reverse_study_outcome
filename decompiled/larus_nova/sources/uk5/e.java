package uk5;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.ee.bear.onboarding.export.Direction;
import java.util.Arrays;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f550517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f550518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f550519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f550520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Direction f550521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f550522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f550523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f550524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f550525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f550526l;

    public final String toString() {
        return "TextData{title='" + this.f550516b + "', body='" + this.f550517c + "', targetView=" + this.f550518d + ", timerDuration=" + this.f550522h + ", autoDismissDelayTime=" + this.f550523i + ", targetPos=" + Arrays.toString(this.f550519e) + '}';
    }

    public e(String r100, RectF r101) {
        this.f550523i = -1;
        this.f550525k = false;
        this.f550526l = false;
        this.f550516b = r100;
        this.f550520f = r101;
    }

    public e(String r100, View r101) {
        this.f550523i = -1;
        this.f550525k = false;
        this.f550526l = false;
        this.f550516b = r100;
        this.f550518d = r101;
    }

    public e(String r100, int[] r101) {
        this.f550523i = -1;
        this.f550525k = false;
        this.f550526l = false;
        this.f550516b = r100;
        this.f550519e = r101;
    }
}

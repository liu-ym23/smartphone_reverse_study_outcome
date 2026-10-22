package qsb;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f534724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f534725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f534726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f534727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f534728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f534729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f534730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f534731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f534732j;

    public final int a() {
        if (this.f534732j != (-1)) goto L13;
        if (this.f534727e != null) goto L7;
        b();
    L7:
        Bitmap r100 = this.f534727e;
        if (r100 != null) goto L11;
        return 32;
    L11:
        this.f534732j = UIHelper.px2dp(r100.getHeight());
    L13:
        return this.f534732j;
    }

    public final Bitmap b() {
        if (this.f534727e != null) goto L15;
        int r100 = this.f534729g;
        if (r100 > 0) goto L8;
        return null;
    L8:
        Drawable r101 = UIHelper.getDrawable(r100);
        if ((r101 instanceof BitmapDrawable) == false) goto L12;
        this.f534727e = ((BitmapDrawable) r101).getBitmap();
    L12:
        if (this.f534727e != null) goto L15;
        this.f534729g = -1;
    L15:
        return this.f534727e;
    }

    public final int c() {
        if (this.f534731i != (-1)) goto L13;
        if (this.f534727e != null) goto L7;
        b();
    L7:
        Bitmap r100 = this.f534727e;
        if (r100 != null) goto L11;
        return 32;
    L11:
        this.f534731i = UIHelper.px2dp(r100.getWidth());
    L13:
        return this.f534731i;
    }

    public a(String r100, String r101, String r102, String r103, int r104, Boolean r105) {
        this.f534728f = new CopyOnWriteArrayList();
        this.f534731i = -1;
        this.f534732j = -1;
        this.f534723a = r100;
        this.f534724b = r101;
        this.f534725c = r102;
        this.f534726d = r103;
        this.f534729g = r104;
        this.f534730h = r105.booleanValue();
    }

    public a(String r100, String r101, String r102, String r103, Bitmap r104, Boolean r105) {
        this.f534728f = new CopyOnWriteArrayList();
        this.f534731i = -1;
        this.f534732j = -1;
        this.f534723a = r100;
        this.f534724b = r101;
        this.f534725c = r102;
        this.f534726d = r103;
        this.f534727e = r104;
        this.f534730h = r105.booleanValue();
    }
}

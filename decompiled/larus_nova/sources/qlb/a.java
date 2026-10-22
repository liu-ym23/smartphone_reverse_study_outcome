package qlb;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f533826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f533827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f533828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f533829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f533830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f533831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f533832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f533833h;

    public a(Uri r100) {
        String r101 = r100.toString();
        if (r101.startsWith("file:///") == true) goto L5;
    L7:
        this.f533827b = null;
        this.f533826a = r100;
        this.f533828c = null;
        this.f533829d = true;
        return;
    L5:
        if (new PolarisFileWrapper(r101.substring(7)).exists() == true) goto L7;
        r100 = UriProtector.parse(URLDecoder.decode(r101, "UTF-8"));     // Catch: UnsupportedEncodingException -> L9
        goto L7
    }

    public static a a(Bitmap r100) {
        if (r100 == null) goto L6;
        return new a(r100, true);
    L6:
        throw new NullPointerException("Bitmap must not be null");
    }

    public a(int r100) {
        this.f533827b = null;
        this.f533826a = null;
        this.f533828c = Integer.valueOf(r100);
        this.f533829d = true;
    }

    public a(Bitmap r100, boolean r101) {
        this.f533827b = r100;
        this.f533826a = null;
        this.f533828c = null;
        this.f533829d = false;
        this.f533830e = r100.getWidth();
        this.f533831f = r100.getHeight();
        this.f533833h = r101;
    }
}

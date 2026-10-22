package mlb;

import android.graphics.Bitmap;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f514398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f514399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f514400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f514401d;

    public interface a {
        void a(ArrayList<QRCodeResultInfo> r100);

        void onError(String r100);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("from:");
        r100.append(this.f514398a);
        r100.append(",path:");
        r100.append(this.f514399b);
        r100.append(",bitmap is null:");
        boolean r101 = true;
        if (this.f514400c != null) goto L5;
        boolean r102 = true;
    L6:
        r100.append(r102);
        r100.append(",callback is null:");
        if (this.f514401d == null) goto L10;
        r101 = false;
    L10:
        r100.append(r101);
        return r100.toString();
    L5:
        r102 = false;
        goto L6
    }

    public d() {
        this.f514398a = "default";
    }
}

package vl2;

import android.util.SparseArray;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends vl2.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f555636j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f555637k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f555638l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f555639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f555640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f555641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f555642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f555643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f555644i;

    public static final class a {
    }

    static {
        SparseArray<c.a> r100 = c.f555645a;
        c.a r101 = null;
        if (r100 == null) goto L5;
        c.a r102 = r100.get(5);
    L6:
        String r103 = r102.f555646a;
        f555636j = r103;
        if (r100 == null) goto L9;
        r101 = r100.get(6);
    L9:
        f555637k = r101.f555646a;
        f555638l = File.separator + r103;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        super(r100, f555638l);
        this.f555639d = "";
        this.f555640e = "";
        this.f555641f = "";
        this.f555642g = "";
        this.f555643h = "";
        this.f555644i = "";
        StringBuilder r102 = new StringBuilder();
        r102.append(File.separator);
        if (r101 != 6) goto L5;
        String r103 = f555637k;
    L6:
        r102.append(r103);
        f555638l = r102.toString();
        this.f555633a = r100 + f555638l + ".zip";
        String r104 = r100 + f555638l + "/coupon";
        String r105 = r100 + f555638l + "/couponhide";
        this.f555639d = r105;
        String r106 = r100 + f555638l + "/happy";
        this.f555640e = r106;
        String r107 = r100 + f555638l + "/ttlive_bottom_front_coupon_view.png";
        this.f555641f = r107;
        String r108 = r100 + f555638l + "/ttlive_bottom_behind_coupon_view.png";
        this.f555642g = r108;
        this.f555643h = r100 + f555638l + "/ttlive_yellow_double_coupon_view.png";
        String r109 = r100 + f555638l + "/ttlive_yellow_coupon_bg.png";
        this.f555644i = r109;
        ((ArrayList) this.f555635c).add(r107);
        ((ArrayList) this.f555635c).add(r108);
        ((ArrayList) this.f555635c).add(r109);
        ((ArrayList) this.f555635c).add(r104);
        ((ArrayList) this.f555635c).add(r105);
        ((ArrayList) this.f555635c).add(r106);
        return;
    L5:
        r103 = f555636j;
        goto L6
    }
}

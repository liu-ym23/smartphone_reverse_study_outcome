package ua7;

import android.os.Bundle;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f549247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f549248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f549249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f549250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public fc7.a f549251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f549252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f549253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f549254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f549255i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f549256j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f549257k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<wqa.i> f549258l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f549259m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<Integer> f549260n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f549261o;

    public String toString() {
        return "BaseApiResponse{logId='" + this.f549247a + "', secondaryDecisionConf='" + this.f549248b + "', success=" + this.f549249c + ", mRequestUrl='" + this.f549250d + "', dataTip=" + this.f549252f + ", error=" + this.f549253g + ", mDetailErrorCode=" + this.f549254h + ", errorMsg='" + this.f549255i + "', mDetailErrorMsg='" + this.f549256j + "', url='" + this.f549257k + "', headers=" + this.f549258l + ", result=" + this.f549259m + ", api=" + this.f549261o + ", mErrorCodeTask=" + this.f549251e + '}';
    }

    public b(boolean r100, int r101) {
        this.f549249c = r100;
        this.f549261o = r101;
    }
}

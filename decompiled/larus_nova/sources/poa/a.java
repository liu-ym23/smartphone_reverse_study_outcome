package poa;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f530142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f530143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f530144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f530145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f530146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f530147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f530148g;

    public final boolean a() {
        if (TextUtils.isEmpty(this.f530146e) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f530146e.equals("0") == true) goto L8;
        return false;
    }

    public final String toString() {
        return "AppInfo{appID=" + this.f530142a + ", version='" + this.f530143b + "', updateVersionCode='" + this.f530144c + "', deviceID='" + this.f530145d + "', userID='" + this.f530146e + "', channel='" + this.f530147f + "', packageName='" + this.f530148g + "'}";
    }

    public a() {
    }
}

package yw7;

import android.app.PendingIntent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f569345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f569346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f569347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PendingIntent f569348d;

    public b(int r100, int r101, String r102) {
        this.f569345a = 10002;
        this.f569346b = 8003002;
        this.f569347c = "";
        this.f569345a = r100;
        this.f569346b = r101;
        this.f569347c = r102;
    }

    public b(Bundle r100) {
        this.f569345a = 10002;
        this.f569346b = 8003002;
        this.f569347c = "";
        this.f569345a = r100.getInt("stateCode", 10002);
        this.f569346b = r100.getInt("errorCode", 8003002);
        this.f569347c = r100.getString("errorMessage");
        this.f569348d = (PendingIntent) r100.getParcelable("data");
    }
}

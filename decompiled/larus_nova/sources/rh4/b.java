package rh4;

import oh4.d;
import org.json.JSONArray;
import zg4.i;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f537779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f537780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f537781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f537782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f537783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f537784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f537785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f537786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f537787p;

    @Override // oh4.d
    public final String toString() {
        return "pollSecond=" + this.f537779h + "\nwaterLineMB=" + this.f537780i + "\ncollectSizeMB=" + this.f537781j + "\nneedDumpMemInfo=" + this.f537786o + "\ndebug=" + this.f537787p + "\nmonitorSize=" + this.f537782k + "\nmonitorType=" + this.f537783l + "\nbtFlag=" + this.f537784m + "\nbtSize=" + this.f537785n + "\n";
    }

    public b(JSONArray r100) {
        super(21, 35, 1);
        this.f537784m = 3;
        this.f537785n = 500;
        this.f537787p = false;
        if (i.b() == false) goto L5;
        this.f537783l = 0;
        this.f537780i = 30;
        this.f537781j = 300;
        this.f537779h = 1;
        this.f537786o = false;
        this.f537782k = 2;
        this.f537787p = true;
        this.f537785n = 4;
        this.f537784m = 3;
        return;
    L5:
        int r101 = r100.optInt(0);
        this.f537779h = r101;
        this.f537780i = r100.optInt(1);
        this.f537781j = r100.optInt(2);
        this.f537786o = r100.optBoolean(3);
        this.f537782k = r100.optInt(5);
        this.f537783l = r100.optInt(6);
        if (r100.length() < 9) goto L8;
        this.f537784m = r100.optInt(7);
        this.f537785n = r100.optInt(8);
    L8:
        this.f537779h = Math.max(4, r101);
    }
}

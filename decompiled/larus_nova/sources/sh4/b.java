package sh4;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import oh4.d;
import org.json.JSONArray;
import zg4.i;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f541964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f541965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f541966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f541967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f541968l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f541969m;

    @Override // oh4.d
    public final String toString() {
        return "monitorType=" + this.f541964h + "\nlimitGlobal=" + this.f541967k + "\nlimitWeak=" + this.f541968l + "\nlimitLocal=" + this.f541969m + "\nbtFlag=" + this.f541965i + "\ndebugType=" + this.f541966j + "\n";
    }

    public b(int r100, JSONArray r101, int r102) {
        super(23, 33, 5);
        this.f541964h = 0;
        this.f541965i = 0;
        this.f541966j = 0;
        this.f541967k = 50000;
        this.f541968l = 50000;
        this.f541969m = 500;
        if (i.b() == false) goto L5;
        this.f541964h = 7;
        this.f541965i = 3;
        this.f541967k = 1000;
        this.f541968l = 1000;
        this.f541969m = TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG;
        this.f541966j = 4;
        return;
    L5:
        this.f541964h = r100;
        this.f541965i = r102;
        int r103 = r101.length();
        if (r103 < 2) goto L10;
        this.f541967k = r101.optInt(0);
        this.f541968l = r101.optInt(1);
        if (r103 != 3) goto L10;
        this.f541969m = r101.optInt(2);
    L10:
        this.f541967k = Math.max(1000, this.f541967k);
        this.f541968l = Math.max(1000, this.f541968l);
        this.f541969m = Math.max(500, this.f541969m);
    }
}

package cs0;

import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IQuality f465160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f465161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f465162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f465163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f465164h;

    public c(String r100, String r101, String r102, IQuality r103) {
        this.f465161e = "unknown";
        this.f465162f = false;
        this.f465163g = "";
        this.f465164h = true;
        this.f465157a = r100;
        this.f465158b = r101;
        this.f465159c = r102;
        this.f465160d = r103;
    }

    public c(String r100, String r101, String r102, LiveCoreSDKData.Quality r103, String r104) {
        this.f465161e = "unknown";
        this.f465162f = false;
        this.f465163g = "";
        this.f465164h = true;
        this.f465157a = r100;
        this.f465158b = r101;
        this.f465159c = r102;
        this.f465160d = r103;
        this.f465161e = r104;
    }
}

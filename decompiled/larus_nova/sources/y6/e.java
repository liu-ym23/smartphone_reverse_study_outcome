package y6;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f566288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f566289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f566290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f566291d;

    public e() {
        this.f566288a = "";
        this.f566289b = "";
        this.f566290c = "";
        this.f566291d = "";
    }

    public e(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r102, "image");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f566288a = r100;
        this.f566290c = r101;
        this.f566291d = r102;
        this.f566289b = r103;
    }
}

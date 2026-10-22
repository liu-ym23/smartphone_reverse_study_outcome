package nl;

import com.bytedance.android.ec.model.PromotionBenefitLabel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f519526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f519527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f519528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<PromotionBenefitLabel> f519529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f519530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f519531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f519532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f519533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Float f519534k;

    public f(String r100, String r101, int r102, String[] r103, Long r104, List r105, String r106, String r110, String r111, Boolean r112, Float r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r114 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r114 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r114 & 32) == 0) goto L15;
        r105 = null;
    L15:
        if ((r114 & 64) == 0) goto L18;
        r106 = null;
    L18:
        if ((r114 & 128) == 0) goto L21;
        r110 = null;
    L21:
        if ((r114 & 256) == 0) goto L24;
        r111 = null;
    L24:
        if ((r114 & 512) == 0) goto L27;
        r112 = Boolean.FALSE;
    L27:
        if ((r114 & 1024) == 0) goto L29;
        r113 = null;
    L29:
        Intrinsics.checkNotNullParameter(r101, "promotionId");
        this.f519524a = r100;
        this.f519525b = r101;
        this.f519526c = r102;
        this.f519527d = r103;
        this.f519528e = r104;
        this.f519529f = r105;
        this.f519530g = r106;
        this.f519531h = r110;
        this.f519532i = r111;
        this.f519533j = r112;
        this.f519534k = r113;
    }
}

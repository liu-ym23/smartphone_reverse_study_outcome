package uc9;

import com.larus.im.bean.bot.BgImageInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f549658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f549659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f549660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f549661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f549662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f549663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f549664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f549665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f549666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f549667j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f549668k;

    public /* synthetic */ b() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public final BgImageInfo a() {
        String r100 = this.f549658a;
        String r101 = this.f549659b;
        Boolean r102 = this.f549660c;
        List<String> r103 = this.f549661d;
        if (r103 == null) goto L5;
        List r104 = CollectionsKt.toList(r103);
    L7:
        return new BgImageInfo(r100, r101, r102, r104, this.f549662e, this.f549663f, this.f549664g, this.f549665h, this.f549666i, this.f549667j, this.f549668k);
    L5:
        r104 = null;
        goto L7
    }

    public b(String r100, String r101, Boolean r102, List<String> r103, Boolean r104, String r105, String r106, String r107, String r108, Integer r110, String r111) {
        this.f549658a = r100;
        this.f549659b = r101;
        this.f549660c = r102;
        this.f549661d = r103;
        this.f549662e = r104;
        this.f549663f = r105;
        this.f549664g = r106;
        this.f549665h = r107;
        this.f549666i = r108;
        this.f549667j = r110;
        this.f549668k = r111;
    }
}

package swa;

import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f543757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f543758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f543759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f543760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EntityDomain f543761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f543762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f543763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f543764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FileBizDomain f543765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f543766k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f543767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f543768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f543769n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f543770o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Long f543771p;

    public final String toString() {
        return "pointKey = " + this.f543759d + ", entityType = " + this.f543760e + ", entityDomain = " + this.f543761f.getDomainName() + ", entityOperate = " + this.f543762g + ", operatorTenantId = " + this.f543763h + ", operatorUid = " + this.f543764i + ", fileBizDomain = " + this.f543765j.getBiz() + ", senderUserId = " + this.f543766k + ", senderTenantId = " + this.f543767l + ", msgId = " + this.f543768m + ", fileKey = " + this.f543769n + ", chatId = " + this.f543770o + ", chatType = " + this.f543771p;
    }

    public b(String r100, Integer r101, Integer r110, String r111, String r112, EntityDomain r113, String r114, long r115, long r116, FileBizDomain r117, Long r210, Long r211, String r212, String r213, String r214, Long r215) {
        Intrinsics.checkNotNullParameter(r111, "pointKey");
        Intrinsics.checkNotNullParameter(r112, "entityType");
        Intrinsics.checkNotNullParameter(r113, "entityDomain");
        Intrinsics.checkNotNullParameter(r114, "entityOperate");
        Intrinsics.checkNotNullParameter(r117, "fileBizDomain");
        this.f543756a = r100;
        this.f543757b = r101;
        this.f543758c = r110;
        this.f543759d = r111;
        this.f543760e = r112;
        this.f543761f = r113;
        this.f543762g = r114;
        this.f543763h = r115;
        this.f543764i = r116;
        this.f543765j = r117;
        this.f543766k = r210;
        this.f543767l = r211;
        this.f543768m = r212;
        this.f543769n = r213;
        this.f543770o = r214;
        this.f543771p = r215;
    }
}

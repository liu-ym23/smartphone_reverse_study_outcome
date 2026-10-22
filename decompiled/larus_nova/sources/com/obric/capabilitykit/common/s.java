package com.obric.capabilitykit.common;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ConditionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum s extends Enum<s> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f396194b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f396195c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ s[] f396196d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f396197a;

    static {
        s r100 = new s("TIME", 0, "time");
        f396194b = r100;
        s r101 = new s(HTTP.LOCATION, 1, "location");
        f396195c = r101;
        f396196d = new s[]{r100, r101};
    }

    public s(String r100, int r101, String r102) {
        super(r100, r101);
        this.f396197a = r102;
    }

    public static s valueOf(String r100) {
        return (s) a.a(s.class, r100);
    }

    public static s[] values() {
        return (s[]) f396196d.clone();
    }

    public final String b() {
        return this.f396197a;
    }
}

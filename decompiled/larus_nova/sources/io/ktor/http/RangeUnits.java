package io.ktor.http;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/ktor/http/RangeUnits;", "", "", "unitToken", "Ljava/lang/String;", "getUnitToken", "()Ljava/lang/String;", "Bytes", "None", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final enum RangeUnits extends Enum<RangeUnits> {
    public static final RangeUnits Bytes = null;
    public static final RangeUnits None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RangeUnits[] f491815a = null;
    private final String unitToken;

    public static RangeUnits valueOf(String r100) {
        return (RangeUnits) r27.a.a(RangeUnits.class, r100);
    }

    public static RangeUnits[] values() {
        return (RangeUnits[]) f491815a.clone();
    }

    static {
        RangeUnits r100 = new RangeUnits("Bytes", 0, HTTP.CONTENT_RANGE_BYTES);
        Bytes = r100;
        RangeUnits r101 = new RangeUnits("None", 1, "none");
        None = r101;
        f491815a = new RangeUnits[]{r100, r101};
    }

    public final String getUnitToken() {
        return this.unitToken;
    }

    public RangeUnits(String r100, int r101, String r102) {
        super(r100, r101);
        this.unitToken = r102;
    }
}

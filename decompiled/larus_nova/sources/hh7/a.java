package hh7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lhh7/a;", "", "", "id", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "eventType", "b", "setEventType", "Lhh7/f;", "privacyApiData", "Lhh7/f;", "d", "()Lhh7/f;", "setPrivacyApiData", "(Lhh7/f;)V", "", "clientInvokeTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setClientInvokeTime", "(J)V", "timon-monitor-impl_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("client_invoke_time")
    private long clientInvokeTime;

    @SerializedName("event_type")
    private String eventType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f485226id;

    @SerializedName("privacy_api_call_data")
    private f privacyApiData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f485226id, r101.f485226id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.eventType, r101.eventType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.privacyApiData, r101.privacyApiData) == true) goto L12;
        return false;
    L12:
        if (this.clientInvokeTime == r101.clientInvokeTime) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f485226id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.eventType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        f r107 = this.privacyApiData;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.clientInvokeTime;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ActionData(id=" + this.f485226id + ", eventType=" + this.eventType + ", privacyApiData=" + this.privacyApiData + ", clientInvokeTime=" + this.clientInvokeTime + ")";
    }

    public final long a() {
        return this.clientInvokeTime;
    }

    public final String b() {
        return this.eventType;
    }

    public final String c() {
        return this.f485226id;
    }

    public final f d() {
        return this.privacyApiData;
    }

    public a(String r100, f r101, long r102) {
        this.f485226id = r100;
        this.eventType = "privacy_api_call";
        this.privacyApiData = r101;
        this.clientInvokeTime = r102;
    }
}

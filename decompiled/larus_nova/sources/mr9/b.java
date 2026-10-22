package mr9;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.common.spi.security.ObricSecurityServiceDelegate;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006&"}, d2 = {"Lcom/larus/platform/model/upload/ImageAuth;", "", "accessKey", "", "secretKey", "sessionToken", "expiredTime", "currentTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getSecretKey", "getSessionToken", "getExpiredTime", "getCurrentTime", "expiredTimestamp", "", "getExpiredTimestamp", "()J", "setExpiredTimestamp", "(J)V", "currentTimeStamp", "getCurrentTimeStamp", "setCurrentTimeStamp", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f514986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f514987b = null;

    @SerializedName("access_key_id")
    private final String accessKey;

    @SerializedName("current_time")
    private final String currentTime;

    @SerializedName("expired_time")
    private final String expiredTime;

    @SerializedName("secret_access_key")
    private final String secretKey;

    @SerializedName("session_token")
    private final String sessionToken;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.accessKey, r101.accessKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secretKey, r101.secretKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sessionToken, r101.sessionToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expiredTime, r101.expiredTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.currentTime, r101.currentTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.accessKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.secretKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sessionToken;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.expiredTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.currentTime;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    static {
        f514986a = new a();
        if (Build.VERSION.SDK_INT < 24) goto L5;
        SimpleDateFormat r100 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    L6:
        f514987b = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    public b() {
        this("", "", "", "", "");
    }

    public final long b() {
        a r100 = f514986a;
        String r101 = this.expiredTime;
        r100.getClass();
        if (Build.VERSION.SDK_INT < 24) goto L22;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        SimpleDateFormat r103 = f514987b;     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        Date r104 = r103.parse(r101);     // Catch: Throwable -> L12
        if (r104 == null) goto L9;
        long r105 = r104.getTime();     // Catch: Throwable -> L12
    L10:
        Object r106 = Result.m9449constructorimpl(Long.valueOf(r105));     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L19;
        r106 = -1L;
    L19:
        return ((Number) r106).longValue();
    L9:
        r105 = -1;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L22:
        return -1;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("ImageAuth(accessKey=");
        ObricSecurityServiceDelegate r101 = ObricSecurityServiceDelegate.f387847b;
        r100.append(r101.a(this.accessKey));
        r100.append(", secretKey=");
        r100.append(r101.a(this.secretKey));
        r100.append(", sessionToken=");
        r100.append(r101.a(this.sessionToken));
        r100.append(", expiredTime=");
        r100.append(this.expiredTime);
        r100.append(", currentTime=");
        r100.append(this.currentTime);
        r100.append(')');
        return r100.toString();
    }

    public final String a() {
        return this.accessKey;
    }

    public final String c() {
        return this.secretKey;
    }

    public final String d() {
        return this.sessionToken;
    }

    public b(String r100, String r101, String r102, String r103, String r104) {
        this.accessKey = r100;
        this.secretKey = r101;
        this.sessionToken = r102;
        this.expiredTime = r103;
        this.currentTime = r104;
    }
}

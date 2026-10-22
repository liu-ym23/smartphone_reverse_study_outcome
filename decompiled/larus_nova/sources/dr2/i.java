package dr2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public interface i extends dy0.a {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f469742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f469743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f469744c;

        public a() {
            this(0, 0, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f469742a == r101.f469742a) goto L8;
            return false;
        L8:
            if (this.f469743b == r101.f469743b) goto L10;
            return false;
        L10:
            if (this.f469744c == r101.f469744c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            return (((this.f469742a * 31) + this.f469743b) * 31) + this.f469744c;
        }

        public final String toString() {
            return "IRevLiveCertStatus(certStatus=" + this.f469742a + ", manualStatus=" + this.f469743b + ", ageRange=" + this.f469744c + ")";
        }

        public a(int r100, int r101, int r102) {
            this.f469742a = r100;
            this.f469743b = r101;
            this.f469744c = r102;
        }
    }

    public interface b {
    }

    void po(Context r100, HashMap r101, JSONObject r102, boolean r103, com.bytedance.android.live.wallet.platform.business.verify.f r104);

    void sg(String r100, Activity r101, Bundle r102, com.bytedance.android.live.wallet.platform.business.verify.q.a r103);
}

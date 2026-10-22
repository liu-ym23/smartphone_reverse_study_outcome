package uq3;

import android.graphics.Color;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f551227f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECUrlModel f551228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f551229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f551230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f551231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f551232e;

    public static final class a {
        public static i a(com.bytedance.android.window.shop.repository.dto.r r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            String r101 = r100.a();     // Catch: Exception -> L8
            if (r101 != null) goto L6;
            r101 = "#FFFFFFFF";
        L6:
            int r102 = Color.parseColor(r101);     // Catch: Exception -> L8
        L10:
            String r103 = r100.e();
            if (r103 != null) goto L13;
            r103 = "";
        L13:
            i r104 = new i(r103, r102, r100.c(), r100.d());
            r104.f551228a = r100.b();
            return r104;
        L8:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
            r102 = (int) BodyPartID.bodyIdMax;
            goto L10
        }
    }

    static {
    }

    public i(String r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f551229b = r100;
        this.f551230c = r101;
        this.f551231d = r102;
        this.f551232e = r103;
    }
}

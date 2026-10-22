package o9a;

import android.os.Bundle;
import android.widget.RemoteViews;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.assistant_card.provider_core.bean.CardAction;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f522499i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RemoteViews f522500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CardAction> f522501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f522502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f522503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f522504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f522505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f522506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f522507h;

    public static final class a {

        /* JADX INFO: renamed from: o9a.d$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/obric/aiagent/assistant_card/provider_core/bean/RemoteCard$Companion$fromBundle$remoteActions$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/obric/aiagent/assistant_card/provider_core/bean/CardAction;", "Lkotlin/collections/ArrayList;", "assistant-card-provider-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C7026a extends TypeToken<ArrayList<CardAction>> {
            public C7026a() {
            }
        }

        public static d a(Bundle r110) {
            if (r110 != null) goto L5;
            p9a.b.b("RemoteCard", "fromBundle: bundle is null");
            return null;
        L5:
            RemoteViews r100 = (RemoteViews) r110.getParcelable("remote_views");
            List r101 = (List) GsonProtectorUtils.fromJson(p9a.d.f528330a, r110.getString("remote_actions"), new C7026a().getType());
            boolean r102 = r110.getBoolean("is_night_mode");
            boolean r103 = r110.getBoolean("concern_night_Mode");
            String r104 = r110.getString("app_version_name");
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            return new d(r100, r101, r102, r103, r104, r110.getLong(Constants.EXTRA_KEY_APP_VERSION_CODE), r110.getInt("round_angle"), r110.getInt("scroll_view"));
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f522500a, r101.f522500a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522501b, r101.f522501b) == true) goto L15;
        return false;
    L15:
        if (this.f522502c == r101.f522502c) goto L18;
        return false;
    L18:
        if (this.f522503d == r101.f522503d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f522504e, r101.f522504e) == true) goto L24;
        return false;
    L24:
        if (this.f522505f == r101.f522505f) goto L27;
        return false;
    L27:
        if (this.f522506g == r101.f522506g) goto L30;
        return false;
    L30:
        if (this.f522507h == r101.f522507h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        RemoteViews r100 = this.f522500a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<CardAction> r104 = this.f522501b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.f522502c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f522503d == true) goto L18;
        r106 = 1237;
    L18:
        int r109 = (((r108 + r106) * 31) + this.f522504e.hashCode()) * 31;
        long r110 = this.f522505f;
        return ((((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.f522506g) * 31) + this.f522507h;
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RemoteCard(view=" + this.f522500a + ", actions=" + this.f522501b + ", isNightMode=" + this.f522502c + ", concernNightMode=" + this.f522503d + ", appVersionName=" + this.f522504e + ", appVersionCode=" + this.f522505f + ", roundAngle=" + this.f522506g + ", scrollViewId=" + this.f522507h + ')';
    }

    public d(RemoteViews r100, List<CardAction> r101, boolean r102, boolean r103, String r104, long r105, int r106, int r110) {
        Intrinsics.checkNotNullParameter(r104, "appVersionName");
        this.f522500a = r100;
        this.f522501b = r101;
        this.f522502c = r102;
        this.f522503d = r103;
        this.f522504e = r104;
        this.f522505f = r105;
        this.f522506g = r106;
        this.f522507h = r110;
    }
}

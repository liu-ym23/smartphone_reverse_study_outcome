package rc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeDimension;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l61.b;
import l61.d;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements g61.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DegradeScene f537073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f537074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pc2.b f537075c;

    @Override // g61.a
    public final boolean a() {
        this.f537075c.a(new e32.a(this.f537073a, DegradeSceneLevel.AudienceExpLevel.Normal, DegradeDimension.GLOBAL), MapsKt.mapOf(new Pair[]{TuplesKt.to("expBizSceneType", this.f537074b.getType().name()), TuplesKt.to("expBizSceneLevel", this.f537074b.getLevel().name())}));
        return false;
    }

    @Override // g61.a
    public final boolean b() {
        this.f537075c.a(new e32.a(this.f537073a, DegradeSceneLevel.AudienceExpLevel.Degrade, DegradeDimension.GLOBAL), MapsKt.mapOf(new Pair[]{TuplesKt.to("expBizSceneType", this.f537074b.getType().name()), TuplesKt.to("expBizSceneLevel", this.f537074b.getLevel().name())}));
        return false;
    }

    @Override // g61.a
    public final boolean c() {
        this.f537075c.a(new e32.a(this.f537073a, DegradeSceneLevel.AudienceExpLevel.Enhance, DegradeDimension.GLOBAL), MapsKt.mapOf(new Pair[]{TuplesKt.to("expBizSceneType", this.f537074b.getType().name()), TuplesKt.to("expBizSceneLevel", this.f537074b.getLevel().name())}));
        return false;
    }

    public a(DegradeScene r100, d.a r101, pc2.b r102) {
        Intrinsics.checkNotNullParameter(r100, "degradeScene");
        Intrinsics.checkNotNullParameter(r101, "expScene");
        Intrinsics.checkNotNullParameter(r102, "degradeRequester");
        this.f537073a = r100;
        this.f537074b = r101;
        this.f537075c = r102;
    }
}

package oc2;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import f32.f;
import java.lang.Enum;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a<T extends f32.f, F extends Enum<?>> implements h32.c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashSet f522677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f522678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public F f522679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.b f522680e;

    public abstract T c(F r100);

    public abstract DegradeFeature d();

    public abstract F e();

    public void g() {
        this.f522677b.clear();
    }

    public void h() {
        F r100 = (F) e();
        this.f522679d = r100;
        this.f522678c = (T) c(r100);
    }

    @Override // h32.c
    public final void a(h32.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f522677b.remove(r100) == false) goto L6;
        int r101 = g32.c.f479795a;
        DegradeFeature r102 = d();
        Intrinsics.checkNotNullParameter(r102, "feature");
        ALogger.i("InteractivityDegradeLogger", "listener removed. feature: " + r102.name());
        return;
    }

    @Override // h32.c
    public final void b(h32.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f522677b.add(r100) == false) goto L9;
        T r101 = this.f522678c;
        if (r101 == true) goto L7;
        r101 = (T) c(this.f522679d);
    L7:
        r100.a(r101);
        int r102 = g32.c.f479795a;
        DegradeFeature r103 = d();
        Intrinsics.checkNotNullParameter(r103, "feature");
        ALogger.i("InteractivityDegradeLogger", "new listener added. feature: " + r103.name());
        return;
    }

    public final void f(e32.a r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        F r100 = (F) e();
        if ((!Intrinsics.areEqual(this.f522679d, r100)) == false) goto L8;
        T r101 = (T) c(r100);
        int r102 = g32.c.f479795a;
        DegradeFeature r103 = d();
        F r104 = this.f522679d;
        String r105 = String.valueOf(this.f522678c);
        String r106 = r101.toString();
        Intrinsics.checkNotNullParameter(r103, "feature");
        Intrinsics.checkNotNullParameter(r104, "oldLevel");
        Intrinsics.checkNotNullParameter(r105, "oldConfig");
        Intrinsics.checkNotNullParameter(r100, "newLevel");
        Intrinsics.checkNotNullParameter(r106, "newConfig");
        ALogger.i("InteractivityDegradeLogger", "feature level update. feature: " + r103.name() + ", oldLevel: " + r104.name() + ", oldConfig: " + r105 + ", new level: " + r100.name() + ", new config: " + r106);
        int r107 = g32.d.f479796a;
        DegradeFeature r108 = d();
        String r109 = this.f522679d.name();
        String r111 = r100.name();
        Intrinsics.checkNotNullParameter(r110, "degradeRequest");
        Intrinsics.checkNotNullParameter(r108, "degradeFeature");
        Intrinsics.checkNotNullParameter(r109, "oldFeatureLevelName");
        Intrinsics.checkNotNullParameter(r111, "newFeatureLevelName");
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("degrade_scene", r110.f470901a.name());
        r112.put("degrade_level", r110.f470902b.logName());
        r112.put("old_feature_level", r109);
        r112.put("new_feature_level", r111);
        r112.put("degrade_feature", r108.name());
        j0.l().sendLog("livesdk_live_interactivity_degrade_feature_level_changed", r112, new Object[]{IRoom.class, x.class});
        this.f522679d = r100;
        this.f522678c = r101;
        Iterator r113 = CollectionsKt.toList(this.f522677b).iterator();
    L6:
        if (r113.hasNext() == false) goto L10;
        ((h32.d) r113.next()).a(r101);
        goto L6
    L10:
        return;
    }

    public a(F r100, com.bytedance.android.livesdk.interactivity.b r101) {
        Intrinsics.checkNotNullParameter(r100, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r101, "statusHolder");
        this.f522679d = r100;
        this.f522680e = r101;
        this.f522677b = new ConcurrentHashSet();
    }
}

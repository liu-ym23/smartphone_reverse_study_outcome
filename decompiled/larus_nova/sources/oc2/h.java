package oc2;

import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeFeature;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.FlowLikeFeatureLevel;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends oc2.a<f32.d, FlowLikeFeatureLevel> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DegradeFeature f522688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f522689g;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((b) r101).f522692c.getLevel()), Integer.valueOf(((b) r100).f522692c.getLevel()));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DegradeScene f522690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DegradeSceneLevel f522691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FlowLikeFeatureLevel f522692c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f522690a, r101.f522690a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f522691b, r101.f522691b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f522692c, r101.f522692c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            DegradeScene r100 = this.f522690a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            DegradeSceneLevel r104 = this.f522691b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            FlowLikeFeatureLevel r107 = this.f522692c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "FlowLikeDegradeProjection(degradeScene=" + this.f522690a + ", degradeSceneLevel=" + this.f522691b + ", degradeFeatureLevel=" + this.f522692c + ")";
        }

        public b(DegradeScene r100, DegradeSceneLevel r101, FlowLikeFeatureLevel r102) {
            Intrinsics.checkNotNullParameter(r100, "degradeScene");
            Intrinsics.checkNotNullParameter(r101, "degradeSceneLevel");
            Intrinsics.checkNotNullParameter(r102, "degradeFeatureLevel");
            this.f522690a = r100;
            this.f522691b = r101;
            this.f522692c = r102;
        }
    }

    @Override // oc2.a
    public final Enum e() {
        Iterator<T> r100 = this.f522689g.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        b r102 = (b) r101;
        if (Intrinsics.areEqual(this.f522680e.b(r102.f522690a), r102.f522691b) == false) goto L4;
    L9:
        b r103 = (b) r101;
        if (r103 == null) goto L14;
        FlowLikeFeatureLevel r104 = r103.f522692c;
        if (r104 == null) goto L14;
        return r104;
    L14:
        return FlowLikeFeatureLevel.LEVEL_DEFAULT;
    L8:
        r101 = null;
        goto L9
    }

    @Override // oc2.a
    public final DegradeFeature d() {
        return this.f522688f;
    }

    @Override // oc2.a
    public final f32.f c(Enum r110) {
        FlowLikeFeatureLevel r100 = (FlowLikeFeatureLevel) r110;
        Intrinsics.checkNotNullParameter(r100, "level");
        int r101 = i.f522693a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return new f32.d(false, false, 0, false, 15);
    L17:
        return new f32.d(true, false, 0, false, 14);
    L18:
        return new f32.d(false, true, 800, false, 9);
    L19:
        return new f32.d(false, false, 800, false, 11);
    L15:
        return new f32.d(false, false, 400, false, 11);
    }

    public h(FlowLikeFeatureLevel r100, com.bytedance.android.livesdk.interactivity.b r101) {
        Intrinsics.checkNotNullParameter(r100, "curFeatureLevel");
        Intrinsics.checkNotNullParameter(r101, "statusHolder");
        super(r100, r101);
        this.f522688f = DegradeFeature.FLOW_LIKE;
        DegradeScene r102 = DegradeScene.STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE;
        this.f522689g = CollectionsKt.sortedWith(CollectionsKt.mutableListOf(new b[]{new b(r102, DegradeSceneLevel.PlatformFlowLikeDegradeLevel.LEVEL_ONE, FlowLikeFeatureLevel.LEVEL_ONE), new b(r102, DegradeSceneLevel.PlatformFlowLikeDegradeLevel.LEVEL_TWO, FlowLikeFeatureLevel.LEVEL_TWO), new b(r102, DegradeSceneLevel.PlatformFlowLikeDegradeLevel.LEVEL_THREE, FlowLikeFeatureLevel.LEVEL_THREE), new b(DegradeScene.ECOM, DegradeSceneLevel.Ecom.HAPPEN, FlowLikeFeatureLevel.LEVEL_FOUR)}), new a());
    }
}

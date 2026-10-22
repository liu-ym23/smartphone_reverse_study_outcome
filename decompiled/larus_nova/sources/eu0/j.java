package eu0;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class j extends MVIState<j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f473990e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SubStatePropertyImpl f473991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SubStatePropertyImpl f473992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SubStatePropertyImpl f473993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SubStatePropertyImpl f473994d;

    static {
        f473990e = new KProperty[]{Reflection.property1(new PropertyReference1Impl(j.class, "followIconState", "getFollowIconState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(j.class, "singleEntranceState", "getSingleEntranceState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(j.class, "doubleEntranceState", "getDoubleEntranceState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(j.class, "tipState", "getTipState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public j() {
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r100 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r101 = this.propertyAddedCallback;
        SubStatePropertyImpl r102 = new SubStatePropertyImpl(l.class, null, r100, r101);
        KProperty[] r103 = f473990e;
        r102.f41672a = r103[0].getName();
        r101.invoke(r102);
        this.f473991a = r102;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r104 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r105 = this.propertyAddedCallback;
        SubStatePropertyImpl r106 = new SubStatePropertyImpl(m0.class, null, r104, r105);
        r106.f41672a = r103[1].getName();
        r105.invoke(r106);
        this.f473992b = r106;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r107 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r108 = this.propertyAddedCallback;
        SubStatePropertyImpl r109 = new SubStatePropertyImpl(f.class, null, r107, r108);
        r109.f41672a = r103[2].getName();
        r108.invoke(r109);
        this.f473993c = r109;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r110 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r111 = this.propertyAddedCallback;
        SubStatePropertyImpl r112 = new SubStatePropertyImpl(p0.class, null, r110, r111);
        r112.f41672a = r103[3].getName();
        r111.invoke(r112);
        this.f473994d = r112;
    }
}

package fl1;

import bl1.j;
import com.bytedance.android.live.core.tetris.IComponentManager;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdk.chatroom.replay.descriptor.schedule.ReplayDescriptorScheduleList;
import j70.f;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f477680h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayerDescriptorList f477681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f477682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f> f477683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f> f477684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<f> f477685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final uq1.b f477686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IComponentManager f477687g;

    /* JADX INFO: renamed from: fl1.a$a, reason: collision with other inner class name */
    public static final class C5922a {
    }

    static {
    }

    public a(uq1.b r110, IComponentManager r111) {
        Intrinsics.checkNotNullParameter(r110, "mLayerContext");
        Intrinsics.checkNotNullParameter(r111, "mLayerManager");
        this.f477686f = r110;
        this.f477687g = r111;
        uq1.a r112 = r110.f551200d;
        LayerDescriptorList r113 = new ReplayDescriptorScheduleList().f108299h;
        r113.add(new j(Boolean.TRUE));
        Unit r100 = Unit.INSTANCE;
        this.f477681a = r113;
        r112.getClass();
        f r114 = uq1.a.B;
        f r101 = uq1.a.C;
        this.f477682b = CollectionsKt.mutableListOf(new f[]{uq1.a.L, uq1.a.f551191r, uq1.a.f551185l, uq1.a.f551180g, uq1.a.f551181h, uq1.a.f551199z, r114, r101, uq1.a.f551197x});
        f r102 = uq1.a.f551192s;
        this.f477683c = CollectionsKt.mutableListOf(new f[]{r102, uq1.a.f551182i, uq1.a.f551174a});
        this.f477684d = CollectionsKt.mutableListOf(new f[]{uq1.a.f551173J, uq1.a.f551193t, r114, r101, r102, uq1.a.f551176c});
        this.f477685e = CollectionsKt.mutableListOf(new f[]{uq1.a.f551177d, uq1.a.f551186m, uq1.a.f551196w, uq1.a.f551195v});
    }
}

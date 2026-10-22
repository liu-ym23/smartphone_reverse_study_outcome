package lq2;

import com.bytedance.android.live.initialize.IWTORepeatableTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOSceneType;
import com.bytedance.android.live.initialize.WTOThreadType;
import com.bytedance.android.live.initialize.WTOThreadWorkType;
import com.bytedance.android.livesdk.revenue.perf.wto.IRevWTORepeatableTask;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements IWTORepeatableTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRevWTORepeatableTask f510289a;

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final boolean cancelable() {
        return true;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final boolean isEffective() {
        return true;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final void run() {
        this.f510289a.run();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final String taskBusinessInfo() {
        return this.f510289a.taskBusinessInfo();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final List<Integer> taskCategoryList() {
        return this.f510289a.taskCategoryList();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final com.bytedance.android.live.initialize.a taskExecutePeriod() {
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "COMPONENT_INJECT") == false) goto L7;
        return com.bytedance.android.live.initialize.a.c.f69378c;
    L7:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "LAUNCH") == false) goto L11;
        return com.bytedance.android.live.initialize.a.i.f69383c;
    L11:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "BOOT_FINISH") == false) goto L15;
        return com.bytedance.android.live.initialize.a.C1128a.f69376c;
    L15:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "ENTER_ROOM") == false) goto L19;
        return com.bytedance.android.live.initialize.a.e.f69379c;
    L19:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "PRE_ENTER_ROOM") == false) goto L23;
        return com.bytedance.android.live.initialize.a.j.f69384c;
    L23:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "COMMON") == false) goto L27;
        return com.bytedance.android.live.initialize.a.b.f69377c;
    L27:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "FIRST_FRAME") == false) goto L31;
        return com.bytedance.android.live.initialize.a.f.f69380c;
    L31:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "FIRST_SCREEN") == false) goto L35;
        return com.bytedance.android.live.initialize.a.g.f69381c;
    L35:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "INTERACT_PREPARED") == false) goto L39;
        return com.bytedance.android.live.initialize.a.h.f69382c;
    L39:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "ROOM_CHANGE") == false) goto L43;
        return com.bytedance.android.live.initialize.a.k.f69385c;
    L43:
        if (Intrinsics.areEqual(this.f510289a.taskExecutePeriod().f514792a, "ROOM_EXIT") == false) goto L47;
        return com.bytedance.android.live.initialize.a.l.f69386c;
    L47:
        return com.bytedance.android.live.initialize.a.b.f69377c;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final int taskID() {
        return this.f510289a.taskID();
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final WTOPriorityType taskPriorityType() {
        String r100 = this.f510289a.taskPriorityType().getTag();
        WTOPriorityType r101 = WTOPriorityType.NOW;
        if (Intrinsics.areEqual(r100, r101.getTag()) == false) goto L5;
        return r101;
    L5:
        String r102 = this.f510289a.taskPriorityType().getTag();
        WTOPriorityType r103 = WTOPriorityType.SCHEDULE;
        if (Intrinsics.areEqual(r102, r103.getTag()) == false) goto L8;
        return r103;
    L8:
        String r104 = this.f510289a.taskPriorityType().getTag();
        WTOPriorityType r105 = WTOPriorityType.PARSE;
        if (Intrinsics.areEqual(r104, r105.getTag()) == false) goto L11;
        return r105;
    L11:
        String r106 = this.f510289a.taskPriorityType().getTag();
        WTOPriorityType r107 = WTOPriorityType.BACKGROUND;
        if (Intrinsics.areEqual(r106, r107.getTag()) == false) goto L14;
        return r107;
    L14:
        return r103;
    }

    @Override // com.bytedance.android.live.initialize.IWTORepeatableTask
    public final WTOSceneType taskSceneType() {
        String r100 = this.f510289a.taskSceneType().getTag();
        WTOSceneType r101 = WTOSceneType.CURRENT;
        if (Intrinsics.areEqual(r100, r101.getTag()) == false) goto L5;
        return r101;
    L5:
        String r102 = this.f510289a.taskSceneType().getTag();
        WTOSceneType r103 = WTOSceneType.PRELOAD;
        if (Intrinsics.areEqual(r102, r103.getTag()) == false) goto L8;
        return r103;
    L8:
        String r104 = this.f510289a.taskSceneType().getTag();
        WTOSceneType r105 = WTOSceneType.COMMON;
        Intrinsics.areEqual(r104, r105.getTag());
        return r105;
    }

    @Override // com.bytedance.android.live.initialize.IWTOTask
    public final WTOThreadType taskThreadType() {
        String r100 = this.f510289a.taskThreadType().getTag();
        WTOThreadType r101 = WTOThreadType.UIThread;
        if (Intrinsics.areEqual(r100, r101.getTag()) == false) goto L5;
        return r101;
    L5:
        String r102 = this.f510289a.taskThreadType().getTag();
        WTOThreadType r103 = WTOThreadType.PeriodThread;
        if (Intrinsics.areEqual(r102, r103.getTag()) == false) goto L8;
        return r103;
    L8:
        String r104 = this.f510289a.taskThreadType().getTag();
        WTOThreadType r105 = WTOThreadType.WorkerThread;
        Intrinsics.areEqual(r104, r105.getTag());
        return r105;
    }

    @Override // com.bytedance.android.live.initialize.IWTORepeatableTask
    public final WTOThreadWorkType taskThreadWorkType() {
        String r100 = this.f510289a.taskThreadWorkType().getTag();
        WTOThreadWorkType r101 = WTOThreadWorkType.CPU_FIXED;
        if (Intrinsics.areEqual(r100, r101.getTag()) == false) goto L5;
        return r101;
    L5:
        String r102 = this.f510289a.taskThreadWorkType().getTag();
        WTOThreadWorkType r103 = WTOThreadWorkType.IO;
        if (Intrinsics.areEqual(r102, r103.getTag()) == false) goto L8;
        return r103;
    L8:
        String r104 = this.f510289a.taskThreadWorkType().getTag();
        WTOThreadWorkType r105 = WTOThreadWorkType.TIME_CLOCK;
        if (Intrinsics.areEqual(r104, r105.getTag()) == false) goto L11;
        return r105;
    L11:
        return r101;
    }

    public d(yz1.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f510289a = r100;
    }
}

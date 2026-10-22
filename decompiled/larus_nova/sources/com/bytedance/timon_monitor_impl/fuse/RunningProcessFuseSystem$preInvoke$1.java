package com.bytedance.timon_monitor_impl.fuse;

import android.app.ActivityManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.timon_monitor_impl.pipeline.ValidateSystem;
import com.bytedance.timonbase.report.TMDataCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class RunningProcessFuseSystem$preInvoke$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $id;
    final /* synthetic */ List $processes;
    final /* synthetic */ Throwable $throwable;

    public RunningProcessFuseSystem$preInvoke$1(int r100, Throwable r101, List r102) {
        this.$id = r100;
        this.$throwable = r101;
        this.$processes = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        r100.put("api_id", String.valueOf(this.$id));
        r100.put("issue_type", "leakage_error");
        r100.put("stack_trace", this.$throwable.getStackTrace());
        if ((!this.$processes.isEmpty()) == false) goto L5;
        int r102 = ValidateSystem.f270758a;
        r100.put("replaceProcess", ValidateSystem.a.a((ActivityManager.RunningAppProcessInfo) ListProtector.get(this.$processes, 0)));
    L5:
        TMDataCollector.h("timon_major_issue", r100, null, r101, 48);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

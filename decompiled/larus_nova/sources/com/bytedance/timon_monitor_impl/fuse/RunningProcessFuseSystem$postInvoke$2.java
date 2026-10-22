package com.bytedance.timon_monitor_impl.fuse;

import android.app.Application;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.report.TMDataCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class RunningProcessFuseSystem$postInvoke$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $id;
    final /* synthetic */ Throwable $throwable;

    public RunningProcessFuseSystem$postInvoke$2(int r100, Throwable r101) {
        this.$id = r100;
        this.$throwable = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        r100.put("api_id", String.valueOf(this.$id));
        r100.put("issue_type", "importance 隐私弹窗前使用");
        r100.put("stack_trace", this.$throwable.getStackTrace());
        Application r102 = TMEnv.f270769c;
        if (r102 == null) goto L5;
        r100.put("is_main", com.bytedance.timonbase.utils.a.c(r102));
    L5:
        TMDataCollector.h("timon_major_issue", r100, null, r101, 48);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

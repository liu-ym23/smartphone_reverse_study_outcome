package com.bytedance.timonbase;

import android.app.Application;
import com.bytedance.timonbase.utils.EnumUtils$Priority;
import com.bytedance.timonbase.utils.EnumUtils$WorkType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timonbase/TimonLifecycleServiceDowngradeImp;", "Lcom/bytedance/timonbase/ITMLifecycleService;", "<init>", "()V", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class TimonLifecycleServiceDowngradeImp implements ITMLifecycleService {
    public TimonLifecycleServiceDowngradeImp() {
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public final void b() {
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public final String c() {
        return "";
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public final void d(int r100, String r101, Function0<String> r102, Application r103, a r104) {
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public final void e() {
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public final void onConfigUpdate() {
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public final boolean enable() {
        return ITMLifecycleService.a.a(this);
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public final EnumUtils$WorkType a() {
        return EnumUtils$WorkType.BACKGROUND;
    }

    @Override // com.bytedance.timonbase.ITMLifecycleService
    public final EnumUtils$Priority priority() {
        return EnumUtils$Priority.MIDDLE;
    }
}

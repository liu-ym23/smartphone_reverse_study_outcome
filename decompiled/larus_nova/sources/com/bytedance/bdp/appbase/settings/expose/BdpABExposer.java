package com.bytedance.bdp.appbase.settings.expose;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpABExposer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f201018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f201019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f201020c;

    public BdpABExposer(String r100) {
        this.f201020c = r100;
        this.f201018a = "BdpABExposer_" + r100;
        this.f201019b = LazyKt.lazy(BdpABExposer$mainSettingsProvider$2.INSTANCE);
    }

    public final void a(String r100, JSONObject r101) {
        if (r101 == null) goto L4;
        final Long r102 = Long.valueOf(r101.optLong(r100));
    L5:
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.longValue() == 0) goto L12;
        BdpPool.execute(BdpTask.TaskType.IO, new BdpABExposer$markExposeIfNeed$1(this, r102));
        return;
    L12:
        return;
    L4:
        r102 = null;
        goto L5
    }
}

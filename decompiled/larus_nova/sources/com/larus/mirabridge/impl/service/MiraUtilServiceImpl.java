package com.larus.mirabridge.impl.service;

import android.content.Context;
import com.bytedance.mira.util.ResUtil;
import com.larus.mirabridge.api.plugin.service.IMiraUtilService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/larus/mirabridge/impl/service/MiraUtilServiceImpl;", "Lcom/larus/mirabridge/api/plugin/service/IMiraUtilService;", "<init>", "()V", "getResourceAssetPaths", "", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiraUtilServiceImpl implements IMiraUtilService {
    public MiraUtilServiceImpl() {
    }

    @Override // com.larus.mirabridge.api.plugin.service.IMiraUtilService
    public final List<String> a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ResUtil.getAssetPaths(r100.getAssets());
    }
}

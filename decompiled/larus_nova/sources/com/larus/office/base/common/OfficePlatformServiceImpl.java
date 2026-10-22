package com.larus.office.base.common;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.larus.platform.service.IOfficePlatformService;
import com.ss.android.lark.utils.statistics.PerfLog;
import jr9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0001J/\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0018\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/office/base/common/OfficePlatformServiceImpl;", "Lcom/larus/platform/service/IOfficePlatformService;", "<init>", "()V", "buildFeishuLink", "", "docType", "Lcom/larus/platform/service/IOfficePlatformService$FeishuDocType;", "token", "handleCopyFeishuLink", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "feishuLink", "sharePanelDialog", "Landroidx/fragment/app/DialogFragment;", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "isSupportedDriveFileType", "driveFileType", "", "(Ljava/lang/Integer;)Z", "toFeishuDocType", "(Ljava/lang/Integer;)Lcom/larus/platform/service/IOfficePlatformService$FeishuDocType;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePlatformServiceImpl implements IOfficePlatformService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficePlatformHelper f360482a;

    @Override // com.larus.platform.service.IOfficePlatformService
    public final String a(IOfficePlatformService.FeishuDocType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "docType");
        Intrinsics.checkNotNullParameter(r101, "token");
        return this.f360482a.a(r100, r101);
    }

    @Override // com.larus.platform.service.IOfficePlatformService
    public final void b(Context r100, String r101, DialogFragment r102, a r103) {
        Intrinsics.checkNotNullParameter(r103, "shareItemConfig");
        this.f360482a.b(r100, r101, r102, r103);
    }

    @Override // com.larus.platform.service.IOfficePlatformService
    public final boolean c(Integer r100) {
        return this.f360482a.c(r100);
    }

    @Override // com.larus.platform.service.IOfficePlatformService
    public final IOfficePlatformService.FeishuDocType d(Integer r100) {
        return this.f360482a.d(r100);
    }

    public OfficePlatformServiceImpl() {
        this.f360482a = OfficePlatformHelper.f360480a;
    }
}

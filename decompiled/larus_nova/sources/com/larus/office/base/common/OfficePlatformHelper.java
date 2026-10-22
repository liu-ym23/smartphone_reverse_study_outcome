package com.larus.office.base.common;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.bytedance.crash.d;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.platform.service.IOfficePlatformService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import jr9.a;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0017\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/office/base/common/OfficePlatformHelper;", "Lcom/larus/platform/service/IOfficePlatformService;", "<init>", "()V", "TAG", "", "SUPPORTED_DRIVE_FILE_TYPES", "", "", "buildFeishuLink", "docType", "Lcom/larus/platform/service/IOfficePlatformService$FeishuDocType;", "token", "isSupportedDriveFileType", "", "driveFileType", "(Ljava/lang/Integer;)Z", "toFeishuDocType", "(Ljava/lang/Integer;)Lcom/larus/platform/service/IOfficePlatformService$FeishuDocType;", "handleCopyFeishuLink", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "feishuLink", "sharePanelDialog", "Landroidx/fragment/app/DialogFragment;", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "reportShareResult", "", "success", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePlatformHelper implements IOfficePlatformService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficePlatformHelper f360480a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f360481b = null;

    private OfficePlatformHelper() {
    }

    static {
        f360480a = new OfficePlatformHelper();
        f360481b = SetsKt.setOf(new Integer[]{22, 30, 3});
    }

    @Override // com.larus.platform.service.IOfficePlatformService
    public final boolean c(Integer r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (f360481b.contains(r100) == false) goto L6;
        return true;
    }

    @Override // com.larus.platform.service.IOfficePlatformService
    public final IOfficePlatformService.FeishuDocType d(Integer r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.intValue() != 22) goto L9;
        return IOfficePlatformService.FeishuDocType.DOCX;
    L9:
        if (r100.intValue() != 30) goto L12;
        return IOfficePlatformService.FeishuDocType.SLIDES;
    L12:
        if (r100.intValue() == 3) goto L14;
        return null;
    L14:
        return IOfficePlatformService.FeishuDocType.SHEET;
    }

    @Override // com.larus.platform.service.IOfficePlatformService
    public final String a(IOfficePlatformService.FeishuDocType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "docType");
        Intrinsics.checkNotNullParameter(r101, "token");
        return "https://www.feishu.cn/" + r100.getPath() + '/' + r101;
    }

    @Override // com.larus.platform.service.IOfficePlatformService
    public final void b(Context r100, String r101, DialogFragment r102, a r110) {
        Intrinsics.checkNotNullParameter(r110, "shareItemConfig");
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("handleCopyFeishuLink feishuLink=");
        if (r101 == null) goto L5;
        String r105 = StringsKt.take(r101, 50);
    L6:
        r104.append(r105);
        r103.i("CopyFeishuLinkHelper", r104.toString());
        if (r101 != null) goto L9;
    L12:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L24;
        r103.e("CopyFeishuLinkHelper", "handleCopyFeishuLink 飞书链接为空");
        ShareServiceDelegate.f313831b.d(r110.b(), r110.c(), null, "0");
        if (r102 == null) goto L38;
        r102.dismissAllowingStateLoss();     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r107 = DialogFragmentLancet.sLastShowStack;
        if (r107 == null) goto L39;
        d.d(r107, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L39:
        return;
    L38:
        return;
    L24:
        ShareServiceDelegate r108 = ShareServiceDelegate.f313831b;
        r108.o(r100, r101);
        r108.d(r110.b(), r110.c(), null, "1");
        if (r102 != null) goto L34;
    L32:
        r103.i("CopyFeishuLinkHelper", "handleCopyFeishuLink 完成");
        return;
    L34:
        r102.dismissAllowingStateLoss();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r109 = DialogFragmentLancet.sLastShowStack;
        if (r109 == null) goto L32;
        d.d(r109, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L32
    L9:
        if (r101.length() == 0) goto L12;
        r106 = false;
        goto L14
    L5:
        r105 = null;
        goto L6
    }
}

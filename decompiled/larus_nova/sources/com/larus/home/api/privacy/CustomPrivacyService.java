package com.larus.home.api.privacy;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import ib9.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/larus/home/api/privacy/CustomPrivacyService;", "Lcom/larus/home/api/privacy/ICustomPrivacyService;", "<init>", "()V", "TAG", "", "impl", "getImpl", "()Lcom/larus/home/api/privacy/ICustomPrivacyService;", "impl$delegate", "Lkotlin/Lazy;", "getCustomPrivacyDialog", "Landroidx/fragment/app/DialogFragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "agree", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "disagree", "Lcom/larus/common_ui/dialog/CancelClickListener;", "getCustomPrivacyActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomPrivacyService implements ICustomPrivacyService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CustomPrivacyService f344098b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f344099c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f344100d = null;

    private CustomPrivacyService() {
    }

    @Override // com.larus.home.api.privacy.ICustomPrivacyService
    public final Class<? extends Activity> b() {
        ICustomPrivacyService r100 = (ICustomPrivacyService) f344100d.getValue();     // Catch: Exception -> L7
        if (r100 == null) goto L9;
        return r100.b();
    L9:
        return null;
    L7:
        e = move-exception;
        FLogger.f375446a.e(f344099c, "getCustomPrivacyActivityClass error", e);
        return null;
    }

    static {
        f344098b = new CustomPrivacyService();
        f344099c = "CustomPrivacyService";
        f344100d = LazyKt.lazy(new a());
    }

    @Override // com.larus.home.api.privacy.ICustomPrivacyService
    public final DialogFragment d(Context r100, p0 r101, u r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "agree");
        Intrinsics.checkNotNullParameter(r102, "disagree");
        ICustomPrivacyService r103 = (ICustomPrivacyService) f344100d.getValue();     // Catch: Exception -> L7
        if (r103 == null) goto L9;
        return r103.d(r100, r101, r102);
    L9:
        return null;
    L7:
        e = move-exception;
        FLogger.f375446a.e(f344099c, "getCustomPrivacyDialog error", e);
        return null;
    }
}

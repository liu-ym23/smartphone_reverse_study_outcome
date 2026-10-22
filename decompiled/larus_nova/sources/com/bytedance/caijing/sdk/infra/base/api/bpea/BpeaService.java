package com.bytedance.caijing.sdk.infra.base.api.bpea;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u00019J5\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0005H&J$\u0010\u0015\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001a\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001a\u0010\u001e\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0007\u001a\u00020\u0005H&J*\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0005H&J\"\u0010'\u001a\u0004\u0018\u00010\u00052\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050%2\u0006\u0010\u0007\u001a\u00020\u0005H&J6\u0010,\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0%H&J\u001a\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0005H&J\u001a\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0005H&J\u001a\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0005H&J\u001a\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0005H&J\u001a\u00106\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001a\u00107\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001a\u00108\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006:"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/bpea/BpeaService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/app/Activity;", "activity", "", "", ComplianceResult.JsonKey.PERMISSIONS, "token", "Lcom/bytedance/caijing/sdk/infra/base/api/bpea/BpeaService$a;", "callback", "", "requestEzPermission", "(Landroid/app/Activity;[Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/caijing/sdk/infra/base/api/bpea/BpeaService$a;)V", "Landroid/content/ClipboardManager;", "clip", "Landroid/content/ClipData;", "clipData", "setPrimaryClip", "getPrimaryClip", "", "text", "setClipboardText", "Landroid/hardware/Camera;", "openCamera", "", ShortVideoSegments.KEY_CAMERA_ID, "camera", "releaseCamera", "Landroid/telephony/TelephonyManager;", "telephonyManager", BpeaManager.getNetworkType, "Landroid/content/pm/PackageManager;", "pm", "packageName", "flags", "Landroid/content/pm/PackageInfo;", "getPackageInfo", "Lkotlin/Function0;", "pay", "alipay", "", "", "ext", AbsMethodDelegate.TAG_INVOKE, "wrapStartActivityByBpea", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "bpeaToken", "getSimLabelIfAvailable", "getNetworkOperatorIfAvailable", "getIpAddressIfAvailable", "getAndroidIdIfAvailable", "Landroid/media/AudioRecord;", "audioRecord", "startRecording", "stopRecording", "releaseRecord", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface BpeaService extends ICJService {

    /* JADX INFO: loaded from: classes15.dex */
    public interface a {
        void onEzPermissionResult(boolean r100, List<String> r101, List<String> r102);

        void onRequestPermissions();
    }

    String alipay(Function0<String> r100, String r101);

    String getAndroidIdIfAvailable(Context r100, String r101) throws Exception;

    String getIpAddressIfAvailable(Context r100, String r101) throws Exception;

    String getNetworkOperatorIfAvailable(Context r100, String r101) throws Exception;

    int getNetworkType(TelephonyManager r100, String r101);

    PackageInfo getPackageInfo(PackageManager r100, String r101, int r102, String r103);

    ClipData getPrimaryClip(ClipboardManager r100, String r101);

    String getSimLabelIfAvailable(Context r100, String r101) throws Exception;

    Camera openCamera(int r100, String r101) throws Exception;

    Camera openCamera(String r100) throws Exception;

    void releaseCamera(Camera r100, String r101);

    void releaseRecord(AudioRecord r100, String r101);

    void requestEzPermission(Activity r100, String[] r101, String r102, a r103);

    void setClipboardText(ClipboardManager r100, CharSequence r101, String r102);

    void setPrimaryClip(ClipboardManager r100, ClipData r101, String r102);

    void startRecording(AudioRecord r100, String r101);

    void stopRecording(AudioRecord r100, String r101);

    void wrapStartActivityByBpea(String r100, Map<String, ? extends Object> r101, Function0<Unit> r102);
}

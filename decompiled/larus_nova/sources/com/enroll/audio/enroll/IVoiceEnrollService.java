package com.enroll.audio.enroll;

import com.larus.dora.impl.util.p0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\bg\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000b0\nH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0017\u001a\u00020\u0003H&J&\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH&J\b\u0010\u001c\u001a\u00020\u0003H&¨\u0006\u001e"}, d2 = {"Lcom/enroll/audio/enroll/IVoiceEnrollService;", "", "clearVoicePrint", "", "getDefaultVoicePrintEnrollStatus", "", "getDeviceEnrollStatus", "sn", "", "getEnrolledDevices", "", "Lkotlin/Pair;", "updateEnrolledDeviceName", "newName", "deleteEnrolledDevice", "callback", "Lkotlin/Function1;", "addEnrolledDevice", "deviceName", "isBtHeadsetVoicePrintRecorded", "getSpeechFingerprintResult", "", "query", "queryBtHeadsetVoicePrintCloudAndResetLocalStatus", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "preloadVoicePrintResourcesIfNeeded", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IVoiceEnrollService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f273709a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f273710a = null;

        static {
            f273710a = new a();
        }

        public a() {
        }

        public static IVoiceEnrollService a() {
            return (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class, false, false);
        }
    }

    static {
        f273709a = a.f273710a;
    }

    boolean a(String r100);

    void b(String r100, String r101, String r102);

    boolean f();

    void g(String r100, String r101);

    byte[] h(String r100);

    void i();

    void j(String r100, p0 r101);

    boolean query(String r100);
}

package com.larus.im.internal.audio.session.omni;

import com.larus.im.internal.jni.bean.OMNIAVLocalEventType;

/* JADX INFO: loaded from: classes29.dex */
public final class p {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347352a = null;

        static {
            int[] r100 = new int[OMNIAVLocalEventType.values().length];
            r100[OMNIAVLocalEventType.selfScreenShareStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r100[OMNIAVLocalEventType.selfScreenShareEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r100[OMNIAVLocalEventType.selfVideoCaptureStopped.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[OMNIAVLocalEventType.videoFirstFrameCaptured.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r100[OMNIAVLocalEventType.deviceError.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r100[OMNIAVLocalEventType.networkQualityChange.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r100[OMNIAVLocalEventType.networkChange.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r100[OMNIAVLocalEventType.roomIdFetched.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[OMNIAVLocalEventType.multiPathWork.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r100[OMNIAVLocalEventType.disconnectedRetringToast.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r100[OMNIAVLocalEventType.retrySuccessToast.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r100[OMNIAVLocalEventType.uplinkAudioVolume.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r100[OMNIAVLocalEventType.downlinkAudioVolume.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r100[OMNIAVLocalEventType.rtcLocalUserJoined.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r100[OMNIAVLocalEventType.rtcRemoteUserJoined.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r100[OMNIAVLocalEventType.unknown.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            f347352a = r100;
        }
    }

    static {
    }

    public p() {
    }
}

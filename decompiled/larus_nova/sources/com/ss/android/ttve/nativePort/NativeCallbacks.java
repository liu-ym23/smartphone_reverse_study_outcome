package com.ss.android.ttve.nativePort;

import com.ss.android.ttve.model.VEFrame;
import com.ss.android.vesdk.model.BefTextLayout;
import com.ss.android.vesdk.model.BefTextLayoutResult;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class NativeCallbacks {

    public interface AudioManagerCallback {
        boolean onIntercept();

        String onResult(String r100, String r101);
    }

    public interface IAudioCaptureCallback {
        void onReceive(ByteBuffer r100);
    }

    public interface ICameraFrameCallback {
        void onResult(int r100, float[] r101, int r102, int r103, int r104, long r105);

        void onResult(ByteBuffer r100, int r101, int r102, long r103);
    }

    public interface IFrameEffectCallback {
        void onResult(long r100);
    }

    public interface IGetFrameCallback {

        /* JADX INFO: renamed from: com.ss.android.ttve.nativePort.NativeCallbacks$IGetFrameCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onResult(IGetFrameCallback r100, VEFrame r101, boolean r102) {
            }
        }

        void onResult(VEFrame r100, boolean r101);

        void onResult(int[] r100, int r101, int r102, long r103, boolean r104);
    }

    public interface ILensCallback {
        void onError(int r100, int r101, String r102);

        void onInfo(int r100, int r101, int r102, String r103);

        void onSuccess(int r100, float r101, int r102);
    }

    public interface OnARTextBitmapCallback {
        BefTextLayoutResult onResult(String r100, BefTextLayout r101);
    }

    public interface OnARTextContentCallback {
        void onResult(String[] r100);
    }

    public interface VEDistortionInfoCallback {
        void onResult(String r100, String r101);
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
        int a(byte[] r100, int r101, int r102, int r103, float r104);
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
    }

    public interface i {
        void a(int r100);

        void b(int r100, double r101);

        void c(int r100);

        void d(int r100);

        void e(double r100);
    }

    public NativeCallbacks() {
    }
}

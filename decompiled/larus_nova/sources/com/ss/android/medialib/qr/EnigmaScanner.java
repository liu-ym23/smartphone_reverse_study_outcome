package com.ss.android.medialib.qr;

import android.content.Context;
import android.view.SurfaceHolder;
import com.bef.effectsdk.message.MessageCenter;
import com.ss.android.ugc.aweme.discover.model.BackgroundConfig;

/* JADX INFO: loaded from: classes38.dex */
public class EnigmaScanner implements MessageCenter.Listener {
    private a listener;

    public static final enum ScanMode extends Enum<ScanMode> {
        public static final ScanMode CAMERA = null;
        public static final ScanMode PICTURE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScanMode[] f449117a = null;

        static {
            ScanMode r100 = new ScanMode("CAMERA", 0);
            CAMERA = r100;
            ScanMode r101 = new ScanMode(BackgroundConfig.BackgroundType.TYPE_PICTURE, 1);
            PICTURE = r101;
            f449117a = new ScanMode[]{r100, r101};
        }

        public static ScanMode[] values() {
            return (ScanMode[]) f449117a.clone();
        }

        public static ScanMode valueOf(String r100) {
            return (ScanMode) r27.a.a(ScanMode.class, r100);
        }

        public ScanMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    private synchronized void onResult() {
        monitor-enter(this);
        monitor-exit(this);
    }

    private void setScanMode() {
    }

    public void enableCameraScan(boolean r100) {
    }

    public void enableCameraScanWithRequirement(boolean r100, long r101) {
    }

    @Override // com.bef.effectsdk.message.MessageCenter.Listener
    public void onMessageReceived(int r100, int r101, int r102, String r103) {
    }

    public void setListener(a r100) {
    }

    public void startScan(Context r100, Object r101, SurfaceHolder r102, ScanSettings r103) {
    }

    public void startScan(String r100, ScanSettings r101, long r102) {
    }

    public void stop() {
    }

    public synchronized void stopCameraScan() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public synchronized void stopPicScan() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public EnigmaScanner() {
    }

    public ScanMode getScanMode() {
        return ScanMode.CAMERA;
    }

    public void release() {
        MessageCenter.removeListener(this);
    }
}

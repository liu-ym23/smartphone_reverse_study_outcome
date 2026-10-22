package com.ss.android.lark.camera_export;

import com.ss.android.ttvecamera.TECameraUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraResolution;", "", "width", "", "height", "<init>", "(II)V", "getWidth", "()I", "getHeight", "toString", "", "Companion", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraResolution {
    private static final CameraResolution CR1080P = null;
    private static final CameraResolution CR1080P_PAD = null;
    private static final CameraResolution CR720P = null;
    private static final CameraResolution CR720P_PAD = null;
    public static final Companion Companion = null;
    private final int height;
    private final int width;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraResolution$Companion;", "", "<init>", "()V", "CR720P", "Lcom/ss/android/lark/camera_export/CameraResolution;", "getCR720P", "()Lcom/ss/android/lark/camera_export/CameraResolution;", "CR1080P", "getCR1080P", "CR1080P_PAD", "getCR1080P_PAD", "CR720P_PAD", "getCR720P_PAD", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CameraResolution getCR1080P() {
            return CameraResolution.access$getCR1080P$cp();
        }

        public final CameraResolution getCR1080P_PAD() {
            return CameraResolution.access$getCR1080P_PAD$cp();
        }

        public final CameraResolution getCR720P() {
            return CameraResolution.access$getCR720P$cp();
        }

        public final CameraResolution getCR720P_PAD() {
            return CameraResolution.access$getCR720P_PAD$cp();
        }
    }

    static {
        Companion = new Companion(null);
        CR720P = new CameraResolution(720, 1280);
        CR1080P = new CameraResolution(1080, TECameraUtils.CAPTURE_NORMAL);
        CR1080P_PAD = new CameraResolution(1080, 1440);
        CR720P_PAD = new CameraResolution(720, 960);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.width);
        r100.append('*');
        r100.append(this.height);
        return r100.toString();
    }

    public static final /* synthetic */ CameraResolution access$getCR1080P$cp() {
        return CR1080P;
    }

    public static final /* synthetic */ CameraResolution access$getCR1080P_PAD$cp() {
        return CR1080P_PAD;
    }

    public static final /* synthetic */ CameraResolution access$getCR720P$cp() {
        return CR720P;
    }

    public static final /* synthetic */ CameraResolution access$getCR720P_PAD$cp() {
        return CR720P_PAD;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public CameraResolution(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }
}

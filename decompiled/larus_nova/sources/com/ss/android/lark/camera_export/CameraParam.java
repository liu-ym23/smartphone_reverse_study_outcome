package com.ss.android.lark.camera_export;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0003,-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010+\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraParam;", "Ljava/io/Serializable;", "<init>", "()V", "from", "", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "type", "getType", "setType", "mode", "getMode", "setMode", "isNewVeCamera", "", "()Z", "setNewVeCamera", "(Z)V", "isFrontCamera", "setFrontCamera", "isSaveGallery", "setSaveGallery", "useHDShoot", "getUseHDShoot", "setUseHDShoot", "use1080P", "getUse1080P", "setUse1080P", "maxDuration", "", "getMaxDuration", "()I", "setMaxDuration", "(I)V", "interceptCallback", "Lcom/ss/android/lark/camera_export/CameraParam$IInterceptCallback;", "getInterceptCallback", "()Lcom/ss/android/lark/camera_export/CameraParam$IInterceptCallback;", "setInterceptCallback", "(Lcom/ss/android/lark/camera_export/CameraParam$IInterceptCallback;)V", "toString", "Companion", "Builder", "IInterceptCallback", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraParam implements Serializable {
    public static final Companion Companion = null;
    public static final String MODE_ONLY_PHOTO = "only_photo";
    public static final String MODE_ONLY_VIDEO = "only_video";
    public static final String MODE_PHOTO_VIDEO_BOTH = "photo_video_both";
    public static final String TYPE_CK_CAMERA = "ck";
    public static final String TYPE_SYSTEM_CAMERA = "system";
    public static final String TYPE_VE_CAMERA = "ve";
    private String from;
    private transient IInterceptCallback interceptCallback;
    private boolean isFrontCamera;
    private boolean isNewVeCamera;
    private boolean isSaveGallery;
    private int maxDuration;
    private String mode;
    private String type;
    private boolean use1080P;
    private boolean useHDShoot;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraParam$Builder;", "", "<init>", "()V", "param", "Lcom/ss/android/lark/camera_export/CameraParam;", "setFrom", "from", "", "setType", "type", "setMode", "mode", "isNewVeCamera", "", "isFrontCamera", "isSaveGallery", "useHDShoot", "use1080P", "setMaxDuration", "maxDuration", "", "setInterceptCallback", "callback", "Lcom/ss/android/lark/camera_export/CameraParam$IInterceptCallback;", "build", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private final CameraParam param;

        public Builder() {
            this.param = new CameraParam();
        }

        public final CameraParam build() {
            return this.param;
        }

        public final Builder isFrontCamera(boolean r100) {
            this.param.setFrontCamera(r100);
            return this;
        }

        public final Builder isNewVeCamera(boolean r100) {
            this.param.setNewVeCamera(r100);
            return this;
        }

        public final Builder isSaveGallery(boolean r100) {
            this.param.setSaveGallery(r100);
            return this;
        }

        public final Builder setFrom(String r100) {
            Intrinsics.checkNotNullParameter(r100, "from");
            this.param.setFrom(r100);
            return this;
        }

        public final Builder setInterceptCallback(IInterceptCallback r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.param.setInterceptCallback(r100);
            return this;
        }

        public final Builder setMaxDuration(int r100) {
            this.param.setMaxDuration(r100);
            return this;
        }

        public final Builder setMode(String r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.param.setMode(r100);
            return this;
        }

        public final Builder setType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.param.setType(r100);
            return this;
        }

        public final Builder use1080P(boolean r100) {
            this.param.setUse1080P(r100);
            return this;
        }

        public final Builder useHDShoot(boolean r100) {
            this.param.setUseHDShoot(r100);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraParam$Companion;", "", "<init>", "()V", "TYPE_VE_CAMERA", "", "TYPE_CK_CAMERA", "TYPE_SYSTEM_CAMERA", "MODE_ONLY_PHOTO", "MODE_ONLY_VIDEO", "MODE_PHOTO_VIDEO_BOTH", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraParam$IInterceptCallback;", "", "onIntercept", "", "msg", "", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IInterceptCallback {
        void onIntercept(String r100);
    }

    static {
        Companion = new Companion(null);
    }

    public String toString() {
        return "from:" + this.from + ",type:" + this.type + ",mode:" + this.mode + ",isNewVeCamera:" + this.isNewVeCamera + ",isFrontCamera:" + this.isFrontCamera + ",isSaveGallery:" + this.isSaveGallery + ",useHDShoot:" + this.useHDShoot + ",use1080P:" + this.use1080P + ",maxDuration:" + this.maxDuration;
    }

    public CameraParam() {
        this.from = "default";
        this.type = TYPE_CK_CAMERA;
        this.mode = MODE_ONLY_PHOTO;
        this.maxDuration = CameraSettings.getCameraVideoMaxDuration();
    }

    public final String getFrom() {
        return this.from;
    }

    public final IInterceptCallback getInterceptCallback() {
        return this.interceptCallback;
    }

    public final int getMaxDuration() {
        return this.maxDuration;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getUse1080P() {
        return this.use1080P;
    }

    public final boolean getUseHDShoot() {
        return this.useHDShoot;
    }

    public final boolean isFrontCamera() {
        return this.isFrontCamera;
    }

    public final boolean isNewVeCamera() {
        return this.isNewVeCamera;
    }

    public final boolean isSaveGallery() {
        return this.isSaveGallery;
    }

    public final void setFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.from = r100;
    }

    public final void setFrontCamera(boolean r100) {
        this.isFrontCamera = r100;
    }

    public final void setInterceptCallback(IInterceptCallback r100) {
        this.interceptCallback = r100;
    }

    public final void setMaxDuration(int r100) {
        this.maxDuration = r100;
    }

    public final void setMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mode = r100;
    }

    public final void setNewVeCamera(boolean r100) {
        this.isNewVeCamera = r100;
    }

    public final void setSaveGallery(boolean r100) {
        this.isSaveGallery = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public final void setUse1080P(boolean r100) {
        this.use1080P = r100;
    }

    public final void setUseHDShoot(boolean r100) {
        this.useHDShoot = r100;
    }
}

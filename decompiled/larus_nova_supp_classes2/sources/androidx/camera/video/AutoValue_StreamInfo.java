package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_StreamInfo extends StreamInfo {
    private final int id;
    private final SurfaceRequest.TransformationInfo inProgressTransformationInfo;
    private final StreamInfo.StreamState streamState;

    public int hashCode() {
        int r0 = (((this.id ^ 1000003) * 1000003) ^ this.streamState.hashCode()) * 1000003;
        SurfaceRequest.TransformationInfo r1 = this.inProgressTransformationInfo;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 ^ r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "StreamInfo{id=" + this.id + ", streamState=" + this.streamState + ", inProgressTransformationInfo=" + this.inProgressTransformationInfo + "}";
    }

    @Override // androidx.camera.video.StreamInfo
    public int getId() {
        return this.id;
    }

    @Override // androidx.camera.video.StreamInfo
    public SurfaceRequest.TransformationInfo getInProgressTransformationInfo() {
        return this.inProgressTransformationInfo;
    }

    @Override // androidx.camera.video.StreamInfo
    public StreamInfo.StreamState getStreamState() {
        return this.streamState;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StreamInfo) == false) goto L21;
        StreamInfo r6 = (StreamInfo) r5;
        if (this.id == r6.getId()) goto L10;
    L19:
        return false;
    L10:
        if (this.streamState.equals(r6.getStreamState()) == false) goto L19;
        SurfaceRequest.TransformationInfo r1 = this.inProgressTransformationInfo;
        if (r1 != null) goto L17;
        if (r6.getInProgressTransformationInfo() != null) goto L19;
        return true;
    L17:
        if (r1.equals(r6.getInProgressTransformationInfo()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    public AutoValue_StreamInfo(int r1, StreamInfo.StreamState r2, SurfaceRequest.TransformationInfo r3) {
        this.id = r1;
        if (r2 == null) goto L7;
        this.streamState = r2;
        this.inProgressTransformationInfo = r3;
        return;
    L7:
        throw new NullPointerException("Null streamState");
    }
}

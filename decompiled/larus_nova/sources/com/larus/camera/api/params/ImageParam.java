package com.larus.camera.api.params;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020\u0000H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/larus/camera/api/params/ImageParam;", "Lcom/larus/camera/api/params/BaseResultParam;", "<init>", "()V", "isPhotoMarked", "", "()Z", "setPhotoMarked", "(Z)V", "isPhotoCropped", "setPhotoCropped", "isAiCreation", "setAiCreation", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "markedMaskBitmap", "getMarkedMaskBitmap", "setMarkedMaskBitmap", "rotation", "", "getRotation", "()I", "setRotation", "(I)V", "detectIntent", "getDetectIntent", "setDetectIntent", "bitmapChangedTime", "", "getBitmapChangedTime", "()J", "setBitmapChangedTime", "(J)V", "clone", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageParam extends BaseResultParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Bitmap f321461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Bitmap f321462b;
    private long bitmapChangedTime;
    private int detectIntent;
    private boolean isAiCreation;
    private boolean isPhotoCropped;
    private boolean isPhotoMarked;
    private int rotation;

    @Override // com.larus.camera.api.params.BaseResultParam
    public ImageParam clone() {
        ImageParam r100 = new ImageParam();
        r100.setCreatedTime(getCreatedTime());
        r100.setPath(getPath());
        r100.isPhotoMarked = this.isPhotoMarked;
        r100.isPhotoCropped = this.isPhotoCropped;
        r100.isAiCreation = this.isAiCreation;
        r100.setWidth(getWidth());
        r100.setHeight(getHeight());
        r100.setSize(getSize());
        r100.f321461a = this.f321461a;
        r100.f321462b = this.f321462b;
        r100.rotation = this.rotation;
        r100.detectIntent = this.detectIntent;
        r100.bitmapChangedTime = this.bitmapChangedTime;
        return r100;
    }

    public String toString() {
        return "[createTime=" + getCreatedTime() + ", path=" + getPath() + ", width=" + getWidth() + ",height=" + getHeight() + ",size=" + getSize() + " bitmapChangedTime=" + this.bitmapChangedTime + ']';
    }

    public ImageParam() {
        this.bitmapChangedTime = getCreatedTime();
    }

    public final Bitmap getBitmap() {
        return this.f321461a;
    }

    public final long getBitmapChangedTime() {
        return this.bitmapChangedTime;
    }

    public final int getDetectIntent() {
        return this.detectIntent;
    }

    public final Bitmap getMarkedMaskBitmap() {
        return this.f321462b;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final boolean isAiCreation() {
        return this.isAiCreation;
    }

    public final boolean isPhotoCropped() {
        return this.isPhotoCropped;
    }

    public final boolean isPhotoMarked() {
        return this.isPhotoMarked;
    }

    @Override // com.larus.camera.api.params.BaseResultParam
    public /* bridge */ /* synthetic */ BaseResultParam clone() {
        return clone();
    }

    public final void setAiCreation(boolean r100) {
        this.isAiCreation = r100;
    }

    public final void setBitmap(Bitmap r100) {
        this.f321461a = r100;
    }

    public final void setBitmapChangedTime(long r100) {
        this.bitmapChangedTime = r100;
    }

    public final void setDetectIntent(int r100) {
        this.detectIntent = r100;
    }

    public final void setMarkedMaskBitmap(Bitmap r100) {
        this.f321462b = r100;
    }

    public final void setPhotoCropped(boolean r100) {
        this.isPhotoCropped = r100;
    }

    public final void setPhotoMarked(boolean r100) {
        this.isPhotoMarked = r100;
    }

    public final void setRotation(int r100) {
        this.rotation = r100;
    }
}

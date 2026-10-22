package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public class GifAnimationMetaData implements Serializable, Parcelable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = null;
    private static final long serialVersionUID = 5692363926580237325L;
    private final int mDuration;
    private final int mHeight;
    private final int mImageCount;
    private final int mLoopCount;
    private final long mMetadataBytesCount;
    private final long mPixelsBytesCount;
    private final int mWidth;

    public class a implements Parcelable.Creator<GifAnimationMetaData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GifAnimationMetaData createFromParcel(Parcel r100) {
            return new GifAnimationMetaData(r100, null);
        }

        @Override // android.os.Parcelable.Creator
        public final GifAnimationMetaData[] newArray(int r100) {
            return new GifAnimationMetaData[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public boolean isAnimated() {
        if (this.mImageCount > 1) goto L5;
    L7:
        return false;
    L5:
        if (this.mDuration <= 0) goto L7;
        return true;
    }

    public String toString() {
        int r100 = this.mLoopCount;
        if (r100 != 0) goto L5;
        String r101 = "Infinity";
    L6:
        String r102 = String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mImageCount), r101, Integer.valueOf(this.mDuration)});
        if (isAnimated() == true) goto L9;
        return r102;
    L9:
        return "Animated " + r102;
    L5:
        r101 = Integer.toString(r100);
        goto L6
    }

    public long getAllocationByteCount() {
        return this.mPixelsBytesCount;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public long getMetadataAllocationByteCount() {
        return this.mMetadataBytesCount;
    }

    public int getNumberOfFrames() {
        return this.mImageCount;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public GifAnimationMetaData(GifInfoHandle r100) {
        this.mLoopCount = r100.h();
        this.mDuration = r100.f();
        this.mWidth = r100.m();
        this.mHeight = r100.g();
        this.mImageCount = r100.k();
        this.mMetadataBytesCount = r100.i();
        this.mPixelsBytesCount = r100.b();
        r100.s();
    }

    public GifAnimationMetaData(AssetFileDescriptor r100) throws IOException {
        this(new GifInfoHandle(r100));
    }

    public GifAnimationMetaData(FileDescriptor r100) throws IOException {
        this(new GifInfoHandle(r100));
    }

    public GifAnimationMetaData(InputStream r100) throws IOException {
        this(new GifInfoHandle(r100));
    }

    public GifAnimationMetaData(String r100) throws IOException {
        this(new GifInfoHandle(r100));
    }

    public GifAnimationMetaData(ByteBuffer r100) throws IOException {
        this(new GifInfoHandle(r100));
    }

    public GifAnimationMetaData(byte[] r100) throws IOException {
        this(new GifInfoHandle(r100));
    }

    public GifAnimationMetaData(File r100) throws IOException {
        this(r100.getPath());
    }

    public GifAnimationMetaData(Parcel r100, a r101) {
        this.mLoopCount = r100.readInt();
        this.mDuration = r100.readInt();
        this.mHeight = r100.readInt();
        this.mWidth = r100.readInt();
        this.mImageCount = r100.readInt();
        this.mMetadataBytesCount = r100.readLong();
        this.mPixelsBytesCount = r100.readLong();
    }

    public long getDrawableAllocationByteCount(d r100, int r101) {
        if (r101 < 1) goto L15;
        if (r101 > 65535) goto L15;
        int r102 = r101 * r101;
        if (r100 != null) goto L9;
    L11:
        int r103 = ((this.mWidth * this.mHeight) * 4) / r102;
    L13:
        return (this.mPixelsBytesCount / ((long) r102)) + r103;
    L9:
        if (r100.f529713f.isRecycled() == true) goto L11;
        r103 = r100.f529713f.getAllocationByteCount();
    L15:
        throw new IllegalStateException("Sample size " + r101 + " out of range <1, \uffff>");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mLoopCount);
        r100.writeInt(this.mDuration);
        r100.writeInt(this.mHeight);
        r100.writeInt(this.mWidth);
        r100.writeInt(this.mImageCount);
        r100.writeLong(this.mMetadataBytesCount);
        r100.writeLong(this.mPixelsBytesCount);
    }

    public GifAnimationMetaData(ContentResolver r100, Uri r101) throws IOException {
        this(GifInfoHandle.q(r100, r101));
    }

    public GifAnimationMetaData(AssetManager r100, String r101) throws IOException {
        this(r100.openFd(r101));
    }

    public GifAnimationMetaData(Resources r100, int r101) throws Resources.NotFoundException, IOException {
        this(r100.openRawResourceFd(r101));
    }
}

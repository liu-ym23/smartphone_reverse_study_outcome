package androidx.camera.video;

import android.location.Location;
import android.os.ParcelFileDescriptor;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class FileDescriptorOutputOptions extends OutputOptions {
    private final FileDescriptorOutputOptionsInternal mFileDescriptorOutputOptionsInternal;

    public static final class Builder extends OutputOptions.Builder<FileDescriptorOutputOptions, Builder> {
        private final FileDescriptorOutputOptionsInternal.Builder mInternalBuilder;

        @Override // androidx.camera.video.OutputOptions.Builder
        public FileDescriptorOutputOptions build() {
            return new FileDescriptorOutputOptions(this.mInternalBuilder.build());
        }

        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ OutputOptions build() {
            return build();
        }

        public Builder(ParcelFileDescriptor r2) {
            super(new AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(r2, "File descriptor can't be null.");
            FileDescriptorOutputOptionsInternal.Builder r0 = (FileDescriptorOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = r0;
            r0.setParcelFileDescriptor(r2);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setDurationLimitMillis(long r1) {
            return super.setDurationLimitMillis(r1);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setFileSizeLimit(long r1) {
            return super.setFileSizeLimit(r1);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileDescriptorOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        public /* bridge */ /* synthetic */ Builder setLocation(Location r1) {
            return super.setLocation(r1);
        }
    }

    public static abstract class FileDescriptorOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {

        public static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public abstract FileDescriptorOutputOptionsInternal build();

            public abstract Builder setParcelFileDescriptor(ParcelFileDescriptor r1);

            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
                return build();
            }

            public Builder() {
            }
        }

        public abstract ParcelFileDescriptor getParcelFileDescriptor();

        public FileDescriptorOutputOptionsInternal() {
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mFileDescriptorOutputOptionsInternal.getParcelFileDescriptor();
    }

    public int hashCode() {
        return this.mFileDescriptorOutputOptionsInternal.hashCode();
    }

    public String toString() {
        return this.mFileDescriptorOutputOptionsInternal.toString().replaceFirst("FileDescriptorOutputOptionsInternal", "FileDescriptorOutputOptions");
    }

    public FileDescriptorOutputOptions(FileDescriptorOutputOptionsInternal r1) {
        super(r1);
        this.mFileDescriptorOutputOptionsInternal = r1;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof FileDescriptorOutputOptions) == true) goto L10;
        return false;
    L10:
        return this.mFileDescriptorOutputOptionsInternal.equals(((FileDescriptorOutputOptions) r2).mFileDescriptorOutputOptionsInternal);
    }
}

package androidx.camera.video;

import android.location.Location;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_FileOutputOptions_FileOutputOptionsInternal extends FileOutputOptions.FileOutputOptionsInternal {
    private final long durationLimitMillis;
    private final File file;
    private final long fileSizeLimit;
    private final Location location;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_FileOutputOptions_FileOutputOptionsInternal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends FileOutputOptions.FileOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private File file;
        private Long fileSizeLimit;
        private Location location;

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal build() {
            if (this.fileSizeLimit != null) goto L5;
            String r0 = " fileSizeLimit";
        L7:
            if (this.durationLimitMillis != null) goto L10;
            r0 = r0 + " durationLimitMillis";
        L10:
            if (this.file != null) goto L13;
            r0 = r0 + " file";
        L13:
            if (r0.isEmpty() == false) goto L17;
            return new AutoValue_FileOutputOptions_FileOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.file, null);
        L17:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
            return build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setDurationLimitMillis(long r1) {
            this.durationLimitMillis = Long.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setFile(File r2) {
            if (r2 == null) goto L6;
            this.file = r2;
            return this;
        L6:
            throw new NullPointerException("Null file");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setFileSizeLimit(long r1) {
            this.fileSizeLimit = Long.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileOutputOptions.FileOutputOptionsInternal.Builder setLocation(Location r1) {
            return setLocation(r1);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileOutputOptions.FileOutputOptionsInternal.Builder setDurationLimitMillis(long r1) {
            return setDurationLimitMillis(r1);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileOutputOptions.FileOutputOptionsInternal.Builder setFileSizeLimit(long r1) {
            return setFileSizeLimit(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setLocation(Location r1) {
            this.location = r1;
            return this;
        }
    }

    public int hashCode() {
        long r0 = this.fileSizeLimit;
        int r1 = (((int) (r0 ^ (r0 >>> 32))) ^ 1000003) * 1000003;
        long r3 = this.durationLimitMillis;
        int r2 = (r1 ^ ((int) ((r3 >>> 32) ^ r3))) * 1000003;
        Location r4 = this.location;
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = this.file.hashCode();
        return r6 ^ ((r2 ^ r5) * 1000003);
    L5:
        r5 = r4.hashCode();
        goto L6
    }

    public String toString() {
        return "FileOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", file=" + this.file + "}";
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal
    public File getFile() {
        return this.file;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getFileSizeLimit() {
        return this.fileSizeLimit;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public Location getLocation() {
        return this.location;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof FileOutputOptions.FileOutputOptionsInternal) == false) goto L23;
        FileOutputOptions.FileOutputOptionsInternal r9 = (FileOutputOptions.FileOutputOptionsInternal) r8;
        if (this.fileSizeLimit == r9.getFileSizeLimit()) goto L10;
    L21:
        return false;
    L10:
        if (this.durationLimitMillis != r9.getDurationLimitMillis()) goto L21;
        Location r1 = this.location;
        if (r1 != null) goto L17;
        if (r9.getLocation() != null) goto L21;
    L19:
        if (this.file.equals(r9.getFile()) == false) goto L21;
        return true;
    L17:
        if (r1.equals(r9.getLocation()) == false) goto L21;
    L23:
        return false;
    }

    private AutoValue_FileOutputOptions_FileOutputOptionsInternal(long r1, long r3, Location r5, File r6) {
        this.fileSizeLimit = r1;
        this.durationLimitMillis = r3;
        this.location = r5;
        this.file = r6;
    }

    public /* synthetic */ AutoValue_FileOutputOptions_FileOutputOptionsInternal(long r1, long r3, Location r5, File r6, AnonymousClass1 r7) {
        this(r1, r3, r5, r6);
    }
}

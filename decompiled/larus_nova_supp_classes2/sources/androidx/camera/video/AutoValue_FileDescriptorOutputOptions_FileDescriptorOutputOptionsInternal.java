package androidx.camera.video;

import android.location.Location;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal {
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;
    private final ParcelFileDescriptor parcelFileDescriptor;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;
        private ParcelFileDescriptor parcelFileDescriptor;

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal build() {
            if (this.fileSizeLimit != null) goto L5;
            String r0 = " fileSizeLimit";
        L7:
            if (this.durationLimitMillis != null) goto L10;
            r0 = r0 + " durationLimitMillis";
        L10:
            if (this.parcelFileDescriptor != null) goto L13;
            r0 = r0 + " parcelFileDescriptor";
        L13:
            if (r0.isEmpty() == false) goto L17;
            return new AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.parcelFileDescriptor, null);
        L17:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ OutputOptions.OutputOptionsInternal build() {
            return build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setDurationLimitMillis(long r1) {
            this.durationLimitMillis = Long.valueOf(r1);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setFileSizeLimit(long r1) {
            this.fileSizeLimit = Long.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setLocation(Location r1) {
            return setLocation(r1);
        }

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setParcelFileDescriptor(ParcelFileDescriptor r2) {
            if (r2 == null) goto L6;
            this.parcelFileDescriptor = r2;
            return this;
        L6:
            throw new NullPointerException("Null parcelFileDescriptor");
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setDurationLimitMillis(long r1) {
            return setDurationLimitMillis(r1);
        }

        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public /* bridge */ /* synthetic */ FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setFileSizeLimit(long r1) {
            return setFileSizeLimit(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setLocation(Location r1) {
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
        int r6 = this.parcelFileDescriptor.hashCode();
        return r6 ^ ((r2 ^ r5) * 1000003);
    L5:
        r5 = r4.hashCode();
        goto L6
    }

    public String toString() {
        return "FileDescriptorOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", parcelFileDescriptor=" + this.parcelFileDescriptor + "}";
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public long getFileSizeLimit() {
        return this.fileSizeLimit;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public Location getLocation() {
        return this.location;
    }

    @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.parcelFileDescriptor;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) == false) goto L23;
        FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal r9 = (FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) r8;
        if (this.fileSizeLimit == r9.getFileSizeLimit()) goto L10;
    L21:
        return false;
    L10:
        if (this.durationLimitMillis != r9.getDurationLimitMillis()) goto L21;
        Location r1 = this.location;
        if (r1 != null) goto L17;
        if (r9.getLocation() != null) goto L21;
    L19:
        if (this.parcelFileDescriptor.equals(r9.getParcelFileDescriptor()) == false) goto L21;
        return true;
    L17:
        if (r1.equals(r9.getLocation()) == false) goto L21;
    L23:
        return false;
    }

    private AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(long r1, long r3, Location r5, ParcelFileDescriptor r6) {
        this.fileSizeLimit = r1;
        this.durationLimitMillis = r3;
        this.location = r5;
        this.parcelFileDescriptor = r6;
    }

    public /* synthetic */ AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(long r1, long r3, Location r5, ParcelFileDescriptor r6, AnonymousClass1 r7) {
        this(r1, r3, r5, r6);
    }
}

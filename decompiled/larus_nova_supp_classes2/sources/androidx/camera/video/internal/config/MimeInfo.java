package androidx.camera.video.internal.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class MimeInfo {

    public static abstract class Builder<B> {
        public Builder() {
        }

        public abstract MimeInfo build();

        public abstract B setMimeType(String r1);

        public abstract B setProfile(int r1);
    }

    public MimeInfo() {
    }

    public abstract String getMimeType();

    public abstract int getProfile();
}

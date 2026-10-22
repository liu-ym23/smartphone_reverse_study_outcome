package androidx.camera.video.internal.audio;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface AudioStream {

    public interface AudioStreamCallback {

        /* JADX INFO: renamed from: androidx.camera.video.internal.audio.AudioStream$AudioStreamCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onSilenceStateChanged(AudioStreamCallback r0, boolean r1) {
            }
        }

        void onSilenceStateChanged(boolean r1);
    }

    public static class AudioStreamException extends Exception {
        public AudioStreamException() {
        }

        public AudioStreamException(String r1) {
            super(r1);
        }

        public AudioStreamException(Throwable r1) {
            super(r1);
        }

        public AudioStreamException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    public static abstract class PacketInfo {
        public PacketInfo() {
        }

        public abstract int getSizeInBytes();

        public abstract long getTimestampNs();

        public static PacketInfo of(int r1, long r2) {
            return new AutoValue_AudioStream_PacketInfo(r1, r2);
        }
    }

    PacketInfo read(ByteBuffer r1);

    void release();

    void setCallback(AudioStreamCallback r1, Executor r2);

    void start() throws AudioStreamException, IllegalStateException;

    void stop() throws IllegalStateException;
}

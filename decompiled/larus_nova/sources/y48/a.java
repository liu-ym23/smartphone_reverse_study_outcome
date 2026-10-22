package y48;

import com.larus.asr.VoiceInputType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: y48.a$a, reason: collision with other inner class name */
    public static final class C8304a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8304a f566065a = null;

        static {
            f566065a = new C8304a();
        }

        public C8304a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f566066a = null;

        static {
            f566066a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f566067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VoiceInputType f566068b;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f566067a == r101.f566067a) goto L12;
            return false;
        L12:
            if (this.f566068b == r101.f566068b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f566067a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f566068b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Submit(handsFree=" + this.f566067a + ", voiceInputType=" + this.f566068b + ')';
        }

        public c(int r100) {
            VoiceInputType r101 = VoiceInputType.TouchSpeaker;
            Intrinsics.checkNotNullParameter(r101, "voiceInputType");
            this.f566067a = false;
            this.f566068b = r101;
        }
    }

    public a() {
    }
}

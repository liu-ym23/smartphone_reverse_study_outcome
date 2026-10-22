package com.larus.audio.call.dora;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/audio/call/dora/DoraEMessageType;", "", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface DoraEMessageType {
    public static final a Companion = null;
    public static final String IMAGE = "image_only";
    public static final String VOICE = "voice_only";
    public static final String VOICE_AND_IMAGE = "voice_and_image";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f289109a = null;

        static {
            f289109a = new a();
        }

        public a() {
        }

        @DoraEMessageType
        public static String a(Integer r100) {
            if (r100 == null) goto L15;
            r100.intValue();
            if (r100.intValue() != 1) goto L8;
            return DoraEMessageType.VOICE;
        L8:
            if (r100.intValue() != 6) goto L12;
            return DoraEMessageType.IMAGE;
        L12:
            if (r100.intValue() != 20) goto L17;
            return DoraEMessageType.VOICE_AND_IMAGE;
        L17:
            return null;
        L15:
            return null;
        }
    }

    static {
        Companion = a.f289109a;
    }
}

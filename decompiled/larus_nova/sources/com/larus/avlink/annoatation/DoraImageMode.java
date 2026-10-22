package com.larus.avlink.annoatation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes23.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/annoatation/DoraImageMode;", "", "Companion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface DoraImageMode {
    public static final int ASR_INTENTION = 1;
    public static final int CONTINUOUS = 2;
    public static final int CONTINUOUS_END = 4;
    public static final a Companion = null;
    public static final int EARPHONE_PIC = 6;
    public static final int ENV_OBSERVE = 17;
    public static final int EXPLORE = 3;
    public static final int EXPLORE_END = 5;
    public static final int FAKE_SHOOT = 11;
    public static final int KWS_INTENTION = 8;
    public static final int LLM_INTENTION = 7;
    public static final int ONLY_PIC = 9;
    public static final int SILENCE_SHOOT = 10;
    public static final int TAKE_PHOTO_INTENT = 21;
    public static final int THUMB_NAIL_SHOOT = 20;
    public static final int UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f291625a = null;

        static {
            f291625a = new a();
        }

        public a() {
        }

        public static boolean a(@DoraImageMode Integer r100) {
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.intValue() != 17) goto L7;
            return true;
        }

        public static boolean b(@DoraImageMode Integer r100) {
            if (r100 == null) goto L10;
            r100.intValue();
            if (r100.intValue() == 2) goto L10;
            if (r100.intValue() == 4) goto L10;
            if (r100.intValue() == 17) goto L10;
            return true;
        L10:
            return false;
        }

        public static boolean c(@DoraImageMode Integer r100) {
            return ArraysKt.contains(new Integer[]{10, 6}, r100);
        }
    }

    static {
        Companion = a.f291625a;
    }
}

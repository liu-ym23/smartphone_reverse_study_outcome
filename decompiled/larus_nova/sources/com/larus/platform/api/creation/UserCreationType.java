package com.larus.platform.api.creation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationType;", "", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface UserCreationType {
    public static final int AVATAR = 3;
    public static final int Avatar2Video = 10;
    public static final int BEAUTIFY = 4;
    public static final a Companion = null;
    public static final int ExtendImage2Video = 9;
    public static final int ExtendText2Video = 8;
    public static final int IMAGE = 2;
    public static final int IMAGE_TO_IMAGE = 5;
    public static final int IMAGE_TO_VIDEO = 7;
    public static final int MUSIC = 1;
    public static final int RefAudio2Video = 12;
    public static final int TEXT_TO_VIDEO = 6;
    public static final int UNKNOWN = 0;
    public static final int VideoImagedMixed2Video = 11;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f365049a = null;

        static {
            f365049a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f365049a;
    }
}

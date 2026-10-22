package com.larus.media;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes30.dex */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/media/LossFocusType;", "", "Companion", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface LossFocusType {
    public static final int AUDIO_FOCUS_LOSS = -1;
    public static final int AUDIO_FOCUS_LOSS_TRANSIENT = -2;
    public static final int AUDIO_FOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
    public static final a Companion = null;
    public static final int UNKNOWN_FOCUS_CHANGE = -1234;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f358945a = null;

        static {
            f358945a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f358945a;
    }
}

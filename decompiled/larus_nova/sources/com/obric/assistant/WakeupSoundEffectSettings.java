package com.obric.assistant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes32.dex */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/assistant/WakeupSoundEffectSettings;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WakeupSoundEffectSettings {
    public static final String CLASSIC = "classic";
    public static final a Companion = null;
    public static final String DOUBAO_SAME_VOICE = "doubao_same_voice";
    public static final String SMART = "smart";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f385203a = null;

        static {
            f385203a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f385203a;
    }
}

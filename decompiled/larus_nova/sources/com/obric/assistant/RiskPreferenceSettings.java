package com.obric.assistant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes32.dex */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/assistant/RiskPreferenceSettings;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RiskPreferenceSettings {
    public static final String AUTONOMY_FIRST = "3";
    public static final String CONFIRM_FIRST = "1";
    public static final a Companion = null;
    public static final String NONE = "0";
    public static final String SMART_BALANCE = "2";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f385200a = null;

        static {
            f385200a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f385200a;
    }
}

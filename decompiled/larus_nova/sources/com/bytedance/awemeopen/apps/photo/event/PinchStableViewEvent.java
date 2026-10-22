package com.bytedance.awemeopen.apps.photo.event;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class PinchStableViewEvent {

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/event/PinchStableViewEvent$State;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface State {
        public static final a Companion = null;
        public static final String ENTER_END = "enter_end";
        public static final String ENTER_START = "enter_start";
        public static final String EXIT_END = "exit_done";
        public static final String EXIT_START = "exit_start";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f197787a = null;

            static {
                f197787a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f197787a;
        }
    }

    public PinchStableViewEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "state");
    }
}

package com.larus.im.internal.rtcsdk.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes30.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/im/internal/rtcsdk/service/RTCServiceConnectionState;", "", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RTCServiceConnectionState {
    public static final int CONNECTED = 3;
    public static final int CONNECTING = 2;
    public static final a Companion = null;
    public static final int DISCONNECTED = 1;
    public static final int FAILED = 7;
    public static final int LOST = 6;
    public static final int RECONNECTED = 5;
    public static final int RECONNECTING = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f350068a = null;

        static {
            f350068a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f350068a;
    }
}

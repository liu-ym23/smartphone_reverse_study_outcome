package com.larus.voicecall.api;

import android.content.Context;
import android.graphics.Bitmap;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes32.dex */
public interface IRtcNotificationService {

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/voicecall/api/IRtcNotificationService$RtcNotificationAction;", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RtcNotificationAction {
        public static final a Companion = null;
        public static final int HANG_UP = 3;
        public static final int MUTE = 1;
        public static final int UN_MUTE = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f377075a = null;

            static {
                f377075a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f377075a;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f377076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f377077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bitmap f377078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f377079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f377080e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f377081f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f377082g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Context f377083h;

        public a(String r100, String r101, Bitmap r102, Integer r103, boolean r104, boolean r105, boolean r106, Context r107) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "content");
            this.f377076a = r100;
            this.f377077b = r101;
            this.f377078c = r102;
            this.f377079d = r103;
            this.f377080e = r104;
            this.f377081f = r105;
            this.f377082g = r106;
            this.f377083h = r107;
        }
    }

    MutableSharedFlow a();
}

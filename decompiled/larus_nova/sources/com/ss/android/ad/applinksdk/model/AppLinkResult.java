package com.ss.android.ad.applinksdk.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLinkResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f406389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f406390b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ad/applinksdk/model/AppLinkResult$Message;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "applinksdk_release"}, k = 1, mv = {1, 4, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Message {
        public static final a Companion = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f406391a = null;

            public a() {
            }

            static {
                f406391a = new a();
            }
        }

        static {
            Companion = a.f406391a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ad/applinksdk/model/AppLinkResult$Type;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "applinksdk_release"}, k = 1, mv = {1, 4, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Type {
        public static final a Companion = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f406392a = null;

            public a() {
            }

            static {
                f406392a = new a();
            }
        }

        static {
            Companion = a.f406392a;
        }
    }

    public final boolean a() {
        int r100 = this.f406389a;
        Type.Companion.getClass();
        if (r100 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int getType() {
        return this.f406389a;
    }

    public AppLinkResult(@Type int r100, @Message int r101) {
        this.f406389a = r100;
        this.f406390b = r101;
    }
}

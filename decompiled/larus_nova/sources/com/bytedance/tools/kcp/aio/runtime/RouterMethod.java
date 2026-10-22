package com.bytedance.tools.kcp.aio.runtime;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes22.dex */
@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/tools/kcp/aio/runtime/RouterMethod;", "", "", "fallbackUrl", "()Ljava/lang/String;", "", "type", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-kmp-aio"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface RouterMethod {
    public static final int CARD = 1;
    public static final a Companion = null;
    public static final int DIALOG = 2;
    public static final int INVALID_COMPONENT = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f270925a = null;

        public a() {
        }

        static {
            f270925a = new a();
        }
    }

    static {
        Companion = a.f270925a;
    }

    String fallbackUrl();

    int type();
}

package com.ss.android.lark.active.user.api;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.impl.v2.entity.c;
import j0c.d;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.annotation.AnnotationTarget;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes34.dex */
public interface IGlobalActiveUserManager {

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/active/user/api/IGlobalActiveUserManager$PassportOnly;", "", "lark-active-user_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PassportOnly {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f408552b;

        public final String toString() {
            return "(" + this.f408551a + ')' + this.f408552b;
        }

        public a(String r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r101, "activeBackgroundUsers");
            this.f408551a = r100;
            this.f408552b = r101;
        }
    }

    @Deprecated(message = "Use UpdateActiveUserRequest", replaceWith = @ReplaceWith(expression = "UpdateActiveUserRequest", imports = {}))
    @PassportOnly
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<User> f408554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.passportc.api.d f408555c;

        public static final class a extends b {
        }

        /* JADX INFO: renamed from: com.ss.android.lark.active.user.api.IGlobalActiveUserManager$b$b, reason: collision with other inner class name */
        public static final class C4740b extends b {
        }

        public static final class c extends b {
        }

        public static final class d extends b {
        }

        public static final class e extends b {
            public e(List<? extends User> r100, com.ss.android.lark.passportc.api.d r101) {
                Intrinsics.checkNotNullParameter(r100, "validUserList");
                Intrinsics.checkNotNullParameter(r101, "executeMode");
                super(r100, r101);
            }
        }

        public b() {
            throw null;
        }

        public b(List r100, com.ss.android.lark.passportc.api.d r101) {
            this.f408553a = "UpdateBackground";
            this.f408554b = r100;
            this.f408555c = r101;
        }
    }

    @Deprecated(message = "Use updateActiveUsers2")
    @PassportOnly
    Object a(b r100, lzb.a r101, Continuation<? super Result<? extends d>> r102);

    @PassportOnly
    Object b(nua.d r100, com.ss.android.lark.passportc.api.d r101, lzb.a r102, Continuation<? super Result<? extends c>> r103);

    b1 c();
}

package com.suite.lark.component.navroute.annotations;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes40.dex */
@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0018\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/suite/lark/component/navroute/annotations/NavRouteDirection;", "", CloudControlInf.ROUTE, "", "navArgs", "Lkotlin/reflect/KClass;", "()Ljava/lang/String;", "()Ljava/lang/Class;", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface NavRouteDirection {
    Class<?> navArgs() default Void.class;

    String route() default "";
}

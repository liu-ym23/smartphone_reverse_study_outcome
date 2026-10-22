package com.suite.lark.component.navroute.annotations;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.suite.lark.component.navroute.graph.c;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Repeatable;
import kotlin.jvm.internal.RepeatableContainer;

/* JADX INFO: loaded from: classes40.dex */
@Target({ElementType.TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001BR\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\b\u0002\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003R\u001d\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\fR\u0017\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\rR\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\u000eR\u0013\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\rR\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/suite/lark/component/navroute/annotations/NavRouteDestination;", "", "toGraph", "", "Lkotlin/reflect/KClass;", "Lcom/suite/lark/component/navroute/define/NavRouteGraphDef;", "direction", "Lcom/suite/lark/component/navroute/define/NavRouteDirectionDef;", CloudControlInf.ROUTE, "", "navArgs", "deepLinks", "()[Ljava/lang/Class;", "()Ljava/lang/Class;", "()Ljava/lang/String;", "()[Ljava/lang/String;", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Repeatable
@java.lang.annotation.Repeatable(Container.class)
public @interface NavRouteDestination {

    @Target({ElementType.TYPE})
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    @RepeatableContainer
    public @interface Container {
        NavRouteDestination[] value();
    }

    String[] deepLinks() default {};

    Class<Object> direction() default Void.class;

    Class<?> navArgs() default Void.class;

    String route() default "";

    Class<Object>[] toGraph() default {c.class};
}

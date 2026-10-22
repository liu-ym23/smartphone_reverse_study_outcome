package com.bytedance.kmp.compose.ohos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes19.dex */
@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001BF\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\bR\u000f\u0010\n\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000eR\u000f\u0010\t\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\t\u0010\fR\u000f\u0010\u0006\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000eR\u000f\u0010\u0007\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\fR\u000f\u0010\u000b\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/compose/ohos/ArkTsExportComposable;", "", "id", "", "hitTestMode", "Lcom/bytedance/kmp/compose/ohos/HitTestMode;", "touchInterceptor", "withInterop", "", "needBackground", "disableRecycleNode", "withOffscreenRender", "()Z", "()Lcom/bytedance/kmp/compose/ohos/HitTestMode;", "()Ljava/lang/String;", "annotation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface ArkTsExportComposable {
    boolean disableRecycleNode() default false;

    HitTestMode hitTestMode() default HitTestMode.ARKUI_HIT_TEST_MODE_DEFAULT;

    String id() default "";

    boolean needBackground() default true;

    String touchInterceptor() default "";

    boolean withInterop() default false;

    boolean withOffscreenRender() default false;
}

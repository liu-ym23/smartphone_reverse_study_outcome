package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.callback;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ApiCallbackInfo {
    boolean failCancel() default false;

    CallbackFailScene[] failScenes() default {};

    CallbackOkScene okScene() default @CallbackOkScene(callbackParams = {}, desc = "");
}

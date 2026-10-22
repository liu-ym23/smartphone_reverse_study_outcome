package com.bytedance.tracing.tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes22.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface TagTypeInf {
    public static final String ERROR = "error";
    public static final String SPAN_KIND = "span.kind";
}

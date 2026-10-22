package com.bytedance.sdk.account.log.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes3.dex */
public interface IProfiler {

    /* JADX INFO: loaded from: classes22.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/account/log/util/IProfiler$RecordLevel;", "", "account-sdk-log_release"}, k = 1, mv = {1, 1, 15})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RecordLevel {
    }

    void a(String r100, int r101, Pair... r102);
}

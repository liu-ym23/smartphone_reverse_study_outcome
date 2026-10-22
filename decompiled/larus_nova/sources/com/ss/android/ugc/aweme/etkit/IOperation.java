package com.ss.android.ugc.aweme.etkit;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/etkit/IOperation;", "R", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public interface IOperation<R> {
    void a(String r100, R r101);

    R get(String r100);

    void put(String r100, R r101);

    JSONObject toJson();
}

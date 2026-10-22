package com.bytedance.android.shopping.sku.params.schema;

import android.net.Uri;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001f\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaListParam;", "", "Ljava/io/Serializable;", "Landroid/net/Uri;", "uri", "", "initData", "", "mutableList", "Ljava/util/List;", "", "list", "getList", "()Ljava/util/List;", "", "paramKey", "Ljava/lang/String;", "getParamKey", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SkuSchemaListParam implements Serializable {
    private final List<Object> list;

    @SerializedName("mutable_list")
    private final List<Object> mutableList;
    private final String paramKey;

    public final List<Object> getList() {
        return this.list;
    }

    public final String getParamKey() {
        return this.paramKey;
    }

    public SkuSchemaListParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "paramKey");
        this.paramKey = r2;
        List<Object> r3 = Collections.synchronizedList(new ArrayList());
        this.mutableList = r3;
        this.list = r3;
    }

    public final void initData(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        List<Object> r0 = this.mutableList;
        String r4 = UriProtector.getQueryParameter(r3, this.paramKey);
        if (r4 != null) goto L5;
    L11:
        JSONArray r5 = new JSONArray();
    L12:
        r0.addAll(CollectionsKt.toMutableList(a.a(r5)));
        return;
    L5:
        if ((!Intrinsics.areEqual(r4, "null")) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L11;
        r5 = k.t(r4);
        if (r5 != null) goto L12;
        goto L11
    }
}

package com.bytedance.platform.aio.channel.js.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@JsonAdapter(MessageAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/platform/aio/channel/js/model/e;", "Lcom/bytedance/platform/aio/channel/js/model/h;", "", "Lcom/bytedance/platform/aio/channel/js/model/g;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "operations", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "<init>", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e extends h {

    @SerializedName("operations")
    private List<? extends g> operations;

    public e() {
        this.operations = CollectionsKt.emptyList();
    }

    public final List<g> a() {
        return this.operations;
    }

    public final void b(List<? extends g> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.operations = r100;
    }
}

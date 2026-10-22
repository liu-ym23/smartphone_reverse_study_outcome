package com.bytedance.locallife.biz.perf;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/biz/perf/f;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "e", "(Z)V", "", "", "priorityUrls", "Ljava/util/List;", "c", "()Ljava/util/List;", "setPriorityUrls", "(Ljava/util/List;)V", "normalUrls", "b", "setNormalUrls", "<init>", "()V", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("normal_urls")
    private List<String> normalUrls;

    @SerializedName("priority_urls")
    private List<String> priorityUrls;

    public final void e() {
        this.enable = false;
    }

    public f() {
        this.priorityUrls = new ArrayList();
        this.normalUrls = new ArrayList();
    }

    public final boolean a() {
        return this.enable;
    }

    public final List<String> b() {
        return this.normalUrls;
    }

    public final List<String> c() {
        return this.priorityUrls;
    }

    public final void d(f r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        this.enable = r100.enable;
        if (r100.enable == false) goto L19;
        List<String> r101 = this.priorityUrls;
        if (r101 == null) goto L11;
        List<String> r102 = r100.priorityUrls;
        if (r102 != null) goto L10;
        r102 = CollectionsKt.emptyList();
    L10:
        r101.addAll(r102);
    L11:
        List<String> r103 = this.normalUrls;
        if (r103 == null) goto L20;
        List<String> r104 = r100.normalUrls;
        if (r104 != null) goto L17;
        r104 = CollectionsKt.emptyList();
    L17:
        r103.addAll(r104);
        return;
    L20:
        return;
    }
}

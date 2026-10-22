package com.bytedance.ug.sdk.luckycat.impl.popup;

import com.bytedance.forest.model.p;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/h;", "", "", "resType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setResType", "(Ljava/lang/String;)V", "", "Lcom/bytedance/ug/sdk/luckycat/impl/popup/g;", "luckyResList", "Ljava/util/List;", "getLuckyResList", "()Ljava/util/List;", "setLuckyResList", "(Ljava/util/List;)V", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ArrayList<p> f271423a;

    @SerializedName("res_list")
    private List<g> luckyResList;

    @SerializedName("res_type")
    private String resType;

    public final List<p> a() {
        List<g> r100 = this.luckyResList;
        if (r100 == null) goto L11;
        List r101 = CollectionsKt.filterNotNull(r100);
        if (r101 == null) goto L11;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        g r103 = (g) r102.next();
        this.f271423a.add(r103.a());
    L11:
        return this.f271423a;
    }

    public h() {
        this.resType = "";
        this.f271423a = new ArrayList();
    }

    public final String b() {
        return this.resType;
    }
}

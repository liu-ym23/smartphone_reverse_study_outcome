package com.bytedance.ug.sdk.luckycat.impl.popup;

import android.text.TextUtils;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.n;
import com.bytedance.forest.model.p;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R,\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/f;", "", "", "preloadType", "Ljava/lang/String;", "getPreloadType", "()Ljava/lang/String;", "setPreloadType", "(Ljava/lang/String;)V", "triggerType", "f", "setTriggerType", "", "delay", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setDelay", "(Ljava/lang/Integer;)V", "", "startTimeMs", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "setStartTimeMs", "(Ljava/lang/Long;)V", "endTimeMs", "c", "setEndTimeMs", "Lcom/bytedance/ug/sdk/luckycat/impl/popup/g;", "mainResource", "Lcom/bytedance/ug/sdk/luckycat/impl/popup/g;", "d", "()Lcom/bytedance/ug/sdk/luckycat/impl/popup/g;", "setMainResource", "(Lcom/bytedance/ug/sdk/luckycat/impl/popup/g;)V", "", "Lcom/bytedance/ug/sdk/luckycat/impl/popup/h;", "subResources", "Ljava/util/List;", "getSubResources", "()Ljava/util/List;", "setSubResources", "(Ljava/util/List;)V", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient n f271421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient HashMap<String, List<p>> f271422b;

    @SerializedName("delay")
    private Integer delay;

    @SerializedName("end_time_ms")
    private Long endTimeMs;

    @SerializedName("main_resource")
    private g mainResource;

    @SerializedName(ChameleonOpenTracker.ParamKey.PRELOAD_TYPE)
    private String preloadType;

    @SerializedName("start_time_ms")
    private Long startTimeMs;

    @SerializedName("sub_resource")
    private List<h> subResources;

    @SerializedName("trigger_type")
    private String triggerType;

    public final void a() {
        List<h> r100 = this.subResources;
        if (r100 == null) goto L19;
        List r101 = CollectionsKt.filterNotNull(r100);
        if (r101 == null) goto L19;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L19;
        h r103 = (h) r102.next();
        if (TextUtils.isEmpty(r103.b()) == true) goto L8;
        HashMap<String, List<p>> r104 = this.f271422b;
        if (r104 == null) goto L8;
        String r105 = r103.b();
        if (r105 != null) goto L17;
        r105 = "other";
    L17:
        List<p> r106 = r104.put(r105, CollectionsKt.filterNotNull(r103.a()));
    L19:
        if (TextUtils.equals("web", this.preloadType) == false) goto L21;
        PreloadType r107 = PreloadType.WEB;
    L22:
        g r108 = this.mainResource;
        if (r108 == null) goto L25;
        p r109 = r108.a();
    L26:
        this.f271421a = new n(r109, r107, this.f271422b);
        return;
    L25:
        r109 = null;
        goto L26
    L21:
        r107 = PreloadType.LYNX;
        goto L22
    }

    public f() {
        this.preloadType = "";
        this.triggerType = "";
        this.delay = 0;
        this.startTimeMs = 0L;
        this.endTimeMs = 0L;
        this.f271422b = new HashMap();
    }

    public final Integer b() {
        return this.delay;
    }

    public final Long c() {
        return this.endTimeMs;
    }

    public final g d() {
        return this.mainResource;
    }

    public final Long e() {
        return this.startTimeMs;
    }

    public final String f() {
        return this.triggerType;
    }
}

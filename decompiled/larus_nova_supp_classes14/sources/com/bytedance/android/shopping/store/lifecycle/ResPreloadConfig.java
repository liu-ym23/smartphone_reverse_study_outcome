package com.bytedance.android.shopping.store.lifecycle;

import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002R6\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0005\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/store/lifecycle/ResPreloadConfig;", "Ljava/io/Serializable;", "", "entranceLocation", "defaultTab", "", "getMatchValue", "tabType", "", "resourceMap", "Ljava/util/Map;", "getResourceMap", "()Ljava/util/Map;", "setResourceMap", "(Ljava/util/Map;)V", "entranceMap", "getEntranceMap", "setEntranceMap", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResPreloadConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("entrance_map")
    private Map<String, String> entranceMap;

    @SerializedName("resource_map")
    private Map<String, ? extends List<String>> resourceMap;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ResPreloadConfig() {
    }

    public final Map<String, String> getEntranceMap() {
        return this.entranceMap;
    }

    public final Map<String, List<String>> getResourceMap() {
        return this.resourceMap;
    }

    public final List<String> getMatchValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tabType");
        Map<String, ? extends List<String>> r0 = this.resourceMap;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    public final void setEntranceMap(Map<String, String> r1) {
        this.entranceMap = r1;
    }

    public final void setResourceMap(Map<String, ? extends List<String>> r1) {
        this.resourceMap = r1;
    }

    public final List<String> getMatchValue(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entranceLocation");
        if (com.bytedance.android.shopping.anchorv3.a.b(r4) == true) goto L17;
        Map<String, String> r5 = this.entranceMap;
        if (r5 != null) goto L8;
    L12:
        Map<String, String> r6 = this.entranceMap;
        if (r6 == null) goto L16;
        String r7 = r6.get(CommentConstants$CmtLongPanelStrategy.DEFAULT);
    L15:
        r4 = r7;
    L16:
        r4 = null;
        goto L17
    L8:
        if (r5.containsKey(r3) != true) goto L12;
        Map<String, String> r8 = this.entranceMap;
        if (r8 == null) goto L16;
        r7 = r8.get(r3);
    L17:
        Map<String, ? extends List<String>> r9 = this.resourceMap;
        if (r9 != null) goto L20;
        return null;
    L20:
        return r9.get(r4);
    }
}

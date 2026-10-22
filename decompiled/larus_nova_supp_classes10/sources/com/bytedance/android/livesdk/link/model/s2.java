package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fRB\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/s2;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/m2;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getRivals", "()Ljava/util/List;", "getRivals$annotations", "()V", "rivals", "Lcom/bytedance/android/livesdk/link/model/q2;", "getTab", "()Lcom/bytedance/android/livesdk/link/model/q2;", "getTab$annotations", "tab", "", "", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getGroupRivals", "()Ljava/util/Map;", "setGroupRivals", "(Ljava/util/Map;)V", "getGroupRivals$annotations", "groupRivals", "", "getDefaultGroup", "()I", "getDefaultGroup$annotations", "defaultGroup", "", "getSubRecommendTitle", "()Ljava/lang/String;", "getSubRecommendTitle$annotations", "subRecommendTitle", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s2 extends vh7.c<s2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "default_group")
    int getDefaultGroup();

    @FieldName(name = "group_rivals")
    Map<Long, IGroupRivals> getGroupRivals();

    @FieldName(name = "rivals")
    List<m2> getRivals();

    @FieldName(name = "sub_recommend_title")
    String getSubRecommendTitle();

    @FieldName(name = "tab")
    q2 getTab();

    @FieldName(name = "group_rivals#setter")
    void setGroupRivals(Map<Long, ? extends IGroupRivals> r1);
}

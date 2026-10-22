package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\"\u0010\u0010\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\"\u0010\u0016\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/q7;", "Lvh7/c;", "", "getTitle", "()Ljava/lang/String;", "getTitle$annotations", "()V", "title", "getDesc", "getDesc$annotations", "desc", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "getTag", "getTag$annotations", LocationMonitorConst.TAG, "getTitleIcon", "getTitleIcon$annotations", "titleIcon", "getIconSchema", "getIconSchema$annotations", "iconSchema", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q7 extends vh7.c<q7> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "desc")
    String getDesc();

    @FieldName(name = "icon_bg_image")
    py.k getIcon();

    @FieldName(name = "icon_schema_url")
    String getIconSchema();

    @FieldName(name = "desc_tag_text")
    String getTag();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "icon")
    py.k getTitleIcon();
}

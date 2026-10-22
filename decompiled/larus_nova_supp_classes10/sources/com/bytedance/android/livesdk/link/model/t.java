package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u000bR\"\u0010\u0018\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u000bR\"\u0010\u001b\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u0010R\"\u0010!\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u000bR\"\u0010$\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u000bR\u001a\u0010'\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0010R6\u0010/\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(j\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*`+8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0006\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t;", "Lvh7/c;", "", "getPanelType", "()I", "getPanelType$annotations", "()V", "panelType", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "", "getText", "()Ljava/lang/String;", "getText$annotations", "text", "getPk2LinkImage", "getPk2LinkImage$annotations", "pk2LinkImage", "getLink2PkImage", "getLink2PkImage$annotations", "link2PkImage", "getLeadPkImage", "getLeadPkImage$annotations", "leadPkImage", "getLeadPkFreqKey", "getLeadPkFreqKey$annotations", "leadPkFreqKey", "getPkIcon", "getPkIcon$annotations", "pkIcon", "getAnchorIcon", "getAnchorIcon$annotations", "anchorIcon", "getWordType", "getWordType$annotations", "wordType", "", "", "Lcom/bytedance/android/livesdk/link/model/q4;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLeadBubbleMap", "()Ljava/util/Map;", "getLeadBubbleMap$annotations", "leadBubbleMap", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t extends vh7.c<t> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "anchor_icon")
    py.k getAnchorIcon();

    @FieldName(name = "icon")
    py.k getIcon();

    @FieldName(name = "button_lead")
    Map<Long, q4> getLeadBubbleMap();

    @FieldName(name = "lead_pk_freq_key")
    String getLeadPkFreqKey();

    @FieldName(name = "lead_pk_image")
    py.k getLeadPkImage();

    @FieldName(name = "linkmic_to_pk_image")
    py.k getLink2PkImage();

    @FieldName(name = "panel_type")
    int getPanelType();

    @FieldName(name = "pk_to_linkmic_image")
    py.k getPk2LinkImage();

    @FieldName(name = "pk_icon")
    py.k getPkIcon();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "word_type")
    String getWordType();
}

package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\b\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010(R.\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\b\u001a\u0004\b+\u0010\u0006¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/link/model/j1;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/b2;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getList", "()Ljava/util/List;", "getList$annotations", "()V", "list", "", "getPkCheckState", "()I", "getPkCheckState$annotations", "pkCheckState", "", "getSelfDataSwitch", "()Z", "getSelfDataSwitch$annotations", "selfDataSwitch", "Lcom/bytedance/android/livesdk/link/model/h1;", "getAutoMatchInfo", "()Lcom/bytedance/android/livesdk/link/model/h1;", "getAutoMatchInfo$annotations", "autoMatchInfo", "Lcom/bytedance/android/livesdk/link/model/p7;", "getTabList", "setTabList", "(Ljava/util/List;)V", "getTabList$annotations", "tabList", "", "getCustomEntranceTag", "()Ljava/lang/String;", "setCustomEntranceTag", "(Ljava/lang/String;)V", "getCustomEntranceTag$annotations", "customEntranceTag", "getSelectTabType", "setSelectTabType", "(I)V", "getSelectTabType$annotations", "selectTabType", "getCannotPkAnchorIds", "getCannotPkAnchorIds$annotations", "cannotPkAnchorIds", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j1 extends vh7.c<j1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "match_info")
    h1 getAutoMatchInfo();

    @FieldName(name = "can_not_pass_anchor_open_ids")
    List<String> getCannotPkAnchorIds();

    @FieldName(name = "custom_entrance_tag")
    String getCustomEntranceTag();

    @FieldName(name = "list")
    List<b2> getList();

    @FieldName(name = "anchor_pk_check")
    int getPkCheckState();

    @FieldName(name = "select_tab_type")
    int getSelectTabType();

    @FieldName(name = "self_data_switch")
    boolean getSelfDataSwitch();

    @FieldName(name = "tab_list")
    List<p7> getTabList();

    @FieldName(name = "custom_entrance_tag#setter")
    void setCustomEntranceTag(String r1);

    @FieldName(name = "select_tab_type#setter")
    void setSelectTabType(int r1);

    @FieldName(name = "tab_list#setter")
    void setTabList(List<? extends p7> r1);
}

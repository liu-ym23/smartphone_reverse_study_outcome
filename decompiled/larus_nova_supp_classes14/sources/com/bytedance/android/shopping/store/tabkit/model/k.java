package com.bytedance.android.shopping.store.tabkit.model;

import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b^\u0010_R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R0\u0010;\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010I\u001a\u0004\bY\u0010K\"\u0004\bZ\u0010MR$\u0010[\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010I\u001a\u0004\b\\\u0010K\"\u0004\b]\u0010M¨\u0006`"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/k;", "", "", "tabID", "Ljava/lang/Integer;", "n", "()Ljava/lang/Integer;", "w", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/x;", "tabStyleConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/x;", "o", "()Lcom/bytedance/android/shopping/store/tabkit/model/x;", "setTabStyleConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/x;)V", "splitStateStyleConfig", "j", "setSplitStateStyleConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/s;", "dynamicConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/s;", "f", "()Lcom/bytedance/android/shopping/store/tabkit/model/s;", "t", "(Lcom/bytedance/android/shopping/store/tabkit/model/s;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/c;", "bizConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/c;", "a", "()Lcom/bytedance/android/shopping/store/tabkit/model/c;", "setBizConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/c;)V", "", "subTabs", "Ljava/util/List;", "m", "()Ljava/util/List;", "setSubTabs", "(Ljava/util/List;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/e;", "navBarConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/e;", "i", "()Lcom/bytedance/android/shopping/store/tabkit/model/e;", "u", "(Lcom/bytedance/android/shopping/store/tabkit/model/e;)V", "Lcom/bytedance/android/shopping/store/tabkit/model/q;", "topTabBarStyle", "Lcom/bytedance/android/shopping/store/tabkit/model/q;", "p", "()Lcom/bytedance/android/shopping/store/tabkit/model/q;", "x", "(Lcom/bytedance/android/shopping/store/tabkit/model/q;)V", "bottomTabBarStyle", "c", "s", "", "", "logExtra", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "setLogExtra", "(Ljava/util/Map;)V", "", "isUnactivated", "Ljava/lang/Boolean;", "r", "()Ljava/lang/Boolean;", "setUnactivated", "(Ljava/lang/Boolean;)V", "bizExtraInfo", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setBizExtraInfo", "(Ljava/lang/String;)V", "tabRawData", "getTabRawData", "setTabRawData", "Lcom/bytedance/android/shopping/store/tabkit/model/j;", "splitStyleConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/j;", "k", "()Lcom/bytedance/android/shopping/store/tabkit/model/j;", "v", "(Lcom/bytedance/android/shopping/store/tabkit/model/j;)V", "statusBarColor", "l", "setStatusBarColor", "customBGColor", "e", "setCustomBGColor", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class k {
    public transient k a;
    public transient Pair<Integer, Integer> b;

    @SerializedName("biz_config")
    private c bizConfig;

    @SerializedName("biz_extra_info")
    private String bizExtraInfo;

    @SerializedName("bottom_tabbar_style")
    private q bottomTabBarStyle;
    public transient Integer c;

    @SerializedName("custom_bg_color")
    private String customBGColor;
    public transient String d;

    @SerializedName("dynamic_config")
    private s dynamicConfig;
    public transient boolean e;

    @SerializedName("unactivated")
    private Boolean isUnactivated;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("navbar_config")
    private e navBarConfig;

    @SerializedName("split_state_style_config")
    private x splitStateStyleConfig;

    @SerializedName("split_style_config")
    private j splitStyleConfig;

    @SerializedName("status_bar_color")
    private String statusBarColor;

    @SerializedName("sub_tabs")
    private List<? extends k> subTabs;

    @SerializedName("tab_id")
    private Integer tabID;

    @SerializedName("tab_raw_data")
    private String tabRawData;

    @SerializedName("style_config")
    private x tabStyleConfig;

    @SerializedName("top_tabbar_style")
    private q topTabBarStyle;

    public final k d() {
        List<? extends k> r0 = this.subTabs;
        if (r0 == null) goto L9;
        Integer r1 = this.c;
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L11:
        return (k) CollectionsKt.getOrNull(r0, r2);
    L7:
        r2 = 0;
        goto L11
    L9:
        return null;
    }

    public final boolean g() {
        List<? extends k> r0 = this.subTabs;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        return !r1;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public final boolean q() {
        Integer r0 = this.tabID;
        int r1 = TabEnum.LIVE_TAB.getType();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != r1) goto L8;
        return true;
    }

    public k() {
        this.b = new Pair(0, null);
    }

    public final c a() {
        return this.bizConfig;
    }

    public final String b() {
        return this.bizExtraInfo;
    }

    public final q c() {
        return this.bottomTabBarStyle;
    }

    public final String e() {
        return this.customBGColor;
    }

    public final s f() {
        return this.dynamicConfig;
    }

    public final Map<String, String> h() {
        return this.logExtra;
    }

    public final e i() {
        return this.navBarConfig;
    }

    public final x j() {
        return this.splitStateStyleConfig;
    }

    public final j k() {
        return this.splitStyleConfig;
    }

    public final String l() {
        return this.statusBarColor;
    }

    public final List<k> m() {
        return this.subTabs;
    }

    public final Integer n() {
        return this.tabID;
    }

    public final x o() {
        return this.tabStyleConfig;
    }

    public final q p() {
        return this.topTabBarStyle;
    }

    public final Boolean r() {
        return this.isUnactivated;
    }

    public final void s(q r1) {
        this.bottomTabBarStyle = r1;
    }

    public final void t(s r1) {
        this.dynamicConfig = r1;
    }

    public final void u(e r1) {
        this.navBarConfig = r1;
    }

    public final void v(j r1) {
        this.splitStyleConfig = r1;
    }

    public final void w(Integer r1) {
        this.tabID = r1;
    }

    public final void x(q r1) {
        this.topTabBarStyle = r1;
    }
}

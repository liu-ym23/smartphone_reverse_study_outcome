package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R$\u0010'\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R$\u0010*\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/q;", "", "Lcom/bytedance/android/shopping/store/tabkit/model/p;", "fullStateConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/p;", "d", "()Lcom/bytedance/android/shopping/store/tabkit/model/p;", "m", "(Lcom/bytedance/android/shopping/store/tabkit/model/p;)V", "splitStateConfig", "i", "r", "", "displayMode", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "alignment", "a", "j", "Lcom/bytedance/android/shopping/store/tabkit/model/n;", "indicatorStyle", "Lcom/bytedance/android/shopping/store/tabkit/model/n;", "f", "()Lcom/bytedance/android/shopping/store/tabkit/model/n;", "o", "(Lcom/bytedance/android/shopping/store/tabkit/model/n;)V", "", "backgroundColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "height", "e", "n", "leftInset", "g", "p", "rightInset", "h", "q", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("alignment")
    private Integer alignment;

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("display_mode")
    private Integer displayMode;

    @SerializedName("full_state_config")
    private p fullStateConfig;

    @SerializedName("height")
    private Integer height;

    @SerializedName("indicator_style")
    private n indicatorStyle;

    @SerializedName("left_inset")
    private Integer leftInset;

    @SerializedName("right_inset")
    private Integer rightInset;

    @SerializedName("split_state_config")
    private p splitStateConfig;

    public q() {
    }

    public final Integer a() {
        return this.alignment;
    }

    public final String b() {
        return this.backgroundColor;
    }

    public final Integer c() {
        return this.displayMode;
    }

    public final p d() {
        return this.fullStateConfig;
    }

    public final Integer e() {
        return this.height;
    }

    public final n f() {
        return this.indicatorStyle;
    }

    public final Integer g() {
        return this.leftInset;
    }

    public final Integer h() {
        return this.rightInset;
    }

    public final p i() {
        return this.splitStateConfig;
    }

    public final void j(Integer r1) {
        this.alignment = r1;
    }

    public final void k(String r1) {
        this.backgroundColor = r1;
    }

    public final void l(Integer r1) {
        this.displayMode = r1;
    }

    public final void m(p r1) {
        this.fullStateConfig = r1;
    }

    public final void n(Integer r1) {
        this.height = r1;
    }

    public final void o(n r1) {
        this.indicatorStyle = r1;
    }

    public final void p(Integer r1) {
        this.leftInset = r1;
    }

    public final void q(Integer r1) {
        this.rightInset = r1;
    }

    public final void r(p r1) {
        this.splitStateConfig = r1;
    }
}

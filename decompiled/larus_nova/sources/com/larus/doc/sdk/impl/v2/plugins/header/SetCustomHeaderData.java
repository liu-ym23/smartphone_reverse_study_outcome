package com.larus.doc.sdk.impl.v2.plugins.header;

import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0004\u001e\u001f !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u000bJ\b\u0010\u001d\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData;", "Ljava/io/Serializable;", "<init>", "()V", "themeColor", "", "getThemeColor", "()Ljava/lang/String;", "setThemeColor", "(Ljava/lang/String;)V", "shouldShowDivider", "", "getShouldShowDivider", "()Z", "setShouldShowDivider", "(Z)V", "titleConfig", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;", "getTitleConfig", "()Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;", "setTitleConfig", "(Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;)V", "items", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Items;", "getItems", "()Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Items;", "setItems", "(Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Items;)V", "isEmpty", "toString", "TitleConfig", "Items", "Item", "EIconRes", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetCustomHeaderData implements Serializable {

    @SerializedName("items")
    private Items items;

    @SerializedName("shouldShowDivider")
    private boolean shouldShowDivider;

    @SerializedName("themeColor")
    private String themeColor;

    @SerializedName("titleConfig")
    private TitleConfig titleConfig;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$EIconRes;", "", "imgResId", "", "imgResTint", "<init>", "(Ljava/lang/String;III)V", "getImgResId", "()I", "getImgResTint", "doc_embedded_mindnote_exit", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EIconRes extends Enum<EIconRes> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ EIconRes[] $VALUES = null;
        public static final EIconRes doc_embedded_mindnote_exit = null;
        private final int imgResId;
        private final int imgResTint;

        private static final /* synthetic */ EIconRes[] $values() {
            return new EIconRes[]{doc_embedded_mindnote_exit};
        }

        public static EnumEntries<EIconRes> getEntries() {
            return $ENTRIES;
        }

        static {
            doc_embedded_mindnote_exit = new EIconRes("doc_embedded_mindnote_exit", 0, R.drawable.chameleonv1_ud_icon_left_outlined, R.color.facade_selector_icon_n1);
            EIconRes[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static EIconRes[] values() {
            return (EIconRes[]) $VALUES.clone();
        }

        public final int getImgResId() {
            return this.imgResId;
        }

        public final int getImgResTint() {
            return this.imgResTint;
        }

        public static EIconRes valueOf(String r100) {
            return (EIconRes) r27.a.a(EIconRes.class, r100);
        }

        private EIconRes(String r100, int r101, int r102, int r103) {
            super(r100, r101);
            this.imgResId = r102;
            this.imgResTint = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Item;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "extraId", "getExtraId", "setExtraId", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "style", "getStyle", "setStyle", "text", "getText", "setText", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Item {

        @SerializedName("enable")
        private Boolean enable;

        @SerializedName("extraId")
        private String extraId;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private String f331634id;

        @SerializedName("style")
        private String style;

        @SerializedName("text")
        private String text;

        public Item() {
        }

        public String toString() {
            return "Item@" + hashCode() + "{id: " + this.f331634id + ", extraId: " + this.extraId + ", enable: " + this.enable + ", style: " + this.style + ", text: " + this.text + '}';
        }

        public final Boolean getEnable() {
            return this.enable;
        }

        public final String getExtraId() {
            return this.extraId;
        }

        public final String getId() {
            return this.f331634id;
        }

        public final String getStyle() {
            return this.style;
        }

        public final String getText() {
            return this.text;
        }

        public final void setEnable(Boolean r100) {
            this.enable = r100;
        }

        public final void setExtraId(String r100) {
            this.extraId = r100;
        }

        public final void setId(String r100) {
            this.f331634id = r100;
        }

        public final void setStyle(String r100) {
            this.style = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Items;", "", "<init>", "()V", "left", "", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Item;", "getLeft", "()Ljava/util/List;", "setLeft", "(Ljava/util/List;)V", "right", "getRight", "setRight", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Items {

        @SerializedName("left")
        private List<Item> left;

        @SerializedName("right")
        private List<Item> right;

        public Items() {
        }

        public String toString() {
            return "Items@" + hashCode() + "{left: " + this.left + ", right: right}";
        }

        public final List<Item> getLeft() {
            return this.left;
        }

        public final List<Item> getRight() {
            return this.right;
        }

        public final void setLeft(List<Item> r100) {
            this.left = r100;
        }

        public final void setRight(List<Item> r100) {
            this.right = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;", "", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "position", "getPosition", "setPosition", "isLoading", "", "()Z", "setLoading", "(Z)V", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TitleConfig {

        @SerializedName("isLoading")
        private boolean isLoading;

        @SerializedName("position")
        private String position;

        @SerializedName("title")
        private String title;

        public TitleConfig() {
        }

        public String toString() {
            return "TitleConfig@" + hashCode() + "{title: " + this.title + ", position: " + this.position + ", isLoading: " + this.isLoading + '}';
        }

        public final String getPosition() {
            return this.position;
        }

        public final String getTitle() {
            return this.title;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final void setLoading(boolean r100) {
            this.isLoading = r100;
        }

        public final void setPosition(String r100) {
            this.position = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }
    }

    public SetCustomHeaderData() {
    }

    public final boolean isEmpty() {
        if (this.titleConfig != null) goto L22;
        Items r100 = this.items;
        if (r100 != null) goto L7;
    L16:
        boolean r101 = true;
    L17:
        if (r101 == true) goto L19;
        return false;
    L19:
        if (this.shouldShowDivider == true) goto L24;
        return true;
    L24:
        return false;
    L7:
        if (r100.getLeft() == null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L16;
        r101 = false;
        goto L17
    L9:
        if (r100.getRight() != null) goto L12;
        r102 = false;
        goto L13
    L22:
        return false;
    }

    public String toString() {
        return "SetCustomHeaderData@" + hashCode() + "{themeColor: " + this.themeColor + ", shouldShowDivider: " + this.shouldShowDivider + ", titleConfig: " + this.titleConfig + ", items: " + this.items + '}';
    }

    public final Items getItems() {
        return this.items;
    }

    public final boolean getShouldShowDivider() {
        return this.shouldShowDivider;
    }

    public final String getThemeColor() {
        return this.themeColor;
    }

    public final TitleConfig getTitleConfig() {
        return this.titleConfig;
    }

    public final void setItems(Items r100) {
        this.items = r100;
    }

    public final void setShouldShowDivider(boolean r100) {
        this.shouldShowDivider = r100;
    }

    public final void setThemeColor(String r100) {
        this.themeColor = r100;
    }

    public final void setTitleConfig(TitleConfig r100) {
        this.titleConfig = r100;
    }
}

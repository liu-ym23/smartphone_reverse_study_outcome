package com.bytedance.android.shopping.store.moments.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Deprecated(message = "混排 建议使用商城的 ECHybridListSectionDTO")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR6\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/dto/SectionDTO;", "Ljava/io/Serializable;", "", "layoutColumn", "I", "getLayoutColumn", "()I", "setLayoutColumn", "(I)V", "Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "sectionStyle", "Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "getSectionStyle", "()Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "setSectionStyle", "(Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/shopping/store/moments/dto/ItemDTO;", "Lkotlin/collections/ArrayList;", "items", "Ljava/util/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "", "sectionId", "Ljava/lang/String;", "getSectionId", "()Ljava/lang/String;", "setSectionId", "(Ljava/lang/String;)V", "operationType", "Ljava/lang/Integer;", "getOperationType", "()Ljava/lang/Integer;", "setOperationType", "(Ljava/lang/Integer;)V", "type", "getType", "setType", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SectionDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("items")
    private ArrayList<ItemDTO> items;

    @SerializedName("layout_column")
    private int layoutColumn;

    @SerializedName("operation_type")
    private Integer operationType;

    @SerializedName("section_id")
    private String sectionId;

    @SerializedName("section_style")
    private StyleDTO sectionStyle;

    @SerializedName("type")
    private int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SectionDTO() {
    }

    public final ArrayList<ItemDTO> getItems() {
        return this.items;
    }

    public final int getLayoutColumn() {
        return this.layoutColumn;
    }

    public final Integer getOperationType() {
        return this.operationType;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final StyleDTO getSectionStyle() {
        return this.sectionStyle;
    }

    public final int getType() {
        return this.type;
    }

    public final void setItems(ArrayList<ItemDTO> r1) {
        this.items = r1;
    }

    public final void setLayoutColumn(int r1) {
        this.layoutColumn = r1;
    }

    public final void setOperationType(Integer r1) {
        this.operationType = r1;
    }

    public final void setSectionId(String r1) {
        this.sectionId = r1;
    }

    public final void setSectionStyle(StyleDTO r1) {
        this.sectionStyle = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}

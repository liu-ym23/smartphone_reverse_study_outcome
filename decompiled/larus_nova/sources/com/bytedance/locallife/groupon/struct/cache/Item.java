package com.bytedance.locallife.groupon.struct.cache;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JD\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/cache/Item;", "", "channel", "", "bundle", "injectSchema", "", "keyExtraParam", "", "Lcom/bytedance/locallife/groupon/struct/cache/ExtraKeyParam;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getBundle", "()Ljava/lang/String;", "getChannel", "getInjectSchema", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKeyExtraParam", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/bytedance/locallife/groupon/struct/cache/Item;", "equals", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Item {

    @SerializedName("bundle")
    private final String bundle;

    @SerializedName("channel")
    private final String channel;

    @SerializedName("inject_schema")
    private final Boolean injectSchema;

    @SerializedName(Constants.KEY_PARAMS)
    private final List<ExtraKeyParam> keyExtraParam;

    public Item() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Item copy$default(Item r100, String r101, String r102, Boolean r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.channel;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.bundle;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.injectSchema;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.keyExtraParam;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.channel;
    }

    public final String component2() {
        return this.bundle;
    }

    public final Boolean component3() {
        return this.injectSchema;
    }

    public final List<ExtraKeyParam> component4() {
        return this.keyExtraParam;
    }

    public final Item copy(String r100, String r101, Boolean r102, List<ExtraKeyParam> r103) {
        return new Item(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Item) == true) goto L8;
        return false;
    L8:
        Item r101 = (Item) r100;
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bundle, r101.bundle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.injectSchema, r101.injectSchema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.keyExtraParam, r101.keyExtraParam) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.channel;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bundle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.injectSchema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<ExtraKeyParam> r110 = this.keyExtraParam;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Item(channel=" + this.channel + ", bundle=" + this.bundle + ", injectSchema=" + this.injectSchema + ", keyExtraParam=" + this.keyExtraParam + ')';
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final Boolean getInjectSchema() {
        return this.injectSchema;
    }

    public final List<ExtraKeyParam> getKeyExtraParam() {
        return this.keyExtraParam;
    }

    public Item(String r100, String r101, Boolean r102, List<ExtraKeyParam> r103) {
        this.channel = r100;
        this.bundle = r101;
        this.injectSchema = r102;
        this.keyExtraParam = r103;
    }

    public /* synthetic */ Item(String r100, String r101, Boolean r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Boolean.TRUE;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = CollectionsKt.emptyList();
    L14:
        this(r100, r101, r102, r103);
    }
}

package com.ss.android.lark.chat.entity.message;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/CustomizeAIButtonGroup;", "Ljava/io/Serializable;", "text", "", "menus", "", "Lcom/ss/android/lark/chat/entity/message/CustomizeAIButton;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getMenus", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomizeAIButtonGroup implements Serializable {

    @SerializedName("buttons")
    private final List<CustomizeAIButton> menus;

    @SerializedName("text")
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomizeAIButtonGroup() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomizeAIButtonGroup copy$default(CustomizeAIButtonGroup r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.menus;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.text;
    }

    public final List<CustomizeAIButton> component2() {
        return this.menus;
    }

    public final CustomizeAIButtonGroup copy(String r100, List<CustomizeAIButton> r101) {
        return new CustomizeAIButtonGroup(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomizeAIButtonGroup) == true) goto L8;
        return false;
    L8:
        CustomizeAIButtonGroup r101 = (CustomizeAIButtonGroup) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.menus, r101.menus) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<CustomizeAIButton> r104 = this.menus;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CustomizeAIButtonGroup(text=" + this.text + ", menus=" + this.menus + ')';
    }

    public final List<CustomizeAIButton> getMenus() {
        return this.menus;
    }

    public final String getText() {
        return this.text;
    }

    public CustomizeAIButtonGroup(String r100, List<CustomizeAIButton> r101) {
        this.text = r100;
        this.menus = r101;
    }

    public /* synthetic */ CustomizeAIButtonGroup(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

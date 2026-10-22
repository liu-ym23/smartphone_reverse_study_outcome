package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0003H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003Ja\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006%"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/ShowContactPickerParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "title", "", "selectedIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSingle", "", "useNextStep", "chatId", "isAssignee", "supportChooseChat", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;ZZLjava/lang/String;ZZ)V", "getTitle", "()Ljava/lang/String;", "getSelectedIds", "()Ljava/util/ArrayList;", "()Z", "getUseNextStep", "getChatId", "getSupportChooseChat", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowContactPickerParam implements NonProguard {
    private final String chatId;
    private final boolean isAssignee;
    private final boolean isSingle;
    private final ArrayList<String> selectedIds;
    private final boolean supportChooseChat;
    private final String title;
    private final boolean useNextStep;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowContactPickerParam copy$default(ShowContactPickerParam r100, String r101, ArrayList r102, boolean r103, boolean r104, String r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.selectedIds;
    L8:
        ArrayList r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.isSingle;
    L11:
        boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.useNextStep;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.chatId;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.isAssignee;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.supportChooseChat;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.title;
    }

    public final ArrayList<String> component2() {
        return this.selectedIds;
    }

    public final boolean component3() {
        return this.isSingle;
    }

    public final boolean component4() {
        return this.useNextStep;
    }

    public final String component5() {
        return this.chatId;
    }

    public final boolean component6() {
        return this.isAssignee;
    }

    public final boolean component7() {
        return this.supportChooseChat;
    }

    public final ShowContactPickerParam copy(String r110, ArrayList<String> r111, boolean r112, boolean r113, String r114, boolean r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, "selectedIds");
        return new ShowContactPickerParam(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShowContactPickerParam) == true) goto L8;
        return false;
    L8:
        ShowContactPickerParam r101 = (ShowContactPickerParam) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedIds, r101.selectedIds) == true) goto L15;
        return false;
    L15:
        if (this.isSingle == r101.isSingle) goto L18;
        return false;
    L18:
        if (this.useNextStep == r101.useNextStep) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L24;
        return false;
    L24:
        if (this.isAssignee == r101.isAssignee) goto L27;
        return false;
    L27:
        if (this.supportChooseChat == r101.supportChooseChat) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.title.hashCode() * 31) + this.selectedIds.hashCode()) * 31;
        int r101 = 1231;
        if (this.isSingle == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.useNextStep == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.chatId;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.isAssignee == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.supportChooseChat == true) goto L23;
        r101 = 1237;
    L23:
        return r110 + r101;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "ShowContactPickerParam(title='" + this.title + "', selectedIds=" + this.selectedIds + ", isSingle=" + this.isSingle + ", useNextStep=" + this.useNextStep + ", chatId=" + this.chatId + ", isAssignee=" + this.isAssignee + ", supportChooseChat=" + this.supportChooseChat + ')';
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final ArrayList<String> getSelectedIds() {
        return this.selectedIds;
    }

    public final boolean getSupportChooseChat() {
        return this.supportChooseChat;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getUseNextStep() {
        return this.useNextStep;
    }

    public final boolean isAssignee() {
        return this.isAssignee;
    }

    public final boolean isSingle() {
        return this.isSingle;
    }

    public ShowContactPickerParam(String r100, ArrayList<String> r101, boolean r102, boolean r103, String r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "selectedIds");
        this.title = r100;
        this.selectedIds = r101;
        this.isSingle = r102;
        this.useNextStep = r103;
        this.chatId = r104;
        this.isAssignee = r105;
        this.supportChooseChat = r106;
    }
}

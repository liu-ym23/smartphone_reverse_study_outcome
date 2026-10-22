package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamAction;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "title", "", "color", "Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamActionColor;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamActionColor;)V", "getTitle", "()Ljava/lang/String;", "getColor", "()Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamActionColor;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenActionSheetParamAction implements NonProguard {
    private final OpenActionSheetParamActionColor color;
    private final String title;

    public static /* synthetic */ OpenActionSheetParamAction copy$default(OpenActionSheetParamAction r100, String r101, OpenActionSheetParamActionColor r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.color;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.title;
    }

    public final OpenActionSheetParamActionColor component2() {
        return this.color;
    }

    public final OpenActionSheetParamAction copy(String r100, OpenActionSheetParamActionColor r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        return new OpenActionSheetParamAction(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenActionSheetParamAction) == true) goto L8;
        return false;
    L8:
        OpenActionSheetParamAction r101 = (OpenActionSheetParamAction) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.title.hashCode() * 31;
        OpenActionSheetParamActionColor r101 = this.color;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "Action(title='" + this.title + "', color='" + this.color + "')";
    }

    public final OpenActionSheetParamActionColor getColor() {
        return this.color;
    }

    public final String getTitle() {
        return this.title;
    }

    public OpenActionSheetParamAction(String r100, OpenActionSheetParamActionColor r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.title = r100;
        this.color = r101;
    }
}

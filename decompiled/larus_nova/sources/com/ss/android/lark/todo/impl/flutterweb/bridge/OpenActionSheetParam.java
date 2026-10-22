package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.byted.cast.linkcommon.cybergarage.upnp.ActionList;
import com.ss.android.lark.diskmanage.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J@\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "title", "", "borderRadius", "", ActionList.ELEM_NAME, "", "Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamAction;", "bottomAction", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamAction;)V", "getTitle", "()Ljava/lang/String;", "getBorderRadius", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getActionList", "()Ljava/util/List;", "getBottomAction", "()Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamAction;", "toString", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParamAction;)Lcom/ss/android/lark/todo/impl/flutterweb/bridge/OpenActionSheetParam;", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenActionSheetParam implements NonProguard {
    private final List<OpenActionSheetParamAction> actionList;
    private final Double borderRadius;
    private final OpenActionSheetParamAction bottomAction;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenActionSheetParam copy$default(OpenActionSheetParam r100, String r101, Double r102, List r103, OpenActionSheetParamAction r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.borderRadius;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.actionList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottomAction;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.title;
    }

    public final Double component2() {
        return this.borderRadius;
    }

    public final List<OpenActionSheetParamAction> component3() {
        return this.actionList;
    }

    public final OpenActionSheetParamAction component4() {
        return this.bottomAction;
    }

    public final OpenActionSheetParam copy(String r100, Double r101, List<OpenActionSheetParamAction> r102, OpenActionSheetParamAction r103) {
        Intrinsics.checkNotNullParameter(r102, ActionList.ELEM_NAME);
        Intrinsics.checkNotNullParameter(r103, "bottomAction");
        return new OpenActionSheetParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenActionSheetParam) == true) goto L8;
        return false;
    L8:
        OpenActionSheetParam r101 = (OpenActionSheetParam) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderRadius, r101.borderRadius) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionList, r101.actionList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bottomAction, r101.bottomAction) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.borderRadius;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.actionList.hashCode()) * 31) + this.bottomAction.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenActionSheetParam(title='" + this.title + "', borderRadius='" + this.borderRadius + "', actionList='" + this.actionList + "', bottomAction='" + this.bottomAction + "')";
    }

    public final List<OpenActionSheetParamAction> getActionList() {
        return this.actionList;
    }

    public final Double getBorderRadius() {
        return this.borderRadius;
    }

    public final OpenActionSheetParamAction getBottomAction() {
        return this.bottomAction;
    }

    public final String getTitle() {
        return this.title;
    }

    public OpenActionSheetParam(String r100, Double r101, List<OpenActionSheetParamAction> r102, OpenActionSheetParamAction r103) {
        Intrinsics.checkNotNullParameter(r102, ActionList.ELEM_NAME);
        Intrinsics.checkNotNullParameter(r103, "bottomAction");
        this.title = r100;
        this.borderRadius = r101;
        this.actionList = r102;
        this.bottomAction = r103;
    }
}

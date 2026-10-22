package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003JU\u0010\"\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogShowOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", SlcCommonAction.KEY_ACTIONS, "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAction;", "Lkotlin/collections/ArrayList;", "alignActionsX", "", "content", "id", "maskClosable", "", "title", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getActions", "()Ljava/util/ArrayList;", "getAlignActionsX", "()Ljava/lang/String;", "getContent", "getId", "getMaskClosable", "()Z", "getTitle", "alignActions", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAlignActions;", "getAlignActions", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAlignActions;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Internal$ConfirmDialogShowOptions implements NonProguard {
    private final ArrayList<IWidget$Internal$ConfirmDialogAction> actions;
    private final String alignActionsX;
    private final String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f411463id;
    private final boolean maskClosable;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IWidget$Internal$ConfirmDialogShowOptions copy$default(IWidget$Internal$ConfirmDialogShowOptions r100, ArrayList r101, String r102, String r103, String r104, boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.actions;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.alignActionsX;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.f411463id;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.maskClosable;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.title;
    L20:
        ArrayList r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final ArrayList<IWidget$Internal$ConfirmDialogAction> component1() {
        return this.actions;
    }

    public final String component2() {
        return this.alignActionsX;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.f411463id;
    }

    public final boolean component5() {
        return this.maskClosable;
    }

    public final String component6() {
        return this.title;
    }

    public final IWidget$Internal$ConfirmDialogShowOptions copy(ArrayList<IWidget$Internal$ConfirmDialogAction> r100, @JSONField(name = "alignActions") String r110, String r111, String r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r110, "alignActionsX");
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r112, "id");
        Intrinsics.checkNotNullParameter(r114, "title");
        return new IWidget$Internal$ConfirmDialogShowOptions(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWidget$Internal$ConfirmDialogShowOptions) == true) goto L8;
        return false;
    L8:
        IWidget$Internal$ConfirmDialogShowOptions r101 = (IWidget$Internal$ConfirmDialogShowOptions) r100;
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.alignActionsX, r101.alignActionsX) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f411463id, r101.f411463id) == true) goto L21;
        return false;
    L21:
        if (this.maskClosable == r101.maskClosable) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.actions.hashCode() * 31) + this.alignActionsX.hashCode()) * 31) + this.content.hashCode()) * 31) + this.f411463id.hashCode()) * 31;
        if (this.maskClosable == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.title.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "ConfirmDialogShowOptions(actions=" + this.actions + ", alignActionsX=" + this.alignActionsX + ", content=" + this.content + ", id=" + this.f411463id + ", maskClosable=" + this.maskClosable + ", title=" + this.title + ')';
    }

    public final IWidget$Internal$ConfirmDialogAlignActions getAlignActions() {
        IWidget$Internal$ConfirmDialogAlignActions.a r100 = IWidget$Internal$ConfirmDialogAlignActions.Companion;
        String r101 = this.alignActionsX;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        IWidget$Internal$ConfirmDialogAlignActions[] r102 = IWidget$Internal$ConfirmDialogAlignActions.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        IWidget$Internal$ConfirmDialogAlignActions r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getValue(), r101) == true) goto L9;
        r104 = r104 + 1;
    L9:
        if (r105 == null) goto L12;
        return r105;
    L12:
        return IWidget$Internal$ConfirmDialogAlignActions.Horizontal;
    L8:
        r105 = null;
        goto L9
    }

    public final ArrayList<IWidget$Internal$ConfirmDialogAction> getActions() {
        return this.actions;
    }

    public final String getAlignActionsX() {
        return this.alignActionsX;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.f411463id;
    }

    public final boolean getMaskClosable() {
        return this.maskClosable;
    }

    public final String getTitle() {
        return this.title;
    }

    public IWidget$Internal$ConfirmDialogShowOptions(ArrayList<IWidget$Internal$ConfirmDialogAction> r100, @JSONField(name = "alignActions") String r101, String r102, String r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r101, "alignActionsX");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r105, "title");
        this.actions = r100;
        this.alignActionsX = r101;
        this.content = r102;
        this.f411463id = r103;
        this.maskClosable = r104;
        this.title = r105;
    }

    public /* synthetic */ IWidget$Internal$ConfirmDialogShowOptions(ArrayList r100, String r101, String r110, String r111, boolean r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        r101 = "horizontal";
    L5:
        String r102 = r101;
        if ((r114 & 16) == 0) goto L8;
        boolean r103 = true;
    L9:
        this(r100, r102, r110, r111, r103, r113);
        return;
    L8:
        r103 = r112;
        goto L9
    }
}

package com.obric.assistant.live.template;

import com.alipay.sdk.m.x.d;
import com.obric.livecard.api.entity.Text;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003JS\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d¨\u00060"}, d2 = {"Lcom/obric/assistant/live/template/ObricExpandedDialogueTemplate;", "", "title", "Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;", "actionBtn", "Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;", "clarifyBtnList", "", RXScreenCaptureService.KEY_CONTENT_TEXT, "Lcom/obric/livecard/api/entity/Text;", "describeText", "notify", "<init>", "(Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;Ljava/util/List;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Text;)V", "getTitle", "()Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;", d.f25925o, "(Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;)V", "getActionBtn", "()Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;", "setActionBtn", "(Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;)V", "getClarifyBtnList", "()Ljava/util/List;", "setClarifyBtnList", "(Ljava/util/List;)V", "getContentText", "()Lcom/obric/livecard/api/entity/Text;", "setContentText", "(Lcom/obric/livecard/api/entity/Text;)V", "getDescribeText", "setDescribeText", "getNotify", "setNotify", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricExpandedDialogueTemplate {
    private ObricExpandedDialogueActionButton actionBtn;
    private List<ObricExpandedDialogueActionButton> clarifyBtnList;
    private Text contentText;
    private Text describeText;
    private Text notify;
    private ObricExpandedDialogueTitle title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricExpandedDialogueTemplate copy$default(ObricExpandedDialogueTemplate r100, ObricExpandedDialogueTitle r101, ObricExpandedDialogueActionButton r102, List r103, Text r104, Text r105, Text r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.actionBtn;
    L8:
        ObricExpandedDialogueActionButton r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.clarifyBtnList;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.contentText;
    L14:
        Text r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.describeText;
    L17:
        Text r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.notify;
    L20:
        ObricExpandedDialogueTitle r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final ObricExpandedDialogueTitle component1() {
        return this.title;
    }

    public final ObricExpandedDialogueActionButton component2() {
        return this.actionBtn;
    }

    public final List<ObricExpandedDialogueActionButton> component3() {
        return this.clarifyBtnList;
    }

    public final Text component4() {
        return this.contentText;
    }

    public final Text component5() {
        return this.describeText;
    }

    public final Text component6() {
        return this.notify;
    }

    public final ObricExpandedDialogueTemplate copy(ObricExpandedDialogueTitle r100, ObricExpandedDialogueActionButton r110, List<ObricExpandedDialogueActionButton> r111, Text r112, Text r113, Text r114) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r112, RXScreenCaptureService.KEY_CONTENT_TEXT);
        return new ObricExpandedDialogueTemplate(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricExpandedDialogueTemplate) == true) goto L8;
        return false;
    L8:
        ObricExpandedDialogueTemplate r101 = (ObricExpandedDialogueTemplate) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionBtn, r101.actionBtn) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clarifyBtnList, r101.clarifyBtnList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentText, r101.contentText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.describeText, r101.describeText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.notify, r101.notify) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.title.hashCode() * 31;
        ObricExpandedDialogueActionButton r101 = this.actionBtn;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<ObricExpandedDialogueActionButton> r105 = this.clarifyBtnList;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.contentText.hashCode()) * 31;
        Text r108 = this.describeText;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Text r111 = this.notify;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricExpandedDialogueTemplate(title=" + this.title + ", actionBtn=" + this.actionBtn + ", clarifyBtnList=" + this.clarifyBtnList + ", contentText=" + this.contentText + ", describeText=" + this.describeText + ", notify=" + this.notify + ')';
    }

    public final ObricExpandedDialogueActionButton getActionBtn() {
        return this.actionBtn;
    }

    public final List<ObricExpandedDialogueActionButton> getClarifyBtnList() {
        return this.clarifyBtnList;
    }

    public final Text getContentText() {
        return this.contentText;
    }

    public final Text getDescribeText() {
        return this.describeText;
    }

    public final Text getNotify() {
        return this.notify;
    }

    public final ObricExpandedDialogueTitle getTitle() {
        return this.title;
    }

    public final void setActionBtn(ObricExpandedDialogueActionButton r100) {
        this.actionBtn = r100;
    }

    public final void setClarifyBtnList(List<ObricExpandedDialogueActionButton> r100) {
        this.clarifyBtnList = r100;
    }

    public final void setContentText(Text r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentText = r100;
    }

    public final void setDescribeText(Text r100) {
        this.describeText = r100;
    }

    public final void setNotify(Text r100) {
        this.notify = r100;
    }

    public final void setTitle(ObricExpandedDialogueTitle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public ObricExpandedDialogueTemplate(ObricExpandedDialogueTitle r100, ObricExpandedDialogueActionButton r101, List<ObricExpandedDialogueActionButton> r102, Text r103, Text r104, Text r105) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r103, RXScreenCaptureService.KEY_CONTENT_TEXT);
        this.title = r100;
        this.actionBtn = r101;
        this.clarifyBtnList = r102;
        this.contentText = r103;
        this.describeText = r104;
        this.notify = r105;
    }

    public /* synthetic */ ObricExpandedDialogueTemplate(ObricExpandedDialogueTitle r110, ObricExpandedDialogueActionButton r111, List r112, Text r113, Text r114, Text r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 16) == 0) goto L5;
        Text r100 = null;
    L7:
        if ((r116 & 32) == 0) goto L9;
        Text r101 = null;
    L10:
        this(r110, r111, r112, r113, r100, r101);
        return;
    L9:
        r101 = r115;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }
}

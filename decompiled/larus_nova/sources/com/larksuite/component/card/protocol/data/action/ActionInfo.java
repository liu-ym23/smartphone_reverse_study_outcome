package com.larksuite.component.card.protocol.data.action;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/larksuite/component/card/protocol/data/action/ActionInfo;", "Ljava/io/Serializable;", "actionStatus", "Lcom/larksuite/component/card/protocol/data/action/ActionStatus;", "actionEnable", "", "actionForceDisable", "actionDisableMessage", "", "sourceType", "", "sourceId", "<init>", "(Lcom/larksuite/component/card/protocol/data/action/ActionStatus;ZZLjava/lang/String;ILjava/lang/String;)V", "getActionStatus", "()Lcom/larksuite/component/card/protocol/data/action/ActionStatus;", "getActionEnable", "()Z", "setActionEnable", "(Z)V", "getActionForceDisable", "setActionForceDisable", "getActionDisableMessage", "()Ljava/lang/String;", "getSourceType", "()I", "getSourceId", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionInfo implements Serializable {
    private final String actionDisableMessage;
    private boolean actionEnable;
    private boolean actionForceDisable;
    private final ActionStatus actionStatus;
    private final String sourceId;
    private final int sourceType;

    public final String getActionDisableMessage() {
        return this.actionDisableMessage;
    }

    public final boolean getActionEnable() {
        return this.actionEnable;
    }

    public final boolean getActionForceDisable() {
        return this.actionForceDisable;
    }

    public final ActionStatus getActionStatus() {
        return this.actionStatus;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public final void setActionEnable(boolean r100) {
        this.actionEnable = r100;
    }

    public final void setActionForceDisable(boolean r100) {
        this.actionForceDisable = r100;
    }

    public ActionInfo(ActionStatus r100, boolean r101, boolean r102, String r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "actionStatus");
        this.actionStatus = r100;
        this.actionEnable = r101;
        this.actionForceDisable = r102;
        this.actionDisableMessage = r103;
        this.sourceType = r104;
        this.sourceId = r105;
    }

    public /* synthetic */ ActionInfo(ActionStatus r100, boolean r101, boolean r110, String r111, int r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r114 & 4) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r114 & 16) == 0) goto L13;
        int r104 = 0;
    L14:
        this(r100, r102, r103, r111, r104, r113);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}

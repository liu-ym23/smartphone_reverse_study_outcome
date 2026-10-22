package com.ss.android.lark.conditional.access.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.api.params.SecurityActionHandleContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\t\u0010%\u001a\u00020&H\u0096\u0001J\t\u0010'\u001a\u00020&H\u0096\u0001J\t\u0010(\u001a\u00020&H\u0096\u0001J\u0016\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010-\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ISecurityAction;", "securityAction", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/SecurityAction;", "currentAction", "Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;", SlcCommonAction.KEY_ACTIONS, "", "<init>", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/SecurityAction;Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;Ljava/util/List;)V", "getCurrentAction", "()Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;", "setCurrentAction", "(Lcom/ss/android/lark/conditional/access/network/model/response/DecisionData$Action;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "internalParams", "", "", "", "getInternalParams", "()Ljava/util/Map;", "setInternalParams", "(Ljava/util/Map;)V", "handleContext", "Lcom/ss/android/lark/security/compliance/api/params/SecurityActionHandleContext;", "getHandleContext", "()Lcom/ss/android/lark/security/compliance/api/params/SecurityActionHandleContext;", "toString", "parseToPrint", "getTraceId", "getSource", "", "describeContents", "onDialogDismiss", "", "onPrimaryButtonClick", "onSecondButtonClick", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "rawActions", "getRawActions", "()Ljava/lang/String;", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InternalSecurityAction implements Parcelable, ISecurityAction {
    public static final Parcelable.Creator<InternalSecurityAction> CREATOR = null;
    private List<DecisionData.Action> actions;
    private DecisionData.Action currentAction;

    @SerializedName("internalParams")
    private Map<String, Object> internalParams;
    private final SecurityAction securityAction;

    public static final class a implements Parcelable.Creator<InternalSecurityAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InternalSecurityAction createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SecurityAction r101 = (SecurityAction) r100.readParcelable(InternalSecurityAction.class.getClassLoader());
            DecisionData.Action r102 = (DecisionData.Action) r100.readSerializable();
            int r103 = r100.readInt();
            ArrayList r104 = new ArrayList(r103);
            int r105 = 0;
        L3:
            if (r105 == r103) goto L6;
            r104.add(r100.readSerializable());
            r105 = r105 + 1;
            goto L3
        L6:
            return new InternalSecurityAction(r101, r102, r104);
        }

        @Override // android.os.Parcelable.Creator
        public final InternalSecurityAction[] newArray(int r100) {
            return new InternalSecurityAction[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction
    public String getRawActions() {
        return this.securityAction.getRawActions();
    }

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction
    public void onDialogDismiss() {
        this.securityAction.onDialogDismiss();
    }

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction
    public void onPrimaryButtonClick() {
        this.securityAction.onPrimaryButtonClick();
    }

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction
    public void onSecondButtonClick() {
        this.securityAction.onSecondButtonClick();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.securityAction, r101);
        r100.writeSerializable(this.currentAction);
        List<DecisionData.Action> r102 = this.actions;
        r100.writeInt(r102.size());
        Iterator<DecisionData.Action> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeSerializable(r103.next());
        goto L4
    }

    public final SecurityActionHandleContext getHandleContext() {
        return this.securityAction.getHandleContext();
    }

    public final int getSource() {
        Object r100 = this.internalParams.get("SDK_ACTION_SOURCE");
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r101 = (Integer) r100;
    L6:
        if (r101 == null) goto L9;
        return r101.intValue();
    L9:
        return this.securityAction.source;
    L5:
        r101 = null;
        goto L6
    }

    public final String getTraceId() {
        return this.securityAction.getTraceId();
    }

    public final String parseToPrint() {
        return toString();
    }

    public String toString() {
        return com.ss.android.lark.security.compliance.infra.util.f.c(this);
    }

    public final List<DecisionData.Action> getActions() {
        return this.actions;
    }

    public final DecisionData.Action getCurrentAction() {
        return this.currentAction;
    }

    public final Map<String, Object> getInternalParams() {
        return this.internalParams;
    }

    public final void setActions(List<DecisionData.Action> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actions = r100;
    }

    public final void setCurrentAction(DecisionData.Action r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentAction = r100;
    }

    public final void setInternalParams(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.internalParams = r100;
    }

    public InternalSecurityAction(SecurityAction r100, DecisionData.Action r101, List<DecisionData.Action> r102) {
        Intrinsics.checkNotNullParameter(r100, "securityAction");
        Intrinsics.checkNotNullParameter(r101, "currentAction");
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        this.securityAction = r100;
        this.currentAction = r101;
        this.actions = r102;
        this.internalParams = new LinkedHashMap();
    }
}

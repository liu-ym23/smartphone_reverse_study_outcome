package com.ss.android.lark.security.compliance.api.model.filepolicy;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.security.compliance.api.params.SecurityActionHandleContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0014\u0010\u001d\u001a\u00020\u001a2\n\u0010\u001e\u001a\u00060\u001fj\u0002` H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/SecurityAction;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ISecurityAction;", "rawActions", "", "traceId", "source", "", "sourceTimestampMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "getRawActions", "()Ljava/lang/String;", "getTraceId", "setTraceId", "(Ljava/lang/String;)V", "handleContext", "Lcom/ss/android/lark/security/compliance/api/params/SecurityActionHandleContext;", "getHandleContext$annotations", "()V", "getHandleContext", "()Lcom/ss/android/lark/security/compliance/api/params/SecurityActionHandleContext;", "setHandleContext", "(Lcom/ss/android/lark/security/compliance/api/params/SecurityActionHandleContext;)V", "onPrimaryButtonClick", "", "onSecondButtonClick", "onDialogDismiss", LynxVideoManagerLite.EVENT_ON_ERROR, "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SecurityAction implements Parcelable, ISecurityAction {
    public static final Parcelable.Creator<SecurityAction> CREATOR = null;
    private SecurityActionHandleContext handleContext;
    private final String rawActions;
    public int source;
    public long sourceTimestampMs;
    private String traceId;

    public static final class a implements Parcelable.Creator<SecurityAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SecurityAction createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SecurityAction(r100.readString(), r100.readString(), r100.readInt(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final SecurityAction[] newArray(int r100) {
            return new SecurityAction[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SecurityAction(String r110) {
        Intrinsics.checkNotNullParameter(r110, "rawActions");
        this(r110, null, 0, 0, 14, null);
    }

    public SecurityAction(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "rawActions");
        Intrinsics.checkNotNullParameter(r111, "traceId");
        this(r110, r111, 0, 0, 12, null);
    }

    public SecurityAction(String r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "rawActions");
        Intrinsics.checkNotNullParameter(r111, "traceId");
        this(r110, r111, r112, 0, 8, null);
    }

    public static /* synthetic */ void getHandleContext$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction
    public void onDialogDismiss() {
    }

    public void onError(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction
    public void onPrimaryButtonClick() {
    }

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction
    public void onSecondButtonClick() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.rawActions);
        r100.writeString(this.traceId);
        r100.writeInt(this.source);
        r100.writeLong(this.sourceTimestampMs);
    }

    public final SecurityActionHandleContext getHandleContext() {
        return this.handleContext;
    }

    @Override // com.ss.android.lark.security.compliance.api.model.filepolicy.ISecurityAction
    public String getRawActions() {
        return this.rawActions;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final void setHandleContext(SecurityActionHandleContext r100) {
        this.handleContext = r100;
    }

    public final void setTraceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.traceId = r100;
    }

    public SecurityAction(String r100, String r101, int r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "rawActions");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        this.rawActions = r100;
        this.traceId = r101;
        this.source = r102;
        this.sourceTimestampMs = r103;
    }

    public /* synthetic */ SecurityAction(String r100, String r101, int r102, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 2) == 0) goto L5;
        r101 = qqb.a.d();
    L5:
        String r103 = r101;
        if ((r111 & 4) == 0) goto L8;
        int r104 = 0;
    L10:
        if ((r111 & 8) == 0) goto L12;
        r110 = 0;
    L12:
        this(r100, r103, r104, r110);
        return;
    L8:
        r104 = r102;
        goto L10
    }
}

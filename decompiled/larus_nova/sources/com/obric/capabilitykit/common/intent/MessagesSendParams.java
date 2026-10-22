package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MessagesSendParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", PickerReporterConstants.KEY.TARGET, "Lcom/obric/capabilitykit/common/intent/ContactTarget;", "content", "Lcom/obric/capabilitykit/common/intent/MessageContent;", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;Lcom/obric/capabilitykit/common/intent/MessageContent;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/MessageContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/MessageContent;)V", "getTarget", "()Lcom/obric/capabilitykit/common/intent/ContactTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MessagesSendParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<MessagesSendParams> CREATOR = null;
    private MessageContent content;
    private ContactTarget target;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<MessagesSendParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MessagesSendParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            MessageContent r102 = null;
            if (r100.readInt() != 0) goto L5;
            ContactTarget r103 = null;
        L6:
            ContactTarget r104 = r103;
            if (r100.readInt() == 0) goto L10;
            r102 = MessageContent.CREATOR.createFromParcel(r100);
        L10:
            MessagesSendParams r105 = new MessagesSendParams(r104, r102);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L11:
            if (r108 > r106) goto L13;
            r108 = r108 + 1;
        L13:
            if (r108 > r101) goto L15;
            joa.a.d(r100, r107);
            r108 = r108 + 1;
            goto L13
        L15:
            return r105;
        L5:
            r103 = ContactTarget.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final MessagesSendParams[] newArray(int r100) {
            return new MessagesSendParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessagesSendParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MessagesSendParams copy$default(MessagesSendParams r100, ContactTarget r101, MessageContent r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        return r100.copy(r101, r102);
    }

    public final ContactTarget component1() {
        return this.target;
    }

    public final MessageContent component2() {
        return this.content;
    }

    public final MessagesSendParams copy(ContactTarget r100, MessageContent r101) {
        return new MessagesSendParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessagesSendParams) == true) goto L8;
        return false;
    L8:
        MessagesSendParams r101 = (MessagesSendParams) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        ContactTarget r100 = this.target;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        MessageContent r104 = this.content;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "MessagesSendParams(target=" + this.target + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        ContactTarget r102 = this.target;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        MessageContent r103 = this.content;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.content);
    }

    public final MessageContent getContent() {
        return this.content;
    }

    public final ContactTarget getTarget() {
        return this.target;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof MessagesSendParams) == true) goto L5;
        return this;
    L5:
        ContactTarget r101 = this.target;
        if (r101 != null) goto L8;
        r101 = ((MessagesSendParams) r100).target;
    L8:
        MessageContent r102 = this.content;
        if (r102 != null) goto L12;
        r102 = ((MessagesSendParams) r100).content;
    L12:
        return new MessagesSendParams(r101, r102);
    }

    public final void setContent(MessageContent r100) {
        this.content = r100;
    }

    public final void setTarget(ContactTarget r100) {
        this.target = r100;
    }

    public MessagesSendParams(ContactTarget r100, MessageContent r101) {
        this.target = r100;
        this.content = r101;
    }

    public /* synthetic */ MessagesSendParams(ContactTarget r100, MessageContent r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

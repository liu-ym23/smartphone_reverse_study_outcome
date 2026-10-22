package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsAddToBlocklistParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", PickerReporterConstants.KEY.TARGET, "Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "isAdd", "", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setAdd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTarget", "()Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ContactsAddToBlocklistParams;", "describeContents", "", "equals", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactsAddToBlocklistParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ContactsAddToBlocklistParams> CREATOR = null;
    private Boolean isAdd;
    private BlockListTarget target;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ContactsAddToBlocklistParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsAddToBlocklistParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L5;
            BlockListTarget r103 = null;
        L6:
            BlockListTarget r104 = r103;
            int r105 = 1;
            if (r100.readInt() != 0) goto L10;
        L14:
            ContactsAddToBlocklistParams r106 = new ContactsAddToBlocklistParams(r104, r102);
            int r107 = Math.min(r101, 0);
            ClassLoader r108 = a.class.getClassLoader();
        L15:
            if (r105 > r107) goto L17;
            r105 = r105 + 1;
        L17:
            if (r105 > r101) goto L19;
            joa.a.d(r100, r108);
            r105 = r105 + 1;
            goto L17
        L19:
            return r106;
        L10:
            if (r100.readInt() == 0) goto L12;
            boolean r109 = true;
        L13:
            r102 = Boolean.valueOf(r109);
            goto L14
        L12:
            r109 = false;
            goto L13
        L5:
            r103 = BlockListTarget.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsAddToBlocklistParams[] newArray(int r100) {
            return new ContactsAddToBlocklistParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsAddToBlocklistParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsAddToBlocklistParams copy$default(ContactsAddToBlocklistParams r100, BlockListTarget r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isAdd;
    L9:
        return r100.copy(r101, r102);
    }

    public final BlockListTarget component1() {
        return this.target;
    }

    public final Boolean component2() {
        return this.isAdd;
    }

    public final ContactsAddToBlocklistParams copy(BlockListTarget r100, Boolean r101) {
        return new ContactsAddToBlocklistParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactsAddToBlocklistParams) == true) goto L8;
        return false;
    L8:
        ContactsAddToBlocklistParams r101 = (ContactsAddToBlocklistParams) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAdd, r101.isAdd) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        BlockListTarget r100 = this.target;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isAdd;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactsAddToBlocklistParams(target=" + this.target + ", isAdd=" + this.isAdd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        BlockListTarget r102 = this.target;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.isAdd;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final BlockListTarget getTarget() {
        return this.target;
    }

    public final Boolean isAdd() {
        return this.isAdd;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof ContactsAddToBlocklistParams) == true) goto L5;
        return this;
    L5:
        BlockListTarget r101 = this.target;
        if (r101 != null) goto L8;
        r101 = ((ContactsAddToBlocklistParams) r100).target;
    L8:
        Boolean r102 = this.isAdd;
        if (r102 != null) goto L12;
        r102 = ((ContactsAddToBlocklistParams) r100).isAdd;
    L12:
        return new ContactsAddToBlocklistParams(r101, r102);
    }

    public final void setAdd(Boolean r100) {
        this.isAdd = r100;
    }

    public final void setTarget(BlockListTarget r100) {
        this.target = r100;
    }

    public ContactsAddToBlocklistParams(BlockListTarget r100, Boolean r101) {
        this.target = r100;
        this.isAdd = r101;
    }

    public /* synthetic */ ContactsAddToBlocklistParams(BlockListTarget r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ \u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u0012\u0010\u0019\u001a\u00020\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010HÖ\u0001R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsDeleteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "([Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "setTargets", "[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "component1", "copy", "([Lcom/obric/capabilitykit/entity/app/ContactEntity;)Lcom/obric/capabilitykit/common/intent/ContactsDeleteParams;", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactsDeleteParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<ContactsDeleteParams> CREATOR = null;
    private ContactEntity[] targets;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ContactsDeleteParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsDeleteParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            ContactEntity[] r102 = null;
        L9:
            ContactsDeleteParams r103 = new ContactsDeleteParams(r102);
            int r104 = Math.min(r101, 0);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L10:
            if (r106 > r104) goto L12;
            r106 = r106 + 1;
        L12:
            if (r106 > r101) goto L14;
            joa.a.d(r100, r105);
            r106 = r106 + 1;
            goto L12
        L14:
            return r103;
        L5:
            int r107 = r100.readInt();
            ContactEntity[] r108 = new ContactEntity[r107];
            int r109 = 0;
        L6:
            if (r109 == r107) goto L8;
            r108[r109] = (ContactEntity) r100.readParcelable(ContactsDeleteParams.class.getClassLoader());
            r109 = r109 + 1;
            goto L6
        L8:
            r102 = r108;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsDeleteParams[] newArray(int r100) {
            return new ContactsDeleteParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsDeleteParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsDeleteParams copy$default(ContactsDeleteParams r100, ContactEntity[] r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.targets;
    L6:
        return r100.copy(r101);
    }

    public final ContactEntity[] component1() {
        return this.targets;
    }

    public final ContactsDeleteParams copy(ContactEntity[] r100) {
        return new ContactsDeleteParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactsDeleteParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.targets, ((ContactsDeleteParams) r100).targets) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        ContactEntity[] r100 = this.targets;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r100);
    }

    public String toString() {
        return "ContactsDeleteParams(targets=" + Arrays.toString(this.targets) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        ContactEntity[] r103 = this.targets;
        if (r103 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r103.length;
        r100.writeInt(r104);
    L6:
        if (r102 == r104) goto L10;
        r100.writeParcelable(r103[r102], r101);
        r102 = r102 + 1;
        goto L6
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.targets);
    }

    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ContactEntity[] getTargets() {
        return this.targets;
    }

    public ContactsDeleteParams(ContactEntity[] r100) {
        this.targets = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof ContactsDeleteParams) == true) goto L5;
        return this;
    L5:
        ContactEntity[] r101 = this.targets;
        if (r101 != null) goto L9;
        r101 = ((ContactsDeleteParams) r100).targets;
    L9:
        return new ContactsDeleteParams(r101);
    }

    public final void setTargets(ContactEntity[] r100) {
        this.targets = r100;
    }

    public /* synthetic */ ContactsDeleteParams(ContactEntity[] r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}

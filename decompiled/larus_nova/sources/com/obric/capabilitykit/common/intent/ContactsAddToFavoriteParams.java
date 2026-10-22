package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0016HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0012\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010 \u001a\u00020!HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsAddToFavoriteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", PickerReporterConstants.KEY.TARGET, "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "isAdd", "", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setAdd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTarget", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ContactsAddToFavoriteParams;", "describeContents", "", "equals", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactsAddToFavoriteParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<ContactsAddToFavoriteParams> CREATOR = null;
    private Boolean isAdd;
    private ContactEntity target;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ContactsAddToFavoriteParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsAddToFavoriteParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ContactEntity r102 = (ContactEntity) r100.readParcelable(ContactsAddToFavoriteParams.class.getClassLoader());
            int r103 = 1;
            if (r100.readInt() != 0) goto L6;
            Boolean r104 = null;
        L10:
            ContactsAddToFavoriteParams r105 = new ContactsAddToFavoriteParams(r102, r104);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
        L11:
            if (r103 > r106) goto L13;
            r103 = r103 + 1;
        L13:
            if (r103 > r101) goto L15;
            joa.a.d(r100, r107);
            r103 = r103 + 1;
            goto L13
        L15:
            return r105;
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r108 = true;
        L9:
            r104 = Boolean.valueOf(r108);
            goto L10
        L8:
            r108 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ContactsAddToFavoriteParams[] newArray(int r100) {
            return new ContactsAddToFavoriteParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsAddToFavoriteParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsAddToFavoriteParams copy$default(ContactsAddToFavoriteParams r100, ContactEntity r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isAdd;
    L9:
        return r100.copy(r101, r102);
    }

    public final ContactEntity component1() {
        return this.target;
    }

    public final Boolean component2() {
        return this.isAdd;
    }

    public final ContactsAddToFavoriteParams copy(ContactEntity r100, Boolean r101) {
        return new ContactsAddToFavoriteParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContactsAddToFavoriteParams) == true) goto L8;
        return false;
    L8:
        ContactsAddToFavoriteParams r101 = (ContactsAddToFavoriteParams) r100;
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
        ContactEntity r100 = this.target;
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
        return "ContactsAddToFavoriteParams(target=" + this.target + ", isAdd=" + this.isAdd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.target, r101);
        Boolean r102 = this.isAdd;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.target);
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ContactEntity getTarget() {
        return this.target;
    }

    public final Boolean isAdd() {
        return this.isAdd;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof ContactsAddToFavoriteParams) == true) goto L5;
        return this;
    L5:
        ContactEntity r101 = this.target;
        if (r101 != null) goto L8;
        r101 = ((ContactsAddToFavoriteParams) r100).target;
    L8:
        Boolean r102 = this.isAdd;
        if (r102 != null) goto L12;
        r102 = ((ContactsAddToFavoriteParams) r100).isAdd;
    L12:
        return new ContactsAddToFavoriteParams(r101, r102);
    }

    public final void setAdd(Boolean r100) {
        this.isAdd = r100;
    }

    public final void setTarget(ContactEntity r100) {
        this.target = r100;
    }

    public ContactsAddToFavoriteParams(ContactEntity r100, Boolean r101) {
        this.target = r100;
        this.isAdd = r101;
    }

    public /* synthetic */ ContactsAddToFavoriteParams(ContactEntity r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

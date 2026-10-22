package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\u0010\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\"H\u0016J\t\u0010#\u001a\u00020\u001cHÖ\u0001J\b\u0010$\u001a\u00020\u001eH\u0016J\u0012\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010 H\u0016J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/intent/NotesUpdateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", PickerReporterConstants.KEY.TARGET, "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "title", "", "content", "Lcom/obric/capabilitykit/common/intent/NoteContent;", "(Lcom/obric/capabilitykit/entity/app/NoteEntity;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/NoteContent;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/NoteContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/NoteContent;)V", "getTarget", "()Lcom/obric/capabilitykit/entity/app/NoteEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/NoteEntity;)V", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotesUpdateParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<NotesUpdateParams> CREATOR = null;
    private NoteContent content;
    private NoteEntity target;
    private String title;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<NotesUpdateParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final NotesUpdateParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            NoteEntity r102 = (NoteEntity) r100.readParcelable(NotesUpdateParams.class.getClassLoader());
            String r103 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            NoteContent r104 = null;
        L6:
            NotesUpdateParams r105 = new NotesUpdateParams(r102, r103, r104);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L7:
            if (r108 > r106) goto L9;
            r108 = r108 + 1;
        L9:
            if (r108 > r101) goto L11;
            joa.a.d(r100, r107);
            r108 = r108 + 1;
            goto L9
        L11:
            return r105;
        L5:
            r104 = NoteContent.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final NotesUpdateParams[] newArray(int r100) {
            return new NotesUpdateParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public NotesUpdateParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NotesUpdateParams copy$default(NotesUpdateParams r100, NoteEntity r101, String r102, NoteContent r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.content;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final NoteEntity component1() {
        return this.target;
    }

    public final String component2() {
        return this.title;
    }

    public final NoteContent component3() {
        return this.content;
    }

    public final NotesUpdateParams copy(NoteEntity r100, String r101, NoteContent r102) {
        return new NotesUpdateParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NotesUpdateParams) == true) goto L8;
        return false;
    L8:
        NotesUpdateParams r101 = (NotesUpdateParams) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(new Object[]{this.target, this.content});
    }

    public int hashCode() {
        NoteEntity r100 = this.target;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        NoteContent r107 = this.content;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "NotesUpdateParams(target=" + this.target + ", title=" + this.title + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.target, r101);
        r100.writeString(this.title);
        NoteContent r102 = this.content;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final NoteContent getContent() {
        return this.content;
    }

    public final NoteEntity getTarget() {
        return this.target;
    }

    public final String getTitle() {
        return this.title;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof NotesUpdateParams) == true) goto L5;
        return this;
    L5:
        NoteEntity r101 = this.target;
        if (r101 != null) goto L8;
        r101 = ((NotesUpdateParams) r100).target;
    L8:
        String r102 = this.title;
        if (r102 != null) goto L11;
        r102 = ((NotesUpdateParams) r100).title;
    L11:
        NoteContent r103 = this.content;
        if (r103 != null) goto L15;
        r103 = ((NotesUpdateParams) r100).content;
    L15:
        return new NotesUpdateParams(r101, r102, r103);
    }

    public final void setContent(NoteContent r100) {
        this.content = r100;
    }

    public final void setTarget(NoteEntity r100) {
        this.target = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public NotesUpdateParams(NoteEntity r100, String r101, NoteContent r102) {
        this.target = r100;
        this.title = r101;
        this.content = r102;
    }

    public /* synthetic */ NotesUpdateParams(NoteEntity r100, String r101, NoteContent r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

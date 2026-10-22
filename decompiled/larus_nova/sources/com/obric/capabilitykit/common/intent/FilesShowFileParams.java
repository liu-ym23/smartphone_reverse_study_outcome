package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u0010\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013H\u0016J\t\u0010\u0014\u001a\u00020\rHÖ\u0001J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rHÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/FilesShowFileParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", PickerReporterConstants.KEY.TARGET, "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "getTarget", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setTarget", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FilesShowFileParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<FilesShowFileParams> CREATOR = null;
    private FileEntity target;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<FilesShowFileParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FilesShowFileParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            FilesShowFileParams r102 = new FilesShowFileParams((FileEntity) r100.readParcelable(FilesShowFileParams.class.getClassLoader()));
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final FilesShowFileParams[] newArray(int r100) {
            return new FilesShowFileParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilesShowFileParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FilesShowFileParams copy$default(FilesShowFileParams r100, FileEntity r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        return r100.copy(r101);
    }

    public final FileEntity component1() {
        return this.target;
    }

    public final FilesShowFileParams copy(FileEntity r100) {
        return new FilesShowFileParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FilesShowFileParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.target, ((FilesShowFileParams) r100).target) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        FileEntity r100 = this.target;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "FilesShowFileParams(target=" + this.target + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.target, r101);
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

    public final FileEntity getTarget() {
        return this.target;
    }

    public FilesShowFileParams(FileEntity r100) {
        this.target = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof FilesShowFileParams) == true) goto L5;
        return this;
    L5:
        FileEntity r101 = this.target;
        if (r101 != null) goto L9;
        r101 = ((FilesShowFileParams) r100).target;
    L9:
        return new FilesShowFileParams(r101);
    }

    public final void setTarget(FileEntity r100) {
        this.target = r100;
    }

    public /* synthetic */ FilesShowFileParams(FileEntity r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}

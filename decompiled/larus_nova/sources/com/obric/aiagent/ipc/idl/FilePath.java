package com.obric.aiagent.ipc.idl;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aiagent.platform.depend.IAppContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0003J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/obric/aiagent/ipc/idl/FilePath;", "Landroid/os/Parcelable;", "baseDir", "", "relativePath", "", "isDirectory", "", "<init>", "(ILjava/lang/String;Z)V", "getBaseDir", "()I", "getRelativePath", "()Ljava/lang/String;", "()Z", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "toLocalFile", "Ljava/io/File;", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "ipc-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilePath implements Parcelable {
    public static final Parcelable.Creator<FilePath> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f384701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f384702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f384703c;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b implements Parcelable.Creator<FilePath> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final FilePath createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            String r102 = r100.readString();
            if (r100.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            return new FilePath(r101, r102, r103);
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FilePath[] newArray(int r100) {
            return new FilePath[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FilePath) == true) goto L8;
        return false;
    L8:
        FilePath r101 = (FilePath) r100;
        if (this.f384701a == r101.f384701a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f384702b, r101.f384702b) == true) goto L15;
        return false;
    L15:
        if (this.f384703c == r101.f384703c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f384701a * 31) + this.f384702b.hashCode()) * 31;
        if (this.f384703c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "FilePath(baseDir=" + this.f384701a + ", relativePath=" + this.f384702b + ", isDirectory=" + this.f384703c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f384701a);
        r100.writeString(this.f384702b);
        r100.writeInt(this.f384703c ? 1 : 0);
    }

    private final Application getContext() {
        return IAppContext.f384977a.getApplication();
    }

    public final File a() {
        int r100 = this.f384701a;
        if (r100 == 0) goto L21;
        if (r100 == 1) goto L29;
        if (r100 == 2) goto L28;
        switch(r100) {
            case 10: goto L15;
            case 11: goto L12;
            case 12: goto L23;
            default: goto L22;
        };
    L12:
        File r101 = getContext().getExternalCacheDir();
        if (r101 != null) goto L25;
        return null;
    L25:
        return new PolarisFileWrapper(r101, this.f384702b);
    L15:
        File r102 = getContext().getObbDir();
        if (r102 != null) goto L27;
        return null;
    L27:
        return new PolarisFileWrapper(r102, this.f384702b);
    L22:
        return getContext().getDir(this.f384702b, 0);
    L23:
        return getContext().getExternalFilesDir(this.f384702b);
    L28:
        return new PolarisFileWrapper(getContext().getFilesDir(), this.f384702b);
    L29:
        return new PolarisFileWrapper(getContext().getCacheDir(), this.f384702b);
    L21:
        return getContext().getDir(this.f384702b, 0);
    }

    public FilePath(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "relativePath");
        this.f384701a = r100;
        this.f384702b = r101;
        this.f384703c = r102;
    }
}

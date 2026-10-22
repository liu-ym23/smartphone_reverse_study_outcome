package com.bytedance.ee.bear.list.selector;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u00104\u001a\u0002052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u00020&H\u0016J\b\u00107\u001a\u00020&H\u0016J\b\u00108\u001a\u00020\u000eH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001a\u0010.\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u00101\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "selectorType", "Lcom/bytedance/ee/bear/list/selector/SelectorType;", "getSelectorType", "()Lcom/bytedance/ee/bear/list/selector/SelectorType;", "setSelectorType", "(Lcom/bytedance/ee/bear/list/selector/SelectorType;)V", "selectorTitle", "", "getSelectorTitle", "()Ljava/lang/String;", "setSelectorTitle", "(Ljava/lang/String;)V", "enableSelectCurrent", "", "getEnableSelectCurrent", "()Z", "setEnableSelectCurrent", "(Z)V", "enableShowRecent", "getEnableShowRecent", "setEnableShowRecent", "enableShowRecentV1", "getEnableShowRecentV1", "setEnableShowRecentV1", "selectorScope", "Lcom/bytedance/ee/bear/list/selector/SelectorScope;", "getSelectorScope", "()Lcom/bytedance/ee/bear/list/selector/SelectorScope;", "setSelectorScope", "(Lcom/bytedance/ee/bear/list/selector/SelectorScope;)V", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "enableCreateFolder", "getEnableCreateFolder", "setEnableCreateFolder", "enableSelectMySpace", "getEnableSelectMySpace", "setEnableSelectMySpace", "enableUnorganized", "getEnableUnorganized", "setEnableUnorganized", "writeToParcel", "", "flags", "describeContents", "toString", "CREATOR", "contentmanager-list-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectorConfig implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static WeakReference<td5.a> f229368k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SelectorType f229369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f229370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f229371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f229372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f229373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SelectorScope f229374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f229375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f229376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f229377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f229378j;

    public static final class a implements Parcelable.Creator<SelectorConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectorConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SelectorConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SelectorConfig[] newArray(int r100) {
            return new SelectorConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "SelectorConfig(selectorType='" + this.f229369a + "', selectorTitle='" + this.f229370b + "', enableSelectCurrent=" + this.f229371c + ", enableShowRecent=" + this.f229372d + ", enableShowRecentV1=" + this.f229373e + ", selectorScope=" + this.f229374f + "), requestCode=" + this.f229375g + "), enableCreateFolder=" + this.f229376h + "), enableSelectMySpace=" + this.f229377i + "), enableUnorganized=" + this.f229378j + "), ";
    }

    public SelectorConfig() {
        this.f229369a = SelectorType.SPACE_MOVE_TO;
        this.f229370b = "";
        this.f229374f = SelectorScope.ALL;
        this.f229375g = -1;
        this.f229376h = true;
        this.f229377i = true;
        this.f229378j = true;
    }

    public SelectorConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        SelectorType r101 = (SelectorType) r100.readParcelable(SelectorType.class.getClassLoader());
        if (r101 != null) goto L5;
        r101 = SelectorType.SPACE_MOVE_TO;
    L5:
        this.f229369a = r101;
        String r102 = r100.readString();
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        this.f229370b = r102;
        boolean r103 = true;
        if (r100.readByte() == 0) goto L11;
        boolean r104 = true;
    L12:
        this.f229371c = r104;
        if (r100.readByte() == 0) goto L15;
        boolean r105 = true;
    L16:
        this.f229372d = r105;
        if (r100.readByte() == 0) goto L19;
        boolean r106 = true;
    L20:
        this.f229373e = r106;
        SelectorScope r107 = (SelectorScope) r100.readParcelable(SelectorScope.class.getClassLoader());
        if (r107 != null) goto L23;
        r107 = SelectorScope.ALL;
    L23:
        this.f229374f = r107;
        this.f229375g = r100.readInt();
        if (r100.readByte() == 0) goto L26;
        boolean r108 = true;
    L27:
        this.f229376h = r108;
        if (r100.readByte() == 0) goto L30;
        boolean r109 = true;
    L31:
        this.f229377i = r109;
        if (r100.readByte() != 0) goto L35;
        r103 = false;
    L35:
        this.f229378j = r103;
        return;
    L30:
        r109 = false;
        goto L31
    L26:
        r108 = false;
        goto L27
    L19:
        r106 = false;
        goto L20
    L15:
        r105 = false;
        goto L16
    L11:
        r104 = false;
        goto L12
    }

    public final void a(SelectorScope r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f229374f = r100;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f229370b = r100;
    }

    public final void c(SelectorType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f229369a = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.f229369a, r101);
        r100.writeString(this.f229370b);
        r100.writeByte(this.f229371c ? 1 : 0);
        r100.writeByte(this.f229372d ? 1 : 0);
        r100.writeByte(this.f229373e ? 1 : 0);
        r100.writeParcelable(this.f229374f, r101);
        r100.writeInt(this.f229375g);
        r100.writeByte(this.f229376h ? 1 : 0);
        r100.writeByte(this.f229377i ? 1 : 0);
        r100.writeByte(this.f229378j ? 1 : 0);
    }
}

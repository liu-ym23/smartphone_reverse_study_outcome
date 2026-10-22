package com.bytedance.ee.bear.list.selector;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u00104\u001a\u0002052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u00020&H\u0016J\b\u00107\u001a\u00020&H\u0016J\b\u00108\u001a\u00020\u000eH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001a\u0010.\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u00101\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "selectorType", "Lcom/bytedance/ee/bear/list/selector/SelectorType;", "getSelectorType", "()Lcom/bytedance/ee/bear/list/selector/SelectorType;", "setSelectorType", "(Lcom/bytedance/ee/bear/list/selector/SelectorType;)V", "selectorTitle", "", "getSelectorTitle", "()Ljava/lang/String;", "setSelectorTitle", "(Ljava/lang/String;)V", "enableSelectCurrent", "", "getEnableSelectCurrent", "()Z", "setEnableSelectCurrent", "(Z)V", "enableShowRecent", "getEnableShowRecent", "setEnableShowRecent", "enableShowRecentV1", "getEnableShowRecentV1", "setEnableShowRecentV1", "selectorScope", "Lcom/bytedance/ee/bear/list/selector/SelectorScope;", "getSelectorScope", "()Lcom/bytedance/ee/bear/list/selector/SelectorScope;", "setSelectorScope", "(Lcom/bytedance/ee/bear/list/selector/SelectorScope;)V", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "enableCreateFolder", "getEnableCreateFolder", "setEnableCreateFolder", "enableSelectMySpace", "getEnableSelectMySpace", "setEnableSelectMySpace", "enableUnorganized", "getEnableUnorganized", "setEnableUnorganized", "writeToParcel", "", "flags", "describeContents", "toString", "CREATOR", "contentmanager-list-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectorConfig implements Parcelable {
    public static final a CREATOR = null;
    public static WeakReference<td5.a> k;
    public SelectorType a;
    public String b;
    public boolean c;
    public boolean d;
    public boolean e;
    public SelectorScope f;
    public int g;
    public final boolean h;
    public boolean i;
    public boolean j;

    public static final class a implements Parcelable.Creator<SelectorConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectorConfig createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new SelectorConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SelectorConfig[] newArray(int r1) {
            return new SelectorConfig[r1];
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
        return "SelectorConfig(selectorType='" + this.a + "', selectorTitle='" + this.b + "', enableSelectCurrent=" + this.c + ", enableShowRecent=" + this.d + ", enableShowRecentV1=" + this.e + ", selectorScope=" + this.f + "), requestCode=" + this.g + "), enableCreateFolder=" + this.h + "), enableSelectMySpace=" + this.i + "), enableUnorganized=" + this.j + "), ";
    }

    public SelectorConfig() {
        this.a = SelectorType.SPACE_MOVE_TO;
        this.b = "";
        this.f = SelectorScope.ALL;
        this.g = -1;
        this.h = true;
        this.i = true;
        this.j = true;
    }

    public SelectorConfig(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        this();
        SelectorType r0 = (SelectorType) r4.readParcelable(SelectorType.class.getClassLoader());
        if (r0 != null) goto L5;
        r0 = SelectorType.SPACE_MOVE_TO;
    L5:
        this.a = r0;
        String r1 = r4.readString();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        this.b = r1;
        boolean r2 = true;
        if (r4.readByte() == 0) goto L11;
        boolean r3 = true;
    L12:
        this.c = r3;
        if (r4.readByte() == 0) goto L15;
        boolean r5 = true;
    L16:
        this.d = r5;
        if (r4.readByte() == 0) goto L19;
        boolean r6 = true;
    L20:
        this.e = r6;
        SelectorScope r7 = (SelectorScope) r4.readParcelable(SelectorScope.class.getClassLoader());
        if (r7 != null) goto L23;
        r7 = SelectorScope.ALL;
    L23:
        this.f = r7;
        this.g = r4.readInt();
        if (r4.readByte() == 0) goto L26;
        boolean r8 = true;
    L27:
        this.h = r8;
        if (r4.readByte() == 0) goto L30;
        boolean r9 = true;
    L31:
        this.i = r9;
        if (r4.readByte() != 0) goto L35;
        r2 = false;
    L35:
        this.j = r2;
        return;
    L30:
        r9 = false;
        goto L31
    L26:
        r8 = false;
        goto L27
    L19:
        r6 = false;
        goto L20
    L15:
        r5 = false;
        goto L16
    L11:
        r3 = false;
        goto L12
    }

    public final void a(SelectorScope r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void c(SelectorType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeParcelable(this.a, r3);
        r2.writeString(this.b);
        r2.writeByte(this.c ? 1 : 0);
        r2.writeByte(this.d ? 1 : 0);
        r2.writeByte(this.e ? 1 : 0);
        r2.writeParcelable(this.f, r3);
        r2.writeInt(this.g);
        r2.writeByte(this.h ? 1 : 0);
        r2.writeByte(this.i ? 1 : 0);
        r2.writeByte(this.j ? 1 : 0);
    }
}

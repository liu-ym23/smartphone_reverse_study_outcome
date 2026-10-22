package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/capabilitykit/common/execution/IntentCalling;", "Landroid/os/Parcelable;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class IntentCalling implements Parcelable {
    public static final Parcelable.Creator<IntentCalling> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f396163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f396164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f396165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f396166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f396167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f396168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f396169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f396170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f396171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Parcelable f396172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f396173k;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<IntentCalling> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IntentCalling createFromParcel(Parcel r210) {
            int r100 = r210.readInt();
            Intrinsics.checkNotNullParameter(r210, "parcel");
            long r101 = r210.readLong();
            long r102 = r210.readLong();
            long r103 = r210.readLong();
            long r110 = r210.readLong();
            long r111 = r210.readLong();
            String r112 = r210.readString();
            String r113 = r210.readString();
            String r114 = r210.readString();
            String r115 = r210.readString();
            Parcelable r116 = r210.readParcelable(IntentCalling.class.getClassLoader());
            if (r210.readInt() != 0) goto L5;
            int r211 = r100;
            LinkedHashMap r117 = null;
        L9:
            IntentCalling r104 = new IntentCalling(r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117);
            int r105 = r211;
            int r106 = Math.min(r105, 1);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L11:
            if (r108 > r106) goto L17;
            if (r108 != 1) goto L16;
            Object r109 = joa.a.c(r210, r107);
            if (r109 == null) goto L16;
            r104.f396173k = (Map) r109;
        L16:
            r108 = r108 + 1;
        L17:
            if (r108 > r105) goto L19;
            joa.a.d(r210, r107);
            r108 = r108 + 1;
            goto L17
        L19:
            return r104;
        L5:
            int r118 = r210.readInt();
            LinkedHashMap r119 = new LinkedHashMap(r118);
            int r120 = 0;
        L6:
            if (r120 == r118) goto L8;
            r119.put(r210.readString(), r210.readString());
            r120 = r120 + 1;
            r118 = r118;
            r100 = r100;
            goto L6
        L8:
            r211 = r100;
            r117 = r119;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final IntentCalling[] newArray(int r100) {
            return new IntentCalling[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public IntentCalling(long r100, long r101, long r110, long r111, long r112, String r113, String r114, String r115, String r116, Parcelable r210, Map<String, String> r211) {
        Intrinsics.checkNotNullParameter(r113, "intentName");
        Intrinsics.checkNotNullParameter(r114, "implClassName");
        this.f396163a = r100;
        this.f396164b = r101;
        this.f396165c = r110;
        this.f396166d = r111;
        this.f396167e = r112;
        this.f396168f = r113;
        this.f396169g = r114;
        this.f396170h = r115;
        this.f396171i = r116;
        this.f396172j = r210;
        this.f396173k = r211;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IntentCalling) == true) goto L8;
        return false;
    L8:
        IntentCalling r101 = (IntentCalling) r100;
        if (this.f396163a == r101.f396163a) goto L12;
        return false;
    L12:
        if (this.f396164b == r101.f396164b) goto L15;
        return false;
    L15:
        if (this.f396165c == r101.f396165c) goto L18;
        return false;
    L18:
        if (this.f396166d == r101.f396166d) goto L21;
        return false;
    L21:
        if (this.f396167e == r101.f396167e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f396168f, r101.f396168f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f396169g, r101.f396169g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f396170h, r101.f396170h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f396171i, r101.f396171i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f396172j, r101.f396172j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f396173k, r101.f396173k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f396163a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f396164b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f396165c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f396166d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f396167e;
        int r109 = (((((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.f396168f.hashCode()) * 31) + this.f396169g.hashCode()) * 31;
        String r110 = this.f396170h;
        int r111 = 0;
        if (r110 != null) goto L5;
        int r112 = 0;
    L6:
        int r113 = (r109 + r112) * 31;
        String r114 = this.f396171i;
        if (r114 != null) goto L9;
        int r115 = 0;
    L10:
        int r116 = (r113 + r115) * 31;
        Parcelable r117 = this.f396172j;
        if (r117 != null) goto L13;
        int r118 = 0;
    L14:
        int r119 = (r116 + r118) * 31;
        Map<String, String> r120 = this.f396173k;
        if (r120 == null) goto L19;
        r111 = r120.hashCode();
    L19:
        return r119 + r111;
    L13:
        r118 = r117.hashCode();
        goto L14
    L9:
        r115 = r114.hashCode();
        goto L10
    L5:
        r112 = r110.hashCode();
        goto L6
    }

    public final String toString() {
        return "IntentCalling(questionId=" + this.f396163a + ", messageId=" + this.f396164b + ", actionId=" + this.f396165c + ", jobId=" + this.f396166d + ", replyFor=" + this.f396167e + ", intentName=" + this.f396168f + ", implClassName=" + this.f396169g + ", inputParamTypeName=" + this.f396170h + ", inputParams=" + this.f396171i + ", inputParamsParcel=" + this.f396172j + ", ext=" + this.f396173k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeLong(this.f396163a);
        r100.writeLong(this.f396164b);
        r100.writeLong(this.f396165c);
        r100.writeLong(this.f396166d);
        r100.writeLong(this.f396167e);
        r100.writeString(this.f396168f);
        r100.writeString(this.f396169g);
        r100.writeString(this.f396170h);
        r100.writeString(this.f396171i);
        r100.writeParcelable(this.f396172j, r101);
        Map<String, String> r102 = this.f396173k;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeValue(this.f396173k);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L7
    }
}

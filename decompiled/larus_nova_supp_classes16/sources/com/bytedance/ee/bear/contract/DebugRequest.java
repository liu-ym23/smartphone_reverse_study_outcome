package com.bytedance.ee.bear.contract;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u001b\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003Js\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0006\u0010#\u001a\u00020\u001aJ\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u001aHÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/contract/DebugRequest;", "Landroid/os/Parcelable;", "time", "", "url", "", "requestBody", "requestHeaders", "", "", "logId", "responseHeader", "response", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getTime", "()J", "getUrl", "()Ljava/lang/String;", "getRequestBody", "getRequestHeaders", "()Ljava/util/Map;", "getLogId", "getResponseHeader", "getResponse", "getResultCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "dev-tools-debug-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebugRequest implements Parcelable {
    public static final Parcelable.Creator<DebugRequest> CREATOR = null;
    public final long a;
    public final String b;
    public final String c;
    public final Map<String, List<String>> d;
    public final String e;
    public final Map<String, List<String>> f;
    public final String g;

    public static final class a implements Parcelable.Creator<DebugRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DebugRequest createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            long r2 = r12.readLong();
            String r4 = r12.readString();
            String r5 = r12.readString();
            int r0 = r12.readInt();
            LinkedHashMap r6 = new LinkedHashMap(r0);
            int r1 = 0;
            int r7 = 0;
        L3:
            if (r7 == r0) goto L5;
            r6.put(r12.readString(), r12.createStringArrayList());
            r7 = r7 + 1;
            goto L3
        L5:
            String r8 = r12.readString();
            int r3 = r12.readInt();
            LinkedHashMap r9 = new LinkedHashMap(r3);
        L6:
            String r10 = r12.readString();
            if (r1 == r3) goto L10;
            r9.put(r10, r12.createStringArrayList());
            r1 = r1 + 1;
            goto L6
        L10:
            return new DebugRequest(r2, r4, r5, r6, r8, r9, r10);
        }

        @Override // android.os.Parcelable.Creator
        public final DebugRequest[] newArray(int r1) {
            return new DebugRequest[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public DebugRequest() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DebugRequest) == true) goto L8;
        return false;
    L8:
        DebugRequest r9 = (DebugRequest) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "DebugRequest(time=" + this.a + ", url=" + this.b + ", requestBody=" + this.c + ", requestHeaders=" + this.d + ", logId=" + this.e + ", responseHeader=" + this.f + ", response=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeLong(this.a);
        r3.writeString(this.b);
        r3.writeString(this.c);
        Map<String, List<String>> r5 = this.d;
        r3.writeInt(r5.size());
        Iterator<Map.Entry<String, List<String>>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, List<String>> r0 = r6.next();
        r3.writeString(r0.getKey());
        r3.writeStringList(r0.getValue());
        goto L4
    L6:
        r3.writeString(this.e);
        Map<String, List<String>> r7 = this.f;
        r3.writeInt(r7.size());
        Iterator<Map.Entry<String, List<String>>> r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry<String, List<String>> r1 = r8.next();
        r3.writeString(r1.getKey());
        r3.writeStringList(r1.getValue());
        goto L8
    L10:
        r3.writeString(this.g);
    }

    public /* synthetic */ DebugRequest(int r10) {
        this(0, "", "", new HashMap(), "", new HashMap(), "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DebugRequest(long r2, String r4, String r5, Map<String, ? extends List<String>> r6, String r7, Map<String, ? extends List<String>> r8, String r9) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "requestBody");
        Intrinsics.checkNotNullParameter(r6, "requestHeaders");
        Intrinsics.checkNotNullParameter(r7, "logId");
        Intrinsics.checkNotNullParameter(r8, "responseHeader");
        Intrinsics.checkNotNullParameter(r9, "response");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}

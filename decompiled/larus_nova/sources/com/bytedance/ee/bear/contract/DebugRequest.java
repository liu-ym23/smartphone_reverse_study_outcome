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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u001b\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003Js\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0006\u0010#\u001a\u00020\u001aJ\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u001aHÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/contract/DebugRequest;", "Landroid/os/Parcelable;", "time", "", "url", "", "requestBody", "requestHeaders", "", "", "logId", "responseHeader", "response", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getTime", "()J", "getUrl", "()Ljava/lang/String;", "getRequestBody", "getRequestHeaders", "()Ljava/util/Map;", "getLogId", "getResponseHeader", "getResponse", "getResultCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "dev-tools-debug-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebugRequest implements Parcelable {
    public static final Parcelable.Creator<DebugRequest> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f216896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f216897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f216898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f216899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f216900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f216901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f216902g;

    public static final class a implements Parcelable.Creator<DebugRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DebugRequest createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            long r100 = r110.readLong();
            String r101 = r110.readString();
            String r102 = r110.readString();
            int r103 = r110.readInt();
            LinkedHashMap r104 = new LinkedHashMap(r103);
            int r105 = 0;
            int r106 = 0;
        L3:
            if (r106 == r103) goto L5;
            r104.put(r110.readString(), r110.createStringArrayList());
            r106 = r106 + 1;
            goto L3
        L5:
            String r107 = r110.readString();
            int r108 = r110.readInt();
            LinkedHashMap r109 = new LinkedHashMap(r108);
        L6:
            String r111 = r110.readString();
            if (r105 == r108) goto L10;
            r109.put(r111, r110.createStringArrayList());
            r105 = r105 + 1;
            goto L6
        L10:
            return new DebugRequest(r100, r101, r102, r104, r107, r109, r111);
        }

        @Override // android.os.Parcelable.Creator
        public final DebugRequest[] newArray(int r100) {
            return new DebugRequest[r100];
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DebugRequest) == true) goto L8;
        return false;
    L8:
        DebugRequest r101 = (DebugRequest) r100;
        if (this.f216896a == r101.f216896a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f216897b, r101.f216897b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f216898c, r101.f216898c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f216899d, r101.f216899d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f216900e, r101.f216900e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f216901f, r101.f216901f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f216902g, r101.f216902g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f216896a;
        return (((((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f216897b.hashCode()) * 31) + this.f216898c.hashCode()) * 31) + this.f216899d.hashCode()) * 31) + this.f216900e.hashCode()) * 31) + this.f216901f.hashCode()) * 31) + this.f216902g.hashCode();
    }

    public final String toString() {
        return "DebugRequest(time=" + this.f216896a + ", url=" + this.f216897b + ", requestBody=" + this.f216898c + ", requestHeaders=" + this.f216899d + ", logId=" + this.f216900e + ", responseHeader=" + this.f216901f + ", response=" + this.f216902g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f216896a);
        r100.writeString(this.f216897b);
        r100.writeString(this.f216898c);
        Map<String, List<String>> r102 = this.f216899d;
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, List<String>>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, List<String>> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeStringList(r104.getValue());
        goto L4
    L6:
        r100.writeString(this.f216900e);
        Map<String, List<String>> r105 = this.f216901f;
        r100.writeInt(r105.size());
        Iterator<Map.Entry<String, List<String>>> r106 = r105.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        Map.Entry<String, List<String>> r107 = r106.next();
        r100.writeString(r107.getKey());
        r100.writeStringList(r107.getValue());
        goto L8
    L10:
        r100.writeString(this.f216902g);
    }

    public /* synthetic */ DebugRequest(int r110) {
        this(0, "", "", new HashMap(), "", new HashMap(), "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DebugRequest(long r100, String r101, String r102, Map<String, ? extends List<String>> r103, String r104, Map<String, ? extends List<String>> r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "requestBody");
        Intrinsics.checkNotNullParameter(r103, "requestHeaders");
        Intrinsics.checkNotNullParameter(r104, "logId");
        Intrinsics.checkNotNullParameter(r105, "responseHeader");
        Intrinsics.checkNotNullParameter(r106, "response");
        this.f216896a = r100;
        this.f216897b = r101;
        this.f216898c = r102;
        this.f216899d = r103;
        this.f216900e = r104;
        this.f216901f = r105;
        this.f216902g = r106;
    }
}

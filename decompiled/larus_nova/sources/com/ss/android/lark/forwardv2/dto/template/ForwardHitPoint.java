package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006,"}, d2 = {"Lcom/ss/android/lark/forwardv2/dto/template/ForwardHitPoint;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "searchBehaviorKey", "", "getSearchBehaviorKey", "()Ljava/lang/String;", "setSearchBehaviorKey", "(Ljava/lang/String;)V", "basicForwardSource", "getBasicForwardSource", "setBasicForwardSource", "forwardSourceChatType", "getForwardSourceChatType", "setForwardSourceChatType", "location", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardLocation;", "getLocation", "()Lcom/ss/android/lark/forwardv2/dto/template/ForwardLocation;", "setLocation", "(Lcom/ss/android/lark/forwardv2/dto/template/ForwardLocation;)V", "callType", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardCallType;", "getCallType", "()Lcom/ss/android/lark/forwardv2/dto/template/ForwardCallType;", "setCallType", "(Lcom/ss/android/lark/forwardv2/dto/template/ForwardCallType;)V", "sourceMessageIds", "", "getSourceMessageIds", "()Ljava/util/List;", "setSourceMessageIds", "(Ljava/util/List;)V", "writeToParcel", "", "flags", "", "describeContents", "Builder", "CREATOR", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardHitPoint implements Parcelable {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f424839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f424840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f424841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ForwardLocation f424842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ForwardCallType f424843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f424844f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ForwardLocation f424845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ForwardCallType f424846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f424847c;

        /* JADX INFO: renamed from: com.ss.android.lark.forwardv2.dto.template.ForwardHitPoint$a$a, reason: collision with other inner class name */
        public static final class C5021a {
        }

        static {
        }

        public a() {
            this.f424845a = ForwardLocation.OTHER;
            this.f424846b = ForwardCallType.CLICK;
            this.f424847c = new ArrayList();
        }
    }

    public static final class b implements Parcelable.Creator<ForwardHitPoint> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardHitPoint createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardHitPoint r101 = new ForwardHitPoint();
            r101.f424839a = r100.readString();
            r101.f424840b = r100.readString();
            r101.f424841c = r100.readString();
            r101.f424844f = r100.createStringArrayList();
            String r102 = r100.readString();
            ForwardCallType r103 = null;
            if (r102 == null) goto L5;
            ForwardLocation.Companion.getClass();
            ForwardLocation r104 = ForwardLocation.a.a(r102);
        L6:
            r101.f424842d = r104;
            String r105 = r100.readString();
            if (r105 == null) goto L9;
            ForwardCallType.Companion.getClass();
            r103 = ForwardCallType.a.a(r105);
        L9:
            r101.f424843e = r103;
            return r101;
        L5:
            r104 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardHitPoint[] newArray(int r100) {
            return new ForwardHitPoint[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardHitPoint() {
        this.f424842d = ForwardLocation.OTHER;
        this.f424844f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f424839a);
        r100.writeString(this.f424840b);
        r100.writeString(this.f424841c);
        r100.writeStringList(this.f424844f);
        ForwardLocation r102 = this.f424842d;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getValue();
    L6:
        r100.writeString(r104);
        ForwardCallType r105 = this.f424843e;
        if (r105 == null) goto L9;
        r103 = r105.getValue();
    L9:
        r100.writeString(r103);
        return;
    L5:
        r104 = null;
        goto L6
    }
}

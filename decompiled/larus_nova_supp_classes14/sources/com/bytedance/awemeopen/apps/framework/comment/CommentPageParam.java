package com.bytedance.awemeopen.apps.framework.comment;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "Landroid/os/Parcelable;", "<init>", "()V", "CREATOR", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentPageParam implements Parcelable {
    public static final a CREATOR = null;
    public String a;
    public String b;
    public boolean c;
    public long d;
    public Integer e;
    public Integer f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public JSONObject l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public String s;
    public boolean t;
    public int u;
    public Map<String, Object> v;

    public static final class a implements Parcelable.Creator<CommentPageParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentPageParam createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            Intrinsics.checkNotNullParameter(r9, "parcel");
            CommentPageParam r1 = new CommentPageParam();
            String r0 = r9.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.a = r0;
            boolean r3 = true;
            if (r9.readByte() == 0) goto L8;
            boolean r4 = true;
        L9:
            r1.c = r4;
            r1.d = r9.readLong();
            Class r5 = Integer.TYPE;
            Object r6 = r9.readValue(r5.getClassLoader());
            Map<String, Object> r7 = null;
            if ((r6 instanceof Integer) == false) goto L12;
            Integer r8 = (Integer) r6;
        L13:
            r1.e = r8;
            Object r10 = r9.readValue(r5.getClassLoader());
            if ((r10 instanceof Integer) == false) goto L16;
            Integer r11 = (Integer) r10;
        L17:
            r1.f = r11;
            String r12 = r9.readString();
            if (r12 != null) goto L20;
            r12 = "";
        L20:
            r1.g = r12;
            String r13 = r9.readString();
            if (r13 != null) goto L23;
            r13 = "";
        L23:
            r1.h = r13;
            String r14 = r9.readString();
            if (r14 != null) goto L26;
            r14 = "";
        L26:
            r1.i = r14;
            String r15 = r9.readString();
            if (r15 != null) goto L29;
            r15 = "";
        L29:
            r1.j = r15;
            String r16 = r9.readString();
            if (r16 != null) goto L32;
            r16 = "";
        L32:
            r1.k = r16;
            String r17 = r9.readString();
            if (r17 != null) goto L35;
            r17 = "";
        L35:
            r1.l = new JSONObject(r17);
            r1.m = r9.readInt();
            if (r9.readByte() == 0) goto L38;
            boolean r18 = true;
        L39:
            r1.n = r18;
            if (r9.readByte() == 0) goto L42;
            boolean r19 = true;
        L43:
            r1.p = r19;
            if (r9.readByte() == 0) goto L46;
            boolean r20 = true;
        L47:
            r1.q = r20;
            String r21 = r9.readString();
            if (r21 != null) goto L50;
            r21 = "";
        L50:
            r1.r = r21;
            String r22 = r9.readString();
            if (r22 == null) goto L54;
            r2 = r22;
        L54:
            r1.s = r2;
            if (r9.readByte() != 0) goto L58;
            r3 = false;
        L58:
            r1.t = r3;
            r1.u = r9.readInt();
            Object r23 = r9.readValue(Map.class.getClassLoader());
            if (TypeIntrinsics.isMutableMap(r23) == false) goto L61;
            r7 = (Map) r23;
        L61:
            r1.v = r7;
            return r1;
        L46:
            r20 = false;
            goto L47
        L42:
            r19 = false;
            goto L43
        L38:
            r18 = false;
            goto L39
        L16:
            r11 = null;
            goto L17
        L12:
            r8 = null;
            goto L13
        L8:
            r4 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final CommentPageParam[] newArray(int r1) {
            return new CommentPageParam[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public CommentPageParam() {
        this.a = "";
        this.b = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = new JSONObject();
        this.r = "";
        this.s = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.a);
        r3.writeByte(this.c ? 1 : 0);
        r3.writeLong(this.d);
        r3.writeValue(this.e);
        r3.writeValue(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeString(this.i);
        r3.writeString(this.j);
        r3.writeString(this.k);
        r3.writeString(this.l.toString());
        r3.writeInt(this.m);
        r3.writeByte(this.n ? 1 : 0);
        r3.writeByte(this.p ? 1 : 0);
        r3.writeByte(this.q ? 1 : 0);
        r3.writeString(this.r);
        r3.writeString(this.s);
        r3.writeByte(this.t ? 1 : 0);
        r3.writeInt(this.u);
        Map<String, Object> r5 = this.v;
        if (r5 == null) goto L6;
        r3.writeValue(r5);
        return;
    }
}

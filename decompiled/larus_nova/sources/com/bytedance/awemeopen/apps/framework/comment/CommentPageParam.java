package com.bytedance.awemeopen.apps.framework.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "Landroid/os/Parcelable;", "<init>", "()V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentPageParam implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f194075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f194076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f194077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f194078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f194079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f194080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f194081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f194082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f194083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f194084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f194085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONObject f194086l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f194087m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f194088n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f194089o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f194090p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f194091q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f194092r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f194093s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f194094t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f194095u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map<String, Object> f194096v;

    public static final class a implements Parcelable.Creator<CommentPageParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentPageParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            CommentPageParam r101 = new CommentPageParam();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f194075a = r102;
            boolean r104 = true;
            if (r100.readByte() == 0) goto L8;
            boolean r105 = true;
        L9:
            r101.f194077c = r105;
            r101.f194078d = r100.readLong();
            Class r106 = Integer.TYPE;
            Object r107 = r100.readValue(r106.getClassLoader());
            Map<String, Object> r108 = null;
            if ((r107 instanceof Integer) == false) goto L12;
            Integer r109 = (Integer) r107;
        L13:
            r101.f194079e = r109;
            Object r110 = r100.readValue(r106.getClassLoader());
            if ((r110 instanceof Integer) == false) goto L16;
            Integer r111 = (Integer) r110;
        L17:
            r101.f194080f = r111;
            String r112 = r100.readString();
            if (r112 != null) goto L20;
            r112 = "";
        L20:
            r101.f194081g = r112;
            String r113 = r100.readString();
            if (r113 != null) goto L23;
            r113 = "";
        L23:
            r101.f194082h = r113;
            String r114 = r100.readString();
            if (r114 != null) goto L26;
            r114 = "";
        L26:
            r101.f194083i = r114;
            String r115 = r100.readString();
            if (r115 != null) goto L29;
            r115 = "";
        L29:
            r101.f194084j = r115;
            String r116 = r100.readString();
            if (r116 != null) goto L32;
            r116 = "";
        L32:
            r101.f194085k = r116;
            String r117 = r100.readString();
            if (r117 != null) goto L35;
            r117 = "";
        L35:
            r101.f194086l = new JSONObject(r117);
            r101.f194087m = r100.readInt();
            if (r100.readByte() == 0) goto L38;
            boolean r118 = true;
        L39:
            r101.f194088n = r118;
            if (r100.readByte() == 0) goto L42;
            boolean r119 = true;
        L43:
            r101.f194090p = r119;
            if (r100.readByte() == 0) goto L46;
            boolean r120 = true;
        L47:
            r101.f194091q = r120;
            String r121 = r100.readString();
            if (r121 != null) goto L50;
            r121 = "";
        L50:
            r101.f194092r = r121;
            String r122 = r100.readString();
            if (r122 == null) goto L54;
            r103 = r122;
        L54:
            r101.f194093s = r103;
            if (r100.readByte() != 0) goto L58;
            r104 = false;
        L58:
            r101.f194094t = r104;
            r101.f194095u = r100.readInt();
            Object r123 = r100.readValue(Map.class.getClassLoader());
            if (TypeIntrinsics.isMutableMap(r123) == false) goto L61;
            r108 = (Map) r123;
        L61:
            r101.f194096v = r108;
            return r101;
        L46:
            r120 = false;
            goto L47
        L42:
            r119 = false;
            goto L43
        L38:
            r118 = false;
            goto L39
        L16:
            r111 = null;
            goto L17
        L12:
            r109 = null;
            goto L13
        L8:
            r105 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final CommentPageParam[] newArray(int r100) {
            return new CommentPageParam[r100];
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
        this.f194075a = "";
        this.f194076b = "";
        this.f194081g = "";
        this.f194082h = "";
        this.f194083i = "";
        this.f194084j = "";
        this.f194085k = "";
        this.f194086l = new JSONObject();
        this.f194092r = "";
        this.f194093s = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f194075a);
        r100.writeByte(this.f194077c ? 1 : 0);
        r100.writeLong(this.f194078d);
        r100.writeValue(this.f194079e);
        r100.writeValue(this.f194080f);
        r100.writeString(this.f194081g);
        r100.writeString(this.f194082h);
        r100.writeString(this.f194083i);
        r100.writeString(this.f194084j);
        r100.writeString(this.f194085k);
        r100.writeString(this.f194086l.toString());
        r100.writeInt(this.f194087m);
        r100.writeByte(this.f194088n ? 1 : 0);
        r100.writeByte(this.f194090p ? 1 : 0);
        r100.writeByte(this.f194091q ? 1 : 0);
        r100.writeString(this.f194092r);
        r100.writeString(this.f194093s);
        r100.writeByte(this.f194094t ? 1 : 0);
        r100.writeInt(this.f194095u);
        Map<String, Object> r102 = this.f194096v;
        if (r102 == null) goto L6;
        r100.writeValue(r102);
        return;
    }
}

package d11;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f466274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f466275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f466276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f466277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f466278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f466279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f466280h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L22;
        c r101 = (c) r100;
        if (this.f466273a == r101.f466273a) goto L8;
        return false;
    L8:
        if (this.f466274b == r101.f466274b) goto L10;
        return false;
    L10:
        if (this.f466275c == r101.f466275c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f466276d, r101.f466276d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f466277e, r101.f466277e) == true) goto L16;
        return false;
    L16:
        if (this.f466278f == r101.f466278f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f466279g, r101.f466279g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f466280h, r101.f466280h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f466273a * 31;
        long r101 = this.f466274b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f466275c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f466276d;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f466277e;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (((r108 + r110) * 31) + this.f466278f) * 31;
        String r112 = this.f466279g;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f466280h;
        if (r115 == null) goto L18;
        r106 = r115.hashCode();
    L18:
        return r114 + r106;
    L13:
        r113 = 0;
        goto L14
    L9:
        r110 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }

    public final String toString() {
        return "CancelParams(scene=" + this.f466273a + ", channelId=" + this.f466274b + ", toRoomId=" + this.f466275c + ", toUserId=" + this.f466276d + ", secToUserId=" + this.f466277e + ", cancelType=" + this.f466278f + ", reqSrc=" + this.f466279g + ", inviteeUserIds=" + this.f466280h + ")";
    }

    public final i a() {
        Class<?> r100 = ((JsonAdapter) i.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r101 = vh7.b.f554981a;
        Constructor r102 = r101.get(r100);
        if (r102 != null) goto L12;
        r102 = r100.getConstructor(new Class[0]);
        if (r102 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r103 = r101.putIfAbsent(r100, (Constructor<? extends SerializableObjectJsonAdapterBase>) r102);
        if (r103 == null) goto L12;
        r102 = r103;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r104 = ((SerializableObjectJsonAdapterBase) r102.newInstance(new Object[0])).createInstance();
        if (r104 == null) goto L24;
        i r105 = (i) r104;
        r105.setChannelId(this.f466274b);
        r105.f(this.f466275c);
        String r106 = this.f466276d;
        String r107 = "";
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r105.setToOpenId(r106);
        String r108 = this.f466277e;
        if (r108 == null) goto L21;
        r107 = r108;
    L21:
        r105.g(r107);
        r105.setScene(this.f466273a);
        r105.n0(this.f466278f);
        r105.J2(this.f466279g);
        return r105;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerCancelParams");
    }

    public c(int r110, long r111, long r112, String r113, String r114, int r210, String r211) {
        Intrinsics.checkNotNullParameter(r211, "reqSrc");
        this(r110, r111, r112, r113, r114, r210, r211, null);
    }

    public c(int r100, long r101, long r102, String r103, String r104, int r105, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "reqSrc");
        this.f466273a = r100;
        this.f466274b = r101;
        this.f466275c = r102;
        this.f466276d = r103;
        this.f466277e = r104;
        this.f466278f = r105;
        this.f466279g = r110;
        this.f466280h = r111;
    }
}

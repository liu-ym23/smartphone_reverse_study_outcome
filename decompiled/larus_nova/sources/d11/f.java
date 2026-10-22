package d11;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f466315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f466317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f466318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f466319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f466320g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L20;
        f r101 = (f) r100;
        if (this.f466314a == r101.f466314a) goto L8;
        return false;
    L8:
        if (this.f466315b == r101.f466315b) goto L10;
        return false;
    L10:
        if (this.f466316c == r101.f466316c) goto L12;
        return false;
    L12:
        if (this.f466317d == r101.f466317d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f466318e, r101.f466318e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f466319f, r101.f466319f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f466320g, r101.f466320g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f466314a * 31;
        long r101 = this.f466315b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f466316c) * 31;
        long r103 = this.f466317d;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f466318e;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f466319f;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f466320g;
        if (r112 == null) goto L14;
        r106 = r112.hashCode();
    L14:
        return r111 + r106;
    L9:
        r110 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }

    public final String toString() {
        return "PermitParams(scene=" + this.f466314a + ", channelId=" + this.f466315b + ", permitStatus=" + this.f466316c + ", roomId=" + this.f466317d + ", applyUserId=" + this.f466318e + ", applyAnchorSecId=" + this.f466319f + ", applyFromInteractId=" + this.f466320g + ")";
    }

    public final k a() {
        Class<?> r100 = ((JsonAdapter) k.class.getAnnotation(JsonAdapter.class)).value();
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
        k r105 = (k) r104;
        r105.setChannelId(this.f466315b);
        r105.l7(this.f466316c);
        r105.setRoomId(this.f466317d);
        String r106 = this.f466318e;
        String r107 = "";
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r105.k4(r106);
        String r108 = this.f466319f;
        if (r108 == null) goto L21;
        r107 = r108;
    L21:
        r105.D6(r107);
        r105.setScene(this.f466314a);
        return r105;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerPermitParams");
    }

    public f(int r100, long r101, int r102, long r103, String r104, String r105, String r106) {
        this.f466314a = r100;
        this.f466315b = r101;
        this.f466316c = r102;
        this.f466317d = r103;
        this.f466318e = r104;
        this.f466319f = r105;
        this.f466320g = r106;
    }
}

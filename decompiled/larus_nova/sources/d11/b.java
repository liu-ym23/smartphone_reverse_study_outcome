package d11;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f466264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f466265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f466266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f466267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f466268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f466269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IRoom f466270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f466271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f466272j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L26;
        b r101 = (b) r100;
        if (this.f466263a == r101.f466263a) goto L8;
        return false;
    L8:
        if (this.f466264b == r101.f466264b) goto L10;
        return false;
    L10:
        if (this.f466265c == r101.f466265c) goto L12;
        return false;
    L12:
        if (this.f466266d == r101.f466266d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f466267e, r101.f466267e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f466268f, r101.f466268f) == true) goto L18;
        return false;
    L18:
        if (this.f466269g == r101.f466269g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f466270h, r101.f466270h) == true) goto L22;
        return false;
    L22:
        if (this.f466271i == r101.f466271i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f466272j, r101.f466272j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f466263a * 31;
        long r101 = this.f466264b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f466265c;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f466266d) * 31;
        String r105 = this.f466267e;
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.hashCode();
    L6:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f466268f;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        long r111 = this.f466269g;
        int r112 = (((r108 + r110) * 31) + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        IRoom r113 = this.f466270h;
        if (r113 == null) goto L13;
        int r114 = r113.hashCode();
    L14:
        int r115 = (((r112 + r114) * 31) + this.f466271i) * 31;
        String r116 = this.f466272j;
        if (r116 == null) goto L18;
        r106 = r116.hashCode();
    L18:
        return r115 + r106;
    L13:
        r114 = 0;
        goto L14
    L9:
        r110 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }

    public final String toString() {
        return "ApplyParams(scene=" + this.f466263a + ", roomId=" + this.f466264b + ", toRoomId=" + this.f466265c + ", applyType=" + this.f466266d + ", secToUserId=" + this.f466267e + ", toUserId=" + this.f466268f + ", channelId=" + this.f466269g + ", targetRoom=" + this.f466270h + ", applyIndex=" + this.f466271i + ", clientAttachedInfo=" + this.f466272j + ")";
    }

    public final h a() {
        Class<?> r100 = ((JsonAdapter) h.class.getAnnotation(JsonAdapter.class)).value();
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
        if (r104 == null) goto L20;
        h r105 = (h) r104;
        r105.setRoomId(this.f466264b);
        r105.f(this.f466265c);
        String r106 = this.f466268f;
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r105.setToOpenId(r106);
        r105.g(this.f466267e);
        r105.X3(this.f466266d);
        r105.setScene(this.f466263a);
        r105.setChannelId(this.f466269g);
        r105.h(this.f466272j);
        return r105;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenuelink.connect.params.ServerApplyParams");
    }

    public b(int r100, long r101, long r102, int r103, String r104, String r105, long r110, IRoom r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r104, "secToUserId");
        Intrinsics.checkNotNullParameter(r105, "toUserId");
        Intrinsics.checkNotNullParameter(r111, "targetRoom");
        Intrinsics.checkNotNullParameter(r113, "clientAttachedInfo");
        this.f466263a = r100;
        this.f466264b = r101;
        this.f466265c = r102;
        this.f466266d = r103;
        this.f466267e = r104;
        this.f466268f = r105;
        this.f466269g = r110;
        this.f466270h = r111;
        this.f466271i = r112;
        this.f466272j = r113;
    }
}

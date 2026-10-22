package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import m0a.n;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00060\u0001j\u0002`\u0002:\u000256B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB=\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J1\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\"\u001a\u00020\u0004J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0004J%\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R,\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00067"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationModelKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "dataType", "", "creationList", "", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "modelId", "", "<init>", "(ILjava/util/List;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDataType$annotations", "()V", "getDataType", "()I", "getCreationList$annotations", "getCreationList", "()Ljava/util/List;", "setCreationList", "(Ljava/util/List;)V", "getModelId$annotations", "getModelId", "()Ljava/lang/String;", "setModelId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UserCreationModelKmp implements Parcelable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationModelKmp> CREATOR = null;
    public static final b Companion = null;
    private List<UserCreationKmp> creationList;
    private final int dataType;
    private String modelId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationModelKmp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f374358a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f374359b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f374359b;
        }

        static {
            a r100 = new a();
            f374358a = r100;
            g2 r101 = new g2("com.larus.ugc.feed.api.model.UserCreationModelKmp", r100, 3);
            r101.j("data_type", true);
            r101.j("creation_list", true);
            r101.j("model_id", true);
            f374359b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{w0.f520792a, kuc.a.d((d) UserCreationModelKmp.access$get$childSerializers$cp()[1].getValue()), kuc.a.d(v2.f520790a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f374359b;
            muc.c r101 = r110.beginStructure(r100);
            Lazy[] r102 = UserCreationModelKmp.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            int r103 = r101.decodeIntElement(r100, 0);
            List r111 = (List) r101.decodeNullableSerializableElement(r100, 1, (juc.c) r102[1].getValue(), null);
            int r112 = r103;
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, null);
            int r114 = 7;
        L19:
            r101.endStructure(r100);
            return new UserCreationModelKmp(r114, r112, r111, r113, null);
        L5:
            List r104 = null;
            String r105 = null;
            int r106 = 0;
            int r107 = 0;
            boolean r115 = true;
        L6:
            if (r115 == false) goto L18;
            int r116 = r101.decodeElementIndex(r100);
            if (r116 != (-1)) goto L9;
            r115 = false;
            goto L6
        L9:
            if (r116 != 0) goto L10;
            r106 = r101.decodeIntElement(r100, 0);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r116 != 1) goto L11;
            r104 = (List) r101.decodeNullableSerializableElement(r100, 1, (juc.c) r102[1].getValue(), r104);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r116 != 2) goto L14;
            r105 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r105);
            r107 = r107 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r116);
        L18:
            r112 = r106;
            r114 = r107;
            r111 = r104;
            r113 = r105;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            UserCreationModelKmp r102 = (UserCreationModelKmp) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f374359b;
            muc.d r104 = r100.beginStructure(r103);
            UserCreationModelKmp.write$Self$feed_kmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationModelKmp> serializer() {
            return a.f374358a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationModelKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationModelKmp createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            if (r100.readInt() != 0) goto L5;
            ArrayList r102 = null;
        L10:
            return new UserCreationModelKmp(r101, r102, r100.readString());
        L5:
            int r103 = r100.readInt();
            ArrayList r104 = new ArrayList(r103);
            int r105 = 0;
        L6:
            if (r105 == r103) goto L8;
            r104.add(UserCreationKmp.CREATOR.createFromParcel(r100));
            r105 = r105 + 1;
            goto L6
        L8:
            r102 = r104;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationModelKmp[] newArray(int r100) {
            return new UserCreationModelKmp[r100];
        }
    }

    public UserCreationModelKmp() {
        this(0, null, null, 7, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(UserCreationKmp.a.f374356a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserCreationModelKmp copy$default(UserCreationModelKmp r100, int r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.dataType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.creationList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.modelId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("creation_list")
    public static /* synthetic */ void getCreationList$annotations() {
    }

    @SerialName("data_type")
    public static /* synthetic */ void getDataType$annotations() {
    }

    @SerialName("model_id")
    public static /* synthetic */ void getModelId$annotations() {
    }

    public final int component1() {
        return this.dataType;
    }

    public final List<UserCreationKmp> component2() {
        return this.creationList;
    }

    public final String component3() {
        return this.modelId;
    }

    public final UserCreationModelKmp copy(int r100, List<UserCreationKmp> r101, String r102) {
        return new UserCreationModelKmp(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserCreationModelKmp) == true) goto L8;
        return false;
    L8:
        UserCreationModelKmp r101 = (UserCreationModelKmp) r100;
        if (this.dataType == r101.dataType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationList, r101.creationList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelId, r101.modelId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.dataType * 31;
        List<UserCreationKmp> r101 = this.creationList;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.modelId;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "UserCreationModelKmp(dataType=" + this.dataType + ", creationList=" + this.creationList + ", modelId=" + this.modelId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.dataType);
        List<UserCreationKmp> r102 = this.creationList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeString(this.modelId);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<UserCreationKmp> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().writeToParcel(r100, r101);
        goto L7
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
        $childSerializers = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new n()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final List<UserCreationKmp> getCreationList() {
        return this.creationList;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final void setCreationList(List<UserCreationKmp> r100) {
        this.creationList = r100;
    }

    public final void setModelId(String r100) {
        this.modelId = r100;
    }

    public UserCreationModelKmp(int r100, List<UserCreationKmp> r101, String r102) {
        this.dataType = r100;
        this.creationList = r101;
        this.modelId = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationModelKmp r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.dataType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, r103[1].getValue(), r100.creationList);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r104 = true;
    L26:
        if (r104 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.modelId);
        return;
    L29:
        return;
    L24:
        if (Intrinsics.areEqual(r100.modelId, "") == true) goto L26;
    L15:
        if (Intrinsics.areEqual(r100.creationList, new ArrayList()) == false) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.dataType != 0) goto L4;
        r105 = false;
        goto L9
    }

    public UserCreationModelKmp(int r100, int r101, List r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f374359b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.dataType = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.creationList = new ArrayList();
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.modelId = "";
        return;
    L15:
        this.modelId = r103;
        return;
    L11:
        this.creationList = r102;
        goto L13
    L7:
        this.dataType = r101;
        goto L9
    }

    public /* synthetic */ UserCreationModelKmp(int r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}

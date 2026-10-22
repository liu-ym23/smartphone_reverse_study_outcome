package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00060\u0001j\u0002`\u0002:\u000212B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u00063"}, d2 = {"Lcom/larus/im/bean/message/SendFile;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "localResPath", "", "fileName", "tosKey", "resourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLocalResPath$annotations", "()V", "getLocalResPath", "()Ljava/lang/String;", "setLocalResPath", "(Ljava/lang/String;)V", "getFileName$annotations", "getFileName", "setFileName", "getTosKey$annotations", "getTosKey", "setTosKey", "getResourceId$annotations", "getResourceId", "setResourceId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SendFile implements java.io.Serializable {
    public static final b Companion = null;
    private String fileName;
    private String localResPath;
    private String resourceId;
    private String tosKey;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SendFile> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346715a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346716b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346716b;
        }

        static {
            a r100 = new a();
            f346715a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.SendFile", r100, 4);
            r101.j("local_res_path", true);
            r101.j("file_name", true);
            r101.j("key", true);
            r101.j("resource_id", true);
            f346716b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346716b;
            muc.c r101 = r210.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            String r111 = r106;
            String r112 = r104;
            String r113 = r105;
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new SendFile(r114, r112, r113, r111, r110, null);
        L5:
            String r107 = null;
            String r108 = null;
            String r115 = null;
            int r109 = 0;
            boolean r116 = true;
        L6:
            if (r116 == false) goto L20;
            int r117 = r101.decodeElementIndex(r100);
            if (r117 != (-1)) goto L9;
            r116 = false;
            goto L6
        L9:
            if (r117 != 0) goto L10;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r117 != 1) goto L11;
            r107 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r117 != 2) goto L12;
            r108 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r108);
            r109 = r109 | 4;
            goto L6
        L12:
            if (r117 != 3) goto L15;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r115);
            r109 = r109 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r117);
        L20:
            r114 = r109;
            r112 = r102;
            r113 = r107;
            r111 = r108;
            r110 = r115;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SendFile r102 = (SendFile) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346716b;
            muc.d r104 = r100.beginStructure(r103);
            SendFile.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SendFile> serializer() {
            return a.f346715a;
        }
    }

    public SendFile() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SendFile copy$default(SendFile r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.localResPath;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.fileName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.tosKey;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.resourceId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("file_name")
    public static /* synthetic */ void getFileName$annotations() {
    }

    @SerialName("local_res_path")
    public static /* synthetic */ void getLocalResPath$annotations() {
    }

    @SerialName("resource_id")
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("key")
    public static /* synthetic */ void getTosKey$annotations() {
    }

    public final String component1() {
        return this.localResPath;
    }

    public final String component2() {
        return this.fileName;
    }

    public final String component3() {
        return this.tosKey;
    }

    public final String component4() {
        return this.resourceId;
    }

    public final SendFile copy(String r100, String r101, String r102, String r103) {
        return new SendFile(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendFile) == true) goto L8;
        return false;
    L8:
        SendFile r101 = (SendFile) r100;
        if (Intrinsics.areEqual(this.localResPath, r101.localResPath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tosKey, r101.tosKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.localResPath;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.fileName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tosKey;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.resourceId;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SendFile(localResPath=" + this.localResPath + ", fileName=" + this.fileName + ", tosKey=" + this.tosKey + ", resourceId=" + this.resourceId + ')';
    }

    static {
        Companion = new b();
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getLocalResPath() {
        return this.localResPath;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setLocalResPath(String r100) {
        this.localResPath = r100;
    }

    public final void setResourceId(String r100) {
        this.resourceId = r100;
    }

    public final void setTosKey(String r100) {
        this.tosKey = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(SendFile r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.localResPath);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.fileName);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.tosKey);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.resourceId);
        return;
    L38:
        return;
    L33:
        if (r100.resourceId == null) goto L35;
    L24:
        if (r100.tosKey != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.fileName != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.localResPath != null) goto L4;
        r104 = false;
        goto L9
    }

    public SendFile(String r100, String r101, String r102, String r103) {
        this.localResPath = r100;
        this.fileName = r101;
        this.tosKey = r102;
        this.resourceId = r103;
    }

    public SendFile(int r100, String r101, String r102, String r103, String r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346716b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.localResPath = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.fileName = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.tosKey = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.resourceId = null;
        return;
    L19:
        this.resourceId = r104;
        return;
    L15:
        this.tosKey = r103;
        goto L17
    L11:
        this.fileName = r102;
        goto L13
    L7:
        this.localResPath = r101;
        goto L9
    }

    public /* synthetic */ SendFile(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}

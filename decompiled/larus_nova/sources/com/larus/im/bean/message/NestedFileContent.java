package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import ouc.v;
import yc9.n0;
import yc9.o0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00060\u0001j\u0002`\u0002:\u0002:;BG\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBS\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\b\u0010(\u001a\u00020\u0007H\u0016J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u0017\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bHÆ\u0003JI\u0010-\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bHÆ\u0001J\u0013\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u000fHÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R,\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R2\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/larus/im/bean/message/NestedFileContent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "entities", "", "Lcom/larus/im/bean/message/UplinkFileEntity;", "text", "", "hasGetFileState", "", "fileExt", "", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLjava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;ZLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEntities$annotations", "()V", "getEntities", "()Ljava/util/List;", "setEntities", "(Ljava/util/List;)V", "getText$annotations", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getHasGetFileState$annotations", "getHasGetFileState", "()Z", "setHasGetFileState", "(Z)V", "getFileExt$annotations", "getFileExt", "()Ljava/util/Map;", "setFileExt", "(Ljava/util/Map;)V", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class NestedFileContent implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<UplinkFileEntity> entities;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private Map<String, String> fileExt;
    private boolean hasGetFileState;
    private String text;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<NestedFileContent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346692a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346693b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346693b;
        }

        static {
            a r100 = new a();
            f346692a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.NestedFileContent", r100, 4);
            r101.j("entities", true);
            r101.j("text", true);
            r101.j("has_get_file_state", true);
            r101.j("file_content_ext", true);
            f346693b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = NestedFileContent.access$get$childSerializers$cp();
            return new d[]{kuc.a.d((d) r100[0].getValue()), kuc.a.d(v2.f520790a), i.f520705a, kuc.a.d((d) r100[3].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346693b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = NestedFileContent.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            List r103 = (List) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            boolean r105 = r101.decodeBooleanElement(r100, 2);
            Map r110 = (Map) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), null);
            List r111 = r103;
            boolean r112 = r105;
            String r113 = r104;
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new NestedFileContent(r114, r111, r113, r112, r110, null);
        L5:
            List r106 = null;
            String r115 = null;
            Map r116 = null;
            boolean r107 = false;
            int r108 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r106 = (List) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), r106);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r115);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r107 = r101.decodeBooleanElement(r100, 2);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (Map) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r112 = r107;
            r114 = r108;
            r111 = r106;
            r113 = r115;
            r110 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            NestedFileContent r102 = (NestedFileContent) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346693b;
            muc.d r104 = r100.beginStructure(r103);
            NestedFileContent.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<NestedFileContent> serializer() {
            return a.f346692a;
        }
    }

    public NestedFileContent() {
        this(null, null, false, null, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(UplinkFileEntity.a.f346738a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$2() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NestedFileContent copy$default(NestedFileContent r100, List r101, String r102, boolean r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.entities;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.text;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.hasGetFileState;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.fileExt;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("entities")
    public static /* synthetic */ void getEntities$annotations() {
    }

    @SerialName("file_content_ext")
    public static /* synthetic */ void getFileExt$annotations() {
    }

    @SerialName("has_get_file_state")
    public static /* synthetic */ void getHasGetFileState$annotations() {
    }

    @SerialName("text")
    public static /* synthetic */ void getText$annotations() {
    }

    public final List<UplinkFileEntity> component1() {
        return this.entities;
    }

    public final String component2() {
        return this.text;
    }

    public final boolean component3() {
        return this.hasGetFileState;
    }

    public final Map<String, String> component4() {
        return this.fileExt;
    }

    public final NestedFileContent copy(List<UplinkFileEntity> r100, String r101, boolean r102, Map<String, String> r103) {
        return new NestedFileContent(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NestedFileContent) == true) goto L8;
        return false;
    L8:
        NestedFileContent r101 = (NestedFileContent) r100;
        if (Intrinsics.areEqual(this.entities, r101.entities) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (this.hasGetFileState == r101.hasGetFileState) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileExt, r101.fileExt) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<UplinkFileEntity> r100 = this.entities;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.hasGetFileState == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        Map<String, String> r109 = this.fileExt;
        if (r109 == null) goto L19;
        r101 = r109.hashCode();
    L19:
        return r108 + r101;
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{LazyKt.lazy(r100, new n0()), null, null, LazyKt.lazy(r100, new o0())};
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        v r101 = xt7.d.f565073b;     // Catch: Throwable -> L4
        r101.getClass();     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(r101.a(Companion.serializer(), this));     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L12;
        com.larus.im.internal.delegate.a.f348188b.e("NestedFileContent", "convert2Json failed, stack: " + ExceptionsKt.stackTraceToString(r103));
    L12:
        if (Result.m9455isFailureimpl(r102) == false) goto L14;
        r102 = null;
    L14:
        String r104 = (String) r102;
        if (r104 != null) goto L20;
        return "";
    L20:
        return r104;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final List<UplinkFileEntity> getEntities() {
        return this.entities;
    }

    public final Map<String, String> getFileExt() {
        return this.fileExt;
    }

    public final boolean getHasGetFileState() {
        return this.hasGetFileState;
    }

    public final String getText() {
        return this.text;
    }

    public final void setEntities(List<UplinkFileEntity> r100) {
        this.entities = r100;
    }

    public final void setFileExt(Map<String, String> r100) {
        this.fileExt = r100;
    }

    public final void setHasGetFileState(boolean r100) {
        this.hasGetFileState = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(NestedFileContent r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.entities);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.text);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeBooleanElement(r102, 2, r100.hasGetFileState);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r104 = true;
    L35:
        if (r104 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.fileExt);
        return;
    L38:
        return;
    L33:
        if (Intrinsics.areEqual(r100.fileExt, new LinkedHashMap()) == true) goto L35;
    L24:
        if (r100.hasGetFileState == true) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.text != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.entities != null) goto L4;
        r105 = false;
        goto L9
    }

    public NestedFileContent(List<UplinkFileEntity> r100, String r101, boolean r102, Map<String, String> r103) {
        this.entities = r100;
        this.text = r101;
        this.hasGetFileState = r102;
        this.fileExt = r103;
    }

    public NestedFileContent(int r100, List r101, String r102, boolean r103, Map r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346693b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.entities = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.text = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.hasGetFileState = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.fileExt = new LinkedHashMap();
        return;
    L19:
        this.fileExt = r104;
        return;
    L15:
        this.hasGetFileState = r103;
        goto L17
    L11:
        this.text = r102;
        goto L13
    L7:
        this.entities = r101;
        goto L9
    }

    public /* synthetic */ NestedFileContent(List r100, String r101, boolean r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new LinkedHashMap();
    L14:
        this(r100, r101, r102, r103);
    }
}

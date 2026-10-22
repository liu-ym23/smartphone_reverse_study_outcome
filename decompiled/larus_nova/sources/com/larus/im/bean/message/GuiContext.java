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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002*+B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/larus/im/bean/message/GuiContext;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "artifactType", "", "uri", "view", "Lcom/larus/im/bean/message/GuiView;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/GuiView;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/GuiView;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArtifactType$annotations", "()V", "getArtifactType", "()Ljava/lang/String;", "getUri$annotations", "getUri", "getView$annotations", "getView", "()Lcom/larus/im/bean/message/GuiView;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class GuiContext implements java.io.Serializable {
    public static final b Companion = null;
    private final String artifactType;
    private final String uri;
    private final GuiView view;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<GuiContext> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346637a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346638b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(GuiView.a.f346639a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346638b;
        }

        static {
            a r100 = new a();
            f346637a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.GuiContext", r100, 3);
            r101.j("artifact_type", true);
            r101.j("uri", true);
            r101.j("view", true);
            f346638b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346638b;
            muc.c r101 = r110.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            GuiView r112 = (GuiView) r101.decodeNullableSerializableElement(r100, 2, GuiView.a.f346639a, null);
            String r113 = r104;
            int r114 = 7;
        L19:
            r101.endStructure(r100);
            return new GuiContext(r114, r113, r111, r112, null);
        L5:
            String r105 = null;
            GuiView r106 = null;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L18;
            int r115 = r101.decodeElementIndex(r100);
            if (r115 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r115 != 0) goto L10;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r115 != 1) goto L11;
            r105 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r105);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r115 != 2) goto L14;
            r106 = (GuiView) r101.decodeNullableSerializableElement(r100, 2, GuiView.a.f346639a, r106);
            r107 = r107 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r115);
        L18:
            r114 = r107;
            r113 = r102;
            r111 = r105;
            r112 = r106;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            GuiContext r102 = (GuiContext) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346638b;
            muc.d r104 = r100.beginStructure(r103);
            GuiContext.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<GuiContext> serializer() {
            return a.f346637a;
        }
    }

    public GuiContext() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GuiContext copy$default(GuiContext r100, String r101, String r102, GuiView r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.artifactType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.uri;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.view;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("artifact_type")
    public static /* synthetic */ void getArtifactType$annotations() {
    }

    @SerialName("uri")
    public static /* synthetic */ void getUri$annotations() {
    }

    @SerialName("view")
    public static /* synthetic */ void getView$annotations() {
    }

    public final String component1() {
        return this.artifactType;
    }

    public final String component2() {
        return this.uri;
    }

    public final GuiView component3() {
        return this.view;
    }

    public final GuiContext copy(String r100, String r101, GuiView r102) {
        return new GuiContext(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GuiContext) == true) goto L8;
        return false;
    L8:
        GuiContext r101 = (GuiContext) r100;
        if (Intrinsics.areEqual(this.artifactType, r101.artifactType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.artifactType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uri;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        GuiView r107 = this.view;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GuiContext(artifactType=" + this.artifactType + ", uri=" + this.uri + ", view=" + this.view + ')';
    }

    static {
        Companion = new b();
    }

    public final String getArtifactType() {
        return this.artifactType;
    }

    public final String getUri() {
        return this.uri;
    }

    public final GuiView getView() {
        return this.view;
    }

    public GuiContext(String r100, String r101, GuiView r102) {
        this.artifactType = r100;
        this.uri = r101;
        this.view = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(GuiContext r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.artifactType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.uri);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, GuiView.a.f346639a, r100.view);
        return;
    L29:
        return;
    L24:
        if (r100.view == null) goto L26;
    L15:
        if (r100.uri != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.artifactType != null) goto L4;
        r104 = false;
        goto L9
    }

    public GuiContext(int r100, String r101, String r102, GuiView r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346638b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.artifactType = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.uri = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.view = null;
        return;
    L15:
        this.view = r103;
        return;
    L11:
        this.uri = r102;
        goto L13
    L7:
        this.artifactType = r101;
        goto L9
    }

    public /* synthetic */ GuiContext(String r100, String r101, GuiView r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

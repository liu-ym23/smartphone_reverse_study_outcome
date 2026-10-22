package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadad.api.download.AdDownloadModel;
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
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00060\u0001j\u0002`\u0002:\u0002@ABM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rBU\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#JT\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u000fHÖ\u0001J\t\u00107\u001a\u00020\u0004HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010#R \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010#¨\u0006B"}, d2 = {"Lcom/larus/im/bean/bot/ModelItem;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "name", "", "modelType", "", "modelName", "typeWriter", "", "webSearch", "genPic", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getModelType$annotations", "getModelType", "()J", "setModelType", "(J)V", "getModelName$annotations", "getModelName", "setModelName", "getTypeWriter$annotations", "getTypeWriter", "()Ljava/lang/Boolean;", "setTypeWriter", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getWebSearch$annotations", "getWebSearch", "getGenPic$annotations", "getGenPic", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/im/bean/bot/ModelItem;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ModelItem implements java.io.Serializable {
    public static final b Companion = null;
    private final Boolean genPic;
    private String modelName;
    private long modelType;
    private String name;
    private Boolean typeWriter;
    private final Boolean webSearch;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ModelItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346482a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346483b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            i r101 = i.f520705a;
            return new d[]{kuc.a.d(r100), g1.f520681a, kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346483b;
        }

        static {
            a r100 = new a();
            f346482a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.ModelItem", r100, 6);
            r101.j("name", true);
            r101.j(AdDownloadModel.JsonKey.MODEL_TYPE, true);
            r101.j("model_name", true);
            r101.j("typewriter_switch", true);
            r101.j("support_web_search_switch", true);
            r101.j("support_pic_gen_switch", true);
            f346483b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346483b;
            c r101 = r210.beginStructure(r100);
            int r102 = 2;
            Boolean r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            long r110 = r101.decodeLongElement(r100, 1);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            i r107 = i.f520705a;
            Boolean r108 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, r107, null);
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, r107, null);
            String r111 = r106;
            Boolean r112 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, r107, null);
            Boolean r113 = r109;
            Boolean r114 = r108;
            long r115 = r110;
            int r116 = 63;
            String r117 = r105;
        L21:
            r101.endStructure(r100);
            return new ModelItem(r116, r117, r115, r111, r114, r113, r112, null);
        L5:
            Boolean r118 = null;
            Boolean r119 = null;
            long r120 = 0;
            int r121 = 0;
            boolean r122 = true;
            r117 = null;
            String r123 = null;
        L6:
            if (r122 == false) goto L20;
            int r124 = r101.decodeElementIndex(r100);
            switch(r124) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r124);
        L19:
            r102 = 2;
            r122 = false;
            goto L6
        L11:
            r103 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, i.f520705a, r103);
            r121 = r121 | 32;
        L18:
            r102 = 2;
            goto L6
        L12:
            r118 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, i.f520705a, r118);
            r121 = r121 | 16;
            goto L18
        L13:
            r119 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, i.f520705a, r119);
            r121 = r121 | 8;
            goto L18
        L14:
            r123 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r123);
            r121 = r121 | 4;
            goto L18
        L15:
            r120 = r101.decodeLongElement(r100, 1);
            r121 = r121 | 2;
            goto L18
        L17:
            r121 = r121 | 1;
            r117 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r117);
            goto L18
        L20:
            r112 = r103;
            r116 = r121;
            Boolean r125 = r119;
            r111 = r123;
            long r126 = r120;
            r113 = r118;
            r114 = r125;
            r115 = r126;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ModelItem r102 = (ModelItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346483b;
            muc.d r104 = r100.beginStructure(r103);
            ModelItem.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ModelItem> serializer() {
            return a.f346482a;
        }
    }

    public ModelItem() {
        this(null, 0, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ModelItem copy$default(ModelItem r100, String r101, long r102, String r103, Boolean r110, Boolean r111, Boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.modelType;
    L8:
        long r104 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.modelName;
    L11:
        String r115 = r103;
        if ((r113 & 8) == 0) goto L14;
        r110 = r100.typeWriter;
    L14:
        Boolean r105 = r110;
        if ((r113 & 16) == 0) goto L17;
        r111 = r100.webSearch;
    L17:
        Boolean r106 = r111;
        if ((r113 & 32) == 0) goto L20;
        r112 = r100.genPic;
    L20:
        String r107 = r101;
        return r100.copy(r107, r104, r115, r105, r106, r112);
    }

    @SerialName("support_pic_gen_switch")
    public static /* synthetic */ void getGenPic$annotations() {
    }

    @SerialName("model_name")
    public static /* synthetic */ void getModelName$annotations() {
    }

    @SerialName(AdDownloadModel.JsonKey.MODEL_TYPE)
    public static /* synthetic */ void getModelType$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("typewriter_switch")
    public static /* synthetic */ void getTypeWriter$annotations() {
    }

    @SerialName("support_web_search_switch")
    public static /* synthetic */ void getWebSearch$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final long component2() {
        return this.modelType;
    }

    public final String component3() {
        return this.modelName;
    }

    public final Boolean component4() {
        return this.typeWriter;
    }

    public final Boolean component5() {
        return this.webSearch;
    }

    public final Boolean component6() {
        return this.genPic;
    }

    public final ModelItem copy(String r110, long r111, String r112, Boolean r113, Boolean r114, Boolean r115) {
        return new ModelItem(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModelItem) == true) goto L8;
        return false;
    L8:
        ModelItem r101 = (ModelItem) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (this.modelType == r101.modelType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelName, r101.modelName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.typeWriter, r101.typeWriter) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.webSearch, r101.webSearch) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.genPic, r101.genPic) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.modelType;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.modelName;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Boolean r108 = this.typeWriter;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.webSearch;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Boolean r114 = this.genPic;
        if (r114 == null) goto L23;
        r101 = r114.hashCode();
    L23:
        return r113 + r101;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ModelItem(name=" + this.name + ", modelType=" + this.modelType + ", modelName=" + this.modelName + ", typeWriter=" + this.typeWriter + ", webSearch=" + this.webSearch + ", genPic=" + this.genPic + ')';
    }

    static {
        Companion = new b();
    }

    public final Boolean getGenPic() {
        return this.genPic;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final long getModelType() {
        return this.modelType;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getTypeWriter() {
        return this.typeWriter;
    }

    public final Boolean getWebSearch() {
        return this.webSearch;
    }

    public final void setModelName(String r100) {
        this.modelName = r100;
    }

    public final void setModelType(long r100) {
        this.modelType = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setTypeWriter(Boolean r100) {
        this.typeWriter = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ModelItem r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.name);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeLongElement(r110, 1, r100.modelType);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, v2.f520790a, r100.modelName);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeNullableSerializableElement(r110, 3, i.f520705a, r100.typeWriter);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeNullableSerializableElement(r110, 4, i.f520705a, r100.webSearch);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        r102 = true;
    L53:
        if (r102 == false) goto L56;
        r101.encodeNullableSerializableElement(r110, 5, i.f520705a, r100.genPic);
        return;
    L56:
        return;
    L51:
        if (Intrinsics.areEqual(r100.genPic, Boolean.FALSE) == true) goto L53;
    L42:
        if (Intrinsics.areEqual(r100.webSearch, Boolean.FALSE) == false) goto L40;
        r107 = false;
        goto L45
    L33:
        if (Intrinsics.areEqual(r100.typeWriter, Boolean.FALSE) == false) goto L31;
        r106 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r100.modelName, "") == false) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.modelType != 0) goto L13;
        r104 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.name, "") == false) goto L4;
        r103 = false;
        goto L9
    }

    public ModelItem(String r100, long r101, String r102, Boolean r103, Boolean r104, Boolean r105) {
        this.name = r100;
        this.modelType = r101;
        this.modelName = r102;
        this.typeWriter = r103;
        this.webSearch = r104;
        this.genPic = r105;
    }

    public ModelItem(int r100, String r101, long r102, String r103, Boolean r104, Boolean r105, Boolean r106, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346483b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.name = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.modelType = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.modelName = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.typeWriter = Boolean.FALSE;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.webSearch = Boolean.FALSE;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.genPic = Boolean.FALSE;
        return;
    L27:
        this.genPic = r106;
        return;
    L23:
        this.webSearch = r105;
        goto L25
    L19:
        this.typeWriter = r104;
        goto L21
    L15:
        this.modelName = r103;
        goto L17
    L11:
        this.modelType = r102;
        goto L13
    L7:
        this.name = r101;
        goto L9
    }

    public /* synthetic */ ModelItem(String r100, long r101, String r102, Boolean r110, Boolean r111, Boolean r112, int r113, DefaultConstructorMarker r114) {
        String r103 = "";
        if ((r113 & 1) == 0) goto L5;
        String r115 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r104 = r101;
        if ((r113 & 4) != 0) goto L14;
        r103 = r102;
    L14:
        if ((r113 & 8) == 0) goto L16;
        r110 = Boolean.FALSE;
    L16:
        Boolean r105 = r110;
        if ((r113 & 16) == 0) goto L19;
        r111 = Boolean.FALSE;
    L19:
        Boolean r106 = r111;
        if ((r113 & 32) == 0) goto L22;
        r112 = Boolean.FALSE;
    L22:
        String r107 = r115;
        String r116 = r103;
        this(r107, r104, r116, r105, r106, r112);
        return;
    L5:
        r115 = r100;
        goto L7
    }
}

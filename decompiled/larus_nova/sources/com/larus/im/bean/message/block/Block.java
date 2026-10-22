package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.cert.manager.constants.EventConstant;
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
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 E2\u00060\u0001j\u0002`\u0002:\u0002DEBo\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013Bs\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fHÆ\u0003Jq\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fHÆ\u0001J\u0013\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0004HÖ\u0001J\t\u0010;\u001a\u00020\u0006HÖ\u0001J%\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0019\u001a\u0004\b\n\u0010%R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010(R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010+R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010+¨\u0006F"}, d2 = {"Lcom/larus/im/bean/message/block/Block;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "blockType", "", WikiFolderPushPlugin.BLOCK_ID, "", "parentId", "content", "Lcom/larus/im/bean/message/block/BlockContent;", "isFinish", "", "controlInfo", "Lcom/larus/im/bean/message/block/BlockControlInfo;", "appendFields", "", "metaInfo", "Lcom/larus/im/bean/message/block/BlockMetaInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/block/BlockContent;ZLcom/larus/im/bean/message/block/BlockControlInfo;Ljava/util/List;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/block/BlockContent;ZLcom/larus/im/bean/message/block/BlockControlInfo;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBlockType$annotations", "()V", "getBlockType", "()I", "getBlockId$annotations", "getBlockId", "()Ljava/lang/String;", "getParentId$annotations", "getParentId", "getContent$annotations", "getContent", "()Lcom/larus/im/bean/message/block/BlockContent;", "isFinish$annotations", "()Z", "getControlInfo$annotations", "getControlInfo", "()Lcom/larus/im/bean/message/block/BlockControlInfo;", "getAppendFields$annotations", "getAppendFields", "()Ljava/util/List;", "getMetaInfo$annotations", "getMetaInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class Block implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Integer> appendFields;
    private final String blockId;
    private final int blockType;
    private final BlockContent content;
    private final BlockControlInfo controlInfo;
    private final boolean isFinish;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<BlockMetaInfo> metaInfo;
    private final String parentId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<Block> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346807a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346808b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346808b;
        }

        static {
            a r100 = new a();
            f346807a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.Block", r100, 8);
            r101.j("block_type", true);
            r101.j(BitableResourceData.KEY_BLOCK_ID, true);
            r101.j("parent_id", true);
            r101.j("content", true);
            r101.j(EventConstant.Key.IS_FINISH, true);
            r101.j("control_info", true);
            r101.j("append_fields", true);
            r101.j("meta_info", true);
            f346808b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = Block.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            return new d[]{w0.f520792a, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(BlockContent.a.f346809a), i.f520705a, kuc.a.d(BlockControlInfo.a.f346811a), kuc.a.d((d) r100[6].getValue()), kuc.a.d((d) r100[7].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346808b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = Block.access$get$childSerializers$cp();
            int r103 = 7;
            int r104 = 5;
            if (r101.decodeSequentially() == false) goto L5;
            int r105 = r101.decodeIntElement(r100, 0);
            v2 r110 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r110, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r110, null);
            BlockContent r108 = (BlockContent) r101.decodeNullableSerializableElement(r100, 3, BlockContent.a.f346809a, null);
            boolean r109 = r101.decodeBooleanElement(r100, 4);
            BlockControlInfo r111 = (BlockControlInfo) r101.decodeNullableSerializableElement(r100, 5, BlockControlInfo.a.f346811a, null);
            List r112 = (List) r101.decodeNullableSerializableElement(r100, 6, (juc.c) r102[6].getValue(), null);
            List r113 = (List) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), null);
            BlockContent r114 = r108;
            BlockControlInfo r115 = r111;
            boolean r116 = r109;
            List r117 = r112;
            int r118 = r105;
            String r119 = r107;
            int r120 = 255;
        L24:
            r101.endStructure(r100);
            return new Block(r120, r118, r106, r119, r114, r116, r115, r117, r113, null);
        L5:
            BlockControlInfo r121 = null;
            List r122 = null;
            List r123 = null;
            String r124 = null;
            BlockContent r125 = null;
            String r126 = null;
            int r127 = 0;
            int r128 = 0;
            boolean r129 = false;
            boolean r130 = true;
        L6:
            if (r130 == false) goto L23;
            int r131 = r101.decodeElementIndex(r100);
            switch(r131) {
                case -1: goto L22;
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r131);
        L16:
            r128 = r128 | 8;
            r125 = (BlockContent) r101.decodeNullableSerializableElement(r100, 3, BlockContent.a.f346809a, r125);
            String r132 = r126;
        L21:
            r126 = r132;
            r103 = 7;
            r104 = 5;
            goto L6
        L17:
            int r133 = r128 | 4;
            String r134 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r126);
        L19:
            r128 = r133;
            r132 = r134;
            goto L21
        L18:
            r124 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r124);
            r134 = r126;
            r133 = r128 | 2;
            goto L19
        L20:
            r132 = r126;
            r127 = r101.decodeIntElement(r100, 0);
            r128 = r128 | 1;
            goto L21
        L22:
            r103 = 7;
            r130 = false;
            goto L6
        L11:
            r128 = r128 | 128;
            r123 = (List) r101.decodeNullableSerializableElement(r100, r103, (juc.c) r102[r103].getValue(), r123);
            goto L6
        L12:
            r128 = r128 | 64;
            r122 = (List) r101.decodeNullableSerializableElement(r100, 6, (juc.c) r102[6].getValue(), r122);
            goto L6
        L13:
            r128 = r128 | 32;
            r121 = (BlockControlInfo) r101.decodeNullableSerializableElement(r100, r104, BlockControlInfo.a.f346811a, r121);
            goto L6
        L14:
            r129 = r101.decodeBooleanElement(r100, 4);
            r128 = r128 | 16;
            goto L6
        L23:
            r118 = r127;
            r114 = r125;
            r113 = r123;
            r119 = r126;
            boolean r135 = r129;
            r115 = r121;
            r120 = r128;
            r116 = r135;
            String r211 = r124;
            r117 = r122;
            r106 = r211;
            goto L24
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            Block r102 = (Block) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346808b;
            muc.d r104 = r100.beginStructure(r103);
            Block.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<Block> serializer() {
            return a.f346807a;
        }
    }

    public Block() {
        this(0, null, null, null, false, null, null, null, 255, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(w0.f520792a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new nuc.f(BlockMetaInfo.a.f346815a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Block copy$default(Block r100, int r110, String r111, String r112, BlockContent r113, boolean r114, BlockControlInfo r115, List r116, List r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.blockType;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.blockId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.parentId;
    L15:
        if ((r118 & 8) == 0) goto L17;
        BlockContent r104 = r100.content;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.isFinish;
    L23:
        if ((r118 & 32) == 0) goto L25;
        BlockControlInfo r106 = r100.controlInfo;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = r100.appendFields;
    L31:
        if ((r118 & 128) == 0) goto L33;
        List r108 = r100.metaInfo;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    @SerialName("append_fields")
    public static /* synthetic */ void getAppendFields$annotations() {
    }

    @SerialName(BitableResourceData.KEY_BLOCK_ID)
    public static /* synthetic */ void getBlockId$annotations() {
    }

    @SerialName("block_type")
    public static /* synthetic */ void getBlockType$annotations() {
    }

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("control_info")
    public static /* synthetic */ void getControlInfo$annotations() {
    }

    @SerialName("meta_info")
    public static /* synthetic */ void getMetaInfo$annotations() {
    }

    @SerialName("parent_id")
    public static /* synthetic */ void getParentId$annotations() {
    }

    @SerialName(EventConstant.Key.IS_FINISH)
    public static /* synthetic */ void isFinish$annotations() {
    }

    public final int component1() {
        return this.blockType;
    }

    public final String component2() {
        return this.blockId;
    }

    public final String component3() {
        return this.parentId;
    }

    public final BlockContent component4() {
        return this.content;
    }

    public final boolean component5() {
        return this.isFinish;
    }

    public final BlockControlInfo component6() {
        return this.controlInfo;
    }

    public final List<Integer> component7() {
        return this.appendFields;
    }

    public final List<BlockMetaInfo> component8() {
        return this.metaInfo;
    }

    public final Block copy(int r110, String r111, String r112, BlockContent r113, boolean r114, BlockControlInfo r115, List<Integer> r116, List<BlockMetaInfo> r117) {
        return new Block(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Block) == true) goto L8;
        return false;
    L8:
        Block r101 = (Block) r100;
        if (this.blockType == r101.blockType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockId, r101.blockId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L21;
        return false;
    L21:
        if (this.isFinish == r101.isFinish) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.controlInfo, r101.controlInfo) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.appendFields, r101.appendFields) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.metaInfo, r101.metaInfo) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.blockType * 31;
        String r101 = this.blockId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.parentId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        BlockContent r108 = this.content;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.isFinish == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        BlockControlInfo r113 = this.controlInfo;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<Integer> r116 = this.appendFields;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<BlockMetaInfo> r119 = this.metaInfo;
        if (r119 == null) goto L31;
        r102 = r119.hashCode();
    L31:
        return r118 + r102;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "Block(blockType=" + this.blockType + ", blockId=" + this.blockId + ", parentId=" + this.parentId + ", content=" + this.content + ", isFinish=" + this.isFinish + ", controlInfo=" + this.controlInfo + ", appendFields=" + this.appendFields + ", metaInfo=" + this.metaInfo + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, null, null, LazyKt.lazy(r100, new zc9.e()), LazyKt.lazy(r100, new zc9.f())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final List<Integer> getAppendFields() {
        return this.appendFields;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final int getBlockType() {
        return this.blockType;
    }

    public final BlockContent getContent() {
        return this.content;
    }

    public final BlockControlInfo getControlInfo() {
        return this.controlInfo;
    }

    public final List<BlockMetaInfo> getMetaInfo() {
        return this.metaInfo;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(Block r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.blockType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.blockId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.parentId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, BlockContent.a.f346809a, r100.content);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeBooleanElement(r102, 4, r100.isFinish);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, BlockControlInfo.a.f346811a, r100.controlInfo);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, r103[6].getValue(), r100.appendFields);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        r104 = true;
    L71:
        if (r104 == false) goto L74;
        r101.encodeNullableSerializableElement(r102, 7, r103[7].getValue(), r100.metaInfo);
        return;
    L74:
        return;
    L69:
        if (r100.metaInfo == null) goto L71;
    L60:
        if (r100.appendFields != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.controlInfo != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.isFinish == true) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.content != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.parentId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.blockId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.blockType != 0) goto L4;
        r105 = false;
        goto L9
    }

    public Block(int r100, String r101, String r102, BlockContent r103, boolean r104, BlockControlInfo r105, List<Integer> r106, List<BlockMetaInfo> r107) {
        this.blockType = r100;
        this.blockId = r101;
        this.parentId = r102;
        this.content = r103;
        this.isFinish = r104;
        this.controlInfo = r105;
        this.appendFields = r106;
        this.metaInfo = r107;
    }

    public Block(int r100, int r101, String r102, String r103, BlockContent r104, boolean r105, BlockControlInfo r106, List r110, List r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346808b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.blockType = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.blockId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.parentId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.content = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.isFinish = false;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.controlInfo = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.appendFields = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.metaInfo = null;
        return;
    L35:
        this.metaInfo = r111;
        return;
    L31:
        this.appendFields = r110;
        goto L33
    L27:
        this.controlInfo = r106;
        goto L29
    L23:
        this.isFinish = r105;
        goto L25
    L19:
        this.content = r104;
        goto L21
    L15:
        this.parentId = r103;
        goto L17
    L11:
        this.blockId = r102;
        goto L13
    L7:
        this.blockType = r101;
        goto L9
    }

    public /* synthetic */ Block(int r110, String r111, String r112, BlockContent r113, boolean r114, BlockControlInfo r115, List r116, List r117, int r118, DefaultConstructorMarker r119) {
        boolean r100 = false;
        if ((r118 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        List r102 = null;
        if ((r118 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        BlockContent r105 = null;
    L19:
        if ((r118 & 16) != 0) goto L23;
        r100 = r114;
    L23:
        if ((r118 & 32) == 0) goto L25;
        BlockControlInfo r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r102 = r117;
    L34:
        this(r101, r103, r104, r105, r100, r106, r107, r102);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}

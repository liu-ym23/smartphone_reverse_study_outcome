package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
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
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Z2\u00060\u0001j\u0002`\u0002:\u0002YZB¯\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\u0015B§\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010G\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J¶\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\tHÖ\u0001J\t\u0010P\u001a\u00020\u0004HÖ\u0001J%\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0001¢\u0006\u0002\bXR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010&R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010\u001dR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001dR \u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010&R \u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010&R \u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010&R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001b\u001a\u0004\b7\u00108R \u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b9\u0010\u001b\u001a\u0004\b:\u0010&¨\u0006["}, d2 = {"Lcom/larus/im/bean/message/block/ArtifactBlock;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "resourceId", "", "artifactMetaId", "artifactVersionId", "conversationId", "version", "", "resourceVersion", "topic", "title", SelectInfo.BRIEF, "sourceType", "resourceType", "status", "briefImage", "Lcom/larus/im/bean/message/block/Cover;", "subResourceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/message/block/Cover;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/message/block/Cover;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResourceId$annotations", "()V", "getResourceId", "()Ljava/lang/String;", "getArtifactMetaId$annotations", "getArtifactMetaId", "getArtifactVersionId$annotations", "getArtifactVersionId", "getConversationId$annotations", "getConversationId", "getVersion$annotations", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResourceVersion$annotations", "getResourceVersion", "getTopic$annotations", "getTopic", "getTitle$annotations", "getTitle", "getBrief$annotations", "getBrief", "getSourceType$annotations", "getSourceType", "getResourceType$annotations", "getResourceType", "getStatus$annotations", "getStatus", "getBriefImage$annotations", "getBriefImage", "()Lcom/larus/im/bean/message/block/Cover;", "getSubResourceType$annotations", "getSubResourceType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/message/block/Cover;Ljava/lang/Integer;)Lcom/larus/im/bean/message/block/ArtifactBlock;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ArtifactBlock implements java.io.Serializable {
    public static final b Companion = null;
    private final String artifactMetaId;
    private final String artifactVersionId;
    private final String brief;
    private final Cover briefImage;
    private final String conversationId;
    private final String resourceId;
    private final Integer resourceType;
    private final Integer resourceVersion;
    private final Integer sourceType;
    private final Integer status;
    private final Integer subResourceType;
    private final String title;
    private final String topic;
    private final Integer version;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ArtifactBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346775a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346776b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346776b;
        }

        static {
            a r100 = new a();
            f346775a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.ArtifactBlock", r100, 14);
            r101.j("resource_id", true);
            r101.j("artifact_meta_id", true);
            r101.j("artifact_version_id", true);
            r101.j("conversation_id", true);
            r101.j("version", true);
            r101.j("resource_version", true);
            r101.j("artifact_topic", true);
            r101.j("title", true);
            r101.j(SelectInfo.BRIEF, true);
            r101.j("source_type", true);
            r101.j("resource_type", true);
            r101.j("status", true);
            r101.j("brief_image", true);
            r101.j("sub_resource_type", true);
            f346776b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(Cover.a.f346845a), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f346776b;
            c r101 = r310.beginStructure(r100);
            int r110 = 10;
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            w0 r106 = w0.f520792a;
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r106, null);
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r106, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 6, r103, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 7, r103, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 8, r103, null);
            Integer r115 = (Integer) r101.decodeNullableSerializableElement(r100, 9, r106, null);
            Integer r116 = (Integer) r101.decodeNullableSerializableElement(r100, 10, r106, null);
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 11, r106, null);
            Cover r210 = (Cover) r101.decodeNullableSerializableElement(r100, 12, Cover.a.f346845a, null);
            Integer r211 = (Integer) r101.decodeNullableSerializableElement(r100, 13, r106, null);
            String r118 = r105;
            String r119 = r108;
            String r212 = r109;
            Integer r213 = r115;
            Integer r214 = r116;
            Integer r215 = r117;
            String r216 = r114;
            String r120 = r104;
            Integer r121 = r107;
            Integer r122 = r113;
            String r123 = r111;
            String r124 = r112;
            int r125 = 16383;
        L34:
            r101.endStructure(r100);
            return new ArtifactBlock(r125, r123, r120, r124, r118, r122, r121, r119, r212, r216, r213, r214, r215, r210, r211, null);
        L5:
            int r126 = 13;
            String r127 = null;
            Integer r128 = null;
            Integer r129 = null;
            Integer r130 = null;
            String r131 = null;
            Integer r132 = null;
            Cover r133 = null;
            Integer r134 = null;
            String r135 = null;
            String r217 = null;
            String r218 = null;
            String r219 = null;
            Integer r220 = null;
            int r136 = 0;
            boolean r311 = true;
        L6:
            if (r311 == false) goto L33;
            int r137 = r101.decodeElementIndex(r100);
            switch(r137) {
                case -1: goto L32;
                case 0: goto L30;
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L20;
                case 7: goto L18;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                case 13: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r137);
        L32:
            r126 = 13;
            r110 = 10;
            r311 = false;
            r217 = r217;
            r127 = r127;
            goto L6
        L11:
            r129 = (Integer) r101.decodeNullableSerializableElement(r100, r126, w0.f520792a, r129);
            r136 = r136 | 8192;
        L17:
            String r138 = r218;
        L21:
            String r221 = r138;
            Integer r139 = r220;
        L27:
            String r140 = r127;
        L29:
            r127 = r140;
            String r141 = r219;
        L31:
            r219 = r141;
            r220 = r139;
            r218 = r221;
            r126 = 13;
            r110 = 10;
            goto L6
        L12:
            r133 = (Cover) r101.decodeNullableSerializableElement(r100, 12, Cover.a.f346845a, r133);
            r136 = r136 | 4096;
            goto L17
        L13:
            r132 = (Integer) r101.decodeNullableSerializableElement(r100, 11, w0.f520792a, r132);
            r136 = r136 | 2048;
            goto L17
        L14:
            r134 = (Integer) r101.decodeNullableSerializableElement(r100, r110, w0.f520792a, r134);
            r136 = r136 | 1024;
            goto L17
        L15:
            r130 = (Integer) r101.decodeNullableSerializableElement(r100, 9, w0.f520792a, r130);
            r136 = r136 | 512;
            goto L17
        L16:
            r218 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r218);
            r136 = r136 | 256;
            goto L17
        L18:
            r138 = r218;
            r131 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r131);
            r136 = r136 | 128;
            goto L21
        L20:
            r138 = r218;
            r135 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r135);
            r136 = r136 | 64;
            goto L21
        L22:
            r221 = r218;
            r136 = r136 | 32;
            r139 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r220);
            goto L27
        L23:
            r221 = r218;
            r139 = r220;
            r128 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r128);
            r136 = r136 | 16;
            goto L27
        L25:
            r221 = r218;
            r139 = r220;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r102);
            r136 = r136 | 8;
            goto L27
        L26:
            r221 = r218;
            r139 = r220;
            r127 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r127);
            r136 = r136 | 4;
            goto L27
        L28:
            r221 = r218;
            r139 = r220;
            r140 = r127;
            r219 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r219);
            r136 = r136 | 2;
            goto L29
        L30:
            String r142 = r127;
            r221 = r218;
            r139 = r220;
            r136 = r136 | 1;
            r141 = r219;
            r217 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r217);
            r127 = r142;
            goto L31
        L33:
            String r143 = r127;
            r118 = r102;
            r122 = r128;
            r211 = r129;
            r213 = r130;
            r215 = r132;
            r210 = r133;
            r119 = r135;
            r124 = r143;
            r216 = r218;
            r123 = r217;
            r125 = r136;
            r121 = r220;
            r214 = r134;
            r120 = r219;
            r212 = r131;
            goto L34
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ArtifactBlock r102 = (ArtifactBlock) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346776b;
            muc.d r104 = r100.beginStructure(r103);
            ArtifactBlock.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ArtifactBlock> serializer() {
            return a.f346775a;
        }
    }

    public ArtifactBlock() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ ArtifactBlock copy$default(ArtifactBlock r110, String r111, String r112, String r113, String r114, Integer r210, Integer r211, String r212, String r213, String r214, Integer r215, Integer r216, Integer r217, Cover r218, Integer r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.resourceId;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.artifactMetaId;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.artifactVersionId;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.conversationId;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Integer r104 = r110.version;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Integer r105 = r110.resourceVersion;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.topic;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r107 = r110.title;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r115 = r110.brief;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Integer r116 = r110.sourceType;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Integer r117 = r110.resourceType;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Integer r118 = r110.status;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Cover r119 = r110.briefImage;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        Integer r108 = r110.subResourceType;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("artifact_meta_id")
    public static /* synthetic */ void getArtifactMetaId$annotations() {
    }

    @SerialName("artifact_version_id")
    public static /* synthetic */ void getArtifactVersionId$annotations() {
    }

    @SerialName(SelectInfo.BRIEF)
    public static /* synthetic */ void getBrief$annotations() {
    }

    @SerialName("brief_image")
    public static /* synthetic */ void getBriefImage$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("resource_id")
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("resource_type")
    public static /* synthetic */ void getResourceType$annotations() {
    }

    @SerialName("resource_version")
    public static /* synthetic */ void getResourceVersion$annotations() {
    }

    @SerialName("source_type")
    public static /* synthetic */ void getSourceType$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("sub_resource_type")
    public static /* synthetic */ void getSubResourceType$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("artifact_topic")
    public static /* synthetic */ void getTopic$annotations() {
    }

    @SerialName("version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.resourceId;
    }

    public final Integer component10() {
        return this.sourceType;
    }

    public final Integer component11() {
        return this.resourceType;
    }

    public final Integer component12() {
        return this.status;
    }

    public final Cover component13() {
        return this.briefImage;
    }

    public final Integer component14() {
        return this.subResourceType;
    }

    public final String component2() {
        return this.artifactMetaId;
    }

    public final String component3() {
        return this.artifactVersionId;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final Integer component5() {
        return this.version;
    }

    public final Integer component6() {
        return this.resourceVersion;
    }

    public final String component7() {
        return this.topic;
    }

    public final String component8() {
        return this.title;
    }

    public final String component9() {
        return this.brief;
    }

    public final ArtifactBlock copy(String r110, String r111, String r112, String r210, Integer r211, Integer r212, String r213, String r214, String r215, Integer r216, Integer r217, Integer r218, Cover r219, Integer r310) {
        return new ArtifactBlock(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ArtifactBlock) == true) goto L8;
        return false;
    L8:
        ArtifactBlock r101 = (ArtifactBlock) r100;
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.artifactMetaId, r101.artifactMetaId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.artifactVersionId, r101.artifactVersionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resourceVersion, r101.resourceVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.topic, r101.topic) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.brief, r101.brief) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sourceType, r101.sourceType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.resourceType, r101.resourceType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.briefImage, r101.briefImage) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.subResourceType, r101.subResourceType) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        String r100 = this.resourceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.artifactMetaId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.artifactVersionId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.conversationId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.version;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.resourceVersion;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.topic;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.title;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.brief;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.sourceType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.resourceType;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.status;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Cover r137 = this.briefImage;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.subResourceType;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "ArtifactBlock(resourceId=" + this.resourceId + ", artifactMetaId=" + this.artifactMetaId + ", artifactVersionId=" + this.artifactVersionId + ", conversationId=" + this.conversationId + ", version=" + this.version + ", resourceVersion=" + this.resourceVersion + ", topic=" + this.topic + ", title=" + this.title + ", brief=" + this.brief + ", sourceType=" + this.sourceType + ", resourceType=" + this.resourceType + ", status=" + this.status + ", briefImage=" + this.briefImage + ", subResourceType=" + this.subResourceType + ')';
    }

    static {
        Companion = new b();
    }

    public final String getArtifactMetaId() {
        return this.artifactMetaId;
    }

    public final String getArtifactVersionId() {
        return this.artifactVersionId;
    }

    public final String getBrief() {
        return this.brief;
    }

    public final Cover getBriefImage() {
        return this.briefImage;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Integer getResourceType() {
        return this.resourceType;
    }

    public final Integer getResourceVersion() {
        return this.resourceVersion;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getSubResourceType() {
        return this.subResourceType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final Integer getVersion() {
        return this.version;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ArtifactBlock r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.resourceId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.artifactMetaId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.artifactVersionId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.conversationId);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.version);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, w0.f520792a, r100.resourceVersion);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.topic);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.title);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.brief);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, w0.f520792a, r100.sourceType);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, w0.f520792a, r100.resourceType);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 11, w0.f520792a, r100.status);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, Cover.a.f346845a, r100.briefImage);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        r103 = true;
    L125:
        if (r103 == false) goto L128;
        r101.encodeNullableSerializableElement(r102, 13, w0.f520792a, r100.subResourceType);
        return;
    L128:
        return;
    L123:
        if (r100.subResourceType == null) goto L125;
    L114:
        if (r100.briefImage != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.status != null) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.resourceType != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.sourceType != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.brief != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.title != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.topic != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.resourceVersion != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.version != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.conversationId != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.artifactVersionId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.artifactMetaId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.resourceId != null) goto L4;
        r104 = false;
        goto L9
    }

    public ArtifactBlock(String r100, String r101, String r102, String r103, Integer r104, Integer r105, String r106, String r107, String r108, Integer r110, Integer r111, Integer r112, Cover r113, Integer r114) {
        this.resourceId = r100;
        this.artifactMetaId = r101;
        this.artifactVersionId = r102;
        this.conversationId = r103;
        this.version = r104;
        this.resourceVersion = r105;
        this.topic = r106;
        this.title = r107;
        this.brief = r108;
        this.sourceType = r110;
        this.resourceType = r111;
        this.status = r112;
        this.briefImage = r113;
        this.subResourceType = r114;
    }

    public ArtifactBlock(int r100, String r101, String r102, String r103, String r110, Integer r111, Integer r112, String r113, String r114, String r115, Integer r116, Integer r117, Integer r118, Cover r119, Integer r210, q2 r211) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346776b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.resourceId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.artifactMetaId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.artifactVersionId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.conversationId = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.version = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.resourceVersion = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.topic = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.title = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.brief = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.sourceType = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.resourceType = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.status = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.briefImage = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.subResourceType = null;
        return;
    L59:
        this.subResourceType = r210;
        return;
    L55:
        this.briefImage = r119;
        goto L57
    L51:
        this.status = r118;
        goto L53
    L47:
        this.resourceType = r117;
        goto L49
    L43:
        this.sourceType = r116;
        goto L45
    L39:
        this.brief = r115;
        goto L41
    L35:
        this.title = r114;
        goto L37
    L31:
        this.topic = r113;
        goto L33
    L27:
        this.resourceVersion = r112;
        goto L29
    L23:
        this.version = r111;
        goto L25
    L19:
        this.conversationId = r110;
        goto L21
    L15:
        this.artifactVersionId = r103;
        goto L17
    L11:
        this.artifactMetaId = r102;
        goto L13
    L7:
        this.resourceId = r101;
        goto L9
    }

    public /* synthetic */ ArtifactBlock(String r110, String r111, String r112, String r113, Integer r210, Integer r211, String r212, String r213, String r214, Integer r215, Integer r216, Integer r217, Cover r218, Integer r219, int r310, DefaultConstructorMarker r311) {
        Integer r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Integer r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Integer r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Integer r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Cover r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
}

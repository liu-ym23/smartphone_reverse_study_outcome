package com.larus.im.bean.message.block;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
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
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import zc9.f1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 V2\u00060\u0001j\u0002`\u0002:\u0002UVB\u0099\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016B\u0097\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010>\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0019\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J \u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020\u0004HÖ\u0001J%\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0001¢\u0006\u0002\bTR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010!R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010!R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010!R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010)R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010,R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010/R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001c\u001a\u0004\b1\u00102R,\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001c\u001a\u0004\b4\u00105R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001c\u001a\u0004\b7\u0010\u001eR \u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b8\u0010\u001c\u001a\u0004\b9\u0010!¨\u0006W"}, d2 = {"Lcom/larus/im/bean/message/block/UgcItem;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "itemId", "", "itemType", "", "source", "status", "authorInfo", "Lcom/larus/im/bean/message/block/AuthorInfo;", "cover", "Lcom/larus/im/bean/message/block/ContentCover;", "contentDescription", "Lcom/larus/im/bean/message/block/ContentDescription;", "interactInfo", "Lcom/larus/im/bean/message/block/InteractInfo;", "extra", "", "requestId", "recChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/message/block/AuthorInfo;Lcom/larus/im/bean/message/block/ContentCover;Lcom/larus/im/bean/message/block/ContentDescription;Lcom/larus/im/bean/message/block/InteractInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/message/block/AuthorInfo;Lcom/larus/im/bean/message/block/ContentCover;Lcom/larus/im/bean/message/block/ContentDescription;Lcom/larus/im/bean/message/block/InteractInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItemId$annotations", "()V", "getItemId", "()Ljava/lang/String;", "getItemType$annotations", "getItemType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSource$annotations", "getSource", "getStatus$annotations", "getStatus", "getAuthorInfo$annotations", "getAuthorInfo", "()Lcom/larus/im/bean/message/block/AuthorInfo;", "getCover$annotations", "getCover", "()Lcom/larus/im/bean/message/block/ContentCover;", "getContentDescription$annotations", "getContentDescription", "()Lcom/larus/im/bean/message/block/ContentDescription;", "getInteractInfo$annotations", "getInteractInfo", "()Lcom/larus/im/bean/message/block/InteractInfo;", "getExtra$annotations", "getExtra", "()Ljava/util/Map;", "getRequestId$annotations", "getRequestId", "getRecChannelId$annotations", "getRecChannelId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/message/block/AuthorInfo;Lcom/larus/im/bean/message/block/ContentCover;Lcom/larus/im/bean/message/block/ContentDescription;Lcom/larus/im/bean/message/block/InteractInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/im/bean/message/block/UgcItem;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UgcItem implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final AuthorInfo authorInfo;
    private final ContentDescription contentDescription;
    private final ContentCover cover;
    private final Map<String, String> extra;
    private final InteractInfo interactInfo;
    private final String itemId;
    private final Integer itemType;
    private final Integer recChannelId;
    private final String requestId;
    private final Integer source;
    private final Integer status;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UgcItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347084a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347085b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347085b;
        }

        static {
            a r100 = new a();
            f347084a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.UgcItem", r100, 11);
            r101.j("item_id", true);
            r101.j(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, true);
            r101.j("source", true);
            r101.j("status", true);
            r101.j("author_info", true);
            r101.j("cover", true);
            r101.j("content_description", true);
            r101.j("interaction_info", true);
            r101.j("extra", true);
            r101.j("request_id", true);
            r101.j("rec_channel_id", true);
            f347085b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = UgcItem.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(AuthorInfo.a.f346801a), kuc.a.d(ContentCover.a.f346841a), kuc.a.d(ContentDescription.a.f346843a), kuc.a.d(InteractInfo.a.f346894a), kuc.a.d((d) r100[8].getValue()), kuc.a.d(r101), kuc.a.d(r102)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f347085b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = UgcItem.access$get$childSerializers$cp();
            int r103 = 7;
            int r110 = 8;
            Integer r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            w0 r105 = w0.f520792a;
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            AuthorInfo r107 = (AuthorInfo) r101.decodeNullableSerializableElement(r100, 4, AuthorInfo.a.f346801a, null);
            ContentCover r108 = (ContentCover) r101.decodeNullableSerializableElement(r100, 5, ContentCover.a.f346841a, null);
            ContentDescription r109 = (ContentDescription) r101.decodeNullableSerializableElement(r100, 6, ContentDescription.a.f346843a, null);
            InteractInfo r115 = (InteractInfo) r101.decodeNullableSerializableElement(r100, 7, InteractInfo.a.f346894a, null);
            Map r116 = (Map) r101.decodeNullableSerializableElement(r100, 8, (juc.c) r102[8].getValue(), null);
            int r117 = 2047;
            Map r118 = r116;
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 9, r104, null);
            Integer r212 = (Integer) r101.decodeNullableSerializableElement(r100, 10, r105, null);
            AuthorInfo r119 = r107;
            ContentCover r120 = r108;
            ContentDescription r121 = r109;
            InteractInfo r122 = r115;
            Integer r123 = r113;
            Integer r124 = r106;
            Integer r125 = r114;
            String r126 = r112;
        L31:
            r101.endStructure(r100);
            return new UgcItem(r117, r126, r123, r125, r124, r119, r120, r121, r122, r118, r211, r212, null);
        L5:
            int r127 = 10;
            Integer r128 = null;
            Map r129 = null;
            Integer r130 = null;
            ContentCover r131 = null;
            InteractInfo r132 = null;
            Integer r133 = null;
            String r134 = null;
            ContentDescription r213 = null;
            String r214 = null;
            AuthorInfo r215 = null;
            int r135 = 0;
            boolean r216 = true;
        L6:
            if (r216 == false) goto L30;
            int r136 = r101.decodeElementIndex(r100);
            switch(r136) {
                case -1: goto L29;
                case 0: goto L27;
                case 1: goto L25;
                case 2: goto L23;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r136);
        L29:
            r102 = r102;
            r127 = 10;
            r103 = 7;
            r110 = 8;
            r216 = false;
            goto L6
        L11:
            r130 = (Integer) r101.decodeNullableSerializableElement(r100, r127, w0.f520792a, r130);
            r135 = r135 | 1024;
        L15:
            ContentDescription r137 = r213;
        L20:
            AuthorInfo r138 = r215;
        L28:
            r102 = r102;
            r213 = r137;
            r215 = r138;
            r127 = 10;
            r103 = 7;
            r110 = 8;
            goto L6
        L12:
            r134 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r134);
            r135 = r135 | 512;
            goto L15
        L13:
            r129 = (Map) r101.decodeNullableSerializableElement(r100, r110, (juc.c) r102[r110].getValue(), r129);
            r135 = r135 | 256;
            goto L15
        L14:
            r132 = (InteractInfo) r101.decodeNullableSerializableElement(r100, r103, InteractInfo.a.f346894a, r132);
            r135 = r135 | 128;
            goto L15
        L16:
            r137 = (ContentDescription) r101.decodeNullableSerializableElement(r100, 6, ContentDescription.a.f346843a, r213);
            r135 = r135 | 64;
            goto L20
        L17:
            r137 = r213;
            r131 = (ContentCover) r101.decodeNullableSerializableElement(r100, 5, ContentCover.a.f346841a, r131);
            r135 = r135 | 32;
            goto L20
        L19:
            r137 = r213;
            r215 = (AuthorInfo) r101.decodeNullableSerializableElement(r100, 4, AuthorInfo.a.f346801a, r215);
            r135 = r135 | 16;
            goto L20
        L21:
            r137 = r213;
            r138 = r215;
            r111 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r111);
            r135 = r135 | 8;
            goto L28
        L23:
            r137 = r213;
            r138 = r215;
            r128 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, r128);
            r135 = r135 | 4;
            goto L28
        L25:
            r137 = r213;
            r138 = r215;
            r133 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, r133);
            r135 = r135 | 2;
            goto L28
        L27:
            r137 = r213;
            r138 = r215;
            r135 = r135 | 1;
            r214 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r214);
            goto L28
        L30:
            r121 = r213;
            r118 = r129;
            r212 = r130;
            r120 = r131;
            r122 = r132;
            r123 = r133;
            r211 = r134;
            r124 = r111;
            r125 = r128;
            r119 = r215;
            r126 = r214;
            r117 = r135;
            goto L31
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            UgcItem r102 = (UgcItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347085b;
            muc.d r104 = r100.beginStructure(r103);
            UgcItem.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UgcItem> serializer() {
            return a.f347084a;
        }
    }

    public UgcItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, kuc.a.d(r100));
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UgcItem copy$default(UgcItem r110, String r111, Integer r112, Integer r113, Integer r114, AuthorInfo r115, ContentCover r116, ContentDescription r117, InteractInfo r210, Map r211, String r212, Integer r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.itemId;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Integer r101 = r110.itemType;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r102 = r110.source;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Integer r103 = r110.status;
    L19:
        if ((r214 & 16) == 0) goto L21;
        AuthorInfo r104 = r110.authorInfo;
    L23:
        if ((r214 & 32) == 0) goto L25;
        ContentCover r105 = r110.cover;
    L27:
        if ((r214 & 64) == 0) goto L29;
        ContentDescription r106 = r110.contentDescription;
    L31:
        if ((r214 & 128) == 0) goto L33;
        InteractInfo r107 = r110.interactInfo;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Map r118 = r110.extra;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.requestId;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Integer r108 = r110.recChannelId;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
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

    @SerialName("author_info")
    public static /* synthetic */ void getAuthorInfo$annotations() {
    }

    @SerialName("content_description")
    public static /* synthetic */ void getContentDescription$annotations() {
    }

    @SerialName("cover")
    public static /* synthetic */ void getCover$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("interaction_info")
    public static /* synthetic */ void getInteractInfo$annotations() {
    }

    @SerialName("item_id")
    public static /* synthetic */ void getItemId$annotations() {
    }

    @SerialName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    public static /* synthetic */ void getItemType$annotations() {
    }

    @SerialName("rec_channel_id")
    public static /* synthetic */ void getRecChannelId$annotations() {
    }

    @SerialName("request_id")
    public static /* synthetic */ void getRequestId$annotations() {
    }

    @SerialName("source")
    public static /* synthetic */ void getSource$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    public final String component1() {
        return this.itemId;
    }

    public final String component10() {
        return this.requestId;
    }

    public final Integer component11() {
        return this.recChannelId;
    }

    public final Integer component2() {
        return this.itemType;
    }

    public final Integer component3() {
        return this.source;
    }

    public final Integer component4() {
        return this.status;
    }

    public final AuthorInfo component5() {
        return this.authorInfo;
    }

    public final ContentCover component6() {
        return this.cover;
    }

    public final ContentDescription component7() {
        return this.contentDescription;
    }

    public final InteractInfo component8() {
        return this.interactInfo;
    }

    public final Map<String, String> component9() {
        return this.extra;
    }

    public final UgcItem copy(String r110, Integer r111, Integer r112, Integer r113, AuthorInfo r114, ContentCover r115, ContentDescription r210, InteractInfo r211, Map<String, String> r212, String r213, Integer r214) {
        return new UgcItem(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UgcItem) == true) goto L8;
        return false;
    L8:
        UgcItem r101 = (UgcItem) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.authorInfo, r101.authorInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.contentDescription, r101.contentDescription) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.interactInfo, r101.interactInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.recChannelId, r101.recChannelId) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.itemId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.itemType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.source;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.status;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        AuthorInfo r113 = this.authorInfo;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ContentCover r116 = this.cover;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ContentDescription r119 = this.contentDescription;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        InteractInfo r122 = this.interactInfo;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.extra;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.requestId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.recChannelId;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
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
        return "UgcItem(itemId=" + this.itemId + ", itemType=" + this.itemType + ", source=" + this.source + ", status=" + this.status + ", authorInfo=" + this.authorInfo + ", cover=" + this.cover + ", contentDescription=" + this.contentDescription + ", interactInfo=" + this.interactInfo + ", extra=" + this.extra + ", requestId=" + this.requestId + ", recChannelId=" + this.recChannelId + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new f1()), null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final AuthorInfo getAuthorInfo() {
        return this.authorInfo;
    }

    public final ContentDescription getContentDescription() {
        return this.contentDescription;
    }

    public final ContentCover getCover() {
        return this.cover;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final InteractInfo getInteractInfo() {
        return this.interactInfo;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final Integer getRecChannelId() {
        return this.recChannelId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final Integer getStatus() {
        return this.status;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(UgcItem r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.itemId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, w0.f520792a, r100.itemType);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, w0.f520792a, r100.source);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, w0.f520792a, r100.status);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, AuthorInfo.a.f346801a, r100.authorInfo);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, ContentCover.a.f346841a, r100.cover);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, ContentDescription.a.f346843a, r100.contentDescription);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, InteractInfo.a.f346894a, r100.interactInfo);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, r103[8].getValue(), r100.extra);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.requestId);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        r104 = true;
    L98:
        if (r104 == false) goto L101;
        r101.encodeNullableSerializableElement(r102, 10, w0.f520792a, r100.recChannelId);
        return;
    L101:
        return;
    L96:
        if (r100.recChannelId == null) goto L98;
    L87:
        if (r100.requestId != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.extra != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.interactInfo != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.contentDescription != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.cover != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.authorInfo != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.status != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.source != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.itemType != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.itemId != null) goto L4;
        r105 = false;
        goto L9
    }

    public UgcItem(String r100, Integer r101, Integer r102, Integer r103, AuthorInfo r104, ContentCover r105, ContentDescription r106, InteractInfo r107, Map<String, String> r108, String r110, Integer r111) {
        this.itemId = r100;
        this.itemType = r101;
        this.source = r102;
        this.status = r103;
        this.authorInfo = r104;
        this.cover = r105;
        this.contentDescription = r106;
        this.interactInfo = r107;
        this.extra = r108;
        this.requestId = r110;
        this.recChannelId = r111;
    }

    public UgcItem(int r100, String r101, Integer r102, Integer r103, Integer r104, AuthorInfo r105, ContentCover r106, ContentDescription r107, InteractInfo r110, Map r111, String r112, Integer r113, q2 r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347085b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.itemId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.itemType = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.source = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.status = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.authorInfo = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.cover = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.contentDescription = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.interactInfo = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.extra = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.requestId = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.recChannelId = null;
        return;
    L47:
        this.recChannelId = r113;
        return;
    L43:
        this.requestId = r112;
        goto L45
    L39:
        this.extra = r111;
        goto L41
    L35:
        this.interactInfo = r110;
        goto L37
    L31:
        this.contentDescription = r107;
        goto L33
    L27:
        this.cover = r106;
        goto L29
    L23:
        this.authorInfo = r105;
        goto L25
    L19:
        this.status = r104;
        goto L21
    L15:
        this.source = r103;
        goto L17
    L11:
        this.itemType = r102;
        goto L13
    L7:
        this.itemId = r101;
        goto L9
    }

    public /* synthetic */ UgcItem(String r110, Integer r111, Integer r112, Integer r113, AuthorInfo r114, ContentCover r115, ContentDescription r116, InteractInfo r210, Map r211, String r212, Integer r213, int r214, DefaultConstructorMarker r215) {
        Integer r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        AuthorInfo r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        ContentCover r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        ContentDescription r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        InteractInfo r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Map r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
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
}

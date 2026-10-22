package com.larus.im.bean.message;

import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.obric.capabilitykit.EntityProvider;
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
import kotlinx.serialization.Transient;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import yc9.m1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bN\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 w2\u00060\u0001j\u0002`\u0002:\u0002vwBÁ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aB\u0083\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0018\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0019\u0010\u001eJ\b\u0010Y\u001a\u00020\bH\u0016J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010_\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010b\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010BJ\t\u0010c\u001a\u00020\u0010HÆ\u0003J\u0011\u0010d\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010BJ\u0019\u0010g\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0018HÆ\u0003JÈ\u0001\u0010h\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020\u00102\b\u0010k\u001a\u0004\u0018\u00010lHÖ\u0003J\t\u0010m\u001a\u00020\u0004HÖ\u0001J%\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\u00002\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020tH\u0001¢\u0006\u0002\buR(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010%\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010 \u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010 \u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010 \u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010%\u0012\u0004\b5\u0010 \u001a\u0004\b6\u0010\"\"\u0004\b7\u0010$R(\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010%\u0012\u0004\b8\u0010 \u001a\u0004\b9\u0010\"\"\u0004\b:\u0010$R(\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010%\u0012\u0004\b;\u0010 \u001a\u0004\b<\u0010\"\"\u0004\b=\u0010$R(\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010%\u0012\u0004\b>\u0010 \u001a\u0004\b?\u0010\"\"\u0004\b@\u0010$R(\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010E\u0012\u0004\bA\u0010 \u001a\u0004\b\u000f\u0010B\"\u0004\bC\u0010DR$\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bF\u0010 \u001a\u0004\b\u0011\u0010G\"\u0004\bH\u0010IR,\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010 \u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR&\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bO\u0010 \u001a\u0004\bP\u0010-\"\u0004\bQ\u0010/R(\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010E\u0012\u0004\bR\u0010 \u001a\u0004\b\u0016\u0010B\"\u0004\bS\u0010DR4\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bT\u0010 \u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006x"}, d2 = {"Lcom/larus/im/bean/message/UplinkFileEntity;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "entityType", "", "uplinkEntityContent", "Lcom/larus/im/bean/message/UplinkEntityContent;", "fileIdentifier", "", "expiredInfo", "Lcom/larus/im/bean/message/ExpiredInfo;", "fileReviewStatus", "fileParsedStatus", "upLinkProcess", "upLinkStatus", "isFromDraft", "", "isHistoryReuse", "uri", "Landroid/net/Uri;", "Lcom/flow/kmp/common/util/Uri;", "instantUploadInfoJson", "isOriginalImageChecked", "extra", "", "<init>", "(Ljava/lang/Integer;Lcom/larus/im/bean/message/UplinkEntityContent;Ljava/lang/String;Lcom/larus/im/bean/message/ExpiredInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;ZLandroid/net/Uri;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Lcom/larus/im/bean/message/UplinkEntityContent;Ljava/lang/String;Lcom/larus/im/bean/message/ExpiredInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEntityType$annotations", "()V", "getEntityType", "()Ljava/lang/Integer;", "setEntityType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUplinkEntityContent$annotations", "getUplinkEntityContent", "()Lcom/larus/im/bean/message/UplinkEntityContent;", "setUplinkEntityContent", "(Lcom/larus/im/bean/message/UplinkEntityContent;)V", "getFileIdentifier$annotations", "getFileIdentifier", "()Ljava/lang/String;", "setFileIdentifier", "(Ljava/lang/String;)V", "getExpiredInfo$annotations", "getExpiredInfo", "()Lcom/larus/im/bean/message/ExpiredInfo;", "setExpiredInfo", "(Lcom/larus/im/bean/message/ExpiredInfo;)V", "getFileReviewStatus$annotations", "getFileReviewStatus", "setFileReviewStatus", "getFileParsedStatus$annotations", "getFileParsedStatus", "setFileParsedStatus", "getUpLinkProcess$annotations", "getUpLinkProcess", "setUpLinkProcess", "getUpLinkStatus$annotations", "getUpLinkStatus", "setUpLinkStatus", "isFromDraft$annotations", "()Ljava/lang/Boolean;", "setFromDraft", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isHistoryReuse$annotations", "()Z", "setHistoryReuse", "(Z)V", "getUri$annotations", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "getInstantUploadInfoJson$annotations", "getInstantUploadInfoJson", "setInstantUploadInfoJson", "isOriginalImageChecked$annotations", "setOriginalImageChecked", "getExtra$annotations", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/Integer;Lcom/larus/im/bean/message/UplinkEntityContent;Ljava/lang/String;Lcom/larus/im/bean/message/ExpiredInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;ZLandroid/net/Uri;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/larus/im/bean/message/UplinkFileEntity;", "equals", "other", "", "hashCode", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UplinkFileEntity implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private Integer entityType;
    private ExpiredInfo expiredInfo;
    private Map<String, String> extra;
    private String fileIdentifier;
    private Integer fileParsedStatus;
    private Integer fileReviewStatus;
    private transient String instantUploadInfoJson;
    private transient Boolean isFromDraft;
    private boolean isHistoryReuse;
    private Boolean isOriginalImageChecked;
    private Integer upLinkProcess;
    private Integer upLinkStatus;
    private UplinkEntityContent uplinkEntityContent;
    private transient Uri uri;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UplinkFileEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346738a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346739b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346739b;
        }

        static {
            a r100 = new a();
            f346738a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.UplinkFileEntity", r100, 9);
            r101.j(EntityProvider.KEY_ENTITY_TYPE, true);
            r101.j("entity_content", true);
            r101.j(LocationMonitorConst.IDENTIFIER, true);
            r101.j("expired_state", true);
            r101.j("file_name_state", true);
            r101.j("file_parse_state", true);
            r101.j("upload_process", true);
            r101.j("upload_status", true);
            r101.j("extra", true);
            f346739b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = UplinkFileEntity.access$get$childSerializers$cp();
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d(r101), kuc.a.d(UplinkEntityContent.a.f346734a), kuc.a.d(v2.f520790a), kuc.a.d(ExpiredInfo.a.f346625a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[8].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346739b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = UplinkFileEntity.access$get$childSerializers$cp();
            int r103 = 8;
            int r104 = 6;
            Integer r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            w0 r105 = w0.f520792a;
            Integer r111 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r105, null);
            UplinkEntityContent r112 = (UplinkEntityContent) r101.decodeNullableSerializableElement(r100, 1, UplinkEntityContent.a.f346734a, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, null);
            ExpiredInfo r107 = (ExpiredInfo) r101.decodeNullableSerializableElement(r100, 3, ExpiredInfo.a.f346625a, null);
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r105, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r105, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r105, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 7, r105, null);
            Map r115 = (Map) r101.decodeNullableSerializableElement(r100, 8, (juc.c) r102[8].getValue(), null);
            Integer r116 = r114;
            Integer r117 = r108;
            Integer r118 = r109;
            Integer r119 = r113;
            UplinkEntityContent r120 = r112;
            int r121 = 511;
            ExpiredInfo r122 = r107;
            String r123 = r106;
            Integer r124 = r111;
        L26:
            r101.endStructure(r100);
            return new UplinkFileEntity(r121, r124, r120, r123, r122, r119, r117, r118, r116, r115, null);
        L5:
            Map r125 = null;
            Integer r126 = null;
            Integer r127 = null;
            ExpiredInfo r128 = null;
            Integer r129 = null;
            UplinkEntityContent r130 = null;
            Integer r131 = null;
            String r132 = null;
            int r133 = 0;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L25;
            int r134 = r101.decodeElementIndex(r100);
            switch(r134) {
                case -1: goto L24;
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r134);
        L24:
            r103 = 8;
            r104 = 6;
            r211 = false;
            goto L6
        L11:
            r125 = (Map) r101.decodeNullableSerializableElement(r100, r103, (juc.c) r102[r103].getValue(), r125);
            r133 = r133 | 256;
        L19:
            String r135 = r132;
        L23:
            r132 = r135;
            r103 = 8;
            r104 = 6;
            goto L6
        L12:
            r127 = (Integer) r101.decodeNullableSerializableElement(r100, 7, w0.f520792a, r127);
            r133 = r133 | 128;
            goto L19
        L13:
            r126 = (Integer) r101.decodeNullableSerializableElement(r100, r104, w0.f520792a, r126);
            r133 = r133 | 64;
            goto L19
        L14:
            r129 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r129);
            r133 = r133 | 32;
            goto L19
        L15:
            r131 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r131);
            r133 = r133 | 16;
            goto L19
        L16:
            r128 = (ExpiredInfo) r101.decodeNullableSerializableElement(r100, 3, ExpiredInfo.a.f346625a, r128);
            r133 = r133 | 8;
            goto L19
        L18:
            r132 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r132);
            r133 = r133 | 4;
            goto L19
        L20:
            r135 = r132;
            r130 = (UplinkEntityContent) r101.decodeNullableSerializableElement(r100, 1, UplinkEntityContent.a.f346734a, r130);
            r133 = r133 | 2;
            goto L23
        L22:
            r135 = r132;
            r133 = r133 | 1;
            r110 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r110);
            goto L23
        L25:
            r121 = r133;
            r115 = r125;
            r116 = r127;
            r120 = r130;
            r117 = r129;
            r122 = r128;
            r123 = r132;
            Integer r212 = r131;
            r118 = r126;
            r124 = r110;
            r119 = r212;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            UplinkFileEntity r102 = (UplinkFileEntity) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346739b;
            muc.d r104 = r100.beginStructure(r103);
            UplinkFileEntity.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UplinkFileEntity> serializer() {
            return a.f346738a;
        }
    }

    public UplinkFileEntity() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, kuc.a.d(r100));
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UplinkFileEntity copy$default(UplinkFileEntity r110, Integer r111, UplinkEntityContent r112, String r113, ExpiredInfo r114, Integer r210, Integer r211, Integer r212, Integer r213, Boolean r214, boolean r215, Uri r216, String r217, Boolean r218, Map r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        Integer r100 = r110.entityType;
    L7:
        if ((r310 & 2) == 0) goto L9;
        UplinkEntityContent r101 = r110.uplinkEntityContent;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.fileIdentifier;
    L15:
        if ((r310 & 8) == 0) goto L17;
        ExpiredInfo r103 = r110.expiredInfo;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Integer r104 = r110.fileReviewStatus;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Integer r105 = r110.fileParsedStatus;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Integer r106 = r110.upLinkProcess;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Integer r107 = r110.upLinkStatus;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Boolean r115 = r110.isFromDraft;
    L39:
        if ((r310 & 512) == 0) goto L41;
        boolean r116 = r110.isHistoryReuse;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Uri r117 = r110.uri;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.instantUploadInfoJson;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Boolean r119 = r110.isOriginalImageChecked;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        Map r108 = r110.extra;
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

    @SerialName(EntityProvider.KEY_ENTITY_TYPE)
    public static /* synthetic */ void getEntityType$annotations() {
    }

    @SerialName("expired_state")
    public static /* synthetic */ void getExpiredInfo$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName(LocationMonitorConst.IDENTIFIER)
    public static /* synthetic */ void getFileIdentifier$annotations() {
    }

    @SerialName("file_parse_state")
    public static /* synthetic */ void getFileParsedStatus$annotations() {
    }

    @SerialName("file_name_state")
    public static /* synthetic */ void getFileReviewStatus$annotations() {
    }

    @Transient
    public static /* synthetic */ void getInstantUploadInfoJson$annotations() {
    }

    @SerialName("upload_process")
    public static /* synthetic */ void getUpLinkProcess$annotations() {
    }

    @SerialName("upload_status")
    public static /* synthetic */ void getUpLinkStatus$annotations() {
    }

    @SerialName("entity_content")
    public static /* synthetic */ void getUplinkEntityContent$annotations() {
    }

    @Transient
    public static /* synthetic */ void getUri$annotations() {
    }

    @Transient
    public static /* synthetic */ void isFromDraft$annotations() {
    }

    @Transient
    public static /* synthetic */ void isHistoryReuse$annotations() {
    }

    @Transient
    public static /* synthetic */ void isOriginalImageChecked$annotations() {
    }

    public final Integer component1() {
        return this.entityType;
    }

    public final boolean component10() {
        return this.isHistoryReuse;
    }

    public final Uri component11() {
        return this.uri;
    }

    public final String component12() {
        return this.instantUploadInfoJson;
    }

    public final Boolean component13() {
        return this.isOriginalImageChecked;
    }

    public final Map<String, String> component14() {
        return this.extra;
    }

    public final UplinkEntityContent component2() {
        return this.uplinkEntityContent;
    }

    public final String component3() {
        return this.fileIdentifier;
    }

    public final ExpiredInfo component4() {
        return this.expiredInfo;
    }

    public final Integer component5() {
        return this.fileReviewStatus;
    }

    public final Integer component6() {
        return this.fileParsedStatus;
    }

    public final Integer component7() {
        return this.upLinkProcess;
    }

    public final Integer component8() {
        return this.upLinkStatus;
    }

    public final Boolean component9() {
        return this.isFromDraft;
    }

    public final UplinkFileEntity copy(Integer r110, UplinkEntityContent r111, String r112, ExpiredInfo r210, Integer r211, Integer r212, Integer r213, Integer r214, Boolean r215, boolean r216, Uri r217, String r218, Boolean r219, Map<String, String> r310) {
        return new UplinkFileEntity(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UplinkFileEntity) == true) goto L8;
        return false;
    L8:
        UplinkFileEntity r101 = (UplinkFileEntity) r100;
        if (Intrinsics.areEqual(this.entityType, r101.entityType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uplinkEntityContent, r101.uplinkEntityContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileIdentifier, r101.fileIdentifier) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expiredInfo, r101.expiredInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileReviewStatus, r101.fileReviewStatus) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fileParsedStatus, r101.fileParsedStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.upLinkProcess, r101.upLinkProcess) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.upLinkStatus, r101.upLinkStatus) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isFromDraft, r101.isFromDraft) == true) goto L36;
        return false;
    L36:
        if (this.isHistoryReuse == r101.isHistoryReuse) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.instantUploadInfoJson, r101.instantUploadInfoJson) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.isOriginalImageChecked, r101.isOriginalImageChecked) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.entityType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UplinkEntityContent r104 = this.uplinkEntityContent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.fileIdentifier;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ExpiredInfo r110 = this.expiredInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.fileReviewStatus;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.fileParsedStatus;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.upLinkProcess;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.upLinkStatus;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.isFromDraft;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        if (this.isHistoryReuse == false) goto L41;
        int r128 = 1231;
    L42:
        int r129 = (r127 + r128) * 31;
        Uri r130 = this.uri;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.instantUploadInfoJson;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Boolean r136 = this.isOriginalImageChecked;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        Map<String, String> r139 = this.extra;
        if (r139 == null) goto L59;
        r101 = r139.hashCode();
    L59:
        return r138 + r101;
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = 1237;
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

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new m1())};
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(xt7.d.f565073b.a(Companion.serializer(), this));     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 != null) goto L9;
    L11:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r101);
        if (r103 == null) goto L17;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L17;
        com.larus.im.internal.delegate.a.f348188b.e("UplinkFileEntity", "convert2Json failed, stack: " + ExceptionsKt.stackTraceToString(r103));
    L17:
        if (Result.m9455isFailureimpl(r101) == false) goto L19;
        r101 = null;
    L19:
        String r104 = (String) r101;
        if (r104 != null) goto L25;
        return "";
    L25:
        return r104;
    L9:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L11;
        com.larus.im.internal.delegate.a.f348188b.e("UplinkFileEntity", "convert2Json failed, stack: " + ExceptionsKt.stackTraceToString(r102));
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final Integer getEntityType() {
        return this.entityType;
    }

    public final ExpiredInfo getExpiredInfo() {
        return this.expiredInfo;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public final Integer getFileParsedStatus() {
        return this.fileParsedStatus;
    }

    public final Integer getFileReviewStatus() {
        return this.fileReviewStatus;
    }

    public final String getInstantUploadInfoJson() {
        return this.instantUploadInfoJson;
    }

    public final Integer getUpLinkProcess() {
        return this.upLinkProcess;
    }

    public final Integer getUpLinkStatus() {
        return this.upLinkStatus;
    }

    public final UplinkEntityContent getUplinkEntityContent() {
        return this.uplinkEntityContent;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final Boolean isFromDraft() {
        return this.isFromDraft;
    }

    public final boolean isHistoryReuse() {
        return this.isHistoryReuse;
    }

    public final Boolean isOriginalImageChecked() {
        return this.isOriginalImageChecked;
    }

    public final void setEntityType(Integer r100) {
        this.entityType = r100;
    }

    public final void setExpiredInfo(ExpiredInfo r100) {
        this.expiredInfo = r100;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setFileIdentifier(String r100) {
        this.fileIdentifier = r100;
    }

    public final void setFileParsedStatus(Integer r100) {
        this.fileParsedStatus = r100;
    }

    public final void setFileReviewStatus(Integer r100) {
        this.fileReviewStatus = r100;
    }

    public final void setFromDraft(Boolean r100) {
        this.isFromDraft = r100;
    }

    public final void setHistoryReuse(boolean r100) {
        this.isHistoryReuse = r100;
    }

    public final void setInstantUploadInfoJson(String r100) {
        this.instantUploadInfoJson = r100;
    }

    public final void setOriginalImageChecked(Boolean r100) {
        this.isOriginalImageChecked = r100;
    }

    public final void setUpLinkProcess(Integer r100) {
        this.upLinkProcess = r100;
    }

    public final void setUpLinkStatus(Integer r100) {
        this.upLinkStatus = r100;
    }

    public final void setUplinkEntityContent(UplinkEntityContent r100) {
        this.uplinkEntityContent = r100;
    }

    public final void setUri(Uri r100) {
        this.uri = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(UplinkFileEntity r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, w0.f520792a, r100.entityType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, UplinkEntityContent.a.f346734a, r100.uplinkEntityContent);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.fileIdentifier);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, ExpiredInfo.a.f346625a, r100.expiredInfo);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L41;
    L40:
        boolean r109 = true;
    L48:
        if (r109 == false) goto L51;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.fileReviewStatus);
    L51:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L53;
    L52:
        boolean r110 = true;
    L60:
        if (r110 == false) goto L63;
        r101.encodeNullableSerializableElement(r102, 5, w0.f520792a, r100.fileParsedStatus);
    L63:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L65;
    L64:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 6, w0.f520792a, r100.upLinkProcess);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L77;
    L76:
        boolean r112 = true;
    L84:
        if (r112 == false) goto L87;
        r101.encodeNullableSerializableElement(r102, 7, w0.f520792a, r100.upLinkStatus);
    L87:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L90;
    L88:
        r104 = true;
    L92:
        if (r104 == false) goto L95;
        r101.encodeNullableSerializableElement(r102, 8, r103[8].getValue(), r100.extra);
        return;
    L95:
        return;
    L90:
        if (r100.extra == null) goto L92;
    L77:
        Integer r113 = r100.upLinkStatus;
        int r114 = UpLinkState.DEFAULT.getValue();
        if (r113 == null) goto L76;
        if (r113.intValue() != r114) goto L76;
        r112 = false;
        goto L84
    L65:
        Integer r115 = r100.upLinkProcess;
        if (r115 == null) goto L64;
        if (r115.intValue() != (-1)) goto L64;
        r111 = false;
        goto L72
    L53:
        Integer r116 = r100.fileParsedStatus;
        int r117 = FileParseState.SUCCESS.getValue();
        if (r116 == null) goto L52;
        if (r116.intValue() != r117) goto L52;
        r110 = false;
        goto L60
    L41:
        Integer r118 = r100.fileReviewStatus;
        int r119 = FileReviewState.ACCESS.getValue();
        if (r118 == null) goto L40;
        if (r118.intValue() != r119) goto L40;
        r109 = false;
        goto L48
    L33:
        if (r100.expiredInfo != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.fileIdentifier != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.uplinkEntityContent != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.entityType != null) goto L4;
        r105 = false;
        goto L9
    }

    public UplinkFileEntity(int r100, Integer r101, UplinkEntityContent r102, String r103, ExpiredInfo r104, Integer r105, Integer r106, Integer r110, Integer r111, Map r112, q2 r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346739b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.entityType = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.uplinkEntityContent = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.fileIdentifier = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.expiredInfo = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.fileReviewStatus = Integer.valueOf(FileReviewState.ACCESS.getValue());
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.fileParsedStatus = Integer.valueOf(FileParseState.SUCCESS.getValue());
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.upLinkProcess = -1;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.upLinkStatus = Integer.valueOf(UpLinkState.DEFAULT.getValue());
    L36:
        this.isFromDraft = null;
        this.isHistoryReuse = false;
        this.uri = null;
        this.instantUploadInfoJson = null;
        this.isOriginalImageChecked = null;
        if ((r100 & 256) != 0) goto L39;
        this.extra = null;
        return;
    L39:
        this.extra = r112;
        return;
    L35:
        this.upLinkStatus = r111;
        goto L36
    L31:
        this.upLinkProcess = r110;
        goto L33
    L27:
        this.fileParsedStatus = r106;
        goto L29
    L23:
        this.fileReviewStatus = r105;
        goto L25
    L19:
        this.expiredInfo = r104;
        goto L21
    L15:
        this.fileIdentifier = r103;
        goto L17
    L11:
        this.uplinkEntityContent = r102;
        goto L13
    L7:
        this.entityType = r101;
        goto L9
    }

    public UplinkFileEntity(Integer r100, UplinkEntityContent r101, String r102, ExpiredInfo r103, Integer r104, Integer r105, Integer r106, Integer r107, Boolean r108, boolean r110, Uri r111, String r112, Boolean r113, Map<String, String> r114) {
        this.entityType = r100;
        this.uplinkEntityContent = r101;
        this.fileIdentifier = r102;
        this.expiredInfo = r103;
        this.fileReviewStatus = r104;
        this.fileParsedStatus = r105;
        this.upLinkProcess = r106;
        this.upLinkStatus = r107;
        this.isFromDraft = r108;
        this.isHistoryReuse = r110;
        this.uri = r111;
        this.instantUploadInfoJson = r112;
        this.isOriginalImageChecked = r113;
        this.extra = r114;
    }

    public /* synthetic */ UplinkFileEntity(Integer r110, UplinkEntityContent r111, String r112, ExpiredInfo r113, Integer r210, Integer r211, Integer r212, Integer r213, Boolean r214, boolean r215, Uri r216, String r217, Boolean r218, Map r219, int r310, DefaultConstructorMarker r311) {
        Map r100 = null;
        if ((r310 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        UplinkEntityContent r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        ExpiredInfo r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Integer r105 = Integer.valueOf(FileReviewState.ACCESS.getValue());
    L23:
        if ((r310 & 32) == 0) goto L25;
        Integer r106 = Integer.valueOf(FileParseState.SUCCESS.getValue());
    L27:
        if ((r310 & 64) == 0) goto L29;
        Integer r107 = -1;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Integer r108 = Integer.valueOf(UpLinkState.DEFAULT.getValue());
    L35:
        if ((r310 & 256) == 0) goto L37;
        Boolean r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        boolean r115 = false;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Uri r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Boolean r118 = null;
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

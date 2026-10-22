package com.bytedance.flow.search.kmp.api.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u008b\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005HÆ\u0001J\u0006\u0010>\u001a\u00020\tJ\u0013\u0010?\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\tHÖ\u0001J\t\u0010C\u001a\u00020\u0005HÖ\u0001J\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\tJ%\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\bOR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010#R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0014\u0010\u0011\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u001c\u0010)\u001a\u00020\t8\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010 R\u0017\u0010-\u001a\u00020\u00058F¢\u0006\f\u0012\u0004\b.\u0010+\u001a\u0004\b/\u0010\u001c¨\u0006R"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/ChatSectionPayload;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "createTime", "", "sectionId", "", "conversationId", "sectionName", "viewType", "", "localIndex", "messageId", "isSectionName", "", "url", "unreadCount", "botId", "chatType", "sourceConversationId", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreateTime", "()J", "getSectionId", "()Ljava/lang/String;", "getConversationId", "getSectionName", "getViewType", "()I", "getLocalIndex", "getMessageId", "()Z", "getUrl", "getUnreadCount", "getBotId", "getChatType", "getSourceConversationId", "type", "getType$annotations", "()V", "getType", "stableIdentity", "getStableIdentity$annotations", "getStableIdentity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "Companion", "$serializer", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ChatSectionPayload extends ISearchDataPayload {
    public static final Parcelable.Creator<ChatSectionPayload> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f243337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f243338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f243339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f243340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f243341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f243342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f243343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f243344p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f243345q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f243346r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f243347s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f243348t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f243349u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f243350v;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ChatSectionPayload> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243351a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243352b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243352b;
        }

        static {
            a r100 = new a();
            f243351a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.payload.ChatSectionPayload", r100, 13);
            r101.j("createTime", true);
            r101.j("sectionId", true);
            r101.j("conversationId", true);
            r101.j("sectionName", true);
            r101.j("viewType", true);
            r101.j("localIndex", true);
            r101.j("messageId", true);
            r101.j("isSectionName", true);
            r101.j("url", true);
            r101.j("unreadCount", true);
            r101.j("botId", true);
            r101.j("chatType", true);
            r101.j("sourceConversationId", true);
            f243352b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            g1 r100 = g1.f520681a;
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new d[]{r100, r101, r101, r101, r102, r100, r101, i.f520705a, r101, r102, r101, r101, r101};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f243352b;
            muc.c r101 = r310.beginStructure(r100);
            int r102 = 2;
            int r103 = 0;
            if (r101.decodeSequentially() == false) goto L5;
            long r110 = r101.decodeLongElement(r100, 0);
            String r104 = r101.decodeStringElement(r100, 1);
            String r105 = r101.decodeStringElement(r100, 2);
            String r106 = r101.decodeStringElement(r100, 3);
            int r107 = r101.decodeIntElement(r100, 4);
            long r111 = r101.decodeLongElement(r100, 5);
            String r108 = r101.decodeStringElement(r100, 6);
            boolean r112 = r101.decodeBooleanElement(r100, 7);
            String r109 = r101.decodeStringElement(r100, 8);
            int r113 = r101.decodeIntElement(r100, 9);
            String r114 = r101.decodeStringElement(r100, 10);
            String r115 = r101.decodeStringElement(r100, 11);
            String r116 = r105;
            String r210 = r109;
            String r211 = r101.decodeStringElement(r100, 12);
            String r117 = r108;
            String r212 = r115;
            String r213 = r114;
            int r214 = r113;
            boolean r118 = r112;
            long r119 = r110;
            int r120 = 8191;
            String r121 = r104;
            long r122 = r111;
            int r123 = r107;
            String r124 = r106;
        L27:
            r101.endStructure(r100);
            return new ChatSectionPayload(r120, r119, r121, r116, r124, r123, r122, r117, r118, r210, r214, r213, r212, r211);
        L5:
            String r125 = null;
            String r126 = null;
            String r127 = null;
            String r215 = null;
            String r216 = null;
            String r217 = null;
            String r218 = null;
            long r219 = 0;
            long r220 = 0;
            int r128 = 0;
            int r221 = 0;
            boolean r222 = false;
            boolean r311 = true;
            String r129 = null;
        L6:
            if (r311 == false) goto L26;
            int r130 = r101.decodeElementIndex(r100);
            switch(r130) {
                case -1: goto L25;
                case 0: goto L24;
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r130);
        L23:
            r125 = r101.decodeStringElement(r100, 1);
            r103 = r103 | 2;
            goto L6
        L24:
            r220 = r101.decodeLongElement(r100, 0);
            r103 = r103 | 1;
            r102 = 2;
            goto L6
        L25:
            r102 = 2;
            r311 = false;
            goto L6
        L11:
            r127 = r101.decodeStringElement(r100, 12);
            int r131 = r103 | 4096;
        L22:
            r103 = r131;
            goto L6
        L12:
            r217 = r101.decodeStringElement(r100, 11);
            r131 = r103 | 2048;
            goto L22
        L13:
            r218 = r101.decodeStringElement(r100, 10);
            r131 = r103 | 1024;
            goto L22
        L14:
            r221 = r101.decodeIntElement(r100, 9);
            r131 = r103 | 512;
            goto L22
        L15:
            r126 = r101.decodeStringElement(r100, 8);
            r131 = r103 | 256;
            goto L22
        L16:
            r222 = r101.decodeBooleanElement(r100, 7);
            r131 = r103 | 128;
            goto L22
        L17:
            r216 = r101.decodeStringElement(r100, 6);
            r131 = r103 | 64;
            goto L22
        L18:
            r219 = r101.decodeLongElement(r100, 5);
            r131 = r103 | 32;
            goto L22
        L19:
            r128 = r101.decodeIntElement(r100, 4);
            r131 = r103 | 16;
            goto L22
        L20:
            r215 = r101.decodeStringElement(r100, 3);
            r131 = r103 | 8;
            goto L22
        L21:
            r129 = r101.decodeStringElement(r100, r102);
            r131 = r103 | 4;
            goto L22
        L26:
            r121 = r125;
            r120 = r103;
            r116 = r129;
            r123 = r128;
            r124 = r215;
            r122 = r219;
            r119 = r220;
            r210 = r126;
            r117 = r216;
            r214 = r221;
            r211 = r127;
            r118 = r222;
            String r312 = r218;
            r212 = r217;
            r213 = r312;
            goto L27
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            ChatSectionPayload r112 = (ChatSectionPayload) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f243352b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = ChatSectionPayload.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeLongElement(r100, 0, r112.f243337i);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeStringElement(r100, 1, r112.f243338j);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeStringElement(r100, 2, r112.f243339k);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeStringElement(r100, 3, r112.f243340l);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            boolean r107 = true;
        L45:
            if (r107 == false) goto L48;
            r113.encodeIntElement(r100, 4, r112.f243341m);
        L48:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
        L52:
            boolean r108 = true;
        L54:
            if (r108 == false) goto L57;
            r113.encodeLongElement(r100, 5, r112.f243342n);
        L57:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
        L61:
            boolean r109 = true;
        L63:
            if (r109 == false) goto L66;
            r113.encodeStringElement(r100, 6, r112.f243343o);
        L66:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r113.encodeBooleanElement(r100, 7, r112.f243344p);
        L75:
            if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r113.encodeStringElement(r100, 8, r112.f243345q);
        L84:
            if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r113.encodeIntElement(r100, 9, r112.f243346r);
        L93:
            if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
        L97:
            boolean r117 = true;
        L99:
            if (r117 == false) goto L102;
            r113.encodeStringElement(r100, 10, r112.f243347s);
        L102:
            if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L105;
        L106:
            boolean r118 = true;
        L108:
            if (r118 == false) goto L111;
            r113.encodeStringElement(r100, 11, r112.f243348t);
        L111:
            if (r113.shouldEncodeElementDefault(r100, 12) == false) goto L114;
        L115:
            r102 = true;
        L116:
            if (r102 == false) goto L118;
            r113.encodeStringElement(r100, 12, r112.f243349u);
        L118:
            r113.endStructure(r100);
            return;
        L114:
            if (Intrinsics.areEqual(r112.f243349u, "") == true) goto L116;
        L105:
            if (Intrinsics.areEqual(r112.f243348t, "") == false) goto L106;
            r118 = false;
            goto L108
        L96:
            if (Intrinsics.areEqual(r112.f243347s, "") == false) goto L97;
            r117 = false;
            goto L99
        L87:
            if (r112.f243346r != 0) goto L88;
            r116 = false;
            goto L90
        L78:
            if (Intrinsics.areEqual(r112.f243345q, "") == false) goto L79;
            r115 = false;
            goto L81
        L69:
            if (r112.f243344p == true) goto L70;
            r114 = false;
            goto L72
        L60:
            if (Intrinsics.areEqual(r112.f243343o, "") == false) goto L61;
            r109 = false;
            goto L63
        L51:
            if (r112.f243342n != (-1)) goto L52;
            r108 = false;
            goto L54
        L42:
            if (r112.f243341m != (-1)) goto L43;
            r107 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r112.f243340l, "") == false) goto L34;
            r106 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r112.f243339k, "") == false) goto L25;
            r105 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r112.f243338j, "") == false) goto L16;
            r104 = false;
            goto L18
        L6:
            if (r112.f243337i != (-1)) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ChatSectionPayload> serializer() {
            return a.f243351a;
        }
    }

    public static final class c implements Parcelable.Creator<ChatSectionPayload> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatSectionPayload createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            long r100 = r110.readLong();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            int r104 = r110.readInt();
            long r105 = r110.readLong();
            String r111 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r112 = true;
        L7:
            return new ChatSectionPayload(r100, r101, r102, r103, r104, r105, r111, r112, r110.readString(), r110.readInt(), r110.readString(), r110.readString(), r110.readString());
        L5:
            r112 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatSectionPayload[] newArray(int r100) {
            return new ChatSectionPayload[r100];
        }
    }

    public ChatSectionPayload() {
        this(0, null, null, null, 0, 0, null, false, 0, null, null, null, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatSectionPayload) == true) goto L8;
        return false;
    L8:
        ChatSectionPayload r101 = (ChatSectionPayload) r100;
        if (this.f243337i == r101.f243337i) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243338j, r101.f243338j) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243339k, r101.f243339k) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f243340l, r101.f243340l) == true) goto L21;
        return false;
    L21:
        if (this.f243341m == r101.f243341m) goto L24;
        return false;
    L24:
        if (this.f243342n == r101.f243342n) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f243343o, r101.f243343o) == true) goto L30;
        return false;
    L30:
        if (this.f243344p == r101.f243344p) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f243345q, r101.f243345q) == true) goto L36;
        return false;
    L36:
        if (this.f243346r == r101.f243346r) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f243347s, r101.f243347s) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f243348t, r101.f243348t) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f243349u, r101.f243349u) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f243337i;
        int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f243338j.hashCode()) * 31) + this.f243339k.hashCode()) * 31) + this.f243340l.hashCode()) * 31) + this.f243341m) * 31;
        long r102 = this.f243342n;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f243343o.hashCode()) * 31;
        if (this.f243344p == false) goto L5;
        int r104 = 1231;
    L7:
        return ((((((((((r103 + r104) * 31) + this.f243345q.hashCode()) * 31) + this.f243346r) * 31) + this.f243347s.hashCode()) * 31) + this.f243348t.hashCode()) * 31) + this.f243349u.hashCode();
    L5:
        r104 = 1237;
        goto L7
    }

    public final String toString() {
        return "ChatSectionPayload(createTime=" + this.f243337i + ", sectionId=" + this.f243338j + ", conversationId=" + this.f243339k + ", sectionName=" + this.f243340l + ", viewType=" + this.f243341m + ", localIndex=" + this.f243342n + ", messageId=" + this.f243343o + ", isSectionName=" + this.f243344p + ", url=" + this.f243345q + ", unreadCount=" + this.f243346r + ", botId=" + this.f243347s + ", chatType=" + this.f243348t + ", sourceConversationId=" + this.f243349u + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f243337i);
        r100.writeString(this.f243338j);
        r100.writeString(this.f243339k);
        r100.writeString(this.f243340l);
        r100.writeInt(this.f243341m);
        r100.writeLong(this.f243342n);
        r100.writeString(this.f243343o);
        r100.writeInt(this.f243344p ? 1 : 0);
        r100.writeString(this.f243345q);
        r100.writeInt(this.f243346r);
        r100.writeString(this.f243347s);
        r100.writeString(this.f243348t);
        r100.writeString(this.f243349u);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final String e() {
        String r100 = this.f243338j;
        if (StringsKt.isBlank(r100) == false) goto L13;
        String r101 = this.f243339k;
        if (StringsKt.isBlank(r101) == true) goto L7;
        return r101;
    L7:
        if (this.f243341m == 2) goto L9;
    L11:
        return "";
    L9:
        if ((!StringsKt.isBlank(this.f243349u)) == false) goto L11;
        return this.f243349u + "-chat-section-last";
    L13:
        return r100;
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public final String b() {
        return this.f243348t;
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public int getType() {
        return this.f243350v;
    }

    public /* synthetic */ ChatSectionPayload(long r210, String r211, String r212, String r213, int r214, long r215, String r216, boolean r310, int r311, String r312, String r313, String r314, int r315) {
        if ((r315 & 1) == 0) goto L5;
        long r100 = -1;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r315 & 16) == 0) goto L21;
        int r110 = -1;
    L23:
        if ((r315 & 32) == 0) goto L25;
        long r111 = -1;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r315 & 128) == 0) goto L33;
        boolean r113 = false;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r114 = "";
    L39:
        if ((r315 & 512) == 0) goto L41;
        int r115 = 0;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r116 = "";
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r117 = "";
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r118 = "";
    L54:
        this(r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L53:
        r118 = r314;
        goto L54
    L49:
        r117 = r313;
        goto L51
    L45:
        r116 = r312;
        goto L47
    L41:
        r115 = r311;
        goto L43
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = r310;
        goto L35
    L29:
        r112 = r216;
        goto L31
    L25:
        r111 = r215;
        goto L27
    L21:
        r110 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public ChatSectionPayload(long r110, String r111, String r112, String r113, int r114, long r115, String r210, boolean r211, String r212, int r213, String r214, String r215, String r216) {
        Intrinsics.checkNotNullParameter(r111, "sectionId");
        Intrinsics.checkNotNullParameter(r112, "conversationId");
        Intrinsics.checkNotNullParameter(r113, "sectionName");
        Intrinsics.checkNotNullParameter(r210, "messageId");
        Intrinsics.checkNotNullParameter(r212, "url");
        Intrinsics.checkNotNullParameter(r214, "botId");
        Intrinsics.checkNotNullParameter(r215, "chatType");
        Intrinsics.checkNotNullParameter(r216, "sourceConversationId");
        this.f243337i = r110;
        this.f243338j = r111;
        this.f243339k = r112;
        this.f243340l = r113;
        this.f243341m = r114;
        this.f243342n = r115;
        this.f243343o = r210;
        this.f243344p = r211;
        this.f243345q = r212;
        this.f243346r = r213;
        this.f243347s = r214;
        this.f243348t = r215;
        this.f243349u = r216;
        this.f243350v = 120;
    }

    public ChatSectionPayload(int r100, long r110, String r111, String r112, String r113, int r114, long r115, String r116, boolean r117, String r210, int r211, String r212, String r213, String r214) {
        if ((r100 & 0) != 0) goto L58;
        long r101 = -1;
        if ((r100 & 1) != 0) goto L7;
        this.f243337i = -1;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f243338j = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f243339k = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f243340l = "";
    L21:
        if ((r100 & 16) != 0) goto L23;
        int r102 = -1;
    L24:
        this.f243341m = r102;
        if ((r100 & 32) == 0) goto L28;
        r101 = r115;
    L28:
        this.f243342n = r101;
        if ((r100 & 64) != 0) goto L31;
        this.f243343o = "";
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f243344p = false;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f243345q = "";
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f243346r = 0;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f243347s = "";
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f243348t = "";
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.f243349u = "";
    L56:
        this.f243350v = 120;
        return;
    L55:
        this.f243349u = r214;
        goto L56
    L51:
        this.f243348t = r213;
        goto L53
    L47:
        this.f243347s = r212;
        goto L49
    L43:
        this.f243346r = r211;
        goto L45
    L39:
        this.f243345q = r210;
        goto L41
    L35:
        this.f243344p = r117;
        goto L37
    L31:
        this.f243343o = r116;
        goto L33
    L23:
        r102 = r114;
        goto L24
    L19:
        this.f243340l = r113;
        goto L21
    L15:
        this.f243339k = r112;
        goto L17
    L11:
        this.f243338j = r111;
        goto L13
    L7:
        this.f243337i = r110;
        goto L9
    L58:
        b2.b(r100, 0, a.f243352b);
        throw null;
    }
}

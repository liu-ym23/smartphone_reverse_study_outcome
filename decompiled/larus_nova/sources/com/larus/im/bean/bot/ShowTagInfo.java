package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Set;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
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
import uc9.a0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00060\u0001j\u0002`\u0002:\u0002LMBy\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012By\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010;\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0080\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\tHÖ\u0001J\t\u0010C\u001a\u00020\u0004HÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010#R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010#R\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010#R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010*R \u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010.\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010-R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0018\u001a\u0004\b0\u00101¨\u0006N"}, d2 = {"Lcom/larus/im/bean/bot/ShowTagInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "tagId", "", "name", "nameToShow", "starlingKey", "priority", "", "type", "position", "iconInfo", "Lcom/larus/im/bean/bot/TagIconInfo;", "tagSaveType", "tagUiKit", "Lcom/larus/im/bean/bot/TagUiKit;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILcom/larus/im/bean/bot/TagIconInfo;Ljava/lang/Integer;Lcom/larus/im/bean/bot/TagUiKit;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILcom/larus/im/bean/bot/TagIconInfo;Ljava/lang/Integer;Lcom/larus/im/bean/bot/TagUiKit;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTagId$annotations", "()V", "getTagId", "()Ljava/lang/String;", "getName$annotations", "getName", "getNameToShow$annotations", "getNameToShow", "getStarlingKey$annotations", "getStarlingKey", "getPriority$annotations", "getPriority", "()I", "getType$annotations", "getType", "getPosition$annotations", "getPosition", "getIconInfo$annotations", "getIconInfo", "()Lcom/larus/im/bean/bot/TagIconInfo;", "getTagSaveType$annotations", "getTagSaveType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagUiKit$annotations", "getTagUiKit", "()Lcom/larus/im/bean/bot/TagUiKit;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILcom/larus/im/bean/bot/TagIconInfo;Ljava/lang/Integer;Lcom/larus/im/bean/bot/TagUiKit;)Lcom/larus/im/bean/bot/ShowTagInfo;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ShowTagInfo implements java.io.Serializable {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f346497a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f346498b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Integer> f346499c = null;
    private final TagIconInfo iconInfo;
    private final String name;
    private final String nameToShow;
    private final int position;
    private final int priority;
    private final String starlingKey;
    private final String tagId;
    private final Integer tagSaveType;
    private final com.larus.im.bean.bot.a tagUiKit;
    private final int type;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ShowTagInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346500a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346501b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346501b;
        }

        static {
            a r100 = new a();
            f346500a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.ShowTagInfo", r100, 10);
            r101.j("tag_id", true);
            r101.j("tag_name", true);
            r101.j("show_tag_name", true);
            r101.j("starling_key", true);
            r101.j("priority", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, true);
            r101.j("tag_position", true);
            r101.j("icon_info", true);
            r101.j("tag_save_type", true);
            r101.j("tag_ui_kit", true);
            f346501b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d((d) ShowTagInfo.access$get$childSerializers$cp()[0].getValue()), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), r101, r101, r101, kuc.a.d(TagIconInfo.a.f346507a), kuc.a.d(r101), kuc.a.d(com.larus.im.bean.bot.a.C4334a.f346520a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346501b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = ShowTagInfo.access$get$childSerializers$cp();
            int r103 = 7;
            int r104 = 9;
            int r110 = 8;
            int r111 = 0;
            if (r101.decodeSequentially() == false) goto L5;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), null);
            v2 r106 = v2.f520790a;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 1, r106, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r106, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 3, r106, null);
            int r109 = r101.decodeIntElement(r100, 4);
            int r113 = r101.decodeIntElement(r100, 5);
            int r114 = r101.decodeIntElement(r100, 6);
            TagIconInfo r115 = (TagIconInfo) r101.decodeNullableSerializableElement(r100, 7, TagIconInfo.a.f346507a, null);
            Integer r116 = (Integer) r101.decodeNullableSerializableElement(r100, 8, w0.f520792a, null);
            int r117 = r109;
            int r118 = r113;
            int r119 = r114;
            TagIconInfo r120 = r115;
            com.larus.im.bean.bot.a r121 = (com.larus.im.bean.bot.a) r101.decodeNullableSerializableElement(r100, 9, com.larus.im.bean.bot.a.C4334a.f346520a, null);
            String r122 = r107;
            Integer r123 = r116;
            String r124 = r112;
            int r125 = 1023;
            String r126 = r105;
            String r127 = r108;
        L28:
            r101.endStructure(r100);
            return new ShowTagInfo(r125, r126, r124, r122, r127, r117, r118, r119, r120, r123, r121, null);
        L5:
            Integer r128 = null;
            com.larus.im.bean.bot.a r129 = null;
            String r130 = null;
            TagIconInfo r131 = null;
            String r132 = null;
            String r133 = null;
            String r134 = null;
            int r135 = 0;
            r118 = 0;
            r119 = 0;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L27;
            int r136 = r101.decodeElementIndex(r100);
            switch(r136) {
                case -1: goto L26;
                case 0: goto L24;
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r136);
        L19:
            r111 = r111 | 16;
            r135 = r101.decodeIntElement(r100, 4);
            goto L6
        L20:
            r111 = r111 | 8;
            r130 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r130);
        L22:
            r103 = 7;
            goto L6
        L21:
            r111 = r111 | 4;
            r132 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r132);
            goto L22
        L23:
            r111 = r111 | 2;
            String r137 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r134);
        L25:
            r134 = r137;
            r103 = 7;
            r104 = 9;
            r110 = 8;
            goto L6
        L24:
            r137 = r134;
            r133 = (String) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), r133);
            r111 = r111 | 1;
            goto L25
        L26:
            r103 = 7;
            r110 = 8;
            r211 = false;
            goto L6
        L11:
            r129 = (com.larus.im.bean.bot.a) r101.decodeNullableSerializableElement(r100, r104, com.larus.im.bean.bot.a.C4334a.f346520a, r129);
            int r138 = r111 | 512;
        L12:
            r111 = r138;
        L18:
            r118 = r118;
            goto L6
        L13:
            r128 = (Integer) r101.decodeNullableSerializableElement(r100, r110, w0.f520792a, r128);
            r138 = r111 | 256;
            goto L12
        L14:
            r131 = (TagIconInfo) r101.decodeNullableSerializableElement(r100, r103, TagIconInfo.a.f346507a, r131);
            r138 = r111 | 128;
            goto L12
        L15:
            r119 = r101.decodeIntElement(r100, 6);
            r111 = r111 | 64;
            goto L18
        L17:
            r118 = r101.decodeIntElement(r100, 5);
            r111 = r111 | 32;
            goto L18
        L27:
            String r139 = r133;
            String r140 = r134;
            r123 = r128;
            r121 = r129;
            r120 = r131;
            r125 = r111;
            r117 = r135;
            r124 = r140;
            String r212 = r132;
            r127 = r130;
            r126 = r139;
            r122 = r212;
            goto L28
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ShowTagInfo r102 = (ShowTagInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346501b;
            muc.d r104 = r100.beginStructure(r103);
            ShowTagInfo.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ShowTagInfo> serializer() {
            return a.f346500a;
        }
    }

    public ShowTagInfo() {
        this(null, null, null, null, 0, 0, 0, null, null, null, 1023, null);
    }

    public static /* synthetic */ ShowTagInfo copy$default(ShowTagInfo r110, String r111, String r112, String r113, String r114, int r115, int r116, int r117, TagIconInfo r118, Integer r210, com.larus.im.bean.bot.a r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.tagId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.nameToShow;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.starlingKey;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.priority;
    L23:
        if ((r212 & 32) == 0) goto L25;
        int r105 = r110.type;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.position;
    L31:
        if ((r212 & 128) == 0) goto L33;
        TagIconInfo r107 = r110.iconInfo;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Integer r119 = r110.tagSaveType;
    L39:
        if ((r212 & 512) == 0) goto L41;
        com.larus.im.bean.bot.a r108 = r110.tagUiKit;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
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

    @SerialName("icon_info")
    public static /* synthetic */ void getIconInfo$annotations() {
    }

    @SerialName("tag_name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("show_tag_name")
    public static /* synthetic */ void getNameToShow$annotations() {
    }

    @SerialName("tag_position")
    public static /* synthetic */ void getPosition$annotations() {
    }

    @SerialName("priority")
    public static /* synthetic */ void getPriority$annotations() {
    }

    @SerialName("starling_key")
    public static /* synthetic */ void getStarlingKey$annotations() {
    }

    @SerialName("tag_id")
    @Serializable(with = yt7.c.class)
    public static /* synthetic */ void getTagId$annotations() {
    }

    @SerialName("tag_save_type")
    public static /* synthetic */ void getTagSaveType$annotations() {
    }

    @SerialName("tag_ui_kit")
    public static /* synthetic */ void getTagUiKit$annotations() {
    }

    @SerialName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    public static /* synthetic */ void getType$annotations() {
    }

    public final String component1() {
        return this.tagId;
    }

    public final com.larus.im.bean.bot.a component10() {
        return this.tagUiKit;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.nameToShow;
    }

    public final String component4() {
        return this.starlingKey;
    }

    public final int component5() {
        return this.priority;
    }

    public final int component6() {
        return this.type;
    }

    public final int component7() {
        return this.position;
    }

    public final TagIconInfo component8() {
        return this.iconInfo;
    }

    public final Integer component9() {
        return this.tagSaveType;
    }

    public final ShowTagInfo copy(String r110, String r111, String r112, String r113, int r114, int r115, int r116, TagIconInfo r210, Integer r211, com.larus.im.bean.bot.a r212) {
        return new ShowTagInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShowTagInfo) == true) goto L8;
        return false;
    L8:
        ShowTagInfo r101 = (ShowTagInfo) r100;
        if (Intrinsics.areEqual(this.tagId, r101.tagId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nameToShow, r101.nameToShow) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.starlingKey, r101.starlingKey) == true) goto L21;
        return false;
    L21:
        if (this.priority == r101.priority) goto L24;
        return false;
    L24:
        if (this.type == r101.type) goto L27;
        return false;
    L27:
        if (this.position == r101.position) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconInfo, r101.iconInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tagSaveType, r101.tagSaveType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagUiKit, r101.tagUiKit) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.tagId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nameToShow;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.starlingKey;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((((((r109 + r111) * 31) + this.priority) * 31) + this.type) * 31) + this.position) * 31;
        TagIconInfo r113 = this.iconInfo;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.tagSaveType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        com.larus.im.bean.bot.a r119 = this.tagUiKit;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "ShowTagInfo(tagId=" + this.tagId + ", name=" + this.name + ", nameToShow=" + this.nameToShow + ", starlingKey=" + this.starlingKey + ", priority=" + this.priority + ", type=" + this.type + ", position=" + this.position + ", iconInfo=" + this.iconInfo + ", tagSaveType=" + this.tagSaveType + ", tagUiKit=" + this.tagUiKit + ')';
    }

    static {
        Companion = new b();
        f346497a = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a0()), null, null, null, null, null, null, null, null, null};
        f346498b = SetsKt.setOf(new Integer[]{2, 3, 1});
        f346499c = SetsKt.setOf(5);
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return f346497a;
    }

    public static final /* synthetic */ Set access$getCapabilityLabels$cp() {
        return f346499c;
    }

    public static final /* synthetic */ Set access$getCertificationLabels$cp() {
        return f346498b;
    }

    public final TagIconInfo getIconInfo() {
        return this.iconInfo;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameToShow() {
        return this.nameToShow;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getStarlingKey() {
        return this.starlingKey;
    }

    public final String getTagId() {
        return this.tagId;
    }

    public final Integer getTagSaveType() {
        return this.tagSaveType;
    }

    public final com.larus.im.bean.bot.a getTagUiKit() {
        return this.tagUiKit;
    }

    public final int getType() {
        return this.type;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ShowTagInfo r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = f346497a;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.tagId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.name);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.nameToShow);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.starlingKey);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeIntElement(r102, 4, r100.priority);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeIntElement(r102, 5, r100.type);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeIntElement(r102, 6, r100.position);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, TagIconInfo.a.f346507a, r100.iconInfo);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L77;
    L76:
        boolean r113 = true;
    L84:
        if (r113 == false) goto L87;
        r101.encodeNullableSerializableElement(r102, 8, w0.f520792a, r100.tagSaveType);
    L87:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L90;
    L88:
        r104 = true;
    L92:
        if (r104 == false) goto L95;
        r101.encodeNullableSerializableElement(r102, 9, com.larus.im.bean.bot.a.C4334a.f346520a, r100.tagUiKit);
        return;
    L95:
        return;
    L90:
        if (r100.tagUiKit == null) goto L92;
    L77:
        Integer r114 = r100.tagSaveType;
        if (r114 == null) goto L76;
        if (r114.intValue() != 0) goto L76;
        r113 = false;
        goto L84
    L69:
        if (r100.iconInfo != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.position != 0) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.type != 0) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.priority != 0) goto L40;
        r109 = false;
        goto L45
    L33:
        if (Intrinsics.areEqual(r100.starlingKey, "") == false) goto L31;
        r108 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r100.nameToShow, "") == false) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.name != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.tagId, "") == false) goto L4;
        r105 = false;
        goto L9
    }

    public ShowTagInfo(String r100, String r101, String r102, String r103, int r104, int r105, int r106, TagIconInfo r107, Integer r108, com.larus.im.bean.bot.a r110) {
        this.tagId = r100;
        this.name = r101;
        this.nameToShow = r102;
        this.starlingKey = r103;
        this.priority = r104;
        this.type = r105;
        this.position = r106;
        this.iconInfo = r107;
        this.tagSaveType = r108;
        this.tagUiKit = r110;
    }

    public ShowTagInfo(int r100, String r101, String r102, String r103, String r104, int r105, int r110, int r111, TagIconInfo r112, Integer r113, com.larus.im.bean.bot.a r114, q2 r115) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346501b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.tagId = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.name = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.nameToShow = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.starlingKey = "";
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.priority = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.type = 0;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.position = 0;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.iconInfo = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.tagSaveType = 0;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.tagUiKit = null;
        return;
    L43:
        this.tagUiKit = r114;
        return;
    L39:
        this.tagSaveType = r113;
        goto L41
    L35:
        this.iconInfo = r112;
        goto L37
    L31:
        this.position = r111;
        goto L33
    L27:
        this.type = r110;
        goto L29
    L23:
        this.priority = r105;
        goto L25
    L19:
        this.starlingKey = r104;
        goto L21
    L15:
        this.nameToShow = r103;
        goto L17
    L11:
        this.name = r102;
        goto L13
    L7:
        this.tagId = r101;
        goto L9
    }

    public /* synthetic */ ShowTagInfo(String r110, String r111, String r112, String r113, int r114, int r115, int r116, TagIconInfo r210, Integer r211, com.larus.im.bean.bot.a r212, int r213, DefaultConstructorMarker r214) {
        String r100 = "";
        if ((r213 & 1) == 0) goto L5;
        String r101 = "";
    L6:
        com.larus.im.bean.bot.a r102 = null;
        if ((r213 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r213 & 8) != 0) goto L19;
        r100 = r113;
    L19:
        if ((r213 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r213 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r213 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r213 & 128) == 0) goto L33;
        TagIconInfo r117 = null;
    L35:
        if ((r213 & 256) == 0) goto L37;
        Integer r108 = 0;
    L39:
        if ((r213 & 512) != 0) goto L42;
        r102 = r212;
    L42:
        this(r101, r103, r104, r100, r105, r106, r107, r117, r108, r102);
        return;
    L37:
        r108 = r211;
        goto L39
    L33:
        r117 = r210;
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

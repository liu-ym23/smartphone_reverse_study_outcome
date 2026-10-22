package com.larus.im.bean.bot;

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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 C2\u00060\u0001j\u0002`\u0002:\u0002BCB[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Ba\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u0006\u0010+\u001a\u00020\fJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jb\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\nHÖ\u0001J\t\u00109\u001a\u00020\u0004HÖ\u0001J%\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\"R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010&R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010*¨\u0006D"}, d2 = {"Lcom/larus/im/bean/bot/AnswerAction;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "name", "", "key", "icon", "Lcom/larus/im/bean/bot/ActionIcon;", "url", "position", "", "needShowName", "", "group", "Lcom/larus/im/bean/bot/GroupInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/ActionIcon;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/GroupInfo;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/ActionIcon;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/GroupInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getKey$annotations", "getKey", "getIcon$annotations", "getIcon", "()Lcom/larus/im/bean/bot/ActionIcon;", "getUrl$annotations", "getUrl", "getPosition$annotations", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNeedShowName$annotations", "getNeedShowName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGroup$annotations", "getGroup", "()Lcom/larus/im/bean/bot/GroupInfo;", "isEnd", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/ActionIcon;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/GroupInfo;)Lcom/larus/im/bean/bot/AnswerAction;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class AnswerAction implements java.io.Serializable {
    public static final b Companion = null;
    private final GroupInfo group;
    private final ActionIcon icon;
    private final String key;
    private final String name;
    private final Boolean needShowName;
    private final Integer position;
    private final String url;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<AnswerAction> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346417a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346418b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(ActionIcon.a.f346415a), kuc.a.d(r100), kuc.a.d(w0.f520792a), kuc.a.d(i.f520705a), kuc.a.d(GroupInfo.a.f346471a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346418b;
        }

        static {
            a r100 = new a();
            f346417a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.AnswerAction", r100, 7);
            r101.j("name", true);
            r101.j("key", true);
            r101.j("icon", true);
            r101.j("trigger_url", true);
            r101.j("position", true);
            r101.j("need_show_name", true);
            r101.j("group", true);
            f346418b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346418b;
            c r101 = r110.beginStructure(r100);
            int r102 = 2;
            String r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            ActionIcon r106 = (ActionIcon) r101.decodeNullableSerializableElement(r100, 2, ActionIcon.a.f346415a, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, null);
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, i.f520705a, null);
            int r112 = 127;
            String r113 = r107;
            ActionIcon r114 = r106;
            Integer r115 = r108;
            GroupInfo r116 = (GroupInfo) r101.decodeNullableSerializableElement(r100, 6, GroupInfo.a.f346471a, null);
            r111 = r104;
            String r117 = r105;
            Boolean r118 = r109;
        L23:
            r101.endStructure(r100);
            return new AnswerAction(r112, r111, r117, r114, r113, r115, r118, r116, null);
        L5:
            Integer r119 = null;
            r117 = null;
            GroupInfo r120 = null;
            ActionIcon r121 = null;
            Boolean r122 = null;
            String r123 = null;
            int r124 = 0;
            boolean r125 = true;
        L6:
            if (r125 == false) goto L22;
            int r126 = r101.decodeElementIndex(r100);
            switch(r126) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r126);
        L21:
            r102 = 2;
            r125 = false;
            goto L6
        L11:
            r120 = (GroupInfo) r101.decodeNullableSerializableElement(r100, 6, GroupInfo.a.f346471a, r120);
            r124 = r124 | 64;
        L20:
            r102 = 2;
            goto L6
        L12:
            r122 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, i.f520705a, r122);
            r124 = r124 | 32;
            goto L20
        L13:
            r119 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r119);
            r124 = r124 | 16;
            goto L20
        L14:
            r123 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r123);
            r124 = r124 | 8;
            goto L20
        L15:
            r121 = (ActionIcon) r101.decodeNullableSerializableElement(r100, r102, ActionIcon.a.f346415a, r121);
            r124 = r124 | 4;
            goto L20
        L17:
            r117 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r117);
            r124 = r124 | 2;
            goto L20
        L19:
            r124 = r124 | 1;
            r111 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r111);
            goto L20
        L22:
            r112 = r124;
            r116 = r120;
            r114 = r121;
            r113 = r123;
            r118 = r122;
            r115 = r119;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            AnswerAction r102 = (AnswerAction) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346418b;
            muc.d r104 = r100.beginStructure(r103);
            AnswerAction.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<AnswerAction> serializer() {
            return a.f346417a;
        }
    }

    public AnswerAction() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AnswerAction copy$default(AnswerAction r100, String r101, String r102, ActionIcon r103, String r104, Integer r110, Boolean r111, GroupInfo r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.key;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.icon;
    L11:
        ActionIcon r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.url;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.position;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.needShowName;
    L20:
        Boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.group;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    @SerialName("group")
    public static /* synthetic */ void getGroup$annotations() {
    }

    @SerialName("icon")
    public static /* synthetic */ void getIcon$annotations() {
    }

    @SerialName("key")
    public static /* synthetic */ void getKey$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("need_show_name")
    public static /* synthetic */ void getNeedShowName$annotations() {
    }

    @SerialName("position")
    public static /* synthetic */ void getPosition$annotations() {
    }

    @SerialName("trigger_url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.key;
    }

    public final ActionIcon component3() {
        return this.icon;
    }

    public final String component4() {
        return this.url;
    }

    public final Integer component5() {
        return this.position;
    }

    public final Boolean component6() {
        return this.needShowName;
    }

    public final GroupInfo component7() {
        return this.group;
    }

    public final AnswerAction copy(String r110, String r111, ActionIcon r112, String r113, Integer r114, Boolean r115, GroupInfo r116) {
        return new AnswerAction(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnswerAction) == true) goto L8;
        return false;
    L8:
        AnswerAction r101 = (AnswerAction) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.needShowName, r101.needShowName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.group, r101.group) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.key;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ActionIcon r107 = this.icon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.url;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.position;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.needShowName;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        GroupInfo r119 = this.group;
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
        return "AnswerAction(name=" + this.name + ", key=" + this.key + ", icon=" + this.icon + ", url=" + this.url + ", position=" + this.position + ", needShowName=" + this.needShowName + ", group=" + this.group + ')';
    }

    static {
        Companion = new b();
    }

    public final boolean isEnd() {
        Integer r100 = this.position;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.intValue() >= 0) goto L7;
        return true;
    }

    public final GroupInfo getGroup() {
        return this.group;
    }

    public final ActionIcon getIcon() {
        return this.icon;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNeedShowName() {
        return this.needShowName;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getUrl() {
        return this.url;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(AnswerAction r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.name);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.key);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, ActionIcon.a.f346415a, r100.icon);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.url);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.position);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, i.f520705a, r100.needShowName);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        r103 = true;
    L62:
        if (r103 == false) goto L65;
        r101.encodeNullableSerializableElement(r102, 6, GroupInfo.a.f346471a, r100.group);
        return;
    L65:
        return;
    L60:
        if (r100.group == null) goto L62;
    L51:
        if (Intrinsics.areEqual(r100.needShowName, Boolean.FALSE) == false) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.position != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.url != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.icon != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.key != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.name != null) goto L4;
        r104 = false;
        goto L9
    }

    public AnswerAction(String r100, String r101, ActionIcon r102, String r103, Integer r104, Boolean r105, GroupInfo r106) {
        this.name = r100;
        this.key = r101;
        this.icon = r102;
        this.url = r103;
        this.position = r104;
        this.needShowName = r105;
        this.group = r106;
    }

    public AnswerAction(int r100, String r101, String r102, ActionIcon r103, String r104, Integer r105, Boolean r106, GroupInfo r107, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346418b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.name = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.key = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.icon = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.url = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.position = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.needShowName = Boolean.FALSE;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.group = null;
        return;
    L31:
        this.group = r107;
        return;
    L27:
        this.needShowName = r106;
        goto L29
    L23:
        this.position = r105;
        goto L25
    L19:
        this.url = r104;
        goto L21
    L15:
        this.icon = r103;
        goto L17
    L11:
        this.key = r102;
        goto L13
    L7:
        this.name = r101;
        goto L9
    }

    public /* synthetic */ AnswerAction(String r100, String r101, ActionIcon r102, String r110, Integer r111, Boolean r112, GroupInfo r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        ActionIcon r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        r112 = Boolean.FALSE;
    L25:
        Boolean r107 = r112;
        if ((r114 & 64) == 0) goto L28;
        GroupInfo r117 = null;
    L29:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}

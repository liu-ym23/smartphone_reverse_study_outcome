package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
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
import nuc.w0;
import uc9.w;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00060\u0001j\u0002`\u0002:\u0002:;BU\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rB]\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\\\u0010*\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u001eR \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0018¨\u0006<"}, d2 = {"Lcom/larus/im/bean/bot/ConversationPage;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "pageList", "", "", "bizType", "defaultStatus", "showActionBar", "", "showTmplInputBox", "pagePosition", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPageList$annotations", "()V", "getPageList", "()Ljava/util/List;", "getBizType$annotations", "getBizType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultStatus$annotations", "getDefaultStatus", "getShowActionBar$annotations", "getShowActionBar", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowTmplInputBox$annotations", "getShowTmplInputBox", "getPagePosition$annotations", "getPagePosition", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/im/bean/bot/ConversationPage;", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ConversationPage implements java.io.Serializable {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f346463a = null;
    private final Integer bizType;
    private final Integer defaultStatus;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Integer> pageList;
    private final Integer pagePosition;
    private final Boolean showActionBar;
    private final Boolean showTmplInputBox;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ConversationPage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346464a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346465b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346465b;
        }

        static {
            a r100 = new a();
            f346464a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.ConversationPage", r100, 6);
            r101.j("page_list", true);
            r101.j("biz_type", true);
            r101.j("default_status", true);
            r101.j("show_action_bar", true);
            r101.j("show_tmpl_input_box", true);
            r101.j("page_position", true);
            f346465b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            i r101 = i.f520705a;
            return new d[]{kuc.a.d((d) ConversationPage.access$get$childSerializers$cp()[0].getValue()), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346465b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = ConversationPage.access$get$childSerializers$cp();
            int r103 = 2;
            Integer r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            List r104 = (List) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), null);
            w0 r105 = w0.f520792a;
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            i r108 = i.f520705a;
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, r108, null);
            Boolean r111 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, r108, null);
            List r112 = r104;
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r105, null);
            Integer r114 = r107;
            Boolean r115 = r111;
            Integer r116 = r106;
            Boolean r117 = r109;
            int r118 = 63;
        L20:
            r101.endStructure(r100);
            return new ConversationPage(r118, r112, r116, r114, r117, r115, r113, null);
        L5:
            r112 = null;
            Boolean r119 = null;
            r114 = null;
            Integer r120 = null;
            r115 = null;
            int r121 = 0;
            boolean r122 = true;
        L6:
            if (r122 == false) goto L19;
            int r123 = r101.decodeElementIndex(r100);
            switch(r123) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r123);
        L17:
            r112 = (List) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), r112);
            r121 = r121 | 1;
            r103 = 2;
            goto L6
        L18:
            r122 = false;
            goto L6
        L11:
            r121 = r121 | 32;
            r110 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r110);
            goto L6
        L12:
            r121 = r121 | 16;
            r115 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, i.f520705a, r115);
            goto L6
        L13:
            r121 = r121 | 8;
            r119 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, i.f520705a, r119);
            goto L6
        L14:
            r121 = r121 | 4;
            r114 = (Integer) r101.decodeNullableSerializableElement(r100, r103, w0.f520792a, r114);
            goto L6
        L15:
            r121 = r121 | 2;
            r120 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, r120);
            goto L6
        L19:
            r113 = r110;
            r118 = r121;
            Integer r124 = r120;
            r117 = r119;
            r116 = r124;
            goto L20
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ConversationPage r102 = (ConversationPage) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346465b;
            muc.d r104 = r100.beginStructure(r103);
            ConversationPage.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ConversationPage> serializer() {
            return a.f346464a;
        }
    }

    public ConversationPage() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationPage copy$default(ConversationPage r100, List r101, Integer r102, Integer r103, Boolean r104, Boolean r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.pageList;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.bizType;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.defaultStatus;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.showActionBar;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.showTmplInputBox;
    L17:
        Boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.pagePosition;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName("biz_type")
    public static /* synthetic */ void getBizType$annotations() {
    }

    @SerialName("default_status")
    public static /* synthetic */ void getDefaultStatus$annotations() {
    }

    @SerialName("page_list")
    public static /* synthetic */ void getPageList$annotations() {
    }

    @SerialName("page_position")
    public static /* synthetic */ void getPagePosition$annotations() {
    }

    @SerialName("show_action_bar")
    public static /* synthetic */ void getShowActionBar$annotations() {
    }

    @SerialName("show_tmpl_input_box")
    public static /* synthetic */ void getShowTmplInputBox$annotations() {
    }

    public final List<Integer> component1() {
        return this.pageList;
    }

    public final Integer component2() {
        return this.bizType;
    }

    public final Integer component3() {
        return this.defaultStatus;
    }

    public final Boolean component4() {
        return this.showActionBar;
    }

    public final Boolean component5() {
        return this.showTmplInputBox;
    }

    public final Integer component6() {
        return this.pagePosition;
    }

    public final ConversationPage copy(List<Integer> r100, Integer r110, Integer r111, Boolean r112, Boolean r113, Integer r114) {
        return new ConversationPage(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationPage) == true) goto L8;
        return false;
    L8:
        ConversationPage r101 = (ConversationPage) r100;
        if (Intrinsics.areEqual(this.pageList, r101.pageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizType, r101.bizType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultStatus, r101.defaultStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showActionBar, r101.showActionBar) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showTmplInputBox, r101.showTmplInputBox) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pagePosition, r101.pagePosition) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        List<Integer> r100 = this.pageList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bizType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.defaultStatus;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.showActionBar;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.showTmplInputBox;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.pagePosition;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "ConversationPage(pageList=" + this.pageList + ", bizType=" + this.bizType + ", defaultStatus=" + this.defaultStatus + ", showActionBar=" + this.showActionBar + ", showTmplInputBox=" + this.showTmplInputBox + ", pagePosition=" + this.pagePosition + ')';
    }

    static {
        Companion = new b();
        f346463a = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new w()), null, null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return f346463a;
    }

    public final Integer getBizType() {
        return this.bizType;
    }

    public final Integer getDefaultStatus() {
        return this.defaultStatus;
    }

    public final List<Integer> getPageList() {
        return this.pageList;
    }

    public final Integer getPagePosition() {
        return this.pagePosition;
    }

    public final Boolean getShowActionBar() {
        return this.showActionBar;
    }

    public final Boolean getShowTmplInputBox() {
        return this.showTmplInputBox;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ConversationPage r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = f346463a;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.pageList);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L14;
    L13:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L24;
        r101.encodeNullableSerializableElement(r102, 1, w0.f520792a, r100.bizType);
    L24:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L26;
    L25:
        boolean r107 = true;
    L33:
        if (r107 == false) goto L36;
        r101.encodeNullableSerializableElement(r102, 2, w0.f520792a, r100.defaultStatus);
    L36:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L39;
    L37:
        boolean r108 = true;
    L42:
        if (r108 == false) goto L45;
        r101.encodeNullableSerializableElement(r102, 3, i.f520705a, r100.showActionBar);
    L45:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L48;
    L46:
        boolean r109 = true;
    L51:
        if (r109 == false) goto L54;
        r101.encodeNullableSerializableElement(r102, 4, i.f520705a, r100.showTmplInputBox);
    L54:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L56;
    L55:
        r104 = true;
    L62:
        if (r104 == false) goto L65;
        r101.encodeNullableSerializableElement(r102, 5, w0.f520792a, r100.pagePosition);
        return;
    L65:
        return;
    L56:
        Integer r110 = r100.pagePosition;
        if (r110 == null) goto L55;
        if (r110.intValue() == 0) goto L62;
    L48:
        if (Intrinsics.areEqual(r100.showTmplInputBox, Boolean.FALSE) == false) goto L46;
        r109 = false;
        goto L51
    L39:
        if (Intrinsics.areEqual(r100.showActionBar, Boolean.FALSE) == false) goto L37;
        r108 = false;
        goto L42
    L26:
        Integer r111 = r100.defaultStatus;
        if (r111 == null) goto L25;
        if (r111.intValue() != 2) goto L25;
        r107 = false;
        goto L33
    L14:
        Integer r112 = r100.bizType;
        if (r112 == null) goto L13;
        if (r112.intValue() != 0) goto L13;
        r106 = false;
        goto L21
    L6:
        if (r100.pageList != null) goto L4;
        r105 = false;
        goto L9
    }

    public ConversationPage(List<Integer> r100, Integer r101, Integer r102, Boolean r103, Boolean r104, Integer r105) {
        this.pageList = r100;
        this.bizType = r101;
        this.defaultStatus = r102;
        this.showActionBar = r103;
        this.showTmplInputBox = r104;
        this.pagePosition = r105;
    }

    public ConversationPage(int r100, List r101, Integer r102, Integer r103, Boolean r104, Boolean r105, Integer r110, q2 r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346465b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.pageList = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.bizType = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.defaultStatus = 2;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.showActionBar = Boolean.FALSE;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.showTmplInputBox = Boolean.FALSE;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.pagePosition = 0;
        return;
    L27:
        this.pagePosition = r110;
        return;
    L23:
        this.showTmplInputBox = r105;
        goto L25
    L19:
        this.showActionBar = r104;
        goto L21
    L15:
        this.defaultStatus = r103;
        goto L17
    L11:
        this.bizType = r102;
        goto L13
    L7:
        this.pageList = r101;
        goto L9
    }

    public /* synthetic */ ConversationPage(List r100, Integer r101, Integer r102, Boolean r103, Boolean r104, Integer r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        Integer r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = 2;
    L11:
        Integer r105 = r102;
        if ((r111 & 8) == 0) goto L14;
        r103 = Boolean.FALSE;
    L14:
        Boolean r106 = r103;
        if ((r111 & 16) == 0) goto L17;
        r104 = Boolean.FALSE;
    L17:
        Boolean r107 = r104;
        if ((r111 & 32) == 0) goto L20;
        r110 = 0;
    L20:
        List r108 = r100;
        this(r108, r113, r105, r106, r107, r110);
    }
}

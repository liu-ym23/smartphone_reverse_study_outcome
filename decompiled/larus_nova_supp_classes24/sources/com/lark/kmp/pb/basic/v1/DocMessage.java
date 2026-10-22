package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0007+,-./01B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0011\u0010\u0019\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010$\u001a\u0004\b!\u0010#R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocMessage;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocMessage$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocMessage$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/DocMessage$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/DocMessage$Type;", "create_time", "", "getCreate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "update_time", "getUpdate_time", "content", "getContent", "doc_feed_id", "getDoc_feed_id", "from_id", "getFrom_id", "rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "is_i18n_message", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "i18n_info", "Lcom/lark/kmp/pb/basic/v1/DocMessage$I18nInfo;", "getI18n_info", "()Lcom/lark/kmp/pb/basic/v1/DocMessage$I18nInfo;", "newBuilder", "toString", "Builder", "Companion", "Type", "I18nInfo", "TmplParamElemType", "TmplParamElement", "TmplParamElementList", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DocMessage extends com.lark.wire.Message<DocMessage, a> {
    public static final ProtoAdapter<DocMessage> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_CONTENT = "";
    public static final long DEFAULT_CREATE_TIME = 0;
    public static final Type DEFAULT_TYPE = null;
    public static final long DEFAULT_UPDATE_TIME = 0;
    private static final long serialVersionUID = 0;
    private final String content;
    private final Long create_time;
    private final String doc_feed_id;
    private final String from_id;
    private final I18nInfo i18n_info;
    private final String id;
    private final Boolean is_i18n_message;
    private final RichText rich_text;
    private final Type type;
    private final Long update_time;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020$0\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\f¨\u0006*"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocMessage$I18nInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocMessage$I18nInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocMessage$I18nInfo$Builder;Lokio/ByteString;)V", "i18n_titles", "", "", "getI18n_titles", "()Ljava/util/Map;", "i18n_richtexts", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getI18n_richtexts", "title_tmpl_code", "", "getTitle_tmpl_code", "()Ljava/lang/Long;", "Ljava/lang/Long;", "text_tmpl_code", "getText_tmpl_code", "title_tmpl_params", "Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElement;", "getTitle_tmpl_params", "text_tmpl_params", "getText_tmpl_params", "title_tmpl_key", "getTitle_tmpl_key", "()Ljava/lang/String;", "text_tmpl_key", "getText_tmpl_key", "text_tmpl_params_v2", "getText_tmpl_params_v2", "text_tmpl_params_v3", "Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElementList;", "getText_tmpl_params_v3", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class I18nInfo extends com.lark.wire.Message<I18nInfo, a> {
        public static final ProtoAdapter<I18nInfo> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, RichText> i18n_richtexts;
        private final Map<String, String> i18n_titles;
        private final Long text_tmpl_code;
        private final String text_tmpl_key;
        private final Map<String, TmplParamElement> text_tmpl_params;
        private final Map<String, TmplParamElement> text_tmpl_params_v2;
        private final Map<String, TmplParamElementList> text_tmpl_params_v3;
        private final Long title_tmpl_code;
        private final String title_tmpl_key;
        private final Map<String, TmplParamElement> title_tmpl_params;

        public static final class a extends com.lark.wire.Message.a<I18nInfo, a> {
            public Map<String, String> d;
            public Map<String, RichText> e;
            public Long f;
            public Long g;
            public Map<String, TmplParamElement> h;
            public Map<String, TmplParamElement> i;
            public String j;
            public String k;
            public Map<String, TmplParamElement> l;
            public Map<String, TmplParamElementList> m;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new I18nInfo(this, c(), null);
            }

            public a() {
                this.d = MapsKt.emptyMap();
                this.e = MapsKt.emptyMap();
                this.h = MapsKt.emptyMap();
                this.i = MapsKt.emptyMap();
                this.l = MapsKt.emptyMap();
                this.m = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ I18nInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(I18nInfo.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new DocMessage$I18nInfo$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.i18n_titles;
            r0.e = this.i18n_richtexts;
            r0.f = this.title_tmpl_code;
            r0.g = this.text_tmpl_code;
            r0.h = this.title_tmpl_params;
            r0.i = this.text_tmpl_params;
            r0.j = this.title_tmpl_key;
            r0.k = this.text_tmpl_key;
            r0.l = this.text_tmpl_params_v2;
            r0.m = this.text_tmpl_params_v3;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(I18nInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, RichText> getI18n_richtexts() {
            return this.i18n_richtexts;
        }

        public final Map<String, String> getI18n_titles() {
            return this.i18n_titles;
        }

        public final Long getText_tmpl_code() {
            return this.text_tmpl_code;
        }

        public final String getText_tmpl_key() {
            return this.text_tmpl_key;
        }

        public final Map<String, TmplParamElement> getText_tmpl_params() {
            return this.text_tmpl_params;
        }

        public final Map<String, TmplParamElement> getText_tmpl_params_v2() {
            return this.text_tmpl_params_v2;
        }

        public final Map<String, TmplParamElementList> getText_tmpl_params_v3() {
            return this.text_tmpl_params_v3;
        }

        public final Long getTitle_tmpl_code() {
            return this.title_tmpl_code;
        }

        public final String getTitle_tmpl_key() {
            return this.title_tmpl_key;
        }

        public final Map<String, TmplParamElement> getTitle_tmpl_params() {
            return this.title_tmpl_params;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public I18nInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.i18n_titles = com.lark.wire.internal.a.d("i18n_titles", r2.d);
            this.i18n_richtexts = com.lark.wire.internal.a.d("i18n_richtexts", r2.e);
            this.title_tmpl_code = r2.f;
            this.text_tmpl_code = r2.g;
            this.title_tmpl_params = com.lark.wire.internal.a.d("title_tmpl_params", r2.h);
            this.text_tmpl_params = com.lark.wire.internal.a.d("text_tmpl_params", r2.i);
            this.title_tmpl_key = r2.j;
            this.text_tmpl_key = r2.k;
            this.text_tmpl_params_v2 = com.lark.wire.internal.a.d("text_tmpl_params_v2", r2.l);
            this.text_tmpl_params_v3 = com.lark.wire.internal.a.d("text_tmpl_params_v3", r2.m);
        }

        public /* synthetic */ I18nInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElemType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER_ID", "TEXT", "I18N_KEY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum TmplParamElemType extends Enum<TmplParamElemType> implements o0 {
        public static final ProtoAdapter<TmplParamElemType> ADAPTER = null;
        public static final b Companion = null;
        public static final TmplParamElemType I18N_KEY = null;
        public static final TmplParamElemType TEXT = null;
        public static final TmplParamElemType UNKNOWN = null;
        public static final TmplParamElemType USER_ID = null;
        public static final /* synthetic */ TmplParamElemType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<TmplParamElemType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                TmplParamElemType.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return TmplParamElemType.I18N_KEY;
            L18:
                return TmplParamElemType.TEXT;
            L19:
                return TmplParamElemType.USER_ID;
            L15:
                return TmplParamElemType.UNKNOWN;
            }

            public a(KClass<TmplParamElemType> r1, Syntax r2, TmplParamElemType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<TmplParamElemType> getEntries() {
            return b;
        }

        static {
            TmplParamElemType r0 = new TmplParamElemType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            TmplParamElemType r1 = new TmplParamElemType("USER_ID", 1, 1);
            USER_ID = r1;
            TmplParamElemType r3 = new TmplParamElemType("TEXT", 2, 2);
            TEXT = r3;
            TmplParamElemType r5 = new TmplParamElemType("I18N_KEY", 3, 3);
            I18N_KEY = r5;
            TmplParamElemType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(TmplParamElemType.class), Syntax.PROTO_2, r0);
        }

        public static TmplParamElemType[] values() {
            return (TmplParamElemType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final TmplParamElemType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return I18N_KEY;
        L18:
            return TEXT;
        L19:
            return USER_ID;
        L15:
            return UNKNOWN;
        }

        public static TmplParamElemType valueOf(String r1) {
            return (TmplParamElemType) r27.a.a(TmplParamElemType.class, r1);
        }

        public TmplParamElemType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElement;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElement$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElement$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElemType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElemType;", "content", "", "getContent", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TmplParamElement extends com.lark.wire.Message<TmplParamElement, a> {
        public static final ProtoAdapter<TmplParamElement> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final TmplParamElemType type;

        public static final class a extends com.lark.wire.Message.a<TmplParamElement, a> {
            public TmplParamElemType d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TmplParamElement(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TmplParamElement> {
            @Override // com.lark.wire.ProtoAdapter
            public final TmplParamElement c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                r1.d = TmplParamElemType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L9:
                r10.j(r4);
                goto L3
            L16:
                return new TmplParamElement(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TmplParamElement r5) {
                TmplParamElement r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + TmplParamElemType.ADAPTER.l(1, r6.getType())) + ProtoAdapter.q.l(2, r6.getContent());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TmplParamElement r5) {
                TmplParamElement r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                TmplParamElemType.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.q.i(r4, 2, r6.getContent());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TmplParamElement r5) {
                TmplParamElement r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.j(r4, 2, r6.getContent());
                TmplParamElemType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<TmplParamElement> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.DocMessage.TmplParamElement", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TmplParamElement(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TmplParamElement.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.content;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TmplParamElement.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final TmplParamElemType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TmplParamElement(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.content = r2.e;
        }

        public /* synthetic */ TmplParamElement(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElementList;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElementList$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElementList$Builder;Lokio/ByteString;)V", "tmpl_param_element_list", "", "Lcom/lark/kmp/pb/basic/v1/DocMessage$TmplParamElement;", "getTmpl_param_element_list", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TmplParamElementList extends com.lark.wire.Message<TmplParamElementList, a> {
        public static final ProtoAdapter<TmplParamElementList> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<TmplParamElement> tmpl_param_element_list;

        public static final class a extends com.lark.wire.Message.a<TmplParamElementList, a> {
            public List<TmplParamElement> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TmplParamElementList(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<TmplParamElementList> {
            @Override // com.lark.wire.ProtoAdapter
            public final TmplParamElementList c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L9;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                r1.add(TmplParamElement.ADAPTER.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "tmpl_param_element_list");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new TmplParamElementList(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TmplParamElementList r4) {
                TmplParamElementList r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + TmplParamElement.ADAPTER.a().l(1, r5.getTmpl_param_element_list());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TmplParamElementList r5) {
                TmplParamElementList r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                TmplParamElement.ADAPTER.a().i(r4, 1, r6.getTmpl_param_element_list());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, TmplParamElementList r4) {
                TmplParamElementList r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                TmplParamElement.ADAPTER.a().j(r3, 1, r5.getTmpl_param_element_list());
            }

            public b(FieldEncoding r7, KClass<TmplParamElementList> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.DocMessage.TmplParamElementList", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TmplParamElementList(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TmplParamElementList.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.tmpl_param_element_list;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TmplParamElementList.class).getSimpleName() + '@' + hashCode();
        }

        public final List<TmplParamElement> getTmpl_param_element_list() {
            return this.tmpl_param_element_list;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TmplParamElementList(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.tmpl_param_element_list = com.lark.wire.internal.a.c("tmpl_param_element_list", r2.d);
        }

        public /* synthetic */ TmplParamElementList(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocMessage$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "MENTION", "COMMENT", "REPLY", "SOLVE", "SHARE", "REOPEN", "COMMENT_REACTION", "TEMPLATE_CARD", "WITHDRAW", "CONTENT_REACTION", "WITHDRAW_CONTENT_REACTION", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type COMMENT = null;
        public static final Type COMMENT_REACTION = null;
        public static final Type CONTENT_REACTION = null;
        public static final b Companion = null;
        public static final Type MENTION = null;
        public static final Type REOPEN = null;
        public static final Type REPLY = null;
        public static final Type SHARE = null;
        public static final Type SOLVE = null;
        public static final Type TEMPLATE_CARD = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final Type WITHDRAW = null;
        public static final Type WITHDRAW_CONTENT_REACTION = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 0: goto L16;
                    case 1: goto L28;
                    case 2: goto L27;
                    case 3: goto L26;
                    case 4: goto L25;
                    case 5: goto L24;
                    case 6: goto L23;
                    case 7: goto L22;
                    case 8: goto L21;
                    case 9: goto L20;
                    case 10: goto L19;
                    case 11: goto L18;
                    default: goto L3;
                };
            L3:
                return null;
            L18:
                return Type.WITHDRAW_CONTENT_REACTION;
            L19:
                return Type.CONTENT_REACTION;
            L20:
                return Type.WITHDRAW;
            L21:
                return Type.TEMPLATE_CARD;
            L22:
                return Type.COMMENT_REACTION;
            L23:
                return Type.REOPEN;
            L24:
                return Type.SHARE;
            L25:
                return Type.SOLVE;
            L26:
                return Type.REPLY;
            L27:
                return Type.COMMENT;
            L28:
                return Type.MENTION;
            L16:
                return Type.UNKNOWN_TYPE;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            Type r1 = new Type("MENTION", 1, 1);
            MENTION = r1;
            Type r3 = new Type("COMMENT", 2, 2);
            COMMENT = r3;
            Type r5 = new Type("REPLY", 3, 3);
            REPLY = r5;
            Type r7 = new Type("SOLVE", 4, 4);
            SOLVE = r7;
            Type r9 = new Type("SHARE", 5, 5);
            SHARE = r9;
            Type r11 = new Type("REOPEN", 6, 6);
            REOPEN = r11;
            Type r13 = new Type("COMMENT_REACTION", 7, 7);
            COMMENT_REACTION = r13;
            Type r15 = new Type("TEMPLATE_CARD", 8, 8);
            TEMPLATE_CARD = r15;
            Type r14 = new Type("WITHDRAW", 9, 9);
            WITHDRAW = r14;
            Type r12 = new Type("CONTENT_REACTION", 10, 10);
            CONTENT_REACTION = r12;
            Type r10 = new Type("WITHDRAW_CONTENT_REACTION", 11, 11);
            WITHDRAW_CONTENT_REACTION = r10;
            Type[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<DocMessage, a> {
        public String d;
        public Type e;
        public Long f;
        public Long g;
        public String h;
        public String i;
        public String j;
        public RichText k;
        public Boolean l;
        public I18nInfo m;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new DocMessage(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<DocMessage> {
        @Override // com.lark.wire.ProtoAdapter
        public final DocMessage c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L21;
            switch(r4) {
                case 1: goto L19;
                case 2: goto L22;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r1.e = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L7:
            r1.m = I18nInfo.ADAPTER.c(r10);
            goto L3
        L8:
            r1.l = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L9:
            r1.k = RichText.ADAPTER.c(r10);
            goto L3
        L10:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.j = r10.i();
            goto L3
        L11:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r6 = r10.i();
            Intrinsics.checkNotNullParameter(r6, "doc_feed_id");
            r1.i = r6;
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.h = r10.i();
            goto L3
        L13:
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L14:
            r1.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r7 = r10.i();
            Intrinsics.checkNotNullParameter(r7, "id");
            r1.d = r7;
            goto L3
        L6:
            r10.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L21:
            return new DocMessage(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(DocMessage r6) {
            DocMessage r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r7.getId())) + Type.ADAPTER.l(2, r7.getType());
            t r3 = ProtoAdapter.k;
            return (((((((r2 + r3.l(3, r7.getCreate_time())) + r3.l(4, r7.getUpdate_time())) + r1.l(5, r7.getContent())) + r1.l(6, r7.getDoc_feed_id())) + r1.l(7, r7.getFrom_id())) + RichText.ADAPTER.l(8, r7.getRich_text())) + ProtoAdapter.g.l(9, r7.is_i18n_message())) + I18nInfo.ADAPTER.l(10, r7.getI18n_info());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, DocMessage r6) {
            DocMessage r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            Type.ADAPTER.i(r5, 2, r7.getType());
            t r1 = ProtoAdapter.k;
            r1.i(r5, 3, r7.getCreate_time());
            r1.i(r5, 4, r7.getUpdate_time());
            r0.i(r5, 5, r7.getContent());
            r0.i(r5, 6, r7.getDoc_feed_id());
            r0.i(r5, 7, r7.getFrom_id());
            RichText.ADAPTER.i(r5, 8, r7.getRich_text());
            ProtoAdapter.g.i(r5, 9, r7.is_i18n_message());
            I18nInfo.ADAPTER.i(r5, 10, r7.getI18n_info());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, DocMessage r6) {
            DocMessage r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            I18nInfo.ADAPTER.j(r5, 10, r7.getI18n_info());
            ProtoAdapter.g.j(r5, 9, r7.is_i18n_message());
            RichText.ADAPTER.j(r5, 8, r7.getRich_text());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 7, r7.getFrom_id());
            r0.j(r5, 6, r7.getDoc_feed_id());
            r0.j(r5, 5, r7.getContent());
            t r1 = ProtoAdapter.k;
            r1.j(r5, 4, r7.getUpdate_time());
            r1.j(r5, 3, r7.getCreate_time());
            Type.ADAPTER.j(r5, 2, r7.getType());
            r0.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<DocMessage> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.DocMessage", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ DocMessage(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_TYPE = Type.MENTION;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DocMessage.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.type;
        r0.f = this.create_time;
        r0.g = this.update_time;
        r0.h = this.content;
        r0.i = this.doc_feed_id;
        r0.j = this.from_id;
        r0.k = this.rich_text;
        r0.l = this.is_i18n_message;
        r0.m = this.i18n_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(DocMessage.class).getSimpleName() + '@' + hashCode();
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getCreate_time() {
        return this.create_time;
    }

    public final String getDoc_feed_id() {
        return this.doc_feed_id;
    }

    public final String getFrom_id() {
        return this.from_id;
    }

    public final I18nInfo getI18n_info() {
        return this.i18n_info;
    }

    public final String getId() {
        return this.id;
    }

    public final RichText getRich_text() {
        return this.rich_text;
    }

    public final Type getType() {
        return this.type;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final Boolean is_i18n_message() {
        return this.is_i18n_message;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public DocMessage(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        this.type = r2.e;
        this.create_time = r2.f;
        this.update_time = r2.g;
        this.content = r2.h;
        String r5 = r2.i;
        Intrinsics.checkNotNull(r5);
        this.doc_feed_id = r5;
        this.from_id = r2.j;
        this.rich_text = r2.k;
        this.is_i18n_message = r2.l;
        this.i18n_info = r2.m;
    }

    public /* synthetic */ DocMessage(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

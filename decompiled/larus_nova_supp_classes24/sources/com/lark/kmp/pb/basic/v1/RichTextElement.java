package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.b0;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.w;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\bK\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:<%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u000eH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$Builder;Lokio/ByteString;)V", "tag", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$Tag;", "getTag", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$Tag;", "style", "", "", "getStyle", "()Ljava/util/Map;", "property", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$PropertySet;", "getProperty", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$PropertySet;", "child_ids", "", "getChild_ids", "()Ljava/util/List;", "style_keys", "getStyle_keys", "wide_style", "getWide_style", "ser_upgrade_element", "getSer_upgrade_element", "()Lokio/ByteString;", "last_upgrade_version", "getLast_upgrade_version", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "Tag", "UnknownProperty", "ParagraphProperty", "FigureProperty", "TextProperty", "ItalicProperty", "BoldProperty", "UnderlineProperty", "AnchorProperty", "AtProperty", "AtUserGroupProperty", "MentionProperty", "MentionItem", "ImageProperty", "EmotionProperty", "ReactionProperty", "ButtonProperty", "ButtonConfirmProperty", "ButtonLoadingProperty", "SelectProperty", "ProgressSelectOptionProperty", "DivProperty", "TextableAreaProperty", "TimeProperty", "LinkProperty", "MediaProperty", "SelectMenuProperty", "MenuOption", "OverflowMenuProperty", "DatePickerProperty", "TimePickerProperty", "DatetimePickerProperty", "PropertySet", "DocsProperty", "H1Property", "H2Property", "H3Property", "H4Property", "H5Property", "H6Property", "ULProperty", "OLProperty", "LIProperty", "QuoteProperty", "CodeProperty", "CodeBlockProperty", "CodeBlockV2Property", "HRProperty", "MyAIToolProperty", "HorizontalAlign", "VerticalAlign", "TableProperty", "TableRowProperty", "TableCellProperty", "ColumnsProperty", "ColumnProperty", "ImageGalleryProperty", "MarkdownProperty", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RichTextElement extends com.lark.wire.Message<RichTextElement, a> {
    public static final ProtoAdapter<RichTextElement> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final List<String> child_ids;
    private final String last_upgrade_version;
    private final PropertySet property;
    private final ByteString ser_upgrade_element;
    private final Map<String, String> style;
    private final List<String> style_keys;
    private final Tag tag;
    private final Map<String, String> wide_style;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001c\u0010\u001eR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010$\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b%\u0010\u001e¨\u0006+"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$AnchorProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AnchorProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$AnchorProperty$Builder;Lokio/ByteString;)V", "href", "", "getHref", "()Ljava/lang/String;", "content", "getContent", "text_content", "getText_content", "special_url", "Lcom/lark/kmp/pb/basic/v1/SpecialURL;", "getSpecial_url", "()Lcom/lark/kmp/pb/basic/v1/SpecialURL;", "i18n_key", "getI18n_key", "ios_href", "getIos_href", "android_href", "getAndroid_href", "pc_href", "getPc_href", "is_custom", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "scene", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AnchorProperty$Scene;", "getScene", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$AnchorProperty$Scene;", "close_card_preview", "getClose_card_preview", "newBuilder", "toString", "Builder", "Companion", "Scene", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AnchorProperty extends com.lark.wire.Message<AnchorProperty, a> {
        public static final ProtoAdapter<AnchorProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String android_href;
        private final Boolean close_card_preview;
        private final String content;
        private final String href;
        private final String i18n_key;
        private final String ios_href;
        private final Boolean is_custom;
        private final String pc_href;
        private final Scene scene;
        private final SpecialURL special_url;
        private final String text_content;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$AnchorProperty$Scene;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "COPY_PASTE_ANCHOR", "COPY_PASTE_TEXT", "CUSTOM_EDIT", "SEVER_PARSE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Scene extends Enum<Scene> implements o0 {
            public static final ProtoAdapter<Scene> ADAPTER = null;
            public static final Scene COPY_PASTE_ANCHOR = null;
            public static final Scene COPY_PASTE_TEXT = null;
            public static final Scene CUSTOM_EDIT = null;
            public static final b Companion = null;
            public static final Scene SEVER_PARSE = null;
            public static final Scene UNKNOWN = null;
            public static final /* synthetic */ Scene[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Scene> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Scene.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<Scene> r1, Syntax r2, Scene r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Scene a(int r1) {
                    if (r1 == 0) goto L17;
                    if (r1 == 1) goto L22;
                    if (r1 == 2) goto L21;
                    if (r1 == 3) goto L20;
                    if (r1 == 4) goto L19;
                    return null;
                L19:
                    return Scene.SEVER_PARSE;
                L20:
                    return Scene.CUSTOM_EDIT;
                L21:
                    return Scene.COPY_PASTE_TEXT;
                L22:
                    return Scene.COPY_PASTE_ANCHOR;
                L17:
                    return Scene.UNKNOWN;
                }
            }

            @JvmStatic
            public static final Scene fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<Scene> getEntries() {
                return b;
            }

            static {
                Scene r0 = new Scene("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Scene r1 = new Scene("COPY_PASTE_ANCHOR", 1, 1);
                COPY_PASTE_ANCHOR = r1;
                Scene r3 = new Scene("COPY_PASTE_TEXT", 2, 2);
                COPY_PASTE_TEXT = r3;
                Scene r5 = new Scene("CUSTOM_EDIT", 3, 3);
                CUSTOM_EDIT = r5;
                Scene r7 = new Scene("SEVER_PARSE", 4, 4);
                SEVER_PARSE = r7;
                Scene[] r9 = {r0, r1, r3, r5, r7};
                a = r9;
                b = EnumEntriesKt.enumEntries(r9);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Scene.class), Syntax.PROTO_2, r0);
            }

            public static Scene[] values() {
                return (Scene[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Scene valueOf(String r1) {
                return (Scene) r27.a.a(Scene.class, r1);
            }

            public Scene(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<AnchorProperty, a> {
            public String d;
            public String e;
            public String f;
            public SpecialURL g;
            public String h;
            public String i;
            public String j;
            public String k;
            public Boolean l;
            public Scene m;
            public Boolean n;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AnchorProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AnchorProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final AnchorProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L25;
                switch(r4) {
                    case 1: goto L23;
                    case 2: goto L22;
                    case 3: goto L21;
                    case 4: goto L28;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    case 8: goto L13;
                    case 9: goto L12;
                    case 10: goto L26;
                    case 11: goto L7;
                    default: goto L6;
                };
            L26:
                r1.m = Scene.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L28:
                r1.g = SpecialURL.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L7:
                r1.n = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L12:
                r1.l = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.k = r10.i();
                goto L3
            L14:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.j = r10.i();
                goto L3
            L15:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.i = r10.i();
                goto L3
            L16:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.h = r10.i();
                goto L3
            L21:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.f = r10.i();
                goto L3
            L22:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                String r7 = r10.i();
                Intrinsics.checkNotNullParameter(r7, "content");
                r1.e = r7;
                goto L3
            L23:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                String r8 = r10.i();
                Intrinsics.checkNotNullParameter(r8, "href");
                r1.d = r8;
                goto L3
            L6:
                r10.j(r4);
                Unit r9 = Unit.INSTANCE;
                goto L3
            L25:
                return new AnchorProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AnchorProperty r6) {
                AnchorProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = (((((((r0 + r1.l(1, r7.getHref())) + r1.l(2, r7.getContent())) + r1.l(3, r7.getText_content())) + SpecialURL.ADAPTER.l(4, r7.getSpecial_url())) + r1.l(5, r7.getI18n_key())) + r1.l(6, r7.getIos_href())) + r1.l(7, r7.getAndroid_href())) + r1.l(8, r7.getPc_href());
                l r3 = ProtoAdapter.g;
                return ((r2 + r3.l(9, r7.is_custom())) + Scene.ADAPTER.l(10, r7.getScene())) + r3.l(11, r7.getClose_card_preview());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, AnchorProperty r6) {
                AnchorProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getHref());
                r0.i(r5, 2, r7.getContent());
                r0.i(r5, 3, r7.getText_content());
                SpecialURL.ADAPTER.i(r5, 4, r7.getSpecial_url());
                r0.i(r5, 5, r7.getI18n_key());
                r0.i(r5, 6, r7.getIos_href());
                r0.i(r5, 7, r7.getAndroid_href());
                r0.i(r5, 8, r7.getPc_href());
                l r1 = ProtoAdapter.g;
                r1.i(r5, 9, r7.is_custom());
                Scene.ADAPTER.i(r5, 10, r7.getScene());
                r1.i(r5, 11, r7.getClose_card_preview());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, AnchorProperty r6) {
                AnchorProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r5, 11, r7.getClose_card_preview());
                Scene.ADAPTER.j(r5, 10, r7.getScene());
                r0.j(r5, 9, r7.is_custom());
                w r1 = ProtoAdapter.q;
                r1.j(r5, 8, r7.getPc_href());
                r1.j(r5, 7, r7.getAndroid_href());
                r1.j(r5, 6, r7.getIos_href());
                r1.j(r5, 5, r7.getI18n_key());
                SpecialURL.ADAPTER.j(r5, 4, r7.getSpecial_url());
                r1.j(r5, 3, r7.getText_content());
                r1.j(r5, 2, r7.getContent());
                r1.j(r5, 1, r7.getHref());
            }

            public b(FieldEncoding r7, KClass<AnchorProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.AnchorProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AnchorProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AnchorProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.href;
            r0.e = this.content;
            r0.f = this.text_content;
            r0.g = this.special_url;
            r0.h = this.i18n_key;
            r0.i = this.ios_href;
            r0.j = this.android_href;
            r0.k = this.pc_href;
            r0.l = this.is_custom;
            r0.m = this.scene;
            r0.n = this.close_card_preview;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AnchorProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAndroid_href() {
            return this.android_href;
        }

        public final Boolean getClose_card_preview() {
            return this.close_card_preview;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getHref() {
            return this.href;
        }

        public final String getI18n_key() {
            return this.i18n_key;
        }

        public final String getIos_href() {
            return this.ios_href;
        }

        public final String getPc_href() {
            return this.pc_href;
        }

        public final Scene getScene() {
            return this.scene;
        }

        public final SpecialURL getSpecial_url() {
            return this.special_url;
        }

        public final String getText_content() {
            return this.text_content;
        }

        public final Boolean is_custom() {
            return this.is_custom;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AnchorProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.href = r4;
            String r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.content = r5;
            this.text_content = r2.f;
            this.special_url = r2.g;
            this.i18n_key = r2.h;
            this.ios_href = r2.i;
            this.android_href = r2.j;
            this.pc_href = r2.k;
            this.is_custom = r2.l;
            this.scene = r2.m;
            this.close_card_preview = r2.n;
        }

        public /* synthetic */ AnchorProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000e\u0010\u0010R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty$Builder;Lokio/ByteString;)V", "user_id", "", "getUser_id", "()Ljava/lang/String;", "content", "getContent", "is_outer", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_anonymous", "is_highlight", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AtProperty extends com.lark.wire.Message<AtProperty, a> {
        public static final ProtoAdapter<AtProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final Boolean is_anonymous;
        private final Boolean is_highlight;
        private final Boolean is_outer;
        private final String user_id;

        public static final class a extends com.lark.wire.Message.a<AtProperty, a> {
            public String d;
            public String e;
            public Boolean f;
            public Boolean g;
            public Boolean h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AtProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AtProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final AtProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "user_id");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r6 = r7.i();
                Intrinsics.checkNotNullParameter(r6, "content");
                r1.e = r6;
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L12:
                if (r4 != 4) goto L14;
                r1.g = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L14:
                if (r4 != 5) goto L15;
                r1.h = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L15:
                r7.j(r4);
                Unit r8 = Unit.INSTANCE;
                goto L3
            L22:
                return new AtProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AtProperty r5) {
                AtProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = (r0 + r1.l(1, r6.getUser_id())) + r1.l(2, r6.getContent());
                l r3 = ProtoAdapter.g;
                return ((r2 + r3.l(3, r6.is_outer())) + r3.l(4, r6.is_anonymous())) + r3.l(5, r6.is_highlight());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, AtProperty r5) {
                AtProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUser_id());
                r0.i(r4, 2, r6.getContent());
                l r1 = ProtoAdapter.g;
                r1.i(r4, 3, r6.is_outer());
                r1.i(r4, 4, r6.is_anonymous());
                r1.i(r4, 5, r6.is_highlight());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, AtProperty r5) {
                AtProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 5, r6.is_highlight());
                r0.j(r4, 4, r6.is_anonymous());
                r0.j(r4, 3, r6.is_outer());
                w r1 = ProtoAdapter.q;
                r1.j(r4, 2, r6.getContent());
                r1.j(r4, 1, r6.getUser_id());
            }

            public b(FieldEncoding r7, KClass<AtProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.AtProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AtProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AtProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.user_id;
            r0.e = this.content;
            r0.f = this.is_outer;
            r0.g = this.is_anonymous;
            r0.h = this.is_highlight;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AtProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final String getUser_id() {
            return this.user_id;
        }

        public final Boolean is_anonymous() {
            return this.is_anonymous;
        }

        public final Boolean is_highlight() {
            return this.is_highlight;
        }

        public final Boolean is_outer() {
            return this.is_outer;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AtProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.user_id = r4;
            String r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.content = r5;
            this.is_outer = r2.f;
            this.is_anonymous = r2.g;
            this.is_highlight = r2.h;
        }

        public /* synthetic */ AtProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtUserGroupProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtUserGroupProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtUserGroupProperty$Builder;Lokio/ByteString;)V", "user_group_id", "", "getUser_group_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "default_group_name", "", "getDefault_group_name", "()Ljava/lang/String;", "i18n_group_name", "", "getI18n_group_name", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AtUserGroupProperty extends com.lark.wire.Message<AtUserGroupProperty, a> {
        public static final ProtoAdapter<AtUserGroupProperty> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final String default_group_name;
        private final Map<String, String> i18n_group_name;
        private final Long user_group_id;

        public static final class a extends com.lark.wire.Message.a<AtUserGroupProperty, a> {
            public Long d;
            public String e;
            public Map<String, String> f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AtUserGroupProperty(this, c(), null);
            }

            public a() {
                this.f = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ AtUserGroupProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(AtUserGroupProperty.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new RichTextElement$AtUserGroupProperty$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.user_group_id;
            r0.e = this.default_group_name;
            r0.f = this.i18n_group_name;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AtUserGroupProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getDefault_group_name() {
            return this.default_group_name;
        }

        public final Map<String, String> getI18n_group_name() {
            return this.i18n_group_name;
        }

        public final Long getUser_group_id() {
            return this.user_group_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AtUserGroupProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.user_group_id = r2.d;
            this.default_group_name = r2.e;
            this.i18n_group_name = com.lark.wire.internal.a.d("i18n_group_name", r2.f);
        }

        public /* synthetic */ AtUserGroupProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$BoldProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$BoldProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$BoldProperty$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "i18n_key", "getI18n_key", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class BoldProperty extends com.lark.wire.Message<BoldProperty, a> {
        public static final ProtoAdapter<BoldProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final String i18n_key;

        public static final class a extends com.lark.wire.Message.a<BoldProperty, a> {
            public String d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new BoldProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<BoldProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final BoldProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "content");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L13:
                return new BoldProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(BoldProperty r5) {
                BoldProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getContent())) + r1.l(2, r6.getI18n_key());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, BoldProperty r5) {
                BoldProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getContent());
                r0.i(r4, 2, r6.getI18n_key());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, BoldProperty r5) {
                BoldProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getI18n_key());
                r0.j(r4, 1, r6.getContent());
            }

            public b(FieldEncoding r7, KClass<BoldProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.BoldProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ BoldProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BoldProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content;
            r0.e = this.i18n_key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(BoldProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final String getI18n_key() {
            return this.i18n_key;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public BoldProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.content = r4;
            this.i18n_key = r2.e;
        }

        public /* synthetic */ BoldProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty$Builder;Lokio/ByteString;)V", "title", "", "getTitle", "()Ljava/lang/String;", "text", "getText", "confirm", "getConfirm", "dismiss", "getDismiss", "title_i18n_key", "getTitle_i18n_key", "text_i18n_key", "getText_i18n_key", "confirm_i18n_key", "getConfirm_i18n_key", "dismiss_i18n_key", "getDismiss_i18n_key", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ButtonConfirmProperty extends com.lark.wire.Message<ButtonConfirmProperty, a> {
        public static final ProtoAdapter<ButtonConfirmProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String confirm;
        private final String confirm_i18n_key;
        private final String dismiss;
        private final String dismiss_i18n_key;
        private final String text;
        private final String text_i18n_key;
        private final String title;
        private final String title_i18n_key;

        public static final class a extends com.lark.wire.Message.a<ButtonConfirmProperty, a> {
            public String d;
            public String e;
            public String f;
            public String g;
            public String h;
            public String i;
            public String j;
            public String k;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ButtonConfirmProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ButtonConfirmProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ButtonConfirmProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L16;
                switch(r4) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.k = r7.i();
                goto L3
            L8:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.j = r7.i();
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.i = r7.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.h = r7.i();
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "dismiss");
                r1.g = r5;
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r6 = r7.i();
                Intrinsics.checkNotNullParameter(r6, "confirm");
                r1.f = r6;
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r8 = r7.i();
                Intrinsics.checkNotNullParameter(r8, "text");
                r1.e = r8;
                goto L3
            L14:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r9 = r7.i();
                Intrinsics.checkNotNullParameter(r9, "title");
                r1.d = r9;
                goto L3
            L6:
                r7.j(r4);
                Unit r10 = Unit.INSTANCE;
                goto L3
            L16:
                return new ButtonConfirmProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ButtonConfirmProperty r5) {
                ButtonConfirmProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((((((r0 + r1.l(1, r6.getTitle())) + r1.l(2, r6.getText())) + r1.l(3, r6.getConfirm())) + r1.l(4, r6.getDismiss())) + r1.l(5, r6.getTitle_i18n_key())) + r1.l(6, r6.getText_i18n_key())) + r1.l(7, r6.getConfirm_i18n_key())) + r1.l(8, r6.getDismiss_i18n_key());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ButtonConfirmProperty r5) {
                ButtonConfirmProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getTitle());
                r0.i(r4, 2, r6.getText());
                r0.i(r4, 3, r6.getConfirm());
                r0.i(r4, 4, r6.getDismiss());
                r0.i(r4, 5, r6.getTitle_i18n_key());
                r0.i(r4, 6, r6.getText_i18n_key());
                r0.i(r4, 7, r6.getConfirm_i18n_key());
                r0.i(r4, 8, r6.getDismiss_i18n_key());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ButtonConfirmProperty r5) {
                ButtonConfirmProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 8, r6.getDismiss_i18n_key());
                r0.j(r4, 7, r6.getConfirm_i18n_key());
                r0.j(r4, 6, r6.getText_i18n_key());
                r0.j(r4, 5, r6.getTitle_i18n_key());
                r0.j(r4, 4, r6.getDismiss());
                r0.j(r4, 3, r6.getConfirm());
                r0.j(r4, 2, r6.getText());
                r0.j(r4, 1, r6.getTitle());
            }

            public b(FieldEncoding r7, KClass<ButtonConfirmProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ButtonConfirmProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ButtonConfirmProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ButtonConfirmProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.title;
            r0.e = this.text;
            r0.f = this.confirm;
            r0.g = this.dismiss;
            r0.h = this.title_i18n_key;
            r0.i = this.text_i18n_key;
            r0.j = this.confirm_i18n_key;
            r0.k = this.dismiss_i18n_key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ButtonConfirmProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getConfirm() {
            return this.confirm;
        }

        public final String getConfirm_i18n_key() {
            return this.confirm_i18n_key;
        }

        public final String getDismiss() {
            return this.dismiss;
        }

        public final String getDismiss_i18n_key() {
            return this.dismiss_i18n_key;
        }

        public final String getText() {
            return this.text;
        }

        public final String getText_i18n_key() {
            return this.text_i18n_key;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getTitle_i18n_key() {
            return this.title_i18n_key;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ButtonConfirmProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.title = r4;
            String r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.text = r5;
            String r6 = r2.f;
            Intrinsics.checkNotNull(r6);
            this.confirm = r6;
            String r7 = r2.g;
            Intrinsics.checkNotNull(r7);
            this.dismiss = r7;
            this.title_i18n_key = r2.h;
            this.text_i18n_key = r2.i;
            this.confirm_i18n_key = r2.j;
            this.dismiss_i18n_key = r2.k;
        }

        public /* synthetic */ ButtonConfirmProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonLoadingProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonLoadingProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonLoadingProperty$Builder;Lokio/ByteString;)V", "begin", "", "getBegin", "()Ljava/lang/String;", "success", "getSuccess", "fail", "getFail", "begin_i18n_key", "getBegin_i18n_key", "success_i18n_key", "getSuccess_i18n_key", "fail_i18n_key", "getFail_i18n_key", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ButtonLoadingProperty extends com.lark.wire.Message<ButtonLoadingProperty, a> {
        public static final ProtoAdapter<ButtonLoadingProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String begin;
        private final String begin_i18n_key;
        private final String fail;
        private final String fail_i18n_key;
        private final String success;
        private final String success_i18n_key;

        public static final class a extends com.lark.wire.Message.a<ButtonLoadingProperty, a> {
            public String d;
            public String e;
            public String f;
            public String g;
            public String h;
            public String i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ButtonLoadingProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ButtonLoadingProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ButtonLoadingProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L14;
                switch(r4) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.i = r7.i();
                goto L3
            L8:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.h = r7.i();
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "fail");
                r1.f = r5;
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r6 = r7.i();
                Intrinsics.checkNotNullParameter(r6, "success");
                r1.e = r6;
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r8 = r7.i();
                Intrinsics.checkNotNullParameter(r8, "begin");
                r1.d = r8;
                goto L3
            L6:
                r7.j(r4);
                Unit r9 = Unit.INSTANCE;
                goto L3
            L14:
                return new ButtonLoadingProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ButtonLoadingProperty r5) {
                ButtonLoadingProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((((r0 + r1.l(1, r6.getBegin())) + r1.l(2, r6.getSuccess())) + r1.l(3, r6.getFail())) + r1.l(4, r6.getBegin_i18n_key())) + r1.l(5, r6.getSuccess_i18n_key())) + r1.l(6, r6.getFail_i18n_key());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ButtonLoadingProperty r5) {
                ButtonLoadingProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getBegin());
                r0.i(r4, 2, r6.getSuccess());
                r0.i(r4, 3, r6.getFail());
                r0.i(r4, 4, r6.getBegin_i18n_key());
                r0.i(r4, 5, r6.getSuccess_i18n_key());
                r0.i(r4, 6, r6.getFail_i18n_key());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ButtonLoadingProperty r5) {
                ButtonLoadingProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 6, r6.getFail_i18n_key());
                r0.j(r4, 5, r6.getSuccess_i18n_key());
                r0.j(r4, 4, r6.getBegin_i18n_key());
                r0.j(r4, 3, r6.getFail());
                r0.j(r4, 2, r6.getSuccess());
                r0.j(r4, 1, r6.getBegin());
            }

            public b(FieldEncoding r7, KClass<ButtonLoadingProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ButtonLoadingProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ButtonLoadingProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ButtonLoadingProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.begin;
            r0.e = this.success;
            r0.f = this.fail;
            r0.g = this.begin_i18n_key;
            r0.h = this.success_i18n_key;
            r0.i = this.fail_i18n_key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ButtonLoadingProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getBegin() {
            return this.begin;
        }

        public final String getBegin_i18n_key() {
            return this.begin_i18n_key;
        }

        public final String getFail() {
            return this.fail;
        }

        public final String getFail_i18n_key() {
            return this.fail_i18n_key;
        }

        public final String getSuccess() {
            return this.success;
        }

        public final String getSuccess_i18n_key() {
            return this.success_i18n_key;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ButtonLoadingProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.begin = r4;
            String r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.success = r5;
            String r6 = r2.f;
            Intrinsics.checkNotNull(r6);
            this.fail = r6;
            this.begin_i18n_key = r2.g;
            this.success_i18n_key = r2.h;
            this.fail_i18n_key = r2.i;
        }

        public /* synthetic */ ButtonLoadingProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001b\u0010\u000fR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000b¨\u0006\""}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonProperty$Builder;Lokio/ByteString;)V", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "disable", "", "getDisable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "active", "getActive", "confirm", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "getConfirm", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "loading", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonLoadingProperty;", "getLoading", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonLoadingProperty;", "is_loading", "mode", "getMode", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ButtonProperty extends com.lark.wire.Message<ButtonProperty, a> {
        public static final ProtoAdapter<ButtonProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_ACTIVE = false;
        public static final boolean DEFAULT_DISABLE = false;
        public static final boolean DEFAULT_IS_LOADING = false;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final Boolean active;
        private final ButtonConfirmProperty confirm;
        private final Boolean disable;
        private final Boolean is_loading;
        private final ButtonLoadingProperty loading;
        private final String mode;

        public static final class a extends com.lark.wire.Message.a<ButtonProperty, a> {
            public String d;
            public Boolean e;
            public Boolean f;
            public ButtonConfirmProperty g;
            public ButtonLoadingProperty h;
            public Boolean i;
            public String j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ButtonProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ButtonProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ButtonProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L15;
                switch(r4) {
                    case 1: goto L13;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.j = r7.i();
                goto L3
            L8:
                r1.i = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L9:
                r1.h = ButtonLoadingProperty.ADAPTER.c(r7);
                goto L3
            L10:
                r1.g = ButtonConfirmProperty.ADAPTER.c(r7);
                goto L3
            L11:
                r1.f = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L12:
                r1.e = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L15:
                return new ButtonProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ButtonProperty r7) {
                ButtonProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r8, "value");
                int r0 = r8.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = r0 + r1.l(1, r8.getAction_id());
                l r3 = ProtoAdapter.g;
                return (((((r2 + r3.l(2, r8.getDisable())) + r3.l(3, r8.getActive())) + ButtonConfirmProperty.ADAPTER.l(4, r8.getConfirm())) + ButtonLoadingProperty.ADAPTER.l(5, r8.getLoading())) + r3.l(6, r8.is_loading())) + r1.l(7, r8.getMode());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r6, ButtonProperty r7) {
                ButtonProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r6, 1, r8.getAction_id());
                l r1 = ProtoAdapter.g;
                r1.i(r6, 2, r8.getDisable());
                r1.i(r6, 3, r8.getActive());
                ButtonConfirmProperty.ADAPTER.i(r6, 4, r8.getConfirm());
                ButtonLoadingProperty.ADAPTER.i(r6, 5, r8.getLoading());
                r1.i(r6, 6, r8.is_loading());
                r0.i(r6, 7, r8.getMode());
                r6.a(r8.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r6, ButtonProperty r7) {
                ButtonProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                r6.d(r8.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r6, 7, r8.getMode());
                l r1 = ProtoAdapter.g;
                r1.j(r6, 6, r8.is_loading());
                ButtonLoadingProperty.ADAPTER.j(r6, 5, r8.getLoading());
                ButtonConfirmProperty.ADAPTER.j(r6, 4, r8.getConfirm());
                r1.j(r6, 3, r8.getActive());
                r1.j(r6, 2, r8.getDisable());
                r0.j(r6, 1, r8.getAction_id());
            }

            public b(FieldEncoding r7, KClass<ButtonProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ButtonProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ButtonProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ButtonProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.action_id;
            r0.e = this.disable;
            r0.f = this.active;
            r0.g = this.confirm;
            r0.h = this.loading;
            r0.i = this.is_loading;
            r0.j = this.mode;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ButtonProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final Boolean getActive() {
            return this.active;
        }

        public final ButtonConfirmProperty getConfirm() {
            return this.confirm;
        }

        public final Boolean getDisable() {
            return this.disable;
        }

        public final ButtonLoadingProperty getLoading() {
            return this.loading;
        }

        public final String getMode() {
            return this.mode;
        }

        public final Boolean is_loading() {
            return this.is_loading;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ButtonProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.action_id = r2.d;
            this.disable = r2.e;
            this.active = r2.f;
            this.confirm = r2.g;
            this.loading = r2.h;
            this.is_loading = r2.i;
            this.mode = r2.j;
        }

        public /* synthetic */ ButtonProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u001a\u001b\u001c\u001d\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Builder;Lokio/ByteString;)V", "language", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Language;", "getLanguage", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Language;", "content", "", "getContent", "()Ljava/lang/String;", "style_refs", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$StyleRef;", "getStyle_refs", "()Ljava/util/List;", "styles", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Style;", "getStyles", "newBuilder", "toString", "Builder", "Companion", "Language", "StyleType", "Style", "StyleRef", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CodeBlockProperty extends com.lark.wire.Message<CodeBlockProperty, a> {
        public static final ProtoAdapter<CodeBlockProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final Language language;
        private final List<StyleRef> style_refs;
        private final List<Style> styles;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0086\u0081\u0002\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Language;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "JS", "APACHE", "BASH", "CS", "CPLUSPLUS", "COFFE_SCRIPT", "HTML", "XML", "HTTP", "JSON", "JAVA", "MAKEFILE", "MARKDOWN", "NGINX", "OBJC", "PHP", "PERL", "PYTHON", "RUBY", "SQL", "SHELL", "GO", "SCSS", "LUA", "DJANGO", "KOTLIN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Language extends Enum<Language> implements o0 {
            public static final ProtoAdapter<Language> ADAPTER = null;
            public static final Language APACHE = null;
            public static final Language BASH = null;
            public static final Language COFFE_SCRIPT = null;
            public static final Language CPLUSPLUS = null;
            public static final Language CS = null;
            public static final b Companion = null;
            public static final Language DJANGO = null;
            public static final Language GO = null;
            public static final Language HTML = null;
            public static final Language HTTP = null;
            public static final Language JAVA = null;
            public static final Language JS = null;
            public static final Language JSON = null;
            public static final Language KOTLIN = null;
            public static final Language LUA = null;
            public static final Language MAKEFILE = null;
            public static final Language MARKDOWN = null;
            public static final Language NGINX = null;
            public static final Language OBJC = null;
            public static final Language PERL = null;
            public static final Language PHP = null;
            public static final Language PYTHON = null;
            public static final Language RUBY = null;
            public static final Language SCSS = null;
            public static final Language SHELL = null;
            public static final Language SQL = null;
            public static final Language XML = null;
            public static final /* synthetic */ Language[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Language> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Language.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<Language> r1, Syntax r2, Language r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Language a(int r0) {
                    switch(r0) {
                        case 0: goto L30;
                        case 1: goto L56;
                        case 2: goto L55;
                        case 3: goto L54;
                        case 4: goto L53;
                        case 5: goto L52;
                        case 6: goto L51;
                        case 7: goto L50;
                        case 8: goto L49;
                        case 9: goto L48;
                        case 10: goto L47;
                        case 11: goto L46;
                        case 12: goto L45;
                        case 13: goto L44;
                        case 14: goto L43;
                        case 15: goto L42;
                        case 16: goto L41;
                        case 17: goto L40;
                        case 18: goto L39;
                        case 19: goto L38;
                        case 20: goto L37;
                        case 21: goto L36;
                        case 22: goto L35;
                        case 23: goto L34;
                        case 24: goto L33;
                        case 25: goto L32;
                        default: goto L3;
                    };
                L3:
                    return null;
                L32:
                    return Language.KOTLIN;
                L33:
                    return Language.DJANGO;
                L34:
                    return Language.LUA;
                L35:
                    return Language.SCSS;
                L36:
                    return Language.GO;
                L37:
                    return Language.SHELL;
                L38:
                    return Language.SQL;
                L39:
                    return Language.RUBY;
                L40:
                    return Language.PYTHON;
                L41:
                    return Language.PERL;
                L42:
                    return Language.PHP;
                L43:
                    return Language.OBJC;
                L44:
                    return Language.NGINX;
                L45:
                    return Language.MARKDOWN;
                L46:
                    return Language.MAKEFILE;
                L47:
                    return Language.JAVA;
                L48:
                    return Language.JSON;
                L49:
                    return Language.HTTP;
                L50:
                    return Language.XML;
                L51:
                    return Language.HTML;
                L52:
                    return Language.COFFE_SCRIPT;
                L53:
                    return Language.CPLUSPLUS;
                L54:
                    return Language.CS;
                L55:
                    return Language.BASH;
                L56:
                    return Language.APACHE;
                L30:
                    return Language.JS;
                }
            }

            @JvmStatic
            public static final Language fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<Language> getEntries() {
                return b;
            }

            static {
                Language r0 = new Language("JS", 0, 0);
                JS = r0;
                Language r1 = new Language("APACHE", 1, 1);
                APACHE = r1;
                Language r3 = new Language("BASH", 2, 2);
                BASH = r3;
                Language r5 = new Language("CS", 3, 3);
                CS = r5;
                Language r7 = new Language("CPLUSPLUS", 4, 4);
                CPLUSPLUS = r7;
                Language r9 = new Language("COFFE_SCRIPT", 5, 5);
                COFFE_SCRIPT = r9;
                Language r11 = new Language("HTML", 6, 6);
                HTML = r11;
                Language r13 = new Language("XML", 7, 7);
                XML = r13;
                Language r15 = new Language("HTTP", 8, 8);
                HTTP = r15;
                Language r14 = new Language("JSON", 9, 9);
                JSON = r14;
                Language r12 = new Language("JAVA", 10, 10);
                JAVA = r12;
                Language r10 = new Language("MAKEFILE", 11, 11);
                MAKEFILE = r10;
                Language r8 = new Language("MARKDOWN", 12, 12);
                MARKDOWN = r8;
                Language r6 = new Language("NGINX", 13, 13);
                NGINX = r6;
                Language r4 = new Language("OBJC", 14, 14);
                OBJC = r4;
                Language r2 = new Language("PHP", 15, 15);
                PHP = r2;
                Language r16 = new Language("PERL", 16, 16);
                PERL = r16;
                Language r17 = new Language("PYTHON", 17, 17);
                PYTHON = r17;
                Language r19 = new Language("RUBY", 18, 18);
                RUBY = r19;
                Language r20 = new Language("SQL", 19, 19);
                SQL = r20;
                Language r21 = new Language("SHELL", 20, 20);
                SHELL = r21;
                Language r22 = new Language("GO", 21, 21);
                GO = r22;
                Language r23 = new Language("SCSS", 22, 22);
                SCSS = r23;
                Language r24 = new Language("LUA", 23, 23);
                LUA = r24;
                Language r25 = new Language("DJANGO", 24, 24);
                DJANGO = r25;
                Language r26 = new Language("KOTLIN", 25, 25);
                KOTLIN = r26;
                Language[] r27 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26};
                a = r27;
                b = EnumEntriesKt.enumEntries(r27);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Language.class), Syntax.PROTO_2, r0);
            }

            public static Language[] values() {
                return (Language[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Language valueOf(String r1) {
                return (Language) r27.a.a(Language.class, r1);
            }

            public Language(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Style;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Style$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$Style$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$StyleType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$StyleType;", "name", "", "getName", "()Ljava/lang/String;", "value", "getValue", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class Style extends com.lark.wire.Message<Style, a> {
            public static final ProtoAdapter<Style> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final String name;
            private final StyleType type;
            private final String value;

            public static final class a extends com.lark.wire.Message.a<Style, a> {
                public StyleType d;
                public String e;
                public String f;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new Style(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<Style> {
                @Override // com.lark.wire.ProtoAdapter
                public final Style c(g0 r10) {
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    a r1 = new a();
                    long r2 = r10.c();
                L3:
                    int r4 = r10.e();
                    if (r4 == (-1)) goto L19;
                    if (r4 != 1) goto L8;
                    r1.d = StyleType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L8:
                    if (r4 != 2) goto L10;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.e = r10.i();
                    goto L3
                L10:
                    if (r4 != 3) goto L11;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.f = r10.i();
                    goto L3
                L11:
                    r10.j(r4);
                    goto L3
                L19:
                    return new Style(r1, r10.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(Style r5) {
                    Style r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size() + StyleType.ADAPTER.l(1, r6.getType());
                    w r1 = ProtoAdapter.q;
                    return (r0 + r1.l(2, r6.getName())) + r1.l(3, r6.getValue());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, Style r5) {
                    Style r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    StyleType.ADAPTER.i(r4, 1, r6.getType());
                    w r0 = ProtoAdapter.q;
                    r0.i(r4, 2, r6.getName());
                    r0.i(r4, 3, r6.getValue());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, Style r5) {
                    Style r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    w r0 = ProtoAdapter.q;
                    r0.j(r4, 3, r6.getValue());
                    r0.j(r4, 2, r6.getName());
                    StyleType.ADAPTER.j(r4, 1, r6.getType());
                }

                public b(FieldEncoding r7, KClass<Style> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.CodeBlockProperty.Style", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ Style(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Style.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.type;
                r0.e = this.name;
                r0.f = this.value;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(Style.class).getSimpleName() + '@' + hashCode();
            }

            public final String getName() {
                return this.name;
            }

            public final StyleType getType() {
                return this.type;
            }

            public final String getValue() {
                return this.value;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public Style(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.type = r2.d;
                this.name = r2.e;
                this.value = r2.f;
            }

            public /* synthetic */ Style(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$StyleRef;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$StyleRef$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$StyleRef$Builder;Lokio/ByteString;)V", "location", "", "getLocation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "length", "getLength", "style_ids", "", "getStyle_ids", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class StyleRef extends com.lark.wire.Message<StyleRef, a> {
            public static final ProtoAdapter<StyleRef> ADAPTER = null;
            public static final c Companion = null;
            public static final int DEFAULT_LENGTH = 0;
            public static final int DEFAULT_LOCATION = 0;
            private static final long serialVersionUID = 0;
            private final Integer length;
            private final Integer location;
            private final List<Integer> style_ids;

            public static final class a extends com.lark.wire.Message.a<StyleRef, a> {
                public Integer d;
                public Integer e;
                public List<Integer> f;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new StyleRef(this, c(), null);
                }

                public a() {
                    this.f = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<StyleRef> {
                @Override // com.lark.wire.ProtoAdapter
                public final StyleRef c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r0 = new a();
                    ArrayList r1 = new ArrayList();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L15;
                    if (r4 != 1) goto L8;
                    r0.d = (Integer) ProtoAdapter.h.c(r7);
                    goto L3
                L8:
                    if (r4 != 2) goto L10;
                    r0.e = (Integer) ProtoAdapter.h.c(r7);
                    goto L3
                L10:
                    if (r4 != 3) goto L11;
                    r1.add(ProtoAdapter.h.c(r7));
                    goto L3
                L11:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L15:
                    ByteString r8 = r7.d(r2);
                    Intrinsics.checkNotNullParameter(r1, "style_ids");
                    com.lark.wire.internal.a.a(r1);
                    r0.f = r1;
                    return new StyleRef(r0, r8, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(StyleRef r5) {
                    StyleRef r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size();
                    s r1 = ProtoAdapter.h;
                    return ((r0 + r1.l(1, r6.getLocation())) + r1.l(2, r6.getLength())) + r1.a().l(3, r6.getStyle_ids());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, StyleRef r5) {
                    StyleRef r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    s r0 = ProtoAdapter.h;
                    r0.i(r4, 1, r6.getLocation());
                    r0.i(r4, 2, r6.getLength());
                    r0.a().i(r4, 3, r6.getStyle_ids());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r5, StyleRef r6) {
                    StyleRef r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    r5.d(r7.unknownFields());
                    s r0 = ProtoAdapter.h;
                    r0.a().j(r5, 3, r7.getStyle_ids());
                    r0.j(r5, 2, r7.getLength());
                    r0.j(r5, 1, r7.getLocation());
                }

                public b(FieldEncoding r7, KClass<StyleRef> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.CodeBlockProperty.StyleRef", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ StyleRef(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(StyleRef.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.location;
                r0.e = this.length;
                r0.f = this.style_ids;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(StyleRef.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getLength() {
                return this.length;
            }

            public final Integer getLocation() {
                return this.location;
            }

            public final List<Integer> getStyle_ids() {
                return this.style_ids;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public StyleRef(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.location = r2.d;
                this.length = r2.e;
                this.style_ids = com.lark.wire.internal.a.c("style_ids", r2.f);
            }

            public /* synthetic */ StyleRef(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty$StyleType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CUSTOMIZE", "GRAMMAR", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum StyleType extends Enum<StyleType> implements o0 {
            public static final ProtoAdapter<StyleType> ADAPTER = null;
            public static final StyleType CUSTOMIZE = null;
            public static final b Companion = null;
            public static final StyleType GRAMMAR = null;
            public static final /* synthetic */ StyleType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<StyleType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    StyleType.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return StyleType.GRAMMAR;
                L9:
                    return StyleType.CUSTOMIZE;
                }

                public a(KClass<StyleType> r1, Syntax r2, StyleType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<StyleType> getEntries() {
                return b;
            }

            static {
                StyleType r0 = new StyleType("CUSTOMIZE", 0, 0);
                CUSTOMIZE = r0;
                StyleType r1 = new StyleType("GRAMMAR", 1, 1);
                GRAMMAR = r1;
                StyleType[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(StyleType.class), Syntax.PROTO_2, r0);
            }

            public static StyleType[] values() {
                return (StyleType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final StyleType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return GRAMMAR;
            L9:
                return CUSTOMIZE;
            }

            public static StyleType valueOf(String r1) {
                return (StyleType) r27.a.a(StyleType.class, r1);
            }

            public StyleType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<CodeBlockProperty, a> {
            public Language d;
            public String e;
            public List<StyleRef> f;
            public List<Style> g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CodeBlockProperty(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
                this.g = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<CodeBlockProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final CodeBlockProperty c(g0 r12) {
                Intrinsics.checkNotNullParameter(r12, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                ArrayList r3 = new ArrayList();
                long r4 = r12.c();
            L3:
                int r6 = r12.e();
                if (r6 == (-1)) goto L21;
                if (r6 != 1) goto L8;
                r1.d = Language.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L8:
                if (r6 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.e = r12.i();
                goto L3
            L10:
                if (r6 != 3) goto L12;
                r2.add(StyleRef.ADAPTER.c(r12));
                goto L3
            L12:
                if (r6 != 4) goto L13;
                r3.add(Style.ADAPTER.c(r12));
                goto L3
            L13:
                r12.j(r6);
                goto L3
            L21:
                ByteString r13 = r12.d(r4);
                Intrinsics.checkNotNullParameter(r2, "style_refs");
                com.lark.wire.internal.a.a(r2);
                r1.f = r2;
                Intrinsics.checkNotNullParameter(r3, "styles");
                com.lark.wire.internal.a.a(r3);
                r1.g = r3;
                return new CodeBlockProperty(r1, r13, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CodeBlockProperty r5) {
                CodeBlockProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((r6.unknownFields().size() + Language.ADAPTER.l(1, r6.getLanguage())) + ProtoAdapter.q.l(2, r6.getContent())) + StyleRef.ADAPTER.a().l(3, r6.getStyle_refs())) + Style.ADAPTER.a().l(4, r6.getStyles());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CodeBlockProperty r5) {
                CodeBlockProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Language.ADAPTER.i(r4, 1, r6.getLanguage());
                ProtoAdapter.q.i(r4, 2, r6.getContent());
                StyleRef.ADAPTER.a().i(r4, 3, r6.getStyle_refs());
                Style.ADAPTER.a().i(r4, 4, r6.getStyles());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CodeBlockProperty r5) {
                CodeBlockProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                Style.ADAPTER.a().j(r4, 4, r6.getStyles());
                StyleRef.ADAPTER.a().j(r4, 3, r6.getStyle_refs());
                ProtoAdapter.q.j(r4, 2, r6.getContent());
                Language.ADAPTER.j(r4, 1, r6.getLanguage());
            }

            public b(FieldEncoding r7, KClass<CodeBlockProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.CodeBlockProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CodeBlockProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CodeBlockProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.language;
            r0.e = this.content;
            r0.f = this.style_refs;
            r0.g = this.styles;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CodeBlockProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final Language getLanguage() {
            return this.language;
        }

        public final List<StyleRef> getStyle_refs() {
            return this.style_refs;
        }

        public final List<Style> getStyles() {
            return this.styles;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CodeBlockProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.language = r2.d;
            this.content = r2.e;
            this.style_refs = com.lark.wire.internal.a.c("style_refs", r2.f);
            this.styles = com.lark.wire.internal.a.c("styles", r2.g);
        }

        public /* synthetic */ CodeBlockProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u001e\u001f !\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Builder;Lokio/ByteString;)V", "language", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Language;", "getLanguage", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Language;", "contents", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$LineContent;", "getContents", "()Ljava/util/List;", "word_wrap", "", "getWord_wrap", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "version", "", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "Language", "ContentType", "Content", "LineContent", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CodeBlockV2Property extends com.lark.wire.Message<CodeBlockV2Property, a> {
        public static final ProtoAdapter<CodeBlockV2Property> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<LineContent> contents;
        private final Language language;
        private final Integer version;
        private final Boolean word_wrap;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Content;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Content$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Content$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$ContentType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$ContentType;", "style", "", "getStyle", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class Content extends com.lark.wire.Message<Content, a> {
            public static final ProtoAdapter<Content> ADAPTER = null;
            public static final b Companion = null;
            private static final long serialVersionUID = 0;
            private final String content;
            private final Map<String, String> style;
            private final ContentType type;

            public static final class a extends com.lark.wire.Message.a<Content, a> {
                public String d;
                public ContentType e;
                public Map<String, String> f;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new Content(this, c(), null);
                }

                public a() {
                    this.f = MapsKt.emptyMap();
                }
            }

            public static final class b {
                public b() {
                }
            }

            public /* synthetic */ Content(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new b();
                final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
                final KClass r1 = Reflection.getOrCreateKotlinClass(Content.class);
                final Syntax r2 = Syntax.PROTO_2;
                ADAPTER = new RichTextElement$CodeBlockV2Property$Content$Companion$ADAPTER$1(r0, r1, r2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.content;
                r0.e = this.type;
                r0.f = this.style;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(Content.class).getSimpleName() + '@' + hashCode();
            }

            public final String getContent() {
                return this.content;
            }

            public final Map<String, String> getStyle() {
                return this.style;
            }

            public final ContentType getType() {
                return this.type;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public Content(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.content = r2.d;
                this.type = r2.e;
                this.style = com.lark.wire.internal.a.d("style", r2.f);
            }

            public /* synthetic */ Content(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b9\b\u0086\u0081\u0002\u0018\u0000 <2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001<B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;¨\u0006="}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$ContentType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "KEYWORD", "BUILT_IN", "TYPE", "LITERAL", "NUMBER", "OPERATOR", "PUNCTUATION", "PROPERTY", "REGEXP", "STRING", "CHAR_ESCAPE", "SUBST", "SYMBOL", "CLASS", "FUNCTION", "VARIABLE", "VARIABLE_LANGUAGE", "VARIABLE_CONSTANT", "TITLE", "TITLE_CLASS", "TITLE_CLASS_INHERITED", "TITLE_FUNCTION", "TITLE_FUNCTION_INVOKE", "PARAMS", "COMMENT", "DOCTAG", "META", "META_PROMPT", "META_KEYWORD", "META_STRING", "SECTION", "TAG", "NAME", "ATTR", "ATTRIBUTE", "BULLET", "CODE", "EMPHASIS", "FORMULA", "LINK", "QUOTE", "SELECTOR_TAG", "SELECTOR_ID", "SELECTOR_CLASS", "SELECTOR_ATTR", "SELECTOR_PSEUDO", "TEMPLATE_TAG", "TEMPLATE_VARIABLE", "ADDITION", "DELETION", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum ContentType extends Enum<ContentType> implements o0 {
            public static final ProtoAdapter<ContentType> ADAPTER = null;
            public static final ContentType ADDITION = null;
            public static final ContentType ATTR = null;
            public static final ContentType ATTRIBUTE = null;
            public static final ContentType BUILT_IN = null;
            public static final ContentType BULLET = null;
            public static final ContentType CHAR_ESCAPE = null;
            public static final ContentType CLASS = null;
            public static final ContentType CODE = null;
            public static final ContentType COMMENT = null;
            public static final b Companion = null;
            public static final ContentType DELETION = null;
            public static final ContentType DOCTAG = null;
            public static final ContentType EMPHASIS = null;
            public static final ContentType FORMULA = null;
            public static final ContentType FUNCTION = null;
            public static final ContentType KEYWORD = null;
            public static final ContentType LINK = null;
            public static final ContentType LITERAL = null;
            public static final ContentType META = null;
            public static final ContentType META_KEYWORD = null;
            public static final ContentType META_PROMPT = null;
            public static final ContentType META_STRING = null;
            public static final ContentType NAME = null;
            public static final ContentType NUMBER = null;
            public static final ContentType OPERATOR = null;
            public static final ContentType PARAMS = null;
            public static final ContentType PROPERTY = null;
            public static final ContentType PUNCTUATION = null;
            public static final ContentType QUOTE = null;
            public static final ContentType REGEXP = null;
            public static final ContentType SECTION = null;
            public static final ContentType SELECTOR_ATTR = null;
            public static final ContentType SELECTOR_CLASS = null;
            public static final ContentType SELECTOR_ID = null;
            public static final ContentType SELECTOR_PSEUDO = null;
            public static final ContentType SELECTOR_TAG = null;
            public static final ContentType STRING = null;
            public static final ContentType SUBST = null;
            public static final ContentType SYMBOL = null;
            public static final ContentType TAG = null;
            public static final ContentType TEMPLATE_TAG = null;
            public static final ContentType TEMPLATE_VARIABLE = null;
            public static final ContentType TEXT = null;
            public static final ContentType TITLE = null;
            public static final ContentType TITLE_CLASS = null;
            public static final ContentType TITLE_CLASS_INHERITED = null;
            public static final ContentType TITLE_FUNCTION = null;
            public static final ContentType TITLE_FUNCTION_INVOKE = null;
            public static final ContentType TYPE = null;
            public static final ContentType VARIABLE = null;
            public static final ContentType VARIABLE_CONSTANT = null;
            public static final ContentType VARIABLE_LANGUAGE = null;
            public static final /* synthetic */ ContentType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<ContentType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    ContentType.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<ContentType> r1, Syntax r2, ContentType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static ContentType a(int r0) {
                    switch(r0) {
                        case 0: goto L55;
                        case 1: goto L106;
                        case 2: goto L105;
                        case 3: goto L104;
                        case 4: goto L103;
                        case 5: goto L102;
                        case 6: goto L101;
                        case 7: goto L100;
                        case 8: goto L99;
                        case 9: goto L98;
                        case 10: goto L97;
                        case 11: goto L96;
                        case 12: goto L95;
                        case 13: goto L94;
                        case 14: goto L93;
                        case 15: goto L92;
                        case 16: goto L91;
                        case 17: goto L90;
                        case 18: goto L89;
                        case 19: goto L88;
                        case 20: goto L87;
                        case 21: goto L86;
                        case 22: goto L85;
                        case 23: goto L84;
                        case 24: goto L83;
                        case 25: goto L82;
                        case 26: goto L81;
                        case 27: goto L80;
                        case 28: goto L79;
                        case 29: goto L78;
                        case 30: goto L77;
                        case 31: goto L76;
                        case 32: goto L75;
                        case 33: goto L74;
                        case 34: goto L73;
                        case 35: goto L72;
                        case 36: goto L71;
                        case 37: goto L70;
                        case 38: goto L69;
                        case 39: goto L68;
                        case 40: goto L67;
                        case 41: goto L66;
                        case 42: goto L65;
                        case 43: goto L64;
                        case 44: goto L63;
                        case 45: goto L62;
                        case 46: goto L61;
                        case 47: goto L60;
                        case 48: goto L59;
                        case 49: goto L58;
                        case 50: goto L57;
                        default: goto L3;
                    };
                L3:
                    return null;
                L57:
                    return ContentType.DELETION;
                L58:
                    return ContentType.ADDITION;
                L59:
                    return ContentType.TEMPLATE_VARIABLE;
                L60:
                    return ContentType.TEMPLATE_TAG;
                L61:
                    return ContentType.SELECTOR_PSEUDO;
                L62:
                    return ContentType.SELECTOR_ATTR;
                L63:
                    return ContentType.SELECTOR_CLASS;
                L64:
                    return ContentType.SELECTOR_ID;
                L65:
                    return ContentType.SELECTOR_TAG;
                L66:
                    return ContentType.QUOTE;
                L67:
                    return ContentType.LINK;
                L68:
                    return ContentType.FORMULA;
                L69:
                    return ContentType.EMPHASIS;
                L70:
                    return ContentType.CODE;
                L71:
                    return ContentType.BULLET;
                L72:
                    return ContentType.ATTRIBUTE;
                L73:
                    return ContentType.ATTR;
                L74:
                    return ContentType.NAME;
                L75:
                    return ContentType.TAG;
                L76:
                    return ContentType.SECTION;
                L77:
                    return ContentType.META_STRING;
                L78:
                    return ContentType.META_KEYWORD;
                L79:
                    return ContentType.META_PROMPT;
                L80:
                    return ContentType.META;
                L81:
                    return ContentType.DOCTAG;
                L82:
                    return ContentType.COMMENT;
                L83:
                    return ContentType.PARAMS;
                L84:
                    return ContentType.TITLE_FUNCTION_INVOKE;
                L85:
                    return ContentType.TITLE_FUNCTION;
                L86:
                    return ContentType.TITLE_CLASS_INHERITED;
                L87:
                    return ContentType.TITLE_CLASS;
                L88:
                    return ContentType.TITLE;
                L89:
                    return ContentType.VARIABLE_CONSTANT;
                L90:
                    return ContentType.VARIABLE_LANGUAGE;
                L91:
                    return ContentType.VARIABLE;
                L92:
                    return ContentType.FUNCTION;
                L93:
                    return ContentType.CLASS;
                L94:
                    return ContentType.SYMBOL;
                L95:
                    return ContentType.SUBST;
                L96:
                    return ContentType.CHAR_ESCAPE;
                L97:
                    return ContentType.STRING;
                L98:
                    return ContentType.REGEXP;
                L99:
                    return ContentType.PROPERTY;
                L100:
                    return ContentType.PUNCTUATION;
                L101:
                    return ContentType.OPERATOR;
                L102:
                    return ContentType.NUMBER;
                L103:
                    return ContentType.LITERAL;
                L104:
                    return ContentType.TYPE;
                L105:
                    return ContentType.BUILT_IN;
                L106:
                    return ContentType.KEYWORD;
                L55:
                    return ContentType.TEXT;
                }
            }

            @JvmStatic
            public static final ContentType fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<ContentType> getEntries() {
                return b;
            }

            static {
                ContentType r0 = new ContentType("TEXT", 0, 0);
                TEXT = r0;
                ContentType r1 = new ContentType("KEYWORD", 1, 1);
                KEYWORD = r1;
                ContentType r2 = new ContentType("BUILT_IN", 2, 2);
                BUILT_IN = r2;
                ContentType r3 = new ContentType("TYPE", 3, 3);
                TYPE = r3;
                ContentType r4 = new ContentType("LITERAL", 4, 4);
                LITERAL = r4;
                ContentType r5 = new ContentType("NUMBER", 5, 5);
                NUMBER = r5;
                ContentType r6 = new ContentType("OPERATOR", 6, 6);
                OPERATOR = r6;
                ContentType r7 = new ContentType("PUNCTUATION", 7, 7);
                PUNCTUATION = r7;
                ContentType r8 = new ContentType("PROPERTY", 8, 8);
                PROPERTY = r8;
                ContentType r9 = new ContentType("REGEXP", 9, 9);
                REGEXP = r9;
                ContentType r10 = new ContentType("STRING", 10, 10);
                STRING = r10;
                ContentType r11 = new ContentType("CHAR_ESCAPE", 11, 11);
                CHAR_ESCAPE = r11;
                ContentType r12 = new ContentType("SUBST", 12, 12);
                SUBST = r12;
                ContentType r13 = new ContentType("SYMBOL", 13, 13);
                SYMBOL = r13;
                ContentType r14 = new ContentType("CLASS", 14, 14);
                CLASS = r14;
                ContentType r15 = new ContentType("FUNCTION", 15, 15);
                FUNCTION = r15;
                ContentType r16 = new ContentType("VARIABLE", 16, 16);
                VARIABLE = r16;
                ContentType r17 = new ContentType("VARIABLE_LANGUAGE", 17, 17);
                VARIABLE_LANGUAGE = r17;
                ContentType r19 = new ContentType("VARIABLE_CONSTANT", 18, 18);
                VARIABLE_CONSTANT = r19;
                ContentType r110 = new ContentType("TITLE", 19, 19);
                TITLE = r110;
                ContentType r111 = new ContentType("TITLE_CLASS", 20, 20);
                TITLE_CLASS = r111;
                ContentType r112 = new ContentType("TITLE_CLASS_INHERITED", 21, 21);
                TITLE_CLASS_INHERITED = r112;
                ContentType r113 = new ContentType("TITLE_FUNCTION", 22, 22);
                TITLE_FUNCTION = r113;
                ContentType r114 = new ContentType("TITLE_FUNCTION_INVOKE", 23, 23);
                TITLE_FUNCTION_INVOKE = r114;
                ContentType r115 = new ContentType("PARAMS", 24, 24);
                PARAMS = r115;
                ContentType r116 = new ContentType("COMMENT", 25, 25);
                COMMENT = r116;
                ContentType r117 = new ContentType("DOCTAG", 26, 26);
                DOCTAG = r117;
                ContentType r118 = new ContentType("META", 27, 27);
                META = r118;
                ContentType r119 = new ContentType("META_PROMPT", 28, 28);
                META_PROMPT = r119;
                ContentType r120 = new ContentType("META_KEYWORD", 29, 29);
                META_KEYWORD = r120;
                ContentType r121 = new ContentType("META_STRING", 30, 30);
                META_STRING = r121;
                ContentType r122 = new ContentType("SECTION", 31, 31);
                SECTION = r122;
                ContentType r123 = new ContentType("TAG", 32, 32);
                TAG = r123;
                ContentType r124 = new ContentType("NAME", 33, 33);
                NAME = r124;
                ContentType r125 = new ContentType("ATTR", 34, 34);
                ATTR = r125;
                ContentType r126 = new ContentType("ATTRIBUTE", 35, 35);
                ATTRIBUTE = r126;
                ContentType r127 = new ContentType("BULLET", 36, 36);
                BULLET = r127;
                ContentType r128 = new ContentType("CODE", 37, 37);
                CODE = r128;
                ContentType r129 = new ContentType("EMPHASIS", 38, 38);
                EMPHASIS = r129;
                ContentType r130 = new ContentType("FORMULA", 39, 39);
                FORMULA = r130;
                ContentType r131 = new ContentType("LINK", 40, 40);
                LINK = r131;
                ContentType r132 = new ContentType("QUOTE", 41, 41);
                QUOTE = r132;
                ContentType r133 = new ContentType("SELECTOR_TAG", 42, 42);
                SELECTOR_TAG = r133;
                ContentType r134 = new ContentType("SELECTOR_ID", 43, 43);
                SELECTOR_ID = r134;
                ContentType r135 = new ContentType("SELECTOR_CLASS", 44, 44);
                SELECTOR_CLASS = r135;
                ContentType r136 = new ContentType("SELECTOR_ATTR", 45, 45);
                SELECTOR_ATTR = r136;
                ContentType r137 = new ContentType("SELECTOR_PSEUDO", 46, 46);
                SELECTOR_PSEUDO = r137;
                ContentType r138 = new ContentType("TEMPLATE_TAG", 47, 47);
                TEMPLATE_TAG = r138;
                ContentType r139 = new ContentType("TEMPLATE_VARIABLE", 48, 48);
                TEMPLATE_VARIABLE = r139;
                ContentType r140 = new ContentType("ADDITION", 49, 49);
                ADDITION = r140;
                ContentType r141 = new ContentType("DELETION", 50, 50);
                DELETION = r141;
                ContentType[] r142 = {r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141};
                a = r142;
                b = EnumEntriesKt.enumEntries(r142);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(ContentType.class), Syntax.PROTO_2, r0);
            }

            public static ContentType[] values() {
                return (ContentType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static ContentType valueOf(String r1) {
                return (ContentType) r27.a.a(ContentType.class, r1);
            }

            public ContentType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\bK\b\u0086\u0081\u0002\u0018\u0000 N2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001NB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bM¨\u0006O"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Language;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PLAIN_TEXT", "ABAP", "ADA", "APACHE", "APEX", "ASSEMBLY", "BASH", "C_SHARP", "CPP", "C", "CMAKE", "COBOL", "CSS", "COFFEE_SCRIPT", "D", "DART", "DELPHI", "DIFF", "DJANGO", "DOCKER_FILE", "ERLANG", "FORTRAN", "GHERKIN", "GO", "GRAPHQL", "GROOVY", "HTML", "HTMLBARS", "HTTP", "HASKELL", "JSON", "JAVA", "JAVASCRIPT", "JULIA", "KOTLIN", "LATEX", "LISP", "LUA", "MATLAB", "MAKEFILE", "MARKDOWN", "NGINX", "OBJECTIVE_C", "OPENGL_SHADING_LANGUAGE", "PHP", "PERL", "POWERSHELL", "PROLOG", "PROPERTIES", "PROTOBUF", "PYTHON", "R", "RUBY", "RUST", "SAS", "SCSS", "SQL", "SCALA", "SCHEME", "SHELL", "SOLIDITY", "SWIFT", "TOML", "THRIFT", "TYPESCRIPT", "VBSCRIPT", "VISUAL_BASIC", "XML", "YAML", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Language extends Enum<Language> implements o0 {
            public static final Language ABAP = null;
            public static final Language ADA = null;
            public static final ProtoAdapter<Language> ADAPTER = null;
            public static final Language APACHE = null;
            public static final Language APEX = null;
            public static final Language ASSEMBLY = null;
            public static final Language BASH = null;
            public static final Language C = null;
            public static final Language CMAKE = null;
            public static final Language COBOL = null;
            public static final Language COFFEE_SCRIPT = null;
            public static final Language CPP = null;
            public static final Language CSS = null;
            public static final Language C_SHARP = null;
            public static final b Companion = null;
            public static final Language D = null;
            public static final Language DART = null;
            public static final Language DELPHI = null;
            public static final Language DIFF = null;
            public static final Language DJANGO = null;
            public static final Language DOCKER_FILE = null;
            public static final Language ERLANG = null;
            public static final Language FORTRAN = null;
            public static final Language GHERKIN = null;
            public static final Language GO = null;
            public static final Language GRAPHQL = null;
            public static final Language GROOVY = null;
            public static final Language HASKELL = null;
            public static final Language HTML = null;
            public static final Language HTMLBARS = null;
            public static final Language HTTP = null;
            public static final Language JAVA = null;
            public static final Language JAVASCRIPT = null;
            public static final Language JSON = null;
            public static final Language JULIA = null;
            public static final Language KOTLIN = null;
            public static final Language LATEX = null;
            public static final Language LISP = null;
            public static final Language LUA = null;
            public static final Language MAKEFILE = null;
            public static final Language MARKDOWN = null;
            public static final Language MATLAB = null;
            public static final Language NGINX = null;
            public static final Language OBJECTIVE_C = null;
            public static final Language OPENGL_SHADING_LANGUAGE = null;
            public static final Language PERL = null;
            public static final Language PHP = null;
            public static final Language PLAIN_TEXT = null;
            public static final Language POWERSHELL = null;
            public static final Language PROLOG = null;
            public static final Language PROPERTIES = null;
            public static final Language PROTOBUF = null;
            public static final Language PYTHON = null;
            public static final Language R = null;
            public static final Language RUBY = null;
            public static final Language RUST = null;
            public static final Language SAS = null;
            public static final Language SCALA = null;
            public static final Language SCHEME = null;
            public static final Language SCSS = null;
            public static final Language SHELL = null;
            public static final Language SOLIDITY = null;
            public static final Language SQL = null;
            public static final Language SWIFT = null;
            public static final Language THRIFT = null;
            public static final Language TOML = null;
            public static final Language TYPESCRIPT = null;
            public static final Language VBSCRIPT = null;
            public static final Language VISUAL_BASIC = null;
            public static final Language XML = null;
            public static final Language YAML = null;
            public static final /* synthetic */ Language[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Language> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Language.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<Language> r1, Syntax r2, Language r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Language a(int r0) {
                    switch(r0) {
                        case 0: goto L73;
                        case 1: goto L142;
                        case 2: goto L141;
                        case 3: goto L140;
                        case 4: goto L139;
                        case 5: goto L138;
                        case 6: goto L137;
                        case 7: goto L136;
                        case 8: goto L135;
                        case 9: goto L134;
                        case 10: goto L133;
                        case 11: goto L132;
                        case 12: goto L131;
                        case 13: goto L130;
                        case 14: goto L129;
                        case 15: goto L128;
                        case 16: goto L127;
                        case 17: goto L126;
                        case 18: goto L125;
                        case 19: goto L124;
                        case 20: goto L123;
                        case 21: goto L122;
                        case 22: goto L121;
                        case 23: goto L120;
                        case 24: goto L119;
                        case 25: goto L118;
                        case 26: goto L117;
                        case 27: goto L116;
                        case 28: goto L115;
                        case 29: goto L114;
                        case 30: goto L113;
                        case 31: goto L112;
                        case 32: goto L111;
                        case 33: goto L110;
                        case 34: goto L109;
                        case 35: goto L108;
                        case 36: goto L107;
                        case 37: goto L106;
                        case 38: goto L105;
                        case 39: goto L104;
                        case 40: goto L103;
                        case 41: goto L102;
                        case 42: goto L101;
                        case 43: goto L100;
                        case 44: goto L99;
                        case 45: goto L98;
                        case 46: goto L97;
                        case 47: goto L96;
                        case 48: goto L95;
                        case 49: goto L94;
                        case 50: goto L93;
                        case 51: goto L92;
                        case 52: goto L91;
                        case 53: goto L90;
                        case 54: goto L89;
                        case 55: goto L88;
                        case 56: goto L87;
                        case 57: goto L86;
                        case 58: goto L85;
                        case 59: goto L84;
                        case 60: goto L83;
                        case 61: goto L82;
                        case 62: goto L81;
                        case 63: goto L80;
                        case 64: goto L79;
                        case 65: goto L78;
                        case 66: goto L77;
                        case 67: goto L76;
                        case 68: goto L75;
                        default: goto L3;
                    };
                L3:
                    return null;
                L75:
                    return Language.YAML;
                L76:
                    return Language.XML;
                L77:
                    return Language.VISUAL_BASIC;
                L78:
                    return Language.VBSCRIPT;
                L79:
                    return Language.TYPESCRIPT;
                L80:
                    return Language.THRIFT;
                L81:
                    return Language.TOML;
                L82:
                    return Language.SWIFT;
                L83:
                    return Language.SOLIDITY;
                L84:
                    return Language.SHELL;
                L85:
                    return Language.SCHEME;
                L86:
                    return Language.SCALA;
                L87:
                    return Language.SQL;
                L88:
                    return Language.SCSS;
                L89:
                    return Language.SAS;
                L90:
                    return Language.RUST;
                L91:
                    return Language.RUBY;
                L92:
                    return Language.R;
                L93:
                    return Language.PYTHON;
                L94:
                    return Language.PROTOBUF;
                L95:
                    return Language.PROPERTIES;
                L96:
                    return Language.PROLOG;
                L97:
                    return Language.POWERSHELL;
                L98:
                    return Language.PERL;
                L99:
                    return Language.PHP;
                L100:
                    return Language.OPENGL_SHADING_LANGUAGE;
                L101:
                    return Language.OBJECTIVE_C;
                L102:
                    return Language.NGINX;
                L103:
                    return Language.MARKDOWN;
                L104:
                    return Language.MAKEFILE;
                L105:
                    return Language.MATLAB;
                L106:
                    return Language.LUA;
                L107:
                    return Language.LISP;
                L108:
                    return Language.LATEX;
                L109:
                    return Language.KOTLIN;
                L110:
                    return Language.JULIA;
                L111:
                    return Language.JAVASCRIPT;
                L112:
                    return Language.JAVA;
                L113:
                    return Language.JSON;
                L114:
                    return Language.HASKELL;
                L115:
                    return Language.HTTP;
                L116:
                    return Language.HTMLBARS;
                L117:
                    return Language.HTML;
                L118:
                    return Language.GROOVY;
                L119:
                    return Language.GRAPHQL;
                L120:
                    return Language.GO;
                L121:
                    return Language.GHERKIN;
                L122:
                    return Language.FORTRAN;
                L123:
                    return Language.ERLANG;
                L124:
                    return Language.DOCKER_FILE;
                L125:
                    return Language.DJANGO;
                L126:
                    return Language.DIFF;
                L127:
                    return Language.DELPHI;
                L128:
                    return Language.DART;
                L129:
                    return Language.D;
                L130:
                    return Language.COFFEE_SCRIPT;
                L131:
                    return Language.CSS;
                L132:
                    return Language.COBOL;
                L133:
                    return Language.CMAKE;
                L134:
                    return Language.C;
                L135:
                    return Language.CPP;
                L136:
                    return Language.C_SHARP;
                L137:
                    return Language.BASH;
                L138:
                    return Language.ASSEMBLY;
                L139:
                    return Language.APEX;
                L140:
                    return Language.APACHE;
                L141:
                    return Language.ADA;
                L142:
                    return Language.ABAP;
                L73:
                    return Language.PLAIN_TEXT;
                }
            }

            @JvmStatic
            public static final Language fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<Language> getEntries() {
                return b;
            }

            static {
                Language r0 = new Language("PLAIN_TEXT", 0, 0);
                PLAIN_TEXT = r0;
                Language r1 = new Language("ABAP", 1, 1);
                ABAP = r1;
                Language r2 = new Language("ADA", 2, 2);
                ADA = r2;
                Language r3 = new Language("APACHE", 3, 3);
                APACHE = r3;
                Language r4 = new Language("APEX", 4, 4);
                APEX = r4;
                Language r5 = new Language("ASSEMBLY", 5, 5);
                ASSEMBLY = r5;
                Language r6 = new Language("BASH", 6, 6);
                BASH = r6;
                Language r7 = new Language("C_SHARP", 7, 7);
                C_SHARP = r7;
                Language r8 = new Language("CPP", 8, 8);
                CPP = r8;
                Language r9 = new Language("C", 9, 9);
                C = r9;
                Language r10 = new Language("CMAKE", 10, 10);
                CMAKE = r10;
                Language r11 = new Language("COBOL", 11, 11);
                COBOL = r11;
                Language r12 = new Language("CSS", 12, 12);
                CSS = r12;
                Language r13 = new Language("COFFEE_SCRIPT", 13, 13);
                COFFEE_SCRIPT = r13;
                Language r14 = new Language("D", 14, 14);
                D = r14;
                Language r15 = new Language("DART", 15, 15);
                DART = r15;
                Language r16 = new Language("DELPHI", 16, 16);
                DELPHI = r16;
                Language r17 = new Language("DIFF", 17, 17);
                DIFF = r17;
                Language r19 = new Language("DJANGO", 18, 18);
                DJANGO = r19;
                Language r110 = new Language("DOCKER_FILE", 19, 19);
                DOCKER_FILE = r110;
                Language r111 = new Language("ERLANG", 20, 20);
                ERLANG = r111;
                Language r112 = new Language("FORTRAN", 21, 21);
                FORTRAN = r112;
                Language r113 = new Language("GHERKIN", 22, 22);
                GHERKIN = r113;
                Language r114 = new Language("GO", 23, 23);
                GO = r114;
                Language r115 = new Language("GRAPHQL", 24, 24);
                GRAPHQL = r115;
                Language r116 = new Language("GROOVY", 25, 25);
                GROOVY = r116;
                Language r117 = new Language("HTML", 26, 26);
                HTML = r117;
                Language r118 = new Language("HTMLBARS", 27, 27);
                HTMLBARS = r118;
                Language r119 = new Language("HTTP", 28, 28);
                HTTP = r119;
                Language r120 = new Language("HASKELL", 29, 29);
                HASKELL = r120;
                Language r121 = new Language("JSON", 30, 30);
                JSON = r121;
                Language r122 = new Language("JAVA", 31, 31);
                JAVA = r122;
                Language r123 = new Language("JAVASCRIPT", 32, 32);
                JAVASCRIPT = r123;
                Language r124 = new Language("JULIA", 33, 33);
                JULIA = r124;
                Language r125 = new Language("KOTLIN", 34, 34);
                KOTLIN = r125;
                Language r126 = new Language("LATEX", 35, 35);
                LATEX = r126;
                Language r127 = new Language("LISP", 36, 36);
                LISP = r127;
                Language r128 = new Language("LUA", 37, 37);
                LUA = r128;
                Language r129 = new Language("MATLAB", 38, 38);
                MATLAB = r129;
                Language r130 = new Language("MAKEFILE", 39, 39);
                MAKEFILE = r130;
                Language r131 = new Language("MARKDOWN", 40, 40);
                MARKDOWN = r131;
                Language r132 = new Language("NGINX", 41, 41);
                NGINX = r132;
                Language r133 = new Language("OBJECTIVE_C", 42, 42);
                OBJECTIVE_C = r133;
                Language r134 = new Language("OPENGL_SHADING_LANGUAGE", 43, 43);
                OPENGL_SHADING_LANGUAGE = r134;
                Language r135 = new Language("PHP", 44, 44);
                PHP = r135;
                Language r136 = new Language("PERL", 45, 45);
                PERL = r136;
                Language r137 = new Language("POWERSHELL", 46, 46);
                POWERSHELL = r137;
                Language r138 = new Language("PROLOG", 47, 47);
                PROLOG = r138;
                Language r139 = new Language("PROPERTIES", 48, 48);
                PROPERTIES = r139;
                Language r140 = new Language("PROTOBUF", 49, 49);
                PROTOBUF = r140;
                Language r141 = new Language("PYTHON", 50, 50);
                PYTHON = r141;
                Language r142 = new Language("R", 51, 51);
                R = r142;
                Language r143 = new Language("RUBY", 52, 52);
                RUBY = r143;
                Language r144 = new Language("RUST", 53, 53);
                RUST = r144;
                Language r145 = new Language("SAS", 54, 54);
                SAS = r145;
                Language r146 = new Language("SCSS", 55, 55);
                SCSS = r146;
                Language r147 = new Language("SQL", 56, 56);
                SQL = r147;
                Language r148 = new Language("SCALA", 57, 57);
                SCALA = r148;
                Language r149 = new Language("SCHEME", 58, 58);
                SCHEME = r149;
                Language r150 = new Language("SHELL", 59, 59);
                SHELL = r150;
                Language r151 = new Language("SOLIDITY", 60, 60);
                SOLIDITY = r151;
                Language r152 = new Language("SWIFT", 61, 61);
                SWIFT = r152;
                Language r153 = new Language("TOML", 62, 62);
                TOML = r153;
                Language r154 = new Language("THRIFT", 63, 63);
                THRIFT = r154;
                Language r155 = new Language("TYPESCRIPT", 64, 64);
                TYPESCRIPT = r155;
                Language r156 = new Language("VBSCRIPT", 65, 65);
                VBSCRIPT = r156;
                Language r157 = new Language("VISUAL_BASIC", 66, 66);
                VISUAL_BASIC = r157;
                Language r158 = new Language("XML", 67, 67);
                XML = r158;
                Language r159 = new Language("YAML", 68, 68);
                YAML = r159;
                Language[] r160 = {r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159};
                a = r160;
                b = EnumEntriesKt.enumEntries(r160);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Language.class), Syntax.PROTO_2, r0);
            }

            public static Language[] values() {
                return (Language[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Language valueOf(String r1) {
                return (Language) r27.a.a(Language.class, r1);
            }

            public Language(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$LineContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$LineContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$LineContent$Builder;Lokio/ByteString;)V", "contents", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property$Content;", "getContents", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class LineContent extends com.lark.wire.Message<LineContent, a> {
            public static final ProtoAdapter<LineContent> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final List<Content> contents;

            public static final class a extends com.lark.wire.Message.a<LineContent, a> {
                public List<Content> d;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new LineContent(this, c(), null);
                }

                public a() {
                    this.d = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<LineContent> {
                @Override // com.lark.wire.ProtoAdapter
                public final LineContent c(g0 r7) {
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
                    r1.add(Content.ADAPTER.c(r7));
                    goto L3
                L9:
                    ByteString r8 = r7.d(r2);
                    Intrinsics.checkNotNullParameter(r1, "contents");
                    com.lark.wire.internal.a.a(r1);
                    r0.d = r1;
                    return new LineContent(r0, r8, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(LineContent r4) {
                    LineContent r5 = r4;
                    Intrinsics.checkNotNullParameter(r5, "value");
                    return r5.unknownFields().size() + Content.ADAPTER.a().l(1, r5.getContents());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, LineContent r5) {
                    LineContent r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    Content.ADAPTER.a().i(r4, 1, r6.getContents());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r3, LineContent r4) {
                    LineContent r5 = r4;
                    Intrinsics.checkNotNullParameter(r3, "writer");
                    Intrinsics.checkNotNullParameter(r5, "value");
                    r3.d(r5.unknownFields());
                    Content.ADAPTER.a().j(r3, 1, r5.getContents());
                }

                public b(FieldEncoding r7, KClass<LineContent> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.CodeBlockV2Property.LineContent", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ LineContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LineContent.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.contents;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(LineContent.class).getSimpleName() + '@' + hashCode();
            }

            public final List<Content> getContents() {
                return this.contents;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public LineContent(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.contents = com.lark.wire.internal.a.c("contents", r2.d);
            }

            public /* synthetic */ LineContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<CodeBlockV2Property, a> {
            public Language d;
            public List<LineContent> e;
            public Boolean f;
            public Integer g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CodeBlockV2Property(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<CodeBlockV2Property> {
            @Override // com.lark.wire.ProtoAdapter
            public final CodeBlockV2Property c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L21;
                if (r4 != 1) goto L8;
                r0.d = Language.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.add(LineContent.ADAPTER.c(r10));
                goto L3
            L10:
                if (r4 != 4) goto L12;
                r0.f = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L12:
                if (r4 != 5) goto L13;
                r0.g = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L13:
                r10.j(r4);
                goto L3
            L21:
                ByteString r11 = r10.d(r2);
                Intrinsics.checkNotNullParameter(r1, "contents");
                com.lark.wire.internal.a.a(r1);
                r0.e = r1;
                return new CodeBlockV2Property(r0, r11, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CodeBlockV2Property r5) {
                CodeBlockV2Property r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((r6.unknownFields().size() + Language.ADAPTER.l(1, r6.getLanguage())) + LineContent.ADAPTER.a().l(2, r6.getContents())) + ProtoAdapter.g.l(4, r6.getWord_wrap())) + ProtoAdapter.h.l(5, r6.getVersion());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CodeBlockV2Property r5) {
                CodeBlockV2Property r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Language.ADAPTER.i(r4, 1, r6.getLanguage());
                LineContent.ADAPTER.a().i(r4, 2, r6.getContents());
                ProtoAdapter.g.i(r4, 4, r6.getWord_wrap());
                ProtoAdapter.h.i(r4, 5, r6.getVersion());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CodeBlockV2Property r5) {
                CodeBlockV2Property r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 5, r6.getVersion());
                ProtoAdapter.g.j(r4, 4, r6.getWord_wrap());
                LineContent.ADAPTER.a().j(r4, 2, r6.getContents());
                Language.ADAPTER.j(r4, 1, r6.getLanguage());
            }

            public b(FieldEncoding r7, KClass<CodeBlockV2Property> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.CodeBlockV2Property", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CodeBlockV2Property(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CodeBlockV2Property.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.language;
            r0.e = this.contents;
            r0.f = this.word_wrap;
            r0.g = this.version;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CodeBlockV2Property.class).getSimpleName() + '@' + hashCode();
        }

        public final List<LineContent> getContents() {
            return this.contents;
        }

        public final Language getLanguage() {
            return this.language;
        }

        public final Integer getVersion() {
            return this.version;
        }

        public final Boolean getWord_wrap() {
            return this.word_wrap;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CodeBlockV2Property(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.language = r2.d;
            this.contents = com.lark.wire.internal.a.c("contents", r2.e);
            this.word_wrap = r2.f;
            this.version = r2.g;
        }

        public /* synthetic */ CodeBlockV2Property(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CodeProperty extends com.lark.wire.Message<CodeProperty, a> {
        public static final ProtoAdapter<CodeProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<CodeProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CodeProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CodeProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final CodeProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new CodeProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CodeProperty r2) {
                CodeProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, CodeProperty r3) {
                CodeProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, CodeProperty r3) {
                CodeProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<CodeProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.CodeProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CodeProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CodeProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CodeProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CodeProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ CodeProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnProperty$Builder;Lokio/ByteString;)V", "width", "", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ColumnProperty extends com.lark.wire.Message<ColumnProperty, a> {
        public static final ProtoAdapter<ColumnProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer width;

        public static final class a extends com.lark.wire.Message.a<ColumnProperty, a> {
            public Integer d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ColumnProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ColumnProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ColumnProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = (Integer) ProtoAdapter.h.c(r6);
                goto L3
            L10:
                return new ColumnProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ColumnProperty r4) {
                ColumnProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.h.l(1, r5.getWidth());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ColumnProperty r5) {
                ColumnProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.h.i(r4, 1, r6.getWidth());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, ColumnProperty r4) {
                ColumnProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.h.j(r3, 1, r5.getWidth());
            }

            public b(FieldEncoding r7, KClass<ColumnProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ColumnProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ColumnProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ColumnProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.width;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ColumnProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getWidth() {
            return this.width;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ColumnProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.width = r2.d;
        }

        public /* synthetic */ ColumnProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnsProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnsProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnsProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ColumnsProperty extends com.lark.wire.Message<ColumnsProperty, a> {
        public static final ProtoAdapter<ColumnsProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<ColumnsProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ColumnsProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ColumnsProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ColumnsProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new ColumnsProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ColumnsProperty r2) {
                ColumnsProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, ColumnsProperty r3) {
                ColumnsProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, ColumnsProperty r3) {
                ColumnsProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<ColumnsProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ColumnsProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ColumnsProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ColumnsProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ColumnsProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ColumnsProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ ColumnsProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatePickerProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatePickerProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatePickerProperty$Builder;Lokio/ByteString;)V", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "place_holder", "getPlace_holder", "place_holder_i18n_key", "getPlace_holder_i18n_key", "initial_date", "getInitial_date", "confirm", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "getConfirm", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "disable", "", "getDisable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_loading", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DatePickerProperty extends com.lark.wire.Message<DatePickerProperty, a> {
        public static final ProtoAdapter<DatePickerProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_DISABLE = false;
        public static final boolean DEFAULT_IS_LOADING = false;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final ButtonConfirmProperty confirm;
        private final Boolean disable;
        private final String initial_date;
        private final Boolean is_loading;
        private final String place_holder;
        private final String place_holder_i18n_key;

        public static final class a extends com.lark.wire.Message.a<DatePickerProperty, a> {
            public String d;
            public String e;
            public String f;
            public String g;
            public ButtonConfirmProperty h;
            public Boolean i;
            public Boolean j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DatePickerProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DatePickerProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final DatePickerProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L15;
                switch(r4) {
                    case 1: goto L13;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L7:
                r1.j = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L8:
                r1.i = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L9:
                r1.h = ButtonConfirmProperty.ADAPTER.c(r7);
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L15:
                return new DatePickerProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DatePickerProperty r5) {
                DatePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = ((((r0 + r1.l(1, r6.getAction_id())) + r1.l(2, r6.getPlace_holder())) + r1.l(3, r6.getPlace_holder_i18n_key())) + r1.l(4, r6.getInitial_date())) + ButtonConfirmProperty.ADAPTER.l(5, r6.getConfirm());
                l r3 = ProtoAdapter.g;
                return (r2 + r3.l(6, r6.getDisable())) + r3.l(7, r6.is_loading());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, DatePickerProperty r5) {
                DatePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getAction_id());
                r0.i(r4, 2, r6.getPlace_holder());
                r0.i(r4, 3, r6.getPlace_holder_i18n_key());
                r0.i(r4, 4, r6.getInitial_date());
                ButtonConfirmProperty.ADAPTER.i(r4, 5, r6.getConfirm());
                l r1 = ProtoAdapter.g;
                r1.i(r4, 6, r6.getDisable());
                r1.i(r4, 7, r6.is_loading());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, DatePickerProperty r5) {
                DatePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 7, r6.is_loading());
                r0.j(r4, 6, r6.getDisable());
                ButtonConfirmProperty.ADAPTER.j(r4, 5, r6.getConfirm());
                w r1 = ProtoAdapter.q;
                r1.j(r4, 4, r6.getInitial_date());
                r1.j(r4, 3, r6.getPlace_holder_i18n_key());
                r1.j(r4, 2, r6.getPlace_holder());
                r1.j(r4, 1, r6.getAction_id());
            }

            public b(FieldEncoding r7, KClass<DatePickerProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.DatePickerProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DatePickerProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DatePickerProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.action_id;
            r0.e = this.place_holder;
            r0.f = this.place_holder_i18n_key;
            r0.g = this.initial_date;
            r0.h = this.confirm;
            r0.i = this.disable;
            r0.j = this.is_loading;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DatePickerProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final ButtonConfirmProperty getConfirm() {
            return this.confirm;
        }

        public final Boolean getDisable() {
            return this.disable;
        }

        public final String getInitial_date() {
            return this.initial_date;
        }

        public final String getPlace_holder() {
            return this.place_holder;
        }

        public final String getPlace_holder_i18n_key() {
            return this.place_holder_i18n_key;
        }

        public final Boolean is_loading() {
            return this.is_loading;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DatePickerProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.action_id = r2.d;
            this.place_holder = r2.e;
            this.place_holder_i18n_key = r2.f;
            this.initial_date = r2.g;
            this.confirm = r2.h;
            this.disable = r2.i;
            this.is_loading = r2.j;
        }

        public /* synthetic */ DatePickerProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatetimePickerProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatetimePickerProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatetimePickerProperty$Builder;Lokio/ByteString;)V", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "place_holder", "getPlace_holder", "place_holder_i18n_key", "getPlace_holder_i18n_key", "initial_datetime", "getInitial_datetime", "confirm", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "getConfirm", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "disable", "", "getDisable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_loading", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DatetimePickerProperty extends com.lark.wire.Message<DatetimePickerProperty, a> {
        public static final ProtoAdapter<DatetimePickerProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_DISABLE = false;
        public static final boolean DEFAULT_IS_LOADING = false;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final ButtonConfirmProperty confirm;
        private final Boolean disable;
        private final String initial_datetime;
        private final Boolean is_loading;
        private final String place_holder;
        private final String place_holder_i18n_key;

        public static final class a extends com.lark.wire.Message.a<DatetimePickerProperty, a> {
            public String d;
            public String e;
            public String f;
            public String g;
            public ButtonConfirmProperty h;
            public Boolean i;
            public Boolean j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DatetimePickerProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DatetimePickerProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final DatetimePickerProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L15;
                switch(r4) {
                    case 1: goto L13;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L7:
                r1.j = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L8:
                r1.i = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L9:
                r1.h = ButtonConfirmProperty.ADAPTER.c(r7);
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L15:
                return new DatetimePickerProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DatetimePickerProperty r5) {
                DatetimePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = ((((r0 + r1.l(1, r6.getAction_id())) + r1.l(2, r6.getPlace_holder())) + r1.l(3, r6.getPlace_holder_i18n_key())) + r1.l(4, r6.getInitial_datetime())) + ButtonConfirmProperty.ADAPTER.l(5, r6.getConfirm());
                l r3 = ProtoAdapter.g;
                return (r2 + r3.l(6, r6.getDisable())) + r3.l(7, r6.is_loading());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, DatetimePickerProperty r5) {
                DatetimePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getAction_id());
                r0.i(r4, 2, r6.getPlace_holder());
                r0.i(r4, 3, r6.getPlace_holder_i18n_key());
                r0.i(r4, 4, r6.getInitial_datetime());
                ButtonConfirmProperty.ADAPTER.i(r4, 5, r6.getConfirm());
                l r1 = ProtoAdapter.g;
                r1.i(r4, 6, r6.getDisable());
                r1.i(r4, 7, r6.is_loading());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, DatetimePickerProperty r5) {
                DatetimePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 7, r6.is_loading());
                r0.j(r4, 6, r6.getDisable());
                ButtonConfirmProperty.ADAPTER.j(r4, 5, r6.getConfirm());
                w r1 = ProtoAdapter.q;
                r1.j(r4, 4, r6.getInitial_datetime());
                r1.j(r4, 3, r6.getPlace_holder_i18n_key());
                r1.j(r4, 2, r6.getPlace_holder());
                r1.j(r4, 1, r6.getAction_id());
            }

            public b(FieldEncoding r7, KClass<DatetimePickerProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.DatetimePickerProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DatetimePickerProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DatetimePickerProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.action_id;
            r0.e = this.place_holder;
            r0.f = this.place_holder_i18n_key;
            r0.g = this.initial_datetime;
            r0.h = this.confirm;
            r0.i = this.disable;
            r0.j = this.is_loading;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DatetimePickerProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final ButtonConfirmProperty getConfirm() {
            return this.confirm;
        }

        public final Boolean getDisable() {
            return this.disable;
        }

        public final String getInitial_datetime() {
            return this.initial_datetime;
        }

        public final String getPlace_holder() {
            return this.place_holder;
        }

        public final String getPlace_holder_i18n_key() {
            return this.place_holder_i18n_key;
        }

        public final Boolean is_loading() {
            return this.is_loading;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DatetimePickerProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.action_id = r2.d;
            this.place_holder = r2.e;
            this.place_holder_i18n_key = r2.f;
            this.initial_datetime = r2.g;
            this.confirm = r2.h;
            this.disable = r2.i;
            this.is_loading = r2.j;
        }

        public /* synthetic */ DatetimePickerProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$DivProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$DivProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$DivProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DivProperty extends com.lark.wire.Message<DivProperty, a> {
        public static final ProtoAdapter<DivProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<DivProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DivProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DivProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final DivProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new DivProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DivProperty r2) {
                DivProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, DivProperty r3) {
                DivProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, DivProperty r3) {
                DivProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<DivProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.DivProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DivProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DivProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DivProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DivProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ DivProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$DocsProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$DocsProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$DocsProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DocsProperty extends com.lark.wire.Message<DocsProperty, a> {
        public static final ProtoAdapter<DocsProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<DocsProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DocsProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DocsProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final DocsProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new DocsProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DocsProperty r2) {
                DocsProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, DocsProperty r3) {
                DocsProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, DocsProperty r3) {
                DocsProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<DocsProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.DocsProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DocsProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DocsProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DocsProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DocsProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ DocsProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$EmotionProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$EmotionProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$EmotionProperty$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class EmotionProperty extends com.lark.wire.Message<EmotionProperty, a> {
        public static final ProtoAdapter<EmotionProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String key;

        public static final class a extends com.lark.wire.Message.a<EmotionProperty, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new EmotionProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<EmotionProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final EmotionProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L10;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "key");
                r1.d = r5;
                goto L3
            L10:
                return new EmotionProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(EmotionProperty r4) {
                EmotionProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getKey());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, EmotionProperty r5) {
                EmotionProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getKey());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, EmotionProperty r4) {
                EmotionProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getKey());
            }

            public b(FieldEncoding r7, KClass<EmotionProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.EmotionProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ EmotionProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EmotionProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(EmotionProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getKey() {
            return this.key;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public EmotionProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.key = r4;
        }

        public /* synthetic */ EmotionProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$FigureProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$FigureProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$FigureProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class FigureProperty extends com.lark.wire.Message<FigureProperty, a> {
        public static final ProtoAdapter<FigureProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<FigureProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new FigureProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<FigureProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final FigureProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new FigureProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(FigureProperty r2) {
                FigureProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, FigureProperty r3) {
                FigureProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, FigureProperty r3) {
                FigureProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<FigureProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.FigureProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ FigureProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FigureProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(FigureProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public FigureProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ FigureProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$H1Property;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H1Property$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$H1Property$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class H1Property extends com.lark.wire.Message<H1Property, a> {
        public static final ProtoAdapter<H1Property> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<H1Property, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new H1Property(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<H1Property> {
            @Override // com.lark.wire.ProtoAdapter
            public final H1Property c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new H1Property(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(H1Property r2) {
                H1Property r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, H1Property r3) {
                H1Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, H1Property r3) {
                H1Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<H1Property> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.H1Property", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ H1Property(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(H1Property.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(H1Property.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public H1Property(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ H1Property(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$H2Property;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H2Property$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$H2Property$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class H2Property extends com.lark.wire.Message<H2Property, a> {
        public static final ProtoAdapter<H2Property> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<H2Property, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new H2Property(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<H2Property> {
            @Override // com.lark.wire.ProtoAdapter
            public final H2Property c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new H2Property(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(H2Property r2) {
                H2Property r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, H2Property r3) {
                H2Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, H2Property r3) {
                H2Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<H2Property> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.H2Property", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ H2Property(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(H2Property.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(H2Property.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public H2Property(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ H2Property(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$H3Property;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H3Property$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$H3Property$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class H3Property extends com.lark.wire.Message<H3Property, a> {
        public static final ProtoAdapter<H3Property> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<H3Property, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new H3Property(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<H3Property> {
            @Override // com.lark.wire.ProtoAdapter
            public final H3Property c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new H3Property(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(H3Property r2) {
                H3Property r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, H3Property r3) {
                H3Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, H3Property r3) {
                H3Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<H3Property> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.H3Property", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ H3Property(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(H3Property.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(H3Property.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public H3Property(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ H3Property(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$H4Property;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H4Property$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$H4Property$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class H4Property extends com.lark.wire.Message<H4Property, a> {
        public static final ProtoAdapter<H4Property> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<H4Property, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new H4Property(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<H4Property> {
            @Override // com.lark.wire.ProtoAdapter
            public final H4Property c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new H4Property(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(H4Property r2) {
                H4Property r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, H4Property r3) {
                H4Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, H4Property r3) {
                H4Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<H4Property> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.H4Property", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ H4Property(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(H4Property.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(H4Property.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public H4Property(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ H4Property(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$H5Property;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H5Property$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$H5Property$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class H5Property extends com.lark.wire.Message<H5Property, a> {
        public static final ProtoAdapter<H5Property> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<H5Property, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new H5Property(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<H5Property> {
            @Override // com.lark.wire.ProtoAdapter
            public final H5Property c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new H5Property(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(H5Property r2) {
                H5Property r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, H5Property r3) {
                H5Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, H5Property r3) {
                H5Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<H5Property> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.H5Property", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ H5Property(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(H5Property.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(H5Property.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public H5Property(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ H5Property(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$H6Property;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H6Property$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$H6Property$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class H6Property extends com.lark.wire.Message<H6Property, a> {
        public static final ProtoAdapter<H6Property> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<H6Property, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new H6Property(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<H6Property> {
            @Override // com.lark.wire.ProtoAdapter
            public final H6Property c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new H6Property(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(H6Property r2) {
                H6Property r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, H6Property r3) {
                H6Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, H6Property r3) {
                H6Property r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<H6Property> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.H6Property", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ H6Property(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(H6Property.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(H6Property.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public H6Property(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ H6Property(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$HRProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$HRProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$HRProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class HRProperty extends com.lark.wire.Message<HRProperty, a> {
        public static final ProtoAdapter<HRProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<HRProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new HRProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<HRProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final HRProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new HRProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(HRProperty r2) {
                HRProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, HRProperty r3) {
                HRProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, HRProperty r3) {
                HRProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<HRProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.HRProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ HRProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(HRProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(HRProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public HRProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ HRProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$HorizontalAlign;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HORIZONTAL_ALIGN_UNKNOWN", "HORIZONTAL_ALIGN_LEFT", "HORIZONTAL_ALIGN_CENTER", "HORIZONTAL_ALIGN_RIGHT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum HorizontalAlign extends Enum<HorizontalAlign> implements o0 {
        public static final ProtoAdapter<HorizontalAlign> ADAPTER = null;
        public static final b Companion = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_CENTER = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_LEFT = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_RIGHT = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_UNKNOWN = null;
        public static final /* synthetic */ HorizontalAlign[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<HorizontalAlign> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                HorizontalAlign.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return HorizontalAlign.HORIZONTAL_ALIGN_RIGHT;
            L18:
                return HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
            L19:
                return HorizontalAlign.HORIZONTAL_ALIGN_LEFT;
            L15:
                return HorizontalAlign.HORIZONTAL_ALIGN_UNKNOWN;
            }

            public a(KClass<HorizontalAlign> r1, Syntax r2, HorizontalAlign r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<HorizontalAlign> getEntries() {
            return b;
        }

        static {
            HorizontalAlign r0 = new HorizontalAlign("HORIZONTAL_ALIGN_UNKNOWN", 0, 0);
            HORIZONTAL_ALIGN_UNKNOWN = r0;
            HorizontalAlign r1 = new HorizontalAlign("HORIZONTAL_ALIGN_LEFT", 1, 1);
            HORIZONTAL_ALIGN_LEFT = r1;
            HorizontalAlign r3 = new HorizontalAlign("HORIZONTAL_ALIGN_CENTER", 2, 2);
            HORIZONTAL_ALIGN_CENTER = r3;
            HorizontalAlign r5 = new HorizontalAlign("HORIZONTAL_ALIGN_RIGHT", 3, 3);
            HORIZONTAL_ALIGN_RIGHT = r5;
            HorizontalAlign[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(HorizontalAlign.class), Syntax.PROTO_2, r0);
        }

        public static HorizontalAlign[] values() {
            return (HorizontalAlign[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final HorizontalAlign fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return HORIZONTAL_ALIGN_RIGHT;
        L18:
            return HORIZONTAL_ALIGN_CENTER;
        L19:
            return HORIZONTAL_ALIGN_LEFT;
        L15:
            return HORIZONTAL_ALIGN_UNKNOWN;
        }

        public static HorizontalAlign valueOf(String r1) {
            return (HorizontalAlign) r27.a.a(HorizontalAlign.class, r1);
        }

        public HorizontalAlign(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageGalleryProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageGalleryProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageGalleryProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ImageGalleryProperty extends com.lark.wire.Message<ImageGalleryProperty, a> {
        public static final ProtoAdapter<ImageGalleryProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<ImageGalleryProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ImageGalleryProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ImageGalleryProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ImageGalleryProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new ImageGalleryProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ImageGalleryProperty r2) {
                ImageGalleryProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, ImageGalleryProperty r3) {
                ImageGalleryProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, ImageGalleryProperty r3) {
                ImageGalleryProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<ImageGalleryProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ImageGalleryProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ImageGalleryProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageGalleryProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ImageGalleryProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ImageGalleryProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ ImageGalleryProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Z2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002YZB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010W\u001a\u00020\u0002H\u0016J\b\u0010X\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000fR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000fR\u0013\u0010!\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0013\u0010.\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0013\u00100\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0015\u00102\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b3\u0010\u0019R\u0013\u00104\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0015\u00106\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b6\u0010&R\u0015\u00107\u001a\u0004\u0018\u000108¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0013\u0010<\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000fR\u0013\u0010>\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0015\u0010A\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bB\u0010\u0019R\u0015\u0010C\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\bD\u0010&R\u0013\u0010E\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bF\u0010+R\u0015\u0010G\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bH\u0010\u0019R\u0015\u0010I\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bJ\u0010\u0019R\u0013\u0010K\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u000fR \u0010M\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\bN\u0010O\u001a\u0004\bP\u0010&R\u0013\u0010Q\u001a\u0004\u0018\u00010R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0013\u0010U\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u000f¨\u0006["}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty$Builder;Lokio/ByteString;)V", "urls", "", "", "getUrls", "()Ljava/util/List;", "token", "getToken", "()Ljava/lang/String;", "origin_key", "getOrigin_key", "middle_key", "getMiddle_key", "thumb_key", "getThumb_key", "origin_width", "", "getOrigin_width", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "origin_height", "getOrigin_height", "fs_unit", "getFs_unit", "alt", "getAlt", "alt_i18n_key", "getAlt_i18n_key", "img_can_preview", "", "getImg_can_preview", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "thumbnail_webp", "Lcom/lark/kmp/pb/basic/v1/Image;", "getThumbnail_webp", "()Lcom/lark/kmp/pb/basic/v1/Image;", "middle_webp", "getMiddle_webp", "middle_mp4", "getMiddle_mp4", "cover", "getCover", "custom_width", "getCustom_width", "intact", "getIntact", "is_origin_source", "origin_size", "", "getOrigin_size", "()Ljava/lang/Long;", "Ljava/lang/Long;", "upload_id", "getUpload_id", "inline_preview", "getInline_preview", "()Lokio/ByteString;", "show_mode", "getShow_mode", "need_copy", "getNeed_copy", "origin", "getOrigin", "width", "getWidth", "height", "getHeight", "resource_preview_token", "getResource_preview_token", "resource_is_cleaned", "getResource_is_cleaned$annotations", "()V", "getResource_is_cleaned", "clean_resource_scene", "Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene;", "getClean_resource_scene", "()Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene;", "resource_msg_link_token", "getResource_msg_link_token", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ImageProperty extends com.lark.wire.Message<ImageProperty, a> {
        public static final ProtoAdapter<ImageProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final String DEFAULT_ALT = "";
        public static final String DEFAULT_ALT_I18N_KEY = "";
        public static final String DEFAULT_FS_UNIT = "";
        public static final boolean DEFAULT_IMG_CAN_PREVIEW = false;
        public static final boolean DEFAULT_IS_ORIGIN_SOURCE = false;
        public static final String DEFAULT_MIDDLE_KEY = "";
        public static final int DEFAULT_ORIGIN_HEIGHT = 0;
        public static final String DEFAULT_ORIGIN_KEY = "";
        public static final int DEFAULT_ORIGIN_WIDTH = 0;
        public static final String DEFAULT_THUMB_KEY = "";
        public static final String DEFAULT_TOKEN = "";
        private static final long serialVersionUID = 0;
        private final String alt;
        private final String alt_i18n_key;
        private final ResourceCleanScene clean_resource_scene;
        private final Image cover;
        private final Integer custom_width;
        private final String fs_unit;
        private final Integer height;
        private final Boolean img_can_preview;
        private final ByteString inline_preview;
        private final Image intact;
        private final Boolean is_origin_source;
        private final String middle_key;
        private final Image middle_mp4;
        private final Image middle_webp;
        private final Boolean need_copy;
        private final Image origin;
        private final Integer origin_height;
        private final String origin_key;
        private final Long origin_size;
        private final Integer origin_width;
        private final Boolean resource_is_cleaned;
        private final String resource_msg_link_token;
        private final String resource_preview_token;
        private final Integer show_mode;
        private final String thumb_key;
        private final Image thumbnail_webp;
        private final String token;
        private final String upload_id;
        private final List<String> urls;
        private final Integer width;

        public static final class a extends com.lark.wire.Message.a<ImageProperty, a> {
            public Image A;
            public Integer B;
            public Integer C;
            public String D;
            public Boolean E;
            public ResourceCleanScene F;
            public String G;
            public List<String> d;
            public String e;
            public String f;
            public String g;
            public String h;
            public Integer i;
            public Integer j;
            public String k;
            public String l;
            public String m;
            public Boolean n;
            public Image o;
            public Image p;
            public Image q;
            public Image r;
            public Integer s;
            public Image t;
            public Boolean u;
            public Long v;
            public String w;
            public ByteString x;
            public Integer y;
            public Boolean z;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ImageProperty(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ImageProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ImageProperty c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L37;
                switch(r5) {
                    case 1: goto L36;
                    case 2: goto L35;
                    case 3: goto L34;
                    case 4: goto L33;
                    case 5: goto L32;
                    case 6: goto L31;
                    case 7: goto L30;
                    case 8: goto L29;
                    case 9: goto L28;
                    case 10: goto L27;
                    case 11: goto L26;
                    case 12: goto L25;
                    case 13: goto L24;
                    case 14: goto L23;
                    case 15: goto L22;
                    case 16: goto L21;
                    case 17: goto L20;
                    case 18: goto L6;
                    case 19: goto L6;
                    case 20: goto L19;
                    case 21: goto L18;
                    case 22: goto L17;
                    case 23: goto L16;
                    case 24: goto L15;
                    case 25: goto L14;
                    case 26: goto L13;
                    case 27: goto L12;
                    case 28: goto L11;
                    case 29: goto L10;
                    case 30: goto L9;
                    case 31: goto L8;
                    case 32: goto L7;
                    default: goto L6;
                };
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.G = r8.i();
                goto L3
            L8:
                r1.F = ResourceCleanScene.ADAPTER.c(r8);
                goto L3
            L9:
                r1.E = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.D = r8.i();
                goto L3
            L11:
                r1.C = (Integer) ProtoAdapter.i.c(r8);
                goto L3
            L12:
                r1.B = (Integer) ProtoAdapter.i.c(r8);
                goto L3
            L13:
                r1.A = Image.ADAPTER.c(r8);
                goto L3
            L14:
                r1.z = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L15:
                r1.y = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L16:
                ProtoAdapter.p.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.x = r8.f();
                goto L3
            L17:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.w = r8.i();
                goto L3
            L18:
                r1.v = (Long) ProtoAdapter.l.c(r8);
                goto L3
            L19:
                r1.u = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L20:
                r1.t = Image.ADAPTER.c(r8);
                goto L3
            L21:
                r1.s = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L22:
                r1.r = Image.ADAPTER.c(r8);
                goto L3
            L23:
                r1.q = Image.ADAPTER.c(r8);
                goto L3
            L24:
                r1.p = Image.ADAPTER.c(r8);
                goto L3
            L25:
                r1.o = Image.ADAPTER.c(r8);
                goto L3
            L26:
                r1.n = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L27:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.m = r8.i();
                goto L3
            L28:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.l = r8.i();
                goto L3
            L29:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.k = r8.i();
                goto L3
            L30:
                r1.j = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L31:
                r1.i = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L32:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.h = r8.i();
                goto L3
            L33:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.g = r8.i();
                goto L3
            L34:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.f = r8.i();
                goto L3
            L35:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.e = r8.i();
                goto L3
            L36:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L6:
                r8.j(r5);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L37:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "urls");
                com.lark.wire.internal.a.a(r2);
                r1.d = r2;
                return new ImageProperty(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ImageProperty r9) {
                ImageProperty r10 = r9;
                Intrinsics.checkNotNullParameter(r10, "value");
                int r0 = r10.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = ((((r0 + r1.a().l(1, r10.getUrls())) + r1.l(2, r10.getToken())) + r1.l(3, r10.getOrigin_key())) + r1.l(4, r10.getMiddle_key())) + r1.l(5, r10.getThumb_key());
                s r3 = ProtoAdapter.h;
                int r4 = ((((r2 + r3.l(6, r10.getOrigin_width())) + r3.l(7, r10.getOrigin_height())) + r1.l(8, r10.getFs_unit())) + r1.l(9, r10.getAlt())) + r1.l(10, r10.getAlt_i18n_key());
                l r5 = ProtoAdapter.g;
                int r6 = r4 + r5.l(11, r10.getImg_can_preview());
                ProtoAdapter<Image> r7 = Image.ADAPTER;
                int r8 = ((((((((((((r6 + r7.l(12, r10.getThumbnail_webp())) + r7.l(13, r10.getMiddle_webp())) + r7.l(14, r10.getMiddle_mp4())) + r7.l(15, r10.getCover())) + r3.l(16, r10.getCustom_width())) + r7.l(17, r10.getIntact())) + r5.l(20, r10.is_origin_source())) + ProtoAdapter.l.l(21, r10.getOrigin_size())) + r1.l(22, r10.getUpload_id())) + ProtoAdapter.p.l(23, r10.getInline_preview())) + r3.l(24, r10.getShow_mode())) + r5.l(25, r10.getNeed_copy())) + r7.l(26, r10.getOrigin());
                b0 r11 = ProtoAdapter.i;
                return (((((r8 + r11.l(27, r10.getWidth())) + r11.l(28, r10.getHeight())) + r1.l(29, r10.getResource_preview_token())) + r5.l(30, r10.getResource_is_cleaned())) + ResourceCleanScene.ADAPTER.l(31, r10.getClean_resource_scene())) + r1.l(32, r10.getResource_msg_link_token());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r8, ImageProperty r9) {
                ImageProperty r10 = r9;
                Intrinsics.checkNotNullParameter(r8, "writer");
                Intrinsics.checkNotNullParameter(r10, "value");
                w r0 = ProtoAdapter.q;
                r0.a().i(r8, 1, r10.getUrls());
                r0.i(r8, 2, r10.getToken());
                r0.i(r8, 3, r10.getOrigin_key());
                r0.i(r8, 4, r10.getMiddle_key());
                r0.i(r8, 5, r10.getThumb_key());
                s r1 = ProtoAdapter.h;
                r1.i(r8, 6, r10.getOrigin_width());
                r1.i(r8, 7, r10.getOrigin_height());
                r0.i(r8, 8, r10.getFs_unit());
                r0.i(r8, 9, r10.getAlt());
                r0.i(r8, 10, r10.getAlt_i18n_key());
                l r2 = ProtoAdapter.g;
                r2.i(r8, 11, r10.getImg_can_preview());
                ProtoAdapter<Image> r3 = Image.ADAPTER;
                r3.i(r8, 12, r10.getThumbnail_webp());
                r3.i(r8, 13, r10.getMiddle_webp());
                r3.i(r8, 14, r10.getMiddle_mp4());
                r3.i(r8, 15, r10.getCover());
                r1.i(r8, 16, r10.getCustom_width());
                r3.i(r8, 17, r10.getIntact());
                r2.i(r8, 20, r10.is_origin_source());
                ProtoAdapter.l.i(r8, 21, r10.getOrigin_size());
                r0.i(r8, 22, r10.getUpload_id());
                ProtoAdapter.p.i(r8, 23, r10.getInline_preview());
                r1.i(r8, 24, r10.getShow_mode());
                r2.i(r8, 25, r10.getNeed_copy());
                r3.i(r8, 26, r10.getOrigin());
                b0 r4 = ProtoAdapter.i;
                r4.i(r8, 27, r10.getWidth());
                r4.i(r8, 28, r10.getHeight());
                r0.i(r8, 29, r10.getResource_preview_token());
                r2.i(r8, 30, r10.getResource_is_cleaned());
                ResourceCleanScene.ADAPTER.i(r8, 31, r10.getClean_resource_scene());
                r0.i(r8, 32, r10.getResource_msg_link_token());
                r8.a(r10.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r8, ImageProperty r9) {
                ImageProperty r10 = r9;
                Intrinsics.checkNotNullParameter(r8, "writer");
                Intrinsics.checkNotNullParameter(r10, "value");
                r8.d(r10.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r8, 32, r10.getResource_msg_link_token());
                ResourceCleanScene.ADAPTER.j(r8, 31, r10.getClean_resource_scene());
                l r1 = ProtoAdapter.g;
                r1.j(r8, 30, r10.getResource_is_cleaned());
                r0.j(r8, 29, r10.getResource_preview_token());
                b0 r2 = ProtoAdapter.i;
                r2.j(r8, 28, r10.getHeight());
                r2.j(r8, 27, r10.getWidth());
                ProtoAdapter<Image> r3 = Image.ADAPTER;
                r3.j(r8, 26, r10.getOrigin());
                r1.j(r8, 25, r10.getNeed_copy());
                s r4 = ProtoAdapter.h;
                r4.j(r8, 24, r10.getShow_mode());
                ProtoAdapter.p.j(r8, 23, r10.getInline_preview());
                r0.j(r8, 22, r10.getUpload_id());
                ProtoAdapter.l.j(r8, 21, r10.getOrigin_size());
                r1.j(r8, 20, r10.is_origin_source());
                r3.j(r8, 17, r10.getIntact());
                r4.j(r8, 16, r10.getCustom_width());
                r3.j(r8, 15, r10.getCover());
                r3.j(r8, 14, r10.getMiddle_mp4());
                r3.j(r8, 13, r10.getMiddle_webp());
                r3.j(r8, 12, r10.getThumbnail_webp());
                r1.j(r8, 11, r10.getImg_can_preview());
                r0.j(r8, 10, r10.getAlt_i18n_key());
                r0.j(r8, 9, r10.getAlt());
                r0.j(r8, 8, r10.getFs_unit());
                r4.j(r8, 7, r10.getOrigin_height());
                r4.j(r8, 6, r10.getOrigin_width());
                r0.j(r8, 5, r10.getThumb_key());
                r0.j(r8, 4, r10.getMiddle_key());
                r0.j(r8, 3, r10.getOrigin_key());
                r0.j(r8, 2, r10.getToken());
                r0.a().j(r8, 1, r10.getUrls());
            }

            public b(FieldEncoding r7, KClass<ImageProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ImageProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ImageProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        @Deprecated(message = "resource_is_cleaned is deprecated")
        public static /* synthetic */ void getResource_is_cleaned$annotations() {
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.urls;
            r0.e = this.token;
            r0.f = this.origin_key;
            r0.g = this.middle_key;
            r0.h = this.thumb_key;
            r0.i = this.origin_width;
            r0.j = this.origin_height;
            r0.k = this.fs_unit;
            r0.l = this.alt;
            r0.m = this.alt_i18n_key;
            r0.n = this.img_can_preview;
            r0.o = this.thumbnail_webp;
            r0.p = this.middle_webp;
            r0.q = this.middle_mp4;
            r0.r = this.cover;
            r0.s = this.custom_width;
            r0.t = this.intact;
            r0.u = this.is_origin_source;
            r0.v = this.origin_size;
            r0.w = this.upload_id;
            r0.x = this.inline_preview;
            r0.y = this.show_mode;
            r0.z = this.need_copy;
            r0.A = this.origin;
            r0.B = this.width;
            r0.C = this.height;
            r0.D = this.resource_preview_token;
            r0.E = this.resource_is_cleaned;
            r0.F = this.clean_resource_scene;
            r0.G = this.resource_msg_link_token;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ImageProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAlt() {
            return this.alt;
        }

        public final String getAlt_i18n_key() {
            return this.alt_i18n_key;
        }

        public final ResourceCleanScene getClean_resource_scene() {
            return this.clean_resource_scene;
        }

        public final Image getCover() {
            return this.cover;
        }

        public final Integer getCustom_width() {
            return this.custom_width;
        }

        public final String getFs_unit() {
            return this.fs_unit;
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final Boolean getImg_can_preview() {
            return this.img_can_preview;
        }

        public final ByteString getInline_preview() {
            return this.inline_preview;
        }

        public final Image getIntact() {
            return this.intact;
        }

        public final String getMiddle_key() {
            return this.middle_key;
        }

        public final Image getMiddle_mp4() {
            return this.middle_mp4;
        }

        public final Image getMiddle_webp() {
            return this.middle_webp;
        }

        public final Boolean getNeed_copy() {
            return this.need_copy;
        }

        public final Image getOrigin() {
            return this.origin;
        }

        public final Integer getOrigin_height() {
            return this.origin_height;
        }

        public final String getOrigin_key() {
            return this.origin_key;
        }

        public final Long getOrigin_size() {
            return this.origin_size;
        }

        public final Integer getOrigin_width() {
            return this.origin_width;
        }

        public final Boolean getResource_is_cleaned() {
            return this.resource_is_cleaned;
        }

        public final String getResource_msg_link_token() {
            return this.resource_msg_link_token;
        }

        public final String getResource_preview_token() {
            return this.resource_preview_token;
        }

        public final Integer getShow_mode() {
            return this.show_mode;
        }

        public final String getThumb_key() {
            return this.thumb_key;
        }

        public final Image getThumbnail_webp() {
            return this.thumbnail_webp;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getUpload_id() {
            return this.upload_id;
        }

        public final List<String> getUrls() {
            return this.urls;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public final Boolean is_origin_source() {
            return this.is_origin_source;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ImageProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.urls = com.lark.wire.internal.a.c("urls", r2.d);
            this.token = r2.e;
            this.origin_key = r2.f;
            this.middle_key = r2.g;
            this.thumb_key = r2.h;
            this.origin_width = r2.i;
            this.origin_height = r2.j;
            this.fs_unit = r2.k;
            this.alt = r2.l;
            this.alt_i18n_key = r2.m;
            this.img_can_preview = r2.n;
            this.thumbnail_webp = r2.o;
            this.middle_webp = r2.p;
            this.middle_mp4 = r2.q;
            this.cover = r2.r;
            this.custom_width = r2.s;
            this.intact = r2.t;
            this.is_origin_source = r2.u;
            this.origin_size = r2.v;
            this.upload_id = r2.w;
            this.inline_preview = r2.x;
            this.show_mode = r2.y;
            this.need_copy = r2.z;
            this.origin = r2.A;
            this.width = r2.B;
            this.height = r2.C;
            this.resource_preview_token = r2.D;
            this.resource_is_cleaned = r2.E;
            this.clean_resource_scene = r2.F;
            this.resource_msg_link_token = r2.G;
        }

        public /* synthetic */ ImageProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ItalicProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ItalicProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ItalicProperty$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "i18n_key", "getI18n_key", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ItalicProperty extends com.lark.wire.Message<ItalicProperty, a> {
        public static final ProtoAdapter<ItalicProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final String i18n_key;

        public static final class a extends com.lark.wire.Message.a<ItalicProperty, a> {
            public String d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ItalicProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ItalicProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ItalicProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "content");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L13:
                return new ItalicProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ItalicProperty r5) {
                ItalicProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getContent())) + r1.l(2, r6.getI18n_key());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ItalicProperty r5) {
                ItalicProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getContent());
                r0.i(r4, 2, r6.getI18n_key());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ItalicProperty r5) {
                ItalicProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getI18n_key());
                r0.j(r4, 1, r6.getContent());
            }

            public b(FieldEncoding r7, KClass<ItalicProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ItalicProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ItalicProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ItalicProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content;
            r0.e = this.i18n_key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ItalicProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final String getI18n_key() {
            return this.i18n_key;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ItalicProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.content = r4;
            this.i18n_key = r2.e;
        }

        public /* synthetic */ ItalicProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$LIProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$LIProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$LIProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LIProperty extends com.lark.wire.Message<LIProperty, a> {
        public static final ProtoAdapter<LIProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<LIProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LIProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LIProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final LIProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new LIProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LIProperty r2) {
                LIProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, LIProperty r3) {
                LIProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, LIProperty r3) {
                LIProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<LIProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.LIProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LIProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LIProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LIProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LIProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ LIProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$LinkProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$LinkProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$LinkProperty$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "ios_url", "getIos_url", "android_url", "getAndroid_url", "pc_url", "getPc_url", "special_url", "Lcom/lark/kmp/pb/basic/v1/SpecialURL;", "getSpecial_url", "()Lcom/lark/kmp/pb/basic/v1/SpecialURL;", "scene", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$LinkProperty$LinkScene;", "getScene", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$LinkProperty$LinkScene;", "newBuilder", "toString", "Builder", "Companion", "LinkScene", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LinkProperty extends com.lark.wire.Message<LinkProperty, a> {
        public static final ProtoAdapter<LinkProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String android_url;
        private final String ios_url;
        private final String pc_url;
        private final LinkScene scene;
        private final SpecialURL special_url;
        private final String url;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$LinkProperty$LinkScene;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CardLink", "ContentLink", "FooterLink", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum LinkScene extends Enum<LinkScene> implements o0 {
            public static final ProtoAdapter<LinkScene> ADAPTER = null;
            public static final LinkScene CardLink = null;
            public static final b Companion = null;
            public static final LinkScene ContentLink = null;
            public static final LinkScene FooterLink = null;
            public static final LinkScene UNKNOWN = null;
            public static final /* synthetic */ LinkScene[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<LinkScene> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    LinkScene.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
                    return null;
                L17:
                    return LinkScene.FooterLink;
                L18:
                    return LinkScene.ContentLink;
                L19:
                    return LinkScene.CardLink;
                L15:
                    return LinkScene.UNKNOWN;
                }

                public a(KClass<LinkScene> r1, Syntax r2, LinkScene r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<LinkScene> getEntries() {
                return b;
            }

            static {
                LinkScene r0 = new LinkScene("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                LinkScene r1 = new LinkScene("CardLink", 1, 1);
                CardLink = r1;
                LinkScene r3 = new LinkScene("ContentLink", 2, 2);
                ContentLink = r3;
                LinkScene r5 = new LinkScene("FooterLink", 3, 3);
                FooterLink = r5;
                LinkScene[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(LinkScene.class), Syntax.PROTO_2, r0);
            }

            public static LinkScene[] values() {
                return (LinkScene[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final LinkScene fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
                return null;
            L17:
                return FooterLink;
            L18:
                return ContentLink;
            L19:
                return CardLink;
            L15:
                return UNKNOWN;
            }

            public static LinkScene valueOf(String r1) {
                return (LinkScene) r27.a.a(LinkScene.class, r1);
            }

            public LinkScene(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<LinkProperty, a> {
            public String d;
            public String e;
            public String f;
            public String g;
            public SpecialURL h;
            public LinkScene i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LinkProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LinkProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final LinkProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L20;
                switch(r4) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L21;
                    case 6: goto L23;
                    default: goto L6;
                };
            L21:
                r1.h = SpecialURL.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L23:
                r1.i = LinkScene.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L15:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L16:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.f = r10.i();
                goto L3
            L17:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L18:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L6:
                r10.j(r4);
                Unit r7 = Unit.INSTANCE;
                goto L3
            L20:
                return new LinkProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LinkProperty r5) {
                LinkProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((((r0 + r1.l(1, r6.getUrl())) + r1.l(2, r6.getIos_url())) + r1.l(3, r6.getAndroid_url())) + r1.l(4, r6.getPc_url())) + SpecialURL.ADAPTER.l(5, r6.getSpecial_url())) + LinkScene.ADAPTER.l(6, r6.getScene());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LinkProperty r5) {
                LinkProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUrl());
                r0.i(r4, 2, r6.getIos_url());
                r0.i(r4, 3, r6.getAndroid_url());
                r0.i(r4, 4, r6.getPc_url());
                SpecialURL.ADAPTER.i(r4, 5, r6.getSpecial_url());
                LinkScene.ADAPTER.i(r4, 6, r6.getScene());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, LinkProperty r5) {
                LinkProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                LinkScene.ADAPTER.j(r4, 6, r6.getScene());
                SpecialURL.ADAPTER.j(r4, 5, r6.getSpecial_url());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getPc_url());
                r0.j(r4, 3, r6.getAndroid_url());
                r0.j(r4, 2, r6.getIos_url());
                r0.j(r4, 1, r6.getUrl());
            }

            public b(FieldEncoding r7, KClass<LinkProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.LinkProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LinkProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LinkProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.url;
            r0.e = this.ios_url;
            r0.f = this.android_url;
            r0.g = this.pc_url;
            r0.h = this.special_url;
            r0.i = this.scene;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LinkProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAndroid_url() {
            return this.android_url;
        }

        public final String getIos_url() {
            return this.ios_url;
        }

        public final String getPc_url() {
            return this.pc_url;
        }

        public final LinkScene getScene() {
            return this.scene;
        }

        public final SpecialURL getSpecial_url() {
            return this.special_url;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LinkProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.url = r2.d;
            this.ios_url = r2.e;
            this.android_url = r2.f;
            this.pc_url = r2.g;
            this.special_url = r2.h;
            this.scene = r2.i;
        }

        public /* synthetic */ LinkProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0016\u0010\u0018R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MarkdownProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MarkdownProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$MarkdownProperty$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "images", "", "Lcom/lark/kmp/pb/basic/v1/ImageSetV2;", "getImages", "()Ljava/util/Map;", "at_user_ids", "", "", "getAt_user_ids", "()Ljava/util/List;", "is_at_all", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "at_users", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "getAt_users", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MarkdownProperty extends com.lark.wire.Message<MarkdownProperty, a> {
        public static final ProtoAdapter<MarkdownProperty> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final List<Long> at_user_ids;
        private final Map<String, AtProperty> at_users;
        private final String content;
        private final Map<String, ImageSetV2> images;
        private final Boolean is_at_all;

        public static final class a extends com.lark.wire.Message.a<MarkdownProperty, a> {
            public String d;
            public Map<String, ImageSetV2> e;
            public List<Long> f;
            public Boolean g;
            public Map<String, AtProperty> h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MarkdownProperty(this, c(), null);
            }

            public a() {
                this.e = MapsKt.emptyMap();
                this.f = CollectionsKt.emptyList();
                this.h = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ MarkdownProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(MarkdownProperty.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new RichTextElement$MarkdownProperty$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content;
            r0.e = this.images;
            r0.f = this.at_user_ids;
            r0.g = this.is_at_all;
            r0.h = this.at_users;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MarkdownProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final List<Long> getAt_user_ids() {
            return this.at_user_ids;
        }

        public final Map<String, AtProperty> getAt_users() {
            return this.at_users;
        }

        public final String getContent() {
            return this.content;
        }

        public final Map<String, ImageSetV2> getImages() {
            return this.images;
        }

        public final Boolean is_at_all() {
            return this.is_at_all;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MarkdownProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.content = r2.d;
            this.images = com.lark.wire.internal.a.d("images", r2.e);
            this.at_user_ids = com.lark.wire.internal.a.c("at_user_ids", r2.f);
            this.is_at_all = r2.g;
            this.at_users = com.lark.wire.internal.a.d("at_users", r2.h);
        }

        public /* synthetic */ MarkdownProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 O2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003NOPB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010L\u001a\u00020\u0002H\u0016J\b\u0010M\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0013\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0015\u0010&\u001a\u0004\u0018\u00010'¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010+\u001a\u0004\u0018\u00010'¢\u0006\n\n\u0002\u0010*\u001a\u0004\b,\u0010)R\u0013\u0010-\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000bR\u0013\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0013\u00101\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u00104\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b5\u0010 R\u0015\u00106\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b7\u0010 R\u0013\u00108\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000bR\u0013\u0010:\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000bR\u0013\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000bR\u0013\u0010>\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000bR\u0013\u0010@\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000bR \u0010B\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010*\u0012\u0004\bC\u0010D\u001a\u0004\bE\u0010)R\u0013\u0010F\u001a\u0004\u0018\u00010G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010J\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u000b¨\u0006Q"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MediaProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MediaProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$MediaProperty$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "name", "getName", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "mime", "getMime", "source", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MediaProperty$Source;", "getSource", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MediaProperty$Source;", "image", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "fs_unit", "getFs_unit", "crypto_token", "getCrypto_token", "need_copy_img", "", "getNeed_copy_img", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "need_copy_media", "getNeed_copy_media", "compress_path", "getCompress_path", "origin_path", "getOrigin_path", "image_data", "getImage_data", "()Lokio/ByteString;", "width", "getWidth", "height", "getHeight", "url", "getUrl", "image_path", "getImage_path", "image_upload_id", "getImage_upload_id", "media_upload_id", "getMedia_upload_id", "resource_preview_token", "getResource_preview_token", "resource_is_cleaned", "getResource_is_cleaned$annotations", "()V", "getResource_is_cleaned", "clean_resource_scene", "Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene;", "getClean_resource_scene", "()Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene;", "resource_msg_link_token", "getResource_msg_link_token", "newBuilder", "toString", "Builder", "Companion", "Source", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MediaProperty extends com.lark.wire.Message<MediaProperty, a> {
        public static final ProtoAdapter<MediaProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_HEIGHT = 0;
        public static final int DEFAULT_WIDTH = 0;
        private static final long serialVersionUID = 0;
        private final ResourceCleanScene clean_resource_scene;
        private final String compress_path;
        private final String crypto_token;
        private final Integer duration;
        private final String fs_unit;
        private final Integer height;
        private final ImageSet image;
        private final ByteString image_data;
        private final String image_path;
        private final String image_upload_id;
        private final String key;
        private final String media_upload_id;
        private final String mime;
        private final String name;
        private final Boolean need_copy_img;
        private final Boolean need_copy_media;
        private final String origin_path;
        private final Boolean resource_is_cleaned;
        private final String resource_msg_link_token;
        private final String resource_preview_token;
        private final Long size;
        private final Source source;
        private final String url;
        private final Integer width;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MediaProperty$Source;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "LARK", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Source extends Enum<Source> implements o0 {
            public static final ProtoAdapter<Source> ADAPTER = null;
            public static final b Companion = null;
            public static final Source LARK = null;
            public static final Source UNKNOWN = null;
            public static final /* synthetic */ Source[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Source> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Source.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return Source.LARK;
                L9:
                    return Source.UNKNOWN;
                }

                public a(KClass<Source> r1, Syntax r2, Source r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Source> getEntries() {
                return b;
            }

            static {
                Source r0 = new Source("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Source r1 = new Source("LARK", 1, 1);
                LARK = r1;
                Source[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Source.class), Syntax.PROTO_2, r0);
            }

            public static Source[] values() {
                return (Source[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Source fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return LARK;
            L9:
                return UNKNOWN;
            }

            public static Source valueOf(String r1) {
                return (Source) r27.a.a(Source.class, r1);
            }

            public Source(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<MediaProperty, a> {
            public String A;
            public String d;
            public String e;
            public Long f;
            public String g;
            public Source h;
            public ImageSet i;
            public Integer j;
            public String k;
            public String l;
            public Boolean m;
            public Boolean n;
            public String o;
            public String p;
            public ByteString q;
            public Integer r;
            public Integer s;
            public String t;
            public String u;
            public String v;
            public String w;
            public String x;
            public Boolean y;
            public ResourceCleanScene z;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MediaProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MediaProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final MediaProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L36;
                switch(r4) {
                    case 1: goto L21;
                    case 2: goto L20;
                    case 3: goto L19;
                    case 4: goto L18;
                    case 5: goto L37;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L11;
                    case 9: goto L10;
                    case 10: goto L9;
                    case 11: goto L8;
                    default: goto L6;
                };
            L37:
                r1.h = Source.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                r1.n = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L9:
                r1.m = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.l = r10.i();
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.k = r10.i();
                goto L3
            L12:
                r1.j = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L13:
                r1.i = ImageSet.ADAPTER.c(r10);
                goto L3
            L18:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L19:
                r1.f = (Long) ProtoAdapter.k.c(r10);
                goto L3
            L20:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L21:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L6:
                switch(r4) {
                    case 100: goto L34;
                    case 101: goto L33;
                    case 102: goto L32;
                    case 103: goto L31;
                    case 104: goto L30;
                    case 105: goto L29;
                    case 106: goto L28;
                    case 107: goto L27;
                    case 108: goto L26;
                    case 109: goto L25;
                    case 110: goto L24;
                    case 111: goto L23;
                    case 112: goto L22;
                    default: goto L7;
                };
            L22:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.A = r10.i();
                goto L3
            L23:
                r1.z = ResourceCleanScene.ADAPTER.c(r10);
                goto L3
            L24:
                r1.y = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L25:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.x = r10.i();
                goto L3
            L26:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.w = r10.i();
                goto L3
            L27:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.v = r10.i();
                goto L3
            L28:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.u = r10.i();
                goto L3
            L29:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.t = r10.i();
                goto L3
            L30:
                r1.s = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L31:
                r1.r = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L32:
                ProtoAdapter.p.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.q = r10.f();
                goto L3
            L33:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.p = r10.i();
                goto L3
            L34:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.o = r10.i();
                goto L3
            L7:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L36:
                return new MediaProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MediaProperty r8) {
                MediaProperty r9 = r8;
                Intrinsics.checkNotNullParameter(r9, "value");
                int r0 = r9.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = (((((r0 + r1.l(1, r9.getKey())) + r1.l(2, r9.getName())) + ProtoAdapter.k.l(3, r9.getSize())) + r1.l(4, r9.getMime())) + Source.ADAPTER.l(5, r9.getSource())) + ImageSet.ADAPTER.l(6, r9.getImage());
                s r3 = ProtoAdapter.h;
                int r4 = ((r2 + r3.l(7, r9.getDuration())) + r1.l(8, r9.getFs_unit())) + r1.l(9, r9.getCrypto_token());
                l r5 = ProtoAdapter.g;
                return ((((((((((((((r4 + r5.l(10, r9.getNeed_copy_img())) + r5.l(11, r9.getNeed_copy_media())) + r1.l(100, r9.getCompress_path())) + r1.l(101, r9.getOrigin_path())) + ProtoAdapter.p.l(102, r9.getImage_data())) + r3.l(103, r9.getWidth())) + r3.l(104, r9.getHeight())) + r1.l(105, r9.getUrl())) + r1.l(106, r9.getImage_path())) + r1.l(107, r9.getImage_upload_id())) + r1.l(108, r9.getMedia_upload_id())) + r1.l(109, r9.getResource_preview_token())) + r5.l(110, r9.getResource_is_cleaned())) + ResourceCleanScene.ADAPTER.l(111, r9.getClean_resource_scene())) + r1.l(112, r9.getResource_msg_link_token());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r7, MediaProperty r8) {
                MediaProperty r9 = r8;
                Intrinsics.checkNotNullParameter(r7, "writer");
                Intrinsics.checkNotNullParameter(r9, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r7, 1, r9.getKey());
                r0.i(r7, 2, r9.getName());
                ProtoAdapter.k.i(r7, 3, r9.getSize());
                r0.i(r7, 4, r9.getMime());
                Source.ADAPTER.i(r7, 5, r9.getSource());
                ImageSet.ADAPTER.i(r7, 6, r9.getImage());
                s r1 = ProtoAdapter.h;
                r1.i(r7, 7, r9.getDuration());
                r0.i(r7, 8, r9.getFs_unit());
                r0.i(r7, 9, r9.getCrypto_token());
                l r2 = ProtoAdapter.g;
                r2.i(r7, 10, r9.getNeed_copy_img());
                r2.i(r7, 11, r9.getNeed_copy_media());
                r0.i(r7, 100, r9.getCompress_path());
                r0.i(r7, 101, r9.getOrigin_path());
                ProtoAdapter.p.i(r7, 102, r9.getImage_data());
                r1.i(r7, 103, r9.getWidth());
                r1.i(r7, 104, r9.getHeight());
                r0.i(r7, 105, r9.getUrl());
                r0.i(r7, 106, r9.getImage_path());
                r0.i(r7, 107, r9.getImage_upload_id());
                r0.i(r7, 108, r9.getMedia_upload_id());
                r0.i(r7, 109, r9.getResource_preview_token());
                r2.i(r7, 110, r9.getResource_is_cleaned());
                ResourceCleanScene.ADAPTER.i(r7, 111, r9.getClean_resource_scene());
                r0.i(r7, 112, r9.getResource_msg_link_token());
                r7.a(r9.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r7, MediaProperty r8) {
                MediaProperty r9 = r8;
                Intrinsics.checkNotNullParameter(r7, "writer");
                Intrinsics.checkNotNullParameter(r9, "value");
                r7.d(r9.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r7, 112, r9.getResource_msg_link_token());
                ResourceCleanScene.ADAPTER.j(r7, 111, r9.getClean_resource_scene());
                l r1 = ProtoAdapter.g;
                r1.j(r7, 110, r9.getResource_is_cleaned());
                r0.j(r7, 109, r9.getResource_preview_token());
                r0.j(r7, 108, r9.getMedia_upload_id());
                r0.j(r7, 107, r9.getImage_upload_id());
                r0.j(r7, 106, r9.getImage_path());
                r0.j(r7, 105, r9.getUrl());
                s r2 = ProtoAdapter.h;
                r2.j(r7, 104, r9.getHeight());
                r2.j(r7, 103, r9.getWidth());
                ProtoAdapter.p.j(r7, 102, r9.getImage_data());
                r0.j(r7, 101, r9.getOrigin_path());
                r0.j(r7, 100, r9.getCompress_path());
                r1.j(r7, 11, r9.getNeed_copy_media());
                r1.j(r7, 10, r9.getNeed_copy_img());
                r0.j(r7, 9, r9.getCrypto_token());
                r0.j(r7, 8, r9.getFs_unit());
                r2.j(r7, 7, r9.getDuration());
                ImageSet.ADAPTER.j(r7, 6, r9.getImage());
                Source.ADAPTER.j(r7, 5, r9.getSource());
                r0.j(r7, 4, r9.getMime());
                ProtoAdapter.k.j(r7, 3, r9.getSize());
                r0.j(r7, 2, r9.getName());
                r0.j(r7, 1, r9.getKey());
            }

            public b(FieldEncoding r7, KClass<MediaProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.MediaProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MediaProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        @Deprecated(message = "resource_is_cleaned is deprecated")
        public static /* synthetic */ void getResource_is_cleaned$annotations() {
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MediaProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.key;
            r0.e = this.name;
            r0.f = this.size;
            r0.g = this.mime;
            r0.h = this.source;
            r0.i = this.image;
            r0.j = this.duration;
            r0.k = this.fs_unit;
            r0.l = this.crypto_token;
            r0.m = this.need_copy_img;
            r0.n = this.need_copy_media;
            r0.o = this.compress_path;
            r0.p = this.origin_path;
            r0.q = this.image_data;
            r0.r = this.width;
            r0.s = this.height;
            r0.t = this.url;
            r0.u = this.image_path;
            r0.v = this.image_upload_id;
            r0.w = this.media_upload_id;
            r0.x = this.resource_preview_token;
            r0.y = this.resource_is_cleaned;
            r0.z = this.clean_resource_scene;
            r0.A = this.resource_msg_link_token;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MediaProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final ResourceCleanScene getClean_resource_scene() {
            return this.clean_resource_scene;
        }

        public final String getCompress_path() {
            return this.compress_path;
        }

        public final String getCrypto_token() {
            return this.crypto_token;
        }

        public final Integer getDuration() {
            return this.duration;
        }

        public final String getFs_unit() {
            return this.fs_unit;
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final ImageSet getImage() {
            return this.image;
        }

        public final ByteString getImage_data() {
            return this.image_data;
        }

        public final String getImage_path() {
            return this.image_path;
        }

        public final String getImage_upload_id() {
            return this.image_upload_id;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getMedia_upload_id() {
            return this.media_upload_id;
        }

        public final String getMime() {
            return this.mime;
        }

        public final String getName() {
            return this.name;
        }

        public final Boolean getNeed_copy_img() {
            return this.need_copy_img;
        }

        public final Boolean getNeed_copy_media() {
            return this.need_copy_media;
        }

        public final String getOrigin_path() {
            return this.origin_path;
        }

        public final Boolean getResource_is_cleaned() {
            return this.resource_is_cleaned;
        }

        public final String getResource_msg_link_token() {
            return this.resource_msg_link_token;
        }

        public final String getResource_preview_token() {
            return this.resource_preview_token;
        }

        public final Long getSize() {
            return this.size;
        }

        public final Source getSource() {
            return this.source;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Integer getWidth() {
            return this.width;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MediaProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.key = r2.d;
            this.name = r2.e;
            this.size = r2.f;
            this.mime = r2.g;
            this.source = r2.h;
            this.image = r2.i;
            this.duration = r2.j;
            this.fs_unit = r2.k;
            this.crypto_token = r2.l;
            this.need_copy_img = r2.m;
            this.need_copy_media = r2.n;
            this.compress_path = r2.o;
            this.origin_path = r2.p;
            this.image_data = r2.q;
            this.width = r2.r;
            this.height = r2.s;
            this.url = r2.t;
            this.image_path = r2.u;
            this.image_upload_id = r2.v;
            this.media_upload_id = r2.w;
            this.resource_preview_token = r2.x;
            this.resource_is_cleaned = r2.y;
            this.clean_resource_scene = r2.z;
            this.resource_msg_link_token = r2.A;
        }

        public /* synthetic */ MediaProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0012\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionItem$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionItem$MentionType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionItem$MentionType;", "newBuilder", "toString", "Builder", "Companion", "MentionType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MentionItem extends com.lark.wire.Message<MentionItem, a> {
        public static final ProtoAdapter<MentionItem> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String id;
        private final MentionType type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionItem$MentionType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_MENTION_TYPE", "HASH_TAG", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum MentionType extends Enum<MentionType> implements o0 {
            public static final ProtoAdapter<MentionType> ADAPTER = null;
            public static final b Companion = null;
            public static final MentionType HASH_TAG = null;
            public static final MentionType UNKNOWN_MENTION_TYPE = null;
            public static final /* synthetic */ MentionType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<MentionType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    MentionType.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return MentionType.HASH_TAG;
                L9:
                    return MentionType.UNKNOWN_MENTION_TYPE;
                }

                public a(KClass<MentionType> r1, Syntax r2, MentionType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<MentionType> getEntries() {
                return b;
            }

            static {
                MentionType r0 = new MentionType("UNKNOWN_MENTION_TYPE", 0, 0);
                UNKNOWN_MENTION_TYPE = r0;
                MentionType r1 = new MentionType("HASH_TAG", 1, 1);
                HASH_TAG = r1;
                MentionType[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(MentionType.class), Syntax.PROTO_2, r0);
            }

            public static MentionType[] values() {
                return (MentionType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final MentionType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return HASH_TAG;
            L9:
                return UNKNOWN_MENTION_TYPE;
            }

            public static MentionType valueOf(String r1) {
                return (MentionType) r27.a.a(MentionType.class, r1);
            }

            public MentionType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<MentionItem, a> {
            public String d;
            public MentionType e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MentionItem(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MentionItem> {
            @Override // com.lark.wire.ProtoAdapter
            public final MentionItem c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                String r5 = r10.i();
                Intrinsics.checkNotNullParameter(r5, "id");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                MentionType r6 = MentionType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                r1.e = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L9:
                r10.j(r4);
                goto L3
            L16:
                return new MentionItem(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MentionItem r5) {
                MentionItem r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getId())) + MentionType.ADAPTER.l(2, r6.getType());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, MentionItem r5) {
                MentionItem r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getId());
                MentionType.ADAPTER.i(r4, 2, r6.getType());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, MentionItem r5) {
                MentionItem r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                MentionType.ADAPTER.j(r4, 2, r6.getType());
                ProtoAdapter.q.j(r4, 1, r6.getId());
            }

            public b(FieldEncoding r7, KClass<MentionItem> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.MentionItem", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MentionItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MentionItem.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.id;
            r0.e = this.type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MentionItem.class).getSimpleName() + '@' + hashCode();
        }

        public final String getId() {
            return this.id;
        }

        public final MentionType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MentionItem(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.id = r4;
            MentionType r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.type = r5;
        }

        public /* synthetic */ MentionItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionProperty$Builder;Lokio/ByteString;)V", "item", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionItem;", "getItem", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionItem;", "content", "", "getContent", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MentionProperty extends com.lark.wire.Message<MentionProperty, a> {
        public static final ProtoAdapter<MentionProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final MentionItem item;

        public static final class a extends com.lark.wire.Message.a<MentionProperty, a> {
            public MentionItem d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MentionProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MentionProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final MentionProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                r1.d = MentionItem.ADAPTER.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "content");
                r1.e = r5;
                goto L3
            L9:
                r7.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L13:
                return new MentionProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MentionProperty r5) {
                MentionProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + MentionItem.ADAPTER.l(1, r6.getItem())) + ProtoAdapter.q.l(2, r6.getContent());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, MentionProperty r5) {
                MentionProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                MentionItem.ADAPTER.i(r4, 1, r6.getItem());
                ProtoAdapter.q.i(r4, 2, r6.getContent());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, MentionProperty r5) {
                MentionProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.j(r4, 2, r6.getContent());
                MentionItem.ADAPTER.j(r4, 1, r6.getItem());
            }

            public b(FieldEncoding r7, KClass<MentionProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.MentionProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MentionProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MentionProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.item;
            r0.e = this.content;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MentionProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final MentionItem getItem() {
            return this.item;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MentionProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            MentionItem r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.item = r4;
            String r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.content = r5;
        }

        public /* synthetic */ MentionProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MenuOption;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MenuOption$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$MenuOption$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "text_i18n_key", "getText_i18n_key", "value", "getValue", "url", "Lcom/lark/kmp/pb/basic/v1/CardAction$Url;", "getUrl", "()Lcom/lark/kmp/pb/basic/v1/CardAction$Url;", "option_action_id", "getOption_action_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MenuOption extends com.lark.wire.Message<MenuOption, a> {
        public static final ProtoAdapter<MenuOption> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String option_action_id;
        private final String text;
        private final String text_i18n_key;
        private final CardAction.Url url;
        private final String value;

        public static final class a extends com.lark.wire.Message.a<MenuOption, a> {
            public String d;
            public String e;
            public String f;
            public CardAction.Url g;
            public String h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MenuOption(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MenuOption> {
            @Override // com.lark.wire.ProtoAdapter
            public final MenuOption c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L14;
                r1.g = CardAction.Url.ADAPTER.c(r7);
                goto L3
            L14:
                if (r4 != 5) goto L15;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.h = r7.i();
                goto L3
            L15:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L22:
                return new MenuOption(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MenuOption r6) {
                MenuOption r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((((r0 + r1.l(1, r7.getText())) + r1.l(2, r7.getText_i18n_key())) + r1.l(3, r7.getValue())) + CardAction.Url.ADAPTER.l(4, r7.getUrl())) + r1.l(5, r7.getOption_action_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, MenuOption r6) {
                MenuOption r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getText());
                r0.i(r5, 2, r7.getText_i18n_key());
                r0.i(r5, 3, r7.getValue());
                CardAction.Url.ADAPTER.i(r5, 4, r7.getUrl());
                r0.i(r5, 5, r7.getOption_action_id());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, MenuOption r6) {
                MenuOption r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 5, r7.getOption_action_id());
                CardAction.Url.ADAPTER.j(r5, 4, r7.getUrl());
                r0.j(r5, 3, r7.getValue());
                r0.j(r5, 2, r7.getText_i18n_key());
                r0.j(r5, 1, r7.getText());
            }

            public b(FieldEncoding r7, KClass<MenuOption> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.MenuOption", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MenuOption(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MenuOption.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.text;
            r0.e = this.text_i18n_key;
            r0.f = this.value;
            r0.g = this.url;
            r0.h = this.option_action_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MenuOption.class).getSimpleName() + '@' + hashCode();
        }

        public final String getOption_action_id() {
            return this.option_action_id;
        }

        public final String getText() {
            return this.text;
        }

        public final String getText_i18n_key() {
            return this.text_i18n_key;
        }

        public final CardAction.Url getUrl() {
            return this.url;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MenuOption(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.text = r2.d;
            this.text_i18n_key = r2.e;
            this.value = r2.f;
            this.url = r2.g;
            this.option_action_id = r2.h;
        }

        public /* synthetic */ MenuOption(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004 !\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty$Builder;Lokio/ByteString;)V", "tool_id", "", "getTool_id", "()Ljava/lang/String;", "tool_runtime_id", "getTool_runtime_id", "status", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty$Status;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty$Status;", "i18n_name", "", "getI18n_name", "()Ljava/util/Map;", "name", "getName", "text", "getText", "icon", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty$Icon;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty$Icon;", "newBuilder", "toString", "Builder", "Companion", "Status", "Icon", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MyAIToolProperty extends com.lark.wire.Message<MyAIToolProperty, a> {
        public static final ProtoAdapter<MyAIToolProperty> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, String> i18n_name;
        private final Icon icon;
        private final String name;
        private final Status status;
        private final String text;
        private final String tool_id;
        private final String tool_runtime_id;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty$Icon;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOADING", "ANALYZING", "RETRIEVING", "GENERATING", "NONE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Icon extends Enum<Icon> implements o0 {
            public static final ProtoAdapter<Icon> ADAPTER = null;
            public static final Icon ANALYZING = null;
            public static final b Companion = null;
            public static final Icon GENERATING = null;
            public static final Icon LOADING = null;
            public static final Icon NONE = null;
            public static final Icon RETRIEVING = null;
            public static final /* synthetic */ Icon[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Icon> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Icon.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<Icon> r1, Syntax r2, Icon r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Icon a(int r1) {
                    if (r1 == 0) goto L17;
                    if (r1 == 1) goto L22;
                    if (r1 == 2) goto L21;
                    if (r1 == 3) goto L20;
                    if (r1 == 4) goto L19;
                    return null;
                L19:
                    return Icon.NONE;
                L20:
                    return Icon.GENERATING;
                L21:
                    return Icon.RETRIEVING;
                L22:
                    return Icon.ANALYZING;
                L17:
                    return Icon.LOADING;
                }
            }

            @JvmStatic
            public static final Icon fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<Icon> getEntries() {
                return b;
            }

            static {
                Icon r0 = new Icon("LOADING", 0, 0);
                LOADING = r0;
                Icon r1 = new Icon("ANALYZING", 1, 1);
                ANALYZING = r1;
                Icon r3 = new Icon("RETRIEVING", 2, 2);
                RETRIEVING = r3;
                Icon r5 = new Icon("GENERATING", 3, 3);
                GENERATING = r5;
                Icon r7 = new Icon("NONE", 4, 4);
                NONE = r7;
                Icon[] r9 = {r0, r1, r3, r5, r7};
                a = r9;
                b = EnumEntriesKt.enumEntries(r9);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Icon.class), Syntax.PROTO_2, r0);
            }

            public static Icon[] values() {
                return (Icon[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Icon valueOf(String r1) {
                return (Icon) r27.a.a(Icon.class, r1);
            }

            public Icon(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RUNING", "SUCCESS", "FAILED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Status extends Enum<Status> implements o0 {
            public static final ProtoAdapter<Status> ADAPTER = null;
            public static final b Companion = null;
            public static final Status FAILED = null;
            public static final Status RUNING = null;
            public static final Status SUCCESS = null;
            public static final /* synthetic */ Status[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Status> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Status.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Status.FAILED;
                L15:
                    return Status.SUCCESS;
                L12:
                    return Status.RUNING;
                }

                public a(KClass<Status> r1, Syntax r2, Status r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Status> getEntries() {
                return b;
            }

            static {
                Status r0 = new Status("RUNING", 0, 0);
                RUNING = r0;
                Status r1 = new Status("SUCCESS", 1, 1);
                SUCCESS = r1;
                Status r3 = new Status("FAILED", 2, 2);
                FAILED = r3;
                Status[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2, r0);
            }

            public static Status[] values() {
                return (Status[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Status fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return FAILED;
            L15:
                return SUCCESS;
            L12:
                return RUNING;
            }

            public static Status valueOf(String r1) {
                return (Status) r27.a.a(Status.class, r1);
            }

            public Status(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<MyAIToolProperty, a> {
            public String d;
            public String e;
            public Status f;
            public Map<String, String> g;
            public String h;
            public String i;
            public Icon j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MyAIToolProperty(this, c(), null);
            }

            public a() {
                this.g = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ MyAIToolProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(MyAIToolProperty.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new RichTextElement$MyAIToolProperty$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.tool_id;
            r0.e = this.tool_runtime_id;
            r0.f = this.status;
            r0.g = this.i18n_name;
            r0.h = this.name;
            r0.i = this.text;
            r0.j = this.icon;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MyAIToolProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, String> getI18n_name() {
            return this.i18n_name;
        }

        public final Icon getIcon() {
            return this.icon;
        }

        public final String getName() {
            return this.name;
        }

        public final Status getStatus() {
            return this.status;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTool_id() {
            return this.tool_id;
        }

        public final String getTool_runtime_id() {
            return this.tool_runtime_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MyAIToolProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.tool_id = r2.d;
            this.tool_runtime_id = r2.e;
            this.status = r2.f;
            this.i18n_name = com.lark.wire.internal.a.d("i18n_name", r2.g);
            this.name = r2.h;
            this.text = r2.i;
            this.icon = r2.j;
        }

        public /* synthetic */ MyAIToolProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$OLProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$OLProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$OLProperty$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$OLProperty$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$OLProperty$Type;", "start", "", "getStart", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class OLProperty extends com.lark.wire.Message<OLProperty, a> {
        public static final ProtoAdapter<OLProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_START = 1;
        private static final long serialVersionUID = 0;
        private final Integer start;
        private final Type type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$OLProperty$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NUMBER", "LOWERCASE_A", "UPPERCASE_A", "LOWERCASE_ROMAN", "UPPERCASE_ROMAN", "NONE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final b Companion = null;
            public static final Type LOWERCASE_A = null;
            public static final Type LOWERCASE_ROMAN = null;
            public static final Type NONE = null;
            public static final Type NUMBER = null;
            public static final Type UPPERCASE_A = null;
            public static final Type UPPERCASE_ROMAN = null;
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
                public static Type a(int r1) {
                    if (r1 == 0) goto L20;
                    if (r1 == 1) goto L26;
                    if (r1 == 2) goto L25;
                    if (r1 == 3) goto L24;
                    if (r1 == 4) goto L23;
                    if (r1 == 5) goto L22;
                    return null;
                L22:
                    return Type.NONE;
                L23:
                    return Type.UPPERCASE_ROMAN;
                L24:
                    return Type.LOWERCASE_ROMAN;
                L25:
                    return Type.UPPERCASE_A;
                L26:
                    return Type.LOWERCASE_A;
                L20:
                    return Type.NUMBER;
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
                Type r0 = new Type("NUMBER", 0, 0);
                NUMBER = r0;
                Type r1 = new Type("LOWERCASE_A", 1, 1);
                LOWERCASE_A = r1;
                Type r3 = new Type("UPPERCASE_A", 2, 2);
                UPPERCASE_A = r3;
                Type r5 = new Type("LOWERCASE_ROMAN", 3, 3);
                LOWERCASE_ROMAN = r5;
                Type r7 = new Type("UPPERCASE_ROMAN", 4, 4);
                UPPERCASE_ROMAN = r7;
                Type r9 = new Type("NONE", 5, 5);
                NONE = r9;
                Type[] r11 = {r0, r1, r3, r5, r7, r9};
                a = r11;
                b = EnumEntriesKt.enumEntries(r11);
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

        public static final class a extends com.lark.wire.Message.a<OLProperty, a> {
            public Type d;
            public Integer e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new OLProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<OLProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final OLProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new OLProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(OLProperty r5) {
                OLProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType())) + ProtoAdapter.h.l(2, r6.getStart());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, OLProperty r5) {
                OLProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Type.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.h.i(r4, 2, r6.getStart());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, OLProperty r5) {
                OLProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 2, r6.getStart());
                Type.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<OLProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.OLProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ OLProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OLProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.start;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(OLProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getStart() {
            return this.start;
        }

        public final Type getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public OLProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.start = r2.e;
        }

        public /* synthetic */ OLProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$OverflowMenuProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$OverflowMenuProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$OverflowMenuProperty$Builder;Lokio/ByteString;)V", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "options", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MenuOption;", "getOptions", "()Ljava/util/List;", "confirm", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "getConfirm", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "disable", "", "getDisable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_loading", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class OverflowMenuProperty extends com.lark.wire.Message<OverflowMenuProperty, a> {
        public static final ProtoAdapter<OverflowMenuProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_DISABLE = false;
        public static final boolean DEFAULT_IS_LOADING = false;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final ButtonConfirmProperty confirm;
        private final Boolean disable;
        private final Boolean is_loading;
        private final List<MenuOption> options;

        public static final class a extends com.lark.wire.Message.a<OverflowMenuProperty, a> {
            public String d;
            public List<MenuOption> e;
            public ButtonConfirmProperty f;
            public Boolean g;
            public Boolean h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new OverflowMenuProperty(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<OverflowMenuProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final OverflowMenuProperty c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L21;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.d = r8.i();
                goto L3
            L8:
                if (r5 != 2) goto L10;
                r2.add(MenuOption.ADAPTER.c(r8));
                goto L3
            L10:
                if (r5 != 3) goto L12;
                r1.f = ButtonConfirmProperty.ADAPTER.c(r8);
                goto L3
            L12:
                if (r5 != 4) goto L14;
                r1.g = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L14:
                if (r5 != 5) goto L15;
                r1.h = (Boolean) ProtoAdapter.g.c(r8);
                goto L3
            L15:
                r8.j(r5);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L21:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "options");
                com.lark.wire.internal.a.a(r2);
                r1.e = r2;
                return new OverflowMenuProperty(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(OverflowMenuProperty r5) {
                OverflowMenuProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getAction_id())) + MenuOption.ADAPTER.a().l(2, r6.getOptions())) + ButtonConfirmProperty.ADAPTER.l(3, r6.getConfirm());
                l r1 = ProtoAdapter.g;
                return (r0 + r1.l(4, r6.getDisable())) + r1.l(5, r6.is_loading());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, OverflowMenuProperty r5) {
                OverflowMenuProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getAction_id());
                MenuOption.ADAPTER.a().i(r4, 2, r6.getOptions());
                ButtonConfirmProperty.ADAPTER.i(r4, 3, r6.getConfirm());
                l r0 = ProtoAdapter.g;
                r0.i(r4, 4, r6.getDisable());
                r0.i(r4, 5, r6.is_loading());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, OverflowMenuProperty r5) {
                OverflowMenuProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 5, r6.is_loading());
                r0.j(r4, 4, r6.getDisable());
                ButtonConfirmProperty.ADAPTER.j(r4, 3, r6.getConfirm());
                MenuOption.ADAPTER.a().j(r4, 2, r6.getOptions());
                ProtoAdapter.q.j(r4, 1, r6.getAction_id());
            }

            public b(FieldEncoding r7, KClass<OverflowMenuProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.OverflowMenuProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ OverflowMenuProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OverflowMenuProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.action_id;
            r0.e = this.options;
            r0.f = this.confirm;
            r0.g = this.disable;
            r0.h = this.is_loading;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(OverflowMenuProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final ButtonConfirmProperty getConfirm() {
            return this.confirm;
        }

        public final Boolean getDisable() {
            return this.disable;
        }

        public final List<MenuOption> getOptions() {
            return this.options;
        }

        public final Boolean is_loading() {
            return this.is_loading;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public OverflowMenuProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.action_id = r2.d;
            this.options = com.lark.wire.internal.a.c("options", r2.e);
            this.confirm = r2.f;
            this.disable = r2.g;
            this.is_loading = r2.h;
        }

        public /* synthetic */ OverflowMenuProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ParagraphProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ParagraphProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ParagraphProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ParagraphProperty extends com.lark.wire.Message<ParagraphProperty, a> {
        public static final ProtoAdapter<ParagraphProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<ParagraphProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ParagraphProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ParagraphProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ParagraphProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new ParagraphProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ParagraphProperty r2) {
                ParagraphProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, ParagraphProperty r3) {
                ParagraphProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, ParagraphProperty r3) {
                ParagraphProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<ParagraphProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ParagraphProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ParagraphProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ParagraphProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ParagraphProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ParagraphProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ ParagraphProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010 \u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001e¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ProgressSelectOptionProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ProgressSelectOptionProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ProgressSelectOptionProperty$Builder;Lokio/ByteString;)V", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "action_param_name", "getAction_param_name", "action_param_value", "getAction_param_value", "disable", "", "getDisable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "selected", "getSelected", "option_case", "getOption_case", "content", "getContent", "number_of_selected", "", "getNumber_of_selected", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "number_of_total", "getNumber_of_total", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ProgressSelectOptionProperty extends com.lark.wire.Message<ProgressSelectOptionProperty, a> {
        public static final ProtoAdapter<ProgressSelectOptionProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_DISABLE = false;
        public static final boolean DEFAULT_SELECTED = false;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final String action_param_name;
        private final String action_param_value;
        private final String content;
        private final Boolean disable;
        private final Integer number_of_selected;
        private final Integer number_of_total;
        private final String option_case;
        private final Boolean selected;

        public static final class a extends com.lark.wire.Message.a<ProgressSelectOptionProperty, a> {
            public String d;
            public String e;
            public String f;
            public Boolean g;
            public Boolean h;
            public String i;
            public String j;
            public Integer k;
            public Integer l;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ProgressSelectOptionProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ProgressSelectOptionProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ProgressSelectOptionProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L17;
                switch(r4) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    case 6: goto L10;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L7:
                r1.l = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L8:
                r1.k = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.j = r7.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.i = r7.i();
                goto L3
            L11:
                r1.h = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L12:
                r1.g = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L14:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L15:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L17:
                return new ProgressSelectOptionProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ProgressSelectOptionProperty r6) {
                ProgressSelectOptionProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = ((r0 + r1.l(1, r7.getAction_id())) + r1.l(2, r7.getAction_param_name())) + r1.l(3, r7.getAction_param_value());
                l r3 = ProtoAdapter.g;
                int r4 = (((r2 + r3.l(4, r7.getDisable())) + r3.l(5, r7.getSelected())) + r1.l(6, r7.getOption_case())) + r1.l(7, r7.getContent());
                s r5 = ProtoAdapter.h;
                return (r4 + r5.l(8, r7.getNumber_of_selected())) + r5.l(9, r7.getNumber_of_total());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ProgressSelectOptionProperty r6) {
                ProgressSelectOptionProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getAction_id());
                r0.i(r5, 2, r7.getAction_param_name());
                r0.i(r5, 3, r7.getAction_param_value());
                l r1 = ProtoAdapter.g;
                r1.i(r5, 4, r7.getDisable());
                r1.i(r5, 5, r7.getSelected());
                r0.i(r5, 6, r7.getOption_case());
                r0.i(r5, 7, r7.getContent());
                s r2 = ProtoAdapter.h;
                r2.i(r5, 8, r7.getNumber_of_selected());
                r2.i(r5, 9, r7.getNumber_of_total());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ProgressSelectOptionProperty r6) {
                ProgressSelectOptionProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                s r0 = ProtoAdapter.h;
                r0.j(r5, 9, r7.getNumber_of_total());
                r0.j(r5, 8, r7.getNumber_of_selected());
                w r1 = ProtoAdapter.q;
                r1.j(r5, 7, r7.getContent());
                r1.j(r5, 6, r7.getOption_case());
                l r2 = ProtoAdapter.g;
                r2.j(r5, 5, r7.getSelected());
                r2.j(r5, 4, r7.getDisable());
                r1.j(r5, 3, r7.getAction_param_value());
                r1.j(r5, 2, r7.getAction_param_name());
                r1.j(r5, 1, r7.getAction_id());
            }

            public b(FieldEncoding r7, KClass<ProgressSelectOptionProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ProgressSelectOptionProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ProgressSelectOptionProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ProgressSelectOptionProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.action_id;
            r0.e = this.action_param_name;
            r0.f = this.action_param_value;
            r0.g = this.disable;
            r0.h = this.selected;
            r0.i = this.option_case;
            r0.j = this.content;
            r0.k = this.number_of_selected;
            r0.l = this.number_of_total;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ProgressSelectOptionProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final String getAction_param_name() {
            return this.action_param_name;
        }

        public final String getAction_param_value() {
            return this.action_param_value;
        }

        public final String getContent() {
            return this.content;
        }

        public final Boolean getDisable() {
            return this.disable;
        }

        public final Integer getNumber_of_selected() {
            return this.number_of_selected;
        }

        public final Integer getNumber_of_total() {
            return this.number_of_total;
        }

        public final String getOption_case() {
            return this.option_case;
        }

        public final Boolean getSelected() {
            return this.selected;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ProgressSelectOptionProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.action_id = r2.d;
            this.action_param_name = r2.e;
            this.action_param_value = r2.f;
            this.disable = r2.g;
            this.selected = r2.h;
            this.option_case = r2.i;
            this.content = r2.j;
            this.number_of_selected = r2.k;
            this.number_of_total = r2.l;
        }

        public /* synthetic */ ProgressSelectOptionProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000°\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 Ô\u00012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004Ó\u0001Ô\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010Ð\u0001\u001a\u00020\u0002H\u0016J\n\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u00010=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010@\u001a\u0004\u0018\u00010A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010D\u001a\u0004\u0018\u00010E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u0004\u0018\u00010I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010L\u001a\u0004\u0018\u00010M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010P\u001a\u0004\u0018\u00010Q¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010T\u001a\u0004\u0018\u00010U¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0013\u0010X\u001a\u0004\u0018\u00010Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0013\u0010\\\u001a\u0004\u0018\u00010]¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0013\u0010`\u001a\u0004\u0018\u00010a¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0013\u0010d\u001a\u0004\u0018\u00010e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0013\u0010h\u001a\u0004\u0018\u00010i¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0013\u0010l\u001a\u0004\u0018\u00010m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0013\u0010p\u001a\u0004\u0018\u00010q¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0013\u0010t\u001a\u0004\u0018\u00010u¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0013\u0010x\u001a\u0004\u0018\u00010y¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0013\u0010|\u001a\u0004\u0018\u00010}¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0017\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0017\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0017\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0017\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0017\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0017\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001¢\u0006\n\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001R\u0017\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001¢\u0006\n\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001R\u0017\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001R\u0017\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001R\u0017\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001¢\u0006\n\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001R\u0017\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001¢\u0006\n\n\u0000\u001a\u0006\bº\u0001\u0010»\u0001R\u0017\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0017\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0017\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0017\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001¨\u0006Õ\u0001"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$PropertySet;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$PropertySet$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$PropertySet$Builder;Lokio/ByteString;)V", "paragraph", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ParagraphProperty;", "getParagraph", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ParagraphProperty;", "figure", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$FigureProperty;", "getFigure", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$FigureProperty;", "text", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextProperty;", "getText", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextProperty;", "italic", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ItalicProperty;", "getItalic", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ItalicProperty;", "bold", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$BoldProperty;", "getBold", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$BoldProperty;", "underline", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnderlineProperty;", "getUnderline", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnderlineProperty;", "anchor", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AnchorProperty;", "getAnchor", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$AnchorProperty;", "at", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "getAt", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "image", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty;", "emotion", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$EmotionProperty;", "getEmotion", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$EmotionProperty;", "button", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonProperty;", "getButton", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonProperty;", "select", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectProperty;", "getSelect", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectProperty;", "progress", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ProgressSelectOptionProperty;", "getProgress", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ProgressSelectOptionProperty;", "div", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$DivProperty;", "getDiv", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$DivProperty;", "textable_area", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextableAreaProperty;", "getTextable_area", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextableAreaProperty;", "time", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimeProperty;", "getTime", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimeProperty;", "link", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$LinkProperty;", "getLink", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$LinkProperty;", "media", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MediaProperty;", "getMedia", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MediaProperty;", "select_menu", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectMenuProperty;", "getSelect_menu", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectMenuProperty;", "overflow_menu", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$OverflowMenuProperty;", "getOverflow_menu", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$OverflowMenuProperty;", "date_picker", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatePickerProperty;", "getDate_picker", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatePickerProperty;", "docs", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$DocsProperty;", "getDocs", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$DocsProperty;", "h1", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H1Property;", "getH1", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$H1Property;", "h2", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H2Property;", "getH2", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$H2Property;", "h3", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H3Property;", "getH3", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$H3Property;", "ul", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ULProperty;", "getUl", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ULProperty;", "ol", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$OLProperty;", "getOl", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$OLProperty;", "li", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$LIProperty;", "getLi", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$LIProperty;", "quote", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$QuoteProperty;", "getQuote", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$QuoteProperty;", "code", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeProperty;", "getCode", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeProperty;", "code_block", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty;", "getCode_block", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockProperty;", "hr", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$HRProperty;", "getHr", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$HRProperty;", "time_picker", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimePickerProperty;", "getTime_picker", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimePickerProperty;", "datetime_picker", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatetimePickerProperty;", "getDatetime_picker", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$DatetimePickerProperty;", "reaction", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ReactionProperty;", "getReaction", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ReactionProperty;", "mention", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionProperty;", "getMention", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MentionProperty;", "code_block_v2", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property;", "getCode_block_v2", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$CodeBlockV2Property;", "my_ai_tool", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty;", "getMy_ai_tool", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MyAIToolProperty;", "h4", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H4Property;", "getH4", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$H4Property;", "h5", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H5Property;", "getH5", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$H5Property;", "h6", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$H6Property;", "getH6", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$H6Property;", "table", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty;", "getTable", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty;", "table_row", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableRowProperty;", "getTable_row", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableRowProperty;", "table_cell", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableCellProperty;", "getTable_cell", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableCellProperty;", "columns", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnsProperty;", "getColumns", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnsProperty;", "column", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnProperty;", "getColumn", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ColumnProperty;", "at_user_group", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtUserGroupProperty;", "getAt_user_group", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtUserGroupProperty;", "image_gallery", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageGalleryProperty;", "getImage_gallery", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageGalleryProperty;", "markdown", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MarkdownProperty;", "getMarkdown", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$MarkdownProperty;", "unknown", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnknownProperty;", "getUnknown", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnknownProperty;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PropertySet extends com.lark.wire.Message<PropertySet, a> {
        public static final ProtoAdapter<PropertySet> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final AnchorProperty anchor;
        private final AtProperty at;
        private final AtUserGroupProperty at_user_group;
        private final BoldProperty bold;
        private final ButtonProperty button;
        private final CodeProperty code;
        private final CodeBlockProperty code_block;
        private final CodeBlockV2Property code_block_v2;
        private final ColumnProperty column;
        private final ColumnsProperty columns;
        private final DatePickerProperty date_picker;
        private final DatetimePickerProperty datetime_picker;
        private final DivProperty div;
        private final DocsProperty docs;
        private final EmotionProperty emotion;
        private final FigureProperty figure;
        private final H1Property h1;
        private final H2Property h2;
        private final H3Property h3;
        private final H4Property h4;
        private final H5Property h5;
        private final H6Property h6;
        private final HRProperty hr;
        private final ImageProperty image;
        private final ImageGalleryProperty image_gallery;
        private final ItalicProperty italic;
        private final LIProperty li;
        private final LinkProperty link;
        private final MarkdownProperty markdown;
        private final MediaProperty media;
        private final MentionProperty mention;
        private final MyAIToolProperty my_ai_tool;
        private final OLProperty ol;
        private final OverflowMenuProperty overflow_menu;
        private final ParagraphProperty paragraph;
        private final ProgressSelectOptionProperty progress;
        private final QuoteProperty quote;
        private final ReactionProperty reaction;
        private final SelectProperty select;
        private final SelectMenuProperty select_menu;
        private final TableProperty table;
        private final TableCellProperty table_cell;
        private final TableRowProperty table_row;
        private final TextProperty text;
        private final TextableAreaProperty textable_area;
        private final TimeProperty time;
        private final TimePickerProperty time_picker;
        private final ULProperty ul;
        private final UnderlineProperty underline;
        private final UnknownProperty unknown;

        public static final class a extends com.lark.wire.Message.a<PropertySet, a> {
            public H2Property A;
            public H3Property B;
            public ULProperty C;
            public OLProperty D;
            public LIProperty E;
            public QuoteProperty F;
            public CodeProperty G;
            public CodeBlockProperty H;
            public HRProperty I;
            public TimePickerProperty J;
            public DatetimePickerProperty K;
            public ReactionProperty L;
            public MentionProperty M;
            public CodeBlockV2Property N;
            public MyAIToolProperty O;
            public H4Property P;
            public H5Property Q;
            public H6Property R;
            public TableProperty S;
            public TableRowProperty T;
            public TableCellProperty U;
            public ColumnsProperty V;
            public ColumnProperty W;
            public AtUserGroupProperty X;
            public ImageGalleryProperty Y;
            public MarkdownProperty Z;
            public UnknownProperty a0;
            public ParagraphProperty d;
            public FigureProperty e;
            public TextProperty f;
            public ItalicProperty g;
            public BoldProperty h;
            public UnderlineProperty i;
            public AnchorProperty j;
            public AtProperty k;
            public ImageProperty l;
            public EmotionProperty m;
            public ButtonProperty n;
            public SelectProperty o;
            public ProgressSelectOptionProperty p;
            public DivProperty q;
            public TextableAreaProperty r;
            public TimeProperty s;
            public LinkProperty t;
            public MediaProperty u;
            public SelectMenuProperty v;
            public OverflowMenuProperty w;
            public DatePickerProperty x;
            public DocsProperty y;
            public H1Property z;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PropertySet(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PropertySet> {
            @Override // com.lark.wire.ProtoAdapter
            public final PropertySet c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L60;
                if (r3 != 404) goto L7;
                r0.a0 = UnknownProperty.ADAPTER.c(r6);
                goto L3
            L7:
                switch(r3) {
                    case 1: goto L57;
                    case 2: goto L56;
                    case 3: goto L55;
                    case 4: goto L54;
                    case 5: goto L53;
                    case 6: goto L52;
                    case 7: goto L51;
                    case 8: goto L50;
                    case 9: goto L49;
                    case 10: goto L48;
                    case 11: goto L47;
                    case 12: goto L46;
                    case 13: goto L45;
                    case 14: goto L44;
                    case 15: goto L43;
                    case 16: goto L42;
                    case 17: goto L41;
                    case 18: goto L40;
                    case 19: goto L39;
                    case 20: goto L38;
                    case 21: goto L37;
                    case 22: goto L36;
                    case 23: goto L35;
                    case 24: goto L34;
                    case 25: goto L33;
                    case 26: goto L32;
                    case 27: goto L31;
                    case 28: goto L30;
                    case 29: goto L29;
                    case 30: goto L28;
                    case 31: goto L27;
                    case 32: goto L26;
                    case 33: goto L25;
                    case 34: goto L24;
                    case 35: goto L23;
                    case 36: goto L22;
                    case 37: goto L21;
                    case 38: goto L20;
                    case 39: goto L19;
                    case 40: goto L18;
                    case 41: goto L17;
                    case 42: goto L16;
                    case 43: goto L15;
                    case 44: goto L14;
                    case 45: goto L13;
                    case 46: goto L12;
                    case 47: goto L11;
                    case 48: goto L10;
                    case 49: goto L9;
                    default: goto L8;
                };
            L9:
                r0.Z = MarkdownProperty.ADAPTER.c(r6);
                goto L3
            L10:
                r0.Y = ImageGalleryProperty.ADAPTER.c(r6);
                goto L3
            L11:
                r0.X = AtUserGroupProperty.ADAPTER.c(r6);
                goto L3
            L12:
                r0.W = ColumnProperty.ADAPTER.c(r6);
                goto L3
            L13:
                r0.V = ColumnsProperty.ADAPTER.c(r6);
                goto L3
            L14:
                r0.U = TableCellProperty.ADAPTER.c(r6);
                goto L3
            L15:
                r0.T = TableRowProperty.ADAPTER.c(r6);
                goto L3
            L16:
                r0.S = TableProperty.ADAPTER.c(r6);
                goto L3
            L17:
                r0.R = H6Property.ADAPTER.c(r6);
                goto L3
            L18:
                r0.Q = H5Property.ADAPTER.c(r6);
                goto L3
            L19:
                r0.P = H4Property.ADAPTER.c(r6);
                goto L3
            L20:
                r0.O = MyAIToolProperty.ADAPTER.c(r6);
                goto L3
            L21:
                r0.N = CodeBlockV2Property.ADAPTER.c(r6);
                goto L3
            L22:
                r0.M = MentionProperty.ADAPTER.c(r6);
                goto L3
            L23:
                r0.L = ReactionProperty.ADAPTER.c(r6);
                goto L3
            L24:
                r0.K = DatetimePickerProperty.ADAPTER.c(r6);
                goto L3
            L25:
                r0.J = TimePickerProperty.ADAPTER.c(r6);
                goto L3
            L26:
                r0.I = HRProperty.ADAPTER.c(r6);
                goto L3
            L27:
                r0.H = CodeBlockProperty.ADAPTER.c(r6);
                goto L3
            L28:
                r0.G = CodeProperty.ADAPTER.c(r6);
                goto L3
            L29:
                r0.F = QuoteProperty.ADAPTER.c(r6);
                goto L3
            L30:
                r0.E = LIProperty.ADAPTER.c(r6);
                goto L3
            L31:
                r0.D = OLProperty.ADAPTER.c(r6);
                goto L3
            L32:
                r0.C = ULProperty.ADAPTER.c(r6);
                goto L3
            L33:
                r0.B = H3Property.ADAPTER.c(r6);
                goto L3
            L34:
                r0.A = H2Property.ADAPTER.c(r6);
                goto L3
            L35:
                r0.z = H1Property.ADAPTER.c(r6);
                goto L3
            L36:
                r0.y = DocsProperty.ADAPTER.c(r6);
                goto L3
            L37:
                r0.x = DatePickerProperty.ADAPTER.c(r6);
                goto L3
            L38:
                r0.w = OverflowMenuProperty.ADAPTER.c(r6);
                goto L3
            L39:
                r0.v = SelectMenuProperty.ADAPTER.c(r6);
                goto L3
            L40:
                r0.u = MediaProperty.ADAPTER.c(r6);
                goto L3
            L41:
                r0.t = LinkProperty.ADAPTER.c(r6);
                goto L3
            L42:
                r0.s = TimeProperty.ADAPTER.c(r6);
                goto L3
            L43:
                r0.r = TextableAreaProperty.ADAPTER.c(r6);
                goto L3
            L44:
                r0.q = DivProperty.ADAPTER.c(r6);
                goto L3
            L45:
                r0.p = ProgressSelectOptionProperty.ADAPTER.c(r6);
                goto L3
            L46:
                r0.o = SelectProperty.ADAPTER.c(r6);
                goto L3
            L47:
                r0.n = ButtonProperty.ADAPTER.c(r6);
                goto L3
            L48:
                r0.m = EmotionProperty.ADAPTER.c(r6);
                goto L3
            L49:
                r0.l = ImageProperty.ADAPTER.c(r6);
                goto L3
            L50:
                r0.k = AtProperty.ADAPTER.c(r6);
                goto L3
            L51:
                r0.j = AnchorProperty.ADAPTER.c(r6);
                goto L3
            L52:
                r0.i = UnderlineProperty.ADAPTER.c(r6);
                goto L3
            L53:
                r0.h = BoldProperty.ADAPTER.c(r6);
                goto L3
            L54:
                r0.g = ItalicProperty.ADAPTER.c(r6);
                goto L3
            L55:
                r0.f = TextProperty.ADAPTER.c(r6);
                goto L3
            L56:
                r0.e = FigureProperty.ADAPTER.c(r6);
                goto L3
            L57:
                r0.d = ParagraphProperty.ADAPTER.c(r6);
                goto L3
            L8:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L60:
                return new PropertySet(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PropertySet r5) {
                PropertySet r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((((((((((((((((((((((((((((((((((((((((((((((((r6.unknownFields().size() + ParagraphProperty.ADAPTER.l(1, r6.getParagraph())) + FigureProperty.ADAPTER.l(2, r6.getFigure())) + TextProperty.ADAPTER.l(3, r6.getText())) + ItalicProperty.ADAPTER.l(4, r6.getItalic())) + BoldProperty.ADAPTER.l(5, r6.getBold())) + UnderlineProperty.ADAPTER.l(6, r6.getUnderline())) + AnchorProperty.ADAPTER.l(7, r6.getAnchor())) + AtProperty.ADAPTER.l(8, r6.getAt())) + ImageProperty.ADAPTER.l(9, r6.getImage())) + EmotionProperty.ADAPTER.l(10, r6.getEmotion())) + ButtonProperty.ADAPTER.l(11, r6.getButton())) + SelectProperty.ADAPTER.l(12, r6.getSelect())) + ProgressSelectOptionProperty.ADAPTER.l(13, r6.getProgress())) + DivProperty.ADAPTER.l(14, r6.getDiv())) + TextableAreaProperty.ADAPTER.l(15, r6.getTextable_area())) + TimeProperty.ADAPTER.l(16, r6.getTime())) + LinkProperty.ADAPTER.l(17, r6.getLink())) + MediaProperty.ADAPTER.l(18, r6.getMedia())) + SelectMenuProperty.ADAPTER.l(19, r6.getSelect_menu())) + OverflowMenuProperty.ADAPTER.l(20, r6.getOverflow_menu())) + DatePickerProperty.ADAPTER.l(21, r6.getDate_picker())) + DocsProperty.ADAPTER.l(22, r6.getDocs())) + H1Property.ADAPTER.l(23, r6.getH1())) + H2Property.ADAPTER.l(24, r6.getH2())) + H3Property.ADAPTER.l(25, r6.getH3())) + ULProperty.ADAPTER.l(26, r6.getUl())) + OLProperty.ADAPTER.l(27, r6.getOl())) + LIProperty.ADAPTER.l(28, r6.getLi())) + QuoteProperty.ADAPTER.l(29, r6.getQuote())) + CodeProperty.ADAPTER.l(30, r6.getCode())) + CodeBlockProperty.ADAPTER.l(31, r6.getCode_block())) + HRProperty.ADAPTER.l(32, r6.getHr())) + TimePickerProperty.ADAPTER.l(33, r6.getTime_picker())) + DatetimePickerProperty.ADAPTER.l(34, r6.getDatetime_picker())) + ReactionProperty.ADAPTER.l(35, r6.getReaction())) + MentionProperty.ADAPTER.l(36, r6.getMention())) + CodeBlockV2Property.ADAPTER.l(37, r6.getCode_block_v2())) + MyAIToolProperty.ADAPTER.l(38, r6.getMy_ai_tool())) + H4Property.ADAPTER.l(39, r6.getH4())) + H5Property.ADAPTER.l(40, r6.getH5())) + H6Property.ADAPTER.l(41, r6.getH6())) + TableProperty.ADAPTER.l(42, r6.getTable())) + TableRowProperty.ADAPTER.l(43, r6.getTable_row())) + TableCellProperty.ADAPTER.l(44, r6.getTable_cell())) + ColumnsProperty.ADAPTER.l(45, r6.getColumns())) + ColumnProperty.ADAPTER.l(46, r6.getColumn())) + AtUserGroupProperty.ADAPTER.l(47, r6.getAt_user_group())) + ImageGalleryProperty.ADAPTER.l(48, r6.getImage_gallery())) + MarkdownProperty.ADAPTER.l(49, r6.getMarkdown())) + UnknownProperty.ADAPTER.l(404, r6.getUnknown());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, PropertySet r5) {
                PropertySet r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ParagraphProperty.ADAPTER.i(r4, 1, r6.getParagraph());
                FigureProperty.ADAPTER.i(r4, 2, r6.getFigure());
                TextProperty.ADAPTER.i(r4, 3, r6.getText());
                ItalicProperty.ADAPTER.i(r4, 4, r6.getItalic());
                BoldProperty.ADAPTER.i(r4, 5, r6.getBold());
                UnderlineProperty.ADAPTER.i(r4, 6, r6.getUnderline());
                AnchorProperty.ADAPTER.i(r4, 7, r6.getAnchor());
                AtProperty.ADAPTER.i(r4, 8, r6.getAt());
                ImageProperty.ADAPTER.i(r4, 9, r6.getImage());
                EmotionProperty.ADAPTER.i(r4, 10, r6.getEmotion());
                ButtonProperty.ADAPTER.i(r4, 11, r6.getButton());
                SelectProperty.ADAPTER.i(r4, 12, r6.getSelect());
                ProgressSelectOptionProperty.ADAPTER.i(r4, 13, r6.getProgress());
                DivProperty.ADAPTER.i(r4, 14, r6.getDiv());
                TextableAreaProperty.ADAPTER.i(r4, 15, r6.getTextable_area());
                TimeProperty.ADAPTER.i(r4, 16, r6.getTime());
                LinkProperty.ADAPTER.i(r4, 17, r6.getLink());
                MediaProperty.ADAPTER.i(r4, 18, r6.getMedia());
                SelectMenuProperty.ADAPTER.i(r4, 19, r6.getSelect_menu());
                OverflowMenuProperty.ADAPTER.i(r4, 20, r6.getOverflow_menu());
                DatePickerProperty.ADAPTER.i(r4, 21, r6.getDate_picker());
                DocsProperty.ADAPTER.i(r4, 22, r6.getDocs());
                H1Property.ADAPTER.i(r4, 23, r6.getH1());
                H2Property.ADAPTER.i(r4, 24, r6.getH2());
                H3Property.ADAPTER.i(r4, 25, r6.getH3());
                ULProperty.ADAPTER.i(r4, 26, r6.getUl());
                OLProperty.ADAPTER.i(r4, 27, r6.getOl());
                LIProperty.ADAPTER.i(r4, 28, r6.getLi());
                QuoteProperty.ADAPTER.i(r4, 29, r6.getQuote());
                CodeProperty.ADAPTER.i(r4, 30, r6.getCode());
                CodeBlockProperty.ADAPTER.i(r4, 31, r6.getCode_block());
                HRProperty.ADAPTER.i(r4, 32, r6.getHr());
                TimePickerProperty.ADAPTER.i(r4, 33, r6.getTime_picker());
                DatetimePickerProperty.ADAPTER.i(r4, 34, r6.getDatetime_picker());
                ReactionProperty.ADAPTER.i(r4, 35, r6.getReaction());
                MentionProperty.ADAPTER.i(r4, 36, r6.getMention());
                CodeBlockV2Property.ADAPTER.i(r4, 37, r6.getCode_block_v2());
                MyAIToolProperty.ADAPTER.i(r4, 38, r6.getMy_ai_tool());
                H4Property.ADAPTER.i(r4, 39, r6.getH4());
                H5Property.ADAPTER.i(r4, 40, r6.getH5());
                H6Property.ADAPTER.i(r4, 41, r6.getH6());
                TableProperty.ADAPTER.i(r4, 42, r6.getTable());
                TableRowProperty.ADAPTER.i(r4, 43, r6.getTable_row());
                TableCellProperty.ADAPTER.i(r4, 44, r6.getTable_cell());
                ColumnsProperty.ADAPTER.i(r4, 45, r6.getColumns());
                ColumnProperty.ADAPTER.i(r4, 46, r6.getColumn());
                AtUserGroupProperty.ADAPTER.i(r4, 47, r6.getAt_user_group());
                ImageGalleryProperty.ADAPTER.i(r4, 48, r6.getImage_gallery());
                MarkdownProperty.ADAPTER.i(r4, 49, r6.getMarkdown());
                UnknownProperty.ADAPTER.i(r4, 404, r6.getUnknown());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, PropertySet r5) {
                PropertySet r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                UnknownProperty.ADAPTER.j(r4, 404, r6.getUnknown());
                MarkdownProperty.ADAPTER.j(r4, 49, r6.getMarkdown());
                ImageGalleryProperty.ADAPTER.j(r4, 48, r6.getImage_gallery());
                AtUserGroupProperty.ADAPTER.j(r4, 47, r6.getAt_user_group());
                ColumnProperty.ADAPTER.j(r4, 46, r6.getColumn());
                ColumnsProperty.ADAPTER.j(r4, 45, r6.getColumns());
                TableCellProperty.ADAPTER.j(r4, 44, r6.getTable_cell());
                TableRowProperty.ADAPTER.j(r4, 43, r6.getTable_row());
                TableProperty.ADAPTER.j(r4, 42, r6.getTable());
                H6Property.ADAPTER.j(r4, 41, r6.getH6());
                H5Property.ADAPTER.j(r4, 40, r6.getH5());
                H4Property.ADAPTER.j(r4, 39, r6.getH4());
                MyAIToolProperty.ADAPTER.j(r4, 38, r6.getMy_ai_tool());
                CodeBlockV2Property.ADAPTER.j(r4, 37, r6.getCode_block_v2());
                MentionProperty.ADAPTER.j(r4, 36, r6.getMention());
                ReactionProperty.ADAPTER.j(r4, 35, r6.getReaction());
                DatetimePickerProperty.ADAPTER.j(r4, 34, r6.getDatetime_picker());
                TimePickerProperty.ADAPTER.j(r4, 33, r6.getTime_picker());
                HRProperty.ADAPTER.j(r4, 32, r6.getHr());
                CodeBlockProperty.ADAPTER.j(r4, 31, r6.getCode_block());
                CodeProperty.ADAPTER.j(r4, 30, r6.getCode());
                QuoteProperty.ADAPTER.j(r4, 29, r6.getQuote());
                LIProperty.ADAPTER.j(r4, 28, r6.getLi());
                OLProperty.ADAPTER.j(r4, 27, r6.getOl());
                ULProperty.ADAPTER.j(r4, 26, r6.getUl());
                H3Property.ADAPTER.j(r4, 25, r6.getH3());
                H2Property.ADAPTER.j(r4, 24, r6.getH2());
                H1Property.ADAPTER.j(r4, 23, r6.getH1());
                DocsProperty.ADAPTER.j(r4, 22, r6.getDocs());
                DatePickerProperty.ADAPTER.j(r4, 21, r6.getDate_picker());
                OverflowMenuProperty.ADAPTER.j(r4, 20, r6.getOverflow_menu());
                SelectMenuProperty.ADAPTER.j(r4, 19, r6.getSelect_menu());
                MediaProperty.ADAPTER.j(r4, 18, r6.getMedia());
                LinkProperty.ADAPTER.j(r4, 17, r6.getLink());
                TimeProperty.ADAPTER.j(r4, 16, r6.getTime());
                TextableAreaProperty.ADAPTER.j(r4, 15, r6.getTextable_area());
                DivProperty.ADAPTER.j(r4, 14, r6.getDiv());
                ProgressSelectOptionProperty.ADAPTER.j(r4, 13, r6.getProgress());
                SelectProperty.ADAPTER.j(r4, 12, r6.getSelect());
                ButtonProperty.ADAPTER.j(r4, 11, r6.getButton());
                EmotionProperty.ADAPTER.j(r4, 10, r6.getEmotion());
                ImageProperty.ADAPTER.j(r4, 9, r6.getImage());
                AtProperty.ADAPTER.j(r4, 8, r6.getAt());
                AnchorProperty.ADAPTER.j(r4, 7, r6.getAnchor());
                UnderlineProperty.ADAPTER.j(r4, 6, r6.getUnderline());
                BoldProperty.ADAPTER.j(r4, 5, r6.getBold());
                ItalicProperty.ADAPTER.j(r4, 4, r6.getItalic());
                TextProperty.ADAPTER.j(r4, 3, r6.getText());
                FigureProperty.ADAPTER.j(r4, 2, r6.getFigure());
                ParagraphProperty.ADAPTER.j(r4, 1, r6.getParagraph());
            }

            public b(FieldEncoding r7, KClass<PropertySet> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.PropertySet", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PropertySet(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PropertySet.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.paragraph;
            r0.e = this.figure;
            r0.f = this.text;
            r0.g = this.italic;
            r0.h = this.bold;
            r0.i = this.underline;
            r0.j = this.anchor;
            r0.k = this.at;
            r0.l = this.image;
            r0.m = this.emotion;
            r0.n = this.button;
            r0.o = this.select;
            r0.p = this.progress;
            r0.q = this.div;
            r0.r = this.textable_area;
            r0.s = this.time;
            r0.t = this.link;
            r0.u = this.media;
            r0.v = this.select_menu;
            r0.w = this.overflow_menu;
            r0.x = this.date_picker;
            r0.y = this.docs;
            r0.z = this.h1;
            r0.A = this.h2;
            r0.B = this.h3;
            r0.C = this.ul;
            r0.D = this.ol;
            r0.E = this.li;
            r0.F = this.quote;
            r0.G = this.code;
            r0.H = this.code_block;
            r0.I = this.hr;
            r0.J = this.time_picker;
            r0.K = this.datetime_picker;
            r0.L = this.reaction;
            r0.M = this.mention;
            r0.N = this.code_block_v2;
            r0.O = this.my_ai_tool;
            r0.P = this.h4;
            r0.Q = this.h5;
            r0.R = this.h6;
            r0.S = this.table;
            r0.T = this.table_row;
            r0.U = this.table_cell;
            r0.V = this.columns;
            r0.W = this.column;
            r0.X = this.at_user_group;
            r0.Y = this.image_gallery;
            r0.Z = this.markdown;
            r0.a0 = this.unknown;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PropertySet.class).getSimpleName() + '@' + hashCode();
        }

        public final AnchorProperty getAnchor() {
            return this.anchor;
        }

        public final AtProperty getAt() {
            return this.at;
        }

        public final AtUserGroupProperty getAt_user_group() {
            return this.at_user_group;
        }

        public final BoldProperty getBold() {
            return this.bold;
        }

        public final ButtonProperty getButton() {
            return this.button;
        }

        public final CodeProperty getCode() {
            return this.code;
        }

        public final CodeBlockProperty getCode_block() {
            return this.code_block;
        }

        public final CodeBlockV2Property getCode_block_v2() {
            return this.code_block_v2;
        }

        public final ColumnProperty getColumn() {
            return this.column;
        }

        public final ColumnsProperty getColumns() {
            return this.columns;
        }

        public final DatePickerProperty getDate_picker() {
            return this.date_picker;
        }

        public final DatetimePickerProperty getDatetime_picker() {
            return this.datetime_picker;
        }

        public final DivProperty getDiv() {
            return this.div;
        }

        public final DocsProperty getDocs() {
            return this.docs;
        }

        public final EmotionProperty getEmotion() {
            return this.emotion;
        }

        public final FigureProperty getFigure() {
            return this.figure;
        }

        public final H1Property getH1() {
            return this.h1;
        }

        public final H2Property getH2() {
            return this.h2;
        }

        public final H3Property getH3() {
            return this.h3;
        }

        public final H4Property getH4() {
            return this.h4;
        }

        public final H5Property getH5() {
            return this.h5;
        }

        public final H6Property getH6() {
            return this.h6;
        }

        public final HRProperty getHr() {
            return this.hr;
        }

        public final ImageProperty getImage() {
            return this.image;
        }

        public final ImageGalleryProperty getImage_gallery() {
            return this.image_gallery;
        }

        public final ItalicProperty getItalic() {
            return this.italic;
        }

        public final LIProperty getLi() {
            return this.li;
        }

        public final LinkProperty getLink() {
            return this.link;
        }

        public final MarkdownProperty getMarkdown() {
            return this.markdown;
        }

        public final MediaProperty getMedia() {
            return this.media;
        }

        public final MentionProperty getMention() {
            return this.mention;
        }

        public final MyAIToolProperty getMy_ai_tool() {
            return this.my_ai_tool;
        }

        public final OLProperty getOl() {
            return this.ol;
        }

        public final OverflowMenuProperty getOverflow_menu() {
            return this.overflow_menu;
        }

        public final ParagraphProperty getParagraph() {
            return this.paragraph;
        }

        public final ProgressSelectOptionProperty getProgress() {
            return this.progress;
        }

        public final QuoteProperty getQuote() {
            return this.quote;
        }

        public final ReactionProperty getReaction() {
            return this.reaction;
        }

        public final SelectProperty getSelect() {
            return this.select;
        }

        public final SelectMenuProperty getSelect_menu() {
            return this.select_menu;
        }

        public final TableProperty getTable() {
            return this.table;
        }

        public final TableCellProperty getTable_cell() {
            return this.table_cell;
        }

        public final TableRowProperty getTable_row() {
            return this.table_row;
        }

        public final TextProperty getText() {
            return this.text;
        }

        public final TextableAreaProperty getTextable_area() {
            return this.textable_area;
        }

        public final TimeProperty getTime() {
            return this.time;
        }

        public final TimePickerProperty getTime_picker() {
            return this.time_picker;
        }

        public final ULProperty getUl() {
            return this.ul;
        }

        public final UnderlineProperty getUnderline() {
            return this.underline;
        }

        public final UnknownProperty getUnknown() {
            return this.unknown;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PropertySet(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.paragraph = r2.d;
            this.figure = r2.e;
            this.text = r2.f;
            this.italic = r2.g;
            this.bold = r2.h;
            this.underline = r2.i;
            this.anchor = r2.j;
            this.at = r2.k;
            this.image = r2.l;
            this.emotion = r2.m;
            this.button = r2.n;
            this.select = r2.o;
            this.progress = r2.p;
            this.div = r2.q;
            this.textable_area = r2.r;
            this.time = r2.s;
            this.link = r2.t;
            this.media = r2.u;
            this.select_menu = r2.v;
            this.overflow_menu = r2.w;
            this.date_picker = r2.x;
            this.docs = r2.y;
            this.h1 = r2.z;
            this.h2 = r2.A;
            this.h3 = r2.B;
            this.ul = r2.C;
            this.ol = r2.D;
            this.li = r2.E;
            this.quote = r2.F;
            this.code = r2.G;
            this.code_block = r2.H;
            this.hr = r2.I;
            this.time_picker = r2.J;
            this.datetime_picker = r2.K;
            this.reaction = r2.L;
            this.mention = r2.M;
            this.code_block_v2 = r2.N;
            this.my_ai_tool = r2.O;
            this.h4 = r2.P;
            this.h5 = r2.Q;
            this.h6 = r2.R;
            this.table = r2.S;
            this.table_row = r2.T;
            this.table_cell = r2.U;
            this.columns = r2.V;
            this.column = r2.W;
            this.at_user_group = r2.X;
            this.image_gallery = r2.Y;
            this.markdown = r2.Z;
            this.unknown = r2.a0;
        }

        public /* synthetic */ PropertySet(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$QuoteProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$QuoteProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$QuoteProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class QuoteProperty extends com.lark.wire.Message<QuoteProperty, a> {
        public static final ProtoAdapter<QuoteProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<QuoteProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new QuoteProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<QuoteProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final QuoteProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new QuoteProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(QuoteProperty r2) {
                QuoteProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, QuoteProperty r3) {
                QuoteProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, QuoteProperty r3) {
                QuoteProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<QuoteProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.QuoteProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ QuoteProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(QuoteProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(QuoteProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public QuoteProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ QuoteProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ReactionProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ReactionProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ReactionProperty$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ReactionProperty extends com.lark.wire.Message<ReactionProperty, a> {
        public static final ProtoAdapter<ReactionProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String key;

        public static final class a extends com.lark.wire.Message.a<ReactionProperty, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ReactionProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ReactionProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ReactionProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L10;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "key");
                r1.d = r5;
                goto L3
            L10:
                return new ReactionProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ReactionProperty r4) {
                ReactionProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getKey());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ReactionProperty r5) {
                ReactionProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getKey());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, ReactionProperty r4) {
                ReactionProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getKey());
            }

            public b(FieldEncoding r7, KClass<ReactionProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ReactionProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ReactionProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ReactionProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ReactionProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getKey() {
            return this.key;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ReactionProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.key = r4;
        }

        public /* synthetic */ ReactionProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003'()B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010%\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010$\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"¨\u0006*"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectMenuProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectMenuProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectMenuProperty$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectMenuProperty$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectMenuProperty$Type;", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "place_holder", "getPlace_holder", "place_holder_i18n_key", "getPlace_holder_i18n_key", "initial_option", "getInitial_option", "options", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$MenuOption;", "getOptions", "()Ljava/util/List;", "confirm", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "getConfirm", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "disable", "", "getDisable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_loading", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SelectMenuProperty extends com.lark.wire.Message<SelectMenuProperty, a> {
        public static final ProtoAdapter<SelectMenuProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_DISABLE = false;
        public static final boolean DEFAULT_IS_LOADING = false;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final ButtonConfirmProperty confirm;
        private final Boolean disable;
        private final String initial_option;
        private final Boolean is_loading;
        private final List<MenuOption> options;
        private final String place_holder;
        private final String place_holder_i18n_key;
        private final Type type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectMenuProperty$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "STATIC", "PERSON", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final b Companion = null;
            public static final Type PERSON = null;
            public static final Type STATIC = null;
            public static final Type UNKNOWN = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return Type.PERSON;
                L15:
                    return Type.STATIC;
                L12:
                    return Type.UNKNOWN;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Type> getEntries() {
                return b;
            }

            static {
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("STATIC", 1, 1);
                STATIC = r1;
                Type r3 = new Type("PERSON", 2, 2);
                PERSON = r3;
                Type[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
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

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return PERSON;
            L15:
                return STATIC;
            L12:
                return UNKNOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<SelectMenuProperty, a> {
            public Type d;
            public String e;
            public String f;
            public String g;
            public String h;
            public List<MenuOption> i;
            public ButtonConfirmProperty j;
            public Boolean k;
            public Boolean l;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SelectMenuProperty(this, c(), null);
            }

            public a() {
                this.i = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<SelectMenuProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final SelectMenuProperty c(g0 r11) {
                Intrinsics.checkNotNullParameter(r11, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r11.c();
            L3:
                int r5 = r11.e();
                if (r5 == (-1)) goto L19;
                switch(r5) {
                    case 1: goto L21;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    case 6: goto L10;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L21:
                r1.d = Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L7:
                r1.l = (Boolean) ProtoAdapter.g.c(r11);
                goto L3
            L8:
                r1.k = (Boolean) ProtoAdapter.g.c(r11);
                goto L3
            L9:
                r1.j = ButtonConfirmProperty.ADAPTER.c(r11);
                goto L3
            L10:
                r2.add(MenuOption.ADAPTER.c(r11));
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r11, "reader");
                r1.h = r11.i();
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r11, "reader");
                r1.g = r11.i();
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r11, "reader");
                r1.f = r11.i();
                goto L3
            L14:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r11, "reader");
                r1.e = r11.i();
                goto L3
            L6:
                r11.j(r5);
                Unit r7 = Unit.INSTANCE;
                goto L3
            L19:
                ByteString r12 = r11.d(r3);
                Intrinsics.checkNotNullParameter(r2, "options");
                com.lark.wire.internal.a.a(r2);
                r1.i = r2;
                return new SelectMenuProperty(r1, r12, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SelectMenuProperty r5) {
                SelectMenuProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType());
                w r1 = ProtoAdapter.q;
                int r2 = (((((r0 + r1.l(2, r6.getAction_id())) + r1.l(3, r6.getPlace_holder())) + r1.l(4, r6.getPlace_holder_i18n_key())) + r1.l(5, r6.getInitial_option())) + MenuOption.ADAPTER.a().l(6, r6.getOptions())) + ButtonConfirmProperty.ADAPTER.l(7, r6.getConfirm());
                l r3 = ProtoAdapter.g;
                return (r2 + r3.l(8, r6.getDisable())) + r3.l(9, r6.is_loading());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SelectMenuProperty r5) {
                SelectMenuProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Type.ADAPTER.i(r4, 1, r6.getType());
                w r0 = ProtoAdapter.q;
                r0.i(r4, 2, r6.getAction_id());
                r0.i(r4, 3, r6.getPlace_holder());
                r0.i(r4, 4, r6.getPlace_holder_i18n_key());
                r0.i(r4, 5, r6.getInitial_option());
                MenuOption.ADAPTER.a().i(r4, 6, r6.getOptions());
                ButtonConfirmProperty.ADAPTER.i(r4, 7, r6.getConfirm());
                l r1 = ProtoAdapter.g;
                r1.i(r4, 8, r6.getDisable());
                r1.i(r4, 9, r6.is_loading());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SelectMenuProperty r5) {
                SelectMenuProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 9, r6.is_loading());
                r0.j(r4, 8, r6.getDisable());
                ButtonConfirmProperty.ADAPTER.j(r4, 7, r6.getConfirm());
                MenuOption.ADAPTER.a().j(r4, 6, r6.getOptions());
                w r1 = ProtoAdapter.q;
                r1.j(r4, 5, r6.getInitial_option());
                r1.j(r4, 4, r6.getPlace_holder_i18n_key());
                r1.j(r4, 3, r6.getPlace_holder());
                r1.j(r4, 2, r6.getAction_id());
                Type.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<SelectMenuProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.SelectMenuProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SelectMenuProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SelectMenuProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.action_id;
            r0.f = this.place_holder;
            r0.g = this.place_holder_i18n_key;
            r0.h = this.initial_option;
            r0.i = this.options;
            r0.j = this.confirm;
            r0.k = this.disable;
            r0.l = this.is_loading;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SelectMenuProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final ButtonConfirmProperty getConfirm() {
            return this.confirm;
        }

        public final Boolean getDisable() {
            return this.disable;
        }

        public final String getInitial_option() {
            return this.initial_option;
        }

        public final List<MenuOption> getOptions() {
            return this.options;
        }

        public final String getPlace_holder() {
            return this.place_holder;
        }

        public final String getPlace_holder_i18n_key() {
            return this.place_holder_i18n_key;
        }

        public final Type getType() {
            return this.type;
        }

        public final Boolean is_loading() {
            return this.is_loading;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SelectMenuProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.action_id = r2.e;
            this.place_holder = r2.f;
            this.place_holder_i18n_key = r2.g;
            this.initial_option = r2.h;
            this.options = com.lark.wire.internal.a.c("options", r2.i);
            this.confirm = r2.j;
            this.disable = r2.k;
            this.is_loading = r2.l;
        }

        public /* synthetic */ SelectMenuProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$SelectProperty$Builder;Lokio/ByteString;)V", "min_pick_num", "", "getMin_pick_num", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "max_pick_num", "getMax_pick_num", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SelectProperty extends com.lark.wire.Message<SelectProperty, a> {
        public static final ProtoAdapter<SelectProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_MAX_PICK_NUM = 1;
        public static final int DEFAULT_MIN_PICK_NUM = 1;
        private static final long serialVersionUID = 0;
        private final Integer max_pick_num;
        private final Integer min_pick_num;

        public static final class a extends com.lark.wire.Message.a<SelectProperty, a> {
            public Integer d;
            public Integer e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SelectProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<SelectProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final SelectProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 4) goto L8;
                r0.d = (Integer) ProtoAdapter.h.c(r6);
                goto L3
            L8:
                if (r3 != 5) goto L9;
                r0.e = (Integer) ProtoAdapter.h.c(r6);
                goto L3
            L9:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L13:
                return new SelectProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SelectProperty r5) {
                SelectProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                s r1 = ProtoAdapter.h;
                return (r0 + r1.l(4, r6.getMin_pick_num())) + r1.l(5, r6.getMax_pick_num());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SelectProperty r5) {
                SelectProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                s r0 = ProtoAdapter.h;
                r0.i(r4, 4, r6.getMin_pick_num());
                r0.i(r4, 5, r6.getMax_pick_num());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SelectProperty r5) {
                SelectProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                s r0 = ProtoAdapter.h;
                r0.j(r4, 5, r6.getMax_pick_num());
                r0.j(r4, 4, r6.getMin_pick_num());
            }

            public b(FieldEncoding r7, KClass<SelectProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.SelectProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SelectProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SelectProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.min_pick_num;
            r0.e = this.max_pick_num;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SelectProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getMax_pick_num() {
            return this.max_pick_num;
        }

        public final Integer getMin_pick_num() {
            return this.min_pick_num;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SelectProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.min_pick_num = r2.d;
            this.max_pick_num = r2.e;
        }

        public /* synthetic */ SelectProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableCellProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableCellProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableCellProperty$Builder;Lokio/ByteString;)V", "colspan", "", "getColspan", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "rowspan", "getRowspan", "horizontal_align", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$HorizontalAlign;", "getHorizontal_align", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$HorizontalAlign;", "vertical_align", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$VerticalAlign;", "getVertical_align", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$VerticalAlign;", "is_merged", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TableCellProperty extends com.lark.wire.Message<TableCellProperty, a> {
        public static final ProtoAdapter<TableCellProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_COLSPAN = 1;
        public static final int DEFAULT_ROWSPAN = 1;
        private static final long serialVersionUID = 0;
        private final Integer colspan;
        private final HorizontalAlign horizontal_align;
        private final Boolean is_merged;
        private final Integer rowspan;
        private final VerticalAlign vertical_align;

        public static final class a extends com.lark.wire.Message.a<TableCellProperty, a> {
            public Integer d;
            public Integer e;
            public HorizontalAlign f;
            public VerticalAlign g;
            public Boolean h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TableCellProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TableCellProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TableCellProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L28;
                if (r3 != 1) goto L8;
                r0.d = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.f = HorizontalAlign.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.g = VerticalAlign.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.h = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L15:
                r9.j(r3);
                goto L3
            L28:
                return new TableCellProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TableCellProperty r5) {
                TableCellProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                s r1 = ProtoAdapter.h;
                return ((((r0 + r1.l(1, r6.getColspan())) + r1.l(2, r6.getRowspan())) + HorizontalAlign.ADAPTER.l(3, r6.getHorizontal_align())) + VerticalAlign.ADAPTER.l(4, r6.getVertical_align())) + ProtoAdapter.g.l(5, r6.is_merged());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TableCellProperty r5) {
                TableCellProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                s r0 = ProtoAdapter.h;
                r0.i(r4, 1, r6.getColspan());
                r0.i(r4, 2, r6.getRowspan());
                HorizontalAlign.ADAPTER.i(r4, 3, r6.getHorizontal_align());
                VerticalAlign.ADAPTER.i(r4, 4, r6.getVertical_align());
                ProtoAdapter.g.i(r4, 5, r6.is_merged());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TableCellProperty r5) {
                TableCellProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 5, r6.is_merged());
                VerticalAlign.ADAPTER.j(r4, 4, r6.getVertical_align());
                HorizontalAlign.ADAPTER.j(r4, 3, r6.getHorizontal_align());
                s r0 = ProtoAdapter.h;
                r0.j(r4, 2, r6.getRowspan());
                r0.j(r4, 1, r6.getColspan());
            }

            public b(FieldEncoding r7, KClass<TableCellProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.TableCellProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TableCellProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TableCellProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.colspan;
            r0.e = this.rowspan;
            r0.f = this.horizontal_align;
            r0.g = this.vertical_align;
            r0.h = this.is_merged;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TableCellProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getColspan() {
            return this.colspan;
        }

        public final HorizontalAlign getHorizontal_align() {
            return this.horizontal_align;
        }

        public final Integer getRowspan() {
            return this.rowspan;
        }

        public final VerticalAlign getVertical_align() {
            return this.vertical_align;
        }

        public final Boolean is_merged() {
            return this.is_merged;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TableCellProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.colspan = r2.d;
            this.rowspan = r2.e;
            this.horizontal_align = r2.f;
            this.vertical_align = r2.g;
            this.is_merged = r2.h;
        }

        public /* synthetic */ TableCellProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty$Builder;Lokio/ByteString;)V", "columns", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty$Column;", "getColumns", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "Column", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TableProperty extends com.lark.wire.Message<TableProperty, a> {
        public static final ProtoAdapter<TableProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<Column> columns;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty$Column;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty$Column$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableProperty$Column$Builder;Lokio/ByteString;)V", "width", "", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "horizontal_align", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$HorizontalAlign;", "getHorizontal_align", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$HorizontalAlign;", "vertical_align", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$VerticalAlign;", "getVertical_align", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$VerticalAlign;", "is_header", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class Column extends com.lark.wire.Message<Column, a> {
            public static final ProtoAdapter<Column> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final HorizontalAlign horizontal_align;
            private final Boolean is_header;
            private final VerticalAlign vertical_align;
            private final Integer width;

            public static final class a extends com.lark.wire.Message.a<Column, a> {
                public Integer d;
                public HorizontalAlign e;
                public VerticalAlign f;
                public Boolean g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new Column(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<Column> {
                @Override // com.lark.wire.ProtoAdapter
                public final Column c(g0 r9) {
                    Intrinsics.checkNotNullParameter(r9, "reader");
                    a r0 = new a();
                    long r1 = r9.c();
                L3:
                    int r3 = r9.e();
                    if (r3 == (-1)) goto L25;
                    if (r3 != 1) goto L8;
                    r0.d = (Integer) ProtoAdapter.h.c(r9);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.e = HorizontalAlign.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
                L21:
                    e = move-exception;
                    r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r4 = Unit.INSTANCE;
                    goto L3
                L10:
                    if (r3 != 3) goto L12;
                    r0.f = VerticalAlign.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
                L17:
                    e = move-exception;
                    r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L12:
                    if (r3 != 4) goto L13;
                    r0.g = (Boolean) ProtoAdapter.g.c(r9);
                    goto L3
                L13:
                    r9.j(r3);
                    goto L3
                L25:
                    return new Column(r0, r9.d(r1), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(Column r5) {
                    Column r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    return (((r6.unknownFields().size() + ProtoAdapter.h.l(1, r6.getWidth())) + HorizontalAlign.ADAPTER.l(2, r6.getHorizontal_align())) + VerticalAlign.ADAPTER.l(3, r6.getVertical_align())) + ProtoAdapter.g.l(4, r6.is_header());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, Column r5) {
                    Column r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.h.i(r4, 1, r6.getWidth());
                    HorizontalAlign.ADAPTER.i(r4, 2, r6.getHorizontal_align());
                    VerticalAlign.ADAPTER.i(r4, 3, r6.getVertical_align());
                    ProtoAdapter.g.i(r4, 4, r6.is_header());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, Column r5) {
                    Column r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    ProtoAdapter.g.j(r4, 4, r6.is_header());
                    VerticalAlign.ADAPTER.j(r4, 3, r6.getVertical_align());
                    HorizontalAlign.ADAPTER.j(r4, 2, r6.getHorizontal_align());
                    ProtoAdapter.h.j(r4, 1, r6.getWidth());
                }

                public b(FieldEncoding r7, KClass<Column> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.TableProperty.Column", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ Column(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Column.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.width;
                r0.e = this.horizontal_align;
                r0.f = this.vertical_align;
                r0.g = this.is_header;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(Column.class).getSimpleName() + '@' + hashCode();
            }

            public final HorizontalAlign getHorizontal_align() {
                return this.horizontal_align;
            }

            public final VerticalAlign getVertical_align() {
                return this.vertical_align;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public final Boolean is_header() {
                return this.is_header;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public Column(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.width = r2.d;
                this.horizontal_align = r2.e;
                this.vertical_align = r2.f;
                this.is_header = r2.g;
            }

            public /* synthetic */ Column(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<TableProperty, a> {
            public List<Column> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TableProperty(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<TableProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TableProperty c(g0 r7) {
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
                r1.add(Column.ADAPTER.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "columns");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new TableProperty(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TableProperty r4) {
                TableProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + Column.ADAPTER.a().l(1, r5.getColumns());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TableProperty r5) {
                TableProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Column.ADAPTER.a().i(r4, 1, r6.getColumns());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, TableProperty r4) {
                TableProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                Column.ADAPTER.a().j(r3, 1, r5.getColumns());
            }

            public b(FieldEncoding r7, KClass<TableProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.TableProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TableProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TableProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.columns;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TableProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final List<Column> getColumns() {
            return this.columns;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TableProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.columns = com.lark.wire.internal.a.c("columns", r2.d);
        }

        public /* synthetic */ TableProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableRowProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableRowProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$TableRowProperty$Builder;Lokio/ByteString;)V", "horizontal_align", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$HorizontalAlign;", "getHorizontal_align", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$HorizontalAlign;", "vertical_align", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$VerticalAlign;", "getVertical_align", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$VerticalAlign;", "is_header", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TableRowProperty extends com.lark.wire.Message<TableRowProperty, a> {
        public static final ProtoAdapter<TableRowProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final HorizontalAlign horizontal_align;
        private final Boolean is_header;
        private final VerticalAlign vertical_align;

        public static final class a extends com.lark.wire.Message.a<TableRowProperty, a> {
            public HorizontalAlign d;
            public VerticalAlign e;
            public Boolean f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TableRowProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TableRowProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TableRowProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L22;
                if (r3 != 1) goto L8;
                r0.d = HorizontalAlign.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = VerticalAlign.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L22:
                return new TableRowProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TableRowProperty r5) {
                TableRowProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + HorizontalAlign.ADAPTER.l(1, r6.getHorizontal_align())) + VerticalAlign.ADAPTER.l(2, r6.getVertical_align())) + ProtoAdapter.g.l(3, r6.is_header());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TableRowProperty r5) {
                TableRowProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                HorizontalAlign.ADAPTER.i(r4, 1, r6.getHorizontal_align());
                VerticalAlign.ADAPTER.i(r4, 2, r6.getVertical_align());
                ProtoAdapter.g.i(r4, 3, r6.is_header());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TableRowProperty r5) {
                TableRowProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 3, r6.is_header());
                VerticalAlign.ADAPTER.j(r4, 2, r6.getVertical_align());
                HorizontalAlign.ADAPTER.j(r4, 1, r6.getHorizontal_align());
            }

            public b(FieldEncoding r7, KClass<TableRowProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.TableRowProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TableRowProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TableRowProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.horizontal_align;
            r0.e = this.vertical_align;
            r0.f = this.is_header;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TableRowProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final HorizontalAlign getHorizontal_align() {
            return this.horizontal_align;
        }

        public final VerticalAlign getVertical_align() {
            return this.vertical_align;
        }

        public final Boolean is_header() {
            return this.is_header;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TableRowProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.horizontal_align = r2.d;
            this.vertical_align = r2.e;
            this.is_header = r2.f;
        }

        public /* synthetic */ TableRowProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b8\b\u0086\u0081\u0002\u0018\u0000 ;2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001;B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:¨\u0006<"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$Tag;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TEXT", "IMG", "P", "FIGURE", "AT", "A", "B", "I", "U", "EMOTION", "BUTTON", "SELECT", "PROGRESSSELECT", "DIV", "TEXTABLEAREA", "TIME", "LINK", "MEDIA", "SELECTMENU", "OVERFLOWMENU", "DATEPICKER", "DOCS", "H1", "H2", "H3", "UL", "OL", "LI", "QUOTE", "CODE", "CODE_BLOCK", "HR", "TIMEPICKER", "DATETIMEPICKER", "REACTION", "MENTION", "CODE_BLOCK_V2", "MY_AI_TOOL", "TABLE", "TABLE_ROW", "TABLE_CELL", "COLUMNS", "COLUMN", "H4", "H5", "H6", "AT_USER_GROUP", "IMAGE_GALLERY", "MARKDOWN", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Tag extends Enum<Tag> implements o0 {
        public static final Tag A = null;
        public static final ProtoAdapter<Tag> ADAPTER = null;
        public static final Tag AT = null;
        public static final Tag AT_USER_GROUP = null;
        public static final Tag B = null;
        public static final Tag BUTTON = null;
        public static final Tag CODE = null;
        public static final Tag CODE_BLOCK = null;
        public static final Tag CODE_BLOCK_V2 = null;
        public static final Tag COLUMN = null;
        public static final Tag COLUMNS = null;
        public static final b Companion = null;
        public static final Tag DATEPICKER = null;
        public static final Tag DATETIMEPICKER = null;
        public static final Tag DIV = null;
        public static final Tag DOCS = null;
        public static final Tag EMOTION = null;
        public static final Tag FIGURE = null;
        public static final Tag H1 = null;
        public static final Tag H2 = null;
        public static final Tag H3 = null;
        public static final Tag H4 = null;
        public static final Tag H5 = null;
        public static final Tag H6 = null;
        public static final Tag HR = null;
        public static final Tag I = null;
        public static final Tag IMAGE_GALLERY = null;
        public static final Tag IMG = null;
        public static final Tag LI = null;
        public static final Tag LINK = null;
        public static final Tag MARKDOWN = null;
        public static final Tag MEDIA = null;
        public static final Tag MENTION = null;
        public static final Tag MY_AI_TOOL = null;
        public static final Tag OL = null;
        public static final Tag OVERFLOWMENU = null;
        public static final Tag P = null;
        public static final Tag PROGRESSSELECT = null;
        public static final Tag QUOTE = null;
        public static final Tag REACTION = null;
        public static final Tag SELECT = null;
        public static final Tag SELECTMENU = null;
        public static final Tag TABLE = null;
        public static final Tag TABLE_CELL = null;
        public static final Tag TABLE_ROW = null;
        public static final Tag TEXT = null;
        public static final Tag TEXTABLEAREA = null;
        public static final Tag TIME = null;
        public static final Tag TIMEPICKER = null;
        public static final Tag U = null;
        public static final Tag UL = null;
        public static final Tag UNKNOWN = null;
        public static final /* synthetic */ Tag[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Tag> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Tag.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Tag> r1, Syntax r2, Tag r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Tag a(int r0) {
                switch(r0) {
                    case 0: goto L54;
                    case 1: goto L104;
                    case 2: goto L103;
                    case 3: goto L102;
                    case 4: goto L101;
                    case 5: goto L100;
                    case 6: goto L99;
                    case 7: goto L98;
                    case 8: goto L97;
                    case 9: goto L96;
                    case 10: goto L95;
                    case 11: goto L94;
                    case 12: goto L93;
                    case 13: goto L92;
                    case 14: goto L91;
                    case 15: goto L90;
                    case 16: goto L89;
                    case 17: goto L88;
                    case 18: goto L87;
                    case 19: goto L86;
                    case 20: goto L85;
                    case 21: goto L84;
                    case 22: goto L83;
                    case 23: goto L82;
                    case 24: goto L81;
                    case 25: goto L80;
                    case 26: goto L79;
                    case 27: goto L78;
                    case 28: goto L77;
                    case 29: goto L76;
                    case 30: goto L75;
                    case 31: goto L74;
                    case 32: goto L73;
                    case 33: goto L72;
                    case 34: goto L71;
                    case 35: goto L70;
                    case 36: goto L69;
                    case 37: goto L68;
                    case 38: goto L67;
                    case 39: goto L66;
                    case 40: goto L65;
                    case 41: goto L64;
                    case 42: goto L63;
                    case 43: goto L62;
                    case 44: goto L61;
                    case 45: goto L60;
                    case 46: goto L59;
                    case 47: goto L58;
                    case 48: goto L57;
                    case 49: goto L56;
                    default: goto L3;
                };
            L3:
                return null;
            L56:
                return Tag.MARKDOWN;
            L57:
                return Tag.IMAGE_GALLERY;
            L58:
                return Tag.AT_USER_GROUP;
            L59:
                return Tag.H6;
            L60:
                return Tag.H5;
            L61:
                return Tag.H4;
            L62:
                return Tag.COLUMN;
            L63:
                return Tag.COLUMNS;
            L64:
                return Tag.TABLE_CELL;
            L65:
                return Tag.TABLE_ROW;
            L66:
                return Tag.TABLE;
            L67:
                return Tag.MY_AI_TOOL;
            L68:
                return Tag.CODE_BLOCK_V2;
            L69:
                return Tag.MENTION;
            L70:
                return Tag.REACTION;
            L71:
                return Tag.DATETIMEPICKER;
            L72:
                return Tag.TIMEPICKER;
            L73:
                return Tag.HR;
            L74:
                return Tag.CODE_BLOCK;
            L75:
                return Tag.CODE;
            L76:
                return Tag.QUOTE;
            L77:
                return Tag.LI;
            L78:
                return Tag.OL;
            L79:
                return Tag.UL;
            L80:
                return Tag.H3;
            L81:
                return Tag.H2;
            L82:
                return Tag.H1;
            L83:
                return Tag.DOCS;
            L84:
                return Tag.DATEPICKER;
            L85:
                return Tag.OVERFLOWMENU;
            L86:
                return Tag.SELECTMENU;
            L87:
                return Tag.MEDIA;
            L88:
                return Tag.LINK;
            L89:
                return Tag.TIME;
            L90:
                return Tag.TEXTABLEAREA;
            L91:
                return Tag.DIV;
            L92:
                return Tag.PROGRESSSELECT;
            L93:
                return Tag.SELECT;
            L94:
                return Tag.BUTTON;
            L95:
                return Tag.EMOTION;
            L96:
                return Tag.U;
            L97:
                return Tag.I;
            L98:
                return Tag.B;
            L99:
                return Tag.A;
            L100:
                return Tag.AT;
            L101:
                return Tag.FIGURE;
            L102:
                return Tag.P;
            L103:
                return Tag.IMG;
            L104:
                return Tag.TEXT;
            L54:
                return Tag.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Tag fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Tag> getEntries() {
            return b;
        }

        static {
            Tag r0 = new Tag("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Tag r1 = new Tag("TEXT", 1, 1);
            TEXT = r1;
            Tag r2 = new Tag("IMG", 2, 2);
            IMG = r2;
            Tag r3 = new Tag("P", 3, 3);
            P = r3;
            Tag r4 = new Tag("FIGURE", 4, 4);
            FIGURE = r4;
            Tag r5 = new Tag("AT", 5, 5);
            AT = r5;
            Tag r6 = new Tag("A", 6, 6);
            A = r6;
            Tag r7 = new Tag("B", 7, 7);
            B = r7;
            Tag r8 = new Tag("I", 8, 8);
            I = r8;
            Tag r9 = new Tag("U", 9, 9);
            U = r9;
            Tag r10 = new Tag("EMOTION", 10, 10);
            EMOTION = r10;
            Tag r11 = new Tag("BUTTON", 11, 11);
            BUTTON = r11;
            Tag r12 = new Tag("SELECT", 12, 12);
            SELECT = r12;
            Tag r13 = new Tag("PROGRESSSELECT", 13, 13);
            PROGRESSSELECT = r13;
            Tag r14 = new Tag("DIV", 14, 14);
            DIV = r14;
            Tag r15 = new Tag("TEXTABLEAREA", 15, 15);
            TEXTABLEAREA = r15;
            Tag r16 = new Tag("TIME", 16, 16);
            TIME = r16;
            Tag r17 = new Tag("LINK", 17, 17);
            LINK = r17;
            Tag r19 = new Tag("MEDIA", 18, 18);
            MEDIA = r19;
            Tag r110 = new Tag("SELECTMENU", 19, 19);
            SELECTMENU = r110;
            Tag r111 = new Tag("OVERFLOWMENU", 20, 20);
            OVERFLOWMENU = r111;
            Tag r112 = new Tag("DATEPICKER", 21, 21);
            DATEPICKER = r112;
            Tag r113 = new Tag("DOCS", 22, 22);
            DOCS = r113;
            Tag r114 = new Tag("H1", 23, 23);
            H1 = r114;
            Tag r115 = new Tag("H2", 24, 24);
            H2 = r115;
            Tag r116 = new Tag("H3", 25, 25);
            H3 = r116;
            Tag r117 = new Tag("UL", 26, 26);
            UL = r117;
            Tag r118 = new Tag("OL", 27, 27);
            OL = r118;
            Tag r119 = new Tag("LI", 28, 28);
            LI = r119;
            Tag r120 = new Tag("QUOTE", 29, 29);
            QUOTE = r120;
            Tag r121 = new Tag("CODE", 30, 30);
            CODE = r121;
            Tag r122 = new Tag("CODE_BLOCK", 31, 31);
            CODE_BLOCK = r122;
            Tag r123 = new Tag("HR", 32, 32);
            HR = r123;
            Tag r124 = new Tag("TIMEPICKER", 33, 33);
            TIMEPICKER = r124;
            Tag r125 = new Tag("DATETIMEPICKER", 34, 34);
            DATETIMEPICKER = r125;
            Tag r126 = new Tag("REACTION", 35, 35);
            REACTION = r126;
            Tag r127 = new Tag("MENTION", 36, 36);
            MENTION = r127;
            Tag r128 = new Tag("CODE_BLOCK_V2", 37, 37);
            CODE_BLOCK_V2 = r128;
            Tag r129 = new Tag("MY_AI_TOOL", 38, 38);
            MY_AI_TOOL = r129;
            Tag r130 = new Tag("TABLE", 39, 39);
            TABLE = r130;
            Tag r131 = new Tag("TABLE_ROW", 40, 40);
            TABLE_ROW = r131;
            Tag r132 = new Tag("TABLE_CELL", 41, 41);
            TABLE_CELL = r132;
            Tag r133 = new Tag("COLUMNS", 42, 42);
            COLUMNS = r133;
            Tag r134 = new Tag("COLUMN", 43, 43);
            COLUMN = r134;
            Tag r135 = new Tag("H4", 44, 44);
            H4 = r135;
            Tag r136 = new Tag("H5", 45, 45);
            H5 = r136;
            Tag r137 = new Tag("H6", 46, 46);
            H6 = r137;
            Tag r138 = new Tag("AT_USER_GROUP", 47, 47);
            AT_USER_GROUP = r138;
            Tag r139 = new Tag("IMAGE_GALLERY", 48, 48);
            IMAGE_GALLERY = r139;
            Tag r140 = new Tag("MARKDOWN", 49, 49);
            MARKDOWN = r140;
            Tag[] r141 = {r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140};
            a = r141;
            b = EnumEntriesKt.enumEntries(r141);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Tag.class), Syntax.PROTO_2, r0);
        }

        public static Tag[] values() {
            return (Tag[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Tag valueOf(String r1) {
            return (Tag) r27.a.a(Tag.class, r1);
        }

        public Tag(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextProperty$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "i18n_key", "getI18n_key", "numberOfLines", "", "getNumberOfLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TextProperty extends com.lark.wire.Message<TextProperty, a> {
        public static final ProtoAdapter<TextProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_NUMBEROFLINES = 0;
        private static final long serialVersionUID = 0;
        private final String content;
        private final String i18n_key;
        private final Integer numberOfLines;

        public static final class a extends com.lark.wire.Message.a<TextProperty, a> {
            public String d;
            public String e;
            public Integer f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TextProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TextProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TextProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "content");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L11;
                r1.f = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L11:
                r7.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L16:
                return new TextProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TextProperty r5) {
                TextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(1, r6.getContent())) + r1.l(2, r6.getI18n_key())) + ProtoAdapter.h.l(3, r6.getNumberOfLines());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TextProperty r5) {
                TextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getContent());
                r0.i(r4, 2, r6.getI18n_key());
                ProtoAdapter.h.i(r4, 3, r6.getNumberOfLines());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TextProperty r5) {
                TextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 3, r6.getNumberOfLines());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getI18n_key());
                r0.j(r4, 1, r6.getContent());
            }

            public b(FieldEncoding r7, KClass<TextProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.TextProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TextProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content;
            r0.e = this.i18n_key;
            r0.f = this.numberOfLines;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TextProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final String getI18n_key() {
            return this.i18n_key;
        }

        public final Integer getNumberOfLines() {
            return this.numberOfLines;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TextProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.content = r4;
            this.i18n_key = r2.e;
            this.numberOfLines = r2.f;
        }

        public /* synthetic */ TextProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextableAreaProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextableAreaProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$TextableAreaProperty$Builder;Lokio/ByteString;)V", "numberOfLines", "", "getNumberOfLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TextableAreaProperty extends com.lark.wire.Message<TextableAreaProperty, a> {
        public static final ProtoAdapter<TextableAreaProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_NUMBEROFLINES = 0;
        private static final long serialVersionUID = 0;
        private final Integer numberOfLines;

        public static final class a extends com.lark.wire.Message.a<TextableAreaProperty, a> {
            public Integer d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TextableAreaProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TextableAreaProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TextableAreaProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = (Integer) ProtoAdapter.h.c(r6);
                goto L3
            L10:
                return new TextableAreaProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TextableAreaProperty r4) {
                TextableAreaProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.h.l(1, r5.getNumberOfLines());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TextableAreaProperty r5) {
                TextableAreaProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.h.i(r4, 1, r6.getNumberOfLines());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, TextableAreaProperty r4) {
                TextableAreaProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.h.j(r3, 1, r5.getNumberOfLines());
            }

            public b(FieldEncoding r7, KClass<TextableAreaProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.TextableAreaProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TextableAreaProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextableAreaProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.numberOfLines;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TextableAreaProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getNumberOfLines() {
            return this.numberOfLines;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TextableAreaProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.numberOfLines = r2.d;
        }

        public /* synthetic */ TextableAreaProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimePickerProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimePickerProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimePickerProperty$Builder;Lokio/ByteString;)V", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "place_holder", "getPlace_holder", "place_holder_i18n_key", "getPlace_holder_i18n_key", "initial_time", "getInitial_time", "confirm", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "getConfirm", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ButtonConfirmProperty;", "disable", "", "getDisable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_loading", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TimePickerProperty extends com.lark.wire.Message<TimePickerProperty, a> {
        public static final ProtoAdapter<TimePickerProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_DISABLE = false;
        public static final boolean DEFAULT_IS_LOADING = false;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final ButtonConfirmProperty confirm;
        private final Boolean disable;
        private final String initial_time;
        private final Boolean is_loading;
        private final String place_holder;
        private final String place_holder_i18n_key;

        public static final class a extends com.lark.wire.Message.a<TimePickerProperty, a> {
            public String d;
            public String e;
            public String f;
            public String g;
            public ButtonConfirmProperty h;
            public Boolean i;
            public Boolean j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TimePickerProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TimePickerProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TimePickerProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L15;
                switch(r4) {
                    case 1: goto L13;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L7:
                r1.j = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L8:
                r1.i = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L9:
                r1.h = ButtonConfirmProperty.ADAPTER.c(r7);
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L15:
                return new TimePickerProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TimePickerProperty r5) {
                TimePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = ((((r0 + r1.l(1, r6.getAction_id())) + r1.l(2, r6.getPlace_holder())) + r1.l(3, r6.getPlace_holder_i18n_key())) + r1.l(4, r6.getInitial_time())) + ButtonConfirmProperty.ADAPTER.l(5, r6.getConfirm());
                l r3 = ProtoAdapter.g;
                return (r2 + r3.l(6, r6.getDisable())) + r3.l(7, r6.is_loading());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TimePickerProperty r5) {
                TimePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getAction_id());
                r0.i(r4, 2, r6.getPlace_holder());
                r0.i(r4, 3, r6.getPlace_holder_i18n_key());
                r0.i(r4, 4, r6.getInitial_time());
                ButtonConfirmProperty.ADAPTER.i(r4, 5, r6.getConfirm());
                l r1 = ProtoAdapter.g;
                r1.i(r4, 6, r6.getDisable());
                r1.i(r4, 7, r6.is_loading());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TimePickerProperty r5) {
                TimePickerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 7, r6.is_loading());
                r0.j(r4, 6, r6.getDisable());
                ButtonConfirmProperty.ADAPTER.j(r4, 5, r6.getConfirm());
                w r1 = ProtoAdapter.q;
                r1.j(r4, 4, r6.getInitial_time());
                r1.j(r4, 3, r6.getPlace_holder_i18n_key());
                r1.j(r4, 2, r6.getPlace_holder());
                r1.j(r4, 1, r6.getAction_id());
            }

            public b(FieldEncoding r7, KClass<TimePickerProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.TimePickerProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TimePickerProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TimePickerProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.action_id;
            r0.e = this.place_holder;
            r0.f = this.place_holder_i18n_key;
            r0.g = this.initial_time;
            r0.h = this.confirm;
            r0.i = this.disable;
            r0.j = this.is_loading;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TimePickerProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final ButtonConfirmProperty getConfirm() {
            return this.confirm;
        }

        public final Boolean getDisable() {
            return this.disable;
        }

        public final String getInitial_time() {
            return this.initial_time;
        }

        public final String getPlace_holder() {
            return this.place_holder;
        }

        public final String getPlace_holder_i18n_key() {
            return this.place_holder_i18n_key;
        }

        public final Boolean is_loading() {
            return this.is_loading;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TimePickerProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.action_id = r2.d;
            this.place_holder = r2.e;
            this.place_holder_i18n_key = r2.f;
            this.initial_time = r2.g;
            this.confirm = r2.h;
            this.disable = r2.i;
            this.is_loading = r2.j;
        }

        public /* synthetic */ TimePickerProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimeProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimeProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$TimeProperty$Builder;Lokio/ByteString;)V", "millisecond_since1970", "", "getMillisecond_since1970", "()J", "format", "", "getFormat", "()Ljava/lang/String;", "link", "getLink", "format_type", "getFormat_type", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TimeProperty extends com.lark.wire.Message<TimeProperty, a> {
        public static final ProtoAdapter<TimeProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final String DEFAULT_FORMAT = "YYYY.MM.DD(dddd) HH:mm (GMT)";
        private static final long serialVersionUID = 0;
        private final String format;
        private final String format_type;
        private final String link;
        private final long millisecond_since1970;

        public static final class a extends com.lark.wire.Message.a<TimeProperty, a> {
            public Long d;
            public String e;
            public String f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TimeProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TimeProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TimeProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                r1.d = Long.valueOf(((Number) ProtoAdapter.k.c(r7)).longValue());
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new TimeProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TimeProperty r5) {
                TimeProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + ProtoAdapter.k.l(1, Long.valueOf(r6.getMillisecond_since1970()));
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(2, r6.getFormat())) + r1.l(3, r6.getLink())) + r1.l(4, r6.getFormat_type());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TimeProperty r5) {
                TimeProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.k.i(r4, 1, Long.valueOf(r6.getMillisecond_since1970()));
                w r0 = ProtoAdapter.q;
                r0.i(r4, 2, r6.getFormat());
                r0.i(r4, 3, r6.getLink());
                r0.i(r4, 4, r6.getFormat_type());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TimeProperty r5) {
                TimeProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getFormat_type());
                r0.j(r4, 3, r6.getLink());
                r0.j(r4, 2, r6.getFormat());
                ProtoAdapter.k.j(r4, 1, Long.valueOf(r6.getMillisecond_since1970()));
            }

            public b(FieldEncoding r7, KClass<TimeProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.TimeProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TimeProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TimeProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = Long.valueOf(this.millisecond_since1970);
            r0.e = this.format;
            r0.f = this.link;
            r0.g = this.format_type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TimeProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getFormat() {
            return this.format;
        }

        public final String getFormat_type() {
            return this.format_type;
        }

        public final String getLink() {
            return this.link;
        }

        public final long getMillisecond_since1970() {
            return this.millisecond_since1970;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TimeProperty(a r3, ByteString r4) {
            super(ADAPTER, r4);
            Long r5 = r3.d;
            Intrinsics.checkNotNull(r5);
            this.millisecond_since1970 = r5.longValue();
            this.format = r3.e;
            this.link = r3.f;
            this.format_type = r3.g;
        }

        public /* synthetic */ TimeProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ULProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ULProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$ULProperty$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ULProperty$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$ULProperty$Type;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ULProperty extends com.lark.wire.Message<ULProperty, a> {
        public static final ProtoAdapter<ULProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Type type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$ULProperty$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DISC", "CIRCLE", "SQUARE", "NONE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type CIRCLE = null;
            public static final b Companion = null;
            public static final Type DISC = null;
            public static final Type NONE = null;
            public static final Type SQUARE = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
                    return null;
                L17:
                    return Type.NONE;
                L18:
                    return Type.SQUARE;
                L19:
                    return Type.CIRCLE;
                L15:
                    return Type.DISC;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Type> getEntries() {
                return b;
            }

            static {
                Type r0 = new Type("DISC", 0, 0);
                DISC = r0;
                Type r1 = new Type("CIRCLE", 1, 1);
                CIRCLE = r1;
                Type r3 = new Type("SQUARE", 2, 2);
                SQUARE = r3;
                Type r5 = new Type("NONE", 3, 3);
                NONE = r5;
                Type[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
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

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
                return null;
            L17:
                return NONE;
            L18:
                return SQUARE;
            L19:
                return CIRCLE;
            L15:
                return DISC;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ULProperty, a> {
            public Type d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ULProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ULProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ULProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L11;
                r0.d = Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L13:
                return new ULProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ULProperty r4) {
                ULProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + Type.ADAPTER.l(1, r5.getType());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ULProperty r5) {
                ULProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Type.ADAPTER.i(r4, 1, r6.getType());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, ULProperty r4) {
                ULProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                Type.ADAPTER.j(r3, 1, r5.getType());
            }

            public b(FieldEncoding r7, KClass<ULProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.ULProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ULProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ULProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ULProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Type getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ULProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
        }

        public /* synthetic */ ULProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnderlineProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnderlineProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnderlineProperty$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "i18n_key", "getI18n_key", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class UnderlineProperty extends com.lark.wire.Message<UnderlineProperty, a> {
        public static final ProtoAdapter<UnderlineProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final String i18n_key;

        public static final class a extends com.lark.wire.Message.a<UnderlineProperty, a> {
            public String d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new UnderlineProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<UnderlineProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final UnderlineProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "content");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L13:
                return new UnderlineProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(UnderlineProperty r5) {
                UnderlineProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getContent())) + r1.l(2, r6.getI18n_key());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, UnderlineProperty r5) {
                UnderlineProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getContent());
                r0.i(r4, 2, r6.getI18n_key());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, UnderlineProperty r5) {
                UnderlineProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getI18n_key());
                r0.j(r4, 1, r6.getContent());
            }

            public b(FieldEncoding r7, KClass<UnderlineProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.UnderlineProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ UnderlineProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UnderlineProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content;
            r0.e = this.i18n_key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(UnderlineProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final String getI18n_key() {
            return this.i18n_key;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public UnderlineProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.content = r4;
            this.i18n_key = r2.e;
        }

        public /* synthetic */ UnderlineProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnknownProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnknownProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RichTextElement$UnknownProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class UnknownProperty extends com.lark.wire.Message<UnknownProperty, a> {
        public static final ProtoAdapter<UnknownProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<UnknownProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new UnknownProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<UnknownProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final UnknownProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new UnknownProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(UnknownProperty r2) {
                UnknownProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, UnknownProperty r3) {
                UnknownProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, UnknownProperty r3) {
                UnknownProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<UnknownProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.RichTextElement.UnknownProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ UnknownProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UnknownProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(UnknownProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public UnknownProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ UnknownProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RichTextElement$VerticalAlign;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VERTICAL_ALIGN_UNKNOWN", "VERTICAL_ALIGN_TOP", "VERTICAL_ALIGN_CENTER", "VERTICAL_ALIGN_BOTTOM", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum VerticalAlign extends Enum<VerticalAlign> implements o0 {
        public static final ProtoAdapter<VerticalAlign> ADAPTER = null;
        public static final b Companion = null;
        public static final VerticalAlign VERTICAL_ALIGN_BOTTOM = null;
        public static final VerticalAlign VERTICAL_ALIGN_CENTER = null;
        public static final VerticalAlign VERTICAL_ALIGN_TOP = null;
        public static final VerticalAlign VERTICAL_ALIGN_UNKNOWN = null;
        public static final /* synthetic */ VerticalAlign[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<VerticalAlign> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                VerticalAlign.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return VerticalAlign.VERTICAL_ALIGN_BOTTOM;
            L18:
                return VerticalAlign.VERTICAL_ALIGN_CENTER;
            L19:
                return VerticalAlign.VERTICAL_ALIGN_TOP;
            L15:
                return VerticalAlign.VERTICAL_ALIGN_UNKNOWN;
            }

            public a(KClass<VerticalAlign> r1, Syntax r2, VerticalAlign r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<VerticalAlign> getEntries() {
            return b;
        }

        static {
            VerticalAlign r0 = new VerticalAlign("VERTICAL_ALIGN_UNKNOWN", 0, 0);
            VERTICAL_ALIGN_UNKNOWN = r0;
            VerticalAlign r1 = new VerticalAlign("VERTICAL_ALIGN_TOP", 1, 1);
            VERTICAL_ALIGN_TOP = r1;
            VerticalAlign r3 = new VerticalAlign("VERTICAL_ALIGN_CENTER", 2, 2);
            VERTICAL_ALIGN_CENTER = r3;
            VerticalAlign r5 = new VerticalAlign("VERTICAL_ALIGN_BOTTOM", 3, 3);
            VERTICAL_ALIGN_BOTTOM = r5;
            VerticalAlign[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(VerticalAlign.class), Syntax.PROTO_2, r0);
        }

        public static VerticalAlign[] values() {
            return (VerticalAlign[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final VerticalAlign fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return VERTICAL_ALIGN_BOTTOM;
        L18:
            return VERTICAL_ALIGN_CENTER;
        L19:
            return VERTICAL_ALIGN_TOP;
        L15:
            return VERTICAL_ALIGN_UNKNOWN;
        }

        public static VerticalAlign valueOf(String r1) {
            return (VerticalAlign) r27.a.a(VerticalAlign.class, r1);
        }

        public VerticalAlign(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<RichTextElement, a> {
        public Tag d;
        public Map<String, String> e;
        public PropertySet f;
        public List<String> g;
        public List<String> h;
        public Map<String, String> i;
        public ByteString j;
        public String k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new RichTextElement(this, c(), null);
        }

        public a() {
            this.e = MapsKt.emptyMap();
            this.g = CollectionsKt.emptyList();
            this.h = CollectionsKt.emptyList();
            this.i = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ RichTextElement(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(RichTextElement.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new RichTextElement$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.tag;
        r0.e = this.style;
        r0.f = this.property;
        r0.g = this.child_ids;
        r0.h = this.style_keys;
        r0.i = this.wide_style;
        r0.j = this.ser_upgrade_element;
        r0.k = this.last_upgrade_version;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(RichTextElement.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getChild_ids() {
        return this.child_ids;
    }

    public final String getLast_upgrade_version() {
        return this.last_upgrade_version;
    }

    public final PropertySet getProperty() {
        return this.property;
    }

    public final ByteString getSer_upgrade_element() {
        return this.ser_upgrade_element;
    }

    public final Map<String, String> getStyle() {
        return this.style;
    }

    public final List<String> getStyle_keys() {
        return this.style_keys;
    }

    public final Tag getTag() {
        return this.tag;
    }

    public final Map<String, String> getWide_style() {
        return this.wide_style;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public RichTextElement(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Tag r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.tag = r4;
        this.style = com.lark.wire.internal.a.d("style", r2.e);
        PropertySet r5 = r2.f;
        Intrinsics.checkNotNull(r5);
        this.property = r5;
        this.child_ids = com.lark.wire.internal.a.c("child_ids", r2.g);
        this.style_keys = com.lark.wire.internal.a.c("style_keys", r2.h);
        this.wide_style = com.lark.wire.internal.a.d("wide_style", r2.i);
        this.ser_upgrade_element = r2.j;
        this.last_upgrade_version = r2.k;
    }

    public /* synthetic */ RichTextElement(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

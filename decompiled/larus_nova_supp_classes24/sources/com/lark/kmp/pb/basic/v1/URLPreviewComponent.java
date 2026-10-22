package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.f;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.constant.GlobalAudioSceneEnum;
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
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\u0018\u0000 ~2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:O}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010{\u001a\u00020\u0002H\u0016J\b\u0010|\u001a\u00020\u0017H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001a\u0010\u000fR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u00107\u001a\u0004\u0018\u000108¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010;\u001a\u0004\u0018\u00010<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010?\u001a\u0004\u0018\u00010@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010C\u001a\u0004\u0018\u00010D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010G\u001a\u0004\u0018\u00010H¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010K\u001a\u0004\u0018\u00010L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010O\u001a\u0004\u0018\u00010P¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0013\u0010S\u001a\u0004\u0018\u00010T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010W\u001a\u0004\u0018\u00010X¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0013\u0010[\u001a\u0004\u0018\u00010\\¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0013\u0010_\u001a\u0004\u0018\u00010`¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0013\u0010c\u001a\u0004\u0018\u00010d¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0013\u0010g\u001a\u0004\u0018\u00010h¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0013\u0010k\u001a\u0004\u0018\u00010l¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0013\u0010o\u001a\u0004\u0018\u00010p¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0013\u0010s\u001a\u0004\u0018\u00010t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0013\u0010w\u001a\u0004\u0018\u00010x¢\u0006\b\n\u0000\u001a\u0004\by\u0010z¨\u0006¦\u0001"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Type;", "can_skip_when_unknown", "", "getCan_skip_when_unknown", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "style", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Style;", "getStyle", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Style;", "child_ids", "", "", "getChild_ids", "()Ljava/util/List;", "is_font_zoomable", "empty", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EmptyProperty;", "getEmpty", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EmptyProperty;", "linear_layout", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LinearLayoutProperty;", "getLinear_layout", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LinearLayoutProperty;", "flex_layout", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FlexLayoutProperty;", "getFlex_layout", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FlexLayoutProperty;", "header", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$PreviewHeaderProperty;", "getHeader", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$PreviewHeaderProperty;", "richtext", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$RichTextProperty;", "getRichtext", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$RichTextProperty;", "image", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageProperty;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageProperty;", "chatters_preview", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty;", "getChatters_preview", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty;", "button", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ButtonProperty;", "getButton", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ButtonProperty;", "icon_button", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$IconButtonProperty;", "getIcon_button", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$IconButtonProperty;", "text_button", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextButtonProperty;", "getText_button", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextButtonProperty;", "time", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeProperty;", "getTime", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeProperty;", "text", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextProperty;", "getText", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextProperty;", "tag_list", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty;", "getTag_list", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty;", "spin_button", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$SpinButtonProperty;", "getSpin_button", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$SpinButtonProperty;", "avatar", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty;", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty;", GlobalAudioSceneEnum.VIDEO, "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty;", "getVideo", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty;", "card_container", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$CardContainerProperty;", "getCard_container", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$CardContainerProperty;", "doc_image", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocImageProperty;", "getDoc_image", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocImageProperty;", "loading", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LoadingProperty;", "getLoading", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LoadingProperty;", "time_zone", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty;", "getTime_zone", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty;", "oversized_text", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$OversizedTextProperty;", "getOversized_text", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$OversizedTextProperty;", "engine", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EngineProperty;", "getEngine", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EngineProperty;", "doc_state_button", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty;", "getDoc_state_button", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty;", "image_container", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageContainerProperty;", "getImage_container", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageContainerProperty;", "newBuilder", "toString", "Builder", "Companion", "Type", "SizeLevel", "ValueType", "Direction", "Orientation", "Justify", "Align", "FlexWrap", "Theme", "FontType", "Padding", "FontLevel", "Value", "Item", "Style", "EmptyProperty", "LinearLayoutProperty", "FlexLayoutProperty", "PreviewHeaderProperty", "RichTextProperty", "ImageProperty", "ImageContainerProperty", "ChattersPreviewProperty", "ButtonProperty", "IconButtonProperty", "TextButtonProperty", "TimeProperty", "TextProperty", "TagListProperty", "SpinButtonProperty", "AvatarProperty", "VideoProperty", "CardContainerProperty", "DocImageProperty", "LoadingProperty", "TimeZoneProperty", "OversizedTextProperty", "EngineProperty", "DocStateButtonProperty", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class URLPreviewComponent extends com.lark.wire.Message<URLPreviewComponent, a> {
    public static final ProtoAdapter<URLPreviewComponent> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_CAN_SKIP_WHEN_UNKNOWN = true;
    public static final boolean DEFAULT_IS_FONT_ZOOMABLE = true;
    private static final long serialVersionUID = 0;
    private final AvatarProperty avatar;
    private final ButtonProperty button;
    private final Boolean can_skip_when_unknown;
    private final CardContainerProperty card_container;
    private final ChattersPreviewProperty chatters_preview;
    private final List<String> child_ids;
    private final DocImageProperty doc_image;
    private final DocStateButtonProperty doc_state_button;
    private final EmptyProperty empty;
    private final EngineProperty engine;
    private final FlexLayoutProperty flex_layout;
    private final PreviewHeaderProperty header;
    private final IconButtonProperty icon_button;
    private final ImageProperty image;
    private final ImageContainerProperty image_container;
    private final Boolean is_font_zoomable;
    private final LinearLayoutProperty linear_layout;
    private final LoadingProperty loading;
    private final OversizedTextProperty oversized_text;
    private final RichTextProperty richtext;
    private final SpinButtonProperty spin_button;
    private final Style style;
    private final TagListProperty tag_list;
    private final TextProperty text;
    private final TextButtonProperty text_button;
    private final TimeProperty time;
    private final TimeZoneProperty time_zone;
    private final Type type;
    private final VideoProperty video;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Align;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP", "MIDDLE", "BOTTOM", "STRETCH", "BASELINE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Align extends Enum<Align> implements o0 {
        public static final ProtoAdapter<Align> ADAPTER = null;
        public static final Align BASELINE = null;
        public static final Align BOTTOM = null;
        public static final b Companion = null;
        public static final Align MIDDLE = null;
        public static final Align STRETCH = null;
        public static final Align TOP = null;
        public static final /* synthetic */ Align[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Align> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Align.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Align> r1, Syntax r2, Align r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Align a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return Align.BASELINE;
            L20:
                return Align.STRETCH;
            L21:
                return Align.BOTTOM;
            L22:
                return Align.MIDDLE;
            L17:
                return Align.TOP;
            }
        }

        @JvmStatic
        public static final Align fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Align> getEntries() {
            return b;
        }

        static {
            Align r0 = new Align("TOP", 0, 0);
            TOP = r0;
            Align r1 = new Align("MIDDLE", 1, 1);
            MIDDLE = r1;
            Align r3 = new Align("BOTTOM", 2, 2);
            BOTTOM = r3;
            Align r5 = new Align("STRETCH", 3, 3);
            STRETCH = r5;
            Align r7 = new Align("BASELINE", 4, 4);
            BASELINE = r7;
            Align[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Align.class), Syntax.PROTO_2, r0);
        }

        public static Align[] values() {
            return (Align[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Align valueOf(String r1) {
            return (Align) r27.a.a(Align.class, r1);
        }

        public Align(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$Builder;Lokio/ByteString;)V", "chatter_info", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$ChatterInfo;", "getChatter_info", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$ChatterInfo;", "newBuilder", "toString", "", "Builder", "Companion", "ChatterInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AvatarProperty extends com.lark.wire.Message<AvatarProperty, a> {
        public static final ProtoAdapter<AvatarProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ChatterInfo chatter_info;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$ChatterInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$ChatterInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$ChatterInfo$Builder;Lokio/ByteString;)V", "avatar_key", "", "getAvatar_key", "()Ljava/lang/String;", "chatter_id", "getChatter_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class ChatterInfo extends com.lark.wire.Message<ChatterInfo, a> {
            public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final String avatar_key;
            private final String chatter_id;

            public static final class a extends com.lark.wire.Message.a<ChatterInfo, a> {
                public String d;
                public String e;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new ChatterInfo(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<ChatterInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final ChatterInfo c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r1 = new a();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L13;
                    if (r4 != 1) goto L8;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.d = r7.i();
                    goto L3
                L8:
                    if (r4 != 2) goto L9;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.e = r7.i();
                    goto L3
                L9:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L13:
                    return new ChatterInfo(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(ChatterInfo r5) {
                    ChatterInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    return (r0 + r1.l(1, r6.getAvatar_key())) + r1.l(2, r6.getChatter_id());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, ChatterInfo r5) {
                    ChatterInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r4, 1, r6.getAvatar_key());
                    r0.i(r4, 2, r6.getChatter_id());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, ChatterInfo r5) {
                    ChatterInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    w r0 = ProtoAdapter.q;
                    r0.j(r4, 2, r6.getChatter_id());
                    r0.j(r4, 1, r6.getAvatar_key());
                }

                public b(FieldEncoding r7, KClass<ChatterInfo> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.AvatarProperty.ChatterInfo", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ ChatterInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatterInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.avatar_key;
                r0.e = this.chatter_id;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(ChatterInfo.class).getSimpleName() + '@' + hashCode();
            }

            public final String getAvatar_key() {
                return this.avatar_key;
            }

            public final String getChatter_id() {
                return this.chatter_id;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public ChatterInfo(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.avatar_key = r2.d;
                this.chatter_id = r2.e;
            }

            public /* synthetic */ ChatterInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<AvatarProperty, a> {
            public ChatterInfo d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AvatarProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AvatarProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final AvatarProperty c(g0 r6) {
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
                r0.d = ChatterInfo.ADAPTER.c(r6);
                goto L3
            L10:
                return new AvatarProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AvatarProperty r4) {
                AvatarProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ChatterInfo.ADAPTER.l(1, r5.getChatter_info());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, AvatarProperty r5) {
                AvatarProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ChatterInfo.ADAPTER.i(r4, 1, r6.getChatter_info());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, AvatarProperty r4) {
                AvatarProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ChatterInfo.ADAPTER.j(r3, 1, r5.getChatter_info());
            }

            public b(FieldEncoding r7, KClass<AvatarProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.AvatarProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AvatarProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AvatarProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.chatter_info;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AvatarProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final ChatterInfo getChatter_info() {
            return this.chatter_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AvatarProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.chatter_info = r2.d;
        }

        public /* synthetic */ AvatarProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0016\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ButtonProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ButtonProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ButtonProperty$Builder;Lokio/ByteString;)V", "icon", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "text", "", "getText", "()Ljava/lang/String;", "direction", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Direction;", "getDirection", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Direction;", CardActionService.ACTION_ID, "getAction_id", "is_disable", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ud_icon", "Lcom/lark/kmp/pb/basic/v1/UDIcon;", "getUd_icon", "()Lcom/lark/kmp/pb/basic/v1/UDIcon;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ButtonProperty extends com.lark.wire.Message<ButtonProperty, a> {
        public static final ProtoAdapter<ButtonProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final Direction DEFAULT_DIRECTION = null;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final Direction direction;
        private final ImageSet icon;
        private final Boolean is_disable;
        private final String text;
        private final UDIcon ud_icon;

        public static final class a extends com.lark.wire.Message.a<ButtonProperty, a> {
            public ImageSet d;
            public String e;
            public Direction f;
            public String g;
            public Boolean h;
            public UDIcon i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ButtonProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ButtonProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ButtonProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L17;
                switch(r4) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L18;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L18:
                r1.f = Direction.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L7:
                r1.i = UDIcon.ADAPTER.c(r10);
                goto L3
            L8:
                r1.h = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L14:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L15:
                r1.d = ImageSet.ADAPTER.c(r10);
                goto L3
            L6:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L17:
                return new ButtonProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ButtonProperty r6) {
                ButtonProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size() + ImageSet.ADAPTER.l(1, r7.getIcon());
                w r1 = ProtoAdapter.q;
                return ((((r0 + r1.l(2, r7.getText())) + Direction.ADAPTER.l(3, r7.getDirection())) + r1.l(4, r7.getAction_id())) + ProtoAdapter.g.l(5, r7.is_disable())) + UDIcon.ADAPTER.l(6, r7.getUd_icon());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ButtonProperty r6) {
                ButtonProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                ImageSet.ADAPTER.i(r5, 1, r7.getIcon());
                w r0 = ProtoAdapter.q;
                r0.i(r5, 2, r7.getText());
                Direction.ADAPTER.i(r5, 3, r7.getDirection());
                r0.i(r5, 4, r7.getAction_id());
                ProtoAdapter.g.i(r5, 5, r7.is_disable());
                UDIcon.ADAPTER.i(r5, 6, r7.getUd_icon());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ButtonProperty r6) {
                ButtonProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                UDIcon.ADAPTER.j(r5, 6, r7.getUd_icon());
                ProtoAdapter.g.j(r5, 5, r7.is_disable());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 4, r7.getAction_id());
                Direction.ADAPTER.j(r5, 3, r7.getDirection());
                r0.j(r5, 2, r7.getText());
                ImageSet.ADAPTER.j(r5, 1, r7.getIcon());
            }

            public b(FieldEncoding r7, KClass<ButtonProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.ButtonProperty", r9, null);
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
            DEFAULT_DIRECTION = Direction.LTR;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ButtonProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.icon;
            r0.e = this.text;
            r0.f = this.direction;
            r0.g = this.action_id;
            r0.h = this.is_disable;
            r0.i = this.ud_icon;
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

        public final Direction getDirection() {
            return this.direction;
        }

        public final ImageSet getIcon() {
            return this.icon;
        }

        public final String getText() {
            return this.text;
        }

        public final UDIcon getUd_icon() {
            return this.ud_icon;
        }

        public final Boolean is_disable() {
            return this.is_disable;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ButtonProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.icon = r2.d;
            this.text = r2.e;
            this.direction = r2.f;
            this.action_id = r2.g;
            this.is_disable = r2.h;
            this.ud_icon = r2.i;
        }

        public /* synthetic */ ButtonProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$CardContainerProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$CardContainerProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$CardContainerProperty$Builder;Lokio/ByteString;)V", "mask_color", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getMask_color", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardContainerProperty extends com.lark.wire.Message<CardContainerProperty, a> {
        public static final ProtoAdapter<CardContainerProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ThemeColor mask_color;

        public static final class a extends com.lark.wire.Message.a<CardContainerProperty, a> {
            public ThemeColor d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CardContainerProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CardContainerProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final CardContainerProperty c(g0 r6) {
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
                r0.d = ThemeColor.ADAPTER.c(r6);
                goto L3
            L10:
                return new CardContainerProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CardContainerProperty r4) {
                CardContainerProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ThemeColor.ADAPTER.l(1, r5.getMask_color());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CardContainerProperty r5) {
                CardContainerProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ThemeColor.ADAPTER.i(r4, 1, r6.getMask_color());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, CardContainerProperty r4) {
                CardContainerProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ThemeColor.ADAPTER.j(r3, 1, r5.getMask_color());
            }

            public b(FieldEncoding r7, KClass<CardContainerProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.CardContainerProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CardContainerProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CardContainerProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.mask_color;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CardContainerProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final ThemeColor getMask_color() {
            return this.mask_color;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CardContainerProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mask_color = r2.d;
        }

        public /* synthetic */ CardContainerProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\"#$%&B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u001dH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$Builder;Lokio/ByteString;)V", "theme", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Theme;", "getTheme", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Theme;", "chatters_count", "", "getChatters_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "chatter_infos", "", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChatterInfo;", "getChatter_infos", "()Ljava/util/List;", "max_show_count", "getMax_show_count", "chatters_mode", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChattersMode;", "getChatters_mode", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChattersMode;", "title", "", "getTitle", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "ChatterType", "ChatterInfo", "ChattersMode", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChattersPreviewProperty extends com.lark.wire.Message<ChattersPreviewProperty, a> {
        public static final ProtoAdapter<ChattersPreviewProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final ChattersMode DEFAULT_CHATTERS_MODE = null;
        public static final int DEFAULT_MAX_SHOW_COUNT = 5;
        public static final Theme DEFAULT_THEME = null;
        private static final long serialVersionUID = 0;
        private final List<ChatterInfo> chatter_infos;
        private final Integer chatters_count;
        private final ChattersMode chatters_mode;
        private final Integer max_show_count;
        private final Theme theme;
        private final String title;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChatterInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChatterInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChatterInfo$Builder;Lokio/ByteString;)V", "avatar_key", "", "getAvatar_key", "()Ljava/lang/String;", "chatter_id", "getChatter_id", "name", "getName", "type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChatterType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChatterType;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class ChatterInfo extends com.lark.wire.Message<ChatterInfo, a> {
            public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
            public static final c Companion = null;
            public static final ChatterType DEFAULT_TYPE = null;
            private static final long serialVersionUID = 0;
            private final String avatar_key;
            private final String chatter_id;
            private final String name;
            private final ChatterType type;

            public static final class a extends com.lark.wire.Message.a<ChatterInfo, a> {
                public String d;
                public String e;
                public String f;
                public ChatterType g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new ChatterInfo(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<ChatterInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final ChatterInfo c(g0 r10) {
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    a r1 = new a();
                    long r2 = r10.c();
                L3:
                    int r4 = r10.e();
                    if (r4 == (-1)) goto L22;
                    if (r4 != 1) goto L8;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.d = r10.i();
                    goto L3
                L8:
                    if (r4 != 2) goto L10;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.e = r10.i();
                    goto L3
                L10:
                    if (r4 != 3) goto L12;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r10, "reader");
                    r1.f = r10.i();
                    goto L3
                L12:
                    if (r4 != 4) goto L13;
                    r1.g = ChatterType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L13:
                    r10.j(r4);
                    Unit r6 = Unit.INSTANCE;
                    goto L3
                L22:
                    return new ChatterInfo(r1, r10.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(ChatterInfo r5) {
                    ChatterInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    return (((r0 + r1.l(1, r6.getAvatar_key())) + r1.l(2, r6.getChatter_id())) + r1.l(3, r6.getName())) + ChatterType.ADAPTER.l(4, r6.getType());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, ChatterInfo r5) {
                    ChatterInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r4, 1, r6.getAvatar_key());
                    r0.i(r4, 2, r6.getChatter_id());
                    r0.i(r4, 3, r6.getName());
                    ChatterType.ADAPTER.i(r4, 4, r6.getType());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, ChatterInfo r5) {
                    ChatterInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    ChatterType.ADAPTER.j(r4, 4, r6.getType());
                    w r0 = ProtoAdapter.q;
                    r0.j(r4, 3, r6.getName());
                    r0.j(r4, 2, r6.getChatter_id());
                    r0.j(r4, 1, r6.getAvatar_key());
                }

                public b(FieldEncoding r7, KClass<ChatterInfo> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.ChattersPreviewProperty.ChatterInfo", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ ChatterInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                DEFAULT_TYPE = ChatterType.USER;
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatterInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.avatar_key;
                r0.e = this.chatter_id;
                r0.f = this.name;
                r0.g = this.type;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(ChatterInfo.class).getSimpleName() + '@' + hashCode();
            }

            public final String getAvatar_key() {
                return this.avatar_key;
            }

            public final String getChatter_id() {
                return this.chatter_id;
            }

            public final String getName() {
                return this.name;
            }

            public final ChatterType getType() {
                return this.type;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public ChatterInfo(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.avatar_key = r2.d;
                this.chatter_id = r2.e;
                this.name = r2.f;
                this.type = r2.g;
            }

            public /* synthetic */ ChatterInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChatterType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum ChatterType extends Enum<ChatterType> implements o0 {
            public static final ProtoAdapter<ChatterType> ADAPTER = null;
            public static final b Companion = null;
            public static final ChatterType UNKNOWN = null;
            public static final ChatterType USER = null;
            public static final /* synthetic */ ChatterType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<ChatterType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    ChatterType.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return ChatterType.USER;
                L9:
                    return ChatterType.UNKNOWN;
                }

                public a(KClass<ChatterType> r1, Syntax r2, ChatterType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<ChatterType> getEntries() {
                return b;
            }

            static {
                ChatterType r0 = new ChatterType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                ChatterType r1 = new ChatterType("USER", 1, 1);
                USER = r1;
                ChatterType[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(ChatterType.class), Syntax.PROTO_2, r0);
            }

            public static ChatterType[] values() {
                return (ChatterType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final ChatterType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return USER;
            L9:
                return UNKNOWN;
            }

            public static ChatterType valueOf(String r1) {
                return (ChatterType) r27.a.a(ChatterType.class, r1);
            }

            public ChatterType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChattersMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATIC", "DYNAMIC", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum ChattersMode extends Enum<ChattersMode> implements o0 {
            public static final ProtoAdapter<ChattersMode> ADAPTER = null;
            public static final b Companion = null;
            public static final ChattersMode DYNAMIC = null;
            public static final ChattersMode STATIC = null;
            public static final /* synthetic */ ChattersMode[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<ChattersMode> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    ChattersMode.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return ChattersMode.DYNAMIC;
                L9:
                    return ChattersMode.STATIC;
                }

                public a(KClass<ChattersMode> r1, Syntax r2, ChattersMode r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<ChattersMode> getEntries() {
                return b;
            }

            static {
                ChattersMode r0 = new ChattersMode("STATIC", 0, 0);
                STATIC = r0;
                ChattersMode r1 = new ChattersMode("DYNAMIC", 1, 1);
                DYNAMIC = r1;
                ChattersMode[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(ChattersMode.class), Syntax.PROTO_2, r0);
            }

            public static ChattersMode[] values() {
                return (ChattersMode[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final ChattersMode fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return DYNAMIC;
            L9:
                return STATIC;
            }

            public static ChattersMode valueOf(String r1) {
                return (ChattersMode) r27.a.a(ChattersMode.class, r1);
            }

            public ChattersMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ChattersPreviewProperty, a> {
            public Theme d;
            public Integer e;
            public List<ChatterInfo> f;
            public Integer g;
            public ChattersMode h;
            public String i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChattersPreviewProperty(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ChattersPreviewProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChattersPreviewProperty c(g0 r11) {
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
                    case 5: goto L23;
                    case 6: goto L7;
                    default: goto L6;
                };
            L21:
                r1.d = Theme.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L23:
                r1.h = ChattersMode.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r11, "reader");
                r1.i = r11.i();
                goto L3
            L12:
                r1.g = (Integer) ProtoAdapter.h.c(r11);
                goto L3
            L13:
                r2.add(ChatterInfo.ADAPTER.c(r11));
                goto L3
            L14:
                r1.e = (Integer) ProtoAdapter.h.c(r11);
                goto L3
            L6:
                r11.j(r5);
                goto L3
            L19:
                ByteString r12 = r11.d(r3);
                Intrinsics.checkNotNullParameter(r2, "chatter_infos");
                com.lark.wire.internal.a.a(r2);
                r1.f = r2;
                return new ChattersPreviewProperty(r1, r12, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChattersPreviewProperty r6) {
                ChattersPreviewProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size() + Theme.ADAPTER.l(1, r7.getTheme());
                s r1 = ProtoAdapter.h;
                return ((((r0 + r1.l(2, r7.getChatters_count())) + ChatterInfo.ADAPTER.a().l(3, r7.getChatter_infos())) + r1.l(4, r7.getMax_show_count())) + ChattersMode.ADAPTER.l(5, r7.getChatters_mode())) + ProtoAdapter.q.l(6, r7.getTitle());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ChattersPreviewProperty r6) {
                ChattersPreviewProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                Theme.ADAPTER.i(r5, 1, r7.getTheme());
                s r0 = ProtoAdapter.h;
                r0.i(r5, 2, r7.getChatters_count());
                ChatterInfo.ADAPTER.a().i(r5, 3, r7.getChatter_infos());
                r0.i(r5, 4, r7.getMax_show_count());
                ChattersMode.ADAPTER.i(r5, 5, r7.getChatters_mode());
                ProtoAdapter.q.i(r5, 6, r7.getTitle());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ChattersPreviewProperty r6) {
                ChattersPreviewProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ProtoAdapter.q.j(r5, 6, r7.getTitle());
                ChattersMode.ADAPTER.j(r5, 5, r7.getChatters_mode());
                s r0 = ProtoAdapter.h;
                r0.j(r5, 4, r7.getMax_show_count());
                ChatterInfo.ADAPTER.a().j(r5, 3, r7.getChatter_infos());
                r0.j(r5, 2, r7.getChatters_count());
                Theme.ADAPTER.j(r5, 1, r7.getTheme());
            }

            public b(FieldEncoding r7, KClass<ChattersPreviewProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.ChattersPreviewProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChattersPreviewProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_THEME = Theme.LIGHT;
            DEFAULT_CHATTERS_MODE = ChattersMode.DYNAMIC;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChattersPreviewProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.theme;
            r0.e = this.chatters_count;
            r0.f = this.chatter_infos;
            r0.g = this.max_show_count;
            r0.h = this.chatters_mode;
            r0.i = this.title;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChattersPreviewProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final List<ChatterInfo> getChatter_infos() {
            return this.chatter_infos;
        }

        public final Integer getChatters_count() {
            return this.chatters_count;
        }

        public final ChattersMode getChatters_mode() {
            return this.chatters_mode;
        }

        public final Integer getMax_show_count() {
            return this.max_show_count;
        }

        public final Theme getTheme() {
            return this.theme;
        }

        public final String getTitle() {
            return this.title;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChattersPreviewProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.theme = r2.d;
            this.chatters_count = r2.e;
            this.chatter_infos = com.lark.wire.internal.a.c("chatter_infos", r2.f);
            this.max_show_count = r2.g;
            this.chatters_mode = r2.h;
            this.title = r2.i;
        }

        public /* synthetic */ ChattersPreviewProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Direction;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LTR", "RTL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Direction extends Enum<Direction> implements o0 {
        public static final ProtoAdapter<Direction> ADAPTER = null;
        public static final b Companion = null;
        public static final Direction LTR = null;
        public static final Direction RTL = null;
        public static final /* synthetic */ Direction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Direction> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Direction.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return Direction.RTL;
            L9:
                return Direction.LTR;
            }

            public a(KClass<Direction> r1, Syntax r2, Direction r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Direction> getEntries() {
            return b;
        }

        static {
            Direction r0 = new Direction("LTR", 0, 0);
            LTR = r0;
            Direction r1 = new Direction("RTL", 1, 1);
            RTL = r1;
            Direction[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Direction.class), Syntax.PROTO_2, r0);
        }

        public static Direction[] values() {
            return (Direction[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Direction fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return RTL;
        L9:
            return LTR;
        }

        public static Direction valueOf(String r1) {
            return (Direction) r27.a.a(Direction.class, r1);
        }

        public Direction(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocImageProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocImageProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocImageProperty$Builder;Lokio/ByteString;)V", "doc_type", "Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "getDoc_type", "()Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "thumbnail_url", "", "getThumbnail_url", "()Ljava/lang/String;", "secret_url", "getSecret_url", "secret_type", "", "getSecret_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "secret_key", "getSecret_key", "secret_nonce", "getSecret_nonce", "support_preview", "", "getSupport_preview", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DocImageProperty extends com.lark.wire.Message<DocImageProperty, a> {
        public static final ProtoAdapter<DocImageProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final Doc.Type DEFAULT_DOC_TYPE = null;
        private static final long serialVersionUID = 0;
        private final Doc.Type doc_type;
        private final String secret_key;
        private final String secret_nonce;
        private final Integer secret_type;
        private final String secret_url;
        private final Boolean support_preview;
        private final String thumbnail_url;

        public static final class a extends com.lark.wire.Message.a<DocImageProperty, a> {
            public Doc.Type d;
            public String e;
            public String f;
            public Integer g;
            public String h;
            public String i;
            public Boolean j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DocImageProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DocImageProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final DocImageProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L18;
                switch(r4) {
                    case 1: goto L19;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r1.d = Doc.Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L7:
                r1.j = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L8:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.i = r10.i();
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.h = r10.i();
                goto L3
            L10:
                r1.g = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.f = r10.i();
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L6:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L18:
                return new DocImageProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DocImageProperty r6) {
                DocImageProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size() + Doc.Type.ADAPTER.l(1, r7.getDoc_type());
                w r1 = ProtoAdapter.q;
                return (((((r0 + r1.l(2, r7.getThumbnail_url())) + r1.l(3, r7.getSecret_url())) + ProtoAdapter.h.l(4, r7.getSecret_type())) + r1.l(5, r7.getSecret_key())) + r1.l(6, r7.getSecret_nonce())) + ProtoAdapter.g.l(7, r7.getSupport_preview());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, DocImageProperty r6) {
                DocImageProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                Doc.Type.ADAPTER.i(r5, 1, r7.getDoc_type());
                w r0 = ProtoAdapter.q;
                r0.i(r5, 2, r7.getThumbnail_url());
                r0.i(r5, 3, r7.getSecret_url());
                ProtoAdapter.h.i(r5, 4, r7.getSecret_type());
                r0.i(r5, 5, r7.getSecret_key());
                r0.i(r5, 6, r7.getSecret_nonce());
                ProtoAdapter.g.i(r5, 7, r7.getSupport_preview());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, DocImageProperty r6) {
                DocImageProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ProtoAdapter.g.j(r5, 7, r7.getSupport_preview());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 6, r7.getSecret_nonce());
                r0.j(r5, 5, r7.getSecret_key());
                ProtoAdapter.h.j(r5, 4, r7.getSecret_type());
                r0.j(r5, 3, r7.getSecret_url());
                r0.j(r5, 2, r7.getThumbnail_url());
                Doc.Type.ADAPTER.j(r5, 1, r7.getDoc_type());
            }

            public b(FieldEncoding r7, KClass<DocImageProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.DocImageProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DocImageProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_DOC_TYPE = Doc.Type.UNKNOWN;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DocImageProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.doc_type;
            r0.e = this.thumbnail_url;
            r0.f = this.secret_url;
            r0.g = this.secret_type;
            r0.h = this.secret_key;
            r0.i = this.secret_nonce;
            r0.j = this.support_preview;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DocImageProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Doc.Type getDoc_type() {
            return this.doc_type;
        }

        public final String getSecret_key() {
            return this.secret_key;
        }

        public final String getSecret_nonce() {
            return this.secret_nonce;
        }

        public final Integer getSecret_type() {
            return this.secret_type;
        }

        public final String getSecret_url() {
            return this.secret_url;
        }

        public final Boolean getSupport_preview() {
            return this.support_preview;
        }

        public final String getThumbnail_url() {
            return this.thumbnail_url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DocImageProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.doc_type = r2.d;
            this.thumbnail_url = r2.e;
            this.secret_url = r2.f;
            this.secret_type = r2.g;
            this.secret_key = r2.h;
            this.secret_nonce = r2.i;
            this.support_preview = r2.j;
        }

        public /* synthetic */ DocImageProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty$Builder;Lokio/ByteString;)V", "curr_state", "", "getCurr_state", "()Ljava/lang/String;", "state_map", "", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty$DocState;", "getState_map", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "DocState", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DocStateButtonProperty extends com.lark.wire.Message<DocStateButtonProperty, a> {
        public static final ProtoAdapter<DocStateButtonProperty> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final String curr_state;
        private final Map<String, DocState> state_map;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty$DocState;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty$DocState$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$DocStateButtonProperty$DocState$Builder;Lokio/ByteString;)V", "alt", "", "getAlt", "()Ljava/lang/String;", "ud_icon", "Lcom/lark/kmp/pb/basic/v1/UDIcon;", "getUd_icon", "()Lcom/lark/kmp/pb/basic/v1/UDIcon;", "next_state", "getNext_state", "ud_btn_color", "getUd_btn_color", "loading", "", "getLoading", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "selected", "getSelected", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class DocState extends com.lark.wire.Message<DocState, a> {
            public static final ProtoAdapter<DocState> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final String alt;
            private final Boolean loading;
            private final String next_state;
            private final Boolean selected;
            private final String ud_btn_color;
            private final UDIcon ud_icon;

            public static final class a extends com.lark.wire.Message.a<DocState, a> {
                public String d;
                public UDIcon e;
                public String f;
                public String g;
                public Boolean h;
                public Boolean i;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new DocState(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<DocState> {
                @Override // com.lark.wire.ProtoAdapter
                public final DocState c(g0 r7) {
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
                    r1.i = (Boolean) ProtoAdapter.g.c(r7);
                    goto L3
                L8:
                    r1.h = (Boolean) ProtoAdapter.g.c(r7);
                    goto L3
                L9:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.g = r7.i();
                    goto L3
                L10:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.f = r7.i();
                    goto L3
                L11:
                    r1.e = UDIcon.ADAPTER.c(r7);
                    goto L3
                L12:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.d = r7.i();
                    goto L3
                L6:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L14:
                    return new DocState(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(DocState r6) {
                    DocState r7 = r6;
                    Intrinsics.checkNotNullParameter(r7, "value");
                    int r0 = r7.unknownFields().size();
                    w r1 = ProtoAdapter.q;
                    int r2 = (((r0 + r1.l(1, r7.getAlt())) + UDIcon.ADAPTER.l(2, r7.getUd_icon())) + r1.l(3, r7.getNext_state())) + r1.l(4, r7.getUd_btn_color());
                    l r3 = ProtoAdapter.g;
                    return (r2 + r3.l(5, r7.getLoading())) + r3.l(6, r7.getSelected());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r5, DocState r6) {
                    DocState r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    w r0 = ProtoAdapter.q;
                    r0.i(r5, 1, r7.getAlt());
                    UDIcon.ADAPTER.i(r5, 2, r7.getUd_icon());
                    r0.i(r5, 3, r7.getNext_state());
                    r0.i(r5, 4, r7.getUd_btn_color());
                    l r1 = ProtoAdapter.g;
                    r1.i(r5, 5, r7.getLoading());
                    r1.i(r5, 6, r7.getSelected());
                    r5.a(r7.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r5, DocState r6) {
                    DocState r7 = r6;
                    Intrinsics.checkNotNullParameter(r5, "writer");
                    Intrinsics.checkNotNullParameter(r7, "value");
                    r5.d(r7.unknownFields());
                    l r0 = ProtoAdapter.g;
                    r0.j(r5, 6, r7.getSelected());
                    r0.j(r5, 5, r7.getLoading());
                    w r1 = ProtoAdapter.q;
                    r1.j(r5, 4, r7.getUd_btn_color());
                    r1.j(r5, 3, r7.getNext_state());
                    UDIcon.ADAPTER.j(r5, 2, r7.getUd_icon());
                    r1.j(r5, 1, r7.getAlt());
                }

                public b(FieldEncoding r7, KClass<DocState> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.DocStateButtonProperty.DocState", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ DocState(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DocState.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.alt;
                r0.e = this.ud_icon;
                r0.f = this.next_state;
                r0.g = this.ud_btn_color;
                r0.h = this.loading;
                r0.i = this.selected;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(DocState.class).getSimpleName() + '@' + hashCode();
            }

            public final String getAlt() {
                return this.alt;
            }

            public final Boolean getLoading() {
                return this.loading;
            }

            public final String getNext_state() {
                return this.next_state;
            }

            public final Boolean getSelected() {
                return this.selected;
            }

            public final String getUd_btn_color() {
                return this.ud_btn_color;
            }

            public final UDIcon getUd_icon() {
                return this.ud_icon;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public DocState(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.alt = r2.d;
                this.ud_icon = r2.e;
                this.next_state = r2.f;
                this.ud_btn_color = r2.g;
                this.loading = r2.h;
                this.selected = r2.i;
            }

            public /* synthetic */ DocState(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<DocStateButtonProperty, a> {
            public String d;
            public Map<String, DocState> e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DocStateButtonProperty(this, c(), null);
            }

            public a() {
                this.e = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ DocStateButtonProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(DocStateButtonProperty.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new URLPreviewComponent$DocStateButtonProperty$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.curr_state;
            r0.e = this.state_map;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DocStateButtonProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getCurr_state() {
            return this.curr_state;
        }

        public final Map<String, DocState> getState_map() {
            return this.state_map;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DocStateButtonProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.curr_state = r2.d;
            this.state_map = com.lark.wire.internal.a.d("state_map", r2.e);
        }

        public /* synthetic */ DocStateButtonProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EmptyProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EmptyProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EmptyProperty$Builder;Lokio/ByteString;)V", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "hover", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getHover", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "active", "getActive", "container_style", "getContainer_style", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class EmptyProperty extends com.lark.wire.Message<EmptyProperty, a> {
        public static final ProtoAdapter<EmptyProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final ThemeColor active;
        private final String container_style;
        private final ThemeColor hover;

        public static final class a extends com.lark.wire.Message.a<EmptyProperty, a> {
            public String d;
            public ThemeColor e;
            public ThemeColor f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new EmptyProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<EmptyProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final EmptyProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = ThemeColor.ADAPTER.c(r7);
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = ThemeColor.ADAPTER.c(r7);
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
                return new EmptyProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(EmptyProperty r6) {
                EmptyProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                int r2 = r0 + r1.l(1, r7.getAction_id());
                ProtoAdapter<ThemeColor> r3 = ThemeColor.ADAPTER;
                return ((r2 + r3.l(2, r7.getHover())) + r3.l(3, r7.getActive())) + r1.l(4, r7.getContainer_style());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, EmptyProperty r6) {
                EmptyProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getAction_id());
                ProtoAdapter<ThemeColor> r1 = ThemeColor.ADAPTER;
                r1.i(r5, 2, r7.getHover());
                r1.i(r5, 3, r7.getActive());
                r0.i(r5, 4, r7.getContainer_style());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, EmptyProperty r6) {
                EmptyProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 4, r7.getContainer_style());
                ProtoAdapter<ThemeColor> r1 = ThemeColor.ADAPTER;
                r1.j(r5, 3, r7.getActive());
                r1.j(r5, 2, r7.getHover());
                r0.j(r5, 1, r7.getAction_id());
            }

            public b(FieldEncoding r7, KClass<EmptyProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.EmptyProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ EmptyProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EmptyProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.action_id;
            r0.e = this.hover;
            r0.f = this.active;
            r0.g = this.container_style;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(EmptyProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final ThemeColor getActive() {
            return this.active;
        }

        public final String getContainer_style() {
            return this.container_style;
        }

        public final ThemeColor getHover() {
            return this.hover;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public EmptyProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.action_id = r2.d;
            this.hover = r2.e;
            this.active = r2.f;
            this.container_style = r2.g;
        }

        public /* synthetic */ EmptyProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EngineProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EngineProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EngineProperty$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EngineProperty$EngineType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EngineProperty$EngineType;", "body", "getBody", "()Lokio/ByteString;", "turtle_canvas", "Lcom/lark/kmp/pb/basic/v1/TurtleCanvasContent;", "getTurtle_canvas", "()Lcom/lark/kmp/pb/basic/v1/TurtleCanvasContent;", "newBuilder", "toString", "", "Builder", "Companion", "EngineType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class EngineProperty extends com.lark.wire.Message<EngineProperty, a> {
        public static final ProtoAdapter<EngineProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ByteString body;
        private final TurtleCanvasContent turtle_canvas;
        private final EngineType type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$EngineProperty$EngineType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MESSAGE", "DOC_COMPONENT", "TURTLE_CANVAS", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum EngineType extends Enum<EngineType> implements o0 {
            public static final ProtoAdapter<EngineType> ADAPTER = null;
            public static final b Companion = null;
            public static final EngineType DOC_COMPONENT = null;
            public static final EngineType MESSAGE = null;
            public static final EngineType TURTLE_CANVAS = null;
            public static final /* synthetic */ EngineType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<EngineType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    EngineType.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return EngineType.TURTLE_CANVAS;
                L15:
                    return EngineType.DOC_COMPONENT;
                L12:
                    return EngineType.MESSAGE;
                }

                public a(KClass<EngineType> r1, Syntax r2, EngineType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<EngineType> getEntries() {
                return b;
            }

            static {
                EngineType r0 = new EngineType("MESSAGE", 0, 0);
                MESSAGE = r0;
                EngineType r1 = new EngineType("DOC_COMPONENT", 1, 1);
                DOC_COMPONENT = r1;
                EngineType r3 = new EngineType("TURTLE_CANVAS", 2, 2);
                TURTLE_CANVAS = r3;
                EngineType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(EngineType.class), Syntax.PROTO_2, r0);
            }

            public static EngineType[] values() {
                return (EngineType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final EngineType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return TURTLE_CANVAS;
            L15:
                return DOC_COMPONENT;
            L12:
                return MESSAGE;
            }

            public static EngineType valueOf(String r1) {
                return (EngineType) r27.a.a(EngineType.class, r1);
            }

            public EngineType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<EngineProperty, a> {
            public EngineType d;
            public ByteString e;
            public TurtleCanvasContent f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new EngineProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<EngineProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final EngineProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                r1.d = EngineType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.p.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.f();
                goto L3
            L10:
                if (r4 != 100) goto L11;
                r1.f = TurtleCanvasContent.ADAPTER.c(r10);
                goto L3
            L11:
                r10.j(r4);
                goto L3
            L19:
                return new EngineProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(EngineProperty r5) {
                EngineProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + EngineType.ADAPTER.l(1, r6.getType())) + ProtoAdapter.p.l(2, r6.getBody())) + TurtleCanvasContent.ADAPTER.l(100, r6.getTurtle_canvas());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, EngineProperty r5) {
                EngineProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                EngineType.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.p.i(r4, 2, r6.getBody());
                TurtleCanvasContent.ADAPTER.i(r4, 100, r6.getTurtle_canvas());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, EngineProperty r5) {
                EngineProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                TurtleCanvasContent.ADAPTER.j(r4, 100, r6.getTurtle_canvas());
                ProtoAdapter.p.j(r4, 2, r6.getBody());
                EngineType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<EngineProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.EngineProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ EngineProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EngineProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.body;
            r0.f = this.turtle_canvas;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(EngineProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final ByteString getBody() {
            return this.body;
        }

        public final TurtleCanvasContent getTurtle_canvas() {
            return this.turtle_canvas;
        }

        public final EngineType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public EngineProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.body = r2.e;
            this.turtle_canvas = r2.f;
        }

        public /* synthetic */ EngineProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FlexLayoutProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FlexLayoutProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FlexLayoutProperty$Builder;Lokio/ByteString;)V", "orientation", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Orientation;", "getOrientation", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Orientation;", "flex_wrap", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FlexWrap;", "getFlex_wrap", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FlexWrap;", "main_axis_spacing", "", "getMain_axis_spacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "cross_axis_spacing", "getCross_axis_spacing", "padding", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding;", "getPadding", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding;", "main_axis_justify", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Justify;", "getMain_axis_justify", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Justify;", "cross_axis_align", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Align;", "getCross_axis_align", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Align;", "force_use_compact_mode", "", "getForce_use_compact_mode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class FlexLayoutProperty extends com.lark.wire.Message<FlexLayoutProperty, a> {
        public static final ProtoAdapter<FlexLayoutProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final Align DEFAULT_CROSS_AXIS_ALIGN = null;
        public static final FlexWrap DEFAULT_FLEX_WRAP = null;
        public static final boolean DEFAULT_FORCE_USE_COMPACT_MODE = false;
        public static final Justify DEFAULT_MAIN_AXIS_JUSTIFY = null;
        public static final Orientation DEFAULT_ORIENTATION = null;
        private static final long serialVersionUID = 0;
        private final Align cross_axis_align;
        private final Float cross_axis_spacing;
        private final FlexWrap flex_wrap;
        private final Boolean force_use_compact_mode;
        private final Justify main_axis_justify;
        private final Float main_axis_spacing;
        private final Orientation orientation;
        private final Padding padding;

        public static final class a extends com.lark.wire.Message.a<FlexLayoutProperty, a> {
            public Orientation d;
            public FlexWrap e;
            public Float f;
            public Float g;
            public Padding h;
            public Justify i;
            public Align j;
            public Boolean k;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new FlexLayoutProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<FlexLayoutProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final FlexLayoutProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L28;
                switch(r3) {
                    case 1: goto L31;
                    case 2: goto L33;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L35;
                    case 7: goto L29;
                    case 8: goto L7;
                    default: goto L6;
                };
            L29:
                r0.j = Align.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L31:
                r0.d = Orientation.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L33:
                r0.e = FlexWrap.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L35:
                r0.i = Justify.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L7:
                r0.k = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L16:
                r0.h = Padding.ADAPTER.c(r9);
                goto L3
            L17:
                r0.g = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L18:
                r0.f = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L6:
                r9.j(r3);
                goto L3
            L28:
                return new FlexLayoutProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(FlexLayoutProperty r5) {
                FlexLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = (r6.unknownFields().size() + Orientation.ADAPTER.l(1, r6.getOrientation())) + FlexWrap.ADAPTER.l(2, r6.getFlex_wrap());
                f r1 = ProtoAdapter.n;
                return (((((r0 + r1.l(3, r6.getMain_axis_spacing())) + r1.l(4, r6.getCross_axis_spacing())) + Padding.ADAPTER.l(5, r6.getPadding())) + Justify.ADAPTER.l(6, r6.getMain_axis_justify())) + Align.ADAPTER.l(7, r6.getCross_axis_align())) + ProtoAdapter.g.l(8, r6.getForce_use_compact_mode());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, FlexLayoutProperty r5) {
                FlexLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Orientation.ADAPTER.i(r4, 1, r6.getOrientation());
                FlexWrap.ADAPTER.i(r4, 2, r6.getFlex_wrap());
                f r0 = ProtoAdapter.n;
                r0.i(r4, 3, r6.getMain_axis_spacing());
                r0.i(r4, 4, r6.getCross_axis_spacing());
                Padding.ADAPTER.i(r4, 5, r6.getPadding());
                Justify.ADAPTER.i(r4, 6, r6.getMain_axis_justify());
                Align.ADAPTER.i(r4, 7, r6.getCross_axis_align());
                ProtoAdapter.g.i(r4, 8, r6.getForce_use_compact_mode());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, FlexLayoutProperty r5) {
                FlexLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 8, r6.getForce_use_compact_mode());
                Align.ADAPTER.j(r4, 7, r6.getCross_axis_align());
                Justify.ADAPTER.j(r4, 6, r6.getMain_axis_justify());
                Padding.ADAPTER.j(r4, 5, r6.getPadding());
                f r0 = ProtoAdapter.n;
                r0.j(r4, 4, r6.getCross_axis_spacing());
                r0.j(r4, 3, r6.getMain_axis_spacing());
                FlexWrap.ADAPTER.j(r4, 2, r6.getFlex_wrap());
                Orientation.ADAPTER.j(r4, 1, r6.getOrientation());
            }

            public b(FieldEncoding r7, KClass<FlexLayoutProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.FlexLayoutProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ FlexLayoutProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_ORIENTATION = Orientation.ROW;
            DEFAULT_FLEX_WRAP = FlexWrap.NO_WRAP;
            DEFAULT_MAIN_AXIS_JUSTIFY = Justify.START;
            DEFAULT_CROSS_AXIS_ALIGN = Align.TOP;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FlexLayoutProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.orientation;
            r0.e = this.flex_wrap;
            r0.f = this.main_axis_spacing;
            r0.g = this.cross_axis_spacing;
            r0.h = this.padding;
            r0.i = this.main_axis_justify;
            r0.j = this.cross_axis_align;
            r0.k = this.force_use_compact_mode;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(FlexLayoutProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Align getCross_axis_align() {
            return this.cross_axis_align;
        }

        public final Float getCross_axis_spacing() {
            return this.cross_axis_spacing;
        }

        public final FlexWrap getFlex_wrap() {
            return this.flex_wrap;
        }

        public final Boolean getForce_use_compact_mode() {
            return this.force_use_compact_mode;
        }

        public final Justify getMain_axis_justify() {
            return this.main_axis_justify;
        }

        public final Float getMain_axis_spacing() {
            return this.main_axis_spacing;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        public final Padding getPadding() {
            return this.padding;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public FlexLayoutProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.orientation = r2.d;
            this.flex_wrap = r2.e;
            this.main_axis_spacing = r2.f;
            this.cross_axis_spacing = r2.g;
            this.padding = r2.h;
            this.main_axis_justify = r2.i;
            this.cross_axis_align = r2.j;
            this.force_use_compact_mode = r2.k;
        }

        public /* synthetic */ FlexLayoutProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FlexWrap;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_WRAP", "WRAP", "WRAP_REVERSE", "LINEAR_WRAP", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FlexWrap extends Enum<FlexWrap> implements o0 {
        public static final ProtoAdapter<FlexWrap> ADAPTER = null;
        public static final b Companion = null;
        public static final FlexWrap LINEAR_WRAP = null;
        public static final FlexWrap NO_WRAP = null;
        public static final FlexWrap WRAP = null;
        public static final FlexWrap WRAP_REVERSE = null;
        public static final /* synthetic */ FlexWrap[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FlexWrap> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FlexWrap.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return FlexWrap.LINEAR_WRAP;
            L18:
                return FlexWrap.WRAP_REVERSE;
            L19:
                return FlexWrap.WRAP;
            L15:
                return FlexWrap.NO_WRAP;
            }

            public a(KClass<FlexWrap> r1, Syntax r2, FlexWrap r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FlexWrap> getEntries() {
            return b;
        }

        static {
            FlexWrap r0 = new FlexWrap("NO_WRAP", 0, 0);
            NO_WRAP = r0;
            FlexWrap r1 = new FlexWrap("WRAP", 1, 1);
            WRAP = r1;
            FlexWrap r3 = new FlexWrap("WRAP_REVERSE", 2, 2);
            WRAP_REVERSE = r3;
            FlexWrap r5 = new FlexWrap("LINEAR_WRAP", 3, 3);
            LINEAR_WRAP = r5;
            FlexWrap[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FlexWrap.class), Syntax.PROTO_2, r0);
        }

        public static FlexWrap[] values() {
            return (FlexWrap[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FlexWrap fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return LINEAR_WRAP;
        L18:
            return WRAP_REVERSE;
        L19:
            return WRAP;
        L15:
            return NO_WRAP;
        }

        public static FlexWrap valueOf(String r1) {
            return (FlexWrap) r27.a.a(FlexWrap.class, r1);
        }

        public FlexWrap(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontLevel;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontLevel$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontLevel$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontType;", "level", "", "getLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class FontLevel extends com.lark.wire.Message<FontLevel, a> {
        public static final ProtoAdapter<FontLevel> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_LEVEL = 0;
        public static final FontType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        private final Integer level;
        private final FontType type;

        public static final class a extends com.lark.wire.Message.a<FontLevel, a> {
            public FontType d;
            public Integer e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new FontLevel(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<FontLevel> {
            @Override // com.lark.wire.ProtoAdapter
            public final FontLevel c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = FontType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
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
                return new FontLevel(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(FontLevel r5) {
                FontLevel r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + FontType.ADAPTER.l(1, r6.getType())) + ProtoAdapter.h.l(2, r6.getLevel());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, FontLevel r5) {
                FontLevel r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                FontType.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.h.i(r4, 2, r6.getLevel());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, FontLevel r5) {
                FontLevel r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 2, r6.getLevel());
                FontType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<FontLevel> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.FontLevel", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ FontLevel(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_TYPE = FontType.CAPTION;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FontLevel.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.level;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(FontLevel.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getLevel() {
            return this.level;
        }

        public final FontType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public FontLevel(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.level = r2.e;
        }

        public /* synthetic */ FontLevel(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TITLE", "HEADLINE", "BODY", "CAPTION", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FontType extends Enum<FontType> implements o0 {
        public static final ProtoAdapter<FontType> ADAPTER = null;
        public static final FontType BODY = null;
        public static final FontType CAPTION = null;
        public static final b Companion = null;
        public static final FontType HEADLINE = null;
        public static final FontType TITLE = null;
        public static final /* synthetic */ FontType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FontType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FontType.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return FontType.CAPTION;
            L18:
                return FontType.BODY;
            L19:
                return FontType.HEADLINE;
            L15:
                return FontType.TITLE;
            }

            public a(KClass<FontType> r1, Syntax r2, FontType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FontType> getEntries() {
            return b;
        }

        static {
            FontType r0 = new FontType("TITLE", 0, 0);
            TITLE = r0;
            FontType r1 = new FontType("HEADLINE", 1, 1);
            HEADLINE = r1;
            FontType r3 = new FontType("BODY", 2, 2);
            BODY = r3;
            FontType r5 = new FontType("CAPTION", 3, 3);
            CAPTION = r5;
            FontType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FontType.class), Syntax.PROTO_2, r0);
        }

        public static FontType[] values() {
            return (FontType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FontType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return CAPTION;
        L18:
            return BODY;
        L19:
            return HEADLINE;
        L15:
            return TITLE;
        }

        public static FontType valueOf(String r1) {
            return (FontType) r27.a.a(FontType.class, r1);
        }

        public FontType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$IconButtonProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$IconButtonProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$IconButtonProperty$Builder;Lokio/ByteString;)V", "icon", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "is_disable", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "alt", "getAlt", "ud_icon", "Lcom/lark/kmp/pb/basic/v1/UDIcon;", "getUd_icon", "()Lcom/lark/kmp/pb/basic/v1/UDIcon;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class IconButtonProperty extends com.lark.wire.Message<IconButtonProperty, a> {
        public static final ProtoAdapter<IconButtonProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final String alt;
        private final ImageSet icon;
        private final Boolean is_disable;
        private final UDIcon ud_icon;

        public static final class a extends com.lark.wire.Message.a<IconButtonProperty, a> {
            public ImageSet d;
            public String e;
            public Boolean f;
            public String g;
            public UDIcon h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new IconButtonProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<IconButtonProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final IconButtonProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                r1.d = ImageSet.ADAPTER.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L12:
                if (r4 != 4) goto L14;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L14:
                if (r4 != 5) goto L15;
                r1.h = UDIcon.ADAPTER.c(r7);
                goto L3
            L15:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L22:
                return new IconButtonProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(IconButtonProperty r6) {
                IconButtonProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size() + ImageSet.ADAPTER.l(1, r7.getIcon());
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(2, r7.getAction_id())) + ProtoAdapter.g.l(3, r7.is_disable())) + r1.l(4, r7.getAlt())) + UDIcon.ADAPTER.l(5, r7.getUd_icon());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, IconButtonProperty r6) {
                IconButtonProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                ImageSet.ADAPTER.i(r5, 1, r7.getIcon());
                w r0 = ProtoAdapter.q;
                r0.i(r5, 2, r7.getAction_id());
                ProtoAdapter.g.i(r5, 3, r7.is_disable());
                r0.i(r5, 4, r7.getAlt());
                UDIcon.ADAPTER.i(r5, 5, r7.getUd_icon());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, IconButtonProperty r6) {
                IconButtonProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                UDIcon.ADAPTER.j(r5, 5, r7.getUd_icon());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 4, r7.getAlt());
                ProtoAdapter.g.j(r5, 3, r7.is_disable());
                r0.j(r5, 2, r7.getAction_id());
                ImageSet.ADAPTER.j(r5, 1, r7.getIcon());
            }

            public b(FieldEncoding r7, KClass<IconButtonProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.IconButtonProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ IconButtonProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(IconButtonProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.icon;
            r0.e = this.action_id;
            r0.f = this.is_disable;
            r0.g = this.alt;
            r0.h = this.ud_icon;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(IconButtonProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final String getAlt() {
            return this.alt;
        }

        public final ImageSet getIcon() {
            return this.icon;
        }

        public final UDIcon getUd_icon() {
            return this.ud_icon;
        }

        public final Boolean is_disable() {
            return this.is_disable;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public IconButtonProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.icon = r2.d;
            this.action_id = r2.e;
            this.is_disable = r2.f;
            this.alt = r2.g;
            this.ud_icon = r2.h;
        }

        public /* synthetic */ IconButtonProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageContainerProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageContainerProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageContainerProperty$Builder;Lokio/ByteString;)V", "background", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getBackground", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "content_mode", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageContainerProperty$ContentMode;", "getContent_mode", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageContainerProperty$ContentMode;", "dm_background", "getDm_background", "newBuilder", "toString", "Builder", "Companion", "ContentMode", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ImageContainerProperty extends com.lark.wire.Message<ImageContainerProperty, a> {
        public static final ProtoAdapter<ImageContainerProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final ImageSet background;
        private final ContentMode content_mode;
        private final ImageSet dm_background;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageContainerProperty$ContentMode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SCALE_TO_FILL", "SCALE_ASPECT_FIT", "SCALE_ASPECT_FILL", "CENTER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum ContentMode extends Enum<ContentMode> implements o0 {
            public static final ProtoAdapter<ContentMode> ADAPTER = null;
            public static final ContentMode CENTER = null;
            public static final b Companion = null;
            public static final ContentMode SCALE_ASPECT_FILL = null;
            public static final ContentMode SCALE_ASPECT_FIT = null;
            public static final ContentMode SCALE_TO_FILL = null;
            public static final /* synthetic */ ContentMode[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<ContentMode> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    ContentMode.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
                    return null;
                L17:
                    return ContentMode.CENTER;
                L18:
                    return ContentMode.SCALE_ASPECT_FILL;
                L19:
                    return ContentMode.SCALE_ASPECT_FIT;
                L15:
                    return ContentMode.SCALE_TO_FILL;
                }

                public a(KClass<ContentMode> r1, Syntax r2, ContentMode r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<ContentMode> getEntries() {
                return b;
            }

            static {
                ContentMode r0 = new ContentMode("SCALE_TO_FILL", 0, 0);
                SCALE_TO_FILL = r0;
                ContentMode r1 = new ContentMode("SCALE_ASPECT_FIT", 1, 1);
                SCALE_ASPECT_FIT = r1;
                ContentMode r3 = new ContentMode("SCALE_ASPECT_FILL", 2, 2);
                SCALE_ASPECT_FILL = r3;
                ContentMode r5 = new ContentMode("CENTER", 3, 3);
                CENTER = r5;
                ContentMode[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(ContentMode.class), Syntax.PROTO_2, r0);
            }

            public static ContentMode[] values() {
                return (ContentMode[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final ContentMode fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
                return null;
            L17:
                return CENTER;
            L18:
                return SCALE_ASPECT_FILL;
            L19:
                return SCALE_ASPECT_FIT;
            L15:
                return SCALE_TO_FILL;
            }

            public static ContentMode valueOf(String r1) {
                return (ContentMode) r27.a.a(ContentMode.class, r1);
            }

            public ContentMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ImageContainerProperty, a> {
            public ImageSet d;
            public String e;
            public ContentMode f;
            public ImageSet g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ImageContainerProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ImageContainerProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ImageContainerProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                r1.d = ImageSet.ADAPTER.c(r10);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = ContentMode.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r1.g = ImageSet.ADAPTER.c(r10);
                goto L3
            L13:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L22:
                return new ImageContainerProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ImageContainerProperty r6) {
                ImageContainerProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                ProtoAdapter<ImageSet> r1 = ImageSet.ADAPTER;
                return (((r0 + r1.l(1, r7.getBackground())) + ProtoAdapter.q.l(2, r7.getAction_id())) + ContentMode.ADAPTER.l(3, r7.getContent_mode())) + r1.l(4, r7.getDm_background());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ImageContainerProperty r6) {
                ImageContainerProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                ProtoAdapter<ImageSet> r0 = ImageSet.ADAPTER;
                r0.i(r5, 1, r7.getBackground());
                ProtoAdapter.q.i(r5, 2, r7.getAction_id());
                ContentMode.ADAPTER.i(r5, 3, r7.getContent_mode());
                r0.i(r5, 4, r7.getDm_background());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ImageContainerProperty r6) {
                ImageContainerProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ProtoAdapter<ImageSet> r0 = ImageSet.ADAPTER;
                r0.j(r5, 4, r7.getDm_background());
                ContentMode.ADAPTER.j(r5, 3, r7.getContent_mode());
                ProtoAdapter.q.j(r5, 2, r7.getAction_id());
                r0.j(r5, 1, r7.getBackground());
            }

            public b(FieldEncoding r7, KClass<ImageContainerProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.ImageContainerProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ImageContainerProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageContainerProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.background;
            r0.e = this.action_id;
            r0.f = this.content_mode;
            r0.g = this.dm_background;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ImageContainerProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final ImageSet getBackground() {
            return this.background;
        }

        public final ContentMode getContent_mode() {
            return this.content_mode;
        }

        public final ImageSet getDm_background() {
            return this.dm_background;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ImageContainerProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.background = r2.d;
            this.action_id = r2.e;
            this.content_mode = r2.f;
            this.dm_background = r2.g;
        }

        public /* synthetic */ ImageContainerProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ImageProperty$Builder;Lokio/ByteString;)V", "image", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "alt", "", "getAlt", "()Ljava/lang/String;", "ud_icon", "Lcom/lark/kmp/pb/basic/v1/UDIcon;", "getUd_icon", "()Lcom/lark/kmp/pb/basic/v1/UDIcon;", "image_url", "getImage_url", "dm_image", "getDm_image", "dm_image_url", "getDm_image_url", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ImageProperty extends com.lark.wire.Message<ImageProperty, a> {
        public static final ProtoAdapter<ImageProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String alt;
        private final ImageSet dm_image;
        private final String dm_image_url;
        private final ImageSet image;
        private final String image_url;
        private final UDIcon ud_icon;

        public static final class a extends com.lark.wire.Message.a<ImageProperty, a> {
            public ImageSet d;
            public String e;
            public UDIcon f;
            public String g;
            public ImageSet h;
            public String i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ImageProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ImageProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final ImageProperty c(g0 r7) {
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
                r1.h = ImageSet.ADAPTER.c(r7);
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L10:
                r1.f = UDIcon.ADAPTER.c(r7);
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L12:
                r1.d = ImageSet.ADAPTER.c(r7);
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L14:
                return new ImageProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ImageProperty r7) {
                ImageProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r8, "value");
                int r0 = r8.unknownFields().size();
                ProtoAdapter<ImageSet> r1 = ImageSet.ADAPTER;
                int r2 = r0 + r1.l(1, r8.getImage());
                w r3 = ProtoAdapter.q;
                return ((((r2 + r3.l(2, r8.getAlt())) + UDIcon.ADAPTER.l(3, r8.getUd_icon())) + r3.l(4, r8.getImage_url())) + r1.l(5, r8.getDm_image())) + r3.l(6, r8.getDm_image_url());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r6, ImageProperty r7) {
                ImageProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                ProtoAdapter<ImageSet> r0 = ImageSet.ADAPTER;
                r0.i(r6, 1, r8.getImage());
                w r1 = ProtoAdapter.q;
                r1.i(r6, 2, r8.getAlt());
                UDIcon.ADAPTER.i(r6, 3, r8.getUd_icon());
                r1.i(r6, 4, r8.getImage_url());
                r0.i(r6, 5, r8.getDm_image());
                r1.i(r6, 6, r8.getDm_image_url());
                r6.a(r8.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r6, ImageProperty r7) {
                ImageProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                r6.d(r8.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r6, 6, r8.getDm_image_url());
                ProtoAdapter<ImageSet> r1 = ImageSet.ADAPTER;
                r1.j(r6, 5, r8.getDm_image());
                r0.j(r6, 4, r8.getImage_url());
                UDIcon.ADAPTER.j(r6, 3, r8.getUd_icon());
                r0.j(r6, 2, r8.getAlt());
                r1.j(r6, 1, r8.getImage());
            }

            public b(FieldEncoding r7, KClass<ImageProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.ImageProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ImageProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.image;
            r0.e = this.alt;
            r0.f = this.ud_icon;
            r0.g = this.image_url;
            r0.h = this.dm_image;
            r0.i = this.dm_image_url;
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

        public final ImageSet getDm_image() {
            return this.dm_image;
        }

        public final String getDm_image_url() {
            return this.dm_image_url;
        }

        public final ImageSet getImage() {
            return this.image;
        }

        public final String getImage_url() {
            return this.image_url;
        }

        public final UDIcon getUd_icon() {
            return this.ud_icon;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ImageProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.image = r2.d;
            this.alt = r2.e;
            this.ud_icon = r2.f;
            this.image_url = r2.g;
            this.dm_image = r2.h;
            this.dm_image_url = r2.i;
        }

        public /* synthetic */ ImageProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Item;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Item$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Item$Builder;Lokio/ByteString;)V", CardActionService.ACTION_ID, "", "getAction_id", "()Ljava/lang/String;", "text", "getText", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Item extends com.lark.wire.Message<Item, a> {
        public static final ProtoAdapter<Item> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final String text;

        public static final class a extends com.lark.wire.Message.a<Item, a> {
            public String d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Item(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Item> {
            @Override // com.lark.wire.ProtoAdapter
            public final Item c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new Item(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Item r5) {
                Item r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getAction_id())) + r1.l(2, r6.getText());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Item r5) {
                Item r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getAction_id());
                r0.i(r4, 2, r6.getText());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Item r5) {
                Item r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getText());
                r0.j(r4, 1, r6.getAction_id());
            }

            public b(FieldEncoding r7, KClass<Item> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.Item", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Item(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Item.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.action_id;
            r0.e = this.text;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Item.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final String getText() {
            return this.text;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Item(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.action_id = r2.d;
            this.text = r2.e;
        }

        public /* synthetic */ Item(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Justify;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "START", "CENTER", "END", "SPACE_BETWEEN", "SPACE_ARROUND", "SPACE_EVENLY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Justify extends Enum<Justify> implements o0 {
        public static final ProtoAdapter<Justify> ADAPTER = null;
        public static final Justify CENTER = null;
        public static final b Companion = null;
        public static final Justify END = null;
        public static final Justify SPACE_ARROUND = null;
        public static final Justify SPACE_BETWEEN = null;
        public static final Justify SPACE_EVENLY = null;
        public static final Justify START = null;
        public static final /* synthetic */ Justify[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Justify> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Justify.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Justify> r1, Syntax r2, Justify r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Justify a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 5) goto L22;
                return null;
            L22:
                return Justify.SPACE_EVENLY;
            L23:
                return Justify.SPACE_ARROUND;
            L24:
                return Justify.SPACE_BETWEEN;
            L25:
                return Justify.END;
            L26:
                return Justify.CENTER;
            L20:
                return Justify.START;
            }
        }

        @JvmStatic
        public static final Justify fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Justify> getEntries() {
            return b;
        }

        static {
            Justify r0 = new Justify("START", 0, 0);
            START = r0;
            Justify r1 = new Justify("CENTER", 1, 1);
            CENTER = r1;
            Justify r3 = new Justify("END", 2, 2);
            END = r3;
            Justify r5 = new Justify("SPACE_BETWEEN", 3, 3);
            SPACE_BETWEEN = r5;
            Justify r7 = new Justify("SPACE_ARROUND", 4, 4);
            SPACE_ARROUND = r7;
            Justify r9 = new Justify("SPACE_EVENLY", 5, 5);
            SPACE_EVENLY = r9;
            Justify[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Justify.class), Syntax.PROTO_2, r0);
        }

        public static Justify[] values() {
            return (Justify[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Justify valueOf(String r1) {
            return (Justify) r27.a.a(Justify.class, r1);
        }

        public Justify(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LinearLayoutProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LinearLayoutProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LinearLayoutProperty$Builder;Lokio/ByteString;)V", "orientation", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Orientation;", "getOrientation", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Orientation;", "spacing", "", "getSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "wrap_width", "getWrap_width", "padding", "getPadding", "main_axis_justify", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Justify;", "getMain_axis_justify", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Justify;", "cross_axis_align", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Align;", "getCross_axis_align", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Align;", "side_padding", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding;", "getSide_padding", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LinearLayoutProperty extends com.lark.wire.Message<LinearLayoutProperty, a> {
        public static final ProtoAdapter<LinearLayoutProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final Align DEFAULT_CROSS_AXIS_ALIGN = null;
        public static final Justify DEFAULT_MAIN_AXIS_JUSTIFY = null;
        public static final Orientation DEFAULT_ORIENTATION = null;
        private static final long serialVersionUID = 0;
        private final Align cross_axis_align;
        private final Justify main_axis_justify;
        private final Orientation orientation;
        private final Float padding;
        private final Padding side_padding;
        private final Float spacing;
        private final Float wrap_width;

        public static final class a extends com.lark.wire.Message.a<LinearLayoutProperty, a> {
            public Orientation d;
            public Float e;
            public Float f;
            public Float g;
            public Justify h;
            public Align i;
            public Padding j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LinearLayoutProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LinearLayoutProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final LinearLayoutProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L24;
                switch(r3) {
                    case 1: goto L27;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L29;
                    case 6: goto L25;
                    case 7: goto L7;
                    default: goto L6;
                };
            L25:
                r0.i = Align.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L27:
                r0.d = Orientation.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L29:
                r0.h = Justify.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L7:
                r0.j = Padding.ADAPTER.c(r9);
                goto L3
            L16:
                r0.g = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L17:
                r0.f = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L18:
                r0.e = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L6:
                r9.j(r3);
                goto L3
            L24:
                return new LinearLayoutProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LinearLayoutProperty r5) {
                LinearLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + Orientation.ADAPTER.l(1, r6.getOrientation());
                f r1 = ProtoAdapter.n;
                return (((((r0 + r1.l(2, r6.getSpacing())) + r1.l(3, r6.getWrap_width())) + r1.l(4, r6.getPadding())) + Justify.ADAPTER.l(5, r6.getMain_axis_justify())) + Align.ADAPTER.l(6, r6.getCross_axis_align())) + Padding.ADAPTER.l(7, r6.getSide_padding());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LinearLayoutProperty r5) {
                LinearLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Orientation.ADAPTER.i(r4, 1, r6.getOrientation());
                f r0 = ProtoAdapter.n;
                r0.i(r4, 2, r6.getSpacing());
                r0.i(r4, 3, r6.getWrap_width());
                r0.i(r4, 4, r6.getPadding());
                Justify.ADAPTER.i(r4, 5, r6.getMain_axis_justify());
                Align.ADAPTER.i(r4, 6, r6.getCross_axis_align());
                Padding.ADAPTER.i(r4, 7, r6.getSide_padding());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, LinearLayoutProperty r5) {
                LinearLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                Padding.ADAPTER.j(r4, 7, r6.getSide_padding());
                Align.ADAPTER.j(r4, 6, r6.getCross_axis_align());
                Justify.ADAPTER.j(r4, 5, r6.getMain_axis_justify());
                f r0 = ProtoAdapter.n;
                r0.j(r4, 4, r6.getPadding());
                r0.j(r4, 3, r6.getWrap_width());
                r0.j(r4, 2, r6.getSpacing());
                Orientation.ADAPTER.j(r4, 1, r6.getOrientation());
            }

            public b(FieldEncoding r7, KClass<LinearLayoutProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.LinearLayoutProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LinearLayoutProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_ORIENTATION = Orientation.ROW;
            DEFAULT_MAIN_AXIS_JUSTIFY = Justify.START;
            DEFAULT_CROSS_AXIS_ALIGN = Align.TOP;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LinearLayoutProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.orientation;
            r0.e = this.spacing;
            r0.f = this.wrap_width;
            r0.g = this.padding;
            r0.h = this.main_axis_justify;
            r0.i = this.cross_axis_align;
            r0.j = this.side_padding;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LinearLayoutProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Align getCross_axis_align() {
            return this.cross_axis_align;
        }

        public final Justify getMain_axis_justify() {
            return this.main_axis_justify;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        public final Float getPadding() {
            return this.padding;
        }

        public final Padding getSide_padding() {
            return this.side_padding;
        }

        public final Float getSpacing() {
            return this.spacing;
        }

        public final Float getWrap_width() {
            return this.wrap_width;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LinearLayoutProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.orientation = r2.d;
            this.spacing = r2.e;
            this.wrap_width = r2.f;
            this.padding = r2.g;
            this.main_axis_justify = r2.h;
            this.cross_axis_align = r2.i;
            this.side_padding = r2.j;
        }

        public /* synthetic */ LinearLayoutProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LoadingProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LoadingProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$LoadingProperty$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LoadingProperty extends com.lark.wire.Message<LoadingProperty, a> {
        public static final ProtoAdapter<LoadingProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;

        public static final class a extends com.lark.wire.Message.a<LoadingProperty, a> {
            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LoadingProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LoadingProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final LoadingProperty c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L7;
                r6.j(r3);
                goto L3
            L7:
                return new LoadingProperty(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LoadingProperty r2) {
                LoadingProperty r3 = r2;
                Intrinsics.checkNotNullParameter(r3, "value");
                return r3.unknownFields().size();
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r2, LoadingProperty r3) {
                LoadingProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.a(r4.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r2, LoadingProperty r3) {
                LoadingProperty r4 = r3;
                Intrinsics.checkNotNullParameter(r2, "writer");
                Intrinsics.checkNotNullParameter(r4, "value");
                r2.d(r4.unknownFields());
            }

            public b(FieldEncoding r7, KClass<LoadingProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.LoadingProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LoadingProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LoadingProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LoadingProperty.class).getSimpleName() + '@' + hashCode();
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LoadingProperty(ByteString r2) {
            super(ADAPTER, r2);
        }

        public /* synthetic */ LoadingProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Orientation;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ROW", "COLUMN", "ROW_REVERSE", "COLUMN_REVERSE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Orientation extends Enum<Orientation> implements o0 {
        public static final ProtoAdapter<Orientation> ADAPTER = null;
        public static final Orientation COLUMN = null;
        public static final Orientation COLUMN_REVERSE = null;
        public static final b Companion = null;
        public static final Orientation ROW = null;
        public static final Orientation ROW_REVERSE = null;
        public static final /* synthetic */ Orientation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Orientation> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Orientation.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return Orientation.COLUMN_REVERSE;
            L18:
                return Orientation.ROW_REVERSE;
            L19:
                return Orientation.COLUMN;
            L15:
                return Orientation.ROW;
            }

            public a(KClass<Orientation> r1, Syntax r2, Orientation r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Orientation> getEntries() {
            return b;
        }

        static {
            Orientation r0 = new Orientation("ROW", 0, 0);
            ROW = r0;
            Orientation r1 = new Orientation("COLUMN", 1, 1);
            COLUMN = r1;
            Orientation r3 = new Orientation("ROW_REVERSE", 2, 2);
            ROW_REVERSE = r3;
            Orientation r5 = new Orientation("COLUMN_REVERSE", 3, 3);
            COLUMN_REVERSE = r5;
            Orientation[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Orientation.class), Syntax.PROTO_2, r0);
        }

        public static Orientation[] values() {
            return (Orientation[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Orientation fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return COLUMN_REVERSE;
        L18:
            return ROW_REVERSE;
        L19:
            return COLUMN;
        L15:
            return ROW;
        }

        public static Orientation valueOf(String r1) {
            return (Orientation) r27.a.a(Orientation.class, r1);
        }

        public Orientation(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$OversizedTextProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$OversizedTextProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$OversizedTextProperty$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "number_of_lines", "", "getNumber_of_lines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "font_size", "getFont_size", "font_weight", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$OversizedTextProperty$FontWeight;", "getFont_weight", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$OversizedTextProperty$FontWeight;", "newBuilder", "toString", "Builder", "Companion", "FontWeight", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class OversizedTextProperty extends com.lark.wire.Message<OversizedTextProperty, a> {
        public static final ProtoAdapter<OversizedTextProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_FONT_SIZE = 36;
        public static final FontWeight DEFAULT_FONT_WEIGHT = null;
        public static final int DEFAULT_NUMBER_OF_LINES = 0;
        private static final long serialVersionUID = 0;
        private final Integer font_size;
        private final FontWeight font_weight;
        private final Integer number_of_lines;
        private final String text;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$OversizedTextProperty$FontWeight;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "REGULAR", "SEMI_BOLD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum FontWeight extends Enum<FontWeight> implements o0 {
            public static final ProtoAdapter<FontWeight> ADAPTER = null;
            public static final b Companion = null;
            public static final FontWeight REGULAR = null;
            public static final FontWeight SEMI_BOLD = null;
            public static final /* synthetic */ FontWeight[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<FontWeight> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    FontWeight.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return FontWeight.SEMI_BOLD;
                L9:
                    return FontWeight.REGULAR;
                }

                public a(KClass<FontWeight> r1, Syntax r2, FontWeight r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<FontWeight> getEntries() {
                return b;
            }

            static {
                FontWeight r0 = new FontWeight("REGULAR", 0, 0);
                REGULAR = r0;
                FontWeight r1 = new FontWeight("SEMI_BOLD", 1, 1);
                SEMI_BOLD = r1;
                FontWeight[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(FontWeight.class), Syntax.PROTO_2, r0);
            }

            public static FontWeight[] values() {
                return (FontWeight[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final FontWeight fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return SEMI_BOLD;
            L9:
                return REGULAR;
            }

            public static FontWeight valueOf(String r1) {
                return (FontWeight) r27.a.a(FontWeight.class, r1);
            }

            public FontWeight(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<OversizedTextProperty, a> {
            public String d;
            public Integer e;
            public Integer f;
            public FontWeight g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new OversizedTextProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<OversizedTextProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final OversizedTextProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r1.g = FontWeight.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L22:
                return new OversizedTextProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(OversizedTextProperty r5) {
                OversizedTextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getText());
                s r1 = ProtoAdapter.h;
                return ((r0 + r1.l(2, r6.getNumber_of_lines())) + r1.l(3, r6.getFont_size())) + FontWeight.ADAPTER.l(4, r6.getFont_weight());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, OversizedTextProperty r5) {
                OversizedTextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getText());
                s r0 = ProtoAdapter.h;
                r0.i(r4, 2, r6.getNumber_of_lines());
                r0.i(r4, 3, r6.getFont_size());
                FontWeight.ADAPTER.i(r4, 4, r6.getFont_weight());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, OversizedTextProperty r5) {
                OversizedTextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                FontWeight.ADAPTER.j(r4, 4, r6.getFont_weight());
                s r0 = ProtoAdapter.h;
                r0.j(r4, 3, r6.getFont_size());
                r0.j(r4, 2, r6.getNumber_of_lines());
                ProtoAdapter.q.j(r4, 1, r6.getText());
            }

            public b(FieldEncoding r7, KClass<OversizedTextProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.OversizedTextProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ OversizedTextProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_FONT_WEIGHT = FontWeight.REGULAR;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OversizedTextProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.text;
            r0.e = this.number_of_lines;
            r0.f = this.font_size;
            r0.g = this.font_weight;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(OversizedTextProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getFont_size() {
            return this.font_size;
        }

        public final FontWeight getFont_weight() {
            return this.font_weight;
        }

        public final Integer getNumber_of_lines() {
            return this.number_of_lines;
        }

        public final String getText() {
            return this.text;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public OversizedTextProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.text = r2.d;
            this.number_of_lines = r2.e;
            this.font_size = r2.f;
            this.font_weight = r2.g;
        }

        public /* synthetic */ OversizedTextProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding$Builder;Lokio/ByteString;)V", "top", "", "getTop", "()Ljava/lang/Float;", "Ljava/lang/Float;", "right", "getRight", "bottom", "getBottom", "left", "getLeft", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Padding extends com.lark.wire.Message<Padding, a> {
        public static final ProtoAdapter<Padding> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Float bottom;
        private final Float left;
        private final Float right;
        private final Float top;

        public static final class a extends com.lark.wire.Message.a<Padding, a> {
            public Float d;
            public Float e;
            public Float f;
            public Float g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Padding(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Padding> {
            @Override // com.lark.wire.ProtoAdapter
            public final Padding c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = (Float) ProtoAdapter.n.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Float) ProtoAdapter.n.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.f = (Float) ProtoAdapter.n.c(r6);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.g = (Float) ProtoAdapter.n.c(r6);
                goto L3
            L13:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L19:
                return new Padding(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Padding r5) {
                Padding r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                f r1 = ProtoAdapter.n;
                return (((r0 + r1.l(1, r6.getTop())) + r1.l(2, r6.getRight())) + r1.l(3, r6.getBottom())) + r1.l(4, r6.getLeft());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Padding r5) {
                Padding r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                f r0 = ProtoAdapter.n;
                r0.i(r4, 1, r6.getTop());
                r0.i(r4, 2, r6.getRight());
                r0.i(r4, 3, r6.getBottom());
                r0.i(r4, 4, r6.getLeft());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Padding r5) {
                Padding r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                f r0 = ProtoAdapter.n;
                r0.j(r4, 4, r6.getLeft());
                r0.j(r4, 3, r6.getBottom());
                r0.j(r4, 2, r6.getRight());
                r0.j(r4, 1, r6.getTop());
            }

            public b(FieldEncoding r7, KClass<Padding> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.Padding", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Padding(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Padding.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.top;
            r0.e = this.right;
            r0.f = this.bottom;
            r0.g = this.left;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Padding.class).getSimpleName() + '@' + hashCode();
        }

        public final Float getBottom() {
            return this.bottom;
        }

        public final Float getLeft() {
            return this.left;
        }

        public final Float getRight() {
            return this.right;
        }

        public final Float getTop() {
            return this.top;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Padding(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.top = r2.d;
            this.right = r2.e;
            this.bottom = r2.f;
            this.left = r2.g;
        }

        public /* synthetic */ Padding(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 ?2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003>?@B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010<\u001a\u00020\u0002H\u0016J\b\u0010=\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0016\u0010\u0018R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010)\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000fR\u0013\u0010+\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000fR\u0013\u0010-\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0013\u0010/\u001a\u0004\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u00103\u001a\u0004\u0018\u000104¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0015\u00108\u001a\u0004\u0018\u000104¢\u0006\n\n\u0002\u00107\u001a\u0004\b9\u00106R\u0013\u0010:\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000b¨\u0006A"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$PreviewHeaderProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$PreviewHeaderProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$PreviewHeaderProperty$Builder;Lokio/ByteString;)V", "icon_key", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getIcon_key", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "title", "", "getTitle", "()Ljava/lang/String;", "lark_tag", "Lcom/lark/kmp/pb/basic/v1/Tag;", "getLark_tag", "()Lcom/lark/kmp/pb/basic/v1/Tag;", "child_component_id", "getChild_component_id", "is_need_copy_link", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_need_close", "theme", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Theme;", "getTheme", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Theme;", "type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$PreviewHeaderProperty$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$PreviewHeaderProperty$Type;", "tag_color", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getTag_color", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "tag_text_color", "getTag_text_color", "header_tag", "getHeader_tag", "favicon_url", "getFavicon_url", "icon_color", "getIcon_color", "ud_icon", "Lcom/lark/kmp/pb/basic/v1/UDIcon;", "getUd_icon", "()Lcom/lark/kmp/pb/basic/v1/UDIcon;", "number_of_lines", "", "getNumber_of_lines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "icon_size", "getIcon_size", "dm_icon", "getDm_icon", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PreviewHeaderProperty extends com.lark.wire.Message<PreviewHeaderProperty, a> {
        public static final ProtoAdapter<PreviewHeaderProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_IS_NEED_CLOSE = true;
        public static final boolean DEFAULT_IS_NEED_COPY_LINK = true;
        public static final int DEFAULT_NUMBER_OF_LINES = 3;
        public static final Theme DEFAULT_THEME = null;
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        private final String child_component_id;
        private final ImageSet dm_icon;
        private final String favicon_url;
        private final String header_tag;
        private final ThemeColor icon_color;
        private final ImageSet icon_key;
        private final Integer icon_size;
        private final Boolean is_need_close;
        private final Boolean is_need_copy_link;
        private final Tag lark_tag;
        private final Integer number_of_lines;
        private final ThemeColor tag_color;
        private final ThemeColor tag_text_color;
        private final Theme theme;
        private final String title;
        private final Type type;
        private final UDIcon ud_icon;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$PreviewHeaderProperty$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "HEADLINES", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final b Companion = null;
            public static final Type HEADLINES = null;
            public static final Type NORMAL = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return Type.HEADLINES;
                L9:
                    return Type.NORMAL;
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
                Type r0 = new Type("NORMAL", 0, 0);
                NORMAL = r0;
                Type r1 = new Type("HEADLINES", 1, 1);
                HEADLINES = r1;
                Type[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
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
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return HEADLINES;
            L9:
                return NORMAL;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<PreviewHeaderProperty, a> {
            public ImageSet d;
            public String e;
            public Tag f;
            public String g;
            public Boolean h;
            public Boolean i;
            public Theme j;
            public Type k;
            public ThemeColor l;
            public ThemeColor m;
            public String n;
            public String o;
            public ThemeColor p;
            public UDIcon q;
            public Integer r;
            public Integer s;
            public ImageSet t;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PreviewHeaderProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PreviewHeaderProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final PreviewHeaderProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L34;
                switch(r4) {
                    case 1: goto L32;
                    case 2: goto L31;
                    case 3: goto L39;
                    case 4: goto L26;
                    case 5: goto L25;
                    case 6: goto L24;
                    case 7: goto L35;
                    case 8: goto L37;
                    case 9: goto L15;
                    case 10: goto L14;
                    case 11: goto L13;
                    case 12: goto L12;
                    case 13: goto L11;
                    case 14: goto L10;
                    case 15: goto L9;
                    case 16: goto L8;
                    case 17: goto L7;
                    default: goto L6;
                };
            L35:
                r1.j = Theme.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L37:
                r1.k = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L39:
                r1.f = Tag.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
            L29:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L7:
                r1.t = ImageSet.ADAPTER.c(r10);
                goto L3
            L8:
                r1.s = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L9:
                r1.r = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L10:
                r1.q = UDIcon.ADAPTER.c(r10);
                goto L3
            L11:
                r1.p = ThemeColor.ADAPTER.c(r10);
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.o = r10.i();
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.n = r10.i();
                goto L3
            L14:
                r1.m = ThemeColor.ADAPTER.c(r10);
                goto L3
            L15:
                r1.l = ThemeColor.ADAPTER.c(r10);
                goto L3
            L24:
                r1.i = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L25:
                r1.h = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L26:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L31:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L32:
                r1.d = ImageSet.ADAPTER.c(r10);
                goto L3
            L6:
                r10.j(r4);
                Unit r8 = Unit.INSTANCE;
                goto L3
            L34:
                return new PreviewHeaderProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PreviewHeaderProperty r7) {
                PreviewHeaderProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r8, "value");
                int r0 = r8.unknownFields().size();
                ProtoAdapter<ImageSet> r1 = ImageSet.ADAPTER;
                int r2 = r0 + r1.l(1, r8.getIcon_key());
                w r3 = ProtoAdapter.q;
                int r4 = ((r2 + r3.l(2, r8.getTitle())) + Tag.ADAPTER.l(3, r8.getLark_tag())) + r3.l(4, r8.getChild_component_id());
                l r5 = ProtoAdapter.g;
                int r6 = (((r4 + r5.l(5, r8.is_need_copy_link())) + r5.l(6, r8.is_need_close())) + Theme.ADAPTER.l(7, r8.getTheme())) + Type.ADAPTER.l(8, r8.getType());
                ProtoAdapter<ThemeColor> r9 = ThemeColor.ADAPTER;
                int r10 = (((((r6 + r9.l(9, r8.getTag_color())) + r9.l(10, r8.getTag_text_color())) + r3.l(11, r8.getHeader_tag())) + r3.l(12, r8.getFavicon_url())) + r9.l(13, r8.getIcon_color())) + UDIcon.ADAPTER.l(14, r8.getUd_icon());
                s r11 = ProtoAdapter.h;
                return ((r10 + r11.l(15, r8.getNumber_of_lines())) + r11.l(16, r8.getIcon_size())) + r1.l(17, r8.getDm_icon());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r6, PreviewHeaderProperty r7) {
                PreviewHeaderProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                ProtoAdapter<ImageSet> r0 = ImageSet.ADAPTER;
                r0.i(r6, 1, r8.getIcon_key());
                w r1 = ProtoAdapter.q;
                r1.i(r6, 2, r8.getTitle());
                Tag.ADAPTER.i(r6, 3, r8.getLark_tag());
                r1.i(r6, 4, r8.getChild_component_id());
                l r2 = ProtoAdapter.g;
                r2.i(r6, 5, r8.is_need_copy_link());
                r2.i(r6, 6, r8.is_need_close());
                Theme.ADAPTER.i(r6, 7, r8.getTheme());
                Type.ADAPTER.i(r6, 8, r8.getType());
                ProtoAdapter<ThemeColor> r3 = ThemeColor.ADAPTER;
                r3.i(r6, 9, r8.getTag_color());
                r3.i(r6, 10, r8.getTag_text_color());
                r1.i(r6, 11, r8.getHeader_tag());
                r1.i(r6, 12, r8.getFavicon_url());
                r3.i(r6, 13, r8.getIcon_color());
                UDIcon.ADAPTER.i(r6, 14, r8.getUd_icon());
                s r4 = ProtoAdapter.h;
                r4.i(r6, 15, r8.getNumber_of_lines());
                r4.i(r6, 16, r8.getIcon_size());
                r0.i(r6, 17, r8.getDm_icon());
                r6.a(r8.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r6, PreviewHeaderProperty r7) {
                PreviewHeaderProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                r6.d(r8.unknownFields());
                ProtoAdapter<ImageSet> r0 = ImageSet.ADAPTER;
                r0.j(r6, 17, r8.getDm_icon());
                s r1 = ProtoAdapter.h;
                r1.j(r6, 16, r8.getIcon_size());
                r1.j(r6, 15, r8.getNumber_of_lines());
                UDIcon.ADAPTER.j(r6, 14, r8.getUd_icon());
                ProtoAdapter<ThemeColor> r2 = ThemeColor.ADAPTER;
                r2.j(r6, 13, r8.getIcon_color());
                w r3 = ProtoAdapter.q;
                r3.j(r6, 12, r8.getFavicon_url());
                r3.j(r6, 11, r8.getHeader_tag());
                r2.j(r6, 10, r8.getTag_text_color());
                r2.j(r6, 9, r8.getTag_color());
                Type.ADAPTER.j(r6, 8, r8.getType());
                Theme.ADAPTER.j(r6, 7, r8.getTheme());
                l r4 = ProtoAdapter.g;
                r4.j(r6, 6, r8.is_need_close());
                r4.j(r6, 5, r8.is_need_copy_link());
                r3.j(r6, 4, r8.getChild_component_id());
                Tag.ADAPTER.j(r6, 3, r8.getLark_tag());
                r3.j(r6, 2, r8.getTitle());
                r0.j(r6, 1, r8.getIcon_key());
            }

            public b(FieldEncoding r7, KClass<PreviewHeaderProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.PreviewHeaderProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PreviewHeaderProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_THEME = Theme.LIGHT;
            DEFAULT_TYPE = Type.NORMAL;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PreviewHeaderProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.icon_key;
            r0.e = this.title;
            r0.f = this.lark_tag;
            r0.g = this.child_component_id;
            r0.h = this.is_need_copy_link;
            r0.i = this.is_need_close;
            r0.j = this.theme;
            r0.k = this.type;
            r0.l = this.tag_color;
            r0.m = this.tag_text_color;
            r0.n = this.header_tag;
            r0.o = this.favicon_url;
            r0.p = this.icon_color;
            r0.q = this.ud_icon;
            r0.r = this.number_of_lines;
            r0.s = this.icon_size;
            r0.t = this.dm_icon;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PreviewHeaderProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getChild_component_id() {
            return this.child_component_id;
        }

        public final ImageSet getDm_icon() {
            return this.dm_icon;
        }

        public final String getFavicon_url() {
            return this.favicon_url;
        }

        public final String getHeader_tag() {
            return this.header_tag;
        }

        public final ThemeColor getIcon_color() {
            return this.icon_color;
        }

        public final ImageSet getIcon_key() {
            return this.icon_key;
        }

        public final Integer getIcon_size() {
            return this.icon_size;
        }

        public final Tag getLark_tag() {
            return this.lark_tag;
        }

        public final Integer getNumber_of_lines() {
            return this.number_of_lines;
        }

        public final ThemeColor getTag_color() {
            return this.tag_color;
        }

        public final ThemeColor getTag_text_color() {
            return this.tag_text_color;
        }

        public final Theme getTheme() {
            return this.theme;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Type getType() {
            return this.type;
        }

        public final UDIcon getUd_icon() {
            return this.ud_icon;
        }

        public final Boolean is_need_close() {
            return this.is_need_close;
        }

        public final Boolean is_need_copy_link() {
            return this.is_need_copy_link;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PreviewHeaderProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.icon_key = r2.d;
            this.title = r2.e;
            this.lark_tag = r2.f;
            this.child_component_id = r2.g;
            this.is_need_copy_link = r2.h;
            this.is_need_close = r2.i;
            this.theme = r2.j;
            this.type = r2.k;
            this.tag_color = r2.l;
            this.tag_text_color = r2.m;
            this.header_tag = r2.n;
            this.favicon_url = r2.o;
            this.icon_color = r2.p;
            this.ud_icon = r2.q;
            this.number_of_lines = r2.r;
            this.icon_size = r2.s;
            this.dm_icon = r2.t;
        }

        public /* synthetic */ PreviewHeaderProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$RichTextProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$RichTextProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$RichTextProperty$Builder;Lokio/ByteString;)V", "richtext", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRichtext", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "number_of_lines", "", "getNumber_of_lines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "at_out_chatter_ids", "", "", "getAt_out_chatter_ids", "()Ljava/util/List;", "show_update_time", "", "getShow_update_time", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "theme", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;", "getTheme", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;", "newBuilder", "toString", "Builder", "Companion", "RichTextTheme", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class RichTextProperty extends com.lark.wire.Message<RichTextProperty, a> {
        public static final ProtoAdapter<RichTextProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_NUMBER_OF_LINES = 0;
        private static final long serialVersionUID = 0;
        private final List<String> at_out_chatter_ids;
        private final Integer number_of_lines;
        private final RichText richtext;
        private final Boolean show_update_time;
        private final RichTextTheme theme;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "DARK", "LIGHT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum RichTextTheme extends Enum<RichTextTheme> implements o0 {
            public static final ProtoAdapter<RichTextTheme> ADAPTER = null;
            public static final b Companion = null;
            public static final RichTextTheme DARK = null;
            public static final RichTextTheme DEFAULT = null;
            public static final RichTextTheme LIGHT = null;
            public static final /* synthetic */ RichTextTheme[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<RichTextTheme> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    RichTextTheme.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return RichTextTheme.LIGHT;
                L15:
                    return RichTextTheme.DARK;
                L12:
                    return RichTextTheme.DEFAULT;
                }

                public a(KClass<RichTextTheme> r1, Syntax r2, RichTextTheme r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<RichTextTheme> getEntries() {
                return b;
            }

            static {
                RichTextTheme r0 = new RichTextTheme("DEFAULT", 0, 0);
                DEFAULT = r0;
                RichTextTheme r1 = new RichTextTheme("DARK", 1, 1);
                DARK = r1;
                RichTextTheme r3 = new RichTextTheme("LIGHT", 2, 2);
                LIGHT = r3;
                RichTextTheme[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(RichTextTheme.class), Syntax.PROTO_2, r0);
            }

            public static RichTextTheme[] values() {
                return (RichTextTheme[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final RichTextTheme fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return LIGHT;
            L15:
                return DARK;
            L12:
                return DEFAULT;
            }

            public static RichTextTheme valueOf(String r1) {
                return (RichTextTheme) r27.a.a(RichTextTheme.class, r1);
            }

            public RichTextTheme(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<RichTextProperty, a> {
            public RichText d;
            public Integer e;
            public List<String> f;
            public Boolean g;
            public RichTextTheme h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new RichTextProperty(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<RichTextProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final RichTextProperty c(g0 r11) {
                Intrinsics.checkNotNullParameter(r11, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r11.c();
            L3:
                int r5 = r11.e();
                if (r5 == (-1)) goto L24;
                if (r5 != 1) goto L8;
                r1.d = RichText.ADAPTER.c(r11);
                goto L3
            L8:
                if (r5 != 2) goto L10;
                r1.e = (Integer) ProtoAdapter.h.c(r11);
                goto L3
            L10:
                if (r5 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r11, "reader");
                r2.add(r11.i());
                goto L3
            L12:
                if (r5 != 4) goto L14;
                r1.g = (Boolean) ProtoAdapter.g.c(r11);
                goto L3
            L14:
                if (r5 != 5) goto L15;
                r1.h = RichTextTheme.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L15:
                r11.j(r5);
                Unit r7 = Unit.INSTANCE;
                goto L3
            L24:
                ByteString r12 = r11.d(r3);
                Intrinsics.checkNotNullParameter(r2, "at_out_chatter_ids");
                com.lark.wire.internal.a.a(r2);
                r1.f = r2;
                return new RichTextProperty(r1, r12, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(RichTextProperty r5) {
                RichTextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((((r6.unknownFields().size() + RichText.ADAPTER.l(1, r6.getRichtext())) + ProtoAdapter.h.l(2, r6.getNumber_of_lines())) + ProtoAdapter.q.a().l(3, r6.getAt_out_chatter_ids())) + ProtoAdapter.g.l(4, r6.getShow_update_time())) + RichTextTheme.ADAPTER.l(5, r6.getTheme());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, RichTextProperty r5) {
                RichTextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                RichText.ADAPTER.i(r4, 1, r6.getRichtext());
                ProtoAdapter.h.i(r4, 2, r6.getNumber_of_lines());
                ProtoAdapter.q.a().i(r4, 3, r6.getAt_out_chatter_ids());
                ProtoAdapter.g.i(r4, 4, r6.getShow_update_time());
                RichTextTheme.ADAPTER.i(r4, 5, r6.getTheme());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, RichTextProperty r5) {
                RichTextProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                RichTextTheme.ADAPTER.j(r4, 5, r6.getTheme());
                ProtoAdapter.g.j(r4, 4, r6.getShow_update_time());
                ProtoAdapter.q.a().j(r4, 3, r6.getAt_out_chatter_ids());
                ProtoAdapter.h.j(r4, 2, r6.getNumber_of_lines());
                RichText.ADAPTER.j(r4, 1, r6.getRichtext());
            }

            public b(FieldEncoding r7, KClass<RichTextProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.RichTextProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ RichTextProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(RichTextProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.richtext;
            r0.e = this.number_of_lines;
            r0.f = this.at_out_chatter_ids;
            r0.g = this.show_update_time;
            r0.h = this.theme;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(RichTextProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getAt_out_chatter_ids() {
            return this.at_out_chatter_ids;
        }

        public final Integer getNumber_of_lines() {
            return this.number_of_lines;
        }

        public final RichText getRichtext() {
            return this.richtext;
        }

        public final Boolean getShow_update_time() {
            return this.show_update_time;
        }

        public final RichTextTheme getTheme() {
            return this.theme;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public RichTextProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.richtext = r2.d;
            this.number_of_lines = r2.e;
            this.at_out_chatter_ids = com.lark.wire.internal.a.c("at_out_chatter_ids", r2.f);
            this.show_update_time = r2.g;
            this.theme = r2.h;
        }

        public /* synthetic */ RichTextProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$SizeLevel;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "SMALL", "LARGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SizeLevel extends Enum<SizeLevel> implements o0 {
        public static final ProtoAdapter<SizeLevel> ADAPTER = null;
        public static final b Companion = null;
        public static final SizeLevel LARGE = null;
        public static final SizeLevel NORMAL = null;
        public static final SizeLevel SMALL = null;
        public static final /* synthetic */ SizeLevel[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SizeLevel> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SizeLevel.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return SizeLevel.LARGE;
            L15:
                return SizeLevel.SMALL;
            L12:
                return SizeLevel.NORMAL;
            }

            public a(KClass<SizeLevel> r1, Syntax r2, SizeLevel r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<SizeLevel> getEntries() {
            return b;
        }

        static {
            SizeLevel r0 = new SizeLevel("NORMAL", 0, 0);
            NORMAL = r0;
            SizeLevel r1 = new SizeLevel("SMALL", 1, 1);
            SMALL = r1;
            SizeLevel r3 = new SizeLevel("LARGE", 2, 2);
            LARGE = r3;
            SizeLevel[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SizeLevel.class), Syntax.PROTO_2, r0);
        }

        public static SizeLevel[] values() {
            return (SizeLevel[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final SizeLevel fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return LARGE;
        L15:
            return SMALL;
        L12:
            return NORMAL;
        }

        public static SizeLevel valueOf(String r1) {
            return (SizeLevel) r27.a.a(SizeLevel.class, r1);
        }

        public SizeLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$SpinButtonProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$SpinButtonProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$SpinButtonProperty$Builder;Lokio/ByteString;)V", "icon", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "items", "", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Item;", "getItems", "()Ljava/util/List;", "selected_index", "", "getSelected_index", "()Ljava/lang/Long;", "Ljava/lang/Long;", "direction", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Direction;", "getDirection", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Direction;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SpinButtonProperty extends com.lark.wire.Message<SpinButtonProperty, a> {
        public static final ProtoAdapter<SpinButtonProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final Direction DEFAULT_DIRECTION = null;
        public static final long DEFAULT_SELECTED_INDEX = 0;
        private static final long serialVersionUID = 0;
        private final Direction direction;
        private final ImageSet icon;
        private final List<Item> items;
        private final Long selected_index;

        public static final class a extends com.lark.wire.Message.a<SpinButtonProperty, a> {
            public ImageSet d;
            public List<Item> e;
            public Long f;
            public Direction g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SpinButtonProperty(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<SpinButtonProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final SpinButtonProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L21;
                if (r4 != 1) goto L8;
                r0.d = ImageSet.ADAPTER.c(r10);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.add(Item.ADAPTER.c(r10));
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r0.f = (Long) ProtoAdapter.k.c(r10);
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r0.g = Direction.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                r10.j(r4);
                goto L3
            L21:
                ByteString r11 = r10.d(r2);
                Intrinsics.checkNotNullParameter(r1, "items");
                com.lark.wire.internal.a.a(r1);
                r0.e = r1;
                return new SpinButtonProperty(r0, r11, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SpinButtonProperty r5) {
                SpinButtonProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((r6.unknownFields().size() + ImageSet.ADAPTER.l(1, r6.getIcon())) + Item.ADAPTER.a().l(2, r6.getItems())) + ProtoAdapter.k.l(3, r6.getSelected_index())) + Direction.ADAPTER.l(4, r6.getDirection());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SpinButtonProperty r5) {
                SpinButtonProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ImageSet.ADAPTER.i(r4, 1, r6.getIcon());
                Item.ADAPTER.a().i(r4, 2, r6.getItems());
                ProtoAdapter.k.i(r4, 3, r6.getSelected_index());
                Direction.ADAPTER.i(r4, 4, r6.getDirection());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SpinButtonProperty r5) {
                SpinButtonProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                Direction.ADAPTER.j(r4, 4, r6.getDirection());
                ProtoAdapter.k.j(r4, 3, r6.getSelected_index());
                Item.ADAPTER.a().j(r4, 2, r6.getItems());
                ImageSet.ADAPTER.j(r4, 1, r6.getIcon());
            }

            public b(FieldEncoding r7, KClass<SpinButtonProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.SpinButtonProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SpinButtonProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_DIRECTION = Direction.LTR;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SpinButtonProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.icon;
            r0.e = this.items;
            r0.f = this.selected_index;
            r0.g = this.direction;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SpinButtonProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Direction getDirection() {
            return this.direction;
        }

        public final ImageSet getIcon() {
            return this.icon;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public final Long getSelected_index() {
            return this.selected_index;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SpinButtonProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.icon = r2.d;
            this.items = com.lark.wire.internal.a.c("items", r2.e);
            this.selected_index = r2.f;
            this.direction = r2.g;
        }

        public /* synthetic */ SpinButtonProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002:;B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00107\u001a\u00020\u0002H\u0016J\b\u00108\u001a\u000209H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010 \u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0015\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0015\u0010'\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b(\u0010%R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u00101\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b2\u0010%R\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Style;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Style$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Style$Builder;Lokio/ByteString;)V", "size_level", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$SizeLevel;", "getSize_level", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$SizeLevel;", "text_color_v2", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getText_color_v2", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "background_color", "Lcom/lark/kmp/pb/basic/v1/Gradient;", "getBackground_color", "()Lcom/lark/kmp/pb/basic/v1/Gradient;", "width", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Value;", "getWidth", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Value;", "height", "getHeight", "max_width", "getMax_width", "max_height", "getMax_height", "min_width", "getMin_width", "min_height", "getMin_height", "grow_weight", "", "getGrow_weight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "shrink_weight", "getShrink_weight", "font_level", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontLevel;", "getFont_level", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontLevel;", "border", "Lcom/lark/kmp/pb/basic/v1/Border;", "getBorder", "()Lcom/lark/kmp/pb/basic/v1/Border;", "aspect_ratio", "getAspect_ratio", "align_self", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Align;", "getAlign_self", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Align;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Style extends com.lark.wire.Message<Style, a> {
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Align align_self;
        private final Integer aspect_ratio;
        private final Gradient background_color;
        private final Border border;
        private final FontLevel font_level;
        private final Integer grow_weight;
        private final Value height;
        private final Value max_height;
        private final Value max_width;
        private final Value min_height;
        private final Value min_width;
        private final Integer shrink_weight;
        private final SizeLevel size_level;
        private final ThemeColor text_color_v2;
        private final Value width;

        public static final class a extends com.lark.wire.Message.a<Style, a> {
            public SizeLevel d;
            public ThemeColor e;
            public Gradient f;
            public Value g;
            public Value h;
            public Value i;
            public Value j;
            public Value k;
            public Value l;
            public Integer m;
            public Integer n;
            public FontLevel o;
            public Border p;
            public Integer q;
            public Align r;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Style(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Style> {
            @Override // com.lark.wire.ProtoAdapter
            public final Style c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L29;
                switch(r3) {
                    case 1: goto L32;
                    case 2: goto L6;
                    case 3: goto L23;
                    case 4: goto L22;
                    case 5: goto L21;
                    case 6: goto L20;
                    case 7: goto L19;
                    case 8: goto L18;
                    case 9: goto L17;
                    case 10: goto L16;
                    case 11: goto L15;
                    case 12: goto L14;
                    case 13: goto L13;
                    case 14: goto L12;
                    case 15: goto L11;
                    case 16: goto L30;
                    default: goto L6;
                };
            L30:
                r0.r = Align.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L32:
                r0.d = SizeLevel.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
            L26:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L11:
                r0.q = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L12:
                r0.e = ThemeColor.ADAPTER.c(r9);
                goto L3
            L13:
                r0.p = Border.ADAPTER.c(r9);
                goto L3
            L14:
                r0.o = FontLevel.ADAPTER.c(r9);
                goto L3
            L15:
                r0.n = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L16:
                r0.m = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L17:
                r0.l = Value.ADAPTER.c(r9);
                goto L3
            L18:
                r0.k = Value.ADAPTER.c(r9);
                goto L3
            L19:
                r0.j = Value.ADAPTER.c(r9);
                goto L3
            L20:
                r0.i = Value.ADAPTER.c(r9);
                goto L3
            L21:
                r0.h = Value.ADAPTER.c(r9);
                goto L3
            L22:
                r0.g = Value.ADAPTER.c(r9);
                goto L3
            L23:
                r0.f = Gradient.ADAPTER.c(r9);
                goto L3
            L6:
                r9.j(r3);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L29:
                return new Style(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Style r6) {
                Style r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = ((r7.unknownFields().size() + SizeLevel.ADAPTER.l(1, r7.getSize_level())) + ThemeColor.ADAPTER.l(14, r7.getText_color_v2())) + Gradient.ADAPTER.l(3, r7.getBackground_color());
                ProtoAdapter<Value> r1 = Value.ADAPTER;
                int r2 = (((((r0 + r1.l(4, r7.getWidth())) + r1.l(5, r7.getHeight())) + r1.l(6, r7.getMax_width())) + r1.l(7, r7.getMax_height())) + r1.l(8, r7.getMin_width())) + r1.l(9, r7.getMin_height());
                s r3 = ProtoAdapter.h;
                return (((((r2 + r3.l(10, r7.getGrow_weight())) + r3.l(11, r7.getShrink_weight())) + FontLevel.ADAPTER.l(12, r7.getFont_level())) + Border.ADAPTER.l(13, r7.getBorder())) + r3.l(15, r7.getAspect_ratio())) + Align.ADAPTER.l(16, r7.getAlign_self());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, Style r6) {
                Style r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                SizeLevel.ADAPTER.i(r5, 1, r7.getSize_level());
                ThemeColor.ADAPTER.i(r5, 14, r7.getText_color_v2());
                Gradient.ADAPTER.i(r5, 3, r7.getBackground_color());
                ProtoAdapter<Value> r0 = Value.ADAPTER;
                r0.i(r5, 4, r7.getWidth());
                r0.i(r5, 5, r7.getHeight());
                r0.i(r5, 6, r7.getMax_width());
                r0.i(r5, 7, r7.getMax_height());
                r0.i(r5, 8, r7.getMin_width());
                r0.i(r5, 9, r7.getMin_height());
                s r1 = ProtoAdapter.h;
                r1.i(r5, 10, r7.getGrow_weight());
                r1.i(r5, 11, r7.getShrink_weight());
                FontLevel.ADAPTER.i(r5, 12, r7.getFont_level());
                Border.ADAPTER.i(r5, 13, r7.getBorder());
                r1.i(r5, 15, r7.getAspect_ratio());
                Align.ADAPTER.i(r5, 16, r7.getAlign_self());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, Style r6) {
                Style r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                Align.ADAPTER.j(r5, 16, r7.getAlign_self());
                s r0 = ProtoAdapter.h;
                r0.j(r5, 15, r7.getAspect_ratio());
                Border.ADAPTER.j(r5, 13, r7.getBorder());
                FontLevel.ADAPTER.j(r5, 12, r7.getFont_level());
                r0.j(r5, 11, r7.getShrink_weight());
                r0.j(r5, 10, r7.getGrow_weight());
                ProtoAdapter<Value> r1 = Value.ADAPTER;
                r1.j(r5, 9, r7.getMin_height());
                r1.j(r5, 8, r7.getMin_width());
                r1.j(r5, 7, r7.getMax_height());
                r1.j(r5, 6, r7.getMax_width());
                r1.j(r5, 5, r7.getHeight());
                r1.j(r5, 4, r7.getWidth());
                Gradient.ADAPTER.j(r5, 3, r7.getBackground_color());
                ThemeColor.ADAPTER.j(r5, 14, r7.getText_color_v2());
                SizeLevel.ADAPTER.j(r5, 1, r7.getSize_level());
            }

            public b(FieldEncoding r7, KClass<Style> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.Style", r9, null);
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
            r0.d = this.size_level;
            r0.e = this.text_color_v2;
            r0.f = this.background_color;
            r0.g = this.width;
            r0.h = this.height;
            r0.i = this.max_width;
            r0.j = this.max_height;
            r0.k = this.min_width;
            r0.l = this.min_height;
            r0.m = this.grow_weight;
            r0.n = this.shrink_weight;
            r0.o = this.font_level;
            r0.p = this.border;
            r0.q = this.aspect_ratio;
            r0.r = this.align_self;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Style.class).getSimpleName() + '@' + hashCode();
        }

        public final Align getAlign_self() {
            return this.align_self;
        }

        public final Integer getAspect_ratio() {
            return this.aspect_ratio;
        }

        public final Gradient getBackground_color() {
            return this.background_color;
        }

        public final Border getBorder() {
            return this.border;
        }

        public final FontLevel getFont_level() {
            return this.font_level;
        }

        public final Integer getGrow_weight() {
            return this.grow_weight;
        }

        public final Value getHeight() {
            return this.height;
        }

        public final Value getMax_height() {
            return this.max_height;
        }

        public final Value getMax_width() {
            return this.max_width;
        }

        public final Value getMin_height() {
            return this.min_height;
        }

        public final Value getMin_width() {
            return this.min_width;
        }

        public final Integer getShrink_weight() {
            return this.shrink_weight;
        }

        public final SizeLevel getSize_level() {
            return this.size_level;
        }

        public final ThemeColor getText_color_v2() {
            return this.text_color_v2;
        }

        public final Value getWidth() {
            return this.width;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Style(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.size_level = r2.d;
            this.text_color_v2 = r2.e;
            this.background_color = r2.f;
            this.width = r2.g;
            this.height = r2.h;
            this.max_width = r2.i;
            this.max_height = r2.j;
            this.min_width = r2.k;
            this.min_height = r2.l;
            this.grow_weight = r2.m;
            this.shrink_weight = r2.n;
            this.font_level = r2.o;
            this.border = r2.p;
            this.aspect_ratio = r2.q;
            this.align_self = r2.r;
        }

        public /* synthetic */ Style(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty$Builder;Lokio/ByteString;)V", "tags", "", "", "getTags", "()Ljava/util/List;", "mixed_tags", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty$Tag;", "getMixed_tags", "number_of_lines", "", "getNumber_of_lines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "Tag", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TagListProperty extends com.lark.wire.Message<TagListProperty, a> {
        public static final ProtoAdapter<TagListProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_NUMBER_OF_LINES = 1;
        private static final long serialVersionUID = 0;
        private final List<Tag> mixed_tags;
        private final Integer number_of_lines;
        private final List<String> tags;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty$Tag;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty$Tag$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty$Tag$Builder;Lokio/ByteString;)V", "tag", "", "getTag", "()Ljava/lang/String;", "text_color", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getText_color", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "background_color", "getBackground_color", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class Tag extends com.lark.wire.Message<Tag, a> {
            public static final ProtoAdapter<Tag> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final ThemeColor background_color;
            private final String tag;
            private final ThemeColor text_color;

            public static final class a extends com.lark.wire.Message.a<Tag, a> {
                public String d;
                public ThemeColor e;
                public ThemeColor f;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new Tag(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<Tag> {
                @Override // com.lark.wire.ProtoAdapter
                public final Tag c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r1 = new a();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L16;
                    if (r4 != 1) goto L8;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.d = r7.i();
                    goto L3
                L8:
                    if (r4 != 2) goto L10;
                    r1.e = ThemeColor.ADAPTER.c(r7);
                    goto L3
                L10:
                    if (r4 != 3) goto L11;
                    r1.f = ThemeColor.ADAPTER.c(r7);
                    goto L3
                L11:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L16:
                    return new Tag(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(Tag r5) {
                    Tag r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getTag());
                    ProtoAdapter<ThemeColor> r1 = ThemeColor.ADAPTER;
                    return (r0 + r1.l(2, r6.getText_color())) + r1.l(3, r6.getBackground_color());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, Tag r5) {
                    Tag r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.q.i(r4, 1, r6.getTag());
                    ProtoAdapter<ThemeColor> r0 = ThemeColor.ADAPTER;
                    r0.i(r4, 2, r6.getText_color());
                    r0.i(r4, 3, r6.getBackground_color());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, Tag r5) {
                    Tag r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    ProtoAdapter<ThemeColor> r0 = ThemeColor.ADAPTER;
                    r0.j(r4, 3, r6.getBackground_color());
                    r0.j(r4, 2, r6.getText_color());
                    ProtoAdapter.q.j(r4, 1, r6.getTag());
                }

                public b(FieldEncoding r7, KClass<Tag> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.TagListProperty.Tag", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ Tag(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Tag.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.tag;
                r0.e = this.text_color;
                r0.f = this.background_color;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(Tag.class).getSimpleName() + '@' + hashCode();
            }

            public final ThemeColor getBackground_color() {
                return this.background_color;
            }

            public final String getTag() {
                return this.tag;
            }

            public final ThemeColor getText_color() {
                return this.text_color;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public Tag(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.tag = r2.d;
                this.text_color = r2.e;
                this.background_color = r2.f;
            }

            public /* synthetic */ Tag(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<TagListProperty, a> {
            public List<String> d;
            public List<Tag> e;
            public Integer f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TagListProperty(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<TagListProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TagListProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                ArrayList r3 = new ArrayList();
                long r4 = r9.c();
            L3:
                int r6 = r9.e();
                if (r6 == (-1)) goto L15;
                if (r6 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r9, "reader");
                r2.add(r9.i());
                goto L3
            L8:
                if (r6 != 2) goto L10;
                r3.add(Tag.ADAPTER.c(r9));
                goto L3
            L10:
                if (r6 != 3) goto L11;
                r1.f = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L11:
                r9.j(r6);
                goto L3
            L15:
                ByteString r10 = r9.d(r4);
                Intrinsics.checkNotNullParameter(r2, "tags");
                com.lark.wire.internal.a.a(r2);
                r1.d = r2;
                Intrinsics.checkNotNullParameter(r3, "mixed_tags");
                com.lark.wire.internal.a.a(r3);
                r1.e = r3;
                return new TagListProperty(r1, r10, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TagListProperty r5) {
                TagListProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ProtoAdapter.q.a().l(1, r6.getTags())) + Tag.ADAPTER.a().l(2, r6.getMixed_tags())) + ProtoAdapter.h.l(3, r6.getNumber_of_lines());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TagListProperty r5) {
                TagListProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.a().i(r4, 1, r6.getTags());
                Tag.ADAPTER.a().i(r4, 2, r6.getMixed_tags());
                ProtoAdapter.h.i(r4, 3, r6.getNumber_of_lines());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TagListProperty r5) {
                TagListProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 3, r6.getNumber_of_lines());
                Tag.ADAPTER.a().j(r4, 2, r6.getMixed_tags());
                ProtoAdapter.q.a().j(r4, 1, r6.getTags());
            }

            public b(FieldEncoding r7, KClass<TagListProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.TagListProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TagListProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TagListProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.tags;
            r0.e = this.mixed_tags;
            r0.f = this.number_of_lines;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TagListProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final List<Tag> getMixed_tags() {
            return this.mixed_tags;
        }

        public final Integer getNumber_of_lines() {
            return this.number_of_lines;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TagListProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.tags = com.lark.wire.internal.a.c("tags", r2.d);
            this.mixed_tags = com.lark.wire.internal.a.c("mixed_tags", r2.e);
            this.number_of_lines = r2.f;
        }

        public /* synthetic */ TagListProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextButtonProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextButtonProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextButtonProperty$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", CardActionService.ACTION_ID, "getAction_id", "is_disable", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TextButtonProperty extends com.lark.wire.Message<TextButtonProperty, a> {
        public static final ProtoAdapter<TextButtonProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final Boolean is_disable;
        private final String text;

        public static final class a extends com.lark.wire.Message.a<TextButtonProperty, a> {
            public String d;
            public String e;
            public Boolean f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TextButtonProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TextButtonProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TextButtonProperty c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L16;
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
                if (r4 != 3) goto L11;
                r1.f = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L11:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L16:
                return new TextButtonProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TextButtonProperty r5) {
                TextButtonProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(1, r6.getText())) + r1.l(2, r6.getAction_id())) + ProtoAdapter.g.l(3, r6.is_disable());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TextButtonProperty r5) {
                TextButtonProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getText());
                r0.i(r4, 2, r6.getAction_id());
                ProtoAdapter.g.i(r4, 3, r6.is_disable());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TextButtonProperty r5) {
                TextButtonProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 3, r6.is_disable());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getAction_id());
                r0.j(r4, 1, r6.getText());
            }

            public b(FieldEncoding r7, KClass<TextButtonProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.TextButtonProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TextButtonProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextButtonProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.text;
            r0.e = this.action_id;
            r0.f = this.is_disable;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TextButtonProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final String getText() {
            return this.text;
        }

        public final Boolean is_disable() {
            return this.is_disable;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TextButtonProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.text = r2.d;
            this.action_id = r2.e;
            this.is_disable = r2.f;
        }

        public /* synthetic */ TextButtonProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TextProperty$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "number_of_lines", "", "getNumber_of_lines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", CardActionService.ACTION_ID, "getAction_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TextProperty extends com.lark.wire.Message<TextProperty, a> {
        public static final ProtoAdapter<TextProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_NUMBER_OF_LINES = 0;
        private static final long serialVersionUID = 0;
        private final String action_id;
        private final Integer number_of_lines;
        private final String text;

        public static final class a extends com.lark.wire.Message.a<TextProperty, a> {
            public String d;
            public Integer e;
            public String f;

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
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L10:
                if (r4 != 3) goto L11;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L11:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L16:
                return new TextProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TextProperty r6) {
                TextProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(1, r7.getText())) + ProtoAdapter.h.l(2, r7.getNumber_of_lines())) + r1.l(3, r7.getAction_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, TextProperty r6) {
                TextProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getText());
                ProtoAdapter.h.i(r5, 2, r7.getNumber_of_lines());
                r0.i(r5, 3, r7.getAction_id());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, TextProperty r6) {
                TextProperty r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 3, r7.getAction_id());
                ProtoAdapter.h.j(r5, 2, r7.getNumber_of_lines());
                r0.j(r5, 1, r7.getText());
            }

            public b(FieldEncoding r7, KClass<TextProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.TextProperty", r9, null);
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
            r0.d = this.text;
            r0.e = this.number_of_lines;
            r0.f = this.action_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TextProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAction_id() {
            return this.action_id;
        }

        public final Integer getNumber_of_lines() {
            return this.number_of_lines;
        }

        public final String getText() {
            return this.text;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TextProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.text = r2.d;
            this.number_of_lines = r2.e;
            this.action_id = r2.f;
        }

        public /* synthetic */ TextProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Theme;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LIGHT", "DARK", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Theme extends Enum<Theme> implements o0 {
        public static final ProtoAdapter<Theme> ADAPTER = null;
        public static final b Companion = null;
        public static final Theme DARK = null;
        public static final Theme LIGHT = null;
        public static final /* synthetic */ Theme[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Theme> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Theme.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return Theme.DARK;
            L9:
                return Theme.LIGHT;
            }

            public a(KClass<Theme> r1, Syntax r2, Theme r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Theme> getEntries() {
            return b;
        }

        static {
            Theme r0 = new Theme("LIGHT", 0, 0);
            LIGHT = r0;
            Theme r1 = new Theme("DARK", 1, 1);
            DARK = r1;
            Theme[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Theme.class), Syntax.PROTO_2, r0);
        }

        public static Theme[] values() {
            return (Theme[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Theme fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return DARK;
        L9:
            return LIGHT;
        }

        public static Theme valueOf(String r1) {
            return (Theme) r27.a.a(Theme.class, r1);
        }

        public Theme(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeProperty$Builder;Lokio/ByteString;)V", "start_time_stamp", "", "getStart_time_stamp", "()J", "is_countdown", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ntp_action_id", "", "getNtp_action_id", "()Ljava/lang/String;", "is_end", "end_time_stamp", "getEnd_time_stamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TimeProperty extends com.lark.wire.Message<TimeProperty, a> {
        public static final ProtoAdapter<TimeProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_IS_COUNTDOWN = false;
        private static final long serialVersionUID = 0;
        private final Long end_time_stamp;
        private final Boolean is_countdown;
        private final Boolean is_end;
        private final String ntp_action_id;
        private final long start_time_stamp;

        public static final class a extends com.lark.wire.Message.a<TimeProperty, a> {
            public Long d;
            public Boolean e;
            public String f;
            public Boolean g;
            public Long h;

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
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                r1.d = Long.valueOf(((Number) ProtoAdapter.k.c(r7)).longValue());
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L14;
                r1.g = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L14:
                if (r4 != 5) goto L15;
                r1.h = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L15:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L22:
                return new TimeProperty(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TimeProperty r7) {
                TimeProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r8, "value");
                int r0 = r8.unknownFields().size();
                t r1 = ProtoAdapter.k;
                int r2 = r0 + r1.l(1, Long.valueOf(r8.getStart_time_stamp()));
                l r3 = ProtoAdapter.g;
                return (((r2 + r3.l(2, r8.is_countdown())) + ProtoAdapter.q.l(3, r8.getNtp_action_id())) + r3.l(4, r8.is_end())) + r1.l(5, r8.getEnd_time_stamp());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r6, TimeProperty r7) {
                TimeProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r6, 1, Long.valueOf(r8.getStart_time_stamp()));
                l r1 = ProtoAdapter.g;
                r1.i(r6, 2, r8.is_countdown());
                ProtoAdapter.q.i(r6, 3, r8.getNtp_action_id());
                r1.i(r6, 4, r8.is_end());
                r0.i(r6, 5, r8.getEnd_time_stamp());
                r6.a(r8.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r6, TimeProperty r7) {
                TimeProperty r8 = r7;
                Intrinsics.checkNotNullParameter(r6, "writer");
                Intrinsics.checkNotNullParameter(r8, "value");
                r6.d(r8.unknownFields());
                t r0 = ProtoAdapter.k;
                r0.j(r6, 5, r8.getEnd_time_stamp());
                l r1 = ProtoAdapter.g;
                r1.j(r6, 4, r8.is_end());
                ProtoAdapter.q.j(r6, 3, r8.getNtp_action_id());
                r1.j(r6, 2, r8.is_countdown());
                r0.j(r6, 1, Long.valueOf(r8.getStart_time_stamp()));
            }

            public b(FieldEncoding r7, KClass<TimeProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.TimeProperty", r9, null);
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
            r0.d = Long.valueOf(this.start_time_stamp);
            r0.e = this.is_countdown;
            r0.f = this.ntp_action_id;
            r0.g = this.is_end;
            r0.h = this.end_time_stamp;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TimeProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getEnd_time_stamp() {
            return this.end_time_stamp;
        }

        public final String getNtp_action_id() {
            return this.ntp_action_id;
        }

        public final long getStart_time_stamp() {
            return this.start_time_stamp;
        }

        public final Boolean is_countdown() {
            return this.is_countdown;
        }

        public final Boolean is_end() {
            return this.is_end;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TimeProperty(a r3, ByteString r4) {
            super(ADAPTER, r4);
            Long r5 = r3.d;
            Intrinsics.checkNotNull(r5);
            this.start_time_stamp = r5.longValue();
            this.is_countdown = r3.e;
            this.ntp_action_id = r3.f;
            this.is_end = r3.g;
            this.end_time_stamp = r3.h;
        }

        public /* synthetic */ TimeProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\b/0123456B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020.H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010%\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010#R\u0015\u0010'\u001a\u0004\u0018\u00010(¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*¨\u00067"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$Builder;Lokio/ByteString;)V", "time_zone_type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimeZoneType;", "getTime_zone_type", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimeZoneType;", "format_type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$FormatType;", "getFormat_type", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$FormatType;", "time_precision_type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimePrecisionType;", "getTime_precision_type", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimePrecisionType;", "time_style", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimeStyle;", "getTime_style", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimeStyle;", "date_precision_type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$DatePrecisionType;", "getDate_precision_type", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$DatePrecisionType;", "date_status_type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$DateStatusType;", "getDate_status_type", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$DateStatusType;", "start_time_stamp", "", "getStart_time_stamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time_stamp", "getEnd_time_stamp", "enable_gmt", "", "getEnable_gmt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "TimeZoneType", "FormatType", "TimePrecisionType", "TimeStyle", "DatePrecisionType", "DateStatusType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TimeZoneProperty extends com.lark.wire.Message<TimeZoneProperty, a> {
        public static final ProtoAdapter<TimeZoneProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final DatePrecisionType DEFAULT_DATE_PRECISION_TYPE = null;
        public static final DateStatusType DEFAULT_DATE_STATUS_TYPE = null;
        public static final boolean DEFAULT_ENABLE_GMT = true;
        public static final FormatType DEFAULT_FORMAT_TYPE = null;
        public static final TimePrecisionType DEFAULT_TIME_PRECISION_TYPE = null;
        public static final TimeStyle DEFAULT_TIME_STYLE = null;
        public static final TimeZoneType DEFAULT_TIME_ZONE_TYPE = null;
        private static final long serialVersionUID = 0;
        private final DatePrecisionType date_precision_type;
        private final DateStatusType date_status_type;
        private final Boolean enable_gmt;
        private final Long end_time_stamp;
        private final FormatType format_type;
        private final Long start_time_stamp;
        private final TimePrecisionType time_precision_type;
        private final TimeStyle time_style;
        private final TimeZoneType time_zone_type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$DatePrecisionType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DAY_TYPE", "MONTH_TYPE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum DatePrecisionType extends Enum<DatePrecisionType> implements o0 {
            public static final ProtoAdapter<DatePrecisionType> ADAPTER = null;
            public static final b Companion = null;
            public static final DatePrecisionType DAY_TYPE = null;
            public static final DatePrecisionType MONTH_TYPE = null;
            public static final /* synthetic */ DatePrecisionType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<DatePrecisionType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    DatePrecisionType.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return DatePrecisionType.MONTH_TYPE;
                L9:
                    return DatePrecisionType.DAY_TYPE;
                }

                public a(KClass<DatePrecisionType> r1, Syntax r2, DatePrecisionType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<DatePrecisionType> getEntries() {
                return b;
            }

            static {
                DatePrecisionType r0 = new DatePrecisionType("DAY_TYPE", 0, 0);
                DAY_TYPE = r0;
                DatePrecisionType r1 = new DatePrecisionType("MONTH_TYPE", 1, 1);
                MONTH_TYPE = r1;
                DatePrecisionType[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(DatePrecisionType.class), Syntax.PROTO_2, r0);
            }

            public static DatePrecisionType[] values() {
                return (DatePrecisionType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final DatePrecisionType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return MONTH_TYPE;
            L9:
                return DAY_TYPE;
            }

            public static DatePrecisionType valueOf(String r1) {
                return (DatePrecisionType) r27.a.a(DatePrecisionType.class, r1);
            }

            public DatePrecisionType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$DateStatusType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ABSOLUTE", "RELATIVE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum DateStatusType extends Enum<DateStatusType> implements o0 {
            public static final DateStatusType ABSOLUTE = null;
            public static final ProtoAdapter<DateStatusType> ADAPTER = null;
            public static final b Companion = null;
            public static final DateStatusType RELATIVE = null;
            public static final /* synthetic */ DateStatusType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<DateStatusType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    DateStatusType.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return DateStatusType.RELATIVE;
                L9:
                    return DateStatusType.ABSOLUTE;
                }

                public a(KClass<DateStatusType> r1, Syntax r2, DateStatusType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<DateStatusType> getEntries() {
                return b;
            }

            static {
                DateStatusType r0 = new DateStatusType("ABSOLUTE", 0, 0);
                ABSOLUTE = r0;
                DateStatusType r1 = new DateStatusType("RELATIVE", 1, 1);
                RELATIVE = r1;
                DateStatusType[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(DateStatusType.class), Syntax.PROTO_2, r0);
            }

            public static DateStatusType[] values() {
                return (DateStatusType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final DateStatusType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return RELATIVE;
            L9:
                return ABSOLUTE;
            }

            public static DateStatusType valueOf(String r1) {
                return (DateStatusType) r27.a.a(DateStatusType.class, r1);
            }

            public DateStatusType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$FormatType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SHORT", "LONG", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum FormatType extends Enum<FormatType> implements o0 {
            public static final ProtoAdapter<FormatType> ADAPTER = null;
            public static final b Companion = null;
            public static final FormatType LONG = null;
            public static final FormatType SHORT = null;
            public static final /* synthetic */ FormatType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<FormatType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    FormatType.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return FormatType.LONG;
                L9:
                    return FormatType.SHORT;
                }

                public a(KClass<FormatType> r1, Syntax r2, FormatType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<FormatType> getEntries() {
                return b;
            }

            static {
                FormatType r0 = new FormatType("SHORT", 0, 0);
                SHORT = r0;
                FormatType r1 = new FormatType("LONG", 1, 1);
                LONG = r1;
                FormatType[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(FormatType.class), Syntax.PROTO_2, r0);
            }

            public static FormatType[] values() {
                return (FormatType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final FormatType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return LONG;
            L9:
                return SHORT;
            }

            public static FormatType valueOf(String r1) {
                return (FormatType) r27.a.a(FormatType.class, r1);
            }

            public FormatType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimePrecisionType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SECOND", "MINUTE", "HOUR", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum TimePrecisionType extends Enum<TimePrecisionType> implements o0 {
            public static final ProtoAdapter<TimePrecisionType> ADAPTER = null;
            public static final b Companion = null;
            public static final TimePrecisionType HOUR = null;
            public static final TimePrecisionType MINUTE = null;
            public static final TimePrecisionType SECOND = null;
            public static final /* synthetic */ TimePrecisionType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<TimePrecisionType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    TimePrecisionType.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return TimePrecisionType.HOUR;
                L15:
                    return TimePrecisionType.MINUTE;
                L12:
                    return TimePrecisionType.SECOND;
                }

                public a(KClass<TimePrecisionType> r1, Syntax r2, TimePrecisionType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<TimePrecisionType> getEntries() {
                return b;
            }

            static {
                TimePrecisionType r0 = new TimePrecisionType("SECOND", 0, 0);
                SECOND = r0;
                TimePrecisionType r1 = new TimePrecisionType("MINUTE", 1, 1);
                MINUTE = r1;
                TimePrecisionType r3 = new TimePrecisionType("HOUR", 2, 2);
                HOUR = r3;
                TimePrecisionType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(TimePrecisionType.class), Syntax.PROTO_2, r0);
            }

            public static TimePrecisionType[] values() {
                return (TimePrecisionType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final TimePrecisionType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return HOUR;
            L15:
                return MINUTE;
            L12:
                return SECOND;
            }

            public static TimePrecisionType valueOf(String r1) {
                return (TimePrecisionType) r27.a.a(TimePrecisionType.class, r1);
            }

            public TimePrecisionType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimeStyle;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "BY_12_HOUR", "BY_24_HOUR", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum TimeStyle extends Enum<TimeStyle> implements o0 {
            public static final ProtoAdapter<TimeStyle> ADAPTER = null;
            public static final TimeStyle BY_12_HOUR = null;
            public static final TimeStyle BY_24_HOUR = null;
            public static final b Companion = null;
            public static final TimeStyle DEFAULT = null;
            public static final /* synthetic */ TimeStyle[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<TimeStyle> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    TimeStyle.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return TimeStyle.BY_24_HOUR;
                L15:
                    return TimeStyle.BY_12_HOUR;
                L12:
                    return TimeStyle.DEFAULT;
                }

                public a(KClass<TimeStyle> r1, Syntax r2, TimeStyle r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<TimeStyle> getEntries() {
                return b;
            }

            static {
                TimeStyle r0 = new TimeStyle("DEFAULT", 0, 0);
                DEFAULT = r0;
                TimeStyle r1 = new TimeStyle("BY_12_HOUR", 1, 1);
                BY_12_HOUR = r1;
                TimeStyle r3 = new TimeStyle("BY_24_HOUR", 2, 2);
                BY_24_HOUR = r3;
                TimeStyle[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(TimeStyle.class), Syntax.PROTO_2, r0);
            }

            public static TimeStyle[] values() {
                return (TimeStyle[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final TimeStyle fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return BY_24_HOUR;
            L15:
                return BY_12_HOUR;
            L12:
                return DEFAULT;
            }

            public static TimeStyle valueOf(String r1) {
                return (TimeStyle) r27.a.a(TimeStyle.class, r1);
            }

            public TimeStyle(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TimeZoneProperty$TimeZoneType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MERIDIEM", "WEEK", "MONTH", "TIME", "DATE", "FULL_DATE", "DATE_TIME", "FULL_DATE_TIME", "DATE_RANGE", "DATE_TIME_RANGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum TimeZoneType extends Enum<TimeZoneType> implements o0 {
            public static final ProtoAdapter<TimeZoneType> ADAPTER = null;
            public static final b Companion = null;
            public static final TimeZoneType DATE = null;
            public static final TimeZoneType DATE_RANGE = null;
            public static final TimeZoneType DATE_TIME = null;
            public static final TimeZoneType DATE_TIME_RANGE = null;
            public static final TimeZoneType FULL_DATE = null;
            public static final TimeZoneType FULL_DATE_TIME = null;
            public static final TimeZoneType MERIDIEM = null;
            public static final TimeZoneType MONTH = null;
            public static final TimeZoneType TIME = null;
            public static final TimeZoneType WEEK = null;
            public static final /* synthetic */ TimeZoneType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<TimeZoneType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    TimeZoneType.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<TimeZoneType> r1, Syntax r2, TimeZoneType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static TimeZoneType a(int r0) {
                    switch(r0) {
                        case 0: goto L14;
                        case 1: goto L24;
                        case 2: goto L23;
                        case 3: goto L22;
                        case 4: goto L21;
                        case 5: goto L20;
                        case 6: goto L19;
                        case 7: goto L18;
                        case 8: goto L17;
                        case 9: goto L16;
                        default: goto L3;
                    };
                L3:
                    return null;
                L16:
                    return TimeZoneType.DATE_TIME_RANGE;
                L17:
                    return TimeZoneType.DATE_RANGE;
                L18:
                    return TimeZoneType.FULL_DATE_TIME;
                L19:
                    return TimeZoneType.DATE_TIME;
                L20:
                    return TimeZoneType.FULL_DATE;
                L21:
                    return TimeZoneType.DATE;
                L22:
                    return TimeZoneType.TIME;
                L23:
                    return TimeZoneType.MONTH;
                L24:
                    return TimeZoneType.WEEK;
                L14:
                    return TimeZoneType.MERIDIEM;
                }
            }

            @JvmStatic
            public static final TimeZoneType fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<TimeZoneType> getEntries() {
                return b;
            }

            static {
                TimeZoneType r0 = new TimeZoneType("MERIDIEM", 0, 0);
                MERIDIEM = r0;
                TimeZoneType r1 = new TimeZoneType("WEEK", 1, 1);
                WEEK = r1;
                TimeZoneType r3 = new TimeZoneType("MONTH", 2, 2);
                MONTH = r3;
                TimeZoneType r5 = new TimeZoneType("TIME", 3, 3);
                TIME = r5;
                TimeZoneType r7 = new TimeZoneType("DATE", 4, 4);
                DATE = r7;
                TimeZoneType r9 = new TimeZoneType("FULL_DATE", 5, 5);
                FULL_DATE = r9;
                TimeZoneType r11 = new TimeZoneType("DATE_TIME", 6, 6);
                DATE_TIME = r11;
                TimeZoneType r13 = new TimeZoneType("FULL_DATE_TIME", 7, 7);
                FULL_DATE_TIME = r13;
                TimeZoneType r15 = new TimeZoneType("DATE_RANGE", 8, 8);
                DATE_RANGE = r15;
                TimeZoneType r14 = new TimeZoneType("DATE_TIME_RANGE", 9, 9);
                DATE_TIME_RANGE = r14;
                TimeZoneType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
                a = r12;
                b = EnumEntriesKt.enumEntries(r12);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(TimeZoneType.class), Syntax.PROTO_2, r0);
            }

            public static TimeZoneType[] values() {
                return (TimeZoneType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static TimeZoneType valueOf(String r1) {
                return (TimeZoneType) r27.a.a(TimeZoneType.class, r1);
            }

            public TimeZoneType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<TimeZoneProperty, a> {
            public TimeZoneType d;
            public FormatType e;
            public TimePrecisionType f;
            public TimeStyle g;
            public DatePrecisionType h;
            public DateStatusType i;
            public Long j;
            public Long k;
            public Boolean l;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TimeZoneProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TimeZoneProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final TimeZoneProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L35;
                switch(r3) {
                    case 1: goto L38;
                    case 2: goto L40;
                    case 3: goto L44;
                    case 4: goto L46;
                    case 5: goto L36;
                    case 6: goto L42;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L36:
                r0.h = DatePrecisionType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L38:
                r0.d = TimeZoneType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
            L32:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L40:
                r0.e = FormatType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
            L28:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L42:
                r0.i = DateStatusType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L44:
                r0.f = TimePrecisionType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            L24:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r8 = Unit.INSTANCE;
                goto L3
            L46:
                r0.g = TimeStyle.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r10 = Unit.INSTANCE;
                goto L3
            L7:
                r0.l = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L8:
                r0.k = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L9:
                r0.j = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L6:
                r9.j(r3);
                goto L3
            L35:
                return new TimeZoneProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TimeZoneProperty r5) {
                TimeZoneProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = (((((r6.unknownFields().size() + TimeZoneType.ADAPTER.l(1, r6.getTime_zone_type())) + FormatType.ADAPTER.l(2, r6.getFormat_type())) + TimePrecisionType.ADAPTER.l(3, r6.getTime_precision_type())) + TimeStyle.ADAPTER.l(4, r6.getTime_style())) + DatePrecisionType.ADAPTER.l(5, r6.getDate_precision_type())) + DateStatusType.ADAPTER.l(6, r6.getDate_status_type());
                t r1 = ProtoAdapter.k;
                return ((r0 + r1.l(7, r6.getStart_time_stamp())) + r1.l(8, r6.getEnd_time_stamp())) + ProtoAdapter.g.l(9, r6.getEnable_gmt());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TimeZoneProperty r5) {
                TimeZoneProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                TimeZoneType.ADAPTER.i(r4, 1, r6.getTime_zone_type());
                FormatType.ADAPTER.i(r4, 2, r6.getFormat_type());
                TimePrecisionType.ADAPTER.i(r4, 3, r6.getTime_precision_type());
                TimeStyle.ADAPTER.i(r4, 4, r6.getTime_style());
                DatePrecisionType.ADAPTER.i(r4, 5, r6.getDate_precision_type());
                DateStatusType.ADAPTER.i(r4, 6, r6.getDate_status_type());
                t r0 = ProtoAdapter.k;
                r0.i(r4, 7, r6.getStart_time_stamp());
                r0.i(r4, 8, r6.getEnd_time_stamp());
                ProtoAdapter.g.i(r4, 9, r6.getEnable_gmt());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TimeZoneProperty r5) {
                TimeZoneProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 9, r6.getEnable_gmt());
                t r0 = ProtoAdapter.k;
                r0.j(r4, 8, r6.getEnd_time_stamp());
                r0.j(r4, 7, r6.getStart_time_stamp());
                DateStatusType.ADAPTER.j(r4, 6, r6.getDate_status_type());
                DatePrecisionType.ADAPTER.j(r4, 5, r6.getDate_precision_type());
                TimeStyle.ADAPTER.j(r4, 4, r6.getTime_style());
                TimePrecisionType.ADAPTER.j(r4, 3, r6.getTime_precision_type());
                FormatType.ADAPTER.j(r4, 2, r6.getFormat_type());
                TimeZoneType.ADAPTER.j(r4, 1, r6.getTime_zone_type());
            }

            public b(FieldEncoding r7, KClass<TimeZoneProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.TimeZoneProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TimeZoneProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_TIME_ZONE_TYPE = TimeZoneType.FULL_DATE_TIME;
            DEFAULT_FORMAT_TYPE = FormatType.LONG;
            DEFAULT_TIME_PRECISION_TYPE = TimePrecisionType.MINUTE;
            DEFAULT_TIME_STYLE = TimeStyle.DEFAULT;
            DEFAULT_DATE_PRECISION_TYPE = DatePrecisionType.DAY_TYPE;
            DEFAULT_DATE_STATUS_TYPE = DateStatusType.RELATIVE;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TimeZoneProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.time_zone_type;
            r0.e = this.format_type;
            r0.f = this.time_precision_type;
            r0.g = this.time_style;
            r0.h = this.date_precision_type;
            r0.i = this.date_status_type;
            r0.j = this.start_time_stamp;
            r0.k = this.end_time_stamp;
            r0.l = this.enable_gmt;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TimeZoneProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final DatePrecisionType getDate_precision_type() {
            return this.date_precision_type;
        }

        public final DateStatusType getDate_status_type() {
            return this.date_status_type;
        }

        public final Boolean getEnable_gmt() {
            return this.enable_gmt;
        }

        public final Long getEnd_time_stamp() {
            return this.end_time_stamp;
        }

        public final FormatType getFormat_type() {
            return this.format_type;
        }

        public final Long getStart_time_stamp() {
            return this.start_time_stamp;
        }

        public final TimePrecisionType getTime_precision_type() {
            return this.time_precision_type;
        }

        public final TimeStyle getTime_style() {
            return this.time_style;
        }

        public final TimeZoneType getTime_zone_type() {
            return this.time_zone_type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TimeZoneProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.time_zone_type = r2.d;
            this.format_type = r2.e;
            this.time_precision_type = r2.f;
            this.time_style = r2.g;
            this.date_precision_type = r2.h;
            this.date_status_type = r2.i;
            this.start_time_stamp = r2.j;
            this.end_time_stamp = r2.k;
            this.enable_gmt = r2.l;
        }

        public /* synthetic */ TimeZoneProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u0000 !2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EMPTY", "LINEAR_LAYOUT", "FLEX_LAYOUT", "HEADER", "RICHTEXT", "IMAGE", "CHATTERS_PREVIEW", "BUTTON", "ICON_BUTTON", "TEXT_BUTTON", "TIME", "TEXT", "TAG_LIST", "SPIN_BUTTON", "AVATAR", "VIDEO", "CARD_CONTAINER", "DOC_IMAGE", "LOADING", "TIME_ZONE", "OVERSIZED_TEXT", "ENGINE", "DOC_STATE_BUTTON", "IMAGE_CONTAINER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AVATAR = null;
        public static final Type BUTTON = null;
        public static final Type CARD_CONTAINER = null;
        public static final Type CHATTERS_PREVIEW = null;
        public static final b Companion = null;
        public static final Type DOC_IMAGE = null;
        public static final Type DOC_STATE_BUTTON = null;
        public static final Type EMPTY = null;
        public static final Type ENGINE = null;
        public static final Type FLEX_LAYOUT = null;
        public static final Type HEADER = null;
        public static final Type ICON_BUTTON = null;
        public static final Type IMAGE = null;
        public static final Type IMAGE_CONTAINER = null;
        public static final Type LINEAR_LAYOUT = null;
        public static final Type LOADING = null;
        public static final Type OVERSIZED_TEXT = null;
        public static final Type RICHTEXT = null;
        public static final Type SPIN_BUTTON = null;
        public static final Type TAG_LIST = null;
        public static final Type TEXT = null;
        public static final Type TEXT_BUTTON = null;
        public static final Type TIME = null;
        public static final Type TIME_ZONE = null;
        public static final Type VIDEO = null;
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
                if (r1 == 0) goto L33;
                if (r1 == 1) goto L57;
                if (r1 == 2) goto L56;
                switch(r1) {
                    case 501: goto L55;
                    case 502: goto L54;
                    case 503: goto L53;
                    case 504: goto L52;
                    case 505: goto L51;
                    case 506: goto L50;
                    case 507: goto L49;
                    case 508: goto L48;
                    case 509: goto L47;
                    case 510: goto L46;
                    case 511: goto L45;
                    case 512: goto L44;
                    case 513: goto L43;
                    case 514: goto L42;
                    case 515: goto L41;
                    case 516: goto L40;
                    case 517: goto L39;
                    case 518: goto L38;
                    case 519: goto L37;
                    case 520: goto L36;
                    case 521: goto L35;
                    default: goto L8;
                };
            L8:
                return null;
            L35:
                return Type.IMAGE_CONTAINER;
            L36:
                return Type.DOC_STATE_BUTTON;
            L37:
                return Type.ENGINE;
            L38:
                return Type.OVERSIZED_TEXT;
            L39:
                return Type.TIME_ZONE;
            L40:
                return Type.LOADING;
            L41:
                return Type.DOC_IMAGE;
            L42:
                return Type.CARD_CONTAINER;
            L43:
                return Type.VIDEO;
            L44:
                return Type.AVATAR;
            L45:
                return Type.SPIN_BUTTON;
            L46:
                return Type.TAG_LIST;
            L47:
                return Type.TEXT;
            L48:
                return Type.TIME;
            L49:
                return Type.TEXT_BUTTON;
            L50:
                return Type.ICON_BUTTON;
            L51:
                return Type.BUTTON;
            L52:
                return Type.CHATTERS_PREVIEW;
            L53:
                return Type.IMAGE;
            L54:
                return Type.RICHTEXT;
            L55:
                return Type.HEADER;
            L56:
                return Type.FLEX_LAYOUT;
            L57:
                return Type.LINEAR_LAYOUT;
            L33:
                return Type.EMPTY;
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
            Type r0 = new Type("EMPTY", 0, 0);
            EMPTY = r0;
            Type r1 = new Type("LINEAR_LAYOUT", 1, 1);
            LINEAR_LAYOUT = r1;
            Type r3 = new Type("FLEX_LAYOUT", 2, 2);
            FLEX_LAYOUT = r3;
            Type r5 = new Type("HEADER", 3, 501);
            HEADER = r5;
            Type r7 = new Type("RICHTEXT", 4, 502);
            RICHTEXT = r7;
            Type r9 = new Type("IMAGE", 5, 503);
            IMAGE = r9;
            Type r11 = new Type("CHATTERS_PREVIEW", 6, 504);
            CHATTERS_PREVIEW = r11;
            Type r13 = new Type("BUTTON", 7, 505);
            BUTTON = r13;
            Type r12 = new Type("ICON_BUTTON", 8, 506);
            ICON_BUTTON = r12;
            Type r10 = new Type("TEXT_BUTTON", 9, 507);
            TEXT_BUTTON = r10;
            Type r8 = new Type("TIME", 10, 508);
            TIME = r8;
            Type r6 = new Type("TEXT", 11, 509);
            TEXT = r6;
            Type r4 = new Type("TAG_LIST", 12, 510);
            TAG_LIST = r4;
            Type r2 = new Type("SPIN_BUTTON", 13, 511);
            SPIN_BUTTON = r2;
            Type r14 = new Type("AVATAR", 14, 512);
            AVATAR = r14;
            Type r15 = new Type("VIDEO", 15, 513);
            VIDEO = r15;
            Type r16 = new Type("CARD_CONTAINER", 16, 514);
            CARD_CONTAINER = r16;
            Type r17 = new Type("DOC_IMAGE", 17, 515);
            DOC_IMAGE = r17;
            Type r19 = new Type("LOADING", 18, 516);
            LOADING = r19;
            Type r20 = new Type("TIME_ZONE", 19, 517);
            TIME_ZONE = r20;
            Type r21 = new Type("OVERSIZED_TEXT", 20, 518);
            OVERSIZED_TEXT = r21;
            Type r22 = new Type("ENGINE", 21, 519);
            ENGINE = r22;
            Type r23 = new Type("DOC_STATE_BUTTON", 22, 520);
            DOC_STATE_BUTTON = r23;
            Type r24 = new Type("IMAGE_CONTAINER", 23, 521);
            IMAGE_CONTAINER = r24;
            Type[] r25 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17, r19, r20, r21, r22, r23, r24};
            a = r25;
            b = EnumEntriesKt.enumEntries(r25);
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

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Value;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Value$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Value$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ValueType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ValueType;", "value", "", "getValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Value extends com.lark.wire.Message<Value, a> {
        public static final ProtoAdapter<Value> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ValueType type;
        private final Float value;

        public static final class a extends com.lark.wire.Message.a<Value, a> {
            public ValueType d;
            public Float e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Value(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Value> {
            @Override // com.lark.wire.ProtoAdapter
            public final Value c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = ValueType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new Value(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Value r5) {
                Value r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ValueType.ADAPTER.l(1, r6.getType())) + ProtoAdapter.n.l(2, r6.getValue());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Value r5) {
                Value r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ValueType.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.n.i(r4, 2, r6.getValue());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Value r5) {
                Value r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.n.j(r4, 2, r6.getValue());
                ValueType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<Value> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.Value", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Value(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Value.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.value;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Value.class).getSimpleName() + '@' + hashCode();
        }

        public final ValueType getType() {
            return this.type;
        }

        public final Float getValue() {
            return this.value;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Value(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.value = r2.e;
        }

        public /* synthetic */ Value(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ValueType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AUTO", "POINT", "PERCENTAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ValueType extends Enum<ValueType> implements o0 {
        public static final ProtoAdapter<ValueType> ADAPTER = null;
        public static final ValueType AUTO = null;
        public static final b Companion = null;
        public static final ValueType PERCENTAGE = null;
        public static final ValueType POINT = null;
        public static final /* synthetic */ ValueType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ValueType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ValueType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return ValueType.PERCENTAGE;
            L15:
                return ValueType.POINT;
            L12:
                return ValueType.AUTO;
            }

            public a(KClass<ValueType> r1, Syntax r2, ValueType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ValueType> getEntries() {
            return b;
        }

        static {
            ValueType r0 = new ValueType("AUTO", 0, 0);
            AUTO = r0;
            ValueType r1 = new ValueType("POINT", 1, 1);
            POINT = r1;
            ValueType r3 = new ValueType("PERCENTAGE", 2, 2);
            PERCENTAGE = r3;
            ValueType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ValueType.class), Syntax.PROTO_2, r0);
        }

        public static ValueType[] values() {
            return (ValueType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ValueType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return PERCENTAGE;
        L15:
            return POINT;
        L12:
            return AUTO;
        }

        public static ValueType valueOf(String r1) {
            return (ValueType) r27.a.a(ValueType.class, r1);
        }

        public ValueType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty$Builder;Lokio/ByteString;)V", "site", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty$Site;", "getSite", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty$Site;", "cover_image", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getCover_image", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "duration", "", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "src_url", "", "getSrc_url", "()Ljava/lang/String;", "vid", "getVid", "iframe_url", "getIframe_url", "cover_image_url", "getCover_image_url", "newBuilder", "toString", "Builder", "Companion", "Site", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class VideoProperty extends com.lark.wire.Message<VideoProperty, a> {
        public static final ProtoAdapter<VideoProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ImageSet cover_image;
        private final String cover_image_url;
        private final Long duration;
        private final String iframe_url;
        private final Site site;
        private final String src_url;
        private final String vid;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$VideoProperty$Site;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "XIGUA", "DOUYIN", "HUOSHAN", "YOUTUBE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Site extends Enum<Site> implements o0 {
            public static final ProtoAdapter<Site> ADAPTER = null;
            public static final b Companion = null;
            public static final Site DOUYIN = null;
            public static final Site HUOSHAN = null;
            public static final Site UNKNOWN = null;
            public static final Site XIGUA = null;
            public static final Site YOUTUBE = null;
            public static final /* synthetic */ Site[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Site> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Site.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<Site> r1, Syntax r2, Site r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static Site a(int r1) {
                    if (r1 == 0) goto L17;
                    if (r1 == 1) goto L22;
                    if (r1 == 2) goto L21;
                    if (r1 == 3) goto L20;
                    if (r1 == 4) goto L19;
                    return null;
                L19:
                    return Site.YOUTUBE;
                L20:
                    return Site.HUOSHAN;
                L21:
                    return Site.DOUYIN;
                L22:
                    return Site.XIGUA;
                L17:
                    return Site.UNKNOWN;
                }
            }

            @JvmStatic
            public static final Site fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<Site> getEntries() {
                return b;
            }

            static {
                Site r0 = new Site("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Site r1 = new Site("XIGUA", 1, 1);
                XIGUA = r1;
                Site r3 = new Site("DOUYIN", 2, 2);
                DOUYIN = r3;
                Site r5 = new Site("HUOSHAN", 3, 3);
                HUOSHAN = r5;
                Site r7 = new Site("YOUTUBE", 4, 4);
                YOUTUBE = r7;
                Site[] r9 = {r0, r1, r3, r5, r7};
                a = r9;
                b = EnumEntriesKt.enumEntries(r9);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Site.class), Syntax.PROTO_2, r0);
            }

            public static Site[] values() {
                return (Site[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static Site valueOf(String r1) {
                return (Site) r27.a.a(Site.class, r1);
            }

            public Site(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<VideoProperty, a> {
            public Site d;
            public ImageSet e;
            public Long f;
            public String g;
            public String h;
            public String i;
            public String j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new VideoProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<VideoProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final VideoProperty c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L18;
                switch(r4) {
                    case 1: goto L19;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r1.d = Site.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.j = r10.i();
                goto L3
            L8:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.i = r10.i();
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.h = r10.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L11:
                r1.f = (Long) ProtoAdapter.k.c(r10);
                goto L3
            L12:
                r1.e = ImageSet.ADAPTER.c(r10);
                goto L3
            L6:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L18:
                return new VideoProperty(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(VideoProperty r5) {
                VideoProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = ((r6.unknownFields().size() + Site.ADAPTER.l(1, r6.getSite())) + ImageSet.ADAPTER.l(2, r6.getCover_image())) + ProtoAdapter.k.l(3, r6.getDuration());
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(4, r6.getSrc_url())) + r1.l(5, r6.getVid())) + r1.l(6, r6.getIframe_url())) + r1.l(7, r6.getCover_image_url());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, VideoProperty r5) {
                VideoProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Site.ADAPTER.i(r4, 1, r6.getSite());
                ImageSet.ADAPTER.i(r4, 2, r6.getCover_image());
                ProtoAdapter.k.i(r4, 3, r6.getDuration());
                w r0 = ProtoAdapter.q;
                r0.i(r4, 4, r6.getSrc_url());
                r0.i(r4, 5, r6.getVid());
                r0.i(r4, 6, r6.getIframe_url());
                r0.i(r4, 7, r6.getCover_image_url());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, VideoProperty r5) {
                VideoProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 7, r6.getCover_image_url());
                r0.j(r4, 6, r6.getIframe_url());
                r0.j(r4, 5, r6.getVid());
                r0.j(r4, 4, r6.getSrc_url());
                ProtoAdapter.k.j(r4, 3, r6.getDuration());
                ImageSet.ADAPTER.j(r4, 2, r6.getCover_image());
                Site.ADAPTER.j(r4, 1, r6.getSite());
            }

            public b(FieldEncoding r7, KClass<VideoProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent.VideoProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ VideoProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VideoProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.site;
            r0.e = this.cover_image;
            r0.f = this.duration;
            r0.g = this.src_url;
            r0.h = this.vid;
            r0.i = this.iframe_url;
            r0.j = this.cover_image_url;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(VideoProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final ImageSet getCover_image() {
            return this.cover_image;
        }

        public final String getCover_image_url() {
            return this.cover_image_url;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final String getIframe_url() {
            return this.iframe_url;
        }

        public final Site getSite() {
            return this.site;
        }

        public final String getSrc_url() {
            return this.src_url;
        }

        public final String getVid() {
            return this.vid;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public VideoProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.site = r2.d;
            this.cover_image = r2.e;
            this.duration = r2.f;
            this.src_url = r2.g;
            this.vid = r2.h;
            this.iframe_url = r2.i;
            this.cover_image_url = r2.j;
        }

        public /* synthetic */ VideoProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<URLPreviewComponent, a> {
        public LoadingProperty A;
        public TimeZoneProperty B;
        public OversizedTextProperty C;
        public EngineProperty D;
        public DocStateButtonProperty E;
        public ImageContainerProperty F;
        public Type d;
        public Boolean e;
        public Style f;
        public List<String> g;
        public Boolean h;
        public EmptyProperty i;
        public LinearLayoutProperty j;
        public FlexLayoutProperty k;
        public PreviewHeaderProperty l;
        public RichTextProperty m;
        public ImageProperty n;
        public ChattersPreviewProperty o;
        public ButtonProperty p;
        public IconButtonProperty q;
        public TextButtonProperty r;
        public TimeProperty s;
        public TextProperty t;
        public TagListProperty u;
        public SpinButtonProperty v;
        public AvatarProperty w;
        public VideoProperty x;
        public CardContainerProperty y;
        public DocImageProperty z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new URLPreviewComponent(this, c(), null);
        }

        public a() {
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<URLPreviewComponent> {
        @Override // com.lark.wire.ProtoAdapter
        public final URLPreviewComponent c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            DefaultConstructorMarker r7 = null;
            if (r5 == (-1)) goto L50;
            if (r5 != 1) goto L8;
            Type r6 = Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
            Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
            r1.d = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
        L48:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L8:
            if (r5 != 2) goto L10;
            r1.e = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L10:
            if (r5 != 3) goto L12;
            r1.f = Style.ADAPTER.c(r11);
            goto L3
        L12:
            if (r5 != 4) goto L14;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L14:
            if (r5 != 5) goto L15;
            r1.h = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L15:
            switch(r5) {
                case 1000: goto L20;
                case 1001: goto L19;
                case 1002: goto L18;
                default: goto L16;
            };
        L18:
            r1.k = FlexLayoutProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L19:
            r1.j = LinearLayoutProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L20:
            r1.i = EmptyProperty.ADAPTER.c(r11);
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L16:
            switch(r5) {
                case 1501: goto L41;
                case 1502: goto L40;
                case 1503: goto L39;
                case 1504: goto L38;
                case 1505: goto L37;
                case 1506: goto L36;
                case 1507: goto L35;
                case 1508: goto L34;
                case 1509: goto L33;
                case 1510: goto L32;
                case 1511: goto L31;
                case 1512: goto L30;
                case 1513: goto L29;
                case 1514: goto L28;
                case 1515: goto L27;
                case 1516: goto L26;
                case 1517: goto L25;
                case 1518: goto L24;
                case 1519: goto L23;
                case 1520: goto L22;
                case 1521: goto L21;
                default: goto L17;
            };
        L21:
            r1.F = ImageContainerProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            goto L3
        L22:
            r1.E = DocStateButtonProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.F = null;
            goto L3
        L23:
            r1.D = EngineProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L24:
            r1.C = OversizedTextProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L25:
            r1.B = TimeZoneProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L26:
            r1.A = LoadingProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L27:
            r1.z = DocImageProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L28:
            r1.y = CardContainerProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L29:
            r1.x = VideoProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L30:
            r1.w = AvatarProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L31:
            r1.v = SpinButtonProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L32:
            r1.u = TagListProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L33:
            r1.t = TextProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L34:
            r1.s = TimeProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L35:
            r1.r = TextButtonProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L36:
            r1.q = IconButtonProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L37:
            r1.p = ButtonProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L38:
            r1.o = ChattersPreviewProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.n = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L39:
            r1.n = ImageProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.m = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L40:
            r1.m = RichTextProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.l = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L41:
            r1.l = PreviewHeaderProperty.ADAPTER.c(r11);
            r1.i = null;
            r1.j = null;
            r1.k = null;
            r1.m = null;
            r1.n = null;
            r1.o = null;
            r1.p = null;
            r1.q = null;
            r1.r = null;
            r1.s = null;
            r1.t = null;
            r1.u = null;
            r1.v = null;
            r1.w = null;
            r1.x = null;
            r1.y = null;
            r1.z = null;
            r1.A = null;
            r1.B = null;
            r1.C = null;
            r1.D = null;
            r1.E = null;
            r1.F = null;
            goto L3
        L17:
            r11.j(r5);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L50:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "child_ids");
            com.lark.wire.internal.a.a(r2);
            r1.g = r2;
            return new URLPreviewComponent(r1, r12, r7);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(URLPreviewComponent r6) {
            URLPreviewComponent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size() + Type.ADAPTER.l(1, r7.getType());
            l r1 = ProtoAdapter.g;
            return (((((((((((((((((((((((((((r0 + r1.l(2, r7.getCan_skip_when_unknown())) + Style.ADAPTER.l(3, r7.getStyle())) + ProtoAdapter.q.a().l(4, r7.getChild_ids())) + r1.l(5, r7.is_font_zoomable())) + EmptyProperty.ADAPTER.l(CommandStatus.DORA_TRACE, r7.getEmpty())) + LinearLayoutProperty.ADAPTER.l(1001, r7.getLinear_layout())) + FlexLayoutProperty.ADAPTER.l(1002, r7.getFlex_layout())) + PreviewHeaderProperty.ADAPTER.l(1501, r7.getHeader())) + RichTextProperty.ADAPTER.l(1502, r7.getRichtext())) + ImageProperty.ADAPTER.l(1503, r7.getImage())) + ChattersPreviewProperty.ADAPTER.l(1504, r7.getChatters_preview())) + ButtonProperty.ADAPTER.l(1505, r7.getButton())) + IconButtonProperty.ADAPTER.l(1506, r7.getIcon_button())) + TextButtonProperty.ADAPTER.l(1507, r7.getText_button())) + TimeProperty.ADAPTER.l(1508, r7.getTime())) + TextProperty.ADAPTER.l(1509, r7.getText())) + TagListProperty.ADAPTER.l(1510, r7.getTag_list())) + SpinButtonProperty.ADAPTER.l(1511, r7.getSpin_button())) + AvatarProperty.ADAPTER.l(1512, r7.getAvatar())) + VideoProperty.ADAPTER.l(1513, r7.getVideo())) + CardContainerProperty.ADAPTER.l(1514, r7.getCard_container())) + DocImageProperty.ADAPTER.l(1515, r7.getDoc_image())) + LoadingProperty.ADAPTER.l(1516, r7.getLoading())) + TimeZoneProperty.ADAPTER.l(1517, r7.getTime_zone())) + OversizedTextProperty.ADAPTER.l(1518, r7.getOversized_text())) + EngineProperty.ADAPTER.l(1519, r7.getEngine())) + DocStateButtonProperty.ADAPTER.l(1520, r7.getDoc_state_button())) + ImageContainerProperty.ADAPTER.l(1521, r7.getImage_container());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, URLPreviewComponent r6) {
            URLPreviewComponent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            Type.ADAPTER.i(r5, 1, r7.getType());
            l r0 = ProtoAdapter.g;
            r0.i(r5, 2, r7.getCan_skip_when_unknown());
            Style.ADAPTER.i(r5, 3, r7.getStyle());
            ProtoAdapter.q.a().i(r5, 4, r7.getChild_ids());
            r0.i(r5, 5, r7.is_font_zoomable());
            EmptyProperty.ADAPTER.i(r5, CommandStatus.DORA_TRACE, r7.getEmpty());
            LinearLayoutProperty.ADAPTER.i(r5, 1001, r7.getLinear_layout());
            FlexLayoutProperty.ADAPTER.i(r5, 1002, r7.getFlex_layout());
            PreviewHeaderProperty.ADAPTER.i(r5, 1501, r7.getHeader());
            RichTextProperty.ADAPTER.i(r5, 1502, r7.getRichtext());
            ImageProperty.ADAPTER.i(r5, 1503, r7.getImage());
            ChattersPreviewProperty.ADAPTER.i(r5, 1504, r7.getChatters_preview());
            ButtonProperty.ADAPTER.i(r5, 1505, r7.getButton());
            IconButtonProperty.ADAPTER.i(r5, 1506, r7.getIcon_button());
            TextButtonProperty.ADAPTER.i(r5, 1507, r7.getText_button());
            TimeProperty.ADAPTER.i(r5, 1508, r7.getTime());
            TextProperty.ADAPTER.i(r5, 1509, r7.getText());
            TagListProperty.ADAPTER.i(r5, 1510, r7.getTag_list());
            SpinButtonProperty.ADAPTER.i(r5, 1511, r7.getSpin_button());
            AvatarProperty.ADAPTER.i(r5, 1512, r7.getAvatar());
            VideoProperty.ADAPTER.i(r5, 1513, r7.getVideo());
            CardContainerProperty.ADAPTER.i(r5, 1514, r7.getCard_container());
            DocImageProperty.ADAPTER.i(r5, 1515, r7.getDoc_image());
            LoadingProperty.ADAPTER.i(r5, 1516, r7.getLoading());
            TimeZoneProperty.ADAPTER.i(r5, 1517, r7.getTime_zone());
            OversizedTextProperty.ADAPTER.i(r5, 1518, r7.getOversized_text());
            EngineProperty.ADAPTER.i(r5, 1519, r7.getEngine());
            DocStateButtonProperty.ADAPTER.i(r5, 1520, r7.getDoc_state_button());
            ImageContainerProperty.ADAPTER.i(r5, 1521, r7.getImage_container());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, URLPreviewComponent r6) {
            URLPreviewComponent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ImageContainerProperty.ADAPTER.j(r5, 1521, r7.getImage_container());
            DocStateButtonProperty.ADAPTER.j(r5, 1520, r7.getDoc_state_button());
            EngineProperty.ADAPTER.j(r5, 1519, r7.getEngine());
            OversizedTextProperty.ADAPTER.j(r5, 1518, r7.getOversized_text());
            TimeZoneProperty.ADAPTER.j(r5, 1517, r7.getTime_zone());
            LoadingProperty.ADAPTER.j(r5, 1516, r7.getLoading());
            DocImageProperty.ADAPTER.j(r5, 1515, r7.getDoc_image());
            CardContainerProperty.ADAPTER.j(r5, 1514, r7.getCard_container());
            VideoProperty.ADAPTER.j(r5, 1513, r7.getVideo());
            AvatarProperty.ADAPTER.j(r5, 1512, r7.getAvatar());
            SpinButtonProperty.ADAPTER.j(r5, 1511, r7.getSpin_button());
            TagListProperty.ADAPTER.j(r5, 1510, r7.getTag_list());
            TextProperty.ADAPTER.j(r5, 1509, r7.getText());
            TimeProperty.ADAPTER.j(r5, 1508, r7.getTime());
            TextButtonProperty.ADAPTER.j(r5, 1507, r7.getText_button());
            IconButtonProperty.ADAPTER.j(r5, 1506, r7.getIcon_button());
            ButtonProperty.ADAPTER.j(r5, 1505, r7.getButton());
            ChattersPreviewProperty.ADAPTER.j(r5, 1504, r7.getChatters_preview());
            ImageProperty.ADAPTER.j(r5, 1503, r7.getImage());
            RichTextProperty.ADAPTER.j(r5, 1502, r7.getRichtext());
            PreviewHeaderProperty.ADAPTER.j(r5, 1501, r7.getHeader());
            FlexLayoutProperty.ADAPTER.j(r5, 1002, r7.getFlex_layout());
            LinearLayoutProperty.ADAPTER.j(r5, 1001, r7.getLinear_layout());
            EmptyProperty.ADAPTER.j(r5, CommandStatus.DORA_TRACE, r7.getEmpty());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 5, r7.is_font_zoomable());
            ProtoAdapter.q.a().j(r5, 4, r7.getChild_ids());
            Style.ADAPTER.j(r5, 3, r7.getStyle());
            r0.j(r5, 2, r7.getCan_skip_when_unknown());
            Type.ADAPTER.j(r5, 1, r7.getType());
        }

        public b(FieldEncoding r7, KClass<URLPreviewComponent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.URLPreviewComponent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ URLPreviewComponent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(URLPreviewComponent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.can_skip_when_unknown;
        r0.f = this.style;
        r0.g = this.child_ids;
        r0.h = this.is_font_zoomable;
        r0.i = this.empty;
        r0.j = this.linear_layout;
        r0.k = this.flex_layout;
        r0.l = this.header;
        r0.m = this.richtext;
        r0.n = this.image;
        r0.o = this.chatters_preview;
        r0.p = this.button;
        r0.q = this.icon_button;
        r0.r = this.text_button;
        r0.s = this.time;
        r0.t = this.text;
        r0.u = this.tag_list;
        r0.v = this.spin_button;
        r0.w = this.avatar;
        r0.x = this.video;
        r0.y = this.card_container;
        r0.z = this.doc_image;
        r0.A = this.loading;
        r0.B = this.time_zone;
        r0.C = this.oversized_text;
        r0.D = this.engine;
        r0.E = this.doc_state_button;
        r0.F = this.image_container;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(URLPreviewComponent.class).getSimpleName() + '@' + hashCode();
    }

    public final AvatarProperty getAvatar() {
        return this.avatar;
    }

    public final ButtonProperty getButton() {
        return this.button;
    }

    public final Boolean getCan_skip_when_unknown() {
        return this.can_skip_when_unknown;
    }

    public final CardContainerProperty getCard_container() {
        return this.card_container;
    }

    public final ChattersPreviewProperty getChatters_preview() {
        return this.chatters_preview;
    }

    public final List<String> getChild_ids() {
        return this.child_ids;
    }

    public final DocImageProperty getDoc_image() {
        return this.doc_image;
    }

    public final DocStateButtonProperty getDoc_state_button() {
        return this.doc_state_button;
    }

    public final EmptyProperty getEmpty() {
        return this.empty;
    }

    public final EngineProperty getEngine() {
        return this.engine;
    }

    public final FlexLayoutProperty getFlex_layout() {
        return this.flex_layout;
    }

    public final PreviewHeaderProperty getHeader() {
        return this.header;
    }

    public final IconButtonProperty getIcon_button() {
        return this.icon_button;
    }

    public final ImageProperty getImage() {
        return this.image;
    }

    public final ImageContainerProperty getImage_container() {
        return this.image_container;
    }

    public final LinearLayoutProperty getLinear_layout() {
        return this.linear_layout;
    }

    public final LoadingProperty getLoading() {
        return this.loading;
    }

    public final OversizedTextProperty getOversized_text() {
        return this.oversized_text;
    }

    public final RichTextProperty getRichtext() {
        return this.richtext;
    }

    public final SpinButtonProperty getSpin_button() {
        return this.spin_button;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final TagListProperty getTag_list() {
        return this.tag_list;
    }

    public final TextProperty getText() {
        return this.text;
    }

    public final TextButtonProperty getText_button() {
        return this.text_button;
    }

    public final TimeProperty getTime() {
        return this.time;
    }

    public final TimeZoneProperty getTime_zone() {
        return this.time_zone;
    }

    public final Type getType() {
        return this.type;
    }

    public final VideoProperty getVideo() {
        return this.video;
    }

    public final Boolean is_font_zoomable() {
        return this.is_font_zoomable;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public URLPreviewComponent(a r26, ByteString r27) {
        super(ADAPTER, r27);
        Type r2 = r26.d;
        Intrinsics.checkNotNull(r2);
        this.type = r2;
        this.can_skip_when_unknown = r26.e;
        this.style = r26.f;
        this.child_ids = com.lark.wire.internal.a.c("child_ids", r26.g);
        this.is_font_zoomable = r26.h;
        EmptyProperty r3 = r26.i;
        this.empty = r3;
        LinearLayoutProperty r4 = r26.j;
        this.linear_layout = r4;
        FlexLayoutProperty r5 = r26.k;
        this.flex_layout = r5;
        PreviewHeaderProperty r6 = r26.l;
        this.header = r6;
        RichTextProperty r7 = r26.m;
        this.richtext = r7;
        ImageProperty r8 = r26.n;
        this.image = r8;
        ChattersPreviewProperty r9 = r26.o;
        this.chatters_preview = r9;
        ButtonProperty r10 = r26.p;
        this.button = r10;
        IconButtonProperty r11 = r26.q;
        this.icon_button = r11;
        TextButtonProperty r12 = r26.r;
        this.text_button = r12;
        TimeProperty r13 = r26.s;
        this.time = r13;
        TextProperty r14 = r26.t;
        this.text = r14;
        TagListProperty r15 = r26.u;
        this.tag_list = r15;
        SpinButtonProperty r16 = r26.v;
        this.spin_button = r16;
        AvatarProperty r17 = r26.w;
        this.avatar = r17;
        VideoProperty r19 = r26.x;
        this.video = r19;
        CardContainerProperty r20 = r26.y;
        this.card_container = r20;
        DocImageProperty r21 = r26.z;
        this.doc_image = r21;
        LoadingProperty r22 = r26.A;
        this.loading = r22;
        TimeZoneProperty r23 = r26.B;
        this.time_zone = r23;
        OversizedTextProperty r24 = r26.C;
        this.oversized_text = r24;
        EngineProperty r25 = r26.D;
        this.engine = r25;
        DocStateButtonProperty r29 = r26.E;
        this.doc_state_button = r29;
        ImageContainerProperty r1 = r26.F;
        this.image_container = r1;
        boolean r210 = false;
        if (com.lark.wire.internal.a.b(r3, r4, r5, r6, new Object[]{r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r29, r1}) > 1) goto L5;
        r210 = true;
    L5:
        if (r210 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("At most one of empty, linear_layout, flex_layout, header, richtext, image, chatters_preview, button, icon_button, text_button, time, text, tag_list, spin_button, avatar, video, card_container, doc_image, loading, time_zone, oversized_text, engine, doc_state_button, image_container may be non-null".toString());
    }

    public /* synthetic */ URLPreviewComponent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 O2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0007NOPQRSTB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010L\u001a\u00020\u0002H\u0016J\b\u0010M\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u00010=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010@\u001a\u0004\u0018\u00010A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010D\u001a\u0004\u0018\u00010E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u0004\u0018\u00010I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010K¨\u0006U"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewData$Builder;Lokio/ByteString;)V", "str", "", "getStr", "()Ljava/lang/String;", "i32", "", "getI32", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "i64", "", "getI64", "()Ljava/lang/Long;", "Ljava/lang/Long;", "b", "", "getB", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "f", "", "getF", "()Ljava/lang/Float;", "Ljava/lang/Float;", "image_set", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getImage_set", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "items", "Lcom/lark/kmp/pb/basic/v1/PreviewData$Items;", "getItems", "()Lcom/lark/kmp/pb/basic/v1/PreviewData$Items;", "theme_color", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getTheme_color", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "padding", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding;", "getPadding", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Padding;", "theme_colors", "Lcom/lark/kmp/pb/basic/v1/PreviewData$ThemeColors;", "getTheme_colors", "()Lcom/lark/kmp/pb/basic/v1/PreviewData$ThemeColors;", "layout_value", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Value;", "getLayout_value", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Value;", "chatter_infos", "Lcom/lark/kmp/pb/basic/v1/PreviewData$ChatterInfos;", "getChatter_infos", "()Lcom/lark/kmp/pb/basic/v1/PreviewData$ChatterInfos;", "string_list", "Lcom/lark/kmp/pb/basic/v1/PreviewData$StringList;", "getString_list", "()Lcom/lark/kmp/pb/basic/v1/PreviewData$StringList;", "chatter_info", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$ChatterInfo;", "getChatter_info", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$AvatarProperty$ChatterInfo;", "font_level", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontLevel;", "getFont_level", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$FontLevel;", "tag_list", "Lcom/lark/kmp/pb/basic/v1/PreviewData$TagList;", "getTag_list", "()Lcom/lark/kmp/pb/basic/v1/PreviewData$TagList;", "newBuilder", "toString", "Builder", "Companion", "Items", "ThemeColors", "ChatterInfos", "StringList", "TagList", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PreviewData extends com.lark.wire.Message<PreviewData, a> {
    public static final ProtoAdapter<PreviewData> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Boolean b;
    private final URLPreviewComponent.AvatarProperty.ChatterInfo chatter_info;
    private final ChatterInfos chatter_infos;
    private final Float f;
    private final URLPreviewComponent.FontLevel font_level;
    private final Integer i32;
    private final Long i64;
    private final ImageSet image_set;
    private final Items items;
    private final URLPreviewComponent.Value layout_value;
    private final URLPreviewComponent.Padding padding;
    private final String str;
    private final StringList string_list;
    private final TagList tag_list;
    private final ThemeColor theme_color;
    private final ThemeColors theme_colors;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewData$ChatterInfos;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewData$ChatterInfos$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewData$ChatterInfos$Builder;Lokio/ByteString;)V", "chatter_infos", "", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$ChattersPreviewProperty$ChatterInfo;", "getChatter_infos", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatterInfos extends com.lark.wire.Message<ChatterInfos, a> {
        public static final ProtoAdapter<ChatterInfos> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> chatter_infos;

        public static final class a extends com.lark.wire.Message.a<ChatterInfos, a> {
            public List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatterInfos(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ChatterInfos> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatterInfos c(g0 r7) {
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
                r1.add(URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "chatter_infos");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new ChatterInfos(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatterInfos r4) {
                ChatterInfos r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.a().l(1, r5.getChatter_infos());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ChatterInfos r5) {
                ChatterInfos r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.a().i(r4, 1, r6.getChatter_infos());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, ChatterInfos r4) {
                ChatterInfos r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.a().j(r3, 1, r5.getChatter_infos());
            }

            public b(FieldEncoding r7, KClass<ChatterInfos> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.PreviewData.ChatterInfos", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatterInfos(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatterInfos.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.chatter_infos;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatterInfos.class).getSimpleName() + '@' + hashCode();
        }

        public final List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> getChatter_infos() {
            return this.chatter_infos;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatterInfos(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.chatter_infos = com.lark.wire.internal.a.c("chatter_infos", r2.d);
        }

        public /* synthetic */ ChatterInfos(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewData$Items;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewData$Items$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewData$Items$Builder;Lokio/ByteString;)V", "items", "", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$Item;", "getItems", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Items extends com.lark.wire.Message<Items, a> {
        public static final ProtoAdapter<Items> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<URLPreviewComponent.Item> items;

        public static final class a extends com.lark.wire.Message.a<Items, a> {
            public List<URLPreviewComponent.Item> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Items(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<Items> {
            @Override // com.lark.wire.ProtoAdapter
            public final Items c(g0 r7) {
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
                r1.add(URLPreviewComponent.Item.ADAPTER.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "items");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new Items(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Items r4) {
                Items r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + URLPreviewComponent.Item.ADAPTER.a().l(1, r5.getItems());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Items r5) {
                Items r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                URLPreviewComponent.Item.ADAPTER.a().i(r4, 1, r6.getItems());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, Items r4) {
                Items r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                URLPreviewComponent.Item.ADAPTER.a().j(r3, 1, r5.getItems());
            }

            public b(FieldEncoding r7, KClass<Items> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.PreviewData.Items", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Items(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Items.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.items;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Items.class).getSimpleName() + '@' + hashCode();
        }

        public final List<URLPreviewComponent.Item> getItems() {
            return this.items;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Items(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.items = com.lark.wire.internal.a.c("items", r2.d);
        }

        public /* synthetic */ Items(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewData$StringList;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewData$StringList$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewData$StringList$Builder;Lokio/ByteString;)V", "string_list", "", "", "getString_list", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class StringList extends com.lark.wire.Message<StringList, a> {
        public static final ProtoAdapter<StringList> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> string_list;

        public static final class a extends com.lark.wire.Message.a<StringList, a> {
            public List<String> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new StringList(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<StringList> {
            @Override // com.lark.wire.ProtoAdapter
            public final StringList c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L9;
                if (r5 == 1) goto L7;
                r8.j(r5);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L9:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "string_list");
                com.lark.wire.internal.a.a(r2);
                r1.d = r2;
                return new StringList(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(StringList r4) {
                StringList r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.a().l(1, r5.getString_list());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, StringList r5) {
                StringList r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.a().i(r4, 1, r6.getString_list());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, StringList r4) {
                StringList r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.a().j(r3, 1, r5.getString_list());
            }

            public b(FieldEncoding r7, KClass<StringList> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.PreviewData.StringList", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ StringList(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(StringList.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.string_list;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(StringList.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getString_list() {
            return this.string_list;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public StringList(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.string_list = com.lark.wire.internal.a.c("string_list", r2.d);
        }

        public /* synthetic */ StringList(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewData$TagList;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewData$TagList$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewData$TagList$Builder;Lokio/ByteString;)V", "mixed_tags", "", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponent$TagListProperty$Tag;", "getMixed_tags", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TagList extends com.lark.wire.Message<TagList, a> {
        public static final ProtoAdapter<TagList> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<URLPreviewComponent.TagListProperty.Tag> mixed_tags;

        public static final class a extends com.lark.wire.Message.a<TagList, a> {
            public List<URLPreviewComponent.TagListProperty.Tag> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TagList(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<TagList> {
            @Override // com.lark.wire.ProtoAdapter
            public final TagList c(g0 r7) {
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
                r1.add(URLPreviewComponent.TagListProperty.Tag.ADAPTER.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "mixed_tags");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new TagList(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TagList r4) {
                TagList r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + URLPreviewComponent.TagListProperty.Tag.ADAPTER.a().l(1, r5.getMixed_tags());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TagList r5) {
                TagList r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                URLPreviewComponent.TagListProperty.Tag.ADAPTER.a().i(r4, 1, r6.getMixed_tags());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, TagList r4) {
                TagList r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                URLPreviewComponent.TagListProperty.Tag.ADAPTER.a().j(r3, 1, r5.getMixed_tags());
            }

            public b(FieldEncoding r7, KClass<TagList> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.PreviewData.TagList", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TagList(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TagList.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.mixed_tags;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TagList.class).getSimpleName() + '@' + hashCode();
        }

        public final List<URLPreviewComponent.TagListProperty.Tag> getMixed_tags() {
            return this.mixed_tags;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TagList(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mixed_tags = com.lark.wire.internal.a.c("mixed_tags", r2.d);
        }

        public /* synthetic */ TagList(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewData$ThemeColors;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewData$ThemeColors$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewData$ThemeColors$Builder;Lokio/ByteString;)V", "colors", "", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getColors", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ThemeColors extends com.lark.wire.Message<ThemeColors, a> {
        public static final ProtoAdapter<ThemeColors> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<ThemeColor> colors;

        public static final class a extends com.lark.wire.Message.a<ThemeColors, a> {
            public List<ThemeColor> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ThemeColors(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ThemeColors> {
            @Override // com.lark.wire.ProtoAdapter
            public final ThemeColors c(g0 r7) {
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
                r1.add(ThemeColor.ADAPTER.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "colors");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new ThemeColors(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ThemeColors r4) {
                ThemeColors r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ThemeColor.ADAPTER.a().l(1, r5.getColors());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ThemeColors r5) {
                ThemeColors r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ThemeColor.ADAPTER.a().i(r4, 1, r6.getColors());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, ThemeColors r4) {
                ThemeColors r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ThemeColor.ADAPTER.a().j(r3, 1, r5.getColors());
            }

            public b(FieldEncoding r7, KClass<ThemeColors> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.PreviewData.ThemeColors", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ThemeColors(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ThemeColors.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.colors;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ThemeColors.class).getSimpleName() + '@' + hashCode();
        }

        public final List<ThemeColor> getColors() {
            return this.colors;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ThemeColors(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.colors = com.lark.wire.internal.a.c("colors", r2.d);
        }

        public /* synthetic */ ThemeColors(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<PreviewData, a> {
        public String d;
        public Integer e;
        public Long f;
        public Boolean g;
        public Float h;
        public ImageSet i;
        public Items j;
        public ThemeColor k;
        public URLPreviewComponent.Padding l;
        public ThemeColors m;
        public URLPreviewComponent.Value n;
        public ChatterInfos o;
        public StringList p;
        public URLPreviewComponent.AvatarProperty.ChatterInfo q;
        public URLPreviewComponent.FontLevel r;
        public TagList s;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new PreviewData(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<PreviewData> {
        @Override // com.lark.wire.ProtoAdapter
        public final PreviewData c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            long r2 = r8.c();
        L3:
            int r4 = r8.e();
            DefaultConstructorMarker r6 = null;
            if (r4 == (-1)) goto L24;
            switch(r4) {
                case 1: goto L22;
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
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L7:
            r1.s = TagList.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L8:
            r1.r = URLPreviewComponent.FontLevel.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L9:
            r1.q = URLPreviewComponent.AvatarProperty.ChatterInfo.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L10:
            r1.p = StringList.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L11:
            r1.o = ChatterInfos.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L12:
            r1.n = URLPreviewComponent.Value.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L13:
            r1.m = ThemeColors.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L14:
            r1.l = URLPreviewComponent.Padding.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L15:
            r1.k = ThemeColor.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L16:
            r1.j = Items.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L17:
            r1.i = ImageSet.ADAPTER.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L18:
            r1.h = (Float) ProtoAdapter.n.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.g = null;
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
            goto L3
        L19:
            r1.g = (Boolean) ProtoAdapter.g.c(r8);
            r1.d = null;
            r1.e = null;
            r1.f = null;
            r1.h = null;
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
            goto L3
        L20:
            r1.f = (Long) ProtoAdapter.k.c(r8);
            r1.d = null;
            r1.e = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L21:
            r1.e = (Integer) ProtoAdapter.h.c(r8);
            r1.d = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L22:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.d = r8.i();
            r1.e = null;
            r1.f = null;
            r1.g = null;
            r1.h = null;
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
            goto L3
        L6:
            r8.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L24:
            return new PreviewData(r1, r8.d(r2), r6);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PreviewData r5) {
            PreviewData r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (((((((((((((((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getStr())) + ProtoAdapter.h.l(2, r6.getI32())) + ProtoAdapter.k.l(3, r6.getI64())) + ProtoAdapter.g.l(4, r6.getB())) + ProtoAdapter.n.l(5, r6.getF())) + ImageSet.ADAPTER.l(6, r6.getImage_set())) + Items.ADAPTER.l(7, r6.getItems())) + ThemeColor.ADAPTER.l(8, r6.getTheme_color())) + URLPreviewComponent.Padding.ADAPTER.l(9, r6.getPadding())) + ThemeColors.ADAPTER.l(10, r6.getTheme_colors())) + URLPreviewComponent.Value.ADAPTER.l(11, r6.getLayout_value())) + ChatterInfos.ADAPTER.l(12, r6.getChatter_infos())) + StringList.ADAPTER.l(13, r6.getString_list())) + URLPreviewComponent.AvatarProperty.ChatterInfo.ADAPTER.l(14, r6.getChatter_info())) + URLPreviewComponent.FontLevel.ADAPTER.l(15, r6.getFont_level())) + TagList.ADAPTER.l(16, r6.getTag_list());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, PreviewData r5) {
            PreviewData r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getStr());
            ProtoAdapter.h.i(r4, 2, r6.getI32());
            ProtoAdapter.k.i(r4, 3, r6.getI64());
            ProtoAdapter.g.i(r4, 4, r6.getB());
            ProtoAdapter.n.i(r4, 5, r6.getF());
            ImageSet.ADAPTER.i(r4, 6, r6.getImage_set());
            Items.ADAPTER.i(r4, 7, r6.getItems());
            ThemeColor.ADAPTER.i(r4, 8, r6.getTheme_color());
            URLPreviewComponent.Padding.ADAPTER.i(r4, 9, r6.getPadding());
            ThemeColors.ADAPTER.i(r4, 10, r6.getTheme_colors());
            URLPreviewComponent.Value.ADAPTER.i(r4, 11, r6.getLayout_value());
            ChatterInfos.ADAPTER.i(r4, 12, r6.getChatter_infos());
            StringList.ADAPTER.i(r4, 13, r6.getString_list());
            URLPreviewComponent.AvatarProperty.ChatterInfo.ADAPTER.i(r4, 14, r6.getChatter_info());
            URLPreviewComponent.FontLevel.ADAPTER.i(r4, 15, r6.getFont_level());
            TagList.ADAPTER.i(r4, 16, r6.getTag_list());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, PreviewData r5) {
            PreviewData r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            TagList.ADAPTER.j(r4, 16, r6.getTag_list());
            URLPreviewComponent.FontLevel.ADAPTER.j(r4, 15, r6.getFont_level());
            URLPreviewComponent.AvatarProperty.ChatterInfo.ADAPTER.j(r4, 14, r6.getChatter_info());
            StringList.ADAPTER.j(r4, 13, r6.getString_list());
            ChatterInfos.ADAPTER.j(r4, 12, r6.getChatter_infos());
            URLPreviewComponent.Value.ADAPTER.j(r4, 11, r6.getLayout_value());
            ThemeColors.ADAPTER.j(r4, 10, r6.getTheme_colors());
            URLPreviewComponent.Padding.ADAPTER.j(r4, 9, r6.getPadding());
            ThemeColor.ADAPTER.j(r4, 8, r6.getTheme_color());
            Items.ADAPTER.j(r4, 7, r6.getItems());
            ImageSet.ADAPTER.j(r4, 6, r6.getImage_set());
            ProtoAdapter.n.j(r4, 5, r6.getF());
            ProtoAdapter.g.j(r4, 4, r6.getB());
            ProtoAdapter.k.j(r4, 3, r6.getI64());
            ProtoAdapter.h.j(r4, 2, r6.getI32());
            ProtoAdapter.q.j(r4, 1, r6.getStr());
        }

        public b(FieldEncoding r7, KClass<PreviewData> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.PreviewData", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PreviewData(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PreviewData.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.str;
        r0.e = this.i32;
        r0.f = this.i64;
        r0.g = this.b;
        r0.h = this.f;
        r0.i = this.image_set;
        r0.j = this.items;
        r0.k = this.theme_color;
        r0.l = this.padding;
        r0.m = this.theme_colors;
        r0.n = this.layout_value;
        r0.o = this.chatter_infos;
        r0.p = this.string_list;
        r0.q = this.chatter_info;
        r0.r = this.font_level;
        r0.s = this.tag_list;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PreviewData.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getB() {
        return this.b;
    }

    public final URLPreviewComponent.AvatarProperty.ChatterInfo getChatter_info() {
        return this.chatter_info;
    }

    public final ChatterInfos getChatter_infos() {
        return this.chatter_infos;
    }

    public final Float getF() {
        return this.f;
    }

    public final URLPreviewComponent.FontLevel getFont_level() {
        return this.font_level;
    }

    public final Integer getI32() {
        return this.i32;
    }

    public final Long getI64() {
        return this.i64;
    }

    public final ImageSet getImage_set() {
        return this.image_set;
    }

    public final Items getItems() {
        return this.items;
    }

    public final URLPreviewComponent.Value getLayout_value() {
        return this.layout_value;
    }

    public final URLPreviewComponent.Padding getPadding() {
        return this.padding;
    }

    public final String getStr() {
        return this.str;
    }

    public final StringList getString_list() {
        return this.string_list;
    }

    public final TagList getTag_list() {
        return this.tag_list;
    }

    public final ThemeColor getTheme_color() {
        return this.theme_color;
    }

    public final ThemeColors getTheme_colors() {
        return this.theme_colors;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public PreviewData(a r19, ByteString r110) {
        super(ADAPTER, r110);
        String r2 = r19.d;
        this.str = r2;
        Integer r3 = r19.e;
        this.i32 = r3;
        Long r4 = r19.f;
        this.i64 = r4;
        Boolean r5 = r19.g;
        this.b = r5;
        Float r6 = r19.h;
        this.f = r6;
        ImageSet r7 = r19.i;
        this.image_set = r7;
        Items r8 = r19.j;
        this.items = r8;
        ThemeColor r9 = r19.k;
        this.theme_color = r9;
        URLPreviewComponent.Padding r10 = r19.l;
        this.padding = r10;
        ThemeColors r11 = r19.m;
        this.theme_colors = r11;
        URLPreviewComponent.Value r12 = r19.n;
        this.layout_value = r12;
        ChatterInfos r13 = r19.o;
        this.chatter_infos = r13;
        StringList r14 = r19.p;
        this.string_list = r14;
        URLPreviewComponent.AvatarProperty.ChatterInfo r15 = r19.q;
        this.chatter_info = r15;
        URLPreviewComponent.FontLevel r16 = r19.r;
        this.font_level = r16;
        TagList r1 = r19.s;
        this.tag_list = r1;
        boolean r17 = false;
        if (com.lark.wire.internal.a.b(r2, r3, r4, r5, new Object[]{r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r1}) > 1) goto L5;
        r17 = true;
    L5:
        if (r17 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("At most one of str, i32, i64, b, f, image_set, items, theme_color, padding, theme_colors, layout_value, chatter_infos, string_list, chatter_info, font_level, tag_list may be non-null".toString());
    }

    public /* synthetic */ PreviewData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

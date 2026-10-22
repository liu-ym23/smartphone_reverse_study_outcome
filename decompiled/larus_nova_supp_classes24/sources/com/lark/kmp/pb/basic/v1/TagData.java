package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TagData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TagData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TagData$Builder;Lokio/ByteString;)V", "tag_data_items", "", "Lcom/lark/kmp/pb/basic/v1/TagData$TagDataItem;", "getTag_data_items", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "TagDataItem", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TagData extends com.lark.wire.Message<TagData, a> {
    public static final ProtoAdapter<TagData> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<TagDataItem> tag_data_items;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TagData$TagDataItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TagData$TagDataItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TagData$TagDataItem$Builder;Lokio/ByteString;)V", "text_val", "", "getText_val", "()Ljava/lang/String;", "tag_id", "getTag_id", "req_tag_type", "Lcom/lark/kmp/pb/basic/v1/RequestTagTypeEnum;", "getReq_tag_type", "()Lcom/lark/kmp/pb/basic/v1/RequestTagTypeEnum;", "resp_tag_type", "Lcom/lark/kmp/pb/basic/v1/ResponseTagTypeEnum;", "getResp_tag_type", "()Lcom/lark/kmp/pb/basic/v1/ResponseTagTypeEnum;", "priority", "", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TagDataItem extends com.lark.wire.Message<TagDataItem, a> {
        public static final ProtoAdapter<TagDataItem> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer priority;
        private final RequestTagTypeEnum req_tag_type;
        private final ResponseTagTypeEnum resp_tag_type;
        private final String tag_id;
        private final String text_val;

        public static final class a extends com.lark.wire.Message.a<TagDataItem, a> {
            public String d;
            public String e;
            public RequestTagTypeEnum f;
            public ResponseTagTypeEnum g;
            public Integer h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TagDataItem(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TagDataItem> {
            @Override // com.lark.wire.ProtoAdapter
            public final TagDataItem c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L28;
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
                r1.f = RequestTagTypeEnum.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L12:
                if (r4 != 4) goto L14;
                r1.g = ResponseTagTypeEnum.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L14:
                if (r4 != 5) goto L15;
                r1.h = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L15:
                r10.j(r4);
                goto L3
            L28:
                return new TagDataItem(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TagDataItem r5) {
                TagDataItem r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((((r0 + r1.l(1, r6.getText_val())) + r1.l(2, r6.getTag_id())) + RequestTagTypeEnum.ADAPTER.l(3, r6.getReq_tag_type())) + ResponseTagTypeEnum.ADAPTER.l(4, r6.getResp_tag_type())) + ProtoAdapter.h.l(5, r6.getPriority());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TagDataItem r5) {
                TagDataItem r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getText_val());
                r0.i(r4, 2, r6.getTag_id());
                RequestTagTypeEnum.ADAPTER.i(r4, 3, r6.getReq_tag_type());
                ResponseTagTypeEnum.ADAPTER.i(r4, 4, r6.getResp_tag_type());
                ProtoAdapter.h.i(r4, 5, r6.getPriority());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, TagDataItem r5) {
                TagDataItem r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 5, r6.getPriority());
                ResponseTagTypeEnum.ADAPTER.j(r4, 4, r6.getResp_tag_type());
                RequestTagTypeEnum.ADAPTER.j(r4, 3, r6.getReq_tag_type());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getTag_id());
                r0.j(r4, 1, r6.getText_val());
            }

            public b(FieldEncoding r7, KClass<TagDataItem> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.TagData.TagDataItem", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TagDataItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TagDataItem.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.text_val;
            r0.e = this.tag_id;
            r0.f = this.req_tag_type;
            r0.g = this.resp_tag_type;
            r0.h = this.priority;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TagDataItem.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getPriority() {
            return this.priority;
        }

        public final RequestTagTypeEnum getReq_tag_type() {
            return this.req_tag_type;
        }

        public final ResponseTagTypeEnum getResp_tag_type() {
            return this.resp_tag_type;
        }

        public final String getTag_id() {
            return this.tag_id;
        }

        public final String getText_val() {
            return this.text_val;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TagDataItem(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.text_val = r2.d;
            this.tag_id = r2.e;
            this.req_tag_type = r2.f;
            this.resp_tag_type = r2.g;
            this.priority = r2.h;
        }

        public /* synthetic */ TagDataItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<TagData, a> {
        public List<TagDataItem> d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TagData(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<TagData> {
        @Override // com.lark.wire.ProtoAdapter
        public final TagData c(g0 r7) {
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
            r1.add(TagDataItem.ADAPTER.c(r7));
            goto L3
        L9:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "tag_data_items");
            com.lark.wire.internal.a.a(r1);
            r0.d = r1;
            return new TagData(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TagData r4) {
            TagData r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + TagDataItem.ADAPTER.a().l(1, r5.getTag_data_items());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TagData r5) {
            TagData r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            TagDataItem.ADAPTER.a().i(r4, 1, r6.getTag_data_items());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, TagData r4) {
            TagData r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            TagDataItem.ADAPTER.a().j(r3, 1, r5.getTag_data_items());
        }

        public b(FieldEncoding r7, KClass<TagData> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TagData", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TagData(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TagData.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.tag_data_items;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TagData.class).getSimpleName() + '@' + hashCode();
    }

    public final List<TagDataItem> getTag_data_items() {
        return this.tag_data_items;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TagData(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.tag_data_items = com.lark.wire.internal.a.c("tag_data_items", r2.d);
    }

    public /* synthetic */ TagData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

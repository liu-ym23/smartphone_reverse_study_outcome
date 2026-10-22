package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TagInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TagInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TagInfo$Builder;Lokio/ByteString;)V", "is_show_tag", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "tag_color", "Lcom/lark/kmp/pb/basic/v1/TagColor;", "getTag_color", "()Lcom/lark/kmp/pb/basic/v1/TagColor;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TagInfo extends com.lark.wire.Message<TagInfo, a> {
    public static final ProtoAdapter<TagInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Boolean is_show_tag;
    private final TagColor tag_color;

    public static final class a extends com.lark.wire.Message.a<TagInfo, a> {
        public Boolean d;
        public TagColor e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TagInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TagInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final TagInfo c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L16;
            if (r3 != 1) goto L8;
            r0.d = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = TagColor.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L9:
            r9.j(r3);
            goto L3
        L16:
            return new TagInfo(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TagInfo r5) {
            TagInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.is_show_tag())) + TagColor.ADAPTER.l(2, r6.getTag_color());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TagInfo r5) {
            TagInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.g.i(r4, 1, r6.is_show_tag());
            TagColor.ADAPTER.i(r4, 2, r6.getTag_color());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TagInfo r5) {
            TagInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            TagColor.ADAPTER.j(r4, 2, r6.getTag_color());
            ProtoAdapter.g.j(r4, 1, r6.is_show_tag());
        }

        public b(FieldEncoding r7, KClass<TagInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TagInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TagInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TagInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.is_show_tag;
        r0.e = this.tag_color;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TagInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final TagColor getTag_color() {
        return this.tag_color;
    }

    public final Boolean is_show_tag() {
        return this.is_show_tag;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TagInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.is_show_tag = r2.d;
        this.tag_color = r2.e;
    }

    public /* synthetic */ TagInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MentionContentStyle;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MentionContentStyle$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MentionContentStyle$Builder;Lokio/ByteString;)V", "is_available", "", "()Z", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MentionContentStyle extends com.lark.wire.Message<MentionContentStyle, a> {
    public static final ProtoAdapter<MentionContentStyle> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final boolean is_available;

    public static final class a extends com.lark.wire.Message.a<MentionContentStyle, a> {
        public Boolean d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MentionContentStyle(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MentionContentStyle> {
        @Override // com.lark.wire.ProtoAdapter
        public final MentionContentStyle c(g0 r6) {
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
            r0.d = Boolean.valueOf(((Boolean) ProtoAdapter.g.c(r6)).booleanValue());
            goto L3
        L10:
            return new MentionContentStyle(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MentionContentStyle r4) {
            MentionContentStyle r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + ProtoAdapter.g.l(1, Boolean.valueOf(r5.is_available()));
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MentionContentStyle r5) {
            MentionContentStyle r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.g.i(r4, 1, Boolean.valueOf(r6.is_available()));
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, MentionContentStyle r4) {
            MentionContentStyle r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            ProtoAdapter.g.j(r3, 1, Boolean.valueOf(r5.is_available()));
        }

        public b(FieldEncoding r7, KClass<MentionContentStyle> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MentionContentStyle", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MentionContentStyle(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MentionContentStyle.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = Boolean.valueOf(this.is_available);
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MentionContentStyle.class).getSimpleName() + '@' + hashCode();
    }

    public final boolean is_available() {
        return this.is_available;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MentionContentStyle(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Boolean r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.is_available = r4.booleanValue();
    }

    public /* synthetic */ MentionContentStyle(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

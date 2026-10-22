package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MeetingNotesInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MeetingNotesInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MeetingNotesInfo$Builder;Lokio/ByteString;)V", "doc_token", "", "getDoc_token", "()Ljava/lang/String;", "doc_type", "Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "getDoc_type", "()Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "docUrl", "getDocUrl", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MeetingNotesInfo extends com.lark.wire.Message<MeetingNotesInfo, a> {
    public static final ProtoAdapter<MeetingNotesInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String docUrl;
    private final String doc_token;
    private final Doc.Type doc_type;

    public static final class a extends com.lark.wire.Message.a<MeetingNotesInfo, a> {
        public String d;
        public Doc.Type e;
        public String f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MeetingNotesInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MeetingNotesInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final MeetingNotesInfo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = Doc.Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
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
            return new MeetingNotesInfo(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MeetingNotesInfo r6) {
            MeetingNotesInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((r0 + r1.l(1, r7.getDoc_token())) + Doc.Type.ADAPTER.l(2, r7.getDoc_type())) + r1.l(3, r7.getDocUrl());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, MeetingNotesInfo r6) {
            MeetingNotesInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getDoc_token());
            Doc.Type.ADAPTER.i(r5, 2, r7.getDoc_type());
            r0.i(r5, 3, r7.getDocUrl());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, MeetingNotesInfo r6) {
            MeetingNotesInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 3, r7.getDocUrl());
            Doc.Type.ADAPTER.j(r5, 2, r7.getDoc_type());
            r0.j(r5, 1, r7.getDoc_token());
        }

        public b(FieldEncoding r7, KClass<MeetingNotesInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MeetingNotesInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MeetingNotesInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MeetingNotesInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.doc_token;
        r0.e = this.doc_type;
        r0.f = this.docUrl;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MeetingNotesInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final String getDocUrl() {
        return this.docUrl;
    }

    public final String getDoc_token() {
        return this.doc_token;
    }

    public final Doc.Type getDoc_type() {
        return this.doc_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MeetingNotesInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.doc_token = r2.d;
        this.doc_type = r2.e;
        this.docUrl = r2.f;
    }

    public /* synthetic */ MeetingNotesInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0015\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo$Builder;Lokio/ByteString;)V", "sub_translate_messages", "", "", "Lcom/lark/kmp/pb/basic/v1/TranslateInfo;", "getSub_translate_messages", "()Ljava/util/Map;", "sub_mf_translate_messages", "", "Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo$SubMfTranslateInfo;", "getSub_mf_translate_messages", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "SubMfTranslateInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SubTranslateInfo extends com.lark.wire.Message<SubTranslateInfo, a> {
    public static final ProtoAdapter<SubTranslateInfo> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final List<SubMfTranslateInfo> sub_mf_translate_messages;
    private final Map<String, TranslateInfo> sub_translate_messages;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo$SubMfTranslateInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo$SubMfTranslateInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo$SubMfTranslateInfo$Builder;Lokio/ByteString;)V", "sub_message_id", "", "getSub_message_id", "()Ljava/lang/String;", "sub_translate_messages", "Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo;", "getSub_translate_messages", "()Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SubMfTranslateInfo extends com.lark.wire.Message<SubMfTranslateInfo, a> {
        public static final ProtoAdapter<SubMfTranslateInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String sub_message_id;
        private final SubTranslateInfo sub_translate_messages;

        public static final class a extends com.lark.wire.Message.a<SubMfTranslateInfo, a> {
            public String d;
            public SubTranslateInfo e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SubMfTranslateInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<SubMfTranslateInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final SubMfTranslateInfo c(g0 r7) {
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
                r1.e = SubTranslateInfo.ADAPTER.c(r7);
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new SubMfTranslateInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SubMfTranslateInfo r5) {
                SubMfTranslateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getSub_message_id())) + SubTranslateInfo.ADAPTER.l(2, r6.getSub_translate_messages());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SubMfTranslateInfo r5) {
                SubMfTranslateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getSub_message_id());
                SubTranslateInfo.ADAPTER.i(r4, 2, r6.getSub_translate_messages());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SubMfTranslateInfo r5) {
                SubMfTranslateInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                SubTranslateInfo.ADAPTER.j(r4, 2, r6.getSub_translate_messages());
                ProtoAdapter.q.j(r4, 1, r6.getSub_message_id());
            }

            public b(FieldEncoding r7, KClass<SubMfTranslateInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.SubTranslateInfo.SubMfTranslateInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SubMfTranslateInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SubMfTranslateInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.sub_message_id;
            r0.e = this.sub_translate_messages;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SubMfTranslateInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getSub_message_id() {
            return this.sub_message_id;
        }

        public final SubTranslateInfo getSub_translate_messages() {
            return this.sub_translate_messages;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SubMfTranslateInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.sub_message_id = r2.d;
            this.sub_translate_messages = r2.e;
        }

        public /* synthetic */ SubMfTranslateInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<SubTranslateInfo, a> {
        public Map<String, TranslateInfo> d;
        public List<SubMfTranslateInfo> e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new SubTranslateInfo(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ SubTranslateInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(SubTranslateInfo.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new SubTranslateInfo$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.sub_translate_messages;
        r0.e = this.sub_mf_translate_messages;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(SubTranslateInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final List<SubMfTranslateInfo> getSub_mf_translate_messages() {
        return this.sub_mf_translate_messages;
    }

    public final Map<String, TranslateInfo> getSub_translate_messages() {
        return this.sub_translate_messages;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public SubTranslateInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.sub_translate_messages = com.lark.wire.internal.a.d("sub_translate_messages", r2.d);
        this.sub_mf_translate_messages = com.lark.wire.internal.a.c("sub_mf_translate_messages", r2.e);
    }

    public /* synthetic */ SubTranslateInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

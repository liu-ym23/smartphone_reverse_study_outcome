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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010'\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0016\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TranslateInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TranslateInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TranslateInfo$Builder;Lokio/ByteString;)V", "message_id", "", "getMessage_id", "()Ljava/lang/String;", "language", "getLanguage", "content", "Lcom/lark/kmp/pb/basic/v1/Content;", "getContent", "()Lcom/lark/kmp/pb/basic/v1/Content;", "message_type", "Lcom/lark/kmp/pb/basic/v1/Message$Type;", "getMessage_type", "()Lcom/lark/kmp/pb/basic/v1/Message$Type;", "is_auto_translate", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "message_source", "Lcom/lark/kmp/pb/basic/v1/MessageSource;", "getMessage_source", "()Lcom/lark/kmp/pb/basic/v1/MessageSource;", "image_translation_info", "Lcom/lark/kmp/pb/basic/v1/ImageTranslationInfo;", "getImage_translation_info", "()Lcom/lark/kmp/pb/basic/v1/ImageTranslationInfo;", "message_content_version", "", "getMessage_content_version", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TranslateInfo extends com.lark.wire.Message<TranslateInfo, a> {
    public static final ProtoAdapter<TranslateInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Content content;
    private final ImageTranslationInfo image_translation_info;
    private final Boolean is_auto_translate;
    private final String language;
    private final Integer message_content_version;
    private final String message_id;
    private final MessageSource message_source;
    private final Message.Type message_type;

    public static final class a extends com.lark.wire.Message.a<TranslateInfo, a> {
        public String d;
        public String e;
        public Content f;
        public Message.Type g;
        public Boolean h;
        public MessageSource i;
        public ImageTranslationInfo j;
        public Integer k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TranslateInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TranslateInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final TranslateInfo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L19;
            switch(r4) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L20;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            Message.Type r5 = Message.Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            Intrinsics.checkNotNullParameter(r5, "message_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            r1.g = r5;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            r1.k = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L8:
            r1.j = ImageTranslationInfo.ADAPTER.c(r10);
            goto L3
        L9:
            r1.i = MessageSource.ADAPTER.c(r10);
            goto L3
        L10:
            r1.h = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L15:
            r1.f = Content.ADAPTER.c(r10);
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r7 = r10.i();
            Intrinsics.checkNotNullParameter(r7, "language");
            r1.e = r7;
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r8 = r10.i();
            Intrinsics.checkNotNullParameter(r8, "message_id");
            r1.d = r8;
            goto L3
        L6:
            r10.j(r4);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L19:
            return new TranslateInfo(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TranslateInfo r5) {
            TranslateInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((((((r0 + r1.l(1, r6.getMessage_id())) + r1.l(2, r6.getLanguage())) + Content.ADAPTER.l(3, r6.getContent())) + Message.Type.ADAPTER.l(4, r6.getMessage_type())) + ProtoAdapter.g.l(5, r6.is_auto_translate())) + MessageSource.ADAPTER.l(6, r6.getMessage_source())) + ImageTranslationInfo.ADAPTER.l(7, r6.getImage_translation_info())) + ProtoAdapter.h.l(8, r6.getMessage_content_version());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TranslateInfo r5) {
            TranslateInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getMessage_id());
            r0.i(r4, 2, r6.getLanguage());
            Content.ADAPTER.i(r4, 3, r6.getContent());
            Message.Type.ADAPTER.i(r4, 4, r6.getMessage_type());
            ProtoAdapter.g.i(r4, 5, r6.is_auto_translate());
            MessageSource.ADAPTER.i(r4, 6, r6.getMessage_source());
            ImageTranslationInfo.ADAPTER.i(r4, 7, r6.getImage_translation_info());
            ProtoAdapter.h.i(r4, 8, r6.getMessage_content_version());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TranslateInfo r5) {
            TranslateInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.h.j(r4, 8, r6.getMessage_content_version());
            ImageTranslationInfo.ADAPTER.j(r4, 7, r6.getImage_translation_info());
            MessageSource.ADAPTER.j(r4, 6, r6.getMessage_source());
            ProtoAdapter.g.j(r4, 5, r6.is_auto_translate());
            Message.Type.ADAPTER.j(r4, 4, r6.getMessage_type());
            Content.ADAPTER.j(r4, 3, r6.getContent());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 2, r6.getLanguage());
            r0.j(r4, 1, r6.getMessage_id());
        }

        public b(FieldEncoding r7, KClass<TranslateInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TranslateInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TranslateInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TranslateInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.message_id;
        r0.e = this.language;
        r0.f = this.content;
        r0.g = this.message_type;
        r0.h = this.is_auto_translate;
        r0.i = this.message_source;
        r0.j = this.image_translation_info;
        r0.k = this.message_content_version;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TranslateInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Content getContent() {
        return this.content;
    }

    public final ImageTranslationInfo getImage_translation_info() {
        return this.image_translation_info;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Integer getMessage_content_version() {
        return this.message_content_version;
    }

    public final String getMessage_id() {
        return this.message_id;
    }

    public final MessageSource getMessage_source() {
        return this.message_source;
    }

    public final Message.Type getMessage_type() {
        return this.message_type;
    }

    public final Boolean is_auto_translate() {
        return this.is_auto_translate;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TranslateInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.message_id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.language = r5;
        Content r6 = r2.f;
        Intrinsics.checkNotNull(r6);
        this.content = r6;
        Message.Type r7 = r2.g;
        Intrinsics.checkNotNull(r7);
        this.message_type = r7;
        this.is_auto_translate = r2.h;
        this.message_source = r2.i;
        this.image_translation_info = r2.j;
        this.message_content_version = r2.k;
    }

    public /* synthetic */ TranslateInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

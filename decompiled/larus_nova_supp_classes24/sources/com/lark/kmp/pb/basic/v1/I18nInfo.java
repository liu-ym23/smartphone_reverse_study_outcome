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
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/I18nInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/I18nInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/I18nInfo$Builder;Lokio/ByteString;)V", "locale_info", "", "", "Lcom/lark/kmp/pb/basic/v1/I18nInfo$LocaleInfo;", "getLocale_info", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "LocaleInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class I18nInfo extends com.lark.wire.Message<I18nInfo, a> {
    public static final ProtoAdapter<I18nInfo> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<String, LocaleInfo> locale_info;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/I18nInfo$LocaleInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/I18nInfo$LocaleInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/I18nInfo$LocaleInfo$Builder;Lokio/ByteString;)V", "content_languages", "", "", "getContent_languages", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LocaleInfo extends com.lark.wire.Message<LocaleInfo, a> {
        public static final ProtoAdapter<LocaleInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> content_languages;

        public static final class a extends com.lark.wire.Message.a<LocaleInfo, a> {
            public List<String> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LocaleInfo(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<LocaleInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final LocaleInfo c(g0 r8) {
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
                Intrinsics.checkNotNullParameter(r2, "content_languages");
                com.lark.wire.internal.a.a(r2);
                r1.d = r2;
                return new LocaleInfo(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LocaleInfo r4) {
                LocaleInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.a().l(1, r5.getContent_languages());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LocaleInfo r5) {
                LocaleInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.a().i(r4, 1, r6.getContent_languages());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, LocaleInfo r4) {
                LocaleInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.a().j(r3, 1, r5.getContent_languages());
            }

            public b(FieldEncoding r7, KClass<LocaleInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.I18nInfo.LocaleInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LocaleInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LocaleInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content_languages;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LocaleInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getContent_languages() {
            return this.content_languages;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LocaleInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.content_languages = com.lark.wire.internal.a.c("content_languages", r2.d);
        }

        public /* synthetic */ LocaleInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<I18nInfo, a> {
        public Map<String, LocaleInfo> d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new I18nInfo(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
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
        ADAPTER = new I18nInfo$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.locale_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(I18nInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, LocaleInfo> getLocale_info() {
        return this.locale_info;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public I18nInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.locale_info = com.lark.wire.internal.a.d("locale_info", r2.d);
    }

    public /* synthetic */ I18nInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

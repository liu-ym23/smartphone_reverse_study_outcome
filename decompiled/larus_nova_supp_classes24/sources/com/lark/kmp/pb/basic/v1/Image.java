package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000b¨\u0006'"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Image;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Image$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Image$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "urls", "", "getUrls", "()Ljava/util/List;", "width", "", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "height", "getHeight", "type", "Lcom/lark/kmp/pb/basic/v1/Image$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Image$Type;", "exif_orientation", "getExif_orientation", "crypto", "getCrypto", "()Lokio/ByteString;", "fs_unit", "getFs_unit", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Image extends com.lark.wire.Message<Image, a> {
    public static final ProtoAdapter<Image> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ByteString crypto;
    private final Integer exif_orientation;
    private final String fs_unit;
    private final Integer height;
    private final String key;
    private final Type type;
    private final List<String> urls;
    private final Integer width;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Image$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "ENCRYPTED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type ENCRYPTED = null;
        public static final Type NORMAL = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return Type.ENCRYPTED;
            L9:
                return Type.NORMAL;
            }

            public a(KClass<Type> r2, Syntax r3) {
                super(r2, r3, null);
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
            Type r0 = new Type("NORMAL", 0, 1);
            NORMAL = r0;
            Type r1 = new Type("ENCRYPTED", 1, 2);
            ENCRYPTED = r1;
            Type[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
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
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return ENCRYPTED;
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

    public static final class a extends com.lark.wire.Message.a<Image, a> {
        public String d;
        public List<String> e;
        public Integer f;
        public Integer g;
        public Type h;
        public Integer i;
        public ByteString j;
        public String k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Image(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Image> {
        @Override // com.lark.wire.ProtoAdapter
        public final Image c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L18;
            switch(r5) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L20;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r1.h = Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.k = r11.i();
            goto L3
        L8:
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.j = r11.f();
            goto L3
        L9:
            r1.i = (Integer) ProtoAdapter.i.c(r11);
            goto L3
        L14:
            r1.g = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L15:
            r1.f = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.d = r11.i();
            goto L3
        L6:
            r11.j(r5);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L18:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "urls");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            return new Image(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Image r6) {
            Image r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r7.getKey())) + r1.a().l(2, r7.getUrls());
            s r3 = ProtoAdapter.h;
            return (((((r2 + r3.l(3, r7.getWidth())) + r3.l(4, r7.getHeight())) + Type.ADAPTER.l(5, r7.getType())) + ProtoAdapter.i.l(6, r7.getExif_orientation())) + ProtoAdapter.p.l(7, r7.getCrypto())) + r1.l(8, r7.getFs_unit());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, Image r6) {
            Image r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getKey());
            r0.a().i(r5, 2, r7.getUrls());
            s r1 = ProtoAdapter.h;
            r1.i(r5, 3, r7.getWidth());
            r1.i(r5, 4, r7.getHeight());
            Type.ADAPTER.i(r5, 5, r7.getType());
            ProtoAdapter.i.i(r5, 6, r7.getExif_orientation());
            ProtoAdapter.p.i(r5, 7, r7.getCrypto());
            r0.i(r5, 8, r7.getFs_unit());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, Image r6) {
            Image r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 8, r7.getFs_unit());
            ProtoAdapter.p.j(r5, 7, r7.getCrypto());
            ProtoAdapter.i.j(r5, 6, r7.getExif_orientation());
            Type.ADAPTER.j(r5, 5, r7.getType());
            s r1 = ProtoAdapter.h;
            r1.j(r5, 4, r7.getHeight());
            r1.j(r5, 3, r7.getWidth());
            r0.a().j(r5, 2, r7.getUrls());
            r0.j(r5, 1, r7.getKey());
        }

        public b(FieldEncoding r7, KClass<Image> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Image", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Image(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Image.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.key;
        r0.e = this.urls;
        r0.f = this.width;
        r0.g = this.height;
        r0.h = this.type;
        r0.i = this.exif_orientation;
        r0.j = this.crypto;
        r0.k = this.fs_unit;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Image.class).getSimpleName() + '@' + hashCode();
    }

    public final ByteString getCrypto() {
        return this.crypto;
    }

    public final Integer getExif_orientation() {
        return this.exif_orientation;
    }

    public final String getFs_unit() {
        return this.fs_unit;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getKey() {
        return this.key;
    }

    public final Type getType() {
        return this.type;
    }

    public final List<String> getUrls() {
        return this.urls;
    }

    public final Integer getWidth() {
        return this.width;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Image(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.key = r2.d;
        this.urls = com.lark.wire.internal.a.c("urls", r2.e);
        this.width = r2.f;
        this.height = r2.g;
        this.type = r2.h;
        this.exif_orientation = r2.i;
        this.crypto = r2.j;
        this.fs_unit = r2.k;
    }

    public /* synthetic */ Image(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

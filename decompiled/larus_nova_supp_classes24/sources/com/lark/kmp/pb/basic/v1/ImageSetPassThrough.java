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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019¨\u0006\""}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "fs_unit", "getFs_unit", "crypto", "Lcom/lark/kmp/pb/basic/v1/SerCrypto;", "getCrypto", "()Lcom/lark/kmp/pb/basic/v1/SerCrypto;", "file_type", "Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough$FileType;", "getFile_type", "()Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough$FileType;", "width", "", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "height", "getHeight", "newBuilder", "toString", "Builder", "Companion", "FileType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ImageSetPassThrough extends com.lark.wire.Message<ImageSetPassThrough, a> {
    public static final ProtoAdapter<ImageSetPassThrough> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final SerCrypto crypto;
    private final FileType file_type;
    private final String fs_unit;
    private final Integer height;
    private final String key;
    private final Integer width;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough$FileType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PROFILE_TOP_IMAGE", "URL_PREVIEW_INLINE_ICON", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FileType extends Enum<FileType> implements o0 {
        public static final ProtoAdapter<FileType> ADAPTER = null;
        public static final b Companion = null;
        public static final FileType PROFILE_TOP_IMAGE = null;
        public static final FileType URL_PREVIEW_INLINE_ICON = null;
        public static final /* synthetic */ FileType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FileType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FileType.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return FileType.URL_PREVIEW_INLINE_ICON;
            L9:
                return FileType.PROFILE_TOP_IMAGE;
            }

            public a(KClass<FileType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FileType> getEntries() {
            return b;
        }

        static {
            FileType r0 = new FileType("PROFILE_TOP_IMAGE", 0, 1);
            PROFILE_TOP_IMAGE = r0;
            FileType r1 = new FileType("URL_PREVIEW_INLINE_ICON", 1, 2);
            URL_PREVIEW_INLINE_ICON = r1;
            FileType[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FileType.class), Syntax.PROTO_2);
        }

        public static FileType[] values() {
            return (FileType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FileType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return URL_PREVIEW_INLINE_ICON;
        L9:
            return PROFILE_TOP_IMAGE;
        }

        public static FileType valueOf(String r1) {
            return (FileType) r27.a.a(FileType.class, r1);
        }

        public FileType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<ImageSetPassThrough, a> {
        public String d;
        public String e;
        public SerCrypto f;
        public FileType g;
        public Integer h;
        public Integer i;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ImageSetPassThrough(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ImageSetPassThrough> {
        @Override // com.lark.wire.ProtoAdapter
        public final ImageSetPassThrough c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L28;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r5 = r10.i();
            Intrinsics.checkNotNullParameter(r5, "key");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L10:
            if (r4 != 4) goto L12;
            r1.f = SerCrypto.ADAPTER.c(r10);
            goto L3
        L12:
            if (r4 != 5) goto L14;
            r1.g = FileType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L14:
            if (r4 != 6) goto L16;
            r1.h = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L16:
            if (r4 != 7) goto L17;
            r1.i = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L17:
            r10.j(r4);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L28:
            return new ImageSetPassThrough(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ImageSetPassThrough r5) {
            ImageSetPassThrough r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((r0 + r1.l(1, r6.getKey())) + r1.l(2, r6.getFs_unit())) + SerCrypto.ADAPTER.l(4, r6.getCrypto())) + FileType.ADAPTER.l(5, r6.getFile_type());
            s r3 = ProtoAdapter.h;
            return (r2 + r3.l(6, r6.getWidth())) + r3.l(7, r6.getHeight());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ImageSetPassThrough r5) {
            ImageSetPassThrough r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getKey());
            r0.i(r4, 2, r6.getFs_unit());
            SerCrypto.ADAPTER.i(r4, 4, r6.getCrypto());
            FileType.ADAPTER.i(r4, 5, r6.getFile_type());
            s r1 = ProtoAdapter.h;
            r1.i(r4, 6, r6.getWidth());
            r1.i(r4, 7, r6.getHeight());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ImageSetPassThrough r5) {
            ImageSetPassThrough r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            s r0 = ProtoAdapter.h;
            r0.j(r4, 7, r6.getHeight());
            r0.j(r4, 6, r6.getWidth());
            FileType.ADAPTER.j(r4, 5, r6.getFile_type());
            SerCrypto.ADAPTER.j(r4, 4, r6.getCrypto());
            w r1 = ProtoAdapter.q;
            r1.j(r4, 2, r6.getFs_unit());
            r1.j(r4, 1, r6.getKey());
        }

        public b(FieldEncoding r7, KClass<ImageSetPassThrough> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ImageSetPassThrough", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ImageSetPassThrough(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ImageSetPassThrough.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.key;
        r0.e = this.fs_unit;
        r0.f = this.crypto;
        r0.g = this.file_type;
        r0.h = this.width;
        r0.i = this.height;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ImageSetPassThrough.class).getSimpleName() + '@' + hashCode();
    }

    public final SerCrypto getCrypto() {
        return this.crypto;
    }

    public final FileType getFile_type() {
        return this.file_type;
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

    public final Integer getWidth() {
        return this.width;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ImageSetPassThrough(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.key = r4;
        this.fs_unit = r2.e;
        this.crypto = r2.f;
        this.file_type = r2.g;
        this.width = r2.h;
        this.height = r2.i;
    }

    public /* synthetic */ ImageSetPassThrough(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

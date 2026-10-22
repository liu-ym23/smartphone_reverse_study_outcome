package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene$Builder;Lokio/ByteString;)V", "clean_resource_scene", "Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene$Enum;", "getClean_resource_scene", "()Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene$Enum;", "newBuilder", "toString", "", "Builder", "Companion", "Enum", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ResourceCleanScene extends com.lark.wire.Message<ResourceCleanScene, a> {
    public static final ProtoAdapter<ResourceCleanScene> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Enum clean_resource_scene;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene$Enum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_RESOURCE_CLEAN_SCENE", "UNIFIED_STORAGE_REGULARLY_DELETE", "CSAM_DELETE", "UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Enum extends java.lang.Enum<Enum> implements o0 {
        public static final ProtoAdapter<Enum> ADAPTER = null;
        public static final Enum CSAM_DELETE = null;
        public static final b Companion = null;
        public static final Enum UNIFIED_STORAGE_REGULARLY_DELETE = null;
        public static final Enum UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = null;
        public static final Enum UNKNOWN_RESOURCE_CLEAN_SCENE = null;
        public static final /* synthetic */ Enum[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Enum> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Enum.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return Enum.UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER;
            L18:
                return Enum.CSAM_DELETE;
            L19:
                return Enum.UNIFIED_STORAGE_REGULARLY_DELETE;
            L15:
                return Enum.UNKNOWN_RESOURCE_CLEAN_SCENE;
            }

            public a(KClass<Enum> r1, Syntax r2, Enum r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Enum> getEntries() {
            return b;
        }

        static {
            Enum r0 = new Enum("UNKNOWN_RESOURCE_CLEAN_SCENE", 0, 0);
            UNKNOWN_RESOURCE_CLEAN_SCENE = r0;
            Enum r1 = new Enum("UNIFIED_STORAGE_REGULARLY_DELETE", 1, 1);
            UNIFIED_STORAGE_REGULARLY_DELETE = r1;
            Enum r3 = new Enum("CSAM_DELETE", 2, 2);
            CSAM_DELETE = r3;
            Enum r5 = new Enum("UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", 3, 3);
            UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = r5;
            Enum[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Enum.class), Syntax.PROTO_2, r0);
        }

        public static Enum[] values() {
            return (Enum[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Enum fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER;
        L18:
            return CSAM_DELETE;
        L19:
            return UNIFIED_STORAGE_REGULARLY_DELETE;
        L15:
            return UNKNOWN_RESOURCE_CLEAN_SCENE;
        }

        public static Enum valueOf(String r1) {
            return (Enum) r27.a.a(Enum.class, r1);
        }

        public Enum(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<ResourceCleanScene, a> {
        public Enum d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ResourceCleanScene(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ResourceCleanScene> {
        @Override // com.lark.wire.ProtoAdapter
        public final ResourceCleanScene c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L11;
            r0.d = Enum.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L11:
            r9.j(r3);
            goto L3
        L13:
            return new ResourceCleanScene(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ResourceCleanScene r4) {
            ResourceCleanScene r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + Enum.ADAPTER.l(1, r5.getClean_resource_scene());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ResourceCleanScene r5) {
            ResourceCleanScene r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Enum.ADAPTER.i(r4, 1, r6.getClean_resource_scene());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, ResourceCleanScene r4) {
            ResourceCleanScene r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            Enum.ADAPTER.j(r3, 1, r5.getClean_resource_scene());
        }

        public b(FieldEncoding r7, KClass<ResourceCleanScene> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ResourceCleanScene", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ResourceCleanScene(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceCleanScene.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.clean_resource_scene;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ResourceCleanScene.class).getSimpleName() + '@' + hashCode();
    }

    public final Enum getClean_resource_scene() {
        return this.clean_resource_scene;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ResourceCleanScene(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.clean_resource_scene = r2.d;
    }

    public /* synthetic */ ResourceCleanScene(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

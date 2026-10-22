package molten_livequery.proto_kmp;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lmolten_livequery/proto_kmp/MoltenContextExtra;", "Lcom/lark/wire/Message;", "Lmolten_livequery/proto_kmp/MoltenContextExtra$Builder;", "_molten_ctx", "Lokio/ByteString;", "unknownFields", "<init>", "(Lokio/ByteString;Lokio/ByteString;)V", "get_molten_ctx", "()Lokio/ByteString;", "newBuilder", "toString", "", "copy", "Builder", "Companion", "molten_livequery_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoltenContextExtra extends Message<MoltenContextExtra, a> {
    public static final ProtoAdapter<MoltenContextExtra> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ByteString _molten_ctx;

    public static final class a extends Message.a<MoltenContextExtra, a> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ByteString f514690d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new MoltenContextExtra(this.f514690d, c());
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MoltenContextExtra> {
        @Override // com.lark.wire.ProtoAdapter
        public final MoltenContextExtra c(g0 r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            long r101 = r100.c();
            ByteString r102 = null;
        L3:
            int r103 = r100.e();
            if (r103 == (-1)) goto L10;
            if (r103 == 255) goto L7;
            r100.j(r103);
            goto L3
        L7:
            ProtoAdapter.f282727p.getClass();
            Intrinsics.checkNotNullParameter(r100, "reader");
            r102 = r100.f();
            goto L3
        L10:
            return new MoltenContextExtra(r102, r100.d(r101));
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MoltenContextExtra r100) {
            MoltenContextExtra r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "value");
            return r101.unknownFields().size() + ProtoAdapter.f282727p.l(255, r101.get_molten_ctx());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r100, MoltenContextExtra r101) {
            MoltenContextExtra r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Intrinsics.checkNotNullParameter(r102, "value");
            ProtoAdapter.f282727p.i(r100, 255, r102.get_molten_ctx());
            r100.a(r102.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r100, MoltenContextExtra r101) {
            MoltenContextExtra r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Intrinsics.checkNotNullParameter(r102, "value");
            r100.d(r102.unknownFields());
            ProtoAdapter.f282727p.j(r100, 255, r102.get_molten_ctx());
        }

        public b(FieldEncoding r100, KClass<MoltenContextExtra> r101, Syntax r102) {
            super(r100, r101, "type.googleapis.com/molten_livequery.proto_kmp.MoltenContextExtra", r102, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MoltenContextExtra() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MoltenContextExtra.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r100 = new a();
        r100.f514690d = this._molten_ctx;
        r100.a(unknownFields());
        return r100;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MoltenContextExtra.class).getSimpleName() + '@' + hashCode();
    }

    public final ByteString get_molten_ctx() {
        return this._molten_ctx;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public MoltenContextExtra(ByteString r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r101, "unknownFields");
        super(ADAPTER, r101);
        this._molten_ctx = r100;
    }

    public final MoltenContextExtra copy(ByteString r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r101, "unknownFields");
        return new MoltenContextExtra(r100, r101);
    }

    public /* synthetic */ MoltenContextExtra(ByteString r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = ByteString.EMPTY;
    L8:
        this(r100, r101);
    }

    public static /* synthetic */ MoltenContextExtra copy$default(MoltenContextExtra r100, ByteString r101, ByteString r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100._molten_ctx;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.unknownFields();
    L9:
        return r100.copy(r101, r102);
    }
}

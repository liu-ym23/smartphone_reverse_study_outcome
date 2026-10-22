package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/AbbreviationEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/AbbreviationEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/AbbreviationEntity$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "version", "", "getVersion", "()I", "full_name", "getFull_name", "i18n_desc", "getI18n_desc", "metadata", "", "getMetadata", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AbbreviationEntity extends com.lark.wire.Message<AbbreviationEntity, a> {
    public static final ProtoAdapter<AbbreviationEntity> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final String full_name;
    private final String i18n_desc;
    private final String id;
    private final Map<String, String> metadata;
    private final String name;
    private final int version;

    public static final class a extends com.lark.wire.Message.a<AbbreviationEntity, a> {
        public String d;
        public String e;
        public Integer f;
        public String g;
        public String h;
        public Map<String, String> i;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new AbbreviationEntity(this, c(), null);
        }

        public a() {
            this.i = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ AbbreviationEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(AbbreviationEntity.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new AbbreviationEntity$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.name;
        r0.f = Integer.valueOf(this.version);
        r0.g = this.full_name;
        r0.h = this.i18n_desc;
        r0.i = this.metadata;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AbbreviationEntity.class).getSimpleName() + '@' + hashCode();
    }

    public final String getFull_name() {
        return this.full_name;
    }

    public final String getI18n_desc() {
        return this.i18n_desc;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final String getName() {
        return this.name;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public AbbreviationEntity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.name = r5;
        Integer r6 = r2.f;
        Intrinsics.checkNotNull(r6);
        this.version = r6.intValue();
        String r7 = r2.g;
        Intrinsics.checkNotNull(r7);
        this.full_name = r7;
        this.i18n_desc = r2.h;
        this.metadata = com.lark.wire.internal.a.d("metadata", r2.i);
    }

    public /* synthetic */ AbbreviationEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

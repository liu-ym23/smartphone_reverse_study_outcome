package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RenderRouterEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/RenderRouterEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/RenderRouterEntity$Builder;Lokio/ByteString;)V", "root_id", "", "getRoot_id", "()Ljava/lang/String;", "elements", "", "Lcom/lark/kmp/pb/basic/v1/CardComponent;", "getElements", "()Ljava/util/Map;", "engine_entities", "Lcom/lark/kmp/pb/basic/v1/EngineEntity;", "getEngine_entities", "width_mode", "getWidth_mode", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RenderRouterEntity extends com.lark.wire.Message<RenderRouterEntity, a> {
    public static final ProtoAdapter<RenderRouterEntity> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<String, CardComponent> elements;
    private final Map<String, EngineEntity> engine_entities;
    private final String root_id;
    private final String width_mode;

    public static final class a extends com.lark.wire.Message.a<RenderRouterEntity, a> {
        public String d;
        public Map<String, CardComponent> e;
        public Map<String, EngineEntity> f;
        public String g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new RenderRouterEntity(this, c(), null);
        }

        public a() {
            this.e = MapsKt.emptyMap();
            this.f = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ RenderRouterEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(RenderRouterEntity.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new RenderRouterEntity$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.root_id;
        r0.e = this.elements;
        r0.f = this.engine_entities;
        r0.g = this.width_mode;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(RenderRouterEntity.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, CardComponent> getElements() {
        return this.elements;
    }

    public final Map<String, EngineEntity> getEngine_entities() {
        return this.engine_entities;
    }

    public final String getRoot_id() {
        return this.root_id;
    }

    public final String getWidth_mode() {
        return this.width_mode;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public RenderRouterEntity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.root_id = r2.d;
        this.elements = com.lark.wire.internal.a.d("elements", r2.e);
        this.engine_entities = com.lark.wire.internal.a.d("engine_entities", r2.f);
        this.width_mode = r2.g;
    }

    public /* synthetic */ RenderRouterEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

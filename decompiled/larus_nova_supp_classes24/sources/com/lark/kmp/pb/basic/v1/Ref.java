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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Ref;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Ref$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Ref$Builder;Lokio/ByteString;)V", "span", "Lcom/lark/kmp/pb/basic/v1/Span;", "getSpan", "()Lcom/lark/kmp/pb/basic/v1/Span;", "matched_word", "", "getMatched_word", "()Ljava/lang/String;", "platform_disable_option", "", "getPlatform_disable_option", "()Ljava/util/Map;", "baike_entity_meta", "Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta;", "getBaike_entity_meta", "()Lcom/lark/kmp/pb/basic/v1/BaikeEntityMeta;", "calendar_entity_meta", "Lcom/lark/kmp/pb/basic/v1/CalendarEntityMeta;", "getCalendar_entity_meta", "()Lcom/lark/kmp/pb/basic/v1/CalendarEntityMeta;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Ref extends com.lark.wire.Message<Ref, a> {
    public static final ProtoAdapter<Ref> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final BaikeEntityMeta baike_entity_meta;
    private final CalendarEntityMeta calendar_entity_meta;
    private final String matched_word;
    private final Map<String, String> platform_disable_option;
    private final Span span;

    public static final class a extends com.lark.wire.Message.a<Ref, a> {
        public Span d;
        public String e;
        public Map<String, String> f;
        public BaikeEntityMeta g;
        public CalendarEntityMeta h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Ref(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ Ref(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(Ref.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new Ref$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.span;
        r0.e = this.matched_word;
        r0.f = this.platform_disable_option;
        r0.g = this.baike_entity_meta;
        r0.h = this.calendar_entity_meta;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Ref.class).getSimpleName() + '@' + hashCode();
    }

    public final BaikeEntityMeta getBaike_entity_meta() {
        return this.baike_entity_meta;
    }

    public final CalendarEntityMeta getCalendar_entity_meta() {
        return this.calendar_entity_meta;
    }

    public final String getMatched_word() {
        return this.matched_word;
    }

    public final Map<String, String> getPlatform_disable_option() {
        return this.platform_disable_option;
    }

    public final Span getSpan() {
        return this.span;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Ref(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Span r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.span = r4;
        this.matched_word = r2.e;
        this.platform_disable_option = com.lark.wire.internal.a.d("platform_disable_option", r2.f);
        this.baike_entity_meta = r2.g;
        this.calendar_entity_meta = r2.h;
    }

    public /* synthetic */ Ref(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

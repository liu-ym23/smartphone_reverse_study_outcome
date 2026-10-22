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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/HongbaoSystemContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/HongbaoSystemContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/HongbaoSystemContent$Builder;Lokio/ByteString;)V", "wallet", "", "", "getWallet", "()Ljava/util/Map;", "hongbao_id", "getHongbao_id", "()Ljava/lang/String;", "message_id", "getMessage_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class HongbaoSystemContent extends com.lark.wire.Message<HongbaoSystemContent, a> {
    public static final ProtoAdapter<HongbaoSystemContent> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final String hongbao_id;
    private final String message_id;
    private final Map<String, String> wallet;

    public static final class a extends com.lark.wire.Message.a<HongbaoSystemContent, a> {
        public Map<String, String> d;
        public String e;
        public String f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new HongbaoSystemContent(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ HongbaoSystemContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(HongbaoSystemContent.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new HongbaoSystemContent$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.wallet;
        r0.e = this.hongbao_id;
        r0.f = this.message_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(HongbaoSystemContent.class).getSimpleName() + '@' + hashCode();
    }

    public final String getHongbao_id() {
        return this.hongbao_id;
    }

    public final String getMessage_id() {
        return this.message_id;
    }

    public final Map<String, String> getWallet() {
        return this.wallet;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public HongbaoSystemContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.wallet = com.lark.wire.internal.a.d("wallet", r2.d);
        this.hongbao_id = r2.e;
        this.message_id = r2.f;
    }

    public /* synthetic */ HongbaoSystemContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/BotAutoMuteConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/BotAutoMuteConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/BotAutoMuteConfig$Builder;Lokio/ByteString;)V", "bot_id", "", "getBot_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "mute_config", "Lcom/lark/kmp/pb/basic/v1/AutoMuteConfig;", "getMute_config", "()Lcom/lark/kmp/pb/basic/v1/AutoMuteConfig;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class BotAutoMuteConfig extends com.lark.wire.Message<BotAutoMuteConfig, a> {
    public static final ProtoAdapter<BotAutoMuteConfig> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long bot_id;
    private final AutoMuteConfig mute_config;

    public static final class a extends com.lark.wire.Message.a<BotAutoMuteConfig, a> {
        public Long d;
        public AutoMuteConfig e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new BotAutoMuteConfig(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<BotAutoMuteConfig> {
        @Override // com.lark.wire.ProtoAdapter
        public final BotAutoMuteConfig c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L8;
            r0.d = (Long) ProtoAdapter.k.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = AutoMuteConfig.ADAPTER.c(r6);
            goto L3
        L9:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L13:
            return new BotAutoMuteConfig(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(BotAutoMuteConfig r5) {
            BotAutoMuteConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.k.l(1, r6.getBot_id())) + AutoMuteConfig.ADAPTER.l(2, r6.getMute_config());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, BotAutoMuteConfig r5) {
            BotAutoMuteConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.k.i(r4, 1, r6.getBot_id());
            AutoMuteConfig.ADAPTER.i(r4, 2, r6.getMute_config());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, BotAutoMuteConfig r5) {
            BotAutoMuteConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            AutoMuteConfig.ADAPTER.j(r4, 2, r6.getMute_config());
            ProtoAdapter.k.j(r4, 1, r6.getBot_id());
        }

        public b(FieldEncoding r7, KClass<BotAutoMuteConfig> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.BotAutoMuteConfig", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ BotAutoMuteConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BotAutoMuteConfig.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.bot_id;
        r0.e = this.mute_config;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(BotAutoMuteConfig.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getBot_id() {
        return this.bot_id;
    }

    public final AutoMuteConfig getMute_config() {
        return this.mute_config;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public BotAutoMuteConfig(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.bot_id = r2.d;
        this.mute_config = r2.e;
    }

    public /* synthetic */ BotAutoMuteConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

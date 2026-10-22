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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/BannerSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/BannerSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/BannerSetting$Builder;Lokio/ByteString;)V", "chat_message_position", "", "getChat_message_position", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "chat_thread_position", "getChat_thread_position", "i18n_names", "", "", "getI18n_names", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class BannerSetting extends com.lark.wire.Message<BannerSetting, a> {
    public static final ProtoAdapter<BannerSetting> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer chat_message_position;
    private final Integer chat_thread_position;
    private final Map<String, String> i18n_names;

    public static final class a extends com.lark.wire.Message.a<BannerSetting, a> {
        public Integer d;
        public Integer e;
        public Map<String, String> f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new BannerSetting(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ BannerSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(BannerSetting.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new BannerSetting$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_message_position;
        r0.e = this.chat_thread_position;
        r0.f = this.i18n_names;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(BannerSetting.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getChat_message_position() {
        return this.chat_message_position;
    }

    public final Integer getChat_thread_position() {
        return this.chat_thread_position;
    }

    public final Map<String, String> getI18n_names() {
        return this.i18n_names;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public BannerSetting(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.chat_message_position = r2.d;
        this.chat_thread_position = r2.e;
        this.i18n_names = com.lark.wire.internal.a.d("i18n_names", r2.f);
    }

    public /* synthetic */ BannerSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

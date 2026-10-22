package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u001b\u0010\nR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TnsSystemBannedInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TnsSystemBannedInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TnsSystemBannedInfo$Builder;Lokio/ByteString;)V", "is_banned", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "expire_at", "", "getExpire_at", "()Ljava/lang/Long;", "Ljava/lang/Long;", "appeal_urls", "", "", "getAppeal_urls", "()Ljava/util/Map;", "blocked_features", "", "Lcom/lark/kmp/pb/basic/v1/TnsBlockedFeature;", "getBlocked_features", "()Ljava/util/List;", "is_permanent", "appeal_url", "getAppeal_url", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TnsSystemBannedInfo extends com.lark.wire.Message<TnsSystemBannedInfo, a> {
    public static final ProtoAdapter<TnsSystemBannedInfo> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final String appeal_url;
    private final Map<String, String> appeal_urls;
    private final List<TnsBlockedFeature> blocked_features;
    private final Long expire_at;
    private final Boolean is_banned;
    private final Boolean is_permanent;

    public static final class a extends com.lark.wire.Message.a<TnsSystemBannedInfo, a> {
        public Boolean d;
        public Long e;
        public Map<String, String> f;
        public List<? extends TnsBlockedFeature> g;
        public Boolean h;
        public String i;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TnsSystemBannedInfo(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ TnsSystemBannedInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(TnsSystemBannedInfo.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new TnsSystemBannedInfo$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.is_banned;
        r0.e = this.expire_at;
        r0.f = this.appeal_urls;
        r0.g = this.blocked_features;
        r0.h = this.is_permanent;
        r0.i = this.appeal_url;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TnsSystemBannedInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAppeal_url() {
        return this.appeal_url;
    }

    public final Map<String, String> getAppeal_urls() {
        return this.appeal_urls;
    }

    public final List<TnsBlockedFeature> getBlocked_features() {
        return this.blocked_features;
    }

    public final Long getExpire_at() {
        return this.expire_at;
    }

    public final Boolean is_banned() {
        return this.is_banned;
    }

    public final Boolean is_permanent() {
        return this.is_permanent;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TnsSystemBannedInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.is_banned = r2.d;
        this.expire_at = r2.e;
        this.appeal_urls = com.lark.wire.internal.a.d("appeal_urls", r2.f);
        this.blocked_features = com.lark.wire.internal.a.c("blocked_features", r2.g);
        this.is_permanent = r2.h;
        this.appeal_url = r2.i;
    }

    public /* synthetic */ TnsSystemBannedInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

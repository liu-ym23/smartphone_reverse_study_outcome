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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001d0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006#"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/URLPreviewBody;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/URLPreviewBody$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/URLPreviewBody$Builder;Lokio/ByteString;)V", "components", "Lcom/lark/kmp/pb/basic/v1/URLPreviewComponents;", "getComponents", "()Lcom/lark/kmp/pb/basic/v1/URLPreviewComponents;", "actions", "", "", "Lcom/lark/kmp/pb/basic/v1/UrlPreviewAction;", "getActions", "()Ljava/util/Map;", "card_url", "Lcom/lark/kmp/pb/basic/v1/URL;", "getCard_url", "()Lcom/lark/kmp/pb/basic/v1/URL;", "current_state_id", "getCurrent_state_id", "()Ljava/lang/String;", "states", "Lcom/lark/kmp/pb/basic/v1/URLPreviewState;", "getStates", "component_hang_point_pairs", "Lcom/lark/kmp/pb/basic/v1/PreviewHangPointPair;", "getComponent_hang_point_pairs", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class URLPreviewBody extends com.lark.wire.Message<URLPreviewBody, a> {
    public static final ProtoAdapter<URLPreviewBody> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<String, UrlPreviewAction> actions;
    private final URL card_url;
    private final Map<String, PreviewHangPointPair> component_hang_point_pairs;
    private final URLPreviewComponents components;
    private final String current_state_id;
    private final Map<String, URLPreviewState> states;

    public static final class a extends com.lark.wire.Message.a<URLPreviewBody, a> {
        public URLPreviewComponents d;
        public Map<String, UrlPreviewAction> e;
        public URL f;
        public String g;
        public Map<String, URLPreviewState> h;
        public Map<String, PreviewHangPointPair> i;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new URLPreviewBody(this, c(), null);
        }

        public a() {
            this.e = MapsKt.emptyMap();
            this.h = MapsKt.emptyMap();
            this.i = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ URLPreviewBody(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(URLPreviewBody.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new URLPreviewBody$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.components;
        r0.e = this.actions;
        r0.f = this.card_url;
        r0.g = this.current_state_id;
        r0.h = this.states;
        r0.i = this.component_hang_point_pairs;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(URLPreviewBody.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, UrlPreviewAction> getActions() {
        return this.actions;
    }

    public final URL getCard_url() {
        return this.card_url;
    }

    public final Map<String, PreviewHangPointPair> getComponent_hang_point_pairs() {
        return this.component_hang_point_pairs;
    }

    public final URLPreviewComponents getComponents() {
        return this.components;
    }

    public final String getCurrent_state_id() {
        return this.current_state_id;
    }

    public final Map<String, URLPreviewState> getStates() {
        return this.states;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public URLPreviewBody(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.components = r2.d;
        this.actions = com.lark.wire.internal.a.d("actions", r2.e);
        this.card_url = r2.f;
        this.current_state_id = r2.g;
        this.states = com.lark.wire.internal.a.d("states", r2.h);
        this.component_hang_point_pairs = com.lark.wire.internal.a.d("component_hang_point_pairs", r2.i);
    }

    public /* synthetic */ URLPreviewBody(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

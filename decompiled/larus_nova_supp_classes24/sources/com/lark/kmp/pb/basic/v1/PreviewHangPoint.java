package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewHangPoint;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewHangPoint$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewHangPoint$Builder;Lokio/ByteString;)V", "preview_id", "", "getPreview_id", "()Ljava/lang/String;", "need_local_preview", "", "getNeed_local_preview", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "close_card_preview", "getClose_card_preview", "url", "getUrl", "is_lazy_load", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PreviewHangPoint extends com.lark.wire.Message<PreviewHangPoint, a> {
    public static final ProtoAdapter<PreviewHangPoint> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_CLOSE_CARD_PREVIEW = false;
    public static final boolean DEFAULT_IS_LAZY_LOAD = false;
    public static final boolean DEFAULT_NEED_LOCAL_PREVIEW = false;
    private static final long serialVersionUID = 0;
    private final Boolean close_card_preview;
    private final Boolean is_lazy_load;
    private final Boolean need_local_preview;
    private final String preview_id;
    private final String url;

    public static final class a extends com.lark.wire.Message.a<PreviewHangPoint, a> {
        public String d;
        public Boolean e;
        public Boolean f;
        public String g;
        public Boolean h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new PreviewHangPoint(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<PreviewHangPoint> {
        @Override // com.lark.wire.ProtoAdapter
        public final PreviewHangPoint c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L22;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L14;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.g = r7.i();
            goto L3
        L14:
            if (r4 != 5) goto L15;
            r1.h = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L15:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L22:
            return new PreviewHangPoint(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PreviewHangPoint r6) {
            PreviewHangPoint r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = r0 + r1.l(1, r7.getPreview_id());
            l r3 = ProtoAdapter.g;
            return (((r2 + r3.l(2, r7.getNeed_local_preview())) + r3.l(3, r7.getClose_card_preview())) + r1.l(4, r7.getUrl())) + r3.l(5, r7.is_lazy_load());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, PreviewHangPoint r6) {
            PreviewHangPoint r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getPreview_id());
            l r1 = ProtoAdapter.g;
            r1.i(r5, 2, r7.getNeed_local_preview());
            r1.i(r5, 3, r7.getClose_card_preview());
            r0.i(r5, 4, r7.getUrl());
            r1.i(r5, 5, r7.is_lazy_load());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, PreviewHangPoint r6) {
            PreviewHangPoint r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 5, r7.is_lazy_load());
            w r1 = ProtoAdapter.q;
            r1.j(r5, 4, r7.getUrl());
            r0.j(r5, 3, r7.getClose_card_preview());
            r0.j(r5, 2, r7.getNeed_local_preview());
            r1.j(r5, 1, r7.getPreview_id());
        }

        public b(FieldEncoding r7, KClass<PreviewHangPoint> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.PreviewHangPoint", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PreviewHangPoint(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PreviewHangPoint.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.preview_id;
        r0.e = this.need_local_preview;
        r0.f = this.close_card_preview;
        r0.g = this.url;
        r0.h = this.is_lazy_load;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PreviewHangPoint.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getClose_card_preview() {
        return this.close_card_preview;
    }

    public final Boolean getNeed_local_preview() {
        return this.need_local_preview;
    }

    public final String getPreview_id() {
        return this.preview_id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean is_lazy_load() {
        return this.is_lazy_load;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public PreviewHangPoint(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.preview_id = r2.d;
        this.need_local_preview = r2.e;
        this.close_card_preview = r2.f;
        this.url = r2.g;
        this.is_lazy_load = r2.h;
    }

    public /* synthetic */ PreviewHangPoint(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageAnalysisConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageAnalysisConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageAnalysisConfig$Builder;Lokio/ByteString;)V", "title_item", "Lcom/lark/kmp/pb/basic/v1/MessageAnalysisItem;", "getTitle_item", "()Lcom/lark/kmp/pb/basic/v1/MessageAnalysisItem;", "description", "", "getDescription", "()Ljava/lang/String;", "analysis_items", "", "getAnalysis_items", "()Ljava/util/List;", "has_config", "", "getHas_config", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "content", "Lcom/lark/kmp/pb/basic/v1/MessageAnalysisContent;", "getContent", "()Lcom/lark/kmp/pb/basic/v1/MessageAnalysisContent;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MessageAnalysisConfig extends com.lark.wire.Message<MessageAnalysisConfig, a> {
    public static final ProtoAdapter<MessageAnalysisConfig> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<MessageAnalysisItem> analysis_items;
    private final MessageAnalysisContent content;
    private final String description;
    private final Boolean has_config;
    private final MessageAnalysisItem title_item;

    public static final class a extends com.lark.wire.Message.a<MessageAnalysisConfig, a> {
        public MessageAnalysisItem d;
        public String e;
        public List<MessageAnalysisItem> f;
        public Boolean g;
        public MessageAnalysisContent h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MessageAnalysisConfig(this, c(), null);
        }

        public a() {
            this.f = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<MessageAnalysisConfig> {
        @Override // com.lark.wire.ProtoAdapter
        public final MessageAnalysisConfig c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L21;
            if (r5 != 1) goto L8;
            r1.d = MessageAnalysisItem.ADAPTER.c(r8);
            goto L3
        L8:
            if (r5 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.e = r8.i();
            goto L3
        L10:
            if (r5 != 3) goto L12;
            r2.add(MessageAnalysisItem.ADAPTER.c(r8));
            goto L3
        L12:
            if (r5 != 4) goto L14;
            r1.g = (Boolean) ProtoAdapter.g.c(r8);
            goto L3
        L14:
            if (r5 != 5) goto L15;
            r1.h = MessageAnalysisContent.ADAPTER.c(r8);
            goto L3
        L15:
            r8.j(r5);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L21:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "analysis_items");
            com.lark.wire.internal.a.a(r2);
            r1.f = r2;
            return new MessageAnalysisConfig(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MessageAnalysisConfig r6) {
            MessageAnalysisConfig r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            ProtoAdapter<MessageAnalysisItem> r1 = MessageAnalysisItem.ADAPTER;
            return ((((r0 + r1.l(1, r7.getTitle_item())) + ProtoAdapter.q.l(2, r7.getDescription())) + r1.a().l(3, r7.getAnalysis_items())) + ProtoAdapter.g.l(4, r7.getHas_config())) + MessageAnalysisContent.ADAPTER.l(5, r7.getContent());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, MessageAnalysisConfig r6) {
            MessageAnalysisConfig r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            ProtoAdapter<MessageAnalysisItem> r0 = MessageAnalysisItem.ADAPTER;
            r0.i(r5, 1, r7.getTitle_item());
            ProtoAdapter.q.i(r5, 2, r7.getDescription());
            r0.a().i(r5, 3, r7.getAnalysis_items());
            ProtoAdapter.g.i(r5, 4, r7.getHas_config());
            MessageAnalysisContent.ADAPTER.i(r5, 5, r7.getContent());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, MessageAnalysisConfig r6) {
            MessageAnalysisConfig r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            MessageAnalysisContent.ADAPTER.j(r5, 5, r7.getContent());
            ProtoAdapter.g.j(r5, 4, r7.getHas_config());
            ProtoAdapter<MessageAnalysisItem> r0 = MessageAnalysisItem.ADAPTER;
            r0.a().j(r5, 3, r7.getAnalysis_items());
            ProtoAdapter.q.j(r5, 2, r7.getDescription());
            r0.j(r5, 1, r7.getTitle_item());
        }

        public b(FieldEncoding r7, KClass<MessageAnalysisConfig> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MessageAnalysisConfig", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MessageAnalysisConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageAnalysisConfig.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.title_item;
        r0.e = this.description;
        r0.f = this.analysis_items;
        r0.g = this.has_config;
        r0.h = this.content;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MessageAnalysisConfig.class).getSimpleName() + '@' + hashCode();
    }

    public final List<MessageAnalysisItem> getAnalysis_items() {
        return this.analysis_items;
    }

    public final MessageAnalysisContent getContent() {
        return this.content;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean getHas_config() {
        return this.has_config;
    }

    public final MessageAnalysisItem getTitle_item() {
        return this.title_item;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MessageAnalysisConfig(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.title_item = r2.d;
        this.description = r2.e;
        this.analysis_items = com.lark.wire.internal.a.c("analysis_items", r2.f);
        this.has_config = r2.g;
        this.content = r2.h;
    }

    public /* synthetic */ MessageAnalysisConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

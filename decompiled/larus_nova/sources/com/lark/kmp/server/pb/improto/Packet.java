package com.lark.kmp.server.pb.improto;

import com.bytedance.common.wschannel.WsConstants;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.b0;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
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

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003678B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00104\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0#¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0015\u0010)\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b*\u0010\u0017R\u0015\u0010+\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b,\u0010\u0017R\u0015\u0010-\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020.0#¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&¨\u00069"}, d2 = {"Lcom/lark/kmp/server/pb/improto/Packet;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/improto/Packet$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/improto/Packet$Builder;Lokio/ByteString;)V", WsConstants.KEY_SESSION_ID, "", "getSid", "()Ljava/lang/String;", "payload_type", "Lcom/lark/kmp/server/pb/improto/PayloadType;", "getPayload_type", "()Lcom/lark/kmp/server/pb/improto/PayloadType;", "cmd", "Lcom/lark/kmp/server/pb/improto/Command;", "getCmd", "()Lcom/lark/kmp/server/pb/improto/Command;", "status", "", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", WsConstants.KEY_PAYLOAD, "getPayload", "()Lokio/ByteString;", "cid", "getCid", "pipe_entity", "Lcom/lark/kmp/server/pb/improto/PipeEntity;", "getPipe_entity", "()Lcom/lark/kmp/server/pb/improto/PipeEntity;", "version_payloads", "", "Lcom/lark/kmp/server/pb/improto/Packet$VersionPayload;", "getVersion_payloads", "()Ljava/util/List;", "pipe_entities", "getPipe_entities", "wait_retry_interval", "getWait_retry_interval", "command", "getCommand", EffectConfiguration.KEY_CURSOR, "", "getCursor", "()Ljava/lang/Long;", "Ljava/lang/Long;", "compacted_sids", "getCompacted_sids", "newBuilder", "toString", "Builder", "Companion", "VersionPayload", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Packet extends Message<Packet, a> {
    public static final ProtoAdapter<Packet> ADAPTER = null;
    public static final c Companion = null;
    public static final PayloadType DEFAULT_PAYLOAD_TYPE = null;
    public static final int DEFAULT_STATUS = 200;
    private static final long serialVersionUID = 0;
    private final String cid;
    private final Command cmd;
    private final Integer command;
    private final List<Long> compacted_sids;
    private final Long cursor;
    private final ByteString payload;
    private final PayloadType payload_type;
    private final List<PipeEntity> pipe_entities;
    private final PipeEntity pipe_entity;
    private final String sid;
    private final Integer status;
    private final List<VersionPayload> version_payloads;
    private final Integer wait_retry_interval;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/server/pb/improto/Packet$VersionPayload;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/improto/Packet$VersionPayload$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/improto/Packet$VersionPayload$Builder;Lokio/ByteString;)V", "version_range", "Lcom/lark/kmp/server/pb/improto/VersionRange;", "getVersion_range", "()Lcom/lark/kmp/server/pb/improto/VersionRange;", WsConstants.KEY_PAYLOAD, "getPayload", "()Lokio/ByteString;", "newBuilder", "toString", "", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class VersionPayload extends Message<VersionPayload, a> {
        public static final ProtoAdapter<VersionPayload> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ByteString payload;
        private final VersionRange version_range;

        public static final class a extends Message.a<VersionPayload, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public VersionRange f282657d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public ByteString f282658e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new VersionPayload(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<VersionPayload> {
            @Override // com.lark.wire.ProtoAdapter
            public final VersionPayload c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L13;
                if (r103 != 1) goto L8;
                r101.f282657d = VersionRange.ADAPTER.c(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                ProtoAdapter.f282727p.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                ByteString r104 = r100.f();
                Intrinsics.checkNotNullParameter(r104, WsConstants.KEY_PAYLOAD);
                r101.f282658e = r104;
                goto L3
            L9:
                r100.j(r103);
                Unit r105 = Unit.INSTANCE;
                goto L3
            L13:
                return new VersionPayload(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(VersionPayload r100) {
                VersionPayload r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return (r101.unknownFields().size() + VersionRange.ADAPTER.l(1, r101.getVersion_range())) + ProtoAdapter.f282727p.l(2, r101.getPayload());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, VersionPayload r101) {
                VersionPayload r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                VersionRange.ADAPTER.i(r100, 1, r102.getVersion_range());
                ProtoAdapter.f282727p.i(r100, 2, r102.getPayload());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, VersionPayload r101) {
                VersionPayload r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                ProtoAdapter.f282727p.j(r100, 2, r102.getPayload());
                VersionRange.ADAPTER.j(r100, 1, r102.getVersion_range());
            }

            public b(FieldEncoding r100, KClass<VersionPayload> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/improto.Packet.VersionPayload", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ VersionPayload(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VersionPayload.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f282657d = this.version_range;
            r100.f282658e = this.payload;
            r100.a(unknownFields());
            return r100;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(VersionPayload.class).getSimpleName() + "@" + hashCode();
        }

        public final ByteString getPayload() {
            return this.payload;
        }

        public final VersionRange getVersion_range() {
            return this.version_range;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public VersionPayload(a r100, ByteString r101) {
            super(ADAPTER, r101);
            VersionRange r102 = r100.f282657d;
            Intrinsics.checkNotNull(r102);
            this.version_range = r102;
            ByteString r103 = r100.f282658e;
            Intrinsics.checkNotNull(r103);
            this.payload = r103;
        }

        public /* synthetic */ VersionPayload(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    public static final class a extends Message.a<Packet, a> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f282659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PayloadType f282660e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Command f282661f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f282662g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ByteString f282663h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f282664i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public PipeEntity f282665j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<VersionPayload> f282666k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<PipeEntity> f282667l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Integer f282668m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Integer f282669n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Long f282670o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public List<Long> f282671p;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new Packet(this, c(), null);
        }

        public a() {
            this.f282666k = CollectionsKt.emptyList();
            this.f282667l = CollectionsKt.emptyList();
            this.f282671p = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Packet> {
        @Override // com.lark.wire.ProtoAdapter
        public final Packet c(g0 r110) {
            Intrinsics.checkNotNullParameter(r110, "reader");
            a r100 = new a();
            ArrayList r101 = new ArrayList();
            ArrayList r102 = new ArrayList();
            ArrayList r103 = new ArrayList();
            long r104 = r110.c();
        L3:
            int r105 = r110.e();
            if (r105 == (-1)) goto L26;
            switch(r105) {
                case 1: goto L25;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L28:
            Command r106 = Command.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            Intrinsics.checkNotNullParameter(r106, "cmd");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            r100.f282661f = r106;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r110.a(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r107 = Unit.INSTANCE;
            goto L3
        L30:
            PayloadType r108 = PayloadType.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            Intrinsics.checkNotNullParameter(r108, "payload_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            r100.f282660e = r108;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r110.a(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r109 = Unit.INSTANCE;
            goto L3
        L7:
            r103.add(ProtoAdapter.f282722k.c(r110));
            goto L3
        L8:
            r100.f282670o = (Long) ProtoAdapter.f282723l.c(r110);
            goto L3
        L9:
            r100.f282669n = (Integer) ProtoAdapter.f282719h.c(r110);
            goto L3
        L10:
            r100.f282668m = (Integer) ProtoAdapter.f282720i.c(r110);
            goto L3
        L11:
            r102.add(PipeEntity.ADAPTER.c(r110));
            goto L3
        L12:
            r101.add(VersionPayload.ADAPTER.c(r110));
            goto L3
        L13:
            r100.f282665j = PipeEntity.ADAPTER.c(r110);
            goto L3
        L14:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f282664i = r110.i();
            goto L3
        L15:
            ProtoAdapter.f282727p.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f282663h = r110.f();
            goto L3
        L16:
            r100.f282662g = (Integer) ProtoAdapter.f282720i.c(r110);
            goto L3
        L25:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f282659d = r110.i();
            goto L3
        L6:
            r110.j(r105);
            Unit r111 = Unit.INSTANCE;
            goto L3
        L26:
            ByteString r112 = r110.d(r104);
            Intrinsics.checkNotNullParameter(r101, "version_payloads");
            com.lark.wire.internal.a.a(r101);
            r100.f282666k = r101;
            Intrinsics.checkNotNullParameter(r102, "pipe_entities");
            com.lark.wire.internal.a.a(r102);
            r100.f282667l = r102;
            Intrinsics.checkNotNullParameter(r103, "compacted_sids");
            com.lark.wire.internal.a.a(r103);
            r100.f282671p = r103;
            return new Packet(r100, r112, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Packet r100) {
            Packet r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "value");
            int r102 = r101.unknownFields().size();
            w r103 = ProtoAdapter.f282728q;
            int r104 = ((r102 + r103.l(1, r101.getSid())) + PayloadType.ADAPTER.l(2, r101.getPayload_type())) + Command.ADAPTER.l(3, r101.getCmd());
            b0 r105 = ProtoAdapter.f282720i;
            int r106 = ((r104 + r105.l(4, r101.getStatus())) + ProtoAdapter.f282727p.l(5, r101.getPayload())) + r103.l(6, r101.getCid());
            ProtoAdapter<PipeEntity> r107 = PipeEntity.ADAPTER;
            return ((((((r106 + r107.l(7, r101.getPipe_entity())) + VersionPayload.ADAPTER.a().l(8, r101.getVersion_payloads())) + r107.a().l(9, r101.getPipe_entities())) + r105.l(10, r101.getWait_retry_interval())) + ProtoAdapter.f282719h.l(11, r101.getCommand())) + ProtoAdapter.f282723l.l(12, r101.getCursor())) + ProtoAdapter.f282722k.a().l(13, r101.getCompacted_sids());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r100, Packet r101) {
            Packet r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Intrinsics.checkNotNullParameter(r102, "value");
            w r103 = ProtoAdapter.f282728q;
            r103.i(r100, 1, r102.getSid());
            PayloadType.ADAPTER.i(r100, 2, r102.getPayload_type());
            Command.ADAPTER.i(r100, 3, r102.getCmd());
            b0 r104 = ProtoAdapter.f282720i;
            r104.i(r100, 4, r102.getStatus());
            ProtoAdapter.f282727p.i(r100, 5, r102.getPayload());
            r103.i(r100, 6, r102.getCid());
            ProtoAdapter<PipeEntity> r105 = PipeEntity.ADAPTER;
            r105.i(r100, 7, r102.getPipe_entity());
            VersionPayload.ADAPTER.a().i(r100, 8, r102.getVersion_payloads());
            r105.a().i(r100, 9, r102.getPipe_entities());
            r104.i(r100, 10, r102.getWait_retry_interval());
            ProtoAdapter.f282719h.i(r100, 11, r102.getCommand());
            ProtoAdapter.f282723l.i(r100, 12, r102.getCursor());
            ProtoAdapter.f282722k.a().i(r100, 13, r102.getCompacted_sids());
            r100.a(r102.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r100, Packet r101) {
            Packet r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Intrinsics.checkNotNullParameter(r102, "value");
            r100.d(r102.unknownFields());
            ProtoAdapter.f282722k.a().j(r100, 13, r102.getCompacted_sids());
            ProtoAdapter.f282723l.j(r100, 12, r102.getCursor());
            ProtoAdapter.f282719h.j(r100, 11, r102.getCommand());
            b0 r103 = ProtoAdapter.f282720i;
            r103.j(r100, 10, r102.getWait_retry_interval());
            ProtoAdapter<PipeEntity> r104 = PipeEntity.ADAPTER;
            r104.a().j(r100, 9, r102.getPipe_entities());
            VersionPayload.ADAPTER.a().j(r100, 8, r102.getVersion_payloads());
            r104.j(r100, 7, r102.getPipe_entity());
            w r105 = ProtoAdapter.f282728q;
            r105.j(r100, 6, r102.getCid());
            ProtoAdapter.f282727p.j(r100, 5, r102.getPayload());
            r103.j(r100, 4, r102.getStatus());
            Command.ADAPTER.j(r100, 3, r102.getCmd());
            PayloadType.ADAPTER.j(r100, 2, r102.getPayload_type());
            r105.j(r100, 1, r102.getSid());
        }

        public b(FieldEncoding r100, KClass<Packet> r101, Syntax r102) {
            super(r100, r101, "type.googleapis.com/improto.Packet", r102, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Packet(a r100, ByteString r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        Companion = new c();
        DEFAULT_PAYLOAD_TYPE = PayloadType.PB2;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Packet.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r100 = new a();
        r100.f282659d = this.sid;
        r100.f282660e = this.payload_type;
        r100.f282661f = this.cmd;
        r100.f282662g = this.status;
        r100.f282663h = this.payload;
        r100.f282664i = this.cid;
        r100.f282665j = this.pipe_entity;
        r100.f282666k = this.version_payloads;
        r100.f282667l = this.pipe_entities;
        r100.f282668m = this.wait_retry_interval;
        r100.f282669n = this.command;
        r100.f282670o = this.cursor;
        r100.f282671p = this.compacted_sids;
        r100.a(unknownFields());
        return r100;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Packet.class).getSimpleName() + "@" + hashCode();
    }

    public final String getCid() {
        return this.cid;
    }

    public final Command getCmd() {
        return this.cmd;
    }

    public final Integer getCommand() {
        return this.command;
    }

    public final List<Long> getCompacted_sids() {
        return this.compacted_sids;
    }

    public final Long getCursor() {
        return this.cursor;
    }

    public final ByteString getPayload() {
        return this.payload;
    }

    public final PayloadType getPayload_type() {
        return this.payload_type;
    }

    public final List<PipeEntity> getPipe_entities() {
        return this.pipe_entities;
    }

    public final PipeEntity getPipe_entity() {
        return this.pipe_entity;
    }

    public final String getSid() {
        return this.sid;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final List<VersionPayload> getVersion_payloads() {
        return this.version_payloads;
    }

    public final Integer getWait_retry_interval() {
        return this.wait_retry_interval;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public Packet(a r100, ByteString r101) {
        super(ADAPTER, r101);
        this.sid = r100.f282659d;
        PayloadType r102 = r100.f282660e;
        Intrinsics.checkNotNull(r102);
        this.payload_type = r102;
        Command r103 = r100.f282661f;
        Intrinsics.checkNotNull(r103);
        this.cmd = r103;
        this.status = r100.f282662g;
        this.payload = r100.f282663h;
        this.cid = r100.f282664i;
        this.pipe_entity = r100.f282665j;
        this.version_payloads = com.lark.wire.internal.a.c("version_payloads", r100.f282666k);
        this.pipe_entities = com.lark.wire.internal.a.c("pipe_entities", r100.f282667l);
        this.wait_retry_interval = r100.f282668m;
        this.command = r100.f282669n;
        this.cursor = r100.f282670o;
        this.compacted_sids = com.lark.wire.internal.a.c("compacted_sids", r100.f282671p);
    }

    public /* synthetic */ Packet(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = ByteString.EMPTY;
    L5:
        this(r100, r101);
    }
}

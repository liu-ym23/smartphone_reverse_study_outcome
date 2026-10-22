package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewVideo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PreviewVideo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PreviewVideo$Builder;Lokio/ByteString;)V", "site", "Lcom/lark/kmp/pb/basic/v1/PreviewVideo$Site;", "getSite", "()Lcom/lark/kmp/pb/basic/v1/PreviewVideo$Site;", "vid", "", "getVid", "()Ljava/lang/String;", "iframe_url", "getIframe_url", "newBuilder", "toString", "Builder", "Companion", "Site", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PreviewVideo extends com.lark.wire.Message<PreviewVideo, a> {
    public static final ProtoAdapter<PreviewVideo> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_IFRAME_URL = "";
    public static final String DEFAULT_VID = "";
    private static final long serialVersionUID = 0;
    private final String iframe_url;
    private final Site site;
    private final String vid;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PreviewVideo$Site;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "XIGUA", "DOUYIN", "HUOSHAN", "YOUTUBE", "IQIYI", "YOUKU", "QQ", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Site extends Enum<Site> implements o0 {
        public static final ProtoAdapter<Site> ADAPTER = null;
        public static final b Companion = null;
        public static final Site DOUYIN = null;
        public static final Site HUOSHAN = null;
        public static final Site IQIYI = null;
        public static final Site QQ = null;
        public static final Site UNKNOWN = null;
        public static final Site XIGUA = null;
        public static final Site YOUKU = null;
        public static final Site YOUTUBE = null;
        public static final /* synthetic */ Site[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Site> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Site.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Site> r1, Syntax r2, Site r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Site a(int r0) {
                switch(r0) {
                    case 0: goto L12;
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    default: goto L3;
                };
            L3:
                return null;
            L14:
                return Site.QQ;
            L15:
                return Site.YOUKU;
            L16:
                return Site.IQIYI;
            L17:
                return Site.YOUTUBE;
            L18:
                return Site.HUOSHAN;
            L19:
                return Site.DOUYIN;
            L20:
                return Site.XIGUA;
            L12:
                return Site.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Site fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Site> getEntries() {
            return b;
        }

        static {
            Site r0 = new Site("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Site r1 = new Site("XIGUA", 1, 1);
            XIGUA = r1;
            Site r3 = new Site("DOUYIN", 2, 2);
            DOUYIN = r3;
            Site r5 = new Site("HUOSHAN", 3, 3);
            HUOSHAN = r5;
            Site r7 = new Site("YOUTUBE", 4, 4);
            YOUTUBE = r7;
            Site r9 = new Site("IQIYI", 5, 5);
            IQIYI = r9;
            Site r11 = new Site("YOUKU", 6, 6);
            YOUKU = r11;
            Site r13 = new Site("QQ", 7, 7);
            QQ = r13;
            Site[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Site.class), Syntax.PROTO_2, r0);
        }

        public static Site[] values() {
            return (Site[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Site valueOf(String r1) {
            return (Site) r27.a.a(Site.class, r1);
        }

        public Site(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<PreviewVideo, a> {
        public Site d;
        public String e;
        public String f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new PreviewVideo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<PreviewVideo> {
        @Override // com.lark.wire.ProtoAdapter
        public final PreviewVideo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            Site r5 = Site.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            Intrinsics.checkNotNullParameter(r5, "site");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            r1.d = r5;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L10:
            if (r4 != 3) goto L11;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.f = r10.i();
            goto L3
        L11:
            r10.j(r4);
            goto L3
        L19:
            return new PreviewVideo(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PreviewVideo r5) {
            PreviewVideo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size() + Site.ADAPTER.l(1, r6.getSite());
            w r1 = ProtoAdapter.q;
            return (r0 + r1.l(2, r6.getVid())) + r1.l(3, r6.getIframe_url());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, PreviewVideo r5) {
            PreviewVideo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Site.ADAPTER.i(r4, 1, r6.getSite());
            w r0 = ProtoAdapter.q;
            r0.i(r4, 2, r6.getVid());
            r0.i(r4, 3, r6.getIframe_url());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, PreviewVideo r5) {
            PreviewVideo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 3, r6.getIframe_url());
            r0.j(r4, 2, r6.getVid());
            Site.ADAPTER.j(r4, 1, r6.getSite());
        }

        public b(FieldEncoding r7, KClass<PreviewVideo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.PreviewVideo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PreviewVideo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PreviewVideo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.site;
        r0.e = this.vid;
        r0.f = this.iframe_url;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PreviewVideo.class).getSimpleName() + '@' + hashCode();
    }

    public final String getIframe_url() {
        return this.iframe_url;
    }

    public final Site getSite() {
        return this.site;
    }

    public final String getVid() {
        return this.vid;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public PreviewVideo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Site r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.site = r4;
        this.vid = r2.e;
        this.iframe_url = r2.f;
    }

    public /* synthetic */ PreviewVideo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001e¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardVisitInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardVisitInfo$Builder;Lokio/ByteString;)V", "scene_type", "Lcom/lark/kmp/pb/basic/v1/CardVisitInfo$DownloadFileScene;", "getScene_type", "()Lcom/lark/kmp/pb/basic/v1/CardVisitInfo$DownloadFileScene;", "entity_type", "Lcom/lark/kmp/pb/basic/v1/File$EntityType;", "getEntity_type", "()Lcom/lark/kmp/pb/basic/v1/File$EntityType;", "entity_id", "", "getEntity_id", "()Ljava/lang/String;", "inner_msg_id", "", "getInner_msg_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "auth_file_key", "getAuth_file_key", "im_ext", "", "getIm_ext", "()Ljava/util/Map;", "ext", "getExt", "newBuilder", "toString", "Builder", "Companion", "DownloadFileScene", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardVisitInfo extends com.lark.wire.Message<CardVisitInfo, a> {
    public static final ProtoAdapter<CardVisitInfo> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final String auth_file_key;
    private final String entity_id;
    private final File.EntityType entity_type;
    private final Map<String, String> ext;
    private final Map<String, String> im_ext;
    private final Long inner_msg_id;
    private final DownloadFileScene scene_type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardVisitInfo$DownloadFileScene;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT", "FAVORITE", "TODO", "ImFeedAudio", "MessageLink", "UniversalCard", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DownloadFileScene extends Enum<DownloadFileScene> implements o0 {
        public static final ProtoAdapter<DownloadFileScene> ADAPTER = null;
        public static final DownloadFileScene CHAT = null;
        public static final b Companion = null;
        public static final DownloadFileScene FAVORITE = null;
        public static final DownloadFileScene ImFeedAudio = null;
        public static final DownloadFileScene MessageLink = null;
        public static final DownloadFileScene TODO = null;
        public static final DownloadFileScene UNKNOWN = null;
        public static final DownloadFileScene UniversalCard = null;
        public static final /* synthetic */ DownloadFileScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<DownloadFileScene> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                DownloadFileScene.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<DownloadFileScene> r1, Syntax r2, DownloadFileScene r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static DownloadFileScene a(int r1) {
                if (r1 == 0) goto L23;
                if (r1 == 1) goto L30;
                if (r1 == 2) goto L29;
                if (r1 == 3) goto L28;
                if (r1 == 7) goto L27;
                if (r1 == 8) goto L26;
                if (r1 == 9) goto L25;
                return null;
            L25:
                return DownloadFileScene.UniversalCard;
            L26:
                return DownloadFileScene.MessageLink;
            L27:
                return DownloadFileScene.ImFeedAudio;
            L28:
                return DownloadFileScene.TODO;
            L29:
                return DownloadFileScene.FAVORITE;
            L30:
                return DownloadFileScene.CHAT;
            L23:
                return DownloadFileScene.UNKNOWN;
            }
        }

        @JvmStatic
        public static final DownloadFileScene fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<DownloadFileScene> getEntries() {
            return b;
        }

        static {
            DownloadFileScene r0 = new DownloadFileScene("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            DownloadFileScene r1 = new DownloadFileScene("CHAT", 1, 1);
            CHAT = r1;
            DownloadFileScene r3 = new DownloadFileScene("FAVORITE", 2, 2);
            FAVORITE = r3;
            DownloadFileScene r5 = new DownloadFileScene("TODO", 3, 3);
            TODO = r5;
            DownloadFileScene r7 = new DownloadFileScene("ImFeedAudio", 4, 7);
            ImFeedAudio = r7;
            DownloadFileScene r9 = new DownloadFileScene("MessageLink", 5, 8);
            MessageLink = r9;
            DownloadFileScene r12 = new DownloadFileScene("UniversalCard", 6, 9);
            UniversalCard = r12;
            DownloadFileScene[] r11 = {r0, r1, r3, r5, r7, r9, r12};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(DownloadFileScene.class), Syntax.PROTO_2, r0);
        }

        public static DownloadFileScene[] values() {
            return (DownloadFileScene[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static DownloadFileScene valueOf(String r1) {
            return (DownloadFileScene) r27.a.a(DownloadFileScene.class, r1);
        }

        public DownloadFileScene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<CardVisitInfo, a> {
        public DownloadFileScene d;
        public File.EntityType e;
        public String f;
        public Long g;
        public String h;
        public Map<String, String> i;
        public Map<String, String> j;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CardVisitInfo(this, c(), null);
        }

        public a() {
            this.i = MapsKt.emptyMap();
            this.j = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ CardVisitInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(CardVisitInfo.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new CardVisitInfo$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.scene_type;
        r0.e = this.entity_type;
        r0.f = this.entity_id;
        r0.g = this.inner_msg_id;
        r0.h = this.auth_file_key;
        r0.i = this.im_ext;
        r0.j = this.ext;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CardVisitInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAuth_file_key() {
        return this.auth_file_key;
    }

    public final String getEntity_id() {
        return this.entity_id;
    }

    public final File.EntityType getEntity_type() {
        return this.entity_type;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Map<String, String> getIm_ext() {
        return this.im_ext;
    }

    public final Long getInner_msg_id() {
        return this.inner_msg_id;
    }

    public final DownloadFileScene getScene_type() {
        return this.scene_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CardVisitInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.scene_type = r2.d;
        this.entity_type = r2.e;
        this.entity_id = r2.f;
        this.inner_msg_id = r2.g;
        this.auth_file_key = r2.h;
        this.im_ext = com.lark.wire.internal.a.d("im_ext", r2.i);
        this.ext = com.lark.wire.internal.a.d("ext", r2.j);
    }

    public /* synthetic */ CardVisitInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

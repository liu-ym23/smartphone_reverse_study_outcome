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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageTranslationInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ImageTranslationInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ImageTranslationInfo$Builder;Lokio/ByteString;)V", "entity_id", "", "getEntity_id", "()Ljava/lang/String;", "entity_type", "Lcom/lark/kmp/pb/basic/v1/ImageTranslationInfo$EntityType;", "getEntity_type", "()Lcom/lark/kmp/pb/basic/v1/ImageTranslationInfo$EntityType;", "translated_images", "", "Lcom/lark/kmp/pb/basic/v1/TranslatedImage;", "getTranslated_images", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "EntityType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ImageTranslationInfo extends com.lark.wire.Message<ImageTranslationInfo, a> {
    public static final ProtoAdapter<ImageTranslationInfo> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final String entity_id;
    private final EntityType entity_type;
    private final Map<String, TranslatedImage> translated_images;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageTranslationInfo$EntityType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_ENTITY", "MESSAGE_ENTITY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum EntityType extends Enum<EntityType> implements o0 {
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final b Companion = null;
        public static final EntityType MESSAGE_ENTITY = null;
        public static final EntityType UNKNOWN_ENTITY = null;
        public static final /* synthetic */ EntityType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<EntityType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                EntityType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return EntityType.MESSAGE_ENTITY;
            L9:
                return EntityType.UNKNOWN_ENTITY;
            }

            public a(KClass<EntityType> r1, Syntax r2, EntityType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<EntityType> getEntries() {
            return b;
        }

        static {
            EntityType r0 = new EntityType("UNKNOWN_ENTITY", 0, 0);
            UNKNOWN_ENTITY = r0;
            EntityType r1 = new EntityType("MESSAGE_ENTITY", 1, 1);
            MESSAGE_ENTITY = r1;
            EntityType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(EntityType.class), Syntax.PROTO_2, r0);
        }

        public static EntityType[] values() {
            return (EntityType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final EntityType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return MESSAGE_ENTITY;
        L9:
            return UNKNOWN_ENTITY;
        }

        public static EntityType valueOf(String r1) {
            return (EntityType) r27.a.a(EntityType.class, r1);
        }

        public EntityType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<ImageTranslationInfo, a> {
        public String d;
        public EntityType e;
        public Map<String, TranslatedImage> f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ImageTranslationInfo(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ ImageTranslationInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(ImageTranslationInfo.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new ImageTranslationInfo$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.entity_id;
        r0.e = this.entity_type;
        r0.f = this.translated_images;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ImageTranslationInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final String getEntity_id() {
        return this.entity_id;
    }

    public final EntityType getEntity_type() {
        return this.entity_type;
    }

    public final Map<String, TranslatedImage> getTranslated_images() {
        return this.translated_images;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ImageTranslationInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.entity_id = r4;
        EntityType r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.entity_type = r5;
        this.translated_images = com.lark.wire.internal.a.d("translated_images", r2.f);
    }

    public /* synthetic */ ImageTranslationInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}

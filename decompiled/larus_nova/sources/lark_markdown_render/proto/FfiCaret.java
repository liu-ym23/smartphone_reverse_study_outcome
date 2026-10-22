package lark_markdown_render.proto;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FfiCaret extends Message<FfiCaret, Builder> {
    public static final ProtoAdapter<FfiCaret> ADAPTER = null;
    public static final Integer DEFAULT_CANVAS_ID = null;
    public static final Boolean DEFAULT_DIRECTION = null;
    public static final Float DEFAULT_HEIGHT = null;
    public static final Integer DEFAULT_UUID = null;
    public static final Float DEFAULT_X = null;
    public static final Float DEFAULT_Y = null;
    private static final long serialVersionUID = 0;
    public final Integer canvas_id;
    public final Boolean direction;
    public final Float height;
    public final Integer uuid;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Float f508253x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Float f508254y;

    public static final class Builder extends Message.Builder<FfiCaret, Builder> {
        public Integer canvas_id;
        public Boolean direction;
        public Float height;
        public Integer uuid;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Float f508255x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Float f508256y;

        @Override // com.squareup.wire.Message.Builder
        public FfiCaret build() {
            Float r100 = this.f508255x;
            if (r100 == null) goto L17;
            if (this.f508256y == null) goto L17;
            if (this.height == null) goto L17;
            if (this.direction == null) goto L17;
            if (this.uuid == null) goto L17;
            if (this.canvas_id == null) goto L17;
            return new FfiCaret(this.f508255x, this.f508256y, this.height, this.direction, this.uuid, this.canvas_id, super.buildUnknownFields());
        L17:
            throw Internal.missingRequiredFields(new Object[]{r100, "x", this.f508256y, "y", this.height, "height", this.direction, "direction", this.uuid, ST.UUID_DEVICE, this.canvas_id, "canvas_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder canvas_id(Integer r100) {
            this.canvas_id = r100;
            return this;
        }

        public Builder direction(Boolean r100) {
            this.direction = r100;
            return this;
        }

        public Builder height(Float r100) {
            this.height = r100;
            return this;
        }

        public Builder uuid(Integer r100) {
            this.uuid = r100;
            return this;
        }

        public Builder x(Float r100) {
            this.f508255x = r100;
            return this;
        }

        public Builder y(Float r100) {
            this.f508256y = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FfiCaret extends ProtoAdapter<FfiCaret> {
        public ProtoAdapter_FfiCaret() {
            super(FieldEncoding.LENGTH_DELIMITED, FfiCaret.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FfiCaret decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.canvas_id = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            r101.uuid = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L9:
            r101.direction = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L11:
            r101.f508256y = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            r101.f508255x = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FfiCaret r100) {
            ProtoAdapter<Float> r101 = ProtoAdapter.FLOAT;
            int r102 = ((r101.encodedSizeWithTag(1, r100.f508253x) + r101.encodedSizeWithTag(2, r100.f508254y)) + r101.encodedSizeWithTag(3, r100.height)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r100.direction);
            ProtoAdapter<Integer> r103 = ProtoAdapter.UINT32;
            return ((r102 + r103.encodedSizeWithTag(5, r100.uuid)) + r103.encodedSizeWithTag(6, r100.canvas_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FfiCaret decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FfiCaret r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FfiCaret r101) throws IOException {
            ProtoAdapter<Float> r102 = ProtoAdapter.FLOAT;
            r102.encodeWithTag(r100, 1, r101.f508253x);
            r102.encodeWithTag(r100, 2, r101.f508254y);
            r102.encodeWithTag(r100, 3, r101.height);
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r101.direction);
            ProtoAdapter<Integer> r103 = ProtoAdapter.UINT32;
            r103.encodeWithTag(r100, 5, r101.uuid);
            r103.encodeWithTag(r100, 6, r101.canvas_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FfiCaret r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FfiCaret();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_X = r100;
        DEFAULT_Y = r100;
        DEFAULT_HEIGHT = r100;
        DEFAULT_DIRECTION = Boolean.FALSE;
        DEFAULT_UUID = 0;
        DEFAULT_CANVAS_ID = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f508255x = this.f508253x;
        r100.f508256y = this.f508254y;
        r100.height = this.height;
        r100.direction = this.direction;
        r100.uuid = this.uuid;
        r100.canvas_id = this.canvas_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FfiCaret.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FfiCaret(Float r100, Float r110, Float r111, Boolean r112, Integer r113, Integer r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public FfiCaret(Float r100, Float r101, Float r102, Boolean r103, Integer r104, Integer r105, ByteString r106) {
        super(ADAPTER, r106);
        this.f508253x = r100;
        this.f508254y = r101;
        this.height = r102;
        this.direction = r103;
        this.uuid = r104;
        this.canvas_id = r105;
    }
}

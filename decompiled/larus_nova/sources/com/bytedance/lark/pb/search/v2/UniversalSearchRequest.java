package com.bytedance.lark.pb.search.v2;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UniversalSearchRequest extends Message<UniversalSearchRequest, Builder> {
    public static final ProtoAdapter<UniversalSearchRequest> ADAPTER = null;
    public static final InvokeMode DEFAULT_INVOKE_MODE = null;
    public static final ProtoAdapter_UniversalSearchRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SearchCommonRequestHeader header;
    public final InvokeMode invoke_mode;

    public static final class Builder extends Message.Builder<UniversalSearchRequest, Builder> implements d<UniversalSearchRequest> {
        public SearchCommonRequestHeader header;
        public InvokeMode invoke_mode;

        @Override // com.squareup.wire.Message.Builder
        public UniversalSearchRequest build() {
            SearchCommonRequestHeader r100 = this.header;
            if (r100 == null) goto L7;
            return new UniversalSearchRequest(this.header, this.invoke_mode, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "header"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder header(SearchCommonRequestHeader r100) {
            this.header = r100;
            return this;
        }

        public Builder invoke_mode(InvokeMode r100) {
            this.invoke_mode = r100;
            return this;
        }
    }

    public static final enum InvokeMode extends Enum<InvokeMode> implements WireEnum {
        private static final /* synthetic */ InvokeMode[] $VALUES = null;
        public static final ProtoAdapter<InvokeMode> ADAPTER = null;
        public static final InvokeMode CALLBACK = null;
        public static final InvokeMode PUSH_FLOW = null;
        private final int value;

        static {
            InvokeMode r100 = new InvokeMode(HTTP.CALLBACK, 0, 0);
            CALLBACK = r100;
            InvokeMode r101 = new InvokeMode("PUSH_FLOW", 1, 1);
            PUSH_FLOW = r101;
            $VALUES = new InvokeMode[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(InvokeMode.class);
        }

        public static InvokeMode[] values() {
            return (InvokeMode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static InvokeMode fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return PUSH_FLOW;
        L10:
            return CALLBACK;
        }

        public static InvokeMode valueOf(String r100) {
            return (InvokeMode) a.a(InvokeMode.class, r100);
        }

        private InvokeMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UniversalSearchRequest extends ProtoAdapter<UniversalSearchRequest> implements c<UniversalSearchRequest> {
        public ProtoAdapter_UniversalSearchRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalSearchRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalSearchRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.invoke_mode = InvokeMode.CALLBACK;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.header = SearchCommonRequestHeader.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.invoke_mode = InvokeMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UniversalSearchRequest r100) {
            int r101 = SearchCommonRequestHeader.ADAPTER.encodedSizeWithTag(1, r100.header);
            InvokeMode r102 = r100.invoke_mode;
            if (r102 == null) goto L5;
            int r103 = InvokeMode.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalSearchRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalSearchRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalSearchRequest r101) throws IOException {
            SearchCommonRequestHeader.ADAPTER.encodeWithTag(r100, 1, r101.header);
            InvokeMode r102 = r101.invoke_mode;
            if (r102 == null) goto L5;
            InvokeMode.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalSearchRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UniversalSearchRequest r100 = new ProtoAdapter_UniversalSearchRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_INVOKE_MODE = InvokeMode.CALLBACK;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.header = this.header;
        r100.invoke_mode = this.invoke_mode;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalSearchRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalSearchRequest(SearchCommonRequestHeader r100, InvokeMode r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UniversalSearchRequest(SearchCommonRequestHeader r100, InvokeMode r101, ByteString r102) {
        super(ADAPTER, r102);
        this.header = r100;
        this.invoke_mode = r101;
    }
}

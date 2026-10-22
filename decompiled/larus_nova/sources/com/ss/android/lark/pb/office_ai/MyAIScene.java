package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ImageSetPassThrough;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MyAIScene extends Message<MyAIScene, Builder> {
    public static final ProtoAdapter<MyAIScene> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_GREETING = "";
    public static final Boolean DEFAULT_IS_OFFICIAL = null;
    public static final Boolean DEFAULT_IS_PRESET = null;
    public static final Long DEFAULT_SCENE_ID = null;
    public static final String DEFAULT_SCENE_NAME = "";
    public static final Long DEFAULT_TENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mdescription;
    public final String mgreeting;
    public final List<GuideQuestion> mguide_questions;
    public final Boolean mis_official;
    public final Boolean mis_preset;
    public final SceneOwner mowner;
    public final ProcessorType mprocessor_type;
    public final Long mscene_id;
    public final String mscene_name;
    public final ImageSetPassThrough mscene_photo;
    public final SceneStatus mstatus;
    public final Long mtenant_id;

    public static final class Builder extends Message.Builder<MyAIScene, Builder> {
        public String mdescription;
        public String mgreeting;
        public List<GuideQuestion> mguide_questions;
        public Boolean mis_official;
        public Boolean mis_preset;
        public SceneOwner mowner;
        public ProcessorType mprocessor_type;
        public Long mscene_id;
        public String mscene_name;
        public ImageSetPassThrough mscene_photo;
        public SceneStatus mstatus;
        public Long mtenant_id;

        @Override // com.squareup.wire.Message.Builder
        public MyAIScene build() {
            return new MyAIScene(this.mscene_id, this.mowner, this.mtenant_id, this.mprocessor_type, this.mscene_name, this.mscene_photo, this.mgreeting, this.mdescription, this.mguide_questions, this.mstatus, this.mis_official, this.mis_preset, super.buildUnknownFields());
        }

        public Builder() {
            this.mguide_questions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder greeting(String r100) {
            this.mgreeting = r100;
            return this;
        }

        public Builder guide_questions(List<GuideQuestion> r100) {
            Internal.checkElementsNotNull(r100);
            this.mguide_questions = r100;
            return this;
        }

        public Builder is_official(Boolean r100) {
            this.mis_official = r100;
            return this;
        }

        public Builder is_preset(Boolean r100) {
            this.mis_preset = r100;
            return this;
        }

        public Builder owner(SceneOwner r100) {
            this.mowner = r100;
            return this;
        }

        public Builder processor_type(ProcessorType r100) {
            this.mprocessor_type = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.mscene_id = r100;
            return this;
        }

        public Builder scene_name(String r100) {
            this.mscene_name = r100;
            return this;
        }

        public Builder scene_photo(ImageSetPassThrough r100) {
            this.mscene_photo = r100;
            return this;
        }

        public Builder status(SceneStatus r100) {
            this.mstatus = r100;
            return this;
        }

        public Builder tenant_id(Long r100) {
            this.mtenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MyAIScene extends ProtoAdapter<MyAIScene> {
        public ProtoAdapter_MyAIScene() {
            super(FieldEncoding.LENGTH_DELIMITED, MyAIScene.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MyAIScene decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mscene_id = 0L;
            r101.mtenant_id = 0L;
            r101.mscene_name = "";
            r101.mgreeting = "";
            r101.mdescription = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_official = r102;
            r101.mis_preset = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L25;
            switch(r104) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L29;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L27;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L27:
            r101.mstatus = SceneStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r101.mprocessor_type = ProcessorType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mis_preset = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mis_official = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.mguide_questions.add(GuideQuestion.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mgreeting = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mscene_photo = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.mscene_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.mtenant_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L23:
            r101.mowner = SceneOwner.ADAPTER.decode(r100);
            goto L3
        L24:
            r101.mscene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MyAIScene r100) {
            Long r101 = r100.mscene_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            SceneOwner r104 = r100.mowner;
            if (r104 == null) goto L9;
            int r105 = SceneOwner.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.mtenant_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ProcessorType r110 = r100.mprocessor_type;
            if (r110 == null) goto L17;
            int r111 = ProcessorType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mscene_name;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ImageSetPassThrough r116 = r100.mscene_photo;
            if (r116 == null) goto L25;
            int r117 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mgreeting;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mdescription;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = (r121 + r123) + GuideQuestion.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.mguide_questions);
            SceneStatus r125 = r100.mstatus;
            if (r125 == null) goto L37;
            int r126 = SceneStatus.ADAPTER.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.mis_official;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.mis_preset;
            if (r131 == null) goto L46;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r131);
        L46:
            return (r130 + r102) + r100.unknownFields().size();
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MyAIScene decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MyAIScene r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MyAIScene r101) throws IOException {
            Long r102 = r101.mscene_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            SceneOwner r103 = r101.mowner;
            if (r103 == null) goto L8;
            SceneOwner.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.mtenant_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            ProcessorType r105 = r101.mprocessor_type;
            if (r105 == null) goto L14;
            ProcessorType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mscene_name;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            ImageSetPassThrough r107 = r101.mscene_photo;
            if (r107 == null) goto L20;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mgreeting;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mdescription;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            GuideQuestion.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.mguide_questions);
            SceneStatus r110 = r101.mstatus;
            if (r110 == null) goto L29;
            SceneStatus.ADAPTER.encodeWithTag(r100, 10, r110);
        L29:
            Boolean r111 = r101.mis_official;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
        L32:
            Boolean r112 = r101.mis_preset;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MyAIScene r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MyAIScene();
        DEFAULT_SCENE_ID = 0L;
        DEFAULT_TENANT_ID = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_OFFICIAL = r100;
        DEFAULT_IS_PRESET = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscene_id = this.mscene_id;
        r100.mowner = this.mowner;
        r100.mtenant_id = this.mtenant_id;
        r100.mprocessor_type = this.mprocessor_type;
        r100.mscene_name = this.mscene_name;
        r100.mscene_photo = this.mscene_photo;
        r100.mgreeting = this.mgreeting;
        r100.mdescription = this.mdescription;
        r100.mguide_questions = Internal.copyOf("mguide_questions", this.mguide_questions);
        r100.mstatus = this.mstatus;
        r100.mis_official = this.mis_official;
        r100.mis_preset = this.mis_preset;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MyAIScene.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MyAIScene(Long r110, SceneOwner r111, Long r112, ProcessorType r113, String r114, ImageSetPassThrough r210, String r211, String r212, List<GuideQuestion> r213, SceneStatus r214, Boolean r215, Boolean r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public MyAIScene(Long r100, SceneOwner r101, Long r102, ProcessorType r103, String r104, ImageSetPassThrough r105, String r106, String r107, List<GuideQuestion> r110, SceneStatus r111, Boolean r112, Boolean r113, ByteString r114) {
        super(ADAPTER, r114);
        this.mscene_id = r100;
        this.mowner = r101;
        this.mtenant_id = r102;
        this.mprocessor_type = r103;
        this.mscene_name = r104;
        this.mscene_photo = r105;
        this.mgreeting = r106;
        this.mdescription = r107;
        this.mguide_questions = Internal.immutableCopyOf("mguide_questions", r110);
        this.mstatus = r111;
        this.mis_official = r112;
        this.mis_preset = r113;
    }
}

package com.google.protobuf.server;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class FileOptions extends Message<FileOptions, Builder> {
    public static final ProtoAdapter<FileOptions> ADAPTER = null;
    public static final Boolean DEFAULT_CC_ENABLE_ARENAS = null;
    public static final Boolean DEFAULT_CC_GENERIC_SERVICES = null;
    public static final String DEFAULT_CSHARP_NAMESPACE = "";
    public static final Boolean DEFAULT_DEPRECATED = null;
    public static final String DEFAULT_GO_PACKAGE = "";
    public static final Boolean DEFAULT_JAVA_GENERATE_EQUALS_AND_HASH = null;
    public static final Boolean DEFAULT_JAVA_GENERIC_SERVICES = null;
    public static final Boolean DEFAULT_JAVA_MULTIPLE_FILES = null;
    public static final String DEFAULT_JAVA_OUTER_CLASSNAME = "";
    public static final String DEFAULT_JAVA_PACKAGE = "";
    public static final Boolean DEFAULT_JAVA_STRING_CHECK_UTF8 = null;
    public static final String DEFAULT_OBJC_CLASS_PREFIX = "";
    public static final Boolean DEFAULT_PY_GENERIC_SERVICES = null;
    private static final long serialVersionUID = 0;
    public final Boolean mcc_enable_arenas;
    public final Boolean mcc_generic_services;
    public final String mcsharp_namespace;
    public final Boolean mdeprecated;
    public final String mgo_package;
    public final Boolean mjava_generate_equals_and_hash;
    public final Boolean mjava_generic_services;
    public final Boolean mjava_multiple_files;
    public final String mjava_outer_classname;
    public final String mjava_package;
    public final Boolean mjava_string_check_utf8;
    public final String mobjc_class_prefix;
    public final OptimizeMode moptimize_for;
    public final Boolean mpy_generic_services;
    public final List<UninterpretedOption> muninterpreted_option;

    public static final class Builder extends Message.Builder<FileOptions, Builder> {
        public Boolean mcc_enable_arenas;
        public Boolean mcc_generic_services;
        public String mcsharp_namespace;
        public Boolean mdeprecated;
        public String mgo_package;
        public Boolean mjava_generate_equals_and_hash;
        public Boolean mjava_generic_services;
        public Boolean mjava_multiple_files;
        public String mjava_outer_classname;
        public String mjava_package;
        public Boolean mjava_string_check_utf8;
        public String mobjc_class_prefix;
        public OptimizeMode moptimize_for;
        public Boolean mpy_generic_services;
        public List<UninterpretedOption> muninterpreted_option;

        @Override // com.squareup.wire.Message.Builder
        public FileOptions build() {
            return new FileOptions(this.mjava_package, this.mjava_outer_classname, this.mjava_multiple_files, this.mjava_generate_equals_and_hash, this.mjava_string_check_utf8, this.moptimize_for, this.mgo_package, this.mcc_generic_services, this.mjava_generic_services, this.mpy_generic_services, this.mdeprecated, this.mcc_enable_arenas, this.mobjc_class_prefix, this.mcsharp_namespace, this.muninterpreted_option, super.buildUnknownFields());
        }

        public Builder() {
            this.muninterpreted_option = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cc_enable_arenas(Boolean r100) {
            this.mcc_enable_arenas = r100;
            return this;
        }

        public Builder cc_generic_services(Boolean r100) {
            this.mcc_generic_services = r100;
            return this;
        }

        public Builder csharp_namespace(String r100) {
            this.mcsharp_namespace = r100;
            return this;
        }

        public Builder deprecated(Boolean r100) {
            this.mdeprecated = r100;
            return this;
        }

        public Builder go_package(String r100) {
            this.mgo_package = r100;
            return this;
        }

        public Builder java_generate_equals_and_hash(Boolean r100) {
            this.mjava_generate_equals_and_hash = r100;
            return this;
        }

        public Builder java_generic_services(Boolean r100) {
            this.mjava_generic_services = r100;
            return this;
        }

        public Builder java_multiple_files(Boolean r100) {
            this.mjava_multiple_files = r100;
            return this;
        }

        public Builder java_outer_classname(String r100) {
            this.mjava_outer_classname = r100;
            return this;
        }

        public Builder java_package(String r100) {
            this.mjava_package = r100;
            return this;
        }

        public Builder java_string_check_utf8(Boolean r100) {
            this.mjava_string_check_utf8 = r100;
            return this;
        }

        public Builder objc_class_prefix(String r100) {
            this.mobjc_class_prefix = r100;
            return this;
        }

        public Builder optimize_for(OptimizeMode r100) {
            this.moptimize_for = r100;
            return this;
        }

        public Builder py_generic_services(Boolean r100) {
            this.mpy_generic_services = r100;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> r100) {
            Internal.checkElementsNotNull(r100);
            this.muninterpreted_option = r100;
            return this;
        }
    }

    public static final enum OptimizeMode extends Enum<OptimizeMode> implements WireEnum {
        private static final /* synthetic */ OptimizeMode[] $VALUES = null;
        public static final ProtoAdapter<OptimizeMode> ADAPTER = null;
        public static final OptimizeMode CODE_SIZE = null;
        public static final OptimizeMode LITE_RUNTIME = null;
        public static final OptimizeMode SPEED = null;
        private final int value;

        static {
            OptimizeMode r100 = new OptimizeMode("SPEED", 0, 1);
            SPEED = r100;
            OptimizeMode r101 = new OptimizeMode("CODE_SIZE", 1, 2);
            CODE_SIZE = r101;
            OptimizeMode r102 = new OptimizeMode("LITE_RUNTIME", 2, 3);
            LITE_RUNTIME = r102;
            $VALUES = new OptimizeMode[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(OptimizeMode.class);
        }

        public static OptimizeMode[] values() {
            return (OptimizeMode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OptimizeMode fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return LITE_RUNTIME;
        L13:
            return CODE_SIZE;
        L15:
            return SPEED;
        }

        public static OptimizeMode valueOf(String r100) {
            return (OptimizeMode) a.a(OptimizeMode.class, r100);
        }

        private OptimizeMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_FileOptions extends ProtoAdapter<FileOptions> {
        public ProtoAdapter_FileOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, FileOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mjava_package = "";
            r101.mjava_outer_classname = "";
            Boolean r102 = Boolean.FALSE;
            r101.mjava_multiple_files = r102;
            r101.mjava_generate_equals_and_hash = r102;
            r101.mjava_string_check_utf8 = r102;
            r101.mgo_package = "";
            r101.mcc_generic_services = r102;
            r101.mjava_generic_services = r102;
            r101.mpy_generic_services = r102;
            r101.mdeprecated = r102;
            r101.mcc_enable_arenas = r102;
            r101.mobjc_class_prefix = "";
            r101.mcsharp_namespace = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L42;
            if (r104 != 1) goto L8;
            r101.mjava_package = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 20) goto L10;
            r101.mjava_generate_equals_and_hash = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 23) goto L12;
            r101.mdeprecated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 27) goto L14;
            r101.mjava_string_check_utf8 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 31) goto L16;
            r101.mcc_enable_arenas = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            if (r104 != 999) goto L18;
            r101.muninterpreted_option.add(UninterpretedOption.ADAPTER.decode(r100));
            goto L3
        L18:
            if (r104 != 36) goto L20;
            r101.mobjc_class_prefix = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            if (r104 != 37) goto L21;
            r101.mcsharp_namespace = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            switch(r104) {
                case 8: goto L33;
                case 9: goto L44;
                case 10: goto L28;
                case 11: goto L27;
                default: goto L22;
            };
        L44:
            r101.moptimize_for = OptimizeMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L27:
            r101.mgo_package = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.mjava_multiple_files = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L33:
            r101.mjava_outer_classname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            switch(r104) {
                case 16: goto L26;
                case 17: goto L25;
                case 18: goto L24;
                default: goto L23;
            };
        L24:
            r101.mpy_generic_services = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.mjava_generic_services = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.mcc_generic_services = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L42:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FileOptions r100) {
            String r101 = r100.mjava_package;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mjava_outer_classname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(8, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mjava_multiple_files;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mjava_generate_equals_and_hash;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mjava_string_check_utf8;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r113);
        L22:
            int r115 = r112 + r114;
            OptimizeMode r116 = r100.moptimize_for;
            if (r116 == null) goto L25;
            int r117 = OptimizeMode.ADAPTER.encodedSizeWithTag(9, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mgo_package;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(11, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.mcc_generic_services;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.mjava_generic_services;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.mpy_generic_services;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.mdeprecated;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.mcc_enable_arenas;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.mobjc_class_prefix;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(36, r137);
        L54:
            int r139 = r136 + r138;
            String r140 = r100.mcsharp_namespace;
            if (r140 == null) goto L58;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(37, r140);
        L58:
            return ((r139 + r102) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, r100.muninterpreted_option)) + r100.unknownFields().size();
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
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
        public /* bridge */ /* synthetic */ FileOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileOptions r101) throws IOException {
            String r102 = r101.mjava_package;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mjava_outer_classname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r103);
        L8:
            Boolean r104 = r101.mjava_multiple_files;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r104);
        L11:
            Boolean r105 = r101.mjava_generate_equals_and_hash;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 20, r105);
        L14:
            Boolean r106 = r101.mjava_string_check_utf8;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 27, r106);
        L17:
            OptimizeMode r107 = r101.moptimize_for;
            if (r107 == null) goto L20;
            OptimizeMode.ADAPTER.encodeWithTag(r100, 9, r107);
        L20:
            String r108 = r101.mgo_package;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r108);
        L23:
            Boolean r109 = r101.mcc_generic_services;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r109);
        L26:
            Boolean r110 = r101.mjava_generic_services;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r110);
        L29:
            Boolean r111 = r101.mpy_generic_services;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r111);
        L32:
            Boolean r112 = r101.mdeprecated;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 23, r112);
        L35:
            Boolean r113 = r101.mcc_enable_arenas;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r113);
        L38:
            String r114 = r101.mobjc_class_prefix;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 36, r114);
        L41:
            String r115 = r101.mcsharp_namespace;
            if (r115 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r100, 37, r115);
        L44:
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(r100, 999, r101.muninterpreted_option);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FileOptions();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_JAVA_MULTIPLE_FILES = r100;
        DEFAULT_JAVA_GENERATE_EQUALS_AND_HASH = r100;
        DEFAULT_JAVA_STRING_CHECK_UTF8 = r100;
        DEFAULT_CC_GENERIC_SERVICES = r100;
        DEFAULT_JAVA_GENERIC_SERVICES = r100;
        DEFAULT_PY_GENERIC_SERVICES = r100;
        DEFAULT_DEPRECATED = r100;
        DEFAULT_CC_ENABLE_ARENAS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mjava_package = this.mjava_package;
        r100.mjava_outer_classname = this.mjava_outer_classname;
        r100.mjava_multiple_files = this.mjava_multiple_files;
        r100.mjava_generate_equals_and_hash = this.mjava_generate_equals_and_hash;
        r100.mjava_string_check_utf8 = this.mjava_string_check_utf8;
        r100.moptimize_for = this.moptimize_for;
        r100.mgo_package = this.mgo_package;
        r100.mcc_generic_services = this.mcc_generic_services;
        r100.mjava_generic_services = this.mjava_generic_services;
        r100.mpy_generic_services = this.mpy_generic_services;
        r100.mdeprecated = this.mdeprecated;
        r100.mcc_enable_arenas = this.mcc_enable_arenas;
        r100.mobjc_class_prefix = this.mobjc_class_prefix;
        r100.mcsharp_namespace = this.mcsharp_namespace;
        r100.muninterpreted_option = Internal.copyOf("muninterpreted_option", this.muninterpreted_option);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileOptions(String r110, String r111, Boolean r210, Boolean r211, Boolean r212, OptimizeMode r213, String r214, Boolean r215, Boolean r216, Boolean r217, Boolean r218, Boolean r219, String r310, String r311, List<UninterpretedOption> r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public FileOptions(String r100, String r101, Boolean r102, Boolean r103, Boolean r104, OptimizeMode r105, String r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, Boolean r115, String r116, String r117, List<UninterpretedOption> r118, ByteString r119) {
        super(ADAPTER, r119);
        this.mjava_package = r100;
        this.mjava_outer_classname = r101;
        this.mjava_multiple_files = r102;
        this.mjava_generate_equals_and_hash = r103;
        this.mjava_string_check_utf8 = r104;
        this.moptimize_for = r105;
        this.mgo_package = r110;
        this.mcc_generic_services = r111;
        this.mjava_generic_services = r112;
        this.mpy_generic_services = r113;
        this.mdeprecated = r114;
        this.mcc_enable_arenas = r115;
        this.mobjc_class_prefix = r116;
        this.mcsharp_namespace = r117;
        this.muninterpreted_option = Internal.immutableCopyOf("muninterpreted_option", r118);
    }
}

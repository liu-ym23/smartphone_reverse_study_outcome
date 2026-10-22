package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class FileOptions extends com.squareup.wire.Message<FileOptions, Builder> {
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
    public static final OptimizeMode DEFAULT_OPTIMIZE_FOR = null;
    public static final String DEFAULT_PHP_CLASS_PREFIX = "";
    public static final Boolean DEFAULT_PHP_GENERIC_SERVICES = null;
    public static final String DEFAULT_PHP_METADATA_NAMESPACE = "";
    public static final String DEFAULT_PHP_NAMESPACE = "";
    public static final Boolean DEFAULT_PY_GENERIC_SERVICES = null;
    public static final String DEFAULT_RUBY_PACKAGE = "";
    public static final String DEFAULT_SWIFT_PREFIX = "";
    private static final long serialVersionUID = 0;
    public final Boolean cc_enable_arenas;
    public final Boolean cc_generic_services;
    public final String csharp_namespace;
    public final Boolean deprecated;
    public final String go_package;
    public final Boolean java_generate_equals_and_hash;
    public final Boolean java_generic_services;
    public final Boolean java_multiple_files;
    public final String java_outer_classname;
    public final String java_package;
    public final Boolean java_string_check_utf8;
    public final String objc_class_prefix;
    public final OptimizeMode optimize_for;
    public final String php_class_prefix;
    public final Boolean php_generic_services;
    public final String php_metadata_namespace;
    public final String php_namespace;
    public final Boolean py_generic_services;
    public final String ruby_package;
    public final String swift_prefix;
    public final List<UninterpretedOption> uninterpreted_option;

    public static final class Builder extends com.squareup.wire.Message.Builder<FileOptions, Builder> {
        public Boolean cc_enable_arenas;
        public Boolean cc_generic_services;
        public String csharp_namespace;
        public Boolean deprecated;
        public String go_package;
        public Boolean java_generate_equals_and_hash;
        public Boolean java_generic_services;
        public Boolean java_multiple_files;
        public String java_outer_classname;
        public String java_package;
        public Boolean java_string_check_utf8;
        public String objc_class_prefix;
        public OptimizeMode optimize_for;
        public String php_class_prefix;
        public Boolean php_generic_services;
        public String php_metadata_namespace;
        public String php_namespace;
        public Boolean py_generic_services;
        public String ruby_package;
        public String swift_prefix;
        public List<UninterpretedOption> uninterpreted_option;

        @Override // com.squareup.wire.Message.Builder
        public FileOptions build() {
            return new FileOptions(this.java_package, this.java_outer_classname, this.java_multiple_files, this.java_generate_equals_and_hash, this.java_string_check_utf8, this.optimize_for, this.go_package, this.cc_generic_services, this.java_generic_services, this.py_generic_services, this.php_generic_services, this.deprecated, this.cc_enable_arenas, this.objc_class_prefix, this.csharp_namespace, this.swift_prefix, this.php_class_prefix, this.php_namespace, this.php_metadata_namespace, this.ruby_package, this.uninterpreted_option, super.buildUnknownFields());
        }

        public Builder() {
            this.uninterpreted_option = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cc_enable_arenas(Boolean r100) {
            this.cc_enable_arenas = r100;
            return this;
        }

        public Builder cc_generic_services(Boolean r100) {
            this.cc_generic_services = r100;
            return this;
        }

        public Builder csharp_namespace(String r100) {
            this.csharp_namespace = r100;
            return this;
        }

        public Builder deprecated(Boolean r100) {
            this.deprecated = r100;
            return this;
        }

        public Builder go_package(String r100) {
            this.go_package = r100;
            return this;
        }

        public Builder java_generate_equals_and_hash(Boolean r100) {
            this.java_generate_equals_and_hash = r100;
            return this;
        }

        public Builder java_generic_services(Boolean r100) {
            this.java_generic_services = r100;
            return this;
        }

        public Builder java_multiple_files(Boolean r100) {
            this.java_multiple_files = r100;
            return this;
        }

        public Builder java_outer_classname(String r100) {
            this.java_outer_classname = r100;
            return this;
        }

        public Builder java_package(String r100) {
            this.java_package = r100;
            return this;
        }

        public Builder java_string_check_utf8(Boolean r100) {
            this.java_string_check_utf8 = r100;
            return this;
        }

        public Builder objc_class_prefix(String r100) {
            this.objc_class_prefix = r100;
            return this;
        }

        public Builder optimize_for(OptimizeMode r100) {
            this.optimize_for = r100;
            return this;
        }

        public Builder php_class_prefix(String r100) {
            this.php_class_prefix = r100;
            return this;
        }

        public Builder php_generic_services(Boolean r100) {
            this.php_generic_services = r100;
            return this;
        }

        public Builder php_metadata_namespace(String r100) {
            this.php_metadata_namespace = r100;
            return this;
        }

        public Builder php_namespace(String r100) {
            this.php_namespace = r100;
            return this;
        }

        public Builder py_generic_services(Boolean r100) {
            this.py_generic_services = r100;
            return this;
        }

        public Builder ruby_package(String r100) {
            this.ruby_package = r100;
            return this;
        }

        public Builder swift_prefix(String r100) {
            this.swift_prefix = r100;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.uninterpreted_option = r100;
            return this;
        }
    }

    public static final enum OptimizeMode extends java.lang.Enum<OptimizeMode> implements WireEnum {
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
            r101.java_package = "";
            r101.java_outer_classname = "";
            Boolean r102 = Boolean.FALSE;
            r101.java_multiple_files = r102;
            r101.java_generate_equals_and_hash = r102;
            r101.java_string_check_utf8 = r102;
            r101.optimize_for = OptimizeMode.SPEED;
            r101.go_package = "";
            r101.cc_generic_services = r102;
            r101.java_generic_services = r102;
            r101.py_generic_services = r102;
            r101.php_generic_services = r102;
            r101.deprecated = r102;
            r101.cc_enable_arenas = Boolean.TRUE;
            r101.objc_class_prefix = "";
            r101.csharp_namespace = "";
            r101.swift_prefix = "";
            r101.php_class_prefix = "";
            r101.php_namespace = "";
            r101.php_metadata_namespace = "";
            r101.ruby_package = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L53;
            if (r104 != 1) goto L8;
            r101.java_package = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 20) goto L10;
            r101.java_generate_equals_and_hash = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 23) goto L12;
            r101.deprecated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 27) goto L14;
            r101.java_string_check_utf8 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 31) goto L16;
            r101.cc_enable_arenas = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            if (r104 != 999) goto L18;
            r101.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(r100));
            goto L3
        L18:
            if (r104 != 36) goto L20;
            r101.objc_class_prefix = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            if (r104 != 37) goto L22;
            r101.csharp_namespace = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            if (r104 != 44) goto L24;
            r101.php_metadata_namespace = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            if (r104 != 45) goto L25;
            r101.ruby_package = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            switch(r104) {
                case 8: goto L42;
                case 9: goto L55;
                case 10: goto L37;
                case 11: goto L36;
                default: goto L26;
            };
        L55:
            r101.optimize_for = OptimizeMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L40
        L40:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L36:
            r101.go_package = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.java_multiple_files = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L42:
            r101.java_outer_classname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            switch(r104) {
                case 16: goto L35;
                case 17: goto L34;
                case 18: goto L33;
                default: goto L27;
            };
        L33:
            r101.py_generic_services = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L34:
            r101.java_generic_services = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L35:
            r101.cc_generic_services = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            switch(r104) {
                case 39: goto L32;
                case 40: goto L31;
                case 41: goto L30;
                case 42: goto L29;
                default: goto L28;
            };
        L29:
            r101.php_generic_services = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L30:
            r101.php_namespace = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.php_class_prefix = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.swift_prefix = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L53:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FileOptions r100) {
            String r101 = r100.java_package;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.java_outer_classname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(8, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.java_multiple_files;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.java_generate_equals_and_hash;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.java_string_check_utf8;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r113);
        L22:
            int r115 = r112 + r114;
            OptimizeMode r116 = r100.optimize_for;
            if (r116 == null) goto L25;
            int r117 = OptimizeMode.ADAPTER.encodedSizeWithTag(9, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.go_package;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(11, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.cc_generic_services;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.java_generic_services;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.py_generic_services;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.php_generic_services;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(42, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.deprecated;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r134);
        L50:
            int r136 = r133 + r135;
            Boolean r137 = r100.cc_enable_arenas;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(31, r137);
        L54:
            int r139 = r136 + r138;
            String r140 = r100.objc_class_prefix;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.STRING.encodedSizeWithTag(36, r140);
        L58:
            int r142 = r139 + r141;
            String r143 = r100.csharp_namespace;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.STRING.encodedSizeWithTag(37, r143);
        L62:
            int r145 = r142 + r144;
            String r146 = r100.swift_prefix;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.STRING.encodedSizeWithTag(39, r146);
        L66:
            int r148 = r145 + r147;
            String r149 = r100.php_class_prefix;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.STRING.encodedSizeWithTag(40, r149);
        L70:
            int r151 = r148 + r150;
            String r152 = r100.php_namespace;
            if (r152 == null) goto L73;
            int r153 = ProtoAdapter.STRING.encodedSizeWithTag(41, r152);
        L74:
            int r154 = r151 + r153;
            String r155 = r100.php_metadata_namespace;
            if (r155 == null) goto L77;
            int r156 = ProtoAdapter.STRING.encodedSizeWithTag(44, r155);
        L78:
            int r157 = r154 + r156;
            String r158 = r100.ruby_package;
            if (r158 == null) goto L82;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(45, r158);
        L82:
            return ((r157 + r102) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, r100.uninterpreted_option)) + r100.unknownFields().size();
        L77:
            r156 = 0;
            goto L78
        L73:
            r153 = 0;
            goto L74
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
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
            String r102 = r101.java_package;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.java_outer_classname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r103);
        L8:
            Boolean r104 = r101.java_multiple_files;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r104);
        L11:
            Boolean r105 = r101.java_generate_equals_and_hash;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 20, r105);
        L14:
            Boolean r106 = r101.java_string_check_utf8;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 27, r106);
        L17:
            OptimizeMode r107 = r101.optimize_for;
            if (r107 == null) goto L20;
            OptimizeMode.ADAPTER.encodeWithTag(r100, 9, r107);
        L20:
            String r108 = r101.go_package;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r108);
        L23:
            Boolean r109 = r101.cc_generic_services;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r109);
        L26:
            Boolean r110 = r101.java_generic_services;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r110);
        L29:
            Boolean r111 = r101.py_generic_services;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r111);
        L32:
            Boolean r112 = r101.php_generic_services;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 42, r112);
        L35:
            Boolean r113 = r101.deprecated;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 23, r113);
        L38:
            Boolean r114 = r101.cc_enable_arenas;
            if (r114 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 31, r114);
        L41:
            String r115 = r101.objc_class_prefix;
            if (r115 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r100, 36, r115);
        L44:
            String r116 = r101.csharp_namespace;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 37, r116);
        L47:
            String r117 = r101.swift_prefix;
            if (r117 == null) goto L50;
            ProtoAdapter.STRING.encodeWithTag(r100, 39, r117);
        L50:
            String r118 = r101.php_class_prefix;
            if (r118 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r100, 40, r118);
        L53:
            String r119 = r101.php_namespace;
            if (r119 == null) goto L56;
            ProtoAdapter.STRING.encodeWithTag(r100, 41, r119);
        L56:
            String r120 = r101.php_metadata_namespace;
            if (r120 == null) goto L59;
            ProtoAdapter.STRING.encodeWithTag(r100, 44, r120);
        L59:
            String r121 = r101.ruby_package;
            if (r121 == null) goto L62;
            ProtoAdapter.STRING.encodeWithTag(r100, 45, r121);
        L62:
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(r100, 999, r101.uninterpreted_option);
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
        DEFAULT_OPTIMIZE_FOR = OptimizeMode.SPEED;
        DEFAULT_CC_GENERIC_SERVICES = r100;
        DEFAULT_JAVA_GENERIC_SERVICES = r100;
        DEFAULT_PY_GENERIC_SERVICES = r100;
        DEFAULT_PHP_GENERIC_SERVICES = r100;
        DEFAULT_DEPRECATED = r100;
        DEFAULT_CC_ENABLE_ARENAS = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.java_package = this.java_package;
        r100.java_outer_classname = this.java_outer_classname;
        r100.java_multiple_files = this.java_multiple_files;
        r100.java_generate_equals_and_hash = this.java_generate_equals_and_hash;
        r100.java_string_check_utf8 = this.java_string_check_utf8;
        r100.optimize_for = this.optimize_for;
        r100.go_package = this.go_package;
        r100.cc_generic_services = this.cc_generic_services;
        r100.java_generic_services = this.java_generic_services;
        r100.py_generic_services = this.py_generic_services;
        r100.php_generic_services = this.php_generic_services;
        r100.deprecated = this.deprecated;
        r100.cc_enable_arenas = this.cc_enable_arenas;
        r100.objc_class_prefix = this.objc_class_prefix;
        r100.csharp_namespace = this.csharp_namespace;
        r100.swift_prefix = this.swift_prefix;
        r100.php_class_prefix = this.php_class_prefix;
        r100.php_namespace = this.php_namespace;
        r100.php_metadata_namespace = this.php_metadata_namespace;
        r100.ruby_package = this.ruby_package;
        r100.uninterpreted_option = com.squareup.wire.internal.Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileOptions(String r210, String r211, Boolean r212, Boolean r213, Boolean r214, OptimizeMode r215, String r310, Boolean r311, Boolean r312, Boolean r313, Boolean r314, Boolean r315, Boolean r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, List<UninterpretedOption> r414) {
        this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, okio.ByteString.EMPTY);
    }

    public FileOptions(String r100, String r101, Boolean r102, Boolean r103, Boolean r104, OptimizeMode r105, String r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, Boolean r115, Boolean r116, String r117, String r118, String r119, String r210, String r211, String r212, String r213, List<UninterpretedOption> r214, okio.ByteString r215) {
        super(ADAPTER, r215);
        this.java_package = r100;
        this.java_outer_classname = r101;
        this.java_multiple_files = r102;
        this.java_generate_equals_and_hash = r103;
        this.java_string_check_utf8 = r104;
        this.optimize_for = r105;
        this.go_package = r110;
        this.cc_generic_services = r111;
        this.java_generic_services = r112;
        this.py_generic_services = r113;
        this.php_generic_services = r114;
        this.deprecated = r115;
        this.cc_enable_arenas = r116;
        this.objc_class_prefix = r117;
        this.csharp_namespace = r118;
        this.swift_prefix = r119;
        this.php_class_prefix = r210;
        this.php_namespace = r211;
        this.php_metadata_namespace = r212;
        this.ruby_package = r213;
        this.uninterpreted_option = com.squareup.wire.internal.Internal.immutableCopyOf("uninterpreted_option", r214);
    }
}

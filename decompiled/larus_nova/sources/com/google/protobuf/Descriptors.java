package com.google.protobuf;

import androidx.camera.video.AudioStats;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import kotlin.text.Typography;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class Descriptors {
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.Descriptors$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r100 = new int[FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r100;
            r100[FieldDescriptor.JavaType.ENUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L64:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[FieldDescriptor.JavaType.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L6:
            int[] r101 = new int[FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r101;
            r101[FieldDescriptor.Type.INT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L68:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SINT32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L84:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SFIXED32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.UINT32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L76:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.INT64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L52:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SINT64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L74:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SFIXED64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L80:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.UINT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L62:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FIXED64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L66:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FLOAT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L54:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.DOUBLE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L39
        L56:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.BOOL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L40
        L82:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.STRING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L41
        L50:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L42
        L72:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.ENUM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L43
        L78:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L44
        L60:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.GROUP.ordinal()] = 18;     // Catch: NoSuchFieldError -> L45
            return;
        }
    }

    public static final class Descriptor extends GenericDescriptor {
        private final Descriptor containingType;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final Descriptor[] nestedTypes;
        private final OneofDescriptor[] oneofs;
        private DescriptorProtos.DescriptorProto proto;

        private void crossLink() throws DescriptorValidationException {
            Descriptor[] r100 = this.nestedTypes;
            int r101 = r100.length;
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L5;
            r100[r103].crossLink();
            r103 = r103 + 1;
            goto L3
        L5:
            FieldDescriptor[] r104 = this.fields;
            int r105 = r104.length;
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L8;
            FieldDescriptor.access$900(r104[r106]);
            r106 = r106 + 1;
            goto L6
        L8:
            FieldDescriptor[] r107 = this.extensions;
            int r108 = r107.length;
        L9:
            if (r102 >= r108) goto L11;
            FieldDescriptor.access$900(r107[r102]);
            r102 = r102 + 1;
            goto L9
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public List<OneofDescriptor> getOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs));
        }

        public DescriptorProtos.MessageOptions getOptions() {
            return this.proto.getOptions();
        }

        public boolean isExtendable() {
            if (this.proto.getExtensionRangeList().size() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.DescriptorProto toProto() {
            return this.proto;
        }

        public Descriptor(String r100) throws DescriptorValidationException {
            int r101 = r100.lastIndexOf(46);
            if (r101 == (-1)) goto L5;
            String r102 = r100.substring(r101 + 1);
            String r103 = r100.substring(0, r101);
        L6:
            this.index = 0;
            this.proto = DescriptorProtos.DescriptorProto.newBuilder().setName(r102).addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
            this.fullName = r100;
            this.containingType = null;
            this.nestedTypes = new Descriptor[0];
            this.enumTypes = new EnumDescriptor[0];
            this.fields = new FieldDescriptor[0];
            this.extensions = new FieldDescriptor[0];
            this.oneofs = new OneofDescriptor[0];
            this.file = new FileDescriptor(r103, this);
            return;
        L5:
            r103 = "";
            r102 = r100;
            goto L6
        }

        public static /* synthetic */ void access$700(Descriptor r100) throws DescriptorValidationException {
            r100.crossLink();
        }

        private void setProto(DescriptorProtos.DescriptorProto r100) {
            this.proto = r100;
            int r101 = 0;
            int r102 = 0;
        L3:
            Descriptor[] r103 = this.nestedTypes;
            if (r102 >= r103.length) goto L6;
            r103[r102].setProto(r100.getNestedType(r102));
            r102 = r102 + 1;
            goto L3
        L6:
            int r104 = 0;
        L7:
            OneofDescriptor[] r105 = this.oneofs;
            if (r104 >= r105.length) goto L10;
            OneofDescriptor.access$2000(r105[r104], r100.getOneofDecl(r104));
            r104 = r104 + 1;
            goto L7
        L10:
            int r106 = 0;
        L11:
            EnumDescriptor[] r107 = this.enumTypes;
            if (r106 >= r107.length) goto L14;
            EnumDescriptor.access$1100(r107[r106], r100.getEnumType(r106));
            r106 = r106 + 1;
            goto L11
        L14:
            int r108 = 0;
        L15:
            FieldDescriptor[] r109 = this.fields;
            if (r108 >= r109.length) goto L18;
            FieldDescriptor.access$1300(r109[r108], r100.getField(r108));
            r108 = r108 + 1;
        L18:
            FieldDescriptor[] r110 = this.extensions;
            if (r101 >= r110.length) goto L21;
            FieldDescriptor.access$1300(r110[r101], r100.getExtension(r101));
            r101 = r101 + 1;
            goto L18
        }

        public EnumDescriptor findEnumTypeByName(String r100) {
            GenericDescriptor r101 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            if ((r101 instanceof EnumDescriptor) == true) goto L7;
            return null;
        L7:
            return (EnumDescriptor) r101;
        }

        public FieldDescriptor findFieldByName(String r100) {
            GenericDescriptor r101 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            if ((r101 instanceof FieldDescriptor) == true) goto L7;
            return null;
        L7:
            return (FieldDescriptor) r101;
        }

        public FieldDescriptor findFieldByNumber(int r100) {
            return (FieldDescriptor) DescriptorPool.access$1500(FileDescriptor.access$1400(this.file)).get(new DescriptorPool.DescriptorIntPair(this, r100));
        }

        public Descriptor findNestedTypeByName(String r100) {
            GenericDescriptor r101 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            if ((r101 instanceof Descriptor) == true) goto L7;
            return null;
        L7:
            return (Descriptor) r101;
        }

        public boolean isExtensionNumber(int r100) {
            Iterator<DescriptorProtos.DescriptorProto.ExtensionRange> r101 = this.proto.getExtensionRangeList().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            DescriptorProtos.DescriptorProto.ExtensionRange r102 = r101.next();
            if (r102.getStart() > r100) goto L4;
            if (r100 >= r102.getEnd()) goto L4;
            return true;
        L11:
            return false;
        }

        public boolean isReservedName(String r100) {
            Internal.checkNotNull(r100);
            Iterator<String> r101 = this.proto.getReservedNameList().iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            if (r101.next().equals(r100) == false) goto L4;
            return true;
        L9:
            return false;
        }

        public boolean isReservedNumber(int r100) {
            Iterator<DescriptorProtos.DescriptorProto.ReservedRange> r101 = this.proto.getReservedRangeList().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            DescriptorProtos.DescriptorProto.ReservedRange r102 = r101.next();
            if (r102.getStart() > r100) goto L4;
            if (r100 >= r102.getEnd()) goto L4;
            return true;
        L11:
            return false;
        }

        public static /* synthetic */ void access$1000(Descriptor r100, DescriptorProtos.DescriptorProto r101) {
            r100.setProto(r101);
        }

        private Descriptor(DescriptorProtos.DescriptorProto r110, FileDescriptor r111, Descriptor r112, int r113) throws DescriptorValidationException {
            this.index = r113;
            this.proto = r110;
            this.fullName = Descriptors.access$1600(r111, r112, r110.getName());
            this.file = r111;
            this.containingType = r112;
            this.oneofs = new OneofDescriptor[r110.getOneofDeclCount()];
            int r114 = 0;
            int r115 = 0;
        L4:
            if (r115 >= r110.getOneofDeclCount()) goto L6;
            int r100 = r115;
            this.oneofs[r115] = new OneofDescriptor(r110.getOneofDecl(r115), r111, this, r100, null);
            r115 = r115 + 1;
            goto L4
        L6:
            this.nestedTypes = new Descriptor[r110.getNestedTypeCount()];
            int r116 = 0;
        L8:
            if (r116 >= r110.getNestedTypeCount()) goto L10;
            this.nestedTypes[r116] = new Descriptor(r110.getNestedType(r116), r111, this, r116);
            r116 = r116 + 1;
            goto L8
        L10:
            this.enumTypes = new EnumDescriptor[r110.getEnumTypeCount()];
            int r117 = 0;
        L12:
            if (r117 >= r110.getEnumTypeCount()) goto L14;
            int r101 = r117;
            this.enumTypes[r117] = new EnumDescriptor(r110.getEnumType(r117), r111, this, r101, null);
            r117 = r117 + 1;
            goto L12
        L14:
            this.fields = new FieldDescriptor[r110.getFieldCount()];
            int r118 = 0;
        L16:
            if (r118 >= r110.getFieldCount()) goto L18;
            int r102 = r118;
            this.fields[r118] = new FieldDescriptor(r110.getField(r118), r111, this, r102, false, null);
            r118 = r118 + 1;
            goto L16
        L18:
            this.extensions = new FieldDescriptor[r110.getExtensionCount()];
            int r119 = 0;
        L20:
            if (r119 >= r110.getExtensionCount()) goto L22;
            int r103 = r119;
            this.extensions[r119] = new FieldDescriptor(r110.getExtension(r119), r111, this, r103, true, null);
            r119 = r119 + 1;
            goto L20
        L22:
            int r120 = 0;
        L24:
            if (r120 >= r110.getOneofDeclCount()) goto L27;
            OneofDescriptor r104 = this.oneofs[r120];
            OneofDescriptor.access$1802(r104, new FieldDescriptor[r104.getFieldCount()]);
            OneofDescriptor.access$1902(this.oneofs[r120], 0);
            r120 = r120 + 1;
        L27:
            if (r114 >= r110.getFieldCount()) goto L32;
            OneofDescriptor r121 = this.fields[r114].getContainingOneof();
            if (r121 == null) goto L31;
            OneofDescriptor.access$1800(r121)[OneofDescriptor.access$1908(r121)] = this.fields[r114];
        L31:
            r114 = r114 + 1;
            goto L27
        L32:
            FileDescriptor.access$1400(r111).addSymbol(this);
        }

        public /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto r100, FileDescriptor r101, Descriptor r102, int r103, AnonymousClass1 r104) throws DescriptorValidationException {
            this(r100, r101, r102, r103);
        }
    }

    public static final class DescriptorPool {
        private boolean allowUnknownDependencies;
        private final Set<FileDescriptor> dependencies;
        private final Map<String, GenericDescriptor> descriptorsByName;
        private final Map<DescriptorIntPair, EnumValueDescriptor> enumValuesByNumber;
        private final Map<DescriptorIntPair, FieldDescriptor> fieldsByNumber;

        public static final class DescriptorIntPair {
            private final GenericDescriptor descriptor;
            private final int number;

            public int hashCode() {
                return (this.descriptor.hashCode() * 65535) + this.number;
            }

            public boolean equals(Object r100) {
                if ((r100 instanceof DescriptorIntPair) == true) goto L5;
                return false;
            L5:
                DescriptorIntPair r101 = (DescriptorIntPair) r100;
                if (this.descriptor == r101.descriptor) goto L8;
                return false;
            L8:
                if (this.number != r101.number) goto L12;
                return true;
            L12:
                return false;
            }

            public DescriptorIntPair(GenericDescriptor r100, int r101) {
                this.descriptor = r100;
                this.number = r101;
            }
        }

        public static final class PackageDescriptor extends GenericDescriptor {
            private final FileDescriptor file;
            private final String fullName;
            private final String name;

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public Message toProto() {
                return this.file.toProto();
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public FileDescriptor getFile() {
                return this.file;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getFullName() {
                return this.fullName;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getName() {
                return this.name;
            }

            public PackageDescriptor(String r100, String r101, FileDescriptor r102) {
                this.file = r102;
                this.fullName = r101;
                this.name = r100;
            }
        }

        public static final enum SearchFilter extends java.lang.Enum<SearchFilter> {
            private static final /* synthetic */ SearchFilter[] $VALUES = null;
            public static final SearchFilter AGGREGATES_ONLY = null;
            public static final SearchFilter ALL_SYMBOLS = null;
            public static final SearchFilter TYPES_ONLY = null;

            static {
                SearchFilter r100 = new SearchFilter("TYPES_ONLY", 0);
                TYPES_ONLY = r100;
                SearchFilter r101 = new SearchFilter("AGGREGATES_ONLY", 1);
                AGGREGATES_ONLY = r101;
                SearchFilter r102 = new SearchFilter("ALL_SYMBOLS", 2);
                ALL_SYMBOLS = r102;
                $VALUES = new SearchFilter[]{r100, r101, r102};
            }

            public static SearchFilter[] values() {
                return (SearchFilter[]) $VALUES.clone();
            }

            public static SearchFilter valueOf(String r100) {
                return (SearchFilter) a.a(SearchFilter.class, r100);
            }

            private SearchFilter(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static /* synthetic */ Map access$1500(DescriptorPool r100) {
            return r100.fieldsByNumber;
        }

        public static /* synthetic */ Map access$2400(DescriptorPool r100) {
            return r100.enumValuesByNumber;
        }

        private void importPublicDependencies(FileDescriptor r100) {
            Iterator<FileDescriptor> r101 = r100.getPublicDependencies().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            FileDescriptor r102 = r101.next();
            if (this.dependencies.add(r102) == false) goto L4;
            importPublicDependencies(r102);
            goto L4
        }

        public static void validateSymbolName(GenericDescriptor r100) throws DescriptorValidationException {
            String r101 = r100.getName();
            AnonymousClass1 r102 = null;
            if (r101.length() == 0) goto L25;
            boolean r103 = true;
            int r104 = 0;
        L6:
            if (r104 >= r101.length()) goto L20;
            char r105 = r101.charAt(r104);
            if (r105 < 128) goto L11;
            r103 = false;
        L11:
            if (Character.isLetter(r105) == true) goto L19;
            if (r105 == '_') goto L19;
            if (Character.isDigit(r105) == false) goto L18;
            if (r104 > 0) goto L19;
        L18:
            r103 = false;
        L19:
            r104 = r104 + 1;
            goto L6
        L20:
            if (r103 == false) goto L23;
            return;
        L23:
            throw new DescriptorValidationException(r100, "\"" + r101 + "\" is not a valid identifier.", r102);
        L25:
            throw new DescriptorValidationException(r100, "Missing name.", r102);
        }

        public void addEnumValueByNumber(EnumValueDescriptor r100) {
            DescriptorIntPair r101 = new DescriptorIntPair(r100.getType(), r100.getNumber());
            EnumValueDescriptor r102 = this.enumValuesByNumber.put(r101, r100);
            if (r102 == null) goto L6;
            this.enumValuesByNumber.put(r101, r102);
            return;
        }

        public void addFieldByNumber(FieldDescriptor r100) throws DescriptorValidationException {
            DescriptorIntPair r101 = new DescriptorIntPair(r100.getContainingType(), r100.getNumber());
            FieldDescriptor r102 = this.fieldsByNumber.put(r101, r100);
            if (r102 != null) goto L5;
            return;
        L5:
            this.fieldsByNumber.put(r101, r102);
            throw new DescriptorValidationException(r100, "Field number " + r100.getNumber() + " has already been used in \"" + r100.getContainingType().getFullName() + "\" by field \"" + r102.getName() + "\".", null);
        }

        public void addSymbol(GenericDescriptor r100) throws DescriptorValidationException {
            validateSymbolName(r100);
            String r101 = r100.getFullName();
            int r102 = r101.lastIndexOf(46);
            GenericDescriptor r103 = this.descriptorsByName.put(r101, r100);
            if (r103 == null) goto L14;
            this.descriptorsByName.put(r101, r103);
            AnonymousClass1 r104 = null;
            if (r100.getFile() != r103.getFile()) goto L13;
            if (r102 != (-1)) goto L11;
            throw new DescriptorValidationException(r100, "\"" + r101 + "\" is already defined.", r104);
        L11:
            throw new DescriptorValidationException(r100, "\"" + r101.substring(r102 + 1) + "\" is already defined in \"" + r101.substring(0, r102) + "\".", r104);
        L13:
            throw new DescriptorValidationException(r100, "\"" + r101 + "\" is already defined in file \"" + r103.getFile().getName() + "\".", r104);
        }

        public GenericDescriptor findSymbol(String r100) {
            return findSymbol(r100, SearchFilter.ALL_SYMBOLS);
        }

        public boolean isAggregate(GenericDescriptor r100) {
            if ((r100 instanceof Descriptor) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r100 instanceof EnumDescriptor) == true) goto L12;
            if ((r100 instanceof PackageDescriptor) == true) goto L12;
            if ((r100 instanceof ServiceDescriptor) == true) goto L12;
            return false;
        }

        public boolean isType(GenericDescriptor r100) {
            if ((r100 instanceof Descriptor) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r100 instanceof EnumDescriptor) == true) goto L8;
            return false;
        }

        public DescriptorPool(FileDescriptor[] r100, boolean r101) {
            this.descriptorsByName = new HashMap();
            this.fieldsByNumber = new HashMap();
            this.enumValuesByNumber = new HashMap();
            this.dependencies = new HashSet();
            this.allowUnknownDependencies = r101;
            int r102 = 0;
        L4:
            if (r102 >= r100.length) goto L6;
            this.dependencies.add(r100[r102]);
            importPublicDependencies(r100[r102]);
            r102 = r102 + 1;
            goto L4
        L6:
            Iterator<FileDescriptor> r103 = this.dependencies.iterator();
        L8:
            if (r103.hasNext() == false) goto L15;
            FileDescriptor r104 = r103.next();
            addPackage(r104.getPackage(), r104);     // Catch: DescriptorValidationException -> L12
        L12:
            e = move-exception;
            throw new AssertionError(e);
        }

        public void addPackage(String r100, FileDescriptor r101) throws DescriptorValidationException {
            int r102 = r100.lastIndexOf(46);
            if (r102 != (-1)) goto L5;
            String r103 = r100;
        L6:
            GenericDescriptor r104 = this.descriptorsByName.put(r100, new PackageDescriptor(r103, r100, r101));
            if (r104 == null) goto L13;
            this.descriptorsByName.put(r100, r104);
            if ((r104 instanceof PackageDescriptor) == false) goto L12;
            return;
        L12:
            throw new DescriptorValidationException(r101, "\"" + r103 + "\" is already defined (as something other than a package) in file \"" + r104.getFile().getName() + "\".", null);
        L13:
            return;
        L5:
            addPackage(r100.substring(0, r102), r101);
            r103 = r100.substring(r102 + 1);
            goto L6
        }

        public GenericDescriptor findSymbol(String r100, SearchFilter r101) {
            GenericDescriptor r102 = this.descriptorsByName.get(r100);
            if (r102 != null) goto L5;
        L15:
            Iterator<FileDescriptor> r103 = this.dependencies.iterator();
        L17:
            if (r103.hasNext() == false) goto L31;
            GenericDescriptor r104 = FileDescriptor.access$1400(r103.next()).descriptorsByName.get(r100);
            if (r104 == null) goto L17;
            if (r101 == SearchFilter.ALL_SYMBOLS) goto L30;
            if (r101 != SearchFilter.TYPES_ONLY) goto L27;
            if (isType(r104) == true) goto L30;
        L27:
            if (r101 != SearchFilter.AGGREGATES_ONLY) goto L17;
            if (isAggregate(r104) == false) goto L17;
        L30:
            return r104;
        L31:
            return null;
        L5:
            if (r101 != SearchFilter.ALL_SYMBOLS) goto L7;
        L14:
            return r102;
        L7:
            if (r101 != SearchFilter.TYPES_ONLY) goto L11;
            if (isType(r102) == true) goto L14;
        L11:
            if (r101 != SearchFilter.AGGREGATES_ONLY) goto L15;
            if (isAggregate(r102) == false) goto L15;
            goto L14
        }

        public GenericDescriptor lookupSymbol(String r110, GenericDescriptor r111, SearchFilter r112) throws DescriptorValidationException {
            if (r110.startsWith(".") == false) goto L5;
            String r100 = r110.substring(1);
            GenericDescriptor r101 = findSymbol(r100, r112);
        L19:
            if (r101 == null) goto L21;
            return r101;
        L21:
            if (this.allowUnknownDependencies == false) goto L27;
            if (r112 != SearchFilter.TYPES_ONLY) goto L27;
            Descriptors.access$100().warning("The descriptor for message type \"" + r110 + "\" can not be found and a placeholder is created for it");
            Descriptor r113 = new Descriptor(r100);
            this.dependencies.add(r113.getFile());
            return r113;
        L27:
            throw new DescriptorValidationException(r111, "\"" + r110 + "\" is not defined.", null);
        L5:
            int r102 = r110.indexOf(46);
            if (r102 != (-1)) goto L8;
            String r103 = r110;
        L9:
            StringBuilder r104 = new StringBuilder(r111.getFullName());
        L10:
            int r105 = r104.lastIndexOf(".");
            if (r105 == (-1)) goto L12;
            int r106 = r105 + 1;
            r104.setLength(r106);
            r104.append(r103);
            GenericDescriptor r107 = findSymbol(r104.toString(), SearchFilter.AGGREGATES_ONLY);
            if (r107 != null) goto L15;
            r104.setLength(r105);
            goto L10
        L15:
            if (r102 == (-1)) goto L17;
            r104.setLength(r106);
            r104.append(r110);
            r101 = findSymbol(r104.toString(), r112);
        L18:
            r100 = r104.toString();
            goto L19
        L17:
            r101 = r107;
            goto L18
        L12:
            r101 = findSymbol(r110, r112);
            r100 = r110;
            goto L19
        L8:
            r103 = r110.substring(0, r102);
            goto L9
        }
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final Message proto;

        public String getDescription() {
            return this.description;
        }

        public Message getProblemProto() {
            return this.proto;
        }

        public String getProblemSymbolName() {
            return this.name;
        }

        private DescriptorValidationException(FileDescriptor r100, String r101) {
            super(r100.getName() + ": " + r101);
            this.name = r100.getName();
            this.proto = r100.toProto();
            this.description = r101;
        }

        private DescriptorValidationException(GenericDescriptor r100, String r101) {
            super(r100.getFullName() + ": " + r101);
            this.name = r100.getFullName();
            this.proto = r100.toProto();
            this.description = r101;
        }

        private DescriptorValidationException(GenericDescriptor r100, String r101, Throwable r102) {
            this(r100, r101);
            initCause(r102);
        }

        public /* synthetic */ DescriptorValidationException(FileDescriptor r100, String r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        public /* synthetic */ DescriptorValidationException(GenericDescriptor r100, String r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        public /* synthetic */ DescriptorValidationException(GenericDescriptor r100, String r101, Throwable r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public static final class EnumDescriptor extends GenericDescriptor implements Internal.EnumLiteMap<EnumValueDescriptor> {
        private final Descriptor containingType;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private DescriptorProtos.EnumDescriptorProto proto;
        private final WeakHashMap<Integer, WeakReference<EnumValueDescriptor>> unknownValues;
        private EnumValueDescriptor[] values;

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.EnumOptions getOptions() {
            return this.proto.getOptions();
        }

        public int getUnknownEnumValueDescriptorCount() {
            return this.unknownValues.size();
        }

        public List<EnumValueDescriptor> getValues() {
            return Collections.unmodifiableList(Arrays.asList(this.values));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumDescriptorProto toProto() {
            return this.proto;
        }

        private void setProto(DescriptorProtos.EnumDescriptorProto r100) {
            this.proto = r100;
            int r101 = 0;
        L3:
            EnumValueDescriptor[] r102 = this.values;
            if (r101 >= r102.length) goto L6;
            EnumValueDescriptor.access$2700(r102[r101], r100.getValue(r101));
            r101 = r101 + 1;
            goto L3
        }

        public EnumValueDescriptor findValueByName(String r100) {
            GenericDescriptor r101 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            if ((r101 instanceof EnumValueDescriptor) == true) goto L7;
            return null;
        L7:
            return (EnumValueDescriptor) r101;
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EnumValueDescriptor findValueByNumber(int r100) {
            return (EnumValueDescriptor) DescriptorPool.access$2400(FileDescriptor.access$1400(this.file)).get(new DescriptorPool.DescriptorIntPair(this, r100));
        }

        public EnumValueDescriptor findValueByNumberCreatingIfUnknown(int r100) {
            EnumValueDescriptor r101 = findValueByNumber(r100);
            if (r101 == null) goto L5;
            return r101;
        L5:
            monitor-enter(this);
            Integer r102 = new Integer(r100);     // Catch: Throwable -> L13
            WeakReference<EnumValueDescriptor> r103 = this.unknownValues.get(r102);     // Catch: Throwable -> L13
            if (r103 == null) goto L9;
            r101 = r103.get();     // Catch: Throwable -> L13
        L9:
            if (r101 != null) goto L11;
            r101 = new EnumValueDescriptor(this.file, this, r102, null);     // Catch: Throwable -> L13
            this.unknownValues.put(r102, new WeakReference(r101));     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return r101;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public /* bridge */ /* synthetic */ Internal.EnumLite findValueByNumber(int r100) {
            return findValueByNumber(r100);
        }

        public static /* synthetic */ void access$1100(EnumDescriptor r100, DescriptorProtos.EnumDescriptorProto r101) {
            r100.setProto(r101);
        }

        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto r100, FileDescriptor r101, Descriptor r110, int r111) throws DescriptorValidationException {
            this.unknownValues = new WeakHashMap();
            this.index = r111;
            this.proto = r100;
            this.fullName = Descriptors.access$1600(r101, r110, r100.getName());
            this.file = r101;
            this.containingType = r110;
            if (r100.getValueCount() == 0) goto L11;
            this.values = new EnumValueDescriptor[r100.getValueCount()];
            int r112 = 0;
        L6:
            if (r112 >= r100.getValueCount()) goto L8;
            int r102 = r112;
            this.values[r112] = new EnumValueDescriptor(r100.getValue(r112), r101, this, r102, null);
            r112 = r112 + 1;
            goto L6
        L8:
            FileDescriptor.access$1400(r101).addSymbol(this);
            return;
        L11:
            throw new DescriptorValidationException(this, "Enums must contain at least one value.", null);
        }

        public /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto r100, FileDescriptor r101, Descriptor r102, int r103, AnonymousClass1 r104) throws DescriptorValidationException {
            this(r100, r101, r102, r103);
        }
    }

    public static final class EnumValueDescriptor extends GenericDescriptor implements Internal.EnumLite {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Integer number;
        private DescriptorProtos.EnumValueDescriptorProto proto;
        private final EnumDescriptor type;

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        public DescriptorProtos.EnumValueOptions getOptions() {
            return this.proto.getOptions();
        }

        public String toString() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public EnumDescriptor getType() {
            return this.type;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumValueDescriptorProto toProto() {
            return this.proto;
        }

        private void setProto(DescriptorProtos.EnumValueDescriptorProto r100) {
            this.proto = r100;
        }

        public static /* synthetic */ void access$2700(EnumValueDescriptor r100, DescriptorProtos.EnumValueDescriptorProto r101) {
            r100.setProto(r101);
        }

        private EnumValueDescriptor(FileDescriptor r100, EnumDescriptor r101, Integer r102) {
            DescriptorProtos.EnumValueDescriptorProto r103 = DescriptorProtos.EnumValueDescriptorProto.newBuilder().setName("UNKNOWN_ENUM_VALUE_" + r101.getName() + "_" + r102).setNumber(r102.intValue()).build();
            this.index = -1;
            this.proto = r103;
            this.file = r100;
            this.type = r101;
            this.fullName = r101.getFullName() + '.' + r103.getName();
            this.number = r102;
        }

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r100, FileDescriptor r101, EnumDescriptor r102, int r103) throws DescriptorValidationException {
            this.index = r103;
            this.proto = r100;
            this.file = r101;
            this.type = r102;
            this.fullName = r102.getFullName() + '.' + r100.getName();
            FileDescriptor.access$1400(r101).addSymbol(this);
            FileDescriptor.access$1400(r101).addEnumValueByNumber(this);
        }

        public /* synthetic */ EnumValueDescriptor(FileDescriptor r100, EnumDescriptor r101, Integer r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }

        public /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r100, FileDescriptor r101, EnumDescriptor r102, int r103, AnonymousClass1 r104) throws DescriptorValidationException {
            this(r100, r101, r102, r103);
        }
    }

    public static final class FieldDescriptor extends GenericDescriptor implements Comparable<FieldDescriptor>, FieldSet.FieldDescriptorLite<FieldDescriptor> {
        private static final WireFormat.FieldType[] table = null;
        private OneofDescriptor containingOneof;
        private Descriptor containingType;
        private Object defaultValue;
        private EnumDescriptor enumType;
        private final Descriptor extensionScope;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final String jsonName;
        private Descriptor messageType;
        private DescriptorProtos.FieldDescriptorProto proto;
        private Type type;

        public static final enum JavaType extends java.lang.Enum<JavaType> {
            private static final /* synthetic */ JavaType[] $VALUES = null;
            public static final JavaType BOOLEAN = null;
            public static final JavaType BYTE_STRING = null;
            public static final JavaType DOUBLE = null;
            public static final JavaType ENUM = null;
            public static final JavaType FLOAT = null;
            public static final JavaType INT = null;
            public static final JavaType LONG = null;
            public static final JavaType MESSAGE = null;
            public static final JavaType STRING = null;
            private final Object defaultDefault;

            static {
                JavaType r100 = new JavaType("INT", 0, 0);
                INT = r100;
                JavaType r101 = new JavaType("LONG", 1, 0L);
                LONG = r101;
                JavaType r102 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
                FLOAT = r102;
                JavaType r103 = new JavaType("DOUBLE", 3, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
                DOUBLE = r103;
                JavaType r104 = new JavaType("BOOLEAN", 4, Boolean.FALSE);
                BOOLEAN = r104;
                JavaType r105 = new JavaType("STRING", 5, "");
                STRING = r105;
                JavaType r110 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
                BYTE_STRING = r110;
                JavaType r111 = new JavaType("ENUM", 7, null);
                ENUM = r111;
                JavaType r112 = new JavaType("MESSAGE", 8, null);
                MESSAGE = r112;
                $VALUES = new JavaType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
            }

            public static JavaType[] values() {
                return (JavaType[]) $VALUES.clone();
            }

            public static /* synthetic */ Object access$2300(JavaType r100) {
                return r100.defaultDefault;
            }

            public static JavaType valueOf(String r100) {
                return (JavaType) a.a(JavaType.class, r100);
            }

            private JavaType(String r100, int r101, Object r102) {
                super(r100, r101);
                this.defaultDefault = r102;
            }
        }

        public static final enum Type extends java.lang.Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type BOOL = null;
            public static final Type BYTES = null;
            public static final Type DOUBLE = null;
            public static final Type ENUM = null;
            public static final Type FIXED32 = null;
            public static final Type FIXED64 = null;
            public static final Type FLOAT = null;
            public static final Type GROUP = null;
            public static final Type INT32 = null;
            public static final Type INT64 = null;
            public static final Type MESSAGE = null;
            public static final Type SFIXED32 = null;
            public static final Type SFIXED64 = null;
            public static final Type SINT32 = null;
            public static final Type SINT64 = null;
            public static final Type STRING = null;
            public static final Type UINT32 = null;
            public static final Type UINT64 = null;
            private JavaType javaType;

            static {
                Type r100 = new Type("DOUBLE", 0, JavaType.DOUBLE);
                DOUBLE = r100;
                Type r101 = new Type("FLOAT", 1, JavaType.FLOAT);
                FLOAT = r101;
                JavaType r102 = JavaType.LONG;
                Type r103 = new Type("INT64", 2, r102);
                INT64 = r103;
                Type r104 = new Type("UINT64", 3, r102);
                UINT64 = r104;
                JavaType r110 = JavaType.INT;
                Type r105 = new Type("INT32", 4, r110);
                INT32 = r105;
                Type r111 = new Type("FIXED64", 5, r102);
                FIXED64 = r111;
                Type r112 = new Type("FIXED32", 6, r110);
                FIXED32 = r112;
                Type r113 = new Type("BOOL", 7, JavaType.BOOLEAN);
                BOOL = r113;
                Type r114 = new Type("STRING", 8, JavaType.STRING);
                STRING = r114;
                JavaType r115 = JavaType.MESSAGE;
                Type r106 = new Type("GROUP", 9, r115);
                GROUP = r106;
                Type r107 = new Type("MESSAGE", 10, r115);
                MESSAGE = r107;
                Type r108 = new Type("BYTES", 11, JavaType.BYTE_STRING);
                BYTES = r108;
                Type r109 = new Type("UINT32", 12, r110);
                UINT32 = r109;
                Type r116 = new Type("ENUM", 13, JavaType.ENUM);
                ENUM = r116;
                Type r117 = new Type("SFIXED32", 14, r110);
                SFIXED32 = r117;
                Type r118 = new Type("SFIXED64", 15, r102);
                SFIXED64 = r118;
                Type r119 = new Type("SINT32", 16, r110);
                SINT32 = r119;
                Type r120 = new Type("SINT64", 17, r102);
                SINT64 = r120;
                $VALUES = new Type[]{r100, r101, r103, r104, r105, r111, r112, r113, r114, r106, r107, r108, r109, r116, r117, r118, r119, r120};
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type r100) {
                return values()[r100.getNumber() - 1];
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, JavaType r102) {
                super(r100, r101);
                this.javaType = r102;
            }
        }

        private void crossLink() throws DescriptorValidationException {
            AnonymousClass1 r100 = null;
            if (this.proto.hasExtendee() == false) goto L14;
            GenericDescriptor r101 = FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getExtendee(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if ((r101 instanceof Descriptor) == false) goto L12;
            this.containingType = (Descriptor) r101;
            if (getContainingType().isExtensionNumber(getNumber()) == true) goto L14;
            throw new DescriptorValidationException(this, "\"" + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", r100);
        L12:
            throw new DescriptorValidationException(this, "\"" + this.proto.getExtendee() + "\" is not a message type.", r100);
        L14:
            if (this.proto.hasTypeName() == false) goto L46;
            GenericDescriptor r102 = FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getTypeName(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (this.proto.hasType() == true) goto L26;
            if ((r102 instanceof Descriptor) == false) goto L21;
            this.type = Type.MESSAGE;
            goto L26
        L21:
            if ((r102 instanceof EnumDescriptor) == false) goto L24;
            this.type = Type.ENUM;
            goto L26
        L24:
            throw new DescriptorValidationException(this, "\"" + this.proto.getTypeName() + "\" is not a type.", r100);
        L26:
            if (getJavaType() != JavaType.MESSAGE) goto L37;
            if ((r102 instanceof Descriptor) == false) goto L35;
            this.messageType = (Descriptor) r102;
            if (this.proto.hasDefaultValue() == false) goto L50;
            throw new DescriptorValidationException(this, "Messages can't have default values.", r100);
        L50:
            if (this.proto.getOptions().getPacked() == false) goto L57;
            if (isPackable() == true) goto L57;
            throw new DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", r100);
        L57:
            if (this.proto.hasDefaultValue() == false) goto L110;
            if (isRepeated() == true) goto L108;
        L104:
            e = move-exception;
            throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.proto.getDefaultValue() + Typography.quote, e, r100);
        L63:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[getType().ordinal()]) {
                case 1: goto L102;
                case 2: goto L102;
                case 3: goto L102;
                case 4: goto L101;
                case 5: goto L101;
                case 6: goto L100;
                case 7: goto L100;
                case 8: goto L100;
                case 9: goto L99;
                case 10: goto L99;
                case 11: goto L90;
                case 12: goto L80;
                case 13: goto L78;
                case 14: goto L77;
                case 15: goto L140;
                case 16: goto L67;
                case 17: goto L66;
                case 18: goto L66;
                default: goto L120;
            };
        L67:
            EnumValueDescriptor r103 = this.enumType.findValueByName(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L104
            this.defaultValue = r103;     // Catch: NumberFormatException -> L104
            if (r103 != null) goto L120;
            throw new DescriptorValidationException(this, "Unknown enum default value: \"" + this.proto.getDefaultValue() + Typography.quote, r100);     // Catch: NumberFormatException -> L104
        L77:
            this.defaultValue = this.proto.getDefaultValue();     // Catch: NumberFormatException -> L104
            goto L120
        L78:
            this.defaultValue = Boolean.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L104
            goto L120
        L99:
            this.defaultValue = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L104
            goto L120
        L100:
            this.defaultValue = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L104
            goto L120
        L101:
            this.defaultValue = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L104
            goto L120
        L102:
            this.defaultValue = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L104
            goto L120
        L140:
            this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());     // Catch: TextFormat.InvalidEscapeSequenceException -> L74 NumberFormatException -> L104
        L74:
            e = move-exception;
            throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, r100);     // Catch: NumberFormatException -> L104
        L66:
            throw new DescriptorValidationException(this, "Message type had default value.", r100);     // Catch: NumberFormatException -> L104
        L80:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L83;
            this.defaultValue = Double.valueOf(Double.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L104
            goto L120
        L83:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L86;
            this.defaultValue = Double.valueOf(Double.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L104
            goto L120
        L86:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L88;
            this.defaultValue = Double.valueOf(Double.NaN);     // Catch: NumberFormatException -> L104
            goto L120
        L88:
            this.defaultValue = CastDoubleProtector.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L104
            goto L120
        L90:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L93;
            this.defaultValue = Float.valueOf(Float.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L104
            goto L120
        L93:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L96;
            this.defaultValue = Float.valueOf(Float.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L104
            goto L120
        L96:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L98;
            this.defaultValue = Float.valueOf(Float.NaN);     // Catch: NumberFormatException -> L104
            goto L120
        L98:
            this.defaultValue = CastFloatProtector.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L104
        L120:
            if (isExtension() == true) goto L122;
            FileDescriptor.access$1400(this.file).addFieldByNumber(this);
        L122:
            Descriptor r104 = this.containingType;
            if (r104 != null) goto L125;
            return;
        L125:
            if (r104.getOptions().getMessageSetWireFormat() == true) goto L127;
            return;
        L127:
            if (isExtension() == false) goto L136;
            if (isOptional() == false) goto L134;
            if (getType() != Type.MESSAGE) goto L134;
            return;
        L134:
            throw new DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.", r100);
        L136:
            throw new DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.", r100);
        L108:
            throw new DescriptorValidationException(this, "Repeated fields cannot have default values.", r100);
        L110:
            if (isRepeated() == false) goto L112;
            this.defaultValue = Collections.emptyList();
            goto L120
        L112:
            int r105 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getJavaType().ordinal()];
            if (r105 != 1) goto L115;
            this.defaultValue = ListProtector.get(this.enumType.getValues(), 0);
            goto L120
        L115:
            if (r105 == 2) goto L117;
            this.defaultValue = JavaType.access$2300(getJavaType());
            goto L120
        L117:
            this.defaultValue = null;
            goto L120
        L35:
            throw new DescriptorValidationException(this, "\"" + this.proto.getTypeName() + "\" is not a message type.", r100);
        L37:
            if (getJavaType() != JavaType.ENUM) goto L44;
            if ((r102 instanceof EnumDescriptor) == false) goto L42;
            this.enumType = (EnumDescriptor) r102;
            goto L50
        L42:
            throw new DescriptorValidationException(this, "\"" + this.proto.getTypeName() + "\" is not an enum type.", r100);
        L44:
            throw new DescriptorValidationException(this, "Field with primitive type has type_name.", r100);
        L46:
            if (getJavaType() == JavaType.MESSAGE) goto L139;
            if (getJavaType() != JavaType.ENUM) goto L50;
        L139:
            throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.", r100);
        }

        public JavaType getJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return table[this.type.ordinal()];
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        public DescriptorProtos.FieldOptions getOptions() {
            return this.proto.getOptions();
        }

        public boolean hasDefaultValue() {
            return this.proto.hasDefaultValue();
        }

        public boolean isExtension() {
            return this.proto.hasExtendee();
        }

        public boolean isOptional() {
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isRequired() {
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean needsUtf8Check() {
            if (this.type == Type.STRING) goto L7;
            return false;
        L7:
            if (getContainingType().getOptions().getMapEntry() == false) goto L10;
            return true;
        L10:
            if (getFile().getSyntax() != FileDescriptor.Syntax.PROTO3) goto L13;
            return true;
        L13:
            return getFile().getOptions().getJavaStringCheckUtf8();
        }

        static {
            table = WireFormat.FieldType.values();
            if (Type.values().length != DescriptorProtos.FieldDescriptorProto.Type.values().length) goto L6;
            return;
        L6:
            throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
        }

        public Object getDefaultValue() {
            if (getJavaType() == JavaType.MESSAGE) goto L7;
            return this.defaultValue;
        L7:
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public EnumDescriptor getEnumType() {
            if (getJavaType() != JavaType.ENUM) goto L7;
            return this.enumType;
        L7:
            throw new UnsupportedOperationException("This field is not of enum type.");
        }

        public Descriptor getExtensionScope() {
            if (isExtension() == false) goto L7;
            return this.extensionScope;
        L7:
            throw new UnsupportedOperationException("This field is not an extension.");
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        public Descriptor getMessageType() {
            if (getJavaType() != JavaType.MESSAGE) goto L7;
            return this.messageType;
        L7:
            throw new UnsupportedOperationException("This field is not of message type.");
        }

        public boolean isMapField() {
            if (getType() == Type.MESSAGE) goto L5;
        L9:
            return false;
        L5:
            if (isRepeated() == false) goto L9;
            if (getMessageType().getOptions().getMapEntry() == false) goto L9;
            return true;
        }

        public boolean isPackable() {
            if (isRepeated() == true) goto L5;
        L7:
            return false;
        L5:
            if (getLiteType().isPackable() == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            if (isPackable() == true) goto L6;
            return false;
        L6:
            if (getFile().getSyntax() != FileDescriptor.Syntax.PROTO2) goto L10;
            return getOptions().getPacked();
        L10:
            if (getOptions().hasPacked() == true) goto L12;
        L13:
            return true;
        L12:
            if (getOptions().getPacked() == true) goto L13;
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public String toString() {
            return getFullName();
        }

        public OneofDescriptor getContainingOneof() {
            return this.containingOneof;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public String getJsonName() {
            return this.jsonName;
        }

        public Type getType() {
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public /* bridge */ /* synthetic */ Internal.EnumLiteMap getEnumType() {
            return getEnumType();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FieldDescriptorProto toProto() {
            return this.proto;
        }

        public static /* synthetic */ void access$900(FieldDescriptor r100) throws DescriptorValidationException {
            r100.crossLink();
        }

        private static String fieldNameToJsonName(String r100) {
            StringBuilder r101 = new StringBuilder(r100.length());
            int r102 = 0;
            boolean r103 = false;
        L4:
            if (r102 >= r100.length()) goto L13;
            Character r104 = Character.valueOf(r100.charAt(r102));
            if (r104.charValue() != '_') goto L8;
            r103 = true;
        L11:
            r102 = r102 + 1;
            goto L4
        L8:
            if (r103 == false) goto L10;
            r101.append(Character.toUpperCase(r104.charValue()));
            r103 = false;
            goto L11
        L10:
            r101.append(r104);
            goto L11
        L13:
            return r101.toString();
        }

        private void setProto(DescriptorProtos.FieldDescriptorProto r100) {
            this.proto = r100;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(FieldDescriptor r100) {
            if (r100.containingType != this.containingType) goto L7;
            return getNumber() - r100.getNumber();
        L7:
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(FieldDescriptor r100) {
            return compareTo2(r100);
        }

        public static /* synthetic */ void access$1300(FieldDescriptor r100, DescriptorProtos.FieldDescriptorProto r101) {
            r100.setProto(r101);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r100, MessageLite r101) {
            return ((Message.Builder) r100).mergeFrom((Message) r101);
        }

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto r100, FileDescriptor r101, Descriptor r102, int r103, boolean r104) throws DescriptorValidationException {
            this.index = r103;
            this.proto = r100;
            this.fullName = Descriptors.access$1600(r101, r102, r100.getName());
            this.file = r101;
            if (r100.hasJsonName() == false) goto L5;
            this.jsonName = r100.getJsonName();
        L7:
            if (r100.hasType() == false) goto L9;
            this.type = Type.valueOf(r100.getType());
        L9:
            AnonymousClass1 r105 = null;
            if (getNumber() <= 0) goto L43;
            if (r104 == false) goto L26;
            if (r100.hasExtendee() == false) goto L24;
            this.containingType = null;
            if (r102 == null) goto L17;
            this.extensionScope = r102;
        L19:
            if (r100.hasOneofIndex() == true) goto L22;
            this.containingOneof = null;
        L38:
            FileDescriptor.access$1400(r101).addSymbol(this);
            return;
        L22:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", r105);
        L17:
            this.extensionScope = null;
            goto L19
        L24:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", r105);
        L26:
            if (r100.hasExtendee() == true) goto L41;
            this.containingType = r102;
            if (r100.hasOneofIndex() == true) goto L30;
            this.containingOneof = null;
        L37:
            this.extensionScope = null;
            goto L38
        L30:
            if (r100.getOneofIndex() < 0) goto L35;
            if (r100.getOneofIndex() >= r102.toProto().getOneofDeclCount()) goto L35;
            OneofDescriptor r106 = (OneofDescriptor) ListProtector.get(r102.getOneofs(), r100.getOneofIndex());
            this.containingOneof = r106;
            OneofDescriptor.access$1908(r106);
        L35:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + r102.getName(), r105);
        L41:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", r105);
        L43:
            throw new DescriptorValidationException(this, "Field numbers must be positive integers.", r105);
        L5:
            this.jsonName = fieldNameToJsonName(r100.getName());
            goto L7
        }

        public /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto r100, FileDescriptor r101, Descriptor r102, int r103, boolean r104, AnonymousClass1 r105) throws DescriptorValidationException {
            this(r100, r101, r102, r103, r104);
        }
    }

    public static final class FileDescriptor extends GenericDescriptor {
        private final FileDescriptor[] dependencies;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final Descriptor[] messageTypes;
        private final DescriptorPool pool;
        private DescriptorProtos.FileDescriptorProto proto;
        private final FileDescriptor[] publicDependencies;
        private final ServiceDescriptor[] services;

        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor r100);
        }

        public static final enum Syntax extends java.lang.Enum<Syntax> {
            private static final /* synthetic */ Syntax[] $VALUES = null;
            public static final Syntax PROTO2 = null;
            public static final Syntax PROTO3 = null;
            public static final Syntax UNKNOWN = null;
            private final String name;

            static {
                Syntax r100 = new Syntax("UNKNOWN", 0, "unknown");
                UNKNOWN = r100;
                Syntax r101 = new Syntax("PROTO2", 1, "proto2");
                PROTO2 = r101;
                Syntax r102 = new Syntax("PROTO3", 2, "proto3");
                PROTO3 = r102;
                $VALUES = new Syntax[]{r100, r101, r102};
            }

            public static Syntax[] values() {
                return (Syntax[]) $VALUES.clone();
            }

            public static /* synthetic */ String access$000(Syntax r100) {
                return r100.name;
            }

            public static Syntax valueOf(String r100) {
                return (Syntax) a.a(Syntax.class, r100);
            }

            private Syntax(String r100, int r101, String r102) {
                super(r100, r101);
                this.name = r102;
            }
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this;
        }

        private void crossLink() throws DescriptorValidationException {
            Descriptor[] r100 = this.messageTypes;
            int r101 = r100.length;
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L5;
            Descriptor.access$700(r100[r103]);
            r103 = r103 + 1;
            goto L3
        L5:
            ServiceDescriptor[] r104 = this.services;
            int r105 = r104.length;
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L8;
            ServiceDescriptor.access$800(r104[r106]);
            r106 = r106 + 1;
            goto L6
        L8:
            FieldDescriptor[] r107 = this.extensions;
            int r108 = r107.length;
        L9:
            if (r102 >= r108) goto L11;
            FieldDescriptor.access$900(r107[r102]);
            r102 = r102 + 1;
            goto L9
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.proto.getName();
        }

        public List<Descriptor> getMessageTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.FileOptions getOptions() {
            return this.proto.getOptions();
        }

        public String getPackage() {
            return this.proto.getPackage();
        }

        public List<FileDescriptor> getPublicDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
        }

        public List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        public Syntax getSyntax() {
            Syntax r100 = Syntax.PROTO3;
            if (Syntax.access$000(r100).equals(this.proto.getSyntax()) == false) goto L6;
            return r100;
        L6:
            return Syntax.PROTO2;
        }

        public boolean supportsUnknownEnumValue() {
            if (getSyntax() != Syntax.PROTO3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FileDescriptorProto toProto() {
            return this.proto;
        }

        public static /* synthetic */ DescriptorPool access$1400(FileDescriptor r100) {
            return r100.pool;
        }

        private void setProto(DescriptorProtos.FileDescriptorProto r100) {
            this.proto = r100;
            int r101 = 0;
            int r102 = 0;
        L3:
            Descriptor[] r103 = this.messageTypes;
            if (r102 >= r103.length) goto L6;
            Descriptor.access$1000(r103[r102], r100.getMessageType(r102));
            r102 = r102 + 1;
            goto L3
        L6:
            int r104 = 0;
        L7:
            EnumDescriptor[] r105 = this.enumTypes;
            if (r104 >= r105.length) goto L10;
            EnumDescriptor.access$1100(r105[r104], r100.getEnumType(r104));
            r104 = r104 + 1;
            goto L7
        L10:
            int r106 = 0;
        L11:
            ServiceDescriptor[] r107 = this.services;
            if (r106 >= r107.length) goto L14;
            ServiceDescriptor.access$1200(r107[r106], r100.getService(r106));
            r106 = r106 + 1;
        L14:
            FieldDescriptor[] r108 = this.extensions;
            if (r101 >= r108.length) goto L17;
            FieldDescriptor.access$1300(r108[r101], r100.getExtension(r101));
            r101 = r101 + 1;
            goto L14
        }

        public EnumDescriptor findEnumTypeByName(String r100) {
            if (r100.indexOf(46) == (-1)) goto L6;
            return null;
        L6:
            if (getPackage().length() <= 0) goto L8;
            r100 = getPackage() + '.' + r100;
        L8:
            GenericDescriptor r101 = this.pool.findSymbol(r100);
            if (r101 != null) goto L11;
        L16:
            return null;
        L11:
            if ((r101 instanceof EnumDescriptor) == false) goto L16;
            if (r101.getFile() != this) goto L16;
            return (EnumDescriptor) r101;
        }

        public FieldDescriptor findExtensionByName(String r100) {
            if (r100.indexOf(46) == (-1)) goto L6;
            return null;
        L6:
            if (getPackage().length() <= 0) goto L8;
            r100 = getPackage() + '.' + r100;
        L8:
            GenericDescriptor r101 = this.pool.findSymbol(r100);
            if (r101 != null) goto L11;
        L16:
            return null;
        L11:
            if ((r101 instanceof FieldDescriptor) == false) goto L16;
            if (r101.getFile() != this) goto L16;
            return (FieldDescriptor) r101;
        }

        public Descriptor findMessageTypeByName(String r100) {
            if (r100.indexOf(46) == (-1)) goto L6;
            return null;
        L6:
            if (getPackage().length() <= 0) goto L8;
            r100 = getPackage() + '.' + r100;
        L8:
            GenericDescriptor r101 = this.pool.findSymbol(r100);
            if (r101 != null) goto L11;
        L16:
            return null;
        L11:
            if ((r101 instanceof Descriptor) == false) goto L16;
            if (r101.getFile() != this) goto L16;
            return (Descriptor) r101;
        }

        public ServiceDescriptor findServiceByName(String r100) {
            if (r100.indexOf(46) == (-1)) goto L6;
            return null;
        L6:
            if (getPackage().length() <= 0) goto L8;
            r100 = getPackage() + '.' + r100;
        L8:
            GenericDescriptor r101 = this.pool.findSymbol(r100);
            if (r101 != null) goto L11;
        L16:
            return null;
        L11:
            if ((r101 instanceof ServiceDescriptor) == false) goto L16;
            if (r101.getFile() != this) goto L16;
            return (ServiceDescriptor) r101;
        }

        public FileDescriptor(String r100, Descriptor r101) throws DescriptorValidationException {
            DescriptorPool r102 = new DescriptorPool(new FileDescriptor[0], true);
            this.pool = r102;
            this.proto = DescriptorProtos.FileDescriptorProto.newBuilder().setName(r101.getFullName() + ".placeholder.proto").setPackage(r100).addMessageType(r101.toProto()).build();
            this.dependencies = new FileDescriptor[0];
            this.publicDependencies = new FileDescriptor[0];
            this.messageTypes = new Descriptor[]{r101};
            this.enumTypes = new EnumDescriptor[0];
            this.services = new ServiceDescriptor[0];
            this.extensions = new FieldDescriptor[0];
            r102.addPackage(r100, this);
            r102.addSymbol(r101);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_com_google_protobuf_Descriptors$FileDescriptor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r100, FileDescriptor[] r101) throws DescriptorValidationException {
            return buildFrom(r100, r101, false);
        }

        public static void internalUpdateFileDescriptor(FileDescriptor r100, ExtensionRegistry r101) {
            r100.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(r100.proto.toByteString(), r101));
            return;
        L6:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r100, FileDescriptor[] r101, boolean r102) throws DescriptorValidationException {
            FileDescriptor r103 = new FileDescriptor(r100, r101, new DescriptorPool(r101, r102), r102);
            r103.crossLink();
            return r103;
        }

        public static void internalBuildGeneratedFileFrom(String[] r100, FileDescriptor[] r101, InternalDescriptorAssigner r102) {
            StringBuilder r103 = new StringBuilder();
            int r104 = r100.length;
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L5;
            r103.append(r100[r105]);
            r105 = r105 + 1;
            goto L3
        L5:
            byte[] r106 = r103.toString().getBytes(Internal.ISO_8859_1);
            DescriptorProtos.FileDescriptorProto r107 = DescriptorProtos.FileDescriptorProto.parseFrom(r106);     // Catch: InvalidProtocolBufferException -> L20
            FileDescriptor r108 = buildFrom(r107, r101, true);     // Catch: DescriptorValidationException -> L17
            ExtensionRegistry r109 = r102.assignDescriptors(r108);
            if (r109 != null) goto L23;
            return;
        L23:
            r108.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(r106, r109));
            return;
        L13:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        L17:
            e = move-exception;
            throw new IllegalArgumentException("Invalid embedded descriptor for \"" + r107.getName() + "\".", e);
        L20:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto r110, FileDescriptor[] r111, DescriptorPool r112, boolean r113) throws DescriptorValidationException {
            this.pool = r112;
            this.proto = r110;
            this.dependencies = (FileDescriptor[]) r111.clone();
            HashMap r100 = new HashMap();
            int r101 = r111.length;
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L5;
            FileDescriptor r104 = r111[r103];
            r100.put(r104.getName(), r104);
            r103 = r103 + 1;
            goto L3
        L5:
            ArrayList r114 = new ArrayList();
            int r105 = 0;
        L6:
            AnonymousClass1 r106 = null;
            if (r105 >= r110.getPublicDependencyCount()) goto L22;
            int r107 = r110.getPublicDependency(r105);
            if (r107 < 0) goto L21;
            if (r107 >= r110.getDependencyCount()) goto L21;
            String r108 = r110.getDependency(r107);
            FileDescriptor r109 = (FileDescriptor) r100.get(r108);
            if (r109 != null) goto L18;
            if (r113 == true) goto L19;
            throw new DescriptorValidationException(this, "Invalid public dependency: " + r108, r106);
        L19:
            r105 = r105 + 1;
            goto L6
        L18:
            r114.add(r109);
        L21:
            throw new DescriptorValidationException(this, "Invalid public dependency index.", r106);
        L22:
            FileDescriptor[] r115 = new FileDescriptor[r114.size()];
            this.publicDependencies = r115;
            r114.toArray(r115);
            r112.addPackage(getPackage(), this);
            this.messageTypes = new Descriptor[r110.getMessageTypeCount()];
            int r116 = 0;
        L24:
            if (r116 >= r110.getMessageTypeCount()) goto L26;
            this.messageTypes[r116] = new Descriptor(r110.getMessageType(r116), this, null, r116, null);
            r116 = r116 + 1;
            goto L24
        L26:
            this.enumTypes = new EnumDescriptor[r110.getEnumTypeCount()];
            int r117 = 0;
        L28:
            if (r117 >= r110.getEnumTypeCount()) goto L30;
            this.enumTypes[r117] = new EnumDescriptor(r110.getEnumType(r117), this, null, r117, null);
            r117 = r117 + 1;
            goto L28
        L30:
            this.services = new ServiceDescriptor[r110.getServiceCount()];
            int r118 = 0;
        L32:
            if (r118 >= r110.getServiceCount()) goto L34;
            this.services[r118] = new ServiceDescriptor(r110.getService(r118), this, r118, r106);
            r118 = r118 + 1;
            goto L32
        L34:
            this.extensions = new FieldDescriptor[r110.getExtensionCount()];
        L36:
            if (r102 >= r110.getExtensionCount()) goto L38;
            this.extensions[r102] = new FieldDescriptor(r110.getExtension(r102), this, null, r102, true, null);
            r102 = r102 + 1;
            goto L36
        }

        public static void internalBuildGeneratedFileFrom(String[] r100, Class<?> r101, String[] r102, String[] r103, InternalDescriptorAssigner r104) {
            ArrayList r105 = new ArrayList();
            int r106 = 0;
        L4:
            if (r106 >= r102.length) goto L9;
            r105.add((FileDescriptor) INVOKEVIRTUAL_com_google_protobuf_Descriptors$FileDescriptor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101.getClassLoader(), r102[r106]).getField("descriptor").get(null));     // Catch: Exception -> L7
        L8:
            r106 = r106 + 1;
        L7:
            Descriptors.access$100().warning("Descriptors for \"" + r103[r106] + "\" can not be found.");
            goto L8
        L9:
            FileDescriptor[] r107 = new FileDescriptor[r105.size()];
            r105.toArray(r107);
            internalBuildGeneratedFileFrom(r100, r107, r104);
        }
    }

    public static abstract class GenericDescriptor {
        public GenericDescriptor() {
        }

        public abstract FileDescriptor getFile();

        public abstract String getFullName();

        public abstract String getName();

        public abstract Message toProto();
    }

    public static final class MethodDescriptor extends GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor inputType;
        private Descriptor outputType;
        private DescriptorProtos.MethodDescriptorProto proto;
        private final ServiceDescriptor service;

        private void crossLink() throws DescriptorValidationException {
            DescriptorPool r100 = FileDescriptor.access$1400(this.file);
            String r101 = this.proto.getInputType();
            DescriptorPool.SearchFilter r102 = DescriptorPool.SearchFilter.TYPES_ONLY;
            GenericDescriptor r103 = r100.lookupSymbol(r101, this, r102);
            AnonymousClass1 r104 = null;
            if ((r103 instanceof Descriptor) == false) goto L11;
            this.inputType = (Descriptor) r103;
            GenericDescriptor r105 = FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getOutputType(), this, r102);
            if ((r105 instanceof Descriptor) == false) goto L9;
            this.outputType = (Descriptor) r105;
            return;
        L9:
            throw new DescriptorValidationException(this, "\"" + this.proto.getOutputType() + "\" is not a message type.", r104);
        L11:
            throw new DescriptorValidationException(this, "\"" + this.proto.getInputType() + "\" is not a message type.", r104);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.MethodOptions getOptions() {
            return this.proto.getOptions();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public Descriptor getInputType() {
            return this.inputType;
        }

        public Descriptor getOutputType() {
            return this.outputType;
        }

        public ServiceDescriptor getService() {
            return this.service;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.MethodDescriptorProto toProto() {
            return this.proto;
        }

        public static /* synthetic */ void access$2900(MethodDescriptor r100) throws DescriptorValidationException {
            r100.crossLink();
        }

        private void setProto(DescriptorProtos.MethodDescriptorProto r100) {
            this.proto = r100;
        }

        public static /* synthetic */ void access$3000(MethodDescriptor r100, DescriptorProtos.MethodDescriptorProto r101) {
            r100.setProto(r101);
        }

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto r100, FileDescriptor r101, ServiceDescriptor r102, int r103) throws DescriptorValidationException {
            this.index = r103;
            this.proto = r100;
            this.file = r101;
            this.service = r102;
            this.fullName = r102.getFullName() + '.' + r100.getName();
            FileDescriptor.access$1400(r101).addSymbol(this);
        }

        public /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto r100, FileDescriptor r101, ServiceDescriptor r102, int r103, AnonymousClass1 r104) throws DescriptorValidationException {
            this(r100, r101, r102, r103);
        }
    }

    public static final class OneofDescriptor {
        private Descriptor containingType;
        private int fieldCount;
        private FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private DescriptorProtos.OneofDescriptorProto proto;

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.OneofOptions getOptions() {
            return this.proto.getOptions();
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public int getFieldCount() {
            return this.fieldCount;
        }

        public FileDescriptor getFile() {
            return this.file;
        }

        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public static /* synthetic */ FieldDescriptor[] access$1800(OneofDescriptor r100) {
            return r100.fields;
        }

        public static /* synthetic */ int access$1908(OneofDescriptor r100) {
            int r101 = r100.fieldCount;
            r100.fieldCount = r101 + 1;
            return r101;
        }

        private void setProto(DescriptorProtos.OneofDescriptorProto r100) {
            this.proto = r100;
        }

        public FieldDescriptor getField(int r100) {
            return this.fields[r100];
        }

        public static /* synthetic */ FieldDescriptor[] access$1802(OneofDescriptor r100, FieldDescriptor[] r101) {
            r100.fields = r101;
            return r101;
        }

        public static /* synthetic */ int access$1902(OneofDescriptor r100, int r101) {
            r100.fieldCount = r101;
            return r101;
        }

        public static /* synthetic */ void access$2000(OneofDescriptor r100, DescriptorProtos.OneofDescriptorProto r101) {
            r100.setProto(r101);
        }

        private OneofDescriptor(DescriptorProtos.OneofDescriptorProto r100, FileDescriptor r101, Descriptor r102, int r103) throws DescriptorValidationException {
            this.proto = r100;
            this.fullName = Descriptors.access$1600(r101, r102, r100.getName());
            this.file = r101;
            this.index = r103;
            this.containingType = r102;
            this.fieldCount = 0;
        }

        public /* synthetic */ OneofDescriptor(DescriptorProtos.OneofDescriptorProto r100, FileDescriptor r101, Descriptor r102, int r103, AnonymousClass1 r104) throws DescriptorValidationException {
            this(r100, r101, r102, r103);
        }
    }

    public static final class ServiceDescriptor extends GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private MethodDescriptor[] methods;
        private DescriptorProtos.ServiceDescriptorProto proto;

        private void crossLink() throws DescriptorValidationException {
            MethodDescriptor[] r100 = this.methods;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            MethodDescriptor.access$2900(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        public List<MethodDescriptor> getMethods() {
            return Collections.unmodifiableList(Arrays.asList(this.methods));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.ServiceOptions getOptions() {
            return this.proto.getOptions();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.ServiceDescriptorProto toProto() {
            return this.proto;
        }

        public static /* synthetic */ void access$800(ServiceDescriptor r100) throws DescriptorValidationException {
            r100.crossLink();
        }

        private void setProto(DescriptorProtos.ServiceDescriptorProto r100) {
            this.proto = r100;
            int r101 = 0;
        L3:
            MethodDescriptor[] r102 = this.methods;
            if (r101 >= r102.length) goto L6;
            MethodDescriptor.access$3000(r102[r101], r100.getMethod(r101));
            r101 = r101 + 1;
            goto L3
        }

        public MethodDescriptor findMethodByName(String r100) {
            GenericDescriptor r101 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            if ((r101 instanceof MethodDescriptor) == true) goto L7;
            return null;
        L7:
            return (MethodDescriptor) r101;
        }

        public static /* synthetic */ void access$1200(ServiceDescriptor r100, DescriptorProtos.ServiceDescriptorProto r101) {
            r100.setProto(r101);
        }

        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r100, FileDescriptor r110, int r111) throws DescriptorValidationException {
            this.index = r111;
            this.proto = r100;
            this.fullName = Descriptors.access$1600(r110, null, r100.getName());
            this.file = r110;
            this.methods = new MethodDescriptor[r100.getMethodCount()];
            int r112 = 0;
        L4:
            if (r112 >= r100.getMethodCount()) goto L6;
            int r101 = r112;
            this.methods[r112] = new MethodDescriptor(r100.getMethod(r112), r110, this, r101, null);
            r112 = r112 + 1;
            goto L4
        L6:
            FileDescriptor.access$1400(r110).addSymbol(this);
        }

        public /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r100, FileDescriptor r101, int r102, AnonymousClass1 r103) throws DescriptorValidationException {
            this(r100, r101, r102);
        }
    }

    public Descriptors() {
    }

    static {
        logger = Logger.getLogger(Descriptors.class.getName());
    }

    public static /* synthetic */ Logger access$100() {
        return logger;
    }

    public static /* synthetic */ String access$1600(FileDescriptor r100, Descriptor r101, String r102) {
        return computeFullName(r100, r101, r102);
    }

    private static String computeFullName(FileDescriptor r100, Descriptor r101, String r102) {
        if (r101 == null) goto L7;
        return r101.getFullName() + '.' + r102;
    L7:
        if (r100.getPackage().length() > 0) goto L9;
        return r102;
    L9:
        return r100.getPackage() + '.' + r102;
    }
}

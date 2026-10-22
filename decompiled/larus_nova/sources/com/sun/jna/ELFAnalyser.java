package com.sun.jna;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.ttm.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
class ELFAnalyser {
    private static final int EF_ARM_ABI_FLOAT_HARD = 1024;
    private static final int EF_ARM_ABI_FLOAT_SOFT = 512;
    private static final int EI_CLASS_64BIT = 2;
    private static final int EI_DATA_BIG_ENDIAN = 2;
    private static final byte[] ELF_MAGIC = null;
    private static final int E_MACHINE_ARM = 40;
    private boolean ELF;
    private boolean _64Bit;
    private boolean arm;
    private boolean armEabiAapcsVfp;
    private boolean armHardFloatFlag;
    private boolean armSoftFloatFlag;
    private boolean bigEndian;
    private final String filename;

    /* JADX INFO: renamed from: com.sun.jna.ELFAnalyser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType = null;

        static {
            int[] r100 = new int[ArmAeabiAttributesTag.ParameterType.values().length];
            $SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType = r100;
            r100[ArmAeabiAttributesTag.ParameterType.UINT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType[ArmAeabiAttributesTag.ParameterType.NTBS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType[ArmAeabiAttributesTag.ParameterType.ULEB128.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class ArmAeabiAttributesTag {
        public static final ArmAeabiAttributesTag ABI_FP_16bit_format = null;
        public static final ArmAeabiAttributesTag ABI_FP_denormal = null;
        public static final ArmAeabiAttributesTag ABI_FP_exceptions = null;
        public static final ArmAeabiAttributesTag ABI_FP_number_model = null;
        public static final ArmAeabiAttributesTag ABI_FP_optimization_goals = null;
        public static final ArmAeabiAttributesTag ABI_FP_rounding = null;
        public static final ArmAeabiAttributesTag ABI_FP_user_exceptions = null;
        public static final ArmAeabiAttributesTag ABI_HardFP_use = null;
        public static final ArmAeabiAttributesTag ABI_PCS_GOT_use = null;
        public static final ArmAeabiAttributesTag ABI_PCS_R9_use = null;
        public static final ArmAeabiAttributesTag ABI_PCS_RO_data = null;
        public static final ArmAeabiAttributesTag ABI_PCS_RW_data = null;
        public static final ArmAeabiAttributesTag ABI_PCS_wchar_t = null;
        public static final ArmAeabiAttributesTag ABI_VFP_args = null;
        public static final ArmAeabiAttributesTag ABI_WMMX_args = null;
        public static final ArmAeabiAttributesTag ABI_align8_preserved = null;
        public static final ArmAeabiAttributesTag ABI_align_needed = null;
        public static final ArmAeabiAttributesTag ABI_enum_size = null;
        public static final ArmAeabiAttributesTag ABI_optimization_goals = null;
        public static final ArmAeabiAttributesTag ARM_ISA_use = null;
        public static final ArmAeabiAttributesTag Advanced_SIMD_arch = null;
        public static final ArmAeabiAttributesTag CPU_arch = null;
        public static final ArmAeabiAttributesTag CPU_arch_profile = null;
        public static final ArmAeabiAttributesTag CPU_name = null;
        public static final ArmAeabiAttributesTag CPU_raw_name = null;
        public static final ArmAeabiAttributesTag CPU_unaligned_access = null;
        public static final ArmAeabiAttributesTag DIV_use = null;
        public static final ArmAeabiAttributesTag FP_HP_extension = null;
        public static final ArmAeabiAttributesTag FP_arch = null;
        public static final ArmAeabiAttributesTag File = null;
        public static final ArmAeabiAttributesTag MPextension_use = null;
        public static final ArmAeabiAttributesTag MPextension_use2 = null;
        public static final ArmAeabiAttributesTag PCS_config = null;
        public static final ArmAeabiAttributesTag Section = null;
        public static final ArmAeabiAttributesTag Symbol = null;
        public static final ArmAeabiAttributesTag T2EE_use = null;
        public static final ArmAeabiAttributesTag THUMB_ISA_use = null;
        public static final ArmAeabiAttributesTag Virtualization_use = null;
        public static final ArmAeabiAttributesTag WMMX_arch = null;
        public static final ArmAeabiAttributesTag also_compatible_with = null;
        public static final ArmAeabiAttributesTag compatibility = null;
        public static final ArmAeabiAttributesTag conformance = null;
        private static final Map<String, ArmAeabiAttributesTag> nameMap = null;
        public static final ArmAeabiAttributesTag nodefaults = null;
        private static final List<ArmAeabiAttributesTag> tags = null;
        private static final Map<Integer, ArmAeabiAttributesTag> valueMap = null;
        private final String name;
        private final ParameterType parameterType;
        private final int value;

        public static final enum ParameterType extends Enum<ParameterType> {
            private static final /* synthetic */ ParameterType[] $VALUES = null;
            public static final ParameterType NTBS = null;
            public static final ParameterType UINT32 = null;
            public static final ParameterType ULEB128 = null;

            static {
                ParameterType r100 = new ParameterType("UINT32", 0);
                UINT32 = r100;
                ParameterType r101 = new ParameterType("NTBS", 1);
                NTBS = r101;
                ParameterType r102 = new ParameterType("ULEB128", 2);
                ULEB128 = r102;
                $VALUES = new ParameterType[]{r100, r101, r102};
            }

            public static ParameterType[] values() {
                return (ParameterType[]) $VALUES.clone();
            }

            public static ParameterType valueOf(String r100) {
                return (ParameterType) a.a(ParameterType.class, r100);
            }

            private ParameterType(String r100, int r101) {
                super(r100, r101);
            }
        }

        static {
            tags = new LinkedList();
            valueMap = new HashMap();
            nameMap = new HashMap();
            ParameterType r100 = ParameterType.UINT32;
            File = addTag(1, SpeechEngineDefines.RECORDER_TYPE_FILE, r100);
            Section = addTag(2, "Section", r100);
            Symbol = addTag(3, "Symbol", r100);
            ParameterType r101 = ParameterType.NTBS;
            CPU_raw_name = addTag(4, "CPU_raw_name", r101);
            CPU_name = addTag(5, "CPU_name", r101);
            ParameterType r102 = ParameterType.ULEB128;
            CPU_arch = addTag(6, "CPU_arch", r102);
            CPU_arch_profile = addTag(7, "CPU_arch_profile", r102);
            ARM_ISA_use = addTag(8, "ARM_ISA_use", r102);
            THUMB_ISA_use = addTag(9, "THUMB_ISA_use", r102);
            FP_arch = addTag(10, "FP_arch", r102);
            WMMX_arch = addTag(11, "WMMX_arch", r102);
            Advanced_SIMD_arch = addTag(12, "Advanced_SIMD_arch", r102);
            PCS_config = addTag(13, "PCS_config", r102);
            ABI_PCS_R9_use = addTag(14, "ABI_PCS_R9_use", r102);
            ABI_PCS_RW_data = addTag(15, "ABI_PCS_RW_data", r102);
            ABI_PCS_RO_data = addTag(16, "ABI_PCS_RO_data", r102);
            ABI_PCS_GOT_use = addTag(17, "ABI_PCS_GOT_use", r102);
            ABI_PCS_wchar_t = addTag(18, "ABI_PCS_wchar_t", r102);
            ABI_FP_rounding = addTag(19, "ABI_FP_rounding", r102);
            ABI_FP_denormal = addTag(20, "ABI_FP_denormal", r102);
            ABI_FP_exceptions = addTag(21, "ABI_FP_exceptions", r102);
            ABI_FP_user_exceptions = addTag(22, "ABI_FP_user_exceptions", r102);
            ABI_FP_number_model = addTag(23, "ABI_FP_number_model", r102);
            ABI_align_needed = addTag(24, "ABI_align_needed", r102);
            ABI_align8_preserved = addTag(25, "ABI_align8_preserved", r102);
            ABI_enum_size = addTag(26, "ABI_enum_size", r102);
            ABI_HardFP_use = addTag(27, "ABI_HardFP_use", r102);
            ABI_VFP_args = addTag(28, "ABI_VFP_args", r102);
            ABI_WMMX_args = addTag(29, "ABI_WMMX_args", r102);
            ABI_optimization_goals = addTag(30, "ABI_optimization_goals", r102);
            ABI_FP_optimization_goals = addTag(31, "ABI_FP_optimization_goals", r102);
            compatibility = addTag(32, "compatibility", r101);
            CPU_unaligned_access = addTag(34, "CPU_unaligned_access", r102);
            FP_HP_extension = addTag(36, "FP_HP_extension", r102);
            ABI_FP_16bit_format = addTag(38, "ABI_FP_16bit_format", r102);
            MPextension_use = addTag(42, "MPextension_use", r102);
            DIV_use = addTag(44, "DIV_use", r102);
            nodefaults = addTag(64, "nodefaults", r102);
            also_compatible_with = addTag(65, "also_compatible_with", r101);
            conformance = addTag(67, "conformance", r101);
            T2EE_use = addTag(66, "T2EE_use", r102);
            Virtualization_use = addTag(68, "Virtualization_use", r102);
            MPextension_use2 = addTag(70, "MPextension_use", r102);
        }

        public static List<ArmAeabiAttributesTag> getTags() {
            return Collections.unmodifiableList(tags);
        }

        public int hashCode() {
            return MediaPlayer.MEDIA_PLAYER_OPTION_GET_NETWORK_CONNECT_COUNT + this.value;
        }

        public String toString() {
            return this.name + " (" + this.value + ")";
        }

        public String getName() {
            return this.name;
        }

        public ParameterType getParameterType() {
            return this.parameterType;
        }

        public int getValue() {
            return this.value;
        }

        public static ArmAeabiAttributesTag getByName(String r100) {
            return nameMap.get(r100);
        }

        public static ArmAeabiAttributesTag getByValue(int r100) {
            Map<Integer, ArmAeabiAttributesTag> r101 = valueMap;
            if (r101.containsKey(Integer.valueOf(r100)) == false) goto L7;
            return r101.get(Integer.valueOf(r100));
        L7:
            return new ArmAeabiAttributesTag(r100, "Unknown " + r100, getParameterType(r100));
        }

        private static ParameterType getParameterType(int r100) {
            ArmAeabiAttributesTag r101 = getByValue(r100);
            if (r101 != null) goto L11;
            if ((r100 % 2) != 0) goto L9;
            return ParameterType.ULEB128;
        L9:
            return ParameterType.NTBS;
        L11:
            return r101.getParameterType();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L12;
            return false;
        L12:
            if (this.value == ((ArmAeabiAttributesTag) r100).value) goto L14;
            return false;
        L14:
            return true;
        }

        public ArmAeabiAttributesTag(int r100, String r101, ParameterType r102) {
            this.value = r100;
            this.name = r101;
            this.parameterType = r102;
        }

        private static ArmAeabiAttributesTag addTag(int r100, String r101, ParameterType r102) {
            ArmAeabiAttributesTag r103 = new ArmAeabiAttributesTag(r100, r101, r102);
            Map<Integer, ArmAeabiAttributesTag> r104 = valueMap;
            if (r104.containsKey(Integer.valueOf(r103.getValue())) == true) goto L5;
            r104.put(Integer.valueOf(r103.getValue()), r103);
        L5:
            Map<String, ArmAeabiAttributesTag> r105 = nameMap;
            if (r105.containsKey(r103.getName()) == true) goto L8;
            r105.put(r103.getName(), r103);
        L8:
            tags.add(r103);
            return r103;
        }
    }

    public static class ELFSectionHeaderEntry {
        private final int flags;
        private String name;
        private final int nameOffset;
        private final int offset;
        private final int size;
        private final int type;

        public String toString() {
            return "ELFSectionHeaderEntry{nameIdx=" + this.nameOffset + ", name=" + this.name + ", type=" + this.type + ", flags=" + this.flags + ", offset=" + this.offset + ", size=" + this.size + '}';
        }

        public int getFlags() {
            return this.flags;
        }

        public String getName() {
            return this.name;
        }

        public int getNameOffset() {
            return this.nameOffset;
        }

        public int getOffset() {
            return this.offset;
        }

        public int getSize() {
            return this.size;
        }

        public int getType() {
            return this.type;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public ELFSectionHeaderEntry(boolean r100, ByteBuffer r101) {
            this.nameOffset = r101.getInt(0);
            this.type = r101.getInt(4);
            if (r100 == false) goto L5;
            long r102 = r101.getLong(8);
        L6:
            this.flags = (int) r102;
            if (r100 == false) goto L9;
            long r103 = r101.getLong(24);
        L10:
            this.offset = (int) r103;
            if (r100 == false) goto L13;
            long r104 = r101.getLong(32);
        L14:
            this.size = (int) r104;
            return;
        L13:
            r104 = r101.getInt(20);
            goto L14
        L9:
            r103 = r101.getInt(16);
            goto L10
        L5:
            r102 = r101.getInt(8);
            goto L6
        }
    }

    public static class ELFSectionHeaders {
        private final List<ELFSectionHeaderEntry> entries;

        public List<ELFSectionHeaderEntry> getEntries() {
            return this.entries;
        }

        public ELFSectionHeaders(boolean r100, boolean r101, ByteBuffer r110, RandomAccessFile r111) throws IOException {
            this.entries = new ArrayList();
            if (r100 == false) goto L5;
            long r102 = r110.getLong(40);
            short r103 = r110.getShort(58);
            short r104 = r110.getShort(60);
            short r112 = r110.getShort(62);
        L6:
            ByteBuffer r105 = ByteBuffer.allocate(r104 * r103);
            if (r101 == false) goto L9;
            ByteOrder r106 = ByteOrder.BIG_ENDIAN;
        L10:
            r105.order(r106);
            r111.getChannel().read(r105, r102);
            int r107 = 0;
        L11:
            if (r107 >= r104) goto L13;
            r105.position(r107 * r103);
            ByteBuffer r108 = r105.slice();
            r108.order(r105.order());
            r108.limit(r103);
            this.entries.add(new ELFSectionHeaderEntry(r100, r108));
            r107 = r107 + 1;
            goto L11
        L13:
            ELFSectionHeaderEntry r109 = (ELFSectionHeaderEntry) ListProtector.get(this.entries, r112);
            ByteBuffer r113 = ByteBuffer.allocate(r109.getSize());
            if (r101 == false) goto L16;
            ByteOrder r114 = ByteOrder.BIG_ENDIAN;
        L17:
            r113.order(r114);
            r111.getChannel().read(r113, r109.getOffset());
            r113.rewind();
            ByteArrayOutputStream r115 = new ByteArrayOutputStream(20);
            Iterator<ELFSectionHeaderEntry> r116 = this.entries.iterator();
        L19:
            if (r116.hasNext() == false) goto L28;
            ELFSectionHeaderEntry r117 = r116.next();
            r115.reset();
            r113.position(r117.getNameOffset());
        L22:
            if (r113.position() >= r113.limit()) goto L27;
            byte r118 = r113.get();
            if (r118 == 0) goto L27;
            r115.write(r118);
        L27:
            r117.setName(r115.toString("ASCII"));
            goto L19
        L28:
            return;
        L16:
            r114 = ByteOrder.LITTLE_ENDIAN;
            goto L17
        L9:
            r106 = ByteOrder.LITTLE_ENDIAN;
            goto L10
        L5:
            r102 = r110.getInt(32);
            r103 = r110.getShort(46);
            r104 = r110.getShort(48);
            r112 = r110.getShort(50);
            goto L6
        }
    }

    static {
        ELF_MAGIC = new byte[]{ByteCompanionObject.MAX_VALUE, 69, 76, 70};
    }

    private void runDetection() throws IOException {
        RandomAccessFile r100 = new RandomAccessFile(this.filename, "r");
        boolean r101 = true;
        if (r100.length() <= 4) goto L9;
        byte[] r102 = new byte[4];     // Catch: Throwable -> L49
        r100.seek(0);     // Catch: Throwable -> L49
        r100.read(r102);     // Catch: Throwable -> L49
        if (Arrays.equals(r102, ELF_MAGIC) == false) goto L9;
        this.ELF = true;     // Catch: Throwable -> L49
    L9:
        if (this.ELF == false) goto L57;
        r100.seek(4);     // Catch: Throwable -> L49
        byte r103 = r100.readByte();     // Catch: Throwable -> L49
        byte r104 = r100.readByte();     // Catch: Throwable -> L49
        if (r103 != 2) goto L15;
        boolean r105 = true;
    L16:
        this._64Bit = r105;     // Catch: Throwable -> L49
        if (r104 != 2) goto L19;
        boolean r106 = true;
    L20:
        this.bigEndian = r106;     // Catch: Throwable -> L49
        r100.seek(0);     // Catch: Throwable -> L49
        if (this._64Bit == false) goto L23;
        int r107 = 64;
    L24:
        ByteBuffer r108 = ByteBuffer.allocate(r107);     // Catch: Throwable -> L49
        r100.getChannel().read(r108, 0);     // Catch: Throwable -> L49
        if (this.bigEndian == false) goto L27;
        ByteOrder r109 = ByteOrder.BIG_ENDIAN;     // Catch: Throwable -> L49
    L28:
        r108.order(r109);     // Catch: Throwable -> L49
        if (r108.get(18) != 40) goto L31;
        boolean r110 = true;
    L32:
        this.arm = r110;     // Catch: Throwable -> L49
        if (r110 == true) goto L35;
    L55:
        r100.close();     // Catch: IOException -> L52
        return;
    L64:
        return;
    L35:
        if (this._64Bit == false) goto L37;
        int r111 = 48;
    L38:
        int r112 = r108.getInt(r111);     // Catch: Throwable -> L49
        if ((r112 & 1024) != 1024) goto L41;
        boolean r113 = true;
    L42:
        this.armHardFloatFlag = r113;     // Catch: Throwable -> L49
        if ((r112 & 512) == 512) goto L46;
        r101 = false;
    L46:
        this.armSoftFloatFlag = r101;     // Catch: Throwable -> L49
        parseEabiAapcsVfp(r108, r100);     // Catch: Throwable -> L49
        goto L55
    L41:
        r113 = false;
        goto L42
    L37:
        r111 = 36;
        goto L38
    L31:
        r110 = false;
        goto L32
    L27:
        r109 = ByteOrder.LITTLE_ENDIAN;     // Catch: Throwable -> L49
        goto L28
    L23:
        r107 = 52;
        goto L24
    L19:
        r106 = false;
        goto L20
    L15:
        r105 = false;
        goto L16
    L57:
        r100.close();     // Catch: IOException -> L53
        return;
    L63:
        return;
    L49:
        th = move-exception;
        r100.close();     // Catch: IOException -> L54
    L51:
        throw th;
    }

    public boolean isArmHardFloat() {
        if (isArmEabiAapcsVfp() == false) goto L5;
    L8:
        return true;
    L5:
        if (isArmHardFloatFlag() == true) goto L8;
        return false;
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean is64Bit() {
        return this._64Bit;
    }

    public boolean isArm() {
        return this.arm;
    }

    public boolean isArmEabiAapcsVfp() {
        return this.armEabiAapcsVfp;
    }

    public boolean isArmHardFloatFlag() {
        return this.armHardFloatFlag;
    }

    public boolean isArmSoftFloatFlag() {
        return this.armSoftFloatFlag;
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }

    public boolean isELF() {
        return this.ELF;
    }

    private ELFAnalyser(String r100) {
        this.ELF = false;
        this._64Bit = false;
        this.bigEndian = false;
        this.armHardFloatFlag = false;
        this.armSoftFloatFlag = false;
        this.armEabiAapcsVfp = false;
        this.arm = false;
        this.filename = r100;
    }

    public static ELFAnalyser analyse(String r100) throws IOException {
        ELFAnalyser r101 = new ELFAnalyser(r100);
        r101.runDetection();
        return r101;
    }

    private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseAEABI(ByteBuffer r100) {
        HashMap r101 = new HashMap();
    L4:
        if (r100.position() >= r100.limit()) goto L9;
        int r102 = r100.position();
        int r103 = readULEB128(r100).intValue();
        int r104 = r100.getInt();
        if (r103 != 1) goto L8;
        r101.put(Integer.valueOf(r103), parseFileAttribute(r100));
    L8:
        r100.position(r102 + r104);
        goto L4
    L9:
        return r101;
    }

    private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseArmAttributes(ByteBuffer r100) {
        if (r100.get() == 65) goto L7;
        return Collections.EMPTY_MAP;
    L7:
        if (r100.position() >= r100.limit()) goto L17;
        int r101 = r100.position();
        int r102 = r100.getInt();
        if (r102 <= 0) goto L17;
        if ("aeabi".equals(readNTBS(r100, null)) == true) goto L14;
        r100.position(r101 + r102);
        goto L7
    L14:
        return parseAEABI(r100);
    L17:
        return Collections.EMPTY_MAP;
    }

    private static Map<ArmAeabiAttributesTag, Object> parseFileAttribute(ByteBuffer r100) {
        HashMap r101 = new HashMap();
    L4:
        if (r100.position() >= r100.limit()) goto L15;
        ArmAeabiAttributesTag r102 = ArmAeabiAttributesTag.getByValue(readULEB128(r100).intValue());
        int r103 = AnonymousClass1.$SwitchMap$com$sun$jna$ELFAnalyser$ArmAeabiAttributesTag$ParameterType[r102.getParameterType().ordinal()];
        if (r103 != 1) goto L8;
        r101.put(r102, Integer.valueOf(r100.getInt()));
        goto L4
    L8:
        if (r103 != 2) goto L10;
        r101.put(r102, readNTBS(r100, null));
        goto L4
    L10:
        if (r103 != 3) goto L4;
        r101.put(r102, readULEB128(r100));
        goto L4
    L15:
        return r101;
    }

    private static BigInteger readULEB128(ByteBuffer r100) {
        BigInteger r101 = BigInteger.ZERO;
        int r102 = 0;
    L3:
        byte r103 = r100.get();
        r101 = r101.or(BigInteger.valueOf(r103 & ByteCompanionObject.MAX_VALUE).shiftLeft(r102));
        if ((r103 & ByteCompanionObject.MIN_VALUE) == 0) goto L5;
        r102 = r102 + 7;
        goto L3
    L5:
        return r101;
    }

    private void parseEabiAapcsVfp(ByteBuffer r100, RandomAccessFile r101) throws IOException {
        Iterator<ELFSectionHeaderEntry> r102 = new ELFSectionHeaders(this._64Bit, this.bigEndian, r100, r101).getEntries().iterator();
    L4:
        if (r102.hasNext() == false) goto L24;
        ELFSectionHeaderEntry r103 = r102.next();
        if (".ARM.attributes".equals(r103.getName()) == false) goto L4;
        ByteBuffer r104 = ByteBuffer.allocate(r103.getSize());
        if (this.bigEndian == false) goto L10;
        ByteOrder r105 = ByteOrder.BIG_ENDIAN;
    L11:
        r104.order(r105);
        r101.getChannel().read(r104, r103.getOffset());
        r104.rewind();
        Map<ArmAeabiAttributesTag, Object> r106 = parseArmAttributes(r104).get(1);
        if (r106 == null) goto L4;
        Object r107 = r106.get(ArmAeabiAttributesTag.ABI_VFP_args);
        if ((r107 instanceof Integer) == false) goto L20;
        if (((Integer) r107).equals(1) == false) goto L20;
        this.armEabiAapcsVfp = true;
    L20:
        if ((r107 instanceof BigInteger) == false) goto L4;
        if (((BigInteger) r107).intValue() != 1) goto L4;
        this.armEabiAapcsVfp = true;
        goto L4
    L10:
        r105 = ByteOrder.LITTLE_ENDIAN;
        goto L11
    }

    private static String readNTBS(ByteBuffer r100, Integer r101) {
        if (r101 == null) goto L4;
        r100.position(r101.intValue());
    L4:
        int r102 = r100.position();
    L6:
        if (r100.get() == 0) goto L9;
        if (r100.position() <= r100.limit()) goto L6;
    L9:
        byte[] r103 = new byte[(r100.position() - r102) - 1];
        r100.position(r102);
        r100.get(r103);
        r100.position(r100.position() + 1);
        return new String(r103, "ASCII");
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }
}

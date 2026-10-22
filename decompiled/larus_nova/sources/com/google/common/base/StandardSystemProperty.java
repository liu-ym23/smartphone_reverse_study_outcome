package com.google.common.base;

import com.huawei.hms.framework.common.ContainerUtils;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final enum StandardSystemProperty extends Enum<StandardSystemProperty> {
    public static final StandardSystemProperty FILE_SEPARATOR = null;
    public static final StandardSystemProperty JAVA_CLASS_PATH = null;
    public static final StandardSystemProperty JAVA_CLASS_VERSION = null;
    public static final StandardSystemProperty JAVA_COMPILER = null;
    public static final StandardSystemProperty JAVA_EXT_DIRS = null;
    public static final StandardSystemProperty JAVA_HOME = null;
    public static final StandardSystemProperty JAVA_IO_TMPDIR = null;
    public static final StandardSystemProperty JAVA_LIBRARY_PATH = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_NAME = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_VENDOR = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_VERSION = null;
    public static final StandardSystemProperty JAVA_VENDOR = null;
    public static final StandardSystemProperty JAVA_VENDOR_URL = null;
    public static final StandardSystemProperty JAVA_VERSION = null;
    public static final StandardSystemProperty JAVA_VM_NAME = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_NAME = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_VENDOR = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_VERSION = null;
    public static final StandardSystemProperty JAVA_VM_VENDOR = null;
    public static final StandardSystemProperty JAVA_VM_VERSION = null;
    public static final StandardSystemProperty LINE_SEPARATOR = null;
    public static final StandardSystemProperty OS_ARCH = null;
    public static final StandardSystemProperty OS_NAME = null;
    public static final StandardSystemProperty OS_VERSION = null;
    public static final StandardSystemProperty PATH_SEPARATOR = null;
    public static final StandardSystemProperty USER_DIR = null;
    public static final StandardSystemProperty USER_HOME = null;
    public static final StandardSystemProperty USER_NAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StandardSystemProperty[] f274706a = null;
    private final String key;

    static {
        StandardSystemProperty r100 = new StandardSystemProperty("JAVA_VERSION", 0, "java.version");
        JAVA_VERSION = r100;
        StandardSystemProperty r101 = new StandardSystemProperty("JAVA_VENDOR", 1, "java.vendor");
        JAVA_VENDOR = r101;
        StandardSystemProperty r102 = new StandardSystemProperty("JAVA_VENDOR_URL", 2, "java.vendor.url");
        JAVA_VENDOR_URL = r102;
        StandardSystemProperty r103 = new StandardSystemProperty("JAVA_HOME", 3, "java.home");
        JAVA_HOME = r103;
        StandardSystemProperty r104 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VERSION", 4, "java.vm.specification.version");
        JAVA_VM_SPECIFICATION_VERSION = r104;
        StandardSystemProperty r105 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VENDOR", 5, "java.vm.specification.vendor");
        JAVA_VM_SPECIFICATION_VENDOR = r105;
        StandardSystemProperty r110 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_NAME", 6, "java.vm.specification.name");
        JAVA_VM_SPECIFICATION_NAME = r110;
        StandardSystemProperty r111 = new StandardSystemProperty("JAVA_VM_VERSION", 7, "java.vm.version");
        JAVA_VM_VERSION = r111;
        StandardSystemProperty r112 = new StandardSystemProperty("JAVA_VM_VENDOR", 8, "java.vm.vendor");
        JAVA_VM_VENDOR = r112;
        StandardSystemProperty r113 = new StandardSystemProperty("JAVA_VM_NAME", 9, "java.vm.name");
        JAVA_VM_NAME = r113;
        StandardSystemProperty r114 = new StandardSystemProperty("JAVA_SPECIFICATION_VERSION", 10, "java.specification.version");
        JAVA_SPECIFICATION_VERSION = r114;
        StandardSystemProperty r106 = new StandardSystemProperty("JAVA_SPECIFICATION_VENDOR", 11, "java.specification.vendor");
        JAVA_SPECIFICATION_VENDOR = r106;
        StandardSystemProperty r107 = new StandardSystemProperty("JAVA_SPECIFICATION_NAME", 12, "java.specification.name");
        JAVA_SPECIFICATION_NAME = r107;
        StandardSystemProperty r108 = new StandardSystemProperty("JAVA_CLASS_VERSION", 13, "java.class.version");
        JAVA_CLASS_VERSION = r108;
        StandardSystemProperty r109 = new StandardSystemProperty("JAVA_CLASS_PATH", 14, "java.class.path");
        JAVA_CLASS_PATH = r109;
        StandardSystemProperty r115 = new StandardSystemProperty("JAVA_LIBRARY_PATH", 15, "java.library.path");
        JAVA_LIBRARY_PATH = r115;
        StandardSystemProperty r116 = new StandardSystemProperty("JAVA_IO_TMPDIR", 16, "java.io.tmpdir");
        JAVA_IO_TMPDIR = r116;
        StandardSystemProperty r117 = new StandardSystemProperty("JAVA_COMPILER", 17, "java.compiler");
        JAVA_COMPILER = r117;
        StandardSystemProperty r118 = new StandardSystemProperty("JAVA_EXT_DIRS", 18, "java.ext.dirs");
        JAVA_EXT_DIRS = r118;
        StandardSystemProperty r119 = new StandardSystemProperty("OS_NAME", 19, "os.name");
        OS_NAME = r119;
        StandardSystemProperty r120 = new StandardSystemProperty("OS_ARCH", 20, "os.arch");
        OS_ARCH = r120;
        StandardSystemProperty r121 = new StandardSystemProperty("OS_VERSION", 21, "os.version");
        OS_VERSION = r121;
        StandardSystemProperty r122 = new StandardSystemProperty("FILE_SEPARATOR", 22, "file.separator");
        FILE_SEPARATOR = r122;
        StandardSystemProperty r123 = new StandardSystemProperty("PATH_SEPARATOR", 23, "path.separator");
        PATH_SEPARATOR = r123;
        StandardSystemProperty r124 = new StandardSystemProperty("LINE_SEPARATOR", 24, "line.separator");
        LINE_SEPARATOR = r124;
        StandardSystemProperty r125 = new StandardSystemProperty("USER_NAME", 25, "user.name");
        USER_NAME = r125;
        StandardSystemProperty r126 = new StandardSystemProperty("USER_HOME", 26, "user.home");
        USER_HOME = r126;
        StandardSystemProperty r127 = new StandardSystemProperty("USER_DIR", 27, "user.dir");
        USER_DIR = r127;
        f274706a = new StandardSystemProperty[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
    }

    public static StandardSystemProperty[] values() {
        return (StandardSystemProperty[]) f274706a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return key() + ContainerUtils.KEY_VALUE_DELIMITER + value();
    }

    @CheckForNull
    public String value() {
        return System.getProperty(this.key);
    }

    public String key() {
        return this.key;
    }

    public static StandardSystemProperty valueOf(String r100) {
        return (StandardSystemProperty) r27.a.a(StandardSystemProperty.class, r100);
    }

    public StandardSystemProperty(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}

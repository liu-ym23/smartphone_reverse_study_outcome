package com.bytedance.mira.compat.p;

/* JADX INFO: loaded from: classes21.dex */
public class ManifestTagCompat {
    private static final int AndroidManifestActivity_singleUser = 28;
    private static final int AndroidManifestData_host = 2;
    private static final int AndroidManifestData_mimeGroup = 10;
    private static final int AndroidManifestData_mimeType = 0;
    private static final int AndroidManifestData_path = 4;
    private static final int AndroidManifestData_pathPattern = 6;
    private static final int AndroidManifestData_pathPrefix = 5;
    private static final int AndroidManifestData_port = 3;
    private static final int AndroidManifestData_scheme = 1;
    private static final int AndroidManifestData_ssp = 7;
    private static final int AndroidManifestData_sspPattern = 9;
    private static final int AndroidManifestData_sspPrefix = 8;
    private static final int AndroidManifestPermission_banner = 8;
    private static final int AndroidManifestPermission_description = 5;
    private static final int AndroidManifestPermission_icon = 1;
    private static final int AndroidManifestPermission_label = 0;
    private static final int AndroidManifestPermission_logo = 6;
    private static final int AndroidManifestPermission_name = 2;
    private static final int AndroidManifestPermission_permissionFlags = 7;
    private static final int AndroidManifestPermission_permissionGroup = 4;
    private static final int AndroidManifestPermission_protectionLevel = 3;
    private static final int AndroidManifestPermission_roundIcon = 9;
    private static final int AndroidManifestProvider_authorities = 10;
    private static final int AndroidManifestProvider_banner = 17;
    private static final int AndroidManifestProvider_description = 14;
    private static final int AndroidManifestProvider_directBootAware = 18;
    private static final int AndroidManifestProvider_enabled = 6;
    private static final int AndroidManifestProvider_exported = 7;
    private static final int AndroidManifestProvider_forceUriPermissions = 22;
    private static final int AndroidManifestProvider_grantUriPermissions = 13;
    private static final int AndroidManifestProvider_icon = 1;
    private static final int AndroidManifestProvider_initOrder = 12;
    private static final int AndroidManifestProvider_label = 0;
    private static final int AndroidManifestProvider_logo = 15;
    private static final int AndroidManifestProvider_multiprocess = 9;
    private static final int AndroidManifestProvider_name = 2;
    private static final int AndroidManifestProvider_permission = 3;
    private static final int AndroidManifestProvider_process = 8;
    private static final int AndroidManifestProvider_readPermission = 4;
    private static final int AndroidManifestProvider_roundIcon = 19;
    private static final int AndroidManifestProvider_singleUser = 16;
    private static final int AndroidManifestProvider_splitName = 21;
    private static final int AndroidManifestProvider_syncable = 11;
    private static final int AndroidManifestProvider_visibleToInstantApps = 20;
    private static final int AndroidManifestProvider_writePermission = 5;

    public ManifestTagCompat() {
    }

    public static Object getTagValue(String r110) {
        if ("AndroidManifestPermission_label".equals(r110) == false) goto L6;
        return 0;
    L6:
        if ("AndroidManifestPermission_icon".equals(r110) == false) goto L10;
        return 1;
    L10:
        if ("AndroidManifestPermission_name".equals(r110) == false) goto L14;
        return 2;
    L14:
        if ("AndroidManifestPermission_protectionLevel".equals(r110) == false) goto L18;
        return 3;
    L18:
        if ("AndroidManifestPermission_permissionGroup".equals(r110) == false) goto L22;
        return 4;
    L22:
        if ("AndroidManifestPermission_description".equals(r110) == false) goto L26;
        return 5;
    L26:
        if ("AndroidManifestPermission_logo".equals(r110) == false) goto L30;
        return 6;
    L30:
        if ("AndroidManifestPermission_permissionFlags".equals(r110) == false) goto L34;
        return 7;
    L34:
        if ("AndroidManifestPermission_banner".equals(r110) == false) goto L38;
        return 8;
    L38:
        if ("AndroidManifestPermission_roundIcon".equals(r110) == false) goto L42;
        return 9;
    L42:
        if ("AndroidManifestActivity_singleUser".equals(r110) == false) goto L46;
        return 28;
    L46:
        if ("AndroidManifestProvider_label".equals(r110) == false) goto L49;
        return 0;
    L49:
        if ("AndroidManifestProvider_icon".equals(r110) == false) goto L53;
        return 1;
    L53:
        if ("AndroidManifestProvider_name".equals(r110) == false) goto L57;
        return 2;
    L57:
        if ("AndroidManifestProvider_permission".equals(r110) == false) goto L61;
        return 3;
    L61:
        if ("AndroidManifestProvider_readPermission".equals(r110) == false) goto L65;
        return 4;
    L65:
        if ("AndroidManifestProvider_writePermission".equals(r110) == false) goto L69;
        return 5;
    L69:
        if ("AndroidManifestProvider_enabled".equals(r110) == false) goto L73;
        return 6;
    L73:
        if ("AndroidManifestProvider_exported".equals(r110) == false) goto L77;
        return 7;
    L77:
        if ("AndroidManifestProvider_process".equals(r110) == false) goto L81;
        return 8;
    L81:
        if ("AndroidManifestProvider_multiprocess".equals(r110) == false) goto L85;
        return 9;
    L85:
        if ("AndroidManifestProvider_authorities".equals(r110) == false) goto L89;
        return 10;
    L89:
        if ("AndroidManifestProvider_syncable".equals(r110) == false) goto L93;
        return 11;
    L93:
        if ("AndroidManifestProvider_initOrder".equals(r110) == false) goto L97;
        return 12;
    L97:
        if ("AndroidManifestProvider_grantUriPermissions".equals(r110) == false) goto L101;
        return 13;
    L101:
        if ("AndroidManifestProvider_description".equals(r110) == false) goto L105;
        return 14;
    L105:
        if ("AndroidManifestProvider_logo".equals(r110) == false) goto L109;
        return 15;
    L109:
        if ("AndroidManifestProvider_singleUser".equals(r110) == false) goto L113;
        return 16;
    L113:
        if ("AndroidManifestProvider_banner".equals(r110) == false) goto L117;
        return 17;
    L117:
        if ("AndroidManifestProvider_directBootAware".equals(r110) == false) goto L121;
        return 18;
    L121:
        if ("AndroidManifestProvider_roundIcon".equals(r110) == false) goto L125;
        return 19;
    L125:
        if ("AndroidManifestProvider_visibleToInstantApps".equals(r110) == false) goto L129;
        return 20;
    L129:
        if ("AndroidManifestProvider_splitName".equals(r110) == false) goto L133;
        return 21;
    L133:
        if ("AndroidManifestProvider_forceUriPermissions".equals(r110) == false) goto L137;
        return 22;
    L137:
        if ("AndroidManifestData_mimeType".equals(r110) == false) goto L140;
        return 0;
    L140:
        if ("AndroidManifestData_scheme".equals(r110) == false) goto L144;
        return 1;
    L144:
        if ("AndroidManifestData_host".equals(r110) == false) goto L148;
        return 2;
    L148:
        if ("AndroidManifestData_port".equals(r110) == false) goto L152;
        return 3;
    L152:
        if ("AndroidManifestData_path".equals(r110) == false) goto L156;
        return 4;
    L156:
        if ("AndroidManifestData_pathPrefix".equals(r110) == false) goto L160;
        return 5;
    L160:
        if ("AndroidManifestData_pathPattern".equals(r110) == false) goto L164;
        return 6;
    L164:
        if ("AndroidManifestData_ssp".equals(r110) == false) goto L168;
        return 7;
    L168:
        if ("AndroidManifestData_sspPrefix".equals(r110) == false) goto L172;
        return 8;
    L172:
        if ("AndroidManifestData_sspPattern".equals(r110) == false) goto L176;
        return 9;
    L176:
        if ("AndroidManifestData_mimeGroup".equals(r110) == true) goto L178;
        return null;
    L178:
        return 10;
    }
}

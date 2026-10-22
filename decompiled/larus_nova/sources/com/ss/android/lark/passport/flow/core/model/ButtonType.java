package com.ss.android.lark.passport.flow.core.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b5\b\u0086\u0081\u0002\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6¨\u00068"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/model/ButtonType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "NEXT", "REGISTER", "JOIN", "JOIN_SCAN", "JOIN_CODE", "CREATE_TENANT", "CREATE_PERSONAL", "APPEAL", "VERIFY", "KNOWN", "VERIFY_EMAIL", "VERIFY_PHONE", "QR_AUTH_SINGLE", "QR_AUTH_ALL", "QR_AUTH_AUTHZ", "DEPROV_KNOWN", "DEPROV_DELETE_WALLET", "RETRIEVE_NEED_MOBILE_CANCEL", "VERIFY_CIDP", "VERIFY_GOOGLE", "VERIFY_APPLE_ID", "VERIFY_TENANT_DOMAIN", "VERIFY_B_IDP", "OPT_IN_ACCEPT", "OPT_IN_NOT_ACCEPT", "OPT_IN_SKIP_SELECT", "REAL_NAME_SKIP_VERIFY", "REAL_NAME_VERIFY", "JOIN_DIALOG_REFUSE_TENANT", "OPEN_URL", "VERIFY_PASSWORD", "VERIFY_OTP", "VERIFY_SPARE", "VERIFY_MO", "SESSION_REAUTH_GUIDEDIALOG", "SESSION_REAUTH_SWITCH", "SESSION_REAUTH_EXEMPT_REMIND", "QR_LOGIN_CONFIRM_AUTH", "QR_LOGIN_CONFIRM_CANCEL", "VERIFY_FIDO", "SWITCH_AUTH", "SET_PASSWORD", "SESSION_CONFIRM_CANCEL", "QR_LOGIN_SHOW", "VERIFY_DOUBAO", "CREATE_DOUBAO_ACCOUNT", "Companion", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ButtonType extends Enum<ButtonType> {
    public static final ButtonType APPEAL = null;
    public static final ButtonType CREATE_DOUBAO_ACCOUNT = null;
    public static final ButtonType CREATE_PERSONAL = null;
    public static final ButtonType CREATE_TENANT = null;
    public static final a Companion = null;
    public static final ButtonType DEPROV_DELETE_WALLET = null;
    public static final ButtonType DEPROV_KNOWN = null;
    public static final ButtonType JOIN = null;
    public static final ButtonType JOIN_CODE = null;
    public static final ButtonType JOIN_DIALOG_REFUSE_TENANT = null;
    public static final ButtonType JOIN_SCAN = null;
    public static final ButtonType KNOWN = null;
    public static final ButtonType NEXT = null;
    public static final ButtonType NORMAL = null;
    public static final ButtonType OPEN_URL = null;
    public static final ButtonType OPT_IN_ACCEPT = null;
    public static final ButtonType OPT_IN_NOT_ACCEPT = null;
    public static final ButtonType OPT_IN_SKIP_SELECT = null;
    public static final ButtonType QR_AUTH_ALL = null;
    public static final ButtonType QR_AUTH_AUTHZ = null;
    public static final ButtonType QR_AUTH_SINGLE = null;
    public static final ButtonType QR_LOGIN_CONFIRM_AUTH = null;
    public static final ButtonType QR_LOGIN_CONFIRM_CANCEL = null;
    public static final ButtonType QR_LOGIN_SHOW = null;
    public static final ButtonType REAL_NAME_SKIP_VERIFY = null;
    public static final ButtonType REAL_NAME_VERIFY = null;
    public static final ButtonType REGISTER = null;
    public static final ButtonType RETRIEVE_NEED_MOBILE_CANCEL = null;
    public static final ButtonType SESSION_CONFIRM_CANCEL = null;
    public static final ButtonType SESSION_REAUTH_EXEMPT_REMIND = null;
    public static final ButtonType SESSION_REAUTH_GUIDEDIALOG = null;
    public static final ButtonType SESSION_REAUTH_SWITCH = null;
    public static final ButtonType SET_PASSWORD = null;
    public static final ButtonType SWITCH_AUTH = null;
    public static final ButtonType VERIFY = null;
    public static final ButtonType VERIFY_APPLE_ID = null;
    public static final ButtonType VERIFY_B_IDP = null;
    public static final ButtonType VERIFY_CIDP = null;
    public static final ButtonType VERIFY_DOUBAO = null;
    public static final ButtonType VERIFY_EMAIL = null;
    public static final ButtonType VERIFY_FIDO = null;
    public static final ButtonType VERIFY_GOOGLE = null;
    public static final ButtonType VERIFY_MO = null;
    public static final ButtonType VERIFY_OTP = null;
    public static final ButtonType VERIFY_PASSWORD = null;
    public static final ButtonType VERIFY_PHONE = null;
    public static final ButtonType VERIFY_SPARE = null;
    public static final ButtonType VERIFY_TENANT_DOMAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<ButtonType[]> f437742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ButtonType[] f437743b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437744c = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ButtonType a(int r100) {
            ButtonType[] r101 = (ButtonType[]) ButtonType.access$getValues$delegate$cp().getValue();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            ButtonType r104 = r101[r103];
            if (r104.getValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return ButtonType.NORMAL;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    @JvmStatic
    public static final ButtonType fromValue(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<ButtonType> getEntries() {
        return f437744c;
    }

    static {
        ButtonType r100 = new ButtonType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ButtonType r101 = new ButtonType("NEXT", 1, 1);
        NEXT = r101;
        ButtonType r102 = new ButtonType("REGISTER", 2, 2);
        REGISTER = r102;
        ButtonType r103 = new ButtonType("JOIN", 3, 3);
        JOIN = r103;
        ButtonType r104 = new ButtonType("JOIN_SCAN", 4, 4);
        JOIN_SCAN = r104;
        ButtonType r105 = new ButtonType("JOIN_CODE", 5, 5);
        JOIN_CODE = r105;
        ButtonType r110 = new ButtonType("CREATE_TENANT", 6, 6);
        CREATE_TENANT = r110;
        ButtonType r111 = new ButtonType("CREATE_PERSONAL", 7, 7);
        CREATE_PERSONAL = r111;
        ButtonType r112 = new ButtonType("APPEAL", 8, 8);
        APPEAL = r112;
        ButtonType r113 = new ButtonType("VERIFY", 9, 9);
        VERIFY = r113;
        ButtonType r114 = new ButtonType("KNOWN", 10, 10);
        KNOWN = r114;
        ButtonType r106 = new ButtonType("VERIFY_EMAIL", 11, 11);
        VERIFY_EMAIL = r106;
        ButtonType r107 = new ButtonType("VERIFY_PHONE", 12, 12);
        VERIFY_PHONE = r107;
        ButtonType r108 = new ButtonType("QR_AUTH_SINGLE", 13, 13);
        QR_AUTH_SINGLE = r108;
        ButtonType r109 = new ButtonType("QR_AUTH_ALL", 14, 14);
        QR_AUTH_ALL = r109;
        ButtonType r115 = new ButtonType("QR_AUTH_AUTHZ", 15, 15);
        QR_AUTH_AUTHZ = r115;
        ButtonType r116 = new ButtonType("DEPROV_KNOWN", 16, 16);
        DEPROV_KNOWN = r116;
        ButtonType r117 = new ButtonType("DEPROV_DELETE_WALLET", 17, 17);
        DEPROV_DELETE_WALLET = r117;
        ButtonType r118 = new ButtonType("RETRIEVE_NEED_MOBILE_CANCEL", 18, 18);
        RETRIEVE_NEED_MOBILE_CANCEL = r118;
        ButtonType r119 = new ButtonType("VERIFY_CIDP", 19, 19);
        VERIFY_CIDP = r119;
        ButtonType r120 = new ButtonType("VERIFY_GOOGLE", 20, 20);
        VERIFY_GOOGLE = r120;
        ButtonType r121 = new ButtonType("VERIFY_APPLE_ID", 21, 21);
        VERIFY_APPLE_ID = r121;
        ButtonType r122 = new ButtonType("VERIFY_TENANT_DOMAIN", 22, 22);
        VERIFY_TENANT_DOMAIN = r122;
        ButtonType r123 = new ButtonType("VERIFY_B_IDP", 23, 23);
        VERIFY_B_IDP = r123;
        ButtonType r124 = new ButtonType("OPT_IN_ACCEPT", 24, 24);
        OPT_IN_ACCEPT = r124;
        ButtonType r125 = new ButtonType("OPT_IN_NOT_ACCEPT", 25, 25);
        OPT_IN_NOT_ACCEPT = r125;
        ButtonType r126 = new ButtonType("OPT_IN_SKIP_SELECT", 26, 26);
        OPT_IN_SKIP_SELECT = r126;
        ButtonType r127 = new ButtonType("REAL_NAME_SKIP_VERIFY", 27, 27);
        REAL_NAME_SKIP_VERIFY = r127;
        ButtonType r128 = new ButtonType("REAL_NAME_VERIFY", 28, 28);
        REAL_NAME_VERIFY = r128;
        ButtonType r129 = new ButtonType("JOIN_DIALOG_REFUSE_TENANT", 29, 31);
        JOIN_DIALOG_REFUSE_TENANT = r129;
        ButtonType r130 = new ButtonType("OPEN_URL", 30, 32);
        OPEN_URL = r130;
        ButtonType r131 = new ButtonType("VERIFY_PASSWORD", 31, 41);
        VERIFY_PASSWORD = r131;
        ButtonType r132 = new ButtonType("VERIFY_OTP", 32, 42);
        VERIFY_OTP = r132;
        ButtonType r133 = new ButtonType("VERIFY_SPARE", 33, 43);
        VERIFY_SPARE = r133;
        ButtonType r134 = new ButtonType("VERIFY_MO", 34, 45);
        VERIFY_MO = r134;
        ButtonType r135 = new ButtonType("SESSION_REAUTH_GUIDEDIALOG", 35, 48);
        SESSION_REAUTH_GUIDEDIALOG = r135;
        ButtonType r136 = new ButtonType("SESSION_REAUTH_SWITCH", 36, 49);
        SESSION_REAUTH_SWITCH = r136;
        ButtonType r137 = new ButtonType("SESSION_REAUTH_EXEMPT_REMIND", 37, 50);
        SESSION_REAUTH_EXEMPT_REMIND = r137;
        ButtonType r138 = new ButtonType("QR_LOGIN_CONFIRM_AUTH", 38, 51);
        QR_LOGIN_CONFIRM_AUTH = r138;
        ButtonType r139 = new ButtonType("QR_LOGIN_CONFIRM_CANCEL", 39, 52);
        QR_LOGIN_CONFIRM_CANCEL = r139;
        ButtonType r140 = new ButtonType("VERIFY_FIDO", 40, 53);
        VERIFY_FIDO = r140;
        ButtonType r141 = new ButtonType("SWITCH_AUTH", 41, 54);
        SWITCH_AUTH = r141;
        ButtonType r142 = new ButtonType("SET_PASSWORD", 42, 55);
        SET_PASSWORD = r142;
        ButtonType r143 = new ButtonType("SESSION_CONFIRM_CANCEL", 43, 56);
        SESSION_CONFIRM_CANCEL = r143;
        ButtonType r144 = new ButtonType("QR_LOGIN_SHOW", 44, 59);
        QR_LOGIN_SHOW = r144;
        ButtonType r145 = new ButtonType("VERIFY_DOUBAO", 45, 60);
        VERIFY_DOUBAO = r145;
        ButtonType r146 = new ButtonType("CREATE_DOUBAO_ACCOUNT", 46, 63);
        CREATE_DOUBAO_ACCOUNT = r146;
        ButtonType[] r147 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146};
        f437743b = r147;
        f437744c = EnumEntriesKt.enumEntries(r147);
        Companion = new a();
        f437742a = LazyKt.lazy(ButtonType$Companion$values$2.INSTANCE);
    }

    public static ButtonType[] values() {
        return (ButtonType[]) f437743b.clone();
    }

    public static final /* synthetic */ Lazy access$getValues$delegate$cp() {
        return f437742a;
    }

    public final int getValue() {
        return this.value;
    }

    public static ButtonType valueOf(String r100) {
        return (ButtonType) r27.a.a(ButtonType.class, r100);
    }

    public ButtonType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

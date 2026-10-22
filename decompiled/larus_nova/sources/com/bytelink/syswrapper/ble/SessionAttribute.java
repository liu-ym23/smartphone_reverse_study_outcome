package com.bytelink.syswrapper.ble;

import java.util.Objects;
import kotlin.UByte;

/* JADX INFO: loaded from: classes22.dex */
public class SessionAttribute {
    private ChannelType channelType;
    private String did;
    private LinkType linkType;
    private PairMode pairMode;
    private ProtocolType protocolType;
    private SessionRole role;
    private SecMode secMode;
    private byte sessionId;
    private SessionType type;
    private String uid;

    public static final enum ChannelType extends Enum<ChannelType> {
        public static final ChannelType CHANNEL_GATT = null;
        public static final ChannelType CHANNEL_INVALID = null;
        public static final ChannelType CHANNEL_SPP = null;
        public static final ChannelType CHANNEL_TCP = null;
        public static final ChannelType CHANNEL_UDP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChannelType[] f272707a = null;
        private final int value;

        static {
            ChannelType r100 = new ChannelType("CHANNEL_INVALID", 0, 0);
            CHANNEL_INVALID = r100;
            ChannelType r101 = new ChannelType("CHANNEL_GATT", 1, 1);
            CHANNEL_GATT = r101;
            ChannelType r102 = new ChannelType("CHANNEL_SPP", 2, 2);
            CHANNEL_SPP = r102;
            ChannelType r103 = new ChannelType("CHANNEL_TCP", 3, 3);
            CHANNEL_TCP = r103;
            ChannelType r104 = new ChannelType("CHANNEL_UDP", 4, 4);
            CHANNEL_UDP = r104;
            f272707a = new ChannelType[]{r100, r101, r102, r103, r104};
        }

        public static ChannelType[] values() {
            return (ChannelType[]) f272707a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ChannelType fromValue(int r100) {
            ChannelType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            ChannelType r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Invalid ChannelType value: " + r100);
        }

        public static ChannelType valueOf(String r100) {
            return (ChannelType) r27.a.a(ChannelType.class, r100);
        }

        public ChannelType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum LinkType extends Enum<LinkType> {
        public static final LinkType LINK_TYPE_BLE = null;
        public static final LinkType LINK_TYPE_BT = null;
        public static final LinkType LINK_TYPE_P2P = null;
        public static final LinkType LINK_TYPE_WLAN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkType[] f272708a = null;
        private final int value;

        static {
            LinkType r100 = new LinkType("LINK_TYPE_BLE", 0, 0);
            LINK_TYPE_BLE = r100;
            LinkType r101 = new LinkType("LINK_TYPE_BT", 1, 1);
            LINK_TYPE_BT = r101;
            LinkType r102 = new LinkType("LINK_TYPE_WLAN", 2, 2);
            LINK_TYPE_WLAN = r102;
            LinkType r103 = new LinkType("LINK_TYPE_P2P", 3, 3);
            LINK_TYPE_P2P = r103;
            f272708a = new LinkType[]{r100, r101, r102, r103};
        }

        public static LinkType[] values() {
            return (LinkType[]) f272708a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static LinkType fromValue(int r100) {
            LinkType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            LinkType r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Invalid LinkType value: " + r100);
        }

        public static LinkType valueOf(String r100) {
            return (LinkType) r27.a.a(LinkType.class, r100);
        }

        public LinkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum PairMode extends Enum<PairMode> {
        public static final PairMode NON_PAIR = null;
        public static final PairMode PAIR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PairMode[] f272709a = null;
        private final int value;

        static {
            PairMode r100 = new PairMode("NON_PAIR", 0, 0);
            NON_PAIR = r100;
            PairMode r101 = new PairMode("PAIR", 1, 1);
            PAIR = r101;
            f272709a = new PairMode[]{r100, r101};
        }

        public static PairMode[] values() {
            return (PairMode[]) f272709a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static PairMode fromValue(int r100) {
            if (r100 != 0) goto L6;
            return NON_PAIR;
        L6:
            if (r100 != 1) goto L10;
            return PAIR;
        L10:
            throw new IllegalArgumentException("Invalid PairMode value: " + r100);
        }

        public static PairMode valueOf(String r100) {
            return (PairMode) r27.a.a(PairMode.class, r100);
        }

        public PairMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ProtocolType extends Enum<ProtocolType> {
        public static final ProtocolType SESSION_PROTOCOL_NONE = null;
        public static final ProtocolType SESSION_PROTOCOL_V1 = null;
        public static final ProtocolType SESSION_PROTOCOL_V2 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProtocolType[] f272710a = null;
        private final int value;

        static {
            ProtocolType r100 = new ProtocolType("SESSION_PROTOCOL_NONE", 0, 0);
            SESSION_PROTOCOL_NONE = r100;
            ProtocolType r101 = new ProtocolType("SESSION_PROTOCOL_V1", 1, 1);
            SESSION_PROTOCOL_V1 = r101;
            ProtocolType r102 = new ProtocolType("SESSION_PROTOCOL_V2", 2, 2);
            SESSION_PROTOCOL_V2 = r102;
            f272710a = new ProtocolType[]{r100, r101, r102};
        }

        public static ProtocolType[] values() {
            return (ProtocolType[]) f272710a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ProtocolType fromValue(int r100) {
            ProtocolType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            ProtocolType r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Invalid ProtocolType value: " + r100);
        }

        public static ProtocolType valueOf(String r100) {
            return (ProtocolType) r27.a.a(ProtocolType.class, r100);
        }

        public ProtocolType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SecMode extends Enum<SecMode> {
        public static final SecMode AES_CTR_128 = null;
        public static final SecMode NONE_SEC_MODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SecMode[] f272711a = null;
        private final int value;

        static {
            SecMode r100 = new SecMode("NONE_SEC_MODE", 0, 0);
            NONE_SEC_MODE = r100;
            SecMode r101 = new SecMode("AES_CTR_128", 1, 1);
            AES_CTR_128 = r101;
            f272711a = new SecMode[]{r100, r101};
        }

        public static SecMode[] values() {
            return (SecMode[]) f272711a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static SecMode fromValue(int r100) {
            if (r100 != 0) goto L6;
            return NONE_SEC_MODE;
        L6:
            if (r100 != 1) goto L10;
            return AES_CTR_128;
        L10:
            throw new IllegalArgumentException("Invalid SecMode value: " + r100);
        }

        public static SecMode valueOf(String r100) {
            return (SecMode) r27.a.a(SecMode.class, r100);
        }

        public SecMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SessionRole extends Enum<SessionRole> {
        public static final SessionRole SESSION_ROLE_CLIENT = null;
        public static final SessionRole SESSION_ROLE_NONE = null;
        public static final SessionRole SESSION_ROLE_SERVER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SessionRole[] f272712a = null;
        private final int value;

        static {
            SessionRole r100 = new SessionRole("SESSION_ROLE_NONE", 0, 0);
            SESSION_ROLE_NONE = r100;
            SessionRole r101 = new SessionRole("SESSION_ROLE_SERVER", 1, 1);
            SESSION_ROLE_SERVER = r101;
            SessionRole r102 = new SessionRole("SESSION_ROLE_CLIENT", 2, 2);
            SESSION_ROLE_CLIENT = r102;
            f272712a = new SessionRole[]{r100, r101, r102};
        }

        public static SessionRole[] values() {
            return (SessionRole[]) f272712a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static SessionRole fromValue(int r100) {
            SessionRole[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            SessionRole r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Invalid SessionRole value: " + r100);
        }

        public static SessionRole valueOf(String r100) {
            return (SessionRole) r27.a.a(SessionRole.class, r100);
        }

        public SessionRole(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SessionType extends Enum<SessionType> {
        public static final SessionType SESSION_TYPE_AUDIO = null;
        public static final SessionType SESSION_TYPE_DATA = null;
        public static final SessionType SESSION_TYPE_DEFAULT = null;
        public static final SessionType SESSION_TYPE_VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SessionType[] f272713a = null;
        private final int value;

        static {
            SessionType r100 = new SessionType("SESSION_TYPE_DEFAULT", 0, 0);
            SESSION_TYPE_DEFAULT = r100;
            SessionType r101 = new SessionType("SESSION_TYPE_AUDIO", 1, 1);
            SESSION_TYPE_AUDIO = r101;
            SessionType r102 = new SessionType("SESSION_TYPE_VIDEO", 2, 2);
            SESSION_TYPE_VIDEO = r102;
            SessionType r103 = new SessionType("SESSION_TYPE_DATA", 3, 3);
            SESSION_TYPE_DATA = r103;
            f272713a = new SessionType[]{r100, r101, r102, r103};
        }

        public static SessionType[] values() {
            return (SessionType[]) f272713a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static SessionType fromValue(int r100) {
            SessionType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            SessionType r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Invalid SessionType value: " + r100);
        }

        public static SessionType valueOf(String r100) {
            return (SessionType) r27.a.a(SessionType.class, r100);
        }

        public SessionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.protocolType, this.type, this.role, this.pairMode, this.linkType, this.channelType, Byte.valueOf(this.sessionId), this.uid, this.did});
    }

    public String toString() {
        return "SessionAttribute{protocolType=" + this.protocolType + ", type=" + this.type + ", role=" + this.role + ", pairMode=" + this.pairMode + ", linkType=" + this.linkType + ", channelType=" + this.channelType + ", sessionId=0x" + String.format("%02X", new Object[]{Integer.valueOf(this.sessionId & UByte.MAX_VALUE)}) + ", uid='" + this.uid + "', did='" + this.did + "'}";
    }

    public SessionAttribute() {
        this.protocolType = ProtocolType.SESSION_PROTOCOL_NONE;
        this.type = SessionType.SESSION_TYPE_DEFAULT;
        this.role = SessionRole.SESSION_ROLE_NONE;
        this.pairMode = PairMode.NON_PAIR;
        this.linkType = LinkType.LINK_TYPE_BLE;
        this.channelType = ChannelType.CHANNEL_INVALID;
        this.sessionId = 2;
        this.uid = "";
        this.did = "";
    }

    public ChannelType getChannelType() {
        return this.channelType;
    }

    public String getDid() {
        return this.did;
    }

    public LinkType getLinkType() {
        return this.linkType;
    }

    public PairMode getPairMode() {
        return this.pairMode;
    }

    public ProtocolType getProtocolType() {
        return this.protocolType;
    }

    public SessionRole getRole() {
        return this.role;
    }

    public SecMode getSecMode() {
        return this.secMode;
    }

    public byte getSessionId() {
        return this.sessionId;
    }

    public SessionType getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L33:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L33;
        SessionAttribute r101 = (SessionAttribute) r100;
        if (this.sessionId == r101.sessionId) goto L13;
    L31:
        return false;
    L13:
        if (this.protocolType != r101.protocolType) goto L31;
        if (this.type != r101.type) goto L31;
        if (this.role != r101.role) goto L31;
        if (this.pairMode != r101.pairMode) goto L31;
        if (this.linkType != r101.linkType) goto L31;
        if (this.channelType != r101.channelType) goto L31;
        if (Objects.equals(this.uid, r101.uid) == false) goto L31;
        if (Objects.equals(this.did, r101.did) == false) goto L31;
        if (this.secMode != r101.secMode) goto L31;
        return true;
    }

    public void setChannelType(ChannelType r100) {
        Objects.requireNonNull(r100, "channelType cannot be null");
        this.channelType = r100;
    }

    public void setDid(String r100) {
        this.did = r100;
    }

    public void setLinkType(LinkType r100) {
        Objects.requireNonNull(r100, "linkType cannot be null");
        this.linkType = r100;
    }

    public void setPairMode(PairMode r100) {
        Objects.requireNonNull(r100, "pairMode cannot be null");
        this.pairMode = r100;
    }

    public void setProtocolType(ProtocolType r100) {
        Objects.requireNonNull(r100, "protocolType cannot be null");
        this.protocolType = r100;
    }

    public void setRole(SessionRole r100) {
        Objects.requireNonNull(r100, "role cannot be null");
        this.role = r100;
    }

    public void setSecMode(SecMode r100) {
        this.secMode = r100;
    }

    public void setSessionId(byte r100) {
        this.sessionId = r100;
    }

    public void setType(SessionType r100) {
        Objects.requireNonNull(r100, "type cannot be null");
        this.type = r100;
    }

    public void setUid(String r100) {
        this.uid = r100;
    }

    public SessionAttribute(ProtocolType r100, SessionType r101, SessionRole r102, PairMode r103, LinkType r104, ChannelType r105, byte r106) {
        this.protocolType = r100;
        this.type = r101;
        this.role = r102;
        this.pairMode = r103;
        this.linkType = r104;
        this.channelType = r105;
        this.sessionId = r106;
    }
}

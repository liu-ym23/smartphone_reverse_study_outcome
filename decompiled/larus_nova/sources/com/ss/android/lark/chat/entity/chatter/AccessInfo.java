package com.ss.android.lark.chat.entity.chatter;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class AccessInfo implements o5b.a, Serializable {
    private static final long serialVersionUID = -9002720120116429273L;
    private AccessProfile phoneCallAccessProfile;
    private AccessProfile urgentAccessProfile;
    private AccessProfile videoCallAccessProfile;
    private AccessProfile voiceCallAccessProfile;

    public static class AccessProfile implements Serializable {
        private static final long serialVersionUID = 30163195286264315L;
        private InaccessibleCode inaccessibleCode;
        private boolean isAccessible;

        public AccessProfile() {
        }

        public InaccessibleCode getInaccessibleCode() {
            return this.inaccessibleCode;
        }

        public boolean isAccessible() {
            return this.isAccessible;
        }

        public static /* synthetic */ boolean access$000(AccessProfile r100) {
            return r100.isAccessible;
        }

        public static /* synthetic */ InaccessibleCode access$100(AccessProfile r100) {
            return r100.inaccessibleCode;
        }

        public void setAccessible(boolean r100) {
            this.isAccessible = r100;
        }

        public void setInaccessibleCode(InaccessibleCode r100) {
            this.inaccessibleCode = r100;
        }

        public AccessProfile(boolean r100, InaccessibleCode r101) {
            this.isAccessible = r100;
            this.inaccessibleCode = r101;
        }
    }

    public static final enum InaccessibleCode extends Enum<InaccessibleCode> {
        public static final InaccessibleCode DEFAULT = null;
        public static final InaccessibleCode EXECUTIVES = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InaccessibleCode[] f415176a = null;
        private final int value;

        static {
            InaccessibleCode r100 = new InaccessibleCode("DEFAULT", 0, 0);
            DEFAULT = r100;
            InaccessibleCode r101 = new InaccessibleCode("EXECUTIVES", 1, 1);
            EXECUTIVES = r101;
            f415176a = new InaccessibleCode[]{r100, r101};
        }

        public static InaccessibleCode[] values() {
            return (InaccessibleCode[]) f415176a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static InaccessibleCode fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return DEFAULT;
        L8:
            return EXECUTIVES;
        L10:
            return DEFAULT;
        }

        public static InaccessibleCode valueOf(String r100) {
            return (InaccessibleCode) r27.a.a(InaccessibleCode.class, r100);
        }

        public InaccessibleCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public boolean isAccessPhoneCall() {
        AccessProfile r100 = this.phoneCallAccessProfile;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (AccessProfile.access$000(r100) == true) goto L8;
        return false;
    }

    public boolean isAccessVideoCall() {
        AccessProfile r100 = this.videoCallAccessProfile;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (AccessProfile.access$000(r100) == true) goto L8;
        return false;
    }

    public boolean isAccessVoiceCall() {
        AccessProfile r100 = this.voiceCallAccessProfile;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (AccessProfile.access$000(r100) == true) goto L8;
        return false;
    }

    public boolean isInaccessPhoneCallByExecutives() {
        AccessProfile r100 = this.phoneCallAccessProfile;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.isAccessible() == true) goto L9;
        if (AccessProfile.access$100(this.phoneCallAccessProfile) != InaccessibleCode.EXECUTIVES) goto L9;
        return true;
    }

    public boolean isInaccessVideoCallByExecutives() {
        AccessProfile r100 = this.videoCallAccessProfile;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.isAccessible() == true) goto L9;
        if (AccessProfile.access$100(this.videoCallAccessProfile) != InaccessibleCode.EXECUTIVES) goto L9;
        return true;
    }

    public boolean isInaccessVoiceCallByExecutives() {
        AccessProfile r100 = this.voiceCallAccessProfile;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.isAccessible() == true) goto L9;
        if (AccessProfile.access$100(this.voiceCallAccessProfile) != InaccessibleCode.EXECUTIVES) goto L9;
        return true;
    }

    public boolean isInacessUrgentByExecutives() {
        AccessProfile r100 = this.urgentAccessProfile;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.isAccessible() == true) goto L9;
        if (AccessProfile.access$100(this.urgentAccessProfile) != InaccessibleCode.EXECUTIVES) goto L9;
        return true;
    }

    public AccessInfo() {
    }

    public AccessProfile getPhoneCallAccessProfile() {
        return this.phoneCallAccessProfile;
    }

    public AccessProfile getUrgentAccessProfile() {
        return this.urgentAccessProfile;
    }

    public AccessProfile getVideoCallAccessProfile() {
        return this.videoCallAccessProfile;
    }

    public AccessProfile getVoiceCallAccessProfile() {
        return this.voiceCallAccessProfile;
    }

    public void setPhoneCallAccessProfile(AccessProfile r100) {
        this.phoneCallAccessProfile = r100;
    }

    public void setUrgentAccessProfile(AccessProfile r100) {
        this.urgentAccessProfile = r100;
    }

    public void setVideoCallAccessProfile(AccessProfile r100) {
        this.videoCallAccessProfile = r100;
    }

    public void setVoiceCallAccessProfile(AccessProfile r100) {
        this.voiceCallAccessProfile = r100;
    }
}

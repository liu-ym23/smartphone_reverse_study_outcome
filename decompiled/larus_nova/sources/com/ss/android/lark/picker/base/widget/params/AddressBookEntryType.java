package com.ss.android.lark.picker.base.widget.params;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/params/AddressBookEntryType;", "", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface AddressBookEntryType {
    public static final Companion Companion = null;
    public static final int MASK_BOT = 4;
    public static final int MASK_DEPARTMENT = 2048;
    public static final int MASK_EMAIL_CONTACT = 128;
    public static final int MASK_EXIST_GROUP = 32;
    public static final int MASK_EXTERNAL_CONTACT = 16;
    public static final int MASK_MAIL_SHARED_ACCOUNT = 512;
    public static final int MASK_MINE_GROUP = 2;
    public static final int MASK_NEW_CONTACT = 1;
    public static final int MASK_ON_CALL = 8;
    public static final int MASK_OWNER_GROUP = 64;
    public static final int MASK_SPECIAL_FOCUS = 256;
    public static final int MASK_TRUST_PARTY = 1024;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/params/AddressBookEntryType$Companion;", "", "<init>", "()V", "MASK_NEW_CONTACT", "", "MASK_MINE_GROUP", "MASK_BOT", "MASK_ON_CALL", "MASK_EXTERNAL_CONTACT", "MASK_EXIST_GROUP", "MASK_OWNER_GROUP", "MASK_EMAIL_CONTACT", "MASK_SPECIAL_FOCUS", "MASK_MAIL_SHARED_ACCOUNT", "MASK_TRUST_PARTY", "MASK_DEPARTMENT", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int MASK_BOT = 4;
        public static final int MASK_DEPARTMENT = 2048;
        public static final int MASK_EMAIL_CONTACT = 128;
        public static final int MASK_EXIST_GROUP = 32;
        public static final int MASK_EXTERNAL_CONTACT = 16;
        public static final int MASK_MAIL_SHARED_ACCOUNT = 512;
        public static final int MASK_MINE_GROUP = 2;
        public static final int MASK_NEW_CONTACT = 1;
        public static final int MASK_ON_CALL = 8;
        public static final int MASK_OWNER_GROUP = 64;
        public static final int MASK_SPECIAL_FOCUS = 256;
        public static final int MASK_TRUST_PARTY = 1024;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}

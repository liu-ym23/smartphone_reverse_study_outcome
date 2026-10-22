package com.vivo.push;

/* JADX INFO: loaded from: classes41.dex */
public class PushConfig {
    private boolean mAgreePrivacyStatement;
    private boolean mOpenMultiUser;

    public static final class Builder {
        private boolean mAgreePrivacyStatement;
        private boolean mOpenMultiUser;

        public final PushConfig build() {
            return new PushConfig(this, null);
        }

        public Builder() {
            this.mAgreePrivacyStatement = true;
            this.mOpenMultiUser = false;
        }

        public static /* synthetic */ boolean access$000(Builder r100) {
            return r100.mAgreePrivacyStatement;
        }

        public static /* synthetic */ boolean access$100(Builder r100) {
            return r100.mOpenMultiUser;
        }

        public final Builder agreePrivacyStatement(boolean r100) {
            this.mAgreePrivacyStatement = r100;
            return this;
        }

        public final Builder openMultiUserMode(boolean r100) {
            this.mOpenMultiUser = r100;
            return this;
        }
    }

    public boolean isAgreePrivacyStatement() {
        return this.mAgreePrivacyStatement;
    }

    public boolean isOpenMultiUser() {
        return this.mOpenMultiUser;
    }

    private PushConfig(Builder r100) {
        this.mAgreePrivacyStatement = true;
        this.mOpenMultiUser = false;
        this.mAgreePrivacyStatement = Builder.access$000(r100);
        this.mOpenMultiUser = Builder.access$100(r100);
    }

    public /* synthetic */ PushConfig(Builder r100, w r101) {
        this(r100);
    }
}

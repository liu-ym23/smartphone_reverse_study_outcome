package com.ss.android.lark.profile.v2.entity;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u0000 %2\u00020\u0001:\u0003%&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\t¨\u0006("}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/CTA;", "Ljava/io/Serializable;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "ctaType", "", "getCtaType", "()I", "setCtaType", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "name", "getName", "setName", "url", "getUrl", "setUrl", "iconKey", "getIconKey", "setIconKey", "denyReason", "getDenyReason", "setDenyReason", "denyReasonDescription", "getDenyReasonDescription", "setDenyReasonDescription", "Companion", "CTAType", "DeniedReason", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CTA implements Serializable {
    public static final int CTA_TYPE_CHAT = 10;
    public static final int CTA_TYPE_CRYPTO_CHAT = 11;
    public static final int CTA_TYPE_LINK = 1;
    public static final int CTA_TYPE_UNKNOWN = 0;
    public static final int CTA_TYPE_USER_CARD = 14;
    public static final int CTA_TYPE_VIDEO = 13;
    public static final int CTA_TYPE_VOICE = 12;
    public static final a Companion = null;
    public static final int DENIED_REASON_CROSS_TENANT_BLOCKED = 1;
    public static final int DENIED_REASON_CROSS_TENANT_DENY = 2;
    public static final int DENIED_REASON_SAME_CRYPTO_CHAT_DENY = 4;
    public static final int DENIED_REASON_SAME_TENANT_DENY = 3;
    public static final int DENIED_REASON_SEND_SECRET_CHAT_BY_ICON_DENY = 12;
    public static final int DENIED_REASON_UNKNOWN = 0;
    private int ctaType;
    private int denyReason;
    private String denyReasonDescription;
    private boolean enable;
    private String iconKey;
    private String key;
    private String name;
    private String url;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/CTA$CTAType;", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CTAType {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/CTA$DeniedReason;", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DeniedReason {
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CTA() {
        this.key = "";
        this.enable = true;
    }

    public final int getCtaType() {
        return this.ctaType;
    }

    public final int getDenyReason() {
        return this.denyReason;
    }

    public final String getDenyReasonDescription() {
        return this.denyReasonDescription;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCtaType(int r100) {
        this.ctaType = r100;
    }

    public final void setDenyReason(int r100) {
        this.denyReason = r100;
    }

    public final void setDenyReasonDescription(String r100) {
        this.denyReasonDescription = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}

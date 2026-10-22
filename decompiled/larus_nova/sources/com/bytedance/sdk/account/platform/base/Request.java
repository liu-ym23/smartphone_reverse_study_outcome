package com.bytedance.sdk.account.platform.base;

import android.net.Uri;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public class Request {
    public final String authTicket;
    public final int authType;
    public final String callerLocalEntry;
    public final Bundle extra;
    public final String language;
    public final String maskPhoneNumber;
    public final Set<String> optionalScopes0;
    public final Set<String> optionalScopes1;
    public final Uri redirectUri;
    public final String responseType;
    public final Map<String, String> scopeToFields;
    public final Set<String> scopes;
    public final String state;

    public static class Builder {
        String authTicket;
        int authType;
        String callerLocalEntry;
        Bundle extra;
        String language;
        String maskPhoneNumber;
        Set<String> optionalScopes0;
        Set<String> optionalScopes1;
        Uri redirectUri;
        String responseType;
        Map<String, String> scopeToFields;
        Set<String> scopes;
        String state;

        public Request build() {
            return new Request(this, null);
        }

        public Builder() {
        }

        public Builder(Request r100) {
            this.scopes = r100.scopes;
            this.optionalScopes0 = r100.optionalScopes0;
            this.optionalScopes1 = r100.optionalScopes1;
            this.state = r100.state;
            this.callerLocalEntry = r100.callerLocalEntry;
            this.extra = r100.extra;
            this.responseType = r100.responseType;
            this.language = r100.language;
            this.redirectUri = r100.redirectUri;
            this.authTicket = r100.authTicket;
            this.maskPhoneNumber = r100.maskPhoneNumber;
            this.authType = r100.authType;
            this.scopeToFields = r100.scopeToFields;
        }

        public Builder setAuthTicket(String r100) {
            this.authTicket = r100;
            return this;
        }

        public Builder setAuthType(int r100) {
            this.authType = r100;
            return this;
        }

        public Builder setCallerLocalEntry(String r100) {
            this.callerLocalEntry = r100;
            return this;
        }

        public Builder setExtra(Bundle r100) {
            this.extra = r100;
            return this;
        }

        public Builder setLanguage(String r100) {
            this.language = r100;
            return this;
        }

        public Builder setMaskPhoneNumber(String r100) {
            this.maskPhoneNumber = r100;
            return this;
        }

        public Builder setOptionalScopes0(Set<String> r100) {
            this.optionalScopes0 = r100;
            return this;
        }

        public Builder setOptionalScopes1(Set<String> r100) {
            this.optionalScopes1 = r100;
            return this;
        }

        public Builder setRedirectUri(Uri r100) {
            this.redirectUri = r100;
            return this;
        }

        public Builder setResponseType(String r100) {
            this.responseType = r100;
            return this;
        }

        public Builder setScopeToFields(Map<String, String> r100) {
            this.scopeToFields = r100;
            return this;
        }

        public Builder setScopes(Set<String> r100) {
            this.scopes = r100;
            return this;
        }

        public Builder setState(String r100) {
            this.state = r100;
            return this;
        }
    }

    public interface ResponseType {
        public static final String CODE = "code";
        public static final String ID_TOKEN = "id_token";
        public static final String TOKEN = "token";
    }

    public static /* synthetic */ class a {
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    private Request(Builder r100) {
        Set<String> r101 = r100.scopes;
        if (r101 == null) goto L5;
        this.scopes = r101;
    L6:
        Set<String> r102 = r100.optionalScopes0;
        if (r102 == null) goto L9;
        this.optionalScopes0 = r102;
    L10:
        Set<String> r103 = r100.optionalScopes1;
        if (r103 == null) goto L13;
        this.optionalScopes1 = r103;
    L14:
        this.state = r100.state;
        this.callerLocalEntry = r100.callerLocalEntry;
        Bundle r104 = r100.extra;
        if (r104 == null) goto L17;
        this.extra = r104;
    L18:
        this.responseType = r100.responseType;
        this.language = r100.language;
        this.redirectUri = r100.redirectUri;
        this.authTicket = r100.authTicket;
        this.maskPhoneNumber = r100.maskPhoneNumber;
        this.authType = r100.authType;
        this.scopeToFields = r100.scopeToFields;
        return;
    L17:
        this.extra = new Bundle();
        goto L18
    L13:
        this.optionalScopes1 = new HashSet();
        goto L14
    L9:
        this.optionalScopes0 = new HashSet();
        goto L10
    L5:
        this.scopes = new HashSet();
        goto L6
    }

    public /* synthetic */ Request(Builder r100, a r101) {
        this(r100);
    }
}

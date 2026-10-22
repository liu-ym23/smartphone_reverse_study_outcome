package com.ss.android.lark.endpoint.security.detection.factor;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u000b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "LocationPermissionDenied", "LocationPermissionDeniedBefore", "PayloadEncodeFailed", "LocationServicesDisabled", "LocationAdminDisabledGPS", "LocationNotAuthorizedAlways", "LocationPSDARestricted", "LocationTimeout", "LocationNetwork", "LocationRiskOfFakeLocation", "LocationUnknown", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationAdminDisabledGPS;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationNetwork;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationNotAuthorizedAlways;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationPSDARestricted;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationPermissionDenied;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationPermissionDeniedBefore;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationRiskOfFakeLocation;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationServicesDisabled;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationTimeout;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationUnknown;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$PayloadEncodeFailed;", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class EndpointSecurityFactorReportError extends Throwable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationAdminDisabledGPS;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationAdminDisabledGPS extends EndpointSecurityFactorReportError {
        public static final LocationAdminDisabledGPS INSTANCE = null;

        static {
            INSTANCE = new LocationAdminDisabledGPS();
        }

        private LocationAdminDisabledGPS() {
            super("location_admin_disabled_gps", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationNetwork;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationNetwork extends EndpointSecurityFactorReportError {
        public static final LocationNetwork INSTANCE = null;

        static {
            INSTANCE = new LocationNetwork();
        }

        private LocationNetwork() {
            super("location_network", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationNotAuthorizedAlways;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationNotAuthorizedAlways extends EndpointSecurityFactorReportError {
        public static final LocationNotAuthorizedAlways INSTANCE = null;

        static {
            INSTANCE = new LocationNotAuthorizedAlways();
        }

        private LocationNotAuthorizedAlways() {
            super("location_not_authorized_always", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationPSDARestricted;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationPSDARestricted extends EndpointSecurityFactorReportError {
        public static final LocationPSDARestricted INSTANCE = null;

        static {
            INSTANCE = new LocationPSDARestricted();
        }

        private LocationPSDARestricted() {
            super("location_psda_restricted", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationPermissionDenied;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationPermissionDenied extends EndpointSecurityFactorReportError {
        public static final LocationPermissionDenied INSTANCE = null;

        static {
            INSTANCE = new LocationPermissionDenied();
        }

        private LocationPermissionDenied() {
            super("location_permission_denied", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationPermissionDeniedBefore;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationPermissionDeniedBefore extends EndpointSecurityFactorReportError {
        public static final LocationPermissionDeniedBefore INSTANCE = null;

        static {
            INSTANCE = new LocationPermissionDeniedBefore();
        }

        private LocationPermissionDeniedBefore() {
            super("location_permission_denied_before", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationRiskOfFakeLocation;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationRiskOfFakeLocation extends EndpointSecurityFactorReportError {
        public static final LocationRiskOfFakeLocation INSTANCE = null;

        static {
            INSTANCE = new LocationRiskOfFakeLocation();
        }

        private LocationRiskOfFakeLocation() {
            super("location_risk_of_fake_location", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationServicesDisabled;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationServicesDisabled extends EndpointSecurityFactorReportError {
        public static final LocationServicesDisabled INSTANCE = null;

        static {
            INSTANCE = new LocationServicesDisabled();
        }

        private LocationServicesDisabled() {
            super("location_services_disabled", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationTimeout;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationTimeout extends EndpointSecurityFactorReportError {
        public static final LocationTimeout INSTANCE = null;

        static {
            INSTANCE = new LocationTimeout();
        }

        private LocationTimeout() {
            super("location_timeout", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$LocationUnknown;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationUnknown extends EndpointSecurityFactorReportError {
        public static final LocationUnknown INSTANCE = null;

        static {
            INSTANCE = new LocationUnknown();
        }

        private LocationUnknown() {
            super("location_unknown", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError$PayloadEncodeFailed;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PayloadEncodeFailed extends EndpointSecurityFactorReportError {
        public static final PayloadEncodeFailed INSTANCE = null;

        static {
            INSTANCE = new PayloadEncodeFailed();
        }

        private PayloadEncodeFailed() {
            super("payload_encode_failed", null);
        }
    }

    public EndpointSecurityFactorReportError(String r100, DefaultConstructorMarker r101) {
        super(r100);
    }
}

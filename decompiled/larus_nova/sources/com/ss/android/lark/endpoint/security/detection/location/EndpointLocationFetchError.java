package com.ss.android.lark.endpoint.security.detection.location;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0006\u0007\b\t\n\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\b\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "Timeout", "SdkRequestRejected", "SdkReturnedNull", "RiskOfFakeLocation", "Network", "PsdaRestricted", "AdminGpsDisabled", "Unknown", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$AdminGpsDisabled;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$Network;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$PsdaRestricted;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$RiskOfFakeLocation;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$SdkRequestRejected;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$SdkReturnedNull;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$Timeout;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$Unknown;", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class EndpointLocationFetchError extends Throwable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$AdminGpsDisabled;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AdminGpsDisabled extends EndpointLocationFetchError {
        public static final AdminGpsDisabled INSTANCE = null;

        static {
            INSTANCE = new AdminGpsDisabled();
        }

        private AdminGpsDisabled() {
            super("location_admin_gps_disabled", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$Network;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Network extends EndpointLocationFetchError {
        public static final Network INSTANCE = null;

        static {
            INSTANCE = new Network();
        }

        private Network() {
            super("location_network", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$PsdaRestricted;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PsdaRestricted extends EndpointLocationFetchError {
        public static final PsdaRestricted INSTANCE = null;

        static {
            INSTANCE = new PsdaRestricted();
        }

        private PsdaRestricted() {
            super("location_psda_restricted", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$RiskOfFakeLocation;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RiskOfFakeLocation extends EndpointLocationFetchError {
        public static final RiskOfFakeLocation INSTANCE = null;

        static {
            INSTANCE = new RiskOfFakeLocation();
        }

        private RiskOfFakeLocation() {
            super("location_risk_of_fake_location", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$SdkRequestRejected;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SdkRequestRejected extends EndpointLocationFetchError {
        public static final SdkRequestRejected INSTANCE = null;

        static {
            INSTANCE = new SdkRequestRejected();
        }

        private SdkRequestRejected() {
            super("location_sdk_request_rejected", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$SdkReturnedNull;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SdkReturnedNull extends EndpointLocationFetchError {
        public static final SdkReturnedNull INSTANCE = null;

        static {
            INSTANCE = new SdkReturnedNull();
        }

        private SdkReturnedNull() {
            super("location_sdk_returned_null", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$Timeout;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Timeout extends EndpointLocationFetchError {
        public static final Timeout INSTANCE = null;

        static {
            INSTANCE = new Timeout();
        }

        private Timeout() {
            super("location_timeout", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError$Unknown;", "Lcom/ss/android/lark/endpoint/security/detection/location/EndpointLocationFetchError;", "<init>", "()V", "endpoint-security-detection-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Unknown extends EndpointLocationFetchError {
        public static final Unknown INSTANCE = null;

        static {
            INSTANCE = new Unknown();
        }

        private Unknown() {
            super("location_unknown", null);
        }
    }

    public EndpointLocationFetchError(String r100, DefaultConstructorMarker r101) {
        super(r100);
    }
}

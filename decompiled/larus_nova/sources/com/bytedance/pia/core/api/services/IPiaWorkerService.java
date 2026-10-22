package com.bytedance.pia.core.api.services;

/* JADX INFO: loaded from: classes21.dex */
public interface IPiaWorkerService {

    public static class DisableBySettingException extends RuntimeException {
        public DisableBySettingException() {
        }
    }

    public static class NoJSRuntimeException extends RuntimeException {
        public NoJSRuntimeException(Throwable r100) {
            super(r100);
        }
    }

    public static class UrlUnsupportedException extends RuntimeException {
        public UrlUnsupportedException() {
        }
    }
}

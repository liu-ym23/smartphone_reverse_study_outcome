package com.bytedance.ee.lark.infra.foundation.schedulers;

/* JADX INFO: loaded from: classes19.dex */
public interface Subscriber<T> {

    public static class NoConcernSubscriber<T> implements Subscriber<T> {
        public NoConcernSubscriber() {
        }

        @Override // com.bytedance.ee.lark.infra.foundation.schedulers.Subscriber
        public void onError(Throwable r100) {
        }

        @Override // com.bytedance.ee.lark.infra.foundation.schedulers.Subscriber
        public void onSuccess() {
        }

        @Override // com.bytedance.ee.lark.infra.foundation.schedulers.Subscriber
        public void onSuccess(T r100) {
        }
    }

    public static abstract class ResultLessSubscriber<T> implements Subscriber<T> {
        public ResultLessSubscriber() {
        }

        @Override // com.bytedance.ee.lark.infra.foundation.schedulers.Subscriber
        public void onSuccess(T r100) {
        }
    }

    public static abstract class ResultableSubscriber<T> implements Subscriber<T> {
        public ResultableSubscriber() {
        }

        @Override // com.bytedance.ee.lark.infra.foundation.schedulers.Subscriber
        public void onSuccess() {
        }
    }

    void onError(Throwable r100);

    void onSuccess();

    void onSuccess(T r100);
}

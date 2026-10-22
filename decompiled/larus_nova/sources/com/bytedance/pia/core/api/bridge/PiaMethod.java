package com.bytedance.pia.core.api.bridge;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import l47.b;
import m47.h;
import m47.i;
import m47.o;

/* JADX INFO: loaded from: classes21.dex */
public final class PiaMethod<Params, Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scope f266159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<a<Params, Result>> f266160c;

    public static class Error extends RuntimeException {
        private final int code;

        public Error() {
            this("");
        }

        public int getCode() {
            return this.code;
        }

        public Error(int r100) {
            this(r100, "");
        }

        public Error(String r100) {
            this(0, r100);
        }

        public Error(int r100, String r101) {
            super(r101);
            this.code = r100;
        }
    }

    public static class InvalidParamsError extends Error {
        public InvalidParamsError() {
            this("");
        }

        public InvalidParamsError(String r100) {
            super(-3, r100);
        }
    }

    public static class InvalidResultError extends Error {
        public InvalidResultError() {
            this("");
        }

        public InvalidResultError(String r100) {
            super(-4, r100);
        }
    }

    public static final enum Scope extends Enum<Scope> {
        public static final Scope All = null;
        public static final Scope Render = null;
        public static final Scope Worker = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scope[] f266161a = null;

        static {
            Scope r100 = new Scope("Worker", 0);
            Worker = r100;
            Scope r101 = new Scope("Render", 1);
            Render = r101;
            Scope r102 = new Scope(CancelRetainContactInfoFunctions.All, 2);
            All = r102;
            f266161a = new Scope[]{r100, r101, r102};
        }

        public static Scope[] values() {
            return (Scope[]) f266161a.clone();
        }

        public static Scope valueOf(String r100) {
            return (Scope) r27.a.a(Scope.class, r100);
        }

        public Scope(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class SettingDisableError extends Error {
        public SettingDisableError() {
            super(-6, "Disable by settings.");
        }
    }

    public static class UnauthorizedError extends Error {
        public UnauthorizedError() {
            this("");
        }

        public UnauthorizedError(String r100) {
            super(-1, r100);
        }
    }

    public static class UnregisteredError extends Error {
        public UnregisteredError() {
            this("");
        }

        public UnregisteredError(String r100) {
            super(-2, r100);
        }
    }

    public interface a<Params, Result> {
        void a(o r100, Object r101, h r102, i r103);
    }

    public PiaMethod(String r100, b<a<Params, Result>> r101) {
        this(r100, Scope.Worker, r101);
    }

    public PiaMethod(String r100, Scope r101, b<a<Params, Result>> r102) {
        this.f266158a = r100;
        this.f266159b = r101;
        this.f266160c = r102;
    }
}

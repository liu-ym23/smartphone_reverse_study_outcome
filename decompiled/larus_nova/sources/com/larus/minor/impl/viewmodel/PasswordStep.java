package com.larus.minor.impl.viewmodel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes30.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/minor/impl/viewmodel/PasswordStep;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface PasswordStep {
    public static final a Companion = null;
    public static final int STEP_EXIT = 5;
    public static final int STEP_FIRST_DISABLE = 1;
    public static final int STEP_FIRST_ENABLE = 2;
    public static final int STEP_LOADING = 6;
    public static final int STEP_ROUTER_MINOR_OFF = 8;
    public static final int STEP_ROUTER_MINOR_ON = 7;
    public static final int STEP_SECOND_DISABLE = 3;
    public static final int STEP_SECOND_ENABLE = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f359286a = null;

        static {
            f359286a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f359286a;
    }
}

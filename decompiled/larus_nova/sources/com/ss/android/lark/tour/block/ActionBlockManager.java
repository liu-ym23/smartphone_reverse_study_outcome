package com.ss.android.lark.tour.block;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes38.dex */
public final class ActionBlockManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f444297a = null;

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/tour/block/ActionBlockManager$ActionType;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ActionType {
        public static final int ALERT_DIALOG = 2;
        public static final a Companion = null;
        public static final int TIPS = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f444298a = null;

            static {
                f444298a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f444298a;
        }
    }

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/tour/block/ActionBlockManager$PolicyType;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PolicyType {
        public static final int ALERT_DIALOG = 2;
        public static final a Companion = null;
        public static final int ON_BOARDING_TOUR = 3;
        public static final int TIPS = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f444299a = null;

            static {
                f444299a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f444299a;
        }
    }

    public static final class a {
    }

    static {
        f444297a = new HashMap();
        new HashMap();
    }
}

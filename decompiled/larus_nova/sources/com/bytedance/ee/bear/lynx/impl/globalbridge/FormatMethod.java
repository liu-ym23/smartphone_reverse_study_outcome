package com.bytedance.ee.bear.lynx.impl.globalbridge;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes18.dex */
@Target({ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/globalbridge/FormatMethod;", "", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FormatMethod {
    public static final a Companion = null;
    public static final String FORMAT_DATE = "formatDate";
    public static final String FORMAT_DATE_RANGE = "formatDateRange";
    public static final String FORMAT_DATE_TIME = "formatDateTime";
    public static final String FORMAT_DATE_TIME_RANGE = "formatDateTimeRange";
    public static final String FORMAT_FULL_DATE = "formatFullDate";
    public static final String FORMAT_FULL_DATE_RANGE = "formatFullDateRange";
    public static final String FORMAT_FULL_DATE_TIME = "formatFullDateTime";
    public static final String FORMAT_MERIDIEM = "formatMeridiem";
    public static final String FORMAT_MONTH = "formatMonth";
    public static final String FORMAT_TIME = "formatTime";
    public static final String FORMAT_TIME_RANGE = "formatTimeRange";
    public static final String FORMAT_WEEK_DAY = "formatWeekDay";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f229871a = null;

        static {
            f229871a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f229871a;
    }
}

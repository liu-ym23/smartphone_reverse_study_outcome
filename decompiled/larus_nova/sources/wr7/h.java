package wr7;

import com.cronutils.model.field.CronFieldName;
import java.time.ZonedDateTime;
import java.util.Optional;

/* JADX INFO: loaded from: classes22.dex */
public interface h {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f560832a = null;

        static {
            int[] r100 = new int[CronFieldName.values().length];
            f560832a = r100;
            r100[CronFieldName.SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f560832a[CronFieldName.MINUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f560832a[CronFieldName.HOUR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f560832a[CronFieldName.DAY_OF_WEEK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f560832a[CronFieldName.DAY_OF_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f560832a[CronFieldName.MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f560832a[CronFieldName.YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f560832a[CronFieldName.DAY_OF_YEAR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    Optional<ZonedDateTime> a(ZonedDateTime r100);
}

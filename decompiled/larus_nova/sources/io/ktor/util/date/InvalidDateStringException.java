package io.ktor.util.date;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/date/InvalidDateStringException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "data", "", INotificationHitPoint.NoticeType.AT, "", "pattern", "(Ljava/lang/String;ILjava/lang/String;)V", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InvalidDateStringException extends IllegalStateException {
    public InvalidDateStringException(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r102, "pattern");
        super("Failed to parse date string: \"" + r100 + "\" at index " + r101 + ". Pattern: \"" + r102 + Typography.quote);
    }
}

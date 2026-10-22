package com.ss.android.lark.flow.chat.message.downgrade.data;

import com.alipay.sdk.m.x.d;
import com.bytedance.lark.pb.calendar.v1.CalendarEvent;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/downgrade/data/LarkDowngradeCalendarContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "statusEnum", "Lcom/bytedance/lark/pb/calendar/v1/CalendarEvent$Status;", "getStatusEnum", "()Lcom/bytedance/lark/pb/calendar/v1/CalendarEvent$Status;", "setStatusEnum", "(Lcom/bytedance/lark/pb/calendar/v1/CalendarEvent$Status;)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "isContentSame", "", "diffable", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkDowngradeCalendarContent extends Content {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private long endTime;
    private CalendarEvent.Status statusEnum;
    private String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public LarkDowngradeCalendarContent() {
        this.title = "";
        this.endTime = -1;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final CalendarEvent.Status getStatusEnum() {
        return this.statusEnum;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkDowngradeCalendarContent) == false) goto L8;
        LarkDowngradeCalendarContent r101 = (LarkDowngradeCalendarContent) r100;
    L10:
        if (r101 != null) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
    L19:
        return false;
    L15:
        if (this.statusEnum != r101.statusEnum) goto L19;
        if (this.endTime != r101.endTime) goto L19;
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setStatusEnum(CalendarEvent.Status r100) {
        this.statusEnum = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }
}

package com.bytedance.creativex.mediaimport.view.internal;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectDragCloseView$Event;", "", "<init>", "(Ljava/lang/String;I)V", "DRAGGING", "PRE_CLOSE", ErrorCode.CLOSED, "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMediaSelectDragCloseView$Event extends Enum<IMediaSelectDragCloseView$Event> {
    public static final IMediaSelectDragCloseView$Event CLOSED = null;
    public static final IMediaSelectDragCloseView$Event DRAGGING = null;
    public static final IMediaSelectDragCloseView$Event PRE_CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMediaSelectDragCloseView$Event[] f203679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f203680b = null;

    public static EnumEntries<IMediaSelectDragCloseView$Event> getEntries() {
        return f203680b;
    }

    static {
        IMediaSelectDragCloseView$Event r100 = new IMediaSelectDragCloseView$Event("DRAGGING", 0);
        DRAGGING = r100;
        IMediaSelectDragCloseView$Event r101 = new IMediaSelectDragCloseView$Event("PRE_CLOSE", 1);
        PRE_CLOSE = r101;
        IMediaSelectDragCloseView$Event r102 = new IMediaSelectDragCloseView$Event(ErrorCode.CLOSED, 2);
        CLOSED = r102;
        IMediaSelectDragCloseView$Event[] r103 = {r100, r101, r102};
        f203679a = r103;
        f203680b = EnumEntriesKt.enumEntries(r103);
    }

    public static IMediaSelectDragCloseView$Event[] values() {
        return (IMediaSelectDragCloseView$Event[]) f203679a.clone();
    }

    public static IMediaSelectDragCloseView$Event valueOf(String r100) {
        return (IMediaSelectDragCloseView$Event) a.a(IMediaSelectDragCloseView$Event.class, r100);
    }

    public IMediaSelectDragCloseView$Event(String r100, int r101) {
        super(r100, r101);
    }
}

package com.ss.android.lark.feed.shared.page.status;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setStatus", "", "status", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView$FeedPageStatus;", "description", "", "onRetry", "Lkotlin/Function0;", "FeedPageStatus", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FeedBackgroundStatusView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f421446a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView$FeedPageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "HIDE", "LOADING", "EMPTY", "ERROR", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedPageStatus extends Enum<FeedPageStatus> {
        public static final FeedPageStatus EMPTY = null;
        public static final FeedPageStatus ERROR = null;
        public static final FeedPageStatus HIDE = null;
        public static final FeedPageStatus LOADING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedPageStatus[] f421447a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421448b = null;

        public static EnumEntries<FeedPageStatus> getEntries() {
            return f421448b;
        }

        static {
            FeedPageStatus r100 = new FeedPageStatus("HIDE", 0);
            HIDE = r100;
            FeedPageStatus r101 = new FeedPageStatus("LOADING", 1);
            LOADING = r101;
            FeedPageStatus r102 = new FeedPageStatus("EMPTY", 2);
            EMPTY = r102;
            FeedPageStatus r103 = new FeedPageStatus("ERROR", 3);
            ERROR = r103;
            FeedPageStatus[] r104 = {r100, r101, r102, r103};
            f421447a = r104;
            f421448b = EnumEntriesKt.enumEntries(r104);
        }

        public static FeedPageStatus[] values() {
            return (FeedPageStatus[]) f421447a.clone();
        }

        public static FeedPageStatus valueOf(String r100) {
            return (FeedPageStatus) a.a(FeedPageStatus.class, r100);
        }

        public FeedPageStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public FeedBackgroundStatusView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FeedBackgroundStatusView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract void a(FeedPageStatus r100, String r101, Function0<Unit> r102);

    public FeedBackgroundStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ FeedBackgroundStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

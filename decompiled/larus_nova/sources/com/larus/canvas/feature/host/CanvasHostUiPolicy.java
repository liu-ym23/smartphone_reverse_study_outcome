package com.larus.canvas.feature.host;

import android.os.Bundle;
import com.larus.canvas.feature.component.resultdisplay.image.CanvasSaveActionPlacement;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import my8.q;

/* JADX INFO: loaded from: classes26.dex */
public final class CanvasHostUiPolicy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f323739c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f323740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f323741b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/host/CanvasHostUiPolicy$ExitBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE", "HOST_BACK", "HOST_CLOSE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExitBehavior extends Enum<ExitBehavior> {
        public static final ExitBehavior HOST_BACK = null;
        public static final ExitBehavior HOST_CLOSE = null;
        public static final ExitBehavior NATIVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExitBehavior[] f323742a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f323743b = null;

        public static EnumEntries<ExitBehavior> getEntries() {
            return f323743b;
        }

        static {
            ExitBehavior r100 = new ExitBehavior("NATIVE", 0);
            NATIVE = r100;
            ExitBehavior r101 = new ExitBehavior("HOST_BACK", 1);
            HOST_BACK = r101;
            ExitBehavior r102 = new ExitBehavior("HOST_CLOSE", 2);
            HOST_CLOSE = r102;
            ExitBehavior[] r103 = {r100, r101, r102};
            f323742a = r103;
            f323743b = EnumEntriesKt.enumEntries(r103);
        }

        public static ExitBehavior[] values() {
            return (ExitBehavior[]) f323742a.clone();
        }

        public static ExitBehavior valueOf(String r100) {
            return (ExitBehavior) r27.a.a(ExitBehavior.class, r100);
        }

        public ExitBehavior(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/canvas/feature/host/CanvasHostUiPolicy$TitleLeftAction;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE", "BACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TitleLeftAction extends Enum<TitleLeftAction> {
        public static final TitleLeftAction BACK = null;
        public static final TitleLeftAction CLOSE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitleLeftAction[] f323744a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f323745b = null;

        public static EnumEntries<TitleLeftAction> getEntries() {
            return f323745b;
        }

        static {
            TitleLeftAction r100 = new TitleLeftAction("CLOSE", 0);
            CLOSE = r100;
            TitleLeftAction r101 = new TitleLeftAction("BACK", 1);
            BACK = r101;
            TitleLeftAction[] r102 = {r100, r101};
            f323744a = r102;
            f323745b = EnumEntriesKt.enumEntries(r102);
        }

        public static TitleLeftAction[] values() {
            return (TitleLeftAction[]) f323744a.clone();
        }

        public static TitleLeftAction valueOf(String r100) {
            return (TitleLeftAction) r27.a.a(TitleLeftAction.class, r100);
        }

        public TitleLeftAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static CanvasHostUiPolicy a(q r100) {
            if (r100 == null) goto L4;
            Bundle r101 = r100.f516409a;
        L5:
            cy9.a.f465949a.getClass();
            return new CanvasHostUiPolicy(cy9.a.e(r101), !cy9.a.h(r101));
        L4:
            r101 = null;
            goto L5
        }
    }

    static {
    }

    public final boolean a() {
        if (this.f323740a == false) goto L5;
        CanvasSaveActionPlacement r100 = CanvasSaveActionPlacement.IMAGE_OVERLAY_BOTTOM_START;
    L7:
        if (r100 != CanvasSaveActionPlacement.IMAGE_OVERLAY_BOTTOM_START) goto L9;
        return true;
    L9:
        return false;
    L5:
        r100 = CanvasSaveActionPlacement.TITLE_RIGHT;
        goto L7
    }

    public CanvasHostUiPolicy(boolean r100, boolean r101) {
        this.f323740a = r100;
        this.f323741b = r101;
    }
}

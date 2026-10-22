package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedVCHardwareStatusComponent extends FeedCardComponent<Object, FeedVCStatusIconView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f420892c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedVCHardwareStatusComponent$HardwareStatusMode;", "", "<init>", "(Ljava/lang/String;I)V", "Connected", "Upload", "Recording", "Paused", "Summarizing", "Gone", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HardwareStatusMode extends Enum<HardwareStatusMode> {
        public static final HardwareStatusMode Connected = null;
        public static final HardwareStatusMode Gone = null;
        public static final HardwareStatusMode Paused = null;
        public static final HardwareStatusMode Recording = null;
        public static final HardwareStatusMode Summarizing = null;
        public static final HardwareStatusMode Upload = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HardwareStatusMode[] f420893a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420894b = null;

        public static EnumEntries<HardwareStatusMode> getEntries() {
            return f420894b;
        }

        static {
            HardwareStatusMode r100 = new HardwareStatusMode("Connected", 0);
            Connected = r100;
            HardwareStatusMode r101 = new HardwareStatusMode("Upload", 1);
            Upload = r101;
            HardwareStatusMode r102 = new HardwareStatusMode("Recording", 2);
            Recording = r102;
            HardwareStatusMode r103 = new HardwareStatusMode("Paused", 3);
            Paused = r103;
            HardwareStatusMode r104 = new HardwareStatusMode("Summarizing", 4);
            Summarizing = r104;
            HardwareStatusMode r105 = new HardwareStatusMode("Gone", 5);
            Gone = r105;
            HardwareStatusMode[] r110 = {r100, r101, r102, r103, r104, r105};
            f420893a = r110;
            f420894b = EnumEntriesKt.enumEntries(r110);
        }

        public static HardwareStatusMode[] values() {
            return (HardwareStatusMode[]) f420893a.clone();
        }

        public static HardwareStatusMode valueOf(String r100) {
            return (HardwareStatusMode) r27.a.a(HardwareStatusMode.class, r100);
        }

        public HardwareStatusMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new FeedVCStatusIconView(getContext(), null);
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
        r100.gravity = 16;
        return r100;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public Context getContext() {
        return this.f420892c;
    }

    public FeedVCHardwareStatusComponent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f420892c = r100;
    }
}

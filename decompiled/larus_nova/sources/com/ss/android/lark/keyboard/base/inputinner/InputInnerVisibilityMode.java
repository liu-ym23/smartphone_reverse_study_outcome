package com.ss.android.lark.keyboard.base.inputinner;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/base/inputinner/InputInnerVisibilityMode;", "", "<init>", "(Ljava/lang/String;I)V", BannerBizName.DYNAMIC, "ALWAYS_VISIBLE", "ALWAYS_GONE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputInnerVisibilityMode extends Enum<InputInnerVisibilityMode> {
    public static final InputInnerVisibilityMode ALWAYS_GONE = null;
    public static final InputInnerVisibilityMode ALWAYS_VISIBLE = null;
    public static final InputInnerVisibilityMode DYNAMIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputInnerVisibilityMode[] f428236a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428237b = null;

    public static EnumEntries<InputInnerVisibilityMode> getEntries() {
        return f428237b;
    }

    static {
        InputInnerVisibilityMode r100 = new InputInnerVisibilityMode(BannerBizName.DYNAMIC, 0);
        DYNAMIC = r100;
        InputInnerVisibilityMode r101 = new InputInnerVisibilityMode("ALWAYS_VISIBLE", 1);
        ALWAYS_VISIBLE = r101;
        InputInnerVisibilityMode r102 = new InputInnerVisibilityMode("ALWAYS_GONE", 2);
        ALWAYS_GONE = r102;
        InputInnerVisibilityMode[] r103 = {r100, r101, r102};
        f428236a = r103;
        f428237b = EnumEntriesKt.enumEntries(r103);
    }

    public static InputInnerVisibilityMode[] values() {
        return (InputInnerVisibilityMode[]) f428236a.clone();
    }

    public static InputInnerVisibilityMode valueOf(String r100) {
        return (InputInnerVisibilityMode) a.a(InputInnerVisibilityMode.class, r100);
    }

    public InputInnerVisibilityMode(String r100, int r101) {
        super(r100, r101);
    }
}

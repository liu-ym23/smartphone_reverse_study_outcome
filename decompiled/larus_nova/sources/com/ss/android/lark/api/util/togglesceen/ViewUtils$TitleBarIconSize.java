package com.ss.android.lark.api.util.togglesceen;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import j08.d;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/api/util/togglesceen/ViewUtils$TitleBarIconSize;", "", "value", "", "<init>", "(Ljava/lang/String;IF)V", "getValue", "()F", EffectConstants.NORMAL, "SMALL", "leftIconSize", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ViewUtils$TitleBarIconSize extends Enum<ViewUtils$TitleBarIconSize> {
    public static final ViewUtils$TitleBarIconSize NORMAL = null;
    public static final ViewUtils$TitleBarIconSize SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewUtils$TitleBarIconSize[] f408704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408705b = null;
    private final float value;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f408706a = null;

        static {
            int[] r100 = new int[ViewUtils$TitleBarIconSize.values().length];
            r100[ViewUtils$TitleBarIconSize.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f408706a = r100;
        }
    }

    public static EnumEntries<ViewUtils$TitleBarIconSize> getEntries() {
        return f408705b;
    }

    static {
        ViewUtils$TitleBarIconSize r100 = new ViewUtils$TitleBarIconSize(EffectConstants.NORMAL, 0, 0.0f);
        NORMAL = r100;
        ViewUtils$TitleBarIconSize r101 = new ViewUtils$TitleBarIconSize("SMALL", 1, 1.0f);
        SMALL = r101;
        ViewUtils$TitleBarIconSize[] r102 = {r100, r101};
        f408704a = r102;
        f408705b = EnumEntriesKt.enumEntries(r102);
    }

    public static ViewUtils$TitleBarIconSize[] values() {
        return (ViewUtils$TitleBarIconSize[]) f408704a.clone();
    }

    public final float getValue() {
        return this.value;
    }

    public static ViewUtils$TitleBarIconSize valueOf(String r100) {
        return (ViewUtils$TitleBarIconSize) r27.a.a(ViewUtils$TitleBarIconSize.class, r100);
    }

    public final float leftIconSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a.f408706a[ordinal()] != 1) goto L6;
        return d.a(r100, 20.0f);
    L6:
        return d.a(r100, 24.0f);
    }

    public ViewUtils$TitleBarIconSize(String r100, int r101, float r102) {
        super(r100, r101);
        this.value = r102;
    }
}

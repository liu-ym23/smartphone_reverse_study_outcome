package com.obric.common.oea.style.scene.transition;

import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/style/scene/transition/TransitionAnimStyle;", "", "SubpageInOut", "SettingsInOut", "Standard", "Modal", "Search", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum TransitionAnimStyle extends Enum<TransitionAnimStyle> {
    public static final TransitionAnimStyle Modal = null;
    public static final TransitionAnimStyle Search = null;

    @Deprecated(message = "请使用 Modal")
    public static final TransitionAnimStyle SettingsInOut = null;
    public static final TransitionAnimStyle Standard = null;

    @Deprecated(message = "请使用 Standard")
    public static final TransitionAnimStyle SubpageInOut = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TransitionAnimStyle[] f396668a = null;

    static {
        TransitionAnimStyle r100 = new TransitionAnimStyle("SubpageInOut", 0);
        SubpageInOut = r100;
        TransitionAnimStyle r101 = new TransitionAnimStyle("SettingsInOut", 1);
        SettingsInOut = r101;
        TransitionAnimStyle r102 = new TransitionAnimStyle("Standard", 2);
        Standard = r102;
        TransitionAnimStyle r103 = new TransitionAnimStyle("Modal", 3);
        Modal = r103;
        TransitionAnimStyle r104 = new TransitionAnimStyle("Search", 4);
        Search = r104;
        f396668a = new TransitionAnimStyle[]{r100, r101, r102, r103, r104};
    }

    public static TransitionAnimStyle valueOf(String r100) {
        return (TransitionAnimStyle) a.a(TransitionAnimStyle.class, r100);
    }

    public static TransitionAnimStyle[] values() {
        return (TransitionAnimStyle[]) f396668a.clone();
    }

    public TransitionAnimStyle(String r100, int r101) {
        super(r100, r101);
    }
}

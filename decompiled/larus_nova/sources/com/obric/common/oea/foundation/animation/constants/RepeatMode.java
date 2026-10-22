package com.obric.common.oea.foundation.animation.constants;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "", EffectConstants.NORMAL, "LOOP", "REVERSE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum RepeatMode extends Enum<RepeatMode> {
    public static final RepeatMode LOOP = null;
    public static final RepeatMode NORMAL = null;
    public static final RepeatMode REVERSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RepeatMode[] f396384a = null;

    static {
        RepeatMode r100 = new RepeatMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        RepeatMode r101 = new RepeatMode("LOOP", 1);
        LOOP = r101;
        RepeatMode r102 = new RepeatMode("REVERSE", 2);
        REVERSE = r102;
        f396384a = new RepeatMode[]{r100, r101, r102};
    }

    public static RepeatMode valueOf(String r100) {
        return (RepeatMode) a.a(RepeatMode.class, r100);
    }

    public static RepeatMode[] values() {
        return (RepeatMode[]) f396384a.clone();
    }

    public RepeatMode(String r100, int r101) {
        super(r100, r101);
    }
}

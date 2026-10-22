package com.bytedance.ies.bullet.core.common;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/core/common/Arch;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, "SL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum Arch extends Enum<Arch> {
    public static final Arch NORMAL = null;
    public static final Arch SL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Arch[] f246470a = null;
    private final String value;

    public static Arch valueOf(String r100) {
        return (Arch) a.a(Arch.class, r100);
    }

    public static Arch[] values() {
        return (Arch[]) f246470a.clone();
    }

    static {
        Arch r100 = new Arch(EffectConstants.NORMAL, 0, "nl");
        NORMAL = r100;
        Arch r101 = new Arch("SL", 1, "sl");
        SL = r101;
        f246470a = new Arch[]{r100, r101};
    }

    public final String getValue() {
        return this.value;
    }

    public Arch(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
